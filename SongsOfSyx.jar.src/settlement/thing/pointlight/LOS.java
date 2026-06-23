/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface LOS
/*    */ {
/* 12 */   public static final LOS OPEN = new LOS()
/*    */     {
/*    */       public boolean passesToOtherFromThis(int fx, int fy, int tx, int ty)
/*    */       {
/* 16 */         return true;
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 21 */         return true;
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean blocksEnv(int tx, int ty) {
/* 26 */         return false;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public boolean isLightBlocker(int tx, int ty) {
/* 32 */         return false;
/*    */       }
/*    */     };
/*    */ 
/*    */   
/* 37 */   public static final LOS SOLID = new LOS()
/*    */     {
/*    */       public boolean passesToOtherFromThis(int fx, int fy, int tx, int ty)
/*    */       {
/* 41 */         return !(SETT.PATH()).solidity.is(tx, ty);
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 46 */         return false;
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean blocksEnv(int tx, int ty) {
/* 51 */         return true;
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean isLightBlocker(int tx, int ty) {
/* 56 */         return true;
/*    */       }
/*    */     };
/*    */ 
/*    */   
/* 61 */   public static final LOS CEILING = new LOS()
/*    */     {
/*    */       public boolean passesToOtherFromThis(int fx, int fy, int tx, int ty)
/*    */       {
/* 65 */         return !SETT.LIGHTS().los().get(tx, ty).isLightBlocker(tx, ty);
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean passesFromOtherToThis(int fx, int fy, int tx, int ty) {
/* 70 */         return true;
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean blocksEnv(int tx, int ty) {
/* 75 */         return false;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public boolean isLightBlocker(int tx, int ty) {
/* 81 */         return false;
/*    */       }
/*    */     };
/*    */   
/*    */   boolean passesToOtherFromThis(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   boolean passesFromOtherToThis(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   boolean isLightBlocker(int paramInt1, int paramInt2);
/*    */   
/*    */   boolean blocksEnv(int paramInt1, int paramInt2);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LOS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */