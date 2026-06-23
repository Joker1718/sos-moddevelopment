/*    */ package world.map.pathing;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.diplomacy.DIP;
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
/*    */ class null
/*    */   extends WRegSel
/*    */ {
/*    */   public boolean is(Region t) {
/* 63 */     if (WRegSel.faction == null)
/* 64 */       return (t.faction() == FACTIONS.player()); 
/* 65 */     return (t.faction() != null && DIP.WAR().is(t.faction(), WRegSel.faction));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WRegSel$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */