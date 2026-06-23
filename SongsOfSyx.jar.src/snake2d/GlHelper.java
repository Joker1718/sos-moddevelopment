/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ import org.lwjgl.opengl.GLCapabilities;
/*     */ import org.lwjgl.system.Callback;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GlHelper
/*     */ {
/*     */   private final Callback callback;
/*     */   public static String renderer;
/*     */   public static String rendererV;
/*  96 */   private static final Coo FBSize = new Coo(); public static boolean debug;
/*     */   private static final String sInvalid = "GLerr: invalid enum";
/*     */   private static final String sValue = "GLerr: invalid value";
/*     */   private static final String sOp = "GLerr: invalid operation";
/*     */   
/*     */   GlHelper(int viewPortWidth, int viewPortHeight, boolean debug) {
/* 102 */     GLCapabilities g = GL.createCapabilities();
/* 103 */     checkErrors();
/* 104 */     if (debug) {
/* 105 */       this.callback = GlDebugger.setupDebugMessageCallback();
/*     */     } else {
/* 107 */       this.callback = null;
/* 108 */     }  GL30.glBindFramebuffer(36160, 0);
/* 109 */     GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
/* 110 */     GL11.glEnable(3042);
/* 111 */     setBlendNormal();
/* 112 */     GL11.glEnable(2929);
/* 113 */     GL11.glDepthMask(true);
/* 114 */     GL11.glEnable(2960);
/* 115 */     GL11.glDisable(2884);
/* 116 */     GL11.glClearStencil(-1);
/* 117 */     GL11.glClearDepth(0.0D);
/* 118 */     GlHelper.debug = debug;
/* 119 */     FBSize();
/* 120 */     int[] dd = Alloc.ii(4);
/* 121 */     GL11.glGetIntegerv(2978, dd);
/* 122 */     FBSize.set(dd[2], dd[3]);
/*     */     
/* 124 */     ViewPort.setDefault(viewPortWidth, viewPortHeight);
/* 125 */     checkErrors();
/* 126 */     Printer.ln("OPEN_GL");
/* 127 */     Printer.ln("---FB size: " + FBSize.x() + "x" + FBSize.y());
/*     */ 
/*     */     
/* 130 */     Printer.ln("---FB Red Bits: " + GL30.glGetFramebufferAttachmentParameteri(36160, 1024, 33298));
/* 131 */     Printer.ln("---FB Green Bits: " + GL30.glGetFramebufferAttachmentParameteri(36160, 1024, 33299));
/* 132 */     Printer.ln("---FB Blue Bits: " + GL30.glGetFramebufferAttachmentParameteri(36160, 1024, 33300));
/* 133 */     Printer.ln("---FB Alpha Bits: " + GL30.glGetFramebufferAttachmentParameteri(36160, 1024, 33301));
/* 134 */     Printer.ln("---FB Samples: " + GL11.glGetInteger(32937));
/* 135 */     Printer.ln("---Max Texture Dim: " + GL11.glGetInteger(3379));
/* 136 */     Printer.ln("---Version: " + GL11.glGetString(7938));
/* 137 */     Printer.ln("---SL Version: " + GL11.glGetString(35724));
/* 138 */     Printer.ln("---Max Vert: " + GL11.glGetInteger(33000));
/*     */     
/* 140 */     renderer = String.valueOf(GL11.glGetString(7936)) + ", " + GL11.glGetString(7937);
/* 141 */     rendererV = GL11.glGetString(7938);
/* 142 */     Printer.ln("---glRenderer: " + renderer);
/* 143 */     Printer.ln("---Forward compatible: " + g.forwardCompatible);
/*     */     
/* 145 */     Printer.fin();
/*     */     
/* 147 */     String s = getErrors();
/* 148 */     if (s != null) {
/* 149 */       Printer.ln("---error at query: " + s);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     checkErrors();
/*     */   }
/*     */   
/*     */   private static final String sOver = "GLerr: stack overflow";
/*     */   private static final String sUnder = "GLerr: stack underflow";
/*     */   
/*     */   public static COORDINATE FBSize() {
/* 167 */     return (COORDINATE)FBSize;
/*     */   }
/*     */   private static final String sMem = "GLerr: out of memory"; private static final String sFB = "GLerr: invalid FB operation"; private static final String sUnknown = "GLerr: unknown";
/*     */   
/*     */   ByteBuffer getFramePixels(int width, int height) {
/* 172 */     GL11.glReadBuffer(36064);
/* 173 */     int bpp = 4;
/* 174 */     ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
/* 175 */     GL11.glReadPixels(0, 0, width, height, 6408, 5121, buffer);
/* 176 */     return buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   static void checkErrors() {
/* 181 */     String e = getErrors();
/* 182 */     if (debug && e != null) {
/* 183 */       System.err.println(e);
/* 184 */       throw new RuntimeException("The game has crashed, due to opengl errors. " + e + ". You can avoid this crash in the future by unchecking the 'debug' setting in the launcher.");
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
/*     */ 
/*     */   
/*     */   static String getErrors() {
/* 200 */     switch (GL11.glGetError()) { case 0:
/* 201 */         return null;
/* 202 */       case 1280: return "GLerr: invalid enum";
/* 203 */       case 1281: return "GLerr: invalid value";
/* 204 */       case 1282: return "GLerr: invalid operation";
/* 205 */       case 1283: return "GLerr: stack overflow";
/* 206 */       case 1284: return "GLerr: stack underflow";
/* 207 */       case 1285: diagnozeMem(); return "GLerr: out of memory";
/* 208 */       case 1286: return "GLerr: invalid FB operation"; }
/* 209 */      return "GLerr: unknown";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int getFBTexture(int width, int height) {
/* 216 */     int id = GL11.glGenTextures();
/* 217 */     GL11.glBindTexture(3553, id);
/* 218 */     GL11.glTexParameterf(3553, 10241, 9728.0F);
/* 219 */     GL11.glTexParameterf(3553, 10240, 9728.0F);
/* 220 */     GL11.glTexParameteri(3553, 33084, 0);
/* 221 */     GL11.glTexParameteri(3553, 33085, 0);
/* 222 */     GL11.glTexImage2D(3553, 0, 32856, width, height, 0, 32993, 5121, null);
/* 223 */     return id;
/*     */   }
/*     */ 
/*     */   
/*     */   static void setBlendNormal() {
/* 228 */     GL11.glBlendFunc(770, 771);
/*     */   }
/*     */   
/*     */   static void setBlendAdditative() {
/* 232 */     GL11.glBlendFunc(1, 1);
/*     */   }
/*     */   
/*     */   static void bindNormalFrameBuffer() {
/* 236 */     GL30.glBindFramebuffer(36009, 0);
/*     */   }
/*     */   
/*     */   static void clearCurrentFrameBufferColor2() {
/* 240 */     GL11.glClear(16384);
/*     */   }
/*     */   
/*     */   static void finsih() {
/* 244 */     GL11.glFinish();
/*     */   }
/*     */   
/*     */   static void flush() {
/* 248 */     GL11.glFlush();
/*     */   }
/*     */   
/*     */   static void enableBlend(boolean yes) {
/* 252 */     if (yes) {
/* 253 */       GL11.glEnable(3042);
/*     */     } else {
/* 255 */       GL11.glDisable(3042);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void enableDepthTest(boolean yes) {
/* 261 */     if (yes) {
/* 262 */       GL11.glEnable(2929);
/*     */     } else {
/* 264 */       GL11.glDisable(2929);
/*     */     } 
/*     */     
/* 267 */     GL11.glDepthMask(true);
/*     */   }
/*     */   
/*     */   static void setDepthTestAlways() {
/* 271 */     GL11.glDepthMask(true);
/* 272 */     GL11.glDepthFunc(518);
/*     */   }
/*     */   
/*     */   static void setDepthTestLess() {
/* 276 */     GL11.glDepthMask(false);
/* 277 */     GL11.glDepthFunc(518);
/*     */   }
/*     */   
/*     */   static class Stencil
/*     */   {
/*     */     static void enable(boolean yes) {
/* 283 */       if (yes) {
/* 284 */         GL11.glEnable(2960);
/*     */       } else {
/* 286 */         GL11.glDisable(2960);
/*     */       } 
/*     */     }
/*     */     
/*     */     static void setLEQUALreplaceOnPass(int value) {
/* 291 */       GL11.glStencilFunc(515, value, -1);
/* 292 */       GL11.glStencilOp(7680, 7680, 7681);
/*     */     }
/*     */     
/*     */     static void setLEQUALclear(int value) {
/* 296 */       GL11.glStencilFunc(515, value, -1);
/* 297 */       GL11.glStencilOp(7680, 7680, 0);
/*     */     }
/*     */     
/*     */     static void setLESSKeepOnPass(int value) {
/* 301 */       GL11.glStencilFunc(513, value, -1);
/* 302 */       GL11.glStencilOp(7680, 7680, 7680);
/*     */     }
/*     */     
/*     */     static void setLESSreplaceOnPass(int value) {
/* 306 */       GL11.glStencilFunc(513, value, -1);
/* 307 */       GL11.glStencilOp(7680, 7680, 7681);
/*     */     }
/*     */     
/*     */     static void setGEQUALReplaceOnPass(int value) {
/* 311 */       GL11.glStencilFunc(518, value, -1);
/* 312 */       GL11.glStencilOp(7680, 7680, 7681);
/*     */     }
/*     */     
/*     */     static void setEQUALKeepOnFail(int value) {
/* 316 */       GL11.glStencilFunc(514, value, -1);
/* 317 */       GL11.glStencilOp(7680, 7680, 7680);
/*     */     }
/*     */     
/*     */     static void setLEQUALKeepOnFail(int value) {
/* 321 */       GL11.glStencilFunc(515, value, -1);
/* 322 */       GL11.glStencilOp(7680, 7680, 7680);
/*     */     }
/*     */     
/*     */     static void setAlways(int value) {
/* 326 */       GL11.glStencilFunc(519, value, -1);
/* 327 */       GL11.glStencilOp(7681, 7681, 7681);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class ViewPort
/*     */   {
/*     */     private static int dWidth;
/*     */     private static int dHeight;
/*     */     
/*     */     static void setDefault(int width, int height) {
/* 338 */       dWidth = width;
/* 339 */       dHeight = height;
/* 340 */       GL11.glViewport(0, 0, width, height);
/*     */     }
/*     */     
/*     */     static void setDefault() {
/* 344 */       GL11.glViewport(0, 0, dWidth, dHeight);
/*     */     }
/*     */     
/*     */     static void set(int width, int height) {
/* 348 */       GL11.glViewport(0, 0, width, height);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 354 */     checkErrors();
/*     */     
/* 356 */     if (this.callback != null) {
/* 357 */       this.callback.free();
/*     */     }
/* 359 */     checkErrors();
/* 360 */     GL.setCapabilities(null);
/*     */   }
/*     */ 
/*     */   
/*     */   static void diagnozeMem() {
/* 365 */     int mb = 1038336;
/*     */ 
/*     */     
/* 368 */     System.err.println("MEM DIAGNOSE");
/* 369 */     Runtime run = Runtime.getRuntime();
/*     */     
/* 371 */     System.err.println("--JRE Memory");
/* 372 */     System.err.println("--JRE Total: " + (run.totalMemory() / mb));
/* 373 */     System.err.println("--JRE Free: " + (run.freeMemory() / mb));
/* 374 */     System.err.println("--JRE Used: " + ((
/* 375 */         run.totalMemory() - run.freeMemory()) / mb));
/* 376 */     System.err.println("--JRE Max: " + (run.maxMemory() / mb));
/* 377 */     System.gc();
/* 378 */     System.err.println("--JRE Memory After GC");
/* 379 */     System.err.println("--JRE Total: " + (run.totalMemory() / mb));
/* 380 */     System.err.println("--JRE Free: " + (run.freeMemory() / mb));
/* 381 */     System.err.println("--JRE Used: " + ((
/* 382 */         run.totalMemory() - run.freeMemory()) / mb));
/* 383 */     System.err.println("--JRE Max: " + (run.maxMemory() / mb));
/*     */     
/* 385 */     System.err.println("NVIDIA: ");
/* 386 */     int i = GL11.glGetInteger(36935);
/* 387 */     System.err.println("--GPU Dedicated: " + i);
/* 388 */     i = GL11.glGetInteger(36936);
/* 389 */     System.err.println("--GPU Total Available: " + i);
/* 390 */     i = GL11.glGetInteger(36937);
/* 391 */     System.err.println("--GPU Current Available: " + i);
/* 392 */     i = GL11.glGetInteger(36938);
/* 393 */     System.err.println("--GPU Evictions: " + i);
/* 394 */     i = GL11.glGetInteger(36939);
/* 395 */     System.err.println("--GPU Evicted: " + i);
/*     */     
/* 397 */     System.err.println("ATI: ");
/* 398 */     i = GL11.glGetInteger(34813);
/* 399 */     System.err.println("--Renderbuffer Free: " + i);
/* 400 */     i = GL11.glGetInteger(34812);
/* 401 */     System.err.println("--Texture Free: " + i);
/* 402 */     i = GL11.glGetInteger(34811);
/* 403 */     System.err.println("--Vbo Free: " + i);
/*     */     
/* 405 */     while (GL11.glGetError() != 0) {
/* 406 */       String err = getErrors();
/* 407 */       if (err == null)
/*     */         break; 
/* 409 */       Printer.ln("ignored: " + err);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\GlHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */