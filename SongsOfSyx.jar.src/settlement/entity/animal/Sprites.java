/*    */ package settlement.entity.animal;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ class Sprites
/*    */ {
/* 22 */   final TILE_SHEET texture_blood = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("animal").get("_Texture"), 328, 196)
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */       {
/* 26 */         ComposerSources.Singles s = ss.singles;
/*    */         
/* 28 */         ComposerDests.Tile t = d.s32;
/* 29 */         s.init(0, 0, 3, 1, 2, 10, (ComposerDests.Dest)t);
/* 30 */         s.setVar(0);
/* 31 */         for (int i = 0; i < 5; i++) {
/* 32 */           s.setSkip(i * 2, 2).paste(3, true);
/*    */         }
/* 34 */         return t.saveGame();
/*    */       }
/* 37 */     }).get();
/*    */   
/* 39 */   final LIST<TILE_SHEET> texture_water = (new ComposerThings.ITileSheetL()
/*    */     {
/*    */       protected int init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 43 */         s.singles.setVar(1);
/* 44 */         return 4;
/*    */       }
/*    */ 
/*    */       
/*    */       protected TILE_SHEET next(int i, ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 49 */         s.singles.setSkip(i * 2, 2).paste(3, true);
/* 50 */         return d.s32.saveGame();
/*    */       }
/* 52 */     }).get();
/*    */   
/* 54 */   final TILE_SHEET crate = (new ComposerThings.ITileSheet()
/*    */     {
/*    */       
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */       {
/* 59 */         ComposerSources.Singles s = ss.singles;
/* 60 */         s.setSkip(8, 2).paste(3, true);
/* 61 */         return d.s32.saveGame();
/*    */       }
/* 64 */     }).get();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Sprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */