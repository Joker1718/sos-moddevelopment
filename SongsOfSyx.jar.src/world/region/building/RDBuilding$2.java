/*     */ package world.region.building;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import util.data.INT_O;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RD.RDOwnerChanger
/*     */ {
/*     */   public void change(Region reg, Faction oldOwner, Faction newOwner) {
/* 106 */     int l = RDBuilding.this.level.get(reg);
/* 107 */     if (l > 0) {
/* 108 */       if (oldOwner != null) {
/* 109 */         ((INT_O.INT_OE)RDBuilding.this.levelAm.get(l - 1)).inc(oldOwner, -1);
/*     */       }
/* 111 */       if (newOwner != null) {
/* 112 */         ((INT_O.INT_OE)RDBuilding.this.levelAm.get(l - 1)).inc(newOwner, 1);
/*     */       }
/*     */     } 
/* 115 */     if (newOwner == FACTIONS.player() || oldOwner == FACTIONS.player())
/* 116 */       (RD.BUILDINGS()).costs.setDirty(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuilding$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */