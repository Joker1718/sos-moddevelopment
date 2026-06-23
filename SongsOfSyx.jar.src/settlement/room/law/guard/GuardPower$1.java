/*    */ package settlement.room.law.guard;
/*    */ 
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import init.race.Race;
/*    */ import init.type.HTYPES;
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
/*    */ class null
/*    */   implements DIV_SPEC
/*    */ {
/*    */   public Race race() {
/* 29 */     return GuardPower.this.d.race();
/*    */   }
/*    */ 
/*    */   
/*    */   public double training(StatsBattle.StatTraining tr) {
/* 34 */     return tr.stat.div().getD(GuardPower.this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public double equip(EquipBattle e) {
/* 39 */     return CLAMP.d(e.stat().div().get(GuardPower.this.d) / STATS.POP().pop(HTYPES.SOLDIER(), GuardPower.this.d), 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public int men() {
/* 44 */     return STATS.POP().pop(HTYPES.GUARD(), GuardPower.this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public Faction faction() {
/* 49 */     return (Faction)FACTIONS.player();
/*    */   }
/*    */ 
/*    */   
/*    */   public double experience() {
/* 54 */     return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(GuardPower.this.d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 60 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int bannerI() {
/* 66 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\GuardPower$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */