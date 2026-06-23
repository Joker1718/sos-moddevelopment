/*     */ package settlement.room.infra.inn;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ABed
/*     */ {
/*     */   private static final int UNMADE = 0;
/*     */   private static final int AVAILABLE = 1;
/*     */   private static final int RESERVED = 2;
/*     */   private static final int WORK_RESERVED = 3;
/*  25 */   private final Coo coo = new Coo();
/*  26 */   private final RoomBits claimed = new RoomBits((COORDINATE)this.coo, 256);
/*  27 */   private final RoomBits work = new RoomBits((COORDINATE)this.coo, 240);
/*  28 */   private final RoomBits state = new RoomBits((COORDINATE)this.coo, 15)
/*     */     {
/*     */       public void set(ROOMA r, int t)
/*     */       {
/*  32 */         if (ABed.this.state.get() == 1) {
/*  33 */           ABed.this.ins.service.report(ABed.this.service, ABed.this.blue.service, -1);
/*     */         }
/*  35 */         super.set(r, t);
/*  36 */         if (ABed.this.state.get() == 1)
/*  37 */           ABed.this.ins.service.report(ABed.this.service, ABed.this.blue.service, 1); 
/*  38 */         ABed.this.claimed.set((ROOMA)ABed.this.ins, 0);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private InnInstance ins;
/*     */   private final ROOM_INN blue;
/*     */   public final FSERVICE service;
/*     */   final SETT_JOB job;
/*     */   
/*     */   public ABed init(int tx, int ty) {
/*  49 */     if (this.blue.is(tx, ty) && 
/*  50 */       (SETT.ROOMS()).fData.tileData.is(tx, ty, 2)) {
/*  51 */       this.coo.set(tx, ty);
/*  52 */       this.ins = (InnInstance)this.blue.get(tx, ty);
/*  53 */       return this;
/*     */     } 
/*     */     
/*  56 */     return null;
/*     */   }
/*     */   
/*     */   static boolean isUnmade(int tx, int ty) {
/*  60 */     int s = (SETT.ROOMS()).data.get(tx, ty) & 0xF;
/*  61 */     return !(s != 0 && s != 3);
/*     */   }
/*     */   
/*     */   static boolean isClaimed(int tx, int ty) {
/*  65 */     int s = (SETT.ROOMS()).data.get(tx, ty) & 0x100;
/*  66 */     return (s != 0);
/*     */   }
/*     */   
/*     */   public static DIR sleepDir(int tx, int ty) {
/*  70 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  71 */       DIR d = (DIR)DIR.ORTHO.get(i);
/*  72 */       if ((SETT.ROOMS()).fData.tileData.is(tx, ty, 1))
/*  73 */         return d; 
/*     */     } 
/*  75 */     return DIR.C;
/*     */   }
/*     */   ABed(ROOM_INN blue) {
/*  78 */     this.service = new FSERVICE()
/*     */       {
/*     */         public void consume()
/*     */         {
/*  82 */           if (ABed.this.state.get() != 2)
/*  83 */             throw new RuntimeException(); 
/*  84 */           ABed.this.state.set((ROOMA)ABed.this.ins, 0);
/*  85 */           ABed.this.work.set((ROOMA)ABed.this.ins, 0);
/*  86 */           ABed.this.ins.jobs.searchAgain();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/*  91 */           return ABed.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public int y() {
/*  96 */           return ABed.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/* 101 */           return (ABed.this.state.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 106 */           if (ABed.this.state.get() != 1)
/* 107 */             throw new RuntimeException(); 
/* 108 */           ABed.this.state.set((ROOMA)ABed.this.ins, 2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/* 114 */           return (ABed.this.state.get() == 2);
/*     */         }
/*     */ 
/*     */         
/*     */         public void startUsing() {
/* 119 */           ABed.this.claimed.set((ROOMA)ABed.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 124 */           if (ABed.this.state.get() == 2) {
/* 125 */             ABed.this.state.set((ROOMA)ABed.this.ins, 1);
/*     */           }
/*     */         }
/*     */       };
/* 129 */     this.job = new SETT_JOB()
/*     */       {
/* 131 */         private int ws = (int)(TIME.workSeconds() / 10.0D);
/*     */         
/*     */         public boolean jobUseTool() {
/* 134 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 144 */           return ABed.this.ins.blueprintI().employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 149 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 154 */           return (ABed.this.state.get() == 3);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 159 */           if (jobReservedIs(r)) {
/* 160 */             ABed.this.state.set((ROOMA)ABed.this.ins, 0);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 166 */           return (ABed.this.state.get() == 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 171 */           if (!jobReserveCanBe()) {
/* 172 */             throw new RuntimeException();
/*     */           }
/* 174 */           ABed.this.state.set((ROOMA)ABed.this.ins, 3);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 180 */           return this.ws;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 186 */           if (!jobReservedIs(r))
/* 187 */             throw new RuntimeException(); 
/* 188 */           ABed.this.work.inc((ROOMA)ABed.this.ins, 1);
/* 189 */           if (ABed.this.work.get() == 8) {
/* 190 */             ABed.this.state.set((ROOMA)ABed.this.ins, 1);
/*     */           } else {
/* 192 */             ABed.this.state.set((ROOMA)ABed.this.ins, 0);
/*     */           } 
/* 194 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 199 */           return (ABed.this.blue.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 204 */           return (COORDINATE)ABed.this.coo;
/*     */         }
/*     */       };
/*     */     this.blue = blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\ABed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */