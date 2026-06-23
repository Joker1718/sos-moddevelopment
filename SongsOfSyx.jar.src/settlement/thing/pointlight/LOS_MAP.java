/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LOS_MAP
/*    */   implements MAP_OBJECT<LOS>
/*    */ {
/*    */   public LOS get(int tile) {
/* 15 */     return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ 
/*    */   
/*    */   public LOS get(int tx, int ty) {
/* 20 */     RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(tx, ty);
/* 21 */     if (p != null) {
/* 22 */       return p.LOS(tx, ty);
/*    */     }
/*    */     
/* 25 */     return SETT.TILE_MAP().LOS(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\LOS_MAP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */