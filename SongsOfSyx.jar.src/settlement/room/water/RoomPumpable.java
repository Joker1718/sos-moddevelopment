/*    */ package settlement.room.water;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RoomPumpable
/*    */ {
/*    */   protected abstract void drain(int paramInt1, int paramInt2);
/*    */   
/*    */   protected abstract void pump(int paramInt1, int paramInt2, DIR paramDIR, int paramInt3);
/*    */   
/*    */   protected void pumpFail(int tx, int ty, int dirmask) {}
/*    */   
/*    */   protected abstract int dirmask(int paramInt1, int paramInt2);
/*    */   
/*    */   protected int radius() {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */   public static void reportChange(int tx, int ty, int radius) {
/* 29 */     (SETT.ROOMS()).WATER.updater.reportChange(tx, ty, radius);
/*    */   }
/*    */   
/*    */   protected abstract boolean pumpsTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   public double suckAmount(int tx, int ty) {
/* 35 */     return 1.0D;
/*    */   }
/*    */   
/*    */   public abstract double irrigation(int paramInt1, int paramInt2);
/*    */   
/*    */   public static interface ROOM_PUMPABLE {
/*    */     RoomPumpable pumpable(int param1Int1, int param1Int2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\RoomPumpable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */