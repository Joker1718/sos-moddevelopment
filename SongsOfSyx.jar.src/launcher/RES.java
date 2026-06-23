/*     */ package launcher;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerFonter;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RES
/*     */ {
/*     */   public final Font font;
/*     */   public final SPRITE[] clouds;
/*     */   public final SPRITE logo;
/*  26 */   public final SPRITE[] smallPanel = new SPRITE[3];
/*     */   
/*     */   public final SPRITE[] social;
/*     */   public final SPRITE[] arrowUpDown;
/*     */   public final SPRITE[] arrowLR;
/*     */   public final SPRITE[] langs;
/*     */   public final SPRITE bg;
/*     */   
/*     */   RES() throws IOException {
/*  35 */     Json json = new Json((PATHS.CONFIG()).init.gets("Charset"));
/*  36 */     CharSequence cs = json.text("CHARS");
/*  37 */     final int trail = json.i("SPACING", 0, 32, 0);
/*     */     
/*  39 */     Font.setCharset(cs);
/*  40 */     this.font = (new ComposerThings.IFont(PATHS.SPRITE().getFolder("font").get("Medium"))
/*     */       {
/*     */         protected Font init(ComposerUtil c, ComposerFonter f)
/*     */         {
/*  44 */           return f.save(0, 0, trail);
/*     */         }
/*  46 */       }).get(trail);
/*     */ 
/*     */ 
/*     */     
/*  50 */     this.clouds = sprite(0, 4, 4, 6, 2);
/*  51 */     this.logo = sprite(70, 24, 4, 2);
/*  52 */     this.smallPanel[0] = sprite(140, 29, 2, 2);
/*  53 */     this.smallPanel[1] = sprite(178, 29, 1, 2);
/*  54 */     this.smallPanel[2] = sprite(200, 29, 1, 2);
/*     */ 
/*     */     
/*  57 */     TILE_SHEET ls = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  61 */           s.singles.init(0, 222, 1, 1, 10, 1, (ComposerDests.Dest)d.s24);
/*  62 */           s.singles.paste(true);
/*  63 */           return d.s24.save(1);
/*     */         }
/*  66 */       }).get();
/*     */     
/*  68 */     this.social = new SPRITE[] {
/*  69 */         ls.makeSprite(0), 
/*  70 */         ls.makeSprite(1), 
/*  71 */         ls.makeSprite(2), 
/*  72 */         ls.makeSprite(3)
/*     */       };
/*  74 */     this.arrowUpDown = new SPRITE[] {
/*  75 */         ls.makeSprite(4), 
/*  76 */         ls.makeSprite(5)
/*     */       };
/*     */     
/*  79 */     this.arrowLR = new SPRITE[] {
/*  80 */         ls.makeSprite(6), 
/*  81 */         ls.makeSprite(7)
/*     */       };
/*     */ 
/*     */     
/*  85 */     ls = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  89 */           s.singles.init(0, 252, 1, 1, 14, 2, (ComposerDests.Dest)d.s24);
/*  90 */           s.singles.paste(true);
/*  91 */           return d.s24.save(1);
/*     */         }
/*  94 */       }).get();
/*  95 */     this.langs = new SPRITE[28];
/*  96 */     for (int i = 0; i < this.langs.length; i++) {
/*  97 */       this.langs[i] = ls.makeSprite(i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     TILE_SHEET sh = (new ComposerThings.ITileSheet((PATHS.BASE()).LAUNCHER.getFolder("assets").get("BG"), 920, 236)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 109 */           s.full.init(0, 0, 1, 1, 28, 14, d.s16);
/* 110 */           s.full.paste(true);
/* 111 */           return d.s16.save(1);
/*     */         }
/* 114 */       }).get();
/*     */     
/* 116 */     this.bg = toSprite(sh, 28, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SPRITE sprite(final int y1, final int tilesX, final int tilesY, int scale) throws IOException {
/* 125 */     TILE_SHEET ls = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 129 */           s.full.init(0, y1, 1, 1, tilesX, tilesY, d.s16);
/* 130 */           s.full.paste(true);
/* 131 */           return d.s16.save(1);
/*     */         }
/* 134 */       }).get();
/*     */     
/* 136 */     return toSprite(ls, tilesX, scale);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private SPRITE[] sprite(final int y1, final int tilesX, final int tilesY, final int amount, int scale) throws IOException {
/* 142 */     SPRITE[] res = new SPRITE[amount];
/*     */     
/* 144 */     LIST<TILE_SHEET> ls = (new ComposerThings.ITileSheetL()
/*     */       {
/*     */         protected int init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 148 */           s.full.init(0, y1, amount, 1, tilesX, tilesY, d.s16);
/* 149 */           return amount;
/*     */         }
/*     */ 
/*     */         
/*     */         protected TILE_SHEET next(int i, ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 154 */           s.full.setVar(i).paste(true);
/* 155 */           return d.s16.save(1);
/*     */         }
/* 158 */       }).get();
/*     */     
/* 160 */     for (int i = 0; i < res.length; i++) {
/* 161 */       res[i] = toSprite((TILE_SHEET)ls.get(i), tilesX, scale);
/*     */     }
/*     */     
/* 164 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private SPRITE toSprite(final TILE_SHEET sh, final int tilesX, int scale) {
/* 169 */     int w = tilesX * sh.size();
/* 170 */     int h = (int)(sh.size() * Math.ceil((sh.tiles() / tilesX)));
/*     */     
/* 172 */     return (SPRITE)new SPRITE.Imp(w * scale, h * scale)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 176 */           int d = (X2 - X1) / tilesX;
/*     */           
/* 178 */           for (int i = 0; i < sh.tiles(); i++) {
/* 179 */             int x = X1 + d * i % tilesX;
/* 180 */             int y = Y1 + d * i / tilesX;
/* 181 */             sh.render(r, i, x, x + d, y, y + d);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\RES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */