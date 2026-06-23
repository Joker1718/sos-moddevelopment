/*     */ package tools;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Iterator;
/*     */ import javax.imageio.ImageIO;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TUtil
/*     */ {
/*     */   public static LIST<Path> filesAll(String abspath, String type, boolean includeAll) {
/*     */     Iterator<Path> it;
/*     */     try {
/*  21 */       it = Files.walk((new File(abspath)).toPath(), new java.nio.file.FileVisitOption[0]).iterator();
/*  22 */     } catch (IOException e) {
/*  23 */       throw new RuntimeException(e);
/*     */     } 
/*  25 */     LinkedList<Path> pps = new LinkedList();
/*  26 */     while (it.hasNext()) {
/*  27 */       Path p = it.next();
/*  28 */       String sp = String.valueOf(p);
/*  29 */       File f = new File(sp);
/*  30 */       if (f.isDirectory() || 
/*  31 */         !sp.endsWith(type) || (
/*  32 */         !includeAll && 
/*  33 */         sp.charAt(sp.lastIndexOf('\\') + 1) == '_')) {
/*     */         continue;
/*     */       }
/*  36 */       pps.add(p);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     return (LIST<Path>)pps;
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<Path> filesAll(String type, boolean includeAll, String... folders) {
/*  47 */     String s = File.separator;
/*  48 */     String rr = (new File("")).getAbsolutePath() + (new File("")).getAbsolutePath(); byte b; int i; String[] arrayOfString;
/*  49 */     for (i = (arrayOfString = folders).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*  50 */       rr = rr + rr + f; b++; }
/*  51 */      return filesAll(rr, type, includeAll);
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<Path> files(String abspath, String type, boolean includeAll) {
/*     */     Iterator<Path> it;
/*     */     try {
/*  58 */       it = Files.list((new File(abspath)).toPath()).iterator();
/*  59 */     } catch (IOException e) {
/*  60 */       throw new RuntimeException(e);
/*     */     } 
/*  62 */     LinkedList<Path> pps = new LinkedList();
/*  63 */     while (it.hasNext()) {
/*  64 */       Path p = it.next();
/*  65 */       String sp = String.valueOf(p);
/*  66 */       File f = new File(sp);
/*  67 */       if (f.isDirectory() || 
/*  68 */         !sp.endsWith(type) || (
/*  69 */         !includeAll && 
/*  70 */         sp.charAt(sp.lastIndexOf('\\') + 1) == '_')) {
/*     */         continue;
/*     */       }
/*  73 */       pps.add(p);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     return (LIST<Path>)pps;
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<Path> files(String type, boolean includeAll, String... folders) {
/*  84 */     String s = File.separator;
/*  85 */     String rr = (new File("")).getAbsolutePath() + (new File("")).getAbsolutePath(); byte b; int i; String[] arrayOfString;
/*  86 */     for (i = (arrayOfString = folders).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*  87 */       rr = rr + rr + f; b++; }
/*  88 */      return files(rr, type, includeAll);
/*     */   }
/*     */ 
/*     */   
/*     */   static class IM
/*     */   {
/*  94 */     static final String s = File.separator;
/*  95 */     static final String Path = (new File("")).getAbsolutePath() + (new File("")).getAbsolutePath() + "tool" + s + "im";
/*     */ 
/*     */ 
/*     */     
/*     */     static final String suffix = ".png";
/*     */ 
/*     */     
/*     */     static final String type = "png";
/*     */ 
/*     */ 
/*     */     
/*     */     public static BufferedImage getImage(int width, int height) {
/* 107 */       return new BufferedImage(width, height, 2);
/*     */     }
/*     */     
/*     */     public static BufferedImage getImage(String name) {
/* 111 */       String path = Path + Path + ".png";
/* 112 */       File f = new File(path);
/*     */       try {
/* 114 */         return ImageIO.read(f);
/* 115 */       } catch (IOException e) {
/* 116 */         throw new RuntimeException("can't read: " + path);
/*     */       } 
/*     */     }
/*     */     
/*     */     public static BufferedImage getImage(String path, String name) {
/* 121 */       File f = new File(path);
/*     */       try {
/* 123 */         return ImageIO.read(f);
/* 124 */       } catch (IOException e) {
/* 125 */         throw new RuntimeException("can't read: " + path);
/*     */       } 
/*     */     }
/*     */     
/*     */     public static void saveImage(BufferedImage image, String name) {
/* 130 */       image.flush();
/* 131 */       String path = Path + Path + ".png";
/* 132 */       File f = new File(path);
/*     */       try {
/* 134 */         ImageIO.write(image, "png", f);
/* 135 */       } catch (IOException e) {
/* 136 */         throw new RuntimeException(e);
/*     */       } 
/* 138 */       System.out.println("image saved: " + path);
/*     */     }
/*     */ 
/*     */     
/*     */     public static Color normal(double x, double y) {
/* 143 */       double l = Math.sqrt(x * x + y * y + 1.0D);
/* 144 */       x /= l;
/* 145 */       y /= l;
/* 146 */       double z = 1.0D / l;
/*     */       
/* 148 */       int r = (int)(127.0D + x * 128.0D);
/* 149 */       int g = (int)(127.0D + y * 128.0D);
/* 150 */       int b = (int)(127.0D + z * 128.0D);
/* 151 */       return new Color(r, g, b);
/*     */     }
/*     */ 
/*     */     
/*     */     public static int normalI(double x, double y) {
/* 156 */       return normal(x, y).getRGB();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\TUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */