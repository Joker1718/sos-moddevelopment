/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComponent;
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
/*    */   implements SFINDER
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 67 */     return c.hasEdge();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTile(int tx, int ty, int tile) {
/* 72 */     if ((SETT.PATH()).solidity.is(tx, ty))
/* 73 */       return false; 
/* 74 */     return !(tx != 0 && tx != SETT.TWIDTH - 1 && ty != 0 && ty != SETT.THEIGHT - 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderEntry$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */