/*    */ package settlement.thing;
/*    */ 
/*    */ import init.paths.PATH;
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
/*    */ 
/*    */ 
/*    */ public class Sprites
/*    */ {
/*    */   public final TILE_SHEET flesh;
/*    */   public final TILE_SHEET bloodPool;
/*    */   public final TILE_SHEET debris;
/*    */   public final TILE_SHEET caravan;
/*    */   public final TILE_SHEET rubbish;
/*    */   
/*    */   Sprites() throws IOException {
/* 25 */     PATH path = PATHS.SPRITE_SETTLEMENT().getFolder("thing");
/*    */     
/* 27 */     this.flesh = (new ComposerThings.ITileSheet(path.get("Gore"), 236, 62)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */         {
/* 31 */           ComposerDests.Tile t = d.s8;
/* 32 */           ComposerSources.Singles s = ss.singles;
/* 33 */           s.init(0, 0, 1, 1, 8, 4, (ComposerDests.Dest)t);
/* 34 */           s.paste(1, true);
/* 35 */           return t.saveGame();
/*    */         }
/* 38 */       }).get();
/*    */ 
/*    */     
/* 41 */     this.bloodPool = this.flesh.slice(32, 64);
/*    */     
/* 43 */     this.debris = (new ComposerThings.ITileSheet(path.get("Debris"), 292, 34)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */         {
/* 47 */           ComposerDests.Tile t = d.s8;
/* 48 */           ComposerSources.Singles s = ss.singles;
/* 49 */           s.init(0, 0, 1, 1, 10, 2, (ComposerDests.Dest)t);
/* 50 */           s.setSkip(0, 20).paste(true);
/* 51 */           return t.saveGame();
/*    */         }
/* 54 */       }).get();
/*    */     
/* 56 */     this.caravan = (new ComposerThings.ITileSheet(path.get("Caravan"), 100, 116)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 60 */           s.singles.init(0, 0, 1, 1, 2, 5, (ComposerDests.Dest)d.s16);
/* 61 */           for (int i = 0; i < 5; i++) {
/* 62 */             s.singles.setSkip(i * 2, 2).paste(3, true);
/*    */           }
/* 64 */           return d.s16.saveGame();
/*    */         }
/* 66 */       }).get();
/*    */     
/* 68 */     this.rubbish = (new ComposerThings.ITileSheet(path.get("Rubbish"), 460, 20)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d) {
/* 71 */           ComposerDests.Tile t = d.s8;
/* 72 */           ComposerSources.Singles s = ss.singles;
/* 73 */           s.init(0, 0, 1, 1, 16, 1, (ComposerDests.Dest)t);
/* 74 */           s.paste(true);
/* 75 */           return t.saveGame();
/*    */         }
/* 77 */       }).get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\Sprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */