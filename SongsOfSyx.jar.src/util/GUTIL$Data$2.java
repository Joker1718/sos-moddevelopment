/*    */ package util;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.util.misc.StatsDebugger;
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
/*    */   extends StatsDebugger.Value
/*    */ {
/*    */   double t;
/*    */   double am;
/*    */   
/*    */   null(StatsDebugger paramStatsDebugger, String $anonymous0, int $anonymous1, StatsDebugger.Formatter $anonymous2) {
/* 78 */     super(paramStatsDebugger, $anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected double getValue() {
/* 85 */     this.t += GAME.SPEED.speed();
/* 86 */     this.am++;
/* 87 */     if (this.am > 30.0D) {
/* 88 */       this.t /= this.am;
/* 89 */       this.am = 1.0D;
/*    */     } 
/* 91 */     return this.t / this.am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\GUTIL$Data$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */