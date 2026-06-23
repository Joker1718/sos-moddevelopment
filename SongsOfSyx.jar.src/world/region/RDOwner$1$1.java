/*    */ package world.region;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.faction.FACTIONS;
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
/*    */ class null
/*    */   extends RBooster
/*    */ {
/*    */   public double get(Region t) {
/* 51 */     if (t.faction() == FACTIONS.player())
/* 52 */       return (RDOwner.null.access$0(RDOwner.null.this)).affiliation.getD(t); 
/* 53 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOwner$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */