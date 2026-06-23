/*    */ package settlement.entity;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.service.hygine.bath.ROOM_BATH;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubmergedMap
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tx, int ty) {
/* 16 */     if (ROOM_BATH.isPool(tx, ty)) {
/* 17 */       return true;
/*    */     }
/* 19 */     if ((SETT.TERRAIN()).WATER.ice.is(tx, ty))
/* 20 */       return false; 
/* 21 */     if ((SETT.TERRAIN()).WATER.open.is(tx, ty))
/* 22 */       return true; 
/* 23 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 24 */     if (r != null && r.blueprint() instanceof settlement.room.water.pool.ROOM_POOL)
/* 25 */       return true; 
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 31 */     throw new RuntimeException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\SubmergedMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */