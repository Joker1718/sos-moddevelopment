/*    */ package tools.image;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ 
/*    */ class Util
/*    */ {
/* 13 */   static final String s = File.separator;
/* 14 */   static final String Path = (new File("")).getAbsolutePath() + (new File("")).getAbsolutePath() + "tool" + s + "image" + s;
/*    */ 
/*    */ 
/*    */   
/*    */   static final String suffix = ".png";
/*    */ 
/*    */   
/*    */   static final String type = "png";
/*    */ 
/*    */ 
/*    */   
/*    */   public static BufferedImage getImage(int width, int height) {
/* 26 */     return new BufferedImage(width, height, 2);
/*    */   }
/*    */   
/*    */   public static BufferedImage getLocalImage(String name) {
/* 30 */     String path = Path + Path + ".png";
/* 31 */     File f = new File(path);
/*    */     try {
/* 33 */       return ImageIO.read(f);
/* 34 */     } catch (IOException e) {
/* 35 */       throw new RuntimeException("can't read: " + path);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static BufferedImage getImage(String path) {
/* 40 */     File f = new File(path);
/*    */     try {
/* 42 */       return ImageIO.read(f);
/* 43 */     } catch (IOException e) {
/* 44 */       throw new RuntimeException("can't read: " + path);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void saveImage(BufferedImage image, String name) {
/* 49 */     image.flush();
/* 50 */     String path = Path + Path + ".png";
/* 51 */     File f = new File(path);
/*    */     try {
/* 53 */       ImageIO.write(image, "png", f);
/* 54 */     } catch (IOException e) {
/* 55 */       throw new RuntimeException(e);
/*    */     } 
/* 57 */     System.out.println("image saved: " + path);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Color normal(double x, double y) {
/* 62 */     double l = Math.sqrt(x * x + y * y + 1.0D);
/* 63 */     x /= l;
/* 64 */     y /= l;
/* 65 */     double z = 1.0D / l;
/*    */     
/* 67 */     int r = (int)(127.0D + x * 128.0D);
/* 68 */     int g = (int)(127.0D + y * 128.0D);
/* 69 */     int b = (int)(127.0D + z * 128.0D);
/* 70 */     return new Color(r, g, b);
/*    */   }
/*    */ 
/*    */   
/*    */   public static int normalI(double x, double y) {
/* 75 */     return normal(x, y).getRGB();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\image\Util.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */