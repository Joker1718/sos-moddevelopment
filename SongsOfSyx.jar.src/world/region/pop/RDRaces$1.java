/*    */ package world.region.pop;
/*    */ 
/*    */ import util.data.DOUBLE_O;
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
/*    */ class null
/*    */   extends DOUBLE_O.DoubleOCached<Region>
/*    */ {
/*    */   public double getValue(Region t) {
/* 70 */     double cache = 0.0D;
/* 71 */     for (int ri = 0; ri < RDRaces.this.all.size(); ri++) {
/* 72 */       cache += ((RDRace)RDRaces.this.all.get(ri)).pop.target(t);
/*    */     }
/* 74 */     return cache;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDRaces$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */