/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PortraitAbs
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   final int scale;
/*     */   
/*     */   public PortraitAbs(int scale) {
/*  85 */     super(40 * scale, 64 * scale);
/*  86 */     this.scale = scale;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  91 */     Induvidual ro = indu();
/*     */     
/*  93 */     if (ro == null) {
/*     */       return;
/*     */     }
/*  96 */     int y = Y1;
/*     */     
/*  98 */     STATS.APPEARANCE().portraitRender(r, ro, X1, y, this.scale);
/*     */     
/* 100 */     if (succ() == 0) {
/* 101 */       ((SPRITE)(ro.race().appearance()).crown.crowns().get(0)).renderScaled(r, X1, y + 8 * this.scale, this.scale);
/*     */     } else {
/* 103 */       ((COLOR)UIRoyalty.cols.getC(succ() - 1)).bind();
/* 104 */       int w = this.scale / 2;
/* 105 */       w = CLAMP.i(w, 1, 2);
/* 106 */       (UI.icons()).s.star.render(r, X2 - 16 * w - 4, X2 - 4, Y1 + 4, Y1 + 4 + w * 16);
/* 107 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract Induvidual indu();
/*     */   
/*     */   protected abstract int succ();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIRoyalty$PortraitAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */