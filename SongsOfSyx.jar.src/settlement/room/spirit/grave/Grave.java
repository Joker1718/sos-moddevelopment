/*     */ package settlement.room.spirit.grave;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Grave
/*     */ {
/*     */   static final int ITEM_MARK = 1;
/*     */   static final int DIG_MARK = 2;
/*  22 */   private static Bits id = new Bits(65535);
/*  23 */   private static Bits state = new Bits(983040);
/*  24 */   private static Bit reserved = new Bit(1048576);
/*  25 */   private static Bits time = new Bits(-16777216);
/*     */   
/*     */   private static final int UNUSED = 0;
/*     */   private static final int RESERVED = 2;
/*     */   private static final int USED = 3;
/*     */   private int data;
/*  31 */   private final Coo coo = new Coo();
/*     */   
/*     */   private GraveInstance ins;
/*     */   
/*     */   private final RoomBlueprintIns<GraveInstance> b;
/*     */   
/*     */   private final GraveData d;
/*     */   
/*     */   final FSERVICE service;
/*     */   private final GRAVE_JOB job;
/*     */   
/*     */   int daysTillDecompose(int tx, int ty) {
/*  43 */     if (get(tx, ty) != null) {
/*  44 */       return time.get(this.data);
/*     */     }
/*  46 */     return 0;
/*     */   }
/*     */   
/*     */   boolean init(int tx, int ty, int i) {
/*  50 */     if (this.b.is(tx, ty) && 
/*  51 */       (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  52 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, tx, ty, id.set(0, i));
/*  53 */       return true;
/*     */     } 
/*     */     
/*  56 */     return false;
/*     */   }
/*     */   
/*     */   Grave get(int tx, int ty) {
/*  60 */     if (this.b.is(tx, ty) && 
/*  61 */       (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  62 */       int data = (SETT.ROOMS()).data.get(tx, ty);
/*  63 */       this.data = data;
/*  64 */       this.coo.set(tx, ty);
/*  65 */       this.ins = (GraveInstance)this.b.get(tx, ty);
/*  66 */       return this;
/*     */     } 
/*     */     
/*  69 */     return null;
/*     */   }
/*     */   
/*     */   void updateDay2() {
/*  73 */     if (state.get(this.data) == 3) {
/*  74 */       this.data = time.inc(this.data, -1);
/*  75 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*  76 */       if (time.get(this.data) == 0) {
/*  77 */         GraveInfo.get(this.ins, id.get(this.data)).clear();
/*  78 */         this.data = state.set(this.data, 0);
/*  79 */         save();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   FSERVICE service(int tx, int ty) {
/*  86 */     Grave g = get(tx, ty);
/*  87 */     if (g != null)
/*  88 */       return g.service; 
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   GRAVE_JOB job(int tx, int ty) {
/*  93 */     Grave g = get(tx, ty);
/*  94 */     if (g != null)
/*  95 */       return g.job; 
/*  96 */     return null;
/*     */   }
/*     */   
/*     */   boolean isUsable() {
/* 100 */     return (state.get(this.data) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean isUsed(int tx, int ty) {
/* 105 */     int i = state.get((SETT.ROOMS()).data.get(tx, ty));
/* 106 */     return (i == 3);
/*     */   }
/*     */ 
/*     */   
/*     */   private void save() {
/* 111 */     int old = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*     */     
/* 113 */     if (old != this.data) {
/* 114 */       int current = this.data;
/* 115 */       this.data = old;
/* 116 */       if (this.service.findableReservedCanBe()) {
/* 117 */         (SETT.ROOMS()).graveServiceSpots.report((FINDABLE)this.service, -1);
/*     */       }
/* 119 */       if (state.get(this.data) == 0) {
/* 120 */         this.ins.count(-1);
/*     */       }
/*     */       
/* 123 */       this.data = current;
/* 124 */       if (this.service.findableReservedCanBe()) {
/* 125 */         (SETT.ROOMS()).graveServiceSpots.report((FINDABLE)this.service, 1);
/*     */       }
/* 127 */       if (state.get(this.data) == 0) {
/* 128 */         this.ins.count(1);
/*     */       }
/*     */ 
/*     */       
/* 132 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */     } 
/*     */   }
/*     */   Grave(RoomBlueprintIns<GraveInstance> b, GraveData d) {
/* 136 */     this.service = new FSERVICE()
/*     */       {
/*     */         public int x()
/*     */         {
/* 140 */           return Grave.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public int y() {
/* 145 */           return Grave.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/* 150 */           return (Grave.state.get(Grave.this.data) == 3 && !Grave.reserved.is(Grave.this.data));
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 155 */           if (!findableReservedCanBe())
/* 156 */             throw new RuntimeException(); 
/* 157 */           Grave.this.data = Grave.reserved.set(Grave.this.data);
/* 158 */           Grave.this.save();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/* 163 */           return Grave.reserved.is(Grave.this.data);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 168 */           Grave.this.data = Grave.reserved.clear(Grave.this.data);
/* 169 */           Grave.this.data = Grave.state.set(Grave.this.data, 3);
/* 170 */           Grave.this.save();
/*     */         }
/*     */ 
/*     */         
/*     */         public void consume() {
/* 175 */           Grave.this.data = Grave.reserved.clear(Grave.this.data);
/* 176 */           Grave.this.save();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 181 */     this.job = new GRAVE_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/* 185 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 196 */           return Grave.this.ins.blueprintI().employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 201 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 206 */           if (Grave.state.get(Grave.this.data) == 2) {
/* 207 */             return true;
/*     */           }
/* 209 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 214 */           if (jobReservedIs(r)) {
/* 215 */             Grave.this.data = Grave.state.set(Grave.this.data, 0);
/* 216 */             Grave.this.save();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 222 */           if (Grave.state.get(Grave.this.data) == 0) {
/* 223 */             return true;
/*     */           }
/* 225 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 230 */           Grave.this.data = Grave.state.set(Grave.this.data, 2);
/* 231 */           Grave.this.save();
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 236 */           return 10.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 241 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 246 */           return (COORDINATE)Grave.this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public void buryAndPerform(ThingsCorpses.Corpse c) {
/* 251 */           if (c != null) {
/* 252 */             Grave.this.d.get(c.indu().clas()).burry(c);
/* 253 */             GraveInfo.get(Grave.this.ins, Grave.id.get(Grave.this.data)).bury(c);
/* 254 */             c.remove();
/* 255 */             Grave.this.data = Grave.state.set(Grave.this.data, 3);
/* 256 */             Grave.this.data = Grave.time.set(Grave.this.data, Grave.this.d.composeTime);
/*     */           } else {
/* 258 */             Grave.this.data = Grave.state.set(Grave.this.data, 0);
/*     */           } 
/*     */           
/* 261 */           Grave.this.save();
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */     this.d = d;
/*     */   }
/*     */   
/*     */   public boolean reuse() {
/* 269 */     if (state.get(this.data) == 3) {
/* 270 */       this.data = state.set(this.data, 0);
/* 271 */       save();
/* 272 */       return true;
/*     */     } 
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   void dispose() {
/* 278 */     if (state.get(this.data) != 0) state.get(this.data);
/*     */ 
/*     */ 
/*     */     
/* 282 */     if (this.service.findableReservedCanBe()) {
/* 283 */       (SETT.ROOMS()).graveServiceSpots.report((FINDABLE)this.service, -1);
/*     */     }
/* 285 */     this.data = state.set(this.data, 0);
/* 286 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */   
/*     */   void deactivate() {
/* 290 */     if (state.get(this.data) != 0) state.get(this.data); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\Grave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */