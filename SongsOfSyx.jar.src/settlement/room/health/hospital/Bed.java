/*     */ package settlement.room.health.hospital;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.value.Lockable;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ final class Bed {
/*  19 */   private final Coo coo = new Coo();
/*     */   
/*     */   private HospitalInstance ins;
/*  22 */   private final RoomBits wreserved = new RoomBits((COORDINATE)this.coo, 1);
/*  23 */   private final RoomBits wres1 = new RoomBits((COORDINATE)this.coo, 14);
/*  24 */   private final RoomBits wres2 = new RoomBits((COORDINATE)this.coo, 112);
/*  25 */   private final RoomBits freeWork = new RoomBits((COORDINATE)this.coo, 128);
/*  26 */   private final RoomBits sstate = new RoomBits((COORDINATE)this.coo, 3840)
/*     */     {
/*     */       public void set(ROOMA r, int t)
/*     */       {
/*  30 */         Bed.this.ins.service().report(Bed.this.service, Bed.this.ins.blueprintI().service(), -1);
/*  31 */         super.set(r, t);
/*  32 */         Bed.this.ins.service().report(Bed.this.service, Bed.this.ins.blueprintI().service(), 1);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  37 */   private final int I_UNAVAILABLE = 0;
/*  38 */   private final int I_AVAILABLE = 1;
/*  39 */   private final int I_RESERVED = 2;
/*  40 */   private final int I_USED = 3;
/*     */   
/*  42 */   private static Bed self = new Bed();
/*     */   
/*     */   public static SETT_JOB job(int tx, int ty) {
/*  45 */     if (self.init(tx, ty))
/*  46 */       return self.job; 
/*  47 */     return null;
/*     */   }
/*     */   
/*     */   public static FSERVICE service(int tx, int ty) {
/*  51 */     if (self.init(tx, ty))
/*  52 */       return self.service; 
/*  53 */     return null;
/*     */   }
/*     */   public static boolean res1(int tx, int ty) {
/*  56 */     if (!self.init(tx, ty))
/*  57 */       return false; 
/*  58 */     return (self.wres1.get() > 0);
/*     */   }
/*     */   
/*     */   public static boolean res2(int tx, int ty) {
/*  62 */     if (!self.init(tx, ty))
/*  63 */       return false; 
/*  64 */     return (self.wres2.get() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void consume(int tx, int ty) {}
/*     */ 
/*     */   
/*     */   private boolean init(int tx, int ty) {
/*  72 */     this.ins = (HospitalInstance)b().get(tx, ty);
/*  73 */     if (this.ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  74 */       this.coo.set(tx, ty);
/*  75 */       return true;
/*     */     } 
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean made(int tx, int ty) {
/*  81 */     self.getClass(); return (self.init(tx, ty) && self.sstate.get() != 0);
/*     */   }
/*     */   
/*     */   public static boolean resource(int tx, int ty) {
/*  85 */     self.getClass(); return (self.init(tx, ty) && self.wres1.get() > 0 && self.sstate.get() != 3);
/*     */   }
/*     */   
/*     */   private static ROOM_HOSPITAL b() {
/*  89 */     return (SETT.ROOMS()).HOSPITAL;
/*     */   }
/*     */   
/*  92 */   private final SETT_JOB job = new SETT_JOB()
/*     */     {
/*  94 */       private final int wt = 30;
/*  95 */       private final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */ 
/*     */       
/*     */       public boolean jobUseTool() {
/*  99 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean jobUseHands() {
/* 104 */         return (Bed.this.sstate.get() == 0);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */       
/*     */       public SoundRace jobSound() {
/* 114 */         return Bed.b().employment().sound();
/*     */       }
/*     */ 
/*     */       
/*     */       public RBIT jobResourceBitToFetch() {
/* 119 */         this.bits.clear();
/* 120 */         if (Bed.this.sstate.get() == 0)
/* 121 */           return null; 
/* 122 */         if (Bed.this.wres1.get() == 0 && Bed.this.ins.fetch[0] && ((Lockable)(Bed.b()).resLocks.get(0)).passes(FACTIONS.player()))
/* 123 */           this.bits.or(((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(0)).resource); 
/* 124 */         if (Bed.this.wres2.get() == 0 && Bed.this.ins.fetch[1] && ((Lockable)(Bed.b()).resLocks.get(1)).passes(FACTIONS.player()))
/* 125 */           this.bits.or(((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(1)).resource); 
/* 126 */         return this.bits.isClear() ? null : (RBIT)this.bits;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean jobReservedIs(RESOURCE r) {
/* 131 */         return (Bed.this.wreserved.get() == 1);
/*     */       }
/*     */ 
/*     */       
/*     */       public void jobReserveCancel(RESOURCE r) {
/* 136 */         Bed.this.wreserved.set((ROOMA)Bed.this.ins, 0);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean jobReserveCanBe() {
/* 141 */         if (Bed.this.wreserved.get() == 1)
/* 142 */           return false; 
/* 143 */         if (Bed.this.sstate.get() == 0)
/* 144 */           return true; 
/* 145 */         if (Bed.this.wres1.get() == 0 && Bed.this.ins.fetch[0] && ((Lockable)(Bed.b()).resLocks.get(0)).passes(FACTIONS.player()))
/* 146 */           return true; 
/* 147 */         if (Bed.this.wres2.get() == 0 && Bed.this.ins.fetch[1] && ((Lockable)(Bed.b()).resLocks.get(1)).passes(FACTIONS.player()))
/* 148 */           return true; 
/* 149 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void jobReserve(RESOURCE r) {
/* 155 */         Bed.this.wreserved.set((ROOMA)Bed.this.ins, 1);
/*     */       }
/*     */ 
/*     */       
/*     */       public double jobPerformTime(Humanoid a) {
/* 160 */         return ((Bed.this.freeWork.get() == 1) ? true : 30);
/*     */       }
/*     */ 
/*     */       
/*     */       public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 165 */         jobReserveCancel(r);
/* 166 */         if (r == ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(0)).resource) {
/* 167 */           ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(0)).inc((ROOM_IDATA_INSTANCE)Bed.this.ins, rAm);
/* 168 */           Bed.this.wres1.inc((ROOMA)Bed.this.ins, rAm);
/* 169 */         } else if (r == ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(1)).resource) {
/* 170 */           ((IndustryResource)((Industry)(Bed.b()).indus.get(0)).ins().get(1)).inc((ROOM_IDATA_INSTANCE)Bed.this.ins, rAm);
/* 171 */           Bed.this.wres2.inc((ROOMA)Bed.this.ins, rAm);
/*     */         }
/* 173 */         else if (Bed.this.sstate.get() == 0) {
/* 174 */           Bed.this.sstate.set((ROOMA)Bed.this.ins, 1);
/*     */         } 
/*     */         
/* 177 */         Bed.this.freeWork.set((ROOMA)Bed.this.ins, Bed.this.ins.employees().fetchBonusConsume(31) ? 1 : 0);
/* 178 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence jobName() {
/* 183 */         return (Bed.b().employment()).verb;
/*     */       }
/*     */ 
/*     */       
/*     */       public COORDINATE jobCoo() {
/* 188 */         return (COORDINATE)Bed.this.coo;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 194 */   public final FSERVICE service = new FSERVICE()
/*     */     {
/*     */       public int y()
/*     */       {
/* 198 */         return Bed.this.coo.y();
/*     */       }
/*     */ 
/*     */       
/*     */       public int x() {
/* 203 */         return Bed.this.coo.x();
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean findableReservedIs() {
/* 208 */         return !(Bed.this.sstate.get() != 2 && Bed.this.sstate.get() != 3);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean findableReservedCanBe() {
/* 213 */         return (Bed.this.sstate.get() == 1);
/*     */       }
/*     */ 
/*     */       
/*     */       public void findableReserveCancel() {
/* 218 */         Bed.this.sstate.set((ROOMA)Bed.this.ins, 1);
/*     */       }
/*     */ 
/*     */       
/*     */       public void findableReserve() {
/* 223 */         if (findableReservedCanBe()) {
/* 224 */           Bed.this.sstate.set((ROOMA)Bed.this.ins, 2);
/*     */         }
/*     */       }
/*     */       
/*     */       public void startUsing() {
/* 229 */         Bed.this.sstate.set((ROOMA)Bed.this.ins, 3);
/*     */       }
/*     */ 
/*     */       
/*     */       public void consume() {
/* 234 */         Bed.this.wres1.inc((ROOMA)Bed.this.ins, -1);
/* 235 */         Bed.this.wres2.inc((ROOMA)Bed.this.ins, -1);
/* 236 */         Bed.this.sstate.set((ROOMA)Bed.this.ins, 0);
/* 237 */         Bed.this.ins.jobs.searchAgain();
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Bed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */