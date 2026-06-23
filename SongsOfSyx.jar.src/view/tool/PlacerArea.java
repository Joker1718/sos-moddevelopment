/*    */ package view.tool;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.map.MAP_SETTER;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PlacerArea
/*    */   implements AREA
/*    */ {
/* 16 */   static PlacerArea self = new PlacerArea();
/*    */   
/* 18 */   private final Bitmap1D map = new Bitmap1D(SETT.TAREA, false);
/* 19 */   private final Rec bounds = new Rec();
/* 20 */   private int area = 0;
/*    */ 
/*    */   
/*    */   final MAP_SETTER set;
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 28 */     return this.map.get(tile);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 34 */     if (SETT.IN_BOUNDS(tx, ty))
/* 35 */       return is(tx + ty * SETT.TWIDTH); 
/* 36 */     return false;
/*    */   }
/*    */   private PlacerArea() {
/* 39 */     this.set = new MAP_SETTER()
/*    */       {
/*    */         public MAP_SETTER set(int tx, int ty)
/*    */         {
/* 43 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 44 */             PlacerArea.this.bounds.unify(tx, ty);
/* 45 */             int i = tx + ty * SETT.TWIDTH;
/* 46 */             if (!PlacerArea.this.map.get(i)) {
/* 47 */               PlacerArea.this.area++;
/* 48 */               PlacerArea.this.map.set(i, true);
/*    */             } 
/*    */           } 
/*    */           
/* 52 */           return this;
/*    */         }
/*    */ 
/*    */         
/*    */         public MAP_SETTER set(int tile) {
/* 57 */           throw new RuntimeException();
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   void clear() {
/* 63 */     if (this.area > 0) {
/*    */ 
/*    */       
/* 66 */       for (COORDINATE c : this.bounds) {
/* 67 */         this.map.set(c.x() + c.y() * SETT.TWIDTH, false);
/*    */       }
/* 69 */       this.bounds.set(SETT.TWIDTH, 0.0D, SETT.THEIGHT, 0.0D);
/* 70 */       this.area = 0;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public RECTANGLE body() {
/* 76 */     return (RECTANGLE)this.bounds;
/*    */   }
/*    */ 
/*    */   
/*    */   public int area() {
/* 81 */     return this.area;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacerArea.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */