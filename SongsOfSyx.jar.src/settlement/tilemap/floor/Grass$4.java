/*    */ package settlement.tilemap.floor;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import view.tool.PLACABLE;
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
/* 67 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 71 */     Grass.this.data.set(tx + ty * SETT.TWIDTH, CLAMP.i(Grass.this.data.get(tx + ty * SETT.TWIDTH) + 1, 0, 15));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 77 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 82 */     return (PLACABLE)ppu;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\Grass$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */