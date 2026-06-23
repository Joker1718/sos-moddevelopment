/*     */ package settlement.entity.humanoid.ai.types.insane;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer first;
/*     */   private final AIPLAN.PLANRES.Resumer res;
/*     */   private final AIPLAN.PLANRES.Resumer sleep;
/*     */   private final AIPLAN.PLANRES.Resumer eat;
/*     */   
/*     */   null(String $anonymous0) {
/* 282 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 289 */     this.first = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 293 */           if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a) > 0) {
/* 294 */             AISUB.AISubActivation s = AIModule_Insane.null.this.eat.set(a, d);
/* 295 */             if (s != null)
/* 296 */               return s; 
/* 297 */             if ((STATS.FOOD()).STARVATION.indu().getD(a.indu()) > 0.0D) {
/* 298 */               AIManager.dead = CAUSE_LEAVES.STARVED();
/*     */             }
/*     */           } 
/*     */           
/* 302 */           if (TIME.light().nightIs())
/* 303 */             return AIModule_Insane.null.this.sleep.set(a, d); 
/* 304 */           d.planByte1 = (byte)(10 + RND.rInt(10));
/* 305 */           if ((SETT.PATH()).finders.randomDistanceAway.find(a.tc().x(), a.tc().y(), d.path, 70)) {
/* 306 */             return (AI.SUBS()).walkTo.pathRun(a, d);
/*     */           }
/* 308 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 313 */           return AIModule_Insane.null.this.res.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 318 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 328 */     this.res = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 332 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 333 */           if (d.planByte1 <= 0)
/* 334 */             return null; 
/* 335 */           if (RND.oneIn(10)) {
/* 336 */             return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 2);
/*     */           }
/* 338 */           return (AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubs[RND.rInt((AIModule_Insane.null.access$0(AIModule_Insane.null.this)).crazySubs.length)].activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 343 */           return setAction(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 348 */           return true;
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
/* 359 */           if (e.event == HEvent.COLLISION_UNREACHABLE) {
/* 360 */             DIR dd = a.speed.dir();
/* 361 */             if (!dd.isOrtho())
/* 362 */               dd = dd.next(1); 
/* 363 */             for (int i = 0; i < 4 && 
/* 364 */               !(SETT.PATH()).connectivity.is(a.tc(), dd); i++)
/*     */             {
/*     */               
/* 367 */               dd = dd.next(2);
/*     */             }
/*     */             
/* 370 */             if ((SETT.PATH()).connectivity.is(a.tc(), dd)) {
/* 371 */               a.speed.setRaw(dd, 0.5D);
/*     */             } else {
/* 373 */               a.speed.magnitudeTargetSet(0.0D);
/*     */             } 
/*     */           } 
/* 376 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 380 */     this.sleep = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 384 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 389 */           if (TIME.light().nightIs()) {
/* 390 */             return (AI.SUBS()).subSleep.activate(a, d);
/*     */           }
/* 392 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 397 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 407 */     this.eat = new AIPLAN.PLANRES.Resumer(this, AIModule_Insane.¤¤insane)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 411 */           return (AI.SUBS()).walkTo.resource(a, d, (RESOURCES.EDI()).mask, 2147483647);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 416 */           if (d.resourceCarried() != null) {
/* 417 */             STATS.FOOD().eat(a, 1, 0.0D);
/* 418 */             d.resourceAInc(-1);
/* 419 */             return (AI.SUBS()).STAND.activate(a, d, (AI.STATES()).anima.box.activate(a, d, 2.0D));
/*     */           } 
/* 421 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 426 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.first.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\insane\AIModule_Insane$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */