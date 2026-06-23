/*    */ package init.sprite.UI;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import snake2d.util.sprite.TextureCoords;
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
/*    */ class IconSheet
/*    */   extends Icon
/*    */ {
/*    */   private final TILE_SHEET sheet;
/*    */   private final int tile;
/*    */   
/*    */   IconSheet(int size, TILE_SHEET sheet, int tile) {
/* 85 */     super(size, (SPRITE)new SPRITE.Imp(size, sheet, tile)
/*    */         {
/*    */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */           {
/* 89 */             sheet.render(r, tile, X1, X2, Y1, Y2);
/*    */           }
/*    */         });
/* 92 */     this.sheet = sheet;
/* 93 */     this.tile = tile;
/*    */   }
/*    */ 
/*    */   
/*    */   public TextureCoords texture() {
/* 98 */     return this.sheet.getTexture(this.tile);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\Icon$IconSheet.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */