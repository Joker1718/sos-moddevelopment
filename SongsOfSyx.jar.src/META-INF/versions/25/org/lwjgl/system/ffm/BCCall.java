/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ import java.lang.classfile.CodeBuilder;
/*     */ import java.lang.classfile.TypeKind;
/*     */ import java.lang.constant.ClassDesc;
/*     */ import java.lang.constant.ConstantDescs;
/*     */ import java.lang.foreign.FunctionDescriptor;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Parameter;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.ffm.BCDescriptors;
/*     */ import org.lwjgl.system.ffm.FFM;
/*     */ import org.lwjgl.system.ffm.FFMBooleanInt;
/*     */ import org.lwjgl.system.ffm.FFMConfig;
/*     */ import org.lwjgl.system.ffm.FFMDefinition;
/*     */ import org.lwjgl.system.ffm.FFMPointer;
/*     */ 
/*     */ abstract class BCCall {
/*  22 */   protected static final boolean BITS32 = (ValueLayout.ADDRESS.byteSize() == 4L);
/*     */   
/*     */   protected final FFMConfig config;
/*     */   
/*     */   BCCall(FFMConfig config) {
/*  27 */     this.config = config;
/*     */   }
/*     */   
/*     */   protected static ClassDesc getClassDescWrapper(Method method) {
/*  31 */     Class<?> declaringClass = method.getDeclaringClass();
/*  32 */     return ClassDesc.of(declaringClass
/*  33 */         .getPackageName(), declaringClass
/*  34 */         .getSimpleName() + "$" + declaringClass.getSimpleName());
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean needsBinder(Class<?> type) {
/*  39 */     if (!type.isInterface()) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (MemorySegment.class.isAssignableFrom(type)) {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     FFM.lookupBinder(this.config, type);
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   protected static void boxPrimitiveValue(CodeBuilder cb, TypeKind tk) {
/*  52 */     switch (null.$SwitchMap$java$lang$classfile$TypeKind[tk.ordinal()]) { case 1:
/*  53 */         cb.invokestatic(ConstantDescs.CD_Boolean, "valueOf", BCDescriptors.MTD_Boolean_valueOf); return;
/*  54 */       case 2: cb.invokestatic(ConstantDescs.CD_Byte, "valueOf", BCDescriptors.MTD_Byte_valueOf); return;
/*  55 */       case 3: cb.invokestatic(ConstantDescs.CD_Short, "valueOf", BCDescriptors.MTD_Short_valueOf); return;
/*  56 */       case 4: cb.invokestatic(ConstantDescs.CD_Integer, "valueOf", BCDescriptors.MTD_Integer_valueOf); return;
/*  57 */       case 5: cb.invokestatic(ConstantDescs.CD_Long, "valueOf", BCDescriptors.MTD_Long_valueOf); return;
/*  58 */       case 6: cb.invokestatic(ConstantDescs.CD_Float, "valueOf", BCDescriptors.MTD_Float_valueOf); return;
/*  59 */       case 7: cb.invokestatic(ConstantDescs.CD_Double, "valueOf", BCDescriptors.MTD_Double_valueOf); return; }
/*  60 */      throw new UnsupportedOperationException("Unsupported primitive type: " + String.valueOf(tk));
/*     */   }
/*     */   
/*     */   protected static MemoryLayout valueLayout(Parameter parameter) {
/*  64 */     return valueLayout(parameter, parameter.getType());
/*     */   } protected static MemoryLayout valueLayout(AnnotatedElement element, Class<?> type) {
/*  66 */     if (type == String.class)
/*  67 */       return FFM.C_POINTER; 
/*  68 */     if (type == MemorySegment.class)
/*  69 */       return ValueLayout.ADDRESS; 
/*  70 */     if (type == boolean.class) {
/*  71 */       FFMBooleanInt booleanInt = element.<FFMBooleanInt>getAnnotation(FFMBooleanInt.class);
/*  72 */       if (booleanInt != null) {
/*  73 */         return (booleanInt.value()).layout;
/*     */       }
/*  75 */       return ValueLayout.JAVA_BOOLEAN;
/*  76 */     }  if (type == byte.class)
/*  77 */       return ValueLayout.JAVA_BYTE; 
/*  78 */     if (type == short.class)
/*  79 */       return ValueLayout.JAVA_SHORT; 
/*  80 */     if (type == int.class)
/*  81 */       return ValueLayout.JAVA_INT; 
/*  82 */     if (type == long.class)
/*  83 */       return (BITS32 && element.isAnnotationPresent((Class)FFMPointer.class)) ? 
/*  84 */         ValueLayout.JAVA_INT : 
/*  85 */         ValueLayout.JAVA_LONG; 
/*  86 */     if (type == float.class)
/*  87 */       return ValueLayout.JAVA_FLOAT; 
/*  88 */     if (type == double.class) {
/*  89 */       return ValueLayout.JAVA_DOUBLE;
/*     */     }
/*  91 */     throw new IllegalArgumentException("Unsupported type: " + String.valueOf(type));
/*     */   }
/*     */   
/*     */   protected static void printDebug(Method method, Parameter[] parameters, FunctionDescriptor descriptor) {
/*  95 */     APIUtil.apiLog("\t-> J: " + String.valueOf(method.getReturnType()) + " " + method.getName() + "(" + (String)Stream.<Parameter>of(parameters).map(it -> it.getType().getSimpleName()).collect(Collectors.joining(", ")) + ")");
/*  96 */     FFMDefinition signature = method.<FFMDefinition>getAnnotation(FFMDefinition.class);
/*  97 */     if (signature != null) {
/*  98 */       APIUtil.apiLog("\t-> S: " + signature.value());
/*     */     }
/* 100 */     APIUtil.apiLog("\t-> N: " + String.valueOf(descriptor));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\BCCall.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */