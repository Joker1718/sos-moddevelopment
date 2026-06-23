/*     */ package settlement.entity.humanoid.ai.home;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIUtilMoveH;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer use;
/*     */   private final AIPLAN.PLANRES.Resumer bed;
/*     */   private final AIPLAN.PLANRES.Resumer move;
/*     */   
/*     */   null(String $anonymous0) {
/* 384 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 396 */     this.walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 400 */           return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 405 */           return AIModule_Home.null.this.use.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 410 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 419 */     this.use = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 423 */           d.planByte2 = 5;
/* 424 */           HomeInstance h = AIModule_Home.null.this.get(a);
/* 425 */           if (h == null)
/* 426 */             return null; 
/* 427 */           if (!h.is(a.tc())) {
/* 428 */             int sx = h.serviceX();
/* 429 */             int sy = h.serviceY();
/* 430 */             return (AI.SUBS()).walkTo.cooFull(a, d, sx, sy);
/*     */           } 
/* 432 */           h.use();
/* 433 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 440 */           if (AIModule_Home.null.this.shouldRes(a, d) && AIModule_Home.null.access$0(AIModule_Home.null.this).getPriority(a, d) > 0) {
/* 441 */             AISUB.AISubActivation s = null;
/* 442 */             switch (RND.rInt(4)) {
/*     */               case 0:
/* 444 */                 s = AIModule_Home.null.this.bed.set(a, d);
/*     */                 break;
/*     */               case 1:
/* 447 */                 s = AIModule_Home.null.this.move.set(a, d);
/*     */                 break;
/*     */             } 
/*     */             
/* 451 */             if (s != null) {
/* 452 */               return s;
/*     */             }
/* 454 */             if (!SETT.ENTITIES().hasAtTileHigher((ENTITY)a, a.tc().x(), a.tc().y())) {
/* 455 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/* 457 */             HomeInstance h = AIModule_Home.null.this.get(a);
/* 458 */             for (DIR dir : DIR.ORTHO) {
/* 459 */               if (h.is(a.tc(), dir) && !(SETT.PATH()).solidity.is(a.tc(), dir)) {
/* 460 */                 return (AI.SUBS()).walkTo.cooFull(a, d, a.tc().x() + dir.x(), a.tc().y() + dir.y());
/*     */               }
/*     */             } 
/* 463 */             return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           } 
/* 465 */           can(a, d);
/* 466 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 471 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 481 */           if (e.type == HPoll.CAN_INTERRACT)
/* 482 */             return 1.0D; 
/* 483 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 487 */     this.bed = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 491 */           HomeInstance h = AIModule_Home.null.this.get(a);
/* 492 */           HomeInstance.DirCoo c = h.findService(a);
/*     */           
/* 494 */           if (c == null)
/* 495 */             return (AI.SUBS()).STAND.activateRndDir(a, d); 
/* 496 */           d.planTile.set((COORDINATE)c);
/* 497 */           d.planByte1 = (byte)(8 + RND.rInt(2));
/* 498 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)c);
/* 499 */           if (s != null) {
/* 500 */             return s;
/*     */           }
/*     */           
/* 503 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 508 */           if (AIModule_Home.null.this.shouldRes(a, d)) {
/*     */ 
/*     */             
/* 511 */             d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 <= 0) {
/* 512 */               AIModule_Home.null.this.moveOK(a, d);
/* 513 */               return AIModule_Home.null.this.use.set(a, d);
/*     */             } 
/* 515 */             HomeInstance h = AIModule_Home.null.this.get(a);
/* 516 */             HomeInstance.DirCoo c = h.getService(d.planTile.x(), d.planTile.y());
/* 517 */             if (c == null) {
/* 518 */               can(a, d);
/* 519 */               return null;
/*     */             } 
/*     */             
/* 522 */             AIUtilMoveH.moveToTile(a, c.x(), c.y(), c.isLay ? c.dir : DIR.C);
/*     */             
/* 524 */             a.speed.setDirCurrent(c.dir);
/*     */             
/* 526 */             if (c.isLay && (a.race()).physics.sleeps) {
/* 527 */               return (AI.SUBS()).subSleep.activate(a, d);
/*     */             }
/* 529 */             return (AI.SUBS()).STAND.activateTime(a, d, 8);
/*     */           } 
/* 531 */           can(a, d);
/* 532 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 537 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 542 */           AIModule_Home.null.this.moveOK(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 547 */           if (e.event == HEvent.COLLISION_UNREACHABLE)
/* 548 */             return false; 
/* 549 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 553 */     this.move = new AIPLAN.PLANRES.Resumer(this, AIModule_Home.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 557 */           HomeInstance h = AIModule_Home.null.this.get(a);
/* 558 */           for (DIR dir : DIR.ORTHO) {
/* 559 */             if (h.is(a.tc(), dir) && !(SETT.PATH()).solidity.is(a.tc(), dir) && !SETT.ENTITIES().hasAtTile(a.tc().x() + dir.x(), a.tc().y() + dir.y())) {
/* 560 */               return (AI.SUBS()).walkTo.cooFull(a, d, a.tc().x() + dir.x(), a.tc().y() + dir.y());
/*     */             }
/*     */           } 
/* 563 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 568 */           if (AIModule_Home.null.this.shouldRes(a, d)) {
/* 569 */             if (RND.oneIn(8)) {
/* 570 */               return AIModule_Home.null.this.use.set(a, d);
/*     */             }
/* 572 */             return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           } 
/* 574 */           can(a, d);
/* 575 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 580 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean shouldRes(Humanoid a, AIManager d) {
/* 594 */     if (!isHome(a, d))
/* 595 */       return false; 
/* 596 */     if (!AIModule_Home.this.moduleCanContinue(a, d)) {
/* 597 */       return false;
/*     */     }
/* 599 */     return true;
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { d.planByte2 = 4;
/*     */     HOME h = (STATS.HOME()).GETTER.get(a, this);
/*     */     if (h.is(a.tc().x(), a.tc().y()))
/*     */       return this.use.set(a, d); 
/*     */     return this.walk.set(a, d); } private void moveOK(Humanoid a, AIManager d) {
/* 605 */     if ((SETT.PATH()).solidity.is(a.tc())) {
/* 606 */       AIUtilMoveH.unfuck(a);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isHome(Humanoid a, AIManager d) {
/* 611 */     HomeInstance h = get(a);
/* 612 */     if (h != null) {
/* 613 */       boolean ret = h.is(a.tc());
/*     */       
/* 615 */       return ret;
/*     */     } 
/* 617 */     return false;
/*     */   }
/*     */   
/*     */   private HomeInstance get(Humanoid a) {
/* 621 */     HOME h = (STATS.HOME()).GETTER.get(a, this);
/* 622 */     if (h != null && h instanceof HomeInstance)
/* 623 */       return (HomeInstance)h; 
/* 624 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 629 */     if (STATS.LAW().getCurfew().is()) {
/* 630 */       string.add(AIModule_Home.¤¤curfew);
/*     */     } else {
/* 632 */       string.add(AIModule_Home.¤¤name);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\home\AIModule_Home$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */