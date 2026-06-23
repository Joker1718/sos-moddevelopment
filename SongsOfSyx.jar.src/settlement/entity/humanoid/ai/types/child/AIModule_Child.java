/*     */ package settlement.entity.humanoid.ai.types.child;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.NEEDS;
/*     */ import java.util.Comparator;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.room.knowledge.school.ROOM_SCHOOL;
/*     */ import settlement.room.service.nursery.ROOM_NURSERY;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIModule_Child
/*     */   extends AIModule
/*     */ {
/*  46 */   private static CharSequence ¤¤name = "¤Child";
/*  47 */   private static CharSequence ¤¤play = "¤Playing";
/*  48 */   private static CharSequence ¤¤sleep = "¤Sleeping";
/*  49 */   private static CharSequence ¤¤Studying = "¤Studying";
/*  50 */   private static CharSequence ¤¤nursinging = "¤Attending Nursery";
/*  51 */   private static CharSequence ¤¤leaving = "¤leaving your city.";
/*     */   
/*     */   static {
/*  54 */     D.ts(AIModule_Child.class);
/*     */   }
/*     */   
/*  57 */   private static final INT_O.INT_OE<AIManager> nurseryTimeout = (INT_O.INT_OE<AIManager>)new INT_O.INTWRAP(3, (AIModules.data()).byte2);
/*  58 */   private static final INT_O.INT_OE<AIManager> schoolTimeout = (INT_O.INT_OE<AIManager>)new INT_O.INTWRAP(12, (AIModules.data()).byte2);
/*  59 */   private static final INT_O.INT_OE<AIManager> schoolTimeoutDay = (INT_O.INT_OE<AIManager>)new INT_O.INTWRAP(48, (AIModules.data()).byte2);
/*     */   
/*  61 */   public final double ChildDaySeconds = TIME.workSeconds();
/*  62 */   public final double ChildDayStart = (8 * TIME.secondsPerHour());
/*  63 */   public final double ChildDayEnd = this.ChildDayStart + this.ChildDaySeconds;
/*     */   
/*     */   public AIModule_Child() {
/*  66 */     super((HTYPES.CHILD()).icon, ¤¤name, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 265 */     this.play = (AIPLAN)new Plan(this, "childPlay")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 269 */           d.planByte1 = 0;
/* 270 */           return this.stand.set(a, d);
/*     */         }
/*     */         
/* 273 */         private final AIPLAN.PLANRES.Resumer stand = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤play)
/*     */           {
/*     */             
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 278 */               if (!RND.oneIn(4)) {
/* 279 */                 Humanoid f = AIModule_Child.null.access$0(AIModule_Child.null.this).friend(a, d);
/* 280 */                 if (f == null) {
/* 281 */                   f = AIModule_Child.null.access$0(AIModule_Child.null.this).parent(a, d);
/* 282 */                 } else if (AIModule_Child.null.access$0(AIModule_Child.null.this).parent(a, d) != null && RND.oneIn(4)) {
/* 283 */                   f = AIModule_Child.null.access$0(AIModule_Child.null.this).parent(a, d);
/*     */                 } 
/* 285 */                 if (f != null && 
/* 286 */                   d.path.request(a.tc(), f.tc())) {
/* 287 */                   return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */                 }
/*     */               } 
/*     */               
/* 291 */               if ((SETT.PATH()).finders.randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 64)) {
/* 292 */                 return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */               }
/* 294 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 299 */               if (!AIModule_Child.null.access$0(AIModule_Child.null.this).moduleCanContinue(a, d) || RND.oneIn(8))
/* 300 */                 return null; 
/* 301 */               if (RND.oneIn(4))
/* 302 */                 return (AI.SUBS()).LAY.activateRndDir(a, d); 
/* 303 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 308 */               return true;
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
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 321 */           if (e.event == HEvent.COLLISION_SOFT || e.event == HEvent.COLLISION_HARD)
/* 322 */             d.planByte1 = (byte)CLAMP.i(d.planByte1 + 1, 0, 3); 
/* 323 */           if (e.event == HEvent.COLLISION_UNREACHABLE) {
/* 324 */             DIR dd = a.speed.dir();
/* 325 */             if (!dd.isOrtho())
/* 326 */               dd = dd.next(1); 
/* 327 */             for (int i = 0; i < 4 && 
/* 328 */               !(SETT.PATH()).connectivity.is(a.tc(), dd); i++)
/*     */             {
/*     */               
/* 331 */               dd = dd.next(2);
/*     */             }
/*     */             
/* 334 */             if ((SETT.PATH()).connectivity.is(a.tc(), dd)) {
/* 335 */               a.speed.setRaw(dd, 0.5D);
/*     */             } else {
/* 337 */               a.speed.magnitudeTargetSet(0.0D);
/*     */             } 
/*     */           } 
/* 340 */           return super.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 345 */           if (d.planByte1 < 3 && e.type == HPoll.WILL_COLLIDE_WITH && e.other instanceof Humanoid && ((Humanoid)e.other).indu().hType() != HTYPES.CHILD() && RND.oneIn(8))
/* 346 */             return 1.0D; 
/* 347 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 351 */     this.sleep = (AIPLAN)new Plan(this, "childSleep")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 355 */           return this.walk.set(a, d);
/*     */         }
/*     */         
/* 358 */         private final AIPLAN.PLANRES.Resumer walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤sleep)
/*     */           {
/*     */             
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 363 */               Humanoid parent = AIModule_Child.null.access$0(AIModule_Child.null.this).parent(a, d);
/* 364 */               if (parent != null) {
/* 365 */                 HOME home = (STATS.HOME()).GETTER.get(parent, this);
/* 366 */                 if (home != null && 
/* 367 */                   d.path.requestFull(a.tc(), home.serviceX(), home.serviceY())) {
/* 368 */                   return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */                 }
/*     */               } 
/*     */ 
/*     */               
/* 373 */               AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.PATH()).finders.indoor, 100);
/* 374 */               if (s != null)
/* 375 */                 return s; 
/* 376 */               return AIModule_Child.null.this.sleep.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 381 */               HOME home = (HOME)(SETT.ROOMS()).HOME.getter.get(a.tc());
/* 382 */               if (home != null && home instanceof HomeInstance) {
/* 383 */                 HomeInstance h = (HomeInstance)home;
/* 384 */                 h.use();
/* 385 */                 if (SETT.ENTITIES().hasAtTile((ENTITY)a, a.tc().x(), a.tc().y())) {
/* 386 */                   for (DIR dir : DIR.ORTHO) {
/* 387 */                     if (h.is(a.tc(), dir) && !(SETT.PATH()).solidity.is(a.tc(), dir) && !SETT.ENTITIES().hasAtTile(a.tc().x() + dir.x(), a.tc().y() + dir.y())) {
/* 388 */                       return (AI.SUBS()).walkTo.cooFull(a, d, a.tc().x() + dir.x(), a.tc().y() + dir.y());
/*     */                     }
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */ 
/*     */               
/* 395 */               return AIModule_Child.null.this.sleep.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 400 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */         
/* 409 */         private final AIPLAN.PLANRES.Resumer sleep = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤sleep)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 424 */               return (AI.SUBS()).subSleep.activate(a, d);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 430 */               if (AIModule_Child.null.access$0(AIModule_Child.null.this).moduleCanContinue(a, d) && TIME.light().nightIs())
/* 431 */                 return (AI.SUBS()).subSleep.activate(a, d); 
/* 432 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 437 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
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
/* 453 */     this.nursery = (AIPLAN)new Plan(this, "childnursery")
/*     */       {
/* 455 */         private final ArrayListGrower<ROOM_NURSERY> best = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */         
/*     */         private HCLASS sortClass;
/*     */ 
/*     */ 
/*     */         
/*     */         private Race sortRace;
/*     */ 
/*     */         
/*     */         private final Comparator<ROOM_NURSERY> comp;
/*     */ 
/*     */         
/*     */         private final AIPLAN.PLANRES.Resumer walk;
/*     */ 
/*     */         
/*     */         private final AIPLAN.PLANRES.Resumer study;
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 477 */           this.sortClass = a.indu().hType().parentClass();
/* 478 */           this.sortRace = a.race();
/*     */           
/* 480 */           this.best.sort(this.comp);
/*     */           
/* 482 */           for (ROOM_NURSERY n : this.best) {
/* 483 */             n.stat().setAccess(a, false);
/*     */           }
/*     */           
/* 486 */           for (ROOM_NURSERY n : this.best) {
/* 487 */             if (n.stat().accessRequest(a)) {
/* 488 */               AISUB.AISubActivation ss = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(n.service()).finder, n.radius());
/* 489 */               if (ss != null) {
/* 490 */                 d.planTile.set(d.path.destX(), d.path.destY());
/* 491 */                 d.planByte1 = (byte)n.typeIndex();
/* 492 */                 n.stat().setAccess(a, true);
/* 493 */                 this.walk.set(a, d);
/* 494 */                 return ss;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 499 */           return this.walk.set(a, d);
/*     */         }
/*     */         
/*     */         private ROOM_NURSERY b(AIManager d) {
/* 503 */           return (ROOM_NURSERY)(SETT.ROOMS()).NURSERIES.get(d.planByte1);
/*     */         }
/*     */         
/*     */         FSERVICE ss(AIManager d) {
/* 507 */           return b(d).service().service(d.planTile.x(), d.planTile.y());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 593 */     this.school = (AIPLAN)new Plan(this, "childSchool")
/*     */       {
/* 595 */         private final ArrayListGrower<ROOM_SCHOOL> best = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private Induvidual sorti;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final Comparator<ROOM_SCHOOL> comp;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final AIPLAN.PLANRES.Resumer walk;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final AIPLAN.PLANRES.Resumer study;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 621 */           this.sorti = a.indu();
/*     */           
/* 623 */           this.best.sort(this.comp);
/*     */ 
/*     */           
/* 626 */           for (ROOM_SCHOOL s : this.best) {
/* 627 */             AISUB.AISubActivation ss = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(s.service()).finder, 250);
/* 628 */             if (ss != null) {
/* 629 */               d.planByte1 = (byte)s.typeIndex();
/* 630 */               this.walk.set(a, d);
/* 631 */               return ss;
/*     */             } 
/*     */           } 
/* 634 */           return null;
/*     */         }
/*     */         
/*     */         private ROOM_SCHOOL b(AIManager d) {
/* 638 */           return (ROOM_SCHOOL)(SETT.ROOMS()).SCHOOLS.get(d.planByte1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 725 */     this.leave = (AIPLAN)new Plan(this, "SubEmigrateChild")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 730 */           (GAME.events()).riot.emigrate(a);
/* 731 */           return this.walk.set(a, d);
/*     */         }
/*     */ 
/*     */         
/* 735 */         private final AIPLAN.PLANRES.Resumer walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤leaving)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 739 */               if ((SETT.PATH()).finders.entryPoints.find(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/* 740 */                 (STATS.WORK()).EMPLOYED.set(a, null);
/* 741 */                 (STATS.BATTLE()).RECRUIT.set(a, null);
/* 742 */                 (STATS.BATTLE()).DIV.set(a, null);
/* 743 */                 return (AI.SUBS()).walkTo.path(a, d);
/*     */               } 
/* 745 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 750 */               Humanoid.HumanoidResource.dead = CAUSE_LEAVES.EMMIGRATED();
/* 751 */               return (AI.SUBS()).STAND.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 756 */               return true;
/*     */             }
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/*     */   }
/*     */   
/*     */   private final AIPLAN play;
/*     */   private final AIPLAN sleep;
/*     */   private final AIPLAN nursery;
/*     */   private final AIPLAN school;
/*     */   private final AIPLAN leave;
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     if (isSleep(a, d))
/*     */       return this.sleep.activate(a, d); 
/*     */     if (isEmmigrate(a, d)) {
/*     */       AIPLAN.AiPlanActivation p = this.leave.activate(a, d);
/*     */       if (p != null)
/*     */         return p; 
/*     */     } 
/*     */     if (isSchool(a, d)) {
/*     */       AIPLAN.AiPlanActivation p = this.school.activate(a, d);
/*     */       if (p == null) {
/*     */         schoolTimeout.set(d, 2);
/*     */         schoolTimeoutDay.inc(d, 1);
/*     */       } else {
/*     */         schoolTimeoutDay.set(d, 0);
/*     */         return p;
/*     */       } 
/*     */     } 
/*     */     if (isNursery(a, d)) {
/*     */       AIPLAN.AiPlanActivation p = this.nursery.activate(a, d);
/*     */       if (p == null) {
/*     */         nurseryTimeout.set(d, 2);
/*     */       } else {
/*     */         return p;
/*     */       } 
/*     */     } 
/*     */     return this.play.activate(a, d);
/*     */   }
/*     */   
/*     */   public static boolean shouldGrowUp(Humanoid a, AIManager d) {
/*     */     if (!(STATS.POP()).age.isAdult(a.indu()))
/*     */       return false; 
/*     */     if (!(STATS.EDUCATION()).child.educateCan(a.indu()))
/*     */       return true; 
/*     */     if (schoolTimeoutDay.get(d) > 2)
/*     */       return true; 
/*     */     for (ROOM_SCHOOL s : (SETT.ROOMS()).SCHOOLS) {
/*     */       if (s.service().total() > 0)
/*     */         return false; 
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   private boolean isEmmigrate(Humanoid a, AIManager d) {
/*     */     if (SETT.ENTRY().isClosed())
/*     */       return false; 
/*     */     if (STATS.REL().hasParent(a.indu())) {
/*     */       int pr = STATS.REL().parentRef(a.indu());
/*     */       if (STATS.REL().death(pr) == CAUSE_LEAVES.EMMIGRATED())
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private boolean isSleep(Humanoid a, AIManager d) {
/*     */     if (TIME.light().nightIs() || (NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0 || (STATS.NEEDS()).EXPOSURE.COUNT.indu().get(a.indu()) > 0)
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean isTime() {
/*     */     int t = (int)(TIME.currentSecond() % TIME.secondsPerDay());
/*     */     return (t >= this.ChildDayStart && t < this.ChildDayEnd);
/*     */   }
/*     */   
/*     */   private boolean isNursery(Humanoid a, AIManager d) {
/*     */     if (!(STATS.POP()).age.isAdult(a.indu()) && nurseryTimeout.get(d) == 0 && isTime())
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private boolean isSchool(Humanoid a, AIManager d) {
/*     */     if ((STATS.POP()).age.isAdult(a.indu()) && schoolTimeout.get(d) == 0 && isTime() && (STATS.EDUCATION()).child.educateCan(a.indu()))
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/*     */     d.planTile.set(-1.0D, -1.0D);
/*     */     (AIModules.data()).byte2.set(d, 0);
/*     */     setGrowth(a);
/*     */   }
/*     */   
/*     */   public static void setGrowth(Humanoid a) {
/*     */     double h = (a.race()).physics.height();
/*     */     h = h * 0.75D + h * STATS.RAN().getD(a.indu(), 4) * 0.5D;
/*     */     double w = (BOOSTABLES.PHYSICS()).MASS.get((BOOSTABLE_O)a.indu());
/*     */     w = w * 0.95D + w * STATS.RAN().getD(a.indu(), 6) * 0.1D;
/*     */     double age = (STATS.POP()).age.DAYS.get(a.indu());
/*     */     age -= (a.race()).physics.babyDays;
/*     */     age /= (a.race()).physics.childDays;
/*     */     age = 0.35D + 0.65D * age;
/*     */     age = CLAMP.d(age, 0.35D, 1.0D);
/*     */     a.physics.setHeight(h * age);
/*     */     a.physics.setMass(w * age);
/*     */   }
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {}
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {
/*     */     if (newDay)
/*     */       setGrowth(a); 
/*     */     nurseryTimeout.inc(d, -1);
/*     */     schoolTimeout.inc(d, -1);
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     if (isSleep(a, d) || isNursery(a, d) || isSchool(a, d))
/*     */       return 2; 
/*     */     if ((STATS.RAN().get(a.indu(), TIME.hours().bitCurrent()) & 0x1) == 1)
/*     */       return 1; 
/*     */     return 0;
/*     */   }
/*     */   
/*     */   private abstract class Plan extends AIPLAN.PLANRES {
/*     */     public Plan(String key) {
/*     */       super(key);
/*     */     }
/*     */     
/*     */     public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*     */       if (e.event == HEvent.MEET_HARMLESS && e.other instanceof Humanoid) {
/*     */         Humanoid h = (Humanoid)e.other;
/*     */         if (h.indu().hType() == HTYPES.CHILD()) {
/*     */           Humanoid ff = AIModule_Child.this.friend(a, d);
/*     */           if (ff == null || a.race().pref().race(ff.race()) > a.race().pref().race(h.race()))
/*     */             (STATS.POP()).FRIEND.set(a.indu(), ff); 
/*     */         } 
/*     */       } 
/*     */       return super.event(a, d, e);
/*     */     }
/*     */   }
/*     */   
/*     */   public Humanoid friend(Humanoid a, AIManager d) {
/*     */     ENTITY e = (ENTITY)(STATS.POP()).FRIEND.get(a.indu());
/*     */     if (e != null && e instanceof Humanoid)
/*     */       return (Humanoid)e; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public Humanoid parent(Humanoid a, AIManager d) {
/*     */     if (STATS.REL().hasParent(a.indu()))
/*     */       return STATS.REL().human(STATS.REL().parentRef(a.indu())); 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\child\AIModule_Child.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */