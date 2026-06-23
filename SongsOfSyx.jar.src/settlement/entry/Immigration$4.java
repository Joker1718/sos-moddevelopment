/*    */ package settlement.entry;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import init.race.Race;
/*    */ import settlement.main.SETT;
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
/*    */   extends Immigration.Bo
/*    */ {
/*    */   null(BSourceInfo $anonymous0, double $anonymous1, double $anonymous2, boolean $anonymous3) {
/* 60 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected double g(Race race) {
/* 64 */     return race.population().climate(SETT.ENV().climate());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\Immigration$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */