/*     */ package util.spritecomposer;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Resources
/*     */ {
/*     */   static FileGetter g;
/*     */   static FilePutter p;
/*     */   static ComposerDests dests;
/*     */   static ComposerUtil c;
/*     */   static ComposerSources sources;
/*     */   static ComposerTexturer immi;
/*     */   static ComposerFonter fonter;
/*     */   static boolean needsBigger = false;
/*     */   private static final int CHECK = 669966991;
/*     */   
/*     */   static Result read(String prefix, int width) throws IOException {
/*  28 */     dispose();
/*     */     
/*  30 */     PATH d = PATHS.CACHE_DATA();
/*  31 */     PATH t = PATHS.CACHE_TEXTURE();
/*  32 */     if (d.exists(prefix + "TextureData") && t.exists(prefix + "Diffuse") && t.exists(prefix + "Normal")) {
/*  33 */       SnakeImage diffuse, normal; FileGetter gg = new FileGetter(d.get(prefix + "TextureData"));
/*  34 */       int check = gg.lastInt();
/*     */       
/*  36 */       if (check != 669966991) {
/*  37 */         d.delete(prefix + "TextureData");
/*  38 */         return null;
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/*  43 */         diffuse = new SnakeImage(t.get(prefix + "Diffuse"));
/*  44 */         normal = new SnakeImage(t.get(prefix + "Normal"));
/*  45 */       } catch (snake2d.Errors.DataError e) {
/*  46 */         e.printStackTrace();
/*  47 */         t.delete(prefix + "Diffuse");
/*  48 */         t.delete(prefix + "Normal");
/*  49 */         return null;
/*     */       } 
/*     */       
/*  52 */       g = gg;
/*  53 */       c = new ComposerUtil();
/*     */       
/*  55 */       if (diffuse.width != normal.width || diffuse.height != normal.height || diffuse.width != width) {
/*  56 */         d.delete(prefix + "TextureData");
/*  57 */         diffuse.dispose();
/*  58 */         normal.dispose();
/*  59 */         return null;
/*     */       } 
/*     */       
/*  62 */       Result res = new Result();
/*  63 */       res.diffuse = diffuse;
/*  64 */       res.normal = normal;
/*  65 */       return res;
/*     */     } 
/*     */ 
/*     */     
/*  69 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void delete(String prefix) {
/*  74 */     if (PATHS.CACHE_DATA().exists(prefix + "TextureData")) {
/*  75 */       PATHS.CACHE_DATA().delete(prefix + "TextureData");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean init(String prefix, int size) throws IOException {
/*  81 */     dispose();
/*     */     
/*  83 */     PATH d = PATHS.CACHE_DATA();
/*  84 */     p = new FilePutter(d.create(prefix + "TextureData"), 262144);
/*  85 */     c = new ComposerUtil();
/*  86 */     dests = new ComposerDests(size);
/*     */     
/*  88 */     sources = new ComposerSources();
/*  89 */     immi = new ComposerTexturer(c);
/*  90 */     fonter = new ComposerFonter(c);
/*     */     
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void save(String prefix, int extraHeight) {
/*  98 */     CORE.checkIn();
/*  99 */     PATH t = PATHS.CACHE_TEXTURE();
/* 100 */     dests.save(t.create(prefix + "Diffuse"), t.create(prefix + "Normal"), p, extraHeight);
/* 101 */     p.i(669966991);
/* 102 */     p.save();
/* 103 */     dispose();
/*     */   }
/*     */   
/*     */   public static void dispose() {
/* 107 */     g = null;
/* 108 */     if (p != null) {
/* 109 */       p = null;
/*     */     }
/* 111 */     if (dests != null) {
/* 112 */       dests.dispose();
/* 113 */       dests = null;
/*     */     } 
/* 115 */     sources = null;
/* 116 */     immi = null;
/* 117 */     fonter = null;
/* 118 */     if (c != null) {
/* 119 */       c.dispose();
/*     */     }
/* 121 */     c = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\Resources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */