/*    */ package game.battle.util;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import init.constant.Config;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsBattle;
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface DIV_SPECE
/*    */   extends DIV_SPEC, DIV_SETTING.DIV_SETTINGE
/*    */ {
/*    */   void raceSet(Race paramRace);
/*    */   
/*    */   void experienceSet(double paramDouble);
/*    */   
/*    */   Str nameE();
/*    */   
/*    */   void bannerISet(int paramInt);
/*    */   
/*    */   void factionSet(Faction paramFaction);
/*    */   
/*    */   default DIV_SPECE copyFrom(DIV_SPEC other) {
/*    */     int i;
/* 36 */     for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 37 */       StatsBattle.StatTraining t = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/* 38 */       trainingSet(t, other.training(t));
/*    */     } 
/*    */     
/* 41 */     for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 42 */       EquipBattle t = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 43 */       equipSet(t, other.equip(t));
/*    */     } 
/*    */     
/* 46 */     menSet(other.men());
/* 47 */     experienceSet(other.experience());
/* 48 */     raceSet(other.race());
/* 49 */     nameE().clear().add(other.name());
/* 50 */     bannerISet(other.bannerI());
/* 51 */     factionSet(other.faction());
/* 52 */     return this;
/*    */   }
/*    */   
/*    */   default void generate() {
/* 56 */     double tr = RND.rFloat();
/* 57 */     double eq = RND.rFloat();
/*    */     
/* 59 */     Race r = (Race)RACES.all().rnd();
/* 60 */     raceSet(r);
/* 61 */     menSet(10 + RND.rInt((Config.battle()).MEN_PER_DIVISION - 10));
/* 62 */     experienceSet(RND.rFloat());
/* 63 */     nameE().clear().add((CharSequence)r.info.armyNames.rnd());
/* 64 */     bannerISet(RND.rInt((GAME.ARMIES()).banners.size()));
/*    */     
/* 66 */     DivType dd = (GAME.battle()).types.rnd(r, (Faction)FACTIONS.player(), RND.rFloat());
/*    */     int i;
/* 68 */     for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 69 */       EquipBattle t = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 70 */       equipSet(t, dd.equip((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i)) * eq);
/*    */     } 
/* 72 */     for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 73 */       StatsBattle.StatTraining t = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/* 74 */       trainingSet(t, dd.training((StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i)) * tr);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DIV_SPEC$DIV_SPECE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */