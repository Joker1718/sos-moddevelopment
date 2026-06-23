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
/*     */ class null
/*     */   implements SFINDER
/*     */ {
/*     */   public boolean isInComponent(SComponent c, double distance) {
/*  94 */     return !(!(SETT.PATH()).comps.data.maintenanceRes.has(c, (RBIT)SFinderMaintenance.this.tbits) && 
/*  95 */       (SETT.PATH()).comps.data.maintenance.get(c) <= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTile(int tx, int ty, int tileNr) {
/* 100 */     if ((SETT.MAINTENANCE()).reservable.is(tx, ty)) {
/* 101 */       RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(tx, ty);
/* 102 */       return !(res != null && !SFinderMaintenance.this.tbits.has(res));
/*     */     } 
/* 104 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderMaintenance$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */