/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  99 */     if (BattleBattle.this.g.player.lossesRetreat() >= BattleBattle.this.g.player.men()) {
/* 100 */       text.text(BattleBattle.¤¤RetreatCant);
/*     */     } else {
/* 102 */       Text t = text.text();
/* 103 */       t.add(BattleBattle.¤¤RetreatD);
/* 104 */       t.insert(0, BattleBattle.this.g.player.lossesRetreat());
/* 105 */       text.add((SPRITE)t);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 113 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 114 */     if (BattleBattle.this.g.player.lossesRetreat() >= BattleBattle.this.g.player.men()) {
/* 115 */       OPACITY.O25.bind();
/* 116 */       COLOR.RED100.render(r, (RECTANGLE)this.body, -4);
/* 117 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 123 */     if (BattleBattle.this.g.player.lossesRetreat() >= BattleBattle.this.g.player.men()) {
/*     */       return;
/*     */     }
/* 126 */     BattleBattle.this.close.exe();
/* 127 */     BattleBattle.this.g.retreat();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 133 */     if (super.hover(mCoo)) {
/* 134 */       BattleBattle.this.setCas(true, false);
/* 135 */       return true;
/*     */     } 
/* 137 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleBattle$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */