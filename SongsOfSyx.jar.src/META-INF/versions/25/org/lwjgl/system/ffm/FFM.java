/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.classfile.ClassBuilder;
/*     */ import java.lang.classfile.ClassFile;
/*     */ import java.lang.classfile.CodeBuilder;
/*     */ import java.lang.classfile.MethodBuilder;
/*     */ import java.lang.classfile.TypeKind;
/*     */ import java.lang.classfile.attribute.ModuleAttribute;
/*     */ import java.lang.classfile.attribute.ModuleExportInfo;
/*     */ import java.lang.classfile.attribute.ModuleRequireInfo;
/*     */ import java.lang.constant.ClassDesc;
/*     */ import java.lang.constant.ConstantDesc;
/*     */ import java.lang.constant.ConstantDescs;
/*     */ import java.lang.constant.DynamicConstantDesc;
/*     */ import java.lang.constant.MethodTypeDesc;
/*     */ import java.lang.constant.ModuleDesc;
/*     */ import java.lang.constant.PackageDesc;
/*     */ import java.lang.foreign.AddressLayout;
/*     */ import java.lang.foreign.Arena;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import java.lang.invoke.MethodHandle;
/*     */ import java.lang.invoke.MethodHandles;
/*     */ import java.lang.reflect.AccessFlag;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.stream.Collectors;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.ffm.BCCallDown;
/*     */ import org.lwjgl.system.ffm.BCCallUp;
/*     */ import org.lwjgl.system.ffm.BCDescriptors;
/*     */ import org.lwjgl.system.ffm.BCUtil;
/*     */ import org.lwjgl.system.ffm.Binder;
/*     */ import org.lwjgl.system.ffm.FFMConfig;
/*     */ import org.lwjgl.system.ffm.GroupBinder;
/*     */ import org.lwjgl.system.ffm.UpcallBinder;
/*     */ import org.lwjgl.system.ffm.mapping.Mapping;
/*     */ import org.lwjgl.system.libffi.FFICIF;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FFM
/*     */ {
/*  63 */   static final AddressLayout C_POINTER = ValueLayout.ADDRESS
/*  64 */     .withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, ValueLayout.JAVA_BYTE));
/*     */   
/*  66 */   static final Set<String> STANDARD_CHARSETS = (Set<String>)Arrays.<Field>stream(StandardCharsets.class.getDeclaredFields())
/*  67 */     .map(Field::getName)
/*  68 */     .collect(Collectors.toUnmodifiableSet());
/*     */ 
/*     */ 
/*     */   
/*  72 */   static final ConcurrentHashMap<AnnotatedElement, FFMConfig> BINDING_CONFIGS = new ConcurrentHashMap<>();
/*     */ 
/*     */   
/*  75 */   static final ScopedValue<Arena> ARENA = ScopedValue.newInstance();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void main() {
/*  82 */     Path path = Path.of("bin", new String[] { "classes", "lwjgl", "core", "META-INF", "versions", "25", "module-info.class" });
/*     */ 
/*     */     
/*  85 */     ModuleAttribute moduleAttr = ModuleAttribute.of(ModuleDesc.of("org.lwjgl"), mab -> {
/*     */           mab.moduleVersion(System.getProperty("module.version")).requires(ModuleRequireInfo.of(ModuleDesc.of("java.base"), AccessFlag.MODULE.mask(), "25")).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.ffm"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.freebsd"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.jni"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.libc"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.libffi"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.linux"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.macosx"), 0, new ModuleDesc[0])).exports(ModuleExportInfo.of(PackageDesc.of("org.lwjgl.system.windows"), 0, new ModuleDesc[0]));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           if (Boolean.getBoolean("unsafe")) {
/*     */             mab.requires(ModuleRequireInfo.of(ModuleDesc.of("jdk.unsupported"), AccessFlag.TRANSITIVE.mask(), "25"));
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 106 */       ClassFile.of()
/* 107 */         .buildModuleTo(path, moduleAttr);
/* 108 */     } catch (IOException e) {
/* 109 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   static FFMConfig getConfig(Class<?> bindingInterface) {
/* 114 */     Class<?> c = bindingInterface;
/* 115 */     while (c != null) {
/* 116 */       FFMConfig fFMConfig = BINDING_CONFIGS.get(c);
/* 117 */       if (fFMConfig != null) {
/* 118 */         return fFMConfig;
/*     */       }
/* 120 */       c = c.getEnclosingClass();
/*     */     } 
/*     */     
/* 123 */     Package p = Objects.<Package>requireNonNull(bindingInterface.getPackage());
/* 124 */     FFMConfig config = BINDING_CONFIGS.get(p);
/*     */     
/* 126 */     if (config == null) {
/* 127 */       throw new IllegalStateException("No FFMConfig registered for " + String.valueOf(bindingInterface));
/*     */     }
/*     */     
/* 130 */     return config;
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T> T generate(Class<T> bindingInterface, FFMConfig config) throws Exception {
/* 135 */     Method[] methods = bindingInterface.getMethods();
/*     */     
/* 137 */     ClassDesc thisClass = ClassDesc.of(bindingInterface.getPackageName(), bindingInterface.getSimpleName() + "Impl");
/* 138 */     byte[] bytecode = ClassFile.of().build(thisClass, classBuilder -> {
/*     */           BCUtil.startHiddenClass(classBuilder).withInterfaceSymbols(new ClassDesc[] { bindingInterface.describeConstable().orElseThrow() });
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           for (int m = 0; m < methods.length; m++) {
/*     */             Method method = methods[m];
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             MethodTypeDesc methodTypeDesc = BCUtil.getMethodTypeDesc(method);
/*     */ 
/*     */ 
/*     */             
/*     */             DynamicConstantDesc<MethodHandle> condy = DynamicConstantDesc.ofNamed(BCDescriptors.DMHD_FFM_bootstrapDowncall, method.getName(), ConstantDescs.CD_MethodHandle, new ConstantDesc[] { Integer.valueOf(m) });
/*     */ 
/*     */ 
/*     */             
/*     */             classBuilder.withMethod(method.getName(), methodTypeDesc, 1, ());
/*     */           } 
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 164 */     return config.lookup
/*     */       
/* 166 */       .defineHiddenClassWithClassData(bytecode, List.of(config, methods), false, new MethodHandles.Lookup.ClassOption[0])
/* 167 */       .lookupClass()
/*     */       
/* 169 */       .getDeclaredConstructor(new Class[0])
/* 170 */       .newInstance(new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static MethodHandle bootstrapDowncall(MethodHandles.Lookup lookup, String name, Class<?> bootstrapClass, int methodIndex) throws IllegalAccessException {
/* 176 */     FFMConfig config = MethodHandles.<FFMConfig>classDataAt(lookup, "_", FFMConfig.class, 0);
/* 177 */     Method method = ((Method[])MethodHandles.classDataAt(lookup, "_", (Class)Method[].class, 1))[methodIndex];
/*     */     
/* 179 */     if (config.debugGenerator) {
/* 180 */       APIUtil.apiLog("BOOTSTRAPPING DOWNCALL#" + methodIndex + ": " + name);
/*     */     }
/* 182 */     return (new BCCallDown(config, method))
/* 183 */       .bootstrap();
/*     */   }
/*     */   
/*     */   static Field findBinderField(Class<?> targetType) {
/* 187 */     Field field = null;
/*     */     
/* 189 */     for (Field targetField : targetType.getDeclaredFields()) {
/* 190 */       int modifiers = targetField.getModifiers();
/*     */       
/* 192 */       if (!Modifier.isPublic(modifiers) || !Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
/* 193 */         throw new IllegalStateException(String.valueOf(targetType) + " is not an interface");
/*     */       }
/*     */       
/* 196 */       Type binderType = targetField.getGenericType();
/* 197 */       if (binderType instanceof ParameterizedType) { ParameterizedType binderTypeGeneric = (ParameterizedType)binderType;
/* 198 */         Type[] binderTypeArguments = binderTypeGeneric.getActualTypeArguments();
/* 199 */         if (binderTypeArguments.length == 1 && binderTypeArguments[0].equals(targetType)) {
/* 200 */           Class<?> binderClass = (Class)binderTypeGeneric.getRawType();
/* 201 */           if (GroupBinder.class.isAssignableFrom(binderClass) || UpcallBinder.class.isAssignableFrom(binderClass)) {
/* 202 */             if (field != null) {
/* 203 */               throw new IllegalStateException("Multiple binder fields found for " + String.valueOf(targetType));
/*     */             }
/* 205 */             field = targetField;
/*     */           } 
/*     */         }  }
/*     */     
/*     */     } 
/*     */     
/* 211 */     if (field == null) {
/* 212 */       throw new IllegalStateException("No binder field found for " + String.valueOf(targetType));
/*     */     }
/*     */     
/* 215 */     return field;
/*     */   }
/*     */   
/*     */   static FFMConfig.BinderField lookupBinder(FFMConfig config, Class<?> targetType) {
/* 219 */     FFMConfig.BinderField binderField = (FFMConfig.BinderField)config.binders.get(targetType);
/* 220 */     if (binderField == null) {
/* 221 */       binderField = lookupBinderCacheMiss(config, targetType);
/*     */     }
/* 223 */     return binderField;
/*     */   }
/*     */   private static FFMConfig.BinderField lookupBinderCacheMiss(FFMConfig config, Class<?> targetType) {
/*     */     Binder<?> binder;
/* 227 */     Field field = findBinderField(targetType);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 232 */       binder = (Binder)field.get(null);
/* 233 */     } catch (IllegalAccessException e) {
/* 234 */       throw new RuntimeException(e);
/*     */     } 
/*     */     
/* 237 */     if (binder == null) {
/* 238 */       throw new IllegalStateException("Missing binder field value for " + String.valueOf(targetType));
/*     */     }
/*     */     
/* 241 */     FFMConfig.BinderField binderField = new FFMConfig.BinderField(field.getName(), binder);
/* 242 */     config.binders.put(targetType, binderField);
/* 243 */     return binderField;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 249 */   public static final Mapping.Opaque opaque = Mapping.createOpaque("void");
/*     */ 
/*     */   
/* 252 */   public static final Mapping.Boolean jboolean = Mapping.createBoolean("boolean");
/*     */   
/* 254 */   public static final Mapping.Byte jbyte = Mapping.createByte("byte", true);
/*     */   
/* 256 */   public static final Mapping.Char jchar = Mapping.createChar("char");
/*     */   
/* 258 */   public static final Mapping.Short jshort = Mapping.createShort("short", true);
/*     */   
/* 260 */   public static final Mapping.Int jint = Mapping.createInt("int", true);
/*     */   
/* 262 */   public static final Mapping.Long jlong = Mapping.createLong("long", true);
/*     */   
/* 264 */   public static final Mapping.Float jfloat = Mapping.createFloat("float");
/*     */   
/* 266 */   public static final Mapping.Double jdouble = Mapping.createDouble("double");
/*     */ 
/*     */   
/* 269 */   public static final Mapping.Byte int8_t = jbyte.typedef("int8_t");
/*     */ 
/*     */   
/* 272 */   public static final Mapping.Short int16_t = jshort.typedef("int16_t");
/*     */ 
/*     */   
/* 275 */   public static final Mapping.Int int32_t = jint.typedef("int32_t");
/*     */ 
/*     */   
/* 278 */   public static final Mapping.Long int64_t = jlong.typedef("int64_t");
/*     */ 
/*     */   
/* 281 */   public static final Mapping.Byte uint8_t = Mapping.createByte("uint8_t", false);
/*     */ 
/*     */   
/* 284 */   public static final Mapping.Short uint16_t = Mapping.createShort("uint16_t", false);
/*     */ 
/*     */   
/* 287 */   public static final Mapping.Int uint32_t = Mapping.createInt("uint32_t", false);
/*     */ 
/*     */   
/* 290 */   public static final Mapping.Long uint64_t = Mapping.createLong("uint64_t", false);
/*     */ 
/*     */   
/* 293 */   public static final Mapping.Size size_t = Mapping.createSize("size_t", false);
/*     */ 
/*     */   
/* 296 */   public static final Mapping.Size ptrdiff_t = Mapping.createSize("ptrdiff_t", true);
/*     */ 
/*     */   
/* 299 */   public static final Mapping.Size intptr_t = Mapping.createSize("intptr_t", true);
/*     */ 
/*     */   
/* 302 */   public static final Mapping.Size uintptr_t = Mapping.createSize("uintptr_t", false);
/*     */ 
/*     */   
/* 305 */   public static final Mapping.Boolean bool = jboolean.typedef("bool");
/*     */ 
/*     */   
/* 308 */   public static final Mapping.Byte cchar = int8_t.typedef("char");
/*     */ 
/*     */   
/* 311 */   public static final Mapping.Short cshort = int16_t.typedef("short");
/*     */ 
/*     */   
/* 314 */   public static final Mapping.Int cint = int32_t.typedef("int");
/*     */ 
/*     */   
/* 317 */   public static final Mapping.CLong clong = Mapping.createCLong("long", true);
/*     */ 
/*     */   
/* 320 */   public static final Mapping.Long long_long = jlong.typedef("long long");
/*     */ 
/*     */   
/* 323 */   public static final Mapping.Byte unsigned_char = uint8_t.typedef("unsigned char");
/*     */ 
/*     */   
/* 326 */   public static final Mapping.Short unsigned_short = uint16_t.typedef("unsigned short");
/*     */ 
/*     */   
/* 329 */   public static final Mapping.Int unsigned_int = uint32_t.typedef("unsigned int");
/*     */ 
/*     */   
/* 332 */   public static final Mapping.CLong unsigned_long = Mapping.createCLong("unsigned long", false);
/*     */ 
/*     */   
/* 335 */   public static final Mapping.Long unsigned_long_long = uint64_t.typedef("unsigned long long");
/*     */ 
/*     */   
/* 338 */   public static final Mapping.Float float32 = jfloat.typedef("float");
/*     */ 
/*     */   
/* 341 */   public static final Mapping.Double float64 = jdouble.typedef("double");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> StructBinderBuilder<T> ffmStruct(Class<T> structInterface) {
/* 351 */     return new StructBinderBuilder(structInterface);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> UnionBinderBuilder<T> ffmUnion(Class<T> unionInterface) {
/* 362 */     return new UnionBinderBuilder(unionInterface);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> UpcallBinder<T> ffmUpcall(Class<T> upcallInterface) {
/* 676 */     return ffmUpcall(upcallInterface, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> UpcallBinder<T> ffmUpcall(Class<T> upcallInterface, FFICIF cif) {
/* 691 */     FFMConfig config = getConfig(upcallInterface);
/* 692 */     if (config.debugGenerator) {
/* 693 */       APIUtil.apiLog("BOOTSTRAPPING UPCALL " + String.valueOf(upcallInterface));
/*     */     }
/*     */ 
/*     */     
/* 697 */     return (new BCCallUp(config, upcallInterface, cif))
/* 698 */       .bootstrap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ScopedValue<Arena> ffmScopedArena() {
/* 708 */     return ARENA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ffmScopedRun(Arena arena, Runnable runnable) {
/* 723 */     ScopedValue.<Arena>where(ARENA, arena)
/* 724 */       .run(runnable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <R, X extends Throwable> R ffmScopedCall(Arena arena, ScopedValue.CallableOp<? extends R, X> op) throws X {
/* 740 */     return 
/* 741 */       (R)ScopedValue.<Arena>where(ARENA, arena)
/* 742 */       .call(op);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T ffmGenerate(Class<T> bindingInterface) {
/*     */     try {
/* 756 */       return generate(bindingInterface, getConfig(bindingInterface));
/* 757 */     } catch (RuntimeException|Error e) {
/* 758 */       throw e;
/* 759 */     } catch (Throwable t) {
/* 760 */       throw new RuntimeException(t);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T ffmGenerate(Class<T> bindingInterface, FFMConfig config) {
/* 774 */     FFMConfig previous = BINDING_CONFIGS.put(bindingInterface, config);
/*     */     try {
/* 776 */       return (T)generate((Class)bindingInterface, config);
/* 777 */     } catch (RuntimeException|Error e) {
/* 778 */       throw e;
/* 779 */     } catch (Throwable t) {
/* 780 */       throw new RuntimeException(t);
/*     */     } finally {
/*     */       
/* 783 */       ffmConfig(bindingInterface, previous);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FFMConfigBuilder ffmConfigBuilder(MethodHandles.Lookup lookup) {
/* 954 */     return new FFMConfigBuilder(lookup);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ffmConfig(Package _package, FFMConfig config) {
/* 969 */     if (config == null) {
/* 970 */       BINDING_CONFIGS.remove(_package);
/*     */     } else {
/* 972 */       BINDING_CONFIGS.put(_package, config);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ffmConfig(Class<?> _class, FFMConfig config) {
/* 988 */     if (config == null) {
/* 989 */       BINDING_CONFIGS.remove(_class);
/*     */     } else {
/* 991 */       BINDING_CONFIGS.put(_class, config);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\FFM.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */