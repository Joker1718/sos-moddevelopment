/*    */ package settlement.entity.humanoid.ai.battle;
/*    */ 
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*    */ class null
/*    */   extends AISUB.Simple
/*    */ {
/*    */   null(String $anonymous0) {
/* 23 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 27 */     return activate(a, d, (AI.STATES()).STOP.activate(a, d, 0.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 32 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 37 */     if (e.event == HEvent.COLLISION_TILE) {
/* 38 */       if ((AI.modules()).battle.tile.shouldattackTile(d, a, e.tx, e.ty)) {
/* 39 */         d.interrupt(a, e);
/* 40 */         d.overwrite(a, (AI.modules()).battle.tile.init(d, a, e.tx, e.ty));
/*    */       } else {
/* 42 */         d.interrupt(a, e);
/* 43 */         d.overwrite(a, MarchSubCutTo.this.inter.activate(a, d));
/*    */       } 
/*    */       
/* 46 */       return false;
/*    */     } 
/*    */     
/* 49 */     return InterBattle.listener.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchSubCutTo$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */