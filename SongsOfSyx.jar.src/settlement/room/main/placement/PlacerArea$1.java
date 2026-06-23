/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
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
/*    */ class null
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 31 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 35 */     if (PlacerArea.this.embrio.instance.is(tx, ty))
/* 36 */       PlacerArea.this.clear(tx, ty); 
/* 37 */     PlacerArea.this.embrio.history.placeEmbryo(tx, ty, -1);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 42 */     if (!PlacerArea.this.embrio.instance.is(tx, ty)) {
/* 43 */       return PlacableMessages.¤¤ROOM_MUST;
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 50 */     return (PLACABLE)PlacerArea.this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void finishPlacing(AREA placedArea) {
/* 55 */     for (COORDINATE c : placedArea.body()) {
/* 56 */       if (placedArea.is(c)) {
/* 57 */         PlacerArea.this.validateItems(c.x(), c.y());
/*    */       }
/*    */     } 
/* 60 */     super.finishPlacing(placedArea);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void placeInfo(GBox b, int oktiles, AREA a) {
/* 66 */     super.placeInfo(b, oktiles, a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerArea$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */