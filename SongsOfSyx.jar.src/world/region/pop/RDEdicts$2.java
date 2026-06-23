/*    */ package world.region.pop;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.stats.STATS;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RBooster;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends RBooster
/*    */ {
/*    */   null(BSourceInfo $anonymous0, double $anonymous1, double $anonymous2, boolean $anonymous3) {
/* 74 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   public double get(Region t) {
/* 78 */     return (STATS.MULTIPLIERS()).PROSECUTION.value(HCLASSES.CITIZEN(), r.race, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDEdicts$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */