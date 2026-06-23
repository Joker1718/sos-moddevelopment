/*    */ package game.raiding;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 45 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 49 */     VIEW.world().activate();
/* 50 */     (VIEW.world()).window.setZoomout(0);
/* 51 */     (VIEW.world()).window.centererTile.set(MessArmyAppear.this.x, MessArmyAppear.this.y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessArmyAppear$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */