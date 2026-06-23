/*    */ package settlement.room.industry.refiner;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*    */ import settlement.room.main.job.RoomResStorage;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomResStorage
/*    */ {
/*    */   null(int $anonymous0) {
/* 19 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public RESOURCE resource() {
/* 23 */     ROOM_PRODUCER_INSTANCE ins = (ROOM_PRODUCER_INSTANCE)(SETT.ROOMS()).map.get((COORDINATE)this);
/* 24 */     return ((IndustryResource)ins.industry().outs().get(0)).resource;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 29 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void changed(int tx, int ty) {
/* 34 */     if (hasRoom()) {
/* 35 */       RefinerInstance m = (RefinerInstance)print.get(tx, ty);
/* 36 */       m.hasStorage = true;
/* 37 */       m.jobs.searchAgain();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\refiner\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */