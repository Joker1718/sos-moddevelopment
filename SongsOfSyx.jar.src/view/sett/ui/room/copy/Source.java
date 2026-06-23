/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.map.MAP_BOOLEANE;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ 
/*    */ final class Source
/*    */   implements MAP_BOOLEANE {
/* 11 */   private final Bitmap1D check = new Bitmap1D(SETT.TAREA, false);
/* 12 */   private final Rec rec = new Rec();
/*    */   
/*    */   public void init() {
/* 15 */     this.rec.clear();
/* 16 */     this.check.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 21 */     return this.check.get(tile);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 26 */     return is(tx + ty * SETT.TWIDTH);
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_BOOLEANE set(int tile, boolean value) {
/* 31 */     this.check.set(tile, value);
/* 32 */     this.rec.unify(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/* 33 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 38 */     if (SETT.IN_BOUNDS(tx, ty)) {
/* 39 */       set(tx + ty * SETT.TWIDTH, value);
/*    */     }
/*    */     
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public RECTANGLE area() {
/* 46 */     return (RECTANGLE)this.rec;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\Source.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */