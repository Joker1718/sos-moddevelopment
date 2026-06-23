/*     */ package settlement.room.service.nursery;
/*     */ 
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements FSERVICE
/*     */ {
/*     */   public int y() {
/* 152 */     return NurseryStation.this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 157 */     return NurseryStation.this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 162 */     return (NurseryStation.this.bServiceReserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 167 */     return (NurseryStation.this.bServiceReserved.get() == 0 && NurseryStation.this.bWorked.get() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 172 */     NurseryStation.this.bServiceReserved.set((ROOMA)NurseryStation.this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 177 */     if (findableReservedCanBe()) {
/* 178 */       NurseryStation.this.bServiceReserved.set((ROOMA)NurseryStation.this.ins, 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void startUsing() {
/* 183 */     NurseryStation.this.bWorked.inc((ROOMA)NurseryStation.this.ins, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 188 */     NurseryStation.this.bServiceReserved.set((ROOMA)NurseryStation.this.ins, 0);
/*     */     
/* 190 */     NurseryStation.this.ins.getWork().searchAgain();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\NurseryStation$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */