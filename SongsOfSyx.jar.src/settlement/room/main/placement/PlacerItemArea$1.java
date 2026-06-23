/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
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
/*    */ class null
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 29 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int x1, int y1, AREA a, PLACER_TYPE t) {
/* 33 */     PlacerItemArea.this.removeItem(x1, y1);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 38 */     if (!PlacerItemArea.this.area.is(tx, ty) || !(SETT.ROOMS()).fData.item.is(tx, ty)) {
/* 39 */       return PlacableMessages.¤¤ITEM_MUST;
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 46 */     if (!PlacerItemArea.this.area.is(fromX, fromY) || !PlacerItemArea.this.area.is(toX, toY))
/* 47 */       return false; 
/* 48 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(fromX, fromY);
/* 49 */     FurnisherItem it2 = (FurnisherItem)(SETT.ROOMS()).fData.item.get(toX, toY);
/* 50 */     if (it != null && it2 != null) {
/* 51 */       COORDINATE c = (SETT.ROOMS()).fData.itemMaster(fromX, fromY, Coo.TMP);
/* 52 */       int x = c.x();
/* 53 */       int y = c.y();
/* 54 */       return (SETT.ROOMS()).fData.itemMaster(toX, toY, Coo.TMP).isSameAs(x, y);
/*    */     } 
/* 56 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerItemArea$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */