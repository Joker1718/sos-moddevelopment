/*    */ package game.events.advice;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
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
/*    */ class null
/*    */   extends EventAdvisor.AdviceHighlight
/*    */ {
/*    */   null(EventAdvisor paramEventAdvisor2, String $anonymous0, String $anonymous1, Json $anonymous2) {
/* 43 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldsend() {
/* 48 */     int t = STATS.WORK().workforce();
/* 49 */     int e = (SETT.ROOMS()).employment.NEEDED.get();
/* 50 */     if (t - e < -5) {
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\advice\EventAdvisor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */