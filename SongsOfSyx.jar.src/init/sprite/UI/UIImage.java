/*    */ package init.sprite.UI;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TextureCoords;
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
/*    */ public class UIImage
/*    */   implements SPRITE
/*    */ {
/*    */   private static final int TILE_SIZE = 64;
/*    */   private final int tilesX;
/*    */   private final int tilesY;
/*    */   private final int width;
/*    */   private final int height;
/*    */   private final TILE_SHEET sheet;
/*    */   
/*    */   UIImage(TILE_SHEET sheet, final int tilesX, final int tilesY) throws IOException {
/* 29 */     this.sheet = sheet;
/* 30 */     this.tilesX = tilesX;
/* 31 */     this.tilesY = tilesY;
/* 32 */     this.width = tilesX * 64;
/* 33 */     this.height = tilesY * 64;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 39 */     sheet = (new ComposerThings.ITileSheet()
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 43 */           s.full.init(0, 0, 1, 1, tilesX, tilesY, d.s32);
/* 44 */           s.full.paste(true);
/* 45 */           return d.s32.saveNormal();
/*    */         }
/* 47 */       }).get();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int width() {
/* 53 */     return this.width;
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 58 */     return this.height;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 63 */     int startX = X1;
/* 64 */     int tile = 0;
/* 65 */     for (int ty = 0; ty < this.tilesY; ty++) {
/* 66 */       X1 = startX;
/* 67 */       for (int tx = 0; tx < this.tilesX; tx++) {
/* 68 */         this.sheet.render(r, tile, X1, Y1);
/* 69 */         X1 += 64;
/* 70 */         tile++;
/*    */       } 
/* 72 */       Y1 += 64;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 79 */     throw new RuntimeException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIImage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */