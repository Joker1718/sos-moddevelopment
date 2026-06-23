/*     */ package settlement.entity.humanoid.ai.home;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIData;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIUtilMoveH;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.home.chamber.ChamberInstance;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public final class AIModule_Home
/*     */   extends AIModule
/*     */ {
/*     */   private final AIData.AIDataBit hasHoused;
/*     */   private final AIData.AIDataBit hasSlept;
/*  41 */   private static CharSequence ¤¤name = "relaxing";
/*  42 */   private static CharSequence ¤¤name2 = "Go Home";
/*  43 */   private static CharSequence ¤¤desc = "Spend some time off the bustling street and have a nap. Preferably in a home.";
/*  44 */   private static CharSequence ¤¤curfew = "Staying off the streets";
/*  45 */   private static CharSequence ¤¤ground = "Going to sleep";
/*  46 */   private static CharSequence ¤¤groundS = "Sleeping";
/*     */   
/*     */   static {
/*  49 */     D.ts(AIModule_Home.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int CURFEW_PRIO = 5;
/*  54 */   private final AIPLAN dump = (AIPLAN)new PlanReturn();
/*     */   
/*     */   public AIModule_Home() {
/*  57 */     super((SPRITE)(UI.icons()).s.house, ¤¤name2, ¤¤desc);
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
/* 229 */     this.sleep_noble = (AIPLAN)new AIPLAN.PLANRES("homeNoble")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 234 */           HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 235 */           if (h.is(a.tc().x(), a.tc().y())) {
/* 236 */             if (RND.oneIn(6))
/* 237 */               return this.walk.set(a, d); 
/* 238 */             return this.bed.set(a, d);
/*     */           } 
/* 240 */           return this.first.set(a, d);
/*     */         }
/*     */         
/* 243 */         private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 247 */               return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 252 */               if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 253 */                 if (RND.oneIn(6))
/* 254 */                   return AIModule_Home.null.this.walk.set(a, d); 
/* 255 */                 return AIModule_Home.null.this.bed.set(a, d);
/*     */               } 
/*     */               
/* 258 */               return null;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 264 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 274 */         private final AIPLAN.PLANRES.Resumer walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */           {
/*     */             
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 279 */               if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 280 */                 return (AI.SUBS()).walkTo.room(a, d, (RoomInstance)AIModule_Home.null.this.get(a));
/*     */               }
/* 282 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 287 */               if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 288 */                 if (RND.oneIn(8)) {
/* 289 */                   if (RND.oneIn(3))
/* 290 */                     return AIModule_Home.null.this.bed.set(a, d); 
/* 291 */                   return (AI.SUBS()).walkTo.room(a, d, (RoomInstance)AIModule_Home.null.this.get(a));
/*     */                 } 
/* 293 */                 return (AI.SUBS()).STAND.activateRndDir(a, d, 4);
/*     */               } 
/*     */ 
/*     */               
/* 297 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 302 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 312 */         private final AIPLAN.PLANRES.Resumer bed = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 316 */               d.planByte1 = 8;
/* 317 */               ChamberInstance chamberInstance = AIModule_Home.null.this.get(a);
/* 318 */               int sx = chamberInstance.serviceX();
/* 319 */               int sy = chamberInstance.serviceY();
/* 320 */               return (AI.SUBS()).walkTo.cooFull(a, d, sx, sy);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 325 */               if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && AIModule_Home.null.this.isHome(a, d)) {
/* 326 */                 d.planByte1 = (byte)(d.planByte1 - 1);
/* 327 */                 if (d.planByte1 <= 0)
/* 328 */                   return AIModule_Home.null.this.walk.set(a, d); 
/* 329 */                 return AIModule_Home.null.this.sleepBed(a, d);
/*     */               } 
/*     */               
/* 332 */               return null;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 338 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         private AISUB.AISubActivation sleepBed(Humanoid a, AIManager d) {
/* 349 */           d.planTile.set(d.path.destX(), d.path.destY());
/* 350 */           int tx = d.planTile.x();
/* 351 */           int ty = d.planTile.y();
/* 352 */           int cx = (SETT.ROOMS()).CHAMBER.getSleepPixelX(tx, ty);
/* 353 */           int cy = (SETT.ROOMS()).CHAMBER.getSleepPixelY(tx, ty);
/* 354 */           a.physics.body().moveC(cx, cy);
/* 355 */           a.speed.setRaw((SETT.ROOMS()).CHAMBER.getSleepDir(tx, ty), 0.0D);
/* 356 */           return (AI.SUBS()).subSleep.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         private boolean isHome(Humanoid a, AIManager d) {
/* 361 */           ChamberInstance h = get(a);
/* 362 */           return (h != null && h.is(a.tc()));
/*     */         }
/*     */         
/*     */         private ChamberInstance get(Humanoid a) {
/* 366 */           HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 367 */           if (h != null && 
/* 368 */             h instanceof ChamberInstance) {
/* 369 */             return (ChamberInstance)h;
/*     */           }
/* 371 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 376 */           if (STATS.LAW().getCurfew().is()) {
/* 377 */             string.add(AIModule_Home.¤¤curfew);
/*     */           } else {
/* 379 */             string.add(AIModule_Home.¤¤name);
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 384 */     this.sleep_home = (AIPLAN)new AIPLAN.PLANRES("home")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 388 */           d.planByte2 = 4;
/* 389 */           HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 390 */           if (h.is(a.tc().x(), a.tc().y())) {
/* 391 */             return this.use.set(a, d);
/*     */           }
/* 393 */           return this.walk.set(a, d);
/*     */         }
/*     */         
/* 396 */         private final AIPLAN.PLANRES.Resumer walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 400 */               return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 405 */               return AIModule_Home.null.this.use.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 410 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/* 419 */         private final AIPLAN.PLANRES.Resumer use = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 423 */               d.planByte2 = 5;
/* 424 */               HomeInstance h = AIModule_Home.null.this.get(a);
/* 425 */               if (h == null)
/* 426 */                 return null; 
/* 427 */               if (!h.is(a.tc())) {
/* 428 */                 int sx = h.serviceX();
/* 429 */                 int sy = h.serviceY();
/* 430 */                 return (AI.SUBS()).walkTo.cooFull(a, d, sx, sy);
/*     */               } 
/* 432 */               h.use();
/* 433 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 440 */               if (AIModule_Home.null.this.shouldRes(a, d) && AIModule_Home.null.access$0(AIModule_Home.null.this).getPriority(a, d) > 0) {
/* 441 */                 AISUB.AISubActivation s = null;
/* 442 */                 switch (RND.rInt(4)) {
/*     */                   case 0:
/* 444 */                     s = AIModule_Home.null.this.bed.set(a, d);
/*     */                     break;
/*     */                   case 1:
/* 447 */                     s = AIModule_Home.null.this.move.set(a, d);
/*     */                     break;
/*     */                 } 
/*     */                 
/* 451 */                 if (s != null) {
/* 452 */                   return s;
/*     */                 }
/* 454 */                 if (!SETT.ENTITIES().hasAtTileHigher((ENTITY)a, a.tc().x(), a.tc().y())) {
/* 455 */                   return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */                 }
/* 457 */                 HomeInstance h = AIModule_Home.null.this.get(a);
/* 458 */                 for (DIR dir : DIR.ORTHO) {
/* 459 */                   if (h.is(a.tc(), dir) && !(SETT.PATH()).solidity.is(a.tc(), dir)) {
/* 460 */                     return (AI.SUBS()).walkTo.cooFull(a, d, a.tc().x() + dir.x(), a.tc().y() + dir.y());
/*     */                   }
/*     */                 } 
/* 463 */                 return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */               } 
/* 465 */               can(a, d);
/* 466 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 471 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 481 */               if (e.type == HPoll.CAN_INTERRACT)
/* 482 */                 return 1.0D; 
/* 483 */               return super.poll(a, d, e);
/*     */             }
/*     */           };
/*     */         
/* 487 */         private final AIPLAN.PLANRES.Resumer bed = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 491 */               HomeInstance h = AIModule_Home.null.this.get(a);
/* 492 */               HomeInstance.DirCoo c = h.findService(a);
/*     */               
/* 494 */               if (c == null)
/* 495 */                 return (AI.SUBS()).STAND.activateRndDir(a, d); 
/* 496 */               d.planTile.set((COORDINATE)c);
/* 497 */               d.planByte1 = (byte)(8 + RND.rInt(2));
/* 498 */               AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)c);
/* 499 */               if (s != null) {
/* 500 */                 return s;
/*     */               }
/*     */               
/* 503 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 508 */               if (AIModule_Home.null.this.shouldRes(a, d)) {
/*     */ 
/*     */                 
/* 511 */                 d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 <= 0) {
/* 512 */                   AIModule_Home.null.this.moveOK(a, d);
/* 513 */                   return AIModule_Home.null.this.use.set(a, d);
/*     */                 } 
/* 515 */                 HomeInstance h = AIModule_Home.null.this.get(a);
/* 516 */                 HomeInstance.DirCoo c = h.getService(d.planTile.x(), d.planTile.y());
/* 517 */                 if (c == null) {
/* 518 */                   can(a, d);
/* 519 */                   return null;
/*     */                 } 
/*     */                 
/* 522 */                 AIUtilMoveH.moveToTile(a, c.x(), c.y(), c.isLay ? c.dir : DIR.C);
/*     */                 
/* 524 */                 a.speed.setDirCurrent(c.dir);
/*     */                 
/* 526 */                 if (c.isLay && (a.race()).physics.sleeps) {
/* 527 */                   return (AI.SUBS()).subSleep.activate(a, d);
/*     */                 }
/* 529 */                 return (AI.SUBS()).STAND.activateTime(a, d, 8);
/*     */               } 
/* 531 */               can(a, d);
/* 532 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 537 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/* 542 */               AIModule_Home.null.this.moveOK(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 547 */               if (e.event == HEvent.COLLISION_UNREACHABLE)
/* 548 */                 return false; 
/* 549 */               return super.event(a, d, e);
/*     */             }
/*     */           };
/*     */         
/* 553 */         private final AIPLAN.PLANRES.Resumer move = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 557 */               HomeInstance h = AIModule_Home.null.this.get(a);
/* 558 */               for (DIR dir : DIR.ORTHO) {
/* 559 */                 if (h.is(a.tc(), dir) && !(SETT.PATH()).solidity.is(a.tc(), dir) && !SETT.ENTITIES().hasAtTile(a.tc().x() + dir.x(), a.tc().y() + dir.y())) {
/* 560 */                   return (AI.SUBS()).walkTo.cooFull(a, d, a.tc().x() + dir.x(), a.tc().y() + dir.y());
/*     */                 }
/*     */               } 
/* 563 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 568 */               if (AIModule_Home.null.this.shouldRes(a, d)) {
/* 569 */                 if (RND.oneIn(8)) {
/* 570 */                   return AIModule_Home.null.this.use.set(a, d);
/*     */                 }
/* 572 */                 return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */               } 
/* 574 */               can(a, d);
/* 575 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 580 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private boolean shouldRes(Humanoid a, AIManager d) {
/* 594 */           if (!isHome(a, d))
/* 595 */             return false; 
/* 596 */           if (!AIModule_Home.this.moduleCanContinue(a, d)) {
/* 597 */             return false;
/*     */           }
/* 599 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         private void moveOK(Humanoid a, AIManager d) {
/* 605 */           if ((SETT.PATH()).solidity.is(a.tc())) {
/* 606 */             AIUtilMoveH.unfuck(a);
/*     */           }
/*     */         }
/*     */         
/*     */         private boolean isHome(Humanoid a, AIManager d) {
/* 611 */           HomeInstance h = get(a);
/* 612 */           if (h != null) {
/* 613 */             boolean ret = h.is(a.tc());
/*     */             
/* 615 */             return ret;
/*     */           } 
/* 617 */           return false;
/*     */         }
/*     */         
/*     */         private HomeInstance get(Humanoid a) {
/* 621 */           HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 622 */           if (h != null && h instanceof HomeInstance)
/* 623 */             return (HomeInstance)h; 
/* 624 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 629 */           if (STATS.LAW().getCurfew().is()) {
/* 630 */             string.add(AIModule_Home.¤¤curfew);
/*     */           } else {
/* 632 */             string.add(AIModule_Home.¤¤name);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 638 */     this.sleep_groud = (AIPLAN)new AIPLAN.PLANRES("homeGround")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 642 */           STATS.HOME().dump(a);
/* 643 */           return this.findBed.set(a, d);
/*     */         }
/*     */         
/* 646 */         private final AIPLAN.PLANRES.Resumer findBed = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤ground)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 650 */               FINDABLE f = (SETT.PATH()).finders.indoor.getReservable(a.tc().x(), a.tc().y());
/* 651 */               d.planByte2 = 0;
/* 652 */               if (f != null) {
/* 653 */                 d.planTile.set(a.tc());
/* 654 */                 f.findableReserve();
/* 655 */                 d.planByte2 = 1;
/* 656 */                 return AIModule_Home.null.this.exit.set(a, d);
/*     */               } 
/* 658 */               int dist = STATS.LAW().getCurfew().is() ? 256 : 64;
/* 659 */               AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.PATH()).finders.indoor, dist);
/*     */               
/* 661 */               if (s == null && a.inWater) {
/* 662 */                 (SETT.PATH()).finders.water.findLand(a.physics.tileC(), d.path, 16);
/* 663 */                 if (d.path.isSuccessful()) {
/* 664 */                   d.planTile.set(-1.0D, -1.0D);
/* 665 */                   s = (AI.SUBS()).walkTo.path(a, d);
/*     */                 } 
/*     */               } 
/*     */               
/* 669 */               if (s != null) {
/* 670 */                 d.planTile.set(d.path.destX(), d.path.destY());
/* 671 */                 d.planByte2 = 1;
/* 672 */                 return s;
/*     */               } 
/* 674 */               return AIModule_Home.null.this.exit.set(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 680 */               return AIModule_Home.null.this.exit.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 685 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/* 690 */               if (d.planByte2 == 1) {
/* 691 */                 FINDABLE f = (SETT.PATH()).finders.indoor.getReserved(d.planTile.x(), d.planTile.y());
/* 692 */                 if (f != null)
/* 693 */                   f.findableReserveCancel(); 
/* 694 */                 d.planByte2 = 0;
/*     */               } 
/*     */             }
/*     */           };
/*     */         
/* 699 */         private final AIPLAN.PLANRES.Resumer exit = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤groundS)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 703 */               d.planByte1 = (byte)(5 + RND.rInt(5));
/* 704 */               if (STATS.LAW().getCurfew().is())
/* 705 */                 return (AI.SUBS()).STAND.activateRndDir(a, d); 
/* 706 */               return (AI.SUBS()).subSleep.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 711 */               d.planByte1 = (byte)(d.planByte1 - 1); if (AIModule_Home.null.access$0(AIModule_Home.null.this).moduleCanContinue(a, d) && d.planByte1 > 0) {
/* 712 */                 if (d.plansub() == (AI.SUBS()).subSleep) {
/* 713 */                   if (RND.oneIn(8))
/* 714 */                     return (AI.SUBS()).STAND.activateRndDir(a, d); 
/* 715 */                   return (AI.SUBS()).subSleep.activate(a, d);
/*     */                 } 
/*     */                 
/* 718 */                 if (!RND.oneIn(7) && !STATS.LAW().getCurfew().is()) {
/* 719 */                   return (AI.SUBS()).subSleep.activate(a, d);
/*     */                 }
/* 721 */                 return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */               } 
/*     */ 
/*     */               
/* 725 */               can(a, d);
/* 726 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 731 */               return true;
/*     */             }
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {
/* 736 */               if (d.planByte2 == 1) {
/* 737 */                 FINDABLE f = (SETT.PATH()).finders.indoor.getReserved(d.planTile.x(), d.planTile.y());
/* 738 */                 if (f != null)
/* 739 */                   f.findableReserveCancel(); 
/* 740 */                 d.planByte2 = 0;
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 746 */               if (e.type == HPoll.CAN_INTERRACT)
/* 747 */                 return (d.plansub() == (AI.SUBS()).STAND) ? 1.0D : 0.0D; 
/* 748 */               return super.poll(a, d, e);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 754 */           if (STATS.LAW().getCurfew().is() || (SETT.PATH()).finders.otherHumanoid.enemiesAreNear(a)) {
/* 755 */             string.add(AIModule_Home.¤¤curfew);
/*     */           } else {
/* 757 */             string.add(AIModule_Home.¤¤name);
/*     */           } 
/*     */         }
/*     */       };
/*     */     AI.data().getClass();
/*     */     this.hasHoused = new AIData.AIDataBit(AI.data(), "home");
/*     */     AI.data().getClass();
/*     */     this.hasSlept = new AIData.AIDataBit(AI.data(), "sleep");
/*     */   }
/*     */   
/*     */   private final AIPLAN sleep_noble;
/*     */   private final AIPLAN sleep_home;
/*     */   private final AIPLAN sleep_groud;
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     this.hasHoused.set(d, true);
/*     */     (STATS.HOME()).GETTER.hasSearched.indu().set(a.indu(), 0);
/*     */     if (a.indu().clas() == HCLASSES.NOBLE()) {
/*     */       ChamberInstance chamberInstance;
/*     */       HOME h = (STATS.HOME()).GETTER.get(a, this);
/*     */       if (h != null && !(h instanceof ChamberInstance))
/*     */         (STATS.HOME()).GETTER.set(a, null); 
/*     */       if (h == null)
/*     */         for (int i = 0; i < (SETT.ROOMS()).CHAMBER.instancesSize(); i++) {
/*     */           ChamberInstance c = (ChamberInstance)(SETT.ROOMS()).CHAMBER.getInstance(i);
/*     */           if (c.canOccupy(a)) {
/*     */             chamberInstance = c;
/*     */             (STATS.HOME()).GETTER.set(a, (HOME)chamberInstance);
/*     */           } 
/*     */         }  
/*     */       if (chamberInstance != null) {
/*     */         if (chamberInstance.is(a.tc().x(), a.tc().y())) {
/*     */           AIPLAN.AiPlanActivation aiPlanActivation1 = this.dump.activate(a, d);
/*     */           if (aiPlanActivation1 != null)
/*     */             return aiPlanActivation1; 
/*     */           return this.sleep_noble.activate(a, d);
/*     */         } 
/*     */         d.path.request(a.tc().x(), a.tc().y(), chamberInstance.serviceX(), chamberInstance.serviceY(), true);
/*     */         if (d.path.isSuccessful())
/*     */           return this.sleep_noble.activate(a, d); 
/*     */       } 
/*     */       (STATS.HOME()).GETTER.set(a, null);
/*     */       (STATS.HOME()).GETTER.hasSearched.indu().set(a.indu(), 1);
/*     */       AIPLAN.AiPlanActivation aiPlanActivation = this.dump.activate(a, d);
/*     */       if (aiPlanActivation != null)
/*     */         return aiPlanActivation; 
/*     */       if (!this.hasSlept.is(d)) {
/*     */         this.hasSlept.set(d, true);
/*     */         return this.sleep_groud.activate(a, d);
/*     */       } 
/*     */       return null;
/*     */     } 
/*     */     if ((STATS.HOME()).GETTER.has(a)) {
/*     */       HOME h = (STATS.HOME()).GETTER.get(a, this);
/*     */       if (h.is(a.tc().x(), a.tc().y())) {
/*     */         AIPLAN.AiPlanActivation aiPlanActivation = this.dump.activate(a, d);
/*     */         if (aiPlanActivation != null)
/*     */           return aiPlanActivation; 
/*     */         if (h instanceof HomeInstance)
/*     */           return this.sleep_home.activate(a, d); 
/*     */         throw new RuntimeException(String.valueOf(h));
/*     */       } 
/*     */     } 
/*     */     if ((SETT.PATH().finders()).home.findHome(a, d.path)) {
/*     */       HOME h = (STATS.HOME()).GETTER.get(a, this);
/*     */       if (h instanceof HomeInstance)
/*     */         return this.sleep_home.activate(a, d); 
/*     */       throw new RuntimeException(String.valueOf(h));
/*     */     } 
/*     */     if ((STATS.HOME()).GETTER.has(a)) {
/*     */       HOME h = (STATS.HOME()).GETTER.get(a, this);
/*     */       int sx = h.serviceX();
/*     */       int sy = h.serviceY();
/*     */       if (!(SETT.PATH()).reachability.is(sx, sy))
/*     */         LOG.ln("" + sx + " " + sx); 
/*     */       (STATS.HOME()).GETTER.set(a, null);
/*     */     } 
/*     */     (STATS.HOME()).GETTER.hasSearched.indu().set(a.indu(), 1);
/*     */     AIPLAN.AiPlanActivation p = this.dump.activate(a, d);
/*     */     if (p != null)
/*     */       return p; 
/*     */     if (!this.hasSlept.is(d)) {
/*     */       this.hasSlept.set(d, true);
/*     */       return this.sleep_groud.activate(a, d);
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {
/*     */     if (AIModules.current(d) == this)
/*     */       return; 
/*     */     if (newDay)
/*     */       this.hasSlept.set(d, false); 
/*     */     if (newDay || ((upI & 0x3) == 0 && !(STATS.HOME()).GETTER.has(a) && (STATS.HOME()).GETTER.hasSearched.indu().get(a.indu()) == 1))
/*     */       this.hasHoused.set(d, false); 
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     if ((SETT.PATH()).finders.otherHumanoid.enemiesAreNear(a))
/*     */       return 7; 
/*     */     if (STATS.LAW().getCurfew().is())
/*     */       return 6; 
/*     */     if ((STATS.HOME()).GETTER.has(a)) {
/*     */       boolean homeSitter = false;
/*     */       if (TIME.light().dayIs()) {
/*     */         homeSitter = (((STATS.POP()).age.AGE_DAYS.indu().get(a.indu()) & 0x3) != 0);
/*     */       } else {
/*     */         homeSitter = (((STATS.POP()).age.AGE_DAYS.indu().get(a.indu()) & 0x1) == 0);
/*     */       } 
/*     */       if (AIModules.current(d) == this && homeSitter)
/*     */         return 1; 
/*     */       HOME h = (STATS.HOME()).GETTER.get(a, this);
/*     */       if (homeSitter && h.is(a.tc().x(), a.tc().y()))
/*     */         return 1; 
/*     */       if (!this.hasHoused.is(d))
/*     */         return 1; 
/*     */       if ((STATS.RAN().get(a.indu(), 27) + TIME.days().bitsSinceStart() & 0x1) == 1 && MATH.distance(TIME.hours().bitCurrent(), a.getNewDayHour(), TIME.hoursPerDay()) > 3)
/*     */         return 1; 
/*     */       return 0;
/*     */     } 
/*     */     if (!this.hasHoused.is(d))
/*     */       return ((STATS.HOME()).GETTER.hasSearched.indu().get(a.indu()) == 1) ? 7 : 1; 
/*     */     if ((STATS.WORK()).EMPLOYED.get(a) == null && a.indu().clas() != HCLASSES.NOBLE() && (SETT.ROOMS()).HOME.odd.has(a))
/*     */       return 1; 
/*     */     return 0;
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a) {
/*     */     return getPriority(a, (AIManager)a.ai());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\home\AIModule_Home.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */