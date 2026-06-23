/*    */ package init.sprite.UI;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ import util.colors.GCOLOR;
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
/*    */ class null
/*    */   implements SPRITE
/*    */ {
/* 35 */   private final TILE_SHEET sheet2 = (new ComposerThings.ITileSheet(PATHS.SPRITE_UI().get("Decor"), 664, 160)
/*    */     {
/*    */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */       {
/* 39 */         s.full.init(0, 0, 1, 1, 4, 1, d.s32);
/* 40 */         s.full.paste(true);
/* 41 */         return d.s32.saveGui();
/*    */       }
/* 43 */     }).get();
/*    */ 
/*    */   
/*    */   public int width() {
/* 47 */     return 128;
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 52 */     return 32;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 63 */     (GCOLOR.T()).H1.bind();
/* 64 */     for (int i = 0; i < 4; i++)
/* 65 */       this.sheet2.render(r, i, X1 + 32 * i, Y1); 
/* 66 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIDecor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */