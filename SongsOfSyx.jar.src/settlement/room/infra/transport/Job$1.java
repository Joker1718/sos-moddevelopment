/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements TILE_STORAGE
/*     */ {
/*     */   public int y() {
/*  87 */     return Job.this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  92 */     return Job.this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageUnreserve(int amount) {
/*  97 */     Job.this.remove();
/*  98 */     Job.this.bamountr.inc((ROOMA)Job.this.ins, -amount);
/*  99 */     Job.this.add();
/*     */   }
/*     */ 
/*     */   
/*     */   public int storageReserved() {
/* 104 */     return Job.this.bamountr.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageReserve(int amount) {
/* 109 */     Job.this.remove();
/* 110 */     Job.this.bamountr.inc((ROOMA)Job.this.ins, amount);
/* 111 */     Job.this.add();
/*     */   }
/*     */ 
/*     */   
/*     */   public int storageReservable() {
/* 116 */     if (Job.this.ins.data.resource() != null)
/* 117 */       return Job.this.bamountr.max() - Job.this.bamount.get() - Job.this.bamountr.get(); 
/* 118 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageDeposit(int amount) {
/* 123 */     Job.this.remove();
/* 124 */     Job.this.bamountr.inc((ROOMA)Job.this.ins, -amount);
/* 125 */     Job.this.add();
/* 126 */     Job.this.ins.data.needsPrep();
/* 127 */     if (Job.this.ins.data.stored() < 400) {
/* 128 */       int am = amount;
/* 129 */       am = CLAMP.i(am, 0, 400 - Job.this.ins.data.stored());
/* 130 */       Job.this.ins.data.store(am);
/* 131 */       amount -= am;
/*     */     } 
/*     */ 
/*     */     
/* 135 */     if (amount > 0) {
/* 136 */       Job.this.remove();
/* 137 */       Job.this.bamount.inc((ROOMA)Job.this.ins, amount);
/*     */       
/* 139 */       Job.this.add();
/*     */     } 
/* 141 */     Job.this.ins.go();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 146 */     return Job.this.ins.resource();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean storageIsFindable() {
/* 151 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */