/*    */ package settlement.entity.humanoid.ai.subwalk;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
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
/*    */ class null
/*    */   extends AISUB.Resumable.Resumer
/*    */ {
/*    */   null(AISUB.Resumable paramResumable) {
/* 49 */     super(paramResumable);
/*    */   }
/*    */   
/*    */   public AISTATE res(Humanoid a, AIManager d) {
/* 53 */     if (d.path.isDest()) {
/* 54 */       a.speed.turn2((BODY_HOLDER)a, ((d.path.destX() << 6) + 32), ((d.path.destY() << 6) + 32));
/* 55 */       return PathWalker.this.setLast(a, d);
/*    */     } 
/*    */     
/* 58 */     d.path.setNext();
/* 59 */     if (!d.path.isSuccessful()) {
/* 60 */       GAME.Notify("no " + String.valueOf(a.physics.tileC()) + " " + d.path.destX() + " " + d.path.destY());
/* 61 */       return PathWalker.this.failure.set(a, d);
/*    */     } 
/* 63 */     d.subPathByte2 = (byte)(d.subPathByte2 + 1);
/* 64 */     if (d.subPathByte2 > 4) {
/* 65 */       d.subPathByte2 = 0;
/* 66 */       if (PathWalker.this.hasFailed(a, d)) {
/* 67 */         a.speed.magnitudeInit(0.0D);
/* 68 */         return PathWalker.this.failure.set(a, d);
/*    */       } 
/*    */     } 
/*    */     
/* 72 */     return PathWalker.this.state.path(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean success(Humanoid a, AIManager d) {
/* 77 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 83 */     PathWalker.this.abort(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 88 */     return res(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\PathWalker$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */