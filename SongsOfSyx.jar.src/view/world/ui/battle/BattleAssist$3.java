/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends Battle.Butt
/*     */ {
/*     */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/*  95 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  99 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 100 */     if (BattleAssist.this.g.player.lossesRetreat() >= BattleAssist.this.g.player.men()) {
/* 101 */       OPACITY.O25.bind();
/* 102 */       COLOR.RED100.render(r, (RECTANGLE)this.body, -4);
/* 103 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 109 */     if (BattleAssist.this.g.player.lossesRetreat() >= BattleAssist.this.g.player.men()) {
/*     */       return;
/*     */     }
/* 112 */     BattleAssist.this.close.exe();
/* 113 */     BattleAssist.this.g.retreat();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 119 */     if (super.hover(mCoo)) {
/* 120 */       BattleAssist.this.setCas(true, false);
/* 121 */       return true;
/*     */     } 
/* 123 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleAssist$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */