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
/*    */ class null
/*    */   extends Tree<WArmy>
/*    */ {
/*    */   null(int $anonymous0) {
/* 18 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(WArmy current, WArmy cmp) {
/* 22 */     if (AD.power().get(current) > AD.power().get(cmp))
/* 23 */       return true; 
/* 24 */     return (current.armyIndex() > cmp.armyIndex());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Defender$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */