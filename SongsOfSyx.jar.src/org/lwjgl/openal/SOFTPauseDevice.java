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
/*    */ public class SOFTPauseDevice
/*    */ {
/*    */   protected SOFTPauseDevice() {
/* 16 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid")
/*    */   public static void alcDevicePauseSOFT(@NativeType("ALCdevice *") long device) {
/* 24 */     long __functionAddress = (ALC.getICD()).alcDevicePauseSOFT;
/* 25 */     if (Checks.CHECKS) {
/* 26 */       Checks.check(__functionAddress);
/* 27 */       Checks.check(device);
/*    */     } 
/* 29 */     JNI.invokePV(device, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid")
/*    */   public static void alcDeviceResumeSOFT(@NativeType("ALCdevice *") long device) {
/* 37 */     long __functionAddress = (ALC.getICD()).alcDeviceResumeSOFT;
/* 38 */     if (Checks.CHECKS) {
/* 39 */       Checks.check(__functionAddress);
/* 40 */       Checks.check(device);
/*    */     } 
/* 42 */     JNI.invokePV(device, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTPauseDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */