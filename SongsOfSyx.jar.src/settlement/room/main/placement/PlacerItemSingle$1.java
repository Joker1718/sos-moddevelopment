/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import view.tool.PLACER_TYPE;
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
/* 50 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 54 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 55 */     if (r != null && r.constructor() == PlacerItemSingle.this.blueprint.constructor()) {
/* 56 */       r.remove(tx, ty, true, this, false).clear();
/*    */     }
/*    */   }
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 61 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 62 */     if (r != null && r.constructor() == PlacerItemSingle.this.blueprint.constructor())
/* 63 */       return null; 
/* 64 */     return E;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 69 */     Room r = (SETT.ROOMS()).map.get(fromX, fromY);
/* 70 */     if (r != null && r.constructor() == PlacerItemSingle.this.blueprint.constructor() && r.isSame(fromX, fromY, toX, toY))
/* 71 */       return true; 
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerItemSingle$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */