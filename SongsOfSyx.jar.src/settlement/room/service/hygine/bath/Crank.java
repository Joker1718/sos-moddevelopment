/*     */ package settlement.room.service.hygine.bath;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ public class Crank
/*     */   implements SETT_JOB
/*     */ {
/*  20 */   final int wt = 20;
/*     */   static final int BIT = 32768;
/*  22 */   private static final Crank self = new Crank();
/*     */   Bath bath;
/*  24 */   final Coo coo = new Coo();
/*     */   BathInstance ins;
/*  26 */   private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, new Bits(4096));
/*  27 */   private final RoomBits working = new RoomBits((COORDINATE)this.coo, new Bits(2048));
/*  28 */   private final RoomBits free = new RoomBits((COORDINATE)this.coo, new Bits(1024));
/*     */   static Crank init(int tx, int ty, ROOM_BATH b) {
/*  30 */     if (!b.is(tx, ty)) {
/*  31 */       return null;
/*     */     }
/*  33 */     BathInstance ins = (BathInstance)b.getter.get(tx, ty);
/*     */     
/*  35 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/*  36 */     if ((data & 0xE000) != 32768)
/*  37 */       return null; 
/*  38 */     for (DIR d : DIR.ORTHO) {
/*  39 */       if (ins.is(tx, ty, d) && ((SETT.ROOMS()).data.get(tx, ty, d) & 0xE000) == 49152) {
/*  40 */         self.bath = b.bath(tx + d.x(), ty + d.y());
/*  41 */         self.coo.set(tx, ty);
/*  42 */         self.ins = (BathInstance)b.get(tx, ty);
/*  43 */         return self;
/*     */       } 
/*     */     } 
/*  46 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   final String name = "pumping water";
/*     */ 
/*     */   
/*     */   public static boolean working(int data) {
/*  54 */     return (self.working.get(data) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/*  59 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/*  65 */     this.working.set((ROOMA)this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  70 */     return this.ins.blueprintI().employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  80 */     return (this.reserved.get() != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  85 */     this.working.set((ROOMA)this.ins, 0);
/*  86 */     this.reserved.set((ROOMA)this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  91 */     return (this.bath.availbilityNeeds() && !jobReservedIs(null));
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  96 */     if (jobReservedIs(null))
/*  97 */       throw new RuntimeException(); 
/*  98 */     this.reserved.set((ROOMA)this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 103 */     return ((this.free.get() == 1) ? true : 20);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 108 */     this.bath.availabilityInc();
/* 109 */     jobReserveCancel(null);
/* 110 */     if (this.ins.employees().fetchBonusConsume(21)) {
/* 111 */       this.free.set((ROOMA)this.ins, 1);
/*     */     } else {
/* 113 */       this.free.set((ROOMA)this.ins, 0);
/*     */     } 
/* 115 */     return null;
/*     */   }
/*     */   private Crank() {
/* 118 */     this.name = "pumping water";
/*     */   }
/*     */   
/*     */   public String jobName() {
/* 122 */     return "pumping water";
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 127 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\Crank.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */