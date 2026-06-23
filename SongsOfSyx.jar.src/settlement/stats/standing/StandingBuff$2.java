/*    */ package settlement.stats.standing;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.boosting.BValue;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.player.Player;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.misc.CLAMP;
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
/*    */ class null
/*    */   implements BValue
/*    */ {
/*    */   public double vGet(FactionNPC f) {
/* 45 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Player f) {
/* 50 */     return vGet(HCLASS_RACE.clP());
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Div div) {
/* 55 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Induvidual indu) {
/* 60 */     return CLAMP.d(StandingBuff.this.timer[(indu.hType()).CLASS.index()] * StandingBuff.this.timerI, 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Region reg) {
/* 65 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(HCLASS_RACE t) {
/* 70 */     if (t.cl != null)
/* 71 */       return CLAMP.d(StandingBuff.this.timer[t.cl.index()] * StandingBuff.this.timerI, 0.0D, 1.0D); 
/* 72 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\StandingBuff$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */