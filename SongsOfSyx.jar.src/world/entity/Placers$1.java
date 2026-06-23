/*    */ package world.entity;
/*    */ 
/*    */ import view.tool.PlacableSimpleTile;
/*    */ import world.WORLD;
/*    */ import world.entity.haven.WHaven;
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
/*    */   extends PlacableSimpleTile
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 37 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty) {
/* 41 */     for (WHaven h : (WORLD.ENTITIES()).havens.fillTile(tx, ty)) {
/* 42 */       h.delete();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 48 */     return ((WORLD.ENTITIES()).havens.fillTile(tx, ty).size() > 0) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\Placers$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */