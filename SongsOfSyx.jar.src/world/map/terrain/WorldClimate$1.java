/*    */ package world.map.terrain;
/*    */ 
/*    */ import init.type.CLIMATE;
/*    */ import init.type.CLIMATES;
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
/*    */ class null
/*    */   implements MAP_OBJECTE<CLIMATE>
/*    */ {
/*    */   public CLIMATE get(int tile) {
/* 48 */     return (CLIMATE)CLIMATES.ALL().get(WorldClimate.this.map.get(tile));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CLIMATE get(int tx, int ty) {
/* 54 */     return get(tx + ty * WORLD.TWIDTH());
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int tile, CLIMATE object) {
/* 59 */     WorldClimate.this.map.set(tile, object.index());
/* 60 */     WORLD.changeTile(tile % WORLD.TWIDTH(), tile / WORLD.TWIDTH());
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int tx, int ty, CLIMATE object) {
/* 65 */     if (WORLD.IN_BOUNDS(tx, ty))
/* 66 */       set(tx + ty * WORLD.TWIDTH(), object); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldClimate$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */