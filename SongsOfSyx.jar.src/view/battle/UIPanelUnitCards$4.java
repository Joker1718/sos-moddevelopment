/*    */ package view.battle;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ import view.main.VIEW;
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
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 83 */     int x1 = body().x1();
/* 84 */     int y1 = body().y1();
/* 85 */     clear();
/* 86 */     for (int i = 0; i < UIPanelUnitCards.xs; i++) {
/* 87 */       int k = ((Integer)ier.get()).intValue() * UIPanelUnitCards.xs + i;
/* 88 */       if (k >= UIPanelUnitCards.this.current.size()) {
/*    */         break;
/*    */       }
/* 91 */       addRightC(0, (RENDEROBJ)UIPanelUnitCards.this.current.get(k));
/*    */     } 
/*    */     
/* 94 */     body().moveX1Y1(x1, y1);
/* 95 */     body().setWidth(((VIEW.UI()).div.battle.width * UIPanelUnitCards.xs));
/* 96 */     body().setHeight((VIEW.UI()).div.battle.height);
/* 97 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIPanelUnitCards$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */