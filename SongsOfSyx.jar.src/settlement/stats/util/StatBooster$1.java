/*    */ package settlement.stats.util;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.stat.STAT;
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
/*    */   public double vGet(Div div) {
/* 44 */     return CLAMP.d(stat.div().getD(div), 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Induvidual indu) {
/* 49 */     return CLAMP.d(stat.indu().getD(indu), 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(HCLASS_RACE t) {
/* 54 */     return CLAMP.d(stat.data(t.cl).getD(t.race), 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stat\\util\StatBooster$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */