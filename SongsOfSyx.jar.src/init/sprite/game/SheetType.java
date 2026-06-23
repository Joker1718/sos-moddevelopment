/*     */ package init.sprite.game;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UICons;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.Errors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SheetType
/*     */   implements INDEXED
/*     */ {
/*  34 */   private static LinkedList<SheetType> tall = new LinkedList();
/*  35 */   public static final c1X1 s1x1 = new c1X1();
/*  36 */   public static final cXxX s2x2 = new cXxX(2);
/*  37 */   public static final cXxX s3x3 = new cXxX(3);
/*  38 */   public static final cCombo sCombo = new cCombo();
/*  39 */   public static final cBox sBox = new cBox();
/*  40 */   public static final cTex sTex = new cTex();
/*  41 */   public static final LIST<SheetType> ALL = (LIST<SheetType>)new ArrayList((Iterable)tall);
/*     */   static {
/*  43 */     tall = null;
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
/* 583 */     DUMMY = new TILE_SHEET()
/*     */       {
/*     */         public int tiles()
/*     */         {
/* 587 */           return 16;
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 592 */           return 64;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int tile, int x1, int x2, int scale) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int tile, int x1, int y1) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int tile, int x1, int x2, int y1, int y2) {
/* 609 */           COLOR.WHITE100.render(r, x1, x2, y1, y2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public TextureCoords getTexture(int tile) {
/* 615 */           return COLOR.WHITE100.texture();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   final String path;
/*     */   private final int W;
/*     */   private final int H;
/*     */   public final int sizeSize;
/*     */   private final int index;
/*     */   private final Sheet dummy;
/*     */   public final boolean defRotates;
/*     */   public static final TILE_SHEET DUMMY;
/*     */   
/*     */   private SheetType(String path, int sizeSize, int W, int H, boolean rot) {
/*     */     this.path = path;
/*     */     this.index = tall.add(this);
/*     */     this.W = W;
/*     */     this.H = H;
/*     */     this.sizeSize = sizeSize;
/*     */     this.dummy = new Sheet.Dummy(sizeSize * 4);
/*     */     this.defRotates = rot;
/*     */   }
/*     */   
/*     */   public abstract TILE_SHEET make(int paramInt1, int paramInt2) throws IOException;
/*     */   
/*     */   protected LIST<TILE_SHEET> make(String key, Json error) throws IOException {
/*     */     PATH pp = PATHS.SPRITE_GAME().getFolder(this.path);
/*     */     if (!pp.exists(key)) {
/*     */       if (error != null)
/*     */         GAME.WarnLight(error.path()); 
/*     */       GAME.WarnLight("The sprite file: " + key + " does not exist in the folder: " + String.valueOf(pp.get()) + error.path());
/*     */       return (LIST<TILE_SHEET>)new ArrayList(DUMMY);
/*     */     } 
/*     */     Path p = pp.get(key);
/*     */     SnakeImage im = new SnakeImage(p);
/*     */     int w = im.width / 2;
/*     */     int h = im.height;
/*     */     im.dispose();
/*     */     if (w % this.W != 0 || h % this.H != 0)
/*     */       throw new Errors.DataError("Image is width is not a multiple of: " + this.W + ", or image height is not a multiple of: " + this.H, p); 
/*     */     w /= this.W;
/*     */     h /= this.H;
/*     */     ArrayList<TILE_SHEET> res = new ArrayList(h);
/*     */     for (int yy = 0; yy < h; yy++) {
/*     */       TILE_SHEET s = make(w, yy * this.H);
/*     */       res.add(s);
/*     */     } 
/*     */     return (LIST<TILE_SHEET>)res;
/*     */   }
/*     */   
/*     */   public final int tile(SheetPair s, int data, int variation, int rotation) {
/*     */     return tile(s.s, s.d, data, variation, rotation);
/*     */   }
/*     */   
/*     */   public abstract int tile(Sheet paramSheet, SheetData paramSheetData, int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   public abstract void renderOverlay(int paramInt1, int paramInt2, SPRITE_RENDERER paramSPRITE_RENDERER, AVAILABILITY paramAVAILABILITY, int paramInt3, int paramInt4, boolean paramBoolean);
/*     */   
/*     */   protected final int getVar(int var, int vars, boolean circular) {
/*     */     var &= Integer.MAX_VALUE;
/*     */     if (circular) {
/*     */       var %= vars + vars - 1;
/*     */       if (var >= vars)
/*     */         var = vars - var % vars - 1; 
/*     */       return var;
/*     */     } 
/*     */     return var % vars;
/*     */   }
/*     */   
/*     */   public int index() {
/*     */     return this.index;
/*     */   }
/*     */   
/*     */   public static class cTex extends SheetType {
/*     */     cTex() {
/*     */       super("texture", 1, 22, 22, true);
/*     */     }
/*     */     
/*     */     protected LIST<TILE_SHEET> make(String key, Json error) throws IOException {
/*     */       PATH pp = PATHS.SPRITE_GAME().getFolder(this.path);
/*     */       if (!pp.exists(key)) {
/*     */         if (error != null)
/*     */           GAME.WarnLight(error.path()); 
/*     */         GAME.WarnLight("The sprite file: " + key + " does not exist in the folder: " + String.valueOf(pp.get()));
/*     */         return (LIST<TILE_SHEET>)new ArrayList(DUMMY);
/*     */       } 
/*     */       Path p = pp.get(key);
/*     */       SnakeImage im = new SnakeImage(p);
/*     */       int iwidth = im.width / 2;
/*     */       int iheight = im.height;
/*     */       im.dispose();
/*     */       final int tilesX = (iwidth - 12) / 16;
/*     */       if (tilesX * 16 + 12 != iwidth)
/*     */         throw new Errors.DataError("Image width does not work. resize", p); 
/*     */       final int tilesY = iheight / 28;
/*     */       if (tilesY * 28 != iheight)
/*     */         throw new Errors.DataError("Image height does not work. resize", p); 
/*     */       ArrayList<TILE_SHEET> res = new ArrayList(tilesY);
/*     */       for (int i = 0; i < tilesY; i++) {
/*     */         final int k = i;
/*     */         TILE_SHEET s = (new ComposerThings.ITileSheet() {
/*     */             protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */               s.full.init(0, 0, 1, tilesY, tilesX, 1, d.s16);
/*     */               s.full.setVar(k).paste(true);
/*     */               return d.s16.saveGame();
/*     */             }
/*     */           }).get();
/*     */         res.add(s);
/*     */       } 
/*     */       return (LIST<TILE_SHEET>)res;
/*     */     }
/*     */     
/*     */     public int tile(Sheet sheet, SheetData da, int data, int variation, int rotation) {
/*     */       variation &= 0xFFFF;
/*     */       int am = sheet.tiles;
/*     */       if (sheet.hasShadow)
/*     */         am--; 
/*     */       variation = getVar(variation, am, da.circular);
/*     */       return variation % am;
/*     */     }
/*     */     
/*     */     public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/*     */       if (a.player < 0.0D) {
/*     */         (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */       } else if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/*     */         (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*     */       } else {
/*     */         (SPRITES.cons()).BIG.outline.render(r, 0, x, y);
/*     */       } 
/*     */     }
/*     */     
/*     */     public TILE_SHEET make(int amount, int y1) throws IOException {
/*     */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class c1X1 extends SheetType {
/*     */     c1X1() {
/*     */       super("1x1", 1, 22, 22, true);
/*     */     }
/*     */     
/*     */     public LIST<TILE_SHEET> make(String key, Json error) throws IOException {
/*     */       PATH pp = PATHS.SPRITE_GAME().getFolder(this.path);
/*     */       if (!pp.exists(key)) {
/*     */         if (error != null)
/*     */           GAME.WarnLight(error.path()); 
/*     */         GAME.WarnLight("The sprite file: " + key + " does not exist in the folder: " + String.valueOf(pp.get()) + error.path());
/*     */         return (LIST<TILE_SHEET>)new ArrayList(DUMMY);
/*     */       } 
/*     */       Path p = pp.get(key);
/*     */       SnakeImage im = new SnakeImage(p);
/*     */       int iwidth = im.width / 2;
/*     */       int iheight = im.height;
/*     */       im.dispose();
/*     */       int tilesX = iwidth / 22;
/*     */       if (tilesX * 22 != iwidth)
/*     */         throw new Errors.DataError("Image is width is not a multiple of: 22", p); 
/*     */       int houseYs = size(iheight, p);
/*     */       int houseHeight = 6 + houseYs * 16;
/*     */       int houses = houseYs * iheight / houseHeight;
/*     */       ArrayList<TILE_SHEET> res = new ArrayList(houses);
/*     */       if (houseYs == 1) {
/*     */         for (int yy = 0; yy < houses; yy++) {
/*     */           TILE_SHEET s = make(tilesX, yy * houseHeight);
/*     */           res.add(s);
/*     */         } 
/*     */       } else {
/*     */         for (int yy = 0; yy < houses; yy++) {
/*     */           int y = houseHeight * yy / houseYs;
/*     */           if (yy % houseYs == 0) {
/*     */             TILE_SHEET s = makeFirst(tilesX, y);
/*     */             res.add(s);
/*     */           } else {
/*     */             y += 16 * yy % houseYs;
/*     */             TILE_SHEET s = make(tilesX, y);
/*     */             res.add(s);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       return (LIST<TILE_SHEET>)res;
/*     */     }
/*     */     
/*     */     private int size(int h, Path p) {
/*     */       for (int i = 1; i < 9; i++) {
/*     */         if (h % (16 * i + 6) == 0)
/*     */           return i; 
/*     */       } 
/*     */       throw new Errors.DataError("Image has wrong dimensions. Image height must be a multiple of x*16+6 pixels. x = how many tiles. Yeah, I can't explain it better...", p);
/*     */     }
/*     */     
/*     */     private TILE_SHEET makeFirst(final int w, final int y1) throws IOException {
/*     */       return (new ComposerThings.ITileSheet() {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */             s.full2.init(0, y1, w, 1, 1, 1, d.s16);
/*     */             for (int i = 0; i < w; i++) {
/*     */               s.full2.setVar(i).pasteRotated(2, true);
/*     */               s.full2.setVar(i).pasteRotated(3, true);
/*     */               s.full2.setVar(i).pasteRotated(0, true);
/*     */               s.full2.setVar(i).pasteRotated(1, true);
/*     */             } 
/*     */             return d.s16.saveGame();
/*     */           }
/*     */         }).get();
/*     */     }
/*     */     
/*     */     public TILE_SHEET make(final int w, final int y1) throws IOException {
/*     */       return (new ComposerThings.ITileSheet() {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */             s.full2.init(0, y1, w, 1, 1, 1, d.s16);
/*     */             for (int i = 0; i < w; i++)
/*     */               s.full2.setVar(i).paste(3, true); 
/*     */             return d.s16.saveGame();
/*     */           }
/*     */         }).get();
/*     */     }
/*     */     
/*     */     public int tile(Sheet sheet, SheetData da, int data, int variation, int rotation) {
/*     */       variation &= 0xFFFF;
/*     */       int am = sheet.tiles;
/*     */       int tt = sheet.hasRotation ? 4 : 1;
/*     */       if (sheet.hasShadow)
/*     */         am -= tt; 
/*     */       variation = getVar(variation, am / tt, da.circular);
/*     */       if (rotation >= 0 && sheet.hasRotation)
/*     */         return (variation * tt % am & 0xFFFFFFFC) + (rotation & 0x3); 
/*     */       return variation % am;
/*     */     }
/*     */     
/*     */     public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/*     */       if (rotation < 0) {
/*     */         if (a.player < 0.0D) {
/*     */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         } else if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/*     */           (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*     */         } else {
/*     */           (SPRITES.cons()).BIG.outline.render(r, 0, x, y);
/*     */         } 
/*     */       } else {
/*     */         int var = 0;
/*     */         if (a.player >= 0.0D)
/*     */           if (a.from > 1.0D) {
/*     */             var = 1;
/*     */           } else {
/*     */             var = 2;
/*     */           }  
/*     */         if (single)
/*     */           var += 3; 
/*     */         Sheet ss = SPRITES.GAME().overlay(this);
/*     */         int t = tile(ss, SheetData.DUMMY, 0, var, rotation);
/*     */         ss.render(null, x, y, null, r, t, 0, 0.0D);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class cXxX extends SheetType {
/*     */     public final int size;
/*     */     
/*     */     cXxX(int size) {
/*     */       super("" + size + "x" + size, size * size, size * 16 + 12, size * 16 + 12, true);
/*     */       this.size = size;
/*     */     }
/*     */     
/*     */     public TILE_SHEET make(final int w, final int y1) throws IOException {
/*     */       return (new ComposerThings.ITileSheet() {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */             s.combo.init(0, y1, w, 1, SheetType.cXxX.this.size, (ComposerDests.Dest)d.s16);
/*     */             for (int i = 0; i < w; i++)
/*     */               s.combo.setVar(i).paste(3, true); 
/*     */             return d.s16.saveGame();
/*     */           }
/*     */         }).get();
/*     */     }
/*     */     
/*     */     public int tile(Sheet sheet, SheetData da, int data, int variation, int rotation) {
/*     */       int t = data;
/*     */       int rot = rotation;
/*     */       int sizeSizeRot = this.sizeSize * (sheet.hasRotation ? 4 : 1);
/*     */       int vars = sheet.tiles / sizeSizeRot - (sheet.hasShadow ? 1 : 0);
/*     */       variation = getVar(variation, vars, da.circular);
/*     */       t += variation * sizeSizeRot;
/*     */       if (rotation >= 0 && sheet.hasRotation)
/*     */         return t + rot * this.sizeSize; 
/*     */       return t;
/*     */     }
/*     */     
/*     */     public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/*     */       UICons c = (SPRITES.cons()).BIG.filled;
/*     */       if (a.player >= 0.0D)
/*     */         if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/*     */           (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*     */         } else {
/*     */           (SPRITES.cons()).BIG.outline.render(r, 0, x, y);
/*     */         }  
/*     */       int m = 0;
/*     */       int dx = dx(data);
/*     */       int dy = dy(data);
/*     */       for (DIR d : DIR.ORTHO) {
/*     */         if (dx + d.x() >= 0 && dx + d.x() < this.size && dy + d.y() >= 0 && dy + d.y() < this.size)
/*     */           m |= d.mask(); 
/*     */       } 
/*     */       c.render(r, m, x, y);
/*     */       if (rotation >= 0) {
/*     */         COLOR.WHITE50.bind();
/*     */         Sheet ss = SPRITES.GAME().overlay(this);
/*     */         int t = tile(ss, SheetData.DUMMY, data & 0x3F, 0, rotation);
/*     */         ss.render(null, x, y, null, r, t, t, 0.0D);
/*     */         COLOR.unbind();
/*     */       } 
/*     */     }
/*     */     
/*     */     public int dx(int data) {
/*     */       return (data & 0x3F) % this.size;
/*     */     }
/*     */     
/*     */     public int dy(int data) {
/*     */       return (data & 0x3F) / this.size;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class cCombo extends SheetType {
/*     */     private cCombo() {
/*     */       super("combo", 16, 72, 72, false);
/*     */     }
/*     */     
/*     */     public TILE_SHEET make(final int amount, final int y1) throws IOException {
/*     */       TILE_SHEET s = (new ComposerThings.ITileSheet() {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */             s.house.init(0, y1, amount, 1, (ComposerDests.Dest)d.s16);
/*     */             for (int i = 0; i < amount; i++)
/*     */               s.house.setVar(i).paste(true); 
/*     */             return d.s16.saveGame();
/*     */           }
/*     */         }).get();
/*     */       return s;
/*     */     }
/*     */     
/*     */     public int tile(Sheet s, SheetData da, int data, int variation, int rotation) {
/*     */       int vars = s.tiles / 16;
/*     */       if (s.hasShadow)
/*     */         vars--; 
/*     */       variation = getVar(variation, vars, da.circular);
/*     */       return data + variation * 16;
/*     */     }
/*     */     
/*     */     public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/*     */       if (a.player < 0.0D) {
/*     */         (SPRITES.cons()).BIG.filled.render(r, data & 0xF, x, y);
/*     */       } else if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/*     */         (SPRITES.cons()).BIG.dashedThick.render(r, data & 0xF, x, y);
/*     */       } else {
/*     */         (SPRITES.cons()).BIG.outline.render(r, data & 0xF, x, y);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class cBox extends SheetType {
/*     */     private final int[][] boxI = Alloc.i2(16);
/*     */     
/*     */     private cBox() {
/*     */       super("box", 16, 76, 76, true);
/*     */       this.boxI[DIR.E.mask() | DIR.S.mask()] = new int[1];
/*     */       (new int[2])[0] = 1;
/*     */       (new int[2])[1] = 2;
/*     */       this.boxI[DIR.S.mask() | DIR.E.mask() | DIR.W.mask()] = new int[2];
/*     */       (new int[1])[0] = 3;
/*     */       this.boxI[DIR.W.mask() | DIR.S.mask()] = new int[1];
/*     */       (new int[2])[0] = 4;
/*     */       (new int[2])[1] = 8;
/*     */       this.boxI[DIR.E.mask() | DIR.N.mask() | DIR.S.mask()] = new int[2];
/*     */       (new int[4])[0] = 5;
/*     */       (new int[4])[1] = 6;
/*     */       (new int[4])[2] = 9;
/*     */       (new int[4])[3] = 10;
/*     */       this.boxI[15] = new int[4];
/*     */       (new int[2])[0] = 7;
/*     */       (new int[2])[1] = 11;
/*     */       this.boxI[DIR.W.mask() | DIR.N.mask() | DIR.S.mask()] = new int[2];
/*     */       (new int[1])[0] = 12;
/*     */       this.boxI[DIR.N.mask() | DIR.E.mask()] = new int[1];
/*     */       (new int[2])[0] = 13;
/*     */       (new int[2])[1] = 14;
/*     */       this.boxI[DIR.N.mask() | DIR.W.mask() | DIR.E.mask()] = new int[2];
/*     */       (new int[1])[0] = 15;
/*     */       this.boxI[DIR.N.mask() | DIR.W.mask()] = new int[1];
/*     */     }
/*     */     
/*     */     public TILE_SHEET make(final int amount, final int y1) throws IOException {
/*     */       return (new ComposerThings.ITileSheet() {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */             s.combo.init(0, y1, amount, 1, 4, (ComposerDests.Dest)d.s16);
/*     */             for (int i = 0; i < amount; i++)
/*     */               s.combo.setVar(i).paste(1, true); 
/*     */             return d.s16.saveGame();
/*     */           }
/*     */         }).get();
/*     */     }
/*     */     
/*     */     public int tile(Sheet s, SheetData da, int data, int variation, int rotation) {
/*     */       int[] ids = this.boxI[data];
/*     */       if (ids == null)
/*     */         return 0; 
/*     */       data = ids[variation % ids.length];
/*     */       variation >>= 4;
/*     */       rotation &= 0x1;
/*     */       int ss = 16 * (s.hasRotation ? 2 : 1);
/*     */       int vars = s.tiles / ss;
/*     */       variation = getVar(variation, vars, da.circular);
/*     */       return data + variation * ss + rotation * 16;
/*     */     }
/*     */     
/*     */     public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/*     */       if (a.player < 0.0D) {
/*     */         (SPRITES.cons()).BIG.filled.render(r, data & 0xF, x, y);
/*     */       } else if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/*     */         (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*     */       } else {
/*     */         (SPRITES.cons()).BIG.outline.render(r, 0, x, y);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public Sheet dummy() {
/*     */     return this.dummy;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\SheetType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */