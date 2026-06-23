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
/*    */ public final class RaceSheet
/*    */ {
/*    */   public final TILE_SHEET sheet;
/*    */   public final TILE_SHEET lay;
/*    */   
/*    */   public RaceSheet(Path path) throws IOException {
/* 18 */     this.sheet = (new ComposerThings.ITileSheet(path, 448, 546)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 22 */           int a = 18;
/* 23 */           s.singles.init(0, 0, 1, 1, 2, a, (ComposerDests.Dest)d.s24);
/* 24 */           for (int i = 0; i < a; i++) {
/* 25 */             s.singles.setSkip(i * 2, 2).paste(3, true);
/*    */           }
/* 27 */           return d.s24.saveGame();
/*    */         }
/* 29 */       }).get();
/*    */     
/* 31 */     this.lay = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 35 */           int a = 6;
/* 36 */           s.singles.init(s.singles.body().x2(), 0, 1, 1, 4, 3, (ComposerDests.Dest)d.s32);
/* 37 */           for (int i = 0; i < a; i++) {
/* 38 */             s.singles.setSkip(i * 2, 2).paste(3, true);
/*    */           }
/* 40 */           return d.s32.saveGame();
/*    */         }
/* 42 */       }).get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RaceSheet.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */