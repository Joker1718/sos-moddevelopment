/*    */ package util.data;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.map.MAP_CLEARER;
/*    */ import snake2d.util.map.MAP_SETTER;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ 
/*    */ 
/*    */ public class AreaTmp
/*    */   implements AREA, MAP_SETTER, MAP_CLEARER
/*    */ {
/* 15 */   private final Bitmap1D data = new Bitmap1D(SETT.TAREA, false);
/* 16 */   private final Rec body = new Rec();
/*    */ 
/*    */ 
/*    */   
/*    */   private int area;
/*    */ 
/*    */ 
/*    */   
/*    */   public RECTANGLE body() {
/* 25 */     return (RECTANGLE)this.body;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 30 */     return this.data.get(tile);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 35 */     if (SETT.IN_BOUNDS(tx, ty))
/* 36 */       return this.data.get(tx + ty * SETT.TWIDTH); 
/* 37 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int area() {
/* 42 */     return this.area;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 46 */     if (this.area > 0)
/* 47 */       this.data.clear(); 
/* 48 */     this.area = 0;
/* 49 */     this.body.setDim(0.0D, 0.0D).moveX1Y1(-1.0D, -1.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MAP_SETTER set(int tile) {
/* 55 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_SETTER set(int tx, int ty) {
/* 60 */     if (SETT.IN_BOUNDS(tx, ty)) {
/* 61 */       if (this.area == 0) {
/* 62 */         this.body.setDim(1.0D).moveX1Y1(tx, ty);
/*    */       } else {
/* 64 */         this.body.unify(tx, ty);
/*    */       } 
/* 66 */       this.area++;
/* 67 */       this.data.set(tx + ty * SETT.TWIDTH, true);
/*    */     } 
/* 69 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_CLEARER clear(int tile) {
/* 74 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_CLEARER clear(int tx, int ty) {
/* 79 */     if (SETT.IN_BOUNDS(tx, ty)) {
/* 80 */       int i = tx + ty * SETT.TWIDTH;
/* 81 */       if (this.data.get(i)) {
/* 82 */         this.area--;
/* 83 */         this.data.set(tx + ty * SETT.TWIDTH, false);
/*    */       } 
/*    */     } 
/* 86 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\AreaTmp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */