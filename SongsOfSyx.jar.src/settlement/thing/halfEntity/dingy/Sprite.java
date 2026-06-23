/*    */ package settlement.thing.halfEntity.dingy;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.rendering.ShadowBatch;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Sprite
/*    */ {
/* 20 */   private final TILE_SHEET sheetCart = (new ComposerThings.ITileSheet((PATHS.SETT()).sprite.getFolder("thing").get("BOAT_DINGY"), 164, 158)
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 24 */         s.singles.init(0, 0, 1, 1, 2, 5, (ComposerDests.Dest)d.s32);
/* 25 */         for (int i = 0; i < 4; i++) {
/* 26 */           for (int r = 0; r < 4; r++) {
/* 27 */             s.singles.setSkip(i * 2, 1).pasteRotated(r, true);
/* 28 */             s.singles.setSkip(i * 2 + 1, 1).pasteRotated(r, true);
/*    */           } 
/*    */         } 
/*    */         
/* 32 */         return d.s32.saveGame();
/*    */       }
/* 34 */     }).get();
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, ShadowBatch s, int rot, int x, int y, int frame, int upgrade) {
/* 39 */     int i = rot;
/* 40 */     i += (frame & 0x1) * 8;
/* 41 */     i += 16 * (upgrade & 0x1);
/*    */     
/* 43 */     this.sheetCart.render(r, i, x, y);
/* 44 */     s.setHeight(4).setDistance2Ground(0.0D);
/* 45 */     this.sheetCart.render((SPRITE_RENDERER)s, i, x, y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\dingy\Sprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */