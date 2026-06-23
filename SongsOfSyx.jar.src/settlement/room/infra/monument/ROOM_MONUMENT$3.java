/*     */ package settlement.room.infra.monument;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsAccess;
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
/*     */ class null
/*     */   implements BValue
/*     */ {
/*     */   public double vGet(FactionNPC f) {
/*  93 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/*  98 */     return vGet(HCLASS_RACE.clP());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE t) {
/* 103 */     return ((StatsAccess.StatMonument)(STATS.ACCESS()).MONUMENTS.ALL().get(tindex)).data(t.cl).getD(t.race);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 108 */     return ((StatsAccess.StatMonument)(STATS.ACCESS()).MONUMENTS.ALL().get(tindex)).div().getD(div);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 113 */     return ((StatsAccess.StatMonument)(STATS.ACCESS()).MONUMENTS.ALL().get(tindex)).indu().getD(indu);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 118 */     return vGet(reg.faction());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\ROOM_MONUMENT$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */