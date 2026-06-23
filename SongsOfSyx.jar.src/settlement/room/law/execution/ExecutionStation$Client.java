/*     */ package settlement.room.law.execution;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Client
/*     */ {
/*     */   public boolean clientReserved() {
/* 181 */     return (ExecutionStation.this.bState.get() >= 2);
/*     */   }
/*     */   
/*     */   public boolean clientPresent() {
/* 185 */     return (ExecutionStation.this.bState.get() > 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clientUse() {
/* 190 */     ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 3);
/*     */   }
/*     */   
/*     */   public void clientCancel() {
/* 194 */     if ((SETT.THINGS()).corpses.tGet.get((COORDINATE)ExecutionStation.this.coo) != null) {
/* 195 */       ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 5);
/*     */     } else {
/* 197 */       ExecutionStation.this.bState.set(ExecutionStation.this.aa.area(), 1);
/*     */     } 
/*     */   }
/*     */   public boolean clientBeingExecuted() {
/* 201 */     return (ExecutionStation.this.bState.get() == 4);
/*     */   }
/*     */   
/*     */   public DIR clientDir() {
/* 205 */     return (DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)ExecutionStation.this.coo)).rotation);
/*     */   }
/*     */   
/*     */   public COORDINATE coo() {
/* 209 */     return (COORDINATE)ExecutionStation.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\ExecutionStation$Client.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */