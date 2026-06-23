/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.spirte.HSprite;
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
/*    */ public abstract class Custom
/*    */   extends AISTATE
/*    */ {
/*    */   private final HSprite sprite;
/*    */   
/*    */   public Custom(String key, String name, HSprite sprite) {
/* 27 */     super("STATE_" + key, name);
/* 28 */     this.sprite = sprite;
/*    */   }
/*    */ 
/*    */   
/*    */   public HSprite sprite(Humanoid a) {
/* 33 */     return this.sprite;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATE$Custom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */