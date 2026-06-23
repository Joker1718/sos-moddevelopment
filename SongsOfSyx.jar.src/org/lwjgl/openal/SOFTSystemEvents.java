/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ import org.lwjgl.system.Pointer;
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
/*    */ public class SOFTSystemEvents
/*    */ {
/*    */   public static final int ALC_EVENT_TYPE_DEFAULT_DEVICE_CHANGED_SOFT = 6614;
/*    */   public static final int ALC_EVENT_TYPE_DEVICE_ADDED_SOFT = 6615;
/*    */   public static final int ALC_EVENT_TYPE_DEVICE_REMOVED_SOFT = 6616;
/*    */   public static final int ALC_PLAYBACK_DEVICE_SOFT = 6612;
/*    */   public static final int ALC_CAPTURE_DEVICE_SOFT = 6613;
/*    */   public static final int ALC_EVENT_SUPPORTED_SOFT = 6617;
/*    */   public static final int ALC_EVENT_NOT_SUPPORTED_SOFT = 6618;
/*    */   
/*    */   protected SOFTSystemEvents() {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALCenum")
/*    */   public static int alcEventIsSupportedSOFT(@NativeType("ALCenum") int eventType, @NativeType("ALCenum") int deviceType) {
/* 42 */     long __functionAddress = (ALC.getICD()).alcEventIsSupportedSOFT;
/* 43 */     if (Checks.CHECKS) {
/* 44 */       Checks.check(__functionAddress);
/*    */     }
/* 46 */     return JNI.invokeI(eventType, deviceType, __functionAddress);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean nalcEventControlSOFT(int count, long events, boolean enable) {
/* 53 */     long __functionAddress = (ALC.getICD()).alcEventControlSOFT;
/* 54 */     if (Checks.CHECKS) {
/* 55 */       Checks.check(__functionAddress);
/*    */     }
/* 57 */     return JNI.invokePZ(count, events, enable, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcEventControlSOFT(@NativeType("ALCenum const *") IntBuffer events, @NativeType("ALCboolean") boolean enable) {
/* 63 */     return nalcEventControlSOFT(Checks.remainingSafe(events), MemoryUtil.memAddressSafe(events), enable);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nalcEventCallbackSOFT(long callback, long userParam) {
/* 70 */     long __functionAddress = (ALC.getICD()).alcEventCallbackSOFT;
/* 71 */     if (Checks.CHECKS) {
/* 72 */       Checks.check(__functionAddress);
/*    */     }
/* 74 */     JNI.invokePPV(callback, userParam, __functionAddress);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCvoid")
/*    */   public static void alcEventCallbackSOFT(@NativeType("ALCEVENTPROCTYPESOFT") SOFTSystemEventProcI callback, @NativeType("ALCvoid *") long userParam) {
/* 80 */     nalcEventCallbackSOFT(MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcEventControlSOFT(@NativeType("ALCenum const *") int[] events, @NativeType("ALCboolean") boolean enable) {
/* 86 */     long __functionAddress = (ALC.getICD()).alcEventControlSOFT;
/* 87 */     if (Checks.CHECKS) {
/* 88 */       Checks.check(__functionAddress);
/*    */     }
/* 90 */     return JNI.invokePZ(Checks.lengthSafe(events), events, enable, __functionAddress);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTSystemEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */