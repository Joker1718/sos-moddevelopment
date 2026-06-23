/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.util.sets.Tree;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Tree<FactionNPC>
/*    */ {
/*    */   null(int $anonymous0) {
/* 55 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(FactionNPC current, FactionNPC cmp) {
/* 59 */     return (value((Faction)current) > value((Faction)cmp));
/*    */   }
/*    */   
/*    */   private double value(Faction f) {
/* 63 */     double d = 1.0D - 1.0D / RD.DIST().distance(f);
/* 64 */     if (DIP.WAR().is((Faction)FACTIONS.player(), f))
/* 65 */       return 0.0D + d; 
/* 66 */     if ((DIP.get((Faction)FACTIONS.player(), f)).trades)
/* 67 */       return FACTIONS.MAX() + d; 
/* 68 */     if (RD.DIST().reachable(f))
/* 69 */       return (FACTIONS.MAX() * 2) + d; 
/* 70 */     if (RD.DIST().factionHasRegionBorderingPlayer(f))
/* 71 */       return (FACTIONS.MAX() * 3) + d; 
/* 72 */     return (FACTIONS.MAX() * 4) + d;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIFactionList$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */