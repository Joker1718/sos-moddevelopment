/*     */ package settlement.room.service.stage;
/*     */ 
/*     */ import settlement.misc.util.FSERVICE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public void consume() {}
/*     */   
/*     */   public int x() {
/*  72 */     return Centre.this.ins.body().cX();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/*  77 */     return Centre.this.ins.body().cY();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  82 */     return (Centre.this.ins.services() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  87 */     if (!findableReservedCanBe()) {
/*  88 */       throw new RuntimeException();
/*     */     }
/*  90 */     Centre.this.ins.incServices(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/*  95 */     return Centre.this.ins.hasService();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 100 */     Centre.this.ins.incServices(1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\stage\Centre$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */