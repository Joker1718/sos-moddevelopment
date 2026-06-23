/*    */ package settlement.entity.humanoid.ai.service;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.service.hygine.bath.ROOM_BATH;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.rnd.RND;
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
/*    */   extends AISUB.Simple
/*    */ {
/*    */   null(String $anonymous0) {
/* 34 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 39 */     if (!a.speed.isZero()) {
/* 40 */       a.speed.magnitudeInit(0.0D);
/*    */     }
/* 42 */     d.subByte = (byte)(d.subByte + 1);
/*    */     
/* 44 */     if (d.subByte > 20) {
/* 45 */       cancel(a, d);
/* 46 */       return null;
/*    */     } 
/*    */     
/* 49 */     if (d.subByte == 1) {
/* 50 */       for (DIR dir : DIR.ORTHO) {
/* 51 */         int x = a.physics.tileC().x() + dir.x();
/* 52 */         int y = a.physics.tileC().y() + dir.y();
/* 53 */         if (ROOM_BATH.isPool(x, y))
/* 54 */           return (AI.STATES()).WALK2.dirTile(a, d, dir); 
/*    */       } 
/* 56 */       d.debug(a, "No bath!");
/* 57 */       return (AI.STATES()).STAND.aDirRND(a, d, 1.0F + RND.rFloat(2.0D));
/*    */     } 
/*    */     
/* 60 */     if (d.subByte > 1) {
/* 61 */       (STATS.POP()).NAKED.set(a.indu(), 0);
/*    */     }
/*    */     
/* 64 */     return (AI.STATES()).STAND.aDirRND(a, d, 1.0F + RND.rFloat(2.0D));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager ai, HEvent.HEventData e) {
/* 70 */     if (e.event == HEvent.MEET_HARMLESS) {
/* 71 */       if (a.speed.isZero()) {
/* 72 */         DIR d = (DIR)DIR.ORTHO.get(RND.rInt(4));
/* 73 */         for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 74 */           int x = a.physics.tileC().x() + d.x();
/* 75 */           int y = a.physics.tileC().y() + d.y();
/* 76 */           if (ROOM_BATH.isPool(x, y) && !SETT.ENTITIES().hasAtTile((ENTITY)a, x, y)) {
/* 77 */             ai.overwrite(a, (AI.STATES()).WALK2.tile(a, ai, x, y));
/*    */           }
/* 79 */           d = d.next(2);
/*    */         } 
/*    */       } 
/*    */       
/* 83 */       return false;
/*    */     } 
/* 85 */     return super.event(a, ai, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanBath$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */