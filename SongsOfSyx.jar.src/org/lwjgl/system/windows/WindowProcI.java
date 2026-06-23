/*    */ package org.lwjgl.system.windows;
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
/*    */ @NativeType("WNDPROC")
/*    */ public interface WindowProcI
/*    */   extends CallbackI
/*    */ {
/* 21 */   public static final Callback.Descriptor DESCRIPTOR = new Callback.Descriptor(
/* 22 */       MethodHandles.lookup(), 
/* 23 */       APIUtil.apiCreateCIF(
/* 24 */         APIUtil.apiStdcall(), LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_uint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer }));
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
/* 35 */     long __result = invoke(
/* 36 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args)), 
/* 37 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(args + POINTER_SIZE)), 
/* 38 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + (2 * POINTER_SIZE))), 
/* 39 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(args + (3 * POINTER_SIZE))));
/*    */     
/* 41 */     APIUtil.apiClosureRetP(ret, __result);
/*    */   }
/*    */   
/*    */   @NativeType("LRESULT")
/*    */   long invoke(@NativeType("HWND") long paramLong1, @NativeType("UINT") int paramInt, @NativeType("WPARAM") long paramLong2, @NativeType("LPARAM") long paramLong3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\WindowProcI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */