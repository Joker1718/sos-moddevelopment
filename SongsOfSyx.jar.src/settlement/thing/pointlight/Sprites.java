/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import init.sprite.SPRITES;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TileTexture;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ final class Sprites
/*    */ {
/*    */   public final TILE_SHEET flame_small;
/*    */   public final TILE_SHEET flame_medium;
/*    */   public final TILE_SHEET flame_big;
/*    */   public final TILE_SHEET candle;
/* 22 */   public final TileTexture.TileTextureScroller displacement = (SPRITES.textures()).dis_big.scroller(4.0D, -3.0D);
/* 23 */   public final TileTexture.TileTextureScroller texture = (SPRITES.textures()).fire.scroller(-3.0D, 4.0D);
/*    */ 
/*    */   
/*    */   Sprites() throws IOException {
/* 27 */     PATH path = PATHS.SPRITE_SETTLEMENT().getFolder("thing");
/*    */     
/* 29 */     this.flame_small = (new ComposerThings.ITileSheet(path.get("Fire"), 236, 62)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */         {
/* 33 */           ComposerDests.Tile t = d.s8;
/* 34 */           ComposerSources.Singles s = ss.singles;
/* 35 */           s.init(0, 0, 1, 1, 8, 4, (ComposerDests.Dest)t);
/* 36 */           s.setSkip(0, 8).paste(true);
/* 37 */           return t.saveGame();
/*    */         }
/* 40 */       }).get();
/*    */     
/* 42 */     this.flame_medium = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */         {
/* 46 */           ComposerDests.Tile t = d.s8;
/* 47 */           ComposerSources.Singles s = ss.singles;
/* 48 */           s.setSkip(8, 8).paste(true);
/* 49 */           return t.saveGame();
/*    */         }
/* 52 */       }).get();
/*    */     
/* 54 */     this.flame_big = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */         {
/* 58 */           ComposerDests.Tile t = d.s8;
/* 59 */           ComposerSources.Singles s = ss.singles;
/* 60 */           s.setSkip(16, 8).paste(true);
/* 61 */           return t.saveGame();
/*    */         }
/* 64 */       }).get();
/*    */     
/* 66 */     this.candle = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d)
/*    */         {
/* 70 */           ComposerDests.Tile t = d.s8;
/* 71 */           ComposerSources.Singles s = ss.singles;
/* 72 */           s.setSkip(24, 8).paste(true);
/* 73 */           return t.saveGame();
/*    */         }
/* 76 */       }).get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\Sprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */