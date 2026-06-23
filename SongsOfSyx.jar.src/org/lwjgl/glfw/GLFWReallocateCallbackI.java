/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import java.lang.invoke.MethodHandles;
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.CallbackI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ import org.lwjgl.system.libffi.FFIType;
/*    */ import org.lwjgl.system.libffi.LibFFI;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ @NativeType("GLFWreallocatefun")
/*    */ public interface GLFWReallocateCallbackI
/*    */   extends CallbackI
/*    */ {
/* 21 */   public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(
/* 22 */       MethodHandles.lookup(), 
/* 23 */       APIUtil.apiCreateCIF(LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer }));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default Callback.Descriptor getDescriptor() {
/* 30 */     return DESCRIPTOR;
/*    */   }
/*    */   
/*    */   default void callback(long ret, long args) {
/* 34 */     long __result = invoke(
/* 35 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args)), 
/* 36 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + POINTER_SIZE)), 
/* 37 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + (2 * POINTER_SIZE))));
/*    */     
/* 39 */     APIUtil.apiClosureRetP(ret, __result);
/*    */   }
/*    */   
/*    */   @NativeType("void *")
/*    */   long invoke(@NativeType("void *") long paramLong1, @NativeType("size_t") long paramLong2, @NativeType("void *") long paramLong3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWReallocateCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */