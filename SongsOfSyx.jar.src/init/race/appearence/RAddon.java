/*     */ package init.race.appearence;
/*     */ 
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ public final class RAddon
/*     */ {
/*     */   public final RColors.ColorCollection col;
/*     */   public final TILE_SHEET sheetStand;
/*     */   public final TILE_SHEET sheetLay;
/*  24 */   public final Lockable<Induvidual> cons = GVALUES.INDU.LOCK.push();
/*     */ 
/*     */   
/*     */   RAddon(Json json, RColors colors, RAddon[] done) throws IOException {
/*  28 */     this.cons.push("CONDITIONS", json);
/*  29 */     if (json.has("COLOR")) {
/*  30 */       this.col = (RColors.ColorCollection)colors.collection.read("COLOR", json);
/*     */     } else {
/*  32 */       this.col = RColors.ColorCollection.DUMMY;
/*  33 */     }  int ii = json.i("ADDON_INDEX", 0, 8);
/*     */     
/*  35 */     if (done[ii] != null) {
/*  36 */       this.sheetStand = (done[ii]).sheetStand;
/*  37 */       this.sheetLay = (done[ii]).sheetLay;
/*     */       
/*     */       return;
/*     */     } 
/*  41 */     final int y1 = 194 + 44 * ii;
/*  42 */     int x1 = 66;
/*     */     
/*  44 */     this.sheetStand = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  48 */           s.singles.init(66, y1, 1, 1, 2, 1, (ComposerDests.Dest)d.s24);
/*  49 */           s.singles.setSkip(0, 2).paste(3, true);
/*  50 */           return d.s24.saveGame();
/*     */         }
/*  52 */       }).get();
/*     */     
/*  54 */     this.sheetLay = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  58 */           s.singles.init(s.singles.body().x2(), y1, 1, 1, 2, 1, (ComposerDests.Dest)d.s32);
/*  59 */           s.singles.setSkip(0, 2).paste(3, true);
/*  60 */           return d.s32.saveGame();
/*     */         }
/*  62 */       }).get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderStanding(Renderer r, int dir, int x, int y, Induvidual in2, boolean dead) {
/*  68 */     render(this.sheetStand, r, dir, x, y, in2, dead);
/*     */   }
/*     */   
/*     */   public void renderLaying(Renderer r, int dir, int x, int y, Induvidual in2, boolean dead) {
/*  72 */     render(this.sheetLay, r, dir, x, y, in2, dead);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderLayingTextured(TILE_SHEET stencil, int si, Renderer r, int dir, int x, int y, Induvidual in2, boolean dead) {
/*  77 */     if (!this.cons.passes(in2)) {
/*     */       return;
/*     */     }
/*  80 */     this.col.get(in2, dead).bind();
/*     */     
/*  82 */     stencil.renderTextured(this.sheetLay.getTexture(dir), si, x, y);
/*  83 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(TILE_SHEET s, Renderer r, int dir, int x, int y, Induvidual in2, boolean dead) {
/*  88 */     if (!this.cons.passes(in2)) {
/*     */       return;
/*     */     }
/*  91 */     this.col.get(in2, dead).bind();
/*  92 */     s.render((SPRITE_RENDERER)r, dir, x, y);
/*  93 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderLaying(Renderer r, int dir, int x, int y, Induvidual in2, boolean dead, COLOR cDecay, double decay) {
/*  98 */     if (!this.cons.passes(in2)) {
/*     */       return;
/*     */     }
/* 101 */     ColorImp.TMP.interpolate(this.col.get(in2, dead), cDecay, decay);
/* 102 */     ColorImp.TMP.bind();
/* 103 */     this.sheetLay.render((SPRITE_RENDERER)r, dir, x, y);
/* 104 */     COLOR.unbind();
/*     */     
/* 106 */     render(this.sheetLay, r, dir, x, y, in2, dead);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RAddon.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */