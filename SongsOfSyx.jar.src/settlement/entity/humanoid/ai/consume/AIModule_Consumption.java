/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.entity.humanoid.ai.main.AIModule;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ 
/*    */ public class AIModule_Consumption
/*    */   extends ArrayList<AIModule> {
/*  8 */   public final AIModule drink = new AIModule_Drink();
/*  9 */   public final AIModule food = new AIModule_Food();
/* 10 */   public final AIModule shop = new AIModule_Shop();
/*    */ 
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */ 
/*    */   
/*    */   public AIModule_Consumption() {
/* 18 */     super(3);
/* 19 */     add(this.drink);
/* 20 */     add(this.food);
/* 21 */     add(this.shop);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\AIModule_Consumption.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */