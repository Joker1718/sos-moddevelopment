/*     */ package util.data;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Count
/*     */ {
/*     */   private final int size;
/*  83 */   private int pScroll = 0;
/*     */   private int longI;
/*  85 */   private int count = 1;
/*     */   private final Count next;
/*     */   
/*     */   Count(int size, Count next) {
/*  89 */     this.size = size;
/*  90 */     this.next = next;
/*     */   }
/*     */   
/*     */   Count count() {
/*  94 */     if (this.next == null) {
/*  95 */       this.count++;
/*  96 */       if (this.count > 1) {
/*  97 */         DataO.this.countLong++;
/*  98 */         this.count = 0;
/*  99 */         this.longI = DataO.this.countLong;
/*     */       } 
/*     */       
/* 102 */       return this;
/*     */     } 
/*     */     
/* 105 */     this.count++;
/* 106 */     if (this.count > 1) {
/* 107 */       this.next.count();
/* 108 */       this.pScroll = this.next.scroll();
/* 109 */       this.count = 0;
/* 110 */       this.longI = this.next.longI;
/*     */     } 
/*     */     
/* 113 */     return this;
/*     */   }
/*     */   
/*     */   int scroll() {
/* 117 */     return this.pScroll + this.count * this.size;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataO$Count.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */