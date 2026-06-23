/*    */ package settlement.room.industry.woodcutter;
/*    */ 
/*    */ import init.type.TERRAINS;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryRegion;
/*    */ import world.map.regions.Region;
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
/* 48 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public double occurence(Region reg) {
/* 52 */     return reg.info.terrain(TERRAINS.FOREST());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\ROOM_WOODCUTTER$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */