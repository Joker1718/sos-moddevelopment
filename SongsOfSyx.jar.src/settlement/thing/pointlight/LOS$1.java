/*    */ package settlement.thing.pointlight;
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
/* 16 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 21 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean blocksEnv(int tx, int ty) {
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isLightBlocker(int tx, int ty) {
/* 32 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LOS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */