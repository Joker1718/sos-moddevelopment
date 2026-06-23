/*    */ package snake2d;
/*    */ 
/*    */ import snake2d.util.file.SnakeImage;
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
/*    */ 
/*    */ 
/*    */ public abstract class SUPER_SCREENSHOT
/*    */ {
/*    */   private final int scale;
/*    */   private String fName;
/*    */   private final CORE.GlJob job;
/*    */   
/*    */   public SUPER_SCREENSHOT(int scale) {
/* 27 */     this.job = new CORE.GlJob()
/*    */       {
/*    */         protected void doJob()
/*    */         {
/* 31 */           SnakeImage image = new SnakeImage(SUPER_SCREENSHOT.this.getWidth() / SUPER_SCREENSHOT.this.scale, SUPER_SCREENSHOT.this.getHeight() / SUPER_SCREENSHOT.this.scale);
/*    */           
/* 33 */           SUPER_SCREENSHOT.this.init();
/*    */           
/* 35 */           double x1 = 0.0D;
/* 36 */           double y1 = 0.0D;
/*    */           
/* 38 */           while (SUPER_SCREENSHOT.this.renderAndHasNext()) {
/* 39 */             if (y1 >= SUPER_SCREENSHOT.this.getHeight())
/* 40 */               throw new RuntimeException(); 
/* 41 */             CORE.getGraphics().flushRenderer();
/* 42 */             CORE.getGraphics().copyFB(image, (int)Math.round(x1 / SUPER_SCREENSHOT.this.scale), (int)Math.round(y1 / SUPER_SCREENSHOT.this.scale), SUPER_SCREENSHOT.this.scale);
/* 43 */             CORE.getGraphics().pollEvents();
/* 44 */             x1 += (CORE.getGraphics()).nativeWidth;
/* 45 */             if (x1 >= SUPER_SCREENSHOT.this.getWidth()) {
/* 46 */               y1 += (CORE.getGraphics()).nativeHeight;
/* 47 */               x1 = 0.0D;
/*    */             } 
/*    */           } 
/*    */ 
/*    */ 
/*    */           
/* 53 */           CORE.getGraphics().pollEvents();
/*    */           
/* 55 */           image.saveJpg(SUPER_SCREENSHOT.this.fName);
/* 56 */           image.dispose();
/* 57 */           gc();
/* 58 */           CORE.getInput().clearAllInput();
/*    */         }
/*    */       };
/*    */     this.scale = scale;
/*    */   } public double fileSizeMB() {
/* 63 */     double a = (getWidth() * getHeight()) / this.scale * 1000000.0D;
/* 64 */     a *= 0.2D;
/* 65 */     return a;
/*    */   }
/*    */   
/*    */   public void perform(String filePath) {
/*    */     this.fName = filePath;
/*    */     this.job.perform();
/*    */   }
/*    */   
/*    */   public abstract int getWidth();
/*    */   
/*    */   public abstract int getHeight();
/*    */   
/*    */   public abstract boolean renderAndHasNext();
/*    */   
/*    */   public abstract void init();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SUPER_SCREENSHOT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */