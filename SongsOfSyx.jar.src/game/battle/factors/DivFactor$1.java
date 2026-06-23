/*    */ package game.battle.factors;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.boosting.BValue;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.player.Player;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import world.map.regions.Region;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements BValue
/*    */ {
/*    */   public double vGet(Div div) {
/* 66 */     return DivFactor.this.getD(div);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Faction f) {
/* 71 */     return DivFactor.this.midValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Region reg) {
/* 76 */     return DivFactor.this.midValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Induvidual indu) {
/* 81 */     Div d = (Div)(STATS.BATTLE()).DIV.get(indu);
/* 82 */     if (d == null || !d.active())
/* 83 */       return DivFactor.this.induValue(indu); 
/* 84 */     return DivFactor.this.getD(d);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(HCLASS_RACE popTime) {
/* 89 */     return DivFactor.this.midValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Player f) {
/* 94 */     return DivFactor.this.midValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(FactionNPC f) {
/* 99 */     return DivFactor.this.midValue;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\DivFactor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */