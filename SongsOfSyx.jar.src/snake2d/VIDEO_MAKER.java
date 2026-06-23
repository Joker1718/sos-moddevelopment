/*     */ package snake2d;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class VIDEO_MAKER
/*     */ {
/*     */   private final RECTANGLE start;
/*     */   private final RECTANGLE end;
/*  18 */   private final Rec tmp = new Rec();
/*  19 */   private final VectorImp vec = new VectorImp();
/*     */   private final int frames;
/*  21 */   private static double FPS = 60.0D;
/*     */   
/*     */   private final String path;
/*     */   
/*     */   public VIDEO_MAKER(RECTANGLE start, RECTANGLE end, int duration, final String path) {
/*  26 */     this.start = start;
/*  27 */     this.end = end;
/*  28 */     this.path = path;
/*  29 */     if (duration > 20000) {
/*  30 */       duration = 20000;
/*     */     }
/*  32 */     this.frames = (int)(FPS * duration / 1000.0D);
/*     */     
/*  34 */     (new CORE.GlJob()
/*     */       {
/*     */         protected void doJob()
/*     */         {
/*  38 */           for (int f = 0; f <= VIDEO_MAKER.this.frames; f++) {
/*  39 */             VIDEO_MAKER.this.make(f);
/*     */           }
/*     */ 
/*     */           
/*  43 */           VIDEO_MAKER.makeVideo(path);
/*     */         }
/*  45 */       }).perform();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void make(int frame) {
/*  53 */     Rec bounds = frame(frame / this.frames);
/*     */     
/*  55 */     int fw = (CORE.getGraphics()).nativeWidth;
/*  56 */     int fh = (CORE.getGraphics()).nativeHeight;
/*     */     
/*  58 */     int scale = bounds.width() / fw;
/*  59 */     scale = CLAMP.i(scale, 1, 4);
/*     */     
/*  61 */     SnakeImage frameBuffers = new SnakeImage(bounds.width() / scale, bounds.height() / scale);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     for (int dy = 0; dy < bounds.height(); dy += fh) {
/*  70 */       for (int dx = 0; dx < bounds.width(); dx += fw) {
/*     */         
/*  72 */         int x1 = bounds.x1() + dx;
/*  73 */         int y1 = bounds.y1() + dy;
/*  74 */         int w = fw;
/*  75 */         int h = fh;
/*  76 */         if (x1 + w > bounds.x2())
/*  77 */           w = bounds.x2() - x1; 
/*  78 */         if (y1 + h > bounds.y2()) {
/*  79 */           h = bounds.y2() - y1;
/*     */         }
/*     */         
/*  82 */         Rec r = new Rec(w, h);
/*  83 */         r.moveX1Y1(x1, y1);
/*     */ 
/*     */         
/*  86 */         render((RECTANGLE)r);
/*  87 */         CORE.getGraphics().flushRenderer();
/*  88 */         CORE.getGraphics().copyFB(frameBuffers, dx / scale, dy / scale, scale);
/*  89 */         CORE.getGraphics().pollEvents();
/*     */       } 
/*     */     } 
/*  92 */     renderProgress(frame, this.frames, 1.0D / FPS);
/*  93 */     CORE.getGraphics().pollEvents();
/*     */     
/*  95 */     SnakeImage result = frameBuffers.resized(fw, fh);
/*  96 */     frameBuffers.dispose();
/*     */     
/*  98 */     String id = String.format("%05d", new Object[] { Integer.valueOf(frame) });
/*     */     
/* 100 */     String p = String.valueOf(this.path) + id + ".jpg";
/* 101 */     result.saveJpg(p);
/* 102 */     System.out.println("saving " + p);
/* 103 */     result.dispose();
/* 104 */     System.gc();
/* 105 */     CORE.getInput().clearAllInput();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void makeVideo(String path) {
/* 112 */     String command = "C:\\Users\\jakob\\Desktop\\jakob\\syx\\ffmpeg-master-latest-win64-gpl-shared\\bin\\";
/* 113 */     command = String.valueOf(command) + "ffmpeg -r " + FPS + " ";
/* 114 */     command = String.valueOf(command) + "-f image2 ";
/* 115 */     command = String.valueOf(command) + "-s " + (CORE.getGraphics()).nativeWidth + "x" + (CORE.getGraphics()).nativeHeight + " ";
/* 116 */     command = String.valueOf(command) + "-i " + path + "%05d.jpg ";
/* 117 */     command = String.valueOf(command) + "-vcodec libx264 -crf 25  -pix_fmt yuv420p ";
/* 118 */     command = String.valueOf(command) + path + "video.mp4";
/*     */     
/* 120 */     System.out.println(command);
/*     */     try {
/* 122 */       Files.deleteIfExists((new File(String.valueOf(path) + "video.mp4")).toPath());
/* 123 */       Runtime.getRuntime().exec(command);
/* 124 */     } catch (IOException e) {
/* 125 */       e.printStackTrace();
/*     */     } 
/* 127 */     System.out.println(String.valueOf(path) + "video.mp4");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Rec frame(double dd) {
/* 135 */     this.tmp.setWidth(this.start.width() + (this.end.width() - this.start.width()) * dd);
/* 136 */     this.tmp.setHeight(this.start.height() + (this.end.height() - this.start.height()) * dd);
/*     */     
/* 138 */     double l = this.vec.set(this.start.cX(), this.start.cY(), this.end.cX(), this.end.cY());
/* 139 */     l *= dd;
/* 140 */     this.tmp.moveC(this.start.cX() + l * this.vec.nX(), this.start.cY() + l * this.vec.nY());
/* 141 */     return this.tmp;
/*     */   }
/*     */   
/*     */   public abstract void render(RECTANGLE paramRECTANGLE);
/*     */   
/*     */   public abstract void renderProgress(int paramInt1, int paramInt2, double paramDouble);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\VIDEO_MAKER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */