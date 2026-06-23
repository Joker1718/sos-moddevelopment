/*     */ package settlement.room.service.pleasure;
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
/*     */ class null
/*     */   implements FSERVICE
/*     */ {
/*     */   public void consume() {
/*  94 */     if (ABed.this.state.get() != 2)
/*  95 */       throw new RuntimeException(); 
/*  96 */     if (ABed.this.worked.get() == 1 || ABed.this.workedHasBeen.get() == 1) {
/*  97 */       ABed.this.state.set((ROOMA)ABed.this.ins, 1);
/*  98 */       ABed.this.workedHasBeen.set((ROOMA)ABed.this.ins, 0);
/*     */     } else {
/* 100 */       ABed.this.state.set((ROOMA)ABed.this.ins, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int x() {
/* 105 */     return ABed.this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 110 */     return ABed.this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 115 */     return (ABed.this.state.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 120 */     if (ABed.this.state.get() != 1)
/* 121 */       throw new RuntimeException(); 
/* 122 */     ABed.this.state.set((ROOMA)ABed.this.ins, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 128 */     return (ABed.this.state.get() == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startUsing() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 138 */     if (ABed.this.state.get() == 2)
/* 139 */       ABed.this.state.set((ROOMA)ABed.this.ins, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\ABed$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */