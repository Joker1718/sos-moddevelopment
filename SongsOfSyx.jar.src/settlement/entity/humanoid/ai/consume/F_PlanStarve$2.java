/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.path.finders.SFinderMisc;
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
/*    */   extends SFinderMisc.FinderMiscWithoutDest
/*    */ {
/*    */   null(int $anonymous0) {
/* 73 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean has() {
/* 77 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTile(int tx, int ty) {
/* 82 */     return (F_PlanStarve.this.corpse(tx, ty) != null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_PlanStarve$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */