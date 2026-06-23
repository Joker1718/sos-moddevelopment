/*    */ package world.map.terrain;
/*    */ 
/*    */ import snake2d.util.map.MAP_DOUBLEE;
/*    */ import snake2d.util.misc.CLAMP;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements MAP_DOUBLEE
/*    */ {
/*    */   public double get(int tx, int ty) {
/* 76 */     if (WORLD.IN_BOUNDS(tx, ty))
/* 77 */       return get(tx + ty * WORLD.TWIDTH()); 
/* 78 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(int tile) {
/* 83 */     return (WorldClimate.this.offmap.get(tile) - 3);
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 88 */     if (WORLD.IN_BOUNDS(tx, ty))
/* 89 */       return set(tx + ty * WORLD.TWIDTH(), value); 
/* 90 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_DOUBLEE set(int tile, double value) {
/* 95 */     int v = (int)(value * 4.0D);
/* 96 */     v = CLAMP.i(v, -3, 4);
/* 97 */     v += 3;
/* 98 */     WorldClimate.this.offmap.set(tile, v);
/* 99 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldClimate$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */