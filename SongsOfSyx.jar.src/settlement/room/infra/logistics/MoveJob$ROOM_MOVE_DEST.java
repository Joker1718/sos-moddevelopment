/*    */ package settlement.room.infra.logistics;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.misc.util.TILE_STORAGE;
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
/*    */ public interface ROOM_MOVE_DEST
/*    */ {
/*    */   TILE_STORAGE destCrate(RBIT paramRBIT, int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   default TILE_STORAGE fetchToCrate(RESOURCE res, int desiredAm) {
/* 35 */     return destCrate(res.bit, 1, -1, -1);
/*    */   }
/*    */   
/*    */   RBIT destSpaceMask();
/*    */   
/*    */   double storedD(RESOURCE paramRESOURCE);
/*    */   
/*    */   RBIT moveCapacity();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveJob$ROOM_MOVE_DEST.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */