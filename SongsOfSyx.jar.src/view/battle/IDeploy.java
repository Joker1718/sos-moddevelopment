/*    */ package view.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.constant.C;
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ import view.interrupter.InterManager;
/*    */ import view.interrupter.Interrupter;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public class IDeploy extends Interrupter {
/* 17 */   private final GButt.ButtPanel butt = new GButt.ButtPanel(Dic.¤¤Start)
/*    */     {
/*    */       protected void clickA() {
/* 20 */         VIEW.b().state().deploy();
/* 21 */         IDeploy.this.hide();
/*    */       }
/*    */     };
/*    */   
/*    */   public IDeploy(InterManager m) {
/* 26 */     this.butt.pad(50, 5);
/* 27 */     this.butt.body.centerX(C.DIM());
/* 28 */     this.butt.body.moveY1(0.0D);
/* 29 */     pin();
/* 30 */     show(m);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 35 */     return this.butt.hover(mCoo);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 40 */     if (button == MButt.LEFT) {
/* 41 */       this.butt.click();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hoverTimer(GBox text) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 52 */     this.butt.render((SPRITE_RENDERER)r, ds);
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 58 */     GAME.SPEED.tmpPause();
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\IDeploy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */