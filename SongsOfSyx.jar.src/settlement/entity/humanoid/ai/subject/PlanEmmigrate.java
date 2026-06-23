/*    */ package settlement.entity.humanoid.ai.subject;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import util.text.D;
/*    */ import world.WORLD;
/*    */ 
/*    */ class PlanEmmigrate
/*    */   extends AIPLAN.PLANRES
/*    */ {
/* 19 */   private static CharSequence ¤¤name = "¤Fed up with this dump and your failing rule.";
/*    */   
/*    */   public PlanEmmigrate() {
/* 22 */     super("SubEmigrate");
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
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 67 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 71 */           if ((SETT.PATH()).finders.entryPoints.find(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/* 72 */             (STATS.POP()).EMMIGRATING.indu().set(a.indu(), 1);
/* 73 */             (STATS.WORK()).EMPLOYED.set(a, null);
/* 74 */             (STATS.BATTLE()).RECRUIT.set(a, null);
/* 75 */             (STATS.BATTLE()).DIV.set(a, null);
/* 76 */             return (AI.SUBS()).walkTo.path(a, d);
/*    */           } 
/* 78 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 83 */           Humanoid.HumanoidResource.dead = CAUSE_LEAVES.EMMIGRATED();
/* 84 */           (STATS.POP()).EMMIGRATING.indu().set(a.indu(), 0);
/* 85 */           return (AI.SUBS()).STAND.activate(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 90 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 95 */           (STATS.POP()).EMMIGRATING.indu().set(a.indu(), 0);
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   private final AIPLAN.PLANRES.Resumer walk;
/*    */   
/*    */   static {
/*    */     D.ts(PlanEmmigrate.class);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     (GAME.events()).riot.emigrate(a);
/*    */     return this.walk.set(a, d);
/*    */   }
/*    */   
/*    */   boolean shouldEmmigrate(Humanoid a) {
/*    */     if (a.indu().clas() != HCLASSES.CITIZEN())
/*    */       return false; 
/*    */     if (SETT.ENTRY().isClosed())
/*    */       return false; 
/*    */     if (WORLD.camps().available(a.race()) && WORLD.camps().current(a.indu().faction(), a.race()) < (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(a.race()))
/*    */       return true; 
/*    */     if (!(GAME.events()).riot.shouldEmigrate(a))
/*    */       return false; 
/*    */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\PlanEmmigrate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */