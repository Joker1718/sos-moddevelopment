/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.spirte.HSprite;
/*    */ 
/*    */ public abstract class AISTATE
/*    */   extends AI.AIElement
/*    */ {
/*    */   private final String name;
/*    */   
/*    */   AISTATE(String key, String name) {
/* 12 */     super("STATE_" + key);
/* 13 */     this.name = name;
/*    */   }
/*    */   
/*    */   public abstract HSprite sprite(Humanoid paramHumanoid);
/*    */   
/*    */   protected String name() {
/* 19 */     return this.name;
/*    */   }
/*    */   
/*    */   protected abstract boolean update(Humanoid paramHumanoid, AIManager paramAIManager, double paramDouble);
/*    */   
/*    */   public static abstract class Custom
/*    */     extends AISTATE {
/*    */     public Custom(String key, String name, HSprite sprite) {
/* 27 */       super("STATE_" + key, name);
/* 28 */       this.sprite = sprite;
/*    */     }
/*    */     private final HSprite sprite;
/*    */     
/*    */     public HSprite sprite(Humanoid a) {
/* 33 */       return this.sprite;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */