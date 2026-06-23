/*     */ package init.sprite.UI;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.paths.PathParser;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UIImageMaker
/*     */ {
/*     */   public static final String split = "->";
/*     */   final PATH path;
/*  28 */   private KeyMap<SPRITE> map = new KeyMap();
/*  29 */   public final int DIM = 32;
/*     */   public final SPRITE DUMMY;
/*     */   
/*     */   UIImageMaker() {
/*  33 */     this.path = PATHS.SPRITE().getFolder("image");
/*  34 */     this.DUMMY = (SPRITE)new SPRITE.Imp(100, 100)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  38 */           COLOR.ORANGE100.render(r, X1, X2, Y1, Y2);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   SPRITE get(String relPath) throws IOException {
/*  44 */     return get(relPath, null, null);
/*     */   }
/*     */   
/*     */   public SPRITE get(Json json) throws IOException {
/*  48 */     return get(json.value("IMAGE"), json, "IMAGE");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE get(String relPath, Json json, String jsonKey) throws IOException {
/*  54 */     Path p = PathParser.get(this.path, relPath, json, jsonKey, 0);
/*     */     
/*  56 */     if (p == null) {
/*  57 */       return this.DUMMY;
/*     */     }
/*     */     
/*  60 */     String kk = String.valueOf(p.toAbsolutePath());
/*     */     
/*  62 */     if (!this.map.containsKey(kk)) {
/*     */       
/*  64 */       SnakeImage im = new SnakeImage(p);
/*  65 */       int iwidth = im.width / 2;
/*  66 */       int iheight = im.height;
/*  67 */       im.dispose();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  72 */       if ((iwidth - 12) % 32 != 0 || (iheight - 12) % 32 != 0) {
/*  73 */         PathParser.error(String.valueOf(p.toAbsolutePath()) + " does not have the right dimensions: Should be a multiple of 32 squares. Look at other file for reference.", json, jsonKey);
/*  74 */         return this.DUMMY;
/*     */       } 
/*     */       
/*  77 */       final int xs = (iwidth - 12) / 32;
/*  78 */       final int ys = (iheight - 12) / 32;
/*     */       
/*  80 */       TILE_SHEET s = (new ComposerThings.ITileSheet(p, iwidth * 2, iheight)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  84 */             s.full.init(0, 0, 1, 1, xs, ys, d.s32);
/*  85 */             s.full.paste(true);
/*  86 */             return d.s32.saveNormal();
/*     */           }
/*  89 */         }).get();
/*     */       
/*  91 */       UIImage m = new UIImage(s, xs, ys);
/*     */       
/*  93 */       this.map.put(kk, m);
/*     */     } 
/*     */     
/*  96 */     return (SPRITE)this.map.get(kk);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class UIImage
/*     */     implements SPRITE
/*     */   {
/*     */     private static final int TILE_SIZE = 64;
/*     */     
/*     */     private final int tilesX;
/*     */     
/*     */     private final int tilesY;
/*     */     private final int width;
/*     */     private final int height;
/*     */     private final TILE_SHEET sheet;
/*     */     
/*     */     UIImage(TILE_SHEET sheet, int tilesX, int tilesY) throws IOException {
/* 113 */       this.sheet = sheet;
/* 114 */       this.tilesX = tilesX;
/* 115 */       this.tilesY = tilesY;
/* 116 */       this.width = tilesX * 64;
/* 117 */       this.height = tilesY * 64;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int width() {
/* 123 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 128 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 133 */       int startX = X1;
/* 134 */       int tile = 0;
/* 135 */       for (int ty = 0; ty < this.tilesY; ty++) {
/* 136 */         X1 = startX;
/* 137 */         for (int tx = 0; tx < this.tilesX; tx++) {
/* 138 */           this.sheet.render(r, tile, X1, Y1);
/* 139 */           X1 += 64;
/* 140 */           tile++;
/*     */         } 
/* 142 */         Y1 += 64;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 149 */       throw new RuntimeException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIImageMaker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */