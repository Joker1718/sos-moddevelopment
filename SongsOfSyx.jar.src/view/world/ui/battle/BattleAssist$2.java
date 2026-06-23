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
/*    */ import util.text.Dic;
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
/* 54 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 57 */     Text t = text.text();
/* 58 */     t.add(BattleAssist.¤¤assistD);
/* 59 */     t.insert(0, BattleAssist.this.g.victory ? Dic.¤¤Victory : (
/* 60 */         (BattleAssist.this.g.player.losses() >= BattleAssist.this.g.player.men()) ? BattleAssist.¤¤Annihilation : Dic.¤¤Defeat));
/* 61 */     t.insert(1, BattleAssist.this.g.player.losses());
/* 62 */     t.insert(2, BattleAssist.this.g.enemy.losses());
/* 63 */     text.add((SPRITE)t);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 69 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 70 */     if (BattleAssist.this.g.victory) {
/* 71 */       OPACITY.O25.bind();
/* 72 */       COLOR.ORANGE100.render(r, (RECTANGLE)this.body, -4);
/* 73 */       OPACITY.unbind();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hover(COORDINATE mCoo) {
/* 80 */     if (super.hover(mCoo)) {
/* 81 */       BattleAssist.this.setCas(false, true);
/* 82 */       return true;
/*    */     } 
/* 84 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 89 */     BattleAssist.this.close.exe();
/* 90 */     BattleAssist.this.g.auto();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\BattleAssist$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */