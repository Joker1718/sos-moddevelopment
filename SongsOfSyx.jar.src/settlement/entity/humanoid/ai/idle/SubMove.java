/*    */ package settlement.entity.humanoid.ai.idle;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ class SubMove
/*    */   extends AISUB.Simple {
/*    */   public SubMove(String key) {
/* 16 */     super(key);
/*    */   }
/*    */   
/*    */   public AISTATE resume(Humanoid a, AIManager d) {
/*    */     DIR di;
/*    */     int x1;
/*    */     int y1;
/*    */     double c;
/* 24 */     if (!a.speed.isZero()) {
/* 25 */       return (AI.STATES()).STOP.instant(a, d);
/*    */     }
/*    */     
/* 28 */     switch (d.subByte) {
/*    */       case 0:
/* 30 */         d.subByte = 1;
/* 31 */         if ((AI.STATES()).WALK2.cTileNeeds(a, d))
/*    */         {
/* 33 */           return (AI.STATES()).WALK2.cTile(a, d);
/*    */         }
/* 35 */         return (AI.STATES()).STOP.instant(a, d);
/*    */       case 1:
/* 37 */         di = (DIR)DIR.ALL.rnd();
/* 38 */         x1 = a.physics.tileC().x();
/* 39 */         y1 = a.physics.tileC().y();
/* 40 */         d.subByte = 2;
/* 41 */         c = (SETT.PATH()).coster.player.getCost(x1, y1, x1 + di.x(), y1 + di.y());
/* 42 */         if (c > 0.0D && c <= 1.0D && (SETT.PATH()).finders.isGoodTileToStandOn(x1 + di.x(), y1 + di.y(), (ENTITY)a))
/*    */         {
/* 44 */           return (AI.STATES()).WALK2.dirTile(a, d, di); } 
/* 45 */         if (RND.rBoolean()) {
/* 46 */           return (AI.STATES()).STAND.activate(a, d, (1.0F + RND.rFloat(5.0D)));
/*    */         }
/*    */       case 2:
/* 49 */         d.subByte = 100;
/* 50 */         return (AI.STATES()).STOP.activate(a, d);
/*    */     } 
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\SubMove.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */