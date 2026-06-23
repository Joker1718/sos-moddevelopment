/*    */ package init.type;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.util.StatBooster;
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
/*    */   extends StatBooster
/*    */ {
/*    */   public double vGet(Induvidual indu) {
/* 53 */     return TRAIT.this.stat().getD(indu);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Div div) {
/* 58 */     return TRAIT.this.stat().getD(div);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(FactionNPC f) {
/* 63 */     return vGet((f.court().king().roy()).induvidual);
/*    */   }
/*    */   
/*    */   public double vGet(HCLASS_RACE popTime) {
/* 67 */     return TRAIT.this.stat().getD(popTime.cl, popTime.race);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TRAIT$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */