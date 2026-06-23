/*    */ package world.region;
/*    */ 
/*    */ import game.faction.Faction;
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
/*    */ class null
/*    */   extends RD.RDOwnerChanger
/*    */ {
/*    */   public void change(Region reg, Faction oldOwner, Faction newOwner) {
/* 56 */     for (RDOutputs.RDOutput r : RDOutputs.this.ALL)
/* 57 */       r.yearlyAccumilation.set(reg, 0); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOutputs$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */