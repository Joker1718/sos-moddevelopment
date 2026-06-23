/*    */ package settlement.room.food.fish;
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
/*    */ class null
/*    */   extends RoomResStorage
/*    */ {
/*    */   null(int $anonymous0) {
/* 28 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public RESOURCE resource() {
/* 32 */     return ((IndustryResource)Job.this.print.productionData.outs().get(0)).resource;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 37 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void changed(int tx, int ty) {
/* 42 */     if (hasRoom()) {
/* 43 */       FishInstance m = (FishInstance)Job.this.print.get(tx, ty);
/* 44 */       m.hasStorage = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */