/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.TILE_STORAGE;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements SFINDER
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 74 */     return SFinderResourceStore.this.resMask.has((SFinderResourceStore.this.d()).storage.bits(c));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTile(int tx, int ty, int tileNr) {
/* 79 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 80 */     if (r != null) {
/*    */       
/* 82 */       TILE_STORAGE result = r.storage(tx, ty);
/* 83 */       if (result != null && result.storageIsFindable() && result.storageReservable() > 0 && result.resource() != null && SFinderResourceStore.this.resMask.has(result.resource())) {
/* 84 */         SFinderResourceStore.this.result.set((COORDINATE)result);
/* 85 */         return true;
/*    */       } 
/*    */     } 
/* 88 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResourceStore$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */