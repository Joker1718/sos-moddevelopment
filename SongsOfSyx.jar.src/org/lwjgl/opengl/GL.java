/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ import org.lwjgl.system.ThreadLocalUtil;
/*     */ import org.lwjgl.system.linux.X11;
/*     */ import org.lwjgl.system.windows.GDI32;
/*     */ import org.lwjgl.system.windows.PIXELFORMATDESCRIPTOR;
/*     */ import org.lwjgl.system.windows.User32;
/*     */ import org.lwjgl.system.windows.WNDCLASSEX;
/*     */ import org.lwjgl.system.windows.WindowsLibrary;
/*     */ import org.lwjgl.system.windows.WindowsUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GL
/*     */ {
/*     */   private static final APIUtil.APIVersion MAX_VERSION;
/*     */   private static FunctionProvider functionProvider;
/*  64 */   private static final ThreadLocal<GLCapabilities> capabilitiesTLS = new ThreadLocal<>();
/*     */   
/*  66 */   private static ICD icd = new ICDStatic();
/*     */   
/*     */   private static WGLCapabilities capabilitiesWGL;
/*     */   
/*     */   private static GLXCapabilities capabilitiesGLXClient;
/*     */   private static GLXCapabilities capabilitiesGLX;
/*     */   
/*     */   static {
/*  74 */     Library.loadSystem(System::load, System::loadLibrary, GL.class, "org.lwjgl.opengl", Platform.mapLibraryNameBundled("lwjgl_opengl"));
/*     */     
/*  76 */     MAX_VERSION = APIUtil.apiParseVersion(Configuration.OPENGL_MAXVERSION);
/*     */     
/*  78 */     if (!((Boolean)Configuration.OPENGL_EXPLICIT_INIT.get(Boolean.valueOf(false))).booleanValue()) {
/*  79 */       create();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void initialize() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create() {
/*  92 */     SharedLibrary sharedLibrary = null;
/*     */     
/*  94 */     String contextAPI = (String)Configuration.OPENGL_CONTEXT_API.get();
/*     */     
/*  96 */     boolean tryEGL = ("EGL".equals(contextAPI) || (contextAPI == null && isWayland()));
/*  97 */     if (tryEGL) {
/*  98 */       sharedLibrary = loadEGL();
/*  99 */     } else if ("OSMesa".equals(contextAPI)) {
/* 100 */       sharedLibrary = loadOSMesa();
/*     */     } 
/*     */     
/* 103 */     if (sharedLibrary == null) {
/* 104 */       sharedLibrary = loadNative();
/* 105 */       if (sharedLibrary == null && !"native".equals(contextAPI)) {
/* 106 */         if (!tryEGL) {
/* 107 */           sharedLibrary = loadEGL();
/*     */         }
/* 109 */         if (sharedLibrary == null && !"OSMesa".equals(contextAPI)) {
/* 110 */           sharedLibrary = loadOSMesa();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     if (sharedLibrary == null) {
/* 116 */       throw new IllegalStateException("There is no OpenGL context management API available.");
/*     */     }
/*     */     
/* 119 */     create(sharedLibrary);
/*     */   }
/*     */   
/*     */   private static boolean isWayland() {
/* 123 */     switch (Platform.get()) {
/*     */       
/*     */       case FREEBSD:
/*     */       case LINUX:
/* 127 */         if ("wayland".equals(System.getenv("XDG_SESSION_TYPE")) && System.getenv("WAYLAND_DISPLAY") != null)
/* 128 */           return true; 
/*     */         break;
/*     */     } 
/* 131 */     return false;
/*     */   }
/*     */   
/*     */   private static SharedLibrary loadNative() {
/*     */     try {
/* 136 */       return Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_LIBRARY_NAME, Configuration.OPENGL_LIBRARY_NAME_DEFAULTS());
/* 137 */     } catch (Throwable ignored) {
/* 138 */       APIUtil.apiLog("[GL] Failed to initialize context management based on native OpenGL platform API");
/* 139 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static SharedLibrary loadEGL() {
/*     */     try {
/* 145 */       return Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.EGL_LIBRARY_NAME, Configuration.EGL_LIBRARY_NAME_DEFAULTS());
/* 146 */     } catch (Throwable ignored) {
/* 147 */       APIUtil.apiLog("[GL] Failed to initialize context management based on EGL");
/* 148 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static SharedLibrary loadOSMesa() {
/*     */     try {
/* 154 */       return Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_OSMESA_LIBRARY_NAME, Configuration.OPENGL_OSMESA_LIBRARY_NAME_DEFAULTS());
/* 155 */     } catch (Throwable ignored) {
/* 156 */       APIUtil.apiLog("[GL] Failed to initialize context management based on OSMesa");
/* 157 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(String libName) {
/* 167 */     create(Library.loadNative(GL.class, "org.lwjgl.opengl", libName));
/*     */   }
/*     */   
/*     */   private static void create(SharedLibrary OPENGL) {
/*     */     try {
/* 172 */       create((FunctionProvider)new SharedLibrary.Delegate(OPENGL)
/*     */           {
/*     */             private final long GetProcAddress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public long getFunctionAddress(ByteBuffer functionName) {
/* 202 */               long address = (this.GetProcAddress == 0L) ? 0L : JNI.callPP(MemoryUtil.memAddress(functionName), this.GetProcAddress);
/* 203 */               if (address == 0L) {
/* 204 */                 address = this.library.getFunctionAddress(functionName);
/* 205 */                 if (address == 0L && Checks.DEBUG_FUNCTIONS) {
/* 206 */                   APIUtil.apiLogMissing("GL", functionName);
/*     */                 }
/*     */               } 
/*     */               
/* 210 */               return address;
/*     */             }
/*     */           });
/* 213 */     } catch (RuntimeException e) {
/* 214 */       OPENGL.free();
/* 215 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(FunctionProvider functionProvider) {
/* 225 */     if (GL.functionProvider != null) {
/* 226 */       throw new IllegalStateException("OpenGL library has already been loaded.");
/*     */     }
/*     */     
/* 229 */     GL.functionProvider = functionProvider;
/* 230 */     ThreadLocalUtil.setFunctionMissingAddresses(2236);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void destroy() {
/* 235 */     if (functionProvider == null) {
/*     */       return;
/*     */     }
/*     */     
/* 239 */     ThreadLocalUtil.setFunctionMissingAddresses(0);
/*     */     
/* 241 */     capabilitiesWGL = null;
/* 242 */     capabilitiesGLX = null;
/*     */     
/* 244 */     if (functionProvider instanceof NativeResource) {
/* 245 */       ((NativeResource)functionProvider).free();
/*     */     }
/* 247 */     functionProvider = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static FunctionProvider getFunctionProvider() {
/* 252 */     return functionProvider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCapabilities(GLCapabilities caps) {
/* 262 */     capabilitiesTLS.set(caps);
/* 263 */     ThreadLocalUtil.setCapabilities((caps == null) ? 0L : MemoryUtil.memAddress((CustomBuffer)caps.addresses));
/* 264 */     icd.set(caps);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLCapabilities getCapabilities() {
/* 273 */     return checkCapabilities(capabilitiesTLS.get());
/*     */   }
/*     */   
/*     */   private static GLCapabilities checkCapabilities(GLCapabilities caps) {
/* 277 */     if (Checks.CHECKS && caps == null) {
/* 278 */       throw new IllegalStateException("No GLCapabilities instance set for the current thread. Possible solutions:\n\ta) Call GL.createCapabilities() after making a context current in the current thread.\n\tb) Call GL.setCapabilities() if a GLCapabilities instance already exists for the current context.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     return caps;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WGLCapabilities getCapabilitiesWGL() {
/* 294 */     if (capabilitiesWGL == null) {
/* 295 */       capabilitiesWGL = createCapabilitiesWGLDummy();
/*     */     }
/*     */     
/* 298 */     return capabilitiesWGL;
/*     */   }
/*     */ 
/*     */   
/*     */   static GLXCapabilities getCapabilitiesGLXClient() {
/* 303 */     if (capabilitiesGLXClient == null) {
/* 304 */       capabilitiesGLXClient = initCapabilitiesGLX(true);
/*     */     }
/*     */     
/* 307 */     return capabilitiesGLXClient;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXCapabilities getCapabilitiesGLX() {
/* 316 */     if (capabilitiesGLX == null) {
/* 317 */       capabilitiesGLX = initCapabilitiesGLX(false);
/*     */     }
/*     */     
/* 320 */     return capabilitiesGLX;
/*     */   }
/*     */   
/*     */   private static GLXCapabilities initCapabilitiesGLX(boolean client) {
/* 324 */     long display = X11.nXOpenDisplay(0L);
/*     */     try {
/* 326 */       return createCapabilitiesGLX(display, client ? -1 : X11.XDefaultScreen(display));
/*     */     } finally {
/* 328 */       X11.XCloseDisplay(display);
/*     */     } 
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
/*     */   public static GLCapabilities createCapabilities() {
/* 342 */     return createCapabilities((IntFunction<PointerBuffer>)null);
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
/*     */   public static GLCapabilities createCapabilities(IntFunction<PointerBuffer> bufferFactory) {
/* 358 */     return createCapabilities(false, bufferFactory);
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
/*     */   public static GLCapabilities createCapabilities(boolean forwardCompatible) {
/* 374 */     return createCapabilities(forwardCompatible, null);
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
/*     */   public static GLCapabilities createCapabilities(boolean forwardCompatible, IntFunction<PointerBuffer> bufferFactory) {
/*     */     int majorVersion, minorVersion;
/* 393 */     FunctionProvider functionProvider = GL.functionProvider;
/* 394 */     if (functionProvider == null) {
/* 395 */       throw new IllegalStateException("OpenGL library has not been loaded.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 400 */     long GetError = functionProvider.getFunctionAddress("glGetError");
/* 401 */     long GetString = functionProvider.getFunctionAddress("glGetString");
/* 402 */     long GetIntegerv = functionProvider.getFunctionAddress("glGetIntegerv");
/*     */     
/* 404 */     if (GetError == 0L || GetString == 0L || GetIntegerv == 0L) {
/* 405 */       throw new IllegalStateException("Core OpenGL functions could not be found. Make sure that the OpenGL library has been loaded correctly.");
/*     */     }
/*     */     
/* 408 */     int errorCode = JNI.callI(GetError);
/* 409 */     if (errorCode != 0) {
/* 410 */       APIUtil.apiLog(String.format("An OpenGL context was in an error state before the creation of its capabilities instance. Error: 0x%X", new Object[] { Integer.valueOf(errorCode) }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 416 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 417 */       IntBuffer version = stack.ints(0);
/*     */ 
/*     */       
/* 420 */       JNI.callPV(33307, MemoryUtil.memAddress(version), GetIntegerv);
/* 421 */       if (JNI.callI(GetError) == 0 && 3 <= (majorVersion = version.get(0))) {
/*     */         
/* 423 */         JNI.callPV(33308, MemoryUtil.memAddress(version), GetIntegerv);
/* 424 */         minorVersion = version.get(0);
/*     */       } else {
/*     */         
/* 427 */         String versionString = MemoryUtil.memUTF8Safe(JNI.callP(7938, GetString));
/* 428 */         if (versionString == null || JNI.callI(GetError) != 0) {
/* 429 */           throw new IllegalStateException("There is no OpenGL context current in the current thread.");
/*     */         }
/*     */         
/* 432 */         APIUtil.APIVersion apiVersion = APIUtil.apiParseVersion(versionString);
/*     */         
/* 434 */         majorVersion = apiVersion.major;
/* 435 */         minorVersion = apiVersion.minor;
/*     */       } 
/*     */     } 
/*     */     
/* 439 */     if (majorVersion < 1 || (majorVersion == 1 && minorVersion < 1)) {
/* 440 */       throw new IllegalStateException("OpenGL 1.1 is required.");
/*     */     }
/*     */     
/* 443 */     int[] GL_VERSIONS = { 5, 1, 3, 6 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 450 */     Set<String> supportedExtensions = new HashSet<>(512);
/*     */     
/* 452 */     int maxMajor = Math.min(majorVersion, GL_VERSIONS.length);
/* 453 */     if (MAX_VERSION != null) {
/* 454 */       maxMajor = Math.min(MAX_VERSION.major, maxMajor);
/*     */     }
/* 456 */     for (int M = 1; M <= maxMajor; M++) {
/* 457 */       int maxMinor = GL_VERSIONS[M - 1];
/* 458 */       if (M == majorVersion) {
/* 459 */         maxMinor = Math.min(minorVersion, maxMinor);
/*     */       }
/* 461 */       if (MAX_VERSION != null && M == MAX_VERSION.major) {
/* 462 */         maxMinor = Math.min(MAX_VERSION.minor, maxMinor);
/*     */       }
/*     */       
/* 465 */       for (int m = (M == 1) ? 1 : 0; m <= maxMinor; m++) {
/* 466 */         supportedExtensions.add("OpenGL" + M + m);
/*     */       }
/*     */     } 
/*     */     
/* 470 */     if (majorVersion < 3) {
/*     */       
/* 472 */       String extensionsString = MemoryUtil.memASCIISafe(JNI.callP(7939, GetString));
/* 473 */       if (extensionsString != null) {
/* 474 */         StringTokenizer tokenizer = new StringTokenizer(extensionsString);
/* 475 */         while (tokenizer.hasMoreTokens()) {
/* 476 */           supportedExtensions.add(tokenizer.nextToken());
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 481 */       try (MemoryStack stack = MemoryStack.stackPush()) {
/* 482 */         IntBuffer pi = memoryStack.ints(0);
/*     */         
/* 484 */         JNI.callPV(33309, MemoryUtil.memAddress(pi), GetIntegerv);
/* 485 */         int extensionCount = pi.get(0);
/*     */         
/* 487 */         long GetStringi = APIUtil.apiGetFunctionAddress(functionProvider, "glGetStringi");
/* 488 */         for (int i = 0; i < extensionCount; i++) {
/* 489 */           supportedExtensions.add(MemoryUtil.memASCII(JNI.callP(7939, i, GetStringi)));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 498 */         JNI.callPV(33310, MemoryUtil.memAddress(pi), GetIntegerv);
/* 499 */         if ((pi.get(0) & 0x1) != 0) {
/* 500 */           forwardCompatible = true;
/*     */         
/*     */         }
/* 503 */         else if (3 < majorVersion || 1 <= minorVersion) {
/* 504 */           if (3 < majorVersion || 2 <= minorVersion) {
/* 505 */             JNI.callPV(37158, MemoryUtil.memAddress(pi), GetIntegerv);
/* 506 */             if ((pi.get(0) & 0x1) != 0) {
/* 507 */               forwardCompatible = true;
/*     */             }
/*     */           } else {
/* 510 */             forwardCompatible = !supportedExtensions.contains("GL_ARB_compatibility");
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 516 */     APIUtil.apiFilterExtensions(supportedExtensions, Configuration.OPENGL_EXTENSION_FILTER);
/*     */     
/* 518 */     GLCapabilities caps = new GLCapabilities(functionProvider, supportedExtensions, forwardCompatible, (bufferFactory == null) ? BufferUtils::createPointerBuffer : bufferFactory);
/*     */ 
/*     */ 
/*     */     
/* 522 */     setCapabilities(caps);
/*     */     
/* 524 */     return caps;
/*     */   }
/*     */ 
/*     */   
/*     */   private static WGLCapabilities createCapabilitiesWGLDummy() {
/* 529 */     long hdc = WGL.wglGetCurrentDC();
/* 530 */     if (hdc != 0L) {
/* 531 */       return createCapabilitiesWGL(hdc);
/*     */     }
/*     */     
/* 534 */     short classAtom = 0;
/* 535 */     long hwnd = 0L;
/* 536 */     long hglrc = 0L;
/* 537 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 538 */       IntBuffer pi = stack.mallocInt(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 544 */       WNDCLASSEX wc = WNDCLASSEX.calloc(stack).cbSize(WNDCLASSEX.SIZEOF).style(3).hInstance(WindowsLibrary.HINSTANCE).lpszClassName(stack.UTF16("WGL"));
/*     */       
/* 546 */       MemoryUtil.memPutAddress(wc
/* 547 */           .address() + WNDCLASSEX.LPFNWNDPROC, User32.Functions.DefWindowProc);
/*     */ 
/*     */ 
/*     */       
/* 551 */       classAtom = User32.RegisterClassEx(pi, wc);
/* 552 */       if (classAtom == 0) {
/* 553 */         WindowsUtil.windowsThrowException("Failed to register WGL window class", pi);
/*     */       }
/*     */       
/* 556 */       hwnd = User32.nCreateWindowEx(
/* 557 */           MemoryUtil.memAddress(pi), 0, (classAtom & 0xFFFF), 0L, 114229248, 0, 0, 1, 1, 0L, 0L, 0L, 0L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 563 */       if (hwnd == 0L) {
/* 564 */         WindowsUtil.windowsThrowException("Failed to create WGL window", pi);
/*     */       }
/*     */       
/* 567 */       hdc = Checks.check(User32.GetDC(hwnd));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 572 */       PIXELFORMATDESCRIPTOR pfd = PIXELFORMATDESCRIPTOR.calloc(stack).nSize((short)PIXELFORMATDESCRIPTOR.SIZEOF).nVersion((short)1).dwFlags(32);
/*     */       
/* 574 */       int pixelFormat = GDI32.ChoosePixelFormat(pi, hdc, pfd);
/* 575 */       if (pixelFormat == 0) {
/* 576 */         WindowsUtil.windowsThrowException("Failed to choose an OpenGL-compatible pixel format", pi);
/*     */       }
/*     */       
/* 579 */       if (GDI32.DescribePixelFormat(pi, hdc, pixelFormat, pfd) == 0) {
/* 580 */         WindowsUtil.windowsThrowException("Failed to obtain pixel format information", pi);
/*     */       }
/*     */       
/* 583 */       if (!GDI32.SetPixelFormat(pi, hdc, pixelFormat, pfd)) {
/* 584 */         WindowsUtil.windowsThrowException("Failed to set the pixel format", pi);
/*     */       }
/*     */       
/* 587 */       hglrc = Checks.check(WGL.wglCreateContext(null, hdc));
/* 588 */       if (!WGL.wglMakeCurrent(pi, hdc, hglrc)) {
/* 589 */         WindowsUtil.windowsThrowException("Failed to make context current", pi);
/*     */       }
/*     */       
/* 592 */       return createCapabilitiesWGL(hdc);
/*     */     } finally {
/* 594 */       if (hglrc != 0L) {
/* 595 */         WGL.wglMakeCurrent(null, 0L, 0L);
/* 596 */         WGL.wglDeleteContext(null, hglrc);
/*     */       } 
/*     */       
/* 599 */       if (hwnd != 0L) {
/* 600 */         User32.DestroyWindow(null, hwnd);
/*     */       }
/*     */       
/* 603 */       if (classAtom != 0) {
/* 604 */         User32.nUnregisterClass(0L, (classAtom & 0xFFFF), WindowsLibrary.HINSTANCE);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WGLCapabilities createCapabilitiesWGL() {
/* 615 */     long hdc = WGL.wglGetCurrentDC();
/* 616 */     if (hdc == 0L) {
/* 617 */       throw new IllegalStateException("Failed to retrieve the device context of the current OpenGL context");
/*     */     }
/*     */     
/* 620 */     return createCapabilitiesWGL(hdc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static WGLCapabilities createCapabilitiesWGL(long hdc) {
/* 629 */     FunctionProvider functionProvider = GL.functionProvider;
/* 630 */     if (functionProvider == null) {
/* 631 */       throw new IllegalStateException("OpenGL library has not been loaded.");
/*     */     }
/*     */     
/* 634 */     String extensionsString = null;
/*     */     
/* 636 */     long wglGetExtensionsString = functionProvider.getFunctionAddress("wglGetExtensionsStringARB");
/* 637 */     if (wglGetExtensionsString != 0L) {
/* 638 */       extensionsString = MemoryUtil.memASCII(JNI.callPP(hdc, wglGetExtensionsString));
/*     */     } else {
/* 640 */       wglGetExtensionsString = functionProvider.getFunctionAddress("wglGetExtensionsStringEXT");
/* 641 */       if (wglGetExtensionsString != 0L) {
/* 642 */         extensionsString = MemoryUtil.memASCII(JNI.callP(wglGetExtensionsString));
/*     */       }
/*     */     } 
/*     */     
/* 646 */     Set<String> supportedExtensions = new HashSet<>(32);
/*     */     
/* 648 */     if (extensionsString != null) {
/* 649 */       StringTokenizer tokenizer = new StringTokenizer(extensionsString);
/* 650 */       while (tokenizer.hasMoreTokens()) {
/* 651 */         supportedExtensions.add(tokenizer.nextToken());
/*     */       }
/*     */     } 
/*     */     
/* 655 */     APIUtil.apiFilterExtensions(supportedExtensions, Configuration.OPENGL_EXTENSION_FILTER);
/*     */     
/* 657 */     return new WGLCapabilities(functionProvider, supportedExtensions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXCapabilities createCapabilitiesGLX(long display) {
/* 668 */     return createCapabilitiesGLX(display, X11.XDefaultScreen(display));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLXCapabilities createCapabilitiesGLX(long display, int screen) {
/*     */     int majorVersion, minorVersion;
/* 680 */     FunctionProvider functionProvider = GL.functionProvider;
/* 681 */     if (functionProvider == null) {
/* 682 */       throw new IllegalStateException("OpenGL library has not been loaded.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 688 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 689 */       IntBuffer piMajor = stack.ints(0);
/* 690 */       IntBuffer piMinor = stack.ints(0);
/*     */       
/* 692 */       if (!GLX11.glXQueryVersion(display, piMajor, piMinor)) {
/* 693 */         throw new IllegalStateException("Failed to query GLX version");
/*     */       }
/*     */       
/* 696 */       majorVersion = piMajor.get(0);
/* 697 */       minorVersion = piMinor.get(0);
/* 698 */       if (majorVersion != 1) {
/* 699 */         throw new IllegalStateException("Invalid GLX major version: " + majorVersion);
/*     */       }
/*     */     } 
/*     */     
/* 703 */     Set<String> supportedExtensions = new HashSet<>(32);
/*     */     
/* 705 */     int[][] GLX_VERSIONS = { { 1, 2, 3, 4 } };
/*     */ 
/*     */ 
/*     */     
/* 709 */     for (int major = 1; major <= GLX_VERSIONS.length; major++) {
/* 710 */       int[] minors = GLX_VERSIONS[major - 1];
/* 711 */       for (int minor : minors) {
/* 712 */         if (major < majorVersion || (major == majorVersion && minor <= minorVersion)) {
/* 713 */           supportedExtensions.add("GLX" + major + minor);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 718 */     if (1 <= minorVersion) {
/*     */       String extensionsString;
/*     */       
/* 721 */       if (screen == -1) {
/* 722 */         long glXGetClientString = functionProvider.getFunctionAddress("glXGetClientString");
/* 723 */         extensionsString = MemoryUtil.memASCIISafe(JNI.callPP(display, 3, glXGetClientString));
/*     */       } else {
/* 725 */         long glXQueryExtensionsString = functionProvider.getFunctionAddress("glXQueryExtensionsString");
/* 726 */         extensionsString = MemoryUtil.memASCIISafe(JNI.callPP(display, screen, glXQueryExtensionsString));
/*     */       } 
/*     */       
/* 729 */       if (extensionsString != null) {
/* 730 */         StringTokenizer tokenizer = new StringTokenizer(extensionsString);
/* 731 */         while (tokenizer.hasMoreTokens()) {
/* 732 */           supportedExtensions.add(tokenizer.nextToken());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 737 */     APIUtil.apiFilterExtensions(supportedExtensions, Configuration.OPENGL_EXTENSION_FILTER);
/*     */     
/* 739 */     return new GLXCapabilities(functionProvider, supportedExtensions);
/*     */   }
/*     */ 
/*     */   
/*     */   static GLCapabilities getICD() {
/* 744 */     return checkCapabilities(icd.get());
/*     */   }
/*     */ 
/*     */   
/*     */   private static interface ICD
/*     */   {
/*     */     default void set(GLCapabilities caps) {}
/*     */ 
/*     */     
/*     */     GLCapabilities get();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ICDStatic
/*     */     implements ICD
/*     */   {
/*     */     private static GLCapabilities tempCaps;
/*     */ 
/*     */     
/*     */     private ICDStatic() {}
/*     */     
/*     */     public void set(GLCapabilities caps) {
/* 766 */       if (tempCaps == null) {
/* 767 */         tempCaps = caps;
/* 768 */       } else if (caps != null && caps != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses, caps.addresses)) {
/* 769 */         APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread-local lookup for GL contexts.");
/* 770 */         GL.icd = GL::getCapabilities;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public GLCapabilities get() {
/* 776 */       return WriteOnce.caps;
/*     */     }
/*     */     
/*     */     private static final class WriteOnce
/*     */     {
/*     */       static final GLCapabilities caps;
/*     */       
/*     */       static {
/* 784 */         GLCapabilities tempCaps = GL.ICDStatic.tempCaps;
/* 785 */         if (tempCaps == null) {
/* 786 */           throw new IllegalStateException("No GLCapabilities instance has been set");
/*     */         }
/* 788 */         caps = tempCaps;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */