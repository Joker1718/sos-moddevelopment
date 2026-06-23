/*     */ package settlement.room.food.farm;
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.sett.SettDebugClick;
/*     */ 
/*     */ final class Tile {
/*     */   private FarmInstance ins;
/*  32 */   private Coo coo = new Coo();
/*     */   
/*     */   private final ROOM_FARM b;
/*     */   private final Time time;
/*  36 */   private final RoomBits bReserved = new RoomBits((COORDINATE)this.coo, new Bits(7));
/*  37 */   private final RoomBits bDead = new RoomBits((COORDINATE)this.coo, new Bits(8));
/*  38 */   private final RoomBits bRandom = new RoomBits((COORDINATE)this.coo, new Bits(2032));
/*  39 */   private final RoomBits bHarvested = new RoomBits((COORDINATE)this.coo, new Bits(2048));
/*  40 */   private final RoomBits bSize = new RoomBits((COORDINATE)this.coo, new Bits(61440));
/*  41 */   private final RoomBits bWorked = new RoomBits((COORDINATE)this.coo, new Bits(4128768));
/*  42 */   private final RoomBits bHasExtraWork = new RoomBits((COORDINATE)this.coo, new Bits(1073741824));
/*  43 */   private final double bRandomI = 1.0D / this.bRandom.max();
/*  44 */   private final double bSizeI = 1.0D / this.bRandom.max();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Cycle[] cycles;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Tile get(int tx, int ty) {
/*  90 */     this.ins = (FarmInstance)this.b.get(tx, ty);
/*  91 */     if (this.ins == null)
/*  92 */       return null; 
/*  93 */     this.coo.set(tx, ty);
/*  94 */     return this;
/*     */   }
/*     */   
/*     */   private Cycle cycle() {
/*  98 */     if (this.bSize.get() > 0)
/*  99 */       return this.CDead; 
/* 100 */     return this.cycles[this.time.dayI()];
/*     */   }
/*     */   
/*     */   public void init(COORDINATE c, FarmInstance ins) {
/* 104 */     this.bRandom.set((ROOMA)ins, RND.rInt(this.bRandom.max()));
/* 105 */     this.bReserved.set((ROOMA)ins, dayR() - 1 & 0x7);
/*     */   }
/*     */   
/*     */   public void updateDay() {
/* 109 */     cycle().update();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     if (Math.ceil((this.bReserved.get() - dayR())) > 2.0D) {
/* 115 */       this.bReserved.set((ROOMA)this.ins, dayR() - 1 & 0x7);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan() {
/* 128 */     return (cycle().size() > 0.0D);
/*     */   }
/*     */   
/*     */   public void destroyTile() {
/* 132 */     cycle().destroyTile();
/*     */   }
/*     */   
/*     */   private int dayR() {
/* 136 */     return (int)this.time.day() & 0x7;
/*     */   }
/*     */   
/*     */   public SETT_JOB job() {
/* 140 */     return cycle();
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i) {
/* 144 */     Cycle c = cycle();
/* 145 */     double am = c.size();
/* 146 */     if (am > 0.0D) {
/*     */       
/* 148 */       double ripe = c.ripeness();
/* 149 */       double growth = c.growth();
/* 150 */       this.b.crop.sprite.renderTrunk(1 + this.b.constructor.direction(i, (AREA)this.ins), r, s, i, growth, ripe, am);
/* 151 */       double res = am * c.fruit();
/* 152 */       ripe = c.ripenessFruit();
/* 153 */       this.b.crop.sprite.renderTop(1 + this.b.constructor.direction(i, (AREA)this.ins), r, s, i, growth, ripe, res);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTill(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i) {
/* 160 */     int till = CLAMP.i(this.bWorked.get(), 0, this.b.time.daysWorking - this.b.time.daysPlanting);
/* 161 */     double dt = till / (this.b.time.daysWorking - this.b.time.daysPlanting);
/* 162 */     this.b.constructor.renderTill(r, i, (AREA)this.ins, dt);
/*     */   }
/*     */ 
/*     */   
/* 166 */   private static CharSequence ¤¤till = "¤Tilling";
/* 167 */   private static CharSequence ¤¤tending = "¤Tending";
/* 168 */   private static CharSequence ¤¤harvesting = "¤Harvesting";
/* 169 */   private static CharSequence ¤¤clearing = "¤Clearing"; private final Cycle CTill; private final Cycle CPlant; private final Cycle CHarvest; final Cycle CDead; public static final double WORK_TIME = 4.0D;
/*     */   
/*     */   static {
/* 172 */     D.ts(Tile.class);
/*     */   }
/*     */   
/* 175 */   Tile(ROOM_FARM b) { this.CTill = new Cycle(this, ¤¤till)
/*     */       {
/*     */         boolean is()
/*     */         {
/* 179 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public double size() {
/* 184 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double ripeness() {
/* 189 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double growth() {
/* 194 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double fruit() {
/* 199 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double ripenessFruit() {
/* 204 */           return 0.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void update() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 214 */           Tile.this.bWorked.inc((ROOMA)Tile.this.ins, 1);
/*     */           
/* 216 */           Tile.this.ins.tData.increase(skill, Tile.this.coo.x(), Tile.this.coo.y());
/* 217 */           if (Tile.this.bHasExtraWork.get() > 0 && is()) {
/* 218 */             Tile.this.bHasExtraWork.inc((ROOMA)Tile.this.ins, -1);
/* 219 */             jobReserveCancel((RESOURCE)null);
/*     */           } 
/* 221 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void destroyTile() {
/* 226 */           int i = Tile.this.bWorked.get();
/* 227 */           int n = i / 2;
/* 228 */           Tile.this.bWorked.set((ROOMA)Tile.this.ins, n);
/* 229 */           Tile.this.ins.tData.decrease(i - n);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 239 */     this.CPlant = new Cycle(this, ¤¤tending)
/*     */       {
/*     */         boolean is()
/*     */         {
/* 243 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public double size() {
/* 248 */           double d = r();
/* 249 */           d *= Tile.this.bWorked.get() * Tile.this.time.daysWorkingI;
/*     */           
/* 251 */           d *= Tile.this.ins.tData.skill();
/* 252 */           d *= (Tile.this.ins.blueprintI()).constructor.fertility(Tile.this.coo.x(), Tile.this.coo.y());
/* 253 */           d = CLAMP.d(d, 0.0D, 1.0D);
/*     */ 
/*     */           
/* 256 */           return d;
/*     */         }
/*     */         
/*     */         private double r() {
/* 260 */           double d = MATH.distance(Tile.this.time.dayPlant, Tile.this.time.day(), Tile.this.time.days);
/* 261 */           d /= Tile.this.time.daysPlanting;
/* 262 */           d *= 1.25D;
/* 263 */           double r = 0.25D * Tile.this.bRandom.get() * Tile.this.bRandomI;
/* 264 */           d -= r;
/* 265 */           return CLAMP.d(d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double ripeness() {
/* 271 */           double d = r();
/* 272 */           if (d > 0.75D) {
/* 273 */             return CLAMP.d((d - 0.75D) * 8.0D, 0.0D, 1.0D);
/*     */           }
/* 275 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double fruit() {
/* 280 */           double d = r();
/* 281 */           if (d > 0.5D) {
/* 282 */             d = (d - 0.5D) * 4.0D;
/*     */           }
/* 284 */           d *= 0.2D + Tile.this.ins.tData.skill() * 0.5D;
/* 285 */           return CLAMP.d(d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public double ripenessFruit() {
/* 290 */           double d = r();
/* 291 */           if (d > 0.75D) {
/* 292 */             return CLAMP.d((d - 0.75D) * 4.0D, 0.0D, 1.0D);
/*     */           }
/* 294 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double growth() {
/* 299 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public void update() {
/* 304 */           Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 0);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void debug() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 314 */           Tile.this.bWorked.inc((ROOMA)Tile.this.ins, 1);
/* 315 */           Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 0);
/* 316 */           Tile.this.ins.tData.increase(skill, Tile.this.coo.x(), Tile.this.coo.y());
/* 317 */           if (Tile.this.bHasExtraWork.get() > 0 && is()) {
/* 318 */             Tile.this.bHasExtraWork.inc((ROOMA)Tile.this.ins, -1);
/* 319 */             jobReserveCancel((RESOURCE)null);
/*     */           } 
/* 321 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void destroyTile() {
/* 326 */           int i = Tile.this.bWorked.get();
/* 327 */           int n = i / 2;
/* 328 */           Tile.this.bWorked.set((ROOMA)Tile.this.ins, n);
/* 329 */           Tile.this.ins.tData.decrease(i - n);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 335 */     this.CHarvest = new Cycle(this, ¤¤harvesting)
/*     */       {
/*     */         boolean is()
/*     */         {
/* 339 */           return (size() > 0.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public double size() {
/* 344 */           if (Tile.this.bHarvested.get() == 0) {
/* 345 */             double d = Tile.this.bWorked.get() * Tile.this.time.daysWorkingI;
/* 346 */             d *= Tile.this.ins.tData.skill();
/* 347 */             d *= (Tile.this.ins.blueprintI()).constructor.fertility(Tile.this.coo.x(), Tile.this.coo.y());
/* 348 */             d = CLAMP.d(d, 0.0D, 1.0D);
/*     */             
/* 350 */             return d;
/*     */           } 
/*     */           
/* 353 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double ripeness() {
/* 358 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double fruit() {
/* 363 */           return 0.2D + Tile.this.ins.tData.skill() * 0.5D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double ripenessFruit() {
/* 368 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double growth() {
/* 373 */           double d = MATH.distance(Tile.this.time.day(), Tile.this.time.dayDeath, Tile.this.time.days);
/* 374 */           d *= 1.25D;
/* 375 */           double r = 0.25D * Tile.this.bRandom.get() * Tile.this.bRandomI;
/* 376 */           d -= r;
/* 377 */           return CLAMP.d(d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public void update() {
/* 382 */           if (Tile.this.bHarvested.get() == 0 && MATH.distance(Tile.this.time.day(), Tile.this.time.dayDeath, Tile.this.time.days) <= 1.0D) {
/* 383 */             Tile.this.bSize.set((ROOMA)Tile.this.ins, (int)Math.ceil(size() * Tile.this.bSize.max()));
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 389 */           Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 1);
/* 390 */           IndustryResource rr = (IndustryResource)((Industry)Tile.this.b.industries().get(0)).outs().get(0);
/* 391 */           double d = rr.rate;
/*     */           
/* 393 */           d *= Tile.this.bWorked.get() * Tile.this.time.daysWorkingI;
/* 394 */           d *= Tile.this.ins.tData.skill();
/* 395 */           d *= Tile.this.time.days;
/* 396 */           d *= ROOM_FARM.WORKERPERTILEI;
/* 397 */           d *= (Tile.this.ins.blueprintI()).yearMul;
/* 398 */           int am = rr.inc((ROOM_IDATA_INSTANCE)Tile.this.ins, d);
/* 399 */           if (am > 0) {
/* 400 */             (SETT.THINGS()).resources.create((COORDINATE)Tile.this.coo, Tile.this.b.crop.resource, am);
/*     */           }
/* 402 */           Tile.this.CDead.jobPerform(skill, r, rAm);
/*     */ 
/*     */           
/* 405 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void destroyTile() {
/* 410 */           Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 1);
/* 411 */           Tile.this.bSize.set((ROOMA)Tile.this.ins, 0);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 417 */     this.CDead = new Cycle(this, ¤¤clearing)
/*     */       {
/*     */         public double size()
/*     */         {
/* 421 */           return Tile.this.bSize.get() * Tile.this.bSizeI;
/*     */         }
/*     */ 
/*     */         
/*     */         public double ripeness() {
/* 426 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double fruit() {
/* 431 */           if (Tile.this.bDead.get() == 1)
/* 432 */             return 0.0D; 
/* 433 */           return growth();
/*     */         }
/*     */ 
/*     */         
/*     */         public double ripenessFruit() {
/* 438 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double growth() {
/* 443 */           if (Tile.this.bDead.get() == 1)
/* 444 */             return 0.0D; 
/* 445 */           double d = MATH.distance(Tile.this.time.day(), Tile.this.time.dayDeath, Tile.this.time.days);
/* 446 */           d *= 1.25D;
/* 447 */           double r = 0.25D * Tile.this.bRandom.get() * Tile.this.bRandomI;
/* 448 */           d -= r;
/* 449 */           if (d >= 1.0D)
/* 450 */             return 0.0D; 
/* 451 */           return CLAMP.d(d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public void update() {
/* 456 */           double now = TIME.years().bitPartOf() * Tile.this.time.days;
/* 457 */           if (MATH.distance(now, Tile.this.time.dayDeath, Tile.this.time.days) <= 1.0D)
/* 458 */             Tile.this.bDead.set((ROOMA)Tile.this.ins, 1); 
/* 459 */           Tile.this.bWorked.set((ROOMA)Tile.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         boolean is() {
/* 464 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 469 */           Tile.this.bDead.set((ROOMA)Tile.this.ins, 0);
/* 470 */           Tile.this.bSize.set((ROOMA)Tile.this.ins, 0);
/* 471 */           Tile.this.bWorked.set((ROOMA)Tile.this.ins, 0);
/* 472 */           return null;
/*     */         }
/*     */         
/*     */         public void destroyTile()
/*     */         {
/* 477 */           jobPerform(null, null, 0); } };
/*     */     this.b = b;
/*     */     this.time = b.time;
/*     */     this.cycles = new Cycle[this.time.days];
/*     */     this.cycles[MATH.mod(this.time.dayHarvest, this.time.days)] = this.CHarvest;
/*     */     this.cycles[MATH.mod(this.time.dayHarvest + 1, this.time.days)] = this.CHarvest;
/*     */     int i;
/*     */     for (i = 0; i < this.time.daysPlanting; i++)
/*     */       this.cycles[MATH.mod(this.time.dayHarvest - i - 1, this.time.days)] = this.CPlant; 
/*     */     for (i = 0; i < this.time.days; i++) {
/*     */       if (this.cycles[i] == null)
/*     */         this.cycles[i] = this.CTill; 
/* 489 */     }  } private abstract class Cycle implements SETT_JOB { Cycle(CharSequence name) { this.name = name; }
/*     */     
/*     */     private final CharSequence name;
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/* 494 */       if (jobReservedIs(r)) {
/* 495 */         throw new RuntimeException();
/*     */       }
/* 497 */       if (MATH.distance(Tile.this.bReserved.get(), Tile.this.dayR(), 7) > 1) {
/* 498 */         Tile.this.bHasExtraWork.set((ROOMA)Tile.this.ins, 1);
/*     */       }
/*     */       
/* 501 */       Tile.this.bReserved.set((ROOMA)Tile.this.ins, Tile.this.dayR());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 506 */       return (Tile.this.bReserved.get() == Tile.this.dayR());
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 511 */       Tile.this.bReserved.set((ROOMA)Tile.this.ins, Tile.this.time.dayI() - 1 & 0x7);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReserveCanBe() {
/* 516 */       return (is() && !jobReservedIs((RESOURCE)null));
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 521 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid a) {
/* 526 */       return 4.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */     
/*     */     abstract boolean is();
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/* 538 */       return (COORDINATE)Tile.this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence jobName() {
/* 543 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/* 548 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 553 */       return Tile.this.b.employment().sound();
/*     */     }
/*     */     
/*     */     public abstract double size();
/*     */     
/*     */     public abstract double fruit();
/*     */     
/*     */     public abstract double growth();
/*     */     
/*     */     public abstract double ripeness();
/*     */     
/*     */     public abstract double ripenessFruit();
/*     */     
/*     */     public abstract void update();
/*     */     
/*     */     public abstract void destroyTile();
/*     */     
/*     */     public void debug() {} }
/*     */ 
/*     */   
/*     */   static final class IData
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/* 577 */     private float skillPrev = 0.0F;
/*     */     
/*     */     private float skill;
/*     */     
/*     */     private int skillI;
/*     */     private short works;
/*     */     private int workAcc;
/* 584 */     private byte day = 0;
/*     */     
/*     */     private final FarmInstance ins;
/*     */ 
/*     */     
/*     */     IData(FarmInstance ins) {
/* 590 */       Time t = (ins.blueprintI()).time;
/* 591 */       this.day = (byte)t.dayI();
/* 592 */       this.ins = ins;
/*     */       
/* 594 */       this.day = (byte)(int)MATH.distance(t.dayDeath, t.day(), t.days);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void updateDay() {
/* 602 */       Time t = (this.ins.blueprintI()).time;
/* 603 */       this.day = (byte)(int)MATH.distance(t.dayDeath, t.day(), t.days);
/*     */       
/* 605 */       if (this.day == 1) {
/* 606 */         this.workAcc = 0;
/* 607 */         this.skillPrev = this.skill / ((this.skillI == 0) ? true : this.skillI);
/* 608 */         this.skill = 0.0F;
/* 609 */         this.skillI = 0;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 615 */       if (this.day >= 1 && this.day <= t.daysWorking) {
/*     */ 
/*     */         
/* 618 */         if (this.works > 0) {
/* 619 */           this.workAcc += this.works;
/*     */         }
/*     */       } else {
/* 622 */         this.day = (byte)t.daysWorking;
/*     */       } 
/* 624 */       this.works = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public double skill() {
/* 629 */       if (this.skillI == 0)
/* 630 */         return this.skillPrev; 
/* 631 */       return (this.skill / this.skillI);
/*     */     }
/*     */ 
/*     */     
/*     */     public double work() {
/* 636 */       return this.workAcc / (this.day * this.ins.area());
/*     */     }
/*     */     
/*     */     public double workday() {
/* 640 */       if (this.day < 1 || this.day > (this.ins.blueprintI()).time.daysWorking)
/* 641 */         return work(); 
/* 642 */       return this.works / this.ins.area();
/*     */     }
/*     */     
/*     */     private void increase(Humanoid skill, int tx, int ty) {
/* 646 */       this.works = (short)(this.works + 1);
/* 647 */       double s = IndustryUtil.calcProductionRate(1.0D, skill, (IndustryRate)this.ins.blueprintI().industries().get(0), this.ins);
/*     */       
/* 649 */       this.skill = (float)(this.skill + s);
/* 650 */       this.skillI++;
/*     */     }
/*     */     
/*     */     public void decrease(int am) {
/* 654 */       this.works = (short)(this.works - am);
/*     */     }
/*     */     
/*     */     public CharSequence cName() {
/* 658 */       return ((this.ins.blueprintI()).tile.cycles[(this.ins.blueprintI()).tile.time.dayI()]).name;
/*     */     }
/*     */     
/*     */     public boolean shouldStore() {
/* 662 */       return ((this.ins.blueprintI()).tile.cycles[(this.ins.blueprintI()).tile.time.dayI()] == (this.ins.blueprintI()).tile.CHarvest);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */