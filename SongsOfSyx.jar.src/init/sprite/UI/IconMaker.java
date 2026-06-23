/*     */ package init.sprite.UI;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.paths.PathParser;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IconMaker
/*     */ {
/*     */   public static final String split = "->";
/*     */   final PATH path;
/*  26 */   private KeyMap<TILE_SHEET> map = new KeyMap();
/*     */   public final int DIM;
/*     */   public final Icon DUMMY;
/*     */   
/*     */   IconMaker(String root, int dim) {
/*  31 */     this.path = PATHS.SPRITE().getFolder("icon").getFolder(root);
/*  32 */     this.DIM = dim;
/*  33 */     this.DUMMY = new Icon(this.DIM, (SPRITE)COLOR.ORANGE100);
/*     */   }
/*     */   
/*     */   Icon get(String relPath, int nr) throws IOException {
/*  37 */     return get(relPath + "->" + relPath, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Icon get(String relPath, Json json, String jsonKey) throws IOException {
/*  43 */     Path p = PathParser.get(this.path, relPath, json, jsonKey, 1);
/*     */     
/*  45 */     if (p == null) {
/*  46 */       return this.DUMMY;
/*     */     }
/*  48 */     String[] ss = relPath.split("->");
/*     */     
/*  50 */     if (ss.length < 0) {
/*  51 */       String str = "The row of the icon file is missing at the end of the path. Sytax is folder->folder->file->0, where 0 is the row of the icon file.";
/*  52 */       PathParser.error(str, json, jsonKey);
/*  53 */       return this.DUMMY;
/*     */     } 
/*     */     
/*  56 */     int nr = -1;
/*     */     
/*     */     try {
/*  59 */       nr = Integer.parseInt(ss[ss.length - 1]);
/*  60 */     } catch (NumberFormatException e) {
/*  61 */       String str = "The final element in the path must be a number. Sytax is folder->folder->file->0, where 0 is the row of the icon file.";
/*  62 */       PathParser.error(str, json, jsonKey);
/*  63 */       return this.DUMMY;
/*     */     } 
/*     */     
/*  66 */     String ne = "The selected row of the file is out of bounds for the file. Sytax is folder->folder->file->0, where 0 is the row of the icon file.";
/*     */     
/*  68 */     if (nr < 0) {
/*  69 */       PathParser.error(ne, json, jsonKey);
/*     */     }
/*     */     
/*  72 */     TILE_SHEET sheet = sheet(p, json, jsonKey);
/*  73 */     if (sheet == null) {
/*  74 */       return this.DUMMY;
/*     */     }
/*  76 */     if (nr >= sheet.tiles()) {
/*  77 */       PathParser.error(ne, json, jsonKey);
/*  78 */       return this.DUMMY;
/*     */     } 
/*     */     
/*  81 */     return new Icon.IconSheet(this.DIM, sheet, nr);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TILE_SHEET sheet(Path path, Json json, String jsonKey) throws IOException {
/* 151 */     String kk = String.valueOf(path.toAbsolutePath());
/*     */     
/* 153 */     if (!this.map.containsKey(kk)) {
/*     */       
/* 155 */       SnakeImage im = new SnakeImage(path);
/* 156 */       int iwidth = im.width / 2;
/* 157 */       int iheight = im.height;
/* 158 */       im.dispose();
/*     */       
/* 160 */       if ((iwidth - 6) % (this.DIM + 6) != 0 || (iheight - 6) % (this.DIM + 6) != 0) {
/* 161 */         PathParser.error(String.valueOf(path.toAbsolutePath()) + " does not have the right dimensions: Should be a multiple of " + String.valueOf(path.toAbsolutePath()) + " squares. Look at other file for reference.", json, jsonKey);
/* 162 */         return null;
/*     */       } 
/*     */       
/* 165 */       final int xs = (iwidth - 6) / (this.DIM + 6);
/* 166 */       final int ys = (iheight - 6) / (this.DIM + 6);
/*     */       
/* 168 */       TILE_SHEET s = (new ComposerThings.ITileSheet(path, iwidth * 2, iheight)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 172 */             ComposerDests.Tile t = d.s16;
/* 173 */             if (IconMaker.this.DIM == 24)
/* 174 */               t = d.s24; 
/* 175 */             if (IconMaker.this.DIM == 32)
/* 176 */               t = d.s32; 
/* 177 */             s.singles.init(0, 0, 1, 1, xs, ys, (ComposerDests.Dest)t);
/* 178 */             s.singles.paste(true);
/* 179 */             return t.saveGame();
/*     */           }
/* 181 */         }).get();
/* 182 */       this.map.put(kk, s);
/*     */     } 
/*     */     
/* 185 */     return (TILE_SHEET)this.map.get(kk);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\IconMaker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */