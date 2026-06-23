/*    */ package game.events.advice;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.standing.STANDINGS;
/*    */ import snake2d.util.file.Json;
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
/*    */   extends EventAdvisor.AdviceHighlight
/*    */ {
/*    */   null(EventAdvisor paramEventAdvisor2, String $anonymous0, String $anonymous1, Json $anonymous2) {
/* 79 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public boolean shouldsend() {
/* 83 */     if ((STANDINGS.CITIZEN()).loyalty.getD(null) < 0.85D && (STATS.POP()).POP.data().get(null) > 15)
/* 84 */       return true; 
/* 85 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\advice\EventAdvisor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */