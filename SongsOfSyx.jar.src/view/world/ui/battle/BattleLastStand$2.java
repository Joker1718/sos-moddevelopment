/*    */ package view.world.ui.battle;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Text;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Battle.Butt
/*    */ {
/*    */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 64 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 67 */     Text t = text.text();
/* 68 */     t.add(BattleLastStand.¤¤RetireD);
/* 69 */     text.add((SPRITE)t);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 75 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 76 */     if (BattleLastStand.this.g.victory) {
/* 77 */       OPACITY.O25.bind();
/* 78 */       COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/* 79 */       OPACITY.unbind();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hover(COORDINATE mCoo) {
/* 86 */     if (super.hover(mCoo)) {
/* 87 */       BattleLastStand.this.setCas(false, true);
/* 88 */       return true;
/*    */     } 
/* 90 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 95 */     BattleLastStand.this.close.exe();
/* 96 */     BattleLastStand.this.g.auto();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleLastStand$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */