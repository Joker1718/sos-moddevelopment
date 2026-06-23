/*    */ package settlement.entity.animal;
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
/*    */ class null
/*    */   extends ComposerThings.ITileSheetL
/*    */ {
/*    */   protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 43 */     s.singles.setVar(1);
/* 44 */     return 4;
/*    */   }
/*    */ 
/*    */   
/*    */   protected TILE_SHEET next(int i, ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 49 */     s.singles.setSkip(i * 2, 2).paste(3, true);
/* 50 */     return d.s32.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Sprites$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */