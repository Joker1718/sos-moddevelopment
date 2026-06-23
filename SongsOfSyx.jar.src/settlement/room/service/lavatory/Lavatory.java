/*     */ package settlement.room.service.lavatory;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ public class Lavatory
/*     */   implements FSERVICE {
/*     */   static final int BIT = 32768;
/*     */   static final int BIT_WASH = 16384;
/*  24 */   static final Bits USAGE = new Bits(112);
/*     */   
/*     */   static final int S_USED = 1;
/*     */   static final int S_BEEING_CLEANED = 2;
/*     */   static final int S_RESERVABLE = 0;
/*     */   static final int S_RESERVED = 3;
/*     */   static final int S_UNUSABLE = 4;
/*  31 */   private static final Lavatory self = new Lavatory();
/*  32 */   private final Coo coo = new Coo();
/*     */   
/*     */   private LavatoryInstance ins;
/*     */   
/*     */   private int data;
/*     */   
/*     */   private ROOM_LAVATORY blue;
/*     */   final SETT_JOB job;
/*     */   
/*     */   static Lavatory get(int tx, int ty) {
/*  42 */     RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(tx, ty);
/*  43 */     if (p instanceof ROOM_LAVATORY) {
/*  44 */       int data = (SETT.ROOMS()).data.get(tx, ty);
/*  45 */       if ((data & 0x8000) != 0) {
/*  46 */         self.blue = (ROOM_LAVATORY)p;
/*  47 */         self.ins = (LavatoryInstance)self.blue.get(tx, ty);
/*  48 */         self.data = data;
/*  49 */         self.coo.set(tx, ty);
/*  50 */         return self;
/*     */       } 
/*     */     } 
/*  53 */     return null;
/*     */   }
/*     */   
/*     */   private void save() {
/*  57 */     int old = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*  58 */     if (old == this.data)
/*     */       return; 
/*  60 */     int current = this.data;
/*  61 */     this.data = old;
/*  62 */     this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, -1);
/*  63 */     this.data = current;
/*  64 */     this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, 1);
/*  65 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */   
/*     */   public static boolean isOpen(int data) {
/*  69 */     return (USAGE.get(data) < 4);
/*     */   }
/*     */   
/*     */   public void init(RoomServiceInstance ser) {
/*  73 */     ser.report(this, (RoomService)(this.ins.blueprintI()).data, 1);
/*     */   }
/*     */   
/*     */   private void stateSet(int state) {
/*  77 */     this.data &= 0xFFFFFFF0;
/*  78 */     this.data |= state;
/*     */   }
/*     */   
/*     */   private int state() {
/*  82 */     return this.data & 0xF;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/*  87 */     return (state() == 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  92 */     return (state() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/*  97 */     if (!findableReservedCanBe())
/*  98 */       throw new RuntimeException(); 
/*  99 */     stateSet(3);
/* 100 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 105 */     if (state() == 3) {
/* 106 */       stateSet(0);
/* 107 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 113 */     if (!findableReservedIs())
/* 114 */       throw new RuntimeException(); 
/* 115 */     this.data = USAGE.inc(this.data, 1);
/* 116 */     if (USAGE.get(this.data) >= 4) {
/* 117 */       stateSet(1);
/*     */     } else {
/* 119 */       stateSet(0);
/* 120 */     }  save();
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 124 */     stateSet(4);
/* 125 */     save();
/*     */   }
/*     */   
/*     */   public void fix() {
/* 129 */     stateSet(0);
/* 130 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 135 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 140 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public DIR getDir() {
/* 145 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)this.coo);
/* 146 */     if (it == null) {
/* 147 */       return DIR.N;
/*     */     }
/* 149 */     for (DIR d : DIR.ORTHO) {
/* 150 */       if (!(SETT.ROOMS()).fData.sprite.is((COORDINATE)this.coo, d) && (d.orthoID() == it.rotation || d.perpendicular().orthoID() == it.rotation))
/* 151 */         return d; 
/*     */     } 
/* 153 */     return DIR.N;
/*     */   }
/*     */   
/*     */   private Lavatory() {
/* 157 */     this.job = new SETT_JOB()
/*     */       {
/*     */         public void jobReserve(RESOURCE r)
/*     */         {
/* 161 */           if (!jobReserveCanBe())
/* 162 */             throw new RuntimeException(); 
/* 163 */           Lavatory.this.stateSet(2);
/* 164 */           Lavatory.this.save();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 169 */           return (Lavatory.this.state() == 2);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 174 */           if (Lavatory.this.state() == 2) {
/* 175 */             if (Lavatory.USAGE.get(Lavatory.this.data) < 4) {
/* 176 */               Lavatory.this.stateSet(0);
/*     */             } else {
/* 178 */               Lavatory.this.stateSet(1);
/* 179 */             }  Lavatory.this.save();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 185 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 190 */           return 45.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/* 195 */           if (!jobReservedIs(res))
/* 196 */             throw new RuntimeException(); 
/* 197 */           Lavatory.this.stateSet(0);
/* 198 */           Lavatory.this.data = Lavatory.USAGE.set(Lavatory.this.data, 0);
/* 199 */           Lavatory.this.save();
/* 200 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 205 */           return (COORDINATE)Lavatory.this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 210 */           return (Lavatory.this.blue.employment()).verb;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 221 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 226 */           return Lavatory.this.blue.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 231 */           return !(Lavatory.this.state() != 1 && (Lavatory.this.state() != 0 || Lavatory.USAGE.get(Lavatory.this.data) <= 2));
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\lavatory\Lavatory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */