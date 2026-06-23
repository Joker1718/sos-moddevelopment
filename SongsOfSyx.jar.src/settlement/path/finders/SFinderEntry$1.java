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
/*    */ class null
/*    */   implements SFINDER
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 49 */     return c.hasEntry();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTile(int tx, int ty, int tileNr) {
/* 54 */     if ((SETT.PATH()).solidity.is(tx, ty))
/* 55 */       return false; 
/* 56 */     if (tx == 0 || tx == SETT.TWIDTH - 1 || ty == 0 || ty == SETT.THEIGHT - 1) {
/* 57 */       return (SETT.ENTRY()).points.map.is(tx, ty);
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderEntry$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */