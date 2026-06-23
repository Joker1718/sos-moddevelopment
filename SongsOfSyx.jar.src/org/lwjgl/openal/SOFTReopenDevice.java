/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryStack;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public class SOFTReopenDevice
/*    */ {
/*    */   protected SOFTReopenDevice() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean nalcReopenDeviceSOFT(long device, long deviceName, long attribs) {
/* 29 */     long __functionAddress = (ALC.getICD()).alcReopenDeviceSOFT;
/* 30 */     if (Checks.CHECKS) {
/* 31 */       Checks.check(__functionAddress);
/* 32 */       Checks.check(device);
/*    */     } 
/* 34 */     return JNI.invokePPPZ(device, deviceName, attribs, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCchar const *") ByteBuffer deviceName, @NativeType("ALCint const *") IntBuffer attribs) {
/* 40 */     if (Checks.CHECKS) {
/* 41 */       Checks.checkNT1Safe(deviceName);
/* 42 */       Checks.checkNTSafe(attribs);
/*    */     } 
/* 44 */     return nalcReopenDeviceSOFT(device, MemoryUtil.memAddressSafe(deviceName), MemoryUtil.memAddressSafe(attribs));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCchar const *") CharSequence deviceName, @NativeType("ALCint const *") IntBuffer attribs) {
/* 50 */     if (Checks.CHECKS) {
/* 51 */       Checks.checkNTSafe(attribs);
/*    */     }
/* 53 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 55 */       stack.nUTF8Safe(deviceName, true);
/* 56 */       long deviceNameEncoded = (deviceName == null) ? 0L : stack.getPointerAddress();
/* 57 */       return nalcReopenDeviceSOFT(device, deviceNameEncoded, MemoryUtil.memAddressSafe(attribs));
/*    */     } finally {
/* 59 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCchar const *") ByteBuffer deviceName, @NativeType("ALCint const *") int[] attribs) {
/* 66 */     long __functionAddress = (ALC.getICD()).alcReopenDeviceSOFT;
/* 67 */     if (Checks.CHECKS) {
/* 68 */       Checks.check(__functionAddress);
/* 69 */       Checks.check(device);
/* 70 */       Checks.checkNT1Safe(deviceName);
/* 71 */       Checks.checkNTSafe(attribs);
/*    */     } 
/* 73 */     return JNI.invokePPPZ(device, MemoryUtil.memAddressSafe(deviceName), attribs, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcReopenDeviceSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCchar const *") CharSequence deviceName, @NativeType("ALCint const *") int[] attribs) {
/* 79 */     long __functionAddress = (ALC.getICD()).alcReopenDeviceSOFT;
/* 80 */     if (Checks.CHECKS) {
/* 81 */       Checks.check(__functionAddress);
/* 82 */       Checks.check(device);
/* 83 */       Checks.checkNTSafe(attribs);
/*    */     } 
/* 85 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 87 */       stack.nUTF8Safe(deviceName, true);
/* 88 */       long deviceNameEncoded = (deviceName == null) ? 0L : stack.getPointerAddress();
/* 89 */       return JNI.invokePPPZ(device, deviceNameEncoded, attribs, __functionAddress);
/*    */     } finally {
/* 91 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTReopenDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */