/*    */ package init.race.appearence;
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
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 34 */     RExtras.from = 0;
/* 35 */     s.singles.init(s.singles.body().x2(), 0, 1, 1, 2, 24, (ComposerDests.Dest)d.s24);
/* 36 */     return RExtras.this.gets(4, d.s24, s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RExtras$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */