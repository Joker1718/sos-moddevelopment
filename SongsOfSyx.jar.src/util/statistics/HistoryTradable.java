/*    */ package util.statistics;
/*    */ 
/*    */ import game.time.TIMECYCLE;
/*    */ import init.trade.TR;
/*    */ import init.trade.TRADABLE;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public class HistoryTradable
/*    */   extends HistoryObject<TRADABLE> {
/*    */   public HistoryTradable(int size, TIMECYCLE time, boolean keep) {
/* 11 */     this(null, size, time, keep);
/*    */   }
/*    */   
/*    */   public HistoryTradable(INFO info, int size, TIMECYCLE time, boolean keep) {
/* 15 */     super(info, size, time, keep, TR.MAP());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryTradable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */