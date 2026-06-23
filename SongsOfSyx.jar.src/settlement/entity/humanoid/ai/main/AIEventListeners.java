/*     */ package settlement.entity.humanoid.ai.main;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.rnd.RND;
/*     */ public final class AIEventListeners { public static final Default def = new Default() {  }; static ENTITY tmp; private final AIPLAN fight; private final AIPLAN followCriminal; private final AIPLAN flee; private final AISUB STOP; public final AISUB EXHAUSTED; private final AIPLAN.PLANRES exhausted; public final AISUB KNOCK_CRIMINAL; final SubPushed PUSHED; public static interface Default extends HEventListener { default boolean event(Humanoid a, AIManager d, HEvent.HEventData e) { return AIEventListeners.PreventSwitchtableIntAlloc.event(a, d, e); } default double poll(Humanoid a, AIManager d, HPoll.HPollData e) { return AIEventListeners.PreventSwitchtableIntAlloc.poll(a, d, e); } } private static class PreventSwitchtableIntAlloc { public static boolean event(Humanoid a, AIManager d, HEvent.HEventData e) { int tx; int ty; double s; switch (e.event) { case COLLISION_HARD: d.interrupt(a, e); d.overwrite(a, (AI.listeners()).PUSHED.push(d, a, e.momentum)); return false;case COLLISION_SOFT: d.interrupt(a, e); d.overwrite(a, (AI.listeners()).STOP.activate(a, d)); return false;case COLLISION_TILE: d.interrupt(a, e); d.overwrite(a, (AI.SUBS()).confused.activate(a, d)); return true;case MEET_ENEMY: if (a.division() == null) { int i = a.physics.tileC().x(); int j = a.physics.tileC().y(); if (RND.oneIn(3) && (SETT.PATH()).finders.entity.getFriendlies(a, i, j) > (SETT.PATH()).finders.entity.getEnemies(a, i, j) / 4) { AIEventListeners.tmp = e.other; d.overwrite(a, (AI.listeners()).fight); } else { d.overwrite(a, (AI.plans()).runToSafety); }  } else { AIEventListeners.tmp = e.other; d.overwrite(a, (AI.listeners()).fight); }  return false;
/*     */         case MEET_HARMLESS: if (a.speed.dot(e.other.speed.nX(), e.other.speed.nY()) < 0.5D) { double t = a.speed.magnitudeTarget() * 0.5D; if (a.speed.magnitude() > t)
/*     */               a.speed.magnitudeInit(t);  }  if (a.speed.magnitude() < e.other.speed.magnitude()) { double t = a.speed.magnitudeTarget() * 0.5D; if (a.speed.magnitude() > t)
/*     */               a.speed.magnitudeInit(t);  }  return false;
/*     */         case CHECK_MORALE: tx = a.physics.tileC().x(); ty = a.physics.tileC().y(); if (a.division() == null && GAME.ARMIES().enemy().men() > 0 && (SETT.PATH()).finders.entity.getEnemies(a, tx, ty) > 0) { d.overwrite(a, (AI.plans()).runToSafety); } else if (a.division() != null && !(AI.modules()).battle.is(a, d)) { int p = (AI.modules()).battle.getPriority(a, d); if (p > 0) { AIModule m = AIModules.current(d); if (m == null || m.getPriority(a, d) < p) { d.overwrite(a, (AI.modules()).battle.interrrupt(a, d)); (AIModules.data()).currentModule.set(d, (AI.modules()).battle.index()); }  }  (AIModules.data()).nextModule.set(d, (AI.modules()).battle.index()); }  return false;
/*     */         case null: AIEventListeners.tmp = null; d.overwrite(a, (AI.listeners()).flee); return true;
/*     */         case EXHAUST: s = a.speed.magnitudeRelative(); if ((STATS.NEEDS()).EXHASTION.indu().getD(a.indu()) > 0.5D && AIModules.current(d).getPriority(a, d) <= 5)
/*     */             d.overwrite(a, (AI.listeners()).exhausted);  if (s > 0.75D) { (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), 2); } else if (s <= 0.6D && RND.oneIn(16)) { (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), -1); }  return false;
/*     */         case NOTIFY_CRIME: if ((AI.modules()).work.isLawEnforcement(a, d)) { AIEventListeners.tmp = e.other; d.overwrite(a, (AI.listeners()).followCriminal); } else if (a.indu().hType() != HTYPES.PRISONER()) { AIEventListeners.tmp = e.other; d.overwrite(a, (AI.listeners()).flee); }  return false;
/*     */         case ROOM_REMOVED: return false;
/*     */         case COLLISION_UNREACHABLE: return false;
/*     */         case INTERRACT: if (HPoll.Handler.canInterract(a, e.other)) { d.otherEntitySet((Humanoid)e.other); d.overwrite(a, (AI.modules()).idle.interract()); return true; }  return false;
/*     */         case FISHINGTRIP_OVER: return false; }  return false; } public static double poll(Humanoid a, AIManager d, HPoll.HPollData e) { switch (e.type) { case WILL_COLLIDE_WITH: if (e.other instanceof Animal) { if (!((Animal)e.other).domesticated())
/*     */               return 1.0D;  return 0.0D; }  if (e.other instanceof Humanoid)
/*     */             return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);  return 0.0D;
/*     */         case DEFENCE_SKILL: return 0.1D * (0.1D + 0.9D * e.facingDot);
/*     */         case null: return 0.0D;
/*     */         case SCARE_ANIMAL_NOT: return 0.0D;
/*     */         case IMPACT_DAMAGE: return 0.0D;
/*     */         case WORKING: return 0.0D;
/*     */         case IS_SLAVE_READY_FOR_UPRISING: return -1.0D;
/*     */         case IS_ENEMY: if (e.other instanceof Humanoid) { Humanoid o = (Humanoid)e.other; if (o.indu().hostile() != a.indu().hostile())
/*     */               return 1.0D;  }  return 0.0D;
/*     */         case CAN_INTERRACT: return 0.0D;
/*     */         case COLLIDES: return 1.0D;
/*  33 */         case PARRY_SKILL: return 0.0D; }  return 0.0D; } } public AIPLAN catchCriminal(Humanoid other) { tmp = (ENTITY)other; return this.followCriminal; } public AIEventListeners() { D.t(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     this.fight = new AIPLAN.PLANRES("eventFight")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 224 */           return this.first.set(a, d);
/*     */         }
/*     */         
/* 227 */         private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, D.g("Fighting"))
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 231 */               return (AI.modules()).battle.fight(a, d, AIEventListeners.tmp);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 236 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 241 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/* 252 */     this.followCriminal = new AIPLAN.PLANRES("eventFloolowCrim")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 256 */           return this.first.set(a, d);
/*     */         }
/*     */         
/* 259 */         private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, D.g("Catching-Criminal", "Catching Criminal"))
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 263 */               return (AI.SUBS()).walkTo.follow(a, d, AIEventListeners.tmp, true, (byte)20);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 268 */               if ((AI.SUBS()).walkTo.followSucess(a, d)) {
/* 269 */                 return AIEventListeners.null.this.knockCriminal.set(a, d);
/*     */               }
/* 271 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 276 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 287 */               if (e.event == HEvent.MEET_HARMLESS && 
/* 288 */                 e.other == SETT.ENTITIES().getByID(d.planObject)) {
/* 289 */                 d.overwrite(a, AIEventListeners.null.this.knockCriminal.set(a, d));
/* 290 */                 return true;
/*     */               } 
/*     */               
/* 293 */               return super.event(a, d, e);
/*     */             }
/*     */           };
/*     */         
/* 297 */         private final AIPLAN.PLANRES.Resumer knockCriminal = new AIPLAN.PLANRES.Resumer(this, this.first.name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 301 */               ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 302 */               if (e == null || !(e instanceof Humanoid)) {
/* 303 */                 return null;
/*     */               }
/* 305 */               a.speed.turn2(a.body(), e.body());
/* 306 */               a.speed.magnitudeInit(0.0D);
/* 307 */               AI.modules().makePrisoner((Humanoid)e, (AIManager)((Humanoid)e).ai());
/* 308 */               return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.box, (AI.STATES()).anima.box.time);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 313 */               return AIEventListeners.null.this.killCriminal.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 318 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 329 */         private final AIPLAN.PLANRES.Resumer killCriminal = new AIPLAN.PLANRES.Resumer(this, this.first.name)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 333 */               ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 334 */               if (e != null && e instanceof Humanoid) {
/* 335 */                 Humanoid a2 = (Humanoid)e;
/* 336 */                 if (AIModule_Prisoner.punishment(a2, a2.ai()) == CRIME_PUNISHMENTS.EXECUTE())
/* 337 */                   return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.work.activate(a, d)); 
/* 338 */                 return null;
/*     */               } 
/* 340 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a2, AIManager d) {
/* 345 */               ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 346 */               if (e != null) {
/* 347 */                 Humanoid a = (Humanoid)e;
/* 348 */                 (STATS.NEEDS()).INJURIES.COUNT.indu().incD(a.indu(), 0.2D + RND.rFloat());
/* 349 */                 (SETT.THINGS()).gore.cloud((ENTITY)a, (a.race().appearance()).colors.blood);
/* 350 */                 (SETT.THINGS()).gore.flesh((ENTITY)a, (a.race().appearance()).colors.blood);
/* 351 */                 if ((STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) > 0.75D) {
/* 352 */                   (GAME.count()).EXECUTIONS.inc(1);
/* 353 */                   (STATS.NEEDS()).INJURIES.COUNT.indu().setD(a.indu(), 1.0D);
/* 354 */                   a.kill(false, CAUSE_LEAVES.EXECUTED());
/*     */                 } 
/* 356 */                 return setAction(a, d);
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 361 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 366 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 378 */           if (e.event == HEvent.NOTIFY_CRIME) {
/* 379 */             return false;
/*     */           }
/* 381 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 393 */     this.flee = new AIPLAN.PLANRES("eventFlee")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 397 */           return this.first.set(a, d);
/*     */         }
/*     */         
/* 400 */         private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, D.g("Fleeing"))
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 404 */               if (AIEventListeners.tmp == null) {
/* 405 */                 return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 1 + RND.rInt(2));
/*     */               }
/* 407 */               return (AI.SUBS()).walkTo.flee(a, d, AIEventListeners.tmp);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 412 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 417 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/* 429 */     this.STOP = new AISUB.Simple("InterStop", D.g("Stopping"))
/*     */       {
/*     */ 
/*     */         
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 435 */           d.subByte = (byte)(d.subByte + 1);
/* 436 */           if (d.subByte == 1)
/* 437 */             return (AI.STATES()).STOP.activate(a, d, (1.0F + RND.rFloat())); 
/* 438 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 443 */           if (e.event == HEvent.COLLISION_SOFT) {
/* 444 */             d.subByte = 0;
/* 445 */           } else if (e.event == HEvent.COLLISION_TILE) {
/* 446 */             return true;
/* 447 */           }  return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 454 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 461 */     this.EXHAUSTED = new AISUB.Simple("InterExhaust", D.g("Out-of-breath", "Out-of-breath"))
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 465 */           if ((STATS.NEEDS()).EXHASTION.indu().getD(a.indu()) > 0.25D) {
/* 466 */             return (AI.STATES()).layStop.activate(a, d, (2.0F + RND.rFloat(15.0D)));
/*     */           }
/* 468 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 473 */           if (e.event == HEvent.EXHAUST) {
/* 474 */             (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), -(1 + RND.rInt(4)));
/* 475 */             return true;
/* 476 */           }  if (e.event == HEvent.COLLISION_TILE)
/* 477 */             return true; 
/* 478 */           if (e.event == HEvent.COLLISION_HARD) {
/* 479 */             d.overwrite(a, (AI.STATES()).layStop.activate(a, d, (2.0F + RND.rFloat(15.0D))));
/* 480 */             return true;
/*     */           } 
/* 482 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 487 */           if (e.type == HPoll.DEFENCE_SKILL)
/* 488 */             return super.poll(a, d, e) * 0.2D; 
/* 489 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 493 */     this.exhausted = new AIPLAN.PLANRES("interexhaustplan")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 497 */           if (a.division() != null)
/* 498 */             (a.division()).reporter.reportReachable(a, false); 
/* 499 */           return this.first.set(a, d);
/*     */         }
/*     */         
/* 502 */         private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, D.g("Out-of-breath", "Out-of-breath"))
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 506 */               return (AIEventListeners.null.access$0(AIEventListeners.null.this)).EXHAUSTED.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 511 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 516 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 527 */               if (e.type == HPoll.DEFENCE_SKILL)
/* 528 */                 return super.poll(a, d, e) * 0.2D; 
/* 529 */               return super.poll(a, d, e);
/*     */             }
/*     */           };
/*     */       };
/*     */ 
/*     */     
/* 535 */     this.KNOCK_CRIMINAL = new AISUB.Simple("InterKnockCrim", D.g("criminal", "Handling Criminal"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 551 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 578 */     this.PUSHED = new SubPushed(); }
/*     */    public AIPLAN flee(Humanoid a, AIManager d, ENTITY from) {
/*     */     tmp = from;
/*     */     return this.flee;
/* 582 */   } final class SubPushed { private final double flyForce = 1.5D;
/* 583 */     private final CharSequence name = D.g("tackled");
/*     */ 
/*     */     
/*     */     AISUB.AISubActivation push(AIManager d, Humanoid a, double momentum) {
/* 587 */       if (momentum > 5.0D) {
/* 588 */         momentum = 5.0D;
/*     */       }
/*     */       
/* 591 */       if (a.division() != null) {
/* 592 */         (a.division()).reporter.reportReachable(a, false);
/*     */       }
/* 594 */       if (momentum > 1.5D) {
/* 595 */         AISTATE aISTATE = (AI.STATES()).FLY.activate(a, d, (float)(0.25D + (momentum - 1.5D) / 3.0D));
/* 596 */         AISUB.AISubActivation aISubActivation = this.subFly.activate(a, d, aISTATE);
/* 597 */         return aISubActivation;
/*     */       } 
/* 599 */       AISTATE state = (AI.STATES()).layStop.activate(a, d, (2.0F + RND.rFloat(5.0D)));
/* 600 */       AISUB.AISubActivation ac = this.subPushed.activate(a, d, state);
/* 601 */       return ac;
/*     */     }
/*     */ 
/*     */     
/* 605 */     private final AISUB.Simple subFly = new AISUB.Simple("InterFly", this.name)
/*     */       {
/*     */ 
/*     */         
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 611 */           d.subByte = (byte)(d.subByte + 1);
/* 612 */           if (d.subByte == 1) {
/* 613 */             return (AI.STATES()).layStop.activate(a, d, (10.0F + RND.rFloat(30.0D)));
/*     */           }
/* 615 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 620 */           if (e.event == HEvent.COLLISION_TILE) {
/* 621 */             d.subByte = 0;
/* 622 */             return true;
/* 623 */           }  if (e.event == HEvent.COLLISION_HARD) {
/*     */             
/* 625 */             double mom = e.momentum * a.physics.getMassI() * 0.002232142857142857D;
/*     */             
/* 627 */             if (mom > 1.5D) {
/* 628 */               AISTATE state = (AI.STATES()).FLY.add(a, d, (float)((mom - 1.5D) / 3.0D));
/* 629 */               d.overwrite(a, state);
/* 630 */               d.subByte = 0;
/*     */             } 
/* 632 */             return true;
/*     */           } 
/* 634 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 639 */           if (e.type == HPoll.COLLIDES) {
/* 640 */             return ((a.physics.getZ() < 100.0D) ? true : false);
/*     */           }
/*     */           
/* 643 */           if (e.type == HPoll.WILL_COLLIDE_WITH) {
/* 644 */             if (e.other instanceof Humanoid) {
/* 645 */               return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */             }
/* 647 */             return 0.0D;
/* 648 */           }  if (e.type == HPoll.DEFENCE_SKILL)
/* 649 */             return super.poll(a, d, e) * 0.1D; 
/* 650 */           return 0.0D;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 655 */     private final AISUB.Simple subPushed = new AISUB.Simple("InterPushed", this.name)
/*     */       {
/*     */ 
/*     */         
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 661 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 666 */           if (e.event == HEvent.COLLISION_TILE) {
/* 667 */             d.subByte = 0;
/* 668 */             return true;
/* 669 */           }  if (e.event == HEvent.COLLISION_HARD) {
/* 670 */             (AI.STATES()).layStop.activate(a, d, (2.0F + RND.rFloat(15.0D)));
/* 671 */             d.subByte = 0;
/* 672 */             return true;
/*     */           } 
/* 674 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 679 */           if (e.type == HPoll.COLLIDES && 
/* 680 */             e.other instanceof Humanoid) {
/* 681 */             return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */           }
/* 683 */           if (e.type == HPoll.WILL_COLLIDE_WITH) {
/* 684 */             if (e.other instanceof Humanoid) {
/* 685 */               return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */             }
/* 687 */             return 0.0D;
/* 688 */           }  if (e.type == HPoll.DEFENCE_SKILL)
/* 689 */             return super.poll(a, d, e) * 0.2D; 
/* 690 */           return 0.0D;
/*     */         }
/*     */       }; }
/*     */ 
/*     */   
/*     */   public static interface HEventListener {
/*     */     boolean event(Humanoid param1Humanoid, AIManager param1AIManager, HEvent.HEventData param1HEventData);
/*     */     
/*     */     double poll(Humanoid param1Humanoid, AIManager param1AIManager, HPoll.HPollData param1HPollData);
/*     */   } }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIEventListeners.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */