/*    */ package init.sprite.imps;
/*    */ 
/*    */ import init.sprite.game.Sheet;
/*    */ import init.sprite.game.SheetData;
/*    */ import init.sprite.game.SheetType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Sheet
/*    */ {
/*    */   null(int $anonymous0, boolean $anonymous1, boolean $anonymous2) {
/* 56 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   public TextureCoords texture(int tile) {
/* 61 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/* 66 */     shadow.setDistance2Ground(0.0D);
/* 67 */     shadow.setHeight(4);
/*    */     
/* 69 */     DIR d = DIR.get(0.5D - SheetType.s2x2.dx(tile), 0.5D - SheetType.s2x2.dy(tile));
/*    */     
/* 71 */     SpriteSkulls.this.render(x, y, d, it, (SPRITE_RENDERER)shadow, random);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 77 */     DIR d = DIR.get(0.5D - SheetType.s2x2.dx(tile), 0.5D - SheetType.s2x2.dy(tile));
/* 78 */     SpriteSkulls.this.render(x, y, d, it, sr, random);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\imps\SpriteSkulls$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */