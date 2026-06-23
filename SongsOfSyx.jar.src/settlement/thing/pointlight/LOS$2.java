/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */   implements LOS
/*    */ {
/*    */   public boolean passesToOtherFromThis(int fx, int fy, int tx, int ty) {
/* 41 */     return !(SETT.PATH()).solidity.is(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean blocksEnv(int tx, int ty) {
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isLightBlocker(int tx, int ty) {
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LOS$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */