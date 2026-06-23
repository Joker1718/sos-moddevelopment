/*    */ package view.battle.editor;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 28 */     if (!SPRITES.loader().isMini())
/* 29 */       SPRITES.loader().minify(true, Dic.¤¤Generating); 
/* 30 */     SPRITES.loader().print(Dic.¤¤Generating);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\BattleViewEditor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */