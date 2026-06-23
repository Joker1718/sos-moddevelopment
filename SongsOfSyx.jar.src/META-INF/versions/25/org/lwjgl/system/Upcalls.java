/*     */ package META-INF.versions.25.org.lwjgl.system;
/*     */ 
/*     */ import java.lang.foreign.Arena;
/*     */ import java.lang.foreign.FunctionDescriptor;
/*     */ import java.lang.foreign.Linker;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.invoke.MethodHandle;
/*     */ import java.lang.invoke.MethodHandles;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.function.Consumer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Callback;
/*     */ import org.lwjgl.system.CallbackI;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.ffm.FFM;
/*     */ import org.lwjgl.system.ffm.UpcallBinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Upcalls
/*     */ {
/*     */   private static final ConcurrentHashMap<Class<?>, Class<?>> CALLBACK_INTERFACE_CACHE;
/*     */   private static final ConcurrentHashMap<Class<?>, UpcallBinder<?>> BINDER_CACHE;
/*     */   private static final ConcurrentHashMap<Long, Upcall> UPCALL_REGISTRY;
/*     */   private static final ArenaType ARENA_TYPE;
/*     */   private static final MethodHandle WRAP_EXCEPTION_V;
/*     */   private static final MethodHandle WRAP_EXCEPTION_B;
/*     */   private static final MethodHandle WRAP_EXCEPTION_S;
/*     */   private static final MethodHandle WRAP_EXCEPTION_I;
/*     */   private static final MethodHandle WRAP_EXCEPTION_J;
/*     */   private static final MethodHandle WRAP_EXCEPTION_F;
/*     */   private static final MethodHandle WRAP_EXCEPTION_D;
/*     */   private static final MethodHandle WRAP_EXCEPTION_A;
/*     */   
/*     */   static long upcallCreate(Callback.Descriptor callbackDescriptor, Object instance) {
/*  67 */     UpcallBinder binder = getBinder(callbackDescriptor, instance);
/*     */     
/*  69 */     FunctionDescriptor descriptor = binder.descriptor();
/*     */     
/*  71 */     ScopedValue<Arena> scopedArena = FFM.ffmScopedArena();
/*     */ 
/*     */     
/*  74 */     Arena arena = scopedArena.isBound() ? scopedArena.get() : ARENA_TYPE.create();
/*     */ 
/*     */ 
/*     */     
/*  78 */     MethodHandle handle = binder.handle().bindTo(instance);
/*     */     
/*  80 */     MemoryLayout stack = binder.stack();
/*  81 */     if (stack != null) {
/*  82 */       handle = handle.bindTo(arena.allocate(stack));
/*     */     }
/*     */     
/*  85 */     if (((Boolean)Configuration.FFM_UPCALL_EXCEPTION_CATCH.get(Boolean.valueOf(true))).booleanValue()) {
/*  86 */       handle = MethodHandles.catchException(handle, Throwable.class, wrapException(descriptor));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     MemorySegment upcall = Linker.nativeLinker().upcallStub(handle, descriptor, arena, new Linker.Option[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     UPCALL_REGISTRY.put(Long.valueOf(upcall.address()), new Upcall(arena, instance));
/*     */     
/* 103 */     return upcall.address();
/*     */   }
/*     */ 
/*     */   
/*     */   static <T extends CallbackI> T upcallGet(long functionPointer) {
/* 108 */     return (T)((Upcall)UPCALL_REGISTRY.get(Long.valueOf(functionPointer))).javaCallback;
/*     */   }
/*     */   
/*     */   static void upcallFree(long functionPointer) {
/* 112 */     Upcall upcall = UPCALL_REGISTRY.remove(Long.valueOf(functionPointer));
/* 113 */     if (upcall != null && ARENA_TYPE.isCloseable()) {
/* 114 */       upcall.arena.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static UpcallBinder getBinder(Callback.Descriptor descriptor, Object instance) {
/* 122 */     Class<?> upcallInterface = CALLBACK_INTERFACE_CACHE.computeIfAbsent(instance.getClass(), it -> {
/*     */           for (;; it = it.getSuperclass()) {
/*     */             if (it.isHidden() || !it.isAnonymousClass()) {
/*     */               Class[] arr$ = it.getInterfaces(); int len$ = arr$.length; int i$ = 0; while (true) {
/*     */                 if (i$ < len$) {
/*     */                   Class<?> iface = arr$[i$]; if (CallbackI.class.isAssignableFrom(iface)) {
/*     */                     it = iface;
/*     */                   } else {
/*     */                     i$++; continue;
/*     */                   } 
/*     */                 } else {
/*     */                   break;
/*     */                 }  if (!it.isInterface())
/*     */                   throw new IllegalStateException("Failed to find upcall interface for " + String.valueOf(instance.getClass())); 
/*     */                 return it;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           if (!it.isInterface())
/*     */             throw new IllegalStateException("Failed to find upcall interface for " + String.valueOf(instance.getClass())); 
/*     */           return it;
/*     */         });
/* 144 */     return BINDER_CACHE
/* 145 */       .computeIfAbsent(upcallInterface, it -> {
/*     */           FFM.ffmConfig(it, FFM.ffmConfigBuilder(descriptor.lookup).build());
/*     */           return FFM.ffmUpcall(it, descriptor.cif);
/*     */         });
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
/*     */   private static MethodHandle wrapException(FunctionDescriptor descriptor) {
/* 182 */     return descriptor.returnLayout()
/* 183 */       .<MethodHandle>map(it -> {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           // Byte code:
/*     */           //   0: aload_0
/*     */           //   1: dup
/*     */           //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */           //   5: pop
/*     */           //   6: astore_1
/*     */           //   7: iconst_0
/*     */           //   8: istore_2
/*     */           //   9: aload_1
/*     */           //   10: iload_2
/*     */           //   11: <illegal opcode> typeSwitch : (Ljava/lang/foreign/MemoryLayout;I)I
/*     */           //   16: tableswitch default -> 132, 0 -> 64, 1 -> 70, 2 -> 76, 3 -> 82, 4 -> 88, 5 -> 94, 6 -> 100, 7 -> 100
/*     */           //   64: getstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_B : Ljava/lang/invoke/MethodHandle;
/*     */           //   67: goto -> 149
/*     */           //   70: getstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_S : Ljava/lang/invoke/MethodHandle;
/*     */           //   73: goto -> 149
/*     */           //   76: getstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_I : Ljava/lang/invoke/MethodHandle;
/*     */           //   79: goto -> 149
/*     */           //   82: getstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_J : Ljava/lang/invoke/MethodHandle;
/*     */           //   85: goto -> 149
/*     */           //   88: getstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_F : Ljava/lang/invoke/MethodHandle;
/*     */           //   91: goto -> 149
/*     */           //   94: getstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_D : Ljava/lang/invoke/MethodHandle;
/*     */           //   97: goto -> 149
/*     */           //   100: aload_1
/*     */           //   101: instanceof java/lang/foreign/AddressLayout
/*     */           //   104: ifeq -> 110
/*     */           //   107: goto -> 126
/*     */           //   110: aload_1
/*     */           //   111: instanceof java/lang/foreign/GroupLayout
/*     */           //   114: ifeq -> 120
/*     */           //   117: goto -> 126
/*     */           //   120: bipush #8
/*     */           //   122: istore_2
/*     */           //   123: goto -> 9
/*     */           //   126: getstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_A : Ljava/lang/invoke/MethodHandle;
/*     */           //   129: goto -> 149
/*     */           //   132: new java/lang/UnsupportedOperationException
/*     */           //   135: dup
/*     */           //   136: aload_0
/*     */           //   137: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */           //   140: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */           //   145: invokespecial <init> : (Ljava/lang/String;)V
/*     */           //   148: athrow
/*     */           //   149: areturn
/*     */           // Line number table:
/*     */           //   Java source line number -> byte code offset
/*     */           //   #183	-> 0
/*     */           //   #184	-> 64
/*     */           //   #185	-> 70
/*     */           //   #186	-> 76
/*     */           //   #187	-> 82
/*     */           //   #188	-> 88
/*     */           //   #189	-> 94
/*     */           //   #190	-> 100
/*     */           //   #191	-> 132
/*     */           //   #190	-> 149
/*     */           // Local variable table:
/*     */           //   start	length	slot	name	descriptor
/*     */           //   7	142	1	selector0$temp	Ljava/lang/foreign/MemoryLayout;
/*     */           //   9	140	2	index$1	I
/*     */           //   0	150	0	it	Ljava/lang/foreign/MemoryLayout;
/* 193 */         }).orElse(WRAP_EXCEPTION_V);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Consumer<Throwable> getUncaughtExceptionHandlerInstance(Object handler) {
/* 199 */     String className = handler.toString();
/*     */     try {
/* 201 */       return 
/* 202 */         Class.forName(className)
/* 203 */         .getConstructor(new Class[0])
/* 204 */         .newInstance(new Object[0]);
/* 205 */     } catch (Throwable t) {
/* 206 */       if (Checks.DEBUG) {
/* 207 */         t.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */       }
/* 209 */       APIUtil.apiLog(String.format("Warning: Failed to instantiate uncaught exception handler: %s. Using the default.", new Object[] { className }));
/* 210 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void wrapException(Throwable t) {
/* 216 */     Object handler = Configuration.FFM_UPCALL_EXCEPTION_HANDLER.get();
/*     */     
/* 218 */     if (handler != null && !"default".equals(handler)) {
/* 219 */       if (handler instanceof Consumer) { Consumer<?> consumer1 = (Consumer)handler;
/* 220 */         consumer1.accept(t);
/*     */         
/*     */         return; }
/*     */       
/* 224 */       Consumer<Throwable> consumer = getUncaughtExceptionHandlerInstance(handler);
/* 225 */       if (consumer != null) {
/* 226 */         consumer.accept(t);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 231 */     APIUtil.DEBUG_STREAM.println("[LWJGL] Unhandled exception in callback:");
/* 232 */     t.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */   }
/*     */   
/*     */   private static void wrapExceptionV(Throwable t) {
/* 236 */     wrapException(t);
/*     */   }
/*     */   
/*     */   private static byte wrapExceptionB(Throwable t) {
/* 240 */     wrapException(t);
/* 241 */     return 0;
/*     */   }
/*     */   
/*     */   private static short wrapExceptionS(Throwable t) {
/* 245 */     wrapException(t);
/* 246 */     return 0;
/*     */   }
/*     */   
/*     */   private static int wrapExceptionI(Throwable t) {
/* 250 */     wrapException(t);
/* 251 */     return 0;
/*     */   }
/*     */   
/*     */   private static long wrapExceptionJ(Throwable t) {
/* 255 */     wrapException(t);
/* 256 */     return 0L;
/*     */   }
/*     */   
/*     */   private static float wrapExceptionF(Throwable t) {
/* 260 */     wrapException(t);
/* 261 */     return 0.0F;
/*     */   }
/*     */   
/*     */   private static double wrapExceptionD(Throwable t) {
/* 265 */     wrapException(t);
/* 266 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private static MemorySegment wrapExceptionA(Throwable t) {
/* 270 */     wrapException(t);
/* 271 */     return MemorySegment.NULL;
/*     */   }
/*     */   
/*     */   static {
/*     */     // Byte code:
/*     */     //   0: new java/util/concurrent/ConcurrentHashMap
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: putstatic org/lwjgl/system/Upcalls.CALLBACK_INTERFACE_CACHE : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   10: new java/util/concurrent/ConcurrentHashMap
/*     */     //   13: dup
/*     */     //   14: invokespecial <init> : ()V
/*     */     //   17: putstatic org/lwjgl/system/Upcalls.BINDER_CACHE : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   20: new java/util/concurrent/ConcurrentHashMap
/*     */     //   23: dup
/*     */     //   24: invokespecial <init> : ()V
/*     */     //   27: putstatic org/lwjgl/system/Upcalls.UPCALL_REGISTRY : Ljava/util/concurrent/ConcurrentHashMap;
/*     */     //   30: getstatic org/lwjgl/system/Configuration.FFM_UPCALL_ARENA : Lorg/lwjgl/system/Configuration;
/*     */     //   33: ldc_w 'auto'
/*     */     //   36: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   39: checkcast java/lang/String
/*     */     //   42: astore_0
/*     */     //   43: iconst_m1
/*     */     //   44: istore_1
/*     */     //   45: aload_0
/*     */     //   46: invokevirtual hashCode : ()I
/*     */     //   49: lookupswitch default -> 126, -903566235 -> 114, -580132440 -> 99, 3005871 -> 84
/*     */     //   84: aload_0
/*     */     //   85: ldc_w 'auto'
/*     */     //   88: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   91: ifeq -> 126
/*     */     //   94: iconst_0
/*     */     //   95: istore_1
/*     */     //   96: goto -> 126
/*     */     //   99: aload_0
/*     */     //   100: ldc_w 'confined'
/*     */     //   103: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   106: ifeq -> 126
/*     */     //   109: iconst_1
/*     */     //   110: istore_1
/*     */     //   111: goto -> 126
/*     */     //   114: aload_0
/*     */     //   115: ldc_w 'shared'
/*     */     //   118: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   121: ifeq -> 126
/*     */     //   124: iconst_2
/*     */     //   125: istore_1
/*     */     //   126: iload_1
/*     */     //   127: tableswitch default -> 170, 0 -> 152, 1 -> 158, 2 -> 164
/*     */     //   152: getstatic org/lwjgl/system/Upcalls$ArenaType.AUTO : Lorg/lwjgl/system/Upcalls$ArenaType;
/*     */     //   155: goto -> 192
/*     */     //   158: getstatic org/lwjgl/system/Upcalls$ArenaType.CONFINED : Lorg/lwjgl/system/Upcalls$ArenaType;
/*     */     //   161: goto -> 192
/*     */     //   164: getstatic org/lwjgl/system/Upcalls$ArenaType.SHARED : Lorg/lwjgl/system/Upcalls$ArenaType;
/*     */     //   167: goto -> 192
/*     */     //   170: new java/lang/IllegalArgumentException
/*     */     //   173: dup
/*     */     //   174: getstatic org/lwjgl/system/Configuration.FFM_UPCALL_ARENA : Lorg/lwjgl/system/Configuration;
/*     */     //   177: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   180: checkcast java/lang/String
/*     */     //   183: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   188: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   191: athrow
/*     */     //   192: putstatic org/lwjgl/system/Upcalls.ARENA_TYPE : Lorg/lwjgl/system/Upcalls$ArenaType;
/*     */     //   195: getstatic org/lwjgl/system/Upcalls.ARENA_TYPE : Lorg/lwjgl/system/Upcalls$ArenaType;
/*     */     //   198: invokevirtual name : ()Ljava/lang/String;
/*     */     //   201: invokevirtual toLowerCase : ()Ljava/lang/String;
/*     */     //   204: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
/*     */     //   209: invokestatic apiLog : (Ljava/lang/CharSequence;)V
/*     */     //   212: ldc_w 'Upcall Registry: ConcurrentHashMap'
/*     */     //   215: invokestatic apiLog : (Ljava/lang/CharSequence;)V
/*     */     //   218: invokestatic getAllocator : ()Lorg/lwjgl/system/MemoryUtil$MemoryAllocator;
/*     */     //   221: pop
/*     */     //   222: invokestatic lookup : ()Ljava/lang/invoke/MethodHandles$Lookup;
/*     */     //   225: astore_0
/*     */     //   226: aload_0
/*     */     //   227: ldc org/lwjgl/system/Upcalls
/*     */     //   229: ldc_w 'wrapExceptionV'
/*     */     //   232: getstatic java/lang/Void.TYPE : Ljava/lang/Class;
/*     */     //   235: ldc java/lang/Throwable
/*     */     //   237: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   240: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   243: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_V : Ljava/lang/invoke/MethodHandle;
/*     */     //   246: aload_0
/*     */     //   247: ldc org/lwjgl/system/Upcalls
/*     */     //   249: ldc_w 'wrapExceptionB'
/*     */     //   252: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
/*     */     //   255: ldc java/lang/Throwable
/*     */     //   257: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   260: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   263: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_B : Ljava/lang/invoke/MethodHandle;
/*     */     //   266: aload_0
/*     */     //   267: ldc org/lwjgl/system/Upcalls
/*     */     //   269: ldc_w 'wrapExceptionS'
/*     */     //   272: getstatic java/lang/Short.TYPE : Ljava/lang/Class;
/*     */     //   275: ldc java/lang/Throwable
/*     */     //   277: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   280: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   283: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_S : Ljava/lang/invoke/MethodHandle;
/*     */     //   286: aload_0
/*     */     //   287: ldc org/lwjgl/system/Upcalls
/*     */     //   289: ldc_w 'wrapExceptionI'
/*     */     //   292: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
/*     */     //   295: ldc java/lang/Throwable
/*     */     //   297: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   300: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   303: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_I : Ljava/lang/invoke/MethodHandle;
/*     */     //   306: aload_0
/*     */     //   307: ldc org/lwjgl/system/Upcalls
/*     */     //   309: ldc_w 'wrapExceptionJ'
/*     */     //   312: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
/*     */     //   315: ldc java/lang/Throwable
/*     */     //   317: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   320: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   323: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_J : Ljava/lang/invoke/MethodHandle;
/*     */     //   326: aload_0
/*     */     //   327: ldc org/lwjgl/system/Upcalls
/*     */     //   329: ldc_w 'wrapExceptionF'
/*     */     //   332: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
/*     */     //   335: ldc java/lang/Throwable
/*     */     //   337: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   340: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   343: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_F : Ljava/lang/invoke/MethodHandle;
/*     */     //   346: aload_0
/*     */     //   347: ldc org/lwjgl/system/Upcalls
/*     */     //   349: ldc_w 'wrapExceptionD'
/*     */     //   352: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
/*     */     //   355: ldc java/lang/Throwable
/*     */     //   357: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   360: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   363: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_D : Ljava/lang/invoke/MethodHandle;
/*     */     //   366: aload_0
/*     */     //   367: ldc org/lwjgl/system/Upcalls
/*     */     //   369: ldc_w 'wrapExceptionA'
/*     */     //   372: ldc java/lang/foreign/MemorySegment
/*     */     //   374: ldc java/lang/Throwable
/*     */     //   376: invokestatic methodType : (Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/invoke/MethodType;
/*     */     //   379: invokevirtual findStatic : (Ljava/lang/Class;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/MethodHandle;
/*     */     //   382: putstatic org/lwjgl/system/Upcalls.WRAP_EXCEPTION_A : Ljava/lang/invoke/MethodHandle;
/*     */     //   385: goto -> 398
/*     */     //   388: astore_1
/*     */     //   389: new java/lang/RuntimeException
/*     */     //   392: dup
/*     */     //   393: aload_1
/*     */     //   394: invokespecial <init> : (Ljava/lang/Throwable;)V
/*     */     //   397: athrow
/*     */     //   398: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #21	-> 0
/*     */     //   #22	-> 10
/*     */     //   #29	-> 20
/*     */     //   #49	-> 30
/*     */     //   #50	-> 152
/*     */     //   #51	-> 158
/*     */     //   #52	-> 164
/*     */     //   #53	-> 170
/*     */     //   #49	-> 192
/*     */     //   #57	-> 195
/*     */     //   #58	-> 212
/*     */     //   #60	-> 218
/*     */     //   #165	-> 222
/*     */     //   #168	-> 226
/*     */     //   #169	-> 246
/*     */     //   #170	-> 266
/*     */     //   #171	-> 286
/*     */     //   #172	-> 306
/*     */     //   #173	-> 326
/*     */     //   #174	-> 346
/*     */     //   #175	-> 366
/*     */     //   #178	-> 385
/*     */     //   #176	-> 388
/*     */     //   #177	-> 389
/*     */     //   #179	-> 398
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   389	9	1	e	Ljava/lang/Exception;
/*     */     //   226	172	0	lookup	Ljava/lang/invoke/MethodHandles$Lookup;
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   226	385	388	java/lang/Exception
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\Upcalls.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */