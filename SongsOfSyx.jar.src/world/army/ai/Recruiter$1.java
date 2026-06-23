/*    */ package world.army.ai;
/*    */ 
/*    */ import snake2d.util.sets.Tree;
/*    */ import world.army.AD;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Tree<WArmy>
/*    */ {
/*    */   null(int $anonymous0) {
/* 22 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(WArmy current, WArmy cmp) {
/* 26 */     if (AD.menTarget(null).get(current) > AD.menTarget(null).get(cmp))
/* 27 */       return true; 
/* 28 */     return (current.armyIndex() > cmp.armyIndex());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Recruiter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */