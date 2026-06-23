/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ import java.lang.classfile.ClassBuilder;
/*     */ import java.lang.classfile.ClassFile;
/*     */ import java.lang.classfile.CodeBuilder;
/*     */ import java.lang.classfile.CompoundElement;
/*     */ import java.lang.classfile.MethodBuilder;
/*     */ import java.lang.classfile.Opcode;
/*     */ import java.lang.constant.ClassDesc;
/*     */ import java.lang.constant.ConstantDescs;
/*     */ import java.lang.constant.MethodTypeDesc;
/*     */ import java.lang.foreign.FunctionDescriptor;
/*     */ import java.lang.foreign.GroupLayout;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import java.lang.invoke.MethodType;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Parameter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import org.lwjgl.system.ffm.BCCall;
/*     */ import org.lwjgl.system.ffm.BCDescriptors;
/*     */ import org.lwjgl.system.ffm.BCUtil;
/*     */ import org.lwjgl.system.ffm.Binder;
/*     */ import org.lwjgl.system.ffm.FFMBooleanInt;
/*     */ import org.lwjgl.system.ffm.FFMConfig;
/*     */ import org.lwjgl.system.ffm.FFMPointer;
/*     */ import org.lwjgl.system.libffi.FFICIF;
/*     */ import org.lwjgl.system.libffi.FFIType;
/*     */ 
/*     */ final class BCCallUp extends BCCall {
/*     */   private static final int FF_RETURNS_STRUCT_BY_VALUE = -2147483648;
/*     */   private final Class<?> upcallInterface;
/*     */   private final Method method;
/*     */   private final Parameter[] parameters;
/*     */   private final int featureFlags;
/*     */   private final int[] featureFlagOffsets;
/*     */   private final LinkedHashMap<Class<?>, Integer> binders;
/*     */   final FunctionDescriptor descriptor;
/*     */   
/*     */   BCCallUp(FFMConfig config, Class<?> upcallInterface, FFICIF cif) {
/*  43 */     super(config);
/*     */     
/*  45 */     this.upcallInterface = upcallInterface;
/*     */     
/*  47 */     if (!upcallInterface.isInterface()) {
/*  48 */       throw new UnsupportedOperationException("The binder must be parameterized with an interface");
/*     */     }
/*     */     
/*  51 */     if (upcallInterface.getDeclaredAnnotation(FunctionalInterface.class) == null) {
/*  52 */       throw new UnsupportedOperationException("The upcall interface must be annotated with @FunctionalInterface");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     this
/*     */ 
/*     */       
/*  64 */       .method = Arrays.<Method>stream(upcallInterface.getDeclaredMethods()).filter(m -> !m.isDefault()).findFirst().orElseThrow();
/*     */     
/*  66 */     this.parameters = this.method.getParameters();
/*     */     
/*  68 */     this.featureFlagOffsets = new int[BCCall.FeatureFlag.FF_LAST.ordinal()];
/*  69 */     this.binders = new LinkedHashMap<>();
/*     */     
/*  71 */     boolean hasTracing = (config.traceConsumer != null && (config.tracingFilter == null || config.tracingFilter.test(this.method)));
/*  72 */     int featureFlags = hasTracing ? BCCall.FeatureFlag.FF_TRACING.mask : 0;
/*     */     
/*  74 */     ArrayList<MemoryLayout> argLayouts = new ArrayList<>(this.parameters.length);
/*  75 */     for (int i = 0; i < this.parameters.length; i++) {
/*  76 */       Parameter parameter = this.parameters[i];
/*  77 */       Class<?> clazz = parameter.getType();
/*  78 */       if (BCUtil.isPointerType(parameter, clazz)) {
/*  79 */         if (BITS32 && clazz == long.class) {
/*  80 */           featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*     */         }
/*  82 */       } else if (clazz == String.class) {
/*  83 */         featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*  84 */       } else if (clazz == boolean.class) {
/*  85 */         FFMBooleanInt booleanInt = parameter.<FFMBooleanInt>getAnnotation(FFMBooleanInt.class);
/*  86 */         if (booleanInt != null) {
/*  87 */           featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*  88 */           argLayouts.add((booleanInt.value()).layout); continue;
/*     */         } 
/*  90 */         if (cif != null) {
/*     */           
/*  92 */           MemoryLayout layout = memoryLayoutFrom(FFIType.create(cif.arg_types().get(i)));
/*  93 */           if (layout != ValueLayout.JAVA_BYTE) {
/*  94 */             featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*  95 */             argLayouts.add(layout); continue;
/*     */           } 
/*     */         } 
/*     */       } else {
/*  99 */         if (needsBinder(clazz)) {
/* 100 */           featureFlags |= BCCall.FeatureFlag.FF_BINDER.mask;
/* 101 */           argLayouts.add(ValueLayout.ADDRESS); continue;
/*     */         } 
/* 103 */         if (Struct.class.isAssignableFrom(clazz)) {
/*     */           
/* 105 */           if (parameter != this.parameters[this.parameters.length - 1])
/*     */           {
/* 107 */             throw new IllegalStateException("Group result parameter must be the last parameter");
/*     */           }
/* 109 */           if (this.method.getReturnType() != void.class) {
/* 110 */             throw new IllegalStateException("Group result parameter requires a void return type");
/*     */           }
/* 112 */           featureFlags |= Integer.MIN_VALUE;
/*     */           continue;
/*     */         } 
/*     */       } 
/* 116 */       argLayouts.add(valueLayout(parameter));
/*     */       continue;
/*     */     } 
/* 119 */     MemoryLayout resLayout = null;
/*     */     
/* 121 */     Class<?> type = this.method.getReturnType();
/* 122 */     if (type != void.class) {
/* 123 */       if (type == String.class)
/* 124 */         throw new IllegalStateException("String return types are not supported in upcalls: " + String.valueOf(this.method)); 
/* 125 */       if (type == boolean.class) {
/* 126 */         if (this.method.isAnnotationPresent((Class)FFMBooleanInt.class)) {
/* 127 */           featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/* 128 */         } else if (cif != null) {
/*     */           
/* 130 */           resLayout = memoryLayoutFrom(cif.rtype());
/* 131 */           featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*     */         } 
/* 133 */       } else if (BITS32 && type == long.class && this.method.isAnnotationPresent((Class)FFMPointer.class)) {
/* 134 */         featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/* 135 */         resLayout = ValueLayout.JAVA_INT;
/* 136 */       } else if (needsBinder(type)) {
/* 137 */         Binder<?> binder = ((FFMConfig.BinderField)config.binders.get(type)).binder();
/* 138 */         if (binder instanceof UpcallBinder) {
/* 139 */           throw new IllegalStateException("Upcalls can only be returned as raw pointer values");
/*     */         }
/*     */         
/* 142 */         this.binders.putIfAbsent(type, Integer.valueOf(this.binders.size()));
/* 143 */         featureFlags |= BCCall.FeatureFlag.FF_BINDER.mask;
/*     */         
/* 145 */         GroupLayout groupLayout = ((GroupBinder)binder).layout();
/* 146 */         if (this.method.isAnnotationPresent((Class)FFMByValue.class)) {
/* 147 */           featureFlags |= BCCall.FeatureFlag.FF_BY_VALUE.mask;
/* 148 */           resLayout = groupLayout;
/*     */         } else {
/* 150 */           resLayout = ValueLayout.ADDRESS.withTargetLayout(groupLayout);
/*     */         } 
/*     */       } else {
/* 153 */         resLayout = valueLayout(this.method, this.method.getReturnType());
/*     */       } 
/* 155 */     } else if ((featureFlags & Integer.MIN_VALUE) != 0) {
/*     */ 
/*     */       
/* 158 */       resLayout = groupLayoutFrom(((FFICIF)Objects.<FFICIF>requireNonNull(cif)).rtype());
/*     */     } 
/*     */     
/* 161 */     this.featureFlags = featureFlags;
/*     */     
/* 163 */     MemoryLayout[] argLayoutsArray = (MemoryLayout[])argLayouts.toArray(x$0 -> new MemoryLayout[x$0]);
/* 164 */     this
/*     */       
/* 166 */       .descriptor = (resLayout == null) ? FunctionDescriptor.ofVoid(argLayoutsArray) : FunctionDescriptor.of(resLayout, argLayoutsArray);
/*     */   }
/*     */   
/*     */   <T> UpcallBinder<T> bootstrap() {
/*     */     MethodType type, methodType1;
/* 171 */     if (this.config.debugGenerator) {
/* 172 */       printDebug(this.method, this.parameters, this.descriptor);
/*     */     }
/*     */     
/* 175 */     switch (this.featureFlags) {
/*     */       case 0:
/*     */       
/*     */       
/*     */       default:
/* 180 */         type = this.descriptor.toMethodType().insertParameterTypes(0, new Class[] { this.upcallInterface });
/*     */         
/* 182 */         if ((this.featureFlags & Integer.MIN_VALUE) != 0)
/*     */         {
/* 184 */           type = type.insertParameterTypes(1, new Class[] { MemorySegment.class });
/*     */         }
/*     */     } 
/*     */ 
/*     */     
/* 189 */     MethodType bridgeDescriptor = type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     org.lwjgl.system.ffm.BCCallUp bCCallUp = this; switch (this.featureFlags)
/*     */     { case 0:
/*     */         try {
/* 216 */           MethodHandle methodHandle = this.config.lookup.unreflect(this.method);
/* 217 */         } catch (IllegalAccessException e) {
/* 218 */           throw new RuntimeException(e);
/*     */         }  break;
/*     */       default:
/* 221 */         methodType1 = bridgeDescriptor; break; }  List<Object> classData = bCCallUp.getClassData(methodType1);
/*     */ 
/*     */     
/* 224 */     ClassDesc thisClass = getClassDescWrapper(this.method);
/* 225 */     byte[] bytecode = ClassFile.of().build(thisClass, classBuilder -> {
/*     */           BCUtil.startHiddenClass(classBuilder).withInterfaceSymbols(new ClassDesc[] { BCDescriptors.CD_UpcallBinder });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           classBuilder.withField("DESCRIPTOR", BCDescriptors.CD_FunctionDescriptor, 26).withField("HANDLE", ConstantDescs.CD_MethodHandle, 26).withMethod("<clinit>", ConstantDescs.MTD_void, 8, ()).withMethod("descriptor", BCDescriptors.MTD_FunctionDescriptor, 17, ()).withMethod("handle", BCDescriptors.MTD_MethodHandle, 17, ());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           classBuilder.withMethod("stack", BCDescriptors.MTD_MemoryLayout, 17, ());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           if (this.featureFlags != 0) {
/*     */             MethodTypeDesc methodTypeDesc = BCUtil.getMethodTypeDesc(this.method);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             classBuilder.withMethod("bridge", bridgeDescriptor.describeConstable().orElseThrow(), 9, ());
/*     */           } 
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     if (this.config.debugGenerator) {
/* 364 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 369 */       MethodHandles.Lookup wrapperLookup = this.config.lookup.defineHiddenClassWithClassData(bytecode, classData, true, new MethodHandles.Lookup.ClassOption[0]);
/* 370 */       return wrapperLookup.lookupClass()
/* 371 */         .getDeclaredConstructor(new Class[0])
/* 372 */         .newInstance(new Object[0]);
/* 373 */     } catch (Error|RuntimeException e) {
/* 374 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/* 375 */       throw e;
/* 376 */     } catch (Exception e) {
/* 377 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/* 378 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private List<Object> getClassData(Object method) {
/* 383 */     ArrayList<Object> list = new ArrayList(4);
/*     */     
/* 385 */     list.add(this.descriptor);
/* 386 */     list.add(method);
/*     */     
/* 388 */     if ((this.featureFlags & Integer.MIN_VALUE) != 0) {
/* 389 */       list.add(this.descriptor.returnLayout().orElseThrow());
/*     */     }
/*     */     
/* 392 */     if (BCCall.FeatureFlag.FF_BINDER.isSet(this.featureFlags)) {
/* 393 */       this.featureFlagOffsets[BCCall.FeatureFlag.FF_BINDER.ordinal()] = list.size();
/* 394 */       for (Class<?> type : this.binders.sequencedKeySet()) {
/* 395 */         list.add(((FFMConfig.BinderField)this.config.binders.get(type)).binder());
/*     */       }
/*     */     } 
/*     */     
/* 399 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static GroupLayout groupLayoutFrom(FFIType groupType) {
/* 409 */     MemorySegment elements = MemorySegment.ofAddress(groupType.address() + FFIType.ELEMENTS).reinterpret(ValueLayout.ADDRESS.byteSize()).get(ValueLayout.ADDRESS, 0L).reinterpret(Long.MAX_VALUE);
/*     */     
/* 411 */     ArrayList<MemoryLayout> members = new ArrayList<>();
/*     */     
/* 413 */     int index = 0;
/*     */     while (true) {
/* 415 */       MemorySegment element = elements.getAtIndex(ValueLayout.ADDRESS, index++);
/* 416 */       if (MemorySegment.NULL.equals(element)) {
/*     */         break;
/*     */       }
/*     */       
/* 420 */       FFIType elementType = FFIType.create(element.address());
/* 421 */       members.add(memoryLayoutFrom(elementType));
/*     */     } 
/*     */     
/* 424 */     return MemoryLayout.structLayout((MemoryLayout[])members.toArray(x$0 -> new MemoryLayout[x$0]));
/*     */   }
/*     */ 
/*     */   
/*     */   private static MemoryLayout memoryLayoutFrom(FFIType type) {
/* 429 */     switch (type.type()) { case 5: case 6: 
/*     */       case 7: case 8: 
/*     */       case 1: case 9: case 10: 
/*     */       case 11: case 12: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 13:
/*     */       
/*     */       case 14:
/* 438 */        }  throw new IllegalStateException("Unsupported libffi type: " + type.type());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\BCCallUp.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */