/*     */ package init.race;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public double vGet(FactionNPC f) {
/* 224 */     if (f == null || f.capitolRegion() == null)
/* 225 */       return 0.0D; 
/* 226 */     return vGet(f.capitolRegion());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 231 */     return isMul ? 1.0D : 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE popTime) {
/* 236 */     if (popTime.race == null) {
/* 237 */       double acc = 0.0D;
/* 238 */       double tot = 0.0D;
/* 239 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 240 */         Race r = (Race)RACES.all().get(ri);
/* 241 */         double pop = (STATS.POP()).POP.data(popTime.cl).get(r);
/*     */         
/* 243 */         acc += RaceBoosts.BV.this.dd[r.index()] * pop;
/* 244 */         tot += pop;
/*     */       } 
/* 246 */       if (tot == 0.0D)
/* 247 */         return 0.0D; 
/* 248 */       return acc / tot;
/*     */     } 
/*     */     
/* 251 */     return RaceBoosts.BV.this.dd[popTime.race.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 257 */     return RaceBoosts.BV.this.dd[div.info.race().index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 262 */     return RaceBoosts.BV.this.dd[indu.race().index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 267 */     double acc = 0.0D;
/* 268 */     double tot = 0.0D;
/* 269 */     for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 270 */       RDRace r = (RDRace)(RD.RACES()).all.get(ri);
/* 271 */       double pop = r.pop.get(reg);
/* 272 */       acc += RaceBoosts.BV.this.dd[r.race.index()] * pop;
/* 273 */       tot += pop;
/*     */     } 
/* 275 */     if (tot == 0.0D)
/* 276 */       return 0.0D; 
/* 277 */     return acc / tot;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceBoosts$BV$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */