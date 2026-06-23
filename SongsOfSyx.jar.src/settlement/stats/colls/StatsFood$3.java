/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.HCLASS;
/*     */ import util.info.INFO;
/*     */ import util.race.PERMISSION;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements PERMISSION
/*     */ {
/*     */   public void set(HCLASS cl, Race race, boolean value) {
/* 177 */     if (race == null) {
/* 178 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 179 */         set(cl, (Race)RACES.all().get(ri), value);
/*     */       }
/*     */       return;
/*     */     } 
/* 183 */     if (value) {
/* 184 */       (StatsFood.this.foodAllowed[cl.index()]).foodAllowed[race.index].or(res);
/*     */     } else {
/* 186 */       (StatsFood.this.foodAllowed[cl.index()]).foodAllowed[race.index].clear(res);
/*     */     } 
/*     */   }
/*     */   
/*     */   public INFO info() {
/* 191 */     return (INFO)res;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean get(HCLASS cl, Race race) {
/* 196 */     if (race == null) {
/* 197 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 198 */         if (get(cl, (Race)RACES.all().get(ri)))
/* 199 */           return true; 
/*     */       } 
/* 201 */       return false;
/*     */     } 
/* 203 */     return (StatsFood.this.foodAllowed[cl.index()]).foodAllowed[race.index].has(res);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsFood$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */