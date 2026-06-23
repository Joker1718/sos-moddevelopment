/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final AIPLAN.PLANRES.Resumer fight;
/*     */   private final AIPLAN.PLANRES.Resumer social;
/*     */   
/*     */   null(String $anonymous0) {
/* 317 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 324 */     this.first = new AIPLAN.PLANRES.Resumer(this, "")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 328 */           d.planByte1 = 0;
/* 329 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 335 */           if (!PlanInterract.null.access$0(PlanInterract.null.this).conn(a, d)) {
/* 336 */             return null;
/*     */           }
/* 338 */           Humanoid o = PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d);
/*     */           
/* 340 */           if (((AIManager)o.ai()).plan() == (PlanInterract.null.access$0(PlanInterract.null.this)).lookForFriend) {
/* 341 */             d.planByte1 = (byte)(d.planByte1 + 1);
/* 342 */             if (d.planByte1 > 100)
/* 343 */               return null; 
/* 344 */             return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           } 
/*     */           
/* 347 */           if (PlanInterract.null.access$0(PlanInterract.null.this).shouldFight(a, o))
/* 348 */             return PlanInterract.null.this.fight.set(a, d); 
/* 349 */           return PlanInterract.null.this.social.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 354 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 363 */     this.fight = new AIPLAN.PLANRES.Resumer(this, "")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 367 */           d.planByte1 = (byte)(15 + RND.rInt(30));
/* 368 */           (STATS.POP()).FRIEND.set(a.indu(), PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d));
/* 369 */           if ((PlanInterract.null.access$0(PlanInterract.null.this)).prop.i(PlanInterract.null.this.key, 0) == 0) {
/* 370 */             (new MessageText(PlanInterract.¤¤brawling, PlanInterract.¤¤brawlingD)).send();
/* 371 */             (PlanInterract.null.access$0(PlanInterract.null.this)).prop.setI(PlanInterract.null.this.key, 1);
/*     */           } 
/*     */           
/* 374 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 379 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 380 */           if (d.planByte1 < 0)
/* 381 */             return null; 
/* 382 */           if (!PlanInterract.null.access$0(PlanInterract.null.this).conn(a, d))
/* 383 */             return null; 
/* 384 */           if ((STATS.NEEDS()).INJURIES.COUNT.indu().getD(a.indu()) > 0.25D) {
/* 385 */             return d.resumeOtherPlan(a, (PlanInterract.null.access$0(PlanInterract.null.this)).out);
/*     */           }
/* 387 */           Humanoid o = PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d);
/* 388 */           if (RND.rBoolean()) {
/* 389 */             a.speed.turn2(a.body(), o.body());
/* 390 */             return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(2));
/*     */           } 
/* 392 */           double dam = RND.rFloat() * 0.25D * (BOOSTABLES.BATTLE()).BLUNT_ATTACK.get((BOOSTABLE_O)a.indu()) / (BOOSTABLES.BATTLE()).BLUNT_DEFENCE.get((BOOSTABLE_O)o.indu());
/* 393 */           if (dam > 0.4D)
/* 394 */             dam = 0.4D; 
/* 395 */           o.inflictDamage(dam, CAUSE_LEAVES.BRAWL());
/* 396 */           return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).anima.box.activate(a, d, 1.0D));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 401 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 410 */     this.social = new AIPLAN.PLANRES.Resumer(this, "")
/*     */       {
/* 412 */         private final AISTATES.Animation[] ani = new AISTATES.Animation[] {
/* 413 */             (AI.STATES()).anima.carry, 
/* 414 */             (AI.STATES()).anima.fist, 
/* 415 */             (AI.STATES()).anima.grab, 
/* 416 */             (AI.STATES()).anima.fistRight, 
/* 417 */             (AI.STATES()).anima.fistRight, 
/* 418 */             (AI.STATES()).anima.fistRight
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 423 */           d.planByte1 = (byte)(15 + RND.rInt(30));
/* 424 */           if ((STATS.POP()).FRIEND.get(a.indu()) == null || RND.oneIn(10)) {
/* 425 */             (STATS.POP()).FRIEND.set(a.indu(), PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d));
/*     */           }
/* 427 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 432 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 433 */           if (d.planByte1 < 0)
/* 434 */             return null; 
/* 435 */           if (!PlanInterract.null.access$0(PlanInterract.null.this).conn(a, d))
/* 436 */             return null; 
/* 437 */           Humanoid o = PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d);
/* 438 */           if (RND.rBoolean()) {
/* 439 */             a.speed.turn2(a.body(), o.body());
/* 440 */             return (AI.SUBS()).STAND.activateRndDir(a, d, RND.rInt(5));
/*     */           } 
/* 442 */           return (AI.SUBS()).DUMMY.activate(a, d, this.ani[RND.rInt(this.ani.length)].activate(a, d, RND.rFloat(3.0D)));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 447 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 458 */     Humanoid o = PlanInterract.this.friend(a, d);
/* 459 */     if (o == null) {
/* 460 */       string.add(PlanInterract.¤¤hanging);
/* 461 */     } else if (((AIManager)o.ai()).plan() == PlanInterract.this.lookForFriend) {
/* 462 */       string.add(PlanInterract.¤¤nameMeet).insert(0, STATS.APPEARANCE().name(o.indu()));
/* 463 */     } else if (PlanInterract.this.shouldFight(a, o)) {
/* 464 */       string.add(PlanInterract.¤¤fighting).insert(0, STATS.APPEARANCE().name(o.indu()));
/*     */     } else {
/* 466 */       string.add(PlanInterract.¤¤name).insert(0, STATS.APPEARANCE().name(o.indu()));
/*     */     } 
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.first.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\PlanInterract$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */