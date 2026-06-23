/*     */ package settlement.room.service.food.eatery;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.work.AIModule_Work;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import settlement.room.main.util.RoomTally;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Crate
/*     */ {
/* 422 */   private final Coo coo = new Coo();
/*     */   private RoomInstance ins;
/*     */   private RoomDistribution.RoomDistributionIns data;
/* 425 */   private final RoomBits serviceReserved = new BB(new Bits(1));
/* 426 */   private final RoomBits serviceReservable = new RoomBits((COORDINATE)this.coo, new Bits(2));
/* 427 */   private final RoomBits freeWork = new RoomBits((COORDINATE)this.coo, new Bits(4));
/* 428 */   private final RoomBits workReserved = new RoomBits((COORDINATE)this.coo, new Bits(8));
/* 429 */   private final RoomBits serviceUsed = new RoomBits((COORDINATE)this.coo, new Bits(240));
/* 430 */   private final RoomBits workAmount = new BB(new Bits(65280));
/*     */   
/*     */   private SETT_JOB workCook;
/*     */   
/*     */   private final SETT_JOB workRes;
/*     */   private final FSERVICE service;
/*     */   
/*     */   Crate() {
/* 438 */     this.workCook = new SETT_JOB()
/*     */       {
/* 440 */         private final int wt = 30;
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 444 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 454 */           return (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 459 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public int jobResourcesNeeded(Humanoid skill) {
/* 464 */           return (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 469 */           return (RoomDistribution.Crate.this.workReserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 474 */           RoomDistribution.Crate.this.workReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 479 */           return (RoomDistribution.Crate.this.workReserved.get() == 0 && RoomDistribution.Crate.this.workAmount.get() <= (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations * 8 && (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tStored.get(RoomDistribution.Crate.this.ins) - (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.get(RoomDistribution.Crate.this.ins) > (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 486 */           RoomDistribution.Crate.this.workReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 491 */           return ((RoomDistribution.Crate.this.freeWork.get() == 1) ? true : 30);
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 496 */           RoomDistribution.Crate.this.workReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/* 497 */           RoomDistribution.Crate.this.workAmount.inc((ROOMA)RoomDistribution.Crate.this.ins, 1);
/* 498 */           if (RoomDistribution.Crate.this.ins.employees().fetchBonusConsume(31)) {
/* 499 */             RoomDistribution.Crate.this.freeWork.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*     */           } else {
/* 501 */             RoomDistribution.Crate.this.freeWork.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*     */           } 
/* 503 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 508 */           return ((RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 513 */           return (COORDINATE)RoomDistribution.Crate.this.coo;
/*     */         }
/*     */       };
/*     */     
/* 517 */     this.workRes = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/* 521 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 531 */           return (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 536 */           return (RBIT)(RoomDistribution.Crate.this.data.distributionData()).fetchMask;
/*     */         }
/*     */ 
/*     */         
/*     */         public int jobResourcesNeeded(Humanoid skill) {
/* 541 */           return (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 546 */           if (r == null) {
/* 547 */             return false;
/*     */           }
/* 549 */           int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/* 550 */           if (ri < 0) {
/* 551 */             return false;
/*     */           }
/*     */           
/* 554 */           return (((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).get(RoomDistribution.Crate.this.ins) > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 559 */           if (r == null)
/*     */             return; 
/* 561 */           int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/* 562 */           if (ri < 0)
/*     */             return; 
/* 564 */           if (((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).get(RoomDistribution.Crate.this.ins) >= AIModule_Work.MAX_FETCH_AMOUNT)
/* 565 */             ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).inc(RoomDistribution.Crate.this.ins, -AIModule_Work.MAX_FETCH_AMOUNT); 
/* 566 */           RoomDistribution.Crate.access$0(RoomDistribution.Crate.this).setMask(r, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.data.distributionData(), (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.ins);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 571 */           return !(RoomDistribution.Crate.this.data.distributionData()).fetchMask.isClear();
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 576 */           int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/* 577 */           ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).inc(RoomDistribution.Crate.this.ins, AIModule_Work.MAX_FETCH_AMOUNT);
/* 578 */           RoomDistribution.Crate.access$0(RoomDistribution.Crate.this).setMask(r, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.data.distributionData(), (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.ins);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 583 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 588 */           int ri = (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).resourceIs[r.index()];
/* 589 */           if (ri >= 0 && ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).get(RoomDistribution.Crate.this.ins) > 0) {
/* 590 */             ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allIncoming.get(ri)).inc(RoomDistribution.Crate.this.ins, -AIModule_Work.MAX_FETCH_AMOUNT);
/* 591 */             ((RoomTally.TallyEntry)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).allStored.get(ri)).inc(RoomDistribution.Crate.this.ins, ram);
/* 592 */             RoomDistribution.Crate.this.workAmount.set((ROOMA)RoomDistribution.Crate.this.ins, RoomDistribution.Crate.this.workAmount.get());
/* 593 */             RoomDistribution.Crate.access$0(RoomDistribution.Crate.this).setMask(r, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.data.distributionData(), (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).crate.ins);
/*     */           } 
/* 595 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 600 */           return ((RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).blue.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 605 */           return (COORDINATE)RoomDistribution.Crate.this.coo;
/*     */         }
/*     */       };
/*     */     
/* 609 */     this.service = new FSERVICE()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe()
/*     */         {
/* 615 */           return (RoomDistribution.Crate.this.serviceReservable.get() == 1 && RoomDistribution.Crate.this.serviceReserved.get() == 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 620 */           RoomDistribution.Crate.this.serviceReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/* 625 */           return (RoomDistribution.Crate.this.serviceReserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 630 */           RoomDistribution.Crate.this.serviceReserved.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/* 631 */           RoomDistribution.Crate.this.serviceUsed.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void startUsing() {
/* 636 */           RoomDistribution.Crate.this.serviceUsed.inc((ROOMA)RoomDistribution.Crate.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/* 641 */           return RoomDistribution.Crate.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public int y() {
/* 646 */           return RoomDistribution.Crate.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public void consume() {
/* 651 */           findableReserveCancel();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private class BB
/*     */     extends RoomBits {
/*     */     public BB(Bits bits) {
/* 659 */       super((COORDINATE)RoomDistribution.Crate.this.coo, bits);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void remove() {
/* 665 */       if (RoomDistribution.Crate.this.serviceReservable.get() == 1) {
/* 666 */         (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.inc(RoomDistribution.Crate.this.ins, -(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations);
/* 667 */         if (RoomDistribution.Crate.this.serviceReserved.get() == 0) {
/* 668 */           RoomDistribution.Crate.this.data.service().report(RoomDistribution.Crate.this.service, (RoomService)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).ser.service(), -1);
/*     */         }
/*     */       } 
/*     */       
/* 672 */       super.remove();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void add() {
/* 677 */       RoomDistribution.Crate.this.serviceReservable.set((ROOMA)RoomDistribution.Crate.this.ins, 0);
/* 678 */       if (RoomDistribution.Crate.this.workAmount.get() >= 1 && (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tStored.get(RoomDistribution.Crate.this.ins) - (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.get(RoomDistribution.Crate.this.ins) >= (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations) {
/* 679 */         RoomDistribution.Crate.this.serviceReservable.set((ROOMA)RoomDistribution.Crate.this.ins, 1);
/* 680 */         (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).tReserved.inc(RoomDistribution.Crate.this.ins, (RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).maxRations);
/* 681 */         if (RoomDistribution.Crate.this.serviceReserved.get() == 0) {
/* 682 */           RoomDistribution.Crate.this.data.service().report(RoomDistribution.Crate.this.service, (RoomService)(RoomDistribution.Crate.access$0(RoomDistribution.Crate.this)).ser.service(), 1);
/*     */         }
/*     */       } 
/* 685 */       super.add();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\RoomDistribution$Crate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */