/*    */ package view.world.editor;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 30 */     if (!SPRITES.loader().isMini())
/* 31 */       SPRITES.loader().minify(true, Dic.¤¤Generating); 
/* 32 */     SPRITES.loader().print(Dic.¤¤Generating);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\editor\WorldViewEditor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */