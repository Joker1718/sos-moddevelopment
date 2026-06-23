/*    */ package settlement.entity.humanoid.ai.danger;
/*    */ 
/*    */ import settlement.entity.humanoid.ai.main.AIModule;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public final class AIModule_Danger
/*    */ {
/*    */   public final LIST<AIModule> all;
/*    */   
/*    */   public AIModule_Danger() {
/* 12 */     ArrayListGrower<AIModule> all = new ArrayListGrower();
/* 13 */     all.add(new AIModule_Exposure());
/* 14 */     all.add(new AIModule_Health());
/* 15 */     this.all = (LIST<AIModule>)all;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\AIModule_Danger.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */