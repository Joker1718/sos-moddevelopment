/*    */ package settlement.entity.humanoid.ai.types.guard;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SCompNLevel;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.components.SComponentEdge;
/*    */ 
/*    */ class PlanMop
/*    */   extends AIPLAN.PLANRES {
/*    */   public PlanMop() {
/* 17 */     super("Guard mop");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 25 */     this.first = new AIPLAN.PLANRES.Resumer(this, "")
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 29 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 0);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 35 */           int ee = 0;
/* 36 */           int ff = 0;
/*    */           
/* 38 */           SComponent ss = (SComponent)((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(a.tc());
/* 39 */           if (ss == null) {
/* 40 */             return null;
/*    */           }
/* 42 */           ee += (SETT.PATH()).comps.data.people(a.indu().hostile()).get(ss);
/* 43 */           ff += (SETT.PATH()).comps.data.people(!a.indu().hostile()).get(ss);
/* 44 */           SComponentEdge e = ss.edgefirst();
/* 45 */           while (e != null) {
/* 46 */             ee += (SETT.PATH()).comps.data.people(a.indu().hostile()).get(e.to());
/* 47 */             ff += (SETT.PATH()).comps.data.people(!a.indu().hostile()).get(e.to());
/* 48 */             e = e.next();
/*    */           } 
/*    */           
/* 51 */           if (ee == 0) {
/* 52 */             return null;
/*    */           }
/* 54 */           ff / 2;
/*    */ 
/*    */ 
/*    */           
/* 58 */           Humanoid aa = (SETT.PATH()).finders.otherHumanoid.enemy(a, 64);
/*    */ 
/*    */ 
/*    */           
/* 62 */           if (ee > ff / 2)
/* 63 */             return d.resumeOtherPlan(a, AI.listeners().flee(a, d, (ENTITY)aa)); 
/* 64 */           if (aa != null) {
/* 65 */             return d.resumeOtherPlan(a, AI.listeners().catchCriminal(aa));
/*    */           }
/* 67 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 72 */           return true;
/*    */         }
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */   }
/*    */   
/*    */   private final AIPLAN.PLANRES.Resumer first;
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.first.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanMop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */