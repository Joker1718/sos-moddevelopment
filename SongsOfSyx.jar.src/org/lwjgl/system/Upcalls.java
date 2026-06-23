/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.jni.JNINativeInterface;
/*     */ import org.lwjgl.system.libffi.FFIClosure;
/*     */ import org.lwjgl.system.libffi.LibFFI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  27 */   private static final boolean DEBUG_ALLOCATOR = ((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR.get(Boolean.valueOf(false))).booleanValue();
/*     */   
/*  29 */   private static final int CLOSURE_SIZE = (int)LibFFI.ffi_get_closure_size();
/*     */ 
/*     */ 
/*     */   
/*     */   private static final ClosureRegistry CLOSURE_REGISTRY;
/*     */ 
/*     */   
/*     */   private static final long CALLBACK_HANDLER;
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  41 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/*  42 */       PointerBuffer code = stack.mallocPointer(1);
/*     */       
/*  44 */       FFIClosure closure = LibFFI.ffi_closure_alloc(CLOSURE_SIZE, code);
/*  45 */       if (closure == null) {
/*  46 */         throw new OutOfMemoryError();
/*     */       }
/*     */       
/*  49 */       if (code.get(0) == closure.address()) {
/*  50 */         APIUtil.apiLog("Closure Registry: simple");
/*     */ 
/*     */ 
/*     */         
/*  54 */         CLOSURE_REGISTRY = new ClosureRegistry()
/*     */           {
/*     */             public void put(long executableAddress, FFIClosure closure) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public FFIClosure get(long executableAddress) {
/*  61 */               return FFIClosure.create(executableAddress);
/*     */             }
/*     */             
/*     */             public FFIClosure remove(long executableAddress) {
/*  65 */               return get(executableAddress);
/*     */             }
/*     */           };
/*     */       } else {
/*  69 */         APIUtil.apiLog("Closure Registry: ConcurrentHashMap");
/*     */         
/*  71 */         CLOSURE_REGISTRY = new ClosureRegistry() {
/*  72 */             private final ConcurrentHashMap<Long, FFIClosure> map = new ConcurrentHashMap<>();
/*     */ 
/*     */             
/*     */             public void put(long executableAddress, FFIClosure closure) {
/*  76 */               this.map.put(Long.valueOf(executableAddress), closure);
/*     */             }
/*     */             
/*     */             public FFIClosure get(long executableAddress) {
/*  80 */               return this.map.get(Long.valueOf(executableAddress));
/*     */             }
/*     */             
/*     */             public FFIClosure remove(long executableAddress) {
/*  84 */               return this.map.remove(Long.valueOf(executableAddress));
/*     */             }
/*     */           };
/*     */       } 
/*  88 */       LibFFI.ffi_closure_free(closure);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  98 */       CALLBACK_HANDLER = getCallbackHandler(CallbackI.class.getDeclaredMethod("callback", new Class[] { long.class, long.class }));
/*  99 */     } catch (Exception e) {
/* 100 */       throw new IllegalStateException("Failed to initialize the native callback handler.", e);
/*     */     } 
/*     */     
/* 103 */     MemoryUtil.getAllocator();
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
/*     */   static long upcallCreate(Callback.Descriptor descriptor, Object instance) {
/*     */     FFIClosure closure;
/*     */     long executableAddress;
/* 125 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 126 */       PointerBuffer code = stack.mallocPointer(1);
/*     */       
/* 128 */       closure = LibFFI.ffi_closure_alloc(CLOSURE_SIZE, code);
/* 129 */       if (closure == null) {
/* 130 */         throw new OutOfMemoryError();
/*     */       }
/* 132 */       executableAddress = code.get(0);
/* 133 */       if (DEBUG_ALLOCATOR) {
/* 134 */         MemoryManage.DebugAllocator.track(executableAddress, CLOSURE_SIZE);
/*     */       }
/*     */     } 
/*     */     
/* 138 */     long user_data = JNINativeInterface.NewGlobalRef(instance);
/*     */     
/* 140 */     int errcode = LibFFI.ffi_prep_closure_loc(closure, descriptor.cif, CALLBACK_HANDLER, user_data, executableAddress);
/* 141 */     if (errcode != 0) {
/* 142 */       JNINativeInterface.DeleteGlobalRef(user_data);
/* 143 */       LibFFI.ffi_closure_free(closure);
/* 144 */       throw new RuntimeException("Failed to prepare the libffi closure");
/*     */     } 
/*     */     
/* 147 */     CLOSURE_REGISTRY.put(executableAddress, closure);
/*     */     
/* 149 */     return executableAddress;
/*     */   }
/*     */   
/*     */   static <T extends CallbackI> T upcallGet(long functionPointer) {
/* 153 */     return (T)MemoryUtil.<CallbackI>memGlobalRefToObject(CLOSURE_REGISTRY.get(functionPointer).user_data());
/*     */   }
/*     */   
/*     */   static void upcallFree(long functionPointer) {
/* 157 */     if (DEBUG_ALLOCATOR) {
/* 158 */       MemoryManage.DebugAllocator.untrack(functionPointer);
/*     */     }
/*     */     
/* 161 */     FFIClosure closure = CLOSURE_REGISTRY.remove(functionPointer);
/*     */     
/* 163 */     JNINativeInterface.DeleteGlobalRef(closure.user_data());
/* 164 */     LibFFI.ffi_closure_free(closure);
/*     */   }
/*     */   
/*     */   private static native long getCallbackHandler(Method paramMethod);
/*     */   
/*     */   private static interface ClosureRegistry {
/*     */     void put(long param1Long, FFIClosure param1FFIClosure);
/*     */     
/*     */     FFIClosure get(long param1Long);
/*     */     
/*     */     FFIClosure remove(long param1Long);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Upcalls.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */