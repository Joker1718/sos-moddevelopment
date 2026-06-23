/*    */ package settlement.room.industry.mine;
/*    */ 
/*    */ import init.type.TERRAIN;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 87 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public double occurence(Region reg) {
/* 91 */     double d = 0.0D;
/* 92 */     for (int ti = 0; ti < TERRAINS.ALL().size(); ti++) {
/* 93 */       d += ROOM_MINE.this.minable.terrain((TERRAIN)TERRAINS.ALL().get(ti)) * reg.info.terrain((TERRAIN)TERRAINS.ALL().getC(this.index));
/*    */     }
/* 95 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\ROOM_MINE$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */