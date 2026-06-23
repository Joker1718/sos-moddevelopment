/*    */ package settlement.path;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.PathGame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements PathGame.COST
/*    */ {
/*    */   public double getCost(int fromX, int fromY, int toX, int toY) {
/* 36 */     AVAILABILITY a = SETT.PATH().getAvailability(toX, toY);
/* 37 */     if (a.enemy < 0.0D) {
/* 38 */       return -1.0D;
/*    */     }
/* 40 */     if (fromX != toX && fromY != toY && (
/* 41 */       (SETT.PATH().getAvailability(fromX, toY)).enemy <= -1.0D || (SETT.PATH().getAvailability(toX, fromY)).enemy <= -1.0D)) {
/* 42 */       return -2.0D;
/*    */     }
/*    */ 
/*    */     
/* 46 */     return a.enemy;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\CostMethods$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */