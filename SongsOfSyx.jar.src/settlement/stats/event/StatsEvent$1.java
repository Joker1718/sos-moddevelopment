/*    */ package settlement.stats.event;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.StatsInit;
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
/*    */   implements StatsInit.StatInitable
/*    */ {
/*    */   public void init(Induvidual h) {
/* 31 */     if (GAME.EVENT().shouldSet(h))
/* 32 */       StatsEvent.this.stat.indu().set(h, 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\event\StatsEvent$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */