/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.map.MAP_OBJECT;
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
/*     */   implements MAP_OBJECT<HomeInstance>
/*     */ {
/*     */   public HomeInstance get(int tx, int ty) {
/* 125 */     if ((SETT.ROOMS()).map.blueprint.get(tx, ty) == ROOM_HOME.this) {
/* 126 */       return (HomeInstance)(SETT.ROOMS()).map.get(tx, ty);
/*     */     }
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public HomeInstance get(int tile) {
/* 133 */     if ((SETT.ROOMS()).map.blueprint.get(tile) == ROOM_HOME.this) {
/* 134 */       return (HomeInstance)(SETT.ROOMS()).map.get(tile);
/*     */     }
/* 136 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\ROOM_HOME$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */