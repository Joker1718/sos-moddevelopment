/*     */ package snake2d;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.Version;
/*     */ import org.lwjgl.glfw.Callbacks;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWErrorCallback;
/*     */ import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
/*     */ import org.lwjgl.glfw.GLFWNativeCocoa;
/*     */ import org.lwjgl.glfw.GLFWVidMode;
/*     */ import org.lwjgl.opengl.GL;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.macosx.ObjCRuntime;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileManager;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.OS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphicContext
/*     */ {
/*     */   public final int nativeWidth;
/*     */   public final int nativeHeight;
/*     */   public final int displayWidth;
/*     */   public final int displayHeight;
/*     */   public final Coo blitArea;
/*     */   private volatile boolean windowIsFocused = true;
/*     */   final int refreshRate;
/*     */   private final GlHelper gl;
/*     */   private final long window;
/*     */   final Renderer renderer;
/*     */   final String screenShotPath;
/*     */   static boolean diagnosing = false;
/* 117 */   private static int diagnoseTimer = 0;
/*     */   private final boolean debugAll;
/*     */   private final boolean macHack;
/* 120 */   public final Coo mouseWindow = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TextureHolder texture;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int chi;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int bi;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Error
/*     */   {
/*     */     private String mess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Error() {
/* 422 */       GraphicsCardGetter g = new GraphicsCardGetter();
/* 423 */       this.mess = "The game failed setting up openGl on your graphics card. This is likeley because your graphics card has no opengl 3.3 support. Some PC's have multiple graphics cards. In this case, try configuring the app to use the other.graphics card in graphic card's control panel. (You may need to do this for java as well.) ";
/*     */ 
/*     */ 
/*     */       
/* 427 */       this.mess = String.valueOf(this.mess) + System.lineSeparator();
/*     */       
/* 429 */       this.mess = String.valueOf(this.mess) + "Current graphics card: ";
/* 430 */       this.mess = String.valueOf(this.mess) + g.version();
/*     */       
/* 432 */       this.mess = String.valueOf(this.mess) + System.lineSeparator();
/* 433 */       this.mess = String.valueOf(this.mess) + System.lineSeparator();
/*     */       
/* 435 */       this.mess = String.valueOf(this.mess) + "If your graphics card does not support opengl 3.3 or higher, please do not report this error.";
/* 436 */       if (g.version() == null) {
/* 437 */         throw get("version");
/*     */       }
/*     */     }
/*     */     
/*     */     Errors.GameError get(String message) {
/* 442 */       return new Errors.GameError(String.valueOf(this.mess) + System.lineSeparator() + message);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String render() {
/* 448 */     return GlHelper.renderer;
/*     */   }
/*     */   
/*     */   public String renderV() {
/* 452 */     return GlHelper.rendererV;
/*     */   }
/*     */   
/*     */   private void printSettings(SETTINGS sett) {
/* 456 */     Printer.ln("SETTINGS");
/* 457 */     Printer.ln("Debug: " + sett.debugMode());
/* 458 */     Printer.ln("Native Screen: " + sett.getNativeWidth() + "x" + sett.getNativeHeight());
/* 459 */     Printer.ln("Display: " + sett.display());
/* 460 */     Printer.ln("Full: " + (sett.display()).fullScreen);
/* 461 */     Printer.ln("Mode: " + sett.getRenderMode());
/* 462 */     Printer.ln("Fit: " + sett.getFitToScreen());
/* 463 */     Printer.ln("Linear: " + sett.getLinearFiltering());
/* 464 */     Printer.ln("VSync: " + sett.getVSynchEnabled());
/* 465 */     Printer.fin();
/*     */   }
/*     */   
/*     */   void makeVisable() {
/* 469 */     GLFW.glfwShowWindow(this.window);
/* 470 */     GLFW.glfwFocusWindow(this.window);
/*     */     
/* 472 */     if (this.macHack) {
/* 473 */       long nsWindow = GLFWNativeCocoa.glfwGetCocoaWindow(this.window);
/* 474 */       if (nsWindow == 0L) {
/* 475 */         Printer.ln("Cocoa: nsWindow == 0 (can't toggle fullscreen)");
/*     */         return;
/*     */       } 
/* 478 */       long selToggle = ObjCRuntime.sel_registerName("toggleFullScreen:");
/* 479 */       long msgSend = ObjCRuntime.getLibrary().getFunctionAddress("objc_msgSend");
/* 480 */       JNI.invokePPV(nsWindow, selToggle, 0.0F, msgSend);
/*     */     } 
/*     */   }
/*     */   
/*     */   final void setTexture(TextureHolder texture) {
/* 485 */     this.texture = texture;
/*     */   }
/*     */   
/*     */   void flushRenderer() {
/* 489 */     this.renderer.flush();
/* 490 */     if (this.texture != null)
/* 491 */       this.texture.flush(); 
/*     */   }
/*     */   
/* 494 */   GraphicContext(SETTINGS sett) { this.chi = 0;
/* 495 */     this.bi = -1; this.debugAll = sett.debugMode(); Configuration.DEBUG.set(Boolean.valueOf(this.debugAll)); Configuration.DEBUG_STREAM.set(System.out); Configuration.DEBUG_MEMORY_ALLOCATOR.set(Boolean.valueOf(this.debugAll)); Configuration.DEBUG_STACK.set(Boolean.valueOf(this.debugAll)); Error error = new Error(); if (sett.getScreenshotFolder() != null) { this.screenShotPath = sett.getScreenshotFolder(); } else { File f = new File("screenshots"); if (f.exists() && !f.isDirectory()) f.delete();  if (!f.exists()) f.mkdirs();  this.screenShotPath = String.valueOf(f.getAbsolutePath()) + File.separator; }  if (sett.getPointSize() != 1 && sett.getPointSize() % 2 != 0) throw new RuntimeException("pointsize must be a power of two!");  if (this.debugAll) GLFWErrorCallback.createPrint(System.out).set();  if (OS.get() == OS.LINUX) GLFW.glfwInitHint(339969, 229378);  if (!GLFW.glfwInit()) throw new IllegalStateException("Unable to initialize GLFW");  GLFW.glfwDefaultWindowHints(); GLFW.glfwWindowHint(131075, 0); GLFW.glfwWindowHint(131076, 0); GLFW.glfwWindowHint(131073, 1); GLFW.glfwWindowHint(131084, 1); GLFW.glfwWindowHint(131079, sett.windowFloating() ? 1 : 0); GLFW.glfwWindowHint(135169, 8); GLFW.glfwWindowHint(135170, 8); GLFW.glfwWindowHint(135171, 8); GLFW.glfwWindowHint(135172, 8); GLFW.glfwWindowHint(135173, 0); GLFW.glfwWindowHint(135174, 0); GLFW.glfwWindowHint(135181, 0); GLFW.glfwWindowHint(135183, -1); GLFW.glfwWindowHint(135180, 0); GLFW.glfwWindowHint(135182, 0); GLFW.glfwWindowHint(135184, 1); GLFW.glfwWindowHint(139265, 196609); GLFW.glfwWindowHint(139266, 3); GLFW.glfwWindowHint(139267, 3); GLFW.glfwWindowHint(139272, 204801); GLFW.glfwWindowHint(139269, 0); GLFW.glfwWindowHint(139273, 0); GLFW.glfwWindowHint(139270, 1); GLFW.glfwWindowHint(139271, this.debugAll ? 1 : 0); GLFW.glfwWindowHint(139277, 1); GLFW.glfwWindowHint(131078, sett.autoIconify() ? 1 : 0); GLFW.glfwInitHint(339969, 229378); printSettings(sett); Printer.ln("GRAPHICS"); Displays.DisplayMode wanted = sett.display(); int dispWidth = wanted.width; int dispHeight = wanted.height; this.nativeWidth = sett.getNativeWidth(); this.nativeHeight = sett.getNativeHeight(); int fps = sett.FPS(); if (fps < 0) { this.refreshRate = wanted.refresh; } else { this.refreshRate = CLAMP.i(fps, 20, wanted.refresh); }  GLFW.glfwWindowHint(135183, this.refreshRate); Displays.DisplayMode current = Displays.current(sett.monitor()); if (!wanted.fullScreen && (dispWidth > current.width || dispHeight > current.height)) { dispWidth = current.width; dispHeight = current.height; }  this.displayWidth = dispWidth; this.displayHeight = dispHeight; boolean fullscreen = !(!wanted.fullScreen && (this.displayWidth != current.width || this.displayHeight != current.height)); if (sett.windowFullFull()) fullscreen = false;  boolean macHack = false; if (fullscreen) { macHack = true; fullscreen = false; for (Displays.DisplayMode d : Displays.available(sett.monitor())) { if (d.width == wanted.width && d.height == wanted.height) { macHack = false; fullscreen = true; break; }  }  }  this.macHack = macHack; if (macHack) { GLFW.glfwWindowHint(131075, 1); GLFW.glfwWindowHint(131077, 1); }  boolean dec = sett.decoratedWindow(); if (fullscreen) { GLFWVidMode vm = GLFW.glfwGetVideoMode(Displays.pointer(sett.monitor())); GLFW.glfwWindowHint(135169, vm.redBits()); GLFW.glfwWindowHint(135170, vm.greenBits()); GLFW.glfwWindowHint(135171, vm.blueBits()); GLFW.glfwWindowHint(135183, vm.refreshRate()); } else { GLFW.glfwWindowHint(131077, dec ? 1 : 0); }  try { Printer.ln("---attempting resolution: " + this.displayWidth + "x" + dispHeight + ", " + wanted.refresh + "Hz, " + (fullscreen ? (wanted.fullScreen ? "fullscreen" : "borderless") : "windowed") + ", monitor " + sett.monitor() + " (" + GLFW.glfwGetMonitorName(Displays.pointer(sett.monitor())) + ")"); this.window = GLFW.glfwCreateWindow(this.displayWidth, this.displayHeight, sett.getWindowName(), fullscreen ? Displays.pointer(sett.monitor()) : 0L, 0L); } catch (Exception e) { e.printStackTrace(); throw error.get("window create " + e); }  if (this.window == 0L) throw error.get("window is null");  int[] dx = Alloc.ii(1); int[] dy = Alloc.ii(1); GLFW.glfwGetMonitorPos(Displays.pointer(sett.monitor()), dx, dy); if (!fullscreen && dec) { int x1 = ((Displays.current(sett.monitor())).width - this.displayWidth) / 4; int y1 = ((Displays.current(sett.monitor())).height - this.displayHeight) / 4; if (x1 < 0) x1 = 0;  if (y1 < 0) y1 = 0;  if (sett.decoratedWindow()) y1 += 30;  GLFW.glfwSetWindowPos(this.window, x1 + dx[0], y1 + dy[0]); }  String icons = sett.getIconFolder(); if (icons != null) { _IconLoader.setIcon(this.window, icons); } else { Printer.ln("NOTE: no icon-folder specified"); }  try { GLFW.glfwMakeContextCurrent(this.window); } catch (Exception e) { e.printStackTrace(); throw error.get("make current " + e); }  long monitor = GLFW.glfwGetWindowMonitor(this.window); if (monitor == 0L) monitor = GLFW.glfwGetPrimaryMonitor();  GLFWVidMode vidMode = GLFW.glfwGetVideoMode(monitor); Printer.ln("---Setting FPS to " + vidMode.refreshRate()); int swapInterval = 0; if (sett.getVSynchEnabled() || sett.vsyncAdaptive()) { swapInterval = 1; int r = this.refreshRate; while (vidMode.refreshRate() >= r * 2) { r *= 2; swapInterval++; }  if (sett.vsyncAdaptive() && (GLFW.glfwExtensionSupported("WGL_EXT_swap_control_tear") || GLFW.glfwExtensionSupported("GLX_EXT_swap_control_tear"))) { Printer.ln("---'Adaptive' Vsync enabled (" + swapInterval + ")"); swapInterval *= -1; }  }  GLFW.glfwSwapInterval(swapInterval); Printer.ln("---created resolution: " + vidMode.width() + "x" + vidMode.height() + ", " + vidMode.refreshRate() + "Hz" + (sett.getVSynchEnabled() ? (", vsync: " + swapInterval) : "")); Printer.ln("---LWJGL: " + Version.getVersion()); Printer.ln("---GLFW: " + GLFW.glfwGetVersionString()); this.gl = new GlHelper(sett.getNativeWidth(), sett.getNativeHeight(), this.debugAll); if (!(GL.getCapabilities()).OpenGL33)
/*     */       throw error.get("gl Capabilities");  if (OS.get() == OS.MAC) { this.blitArea = new Coo(GlHelper.FBSize()); } else { IntBuffer w = BufferUtils.createIntBuffer(1); IntBuffer h = BufferUtils.createIntBuffer(1); GLFW.glfwGetFramebufferSize(this.window, w, h); Coo sc = new Coo(w.get(), h.get()); this.blitArea = new Coo(sc.x(), sc.y()); }  this.mouseWindow.set(this.displayWidth, this.displayHeight); if (OS.get() == OS.LINUX)
/*     */       GLFW.glfwSetFramebufferSizeCallback(this.window, new GLFWFramebufferSizeCallbackI() { public void invoke(long arg0, int fbw, int fbh) { if (fbw <= 0 || fbh <= 0)
/*     */                 return;  GraphicContext.this.blitArea.set(fbw, fbh); Printer.ln("---BLIT CHANGE: " + GraphicContext.this.blitArea.x() + "x" + GraphicContext.this.blitArea.y()); IntBuffer w = BufferUtils.createIntBuffer(1); IntBuffer h = BufferUtils.createIntBuffer(1); GLFW.glfwGetWindowSize(GraphicContext.this.window, w, h); GraphicContext.this.mouseWindow.set(w.get(), h.get()); } }
/* 499 */         );  Printer.ln("---BLIT: " + this.blitArea.x() + "x" + this.blitArea.y()); Printer.fin(); switch (sett.getRenderMode()) { case 0: this.renderer = new RendererDebug(sett, sett.getPointSize()); break;default: this.renderer = new RendererDeffered(sett, sett.getPointSize()); break; }  GLFW.glfwFocusWindow(this.window); GlHelper.checkErrors(); } boolean swapAndCheckClose() { if (this.debugAll && (this.chi & 0xFF) == 0)
/* 500 */       GlHelper.checkErrors(); 
/* 501 */     if (this.bi == -1)
/* 502 */       this.bi = GL11.glGetInteger(36010); 
/* 503 */     GL30.glBindFramebuffer(36008, 0);
/* 504 */     GLFW.glfwSwapBuffers(this.window);
/* 505 */     GL30.glBindFramebuffer(36008, this.bi);
/* 506 */     this.windowIsFocused = (GLFW.glfwGetWindowAttrib(this.window, 131073) == 1);
/* 507 */     diagnose(false);
/* 508 */     if (this.debugAll && (this.chi & 0xFF) == 0)
/* 509 */       GlHelper.checkErrors(); 
/* 510 */     this.chi++;
/* 511 */     return !GLFW.glfwWindowShouldClose(this.window); }
/*     */ 
/*     */   
/*     */   private void diagnose(boolean force) {
/* 515 */     if (diagnosing) {
/* 516 */       if (force) {
/* 517 */         Printer.ln("force");
/*     */       }
/* 519 */       diagnoseTimer++;
/* 520 */       if (diagnoseTimer == 60 || force) {
/* 521 */         diagnoseTimer = 0;
/* 522 */         GlHelper.diagnozeMem();
/*     */       } 
/*     */       
/* 525 */       GlHelper.checkErrors();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean focused() {
/* 530 */     return this.windowIsFocused;
/*     */   }
/*     */   
/*     */   public int fps() {
/* 534 */     return this.refreshRate;
/*     */   }
/*     */   
/*     */   void pollEvents() {
/* 538 */     GLFW.glfwPollEvents();
/*     */   }
/*     */   
/*     */   long getWindow() {
/* 542 */     return this.window;
/*     */   }
/*     */ 
/*     */   
/*     */   void dis() {
/* 547 */     if (this.renderer != null) {
/* 548 */       this.renderer.dis();
/*     */     }
/* 550 */     this.gl.dispose();
/*     */     
/* 552 */     Callbacks.glfwFreeCallbacks(this.window);
/* 553 */     GLFW.glfwDestroyWindow(this.window);
/*     */     
/* 555 */     GLFW.glfwTerminate();
/* 556 */     GLFWErrorCallback e = GLFW.glfwSetErrorCallback(null);
/* 557 */     if (e != null) {
/* 558 */       e.free();
/*     */     }
/* 560 */     Printer.ln(GraphicContext.class + " was sucessfully destroyed");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void terminate() {}
/*     */ 
/*     */   
/*     */   boolean isFocused() {
/* 569 */     return this.windowIsFocused;
/*     */   }
/*     */   
/*     */   void takeScreenShot() {
/* 573 */     String s = FileManager.NAME.timeStampString(String.valueOf(this.screenShotPath) + "shot");
/* 574 */     SnakeImage image = new SnakeImage(this.nativeWidth, this.nativeHeight);
/* 575 */     copyFB(image, 0, 0);
/* 576 */     image.save(String.valueOf(s) + ".png");
/* 577 */     System.gc();
/*     */   }
/*     */ 
/*     */   
/*     */   public void makeScreenShot() {
/* 582 */     if (this.screenShotPath == null)
/*     */       return; 
/* 584 */     (new CORE.GlJob()
/*     */       {
/*     */         protected void doJob() {
/* 587 */           GraphicContext.this.takeScreenShot();
/*     */         }
/* 589 */       }).perform();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void copyFB(SnakeImage image, int startX, int startY) {
/* 595 */     ByteBuffer buff = this.gl.getFramePixels(this.nativeWidth, this.nativeHeight);
/* 596 */     for (int x = 0; x < this.nativeWidth; x++) {
/* 597 */       int x1 = startX + x;
/* 598 */       if (x1 < image.width)
/*     */       {
/* 600 */         for (int y = 0; y < this.nativeHeight; y++) {
/* 601 */           int y1 = startY + this.nativeHeight - y + 1;
/* 602 */           if (y1 < image.height) {
/*     */             
/* 604 */             int i = (x + this.nativeWidth * y) * 4;
/* 605 */             int r = buff.get(i) & 0xFF;
/* 606 */             int g = buff.get(i + 1) & 0xFF;
/* 607 */             int b = buff.get(i + 2) & 0xFF;
/* 608 */             image.rgb.set(x1, y1, r, g, b, 255);
/*     */           } 
/*     */         }  } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void copyFB(SnakeImage image, int startX, int startY, int scale) {
/* 615 */     ByteBuffer buff = this.gl.getFramePixels(this.nativeWidth, this.nativeHeight);
/* 616 */     for (int x = 0; x < this.nativeWidth / scale; x++) {
/* 617 */       int x1 = startX + x;
/* 618 */       if (x1 < image.width)
/*     */       {
/* 620 */         for (int y = 0; y < this.nativeHeight / scale; y++) {
/* 621 */           int y1 = startY + this.nativeHeight / scale - y + 1;
/* 622 */           if (y1 < image.height) {
/*     */             
/* 624 */             int i = (x * scale + this.nativeWidth * y * scale) * 4;
/* 625 */             int r = buff.get(i) & 0xFF;
/* 626 */             int g = buff.get(i + 1) & 0xFF;
/* 627 */             int b = buff.get(i + 2) & 0xFF;
/* 628 */             image.rgb.set(x1, y1, r, g, b, 255);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\GraphicContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */