/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.HTYPE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.ShortCoo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIManager
/*     */   extends Humanoid.HumanoidResource
/*     */   implements HAI
/*     */ {
/*  39 */   final long[] longs = new long[AI.data().longCount()];
/*     */   
/*  41 */   private AISTATE state = null;
/*  42 */   private AISUB sub = null;
/*  43 */   private AIPLAN plan = null;
/*  44 */   private AISUB subInter = null;
/*  45 */   private byte stateI = 0;
/*     */ 
/*     */   
/*     */   byte planResumerByte;
/*     */   
/*     */   public byte planByte1;
/*     */   
/*     */   public byte planByte2;
/*     */   
/*     */   public byte planByte3;
/*     */   
/*     */   public byte planByte4;
/*     */   
/*  58 */   public final ShortCoo planTile = new ShortCoo();
/*     */   
/*     */   public int planObject;
/*     */   
/*     */   public float X;
/*     */   public float Y;
/*  64 */   private int otherEntity = -1;
/*  65 */   public float stateTimer = 0.0F;
/*  66 */   public short subPathByte = 0;
/*     */   public byte subPathByte2;
/*  68 */   public byte subByte = 0;
/*     */   
/*  70 */   private byte interType = -1;
/*     */   
/*  72 */   private byte subByteI = 0;
/*  73 */   private short subPathByteI = 0;
/*     */   
/*     */   private byte subPathByte2I;
/*  76 */   private byte resource = -1;
/*  77 */   private byte resourceA = 0;
/*     */   
/*     */   public int lastCollision;
/*     */   
/*  81 */   public final SPath path = new SPath();
/*     */   
/*     */   public AIManager(Humanoid h) {
/*  84 */     setPlan(AI.first().activate(h, this), h);
/*     */   }
/*     */   
/*     */   public AIManager(Humanoid h, FileGetter file) throws IOException {
/*  88 */     this.stateI = file.b();
/*  89 */     this.planResumerByte = file.b();
/*  90 */     this.planByte1 = file.b();
/*  91 */     this.planByte2 = file.b();
/*  92 */     this.planByte3 = file.b();
/*  93 */     this.planByte4 = file.b();
/*  94 */     this.planTile.load(file);
/*  95 */     this.planObject = file.i();
/*  96 */     this.X = file.f();
/*  97 */     this.Y = file.f();
/*  98 */     this.lastCollision = file.i();
/*  99 */     this.otherEntity = file.i();
/* 100 */     this.stateTimer = file.f();
/* 101 */     this.subPathByte2 = file.b();
/* 102 */     this.subByte = file.b();
/* 103 */     this.subPathByte = file.s();
/*     */     
/* 105 */     this.interType = file.b();
/* 106 */     this.subByteI = file.b();
/* 107 */     this.subPathByteI = file.s();
/* 108 */     this.subPathByte2I = file.b();
/*     */     
/* 110 */     this.resource = (byte)RESOURCES.map().loader().loadI(file);
/* 111 */     this.resourceA = file.b();
/* 112 */     if (resourceCarried() == null)
/* 113 */       this.resourceA = 0; 
/* 114 */     this.path.load(file);
/*     */     
/* 116 */     if (!loadAI(file)) {
/* 117 */       setPlan(AI.first().activate(h, this), h);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean loadAI(FileGetter file) throws IOException {
/* 123 */     AI.data().loader().load(this, file);
/* 124 */     AI.AIElement state = AI.load(file.i());
/* 125 */     AI.AIElement sub = AI.load(file.i());
/* 126 */     AI.AIElement plan = AI.load(file.i());
/* 127 */     AI.AIElement subInter = AI.load(file.i());
/*     */     
/* 129 */     if (subInter instanceof AISUB) {
/* 130 */       this.subInter = (AISUB)subInter;
/*     */     }
/*     */     
/* 133 */     if (state != null && sub != null && plan != null && 
/* 134 */       state instanceof AISTATE && sub instanceof AISUB && plan instanceof AIPLAN) {
/* 135 */       this.state = (AISTATE)state;
/* 136 */       this.sub = (AISUB)sub;
/* 137 */       this.plan = (AIPLAN)plan;
/* 138 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 142 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 149 */     file.b(this.stateI);
/* 150 */     file.b(this.planResumerByte);
/* 151 */     file.b(this.planByte1);
/* 152 */     file.b(this.planByte2);
/* 153 */     file.b(this.planByte3);
/* 154 */     file.b(this.planByte4);
/* 155 */     this.planTile.save(file);
/* 156 */     file.i(this.planObject);
/* 157 */     file.f(this.X);
/* 158 */     file.f(this.Y);
/* 159 */     file.i(this.lastCollision);
/* 160 */     file.i(this.otherEntity);
/* 161 */     file.f(this.stateTimer);
/* 162 */     file.b(this.subPathByte2);
/* 163 */     file.b(this.subByte);
/* 164 */     file.s(this.subPathByte);
/*     */     
/* 166 */     file.b(this.interType);
/*     */     
/* 168 */     file.b(this.subByteI);
/* 169 */     file.s(this.subPathByteI);
/* 170 */     file.b(this.subPathByte2I);
/*     */     
/* 172 */     RESOURCES.map().saver().save((MAPPED)resourceCarried(), file);
/* 173 */     file.b(this.resourceA);
/* 174 */     this.path.save(file);
/*     */     
/* 176 */     AI.data().saver().save(this, file);
/* 177 */     file.i(AI.save(this.state));
/* 178 */     file.i(AI.save(this.sub));
/* 179 */     file.i(AI.save(this.plan));
/* 180 */     file.i(AI.save(this.subInter));
/*     */   }
/*     */   
/*     */   private boolean setPlan(AIPLAN.AiPlanActivation p, Humanoid a) {
/* 184 */     if (p == null) {
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     AIPLAN plan = p.plan();
/* 189 */     AISUB.AISubActivation sub = p.sub();
/*     */     
/* 191 */     if (plan == null || sub == null) {
/* 192 */       throw new RuntimeException(String.valueOf(plan) + " " + String.valueOf(plan));
/*     */     }
/*     */     
/* 195 */     this.plan = plan;
/* 196 */     setSub(sub);
/* 197 */     return true;
/*     */   }
/*     */   
/*     */   private boolean setSub(AISUB.AISubActivation s) {
/* 201 */     if (s == null) {
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     this.sub = s.get();
/* 206 */     this.state = s.state();
/* 207 */     if (this.state == null) {
/* 208 */       throw new RuntimeException(this.sub.getClass().getName());
/*     */     }
/* 210 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void interrupt(Humanoid a, HEvent.HEventData event) {
/* 215 */     this.interType = (byte)event.event.ordinal();
/* 216 */     if (this.subInter == null) {
/*     */       
/* 218 */       this.subInter = this.sub;
/* 219 */       this.subByteI = this.subByte;
/* 220 */       this.subPathByteI = this.subPathByte;
/* 221 */       this.subPathByte2I = this.subPathByte2;
/* 222 */       this.sub = null;
/* 223 */       this.state = null;
/*     */     } else {
/* 225 */       this.sub.cancel(a, this);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void overwrite(Humanoid a, AISUB.AISubActivation sub) {
/* 230 */     if (!setSub(sub))
/* 231 */       debug(a, "nono"); 
/*     */   }
/*     */   
/*     */   public void changeType(Humanoid a, HTYPE t, CAUSE_LEAVE leave, CAUSE_ARRIVE arr) {
/* 235 */     AIPLAN plan = (AI.plans()).NOP;
/* 236 */     this.sub.cancel(a, this);
/* 237 */     if (this.subInter != null) {
/* 238 */       this.subByte = this.subByteI;
/* 239 */       this.subPathByte = this.subPathByteI;
/* 240 */       this.subPathByte2 = this.subPathByte2I;
/* 241 */       this.sub = this.subInter;
/* 242 */       this.sub.cancel(a, this);
/*     */     } 
/* 244 */     this.plan.cancel(a, this);
/* 245 */     this.subInter = null;
/* 246 */     this.interType = -1;
/* 247 */     AIPLAN.AiPlanActivation p = plan.activate(a, this);
/*     */     
/* 249 */     AI.modules().cancel(a, this);
/* 250 */     if (!setPlan(p, a)) {
/* 251 */       throw new RuntimeException();
/*     */     }
/* 253 */     HTYPE prev = a.indu().hType();
/* 254 */     a.indu().hTypeSet(a, t, leave, arr);
/* 255 */     AI.modules().init(a, this, prev, t);
/*     */   }
/*     */   
/*     */   public void overwrite(Humanoid a, AIPLAN plan) {
/* 259 */     this.sub.cancel(a, this);
/* 260 */     if (this.subInter != null) {
/* 261 */       this.subByte = this.subByteI;
/* 262 */       this.subPathByte = this.subPathByteI;
/* 263 */       this.subPathByte2 = this.subPathByte2I;
/* 264 */       this.sub = this.subInter;
/* 265 */       this.sub.cancel(a, this);
/*     */     } 
/* 267 */     this.plan.cancel(a, this);
/* 268 */     this.subInter = null;
/* 269 */     this.interType = -1;
/* 270 */     AIPLAN.AiPlanActivation p = plan.activate(a, this);
/*     */     
/* 272 */     if (!setPlan(p, a)) {
/* 273 */       newPlan(a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation resumeOtherPlan(Humanoid a, AIPLAN plan) {
/* 279 */     this.sub.cancel(a, this);
/* 280 */     if (this.subInter != null) {
/* 281 */       this.subByte = this.subByteI;
/* 282 */       this.subPathByte = this.subPathByteI;
/* 283 */       this.subPathByte2 = this.subPathByte2I;
/* 284 */       this.sub = this.subInter;
/* 285 */       this.sub.cancel(a, this);
/*     */     } 
/* 287 */     this.plan.cancel(a, this);
/* 288 */     this.subInter = null;
/* 289 */     this.interType = -1;
/* 290 */     AIPLAN.AiPlanActivation p = plan.activate(a, this);
/* 291 */     if (p == null) {
/* 292 */       p = (AI.plans()).NOP.activate(a, this);
/* 293 */       plan = (AI.plans()).NOP;
/*     */     } 
/* 295 */     AISUB.AISubActivation sub = p.sub();
/* 296 */     this.plan = plan;
/* 297 */     return sub;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE resumeOtherPlanState(Humanoid a, AIPLAN plan) {
/* 302 */     this.sub.cancel(a, this);
/* 303 */     if (this.subInter != null) {
/* 304 */       this.subByte = this.subByteI;
/* 305 */       this.subPathByte = this.subPathByteI;
/* 306 */       this.subPathByte2 = this.subPathByte2I;
/* 307 */       this.sub = this.subInter;
/* 308 */       this.sub.cancel(a, this);
/*     */     } 
/* 310 */     this.plan.cancel(a, this);
/* 311 */     this.subInter = null;
/* 312 */     this.interType = -1;
/* 313 */     AIPLAN.AiPlanActivation p = plan.activate(a, this);
/* 314 */     if (p == null) {
/* 315 */       p = (AI.plans()).NOP.activate(a, this);
/* 316 */       plan = (AI.plans()).NOP;
/*     */     } 
/* 318 */     AISUB.AISubActivation sub = p.sub();
/* 319 */     this.plan = plan;
/* 320 */     this.sub = sub.get();
/* 321 */     this.state = sub.state();
/* 322 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public void overwrite(Humanoid a, AISTATE state) {
/* 327 */     this.state = state;
/* 328 */     if (state == null) {
/* 329 */       throw new RuntimeException();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isInterrupted() {
/* 335 */     return (this.subInter != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, double ds) {
/* 343 */     if (this.state == null) {
/* 344 */       debug(a, "State!");
/*     */     }
/*     */     
/* 347 */     this.state.sprite(a).tick(a, ds);
/*     */ 
/*     */     
/* 350 */     if (this.state.update(a, this, ds)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 356 */     setNextState(a, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, int updateI, boolean newDay) {
/* 365 */     AIModules.update(a, this, newDay, 16, updateI & 0xFF);
/*     */     
/* 367 */     if (this.state == null) {
/* 368 */       debug(a, "State!");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setNextState(Humanoid a, double ds) {
/* 376 */     if (this.stateI != 30) {
/* 377 */       this.stateI = (byte)(this.stateI + 1);
/*     */     }
/* 379 */     if (this.subInter != null) {
/* 380 */       return handleIterruption(a);
/*     */     }
/*     */     
/* 383 */     if (this.sub == null) {
/* 384 */       LOG.ln(this.plan.className + " " + this.plan.className);
/*     */     }
/* 386 */     this.state = this.sub.resume(a, this);
/*     */     
/* 388 */     if (this.plan == null) {
/* 389 */       LOG.err("REMOVE this " + String.valueOf(this.sub.name(a, this)));
/*     */     }
/* 391 */     if (this.state != null) {
/* 392 */       if (this.stateI == 30) {
/* 393 */         this.stateI = 0;
/* 394 */         if (!this.plan.shouldContinue(a, this)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 405 */           this.plan.cancel(a, this);
/* 406 */           this.sub.cancel(a, this);
/* 407 */           resourceDrop(a);
/* 408 */           newPlan(a);
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 413 */       if (this.plan == null) {
/* 414 */         LOG.ln(String.valueOf(this.sub) + " " + String.valueOf(this.sub));
/* 415 */         debug(a, "WHAT?");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 422 */       if (!this.sub.isSuccessful(a, this) || !this.plan.shouldContinue(a, this)) {
/* 423 */         if ((S.get()).developer && (this.plan.notifyIfSubFails() || !this.plan.shouldContinue(a, this)))
/* 424 */           debug(a, "hello  s:" + this.sub.isSuccessful(a, this) + " p:" + this.plan.shouldContinue(a, this)); 
/* 425 */         this.plan.cancel(a, this);
/* 426 */         this.sub.cancel(a, this);
/* 427 */         resourceDrop(a);
/* 428 */         newPlan(a);
/*     */       } else {
/* 430 */         AISUB.AISubActivation s = this.plan.resume(a, this);
/* 431 */         if (!setSub(s)) {
/* 432 */           resourceDrop(a);
/* 433 */           newPlan(a);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 439 */     return true;
/*     */   }
/*     */   
/*     */   private boolean handleIterruption(Humanoid a) {
/* 443 */     this.state = this.sub.resume(a, this);
/* 444 */     if (this.state != null) {
/* 445 */       return true;
/*     */     }
/* 447 */     this.sub = this.subInter;
/*     */     
/* 449 */     this.subInter = null;
/* 450 */     this.subByte = this.subByteI;
/* 451 */     this.subPathByte = this.subPathByteI;
/* 452 */     this.subPathByte2 = this.subPathByte2I;
/* 453 */     byte it = this.interType;
/* 454 */     this.interType = -1;
/* 455 */     this.state = this.sub.resumeInterrupted(a, this, (HEvent)HEvent.all.get(it));
/*     */     
/* 457 */     if (this.state != null) {
/* 458 */       return true;
/*     */     }
/* 460 */     this.sub.cancel(a, this);
/* 461 */     if (setSub(this.plan.resumeFailed(a, this, (HEvent)HEvent.all.get(it)))) {
/* 462 */       return true;
/*     */     }
/* 464 */     this.plan.cancel(a, this);
/* 465 */     this.sub = null;
/* 466 */     newPlan(a);
/* 467 */     return true;
/*     */   }
/*     */   
/*     */   private void newPlan(Humanoid a) {
/* 471 */     setPlan(AI.modules().getNextPlan(a, this), a);
/*     */   }
/*     */   
/*     */   public AIPLAN plan() {
/* 475 */     return this.plan;
/*     */   }
/*     */   
/*     */   public AISUB plansub() {
/* 479 */     return this.sub;
/*     */   }
/*     */   
/*     */   public AISTATE state() {
/* 483 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resourceCarried() {
/* 488 */     if (this.resource >= 0)
/* 489 */       return (RESOURCE)RESOURCES.ALL().get(this.resource); 
/* 490 */     return null;
/*     */   }
/*     */   
/*     */   public void resourceCarriedSet(RESOURCE r) {
/* 494 */     if (r == null) {
/* 495 */       this.resource = -1;
/* 496 */       this.resourceA = 0;
/*     */     }
/* 498 */     else if (this.resource == r.bIndex()) {
/* 499 */       this.resourceA = (byte)(this.resourceA + 1);
/*     */     } else {
/* 501 */       this.resource = r.bIndex();
/* 502 */       this.resourceA = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourceAInc(int a) {
/* 508 */     if (resourceCarried() == null)
/* 509 */       throw new RuntimeException(); 
/* 510 */     this.resourceA = (byte)(this.resourceA + a);
/* 511 */     if (this.resourceA <= 0) {
/* 512 */       this.resource = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public int resourceA() {
/* 517 */     return this.resourceA;
/*     */   }
/*     */   
/*     */   public void resourceDrop(Humanoid a) {
/* 521 */     if (this.resource >= 0 && this.resourceA > 0) {
/* 522 */       (SETT.THINGS()).resources.create(a.physics.tileC(), resourceCarried(), this.resourceA);
/* 523 */       this.resource = -1;
/* 524 */       this.resourceA = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Humanoid otherEntity() {
/* 529 */     ENTITY e = SETT.ENTITIES().getByID(this.otherEntity);
/* 530 */     if (e != null && e instanceof Humanoid)
/* 531 */       return (Humanoid)e; 
/* 532 */     this.otherEntity = -1;
/* 533 */     return null;
/*     */   }
/*     */   
/*     */   public Humanoid otherEntitySet(Humanoid o) {
/* 537 */     if (o == null) {
/* 538 */       this.otherEntity = -1;
/*     */     } else {
/* 540 */       this.otherEntity = o.id();
/* 541 */     }  return o;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a) {
/* 546 */     this.sub.cancel(a, this);
/*     */     
/* 548 */     if (this.subInter != null) {
/* 549 */       this.sub = this.subInter;
/* 550 */       this.subByte = this.subByteI;
/* 551 */       this.subPathByte = this.subPathByteI;
/* 552 */       this.subPathByte2 = this.subPathByte2I;
/* 553 */       this.sub.cancel(a, this);
/* 554 */       this.subInter = null;
/*     */     } 
/*     */     
/* 557 */     this.plan.cancel(a, this);
/* 558 */     this.plan.remove(a, this);
/*     */     
/* 560 */     AI.modules().cancel(a, this);
/* 561 */     resourceDrop(a);
/*     */     
/* 563 */     AIPLAN.AiPlanActivation pa = (AI.plans()).dead.activate(a, this);
/* 564 */     this.plan = pa.plan();
/* 565 */     AISUB.AISubActivation ac = pa.sub();
/* 566 */     this.sub = ac.get();
/* 567 */     this.state = ac.state();
/*     */   }
/*     */   
/*     */   public void muster(Humanoid a) {
/* 571 */     this.sub.cancel(a, this);
/*     */     
/* 573 */     if (this.subInter != null) {
/* 574 */       this.sub = this.subInter;
/* 575 */       this.subByte = this.subByteI;
/* 576 */       this.subPathByte = this.subPathByteI;
/* 577 */       this.subPathByte2 = this.subPathByte2I;
/* 578 */       this.sub.cancel(a, this);
/* 579 */       this.subInter = null;
/*     */     } 
/*     */     
/* 582 */     this.plan.cancel(a, this);
/*     */     
/* 584 */     resourceDrop(a);
/*     */     
/* 586 */     newPlan(a);
/*     */   }
/*     */   
/*     */   public void debug(Humanoid a, CharSequence message) {
/* 590 */     if ((S.get()).developer) {
/* 591 */       GAME.Notify(String.valueOf(debugInfo(Str.TMP.clear().add(message).NL(), a)));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Str debugInfo(Str str, Humanoid a) {
/* 598 */     str.add("id:").s().add(a.id()).s().add(STATS.APPEARANCE().name(a.indu())).s().add('(').add(a.physics.tileC().x()).s().add(a.physics.tileC().y()).add(')');
/* 599 */     str.NL();
/*     */ 
/*     */     
/* 602 */     if (this.plan == null) {
/* 603 */       str.add('?');
/* 604 */       str.NL();
/*     */     } else {
/*     */       
/* 607 */       str.add(this.plan.className).s().s().add(this.planTile.x()).s().add(this.planTile.y());
/* 608 */       str.NL();
/* 609 */       if (this.plan instanceof AIPLAN.PLANRES)
/*     */       {
/* 611 */         str.s(4).add('>').add((((AIPLAN.PLANRES)this.plan).getResumer(this)).className);
/*     */       }
/*     */     } 
/*     */     
/* 615 */     str.NL();
/* 616 */     str.s(4);
/*     */     
/* 618 */     if (this.sub == null) {
/* 619 */       str.add('?');
/*     */     } else {
/* 621 */       str.add(this.sub.className).s().add('(').add(this.subByte).add(')');
/*     */     } 
/*     */ 
/*     */     
/* 625 */     str.NL();
/* 626 */     str.s(8);
/* 627 */     if (this.state == null) {
/* 628 */       str.add('-');
/*     */     } else {
/* 630 */       str.add(this.state.className);
/*     */     } 
/* 632 */     str.NL();
/* 633 */     if (this.interType != -1) {
/* 634 */       str.s().s().add('(').add(((HEvent)HEvent.all.get(this.interType)).name()).add(')');
/*     */     } else {
/* 636 */       str.s().s().add('-');
/*     */     } 
/* 638 */     str.NL();
/* 639 */     str.add('X').add(':').add(((int)this.X >> 6)).s().add('Y').add(':').add(((int)this.Y >> 6));
/* 640 */     str.NL();
/* 641 */     str.add('p').s().add(this.path.toDebugString());
/* 642 */     str.NL();
/* 643 */     str.add('r').s().add(a.isRemoved());
/* 644 */     str.NL();
/* 645 */     str.add('d').s().add(String.valueOf(dead));
/* 646 */     str.NL();
/* 647 */     str.add('r').s().add(String.valueOf(resourceCarried()));
/*     */     
/* 649 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getOccupation(Humanoid a, Str string) {
/* 654 */     if (this.subInter != null) {
/* 655 */       string.add(this.sub.name(a, this));
/*     */     } else {
/* 657 */       plan().name(a, this, string);
/*     */     } 
/*     */   }
/* 660 */   private static final Coo dest = new Coo();
/*     */ 
/*     */   
/*     */   public COORDINATE getDestination() {
/* 664 */     if (!(AI.SUBS()).walkTo.isWalking(this))
/* 665 */       return null; 
/* 666 */     dest.set(this.path.destX(), this.path.destY());
/* 667 */     return (COORDINATE)dest;
/*     */   }
/*     */   
/*     */   public SPath path() {
/* 671 */     return this.path;
/*     */   }
/*     */   
/*     */   public HSprite sprite(Humanoid h) {
/* 675 */     return state().sprite(h);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoSet(Humanoid a, GBox text) {
/* 681 */     if ((S.get()).developer) {
/*     */       
/* 683 */       text.NL();
/* 684 */       text.text((CharSequence)debugInfo((Str)text.text(), a));
/* 685 */       text.NL();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid h, HEvent.HEventData e) {
/* 691 */     if (this.subInter != null) {
/* 692 */       return this.sub.event(h, this, e);
/*     */     }
/* 694 */     return this.plan.event(h, this, e);
/*     */   }
/*     */   
/*     */   public double poll(Humanoid h, HPoll.HPollData e) {
/* 698 */     if (this.subInter != null) {
/* 699 */       return this.sub.poll(h, this, e);
/*     */     }
/* 701 */     return this.plan.poll(h, this, e);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void add(Humanoid h, CAUSE_ARRIVE a) {
/* 706 */     AI.modules().init(h, this, null, h.indu().hType());
/* 707 */     setPlan(AI.first().activate(h, this), h);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIManager.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */