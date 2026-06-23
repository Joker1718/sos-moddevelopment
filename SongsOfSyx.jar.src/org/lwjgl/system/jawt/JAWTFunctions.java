/*     */ package org.lwjgl.system.jawt;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Frame;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ 
/*     */ 
/*     */ public class JAWTFunctions
/*     */ {
/*     */   public static final int JAWT_VERSION_1_3 = 65539;
/*     */   public static final int JAWT_VERSION_1_4 = 65540;
/*  21 */   private static final SharedLibrary JAWT = Library.loadNative(JAWTFunctions.class, "org.lwjgl.jawt", Configuration.JAWT_LIBRARY_NAME, new String[] { "jawt", APIUtil.apiFindLibrary(System.getProperty("java.home"), "jawt") });
/*     */   public static final int JAWT_VERSION_1_7 = 65543;
/*     */   public static final int JAWT_VERSION_9 = 589824;
/*     */   public static final int JAWT_MACOSX_USE_CALAYER = -2147483648;
/*     */   public static final int JAWT_LOCK_ERROR = 1;
/*     */   public static final int JAWT_LOCK_CLIP_CHANGED = 2;
/*     */   public static final int JAWT_LOCK_BOUNDS_CHANGED = 4;
/*     */   public static final int JAWT_LOCK_SURFACE_CHANGED = 8;
/*     */   
/*  30 */   public static final class Functions { public static final long GetAWT = APIUtil.apiGetFunctionAddress((FunctionProvider)JAWTFunctions.JAWT, (Pointer.BITS64 || Platform.get() != Platform.WINDOWS) ? "JAWT_GetAWT" : "_JAWT_GetAWT@8"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  36 */     return JAWT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected JAWTFunctions() {
/*  54 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nJAWT_GetAWT(long awt) {
/*  64 */     long __functionAddress = Functions.GetAWT;
/*  65 */     return nJAWT_GetAWT(awt, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("jboolean")
/*     */   public static boolean JAWT_GetAWT(@NativeType("JAWT *") JAWT awt) {
/*  71 */     return nJAWT_GetAWT(awt.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nJAWT_DrawingSurface_Lock(long ds, long __functionAddress) {
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.check(__functionAddress);
/*     */     }
/*  81 */     return JNI.callPI(ds, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("jint")
/*     */   public static int JAWT_DrawingSurface_Lock(@NativeType("JAWT_DrawingSurface *") JAWTDrawingSurface ds, @NativeType("void *") long __functionAddress) {
/*  87 */     return nJAWT_DrawingSurface_Lock(ds.address(), __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nJAWT_DrawingSurface_GetDrawingSurfaceInfo(long ds, long __functionAddress) {
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.check(__functionAddress);
/*     */     }
/*  97 */     return JNI.callPP(ds, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("JAWT_DrawingSurfaceInfo *")
/*     */   public static JAWTDrawingSurfaceInfo JAWT_DrawingSurface_GetDrawingSurfaceInfo(@NativeType("JAWT_DrawingSurface *") JAWTDrawingSurface ds, @NativeType("void *") long __functionAddress) {
/* 103 */     long __result = nJAWT_DrawingSurface_GetDrawingSurfaceInfo(ds.address(), __functionAddress);
/* 104 */     return JAWTDrawingSurfaceInfo.createSafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nJAWT_DrawingSurface_FreeDrawingSurfaceInfo(long dsi, long __functionAddress) {
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.check(__functionAddress);
/*     */     }
/* 114 */     JNI.callPV(dsi, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void JAWT_DrawingSurface_FreeDrawingSurfaceInfo(@NativeType("JAWT_DrawingSurfaceInfo *") JAWTDrawingSurfaceInfo dsi, @NativeType("void *") long __functionAddress) {
/* 119 */     nJAWT_DrawingSurface_FreeDrawingSurfaceInfo(dsi.address(), __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nJAWT_DrawingSurface_Unlock(long ds, long __functionAddress) {
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(__functionAddress);
/*     */     }
/* 129 */     JNI.callPV(ds, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void JAWT_DrawingSurface_Unlock(@NativeType("JAWT_DrawingSurface *") JAWTDrawingSurface ds, @NativeType("void *") long __functionAddress) {
/* 134 */     nJAWT_DrawingSurface_Unlock(ds.address(), __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("JAWT_DrawingSurface *")
/*     */   public static JAWTDrawingSurface JAWT_GetDrawingSurface(@NativeType("jobject") Object target, @NativeType("void *") long __functionAddress) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(__functionAddress);
/*     */     }
/* 148 */     long __result = nJAWT_GetDrawingSurface(target, __functionAddress);
/* 149 */     return JAWTDrawingSurface.createSafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nJAWT_FreeDrawingSurface(long ds, long __functionAddress) {
/* 156 */     if (Checks.CHECKS) {
/* 157 */       Checks.check(__functionAddress);
/*     */     }
/* 159 */     JNI.callPV(ds, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void JAWT_FreeDrawingSurface(@NativeType("JAWT_DrawingSurface *") JAWTDrawingSurface ds, @NativeType("void *") long __functionAddress) {
/* 164 */     nJAWT_FreeDrawingSurface(ds.address(), __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void JAWT_Lock(@NativeType("void *") long __functionAddress) {
/* 174 */     if (Checks.CHECKS) {
/* 175 */       Checks.check(__functionAddress);
/*     */     }
/* 177 */     nJAWT_Lock(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void JAWT_Unlock(@NativeType("void *") long __functionAddress) {
/* 187 */     if (Checks.CHECKS) {
/* 188 */       Checks.check(__functionAddress);
/*     */     }
/* 190 */     nJAWT_Unlock(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jobject")
/*     */   public static Component JAWT_GetComponent(@NativeType("void *") long platformInfo, @NativeType("void *") long __functionAddress) {
/* 201 */     if (Checks.CHECKS) {
/* 202 */       Checks.check(platformInfo);
/* 203 */       Checks.check(__functionAddress);
/*     */     } 
/* 205 */     return nJAWT_GetComponent(platformInfo, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jobject")
/*     */   public static Frame JAWT_CreateEmbeddedFrame(@NativeType("void *") long platformInfo, @NativeType("void *") long __functionAddress) {
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(platformInfo);
/* 218 */       Checks.check(__functionAddress);
/*     */     } 
/* 220 */     return nJAWT_CreateEmbeddedFrame(platformInfo, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void JAWT_SetBounds(@NativeType("jobject") Frame embeddedFrame, @NativeType("jint") int x, @NativeType("jint") int y, @NativeType("jint") int w, @NativeType("jint") int h, @NativeType("void *") long __functionAddress) {
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(__functionAddress);
/*     */     }
/* 233 */     nJAWT_SetBounds(embeddedFrame, x, y, w, h, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void JAWT_SynthesizeWindowActivation(@NativeType("jobject") Frame embeddedFrame, @NativeType("jboolean") boolean doActivate, @NativeType("void *") long __functionAddress) {
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(__functionAddress);
/*     */     }
/* 246 */     nJAWT_SynthesizeWindowActivation(embeddedFrame, doActivate, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native boolean nJAWT_GetAWT(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nJAWT_GetDrawingSurface(Object paramObject, long paramLong);
/*     */   
/*     */   public static native void nJAWT_Lock(long paramLong);
/*     */   
/*     */   public static native void nJAWT_Unlock(long paramLong);
/*     */   
/*     */   public static native Component nJAWT_GetComponent(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native Frame nJAWT_CreateEmbeddedFrame(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nJAWT_SetBounds(Frame paramFrame, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong);
/*     */   
/*     */   public static native void nJAWT_SynthesizeWindowActivation(Frame paramFrame, boolean paramBoolean, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jawt\JAWTFunctions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */