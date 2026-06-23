/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements DIV_SPEC
/*     */ {
/*  92 */   final Race race = (Race)RACES.all().rnd();
/*  93 */   final DivType dd = (GAME.battle()).types.rnd(this.race, (Faction)FACTIONS.player(), RND.rFloat());
/*     */   
/*  95 */   final int men = CLAMP.i(RND.rInt((Config.battle()).MEN_PER_DIVISION) + 25, 1, (Config.battle()).MEN_PER_DIVISION);
/*  96 */   final String name = (String)this.race.info.armyNames.rnd();
/*  97 */   final int bannerI = RND.rInt((GAME.ARMIES()).banners.size());
/*     */   
/*  99 */   double tr = RND.rFloat();
/* 100 */   double eq = RND.rFloat();
/* 101 */   double ex = RND.rFloat();
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining t) {
/* 105 */     return this.dd.training(t) * this.tr;
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 110 */     return this.dd.equip(e) * this.eq;
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 115 */     return this.race;
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 120 */     return this.men;
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 130 */     return this.ex;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 135 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 140 */     return this.bannerI;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DivGeneration$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */