/*    */ package settlement.tilemap.terrain;
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
/* 71 */     ComposerDests.Tile t = d.s16;
/*    */     
/* 73 */     s.house.init(0, s.full.body().y2(), 4, 1, (ComposerDests.Dest)t);
/* 74 */     for (int i = 0; i < 3; i++) {
/* 75 */       s.house.setVar(i);
/* 76 */       s.house.setSkip(0, 16).paste(1, true);
/*    */     } 
/* 78 */     s.house.setVar(0);
/* 79 */     s.house.setSkip(0, 1).pasteEdges(true);
/*    */ 
/*    */     
/* 82 */     s.house.setVar(3).setSkip(0, 16).paste(true);
/* 83 */     s.house.setVar(3).setSkip(0, 1).pasteEdges(true);
/*    */     
/* 85 */     s.house2.init(0, s.house.body().y2(), 3, 1, (ComposerDests.Dest)t);
/*    */     
/* 87 */     s.house2.paste(true);
/* 88 */     s.house2.setVar(1).paste(true);
/* 89 */     s.house2.setVar(2).paste(1, true);
/* 90 */     s.full.init(0, s.house2.body().y2(), 1, 1, 16, 1, t);
/* 91 */     s.full.paste(true);
/*    */     
/* 93 */     return t.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */