/*    */ package util.data;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Count
/*    */ {
/*    */   private final int size;
/* 34 */   private int pScroll = 0;
/*    */   private int longI;
/* 36 */   private int count = 1;
/*    */   private final Count next;
/*    */   
/*    */   Count(int size, Count next) {
/* 40 */     this.size = size;
/* 41 */     this.next = next;
/*    */   }
/*    */   
/*    */   Count count() {
/* 45 */     if (this.next == null) {
/* 46 */       this.count++;
/* 47 */       if (this.count > 1) {
/* 48 */         DataOSimple.this.countLong++;
/* 49 */         this.count = 0;
/* 50 */         this.longI = DataOSimple.this.countLong;
/*    */       } 
/*    */       
/* 53 */       return this;
/*    */     } 
/*    */ 
/*    */     
/* 57 */     this.count++;
/* 58 */     if (this.count > 1) {
/* 59 */       this.next.count();
/* 60 */       this.pScroll = this.next.scroll();
/* 61 */       this.count = 0;
/* 62 */       this.longI = this.next.longI;
/*    */     } 
/*    */     
/* 65 */     return this;
/*    */   }
/*    */   
/*    */   int scroll() {
/* 69 */     return this.pScroll + this.count * this.size;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataOSimple$Count.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */