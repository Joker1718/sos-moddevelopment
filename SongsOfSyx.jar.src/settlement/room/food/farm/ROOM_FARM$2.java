/*     */ package settlement.room.food.farm;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.water.RoomIrrigated;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RoomIrrigated
/*     */ {
/*     */   null(RoomIrrigated.ROOM_IRRIGATED $anonymous0, Boostable $anonymous1, double $anonymous2, double $anonymous3) {
/* 104 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */   
/*     */   public double needed(AREA area) {
/* 108 */     return area.area();
/*     */   }
/*     */ 
/*     */   
/*     */   protected double irrigation(RoomInstance ins) {
/* 113 */     return ((FarmInstance)ins).irri;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\ROOM_FARM$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */