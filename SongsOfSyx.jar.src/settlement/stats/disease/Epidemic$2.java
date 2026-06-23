/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import settlement.entity.EntityIterator;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 46 */     (new EntityIterator.Humans()
/*    */       {
/*    */         protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*    */         {
/* 50 */           STATS.DISEASE().cure(h.indu(), false);
/* 51 */           return false;
/*    */         }
/* 53 */       }).iterate();
/* 54 */     Epidemic.this.current = null;
/* 55 */     Epidemic.this.duration = 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Epidemic$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */