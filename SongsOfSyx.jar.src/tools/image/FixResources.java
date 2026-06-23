/*    */ package tools.image;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.nio.file.Path;
/*    */ import tools.TUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FixResources
/*    */ {
/*    */   public static void main(String[] args) {}
/*    */   
/*    */   private FixResources() {
/* 16 */     for (Path p : TUtil.files(".png", true, new String[] { "zipdata", "data", "assets", "sprite", "resource" })) {
/* 17 */       fix(p);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void fix(Path p) {
/* 24 */     BufferedImage source = Util.getImage(String.valueOf(p));
/* 25 */     BufferedImage dest = Util.getImage(244, 94);
/*    */     
/* 27 */     for (int dy = 0; dy < 94; dy++) {
/* 28 */       for (int dx = 0; dx < 122; dx++) {
/* 29 */         int sx = dx + 36;
/* 30 */         int sy = dy;
/*    */         
/* 32 */         dest.setRGB(dx, dy, source.getRGB(sx, sy));
/* 33 */         dest.setRGB(dx + dest.getWidth() / 2, dy, source.getRGB(sx + source.getWidth() / 2, sy));
/*    */       } 
/*    */     } 
/*    */     
/* 37 */     Util.saveImage(dest, String.valueOf(p.getFileName()).split(".png")[0]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\image\FixResources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */