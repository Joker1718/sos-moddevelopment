/*    */ package settlement.room.home.house;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.QueueInteger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/*    */     byte b;
/*    */     int i;
/*    */     QueueInteger[] arrayOfQueueInteger;
/* 28 */     for (i = (arrayOfQueueInteger = OddHome.this.queues).length, b = 0; b < i; ) { QueueInteger q = arrayOfQueueInteger[b];
/* 29 */       q.save(file);
/*    */       b++; }
/*    */      } public void load(FileGetter file) throws IOException { byte b;
/*    */     int i;
/*    */     QueueInteger[] arrayOfQueueInteger;
/* 34 */     for (i = (arrayOfQueueInteger = OddHome.this.queues).length, b = 0; b < i; ) { QueueInteger q = arrayOfQueueInteger[b];
/* 35 */       q.load(file);
/*    */       b++; }
/*    */      } public void clear() {
/*    */     byte b;
/*    */     int i;
/*    */     QueueInteger[] arrayOfQueueInteger;
/* 41 */     for (i = (arrayOfQueueInteger = OddHome.this.queues).length, b = 0; b < i; ) { QueueInteger q = arrayOfQueueInteger[b];
/* 42 */       q.clear();
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\OddHome$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */