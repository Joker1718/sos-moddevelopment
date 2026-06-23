/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final AIPLAN.PLANRES.Resumer knockCriminal;
/*     */   private final AIPLAN.PLANRES.Resumer killCriminal;
/*     */   
/*     */   null(String $anonymous0) {
/* 252 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 259 */     this.first = new AIPLAN.PLANRES.Resumer(this, D.g("Catching-Criminal", "Catching Criminal"))
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 263 */           return (AI.SUBS()).walkTo.follow(a, d, AIEventListeners.tmp, true, (byte)20);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 268 */           if ((AI.SUBS()).walkTo.followSucess(a, d)) {
/* 269 */             return AIEventListeners.null.this.knockCriminal.set(a, d);
/*     */           }
/* 271 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 276 */           return true;
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
/* 287 */           if (e.event == HEvent.MEET_HARMLESS && 
/* 288 */             e.other == SETT.ENTITIES().getByID(d.planObject)) {
/* 289 */             d.overwrite(a, AIEventListeners.null.this.knockCriminal.set(a, d));
/* 290 */             return true;
/*     */           } 
/*     */           
/* 293 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 297 */     this.knockCriminal = new AIPLAN.PLANRES.Resumer(this, this.first.name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 301 */           ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 302 */           if (e == null || !(e instanceof Humanoid)) {
/* 303 */             return null;
/*     */           }
/* 305 */           a.speed.turn2(a.body(), e.body());
/* 306 */           a.speed.magnitudeInit(0.0D);
/* 307 */           AI.modules().makePrisoner((Humanoid)e, (AIManager)((Humanoid)e).ai());
/* 308 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.box, (AI.STATES()).anima.box.time);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 313 */           return AIEventListeners.null.this.killCriminal.set(a, d);
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
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 329 */     this.killCriminal = new AIPLAN.PLANRES.Resumer(this, this.first.name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 333 */           ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 334 */           if (e != null && e instanceof Humanoid) {
/* 335 */             Humanoid a2 = (Humanoid)e;
/* 336 */             if (AIModule_Prisoner.punishment(a2, a2.ai()) == CRIME_PUNISHMENTS.EXECUTE())
/* 337 */               return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.work.activate(a, d)); 
/* 338 */             return null;
/*     */           } 
/* 340 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a2, AIManager d) {
/* 345 */           ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 346 */           if (e != null) {
/* 347 */             Humanoid a = (Humanoid)e;
/* 348 */             (STATS.NEEDS()).INJURIES.COUNT.indu().incD(a.indu(), 0.2D + RND.rFloat());
/* 349 */             (SETT.THINGS()).gore.cloud((ENTITY)a, (a.race().appearance()).colors.blood);
/* 350 */             (SETT.THINGS()).gore.flesh((ENTITY)a, (a.race().appearance()).colors.blood);
/* 351 */             if ((STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) > 0.75D) {
/* 352 */               (GAME.count()).EXECUTIONS.inc(1);
/* 353 */               (STATS.NEEDS()).INJURIES.COUNT.indu().setD(a.indu(), 1.0D);
/* 354 */               a.kill(false, CAUSE_LEAVES.EXECUTED());
/*     */             } 
/* 356 */             return setAction(a, d);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 361 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 366 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.first.set(a, d);
/*     */   }
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 378 */     if (e.event == HEvent.NOTIFY_CRIME) {
/* 379 */       return false;
/*     */     }
/* 381 */     return super.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIEventListeners$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */