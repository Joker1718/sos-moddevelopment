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
/* 65 */     return !SETT.LIGHTS().los().get(tx, ty).isLightBlocker(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 70 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean blocksEnv(int tx, int ty) {
/* 75 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isLightBlocker(int tx, int ty) {
/* 81 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LOS$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */