/*    */ package world.region.pop;
/*    */ 
/*    */ import util.data.DOUBLE_O;
/*    */ import util.info.INFO;
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
/*    */ class null
/*    */   implements DOUBLE_O<Region>
/*    */ {
/* 80 */   final INFO info = new INFO(RDRaces.¤¤Loyalty, RDRaces.¤¤LoyaltyD);
/*    */ 
/*    */   
/*    */   public double getD(Region t) {
/* 84 */     double d = 0.0D;
/* 85 */     for (RDRace r : RDRaces.this.all) {
/* 86 */       d += r.pop.get(t) * r.loyalty.getD(t);
/*    */     }
/* 88 */     if (RDRaces.this.population.get(t) > 0)
/* 89 */       d /= RDRaces.this.population.get(t); 
/* 90 */     return d;
/*    */   }
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 95 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDRaces$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */