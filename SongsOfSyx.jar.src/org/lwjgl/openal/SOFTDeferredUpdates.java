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
/*    */ public class SOFTDeferredUpdates
/*    */ {
/*    */   public static final int AL_DEFERRED_UPDATES_SOFT = 49154;
/*    */   
/*    */   protected SOFTDeferredUpdates() {
/* 18 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alDeferUpdatesSOFT() {
/* 26 */     long __functionAddress = (AL.getICD()).alDeferUpdatesSOFT;
/* 27 */     if (Checks.CHECKS) {
/* 28 */       Checks.check(__functionAddress);
/*    */     }
/* 30 */     JNI.invokeV(__functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alDeferUpdatesDirectSOFT(@NativeType("ALCcontext *") long context) {
/* 38 */     long __functionAddress = (AL.getICD()).alDeferUpdatesDirectSOFT;
/* 39 */     if (Checks.CHECKS) {
/* 40 */       Checks.check(__functionAddress);
/* 41 */       Checks.check(context);
/*    */     } 
/* 43 */     JNI.invokePV(context, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alProcessUpdatesSOFT() {
/* 51 */     long __functionAddress = (AL.getICD()).alProcessUpdatesSOFT;
/* 52 */     if (Checks.CHECKS) {
/* 53 */       Checks.check(__functionAddress);
/*    */     }
/* 55 */     JNI.invokeV(__functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alProcessUpdatesDirectSOFT(@NativeType("ALCcontext *") long context) {
/* 63 */     long __functionAddress = (AL.getICD()).alProcessUpdatesDirectSOFT;
/* 64 */     if (Checks.CHECKS) {
/* 65 */       Checks.check(__functionAddress);
/* 66 */       Checks.check(context);
/*    */     } 
/* 68 */     JNI.invokePV(context, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTDeferredUpdates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */