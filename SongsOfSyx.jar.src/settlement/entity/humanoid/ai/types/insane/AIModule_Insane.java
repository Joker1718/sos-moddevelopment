/*     */ package settlement.entity.humanoid.ai.types.insane;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.health.asylum.ROOM_ASYLUM;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIModule_Insane
/*     */   extends AIModule
/*     */ {
/*  35 */   private static CharSequence ¤¤treatment = "¤In Treatment";
/*  36 */   private static CharSequence ¤¤insane = "¤Being Insane";
/*  37 */   private static CharSequence ¤¤name = "¤Be Insane"; private final AIPLAN asylum; private final AIPLAN crazy; private final AISUB[] crazySubsA; private final AISUB[] crazySubs;
/*     */   
/*     */   public AIModule_Insane() {
/*  40 */     super((SPRITE)(UI.icons()).s.crazy, ¤¤name, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     this.asylum = (AIPLAN)new AIPLAN.PLANRES("instaneAsylum")
/*     */       {
/*  84 */         private final ROOM_ASYLUM A = (SETT.ROOMS()).ASYLUM;
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*  88 */           AI.modules().coo(d).set(-1.0D, -1.0D);
/*  89 */           COORDINATE c = this.A.registerPrisoner(a);
/*  90 */           if (c != null) {
/*  91 */             AI.modules().coo(d).set(c);
/*  92 */             d.planByte1 = 8;
/*  93 */             return this.init.set(a, d);
/*     */           } 
/*  95 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation resume(Humanoid a, AIManager d) {
/* 100 */           AISUB.AISubActivation s = super.resume(a, d);
/* 101 */           if (s == null) {
/* 102 */             (SETT.ROOMS()).ASYLUM.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/* 103 */             AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */           } 
/* 105 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void cancel(Humanoid a, AIManager d) {
/* 110 */           (SETT.ROOMS()).ASYLUM.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/* 111 */           AI.modules().coo(d).set(-1.0D, -1.0D);
/* 112 */           super.cancel(a, d);
/*     */         }
/*     */         
/* 115 */         private final AIPLAN.PLANRES.Resumer init = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */           {
/*     */             
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 120 */               return res(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 126 */               if (!AIModule_Insane.null.this.A.isreserved((COORDINATE)AI.modules().coo(d))) {
/* 127 */                 return null;
/*     */               }
/* 129 */               if (d.planByte1 <= 0) {
/* 130 */                 if (!(SETT.PATH()).connectivity.is(a.tc())) {
/* 131 */                   return AIModule_Insane.null.this.unfuck.set(a, d);
/*     */                 }
/* 133 */                 AIModule_Insane.null.this.cancel(a, d);
/* 134 */                 return null;
/*     */               } 
/*     */               
/* 137 */               if (!AIModule_Insane.null.this.A.isWithinCell(a.tc().x(), a.tc().y(), (COORDINATE)AI.modules().coo(d)))
/*     */               {
/* 139 */                 return AIModule_Insane.null.this.walkToDoor.set(a, d);
/*     */               }
/*     */               
/* 142 */               if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0 && 
/* 143 */                 AIModule_Insane.null.this.A.eatFood((COORDINATE)AI.modules().coo(d))) {
/* 144 */                 (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/*     */               }
/*     */ 
/*     */               
/* 148 */               if (TIME.light().nightIs()) {
/* 149 */                 return (AI.SUBS()).subSleep.activate(a, d);
/*     */               }
/*     */ 
/*     */               
/* 153 */               if (RND.oneIn(5)) {
/* 154 */                 AISUB.AISubActivation s = AIModule_Insane.null.this.changeSpot.set(a, d);
/* 155 */                 if (s != null)
/* 156 */                   return s; 
/*     */               } 
/* 158 */               return (AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubsA[RND.rInt((AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubsA.length)].activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 163 */               return AIModule_Insane.null.this.A.isreserved((COORDINATE)AI.modules().coo(d));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 173 */         private final AIPLAN.PLANRES.Resumer walkToDoor = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 177 */               return (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)AI.modules().coo(d));
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 182 */               return AIModule_Insane.null.this.init.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 187 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/* 197 */         private final AIPLAN.PLANRES.Resumer unfuck = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */           {
/* 199 */             final AISUB untrapp = (AISUB)new AISUB.Simple("insanetrapped")
/*     */               {
/*     */                 public AISTATE resume(Humanoid a, AIManager d)
/*     */                 {
/* 203 */                   d.subByte = (byte)(d.subByte + 1);
/* 204 */                   if (d.subByte != 1)
/* 205 */                     return null; 
/* 206 */                   for (int di = 0; di < DIR.ALL.size(); di++) {
/* 207 */                     DIR dir = (DIR)DIR.ALL.get(di);
/* 208 */                     if ((SETT.PATH()).connectivity.is(a.tc(), dir) && 
/* 209 */                       (SETT.ROOMS()).ASYLUM.isWithinCell(a.tc().x() + dir.x(), a.tc().y() + dir.y(), (COORDINATE)AI.modules().coo(d)))
/*     */                     {
/* 211 */                       return (AI.STATES()).WALK2.dirTile(a, d, dir);
/*     */                     }
/*     */                   } 
/* 214 */                   return (AI.STATES()).STAND.activate(a, d, 1.0D);
/*     */                 }
/*     */               };
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 221 */               return this.untrapp.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 226 */               return AIModule_Insane.null.this.init.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 231 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 241 */         private final AIPLAN.PLANRES.Resumer changeSpot = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤treatment)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 245 */               DIR dir = (DIR)DIR.ORTHO.rnd();
/* 246 */               int dx = a.tc().x() + dir.x();
/* 247 */               int dy = a.tc().y() + dir.y();
/* 248 */               if (AIModule_Insane.null.this.A.isWithinCell(dx, dy, (COORDINATE)AI.modules().coo(d)) && 
/* 249 */                 !SETT.ENTITIES().hasAtTile(dx, dy)) {
/* 250 */                 return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */               }
/* 252 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 257 */               return AIModule_Insane.null.this.init.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 262 */               return true;
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
/* 274 */           if (e.event == HEvent.ROOM_REMOVED && e.room.is((COORDINATE)AI.modules().coo(d))) {
/* 275 */             (SETT.ROOMS()).ASYLUM.unregisterPrisoner((COORDINATE)AI.modules().coo(d));
/* 276 */             AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */           } 
/* 278 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 282 */     this.crazy = (AIPLAN)new AIPLAN.PLANRES("insaneCrazy")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 286 */           return this.first.set(a, d);
/*     */         }
/*     */         
/* 289 */         private final AIPLAN.PLANRES.Resumer first = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 293 */               if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a) > 0) {
/* 294 */                 AISUB.AISubActivation s = AIModule_Insane.null.this.eat.set(a, d);
/* 295 */                 if (s != null)
/* 296 */                   return s; 
/* 297 */                 if ((STATS.FOOD()).STARVATION.indu().getD(a.indu()) > 0.0D) {
/* 298 */                   AIManager.dead = CAUSE_LEAVES.STARVED();
/*     */                 }
/*     */               } 
/*     */               
/* 302 */               if (TIME.light().nightIs())
/* 303 */                 return AIModule_Insane.null.this.sleep.set(a, d); 
/* 304 */               d.planByte1 = (byte)(10 + RND.rInt(10));
/* 305 */               if ((SETT.PATH()).finders.randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 70)) {
/* 306 */                 return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */               }
/* 308 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 313 */               return AIModule_Insane.null.this.res.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 318 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 328 */         private final AIPLAN.PLANRES.Resumer res = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 332 */               d.planByte1 = (byte)(d.planByte1 - 1);
/* 333 */               if (d.planByte1 <= 0)
/* 334 */                 return null; 
/* 335 */               if (RND.oneIn(10)) {
/* 336 */                 return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 2);
/*     */               }
/* 338 */               return (AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubs[RND.rInt((AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubs.length)].activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 343 */               return setAction(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 348 */               return true;
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
/* 359 */               if (e.event == HEvent.COLLISION_UNREACHABLE) {
/* 360 */                 DIR dd = a.speed.dir();
/* 361 */                 if (!dd.isOrtho())
/* 362 */                   dd = dd.next(1); 
/* 363 */                 for (int i = 0; i < 4 && 
/* 364 */                   !(SETT.PATH()).connectivity.is(a.tc(), dd); i++)
/*     */                 {
/*     */                   
/* 367 */                   dd = dd.next(2);
/*     */                 }
/*     */                 
/* 370 */                 if ((SETT.PATH()).connectivity.is(a.tc(), dd)) {
/* 371 */                   a.speed.setRaw(dd, 0.5D);
/*     */                 } else {
/* 373 */                   a.speed.magnitudeTargetSet(0.0D);
/*     */                 } 
/*     */               } 
/* 376 */               return super.event(a, d, e);
/*     */             }
/*     */           };
/*     */         
/* 380 */         private final AIPLAN.PLANRES.Resumer sleep = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 384 */               return res(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 389 */               if (TIME.light().nightIs()) {
/* 390 */                 return (AI.SUBS()).subSleep.activate(a, d);
/*     */               }
/* 392 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 397 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 407 */         private final AIPLAN.PLANRES.Resumer eat = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 411 */               return (AI.SUBS()).walkTo.resource(a, d, (RESOURCES.EDI()).mask, 2147483647);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 416 */               if (d.resourceCarried() != null) {
/* 417 */                 STATS.FOOD().eat(a, 1, 0.0D);
/* 418 */                 d.resourceAInc(-1);
/* 419 */                 return (AI.SUBS()).STAND.activate(a, d, (AI.STATES()).anima.box.activate(a, d, 2.0D));
/*     */               } 
/* 421 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 426 */               return true;
/*     */             }
/*     */ 
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
/* 439 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 505 */       .crazySubsA = new AISUB[] { (AISUB)new AISUB.Simple("crazy1") { protected AISTATE resume(Humanoid a, AIManager d) { d.subByte = (byte)(d.subByte + 1); if (d.subByte > 5 && RND.oneIn(5)) return null;  a.speed.setDirCurrent(a.speed.dir().next(1)); return (AI.STATES()).STAND.activate(a, d, 0.25D); } }, (AISUB)new AISUB.Simple("crazy2") { protected AISTATE resume(Humanoid a, AIManager d) { d.subByte = (byte)(d.subByte + 1); if (d.subByte > 5 && RND.oneIn(5)) return null;  a.speed.setDirCurrent(a.speed.dir().next(1)); return (AI.STATES()).anima.box.activate(a, d, 0.25D); } }, (AISUB)new AISUB.Simple("crazy3") { protected AISTATE resume(Humanoid a, AIManager d) { d.subByte = (byte)(d.subByte + 1); if (d.subByte > 5 && RND.oneIn(5)) return null;  a.speed.setDirCurrent(a.speed.dir().next(1)); return (AI.STATES()).anima.dance.activate(a, d, 0.25D); } }, (AISUB)new AISUB.Simple("crazy4") { protected AISTATE resume(Humanoid a, AIManager d) { d.subByte = (byte)(d.subByte + 1); if (d.subByte > 5 && RND.oneIn(5)) return null;  a.speed.setDirCurrent(a.speed.dir().next(1)); return (AI.STATES()).anima.danceE.activate(a, d, 0.25D); } }, (AISUB)new AISUB.Simple("crazy5") { protected AISTATE resume(Humanoid a, AIManager d) { d.subByte = (byte)(d.subByte + 1); if (d.subByte > 5 && RND.oneIn(5)) return null;  return (AI.STATES()).anima.box.activate(a, d, 0.25D); } }, (AISUB)new AISUB.Simple("crazy6") { protected AISTATE resume(Humanoid a, AIManager d) { d.subByte = (byte)(d.subByte + 1); if (d.subByte > 5 && RND.oneIn(5)) return null;  a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3))); return (AI.STATES()).anima.armsOut.activate(a, d, 0.25D); } }, (AISUB)new AISUB.Simple("crazy7")
/*     */         {
/*     */           protected AISTATE resume(Humanoid a, AIManager d)
/*     */           {
/* 509 */             d.subByte = (byte)(d.subByte + 1);
/* 510 */             if (d.subByte > 5 && RND.oneIn(5))
/* 511 */               return null; 
/* 512 */             return (AI.STATES()).anima.lay.activate(a, d, 0.25D);
/*     */           }
/*     */         } };
/*     */ 
/*     */ 
/*     */     
/* 518 */     this.crazySubs = new AISUB[this.crazySubsA.length + 1];
/*     */     
/* 520 */     for (int i = 0; i < this.crazySubsA.length; i++) {
/* 521 */       this.crazySubs[i] = this.crazySubsA[i];
/*     */     }
/* 523 */     this.crazySubs[this.crazySubs.length - 1] = (AISUB)new AISUB.Simple("crazyRun")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 527 */           d.subByte = (byte)(d.subByte + 1);
/* 528 */           if (d.subByte > 10 && RND.oneIn(5))
/* 529 */             return null; 
/* 530 */           DIR dir = (DIR)DIR.ORTHO.getC(d.subByte);
/* 531 */           if ((SETT.PATH()).solidity.is(a.tc(), dir))
/* 532 */             return (AI.STATES()).anima.lay.activate(a, d, 0.25D); 
/* 533 */           return (AI.STATES()).RUN2.dirTile(a, d, dir);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   static {
/*     */     D.ts(AIModule_Insane.class);
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     AIPLAN.AiPlanActivation p = this.asylum.activate(a, d);
/*     */     if (p != null)
/*     */       return p; 
/*     */     return this.crazy.activate(a, d);
/*     */   }
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/*     */     AI.modules().coo(d).set(-1.0D, -1.0D);
/*     */   }
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {
/*     */     if (newDay && (SETT.ROOMS()).ASYLUM.isreserved((COORDINATE)AI.modules().coo(d))) {
/*     */       int chance = (int)(0.5D * TIME.years().bitConversion((TIMECYCLE)TIME.days()) / (SETT.ROOMS()).ASYLUM.treatmentFactor((COORDINATE)AI.modules().coo(d)));
/*     */       if (RND.oneIn(chance))
/*     */         a.HTypeSet(HTYPES.SUBJECT(), null, CAUSE_ARRIVES.CURED()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     return 8;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\insane\AIModule_Insane.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */