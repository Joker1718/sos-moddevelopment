/*    */ package settlement.thing.halfEntity;
/*    */ 
/*    */ import snake2d.util.sets.Tree;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Tree<HalfEntity>
/*    */ {
/*    */   null(int $anonymous0) {
/* 38 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(HalfEntity current, HalfEntity cmp) {
/* 42 */     return (current.getZ() < cmp.getZ());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\HalfEnts$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */