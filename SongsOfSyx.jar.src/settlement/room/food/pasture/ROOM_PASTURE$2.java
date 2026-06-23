/*    */ package settlement.room.food.pasture;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.industry.module.Industry;
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
/* 81 */     super($anonymous0);
/*    */   }
/*    */   public RESOURCE resource() {
/* 84 */     if (this.ins instanceof PastureInstance) {
/* 85 */       PastureInstance p = (PastureInstance)this.ins;
/* 86 */       if (p.industry().outs().size() > 1) {
/* 87 */         return ((IndustryResource)p.industry().outs().get(1)).resource;
/*    */       }
/* 89 */       return ((IndustryResource)p.industry().outs().get(0)).resource;
/*    */     } 
/* 91 */     return ((IndustryResource)((Industry)ROOM_PASTURE.this.indus.get(0)).outs().get(0)).resource;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 96 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 200);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ROOM_PASTURE$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */