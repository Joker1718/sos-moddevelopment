/*    */ package settlement.entity.humanoid.ai.util;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ 
/*    */ public abstract class AIPlanWalkPath extends AIPLAN.PLANRES {
/*    */   private final CharSequence name;
/*    */   private final boolean full;
/*    */   private final AIPLAN.PLANRES.Resumer walk;
/*    */   
/*    */   public AIPlanWalkPath(String key, CharSequence name) {
/* 16 */     this(key, name, false);
/*    */   }
/*    */   
/*    */   public AIPlanWalkPath(String key, CharSequence name, boolean full) {
/* 20 */     super(key);
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
/* 35 */     this.walk = new AIPLAN.PLANRES.Resumer(this)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 39 */           if (AIPlanWalkPath.this.full)
/* 40 */             return (AI.SUBS()).walkTo.pathFull(a, d); 
/* 41 */           return (AI.SUBS()).walkTo.path(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 46 */           return AIPlanWalkPath.this.next(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 51 */           return true;
/*    */         }
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */     this.name = name;
/*    */     this.full = full;
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.walk.set(a, d);
/*    */   }
/*    */   
/*    */   protected void name(Humanoid a, AIManager d, Str string) {
/*    */     string.add(this.name);
/*    */   }
/*    */   
/*    */   public abstract AISUB.AISubActivation next(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\a\\util\AIPlanWalkPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */