/*     */ package settlement.room.law.police;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ public final class PoliceWork {
/*     */   private final ROOM_POLICE b;
/*     */   private PoliceInstance ins;
/*  28 */   private final Coo coo = new Coo();
/*     */   
/*  30 */   private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, new Bits(1));
/*  31 */   private final RoomBits used = new RoomBits((COORDINATE)this.coo, new Bits(2));
/*     */   
/*  33 */   private final RoomBits clientTime = new RoomBits((COORDINATE)this.coo, new Bits(240))
/*     */     {
/*     */       public void set(ROOMA r, int t)
/*     */       {
/*  37 */         if (get() > 0)
/*  38 */           PoliceWork.this.ins.prisoners--; 
/*  39 */         if (t == 0) {
/*  40 */           ENTITY e = SETT.ENTITIES().getAtTileSingle(PoliceWork.this.coo.x(), PoliceWork.this.coo.y());
/*  41 */           if (e != null && e instanceof Humanoid) {
/*  42 */             Humanoid h = (Humanoid)e;
/*  43 */             if (RND.oneIn(5))
/*  44 */               h.kill(false, CAUSE_LEAVES.PUNISHED()); 
/*  45 */             h.interrupt();
/*     */           } 
/*     */         } 
/*  48 */         super.set(r, t);
/*  49 */         if (get() > 0) {
/*  50 */           PoliceWork.this.ins.prisoners++;
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private Humanoid[] queue;
/*     */   private int hi;
/*     */   private final SETT_JOB job;
/*     */   
/*     */   private boolean init(int tx, int ty) {
/*  61 */     PoliceInstance ins = (PoliceInstance)(SETT.ROOMS()).POLICE.get(tx, ty);
/*  62 */     if (ins == null)
/*  63 */       return false; 
/*  64 */     int c = (SETT.ROOMS()).fData.tileData.get(tx, ty);
/*  65 */     if (c == 0)
/*  66 */       return false; 
/*  67 */     this.ins = ins;
/*  68 */     this.coo.set(tx, ty);
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public SETT_JOB job(int tx, int ty) {
/*  73 */     if (init(tx, ty))
/*  74 */       return this.job; 
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid clientToFetch(int tx, int ty) {
/*  80 */     if (!init(tx, ty))
/*  81 */       return null; 
/*  82 */     if (this.ins.prisoners >= this.ins.prisonersMax())
/*  83 */       return null; 
/*  84 */     if (this.clientTime.get() > 0)
/*  85 */       return null; 
/*  86 */     if (SETT.ENTITIES().hasAtTile(this.coo.x(), this.coo.y()))
/*  87 */       return null; 
/*  88 */     if (((SETT.ROOMS()).fData.tileData.get(tx, ty) & 0x3) != 3) {
/*  89 */       return null;
/*     */     }
/*  91 */     for (int i = 0; i < 10; ) {
/*  92 */       Humanoid h = pollVictim();
/*  93 */       if (!validVictim((ENTITY)h) || !this.b.access(h.indu().popCL()).is()) {
/*     */         i++; continue;
/*  95 */       }  return h;
/*     */     } 
/*     */     
/*  98 */     return null;
/*     */   }
/*     */   PoliceWork(ROOM_POLICE b) {
/* 101 */     this.queue = new Humanoid[256];
/* 102 */     this.hi = this.queue.length;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     this.job = new SETT_JOB()
/*     */       {
/*     */         public void jobReserve(RESOURCE r)
/*     */         {
/* 203 */           PoliceWork.this.reserved.set((ROOMA)PoliceWork.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 208 */           return (PoliceWork.this.reserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 213 */           PoliceWork.this.used.set((ROOMA)PoliceWork.this.ins, 0);
/* 214 */           PoliceWork.this.reserved.set((ROOMA)PoliceWork.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 219 */           return (PoliceWork.this.reserved.get() == 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 224 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid a) {
/* 229 */           return 45.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {
/* 234 */           PoliceWork.this.used.set((ROOMA)PoliceWork.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 239 */           jobReserveCancel(r);
/* 240 */           if (PoliceWork.this.clientTime.get() == 0) {
/*     */             
/* 242 */             ENTITY e = SETT.ENTITIES().getAtTileSingle(PoliceWork.this.coo.x(), PoliceWork.this.coo.y());
/* 243 */             if (e != null && e instanceof Humanoid) {
/* 244 */               Humanoid h = (Humanoid)e;
/* 245 */               h.interrupt();
/*     */             } 
/*     */           } 
/* 248 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 253 */           return (COORDINATE)PoliceWork.this.coo;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 258 */           return (PoliceWork.this.ins.blueprintI().employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 263 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/* 268 */           return ((PoliceWork.this.coo.x() + PoliceWork.this.coo.y() * SETT.TWIDTH + TIME.hours().bitsSinceStart() & 0x1) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 273 */           return PoliceWork.this.ins.blueprintI().employment().sound();
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */   
/*     */   private Humanoid pollVictim() {
/*     */     if (this.hi >= this.queue.length) {
/*     */       this.hi = 0;
/*     */       GUTIL.flooder().init(this);
/*     */       ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*     */       for (int i = 0; i < es.length; i++) {
/*     */         ENTITY e = es[i];
/*     */         if (validVictim(e))
/*     */           GUTIL.flooder().pushSmaller(i % SETT.TWIDTH, i / SETT.TWIDTH, RND.rFloat()); 
/*     */       } 
/*     */       this.hi = this.queue.length - 1;
/*     */       while (this.hi >= 0 && GUTIL.flooder().hasMore()) {
/*     */         PathTile t = GUTIL.flooder().pollSmallest();
/*     */         int j = t.x() + t.y() * SETT.TWIDTH;
/*     */         ENTITY e = es[j];
/*     */         this.queue[this.hi] = (Humanoid)e;
/*     */         this.hi--;
/*     */       } 
/*     */       this.hi++;
/*     */       GUTIL.flooder().done();
/*     */     } 
/*     */     return this.queue[this.hi++];
/*     */   }
/*     */   
/*     */   private boolean validVictim(ENTITY e) {
/*     */     if (e == null || !(e instanceof Humanoid))
/*     */       return false; 
/*     */     Humanoid h = (Humanoid)e;
/*     */     if (h.isRemoved())
/*     */       return false; 
/*     */     RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(h);
/*     */     if (ins != null && (ins.blueprintI() == (SETT.ROOMS()).GUARD || ins.blueprintI() == this.b))
/*     */       return false; 
/*     */     if (this.b.is(h.tc()))
/*     */       return false; 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public Humanoid client(int tx, int ty) {
/*     */     if (!init(tx, ty))
/*     */       return null; 
/*     */     if (((SETT.ROOMS()).fData.tileData.get(tx, ty) & 0x3) != 3)
/*     */       return null; 
/*     */     if (this.clientTime.get() == 0)
/*     */       return null; 
/*     */     ENTITY e = SETT.ENTITIES().getAtTileSingle(tx, ty);
/*     */     if (e == null)
/*     */       return null; 
/*     */     if (e instanceof Humanoid)
/*     */       return (Humanoid)e; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public boolean isLay(int tx, int ty) {
/*     */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 7);
/*     */   }
/*     */   
/*     */   public DIR victimDir(int tx, int ty) {
/*     */     FurnisherItem f = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*     */     if (f == null)
/*     */       return DIR.NE; 
/*     */     return (DIR)DIR.ORTHO.get(f.rotation);
/*     */   }
/*     */   
/*     */   public void deliverClient(int tx, int ty) {
/*     */     if (!init(tx, ty))
/*     */       return; 
/*     */     this.clientTime.set((ROOMA)this.ins, 2 + RND.rInt(2));
/*     */   }
/*     */   
/*     */   public void dispose(int tx, int ty) {
/*     */     if (!init(tx, ty))
/*     */       return; 
/*     */     this.clientTime.set((ROOMA)this.ins, 0);
/*     */   }
/*     */   
/*     */   public void update(int tx, int ty) {
/*     */     if (!init(tx, ty))
/*     */       return; 
/*     */     this.clientTime.inc((ROOMA)this.ins, -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\PoliceWork.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */