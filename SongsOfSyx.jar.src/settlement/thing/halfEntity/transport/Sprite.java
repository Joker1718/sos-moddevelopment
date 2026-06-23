/*    */ package settlement.thing.halfEntity.transport;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import init.resources.RESOURCE;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.rendering.ShadowBatch;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ public final class Sprite
/*    */ {
/*    */   private final TILE_SHEET sheetCart;
/*    */   private final TILE_SHEET sheetHarness;
/* 21 */   private final int M = 4;
/*    */ 
/*    */   
/*    */   Sprite() throws IOException {
/* 25 */     this.sheetCart = (new ComposerThings.ITileSheet((PATHS.SETT()).sprite.getFolder("thing").get("CART"), 164, 234)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 29 */           s.singles.init(0, 0, 1, 1, 2, 6, (ComposerDests.Dest)d.s32);
/* 30 */           for (int i = 0; i < 6; i++) {
/* 31 */             for (int r = 0; r < 4; r++) {
/* 32 */               s.singles.setSkip(i * 2, 1).pasteRotated(r, true);
/* 33 */               s.singles.setSkip(i * 2 + 1, 1).pasteRotated(r, true);
/*    */             } 
/*    */           } 
/*    */           
/* 37 */           return d.s32.saveGame();
/*    */         }
/* 39 */       }).get();
/* 40 */     this.sheetHarness = (new ComposerThings.ITileSheet((PATHS.SETT()).sprite.getFolder("thing").get("CART"), 164, 234)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 44 */           s.singles.init(0, 0, 1, 1, 2, 7, (ComposerDests.Dest)d.s32);
/* 45 */           for (int r = 0; r < 4; r++) {
/* 46 */             s.singles.setSkip(12, 1).pasteRotated(r, true);
/* 47 */             s.singles.setSkip(13, 1).pasteRotated(r, true);
/*    */           } 
/*    */           
/* 50 */           return d.s32.saveGame();
/*    */         }
/* 52 */       }).get();
/*    */   }
/*    */   
/*    */   public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int rot, int cx, int cy, double mov, int ran, double degrade, RESOURCE res, double resamount) {
/* 56 */     int i = rot;
/* 57 */     i += ((int)(mov * 3.0D) & 0x3) * 8;
/* 58 */     DIR d = ((DIR)DIR.ALL.get(rot)).perpendicular();
/*    */ 
/*    */ 
/*    */     
/* 62 */     int x = (int)(cx + d.xN() * 4.0D);
/* 63 */     int y = (int)(cy + d.yN() * 4.0D);
/* 64 */     this.sheetCart.renderC(r, i, x, y);
/* 65 */     s.setHeight(4).setDistance2Ground(0.0D);
/* 66 */     this.sheetCart.renderC((SPRITE_RENDERER)s, i, x, y);
/*    */     
/* 68 */     if (res != null && resamount > 0.0D) {
/* 69 */       x = (int)(d.xN() * 4.0D * 2.0D + cx - 32.0D);
/* 70 */       y = (int)(d.yN() * 4.0D * 2.0D + cy - 32.0D);
/* 71 */       res.renderLaying(r, x, y, ran, resamount * 36.0D + (ran & 0x3));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, ShadowBatch s, int rot, int cx, int cy, double degrade, boolean military) {
/* 76 */     int i = rot + (military ? 40 : 32);
/* 77 */     DIR d = ((DIR)DIR.ALL.get(rot)).perpendicular();
/* 78 */     int x = (int)(cx + d.xN() * 4.0D);
/* 79 */     int y = (int)(cy + d.yN() * 4.0D);
/* 80 */     this.sheetCart.renderC(r, i, x, y);
/* 81 */     s.setHeight(1).setDistance2Ground(0.0D);
/* 82 */     this.sheetCart.renderC((SPRITE_RENDERER)s, i, x, y);
/* 83 */     if (military)
/* 84 */       this.sheetHarness.renderC(r, rot, x, y); 
/*    */   }
/*    */   
/*    */   public void renderHarness(SPRITE_RENDERER r, ShadowBatch s, int rot, int cx, int cy) {
/* 88 */     DIR d = ((DIR)DIR.ALL.get(rot)).perpendicular();
/* 89 */     int x = (int)(cx + d.xN() * 4.0D);
/* 90 */     int y = (int)(cy + d.yN() * 4.0D);
/* 91 */     this.sheetHarness.renderC(r, rot, x, y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\transport\Sprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */