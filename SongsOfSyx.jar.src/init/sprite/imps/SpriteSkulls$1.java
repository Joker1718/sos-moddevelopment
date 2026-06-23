/*    */ package init.sprite.imps;
/*    */ 
/*    */ import init.sprite.game.Sheet;
/*    */ import init.sprite.game.SheetData;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Sheet
/*    */ {
/*    */   null(int $anonymous0, boolean $anonymous1, boolean $anonymous2) {
/* 32 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   public TextureCoords texture(int tile) {
/* 37 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/* 42 */     shadow.setDistance2Ground(0.0D);
/* 43 */     shadow.setHeight(4);
/* 44 */     SpriteSkulls.this.render(x, y, DIR.C, it, (SPRITE_RENDERER)shadow, random);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 50 */     SpriteSkulls.this.render(x, y, DIR.C, it, sr, random);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\imps\SpriteSkulls$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */