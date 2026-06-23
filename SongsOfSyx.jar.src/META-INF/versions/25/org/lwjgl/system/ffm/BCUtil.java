/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.classfile.ClassFileElement;
/*     */ import java.lang.classfile.CompoundElement;
/*     */ import java.lang.constant.ClassDesc;
/*     */ import java.lang.constant.ConstantDescs;
/*     */ import java.lang.constant.DynamicConstantDesc;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.AnnotatedType;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Parameter;
/*     */ import java.util.function.Function;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.ffm.BCDescriptors;
/*     */ import org.lwjgl.system.ffm.FFMCharset;
/*     */ import org.lwjgl.system.ffm.FFMConfig;
/*     */ import org.lwjgl.system.ffm.FFMName;
/*     */ import org.lwjgl.system.ffm.FFMPrefix;
/*     */ 
/*     */ final class BCUtil {
/*     */   static {
/*  24 */     String javaVersion = System.getProperty("java.version");
/*     */ 
/*     */ 
/*     */     
/*  28 */     Matcher matcher = Pattern.compile("^([1-9][0-9]*)(?:(?:\\.0)*\\.[1-9][0-9]*)*(?:-[a-zA-Z0-9]+)?").matcher(javaVersion);
/*     */     
/*  30 */     if (!matcher.find()) {
/*  31 */       throw new IllegalStateException("Failed to parse java.version: " + javaVersion);
/*     */     }
/*     */     
/*  34 */     JAVA_VERSION = Integer.parseInt(matcher.group(1));
/*     */   }
/*     */   static final int JAVA_VERSION;
/*  37 */   static final long NATIVE_THRESHOLD_FILL = powerOfPropertyOr("fill", 5);
/*  38 */   static final long NATIVE_THRESHOLD_COPY = powerOfPropertyOr("copy", 6);
/*     */   
/*  40 */   static final Linker.Option[] EMPTY_OPTIONS = new Linker.Option[0];
/*     */ 
/*     */ 
/*     */   
/*  44 */   static final Object EMPTY_SLOT = new Object();
/*     */   
/*     */   static ClassBuilder startHiddenClass(ClassBuilder classBuilder) {
/*  47 */     return classBuilder
/*  48 */       .withVersion(ClassFile.latestMajorVersion(), ClassFile.latestMinorVersion())
/*  49 */       .withFlags(new AccessFlag[] { AccessFlag.PUBLIC, AccessFlag.FINAL
/*  50 */         }).withSuperclass(ConstantDescs.CD_Object)
/*     */       
/*  52 */       .withMethod("<init>", ConstantDescs.MTD_void, 1, mb -> mb.withCode(()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static MethodTypeDesc getMethodTypeDesc(Method method) {
/*  60 */     return MethodTypeDesc.of(method
/*  61 */         .getReturnType().describeConstable().orElseThrow(), 
/*  62 */         getParameterDescs(method));
/*     */   }
/*     */ 
/*     */   
/*     */   private static ClassDesc[] getParameterDescs(Method method) {
/*  67 */     Class<?>[] parameterTypes = method.getParameterTypes();
/*  68 */     ClassDesc[] parameterDescs = new ClassDesc[parameterTypes.length];
/*  69 */     for (int p = 0; p < parameterTypes.length; p++) {
/*  70 */       parameterDescs[p] = parameterTypes[p].describeConstable().orElseThrow();
/*     */     }
/*  72 */     return parameterDescs;
/*     */   }
/*     */   
/*     */   private static ClassDesc[] getParameterDescsNative(Method method, BCReturnTransform returnTransform) {
/*  76 */     Class<?>[] parameterTypes = method.getParameterTypes();
/*  77 */     ClassDesc[] parameterDescs = new ClassDesc[parameterTypes.length];
/*  78 */     for (int p = 0; p < parameterTypes.length; p++) {
/*  79 */       parameterDescs[p] = getClassDescNative(parameterTypes[p]);
/*     */     }
/*  81 */     return parameterDescs;
/*     */   }
/*     */   
/*     */   private static ClassDesc getClassDescNative(Class<?> type) {
/*     */     Class<?> nativeType;
/*  86 */     if (type == String.class) {
/*  87 */       nativeType = MemorySegment.class;
/*     */     } else {
/*  89 */       nativeType = type;
/*     */     } 
/*  91 */     return nativeType.describeConstable().orElseThrow();
/*     */   }
/*     */   
/*     */   static String getNativeName(Class<?> type) {
/*  95 */     FFMName nativeName = type.<FFMName>getAnnotation(FFMName.class);
/*  96 */     return (nativeName != null) ? 
/*  97 */       nativeName.value() : 
/*  98 */       type.getSimpleName();
/*     */   }
/*     */   static String getNativeName(Method method) {
/*     */     String name;
/* 102 */     FFMName nativeName = method.<FFMName>getAnnotation(FFMName.class);
/*     */ 
/*     */     
/* 105 */     if (nativeName != null) {
/* 106 */       name = nativeName.value();
/*     */     } else {
/* 108 */       name = method.getName();
/*     */       
/* 110 */       FFMPrefix nativePrefix = method.getDeclaringClass().<FFMPrefix>getAnnotation(FFMPrefix.class);
/* 111 */       if (nativePrefix != null && !method.isAnnotationPresent((Class)FFMNoPrefix.class)) {
/* 112 */         name = nativePrefix.value() + nativePrefix.value();
/*     */       }
/*     */     } 
/* 115 */     return name;
/*     */   }
/*     */   
/*     */   private static void checkFFMNullableOnPrimitive(AnnotatedElement element, Class<?> type) {
/* 119 */     if (Checks.DEBUG && (!element.isAnnotationPresent((Class)FFMPointer.class) || type != long.class)) {
/* 120 */       throw new IllegalStateException("The FFMNullable annotation can be applied to @FFMPointer long types only");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void checkFFMNullableOnReference(AnnotatedElement element) {
/* 125 */     if (Checks.DEBUG && element.isAnnotationPresent((Class)FFMNullable.class)) {
/* 126 */       throw new IllegalStateException("The FFMNullable annotation can be applied to @FFMPointer long parameters only");
/*     */     }
/*     */   }
/*     */   
/* 130 */   private static final Pattern NULLABLE_PATTERN = Pattern.compile("null", 2); private static final String PROPERTY_PATH = "java.lang.foreign.native.threshold.power.";
/*     */   private static void checkAnnotations(AnnotatedElement element, Class<? extends AnnotatedElement> type) {
/* 132 */     for (Annotation annotation : element.getDeclaredAnnotations()) {
/* 133 */       Class<? extends Annotation> annotationType = annotation.annotationType();
/* 134 */       if (annotationType.getPackage() != FFM.class.getPackage()) {
/* 135 */         APIUtil.apiLog("Unsupported annotation found on " + type.getSimpleName().toLowerCase() + ": " + String.valueOf(element));
/* 136 */         if (NULLABLE_PATTERN.matcher(annotationType.getSimpleName()).find())
/* 137 */           APIUtil.apiLog("\tUse FFMConfigBuilder::withNullableAnnotation if applicable."); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static <T extends AnnotatedElement> void checkAnnotations(T element, Function<T, AnnotatedType> annotatedTypeProvider) {
/* 143 */     if (Checks.DEBUG) {
/* 144 */       Class<? extends AnnotatedElement> type = (Class)element.getClass();
/* 145 */       checkAnnotations((AnnotatedElement)element, type);
/* 146 */       checkAnnotations(annotatedTypeProvider.apply(element), type);
/*     */     } 
/*     */   }
/*     */   
/*     */   static <T extends AnnotatedElement> boolean isNullable(FFMConfig config, T element, Class<?> type, Function<T, AnnotatedType> annotatedTypeProvider) {
/* 151 */     if (type.isPrimitive()) {
/* 152 */       checkFFMNullableOnPrimitive((AnnotatedElement)element, type);
/* 153 */       return element.isAnnotationPresent((Class)FFMNullable.class);
/*     */     } 
/*     */     
/* 156 */     Class<? extends Annotation> nullableAnnotation = config.nullableAnnotation;
/* 157 */     checkFFMNullableOnReference((AnnotatedElement)element);
/*     */     
/* 159 */     if (nullableAnnotation != null) {
/* 160 */       return config.nullableAnnotationOnType ? (
/* 161 */         (AnnotatedType)annotatedTypeProvider.apply(element)).isAnnotationPresent(nullableAnnotation) : 
/* 162 */         element.isAnnotationPresent(nullableAnnotation);
/*     */     }
/*     */     
/* 165 */     checkAnnotations(element, annotatedTypeProvider);
/* 166 */     return false;
/*     */   }
/*     */   
/*     */   static boolean isNullable(FFMConfig config, Method method) {
/* 170 */     return isNullable(config, method, method
/*     */ 
/*     */         
/* 173 */         .getReturnType(), Method::getAnnotatedReturnType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isNullable(FFMConfig config, Parameter parameter) {
/* 179 */     return isNullable(config, parameter, parameter
/*     */ 
/*     */         
/* 182 */         .getType(), Parameter::getAnnotatedType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static <T extends CodeBuilder> T buildPointer64to32(T cb) {
/* 188 */     cb.l2i();
/* 189 */     return cb;
/*     */   }
/*     */   
/*     */   static <T extends CodeBuilder> T buildPointer32to64(T cb) {
/* 193 */     cb
/* 194 */       .i2l()
/* 195 */       .loadConstant(4294967295L)
/* 196 */       .land();
/* 197 */     return cb;
/*     */   }
/*     */   
/*     */   static <T extends CodeBuilder> T buildGetString(T cb, Method method) {
/* 201 */     cb.lconst_0();
/* 202 */     buildCharsetInstance(cb, getCharset(method))
/* 203 */       .invokeinterface(BCDescriptors.CD_MemorySegment, "getString", BCDescriptors.MTD_String_long_Charset);
/* 204 */     return cb;
/*     */   }
/*     */   
/*     */   static <T extends CodeBuilder> T buildCharsetInstance(T cb, FFMCharset.Type type) {
/* 208 */     cb.getstatic(BCDescriptors.CD_StandardCharsets, type.charset, BCDescriptors.CD_Charset);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     return cb;
/*     */   }
/*     */   
/*     */   static <T extends CodeBuilder> T buildCharsetShift(T cb, FFMCharset.Type type, TypeKind kind) {
/* 220 */     int byteSize = (int)type.layout.byteSize();
/* 221 */     if (byteSize == 1) {
/* 222 */       return cb;
/*     */     }
/*     */     
/* 225 */     switch (byteSize) { case 2:
/* 226 */         cb.iconst_1(); break;
/* 227 */       case 4: cb.iconst_2(); break;
/* 228 */       default: throw new AssertionError(); }
/*     */ 
/*     */     
/* 231 */     if (kind != TypeKind.LONG) {
/* 232 */       cb.ishl();
/*     */     } else {
/* 234 */       cb.lshl();
/*     */     } 
/* 236 */     return cb;
/*     */   }
/*     */   
/*     */   static <T> DynamicConstantDesc<T> condyCData(ClassDesc constantType) {
/* 240 */     return DynamicConstantDesc.ofNamed(ConstantDescs.BSM_CLASS_DATA, "_", constantType, new ConstantDesc[0]);
/*     */   }
/*     */   
/*     */   static <T> DynamicConstantDesc<T> condyCDataAt(ClassDesc constantType, int index) {
/* 244 */     return DynamicConstantDesc.ofNamed(ConstantDescs.BSM_CLASS_DATA_AT, "_", constantType, new ConstantDesc[] { Integer.valueOf(index) });
/*     */   }
/*     */   
/*     */   static FFMCharset.Type getCharset(Method method) {
/* 248 */     FFMCharset annotation = method.<FFMCharset>getAnnotation(FFMCharset.class);
/* 249 */     if (annotation == null) {
/* 250 */       annotation = method.getDeclaringClass().<FFMCharset>getAnnotation(FFMCharset.class);
/*     */     }
/* 252 */     return (annotation != null) ? annotation.value() : FFMCharset.DEFAULT;
/*     */   }
/*     */   
/*     */   static FFMCharset.Type getCharset(Parameter parameter) {
/* 256 */     FFMCharset annotation = parameter.<FFMCharset>getAnnotation(FFMCharset.class);
/* 257 */     if (annotation == null) {
/* 258 */       annotation = parameter.getDeclaringExecutable().getDeclaringClass().<FFMCharset>getAnnotation(FFMCharset.class);
/*     */     }
/* 260 */     return (annotation != null) ? annotation.value() : FFMCharset.DEFAULT;
/*     */   }
/*     */   
/*     */   static boolean isPointerType(Parameter parameter, Class<?> type) {
/* 264 */     return (type == MemorySegment.class || (type == long.class && parameter.isAnnotationPresent((Class)FFMPointer.class)));
/*     */   }
/*     */   
/*     */   private static String getParameterName(Parameter parameter, int index) {
/* 268 */     return parameter.isNamePresent() ? ("<" + 
/* 269 */       parameter.getName() + ">") : ("#" + 
/* 270 */       index);
/*     */   }
/*     */   static String getExceptionTextNULL(Parameter parameter, int index) {
/* 273 */     return parameter.getType().getSimpleName() + " argument " + parameter.getType().getSimpleName() + " cannot be NULL";
/*     */   }
/*     */   
/*     */   static void printModel(CompoundElement<?> model) {
/* 277 */     APIUtil.DEBUG_STREAM.println(model);
/* 278 */     printModel(model, 0);
/*     */   }
/*     */   private static void printModel(CompoundElement<?> model, int depth) {
/* 281 */     String indent = "\t".repeat(depth);
/* 282 */     int bci = 0;
/* 283 */     for (ClassFileElement el : model) {
/* 284 */       if (el instanceof Instruction) { Instruction i = (Instruction)el;
/* 285 */         APIUtil.DEBUG_STREAM.println(indent + indent + ": " + bci);
/* 286 */         bci += i.sizeInBytes(); }
/*     */       else
/* 288 */       { APIUtil.DEBUG_STREAM.println(indent + indent + "* " + " ".repeat(Integer.toString(bci).length())); }
/*     */       
/* 290 */       if (el instanceof CompoundElement) { CompoundElement<?> ce = (CompoundElement)el;
/* 291 */         printModel(ce, depth + 1); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static long powerOfPropertyOr(String name, int defaultPower) {
/* 299 */     int power = Integer.getInteger("java.lang.foreign.native.threshold.power." + name, defaultPower).intValue();
/* 300 */     return 1L << Math.clamp(power, 0, 30);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\BCUtil.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */