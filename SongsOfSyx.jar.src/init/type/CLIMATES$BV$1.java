/*     */ package init.type;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import settlement.stats.Induvidual;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
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
/*     */   implements BValue
/*     */ {
/*     */   public double vGet(Region reg) {
/* 204 */     if (reg == null)
/* 205 */       return 0.0D; 
/* 206 */     double res = 0.0D;
/* 207 */     for (int ci = 0; ci < CLIMATES.ALL().size(); ci++) {
/* 208 */       res += CLIMATES.BV.this.values[ci] * reg.info.climate((CLIMATE)CLIMATES.ALL().get(ci));
/*     */     }
/*     */     
/* 211 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Faction f) {
/* 216 */     if (f == null)
/* 217 */       return 0.0D; 
/* 218 */     return super.vGet(f);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 223 */     return vGet(indu.faction());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 228 */     return vGet(div.faction());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE popTime) {
/* 233 */     if (FACTIONS.player() == null)
/* 234 */       return 0.0D; 
/* 235 */     return vGet(FACTIONS.player());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 240 */     if (f.capitolRegion() == null)
/* 241 */       return 0.0D; 
/* 242 */     return CLIMATES.BV.this.values[((CLIMATE)(WORLD.CLIMATE()).getter.get(f.capitolRegion().cx(), f.capitolRegion().cy())).index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 247 */     return vGet(f.capitolRegion());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CLIMATES$BV$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */