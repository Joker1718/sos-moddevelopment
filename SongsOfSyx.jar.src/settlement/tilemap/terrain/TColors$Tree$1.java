/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import snake2d.util.color.COLOR;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends ComposerThings.IColorSampler
/*    */ {
/*    */   protected COLOR next(int i, ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 71 */     s.full.setSkip(1, row * 16 + i);
/* 72 */     return s.full.sample();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 77 */     s.full.init(0, 0, 1, 1, 16, 4, d.s16);
/* 78 */     return 16;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TColors$Tree$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */