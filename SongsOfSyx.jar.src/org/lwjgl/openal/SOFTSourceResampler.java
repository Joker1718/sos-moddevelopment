/*    */ package org.lwjgl.openal;
/*    */ 
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
/*    */ public class SOFTSourceResampler
/*    */ {
/*    */   public static final int AL_NUM_RESAMPLERS_SOFT = 4624;
/*    */   public static final int AL_DEFAULT_RESAMPLER_SOFT = 4625;
/*    */   public static final int AL_SOURCE_RESAMPLER_SOFT = 4626;
/*    */   public static final int AL_RESAMPLER_NAME_SOFT = 4627;
/*    */   
/*    */   protected SOFTSourceResampler() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nalGetStringiSOFT(int pname, int index) {
/* 34 */     long __functionAddress = (AL.getICD()).alGetStringiSOFT;
/* 35 */     if (Checks.CHECKS) {
/* 36 */       Checks.check(__functionAddress);
/*    */     }
/* 38 */     return JNI.invokeP(pname, index, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALchar const *")
/*    */   public static String alGetStringiSOFT(@NativeType("ALenum") int pname, @NativeType("ALsizei") int index) {
/* 44 */     long __result = nalGetStringiSOFT(pname, index);
/* 45 */     return MemoryUtil.memUTF8Safe(__result);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nalGetStringiDirectSOFT(long context, int pname, int index) {
/* 52 */     long __functionAddress = (AL.getICD()).alGetStringiDirectSOFT;
/* 53 */     if (Checks.CHECKS) {
/* 54 */       Checks.check(__functionAddress);
/* 55 */       Checks.check(context);
/*    */     } 
/* 57 */     return JNI.invokePP(context, pname, index, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALchar const *")
/*    */   public static String alGetStringiDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int pname, @NativeType("ALsizei") int index) {
/* 63 */     long __result = nalGetStringiDirectSOFT(context, pname, index);
/* 64 */     return MemoryUtil.memUTF8Safe(__result);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTSourceResampler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */