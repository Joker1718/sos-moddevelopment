/*    */ package settlement.room.industry.woodcutter;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import settlement.room.main.job.RoomResStorage;
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
/*    */   extends RoomResStorage
/*    */ {
/*    */   null(int $anonymous0) {
/* 46 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public RESOURCE resource() {
/* 50 */     return ((IndustryResource)print.productionData.outs().get(0)).resource;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 55 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void changed(int tx, int ty) {
/* 60 */     if (hasRoom()) {
/* 61 */       Instance m = (Instance)print.get(tx, ty);
/* 62 */       m.hasStorage = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\Job$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */