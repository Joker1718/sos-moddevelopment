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
/*    */ @NativeType("GLFWwindowfocusfun")
/*    */ public interface GLFWWindowFocusCallbackI
/*    */   extends CallbackI
/*    */ {
/* 21 */   public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(
/* 22 */       MethodHandles.lookup(), 
/* 23 */       APIUtil.apiCreateCIF(LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_uint32 }));
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
/* 34 */     invoke(
/* 35 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args)), 
/* 36 */         (MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args + POINTER_SIZE)) != 0));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("GLFWwindow *") long paramLong, @NativeType("int") boolean paramBoolean);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowFocusCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */