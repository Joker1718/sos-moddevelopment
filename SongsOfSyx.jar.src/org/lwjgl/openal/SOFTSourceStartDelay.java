/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOFTSourceStartDelay
/*     */ {
/*     */   protected SOFTSourceStartDelay() {
/*  19 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcePlayAtTimeSOFT(@NativeType("ALuint") int source, @NativeType("ALint64SOFT") long start_time) {
/*  27 */     long __functionAddress = (AL.getICD()).alSourcePlayAtTimeSOFT;
/*  28 */     if (Checks.CHECKS) {
/*  29 */       Checks.check(__functionAddress);
/*     */     }
/*  31 */     JNI.invokeJV(source, start_time, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcePlayAtTimeDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALint64SOFT") long start_time) {
/*  39 */     long __functionAddress = (AL.getICD()).alSourcePlayAtTimeDirectSOFT;
/*  40 */     if (Checks.CHECKS) {
/*  41 */       Checks.check(__functionAddress);
/*  42 */       Checks.check(context);
/*     */     } 
/*  44 */     JNI.invokePJV(context, source, start_time, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcePlayAtTimevSOFT(int n, long sources, long start_time) {
/*  51 */     long __functionAddress = (AL.getICD()).alSourcePlayAtTimevSOFT;
/*  52 */     if (Checks.CHECKS) {
/*  53 */       Checks.check(__functionAddress);
/*     */     }
/*  55 */     JNI.invokePJV(n, sources, start_time, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcePlayAtTimevSOFT(@NativeType("ALuint const *") IntBuffer sources, @NativeType("ALint64SOFT") long start_time) {
/*  61 */     nalSourcePlayAtTimevSOFT(sources.remaining(), MemoryUtil.memAddress(sources), start_time);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcePlayAtTimevDirectSOFT(long context, int n, long sources, long start_time) {
/*  68 */     long __functionAddress = (AL.getICD()).alSourcePlayAtTimevDirectSOFT;
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(__functionAddress);
/*  71 */       Checks.check(context);
/*     */     } 
/*  73 */     JNI.invokePPJV(context, n, sources, start_time, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcePlayAtTimevDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") IntBuffer sources, @NativeType("ALint64SOFT") long start_time) {
/*  79 */     nalSourcePlayAtTimevDirectSOFT(context, sources.remaining(), MemoryUtil.memAddress(sources), start_time);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcePlayAtTimevSOFT(@NativeType("ALuint const *") int[] sources, @NativeType("ALint64SOFT") long start_time) {
/*  85 */     long __functionAddress = (AL.getICD()).alSourcePlayAtTimevSOFT;
/*  86 */     if (Checks.CHECKS) {
/*  87 */       Checks.check(__functionAddress);
/*     */     }
/*  89 */     JNI.invokePJV(sources.length, sources, start_time, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcePlayAtTimevDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") int[] sources, @NativeType("ALint64SOFT") long start_time) {
/*  95 */     long __functionAddress = (AL.getICD()).alSourcePlayAtTimevDirectSOFT;
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(__functionAddress);
/*  98 */       Checks.check(context);
/*     */     } 
/* 100 */     JNI.invokePPJV(context, sources.length, sources, start_time, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTSourceStartDelay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */