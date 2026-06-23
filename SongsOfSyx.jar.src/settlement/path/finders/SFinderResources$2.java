/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.RESOURCE_TILE;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.thing.THINGS;
/*    */ import settlement.thing.ThingsResources;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 48 */     for (COORDINATE c : new Rec(SETT.TILE_BOUNDS)) {
/*    */       
/*    */       do {
/*    */       
/* 52 */       } while (unres(c));
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 57 */       Room room = (SETT.ROOMS()).map.get(c.x(), c.y());
/* 58 */       if (room != null) {
/* 59 */         RESOURCE_TILE res = room.resourceTile(c.x(), c.y());
/* 60 */         while (res != null && res.findableReservedIs() && res.resource() != null) {
/* 61 */           res.findableReserveCancel();
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean unres(COORDINATE c) {
/* 70 */     for (THINGS.Thing t : SETT.THINGS().get(c.x(), c.y())) {
/* 71 */       if (t instanceof ThingsResources.ScatteredResource) {
/* 72 */         ThingsResources.ScatteredResource sc = (ThingsResources.ScatteredResource)t;
/* 73 */         if (sc.findableReservedIs() && sc.resource() != null) {
/* 74 */           sc.findableReserveCancel();
/* 75 */           return true;
/*    */         } 
/*    */       } 
/*    */     } 
/* 79 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResources$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */