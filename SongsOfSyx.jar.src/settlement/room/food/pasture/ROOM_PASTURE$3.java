/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RoomResStorage
/*     */ {
/*     */   null(int $anonymous0) {
/* 100 */     super($anonymous0);
/*     */   }
/*     */   public RESOURCE resource() {
/* 103 */     if (this.ins instanceof PastureInstance) {
/* 104 */       PastureInstance p = (PastureInstance)this.ins;
/* 105 */       if (p.industry().outs().size() > 2) {
/* 106 */         return ((IndustryResource)p.industry().outs().get(2)).resource;
/*     */       }
/* 108 */       return ((IndustryResource)p.industry().outs().get(0)).resource;
/*     */     } 
/* 110 */     return ((IndustryResource)((Industry)ROOM_PASTURE.this.indus.get(0)).outs().get(0)).resource;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean is(int tx, int ty) {
/* 115 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 300);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ROOM_PASTURE$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */