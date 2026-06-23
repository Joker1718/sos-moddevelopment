/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.LongBuffer;
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
/*    */ 
/*    */ 
/*    */ public class SOFTDeviceClock
/*    */ {
/*    */   public static final int ALC_DEVICE_CLOCK_SOFT = 5632;
/*    */   public static final int ALC_DEVICE_LATENCY_SOFT = 5633;
/*    */   public static final int ALC_DEVICE_CLOCK_LATENCY_SOFT = 5634;
/*    */   public static final int AL_SAMPLE_OFFSET_CLOCK_SOFT = 4610;
/*    */   public static final int AL_SEC_OFFSET_CLOCK_SOFT = 4611;
/*    */   
/*    */   protected SOFTDeviceClock() {
/* 29 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nalcGetInteger64vSOFT(long device, int pname, int size, long values) {
/* 36 */     long __functionAddress = (ALC.getICD()).alcGetInteger64vSOFT;
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.check(__functionAddress);
/*    */     }
/* 40 */     JNI.invokePPV(device, pname, size, values, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid")
/*    */   public static void alcGetInteger64vSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCenum") int pname, @NativeType("ALCint64SOFT *") LongBuffer values) {
/* 46 */     nalcGetInteger64vSOFT(device, pname, values.remaining(), MemoryUtil.memAddress(values));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid")
/*    */   public static long alcGetInteger64vSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCenum") int pname) {
/* 52 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*    */     try {
/* 54 */       LongBuffer values = stack.callocLong(1);
/* 55 */       nalcGetInteger64vSOFT(device, pname, 1, MemoryUtil.memAddress(values));
/* 56 */       return values.get(0);
/*    */     } finally {
/* 58 */       stack.setPointer(stackPointer);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid")
/*    */   public static void alcGetInteger64vSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCenum") int pname, @NativeType("ALCint64SOFT *") long[] values) {
/* 65 */     long __functionAddress = (ALC.getICD()).alcGetInteger64vSOFT;
/* 66 */     if (Checks.CHECKS) {
/* 67 */       Checks.check(__functionAddress);
/*    */     }
/* 69 */     JNI.invokePPV(device, pname, values.length, values, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTDeviceClock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */