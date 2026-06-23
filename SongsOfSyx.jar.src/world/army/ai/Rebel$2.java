/*     */ package world.army.ai;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
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
/*     */ class null
/*     */   extends Rebel.Sel
/*     */ {
/*     */   public boolean is(Region t) {
/*  93 */     return (t.faction() == FACTIONS.player() && AD.power().get(Rebel.aa) > power(t));
/*     */   }
/*     */   
/*     */   private double power(Region reg) {
/*  97 */     double m = 0.0D;
/*  98 */     for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/*  99 */       if (a.faction() != null && (a.faction() == FACTIONS.player() || (DIP.get(a.faction(), (Faction)FACTIONS.player())).ally))
/* 100 */         m += AD.power().get(a); 
/*     */     } 
/* 102 */     return m + (RD.MILITARY()).power.getD(reg);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Rebel$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */