/*    */ package settlement.room.main.throne;
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
/* 63 */     s.singles.init(s.full.body().x2(), s.full.body().y1(), 1, 5, 1, 1, (ComposerDests.Dest)d.s24);
/* 64 */     s.singles.setVar(0).paste(3, true);
/* 65 */     s.singles.setVar(1).paste(3, true);
/* 66 */     s.singles.setVar(2).paste(3, true);
/* 67 */     s.singles.setVar(3).paste(3, true);
/* 68 */     s.singles.setVar(4).paste(3, true);
/* 69 */     s.singles.init(s.singles.body().x2(), s.singles.body().y1(), 1, 5, 1, 1, (ComposerDests.Dest)d.s24);
/* 70 */     s.singles.setVar(0).paste(3, true);
/* 71 */     s.singles.setVar(1).paste(3, true);
/* 72 */     s.singles.setVar(2).paste(3, true);
/* 73 */     s.singles.setVar(3).paste(3, true);
/* 74 */     s.singles.setVar(4).paste(3, true);
/*    */     
/* 76 */     return d.s24.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\throne\Sprite$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */