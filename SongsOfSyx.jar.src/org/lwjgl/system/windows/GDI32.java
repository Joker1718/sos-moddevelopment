/*     */ package org.lwjgl.system.windows;public class GDI32 { public static final int DISPLAY_DEVICE_ATTACHED_TO_DESKTOP = 1;
/*     */   public static final int DISPLAY_DEVICE_MULTI_DRIVER = 2;
/*     */   public static final int DISPLAY_DEVICE_PRIMARY_DEVICE = 4;
/*     */   public static final int DISPLAY_DEVICE_MIRRORING_DRIVER = 8;
/*     */   public static final int DISPLAY_DEVICE_VGA_COMPATIBLE = 16;
/*     */   public static final int DISPLAY_DEVICE_REMOVABLE = 32;
/*     */   public static final int DISPLAY_DEVICE_MODESPRUNED = 134217728;
/*     */   public static final int DISPLAY_DEVICE_REMOTE = 67108864;
/*     */   public static final int DISPLAY_DEVICE_DISCONNECT = 33554432;
/*     */   public static final int DISPLAY_DEVICE_TS_COMPATIBLE = 2097152;
/*     */   public static final int DISPLAY_DEVICE_UNSAFE_MODES_ON = 524288;
/*     */   public static final int DISPLAY_DEVICE_ACTIVE = 1;
/*     */   public static final int DISPLAY_DEVICE_ATTACHED = 2;
/*     */   public static final int DM_SPECVERSION = 1025;
/*     */   public static final int DM_ORIENTATION = 1;
/*     */   public static final int DM_PAPERSIZE = 2;
/*     */   public static final int DM_PAPERLENGTH = 4;
/*     */   public static final int DM_PAPERWIDTH = 8;
/*     */   public static final int DM_SCALE = 16;
/*  20 */   private static final SharedLibrary GDI32 = Library.loadNative(GDI32.class, "org.lwjgl", "gdi32"); public static final int DM_POSITION = 32; public static final int DM_NUP = 64; public static final int DM_DISPLAYORIENTATION = 128; public static final int DM_COPIES = 256; public static final int DM_DEFAULTSOURCE = 512; public static final int DM_PRINTQUALITY = 1024; public static final int DM_COLOR = 2048; public static final int DM_DUPLEX = 4096; public static final int DM_YRESOLUTION = 8192; public static final int DM_TTOPTION = 16384; public static final int DM_COLLATE = 32768; public static final int DM_FORMNAME = 65536; public static final int DM_LOGPIXELS = 131072; public static final int DM_BITSPERPEL = 262144; public static final int DM_PELSWIDTH = 524288; public static final int DM_PELSHEIGHT = 1048576; public static final int DM_DISPLAYFLAGS = 2097152; public static final int DM_DISPLAYFREQUENCY = 4194304; public static final int DM_ICMMETHOD = 8388608; public static final int DM_ICMINTENT = 16777216; public static final int DM_MEDIATYPE = 33554432; public static final int DM_DITHERTYPE = 67108864; public static final int DM_PANNINGWIDTH = 134217728; public static final int DM_PANNINGHEIGHT = 268435456; public static final int DM_DISPLAYFIXEDOUTPUT = 536870912; public static final int DMDO_DEFAULT = 0; public static final int DMDO_90 = 1; public static final int DMDO_180 = 2; public static final int DMDO_270 = 3; public static final int DMDFO_DEFAULT = 0; public static final int DMDFO_STRETCH = 1; public static final int DMDFO_CENTER = 2; public static final int DM_INTERLACED = 2; public static final int DMDISPLAYFLAGS_TEXTMODE = 4; public static final int PFD_DOUBLEBUFFER = 1; public static final int PFD_STEREO = 2; public static final int PFD_DRAW_TO_WINDOW = 4; public static final int PFD_DRAW_TO_BITMAP = 8; public static final int PFD_SUPPORT_GDI = 16; public static final int PFD_SUPPORT_OPENGL = 32; public static final int PFD_GENERIC_FORMAT = 64; public static final int PFD_NEED_PALETTE = 128; public static final int PFD_NEED_SYSTEM_PALETTE = 256; public static final int PFD_SWAP_EXCHANGE = 512; public static final int PFD_SWAP_COPY = 1024; public static final int PFD_SWAP_LAYER_BUFFERS = 2048; public static final int PFD_GENERIC_ACCELERATED = 4096; public static final int PFD_SUPPORT_DIRECTDRAW = 8192; public static final int PFD_DIRECT3D_ACCELERATED = 16384; public static final int PFD_SUPPORT_COMPOSITION = 32768; public static final int PFD_DEPTH_DONTCARE = 536870912;
/*     */   public static final int PFD_DOUBLEBUFFER_DONTCARE = 1073741824;
/*     */   public static final int PFD_STEREO_DONTCARE = -2147483648;
/*     */   public static final byte PFD_TYPE_RGBA = 0;
/*     */   public static final byte PFD_TYPE_COLORINDEX = 1;
/*     */   public static final byte PFD_MAIN_PLANE = 0;
/*     */   public static final byte PFD_OVERLAY_PLANE = 1;
/*     */   public static final byte PFD_UNDERLAY_PLANE = -1;
/*     */   
/*  29 */   public static final class Functions { public static final long ChoosePixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "ChoosePixelFormat");
/*  30 */     public static final long DescribePixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "DescribePixelFormat");
/*  31 */     public static final long GetPixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "GetPixelFormat");
/*  32 */     public static final long SetPixelFormat = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "SetPixelFormat");
/*  33 */     public static final long SwapBuffers = APIUtil.apiGetFunctionAddress((FunctionProvider)GDI32.GDI32, "SwapBuffers"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  39 */     return GDI32;
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
/*     */ 
/*     */   
/*     */   protected GDI32() {
/* 139 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nChoosePixelFormat(long _GetLastError, long hdc, long pixelFormatDescriptor) {
/* 149 */     long __functionAddress = Functions.ChoosePixelFormat;
/* 150 */     if (Checks.CHECKS) {
/* 151 */       Checks.check(hdc);
/*     */     }
/* 153 */     return nChoosePixelFormat(_GetLastError, hdc, pixelFormatDescriptor, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int ChoosePixelFormat(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc, @NativeType("PIXELFORMATDESCRIPTOR const *") PIXELFORMATDESCRIPTOR pixelFormatDescriptor) {
/* 158 */     if (Checks.CHECKS) {
/* 159 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 161 */     return nChoosePixelFormat(MemoryUtil.memAddressSafe(_GetLastError), hdc, pixelFormatDescriptor.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nDescribePixelFormat(long _GetLastError, long hdc, int pixelFormat, int bytes, long pixelFormatDescriptor) {
/* 171 */     long __functionAddress = Functions.DescribePixelFormat;
/* 172 */     if (Checks.CHECKS) {
/* 173 */       Checks.check(hdc);
/*     */     }
/* 175 */     return nDescribePixelFormat(_GetLastError, hdc, pixelFormat, bytes, pixelFormatDescriptor, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int DescribePixelFormat(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc, int pixelFormat, @NativeType("UINT") int bytes, @NativeType("LPPIXELFORMATDESCRIPTOR") PIXELFORMATDESCRIPTOR pixelFormatDescriptor) {
/* 180 */     if (Checks.CHECKS) {
/* 181 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 183 */     return nDescribePixelFormat(MemoryUtil.memAddressSafe(_GetLastError), hdc, pixelFormat, bytes, MemoryUtil.memAddressSafe((Pointer)pixelFormatDescriptor));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int DescribePixelFormat(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc, int pixelFormat, @NativeType("LPPIXELFORMATDESCRIPTOR") PIXELFORMATDESCRIPTOR pixelFormatDescriptor) {
/* 188 */     if (Checks.CHECKS) {
/* 189 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 191 */     return nDescribePixelFormat(MemoryUtil.memAddressSafe(_GetLastError), hdc, pixelFormat, PIXELFORMATDESCRIPTOR.SIZEOF, MemoryUtil.memAddressSafe((Pointer)pixelFormatDescriptor));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nGetPixelFormat(long _GetLastError, long hdc) {
/* 201 */     long __functionAddress = Functions.GetPixelFormat;
/* 202 */     if (Checks.CHECKS) {
/* 203 */       Checks.check(hdc);
/*     */     }
/* 205 */     return nGetPixelFormat(_GetLastError, hdc, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int GetPixelFormat(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc) {
/* 210 */     if (Checks.CHECKS) {
/* 211 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 213 */     return nGetPixelFormat(MemoryUtil.memAddressSafe(_GetLastError), hdc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nSetPixelFormat(long _GetLastError, long hdc, int pixelFormat, long pixelFormatDescriptor) {
/* 223 */     long __functionAddress = Functions.SetPixelFormat;
/* 224 */     if (Checks.CHECKS) {
/* 225 */       Checks.check(hdc);
/*     */     }
/* 227 */     return nSetPixelFormat(_GetLastError, hdc, pixelFormat, pixelFormatDescriptor, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean SetPixelFormat(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long hdc, int pixelFormat, @NativeType("PIXELFORMATDESCRIPTOR const *") PIXELFORMATDESCRIPTOR pixelFormatDescriptor) {
/* 233 */     if (Checks.CHECKS) {
/* 234 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 236 */     return (nSetPixelFormat(MemoryUtil.memAddressSafe(_GetLastError), hdc, pixelFormat, MemoryUtil.memAddressSafe((Pointer)pixelFormatDescriptor)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nSwapBuffers(long _GetLastError, long dc) {
/* 246 */     long __functionAddress = Functions.SwapBuffers;
/* 247 */     if (Checks.CHECKS) {
/* 248 */       Checks.check(dc);
/*     */     }
/* 250 */     return nSwapBuffers(_GetLastError, dc, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean SwapBuffers(@NativeType("DWORD *") IntBuffer _GetLastError, @NativeType("HDC") long dc) {
/* 256 */     if (Checks.CHECKS) {
/* 257 */       Checks.checkSafe(_GetLastError, 1);
/*     */     }
/* 259 */     return (nSwapBuffers(MemoryUtil.memAddressSafe(_GetLastError), dc) != 0);
/*     */   }
/*     */   
/*     */   public static native int nChoosePixelFormat(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nDescribePixelFormat(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nGetPixelFormat(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nSetPixelFormat(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nSwapBuffers(long paramLong1, long paramLong2, long paramLong3); }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\GDI32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */