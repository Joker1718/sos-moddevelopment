/*     */ package game.battle.util;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DIV_SPECImp
/*     */   implements DIV_SPEC.DIV_SPECE
/*     */ {
/*  83 */   private final double[] training = new double[(STATS.BATTLE()).TRAINING_ALL.size()];
/*  84 */   private final double[] gear = new double[STATS.EQUIP().BATTLE_ALL().size()];
/*  85 */   private int men = 10;
/*  86 */   private double experience = 0.0D;
/*  87 */   private int race = 0;
/*  88 */   private Str name = (new Str(24)).add(Dic.¤¤rename);
/*  89 */   private int bannerI = 0;
/*  90 */   private int faction = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void clear(Race race) {
/*  98 */     Arrays.fill(this.training, 0.0D);
/*  99 */     Arrays.fill(this.gear, 0.0D);
/* 100 */     this.men = 10;
/* 101 */     this.experience = 0.0D;
/* 102 */     this.race = race.index;
/* 103 */     this.name.clear().add(Dic.¤¤rename);
/* 104 */     this.bannerI = 0;
/* 105 */     this.faction = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 110 */     return this.training[tr.tIndex];
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 115 */     return this.gear[e.indexMilitary()];
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 120 */     return this.men;
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 125 */     return (Race)RACES.all().get(this.race);
/*     */   }
/*     */ 
/*     */   
/*     */   public void raceSet(Race race) {
/* 130 */     this.race = race.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 135 */     return this.experience;
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 140 */     return FACTIONS.getByIndex(this.faction);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 145 */     return (CharSequence)this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 150 */     return this.bannerI;
/*     */   }
/*     */ 
/*     */   
/*     */   public void menSet(int men) {
/* 155 */     this.men = men;
/*     */   }
/*     */ 
/*     */   
/*     */   public void experienceSet(double experience) {
/* 160 */     this.experience = experience;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Str nameE() {
/* 166 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void bannerISet(int bannerI) {
/* 171 */     this.bannerI = bannerI;
/*     */   }
/*     */ 
/*     */   
/*     */   public void trainingSet(StatsBattle.StatTraining tr, double d) {
/* 176 */     this.training[tr.tIndex] = d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void equipSet(EquipBattle e, double d) {
/* 182 */     this.gear[e.indexMilitary()] = d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void factionSet(Faction faction) {
/* 187 */     this.faction = faction.index();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DIV_SPEC$DIV_SPECImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */