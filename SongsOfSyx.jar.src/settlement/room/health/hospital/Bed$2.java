/*     */ package settlement.room.health.hospital;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.value.Lockable;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements SETT_JOB
/*     */ {
/*  94 */   private final int wt = 30;
/*  95 */   private final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseHands() {
/* 104 */     return (Bed.this.sstate.get() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 114 */     return Bed.b().employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 119 */     this.bits.clear();
/* 120 */     if (Bed.this.sstate.get() == 0)
/* 121 */       return null; 
/* 122 */     if (Bed.this.wres1.get() == 0 && Bed.this.ins.fetch[0] && ((Lockable)(Bed.b()).resLocks.get(0)).passes(FACTIONS.player()))
/* 123 */       this.bits.or(((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(0)).resource); 
/* 124 */     if (Bed.this.wres2.get() == 0 && Bed.this.ins.fetch[1] && ((Lockable)(Bed.b()).resLocks.get(1)).passes(FACTIONS.player()))
/* 125 */       this.bits.or(((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(1)).resource); 
/* 126 */     return this.bits.isClear() ? null : (RBIT)this.bits;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 131 */     return (Bed.this.wreserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 136 */     Bed.this.wreserved.set((ROOMA)Bed.this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 141 */     if (Bed.this.wreserved.get() == 1)
/* 142 */       return false; 
/* 143 */     if (Bed.this.sstate.get() == 0)
/* 144 */       return true; 
/* 145 */     if (Bed.this.wres1.get() == 0 && Bed.this.ins.fetch[0] && ((Lockable)(Bed.b()).resLocks.get(0)).passes(FACTIONS.player()))
/* 146 */       return true; 
/* 147 */     if (Bed.this.wres2.get() == 0 && Bed.this.ins.fetch[1] && ((Lockable)(Bed.b()).resLocks.get(1)).passes(FACTIONS.player()))
/* 148 */       return true; 
/* 149 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 155 */     Bed.this.wreserved.set((ROOMA)Bed.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid a) {
/* 160 */     return ((Bed.this.freeWork.get() == 1) ? true : 30);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 165 */     jobReserveCancel(r);
/* 166 */     if (r == ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(0)).resource) {
/* 167 */       ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(0)).inc((ROOM_IDATA_INSTANCE)Bed.this.ins, rAm);
/* 168 */       Bed.this.wres1.inc((ROOMA)Bed.this.ins, rAm);
/* 169 */     } else if (r == ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(1)).resource) {
/* 170 */       ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(1)).inc((ROOM_IDATA_INSTANCE)Bed.this.ins, rAm);
/* 171 */       Bed.this.wres2.inc((ROOMA)Bed.this.ins, rAm);
/*     */     }
/* 173 */     else if (Bed.this.sstate.get() == 0) {
/* 174 */       Bed.this.sstate.set((ROOMA)Bed.this.ins, 1);
/*     */     } 
/*     */     
/* 177 */     Bed.this.freeWork.set((ROOMA)Bed.this.ins, Bed.this.ins.employees().fetchBonusConsume(31) ? 1 : 0);
/* 178 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 183 */     return (Bed.b().employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 188 */     return (COORDINATE)Bed.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Bed$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */