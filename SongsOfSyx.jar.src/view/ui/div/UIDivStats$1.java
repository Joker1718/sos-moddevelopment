/*    */ package view.ui.div;
/*    */ 
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import game.faction.Faction;
/*    */ import init.race.Race;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsBattle;
/*    */ import settlement.stats.equip.EquipBattle;
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
/*    */ class null
/*    */   implements DIV_SPEC
/*    */ {
/*    */   public Race race() {
/* 55 */     return UIDivStats.this.sdiv.race();
/*    */   }
/*    */ 
/*    */   
/*    */   public double training(StatsBattle.StatTraining tr) {
/* 60 */     return tr.stat.div().getD(UIDivStats.this.sdiv);
/*    */   }
/*    */ 
/*    */   
/*    */   public int men() {
/* 65 */     return UIDivStats.this.sdiv.menNrOf();
/*    */   }
/*    */ 
/*    */   
/*    */   public double equip(EquipBattle e) {
/* 70 */     return e.stat().div().getD(UIDivStats.this.sdiv);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 75 */     return (CharSequence)UIDivStats.this.sdiv.info.name();
/*    */   }
/*    */ 
/*    */   
/*    */   public Faction faction() {
/* 80 */     return UIDivStats.this.sdiv.faction();
/*    */   }
/*    */ 
/*    */   
/*    */   public double experience() {
/* 85 */     return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(UIDivStats.this.sdiv);
/*    */   }
/*    */ 
/*    */   
/*    */   public int bannerI() {
/* 90 */     return UIDivStats.this.sdiv.info.bannerI();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivStats$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */