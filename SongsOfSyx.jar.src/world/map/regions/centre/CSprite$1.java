/*    */ package world.map.regions.centre;
/*    */ 
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements CSprite.GETTER
/*    */ {
/*    */   public double pop(Region reg) {
/* 31 */     return RD.RACES().popSize(reg);
/*    */   }
/*    */ 
/*    */   
/*    */   public double fort(Region reg) {
/* 36 */     return (RD.BUILDINGS()).levelWall.get(reg);
/*    */   }
/*    */ 
/*    */   
/*    */   public double garrison(Region reg) {
/* 41 */     return RD.MILITARY().garrison(reg);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\CSprite$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */