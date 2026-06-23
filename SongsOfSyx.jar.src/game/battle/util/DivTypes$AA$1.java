/*     */ package game.battle.util;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 116 */     return DivTypes.AA.this.type.training(tr);
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 121 */     return DivTypes.AA.this.type.equip(e);
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 126 */     return DivTypes.AA.this.race;
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 131 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 141 */     return 0.2D;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 146 */     return Dic.empty;
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 151 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DivTypes$AA$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */