/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SOFTHRTF
/*    */ {
/*    */   public static final int ALC_HRTF_SOFT = 6546;
/*    */   public static final int ALC_HRTF_ID_SOFT = 6550;
/*    */   public static final int ALC_DONT_CARE_SOFT = 2;
/*    */   public static final int ALC_HRTF_STATUS_SOFT = 6547;
/*    */   public static final int ALC_NUM_HRTF_SPECIFIERS_SOFT = 6548;
/*    */   public static final int ALC_HRTF_SPECIFIER_SOFT = 6549;
/*    */   public static final int ALC_HRTF_DISABLED_SOFT = 0;
/*    */   public static final int ALC_HRTF_ENABLED_SOFT = 1;
/*    */   public static final int ALC_HRTF_DENIED_SOFT = 2;
/*    */   public static final int ALC_HRTF_REQUIRED_SOFT = 3;
/*    */   public static final int ALC_HRTF_HEADPHONES_DETECTED_SOFT = 4;
/*    */   public static final int ALC_HRTF_UNSUPPORTED_FORMAT_SOFT = 5;
/*    */   
/*    */   protected SOFTHRTF() {
/* 41 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nalcGetStringiSOFT(long device, int paramName, int index) {
/* 48 */     long __functionAddress = (ALC.getICD()).alcGetStringiSOFT;
/* 49 */     if (Checks.CHECKS) {
/* 50 */       Checks.check(__functionAddress);
/* 51 */       Checks.check(device);
/*    */     } 
/* 53 */     return JNI.invokePP(device, paramName, index, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCchar const *")
/*    */   public static String alcGetStringiSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCenum") int paramName, @NativeType("ALCsizei") int index) {
/* 59 */     long __result = nalcGetStringiSOFT(device, paramName, index);
/* 60 */     return MemoryUtil.memUTF8Safe(__result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean nalcResetDeviceSOFT(long device, long attrList) {
/* 67 */     long __functionAddress = (ALC.getICD()).alcResetDeviceSOFT;
/* 68 */     if (Checks.CHECKS) {
/* 69 */       Checks.check(__functionAddress);
/* 70 */       Checks.check(device);
/*    */     } 
/* 72 */     return JNI.invokePPZ(device, attrList, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcResetDeviceSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCint const *") IntBuffer attrList) {
/* 78 */     if (Checks.CHECKS) {
/* 79 */       Checks.checkNTSafe(attrList);
/*    */     }
/* 81 */     return nalcResetDeviceSOFT(device, MemoryUtil.memAddressSafe(attrList));
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcResetDeviceSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCint const *") int[] attrList) {
/* 87 */     long __functionAddress = (ALC.getICD()).alcResetDeviceSOFT;
/* 88 */     if (Checks.CHECKS) {
/* 89 */       Checks.check(__functionAddress);
/* 90 */       Checks.check(device);
/* 91 */       Checks.checkNTSafe(attrList);
/*    */     } 
/* 93 */     return JNI.invokePPZ(device, attrList, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTHRTF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */