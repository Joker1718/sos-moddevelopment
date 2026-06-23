/*    */ package init.sprite.UI;
/*    */ 
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
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
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 41 */     s.singles.init(0, s.singles.body().y2(), 1, 1, 1, 1, (ComposerDests.Dest)d.s16);
/* 42 */     s.singles.paste(3, true);
/* 43 */     s.combo.init(s.singles.body().x2(), s.singles.body().y1(), 1, 1, 2, (ComposerDests.Dest)d.s16);
/* 44 */     s.combo.paste(3, true);
/* 45 */     s.combo.init(s.combo.body().x2(), s.singles.body().y1(), 1, 1, 3, (ComposerDests.Dest)d.s16);
/* 46 */     s.combo.paste(3, true);
/* 47 */     return d.s16.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIConses$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */