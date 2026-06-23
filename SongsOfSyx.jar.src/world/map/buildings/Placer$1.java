/*    */ package world.map.buildings;
/*    */ 
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.subview.GameWindow;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ import world.WORLD;
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
/* 22 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 26 */     (WORLD.BUILDINGS()).village.set(tx, ty, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 31 */     return (WORLD.BUILDINGS()).village.is(tx, ty) ? null : E;
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateRegardless(GameWindow window, AREA selected) {
/* 36 */     (WORLD.BUILDINGS()).debugVisible = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\buildings\Placer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */