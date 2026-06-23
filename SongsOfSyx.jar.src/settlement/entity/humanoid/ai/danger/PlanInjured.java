/*    */ package settlement.entity.humanoid.ai.danger;
/*    */ 
/*    */ import game.audio.AUDIO;
/*    */ import game.audio.SoundRace;
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.D;
/*    */ 
/*    */ class PlanInjured
/*    */   extends AIPLAN.PLANRES
/*    */ {
/* 18 */   private static CharSequence ¤¤name = "Bleeding out";
/* 19 */   private final SubPlanSeekHospital ho = new SubPlanSeekHospital(this);
/*    */   
/* 21 */   public final SoundRace sound = AUDIO.race("IN_PAIN_MOAN");
/*    */   
/*    */   static {
/* 24 */     D.ts(PlanInjured.class);
/*    */   }
/*    */   private final AIPLAN.PLANRES.Resumer res;
/*    */   public PlanInjured(String key) {
/* 28 */     super(key);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 39 */     this.res = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*    */       {
/*    */         
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 44 */           if (RND.oneIn(10))
/* 45 */             PlanInjured.this.sound.rnd(a); 
/* 46 */           return (AI.SUBS()).LAY.activate(a, d);
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 54 */           if ((STATS.NEEDS()).INJURIES.COUNT.indu().isMax(a.indu())) {
/* 55 */             Humanoid.HumanoidResource.dead = (a.lastLeaveCause() != null) ? a.lastLeaveCause() : CAUSE_LEAVES.getAccident();
/*    */           
/*    */           }
/* 58 */           else if (!(STATS.NEEDS()).INJURIES.inDanger(a.indu())) {
/* 59 */             return null;
/*    */           } 
/*    */           
/* 62 */           AISUB.AISubActivation s = PlanInjured.this.ho.init(a, d);
/* 63 */           if (s != null) {
/* 64 */             return s;
/*    */           }
/* 66 */           return set(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 71 */           return true;
/*    */         }
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     AISUB.AISubActivation s = this.ho.init(a, d);
/*    */     if (s != null)
/*    */       return s; 
/*    */     return this.res.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\PlanInjured.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */