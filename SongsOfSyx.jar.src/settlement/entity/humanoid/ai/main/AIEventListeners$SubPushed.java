/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SubPushed
/*     */ {
/* 582 */   private final double flyForce = 1.5D;
/* 583 */   private final CharSequence name = D.g("tackled");
/*     */ 
/*     */   
/*     */   AISUB.AISubActivation push(AIManager d, Humanoid a, double momentum) {
/* 587 */     if (momentum > 5.0D) {
/* 588 */       momentum = 5.0D;
/*     */     }
/*     */     
/* 591 */     if (a.division() != null) {
/* 592 */       (a.division()).reporter.reportReachable(a, false);
/*     */     }
/* 594 */     if (momentum > 1.5D) {
/* 595 */       AISTATE aISTATE = (AI.STATES()).FLY.activate(a, d, (float)(0.25D + (momentum - 1.5D) / 3.0D));
/* 596 */       AISUB.AISubActivation aISubActivation = this.subFly.activate(a, d, aISTATE);
/* 597 */       return aISubActivation;
/*     */     } 
/* 599 */     AISTATE state = (AI.STATES()).layStop.activate(a, d, (2.0F + RND.rFloat(5.0D)));
/* 600 */     AISUB.AISubActivation ac = this.subPushed.activate(a, d, state);
/* 601 */     return ac;
/*     */   }
/*     */ 
/*     */   
/* 605 */   private final AISUB.Simple subFly = new AISUB.Simple("InterFly", this.name)
/*     */     {
/*     */ 
/*     */       
/*     */       protected AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/* 611 */         d.subByte = (byte)(d.subByte + 1);
/* 612 */         if (d.subByte == 1) {
/* 613 */           return (AI.STATES()).layStop.activate(a, d, (10.0F + RND.rFloat(30.0D)));
/*     */         }
/* 615 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 620 */         if (e.event == HEvent.COLLISION_TILE) {
/* 621 */           d.subByte = 0;
/* 622 */           return true;
/* 623 */         }  if (e.event == HEvent.COLLISION_HARD) {
/*     */           
/* 625 */           double mom = e.momentum * a.physics.getMassI() * 0.002232142857142857D;
/*     */           
/* 627 */           if (mom > 1.5D) {
/* 628 */             AISTATE state = (AI.STATES()).FLY.add(a, d, (float)((mom - 1.5D) / 3.0D));
/* 629 */             d.overwrite(a, state);
/* 630 */             d.subByte = 0;
/*     */           } 
/* 632 */           return true;
/*     */         } 
/* 634 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 639 */         if (e.type == HPoll.COLLIDES) {
/* 640 */           return ((a.physics.getZ() < 100.0D) ? true : false);
/*     */         }
/*     */         
/* 643 */         if (e.type == HPoll.WILL_COLLIDE_WITH) {
/* 644 */           if (e.other instanceof Humanoid) {
/* 645 */             return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */           }
/* 647 */           return 0.0D;
/* 648 */         }  if (e.type == HPoll.DEFENCE_SKILL)
/* 649 */           return super.poll(a, d, e) * 0.1D; 
/* 650 */         return 0.0D;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 655 */   private final AISUB.Simple subPushed = new AISUB.Simple("InterPushed", this.name)
/*     */     {
/*     */ 
/*     */       
/*     */       protected AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/* 661 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 666 */         if (e.event == HEvent.COLLISION_TILE) {
/* 667 */           d.subByte = 0;
/* 668 */           return true;
/* 669 */         }  if (e.event == HEvent.COLLISION_HARD) {
/* 670 */           (AI.STATES()).layStop.activate(a, d, (2.0F + RND.rFloat(15.0D)));
/* 671 */           d.subByte = 0;
/* 672 */           return true;
/*     */         } 
/* 674 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 679 */         if (e.type == HPoll.COLLIDES && 
/* 680 */           e.other instanceof Humanoid) {
/* 681 */           return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */         }
/* 683 */         if (e.type == HPoll.WILL_COLLIDE_WITH) {
/* 684 */           if (e.other instanceof Humanoid) {
/* 685 */             return ((((Humanoid)e.other).indu().hostile() != a.indu().hostile()) ? true : false);
/*     */           }
/* 687 */           return 0.0D;
/* 688 */         }  if (e.type == HPoll.DEFENCE_SKILL)
/* 689 */           return super.poll(a, d, e) * 0.2D; 
/* 690 */         return 0.0D;
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIEventListeners$SubPushed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */