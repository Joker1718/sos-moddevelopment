/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.pointlight.LOS;
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
/*     */   implements LOS
/*     */ {
/*     */   public boolean passesToOtherFromThis(int fx, int fy, int tx, int ty) {
/* 162 */     if ((SETT.ROOMS()).fData.tile.get(fx, fy) == ROOM_HOME.this.constructor.tOpening)
/* 163 */       return true; 
/* 164 */     return ((HomeInstance)ROOM_HOME.this.getter.get(fx, fy)).is(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 169 */     if ((SETT.ROOMS()).fData.tile.get(tx, ty) == ROOM_HOME.this.constructor.tOpening)
/* 170 */       return true; 
/* 171 */     return ((HomeInstance)ROOM_HOME.this.getter.get(tx, ty)).is(fx, fy);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean blocksEnv(int tx, int ty) {
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLightBlocker(int tx, int ty) {
/* 181 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\ROOM_HOME$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */