/*    */ package view.world.generator;
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
/* 44 */     if (!SPRITES.loader().isMini())
/* 45 */       SPRITES.loader().minify(true, Dic.¤¤Generating); 
/* 46 */     SPRITES.loader().print(Dic.¤¤Generating);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\WorldViewGenerator$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */