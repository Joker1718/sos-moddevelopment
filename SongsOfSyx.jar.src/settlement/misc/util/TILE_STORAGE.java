/*    */ package settlement.misc.util;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ public interface TILE_STORAGE
/*    */   extends COORDINATE
/*    */ {
/*    */   RESOURCE resource();
/*    */   
/*    */   void storageDeposit(int paramInt);
/*    */   
/*    */   int storageReservable();
/*    */   
/*    */   default boolean storageIsFindable() {
/* 16 */     return true;
/*    */   }
/*    */   
/*    */   int storageReserved();
/*    */   
/*    */   void storageReserve(int paramInt);
/*    */   
/*    */   void storageUnreserve(int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\mis\\util\TILE_STORAGE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */