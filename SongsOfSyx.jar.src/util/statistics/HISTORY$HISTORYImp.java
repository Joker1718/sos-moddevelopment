/*    */ package util.statistics;
/*    */ 
/*    */ import game.time.TIMECYCLE;
/*    */ import util.info.INFO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class HISTORYImp
/*    */   implements HISTORY
/*    */ {
/*    */   private final TIMECYCLE time;
/*    */   private final int rec;
/*    */   private final INFO info;
/*    */   
/*    */   public HISTORYImp(TIMECYCLE time, int rec) {
/* 61 */     this(null, null, time, rec);
/*    */   }
/*    */   
/*    */   public HISTORYImp(CharSequence name, CharSequence desc, TIMECYCLE time, int rec) {
/* 65 */     if (name == null) {
/* 66 */       this.info = null;
/*    */     } else {
/* 68 */       this.info = new INFO(name, desc);
/* 69 */     }  this.rec = rec;
/* 70 */     this.time = time;
/*    */   }
/*    */ 
/*    */   
/*    */   public TIMECYCLE time() {
/* 75 */     return this.time;
/*    */   }
/*    */ 
/*    */   
/*    */   public int historyRecords() {
/* 80 */     return this.rec;
/*    */   }
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 85 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY$HISTORYImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */