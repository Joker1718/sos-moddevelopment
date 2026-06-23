/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTThreadLocalContext
/*    */ {
/*    */   protected EXTThreadLocalContext() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcSetThreadContext(@NativeType("ALCcontext *") long context) {
/* 24 */     long __functionAddress = (ALC.getICD()).alcSetThreadContext;
/* 25 */     if (Checks.CHECKS) {
/* 26 */       Checks.check(__functionAddress);
/*    */     }
/* 28 */     return JNI.invokePZ(context, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALCcontext *")
/*    */   public static long alcGetThreadContext() {
/* 36 */     long __functionAddress = (ALC.getICD()).alcGetThreadContext;
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.check(__functionAddress);
/*    */     }
/* 40 */     return JNI.invokeP(__functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\EXTThreadLocalContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */