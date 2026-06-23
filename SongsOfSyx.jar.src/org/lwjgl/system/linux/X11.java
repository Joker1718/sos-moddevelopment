/*     */ package org.lwjgl.system.linux;public class X11 { public static final int True = 1; public static final int False = 0; public static final int None = 0; public static final int ParentRelative = 1; public static final int CopyFromParent = 0; public static final int PointerWindow = 0; public static final int InputFocus = 1; public static final int PointerRoot = 1; public static final int AnyPropertyType = 0; public static final int AnyKey = 0; public static final int AnyButton = 0; public static final int AllTemporary = 0; public static final int CurrentTime = 0; public static final int NoSymbol = 0; public static final int Success = 0; public static final int BadRequest = 1; public static final int BadValue = 2; public static final int BadWindow = 3; public static final int BadPixmap = 4; public static final int BadAtom = 5; public static final int BadCursor = 6; public static final int BadFont = 7; public static final int BadMatch = 8; public static final int BadDrawable = 9; public static final int BadAccess = 10; public static final int BadAlloc = 11; public static final int BadColor = 12; public static final int BadGC = 13; public static final int BadIDChoice = 14; public static final int BadName = 15; public static final int BadLength = 16; public static final int BadImplementation = 17; public static final int FirstExtensionError = 128; public static final int LastExtensionError = 255; public static final int CWBackPixmap = 1; public static final int CWBackPixel = 2; public static final int CWBorderPixmap = 4; public static final int CWBorderPixel = 8; public static final int CWBitGravity = 16; public static final int CWWinGravity = 32; public static final int CWBackingStore = 64; public static final int CWBackingPlanes = 128; public static final int CWBackingPixel = 256; public static final int CWOverrideRedirect = 512; public static final int CWSaveUnder = 1024; public static final int CWEventMask = 2048;
/*     */   public static final int CWDontPropagate = 4096;
/*     */   public static final int CWColormap = 8192;
/*     */   public static final int CWCursor = 16384;
/*     */   public static final int NoEventMask = 0;
/*     */   public static final int KeyPressMask = 1;
/*     */   public static final int KeyReleaseMask = 2;
/*     */   public static final int ButtonPressMask = 4;
/*     */   public static final int ButtonReleaseMask = 8;
/*     */   public static final int EnterWindowMask = 16;
/*     */   public static final int LeaveWindowMask = 32;
/*     */   public static final int PointerMotionMask = 64;
/*     */   public static final int PointerMotionHintMask = 128;
/*     */   public static final int Button1MotionMask = 256;
/*     */   public static final int Button2MotionMask = 512;
/*     */   public static final int Button3MotionMask = 1024;
/*     */   public static final int Button4MotionMask = 2048;
/*     */   public static final int Button5MotionMask = 4096;
/*     */   public static final int ButtonMotionMask = 8192;
/*     */   public static final int KeymapStateMask = 16384;
/*     */   public static final int ExposureMask = 32768;
/*     */   public static final int VisibilityChangeMask = 65536;
/*     */   public static final int StructureNotifyMask = 131072;
/*  24 */   private static final SharedLibrary X11 = Library.loadNative(X11.class, "org.lwjgl", null, new String[] { "libX11.so.6", "libX11.so" }); public static final int ResizeRedirectMask = 262144; public static final int SubstructureNotifyMask = 524288; public static final int SubstructureRedirectMask = 1048576; public static final int FocusChangeMask = 2097152; public static final int PropertyChangeMask = 4194304; public static final int ColormapChangeMask = 8388608; public static final int OwnerGrabButtonMask = 16777216; public static final int KeyPress = 2; public static final int KeyRelease = 3; public static final int ButtonPress = 4; public static final int ButtonRelease = 5; public static final int MotionNotify = 6; public static final int EnterNotify = 7; public static final int LeaveNotify = 8; public static final int FocusIn = 9; public static final int FocusOut = 10; public static final int KeymapNotify = 11; public static final int Expose = 12; public static final int GraphicsExpose = 13; public static final int NoExpose = 14; public static final int VisibilityNotify = 15; public static final int CreateNotify = 16; public static final int DestroyNotify = 17; public static final int UnmapNotify = 18; public static final int MapNotify = 19; public static final int MapRequest = 20; public static final int ReparentNotify = 21; public static final int ConfigureNotify = 22; public static final int ConfigureRequest = 23; public static final int GravityNotify = 24; public static final int ResizeRequest = 25; public static final int CirculateNotify = 26; public static final int CirculateRequest = 27; public static final int PropertyNotify = 28; public static final int SelectionClear = 29; public static final int SelectionRequest = 30; public static final int SelectionNotify = 31; public static final int ColormapNotify = 32; public static final int ClientMessage = 33; public static final int MappingNotify = 34; public static final int GenericEvent = 35; public static final int LASTEvent = 36; public static final int ShiftMask = 1; public static final int LockMask = 2; public static final int ControlMask = 4; public static final int Mod1Mask = 8; public static final int Mod2Mask = 16; public static final int Mod3Mask = 32; public static final int Mod4Mask = 64; public static final int Mod5Mask = 128; public static final int ShiftMapIndex = 0; public static final int LockMapIndex = 1; public static final int ControlMapIndex = 2; public static final int Mod1MapIndex = 3; public static final int Mod2MapIndex = 4; public static final int Mod3MapIndex = 5; public static final int Mod4MapIndex = 6; public static final int Mod5MapIndex = 7; public static final int Button1Mask = 256; public static final int Button2Mask = 512; public static final int Button3Mask = 1024; public static final int Button4Mask = 2048; public static final int Button5Mask = 4096; public static final int AnyModifier = 32768; public static final int Button1 = 1; public static final int Button2 = 2; public static final int Button3 = 3; public static final int Button4 = 4; public static final int Button5 = 5; public static final int NotifyNormal = 0; public static final int NotifyGrab = 1; public static final int NotifyUngrab = 2; public static final int NotifyWhileGrabbed = 3; public static final int NotifyHint = 1; public static final int NotifyAncestor = 0; public static final int NotifyVirtual = 1; public static final int NotifyInferior = 2; public static final int NotifyNonlinear = 3; public static final int NotifyNonlinearVirtual = 4; public static final int NotifyPointer = 5; public static final int NotifyPointerRoot = 6; public static final int NotifyDetailNone = 7; public static final int VisibilityUnobscured = 0; public static final int VisibilityPartiallyObscured = 1; public static final int VisibilityFullyObscured = 2; public static final int PlaceOnTop = 0; public static final int PlaceOnBottom = 1; public static final int PropertyNewValue = 0; public static final int PropertyDelete = 1; public static final int ColormapUninstalled = 0; public static final int ColormapInstalled = 1; public static final int GrabModeSync = 0; public static final int GrabModeAsync = 1; public static final int GrabSuccess = 0; public static final int AlreadyGrabbed = 1; public static final int GrabInvalidTime = 2; public static final int GrabNotViewable = 3; public static final int GrabFrozen = 4; public static final int AsyncPointer = 0; public static final int SyncPointer = 1; public static final int ReplayPointer = 2; public static final int AsyncKeyboard = 3; public static final int SyncKeyboard = 4; public static final int ReplayKeyboard = 5; public static final int AsyncBoth = 6; public static final int SyncBoth = 7; public static final int AllocNone = 0; public static final int AllocAll = 1; public static final int RevertToNone = 0; public static final int RevertToPointerRoot = 1; public static final int RevertToParent = 2; public static final int InputOutput = 1; public static final int InputOnly = 2; public static final int DontPreferBlanking = 0; public static final int PreferBlanking = 1; public static final int DefaultBlanking = 2; public static final int DisableScreenSaver = 0; public static final int DisableScreenInterval = 0; public static final int DontAllowExposures = 0; public static final int AllowExposures = 1; public static final int DefaultExposures = 2; public static final int ScreenSaverReset = 0; public static final int ScreenSaverActive = 1; public static final int PropModeReplace = 0; public static final int PropModePrepend = 1; public static final int PropModeAppend = 2; public static final int GXclear = 0; public static final int GXand = 1; public static final int GXandReverse = 2; public static final int GXcopy = 3; public static final int GXandInverted = 4; public static final int GXnoop = 5; public static final int GXxor = 6; public static final int GXor = 7; public static final int GXnor = 8; public static final int GXequiv = 9; public static final int GXinvert = 10; public static final int GXorReverse = 11; public static final int GXcopyInverted = 12; public static final int GXorInverted = 13; public static final int GXnand = 14; public static final int GXset = 15; public static final int LineSolid = 0; public static final int LineOnOffDash = 1; public static final int LineDoubleDash = 2; public static final int CapNotLast = 0; public static final int CapButt = 1; public static final int CapRound = 2; public static final int CapProjecting = 3; public static final int JoinMiter = 0; public static final int JoinRound = 1; public static final int JoinBevel = 2; public static final int FillSolid = 0; public static final int FillTiled = 1; public static final int FillStippled = 2; public static final int FillOpaqueStippled = 3; public static final int EvenOddRule = 0; public static final int WindingRule = 1; public static final int ClipByChildren = 0; public static final int IncludeInferiors = 1; public static final int Unsorted = 0; public static final int YSorted = 1; public static final int YXSorted = 2; public static final int YXBanded = 3; public static final int CoordModeOrigin = 0; public static final int CoordModePrevious = 1; public static final int Complex = 0; public static final int Nonconvex = 1; public static final int Convex = 2; public static final int ArcChord = 0; public static final int ArcPieSlice = 1; public static final int GCFunction = 1; public static final int GCPlaneMask = 2; public static final int GCForeground = 4; public static final int GCBackground = 8; public static final int GCLineWidth = 16; public static final int GCLineStyle = 32; public static final int GCCapStyle = 64; public static final int GCJoinStyle = 128; public static final int GCFillStyle = 256; public static final int GCFillRule = 512; public static final int GCTile = 1024; public static final int GCStipple = 2048; public static final int GCTileStipXOrigin = 4096; public static final int GCTileStipYOrigin = 8192; public static final int GCFont = 16384; public static final int GCSubwindowMode = 32768; public static final int GCGraphicsExposures = 65536; public static final int GCClipXOrigin = 131072; public static final int GCClipYOrigin = 262144; public static final int GCClipMask = 524288; public static final int GCDashOffset = 1048576; public static final int GCDashList = 2097152; public static final int GCArcMode = 4194304; public static final int GCLastBit = 22; public static final int Above = 0;
/*     */   public static final int Below = 1;
/*     */   public static final int TopIf = 2;
/*     */   public static final int BottomIf = 3;
/*     */   public static final int Opposite = 4;
/*     */   public static final int MappingModifier = 0;
/*     */   public static final int MappingKeyboard = 1;
/*     */   public static final int MappingPointer = 2;
/*     */   
/*  33 */   public static final class Functions { public static final long XOpenDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XOpenDisplay");
/*  34 */     public static final long XCloseDisplay = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XCloseDisplay");
/*  35 */     public static final long XDefaultScreen = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XDefaultScreen");
/*  36 */     public static final long XRootWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XRootWindow");
/*  37 */     public static final long XCreateColormap = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XCreateColormap");
/*  38 */     public static final long XFreeColormap = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XFreeColormap");
/*  39 */     public static final long XCreateWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XCreateWindow");
/*  40 */     public static final long XDestroyWindow = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XDestroyWindow");
/*  41 */     public static final long XFree = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XFree");
/*  42 */     public static final long XSendEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XSendEvent");
/*  43 */     public static final long XDisplayMotionBufferSize = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XDisplayMotionBufferSize");
/*  44 */     public static final long XGetMotionEvents = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XGetMotionEvents");
/*  45 */     public static final long XTranslateCoordinates = APIUtil.apiGetFunctionAddress((FunctionProvider)X11.X11, "XTranslateCoordinates"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  51 */     return X11;
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
/*     */   protected X11() {
/* 402 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXOpenDisplay(long display_name) {
/* 409 */     long __functionAddress = Functions.XOpenDisplay;
/* 410 */     return JNI.invokePP(display_name, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Display *")
/*     */   public static long XOpenDisplay(@NativeType("char const *") ByteBuffer display_name) {
/* 416 */     if (Checks.CHECKS) {
/* 417 */       Checks.checkNT1Safe(display_name);
/*     */     }
/* 419 */     return nXOpenDisplay(MemoryUtil.memAddressSafe(display_name));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Display *")
/*     */   public static long XOpenDisplay(@NativeType("char const *") CharSequence display_name) {
/* 425 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 427 */       stack.nASCIISafe(display_name, true);
/* 428 */       long display_nameEncoded = (display_name == null) ? 0L : stack.getPointerAddress();
/* 429 */       return nXOpenDisplay(display_nameEncoded);
/*     */     } finally {
/* 431 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void XCloseDisplay(@NativeType("Display *") long display) {
/* 439 */     long __functionAddress = Functions.XCloseDisplay;
/* 440 */     if (Checks.CHECKS) {
/* 441 */       Checks.check(display);
/*     */     }
/* 443 */     JNI.invokePV(display, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int XDefaultScreen(@NativeType("Display *") long display) {
/* 450 */     long __functionAddress = Functions.XDefaultScreen;
/* 451 */     if (Checks.CHECKS) {
/* 452 */       Checks.check(display);
/*     */     }
/* 454 */     return JNI.invokePI(display, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Window")
/*     */   public static long XRootWindow(@NativeType("Display *") long display, int screen_number) {
/* 462 */     long __functionAddress = Functions.XRootWindow;
/* 463 */     if (Checks.CHECKS) {
/* 464 */       Checks.check(display);
/*     */     }
/* 466 */     return JNI.invokePN(display, screen_number, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXCreateColormap(long display, long w, long visual, int alloc) {
/* 473 */     long __functionAddress = Functions.XCreateColormap;
/* 474 */     if (Checks.CHECKS) {
/* 475 */       Checks.check(display);
/*     */     }
/* 477 */     return JNI.invokePNPN(display, w, visual, alloc, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Colormap")
/*     */   public static long XCreateColormap(@NativeType("Display *") long display, @NativeType("Window") long w, @NativeType("Visual *") Visual visual, int alloc) {
/* 483 */     return nXCreateColormap(display, w, visual.address(), alloc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int XFreeColormap(@NativeType("Display *") long display, @NativeType("Colormap") long colormap) {
/* 490 */     long __functionAddress = Functions.XFreeColormap;
/* 491 */     if (Checks.CHECKS) {
/* 492 */       Checks.check(display);
/*     */     }
/* 494 */     return JNI.invokePNI(display, colormap, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXCreateWindow(long display, long parent, int x, int y, int width, int height, int border_width, int depth, int windowClass, long visual, long valuemask, long attributes) {
/* 501 */     long __functionAddress = Functions.XCreateWindow;
/* 502 */     if (Checks.CHECKS) {
/* 503 */       Checks.check(display);
/*     */     }
/* 505 */     return JNI.invokePNPNPN(display, parent, x, y, width, height, border_width, depth, windowClass, visual, valuemask, attributes, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Window")
/*     */   public static long XCreateWindow(@NativeType("Display *") long display, @NativeType("Window") long parent, int x, int y, @NativeType("unsigned int") int width, @NativeType("unsigned int") int height, @NativeType("unsigned int") int border_width, int depth, @NativeType("unsigned int") int windowClass, @NativeType("Visual *") Visual visual, @NativeType("unsigned long") long valuemask, @NativeType("XSetWindowAttributes *") XSetWindowAttributes attributes) {
/* 511 */     return nXCreateWindow(display, parent, x, y, width, height, border_width, depth, windowClass, visual.address(), valuemask, attributes.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int XDestroyWindow(@NativeType("Display *") long display, @NativeType("Window") long w) {
/* 518 */     long __functionAddress = Functions.XDestroyWindow;
/* 519 */     if (Checks.CHECKS) {
/* 520 */       Checks.check(display);
/*     */     }
/* 522 */     return JNI.invokePNI(display, w, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nXFree(long data) {
/* 529 */     long __functionAddress = Functions.XFree;
/* 530 */     return JNI.invokePI(data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int XFree(@NativeType("void *") ByteBuffer data) {
/* 535 */     return nXFree(MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int XFree(@NativeType("void *") PointerBuffer data) {
/* 540 */     return nXFree(MemoryUtil.memAddress((CustomBuffer)data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nXSendEvent(long display, long w, int propagate, long event_mask, long event_send) {
/* 547 */     long __functionAddress = Functions.XSendEvent;
/* 548 */     if (Checks.CHECKS) {
/* 549 */       Checks.check(display);
/*     */     }
/* 551 */     return JNI.invokePNNPI(display, w, propagate, event_mask, event_send, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Status")
/*     */   public static int XSendEvent(@NativeType("Display *") long display, @NativeType("Window") long w, @NativeType("Bool") boolean propagate, long event_mask, @NativeType("XEvent *") XEvent event_send) {
/* 557 */     return nXSendEvent(display, w, propagate ? 1 : 0, event_mask, event_send.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned long")
/*     */   public static long XDisplayMotionBufferSize(@NativeType("Display *") long display) {
/* 565 */     long __functionAddress = Functions.XDisplayMotionBufferSize;
/* 566 */     if (Checks.CHECKS) {
/* 567 */       Checks.check(display);
/*     */     }
/* 569 */     return JNI.invokePN(display, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nXGetMotionEvents(long display, long w, long start, long stop, long nevents_return) {
/* 576 */     long __functionAddress = Functions.XGetMotionEvents;
/* 577 */     if (Checks.CHECKS) {
/* 578 */       Checks.check(display);
/*     */     }
/* 580 */     return JNI.invokePNNNPP(display, w, start, stop, nevents_return, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("XTimeCoord *")
/*     */   public static XTimeCoord.Buffer XGetMotionEvents(@NativeType("Display *") long display, @NativeType("Window") long w, @NativeType("Time") long start, @NativeType("Time") long stop) {
/* 586 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 587 */     IntBuffer nevents_return = stack.callocInt(1);
/*     */     try {
/* 589 */       long __result = nXGetMotionEvents(display, w, start, stop, MemoryUtil.memAddress(nevents_return));
/* 590 */       return XTimeCoord.createSafe(__result, nevents_return.get(0));
/*     */     } finally {
/* 592 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nXTranslateCoordinates(long display, long src_w, long dest_w, int src_x, int src_y, long dest_x_return, long dest_y_return, long child_return) {
/* 600 */     long __functionAddress = Functions.XTranslateCoordinates;
/* 601 */     if (Checks.CHECKS) {
/* 602 */       Checks.check(display);
/*     */     }
/* 604 */     return JNI.invokePNNPPPI(display, src_w, dest_w, src_x, src_y, dest_x_return, dest_y_return, child_return, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean XTranslateCoordinates(@NativeType("Display *") long display, @NativeType("Window") long src_w, @NativeType("Window") long dest_w, int src_x, int src_y, @NativeType("int *") IntBuffer dest_x_return, @NativeType("int *") IntBuffer dest_y_return, @NativeType("Window *") CLongBuffer child_return) {
/* 610 */     if (Checks.CHECKS) {
/* 611 */       Checks.check(dest_x_return, 1);
/* 612 */       Checks.check(dest_y_return, 1);
/* 613 */       Checks.check((CustomBuffer)child_return, 1);
/*     */     } 
/* 615 */     return (nXTranslateCoordinates(display, src_w, dest_w, src_x, src_y, MemoryUtil.memAddress(dest_x_return), MemoryUtil.memAddress(dest_y_return), MemoryUtil.memAddress((CustomBuffer)child_return)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean XTranslateCoordinates(@NativeType("Display *") long display, @NativeType("Window") long src_w, @NativeType("Window") long dest_w, int src_x, int src_y, @NativeType("int *") int[] dest_x_return, @NativeType("int *") int[] dest_y_return, @NativeType("Window *") CLongBuffer child_return) {
/* 621 */     long __functionAddress = Functions.XTranslateCoordinates;
/* 622 */     if (Checks.CHECKS) {
/* 623 */       Checks.check(display);
/* 624 */       Checks.check(dest_x_return, 1);
/* 625 */       Checks.check(dest_y_return, 1);
/* 626 */       Checks.check((CustomBuffer)child_return, 1);
/*     */     } 
/* 628 */     return (JNI.invokePNNPPPI(display, src_w, dest_w, src_x, src_y, dest_x_return, dest_y_return, MemoryUtil.memAddress((CustomBuffer)child_return), __functionAddress) != 0);
/*     */   } }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\X11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */