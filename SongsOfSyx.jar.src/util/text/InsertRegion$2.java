/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import util.data.GETTER_TRANS;
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
/*    */ class null
/*    */   implements GETTER_TRANS<Region, Faction>
/*    */ {
/*    */   public Faction get(Region f) {
/* 32 */     if (f.faction() == null)
/* 33 */       return (Faction)FACTIONS.player(); 
/* 34 */     return f.faction();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertRegion$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */