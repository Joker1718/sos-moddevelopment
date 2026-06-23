/*    */ package init.race.appearence;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RExtras
/*    */ {
/* 15 */   private static int from = 0;
/*    */   
/*    */   public final TILE_SHEET tool;
/*    */   public final TILE_SHEET water;
/*    */   public final TILE_SHEET trolly;
/*    */   public final TILE_SHEET Lwater;
/*    */   
/*    */   RExtras(Path path) throws IOException {
/* 23 */     this.tool = (new ComposerThings.ITileSheet(path, 428, 310)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 27 */           s.singles.init(0, 0, 1, 1, 2, 24, (ComposerDests.Dest)d.s24);
/* 28 */           return RExtras.this.gets(6, d.s24, s);
/*    */         }
/* 30 */       }).get();
/* 31 */     this.water = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 34 */           RExtras.from = 0;
/* 35 */           s.singles.init(s.singles.body().x2(), 0, 1, 1, 2, 24, (ComposerDests.Dest)d.s24);
/* 36 */           return RExtras.this.gets(4, d.s24, s);
/*    */         }
/* 38 */       }).get();
/* 39 */     this.trolly = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 42 */           RExtras.from = 4;
/* 43 */           return RExtras.this.gets(4, d.s24, s);
/*    */         }
/* 45 */       }).get();
/*    */     
/* 47 */     this.Lwater = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 51 */           s.singles.init(s.singles.body().x2(), 0, 1, 1, 2, 24, (ComposerDests.Dest)d.s32);
/* 52 */           RExtras.from = 0;
/* 53 */           return RExtras.this.gets(4, d.s32, s);
/*    */         }
/* 55 */       }).get();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private TILE_SHEET gets(int nr, ComposerDests.Tile d, ComposerSources s) {
/* 61 */     for (int i = 0; i < nr; i++) {
/* 62 */       s.singles.setSkip((from + i) * 2, 2).paste(3, true);
/*    */     }
/* 64 */     from += nr;
/* 65 */     return d.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RExtras.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */