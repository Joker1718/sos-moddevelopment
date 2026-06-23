/*    */ package settlement.room.food.farm;
/*    */ 
/*    */ import init.type.TERRAINS;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryRegion;
/*    */ import world.map.regions.Region;
/*    */ import world.map.regions.RegionInfo;
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
/*    */   extends IndustryRegion
/*    */ {
/*    */   null(Industry $anonymous0, double $anonymous1) {
/* 69 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public double occurence(Region reg) {
/* 73 */     if (ROOM_FARM.this.constructor().mustBeOutdoors())
/* 74 */       return RegionInfo.vFer().getAi(reg); 
/* 75 */     return reg.info.terrain(TERRAINS.MOUNTAIN());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\ROOM_FARM$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */