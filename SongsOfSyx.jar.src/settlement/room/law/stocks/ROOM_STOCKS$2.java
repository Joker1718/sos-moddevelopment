/*    */ package settlement.room.law.stocks;
/*    */ 
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.service.module.RoomServiceNeed;
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
/*    */   extends RoomServiceNeed
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, RoomInitData $anonymous1) {
/* 45 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public FSERVICE service(int tx, int ty) {
/* 49 */     Tile t = ROOM_STOCKS.this.tile.get(tx, ty);
/* 50 */     if (t != null) {
/* 51 */       return t.service;
/*    */     }
/* 53 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\ROOM_STOCKS$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */