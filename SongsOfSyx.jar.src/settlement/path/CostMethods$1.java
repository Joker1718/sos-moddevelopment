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
/*    */ class null
/*    */   implements PathGame.COST
/*    */ {
/*    */   public double getCost(int fromX, int fromY, int toX, int toY) {
/* 17 */     AVAILABILITY a = SETT.PATH().getAvailability(toX, toY);
/* 18 */     if (a.player < 0.0D) {
/* 19 */       return -1.0D;
/*    */     }
/* 21 */     if (fromX != toX && fromY != toY && (
/* 22 */       (SETT.PATH().getAvailability(fromX, toY)).player <= -1.0D || (SETT.PATH().getAvailability(toX, fromY)).player <= -1.0D)) {
/* 23 */       return -2.0D;
/*    */     }
/*    */ 
/*    */     
/* 27 */     return a.player + (SETT.PATH().getAvailability(fromX, fromY)).from;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\CostMethods$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */