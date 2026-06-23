/*     */ package menu;
/*     */ 
/*     */ import game.faction.player.PTitles;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.SnakeImage;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RSprites
/*     */ {
/* 118 */   private final PATH g = PATHS.SPRITE().getFolder("menu"); public final TILE_SHEET background; public final TILE_SHEET backgroundCr; public final int backgroundTilesX; private static final int lHeight = 67;
/*     */   public final SPRITE[] logoGlyps;
/*     */   public final SPRITE logoFlash;
/*     */   public final SPRITE logoPresents;
/*     */   
/*     */   RSprites() throws IOException {
/* 124 */     COORDINATE dd = SnakeImage.dim(this.g.get("Background"));
/* 125 */     this.backgroundTilesX = (dd.x() - 24) / 64;
/* 126 */     final int ty = (dd.y() - 12) / 32;
/* 127 */     this.background = (new ComposerThings.ITileSheet(this.g.get("Background"), dd.x(), dd.y())
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 131 */           s.full.init(0, 0, 1, 1, RESOURCES.RSprites.this.backgroundTilesX, ty, d.s32);
/* 132 */           s.full.paste(true);
/* 133 */           return d.s32.save(2);
/*     */         }
/* 135 */       }).get();
/* 136 */     this.backgroundCr = (new ComposerThings.ITileSheet(this.g.get("BackgroundCr"), 3096, 396)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 140 */           s.full.init(0, 0, 1, 1, 48, 12, d.s32);
/* 141 */           s.full.paste(true);
/* 142 */           return d.s32.save(2);
/*     */         }
/* 144 */       }).get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       .logoGlyps = new SPRITE[] { (SPRITE)new ComposerThings.ITileSprite(45, 67, 1, this.g.get("GamatronLogo"), 1552, 92) { protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { s.full.init(0, 0, 1, 1, 3, 5, d.s16); s.full.paste(true); return d.s16.save(1); } }, glyph(56), glyph(64), glyph(55), glyph(46), glyph(57), glyph(48), glyph(57) };
/*     */     
/* 168 */     this.logoFlash = glyph(55);
/* 169 */     this.logoPresents = (SPRITE)new ComposerThings.ITileSprite(128, 19, 1)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 173 */           s.full.init(s.full.body().x2(), 0, 1, 1, 8, 2, d.s16);
/* 174 */           s.full.paste(true);
/* 175 */           return d.s16.save(1);
/*     */         }
/*     */       };
/* 178 */     this.logo = (SPRITE)new ComposerThings.ITileSprite(352, 224, 1, this.g.get("Logo"), 728, 224)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 182 */           s.full.init(0, 0, 1, 1, 11, 7, d.s32);
/* 183 */           s.full.paste(true);
/* 184 */           return d.s32.save(1);
/*     */         }
/*     */       };
/* 187 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 195 */       .logoColors = new COLOR[] { (COLOR)(new ColorImp(61, 5, 15)).saturateSelf(0.75D), (COLOR)(new ColorImp(75, 26, 5)).saturateSelf(0.75D), (COLOR)(new ColorImp(84, 60, 10)).saturateSelf(0.75D), (COLOR)(new ColorImp(15, 75, 4)).saturateSelf(0.75D), (COLOR)(new ColorImp(15, 75, 10)).saturateSelf(0.75D), (COLOR)(new ColorImp(2, 10, 75)).saturateSelf(0.75D), (COLOR)(new ColorImp(61, 5, 15)).saturateSelf(0.75D), (COLOR)(new ColorImp(75, 30, 5)).saturateSelf(0.75D) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     this.creditsSmall = new SPRITE[13];
/* 219 */     this.creditsSmallFrame = (SPRITE)new ComposerThings.ITileSprite(64, 64, 3, this.g.get("CreditSmall"), 2128, 76)
/*     */       {
/*     */         
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 224 */           s.full.init(0, 0, RESOURCES.RSprites.this.creditsSmall.length + 1, 1, 2, 2, d.s32);
/* 225 */           s.full.setVar(0).paste(true);
/* 226 */           return d.s32.save(3);
/*     */         }
/*     */       };
/*     */     int i;
/* 230 */     for (i = 0; i < this.creditsSmall.length; i++) {
/* 231 */       final int k = i;
/*     */       
/* 233 */       this.creditsSmall[i] = (SPRITE)new ComposerThings.ITileSprite(64, 64, 3)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 236 */             s.full.setVar(k + 1).paste(true);
/* 237 */             return d.s32.save(3);
/*     */           }
/*     */         };
/*     */     } 
/* 241 */     this.creditsBig = new SPRITE[11];
/* 242 */     this.creditsBigFrame = (SPRITE)new ComposerThings.ITileSprite(96, 128, 3, this.g.get("CreditLarge"), 2596, 140)
/*     */       {
/*     */         
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 247 */           s.full.init(0, 0, RESOURCES.RSprites.this.creditsBig.length + 1, 1, 3, 4, d.s32);
/* 248 */           s.full.setVar(0).paste(true);
/* 249 */           return d.s32.save(3);
/*     */         }
/*     */       };
/*     */     
/* 253 */     for (i = 0; i < this.creditsBig.length; i++) {
/* 254 */       final int k = i;
/* 255 */       this.creditsBig[i] = (SPRITE)new ComposerThings.ITileSprite(96, 128, 3)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 258 */             s.full.setVar(k + 1).paste(true);
/* 259 */             return d.s32.save(3);
/*     */           }
/*     */         };
/*     */     } 
/*     */     
/* 264 */     this.modeIcons = (new PTitles.IconMaker()).all();
/*     */   }
/*     */   
/*     */   public final SPRITE logo;
/*     */   public final COLOR[] logoColors;
/*     */   public final SPRITE creditsSmallFrame;
/*     */   public final SPRITE[] creditsSmall;
/*     */   public final SPRITE creditsBigFrame;
/*     */   public final SPRITE[] creditsBig;
/*     */   public final SPRITE[] modeIcons;
/*     */   
/*     */   private SPRITE glyph(int width) throws IOException {
/*     */     final int tx = (int)Math.ceil(width / 16.0D);
/*     */     return (SPRITE)new ComposerThings.ITileSprite(width, 67, 1) {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */           s.full.init(s.full.body().x2(), 0, 1, 1, tx, 5, d.s16);
/*     */           s.full.paste(true);
/*     */           return d.s16.save(1);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\RESOURCES$RSprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */