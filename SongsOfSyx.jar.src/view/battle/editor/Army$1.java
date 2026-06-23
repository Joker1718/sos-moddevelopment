/*    */ package view.battle.editor;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.constant.Config;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
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
/* 42 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 47 */     (GAME.battle()).power.getClass(); double pow = 1000.0D + ((Config.battle()).MEN_PER_ARMY * RND.rFloat() * RND.rFloat() * RND.rFloat()) * 5.0D;
/*    */     
/* 49 */     player.generate(pow);
/* 50 */     enemy.generate(pow);
/*    */     
/* 52 */     super.clickA();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\Army$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */