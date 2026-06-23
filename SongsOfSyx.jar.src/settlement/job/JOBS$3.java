/*     */ package settlement.job;
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
/*     */ class null
/*     */   implements MAP_OBJECT<Job>
/*     */ {
/*     */   public Job get(int tx, int ty) {
/* 120 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/* 121 */       return null;
/*     */     }
/* 123 */     int i = JOBS.this.map.get(tx, ty);
/* 124 */     if (i != 0) {
/* 125 */       Job j = (Job)Job.all.get(i - 1);
/* 126 */       if (!j.get(tx, ty)) {
/* 127 */         PlacerDelete.place(tx, ty);
/* 128 */         return null;
/*     */       } 
/* 130 */       return j;
/*     */     } 
/*     */     
/* 133 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Job get(int tile) {
/* 138 */     return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 143 */     int i = JOBS.this.map.get(tile);
/* 144 */     return (i != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 149 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 150 */       return false; 
/* 151 */     return is(tx + ty * SETT.TWIDTH);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JOBS$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */