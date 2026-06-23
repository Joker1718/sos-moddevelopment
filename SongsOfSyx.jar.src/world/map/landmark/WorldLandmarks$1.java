/*    */ package world.map.landmark;
/*    */ 
/*    */ import snake2d.util.map.MAP_OBJECTE;
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
/*    */ class null
/*    */   implements MAP_OBJECTE<WorldLandmark>
/*    */ {
/*    */   public WorldLandmark get(int tile) {
/* 59 */     int i = WorldLandmarks.this.mapID.get(tile);
/* 60 */     return (WorldLandmark)WorldLandmarks.this.areas.get(i);
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldLandmark get(int tx, int ty) {
/* 65 */     if (WORLD.IN_BOUNDS(tx, ty))
/* 66 */       return get(tx + ty * WORLD.TWIDTH()); 
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int tile, WorldLandmark object) {
/* 72 */     if (object == null) {
/* 73 */       WorldLandmarks.this.mapID.set(tile, 0);
/*    */     } else {
/* 75 */       WorldLandmarks.this.mapID.set(tile, object.index());
/*    */     } 
/*    */   }
/*    */   
/*    */   public void set(int tx, int ty, WorldLandmark object) {
/* 80 */     if (WORLD.IN_BOUNDS(tx, ty))
/* 81 */       set(tx + ty * WORLD.TWIDTH(), object); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\WorldLandmarks$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */