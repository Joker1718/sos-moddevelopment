/*    */ package org.lwjgl.opengl;
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
/*    */ @NativeType("GLDEBUGPROCAMD")
/*    */ public interface GLDebugMessageAMDCallbackI
/*    */   extends CallbackI
/*    */ {
/* 21 */   public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(
/* 22 */       MethodHandles.lookup(), 
/* 23 */       APIUtil.apiCreateCIF(
/* 24 */         APIUtil.apiStdcall(), LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer }));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default Callback.Descriptor getDescriptor() {
/* 31 */     return DESCRIPTOR;
/*    */   }
/*    */   
/*    */   default void callback(long ret, long args) {
/* 35 */     invoke(
/* 36 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args)), 
/* 37 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args + POINTER_SIZE)), 
/* 38 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args + (2 * POINTER_SIZE))), 
/* 39 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args + (3 * POINTER_SIZE))), 
/* 40 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + (4 * POINTER_SIZE))), 
/* 41 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + (5 * POINTER_SIZE))));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLchar const *") long paramLong1, @NativeType("void *") long paramLong2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLDebugMessageAMDCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */