/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
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
/*     */ final class WorldGroundSprites
/*     */ {
/*     */   public final TILE_SHEET[] sheets;
/*     */   public final TILE_SHEET stencil;
/*     */   public final TILE_SHEET[] cracked;
/*  24 */   public final int DIM = 8;
/*     */ 
/*     */   
/*     */   public WorldGroundSprites() throws IOException {
/*  28 */     this.sheets = new TILE_SHEET[8];
/*     */     
/*  30 */     this.stencil = (new ComposerThings.ITileSheet(PATHS.SPRITE_WORLD_MAP().get("Ground"), 576, 300)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*  33 */           s.house.init(0, 0, 4, 1, (ComposerDests.Dest)d.s16);
/*  34 */           for (int i = 0; i < 4; i++)
/*  35 */             s.house.setVar(i).paste(true); 
/*  36 */           s.full.init(0, s.house.body().y2(), 2, 4, 8, 8, d.s16);
/*  37 */           return d.s16.saveGame();
/*     */         }
/*  40 */       }).get();
/*     */     
/*  42 */     for (int i = 0; i < this.sheets.length; i++) {
/*  43 */       final double k = i;
/*     */       
/*  45 */       this.sheets[i] = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  49 */             double dd = k / (WorldGroundSprites.this.sheets.length - 1);
/*  50 */             int fg = 1;
/*     */             
/*  52 */             if (dd > 0.5D) {
/*  53 */               fg = 3;
/*  54 */               dd = (dd - 0.5D) * 2.0D;
/*  55 */               dd = 1.0D - dd;
/*     */             } else {
/*  57 */               dd *= 2.0D;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/*  62 */             s.full.setVar(0);
/*  63 */             s.full.paste(false);
/*  64 */             s.full.setVar(fg);
/*  65 */             s.full.pasteOverBackground(true, dd);
/*     */             
/*  67 */             return d.s16.saveGame();
/*     */           }
/*  70 */         }).get();
/*     */     } 
/*     */     
/*  73 */     this.cracked = new TILE_SHEET[] {
/*  74 */         (new ComposerThings.ITileSheet()
/*     */         {
/*     */           
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  79 */             s.full.setVar(0);
/*  80 */             s.full.paste(false);
/*  81 */             s.full.setVar(2);
/*  82 */             s.full.pasteOverBackground(true, 0.5D);
/*     */             
/*  84 */             return d.s16.saveGame();
/*     */           }
/*  87 */         }).get(), (
/*  88 */         new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*  91 */             s.full.setVar(2);
/*  92 */             s.full.paste(true);
/*  93 */             return d.s16.saveGame();
/*     */           }
/*  96 */         }).get()
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int ran(int tx, int ty) {
/* 105 */     return (tx & 0x7) + (ty & 0x7) * 8;
/*     */   }
/*     */   
/*     */   public final void renderNormal(TILE_SHEET sheet, SPRITE_RENDERER r, int x, int y, int ran) {
/* 109 */     sheet.render(r, ran & 0x3F, x, y);
/*     */   }
/*     */   
/*     */   public final void renderStenciled(TILE_SHEET sheet, SPRITE_RENDERER r, int x, int y, int mask, int ran1, int ran2) {
/* 113 */     this.stencil.renderTextured(sheet.getTexture(ran1 & 0x3F), mask + 16 * (ran2 & 0x3), x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldGroundSprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */