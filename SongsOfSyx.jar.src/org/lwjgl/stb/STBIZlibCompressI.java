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
/*    */ @NativeType("unsigned char * (*) (unsigned char *, int, int *, int)")
/*    */ public interface STBIZlibCompressI
/*    */   extends CallbackI
/*    */ {
/* 21 */   public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(
/* 22 */       MethodHandles.lookup(), 
/* 23 */       APIUtil.apiCreateCIF(LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_sint32 }));
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
/* 36 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args + POINTER_SIZE)), 
/* 37 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + (2 * POINTER_SIZE))), 
/* 38 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args + (3 * POINTER_SIZE))));
/*    */     
/* 40 */     APIUtil.apiClosureRetP(ret, __result);
/*    */   }
/*    */   
/*    */   @NativeType("unsigned char *")
/*    */   long invoke(@NativeType("unsigned char *") long paramLong1, int paramInt1, @NativeType("int *") long paramLong2, int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIZlibCompressI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */