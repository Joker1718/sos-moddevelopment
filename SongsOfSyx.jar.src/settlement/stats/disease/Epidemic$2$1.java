/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import settlement.entity.EntityIterator;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.STATS;
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
/*    */   extends EntityIterator.Humans
/*    */ {
/*    */   protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/* 50 */     STATS.DISEASE().cure(h.indu(), false);
/* 51 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Epidemic$2$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */