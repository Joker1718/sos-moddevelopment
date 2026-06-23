/*      */ package org.lwjgl.opengl;public class CGL { public static final int kCGLPFAAllRenderers = 1; public static final int kCGLPFATripleBuffer = 3; public static final int kCGLPFADoubleBuffer = 5; public static final int kCGLPFAStereo = 6; public static final int kCGLPFAColorSize = 8; public static final int kCGLPFAAlphaSize = 11; public static final int kCGLPFADepthSize = 12; public static final int kCGLPFAStencilSize = 13; public static final int kCGLPFAMinimumPolicy = 51; public static final int kCGLPFAMaximumPolicy = 52; public static final int kCGLPFASampleBuffers = 55; public static final int kCGLPFASamples = 56; public static final int kCGLPFAColorFloat = 58; public static final int kCGLPFAMultisample = 59; public static final int kCGLPFASupersample = 60; public static final int kCGLPFASampleAlpha = 61; public static final int kCGLPFARendererID = 70; public static final int kCGLPFASingleRenderer = 71; public static final int kCGLPFANoRecovery = 72; public static final int kCGLPFAAccelerated = 73; public static final int kCGLPFAClosestPolicy = 74; public static final int kCGLPFABackingStore = 76; public static final int kCGLPFABackingVolatile = 77; public static final int kCGLPFADisplayMask = 84; public static final int kCGLPFAAllowOfflineRenderers = 96; public static final int kCGLPFAAcceleratedCompute = 97; public static final int kCGLPFAOpenGLProfile = 99; public static final int kCGLPFASupportsAutomaticGraphicsSwitching = 101; public static final int kCGLPFAVirtualScreenCount = 128; public static final int kCGLPFAAuxBuffers = 7; public static final int kCGLPFAAccumSize = 14; public static final int kCGLPFAOffScreen = 53; public static final int kCGLPFAAuxDepthStencil = 57; public static final int kCGLPFAWindow = 80; public static final int kCGLPFACompliant = 83; public static final int kCGLPFAPBuffer = 90; public static final int kCGLPFARemotePBuffer = 91; public static final int kCGLPFARobust = 75; public static final int kCGLPFAMPSafe = 78; public static final int kCGLPFAMultiScreen = 81; public static final int kCGLPFAFullScreen = 54; public static final int kCGLRPOffScreen = 53; public static final int kCGLRPRendererID = 70; public static final int kCGLRPAccelerated = 73; public static final int kCGLRPBackingStore = 76; public static final int kCGLRPWindow = 80; public static final int kCGLRPCompliant = 83; public static final int kCGLRPDisplayMask = 84; public static final int kCGLRPBufferModes = 100; public static final int kCGLRPColorModes = 103; public static final int kCGLRPAccumModes = 104; public static final int kCGLRPDepthModes = 105; public static final int kCGLRPStencilModes = 106; public static final int kCGLRPMaxAuxBuffers = 107; public static final int kCGLRPMaxSampleBuffers = 108; public static final int kCGLRPMaxSamples = 109; public static final int kCGLRPSampleModes = 110; public static final int kCGLRPSampleAlpha = 111; public static final int kCGLRPVideoMemory = 120; public static final int kCGLRPTextureMemory = 121; public static final int kCGLRPGPUVertProcCapable = 122; public static final int kCGLRPGPUFragProcCapable = 123; public static final int kCGLRPRendererCount = 128; public static final int kCGLRPOnline = 129; public static final int kCGLRPAcceleratedCompute = 130; public static final int kCGLRPVideoMemoryMegabytes = 131; public static final int kCGLRPTextureMemoryMegabytes = 132; public static final int kCGLRPRobust = 75; public static final int kCGLRPMPSafe = 78; public static final int kCGLRPMultiScreen = 81; public static final int kCGLRPFullScreen = 54; public static final int kCGLCESwapRectangle = 201; public static final int kCGLCESwapLimit = 203; public static final int kCGLCERasterization = 221; public static final int kCGLCEStateValidation = 301; public static final int kCGLCESurfaceBackingSize = 305; public static final int kCGLCEDisplayListOptimization = 307; public static final int kCGLCEMPEngine = 313; public static final int kCGLCPSwapRectangle = 200; public static final int kCGLCPSwapInterval = 222; public static final int kCGLCPDispatchTableSize = 224; public static final int kCGLCPClientStorage = 226; public static final int kCGLCPSurfaceTexture = 228; public static final int kCGLCPSurfaceOrder = 235; public static final int kCGLCPSurfaceOpacity = 236; public static final int kCGLCPSurfaceBackingSize = 304; public static final int kCGLCPSurfaceSurfaceVolatile = 306; public static final int kCGLCPReclaimResources = 308; public static final int kCGLCPCurrentRendererID = 309; public static final int kCGLCPGPUVertexProcessing = 310; public static final int kCGLCPGPUFragmentProcessing = 311; public static final int kCGLCPHasDrawable = 314; public static final int kCGLCPMPSwapsInFlight = 315; public static final int kCGLGOFormatCacheSize = 501; public static final int kCGLGOClearFormatCache = 502; public static final int kCGLGORetainRenderers = 503; public static final int kCGLGOResetLibrary = 504; public static final int kCGLGOUseErrorHandler = 505; public static final int kCGLGOUseBuildCache = 506; public static final int kCGLOGLPVersion_Legacy = 4096; public static final int kCGLOGLPVersion_3_2_Core = 12800; public static final int kCGLNoError = 0; public static final int kCGLBadAttribute = 10000; public static final int kCGLBadProperty = 10001; public static final int kCGLBadPixelFormat = 10002; public static final int kCGLBadRendererInfo = 10003; public static final int kCGLBadContext = 10004; public static final int kCGLBadDrawable = 10005; public static final int kCGLBadDisplay = 10006; public static final int kCGLBadState = 10007; public static final int kCGLBadValue = 10008; public static final int kCGLBadMatch = 10009; public static final int kCGLBadEnumeration = 10010; public static final int kCGLBadOffScreen = 10011; public static final int kCGLBadFullScreen = 10012; public static final int kCGLBadWindow = 10013; public static final int kCGLBadAddress = 10014; public static final int kCGLBadCodeModule = 10015; public static final int kCGLBadAlloc = 10016; public static final int kCGLBadConnection = 10017; public static final int kCGLMonoscopicBit = 1; public static final int kCGLStereoscopicBit = 2; public static final int kCGLSingleBufferBit = 4; public static final int kCGLDoubleBufferBit = 8; public static final int kCGLTripleBufferBit = 16; public static final int kCGL0Bit = 1; public static final int kCGL1Bit = 2; public static final int kCGL2Bit = 4; public static final int kCGL3Bit = 8; public static final int kCGL4Bit = 16; public static final int kCGL5Bit = 32; public static final int kCGL6Bit = 64; public static final int kCGL8Bit = 128; public static final int kCGL10Bit = 256; public static final int kCGL12Bit = 512; public static final int kCGL16Bit = 1024; public static final int kCGL24Bit = 2048; public static final int kCGL32Bit = 4096; public static final int kCGL48Bit = 8192; public static final int kCGL64Bit = 16384;
/*      */   public static final int kCGL96Bit = 32768;
/*      */   public static final int kCGL128Bit = 65536;
/*      */   public static final int kCGLRGB444Bit = 64;
/*      */   public static final int kCGLARGB4444Bit = 128;
/*      */   public static final int kCGLRGB444A8Bit = 256;
/*      */   public static final int kCGLRGB555Bit = 512;
/*      */   public static final int kCGLARGB1555Bit = 1024;
/*      */   public static final int kCGLRGB555A8Bit = 2048;
/*      */   public static final int kCGLRGB565Bit = 4096;
/*      */   public static final int kCGLRGB565A8Bit = 8192;
/*      */   public static final int kCGLRGB888Bit = 16384;
/*      */   public static final int kCGLARGB8888Bit = 32768;
/*      */   public static final int kCGLRGB888A8Bit = 65536;
/*      */   public static final int kCGLRGB101010Bit = 131072;
/*      */   public static final int kCGLARGB2101010Bit = 262144;
/*      */   public static final int kCGLRGB101010_A8Bit = 524288;
/*      */   public static final int kCGLRGB121212Bit = 1048576;
/*      */   public static final int kCGLARGB12121212Bit = 2097152;
/*      */   public static final int kCGLRGB161616Bit = 4194304;
/*      */   public static final int kCGLRGBA16161616Bit = 8388608;
/*      */   public static final int kCGLRGBFloat64Bit = 16777216;
/*      */   public static final int kCGLRGBAFloat64Bit = 33554432;
/*      */   public static final int kCGLRGBFloat128Bit = 67108864;
/*      */   public static final int kCGLRGBAFloat128Bit = 134217728;
/*      */   public static final int kCGLRGBFloat256Bit = 268435456;
/*      */   public static final int kCGLRGBAFloat256Bit = 536870912;
/*      */   public static final int kCGLSupersampleBit = 1;
/*      */   public static final int kCGLMultisampleBit = 2;
/*      */   
/*   31 */   public static final class Functions { public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetCurrentContext");
/*   32 */     public static final long SetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetCurrentContext");
/*   33 */     public static final long GetShareGroup = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetShareGroup");
/*   34 */     public static final long ChoosePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLChoosePixelFormat");
/*   35 */     public static final long DestroyPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPixelFormat");
/*   36 */     public static final long DescribePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePixelFormat");
/*   37 */     public static final long ReleasePixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePixelFormat");
/*   38 */     public static final long RetainPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPixelFormat");
/*   39 */     public static final long GetPixelFormatRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormatRetainCount");
/*   40 */     public static final long QueryRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLQueryRendererInfo");
/*   41 */     public static final long DestroyRendererInfo = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyRendererInfo");
/*   42 */     public static final long DescribeRenderer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribeRenderer");
/*   43 */     public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreateContext");
/*   44 */     public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyContext");
/*   45 */     public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCopyContext");
/*   46 */     public static final long RetainContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainContext");
/*   47 */     public static final long ReleaseContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleaseContext");
/*   48 */     public static final long GetContextRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetContextRetainCount");
/*   49 */     public static final long GetPixelFormat = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPixelFormat");
/*   50 */     public static final long CreatePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLCreatePBuffer");
/*   51 */     public static final long DestroyPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDestroyPBuffer");
/*   52 */     public static final long DescribePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDescribePBuffer");
/*   53 */     public static final long TexImagePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLTexImagePBuffer");
/*   54 */     public static final long RetainPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLRetainPBuffer");
/*   55 */     public static final long ReleasePBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLReleasePBuffer");
/*   56 */     public static final long GetPBufferRetainCount = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBufferRetainCount");
/*   57 */     public static final long SetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetOffScreen");
/*   58 */     public static final long GetOffScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetOffScreen");
/*   59 */     public static final long SetFullScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreen");
/*   60 */     public static final long SetFullScreenOnDisplay = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetFullScreenOnDisplay");
/*   61 */     public static final long SetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetPBuffer");
/*   62 */     public static final long GetPBuffer = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetPBuffer");
/*   63 */     public static final long ClearDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLClearDrawable");
/*   64 */     public static final long FlushDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLFlushDrawable");
/*   65 */     public static final long Enable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLEnable");
/*   66 */     public static final long Disable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLDisable");
/*   67 */     public static final long IsEnabled = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLIsEnabled");
/*   68 */     public static final long SetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetParameter");
/*   69 */     public static final long GetParameter = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetParameter");
/*   70 */     public static final long SetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetVirtualScreen");
/*   71 */     public static final long GetVirtualScreen = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVirtualScreen");
/*   72 */     public static final long UpdateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUpdateContext");
/*   73 */     public static final long SetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLSetGlobalOption");
/*   74 */     public static final long GetGlobalOption = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetGlobalOption");
/*   75 */     public static final long LockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLLockContext");
/*   76 */     public static final long UnlockContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLUnlockContext");
/*   77 */     public static final long GetVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLGetVersion");
/*   78 */     public static final long ErrorString = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "CGLErrorString"); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected CGL() {
/*  273 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLContextObj")
/*      */   public static long CGLGetCurrentContext() {
/*  281 */     long __functionAddress = Functions.GetCurrentContext;
/*  282 */     return JNI.callP(__functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetCurrentContext(@NativeType("CGLContextObj") long context) {
/*  290 */     long __functionAddress = Functions.SetCurrentContext;
/*  291 */     return JNI.callPI(context, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLShareGroupObj")
/*      */   public static long CGLGetShareGroup(@NativeType("CGLContextObj") long ctx) {
/*  299 */     long __functionAddress = Functions.GetShareGroup;
/*  300 */     if (Checks.CHECKS) {
/*  301 */       Checks.check(ctx);
/*      */     }
/*  303 */     return JNI.callPP(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLChoosePixelFormat(long attribs, long pix, long npix) {
/*  310 */     long __functionAddress = Functions.ChoosePixelFormat;
/*  311 */     return JNI.callPPPI(attribs, pix, npix, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLChoosePixelFormat(@NativeType("CGLPixelFormatAttribute const *") IntBuffer attribs, @NativeType("CGLPixelFormatObj *") PointerBuffer pix, @NativeType("GLint *") IntBuffer npix) {
/*  317 */     if (Checks.CHECKS) {
/*  318 */       Checks.checkNT(attribs);
/*  319 */       Checks.check((CustomBuffer)pix, 1);
/*  320 */       Checks.check(npix, 1);
/*      */     } 
/*  322 */     return nCGLChoosePixelFormat(MemoryUtil.memAddress(attribs), MemoryUtil.memAddress((CustomBuffer)pix), MemoryUtil.memAddress(npix));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyPixelFormat(@NativeType("CGLPixelFormatObj") long pix) {
/*  330 */     long __functionAddress = Functions.DestroyPixelFormat;
/*  331 */     if (Checks.CHECKS) {
/*  332 */       Checks.check(pix);
/*      */     }
/*  334 */     return JNI.callPI(pix, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLDescribePixelFormat(long pix, int pix_num, int attrib, long value) {
/*  341 */     long __functionAddress = Functions.DescribePixelFormat;
/*  342 */     if (Checks.CHECKS) {
/*  343 */       Checks.check(pix);
/*      */     }
/*  345 */     return JNI.callPPI(pix, pix_num, attrib, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePixelFormat(@NativeType("CGLPixelFormatObj") long pix, @NativeType("GLint") int pix_num, @NativeType("CGLPixelFormatAttribute") int attrib, @NativeType("GLint *") IntBuffer value) {
/*  351 */     if (Checks.CHECKS) {
/*  352 */       Checks.check(value, 1);
/*      */     }
/*  354 */     return nCGLDescribePixelFormat(pix, pix_num, attrib, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void CGLReleasePixelFormat(@NativeType("CGLPixelFormatObj") long pix) {
/*  361 */     long __functionAddress = Functions.ReleasePixelFormat;
/*  362 */     if (Checks.CHECKS) {
/*  363 */       Checks.check(pix);
/*      */     }
/*  365 */     JNI.callPV(pix, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLPixelFormatObj")
/*      */   public static long CGLRetainPixelFormat(@NativeType("CGLPixelFormatObj") long pix) {
/*  373 */     long __functionAddress = Functions.RetainPixelFormat;
/*  374 */     if (Checks.CHECKS) {
/*  375 */       Checks.check(pix);
/*      */     }
/*  377 */     return JNI.callPP(pix, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int CGLGetPixelFormatRetainCount(@NativeType("CGLPixelFormatObj") long pix) {
/*  385 */     long __functionAddress = Functions.GetPixelFormatRetainCount;
/*  386 */     if (Checks.CHECKS) {
/*  387 */       Checks.check(pix);
/*      */     }
/*  389 */     return JNI.callPI(pix, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLQueryRendererInfo(int display_mask, long rend, long nrend) {
/*  396 */     long __functionAddress = Functions.QueryRendererInfo;
/*  397 */     return JNI.callPPI(display_mask, rend, nrend, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLQueryRendererInfo(@NativeType("GLuint") int display_mask, @NativeType("CGLRendererInfoObj *") PointerBuffer rend, @NativeType("GLint *") IntBuffer nrend) {
/*  403 */     if (Checks.CHECKS) {
/*  404 */       Checks.check((CustomBuffer)rend, 1);
/*  405 */       Checks.check(nrend, 1);
/*      */     } 
/*  407 */     return nCGLQueryRendererInfo(display_mask, MemoryUtil.memAddress((CustomBuffer)rend), MemoryUtil.memAddress(nrend));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyRendererInfo(@NativeType("CGLRendererInfoObj") long rend) {
/*  415 */     long __functionAddress = Functions.DestroyRendererInfo;
/*  416 */     if (Checks.CHECKS) {
/*  417 */       Checks.check(rend);
/*      */     }
/*  419 */     return JNI.callPI(rend, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLDescribeRenderer(long rend, int rend_num, int prop, long value) {
/*  426 */     long __functionAddress = Functions.DescribeRenderer;
/*  427 */     if (Checks.CHECKS) {
/*  428 */       Checks.check(rend);
/*      */     }
/*  430 */     return JNI.callPPI(rend, rend_num, prop, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribeRenderer(@NativeType("CGLRendererInfoObj") long rend, @NativeType("GLint") int rend_num, @NativeType("CGLRendererProperty") int prop, @NativeType("GLint *") IntBuffer value) {
/*  436 */     if (Checks.CHECKS) {
/*  437 */       Checks.check(value, 1);
/*      */     }
/*  439 */     return nCGLDescribeRenderer(rend, rend_num, prop, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLCreateContext(long pix, long share, long ctx) {
/*  446 */     long __functionAddress = Functions.CreateContext;
/*  447 */     if (Checks.CHECKS) {
/*  448 */       Checks.check(pix);
/*      */     }
/*  450 */     return JNI.callPPPI(pix, share, ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLCreateContext(@NativeType("CGLPixelFormatObj") long pix, @NativeType("CGLContextObj") long share, @NativeType("CGLContextObj *") PointerBuffer ctx) {
/*  456 */     if (Checks.CHECKS) {
/*  457 */       Checks.check((CustomBuffer)ctx, 1);
/*      */     }
/*  459 */     return nCGLCreateContext(pix, share, MemoryUtil.memAddress((CustomBuffer)ctx));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyContext(@NativeType("CGLContextObj") long ctx) {
/*  467 */     long __functionAddress = Functions.DestroyContext;
/*  468 */     if (Checks.CHECKS) {
/*  469 */       Checks.check(ctx);
/*      */     }
/*  471 */     return JNI.callPI(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLCopyContext(@NativeType("CGLContextObj") long src, @NativeType("CGLContextObj") long dst, @NativeType("GLbitfield") int mask) {
/*  479 */     long __functionAddress = Functions.CopyContext;
/*  480 */     if (Checks.CHECKS) {
/*  481 */       Checks.check(src);
/*  482 */       Checks.check(dst);
/*      */     } 
/*  484 */     return JNI.callPPI(src, dst, mask, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLContextObj")
/*      */   public static long CGLRetainContext(@NativeType("CGLContextObj") long ctx) {
/*  492 */     long __functionAddress = Functions.RetainContext;
/*  493 */     if (Checks.CHECKS) {
/*  494 */       Checks.check(ctx);
/*      */     }
/*  496 */     return JNI.callPP(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void CGLReleaseContext(@NativeType("CGLContextObj") long ctx) {
/*  503 */     long __functionAddress = Functions.ReleaseContext;
/*  504 */     if (Checks.CHECKS) {
/*  505 */       Checks.check(ctx);
/*      */     }
/*  507 */     JNI.callPV(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int CGLGetContextRetainCount(@NativeType("CGLContextObj") long ctx) {
/*  515 */     long __functionAddress = Functions.GetContextRetainCount;
/*  516 */     if (Checks.CHECKS) {
/*  517 */       Checks.check(ctx);
/*      */     }
/*  519 */     return JNI.callPI(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLPixelFormatObj")
/*      */   public static long CGLGetPixelFormat(@NativeType("CGLContextObj") long ctx) {
/*  527 */     long __functionAddress = Functions.GetPixelFormat;
/*  528 */     if (Checks.CHECKS) {
/*  529 */       Checks.check(ctx);
/*      */     }
/*  531 */     return JNI.callPP(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLCreatePBuffer(int width, int height, int target, int internalFormat, int max_level, long pbuffer) {
/*  538 */     long __functionAddress = Functions.CreatePBuffer;
/*  539 */     return JNI.callPI(width, height, target, internalFormat, max_level, pbuffer, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLCreatePBuffer(@NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLenum") int target, @NativeType("GLenum") int internalFormat, @NativeType("GLint") int max_level, @NativeType("CGLPBufferObj *") PointerBuffer pbuffer) {
/*  545 */     if (Checks.CHECKS) {
/*  546 */       Checks.check((CustomBuffer)pbuffer, 1);
/*      */     }
/*  548 */     return nCGLCreatePBuffer(width, height, target, internalFormat, max_level, MemoryUtil.memAddress((CustomBuffer)pbuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDestroyPBuffer(@NativeType("CGLPBufferObj") long pbuffer) {
/*  556 */     long __functionAddress = Functions.DestroyPBuffer;
/*  557 */     if (Checks.CHECKS) {
/*  558 */       Checks.check(pbuffer);
/*      */     }
/*  560 */     return JNI.callPI(pbuffer, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLDescribePBuffer(long obj, long width, long height, long target, long internalFormat, long mipmap) {
/*  567 */     long __functionAddress = Functions.DescribePBuffer;
/*  568 */     if (Checks.CHECKS) {
/*  569 */       Checks.check(obj);
/*      */     }
/*  571 */     return JNI.callPPPPPPI(obj, width, height, target, internalFormat, mipmap, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePBuffer(@NativeType("CGLPBufferObj") long obj, @NativeType("GLsizei *") IntBuffer width, @NativeType("GLsizei *") IntBuffer height, @NativeType("GLenum *") IntBuffer target, @NativeType("GLenum *") IntBuffer internalFormat, @NativeType("GLint *") IntBuffer mipmap) {
/*  577 */     if (Checks.CHECKS) {
/*  578 */       Checks.check(width, 1);
/*  579 */       Checks.check(height, 1);
/*  580 */       Checks.check(target, 1);
/*  581 */       Checks.check(internalFormat, 1);
/*  582 */       Checks.check(mipmap, 1);
/*      */     } 
/*  584 */     return nCGLDescribePBuffer(obj, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddress(target), MemoryUtil.memAddress(internalFormat), MemoryUtil.memAddress(mipmap));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLTexImagePBuffer(@NativeType("CGLContextObj") long ctx, @NativeType("CGLPBufferObj") long pbuffer, @NativeType("GLenum") int source) {
/*  592 */     long __functionAddress = Functions.TexImagePBuffer;
/*  593 */     if (Checks.CHECKS) {
/*  594 */       Checks.check(ctx);
/*  595 */       Checks.check(pbuffer);
/*      */     } 
/*  597 */     return JNI.callPPI(ctx, pbuffer, source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLPBufferObj")
/*      */   public static long CGLRetainPBuffer(@NativeType("CGLPBufferObj") long pbuffer) {
/*  605 */     long __functionAddress = Functions.RetainPBuffer;
/*  606 */     if (Checks.CHECKS) {
/*  607 */       Checks.check(pbuffer);
/*      */     }
/*  609 */     return JNI.callPP(pbuffer, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void CGLReleasePBuffer(@NativeType("CGLPBufferObj") long pbuffer) {
/*  616 */     long __functionAddress = Functions.ReleasePBuffer;
/*  617 */     if (Checks.CHECKS) {
/*  618 */       Checks.check(pbuffer);
/*      */     }
/*  620 */     JNI.callPV(pbuffer, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLuint")
/*      */   public static int CGLGetPBufferRetainCount(@NativeType("CGLPBufferObj") long pbuffer) {
/*  628 */     long __functionAddress = Functions.GetPBufferRetainCount;
/*  629 */     if (Checks.CHECKS) {
/*  630 */       Checks.check(pbuffer);
/*      */     }
/*  632 */     return JNI.callPI(pbuffer, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLSetOffScreen(long ctx, int width, int height, int rowbytes, long baseaddr) {
/*  639 */     long __functionAddress = Functions.SetOffScreen;
/*  640 */     if (Checks.CHECKS) {
/*  641 */       Checks.check(ctx);
/*      */     }
/*  643 */     return JNI.callPPI(ctx, width, height, rowbytes, baseaddr, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetOffScreen(@NativeType("CGLContextObj") long ctx, @NativeType("GLsizei") int width, @NativeType("GLsizei") int height, @NativeType("GLint") int rowbytes, @NativeType("void *") ByteBuffer baseaddr) {
/*  649 */     if (Checks.CHECKS) {
/*  650 */       Checks.check(baseaddr, rowbytes * height);
/*      */     }
/*  652 */     return nCGLSetOffScreen(ctx, width, height, rowbytes, MemoryUtil.memAddress(baseaddr));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetOffScreen(long ctx, long width, long height, long rowbytes, long baseaddr) {
/*  659 */     long __functionAddress = Functions.GetOffScreen;
/*  660 */     if (Checks.CHECKS) {
/*  661 */       Checks.check(ctx);
/*      */     }
/*  663 */     return JNI.callPPPPPI(ctx, width, height, rowbytes, baseaddr, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetOffScreen(@NativeType("CGLContextObj") long ctx, @NativeType("GLsizei *") IntBuffer width, @NativeType("GLsizei *") IntBuffer height, @NativeType("GLint *") IntBuffer rowbytes, @NativeType("void **") PointerBuffer baseaddr) {
/*  669 */     if (Checks.CHECKS) {
/*  670 */       Checks.check(width, 1);
/*  671 */       Checks.check(height, 1);
/*  672 */       Checks.check(rowbytes, 1);
/*  673 */       Checks.check((CustomBuffer)baseaddr, 1);
/*      */     } 
/*  675 */     return nCGLGetOffScreen(ctx, MemoryUtil.memAddress(width), MemoryUtil.memAddress(height), MemoryUtil.memAddress(rowbytes), MemoryUtil.memAddress((CustomBuffer)baseaddr));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetFullScreen(@NativeType("CGLContextObj") long ctx) {
/*  683 */     long __functionAddress = Functions.SetFullScreen;
/*  684 */     if (Checks.CHECKS) {
/*  685 */       Checks.check(ctx);
/*      */     }
/*  687 */     return JNI.callPI(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetFullScreenOnDisplay(@NativeType("CGLContextObj") long ctx, @NativeType("GLuint") int display_mask) {
/*  695 */     long __functionAddress = Functions.SetFullScreenOnDisplay;
/*  696 */     if (Checks.CHECKS) {
/*  697 */       Checks.check(ctx);
/*      */     }
/*  699 */     return JNI.callPI(ctx, display_mask, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetPBuffer(@NativeType("CGLContextObj") long ctx, @NativeType("CGLPBufferObj") long pbuffer, @NativeType("GLenum") int face, @NativeType("GLint") int level, @NativeType("GLint") int screen) {
/*  707 */     long __functionAddress = Functions.SetPBuffer;
/*  708 */     if (Checks.CHECKS) {
/*  709 */       Checks.check(ctx);
/*  710 */       Checks.check(pbuffer);
/*      */     } 
/*  712 */     return JNI.callPPI(ctx, pbuffer, face, level, screen, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetPBuffer(long ctx, long pbuffer, long face, long level, long screen) {
/*  719 */     long __functionAddress = Functions.GetPBuffer;
/*  720 */     if (Checks.CHECKS) {
/*  721 */       Checks.check(ctx);
/*      */     }
/*  723 */     return JNI.callPPPPPI(ctx, pbuffer, face, level, screen, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetPBuffer(@NativeType("CGLContextObj") long ctx, @NativeType("CGLPBufferObj *") PointerBuffer pbuffer, @NativeType("GLenum *") IntBuffer face, @NativeType("GLint *") IntBuffer level, @NativeType("GLint *") IntBuffer screen) {
/*  729 */     if (Checks.CHECKS) {
/*  730 */       Checks.check((CustomBuffer)pbuffer, 1);
/*  731 */       Checks.check(face, 1);
/*  732 */       Checks.check(level, 1);
/*  733 */       Checks.check(screen, 1);
/*      */     } 
/*  735 */     return nCGLGetPBuffer(ctx, MemoryUtil.memAddress((CustomBuffer)pbuffer), MemoryUtil.memAddress(face), MemoryUtil.memAddress(level), MemoryUtil.memAddress(screen));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLClearDrawable(@NativeType("CGLContextObj") long ctx) {
/*  743 */     long __functionAddress = Functions.ClearDrawable;
/*  744 */     if (Checks.CHECKS) {
/*  745 */       Checks.check(ctx);
/*      */     }
/*  747 */     return JNI.callPI(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLFlushDrawable(@NativeType("CGLContextObj") long ctx) {
/*  755 */     long __functionAddress = Functions.FlushDrawable;
/*  756 */     if (Checks.CHECKS) {
/*  757 */       Checks.check(ctx);
/*      */     }
/*  759 */     return JNI.callPI(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLEnable(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextEnable") int pname) {
/*  767 */     long __functionAddress = Functions.Enable;
/*  768 */     if (Checks.CHECKS) {
/*  769 */       Checks.check(ctx);
/*      */     }
/*  771 */     return JNI.callPI(ctx, pname, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDisable(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextEnable") int pname) {
/*  779 */     long __functionAddress = Functions.Disable;
/*  780 */     if (Checks.CHECKS) {
/*  781 */       Checks.check(ctx);
/*      */     }
/*  783 */     return JNI.callPI(ctx, pname, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLIsEnabled(long ctx, int pname, long enable) {
/*  790 */     long __functionAddress = Functions.IsEnabled;
/*  791 */     if (Checks.CHECKS) {
/*  792 */       Checks.check(ctx);
/*      */     }
/*  794 */     return JNI.callPPI(ctx, pname, enable, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLIsEnabled(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextEnable") int pname, @NativeType("GLint *") IntBuffer enable) {
/*  800 */     if (Checks.CHECKS) {
/*  801 */       Checks.check(enable, 1);
/*      */     }
/*  803 */     return nCGLIsEnabled(ctx, pname, MemoryUtil.memAddress(enable));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLSetParameter(long ctx, int pname, long params) {
/*  810 */     long __functionAddress = Functions.SetParameter;
/*  811 */     if (Checks.CHECKS) {
/*  812 */       Checks.check(ctx);
/*      */     }
/*  814 */     return JNI.callPPI(ctx, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetParameter(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextParameter") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  820 */     if (Checks.CHECKS) {
/*  821 */       Checks.check(params, 1);
/*      */     }
/*  823 */     return nCGLSetParameter(ctx, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetParameter(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextParameter") int pname, @NativeType("GLint const *") int param) {
/*  829 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  831 */       IntBuffer params = stack.ints(param);
/*  832 */       return nCGLSetParameter(ctx, pname, MemoryUtil.memAddress(params));
/*      */     } finally {
/*  834 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetParameter(long ctx, int pname, long params) {
/*  842 */     long __functionAddress = Functions.GetParameter;
/*  843 */     if (Checks.CHECKS) {
/*  844 */       Checks.check(ctx);
/*      */     }
/*  846 */     return JNI.callPPI(ctx, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetParameter(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextParameter") int pname, @NativeType("GLint *") IntBuffer params) {
/*  852 */     if (Checks.CHECKS) {
/*  853 */       Checks.check(params, 1);
/*      */     }
/*  855 */     return nCGLGetParameter(ctx, pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetVirtualScreen(@NativeType("CGLContextObj") long ctx, @NativeType("GLint") int screen) {
/*  863 */     long __functionAddress = Functions.SetVirtualScreen;
/*  864 */     if (Checks.CHECKS) {
/*  865 */       Checks.check(ctx);
/*      */     }
/*  867 */     return JNI.callPI(ctx, screen, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetVirtualScreen(long ctx, long screen) {
/*  874 */     long __functionAddress = Functions.GetVirtualScreen;
/*  875 */     if (Checks.CHECKS) {
/*  876 */       Checks.check(ctx);
/*      */     }
/*  878 */     return JNI.callPPI(ctx, screen, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetVirtualScreen(@NativeType("CGLContextObj") long ctx, @NativeType("GLint *") IntBuffer screen) {
/*  884 */     if (Checks.CHECKS) {
/*  885 */       Checks.check(screen, 1);
/*      */     }
/*  887 */     return nCGLGetVirtualScreen(ctx, MemoryUtil.memAddress(screen));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLUpdateContext(@NativeType("CGLContextObj") long ctx) {
/*  895 */     long __functionAddress = Functions.UpdateContext;
/*  896 */     if (Checks.CHECKS) {
/*  897 */       Checks.check(ctx);
/*      */     }
/*  899 */     return JNI.callPI(ctx, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLSetGlobalOption(int pname, long params) {
/*  906 */     long __functionAddress = Functions.SetGlobalOption;
/*  907 */     return JNI.callPI(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetGlobalOption(@NativeType("CGLGlobalOption") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  913 */     if (Checks.CHECKS) {
/*  914 */       Checks.check(params, 1);
/*      */     }
/*  916 */     return nCGLSetGlobalOption(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetGlobalOption(@NativeType("CGLGlobalOption") int pname, @NativeType("GLint const *") int param) {
/*  922 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  924 */       IntBuffer params = stack.ints(param);
/*  925 */       return nCGLSetGlobalOption(pname, MemoryUtil.memAddress(params));
/*      */     } finally {
/*  927 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nCGLGetGlobalOption(int pname, long params) {
/*  935 */     long __functionAddress = Functions.GetGlobalOption;
/*  936 */     return JNI.callPI(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetGlobalOption(@NativeType("CGLGlobalOption") int pname, @NativeType("GLint *") IntBuffer params) {
/*  942 */     if (Checks.CHECKS) {
/*  943 */       Checks.check(params, 1);
/*      */     }
/*  945 */     return nCGLGetGlobalOption(pname, MemoryUtil.memAddress(params));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLLockContext(@NativeType("CGLContextObj") long context) {
/*  953 */     long __functionAddress = Functions.LockContext;
/*  954 */     if (Checks.CHECKS) {
/*  955 */       Checks.check(context);
/*      */     }
/*  957 */     return JNI.callPI(context, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLUnlockContext(@NativeType("CGLContextObj") long context) {
/*  965 */     long __functionAddress = Functions.UnlockContext;
/*  966 */     if (Checks.CHECKS) {
/*  967 */       Checks.check(context);
/*      */     }
/*  969 */     return JNI.callPI(context, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nCGLGetVersion(long majorvers, long minorvers) {
/*  976 */     long __functionAddress = Functions.GetVersion;
/*  977 */     JNI.callPPV(majorvers, minorvers, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void CGLGetVersion(@NativeType("GLint *") IntBuffer majorvers, @NativeType("GLint *") IntBuffer minorvers) {
/*  982 */     if (Checks.CHECKS) {
/*  983 */       Checks.check(majorvers, 1);
/*  984 */       Checks.check(minorvers, 1);
/*      */     } 
/*  986 */     nCGLGetVersion(MemoryUtil.memAddress(majorvers), MemoryUtil.memAddress(minorvers));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nCGLErrorString(int error) {
/*  993 */     long __functionAddress = Functions.ErrorString;
/*  994 */     return JNI.callP(error, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String CGLErrorString(@NativeType("CGLError") int error) {
/* 1000 */     long __result = nCGLErrorString(error);
/* 1001 */     return MemoryUtil.memASCIISafe(__result);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLChoosePixelFormat(@NativeType("CGLPixelFormatAttribute const *") int[] attribs, @NativeType("CGLPixelFormatObj *") PointerBuffer pix, @NativeType("GLint *") int[] npix) {
/* 1007 */     long __functionAddress = Functions.ChoosePixelFormat;
/* 1008 */     if (Checks.CHECKS) {
/* 1009 */       Checks.checkNT(attribs);
/* 1010 */       Checks.check((CustomBuffer)pix, 1);
/* 1011 */       Checks.check(npix, 1);
/*      */     } 
/* 1013 */     return JNI.callPPPI(attribs, MemoryUtil.memAddress((CustomBuffer)pix), npix, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePixelFormat(@NativeType("CGLPixelFormatObj") long pix, @NativeType("GLint") int pix_num, @NativeType("CGLPixelFormatAttribute") int attrib, @NativeType("GLint *") int[] value) {
/* 1019 */     long __functionAddress = Functions.DescribePixelFormat;
/* 1020 */     if (Checks.CHECKS) {
/* 1021 */       Checks.check(pix);
/* 1022 */       Checks.check(value, 1);
/*      */     } 
/* 1024 */     return JNI.callPPI(pix, pix_num, attrib, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLQueryRendererInfo(@NativeType("GLuint") int display_mask, @NativeType("CGLRendererInfoObj *") PointerBuffer rend, @NativeType("GLint *") int[] nrend) {
/* 1030 */     long __functionAddress = Functions.QueryRendererInfo;
/* 1031 */     if (Checks.CHECKS) {
/* 1032 */       Checks.check((CustomBuffer)rend, 1);
/* 1033 */       Checks.check(nrend, 1);
/*      */     } 
/* 1035 */     return JNI.callPPI(display_mask, MemoryUtil.memAddress((CustomBuffer)rend), nrend, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribeRenderer(@NativeType("CGLRendererInfoObj") long rend, @NativeType("GLint") int rend_num, @NativeType("CGLRendererProperty") int prop, @NativeType("GLint *") int[] value) {
/* 1041 */     long __functionAddress = Functions.DescribeRenderer;
/* 1042 */     if (Checks.CHECKS) {
/* 1043 */       Checks.check(rend);
/* 1044 */       Checks.check(value, 1);
/*      */     } 
/* 1046 */     return JNI.callPPI(rend, rend_num, prop, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLDescribePBuffer(@NativeType("CGLPBufferObj") long obj, @NativeType("GLsizei *") int[] width, @NativeType("GLsizei *") int[] height, @NativeType("GLenum *") int[] target, @NativeType("GLenum *") int[] internalFormat, @NativeType("GLint *") int[] mipmap) {
/* 1052 */     long __functionAddress = Functions.DescribePBuffer;
/* 1053 */     if (Checks.CHECKS) {
/* 1054 */       Checks.check(obj);
/* 1055 */       Checks.check(width, 1);
/* 1056 */       Checks.check(height, 1);
/* 1057 */       Checks.check(target, 1);
/* 1058 */       Checks.check(internalFormat, 1);
/* 1059 */       Checks.check(mipmap, 1);
/*      */     } 
/* 1061 */     return JNI.callPPPPPPI(obj, width, height, target, internalFormat, mipmap, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetOffScreen(@NativeType("CGLContextObj") long ctx, @NativeType("GLsizei *") int[] width, @NativeType("GLsizei *") int[] height, @NativeType("GLint *") int[] rowbytes, @NativeType("void **") PointerBuffer baseaddr) {
/* 1067 */     long __functionAddress = Functions.GetOffScreen;
/* 1068 */     if (Checks.CHECKS) {
/* 1069 */       Checks.check(ctx);
/* 1070 */       Checks.check(width, 1);
/* 1071 */       Checks.check(height, 1);
/* 1072 */       Checks.check(rowbytes, 1);
/* 1073 */       Checks.check((CustomBuffer)baseaddr, 1);
/*      */     } 
/* 1075 */     return JNI.callPPPPPI(ctx, width, height, rowbytes, MemoryUtil.memAddress((CustomBuffer)baseaddr), __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetPBuffer(@NativeType("CGLContextObj") long ctx, @NativeType("CGLPBufferObj *") PointerBuffer pbuffer, @NativeType("GLenum *") int[] face, @NativeType("GLint *") int[] level, @NativeType("GLint *") int[] screen) {
/* 1081 */     long __functionAddress = Functions.GetPBuffer;
/* 1082 */     if (Checks.CHECKS) {
/* 1083 */       Checks.check(ctx);
/* 1084 */       Checks.check((CustomBuffer)pbuffer, 1);
/* 1085 */       Checks.check(face, 1);
/* 1086 */       Checks.check(level, 1);
/* 1087 */       Checks.check(screen, 1);
/*      */     } 
/* 1089 */     return JNI.callPPPPPI(ctx, MemoryUtil.memAddress((CustomBuffer)pbuffer), face, level, screen, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLIsEnabled(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextEnable") int pname, @NativeType("GLint *") int[] enable) {
/* 1095 */     long __functionAddress = Functions.IsEnabled;
/* 1096 */     if (Checks.CHECKS) {
/* 1097 */       Checks.check(ctx);
/* 1098 */       Checks.check(enable, 1);
/*      */     } 
/* 1100 */     return JNI.callPPI(ctx, pname, enable, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetParameter(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextParameter") int pname, @NativeType("GLint const *") int[] params) {
/* 1106 */     long __functionAddress = Functions.SetParameter;
/* 1107 */     if (Checks.CHECKS) {
/* 1108 */       Checks.check(ctx);
/* 1109 */       Checks.check(params, 1);
/*      */     } 
/* 1111 */     return JNI.callPPI(ctx, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetParameter(@NativeType("CGLContextObj") long ctx, @NativeType("CGLContextParameter") int pname, @NativeType("GLint *") int[] params) {
/* 1117 */     long __functionAddress = Functions.GetParameter;
/* 1118 */     if (Checks.CHECKS) {
/* 1119 */       Checks.check(ctx);
/* 1120 */       Checks.check(params, 1);
/*      */     } 
/* 1122 */     return JNI.callPPI(ctx, pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetVirtualScreen(@NativeType("CGLContextObj") long ctx, @NativeType("GLint *") int[] screen) {
/* 1128 */     long __functionAddress = Functions.GetVirtualScreen;
/* 1129 */     if (Checks.CHECKS) {
/* 1130 */       Checks.check(ctx);
/* 1131 */       Checks.check(screen, 1);
/*      */     } 
/* 1133 */     return JNI.callPPI(ctx, screen, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLSetGlobalOption(@NativeType("CGLGlobalOption") int pname, @NativeType("GLint const *") int[] params) {
/* 1139 */     long __functionAddress = Functions.SetGlobalOption;
/* 1140 */     if (Checks.CHECKS) {
/* 1141 */       Checks.check(params, 1);
/*      */     }
/* 1143 */     return JNI.callPI(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("CGLError")
/*      */   public static int CGLGetGlobalOption(@NativeType("CGLGlobalOption") int pname, @NativeType("GLint *") int[] params) {
/* 1149 */     long __functionAddress = Functions.GetGlobalOption;
/* 1150 */     if (Checks.CHECKS) {
/* 1151 */       Checks.check(params, 1);
/*      */     }
/* 1153 */     return JNI.callPI(pname, params, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void CGLGetVersion(@NativeType("GLint *") int[] majorvers, @NativeType("GLint *") int[] minorvers) {
/* 1158 */     long __functionAddress = Functions.GetVersion;
/* 1159 */     if (Checks.CHECKS) {
/* 1160 */       Checks.check(majorvers, 1);
/* 1161 */       Checks.check(minorvers, 1);
/*      */     } 
/* 1163 */     JNI.callPPV(majorvers, minorvers, __functionAddress);
/*      */   } }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\CGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */