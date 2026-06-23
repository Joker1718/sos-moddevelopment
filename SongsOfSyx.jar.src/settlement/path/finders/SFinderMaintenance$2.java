/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements SFINDER
/*     */ {
/*     */   public boolean isInComponent(SComponent c, double distance) {
/* 112 */     return !(!(SETT.PATH()).comps.data.maintenanceRes.has(c, (RBIT)SFinderMaintenance.this.tbits) && 
/* 113 */       (SETT.PATH()).comps.data.maintenance.get(c) <= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canCross(SComponent c) {
/* 118 */     return RadiusChecker.self.is(c);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTile(int tx, int ty, int tileNr) {
/* 123 */     if ((SETT.MAINTENANCE()).reservable.is(tx, ty)) {
/* 124 */       RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(tx, ty);
/* 125 */       return !(res != null && !SFinderMaintenance.this.tbits.has(res));
/*     */     } 
/* 127 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderMaintenance$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */