/*    */ package util;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ class null
/*    */   extends StatsDebugger.Value
/*    */ {
/*    */   null(StatsDebugger paramStatsDebugger, String $anonymous0, int $anonymous1, StatsDebugger.Formatter $anonymous2) {
/* 69 */     super(paramStatsDebugger, $anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected double getValue() {
/* 73 */     if (SETT.ENTITIES() == null)
/* 74 */       return 0.0D; 
/* 75 */     return SETT.ENTITIES().size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\GUTIL$Data$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */