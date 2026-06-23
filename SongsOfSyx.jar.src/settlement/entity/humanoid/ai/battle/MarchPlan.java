/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.Equip;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MarchPlan
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   public MarchPlan(String key) {
/*  35 */     super(key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     this.cutDistance = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     this.waitForDeploy = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 107 */           d.planByte1 = 0;
/* 108 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 113 */           if (!should(a, d))
/* 114 */             return null; 
/* 115 */           Div div = a.division();
/* 116 */           if (div.deployed() == 0) {
/* 117 */             d.planByte1 = (byte)(d.planByte1 + 1); if (d.planByte1 > 8)
/* 118 */               return null; 
/* 119 */             return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 0.5D));
/*     */           } 
/*     */           
/* 122 */           AISUB.AISubActivation s = MarchPlan.this.retry2(a, d);
/*     */           
/* 124 */           if (s == null) {
/* 125 */             div.reporter.reportReachable(a, false);
/* 126 */             d.planByte1 = (byte)(d.planByte1 + 1); if (d.planByte1 > 8)
/* 127 */               return null; 
/* 128 */             return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 0.5D));
/*     */           } 
/* 130 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 135 */           Div div = a.division();
/* 136 */           if (div == null || !div.settings().mustering()) {
/* 137 */             return false;
/*     */           }
/*     */           
/* 140 */           if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 141 */             return false;
/*     */           }
/* 143 */           return true;
/*     */         }
/*     */         
/*     */         private boolean should(Humanoid a, AIManager d) {
/* 147 */           Div div = a.division();
/* 148 */           if (div == null || !div.settings().mustering()) {
/* 149 */             return false;
/*     */           }
/*     */           
/* 152 */           if (!(AI.modules()).battle.moduleCanContinue(a, d)) {
/* 153 */             return false;
/*     */           }
/* 155 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 168 */     this.cutToPosition = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 174 */           if (a.indu().player() && a.division() != null) {
/* 175 */             DIR dir = DIR.get(a.tc(), (a.division()).reporter.getTile(a));
/* 176 */             if ((dir.x() != 0 || dir.y() != 0) && 
/* 177 */               (SETT.PATH()).coster.player.getCost(a.tc().x(), a.tc().y(), a.tc().x() + dir.x(), a.tc().y() + dir.y()) < 0.0D) {
/* 178 */               return MarchPlan.this.pathToDestination.set(a, d);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 183 */           return (AI.modules()).battle.subCutTo.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 188 */           Div div = a.division();
/* 189 */           if (!div.reporter.posHas(a))
/* 190 */             return MarchPlan.this.pathToDestination.set(a, d); 
/* 191 */           if (BattleUtil.isInPosition(div.reporter.getPixel(a), a, d)) {
/* 192 */             return MarchPlan.this.arriveInFormation.set(a, d);
/*     */           }
/* 194 */           return (AI.modules()).battle.subCutTo.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation resFailed(Humanoid a, AIManager d, HEvent event) {
/* 199 */           if (event == HEvent.COLLISION_TILE && a.division() != null && (a.division()).reporter.posHas(a)) {
/* 200 */             return MarchPlan.this.pathToPosition.set(a, d);
/*     */           }
/* 202 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 207 */           return MarchPlan.this.conn(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 218 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 223 */           return InterBattle.pollReady(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 227 */     this.pathToDestination = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/* 229 */         private final AISUB sub = (AISUB)new AISUB.Simple("MarchPath")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d) {
/* 232 */               d.subByte = (byte)(d.subByte + 1);
/* 233 */               if (d.subByte == 1) {
/* 234 */                 Div div = a.division();
/* 235 */                 if ((div.settings()).running) {
/* 236 */                   return (AI.STATES()).RUN2.path(a, d);
/*     */                 }
/* 238 */                 return (AI.STATES()).WALK2.path(a, d);
/*     */               } 
/*     */               
/* 241 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 246 */               return InterBattle.listener.event(a, d, e);
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 251 */               return InterBattle.listener.poll(a, d, e);
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 259 */           Div div = a.division();
/* 260 */           if (div.deployed() == 0)
/* 261 */             return MarchPlan.this.waitForSpot.set(a, d); 
/* 262 */           if (!div.reporter.posHas(a)) {
/* 263 */             return null;
/*     */           }
/* 265 */           COORDINATE c = div.reporter.getDestTile(a);
/* 266 */           int sx = c.x();
/* 267 */           int sy = c.y();
/* 268 */           COORDINATE dest = (SETT.PATH()).finders.arround.find(sx, sy, 0.0D, 15.0D);
/* 269 */           if (dest == null)
/* 270 */             return null; 
/* 271 */           d.planByte1 = 0;
/* 272 */           d.path.request(a.physics.tileC(), dest.x(), dest.y());
/* 273 */           if (!d.path.isSuccessful()) {
/* 274 */             return null;
/*     */           }
/* 276 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 281 */           if (!d.path.isSuccessful())
/* 282 */             return null; 
/* 283 */           if (d.path.isDest()) {
/* 284 */             return MarchPlan.this.waitInDestination.set(a, d);
/*     */           }
/* 286 */           d.path.setNext();
/* 287 */           Div div = a.division();
/* 288 */           if (!div.reporter.posHas(a))
/* 289 */             return null; 
/* 290 */           COORDINATE c = div.reporter.getDestTile(a);
/* 291 */           int tx = c.x();
/* 292 */           int ty = c.y();
/* 293 */           if (COORDINATE.tileDistance(tx, ty, d.path.destX(), d.path.destY()) > 15.0D) {
/* 294 */             return MarchPlan.this.retry(a, d);
/*     */           }
/* 296 */           d.planByte1 = (byte)(d.planByte1 + 1);
/* 297 */           if (d.planByte1 == 5) {
/* 298 */             c = div.reporter.getTile(a);
/* 299 */             if (c != null && SETT.PATH().isInTheNeighbourhood(c.x(), c.y(), a.physics.tileC().x(), a.physics.tileC().y())) {
/*     */               
/* 301 */               a.speed.magnitudeInit(0.0D);
/* 302 */               return MarchPlan.this.pathToPosition.set(a, d);
/*     */             } 
/* 304 */             d.planByte1 = 0;
/*     */           } 
/*     */           
/* 307 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 312 */           return MarchPlan.this.conn(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 324 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 329 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 333 */     this.pathToPosition = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/* 335 */         private final AISUB sub = (AISUB)new AISUB.Simple("MarchCut")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d) {
/* 338 */               d.subByte = (byte)(d.subByte + 1);
/* 339 */               if (d.subByte == 1)
/* 340 */                 return (AI.STATES()).RUN2.path(a, d); 
/* 341 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 346 */               return InterBattle.listener.event(a, d, e);
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 351 */               return InterBattle.listener.poll(a, d, e);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 357 */           Div div = a.division();
/*     */           
/* 359 */           if (!div.reporter.posHas(a))
/* 360 */             return MarchPlan.this.pathToDestination.set(a, d); 
/* 361 */           COORDINATE c = div.reporter.getTile(a);
/* 362 */           d.planByte1 = (byte)(0xFF & (div.order()).dest.setI());
/* 363 */           d.planByte2 = 0;
/* 364 */           d.path.request(a.physics.tileC(), c.x(), c.y());
/* 365 */           if (!d.path.isSuccessful())
/* 366 */             return MarchPlan.this.waitForSpot.set(a, d); 
/* 367 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 372 */           if (!d.path.isSuccessful())
/* 373 */             return null; 
/* 374 */           Div div = a.division();
/* 375 */           if (d.path.isDest()) {
/*     */             
/* 377 */             a.speed.magnitudeInit(0.0D);
/* 378 */             if (d.planByte2 == 5 && d.planByte1 != (byte)(0xFF & (div.order()).dest.setI())) {
/* 379 */               a.speed.magnitudeInit(0.0D);
/* 380 */               return set(a, d);
/*     */             } 
/* 382 */             if (!div.reporter.posHas(a))
/* 383 */               return MarchPlan.this.waitForSpot.set(a, d); 
/* 384 */             return MarchPlan.this.cutToPosition.set(a, d);
/*     */           } 
/* 386 */           d.path.setNext();
/* 387 */           d.planByte2 = (byte)(d.planByte2 + 1);
/*     */           
/* 389 */           if (d.planByte2 == 5 && d.planByte1 != (byte)(0xFF & (div.order()).dest.setI())) {
/* 390 */             d.planByte2 = 0;
/* 391 */             a.speed.magnitudeInit(0.0D);
/* 392 */             return set(a, d);
/*     */           } 
/*     */           
/* 395 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 400 */           return MarchPlan.this.conn(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 412 */           if (e.event == HEvent.COLLISION_SOFT) {
/* 413 */             d.interrupt(a, e);
/* 414 */             d.overwrite(a, (AI.modules()).battle.subSoft.initCoo(d, a, e.other, d.path.x() * 64 + 32, d.path.y() * 64 + 32));
/*     */           } 
/* 416 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 421 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 425 */     this.arriveInFormation = new AIPLAN.PLANRES.Resumer(this, ¤¤Reforming)
/*     */       {
/* 427 */         private final AISUB sub = (AISUB)new AISUB.Simple("MarchStand")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d)
/*     */             {
/* 431 */               d.subByte = (byte)(d.subByte + 1);
/* 432 */               if (d.subByte == 1)
/* 433 */                 return (AI.STATES()).STAND.activate(a, d, 0.1D); 
/* 434 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 439 */               return InterBattle.listener.event(a, d, e);
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 444 */               return InterBattle.listener.poll(a, d, e);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 450 */           d.planByte1 = (byte)(5 + RND.rInt(5));
/* 451 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 456 */           Div div = a.division();
/*     */           
/* 458 */           if (!div.reporter.posHas(a))
/* 459 */             return null; 
/* 460 */           COORDINATE dest = div.reporter.getPixel(a);
/* 461 */           if (!MarchPlan.this.isInPosition(dest, a, d)) {
/* 462 */             return MarchPlan.this.retry(a, d);
/*     */           }
/*     */           
/* 465 */           if (d.planByte1 > 0) {
/* 466 */             d.planByte1 = (byte)(d.planByte1 - 1);
/* 467 */           } else if (d.planByte1 == 0) {
/* 468 */             return MarchPlan.this.beBraced.set(a, d);
/*     */           } 
/* 470 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 475 */           return MarchPlan.this.conn(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 487 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 492 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 496 */     this.stand = new AISTATES.STOP("MP_STAND", HSprites.SWORD_STAND_SWAY);
/*     */     
/* 498 */     this.beBraced = new AIPLAN.PLANRES.Resumer(this, ¤¤Waiting)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 506 */           d.subByte = 0;
/* 507 */           return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 0.5D));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 513 */           if (!MarchPlan.this.conn(a, d)) {
/* 514 */             return null;
/*     */           }
/*     */           
/* 517 */           byte ss = d.subByte = (byte)(d.subByte + 1);
/* 518 */           AISUB.AISubActivation s = MarchPlan.this.tryMopup(a, d);
/* 519 */           if (s != null) {
/* 520 */             return s;
/*     */           }
/* 522 */           if ((a.division().settings()).shouldbreak) {
/* 523 */             for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 524 */               int dx = a.tc().x() + ((DIR)DIR.ORTHO.get(i)).x();
/* 525 */               int dy = a.tc().y() + ((DIR)DIR.ORTHO.get(i)).y();
/* 526 */               if ((AI.modules()).battle.tile.shouldattackTile(d, a, dx, dy)) {
/* 527 */                 return d.resumeOtherPlan(a, (AI.modules()).battle.tile.init(d, a, dx, dy));
/*     */               }
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/* 533 */           a.physics.isWithinTile();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 538 */           if (MarchPlan.this.shouldFire(a, d)) {
/* 539 */             return MarchPlan.this.fire.set(a, d);
/*     */           }
/* 541 */           d.subByte = ss;
/*     */           
/* 543 */           if (d.subByte < 50) {
/*     */             
/* 545 */             if (!con(a, d)) {
/* 546 */               return MarchPlan.this.retry(a, d);
/*     */             }
/* 548 */             Div div = a.division();
/*     */ 
/*     */             
/* 551 */             if (!div.reporter.posHas(a)) {
/* 552 */               return MarchPlan.this.retry(a, d);
/*     */             }
/*     */             
/* 555 */             COORDINATE dest = div.reporter.getPixel(a);
/*     */             
/* 557 */             if (!MarchPlan.this.isInPosition(dest, a, d)) {
/* 558 */               return MarchPlan.this.retry(a, d);
/*     */             }
/*     */             
/* 561 */             DIR dir = div.position().dir(a.divSpot());
/* 562 */             if (dir == null || !div.status().threatAt(dir, div)) {
/* 563 */               dir = a.division().dir();
/*     */             }
/*     */             
/* 566 */             if (RND.oneIn(30)) {
/* 567 */               a.speed.turn2(dir.next(RND.rInt0(1)));
/* 568 */               return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 1.0D + RND.rFloat(0.5D)));
/*     */             } 
/* 570 */             a.speed.turn2(dir);
/*     */ 
/*     */ 
/*     */             
/* 574 */             return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 0.5D));
/*     */           } 
/* 576 */           return MarchPlan.this.retry(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 581 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 592 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 597 */           return InterBattle.pollReady(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 605 */     this.fire = new AIPLAN.PLANRES.Resumer(this, ¤¤Firing)
/*     */       {
/*     */         private double drawInter(Humanoid a, AIManager d) {
/* 608 */           return a.division().settings().ammo().drawInter(a.division());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 614 */           d.planByte1 = 0;
/* 615 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 621 */           if (!MarchPlan.this.shouldFire(a, d)) {
/* 622 */             return MarchPlan.this.retry(a, d);
/*     */           }
/* 624 */           AISUB.AISubActivation s = MarchPlan.this.tryMopup(a, d);
/* 625 */           if (s != null) {
/* 626 */             return s;
/*     */           }
/* 628 */           Div div = a.division();
/*     */           
/* 630 */           if (!div.reporter.posHas(a)) {
/* 631 */             return MarchPlan.this.retry(a, d);
/*     */           }
/* 633 */           COORDINATE dest = div.reporter.getPixel(a);
/* 634 */           if (!MarchPlan.this.isInPosition(dest, a, d)) {
/* 635 */             return MarchPlan.this.retry(a, d);
/*     */           }
/* 637 */           Trajectory t = div.traj(a);
/*     */           
/* 639 */           if (t == null) {
/*     */             
/* 641 */             DIR dir = div.position().dir(a.divSpot());
/* 642 */             if (dir == null || !div.status().threatAt(dir, div)) {
/* 643 */               dir = a.division().dir();
/*     */             }
/*     */             
/* 646 */             if (RND.oneIn(30)) {
/* 647 */               a.speed.turn2(dir.next(RND.rInt0(1)));
/* 648 */               return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 1.0D + RND.rFloat(0.5D)));
/*     */             } 
/* 650 */             a.speed.turn2(dir);
/* 651 */             return (AI.SUBS()).single.activate(a, d, MarchPlan.this.stand.activate(a, d, 0.5D));
/*     */           } 
/*     */           
/* 654 */           a.speed.setDirCurrent(DIR.get(t.vx(), t.vy()));
/* 655 */           if (d.planByte1 == 1 && drawInter(a, d) >= 0.75D) {
/* 656 */             d.planByte1 = 0;
/*     */ 
/*     */             
/* 659 */             EquipRange rr = a.division().settings().ammo();
/* 660 */             rr.launch(a, t);
/* 661 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.archer2, 0.1D + RND.rFloat() * 0.1D);
/*     */           } 
/* 663 */           if (drawInter(a, d) < 0.75D)
/* 664 */             d.planByte1 = 1; 
/* 665 */           if (drawInter(a, d) > 0.5D)
/* 666 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.archer2, 0.1D + RND.rFloat() * 0.1D); 
/* 667 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.archer1, 0.1D + RND.rFloat() * 0.1D);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 674 */           return MarchPlan.this.conn(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 685 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 690 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 694 */     this.waitForSpot = new AIPLAN.PLANRES.Resumer(this, ¤¤Waiting)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 698 */           return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 703 */           AISUB.AISubActivation s = MarchPlan.this.tryMopup(a, d);
/* 704 */           if (s != null)
/* 705 */             return s; 
/* 706 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 711 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 721 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 726 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 730 */     this.waitInDestination = new AIPLAN.PLANRES.Resumer(this, ¤¤Waiting)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 734 */           if (RND.oneIn(5))
/* 735 */             a.speed.turnRandom(); 
/* 736 */           return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 742 */           AISUB.AISubActivation s = MarchPlan.this.tryMopup(a, d);
/* 743 */           if (s != null) {
/* 744 */             return s;
/*     */           }
/* 746 */           Div div = a.division();
/* 747 */           COORDINATE c = div.reporter.getDestTile(a);
/* 748 */           int tx = c.x();
/* 749 */           int ty = c.y();
/* 750 */           if (COORDINATE.tileDistance(tx, ty, d.path.destX(), d.path.destY()) > 15.0D) {
/* 751 */             return null;
/*     */           }
/*     */           
/* 754 */           if (RND.oneIn(5) && div.reporter.posHas(a)) {
/* 755 */             c = div.reporter.getTile(a);
/* 756 */             if (c != null && SETT.PATH().isInTheNeighbourhood(c.x(), c.y(), a.physics.tileC().x(), a.physics.tileC().y())) {
/* 757 */               return MarchPlan.this.pathToPosition.set(a, d);
/*     */             }
/*     */           } 
/*     */           
/* 761 */           return setAction(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 766 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 771 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 776 */           return MarchPlan.this.conn(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 787 */     this.fetchGear = new AIPLAN.PLANRES.Resumer(this, "Getting Battlegear")
/*     */       {
/* 789 */         final RBIT.RBITImp bi = new RBIT.RBITImp();
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 793 */           this.bi.clear();
/* 794 */           Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/* 795 */           if (div == null) {
/* 796 */             return null;
/*     */           }
/* 798 */           for (Equip e : STATS.EQUIP().BATTLE_ALL()) {
/* 799 */             if (e.stat().indu().get(a.indu()) < e.target(a.indu())) {
/* 800 */               this.bi.or(e.resource(a.indu()));
/*     */             }
/*     */           } 
/*     */           
/* 804 */           if (this.bi.isClear()) {
/* 805 */             return null;
/*     */           }
/* 807 */           return (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bi, 2147483647);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 812 */           RESOURCE r = d.resourceCarried();
/* 813 */           for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 814 */             if (e.stat().indu().get(a.indu()) < e.target(a.indu()) && e.resource(a.indu()) == r) {
/* 815 */               e.inc(a.indu(), 1);
/* 816 */               d.resourceCarriedSet(null);
/*     */               break;
/*     */             } 
/*     */           } 
/* 820 */           AISUB.AISubActivation s = set(a, d);
/* 821 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 826 */           return ((STATS.BATTLE()).DIV.get(a) != null);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 858 */     this.mopup = new AIPLAN.PLANRES.Resumer(this, ¤¤Breaking)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 862 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 867 */           return MarchPlan.this.tryMopup(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 872 */           Div div = a.division();
/* 873 */           return (div != null && div.settings().mustering() && div.settings().moppingUp());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 883 */           if (e.event == HEvent.COLLISION_SOFT)
/* 884 */             return super.event(a, d, e); 
/* 885 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 890 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static CharSequence ¤¤Reforming = "¤Reforming";
/*     */   private static CharSequence ¤¤Waiting = "¤Waiting for orders";
/*     */   private static CharSequence ¤¤Breaking = "¤Breaking Formation";
/*     */   private static CharSequence ¤¤Firing = "¤Firing";
/*     */   private final int cutDistance = 32;
/*     */   private AIPLAN.PLANRES.Resumer waitForDeploy;
/*     */   private final AIPLAN.PLANRES.Resumer cutToPosition;
/*     */   private final AIPLAN.PLANRES.Resumer pathToDestination;
/*     */   private final AIPLAN.PLANRES.Resumer pathToPosition;
/*     */   private final AIPLAN.PLANRES.Resumer arriveInFormation;
/*     */   private final AISTATES.STOP stand;
/*     */   private final AIPLAN.PLANRES.Resumer beBraced;
/*     */   private final AIPLAN.PLANRES.Resumer fire;
/*     */   private final AIPLAN.PLANRES.Resumer waitForSpot;
/*     */   private final AIPLAN.PLANRES.Resumer waitInDestination;
/*     */   private final AIPLAN.PLANRES.Resumer fetchGear;
/*     */   private final AIPLAN.PLANRES.Resumer mopup;
/*     */   
/*     */   static {
/*     */     D.ts(MarchPlan.class);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if (a.indu().player() && d.plan() != this) {
/*     */       AISUB.AISubActivation s = this.fetchGear.set(a, d);
/*     */       if (s != null)
/*     */         return s; 
/*     */     } 
/*     */     return retry(a, d);
/*     */   }
/*     */   
/*     */   private AISUB.AISubActivation retry(Humanoid a, AIManager d) {
/*     */     return this.waitForDeploy.set(a, d);
/*     */   }
/*     */   
/*     */   private AISUB.AISubActivation retry2(Humanoid a, AIManager d) {
/*     */     Div div = a.division();
/*     */     COORDINATE c = a.physics.tileC();
/*     */     if (!div.reporter.posHas(a))
/*     */       return this.pathToDestination.set(a, d); 
/*     */     if (isInPosition(div.reporter.getPixel(a), a, d))
/*     */       return this.beBraced.set(a, d); 
/*     */     COORDINATE de = div.reporter.getTile(a);
/*     */     if (COORDINATE.tileDistance(c, de) < 32.0D)
/*     */       return this.cutToPosition.set(a, d); 
/*     */     if (c != null && SETT.PATH().isInTheNeighbourhood(de.x(), de.y(), a.physics.tileC().x(), a.physics.tileC().y()))
/*     */       return this.pathToPosition.set(a, d); 
/*     */     return this.pathToDestination.set(a, d);
/*     */   }
/*     */   
/*     */   private boolean conn(Humanoid a, AIManager d) {
/*     */     Div div = a.division();
/*     */     return (div != null && div.settings().mustering() && div.deployed() > 0);
/*     */   }
/*     */   
/*     */   private boolean isInPosition(COORDINATE dest, Humanoid a, AIManager d) {
/*     */     return dest.isSameAs(a.physics.body().cX(), a.physics.body().cY());
/*     */   }
/*     */   
/*     */   private boolean shouldFire(Humanoid a, AIManager d) {
/*     */     return (conn(a, d) && a.division().settings().shouldFire() && a.division().settings().ammo().ammoD(a.division()) > 0.0D);
/*     */   }
/*     */   
/*     */   private AISUB.AISubActivation tryMopup(Humanoid a, AIManager d) {
/*     */     if (!a.division().settings().moppingUp())
/*     */       return null; 
/*     */     if (STATS.POP().pop(HTYPES.ENEMY()) == 0 && STATS.POP().pop(HTYPES.RIOTER()) == 0)
/*     */       return null; 
/*     */     Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/*     */     Humanoid h = div.targets.getNextTarget();
/*     */     if (h != null) {
/*     */       AISUB.AISubActivation s = (AI.SUBS()).walkTo.follow(a, d, (ENTITY)h, true, (byte)10);
/*     */       h.target(2);
/*     */       if (s != null) {
/*     */         this.mopup.set(a, d);
/*     */         return s;
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchPlan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */