/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
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
/*     */ class null
/*     */   extends OTile.STATE
/*     */ {
/*     */   null(int $anonymous0) {
/* 146 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void work(Humanoid a, int skill) {
/* 151 */     if (b.time.isRipe() && OTile.this.bHarvested.get() == 0) {
/*     */ 
/*     */ 
/*     */       
/* 155 */       double sk = fruitAmount() * OTile.this.ins.skill() * b.AmountPerTile * ((IndustryResource)b.productionData.outs().get(0)).rate;
/* 156 */       int am = ((IndustryResource)b.productionData.outs().get(0)).inc((ROOM_IDATA_INSTANCE)OTile.this.ins, sk);
/* 157 */       if (am != 0) {
/* 158 */         OTile.this.ins.deposit(am);
/*     */       }
/*     */       
/* 161 */       OTile.this.bHarvested.set((ROOMA)OTile.this.ins, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void fail() {
/* 167 */     if (OTile.this.bDead.get() == OTile.this.bDead.max()) {
/* 168 */       OTile.this.setState(OTile.this.IDEAD);
/*     */     } else {
/* 170 */       OTile.this.bDead.inc((ROOMA)OTile.this.ins, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update() {
/* 175 */     if (b.time.isDeadDay()) {
/* 176 */       OTile.this.bHarvested.set((ROOMA)OTile.this.ins, 0);
/*     */     }
/* 178 */     super.update();
/*     */   }
/*     */ 
/*     */   
/*     */   public double deadAmount() {
/* 183 */     return OTile.this.bDead.getD();
/*     */   }
/*     */ 
/*     */   
/*     */   public double fruitAmount() {
/* 188 */     if (OTile.this.bHarvested.get() == 1)
/* 189 */       return 0.0D; 
/* 190 */     return 1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\OTile$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */