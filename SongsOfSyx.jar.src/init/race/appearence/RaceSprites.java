/*    */ package init.race.appearence;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ public final class RaceSprites
/*    */ {
/* 15 */   private static int from = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   public final TILE_SHEET blood = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("race").getFolder("misc").get("Overlays"), 460, 486)
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 32 */         s.singles.init(0, 0, 1, 1, 2, 24, (ComposerDests.Dest)d.s24);
/* 33 */         RaceSprites.from = 0;
/* 34 */         return RaceSprites.this.gets(8, d.s24, s);
/*    */       }
/* 36 */     }).get();
/* 37 */   public final TILE_SHEET grit = (new ComposerThings.ITileSheet()
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 41 */         return RaceSprites.this.gets(8, d.s24, s);
/*    */       }
/* 43 */     }).get();
/*    */   
/* 45 */   public final TILE_SHEET Lblood = (new ComposerThings.ITileSheet()
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 49 */         s.singles.init(s.singles.body().x2(), 0, 1, 1, 2, 24, (ComposerDests.Dest)d.s32);
/* 50 */         RaceSprites.from = 0;
/* 51 */         return RaceSprites.this.gets(8, d.s32, s);
/*    */       }
/* 53 */     }).get();
/*    */ 
/*    */ 
/*    */   
/* 57 */   public final TILE_SHEET Lgrit = (new ComposerThings.ITileSheet()
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 61 */         s.singles.init(s.singles.body().x2(), 0, 1, 1, 2, 24, (ComposerDests.Dest)d.s32);
/* 62 */         RaceSprites.from = 0;
/* 63 */         return RaceSprites.this.gets(8, d.s32, s);
/*    */       }
/* 65 */     }).get();
/*    */ 
/*    */   
/* 68 */   public final TILE_SHEET gore_stencil = (new ComposerThings.ITileSheet(PATHS.SPRITE().getFolder("race").getFolder("misc").get("Gore"), 316, 158)
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 72 */         s.singles.init(0, 0, 1, 1, 4, 4, (ComposerDests.Dest)d.s32);
/* 73 */         s.singles.setSkip(0, 8).paste(true);
/* 74 */         return d.s32.saveGame();
/*    */       }
/* 76 */     }).get();
/*    */   
/* 78 */   public final TILE_SHEET gore_overlay = (new ComposerThings.ITileSheet()
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 82 */         s.singles.setSkip(8, 8).paste(true);
/* 83 */         return d.s32.saveGame();
/*    */       }
/* 85 */     }).get();
/*    */ 
/*    */ 
/*    */   
/*    */   private TILE_SHEET gets(int nr, ComposerDests.Tile d, ComposerSources s) {
/* 90 */     for (int i = 0; i < nr; i++) {
/* 91 */       s.singles.setSkip((from + i) * 2, 2).paste(3, true);
/*    */     }
/* 93 */     from += nr;
/* 94 */     return d.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RaceSprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */