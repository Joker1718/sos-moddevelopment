/*    */ package game.battle.util;
/*    */ 
/*    */ import init.constant.Config;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsBattle;
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public final class DivType
/*    */   implements DIV_SETTING {
/*    */   public final double occurence;
/* 14 */   public final double[] roccurence = new double[RACES.all().size()];
/*    */   
/* 16 */   final double[] equip = new double[STATS.EQUIP().BATTLE_ALL().size()];
/* 17 */   final double[] training = new double[(STATS.BATTLE()).TRAINING_ALL.size()];
/*    */ 
/*    */   
/*    */   public DivType() {
/* 21 */     this.occurence = 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public DivType(double occ, LIST<StatsBattle.StatTraining> trs, LIST<EquipBattle> eqps) {
/* 26 */     this.occurence = occ;
/*    */     
/* 28 */     for (StatsBattle.StatTraining tr : trs) {
/* 29 */       this.training[tr.tIndex] = 1.0D;
/*    */     }
/* 31 */     for (EquipBattle tr : eqps) {
/* 32 */       this.equip[tr.indexMilitary()] = 1.0D;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public double training(StatsBattle.StatTraining tr) {
/* 38 */     return this.training[tr.tIndex];
/*    */   }
/*    */ 
/*    */   
/*    */   public double equip(EquipBattle e) {
/* 43 */     return this.equip[e.indexMilitary()];
/*    */   }
/*    */ 
/*    */   
/*    */   public int men() {
/* 48 */     return (Config.battle()).MEN_PER_DIVISION;
/*    */   }
/*    */   
/*    */   public boolean valid(Race race) {
/* 52 */     for (int i = 0; i < this.equip.length; i++) {
/* 53 */       if (this.equip[i] > 0.0D && !((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i)).allowed(race))
/* 54 */         return false; 
/*    */     } 
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DivType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */