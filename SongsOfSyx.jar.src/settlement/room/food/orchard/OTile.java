/*     */ package settlement.room.food.orchard;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import view.sett.SettDebugClick;
/*     */ 
/*     */ final class OTile {
/*     */   private Instance ins;
/*  28 */   private Coo coo = new Coo();
/*  29 */   private Coo mCoo = new Coo();
/*     */   private final ROOM_ORCHARD b;
/*     */   public static final int WORK_TIME = 45;
/*     */   public static final int INOTHING = 0;
/*     */   public final STATE ISAPLING;
/*     */   public final STATE ISMALL;
/*     */   public final STATE IBIG;
/*     */   public final STATE IDEAD;
/*     */   private final STATE[] states;
/*     */   
/*  39 */   private final RoomBits bState = new RoomBits((COORDINATE)this.coo, new Bits(7))
/*     */     {
/*     */       public void set(int tx, int ty, ROOMA r, int t)
/*     */       {
/*  43 */         if (get() == OTile.this.IBIG.index) {
/*  44 */           OTile.this.ins.trees = (short)(OTile.this.ins.trees - 1);
/*     */         }
/*  46 */         super.set(tx, ty, r, t);
/*  47 */         if (t == OTile.this.IBIG.index) {
/*  48 */           OTile.this.ins.trees = (short)(OTile.this.ins.trees + 1);
/*     */         }
/*     */       }
/*     */     };
/*     */   
/*  53 */   private final RoomBits bHarvested = new RoomBits((COORDINATE)this.coo, new Bits(8));
/*  54 */   private final RoomBits bDead = new RoomBits((COORDINATE)this.mCoo, new Bits(48));
/*  55 */   private final RoomBits bProgress = new RoomBits((COORDINATE)this.mCoo, new Bits(65472));
/*     */   
/*  57 */   private final RoomBits stateReset = new RoomBits((COORDINATE)this.coo, new Bits(65535));
/*     */   
/*  59 */   private final RoomBits bWorkedDay = new RoomBits((COORDINATE)this.coo, new Bits(458752));
/*  60 */   private final RoomBits bReserved = new RoomBits((COORDINATE)this.coo, new Bits(524288));
/*     */ 
/*     */   
/*  63 */   private final RoomBits bdir = new RoomBits((COORDINATE)this.coo, new Bits(15728640));
/*  64 */   private final RoomBits bRan = new RoomBits((COORDINATE)this.coo, new Bits(251658240));
/*     */ 
/*     */ 
/*     */   
/*  68 */   private final DIR[] dirs = new DIR[] {
/*  69 */       DIR.C, DIR.N, DIR.W, DIR.NW
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final SETT_JOB job;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void chop() {
/* 222 */     if (state() == this.ISMALL) {
/* 223 */       setState(this.ISAPLING);
/* 224 */       (SETT.THINGS()).resources.create((COORDINATE)this.coo, this.b.auxRes.resource(), this.b.auxRes.amount() / 2);
/* 225 */       FACTIONS.player().res().inc(this.b.auxRes.resource(), FResources.RTYPE.PRODUCED, this.b.auxRes.amount() / 2);
/* 226 */     } else if (state() == this.IBIG || state() == this.IDEAD) {
/* 227 */       setState(this.ISAPLING);
/* 228 */       (SETT.THINGS()).resources.create((COORDINATE)this.coo, this.b.auxRes.resource(), this.b.auxRes.amount());
/* 229 */       FACTIONS.player().res().inc(this.b.auxRes.resource(), FResources.RTYPE.PRODUCED, this.b.auxRes.amount());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean kill() {
/* 236 */     if (state() == this.IBIG) {
/* 237 */       setState(this.IDEAD);
/* 238 */       return true;
/*     */     } 
/* 240 */     return false;
/*     */   }
/*     */   
/*     */   public boolean init(int tx, int ty, Instance ins) {
/* 244 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 1)
/* 245 */       return false; 
/* 246 */     if (isMaster(tx, ty)) {
/* 247 */       this.coo.set(tx, ty);
/* 248 */       this.mCoo.set(tx, ty);
/* 249 */       this.bdir.set((ROOMA)ins, 0);
/* 250 */       this.bState.set((ROOMA)ins, this.ISAPLING.index);
/* 251 */       this.bRan.set((ROOMA)ins, RND.rInt(this.bRan.max()));
/* 252 */       this.bWorkedDay.set((ROOMA)ins, this.b.time.dayI() - 1 & this.bWorkedDay.max());
/* 253 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 257 */     for (int di = 1; di < this.dirs.length; di++) {
/* 258 */       DIR d = this.dirs[di];
/* 259 */       if ((SETT.ROOMS()).fData.tileData.get(tx, ty, d) == 1 && isMaster(tx + d.x(), ty + d.y())) {
/* 260 */         this.coo.set(tx, ty);
/* 261 */         this.mCoo.set((tx + d.x()), (ty + d.y()));
/* 262 */         this.bdir.set((ROOMA)ins, di);
/* 263 */         this.bState.set((ROOMA)ins, this.ISAPLING.index);
/* 264 */         this.bRan.set((ROOMA)ins, RND.rInt(this.bRan.max()));
/* 265 */         this.bWorkedDay.set((ROOMA)ins, this.b.time.dayI() - 1 & this.bWorkedDay.max());
/* 266 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 270 */     throw new RuntimeException(); } private boolean isMaster(int tx, int ty) {
/*     */     byte b;
/*     */     int i;
/*     */     DIR[] arrayOfDIR;
/* 274 */     for (i = (arrayOfDIR = this.dirs).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 275 */       if (d != DIR.C && (SETT.ROOMS()).fData.tileData.get(tx, ty, d) == 1)
/* 276 */         return false;  b++; }
/*     */     
/* 278 */     return true;
/*     */   }
/*     */   
/*     */   public STATE state() {
/* 282 */     return this.states[this.bState.get()];
/*     */   }
/*     */   
/*     */   public OTile get(int tx, int ty) {
/* 286 */     this.ins = (Instance)this.b.get(tx, ty);
/* 287 */     if (this.ins == null)
/* 288 */       return null; 
/* 289 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 1)
/* 290 */       return null; 
/* 291 */     this.coo.set(tx, ty);
/* 292 */     if (this.bState.get() == 0)
/* 293 */       return null; 
/* 294 */     DIR d = this.dirs[this.bdir.get()];
/* 295 */     this.mCoo.set((tx + d.x()), (ty + d.y()));
/* 296 */     return this;
/*     */   }
/*     */   
/*     */   public OTile getM(int tx, int ty) {
/* 300 */     if (get(tx, ty) != null && this.bdir.get() == 0)
/* 301 */       return this; 
/* 302 */     return null;
/*     */   }
/*     */   
/*     */   public boolean destroyTileCan() {
/* 306 */     return (this.bState.get() > this.ISAPLING.index);
/*     */   }
/*     */   
/*     */   public void destroyTile() {
/* 310 */     setState(this.ISAPLING);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setState(STATE state) {
/* 315 */     int ox = this.coo.x();
/* 316 */     int oy = this.coo.y();
/*     */     
/* 318 */     for (int y = 0; y < 2; y++) {
/* 319 */       for (int x = 0; x < 2; x++) {
/* 320 */         int tx = this.mCoo.x() + x;
/* 321 */         int ty = this.mCoo.y() + y;
/* 322 */         if (get(tx, ty) != null) {
/*     */ 
/*     */ 
/*     */           
/* 326 */           get(tx, ty);
/* 327 */           this.stateReset.set((ROOMA)this.ins, 0);
/* 328 */           this.bState.set((ROOMA)this.ins, state.index);
/*     */         } 
/*     */       } 
/*     */     } 
/* 332 */     get(ox, oy);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDebug(SPRITE_RENDERER r, RenderData.RenderIterator it) {
/* 337 */     it.setOff(0, 0);
/* 338 */     if (this.bReserved.get() == 0) {
/* 339 */       COLOR.BLUE100.render(r, it.x(), it.y());
/*     */     } else {
/* 341 */       COLOR.GREEN100.render(r, it.x(), it.y());
/*     */     } 
/*     */     
/* 344 */     if (this.bWorkedDay.get() == (this.b.time.dayI() & this.bWorkedDay.max())) {
/* 345 */       COLOR.YELLOW100.render(r, it.x() + 32, it.y());
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateDay() {
/* 350 */     if (Bits.getDistance(this.bWorkedDay.get(), this.b.time.dayI(), this.bWorkedDay.max()) > 2) {
/* 351 */       state().fail();
/* 352 */       this.bWorkedDay.set((ROOMA)this.ins, this.b.time.dayI() - 1 & this.bWorkedDay.max());
/* 353 */       this.bReserved.set((ROOMA)this.ins, 0);
/*     */     } 
/* 355 */     state().update();
/*     */   }
/*     */   
/*     */   public SETT_JOB job() {
/* 359 */     return this.job;
/*     */   }
/*     */   
/* 362 */   OTile(final ROOM_ORCHARD b) { this.job = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/* 366 */           return (OTile.this.state() == OTile.this.IDEAD);
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
/* 377 */           return (OTile.this.state() == OTile.this.IDEAD) ? (SETT.TERRAIN()).TREES.SMALL.clearing().sound(OTile.this.coo.x(), OTile.this.coo.y()) : OTile.this.ins.blueprintI().employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 382 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 387 */           return (OTile.this.bReserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 392 */           OTile.this.bReserved.set((ROOMA)OTile.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 397 */           return (OTile.this.bReserved.get() == 0 && OTile.this.bWorkedDay.get() != (OTile.this.b.time.dayI() & OTile.this.bWorkedDay.max()));
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 402 */           OTile.this.bReserved.set((ROOMA)OTile.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid a) {
/* 407 */           return 45.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 412 */           return (OTile.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 417 */           return (COORDINATE)OTile.this.coo; }
/*     */         private final int failA; public void fail() { OTile.this.bProgress.inc((ROOMA)OTile.this.ins, -this.failA); } public void work(Humanoid a, int skill) { if (OTile.this.bProgress.get() >= sdays) { OTile.this.setState(OTile.this.ISMALL); } else { OTile.this.bProgress.inc((ROOMA)OTile.this.ins, skill); }  OTile.this.bDead.inc((ROOMA)OTile.this.ins, -1); } public int daysTillGrown() { return Math.max(0, b.time.DAYS_TILL_GROWTH - OTile.this.bProgress.get() / 4); }
/*     */       }; this.ISMALL = new STATE(2) {
/*     */         public void work(Humanoid a, int skill) { if (OTile.this.bProgress.get() >= smalldays) { OTile.this.setState(OTile.this.IBIG); } else { OTile.this.bProgress.inc((ROOMA)OTile.this.ins, skill); }  OTile.this.bDead.inc((ROOMA)OTile.this.ins, -1); } public void fail() { if (OTile.this.bDead.get() == OTile.this.bDead.max()) { OTile.this.setState(OTile.this.ISAPLING); } else { OTile.this.bDead.inc((ROOMA)OTile.this.ins, 1); }  } public int daysTillGrown() { return Math.max(0, (smalldays - OTile.this.bProgress.get()) / 4); } }; this.b = b; final int sdays = 4 * (int)(b.time.DAYS_TILL_GROWTH * 0.4D); final int smalldays = 4 * b.time.DAYS_TILL_GROWTH - sdays; this.ISAPLING = new STATE(1)
/*     */       {
/* 422 */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) { OTile.this.bWorkedDay.set((ROOMA)OTile.this.ins, OTile.this.b.time.dayI() & OTile.this.bWorkedDay.max());
/* 423 */           OTile.this.bReserved.set((ROOMA)OTile.this.ins, 0);
/* 424 */           double s = IndustryUtil.calcProductionRate(1.0D, skill, (IndustryRate)OTile.this.ins.industry(), OTile.this.ins);
/* 425 */           OTile.this.ins.incSkill(s);
/* 426 */           int am = (int)s;
/* 427 */           if (s - am > RND.rFloat())
/* 428 */             am++; 
/* 429 */           OTile.this.state().work(skill, am);
/* 430 */           return null; }
/*     */       }; this.IBIG = new STATE(3) {
/*     */         public void work(Humanoid a, int skill) { if (b.time.isRipe() && OTile.this.bHarvested.get() == 0) { double sk = fruitAmount() * OTile.this.ins.skill() * b.AmountPerTile * ((IndustryResource)b.productionData.outs().get(0)).rate; int am = ((IndustryResource)b.productionData.outs().get(0)).inc((ROOM_IDATA_INSTANCE)OTile.this.ins, sk); if (am != 0)
/*     */               OTile.this.ins.deposit(am);  OTile.this.bHarvested.set((ROOMA)OTile.this.ins, 1); }  } public void fail() { if (OTile.this.bDead.get() == OTile.this.bDead.max()) { OTile.this.setState(OTile.this.IDEAD); } else { OTile.this.bDead.inc((ROOMA)OTile.this.ins, 1); }  } public void update() { if (b.time.isDeadDay())
/*     */             OTile.this.bHarvested.set((ROOMA)OTile.this.ins, 0);  super.update(); } public double deadAmount() { return OTile.this.bDead.getD(); } public double fruitAmount() { if (OTile.this.bHarvested.get() == 1)
/*     */             return 0.0D;  return 1.0D; }
/*     */       }; this.IDEAD = new STATE(4) {
/*     */         public void work(Humanoid a, int skill) { OTile.this.setState(OTile.this.ISAPLING); (SETT.THINGS()).resources.create(a.tc(), b.auxRes.resource(), b.auxRes.amount()); FACTIONS.player().res().inc(b.auxRes.resource(), FResources.RTYPE.PRODUCED, b.auxRes.amount()); } public double deadAmount() { return 1.0D; }
/*     */       }; this.states = new STATE[] { null, this.ISAPLING, this.ISMALL, this.IBIG, this.IDEAD }; } public static class STATE
/*     */   {
/* 440 */     STATE(int i) { this.index = i; }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int index;
/*     */ 
/*     */     
/*     */     public void work(Humanoid a, int skill) {}
/*     */     
/*     */     public void fail() {}
/*     */     
/*     */     public double deadAmount() {
/* 452 */       return 0.0D;
/*     */     }
/*     */     
/*     */     public double fruitAmount() {
/* 456 */       return 0.0D;
/*     */     }
/*     */     
/*     */     public int daysTillGrown() {
/* 460 */       return Integer.MAX_VALUE;
/*     */     }
/*     */     
/*     */     public void update() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\OTile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */