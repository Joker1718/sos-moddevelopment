/*    */ package settlement.main;
/*    */ 
/*    */ import settlement.misc.util.TILE_STORAGE;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SettMaps
/*    */ {
/*    */   public final MAP_OBJECT<TILE_STORAGE> STORAGE;
/*    */   
/*    */   SettMaps() {
/* 15 */     this.STORAGE = new MAP_OBJECT<TILE_STORAGE>()
/*    */       {
/*    */         public TILE_STORAGE get(int tx, int ty)
/*    */         {
/* 19 */           Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 20 */           if (r != null)
/* 21 */             return r.storage(tx, ty); 
/* 22 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public TILE_STORAGE get(int tile) {
/* 27 */           int x = tile % SETT.TWIDTH;
/* 28 */           int y = tile / SETT.TWIDTH;
/* 29 */           return get(x, y);
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\main\SettMaps.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */