/*    */ package org.lwjgl.system.macosx;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.FunctionProvider;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LibC
/*    */ {
/*    */   public static final class Functions
/*    */   {
/* 22 */     public static final long getpid = APIUtil.apiGetFunctionAddress((FunctionProvider)LibSystem.getLibrary(), "getpid");
/*    */   }
/*    */ 
/*    */   
/*    */   protected LibC() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("pid_t")
/*    */   public static long getpid() {
/* 35 */     long __functionAddress = Functions.getpid;
/* 36 */     return JNI.invokeP(__functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\LibC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */