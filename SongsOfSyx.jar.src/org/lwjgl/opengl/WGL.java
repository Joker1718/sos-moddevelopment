/*     */ package org.lwjgl.opengl;public class WGL { public static final int WGL_FONT_LINES = 0; public static final int WGL_FONT_POLYGONS = 1; public static final int WGL_SWAP_MAIN_PLANE = 1; public static final int WGL_SWAP_OVERLAY1 = 2; public static final int WGL_SWAP_OVERLAY2 = 4;
/*     */   public static final int WGL_SWAP_OVERLAY3 = 8;
/*     */   public static final int WGL_SWAP_OVERLAY4 = 16;
/*     */   public static final int WGL_SWAP_OVERLAY5 = 32;
/*     */   public static final int WGL_SWAP_OVERLAY6 = 64;
/*     */   public static final int WGL_SWAP_OVERLAY7 = 128;
/*     */   public static final int WGL_SWAP_OVERLAY8 = 256;
/*     */   public static final int WGL_SWAP_OVERLAY9 = 512;
/*     */   public static final int WGL_SWAP_OVERLAY10 = 1024;
/*     */   public static final int WGL_SWAP_OVERLAY11 = 2048;
/*     */   public static final int WGL_SWAP_OVERLAY12 = 4096;
/*     */   public static final int WGL_SWAP_OVERLAY13 = 8192;
/*     */   public static final int WGL_SWAP_OVERLAY14 = 16384;
/*     */   public static final int WGL_SWAP_OVERLAY15 = 32768;
/*     */   public static final int WGL_SWAP_UNDERLAY1 = 65536;
/*     */   public static final int WGL_SWAP_UNDERLAY2 = 131072;
/*     */   public static final int WGL_SWAP_UNDERLAY3 = 262144;
/*     */   public static final int WGL_SWAP_UNDERLAY4 = 524288;
/*     */   public static final int WGL_SWAP_UNDERLAY5 = 1048576;
/*     */   public static final int WGL_SWAP_UNDERLAY6 = 2097152;
/*     */   public static final int WGL_SWAP_UNDERLAY7 = 4194304;
/*     */   
/*     */   static {
/*  24 */     GL.initialize();
/*     */   }
/*     */   public static final int WGL_SWAP_UNDERLAY8 = 8388608; public static final int WGL_SWAP_UNDERLAY9 = 16777216; public static final int WGL_SWAP_UNDERLAY10 = 33554432;
/*     */   public static final int WGL_SWAP_UNDERLAY11 = 67108864;
/*     */   public static final int WGL_SWAP_UNDERLAY12 = 134217728;
/*     */   public static final int WGL_SWAP_UNDERLAY13 = 268435456;
/*     */   public static final int WGL_SWAP_UNDERLAY14 = 536870912;
/*     */   public static final int WGL_SWAP_UNDERLAY15 = 1073741824;
/*     */   
/*  33 */   public static final class Functions { public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCreateContext");
/*  34 */     public static final long CreateLayerContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCreateLayerContext");
/*  35 */     public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCopyContext");
/*  36 */     public static final long DeleteContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglDeleteContext");
/*  37 */     public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetCurrentContext");
/*  38 */     public static final long GetCurrentDC = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetCurrentDC");
/*  39 */     public static final long GetProcAddress = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetProcAddress");
/*  40 */     public static final long MakeCurrent = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglMakeCurrent");
/*  41 */     public static final long ShareLists = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglShareLists"); }
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
/*     */   protected WGL() {
/*  83 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreateContext(long _GetLastError, long hdc) {
/*  93 */     long __functionAddress = Functions.CreateContext;
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.check(hdc);
/*     */     }
/*  97 */     return nwglCreateContext(_GetLastError, hdc, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateContext(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc) {
/* 103 */     if (Checks.CHECKS) {
/* 104 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 106 */     return nwglCreateContext(MemoryUtil.memAddressSafe(_GetLastError), hdc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreateLayerContext(long _GetLastError, long hdc, int layerPlane) {
/* 116 */     long __functionAddress = Functions.CreateLayerContext;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(hdc);
/*     */     }
/* 120 */     return nwglCreateLayerContext(_GetLastError, hdc, layerPlane, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateLayerContext(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc, int layerPlane) {
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 129 */     return nwglCreateLayerContext(MemoryUtil.memAddressSafe(_GetLastError), hdc, layerPlane);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglCopyContext(long _GetLastError, long src, long dst, int mask) {
/* 139 */     long __functionAddress = Functions.CopyContext;
/* 140 */     if (Checks.CHECKS) {
/* 141 */       Checks.check(src);
/* 142 */       Checks.check(dst);
/*     */     } 
/* 144 */     return nwglCopyContext(_GetLastError, src, dst, mask, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglCopyContext(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HGLRC") long src, @NativeType("HGLRC") long dst, @NativeType("UINT") int mask) {
/* 150 */     if (Checks.CHECKS) {
/* 151 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 153 */     return (nwglCopyContext(MemoryUtil.memAddressSafe(_GetLastError), src, dst, mask) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglDeleteContext(long _GetLastError, long context) {
/* 163 */     long __functionAddress = Functions.DeleteContext;
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(context);
/*     */     }
/* 167 */     return nwglDeleteContext(_GetLastError, context, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDeleteContext(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HGLRC") long context) {
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 176 */     return (nwglDeleteContext(MemoryUtil.memAddressSafe(_GetLastError), context) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglGetCurrentContext(long _GetLastError) {
/* 186 */     long __functionAddress = Functions.GetCurrentContext;
/* 187 */     return nwglGetCurrentContext(_GetLastError, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglGetCurrentContext(@NativeType("DWORD *") IntBuffer _GetLastError) {
/* 193 */     if (Checks.CHECKS) {
/* 194 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 196 */     return nwglGetCurrentContext(MemoryUtil.memAddressSafe(_GetLastError));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HDC")
/*     */   public static long wglGetCurrentDC() {
/* 204 */     long __functionAddress = Functions.GetCurrentDC;
/* 205 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglGetProcAddress(long _GetLastError, long proc) {
/* 215 */     long __functionAddress = Functions.GetProcAddress;
/* 216 */     return nwglGetProcAddress(_GetLastError, proc, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("PROC")
/*     */   public static long wglGetProcAddress(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPCSTR") ByteBuffer proc) {
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.checkSafe(_GetLastError, 1);
/* 224 */       Checks.checkNT1(proc);
/*     */     } 
/* 226 */     return nwglGetProcAddress(MemoryUtil.memAddressSafe(_GetLastError), MemoryUtil.memAddress(proc));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("PROC")
/*     */   public static long wglGetProcAddress(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("LPCSTR") CharSequence proc) {
/* 232 */     if (Checks.CHECKS) {
/* 233 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 235 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 237 */       stack.nASCII(proc, true);
/* 238 */       long procEncoded = stack.getPointerAddress();
/* 239 */       return nwglGetProcAddress(MemoryUtil.memAddressSafe(_GetLastError), procEncoded);
/*     */     } finally {
/* 241 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglMakeCurrent(long _GetLastError, long hdc, long hglrc) {
/* 252 */     long __functionAddress = Functions.MakeCurrent;
/* 253 */     return nwglMakeCurrent(_GetLastError, hdc, hglrc, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglMakeCurrent(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc, @NativeType("HGLRC") long hglrc) {
/* 259 */     if (Checks.CHECKS) {
/* 260 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 262 */     return (nwglMakeCurrent(MemoryUtil.memAddressSafe(_GetLastError), hdc, hglrc) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglShareLists(long _GetLastError, long hglrc1, long hglrc2) {
/* 272 */     long __functionAddress = Functions.ShareLists;
/* 273 */     if (Checks.CHECKS) {
/* 274 */       Checks.check(hglrc1);
/* 275 */       Checks.check(hglrc2);
/*     */     } 
/* 277 */     return nwglShareLists(_GetLastError, hglrc1, hglrc2, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglShareLists(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HGLRC") long hglrc1, @NativeType("HGLRC") long hglrc2) {
/* 283 */     if (Checks.CHECKS) {
/* 284 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 286 */     return (nwglShareLists(MemoryUtil.memAddressSafe(_GetLastError), hglrc1, hglrc2) != 0);
/*     */   }
/*     */   
/*     */   public static native long nwglCreateContext(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nwglCreateLayerContext(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*     */   
/*     */   public static native int nwglCopyContext(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
/*     */   
/*     */   public static native int nwglDeleteContext(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nwglGetCurrentContext(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nwglGetProcAddress(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nwglMakeCurrent(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nwglShareLists(long paramLong1, long paramLong2, long paramLong3, long paramLong4); }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */