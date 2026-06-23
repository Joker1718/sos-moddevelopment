/*    */ package settlement.entity.humanoid.ai.idle;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
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
/*    */   extends AISUB.Simple
/*    */ {
/*    */   null(String $anonymous0, CharSequence $anonymous1) {
/* 50 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 54 */     d.subByte = (byte)(d.subByte + 1);
/* 55 */     switch (d.subByte) {
/*    */       case 1:
/* 57 */         (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/* 58 */         return (AI.STATES()).STOP.instant(a, d);
/* 59 */       case 2: return (AI.STATES()).STAND.activate(a, d, 1.5D);
/*    */       case 3:
/* 61 */         if ((SETT.PATH()).finders.getOutofWay.checkAndSetRequest(a.tc().x(), a.tc().y(), d.path) && 
/* 62 */           d.path.isSuccessful()) {
/* 63 */           d.overwrite(a, (AI.SUBS()).walkTo.path(a, d));
/*    */         }
/*    */       case 4:
/* 66 */         return (AI.STATES()).STOP.activate(a, d);
/* 67 */       case 5: return (AI.STATES()).STAND.activate(a, d, (3.0F + RND.rFloat(3.0D)));
/*    */     } 
/* 69 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\Inter$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */