/*    */ package util.statistics;
/*    */ 
/*    */ import game.time.TIMECYCLE;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public class HistoryResource
/*    */   extends HistoryObject<RESOURCE> {
/*    */   public HistoryResource(int size, TIMECYCLE time, boolean keep) {
/* 11 */     this(null, size, time, keep);
/*    */   }
/*    */   
/*    */   public HistoryResource(INFO info, int size, TIMECYCLE time, boolean keep) {
/* 15 */     super(info, size, time, keep, RESOURCES.map());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */