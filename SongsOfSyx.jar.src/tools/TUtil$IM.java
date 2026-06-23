/*     */ package tools;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class IM
/*     */ {
/*  94 */   static final String s = File.separator;
/*  95 */   static final String Path = (new File("")).getAbsolutePath() + (new File("")).getAbsolutePath() + "tool" + s + "im";
/*     */ 
/*     */ 
/*     */   
/*     */   static final String suffix = ".png";
/*     */ 
/*     */   
/*     */   static final String type = "png";
/*     */ 
/*     */ 
/*     */   
/*     */   public static BufferedImage getImage(int width, int height) {
/* 107 */     return new BufferedImage(width, height, 2);
/*     */   }
/*     */   
/*     */   public static BufferedImage getImage(String name) {
/* 111 */     String path = Path + Path + ".png";
/* 112 */     File f = new File(path);
/*     */     try {
/* 114 */       return ImageIO.read(f);
/* 115 */     } catch (IOException e) {
/* 116 */       throw new RuntimeException("can't read: " + path);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static BufferedImage getImage(String path, String name) {
/* 121 */     File f = new File(path);
/*     */     try {
/* 123 */       return ImageIO.read(f);
/* 124 */     } catch (IOException e) {
/* 125 */       throw new RuntimeException("can't read: " + path);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void saveImage(BufferedImage image, String name) {
/* 130 */     image.flush();
/* 131 */     String path = Path + Path + ".png";
/* 132 */     File f = new File(path);
/*     */     try {
/* 134 */       ImageIO.write(image, "png", f);
/* 135 */     } catch (IOException e) {
/* 136 */       throw new RuntimeException(e);
/*     */     } 
/* 138 */     System.out.println("image saved: " + path);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Color normal(double x, double y) {
/* 143 */     double l = Math.sqrt(x * x + y * y + 1.0D);
/* 144 */     x /= l;
/* 145 */     y /= l;
/* 146 */     double z = 1.0D / l;
/*     */     
/* 148 */     int r = (int)(127.0D + x * 128.0D);
/* 149 */     int g = (int)(127.0D + y * 128.0D);
/* 150 */     int b = (int)(127.0D + z * 128.0D);
/* 151 */     return new Color(r, g, b);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int normalI(double x, double y) {
/* 156 */     return normal(x, y).getRGB();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\TUtil$IM.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */