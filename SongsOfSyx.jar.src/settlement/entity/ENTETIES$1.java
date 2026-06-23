/*    */ package settlement.entity;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Tree<ENTITY>
/*    */ {
/*    */   null(int $anonymous0) {
/* 49 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(ENTITY current, ENTITY cmp) {
/* 53 */     double d = current.height() + current.physics.getZ() - cmp.height() + cmp.physics.getZ();
/* 54 */     if (d > 0.0D)
/* 55 */       return true; 
/* 56 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\ENTETIES$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */