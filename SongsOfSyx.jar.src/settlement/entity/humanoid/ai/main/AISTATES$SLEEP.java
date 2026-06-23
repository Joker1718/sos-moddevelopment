/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.spirte.HSprite;
/*    */ import settlement.entity.humanoid.spirte.HSprites;
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
/*    */ 
/*    */ 
/*    */ public class SLEEP
/*    */ {
/*    */   public AISTATE activate(Humanoid a, AIManager d, float time) {
/* 55 */     d.stateTimer = time;
/* 56 */     a.speed.magnitudeInit(0.0D);
/* 57 */     a.speed.magnitudeTargetSet(0.0D);
/* 58 */     if (!a.speed.dir().isOrtho())
/* 59 */       a.speed.setDirCurrent(a.speed.dir().next(1)); 
/* 60 */     return this.state;
/*    */   }
/*    */   
/* 63 */   private final AISTATE state = new AISTATE("SLEEP", "sleeping")
/*    */     {
/*    */       public HSprite sprite(Humanoid a)
/*    */       {
/* 67 */         return HSprites.SLEEP;
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean update(Humanoid a, AIManager d, double ds) {
/* 72 */         d.stateTimer = (float)(d.stateTimer - ds);
/* 73 */         if (d.stateTimer <= 0.0F) {
/* 74 */           return false;
/*    */         }
/* 76 */         return true;
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES$SLEEP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */