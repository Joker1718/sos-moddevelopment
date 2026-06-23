/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.classfile.ClassBuilder;
/*     */ import java.lang.classfile.ClassFile;
/*     */ import java.lang.classfile.CodeBuilder;
/*     */ import java.lang.classfile.CompoundElement;
/*     */ import java.lang.classfile.MethodBuilder;
/*     */ import java.lang.classfile.Opcode;
/*     */ import java.lang.classfile.TypeKind;
/*     */ import java.lang.constant.ClassDesc;
/*     */ import java.lang.constant.ConstantDescs;
/*     */ import java.lang.constant.MethodTypeDesc;
/*     */ import java.lang.foreign.FunctionDescriptor;
/*     */ import java.lang.foreign.GroupLayout;
/*     */ import java.lang.foreign.Linker;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.SymbolLookup;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import java.lang.invoke.MethodHandle;
/*     */ import java.lang.invoke.MethodHandles;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Parameter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.function.Consumer;
/*     */ import org.lwjgl.system.ffm.BCCall;
/*     */ import org.lwjgl.system.ffm.BCDescriptors;
/*     */ import org.lwjgl.system.ffm.BCUtil;
/*     */ import org.lwjgl.system.ffm.Binder;
/*     */ import org.lwjgl.system.ffm.FFMByValue;
/*     */ import org.lwjgl.system.ffm.FFMCaptureCallState;
/*     */ import org.lwjgl.system.ffm.FFMConfig;
/*     */ import org.lwjgl.system.ffm.FFMCritical;
/*     */ import org.lwjgl.system.ffm.FFMFirstVariadicArg;
/*     */ import org.lwjgl.system.ffm.FFMFunctionAddress;
/*     */ import org.lwjgl.system.ffm.FFMJNI;
/*     */ import org.lwjgl.system.ffm.FFMReturn;
/*     */ import org.lwjgl.system.ffm.GroupBinder;
/*     */ import org.lwjgl.system.ffm.StackAllocator;
/*     */ 
/*     */ final class BCCallDown extends BCCall {
/*     */   private final Method method;
/*     */   private final Parameter[] parameters;
/*     */   private final boolean hasFunctionAddress;
/*     */   private final String nativeName;
/*     */   private final int featureFlags;
/*     */   private final int[] featureFlagOffsets;
/*     */   
/*     */   BCCallDown(FFMConfig config, Method method) {
/*  52 */     super(config);
/*     */     
/*  54 */     this.method = method;
/*     */     
/*  56 */     this.parameters = method.getParameters();
/*     */     
/*  58 */     this.hasFunctionAddress = hasFunctionAddress();
/*  59 */     this.nativeName = this.hasFunctionAddress ? null : BCUtil.getNativeName(method);
/*     */     
/*  61 */     this.featureFlagOffsets = new int[BCCall.FeatureFlag.FF_LAST.ordinal()];
/*  62 */     this.binders = new LinkedHashMap<>();
/*     */     
/*  64 */     Class<?> allocatorClass = null;
/*     */     
/*  66 */     Linker.Option captureCallState = null;
/*     */ 
/*     */     
/*  69 */     Linker.Option firstVariadicArg = method.isAnnotationPresent((Class)FFMFirstVariadicArg.class) ? Linker.Option.firstVariadicArg(((FFMFirstVariadicArg)method.<FFMFirstVariadicArg>getAnnotation(FFMFirstVariadicArg.class)).value()) : null;
/*     */     
/*  71 */     boolean hasTracing = (config.traceConsumer != null && (config.tracingFilter == null || config.tracingFilter.test(method)));
/*  72 */     int featureFlags = hasTracing ? BCCall.FeatureFlag.FF_TRACING.mask : 0;
/*     */     
/*  74 */     ArrayList<MemoryLayout> argLayouts = new ArrayList<>(this.parameters.length);
/*     */     
/*  76 */     if (hasJNI()) {
/*  77 */       argLayouts.add(ValueLayout.ADDRESS);
/*  78 */       argLayouts.add(ValueLayout.ADDRESS);
/*  79 */       featureFlags |= BCCall.FeatureFlag.FF_JNI.mask;
/*     */     } 
/*     */     
/*  82 */     for (int i = 0; i < this.parameters.length; i++) {
/*  83 */       Parameter parameter = this.parameters[i];
/*     */       
/*  85 */       if (parameter.getType() == MemorySegment.class) {
/*  86 */         if (i == 0 && this.hasFunctionAddress) {
/*  87 */           if (Checks.DEBUG && Arrays.<Annotation>stream(parameter.getAnnotations()).anyMatch(it -> "org.lwjgl.system.ffm".equals(it.annotationType().getPackage().getName()))) {
/*  88 */             throw new IllegalStateException("FFMFunctionAddress parameters cannot have FFM annotations.");
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/*  93 */         FFMCaptureCallState ccs = parameter.<FFMCaptureCallState>getAnnotation(FFMCaptureCallState.class);
/*  94 */         if (ccs != null) {
/*  95 */           if (i != (this.hasFunctionAddress ? 1 : 0) + ((allocatorClass != null) ? 1 : 0)) {
/*  96 */             throw new IllegalStateException("Invalid position of FFMCaptureCallState parameter.");
/*     */           }
/*     */           
/*  99 */           captureCallState = Linker.Option.captureCallState(ccs.value());
/*     */           continue;
/*     */         } 
/* 102 */       } else if (i == 0 && this.hasFunctionAddress) {
/* 103 */         throw new IllegalStateException("Missing FFMFunctionAddress parameter.");
/*     */       } 
/*     */       
/* 106 */       if (parameter.isAnnotationPresent((Class)FFMFirstVariadicArg.class)) {
/* 107 */         if (firstVariadicArg != null) {
/* 108 */           throw new IllegalStateException("Multiple FFMFirstVariadicArg annotations found.");
/*     */         }
/* 110 */         firstVariadicArg = Linker.Option.firstVariadicArg(i);
/*     */       } 
/*     */       
/* 113 */       if (SegmentAllocator.class.isAssignableFrom(parameter.getType())) {
/* 114 */         if (i != (this.hasFunctionAddress ? 1 : 0)) {
/* 115 */           throw new IllegalStateException("Invalid position of SegmentAllocator/Arena parameter.");
/*     */         }
/* 117 */         allocatorClass = parameter.getType();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 122 */       Class<?> clazz = parameter.getType();
/* 123 */       if (BCUtil.isPointerType(parameter, clazz)) {
/* 124 */         if (config.checks && !BCUtil.isNullable(config, parameter)) {
/* 125 */           featureFlags |= BCCall.FeatureFlag.FF_CHECK.mask;
/*     */         }
/* 127 */         if (BITS32 && clazz == long.class) {
/* 128 */           featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*     */         }
/* 130 */       } else if (clazz == String.class) {
/* 131 */         featureFlags |= BCCall.FeatureFlag.FF_STACK.mask;
/* 132 */       } else if (clazz == boolean.class) {
/* 133 */         if (parameter.isAnnotationPresent((Class)FFMBooleanInt.class)) {
/* 134 */           featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*     */         }
/* 136 */       } else if (needsBinder(clazz)) {
/* 137 */         Binder<?> binder = ((FFMConfig.BinderField)config.binders.get(clazz)).binder();
/* 138 */         if (allocatorClass == null && binder instanceof org.lwjgl.system.ffm.UpcallBinder) {
/* 139 */           throw new IllegalStateException("An Arena parameter is required for parameter #" + i + ": " + String.valueOf(clazz));
/*     */         }
/*     */         
/* 142 */         this.binders.putIfAbsent(clazz, Integer.valueOf(this.binders.size()));
/* 143 */         featureFlags |= BCCall.FeatureFlag.FF_BINDER.mask;
/*     */         
/* 145 */         if (binder instanceof GroupBinder) { GroupBinder<?, ?> groupBinder = (GroupBinder)binder;
/* 146 */           GroupLayout groupLayout = groupBinder.layout();
/* 147 */           argLayouts.add(parameter.isAnnotationPresent((Class)FFMByValue.class) ? 
/* 148 */               groupLayout : 
/* 149 */               ValueLayout.ADDRESS.withTargetLayout(groupLayout)); }
/*     */         else
/* 151 */         { argLayouts.add(ValueLayout.ADDRESS); }
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 157 */       argLayouts.add(valueLayout(parameter));
/*     */       continue;
/*     */     } 
/* 160 */     this.allocatorClass = allocatorClass;
/* 161 */     this.captureCallState = captureCallState;
/* 162 */     this.firstVariadicArg = firstVariadicArg;
/*     */     
/* 164 */     MemoryLayout resLayout = null;
/*     */     
/* 166 */     Class<?> type = method.getReturnType();
/* 167 */     if (type != void.class) {
/* 168 */       FFMReturn returnAnnotation = method.<FFMReturn>getAnnotation(FFMReturn.class);
/*     */       
/* 170 */       if (type == String.class || returnAnnotation != null) {
/* 171 */         featureFlags |= BCCall.FeatureFlag.FF_STACK.mask;
/* 172 */       } else if (type == boolean.class) {
/* 173 */         if (method.isAnnotationPresent((Class)FFMBooleanInt.class)) {
/* 174 */           featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*     */         }
/* 176 */       } else if (BITS32 && type == long.class && method.isAnnotationPresent((Class)FFMPointer.class)) {
/* 177 */         featureFlags |= BCCall.FeatureFlag.FF_TYPE_CONVERSION.mask;
/*     */       } 
/*     */       
/* 180 */       if (returnAnnotation != null) {
/* 181 */         FFMReturn.SizeOut returnOutputAnnotation = method.<FFMReturn.SizeOut>getAnnotation(FFMReturn.SizeOut.class);
/*     */ 
/*     */ 
/*     */         
/* 185 */         if (returnOutputAnnotation == null) {
/* 186 */           for (Parameter parameter : this.parameters) {
/* 187 */             if (parameter.isAnnotationPresent((Class)FFMReturn.Size.class)) {
/* 188 */               resLayout = valueLayout(parameter);
/*     */             }
/*     */           } 
/*     */         }
/* 192 */         injectReturnParameters(argLayouts, returnAnnotation, returnOutputAnnotation);
/* 193 */       } else if (needsBinder(type)) {
/* 194 */         Binder<?> binder = ((FFMConfig.BinderField)config.binders.get(type)).binder();
/* 195 */         if (binder instanceof org.lwjgl.system.ffm.UpcallBinder) {
/* 196 */           throw new IllegalStateException("Upcalls can only be returned as raw pointer values");
/*     */         }
/*     */         
/* 199 */         this.binders.putIfAbsent(type, Integer.valueOf(this.binders.size()));
/* 200 */         featureFlags |= BCCall.FeatureFlag.FF_BINDER.mask;
/*     */         
/* 202 */         GroupLayout groupLayout = ((GroupBinder)binder).layout();
/* 203 */         if (method.isAnnotationPresent((Class)FFMByValue.class)) {
/* 204 */           if (allocatorClass == null) {
/* 205 */             throw new IllegalStateException("A SegmentAllocator/Arena parameter is required for return value");
/*     */           }
/* 207 */           resLayout = groupLayout;
/* 208 */           featureFlags |= BCCall.FeatureFlag.FF_BY_VALUE.mask;
/*     */         } else {
/* 210 */           resLayout = ValueLayout.ADDRESS.withTargetLayout(groupLayout);
/*     */         } 
/*     */       } else {
/* 213 */         resLayout = valueLayout(method, type);
/*     */       } 
/*     */     } 
/*     */     
/* 217 */     this.featureFlags = featureFlags;
/*     */     
/* 219 */     MemoryLayout[] argLayoutsArray = (MemoryLayout[])argLayouts.toArray(x$0 -> new MemoryLayout[x$0]);
/* 220 */     this
/*     */       
/* 222 */       .descriptor = (resLayout == null) ? FunctionDescriptor.ofVoid(argLayoutsArray) : FunctionDescriptor.of(resLayout, argLayoutsArray);
/*     */     
/* 224 */     this
/* 225 */       .ffm = Linker.nativeLinker().downcallHandle(this.descriptor, createOptions());
/*     */   }
/*     */   private final LinkedHashMap<Class<?>, Integer> binders; private final Class<?> allocatorClass; private final Linker.Option captureCallState; private final Linker.Option firstVariadicArg; private final FunctionDescriptor descriptor; private final MethodHandle ffm;
/*     */   private boolean hasFunctionAddress() {
/* 229 */     return (this.method
/* 230 */       .getAnnotation(FFMFunctionAddress.class) != null || this.method
/* 231 */       .getDeclaringClass().getAnnotation(FFMFunctionAddress.class) != null);
/*     */   }
/*     */   
/*     */   private boolean hasJNI() {
/* 235 */     return (this.method
/* 236 */       .getAnnotation(FFMJNI.class) != null || this.method
/* 237 */       .getDeclaringClass().getAnnotation(FFMJNI.class) != null);
/*     */   }
/*     */   
/*     */   private static void injectReturnParameters(ArrayList<MemoryLayout> argLayouts, FFMReturn returnAnnotation, FFMReturn.SizeOut returnSizeOutAnnotation) {
/* 241 */     if (returnSizeOutAnnotation != null && returnSizeOutAnnotation.value() < returnAnnotation.value()) {
/* 242 */       injectReturnParameter(argLayouts, returnSizeOutAnnotation.value(), "Invalid @FFMReturn.SizeOut parameter index: ");
/*     */     }
/* 244 */     injectReturnParameter(argLayouts, returnAnnotation.value(), "Invalid return parameter index: ");
/* 245 */     if (returnSizeOutAnnotation != null && returnAnnotation.value() < returnSizeOutAnnotation.value())
/* 246 */       injectReturnParameter(argLayouts, returnSizeOutAnnotation.value(), "Invalid @FFMReturn.SizeOut parameter index: "); 
/*     */   }
/*     */   
/*     */   private static void injectReturnParameter(ArrayList<MemoryLayout> argLayouts, int injectIndex, String errorMessage) {
/* 250 */     if (injectIndex < 0 || argLayouts.size() < injectIndex) {
/* 251 */       throw new IllegalArgumentException(errorMessage + errorMessage);
/*     */     }
/* 253 */     argLayouts.add(injectIndex, FFM.C_POINTER);
/*     */   }
/*     */   
/*     */   private Linker.Option[] createOptions() {
/* 257 */     ArrayList<Linker.Option> options = new ArrayList<>(2);
/*     */     
/* 259 */     addCritical(options);
/*     */     
/* 261 */     if (this.captureCallState != null) {
/* 262 */       options.add(this.captureCallState);
/*     */     }
/*     */     
/* 265 */     if (this.firstVariadicArg != null) {
/* 266 */       options.add(this.firstVariadicArg);
/*     */     }
/*     */     
/* 269 */     if (options.isEmpty()) {
/* 270 */       return BCUtil.EMPTY_OPTIONS;
/*     */     }
/*     */     
/* 273 */     return (Linker.Option[])options.toArray(x$0 -> new Linker.Option[x$0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void addCritical(ArrayList<Linker.Option> options) {
/* 279 */     Boolean override = (this.config.criticalOverride == null) ? null : this.config.criticalOverride.apply(this.method);
/*     */ 
/*     */     
/* 282 */     if (override != null && !override.booleanValue()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 287 */     FFMCritical annotation = this.method.<FFMCritical>getAnnotation(FFMCritical.class);
/* 288 */     if (annotation == null) {
/* 289 */       annotation = this.method.getDeclaringClass().<FFMCritical>getAnnotation(FFMCritical.class);
/*     */     }
/*     */ 
/*     */     
/* 293 */     if (override != null || annotation != null)
/*     */     {
/* 295 */       options.add(Linker.Option.critical((annotation != null && annotation.value())));
/*     */     }
/*     */   }
/*     */   
/*     */   MethodHandle bootstrap() {
/* 300 */     if (this.config.debugGenerator) {
/* 301 */       printDebug(this.method, this.parameters, this.descriptor);
/*     */     }
/*     */     
/* 304 */     if (this.featureFlags != 0) {
/* 305 */       return bootstrapWrapper();
/*     */     }
/*     */ 
/*     */     
/* 309 */     return this.hasFunctionAddress ? 
/* 310 */       this.ffm : 
/* 311 */       this.ffm.bindTo(((SymbolLookup)Objects.<SymbolLookup>requireNonNull(this.config.symbolLookup)).find(this.nativeName).orElseThrow());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private MethodHandle bootstrapWrapper() {
/* 317 */     if (this.config.debugGenerator) {
/* 318 */       APIUtil.apiLog("\t-> generating wrapper method");
/*     */     }
/*     */     
/* 321 */     List<Object> classData = getClassData();
/*     */     
/* 323 */     ClassDesc thisClass = getClassDescWrapper(this.method);
/* 324 */     byte[] bytecode = ClassFile.of().build(thisClass, classBuilder -> {
/*     */           BCUtil.startHiddenClass(classBuilder);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           MethodTypeDesc nativeMethodTypeDesc = this.ffm.type().describeConstable().orElseThrow();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           if (hasFeature(BCCall.FeatureFlag.FF_TRACING)) {
/*     */             trace(classBuilder, nativeMethodTypeDesc);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           MethodTypeDesc methodTypeDesc = BCUtil.getMethodTypeDesc(this.method);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           classBuilder.withMethod(this.method.getName(), methodTypeDesc, 9, ());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 518 */     if (this.config.debugGenerator) {
/* 519 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 524 */       MethodHandles.Lookup wrapperLookup = this.config.lookup.defineHiddenClassWithClassData(bytecode, classData, true, new MethodHandles.Lookup.ClassOption[0]);
/* 525 */       return wrapperLookup.findStatic(wrapperLookup
/* 526 */           .lookupClass(), this.method
/* 527 */           .getName(), 
/* 528 */           MethodType.methodType(this.method.getReturnType(), this.method.getParameterTypes()));
/*     */     }
/* 530 */     catch (Error|RuntimeException e) {
/* 531 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/* 532 */       throw e;
/* 533 */     } catch (Exception e) {
/* 534 */       BCUtil.printModel((CompoundElement)ClassFile.of().parse(bytecode));
/* 535 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void buildMethodBody(CodeBuilder cb, MethodTypeDesc methodTypeDesc, int allocatorSlot, Consumer<CodeBuilder> bodyHandler) {
/* 540 */     TypeKind returnTK = TypeKind.from(methodTypeDesc.returnType());
/* 541 */     if (allocatorSlot != -1 && (this.allocatorClass == null || StackAllocator.class.isAssignableFrom(this.allocatorClass))) {
/* 542 */       buildStackBody(cb, returnTK, allocatorSlot, bodyHandler);
/*     */     } else {
/* 544 */       bodyHandler.accept(cb);
/*     */     } 
/* 546 */     cb.return_(returnTK);
/*     */   }
/*     */   
/*     */   private void buildStackBody(CodeBuilder cb, TypeKind returnTK, int stackSlot, Consumer<CodeBuilder> arenaTryHandler) {
/* 550 */     int returnSlot = (returnTK == TypeKind.VOID) ? -1 : cb.allocateLocal(returnTK);
/*     */     
/* 552 */     if (this.allocatorClass == null || !StackAllocator.class.isAssignableFrom(this.allocatorClass)) {
/*     */       
/* 554 */       cb
/* 555 */         .invokestatic(BCDescriptors.CD_SegmentStack, "stackPush", BCDescriptors.MTD_SegmentStack)
/* 556 */         .astore(stackSlot);
/*     */     } else {
/*     */       
/* 559 */       cb
/* 560 */         .aload(cb.parameterSlot(this.hasFunctionAddress ? 1 : 0))
/* 561 */         .invokeinterface(BCDescriptors.CD_StackAllocator, "push", BCDescriptors.MTD_StackAllocator)
/* 562 */         .pop();
/*     */     } 
/* 564 */     cb.trying(tryingHandler -> {
/*     */           arenaTryHandler.accept(tryingHandler);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           if (returnTK != TypeKind.VOID) {
/*     */             tryingHandler.storeLocal(returnTK, returnSlot);
/*     */           }
/* 592 */         }catchesHandler -> catchesHandler.catchingAll(())).aload(stackSlot)
/* 593 */       .invokeinterface(BCDescriptors.CD_StackAllocator, "pop", BCDescriptors.MTD_StackAllocator)
/* 594 */       .pop();
/* 595 */     if (returnTK != TypeKind.VOID) {
/* 596 */       cb.loadLocal(returnTK, returnSlot);
/*     */     }
/*     */   }
/*     */   
/*     */   private void trace(ClassBuilder classBuilder, MethodTypeDesc nativeMethodTypeDesc) {
/* 601 */     classBuilder.withMethod("trace", nativeMethodTypeDesc, 10, mb -> mb.withCode(()));
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
/*     */   private boolean hasFeature(BCCall.FeatureFlag flag) {
/* 662 */     return flag.isSet(this.featureFlags);
/*     */   }
/*     */   
/*     */   private int getVirtualParameterCount() {
/* 666 */     int index = 0;
/* 667 */     if (this.hasFunctionAddress) {
/* 668 */       index++;
/*     */     }
/* 670 */     if (this.allocatorClass != null) {
/* 671 */       index++;
/*     */     }
/* 673 */     if (this.captureCallState != null) {
/* 674 */       index++;
/*     */     }
/* 676 */     return index;
/*     */   }
/*     */   
/*     */   private int getFirstNativeParameterIndex() {
/* 680 */     int index = 0;
/* 681 */     if (this.hasFunctionAddress) {
/* 682 */       index++;
/*     */     }
/* 684 */     if (this.allocatorClass != null);
/*     */ 
/*     */     
/* 687 */     if (this.captureCallState != null) {
/* 688 */       index++;
/*     */     }
/* 690 */     return index;
/*     */   }
/*     */   
/*     */   private int getStackSlot(CodeBuilder cb) {
/* 694 */     return (this.allocatorClass != null) ? 
/* 695 */       cb.parameterSlot(this.hasFunctionAddress ? 1 : 0) : 
/* 696 */       cb.allocateLocal(TypeKind.REFERENCE);
/*     */   }
/*     */   
/*     */   private int getUpcallArenaSlot(CodeBuilder cb) {
/* 700 */     if (this.allocatorClass == null || !Arena.class.isAssignableFrom(this.allocatorClass)) {
/* 701 */       throw new IllegalStateException("Allocating upcalls requires an Arena parameter");
/*     */     }
/* 703 */     return cb.parameterSlot(this.hasFunctionAddress ? 1 : 0);
/*     */   }
/*     */   
/*     */   private List<Object> getClassData() {
/* 707 */     ArrayList<Object> list = new ArrayList(5);
/*     */     
/* 709 */     list.add(this.ffm);
/*     */     
/* 711 */     if (!this.hasFunctionAddress) {
/* 712 */       SymbolLookup lookup = this.config.symbolLookup;
/* 713 */       if (lookup == null) {
/* 714 */         throw new IllegalStateException("The registered FFMConfig does not define a SymbolLookup.");
/*     */       }
/* 716 */       list.add(lookup
/* 717 */           .find(this.nativeName)
/* 718 */           .orElseThrow(() -> new IllegalStateException("Failed to resolve native function: " + this.nativeName)));
/*     */     } 
/*     */     
/* 721 */     if (hasFeature(BCCall.FeatureFlag.FF_TRACING)) {
/* 722 */       this.featureFlagOffsets[BCCall.FeatureFlag.FF_TRACING.ordinal()] = list.size();
/* 723 */       list.add(this.config.traceConsumer);
/* 724 */       list.add(this.method);
/*     */     } 
/*     */     
/* 727 */     if (hasFeature(BCCall.FeatureFlag.FF_BINDER)) {
/* 728 */       this.featureFlagOffsets[BCCall.FeatureFlag.FF_BINDER.ordinal()] = list.size();
/* 729 */       for (Class<?> type : this.binders.sequencedKeySet()) {
/* 730 */         list.add(((FFMConfig.BinderField)this.config.binders.get(type)).binder());
/*     */       }
/*     */     } 
/*     */     
/* 734 */     return list;
/*     */   }
/*     */   
/*     */   private static <T extends CodeBuilder> T buildAllocateFrom(T cb, int allocatorSlot, int slot, Parameter parameter) {
/* 738 */     cb
/* 739 */       .aload(allocatorSlot)
/* 740 */       .aload(slot);
/* 741 */     BCUtil.buildCharsetInstance((CodeBuilder)cb, BCUtil.getCharset(parameter))
/* 742 */       .invokeinterface(BCDescriptors.CD_SegmentAllocator, "allocateFrom", BCDescriptors.MTD_MemorySegment_String_Charset);
/* 743 */     return cb;
/*     */   }
/*     */   
/*     */   private <T extends CodeBuilder> T buildGroupAsSegment(T cb, Class<?> type, int parameterSlot) {
/* 747 */     cb
/* 748 */       .ldc(BCUtil.condyCDataAt(BCDescriptors.CD_GroupBinder, this.featureFlagOffsets[BCCall.FeatureFlag.FF_BINDER.ordinal()] + ((Integer)this.binders.get(type)).intValue()))
/* 749 */       .aload(parameterSlot)
/* 750 */       .invokeinterface(BCDescriptors.CD_GroupBinder, "asSegment", BCDescriptors.MTD_MemorySegment_Object);
/* 751 */     return cb;
/*     */   }
/*     */   
/*     */   private <T extends CodeBuilder> T buildUpcallBinderAllocation(T cb, Class<?> type, int parameterSlot) {
/* 755 */     cb
/* 756 */       .ldc(BCUtil.condyCDataAt(BCDescriptors.CD_UpcallBinder, this.featureFlagOffsets[BCCall.FeatureFlag.FF_BINDER.ordinal()] + ((Integer)this.binders.get(type)).intValue()))
/* 757 */       .aload(getUpcallArenaSlot((CodeBuilder)cb))
/* 758 */       .aload(parameterSlot)
/* 759 */       .invokeinterface(BCDescriptors.CD_UpcallBinder, "allocate", BCDescriptors.MTD_MemorySegment_Arena_Object);
/* 760 */     return cb;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\BCCallDown.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */