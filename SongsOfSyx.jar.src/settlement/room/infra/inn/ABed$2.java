/*     */ package settlement.room.infra.inn;
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
/*     */ class null
/*     */   implements FSERVICE
/*     */ {
/*     */   public void consume() {
/*  82 */     if (ABed.this.state.get() != 2)
/*  83 */       throw new RuntimeException(); 
/*  84 */     ABed.this.state.set((ROOMA)ABed.this.ins, 0);
/*  85 */     ABed.this.work.set((ROOMA)ABed.this.ins, 0);
/*  86 */     ABed.this.ins.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  91 */     return ABed.this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  96 */     return ABed.this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 101 */     return (ABed.this.state.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 106 */     if (ABed.this.state.get() != 1)
/* 107 */       throw new RuntimeException(); 
/* 108 */     ABed.this.state.set((ROOMA)ABed.this.ins, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 114 */     return (ABed.this.state.get() == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startUsing() {
/* 119 */     ABed.this.claimed.set((ROOMA)ABed.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 124 */     if (ABed.this.state.get() == 2)
/* 125 */       ABed.this.state.set((ROOMA)ABed.this.ins, 1); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\ABed$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */