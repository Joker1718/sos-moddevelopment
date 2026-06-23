/*     */ package settlement.entity.humanoid.ai.types.child;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import java.util.Comparator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.knowledge.school.ROOM_SCHOOL;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final ArrayListGrower<ROOM_SCHOOL> best;
/*     */   private Induvidual sorti;
/*     */   private final Comparator<ROOM_SCHOOL> comp;
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer study;
/*     */   
/*     */   null(AIModule_Child paramAIModule_Child2, String $anonymous0) {
/* 593 */     super($anonymous0);
/*     */     
/* 595 */     this.best = new ArrayListGrower();
/*     */ 
/*     */     
/* 598 */     for (ROOM_SCHOOL n : (SETT.ROOMS()).SCHOOLS) {
/* 599 */       this.best.add(n);
/*     */     }
/*     */ 
/*     */     
/* 603 */     this.comp = new Comparator<ROOM_SCHOOL>()
/*     */       {
/*     */         public int compare(ROOM_SCHOOL o1, ROOM_SCHOOL o2)
/*     */         {
/* 607 */           double v1 = o1.bonus().get((BOOSTABLE_O)AIModule_Child.null.this.sorti);
/* 608 */           double v2 = o2.bonus().get((BOOSTABLE_O)AIModule_Child.null.this.sorti);
/* 609 */           if (v1 > v2)
/* 610 */             return 1; 
/* 611 */           return (v2 > v1) ? -1 : 0;
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
/* 641 */     this.walk = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤Studying)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 645 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 650 */           return AIModule_Child.null.this.study.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 656 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 666 */     this.study = new AIPLAN.PLANRES.Resumer(this, AIModule_Child.¤¤Studying)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 670 */           d.planByte2 = 0;
/* 671 */           d.planTile.set(d.path.destX(), d.path.destY());
/* 672 */           DIR dir = AIModule_Child.null.this.b(d).childDir(d.path.destX(), d.path.destY());
/* 673 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, d.path.destX() + dir.x(), d.path.destY() + dir.y());
/* 674 */           ss(d).startUsing();
/* 675 */           if (s != null)
/* 676 */             return s; 
/* 677 */           AIModule_Child.null.this.cancel(a, d);
/* 678 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 684 */           d.planByte2 = (byte)(d.planByte2 + 1);
/*     */           
/* 686 */           if (d.planByte2 > 5 && !AIModule_Child.null.access$1(AIModule_Child.null.this).isTime()) {
/* 687 */             FSERVICE f = ss(d);
/* 688 */             f.consume();
/* 689 */             if (AIModule_Child.null.this.b(d) != null)
/* 690 */               (STATS.EDUCATION()).child.educate(a.indu(), AIModule_Child.null.this.b(d).learningSpeed(a, a.tc().x(), a.tc().y())); 
/* 691 */             return null;
/*     */           } 
/*     */           
/* 694 */           DIR dir = AIModule_Child.null.this.b(d).childDir(d.planTile.x(), d.planTile.y());
/* 695 */           if (RND.oneIn(5)) {
/* 696 */             dir = dir.next(-2 + RND.rInt(5));
/*     */           }
/* 698 */           a.speed.setDirCurrent(dir);
/* 699 */           return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */         }
/*     */ 
/*     */         
/*     */         FSERVICE ss(AIManager d) {
/* 704 */           return AIModule_Child.null.this.b(d).service().service(d.planTile.x(), d.planTile.y());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 710 */           return (AIModule_Child.null.this.b(d) != null && ss(d) != null && ss(d).findableReservedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 715 */           FSERVICE f = ss(d);
/* 716 */           if (f != null && f.findableReservedIs())
/* 717 */             f.findableReserveCancel(); 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     this.sorti = a.indu();
/*     */     this.best.sort(this.comp);
/*     */     for (ROOM_SCHOOL s : this.best) {
/*     */       AISUB.AISubActivation ss = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(s.service()).finder, 250);
/*     */       if (ss != null) {
/*     */         d.planByte1 = (byte)s.typeIndex();
/*     */         this.walk.set(a, d);
/*     */         return ss;
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private ROOM_SCHOOL b(AIManager d) {
/*     */     return (ROOM_SCHOOL)(SETT.ROOMS()).SCHOOLS.get(d.planByte1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\child\AIModule_Child$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */