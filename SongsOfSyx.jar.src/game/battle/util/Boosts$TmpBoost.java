/*     */ package game.battle.util;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class TmpBoost
/*     */ {
/* 169 */   private double[] training = new double[(STATS.BATTLE()).TRAINING_ALL.size()];
/* 170 */   private double[] equip = new double[STATS.EQUIP().all().size()];
/* 171 */   private double[] race = new double[RACES.all().size()];
/*     */   
/*     */   private double experience;
/*     */   
/*     */   void set(Boostable bo, boolean isMul) {
/* 176 */     this.experience = get((STATS.BATTLE()).COMBAT_EXPERIENCE.boosters, bo, isMul);
/* 177 */     for (int ri = 0; ri < RACES.all().size(); ri++)
/* 178 */       this.race[ri] = get(((Race)RACES.all().get(ri)).boosts, bo, isMul);  int i;
/* 179 */     for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 180 */       StatsBattle.StatTraining t = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/* 181 */       this.training[i] = get(t.stat.boosters, bo, isMul);
/*     */     } 
/* 183 */     for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 184 */       EquipBattle t = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 185 */       this.equip[i] = get((t.stat()).boosters, bo, isMul);
/*     */     } 
/*     */   }
/*     */   
/*     */   private double get(BoostSpecs bos, Boostable bo, boolean isMul) {
/* 190 */     if (isMul) {
/* 191 */       double d = 1.0D;
/* 192 */       for (int i = 0; i < bos.all().size(); i++) {
/* 193 */         BoostSpec s = (BoostSpec)bos.all().get(i);
/* 194 */         if (s.booster.isMul == isMul && s.boostable == bo) {
/* 195 */           d *= s.booster.to();
/*     */         }
/*     */       } 
/*     */       
/* 199 */       return d;
/*     */     } 
/* 201 */     double res = 0.0D;
/* 202 */     for (int si = 0; si < bos.all().size(); si++) {
/* 203 */       BoostSpec s = (BoostSpec)bos.all().get(si);
/* 204 */       if (s.booster.isMul == isMul && s.boostable == bo) {
/* 205 */         res += s.booster.to();
/*     */       }
/*     */     } 
/*     */     
/* 209 */     return res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\Boosts$TmpBoost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */