/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer pathing;
/*     */   private final AIPLAN.PLANRES.Resumer run;
/*     */   
/*     */   null(String $anonymous0) {
/* 445 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 452 */     this.pathing = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤Fleeing)
/*     */       {
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e)
/*     */         {
/* 456 */           if (e.event == HEvent.COLLISION_SOFT) {
/* 457 */             int ri = RND.rInt(DIR.ORTHO.size());
/* 458 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 459 */               DIR dd = (DIR)DIR.ORTHO.getC(ri + i);
/* 460 */               if ((SETT.PATH()).cost.get(a.tc().x(), a.tc().y(), dd) > 0.0D) {
/* 461 */                 a.speed.turn2(dd);
/* 462 */                 return true;
/*     */               } 
/*     */             } 
/* 465 */             a.speed.turn2(-e.norX, -e.norY);
/* 466 */             d.overwrite(a, AIPlans.null.this.run.set(a, d));
/* 467 */             return true;
/* 468 */           }  if (e.event == HEvent.MEET_ENEMY)
/* 469 */           { a.speed.turn2(-e.norX, -e.norY);
/* 470 */             d.overwrite(a, AIPlans.null.this.run.set(a, d)); }
/* 471 */           else { if (e.event == HEvent.COLLISION_TILE) {
/* 472 */               d.overwrite(a, AIPlans.null.this.run.set(a, d));
/* 473 */               d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/* 474 */               return true;
/* 475 */             }  if (e.event == HEvent.EXHAUST)
/* 476 */               return super.event(a, d, e); 
/* 477 */             if (e.event == HEvent.COLLISION_HARD)
/* 478 */               return super.event(a, d, e);  }
/*     */           
/* 480 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 485 */           if ((SETT.PATH()).finders.entity.findSafety(a, a.physics.tileC().x(), a.physics.tileC().y(), d.path, 100)) {
/* 486 */             return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */           }
/* 488 */           a.speed.turnWithAngel(RND.rFloat0(90.0D));
/*     */           
/* 490 */           return AIPlans.null.this.run.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 495 */           if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 1)
/* 496 */             return null; 
/* 497 */           if (GAME.ARMIES().enemy().men() > 0) {
/* 498 */             a.speed.turnWithAngel(RND.rInt0(90));
/* 499 */             return (AI.SUBS()).STAND.activateTime(a, d, 3 + RND.rInt(3));
/*     */           } 
/*     */           
/* 502 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 507 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 517 */     this.run = new AIPLAN.PLANRES.Resumer(this, AIPlans.¤¤Fleeing)
/*     */       {
/* 519 */         private final AISUB sub = new AISUB.Simple("PlansFlee")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d)
/*     */             {
/* 523 */               d.planByte1 = (byte)(d.planByte1 - 1);
/*     */               
/* 525 */               if (d.planByte1 > 0)
/* 526 */                 return (AI.STATES()).RUN.activate(a, d, (4.0F + RND.rFloat() * 3.0F)); 
/* 527 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 532 */               if (d.planByte1 == 0)
/* 533 */                 return null; 
/* 534 */               d.planByte1 = 0;
/* 535 */               return (AI.STATES()).RUN.activate(a, d, (4.0F + RND.rFloat() * 3.0F));
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 541 */           d.planByte2 = (byte)(2 + RND.rInt(5));
/* 542 */           d.planByte1 = (byte)(2 + RND.rInt(5));
/* 543 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 548 */           if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 1)
/* 549 */             return null; 
/* 550 */           if (GAME.ARMIES().enemy().men() > 0) {
/* 551 */             return AIPlans.null.this.pathing.set(a, d);
/*     */           }
/* 553 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 558 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 569 */           return super.poll(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 574 */           if (e.event == HEvent.COLLISION_SOFT) {
/* 575 */             int ri = RND.rInt(DIR.ORTHO.size());
/* 576 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 577 */               DIR dd = (DIR)DIR.ORTHO.getC(ri + i);
/* 578 */               if (SETT.IN_BOUNDS(a.tc(), dd) && (SETT.PATH()).cost.get(a.tc().x(), a.tc().y(), dd) > 0.0D) {
/* 579 */                 a.speed.turn2(dd);
/* 580 */                 d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/*     */               } 
/*     */             } 
/* 583 */             a.speed.turn2(-e.norX, -e.norY);
/* 584 */             d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/* 585 */             return true;
/* 586 */           }  if (e.event == HEvent.MEET_ENEMY)
/* 587 */           { a.speed.turn2(-e.norX, -e.norY);
/* 588 */             d.overwrite(a, (AI.STATES()).STOP.activate(a, d)); }
/* 589 */           else { if (e.event == HEvent.COLLISION_TILE) {
/* 590 */               d.planByte2 = (byte)(d.planByte2 - 1);
/* 591 */               if (d.planByte2 < 0) {
/* 592 */                 d.overwrite(a, AIPlans.null.this.pathing.set(a, d));
/* 593 */                 return true;
/*     */               } 
/*     */ 
/*     */               
/* 597 */               d.overwrite(a, (AI.STATES()).STOP.activate(a, d));
/* 598 */               return true;
/* 599 */             }  if (e.event == HEvent.EXHAUST)
/* 600 */               return super.event(a, d, e); 
/* 601 */             if (e.event == HEvent.COLLISION_HARD)
/* 602 */               return super.event(a, d, e);  }
/*     */           
/* 604 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.pathing.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPlans$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */