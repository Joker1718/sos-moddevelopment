/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import init.type.WGROUP;
/*     */ import java.io.Serializable;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RoomEmploymentIns
/*     */   extends RoomInstance.SecretEmployment
/*     */   implements Serializable
/*     */ {
/*  30 */   public static CharSequence ¤¤Workload = "¤Work-load";
/*  31 */   public static CharSequence ¤¤WorkloadD = "How busy your employees are. If workload is low, it means some of the workers have nothing to do and are wasting their time. Possible causes of this are that there simply isn't enough work, or that the room is missing resources to work with. If workload is 100%, your workers might have too much to do and the room might need to have more workers allocated.";
/*  32 */   public static CharSequence ¤¤Proximity = "¤Commute";
/*  33 */   public static CharSequence ¤¤ProximityD = "The commute the employees need to undertake each day. Usually this is the distance to the employees home, but some workers need to leave the city during their workday, and these rooms are best placed near the city's exits.";
/*     */   
/*  35 */   public static CharSequence ¤¤ProximityInput = "¤Hauling";
/*  36 */   public static CharSequence ¤¤¤¤ProximityInputD = "Industry workers can fetch the input for the industry without problems if the distance is short. If long, then productivity will suffer."; public static final int FETCH_FREE_TILES = 36;
/*     */   private static final double FETCH_AVERAGE_SPEED = 1.188D;
/*     */   
/*     */   static {
/*  40 */     D.ts(RoomEmploymentIns.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int FETCH_FREE_SECONDS = 61;
/*     */ 
/*     */   
/*     */   private static final int FETCH_FREE_MAX_COMP = 110;
/*     */ 
/*     */   
/*  52 */   public static final int DIST_AVERAGE_TIME = (int)(TIME.workSeconds() * 0.06D);
/*     */ 
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   
/*  58 */   private short workersEmployed = 0;
/*  59 */   private short workersTarget = 0;
/*  60 */   private short workersTargetMax = 500;
/*     */   
/*     */   private final RoomInstance ins;
/*  63 */   private float eff = 0.0F;
/*  64 */   private float effTot = 0.0F;
/*  65 */   private byte EffLast = 100;
/*     */   
/*  67 */   private byte lastProximity = 100;
/*  68 */   private byte proxCount = 0;
/*     */   
/*     */   private float walkSeconds;
/*  71 */   private byte lastFetch = 100;
/*  72 */   private float surplousFetch = 0.0F;
/*  73 */   private byte fetchCount = 0;
/*     */   
/*     */   private float fetchSeconds;
/*     */   private int fetchBonus;
/*  77 */   private static double EffLastI = 0.01D;
/*     */   
/*  79 */   private static ArrayListResize<Humanoid> employees = new ArrayListResize(512, 8192);
/*  80 */   private static int employeesI = -1;
/*  81 */   private static Object employeesO = null;
/*     */   
/*     */   private boolean active = false;
/*     */   
/*  85 */   private final WGROUP.HTypeBitsImp preferred = new WGROUP.HTypeBitsImp(false);
/*     */   private int[] equipData;
/*     */   private static final int toolI = 0;
/*     */   private static final int toolToExpireI = 1;
/*     */   private static final int toolReservedI = 2;
/*     */   
/*     */   public WGROUP.HTypeBits preffered() {
/*  92 */     return (WGROUP.HTypeBits)this.preferred;
/*     */   }
/*     */   
/*     */   public void prefferedSet(WGROUP.HTypeBits other) {
/*  96 */     remove();
/*  97 */     this.preferred.copy(other);
/*  98 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(boolean active, boolean day, boolean auto, double seconds) {
/* 103 */     if (blueprint().employment() == null) {
/*     */       return;
/*     */     }
/* 106 */     if (this.workersTarget > max()) {
/* 107 */       neededSet(max());
/*     */     }
/*     */     
/* 110 */     if (day) {
/* 111 */       remove();
/* 112 */       for (RoomEquip w : (SETT.ROOMS()).employment.equip.ALL) {
/* 113 */         updateTools(w, true);
/*     */       }
/* 115 */       if (this.proxCount > 0) {
/* 116 */         double p = (this.walkSeconds - DIST_AVERAGE_TIME) / TIME.workSeconds();
/*     */ 
/*     */         
/* 119 */         this.walkSeconds = 0.0F;
/* 120 */         this.proxCount = 0;
/* 121 */         p = 1.0D - p;
/* 122 */         p = Math.ceil(p * 100.0D) / 100.0D;
/* 123 */         p = CLAMP.d(p, 0.0D, 10.0D);
/* 124 */         double d = p;
/*     */         
/* 126 */         this.lastProximity = (byte)(int)(100.0D * d);
/*     */       } 
/*     */       
/* 129 */       if (this.fetchCount > 0) {
/* 130 */         double p = this.fetchSeconds / TIME.workSeconds();
/* 131 */         this.fetchSeconds = 0.0F;
/* 132 */         this.fetchCount = 0;
/* 133 */         p = 1.0D - p;
/* 134 */         p = CLAMP.d(p, 0.0D, 1.0D);
/* 135 */         double d = 0.75D * p + 0.25D * this.lastFetch / 100.0D;
/*     */         
/* 137 */         this.lastFetch = (byte)(int)(100.0D * d);
/*     */       } 
/*     */       
/* 140 */       if (this.effTot > 0.0F) {
/* 141 */         double p = (this.eff / this.effTot);
/* 142 */         this.eff = 0.0F;
/* 143 */         this.effTot = 0.0F;
/*     */         
/* 145 */         int next = CLAMP.i((int)(p * 100.0D), 0, 100);
/* 146 */         if (next <= this.EffLast)
/*     */         {
/*     */           
/* 149 */           next = (int)(0.5D * this.EffLast + 0.5D * next); } 
/* 150 */         double last = efficiency();
/* 151 */         this.EffLast = (byte)CLAMP.i(next, 0, 100);
/* 152 */         add();
/* 153 */         if (active && auto)
/* 154 */           adjustAuto(efficiency(), last); 
/*     */       } else {
/* 156 */         add();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateTools(RoomEquip w, boolean expire) {
/* 168 */     if (expire) {
/* 169 */       int exp = toolsToExpire(w);
/* 170 */       exp = CLAMP.i(exp, 0, tools(w));
/* 171 */       int am = tools(w) - exp;
/* 172 */       toolISet(w, 0, am);
/* 173 */       toolISet(w, 1, 0);
/*     */     } 
/*     */ 
/*     */     
/* 177 */     int nn = toolsNeeded(w);
/* 178 */     if (nn < 0) {
/* 179 */       int newAm = tools(w) + nn;
/* 180 */       (SETT.THINGS()).resources.create(this.ins.mX(), this.ins.mY(), w.resource, -nn);
/* 181 */       FACTIONS.player().res().inc(w.resource, FResources.RTYPE.EQUIPPED, nn);
/* 182 */       toolISet(w, 0, newAm);
/*     */     } 
/*     */     
/* 185 */     if (expire) {
/* 186 */       double am = tools(w);
/* 187 */       am *= w.degradePerDay;
/* 188 */       int a = (int)am;
/* 189 */       am -= a;
/* 190 */       if (RND.rFloat() < am)
/* 191 */         a++; 
/* 192 */       toolISet(w, 1, a);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void adjustAuto(double workload, double last) {
/* 197 */     double am = needed();
/* 198 */     if (am == 0.0D) {
/* 199 */       neededSetAdjustWorkload(1);
/* 200 */     } else if (last >= 1.0D && workload >= 1.0D && needed() - employed() <= 1) {
/* 201 */       int aa = 1;
/* 202 */       if (workload >= 1.0D) {
/* 203 */         aa = (int)Math.ceil(employed() / 10.0D);
/*     */       }
/*     */       
/* 206 */       neededSetAdjustWorkload(needed() + aa);
/*     */     }
/* 208 */     else if (am > 1.0D && last < 1.0D && workload < 1.0D && employed() - needed() <= 1) {
/* 209 */       double p = (workload + last) / 2.0D;
/* 210 */       int needed = (int)Math.ceil(p * (employed() + 1.0D));
/*     */       
/* 212 */       int fire = CLAMP.i(employed() - needed, 0, (int)Math.ceil(employed() / 10.0D));
/* 213 */       if (fire > 0) {
/* 214 */         neededSetAdjustWorkload(needed() - fire);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void activate(boolean active) {
/* 221 */     if (active == this.active) {
/*     */       return;
/*     */     }
/*     */     
/* 225 */     remove();
/*     */     
/* 227 */     if (!active) {
/*     */ 
/*     */       
/* 230 */       this.EffLast = 100;
/* 231 */       this.eff = 0.0F;
/* 232 */       this.effTot = 0.0F;
/* 233 */       this.proxCount = 0;
/* 234 */       this.walkSeconds = 0.0F;
/* 235 */       this.lastProximity = 100;
/* 236 */       this.lastFetch = 100;
/* 237 */       this.fetchSeconds = 0.0F;
/* 238 */       this.fetchCount = 0;
/*     */     } 
/* 240 */     this.active = active;
/*     */     
/* 242 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 251 */     if (blueprint().employment() != null) {
/* 252 */       if (employed() > 0) {
/* 253 */         int rem = 0;
/* 254 */         int added = 0; byte b; int i; ENTITY[] arrayOfENTITY;
/* 255 */         for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 256 */           if (e instanceof Humanoid && (STATS.WORK()).EMPLOYED.get(((Humanoid)e).indu()) == this.ins) {
/* 257 */             (STATS.WORK()).EMPLOYED.set(e, null);
/* 258 */             rem++;
/* 259 */             if (!e.isRemoved())
/* 260 */               added++; 
/*     */           }  b++; }
/*     */         
/* 263 */         if (employed() != 0) {
/* 264 */           throw new RuntimeException("" + rem + " " + rem + " " + added);
/*     */         }
/*     */       } 
/*     */       
/* 268 */       for (RoomEquip w : (SETT.ROOMS()).employment.equip.ALL) {
/* 269 */         updateTools(w, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void remove() {
/* 275 */     if (this.active && blueprint().employment() != null) {
/* 276 */       blueprint().employment().register(this, -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void add() {
/* 282 */     if (this.active && blueprint().employment() != null) {
/* 283 */       blueprint().employment().register(this, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void maxSet(int max) {
/* 289 */     if (max < 0 || max > 32767)
/* 290 */       throw new RuntimeException(String.valueOf(ins().name(0, 0)) + " " + String.valueOf(ins().name(0, 0)) + " " + max + " " + ins().mX()); 
/* 291 */     this.workersTargetMax = (short)max;
/* 292 */     if (this.workersTarget > this.workersTargetMax)
/* 293 */       neededSet(this.workersTargetMax); 
/*     */   }
/*     */   
/*     */   public int max() {
/* 297 */     return this.workersTargetMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reportWorkSuccess(int seconds, boolean success) {
/* 302 */     if (employed() <= 0) {
/*     */       return;
/*     */     }
/* 305 */     double v = seconds / employed();
/*     */     
/* 307 */     this.effTot = (float)(this.effTot + v);
/* 308 */     if (success) {
/* 309 */       this.eff = (float)(this.eff + v);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void neededSet(int target) {
/* 315 */     target = CLAMP.i(target, 0, max());
/* 316 */     if (target != this.workersTarget) {
/* 317 */       remove();
/* 318 */       this.workersTarget = (short)target;
/* 319 */       add();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void neededSetAdjustWorkload(int target) {
/* 325 */     target = CLAMP.i(target, 0, max());
/* 326 */     if (target != this.workersTarget) {
/* 327 */       remove();
/* 328 */       if (target > this.workersTarget) {
/* 329 */         double d = 0.75D * this.workersTarget / target;
/* 330 */         this.EffLast = (byte)CLAMP.i(this.EffLast - (int)(d * 100.0D), 0, 100);
/*     */       } else {
/* 332 */         this.EffLast = 100;
/*     */       } 
/* 334 */       this.workersTarget = (short)target;
/* 335 */       add();
/*     */     } 
/*     */   }
/*     */   
/*     */   public int needed() {
/* 340 */     if (!this.ins.active())
/* 341 */       return 0; 
/* 342 */     return this.workersTarget;
/*     */   }
/*     */   
/*     */   public int hardTarget() {
/* 346 */     return this.workersTarget;
/*     */   }
/*     */   
/*     */   public int target() {
/* 350 */     return (int)Math.ceil(this.workersTarget * blueprint().employment().getFill());
/*     */   }
/*     */   
/*     */   public final boolean isOverstaffed() {
/* 354 */     return !((ins().active() || this.workersEmployed <= 0) && this.workersEmployed <= target());
/*     */   }
/*     */   
/*     */   public final int employed() {
/* 358 */     return this.workersEmployed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void employ(Humanoid h) {
/* 367 */     remove();
/* 368 */     this.workersEmployed = (short)(this.workersEmployed + 1);
/* 369 */     if (this.ins.blueprint().employment() != null) {
/* 370 */       this.ins.blueprint().employment().employ(h, 1);
/*     */     }
/* 372 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fire(Humanoid h) {
/* 380 */     remove();
/* 381 */     this.workersEmployed = (short)(this.workersEmployed - 1);
/* 382 */     if (this.ins.blueprint().employment() != null) {
/* 383 */       this.ins.blueprint().employment().employ(h, -1);
/*     */     }
/* 385 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public double efficiencySoFar() {
/* 390 */     if (this.effTot == 0.0F)
/* 391 */       return this.EffLast * EffLastI; 
/* 392 */     return (this.eff / this.effTot);
/*     */   }
/*     */ 
/*     */   
/*     */   public double efficiency() {
/* 397 */     return this.EffLast * EffLastI;
/*     */   }
/*     */   
/*     */   public final RoomInstance ins() {
/* 401 */     return this.ins;
/*     */   }
/*     */   
/*     */   public final RoomBlueprintIns<?> blueprint() {
/* 405 */     return (RoomBlueprintIns)this.ins.blueprint();
/*     */   }
/*     */   
/*     */   public LIST<Humanoid> employees() {
/* 409 */     return employees(this.ins);
/*     */   }
/*     */   
/*     */   public LIST<Humanoid> employees(LISTE<Humanoid> res) {
/* 413 */     return employees(this.ins, res);
/*     */   }
/*     */   
/*     */   public static LIST<Humanoid> employees(RoomInstance ins) {
/* 417 */     if (echeck(ins)) {
/* 418 */       return employees(ins, (LISTE<Humanoid>)employees);
/*     */     }
/* 420 */     return (LIST<Humanoid>)employees;
/*     */   }
/*     */   
/*     */   public static LIST<Humanoid> employess(RoomBlueprint imp) {
/* 424 */     if (echeck(imp)) {
/* 425 */       return employees(imp, (LISTE<Humanoid>)employees);
/*     */     }
/* 427 */     return (LIST<Humanoid>)employees;
/*     */   }
/*     */   
/*     */   private static boolean echeck(Object o) {
/* 431 */     if (employeesI != GAME.updateI() || o != employeesO) {
/* 432 */       employeesI = GAME.updateI();
/* 433 */       employeesO = o;
/* 434 */       employees.clearSoft();
/* 435 */       return true;
/*     */     } 
/* 437 */     return false;
/*     */   } public static LIST<Humanoid> employees(RoomInstance ins, LISTE<Humanoid> res) { byte b;
/*     */     int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 441 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 442 */       if (!res.hasRoom())
/*     */         break; 
/* 444 */       if (e instanceof Humanoid) {
/* 445 */         Humanoid a = (Humanoid)e;
/* 446 */         if ((STATS.WORK()).EMPLOYED.get(a) == ins) {
/* 447 */           res.add(a);
/* 448 */           if (!res.hasRoom()) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 455 */     return (LIST<Humanoid>)res; } public static LIST<Humanoid> employees(RoomBlueprint bb, LISTE<Humanoid> res) {
/*     */     byte b;
/*     */     int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 459 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 460 */       if (e instanceof Humanoid) {
/* 461 */         Humanoid a = (Humanoid)e;
/* 462 */         if ((STATS.WORK()).EMPLOYED.get(a) != null && ((RoomInstance)(STATS.WORK()).EMPLOYED.get(a)).blueprint() == bb) {
/* 463 */           res.add(a);
/* 464 */           if (!res.hasRoom()) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 471 */     return (LIST<Humanoid>)res;
/*     */   }
/*     */   public RoomEmploymentIns(RoomInstance ins) {
/* 474 */     this.equipData = Alloc.ii(0);
/*     */     this.ins = ins;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tools(RoomEquip w) {
/* 480 */     return toolI(w, 0);
/*     */   }
/*     */   
/*     */   public int toolsTarget(RoomEquip w) {
/* 484 */     return employed() * w.target(this.ins.blueprintI().employment()).get();
/*     */   }
/*     */   
/*     */   public int toolsTargetMax(RoomEquip w) {
/* 488 */     return employed() * w.target(this.ins.blueprintI().employment()).max();
/*     */   }
/*     */   
/*     */   public double toolD(RoomEquip w) {
/* 492 */     double e = toolsTargetMax(w);
/* 493 */     if (e == 0.0D)
/* 494 */       return 0.0D; 
/* 495 */     double t = CLAMP.i(tools(w), 0, toolsTarget(w));
/* 496 */     return CLAMP.d(t / e, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public double toolsPerPerson(RoomEquip w) {
/* 500 */     double e = employed();
/* 501 */     if (e == 0.0D)
/* 502 */       return 0.0D; 
/* 503 */     double t = CLAMP.i(tools(w), 0, toolsTarget(w));
/* 504 */     return CLAMP.d(t / e, 0.0D, toolsTargetMax(w));
/*     */   }
/*     */   
/*     */   public int toolsToExpire(RoomEquip w) {
/* 508 */     return toolI(w, 1);
/*     */   }
/*     */   
/*     */   public int toolsNeeded(RoomEquip w) {
/* 512 */     return toolsTarget(w) - tools(w) + toolsToExpire(w) - toolReserved(w);
/*     */   }
/*     */   
/*     */   public int toolReserved(RoomEquip w) {
/* 516 */     return toolI(w, 2);
/*     */   }
/*     */   
/*     */   public void toolReserve(RoomEquip w, int am) {
/* 520 */     int aa = toolI(w, 2) + am;
/* 521 */     if (aa < 0)
/* 522 */       throw new RuntimeException(); 
/* 523 */     toolISet(w, 2, aa);
/*     */   }
/*     */   
/*     */   public void toolDeliver(RoomEquip w, int am) {
/* 527 */     if (am < 0)
/* 528 */       throw new RuntimeException(); 
/* 529 */     remove();
/* 530 */     FACTIONS.player().res().inc(w.resource, FResources.RTYPE.EQUIPPED, -am);
/* 531 */     int aa = toolI(w, 0) + am;
/* 532 */     toolISet(w, 0, aa);
/* 533 */     add();
/*     */   }
/*     */   
/*     */   private int toolI(RoomEquip w, int ii) {
/* 537 */     if (this.equipData.length != (SETT.ROOMS()).employment.equip.ALL.size() * 3)
/* 538 */       this.equipData = Alloc.ii((SETT.ROOMS()).employment.equip.ALL.size() * 3); 
/* 539 */     return this.equipData[w.index() * 3 + ii];
/*     */   }
/*     */   
/*     */   private void toolISet(RoomEquip w, int ii, int value) {
/* 543 */     if (this.equipData.length != (SETT.ROOMS()).employment.equip.ALL.size() * 3)
/* 544 */       this.equipData = Alloc.ii((SETT.ROOMS()).employment.equip.ALL.size() * 3); 
/* 545 */     this.equipData[w.index() * 3 + ii] = value;
/*     */   }
/*     */   
/*     */   public void reportWalkSeconds(int seconds) {
/* 549 */     if (employed() <= 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 565 */     this.walkSeconds = (float)(this.walkSeconds + seconds / employed());
/* 566 */     this.proxCount = 1;
/*     */   }
/*     */   
/*     */   public double proximity() {
/* 570 */     return this.lastProximity / 100.0D;
/*     */   }
/*     */   
/*     */   public double proximitySoFar() {
/* 574 */     if (this.proxCount == 0)
/* 575 */       return this.lastProximity / 100.0D; 
/* 576 */     return 1.0D - (this.walkSeconds - DIST_AVERAGE_TIME) / TIME.workSeconds();
/*     */   }
/*     */   
/*     */   public void reportFetchSeconds(int seconds) {
/* 580 */     if (employed() <= 0) {
/*     */       return;
/*     */     }
/* 583 */     if (seconds < 61) {
/* 584 */       this.fetchBonus += seconds;
/* 585 */       this.surplousFetch += (61 - seconds);
/* 586 */       seconds = 0;
/*     */     } else {
/* 588 */       double over = (seconds - 61);
/* 589 */       if (over > this.surplousFetch)
/* 590 */         over = this.surplousFetch; 
/* 591 */       if (over > 110.0D)
/* 592 */         over = 110.0D; 
/* 593 */       this.surplousFetch = (float)(this.surplousFetch - over);
/* 594 */       seconds = (int)(seconds - over);
/* 595 */       this.fetchBonus += 61;
/* 596 */       seconds -= 61;
/*     */     } 
/*     */     
/* 599 */     int max = (int)((employed() * TIME.secondsPerDay()) * 0.75D);
/*     */ 
/*     */     
/* 602 */     if (this.fetchBonus >= max) {
/* 603 */       this.fetchBonus = max;
/*     */     }
/* 605 */     this.fetchSeconds = (float)(this.fetchSeconds + seconds / employed());
/* 606 */     this.fetchCount = 1;
/*     */   }
/*     */   
/*     */   public double fetchProximity() {
/* 610 */     return this.lastFetch / 100.0D;
/*     */   }
/*     */   
/*     */   public double fetchProximitySoFar() {
/* 614 */     if (this.fetchCount == 0)
/* 615 */       return this.lastFetch / 100.0D; 
/* 616 */     return 1.0D - this.fetchSeconds / TIME.workSeconds();
/*     */   }
/*     */   
/*     */   public int fetchSecondsPerPerson() {
/* 620 */     if (employed() == 0)
/* 621 */       return 0; 
/* 622 */     return this.fetchBonus / employed();
/*     */   }
/*     */   
/*     */   public int fetchBonus(int time) {
/* 626 */     int extra = time * 4;
/* 627 */     extra = Math.min(extra, this.fetchBonus);
/* 628 */     this.fetchBonus -= extra;
/*     */     
/* 630 */     return (int)(time + extra * 0.8D);
/*     */   }
/*     */   
/*     */   public int fetchBonus() {
/* 634 */     return this.fetchBonus;
/*     */   }
/*     */   
/*     */   public boolean fetchBonusConsume(int seconds) {
/* 638 */     if (seconds <= this.fetchBonus) {
/* 639 */       this.fetchBonus -= seconds;
/* 640 */       return true;
/*     */     } 
/* 642 */     return false;
/*     */   }
/*     */   
/*     */   public double totEfficiency() {
/* 646 */     double d = efficiency() * proximity();
/* 647 */     if (this.ins.blueprintI().employment().countInput())
/* 648 */       d *= fetchProximity(); 
/* 649 */     return d;
/*     */   }
/*     */   
/*     */   public boolean active() {
/* 653 */     return this.active;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmploymentIns.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */