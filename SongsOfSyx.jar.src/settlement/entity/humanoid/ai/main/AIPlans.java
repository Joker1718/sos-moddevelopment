/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIPlans
/*     */ {
/*  26 */   private static CharSequence ¤¤swimming = "¤Swimming";
/*  27 */   private static CharSequence ¤¤trapped = "¤Cut off from the throne";
/*  28 */   private static CharSequence ¤¤WalkingToCentre = "¤Walking to the center of the city";
/*  29 */   private static CharSequence ¤¤Fleeing = "¤Fleeing";
/*  30 */   private static CharSequence ¤¤uncons = "¤Unconscious";
/*     */   
/*     */   static {
/*  33 */     D.ts(AIPlans.class);
/*     */   }
/*     */ 
/*     */   
/*  37 */   public final AIPLAN unreachable = new AIPLAN.PLANRES("planUnreach")
/*     */     {
/*     */       
/*     */       public AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */       {
/*  42 */         if ((NEEDS.TYPES()).HUNGER.stat().stat().indu().isMax(a.indu())) {
/*  43 */           AIManager.dead = CAUSE_LEAVES.STARVED();
/*     */         }
/*  45 */         if ((SETT.PATH().finders()).reachable.find(a.tc(), d.path, 8)) {
/*  46 */           return this.path.set(a, d);
/*     */         }
/*     */         
/*  49 */         (STATS.POP()).TRAPPED.indu().set(a.indu(), 1);
/*  50 */         if (a.division() != null) {
/*  51 */           (a.division()).reporter.reportReachable(a, false);
/*     */         }
/*  53 */         if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc())) {
/*  54 */           return this.drowning.set(a, d);
/*     */         }
/*  56 */         return this.start.set(a, d);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  62 */       private final AIPLAN.PLANRES.Resumer path = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤trapped)
/*     */         {
/*     */           public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/*  66 */             return (AI.SUBS()).walkTo.path(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  71 */             if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc()))
/*  72 */               return AIPlans.null.this.drowning.set(a, d); 
/*  73 */             if (!(SETT.PATH()).connectivity.is(a.physics.tileC()))
/*  74 */               AIManager.dead = CAUSE_LEAVES.DROWNED(); 
/*  75 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/*  80 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */       
/*  89 */       private final AIPLAN.PLANRES.Resumer drowning = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤swimming)
/*     */         {
/*  91 */           private AISUB sub = new AISUB.Simple("UNR_DROWN")
/*     */             {
/*     */ 
/*     */ 
/*     */               
/*     */               public AISTATE resume(Humanoid a, AIManager d)
/*     */               {
/*  98 */                 if (d.subByte > 20 && RND.oneIn(3)) {
/*  99 */                   return null;
/*     */                 }
/* 101 */                 d.subByte = (byte)(d.subByte + 1);
/*     */                 
/* 103 */                 return (AI.STATES()).STAND.aDirRND(a, d, (float)(0.2D + RND.rFloat(0.3D)));
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 109 */             return this.sub.activate(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 114 */             AIManager.dead = CAUSE_LEAVES.DROWNED();
/* 115 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 120 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 131 */       private AISUB sub = new AISUB.Simple("UNR_DROWN2")
/*     */         {
/*     */           public AISTATE resume(Humanoid a, AIManager d)
/*     */           {
/* 135 */             d.subByte = (byte)(d.subByte + 1);
/* 136 */             if (d.subByte != 1)
/* 137 */               return null; 
/* 138 */             for (int di = 0; di < DIR.ALL.size(); di++) {
/* 139 */               DIR dir = (DIR)DIR.ALL.get(di);
/* 140 */               if ((SETT.PATH()).connectivity.is(a.tc(), dir)) {
/* 141 */                 if (!dir.isOrtho() && 
/* 142 */                   !((SETT.PATH()).availability.get(a.tc().x() + dir.x(), a.tc().y())).tileCollide && 
/* 143 */                   !((SETT.PATH()).availability.get(a.tc().x(), a.tc().y() + dir.y())).tileCollide)
/* 144 */                   return (AI.STATES()).WALK2.dirTile(a, d, dir); 
/* 145 */                 if (dir.isOrtho() && !((SETT.PATH()).availability.get(a.tc().x() + dir.x(), a.tc().y() + dir.y())).tileCollide) {
/* 146 */                   return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/* 151 */             switch (RND.rInt(3)) { case 0:
/* 152 */                 return (AI.STATES()).STAND.activate(a, d, (0.5F + RND.rFloat(5.0D)));
/* 153 */               case 1: return (AI.STATES()).anima.wave.activate(a, d, (0.5F + RND.rFloat(5.0D))); }
/*     */             
/* 155 */             if (a.division() != null) {
/* 156 */               a.setDivision(null);
/*     */             }
/*     */             
/* 159 */             if (a.indu().hType().isHostile())
/* 160 */               (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1); 
/* 161 */             return (AI.STATES()).anima.box.activate(a, d, (0.5F + RND.rFloat(5.0D)));
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 166 */       private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤trapped)
/*     */         {
/*     */           public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 170 */             d.planByte1 = 0;
/* 171 */             return (AI.SUBS()).STAND.activate(a, d);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 177 */             d.planByte1 = (byte)(d.planByte1 + 1);
/* 178 */             if (d.planByte1 > 5)
/* 179 */               return null; 
/* 180 */             if ((SETT.PATH()).connectivity.is(a.physics.tileC()))
/*     */             {
/*     */ 
/*     */               
/* 184 */               return null;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 189 */             return AIPlans.null.this.sub.activate(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 194 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*     */       protected void cancel(Humanoid a, AIManager d) {
/* 206 */         super.cancel(a, d);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 212 */   public final AIPLAN NOP = new AIPLAN.PLANRES("planNop")
/*     */     {
/*     */       
/* 215 */       private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, "")
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 219 */             return (AI.SUBS()).STAND.activateTime(a, d, 0);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 224 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 229 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*     */       protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 240 */         return this.start.set(a, d);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 245 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 250 */         return 0.0D;
/*     */       }
/*     */     };
/*     */   
/* 254 */   public final AIPLAN KNOCKED_OUT = new AIPLAN.PLANRES("planKnockedOut")
/*     */     {
/*     */       
/* 257 */       private final AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤uncons)
/*     */         {
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 261 */             return (AI.SUBS()).LAY.activateTime(a, d, 10);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 266 */             return (AI.SUBS()).LAY.activateTime(a, d, 10);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 271 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*     */       protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 282 */         return this.start.set(a, d);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 287 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 292 */         return 0.0D;
/*     */       }
/*     */     };
/*     */   
/* 296 */   final AIPLAN dead = new AIPLAN.PLANRES("planDead")
/*     */     {
/* 298 */       private final AISUB dead = new AISUB.Simple("plandead")
/*     */         {
/*     */           public AISTATE resume(Humanoid a, AIManager d)
/*     */           {
/* 302 */             return (AI.STATES()).layStop.activate(a, d, 100.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 307 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 312 */             return 0.0D;
/*     */           }
/*     */         };
/*     */       
/* 316 */       final AIPLAN.PLANRES.Resumer r = new AIPLAN.PLANRES.Resumer(this, "dead")
/*     */         {
/*     */           public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 320 */             return AIPlans.null.this.dead.activate(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 325 */             return AIPlans.null.this.dead.activate(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 330 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*     */       public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 342 */         return this.r.set(a, d);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 347 */   private final AIPLAN deadWhenStill = new AIPLAN.PLANRES("planDeadWhenStil")
/*     */     {
/* 349 */       private final AISUB dead = new AISUB.Simple("planDeadWhenStil")
/*     */         {
/*     */           public AISTATE resume(Humanoid a, AIManager d)
/*     */           {
/* 353 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 358 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 363 */             return 0.0D;
/*     */           }
/*     */         };
/*     */       
/* 367 */       final AIPLAN.PLANRES.Resumer r = new AIPLAN.PLANRES.Resumer(this, "dead")
/*     */         {
/*     */           public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 371 */             return AISUB.AISubActivation.make(AIPlans.null.this.dead, (AI.STATES()).layStop.activate(a, d, 0.5D));
/*     */           }
/*     */ 
/*     */           
/*     */           public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 376 */             if (a.speed.isZero()) {
/* 377 */               AIManager.dead = (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(d.subByte);
/*     */             }
/* 379 */             return AISUB.AISubActivation.make(AIPlans.null.this.dead, (AI.STATES()).layStop.activate(a, d, 0.5D));
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 384 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */       
/*     */       public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 396 */         return this.r.set(a, d);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation deadWhenStill(Humanoid a, AIManager d, CAUSE_LEAVE l, boolean gore) {
/* 402 */     d.subByte = (byte)l.index();
/* 403 */     return this.deadWhenStill.activate(a, d);
/*     */   }
/*     */   
/* 406 */   final AIPLAN GoToThrone = new AIPLAN.PLANRES("planGoThrone")
/*     */     {
/* 408 */       final AIPLAN.PLANRES.Resumer go = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤WalkingToCentre)
/*     */         {
/*     */           public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */           {
/* 412 */             if (a.physics.tileC().tileDistanceTo(THRONE.coo()) < 30.0D)
/* 413 */               return (AI.SUBS()).STAND.activate(a, d); 
/* 414 */             COORDINATE c = (SETT.PATH()).finders.arround.find(THRONE.coo().x(), THRONE.coo().y(), 5.0D, 20.0D);
/* 415 */             if (c == null)
/* 416 */               return (AI.SUBS()).STAND.activate(a, d); 
/* 417 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, c);
/* 418 */             return AIPlans.null.trySub(a, d, s, null);
/*     */           }
/*     */ 
/*     */           
/*     */           public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 423 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 428 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 441 */         return this.go.set(a, d);
/*     */       }
/*     */     };
/*     */   
/* 445 */   final AIPLAN runToSafety = new AIPLAN.PLANRES("planToSafty")
/*     */     {
/*     */       protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */       {
/* 449 */         return this.pathing.set(a, d);
/*     */       }
/*     */       
/* 452 */       private final AIPLAN.PLANRES.Resumer pathing = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤Fleeing)
/*     */         {
/*     */           public boolean event(Humanoid a, AIManager d, HEvent.HEventData e)
/*     */           {
/* 456 */             if (e.event == HEvent.COLLISION_SOFT) {
/* 457 */               int ri = RND.rInt(DIR.ORTHO.size());
/* 458 */               for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 459 */                 DIR dd = (DIR)DIR.ORTHO.getC(ri + i);
/* 460 */                 if ((SETT.PATH()).cost.get(a.tc().x(), a.tc().y(), dd) > 0.0D) {
/* 461 */                   a.speed.turn2(dd);
/* 462 */                   return true;
/*     */                 } 
/*     */               } 
/* 465 */               a.speed.turn2(-e.norX, -e.norY);
/* 466 */               d.overwrite(a, AIPlans.null.this.run.set(a, d));
/* 467 */               return true;
/* 468 */             }  if (e.event == HEvent.MEET_ENEMY)
/* 469 */             { a.speed.turn2(-e.norX, -e.norY);
/* 470 */               d.overwrite(a, AIPlans.null.this.run.set(a, d)); }
/* 471 */             else { if (e.event == HEvent.COLLISION_TILE) {
/* 472 */                 d.overwrite(a, AIPlans.null.this.run.set(a, d));
/* 473 */                 d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/* 474 */                 return true;
/* 475 */               }  if (e.event == HEvent.EXHAUST)
/* 476 */                 return super.event(a, d, e); 
/* 477 */               if (e.event == HEvent.COLLISION_HARD)
/* 478 */                 return super.event(a, d, e);  }
/*     */             
/* 480 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 485 */             if ((SETT.PATH()).finders.entity.findSafety(a, a.physics.tileC().x(), a.physics.tileC().y(), d.path, 100)) {
/* 486 */               return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */             }
/* 488 */             a.speed.turnWithAngel(RND.rFloat0(90.0D));
/*     */             
/* 490 */             return AIPlans.null.this.run.set(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 495 */             if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 1)
/* 496 */               return null; 
/* 497 */             if (GAME.ARMIES().enemy().men() > 0) {
/* 498 */               a.speed.turnWithAngel(RND.rInt0(90));
/* 499 */               return (AI.SUBS()).STAND.activateTime(a, d, 3 + RND.rInt(3));
/*     */             } 
/*     */             
/* 502 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 507 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */         };
/*     */ 
/*     */       
/* 517 */       private final AIPLAN.PLANRES.Resumer run = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤Fleeing)
/*     */         {
/* 519 */           private final AISUB sub = new AISUB.Simple("PlansFlee")
/*     */             {
/*     */               protected AISTATE resume(Humanoid a, AIManager d)
/*     */               {
/* 523 */                 d.planByte1 = (byte)(d.planByte1 - 1);
/*     */                 
/* 525 */                 if (d.planByte1 > 0)
/* 526 */                   return (AI.STATES()).RUN.activate(a, d, (4.0F + RND.rFloat() * 3.0F)); 
/* 527 */                 return null;
/*     */               }
/*     */ 
/*     */               
/*     */               protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 532 */                 if (d.planByte1 == 0)
/* 533 */                   return null; 
/* 534 */                 d.planByte1 = 0;
/* 535 */                 return (AI.STATES()).RUN.activate(a, d, (4.0F + RND.rFloat() * 3.0F));
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 541 */             d.planByte2 = (byte)(2 + RND.rInt(5));
/* 542 */             d.planByte1 = (byte)(2 + RND.rInt(5));
/* 543 */             return this.sub.activate(a, d);
/*     */           }
/*     */ 
/*     */           
/*     */           protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 548 */             if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 1)
/* 549 */               return null; 
/* 550 */             if (GAME.ARMIES().enemy().men() > 0) {
/* 551 */               return AIPlans.null.this.pathing.set(a, d);
/*     */             }
/* 553 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean con(Humanoid a, AIManager d) {
/* 558 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 569 */             return super.poll(a, d, e);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 574 */             if (e.event == HEvent.COLLISION_SOFT) {
/* 575 */               int ri = RND.rInt(DIR.ORTHO.size());
/* 576 */               for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 577 */                 DIR dd = (DIR)DIR.ORTHO.getC(ri + i);
/* 578 */                 if (SETT.IN_BOUNDS(a.tc(), dd) && (SETT.PATH()).cost.get(a.tc().x(), a.tc().y(), dd) > 0.0D) {
/* 579 */                   a.speed.turn2(dd);
/* 580 */                   d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/*     */                 } 
/*     */               } 
/* 583 */               a.speed.turn2(-e.norX, -e.norY);
/* 584 */               d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/* 585 */               return true;
/* 586 */             }  if (e.event == HEvent.MEET_ENEMY)
/* 587 */             { a.speed.turn2(-e.norX, -e.norY);
/* 588 */               d.overwrite(a, (AI.STATES()).STOP.activate(a, d)); }
/* 589 */             else { if (e.event == HEvent.COLLISION_TILE) {
/* 590 */                 d.planByte2 = (byte)(d.planByte2 - 1);
/* 591 */                 if (d.planByte2 < 0) {
/* 592 */                   d.overwrite(a, AIPlans.null.this.pathing.set(a, d));
/* 593 */                   return true;
/*     */                 } 
/*     */ 
/*     */                 
/* 597 */                 d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/* 598 */                 return true;
/* 599 */               }  if (e.event == HEvent.EXHAUST)
/* 600 */                 return super.event(a, d, e); 
/* 601 */               if (e.event == HEvent.COLLISION_HARD)
/* 602 */                 return super.event(a, d, e);  }
/*     */             
/* 604 */             return false;
/*     */           }
/*     */         };
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPlans.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */