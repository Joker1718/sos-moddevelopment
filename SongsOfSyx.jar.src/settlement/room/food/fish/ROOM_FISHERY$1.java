/*    */ package settlement.room.food.fish;
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
/*    */ class null
/*    */   extends IndustryRegion
/*    */ {
/*    */   null(Industry $anonymous0, double $anonymous1) {
/* 49 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public double occurence(Region reg) {
/* 53 */     return Math.max(RegionInfo.vTerrain(TERRAINS.OCEAN()).getAi(reg), RegionInfo.vTerrain(TERRAINS.WET()).getAi(reg));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\ROOM_FISHERY$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */