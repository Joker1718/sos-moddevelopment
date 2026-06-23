/*    */ package world.map.terrain;
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
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 49 */     double dd = k / (WorldGroundSprites.this.sheets.length - 1);
/* 50 */     int fg = 1;
/*    */     
/* 52 */     if (dd > 0.5D) {
/* 53 */       fg = 3;
/* 54 */       dd = (dd - 0.5D) * 2.0D;
/* 55 */       dd = 1.0D - dd;
/*    */     } else {
/* 57 */       dd *= 2.0D;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 62 */     s.full.setVar(0);
/* 63 */     s.full.paste(false);
/* 64 */     s.full.setVar(fg);
/* 65 */     s.full.pasteOverBackground(true, dd);
/*    */     
/* 67 */     return d.s16.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldGroundSprites$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */