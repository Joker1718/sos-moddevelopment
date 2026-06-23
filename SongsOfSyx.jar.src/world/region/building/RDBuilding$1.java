/*    */ package world.region.building;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import util.data.DataO;
/*    */ import util.data.INT_O;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends DataO<Region>.DataNibble
/*    */ {
/*    */   null(DataO paramDataO, String $anonymous0, int $anonymous1) {
/* 89 */     super(paramDataO, $anonymous0, $anonymous1);
/*    */   }
/*    */   public void set(Region t, int s) {
/* 92 */     if (get(t) != 0 && t.faction() != null)
/* 93 */       ((INT_O.INT_OE)RDBuilding.this.levelAm.get(get(t) - 1)).inc(t.faction(), -1); 
/* 94 */     if (s != get(t) && t.faction() == FACTIONS.player())
/* 95 */       (RD.BUILDINGS()).costs.setDirty(); 
/* 96 */     super.set(t, s);
/* 97 */     if (get(t) != 0 && t.faction() != null)
/* 98 */       ((INT_O.INT_OE)RDBuilding.this.levelAm.get(get(t) - 1)).inc(t.faction(), 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuilding$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */