/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMessages;
/*    */ import view.tool.PlacableMulti;
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
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2, PLACABLE $anonymous3) {
/* 43 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 47 */     t.placeFixed(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 52 */     if (!t.isPlacable(tx, ty))
/* 53 */       return PlacableMessages.¤¤BLOCKED; 
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TerrainPlacers$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */