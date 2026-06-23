/*    */ package world.entity;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Tree<WEntity>
/*    */ {
/*    */   null(int $anonymous0) {
/* 44 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(WEntity current, WEntity cmp) {
/* 48 */     return (current.getZ() < cmp.getZ());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\WEntities$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */