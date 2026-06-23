/*     */ package settlement.entity.humanoid.ai.types.child;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import java.util.Comparator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.service.nursery.ROOM_NURSERY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AIModule_Child.Plan
/*     */ {
/*     */   private final ArrayListGrower<ROOM_NURSERY> best;
/*     */   private HCLASS sortClass;
/*     */   private Race sortRace;
/*     */   private final Comparator<ROOM_NURSERY> comp;
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer study;
/*     */   
/*     */   null(AIModule_Child paramAIModule_Child2, String $anonymous0) {
/* 453 */     super($anonymous0);
/*     */     
/* 455 */     this.best = new ArrayListGrower();
/*     */     
/* 457 */     for (ROOM_NURSERY n : (SETT.ROOMS()).NURSERIES) {
/* 458 */       this.best.add(n);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 463 */     this.comp = new Comparator<ROOM_NURSERY>()
/*     */       {
/*     */         public int compare(ROOM_NURSERY o1, ROOM_NURSERY o2)
/*     */         {
/* 467 */           double v1 = (o1.stat().total()).standing.def(AIModule_Child.null.this.sortClass, AIModule_Child.null.this.sortRace);
/* 468 */           double v2 = (o2.stat().total()).standing.def(AIModule_Child.null.this.sortClass, AIModule_Child.null.this.sortRace);
/* 469 */           if (v1 > v2)
/* 470 */             return 1; 
/* 471 */           return (v2 > v1) ? -1 : 0;
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
/* 510 */     this.walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤nursinging)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 514 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 519 */           return AIModule_Child.null.this.study.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 525 */           return (AIModule_Child.null.this.b(d) != null && AIModule_Child.null.this.ss(d) != null && AIModule_Child.null.this.ss(d).findableReservedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 530 */           FSERVICE f = AIModule_Child.null.this.ss(d);
/* 531 */           if (f != null && f.findableReservedIs()) {
/* 532 */             f.findableReserveCancel();
/*     */           }
/*     */         }
/*     */       };
/* 536 */     this.study = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤nursinging)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 540 */           d.planByte2 = 0;
/* 541 */           AIModule_Child.null.this.ss(d).startUsing();
/* 542 */           return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 549 */           if (!AIModule_Child.null.access$0(AIModule_Child.null.this).isTime() || !AIModule_Child.null.access$0(AIModule_Child.null.this).moduleCanContinue(a, d)) {
/* 550 */             can(a, d);
/* 551 */             return null;
/*     */           } 
/*     */           
/* 554 */           d.planByte2 = (byte)(d.planByte2 + 1);
/* 555 */           if ((d.planByte2 * 5) < 120.0D) {
/* 556 */             if (RND.rBoolean())
/* 557 */               return (AI.SUBS()).WORK_HANDS.activate(a, d, 5.0D); 
/* 558 */             return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */           } 
/*     */           
/* 561 */           AIModule_Child.null.this.ss(d).startUsing();
/*     */           
/* 563 */           FSERVICE c = AIModule_Child.null.this.b(d).getOther((COORDINATE)d.planTile);
/*     */           
/* 565 */           if (c != null && d.path.request(a.tc(), (COORDINATE)c)) {
/* 566 */             can(a, d);
/* 567 */             d.planTile.set(d.path.destX(), d.path.destY());
/* 568 */             AIModule_Child.null.this.ss(d).findableReserve();
/* 569 */             AIModule_Child.null.this.walk.set(a, d);
/* 570 */             return (AI.SUBS()).walkTo.path(a, d);
/*     */           } 
/*     */           
/* 573 */           return setAction(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 579 */           return (AIModule_Child.null.this.b(d) != null && AIModule_Child.null.this.ss(d) != null && AIModule_Child.null.this.ss(d).findableReservedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 584 */           FSERVICE f = AIModule_Child.null.this.ss(d);
/* 585 */           if (f != null && f.findableReservedIs())
/* 586 */             f.findableReserveCancel(); 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     this.sortClass = a.indu().hType().parentClass();
/*     */     this.sortRace = a.race();
/*     */     this.best.sort(this.comp);
/*     */     for (ROOM_NURSERY n : this.best)
/*     */       n.stat().setAccess(a, false); 
/*     */     for (ROOM_NURSERY n : this.best) {
/*     */       if (n.stat().accessRequest(a)) {
/*     */         AISUB.AISubActivation ss = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(n.service()).finder, n.radius());
/*     */         if (ss != null) {
/*     */           d.planTile.set(d.path.destX(), d.path.destY());
/*     */           d.planByte1 = (byte)n.typeIndex();
/*     */           n.stat().setAccess(a, true);
/*     */           this.walk.set(a, d);
/*     */           return ss;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   
/*     */   private ROOM_NURSERY b(AIManager d) {
/*     */     return (ROOM_NURSERY)(SETT.ROOMS()).NURSERIES.get(d.planByte1);
/*     */   }
/*     */   
/*     */   FSERVICE ss(AIManager d) {
/*     */     return b(d).service().service(d.planTile.x(), d.planTile.y());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\child\AIModule_Child$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */