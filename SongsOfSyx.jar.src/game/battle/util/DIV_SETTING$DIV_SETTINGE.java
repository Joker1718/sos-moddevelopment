/*    */ package game.battle.util;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsBattle;
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface DIV_SETTINGE
/*    */   extends DIV_SETTING
/*    */ {
/*    */   void trainingSet(StatsBattle.StatTraining paramStatTraining, double paramDouble);
/*    */   
/*    */   void equipSet(EquipBattle paramEquipBattle, double paramDouble);
/*    */   
/*    */   void menSet(int paramInt);
/*    */   
/*    */   default DIV_SETTINGE copySettings(DIV_SETTING other) {
/*    */     int i;
/* 39 */     for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 40 */       EquipBattle b = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 41 */       equipSet(b, other.equip(b));
/*    */     } 
/* 43 */     for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 44 */       StatsBattle.StatTraining b = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/* 45 */       trainingSet(b, other.training(b));
/*    */     } 
/* 47 */     menSet(other.men());
/* 48 */     return this;
/*    */   }
/*    */   
/*    */   default DIV_SETTINGE copySettings(DIV_SETTING other, int men, double e, double t) {
/*    */     int i;
/* 53 */     for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 54 */       EquipBattle b = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 55 */       double d = (int)Math.round(other.equip(b) * e * b.max());
/* 56 */       d /= b.max();
/* 57 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 58 */       equipSet(b, d);
/*    */     } 
/* 60 */     for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 61 */       StatsBattle.StatTraining b = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/* 62 */       double d = (int)(other.training(b) * t * b.stat.indu().max(null));
/* 63 */       d /= b.stat.indu().max(null);
/* 64 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 65 */       trainingSet(b, d);
/*    */     } 
/* 67 */     menSet(men);
/* 68 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DIV_SETTING$DIV_SETTINGE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */