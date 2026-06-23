/*    */ package org.lwjgl.stb;
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
/*    */ @NativeType("stbir__support_callback *")
/*    */ public interface STBIRSupportCallbackI
/*    */   extends CallbackI
/*    */ {
/* 21 */   public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(
/* 22 */       MethodHandles.lookup(), 
/* 23 */       APIUtil.apiCreateCIF(LibFFI.ffi_type_float, new FFIType[] { LibFFI.ffi_type_float, LibFFI.ffi_type_pointer }));
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
/* 34 */     float __result = invoke(
/* 35 */         MemoryUtil.memGetFloat(MemoryUtil.memGetAddress(args)), 
/* 36 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + POINTER_SIZE)));
/*    */     
/* 38 */     APIUtil.apiClosureRet(ret, __result);
/*    */   }
/*    */   
/*    */   float invoke(float paramFloat, @NativeType("void *") long paramLong);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIRSupportCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */