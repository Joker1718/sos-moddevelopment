/*     */ package util.data;
/*     */ 
/*     */ import util.info.INFO;
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
/*     */ class DataAbs
/*     */   implements INT_O.INT_OE<T>
/*     */ {
/*     */   private final int iLong;
/*     */   private final int scroll;
/*     */   private final long mask;
/*     */   private final INFO info;
/*     */   
/*     */   public DataAbs(INFO info, DataOSimple<T>.Count c) {
/*  83 */     c.count();
/*  84 */     this.scroll = c.scroll();
/*  85 */     this.mask = (1L << c.size) - 1L;
/*  86 */     this.iLong = c.longI;
/*  87 */     this.info = info;
/*     */ 
/*     */     
/*  90 */     long cc = this.mask;
/*  91 */     cc <<= this.scroll;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public INFO info() {
/*  97 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(T t) {
/* 102 */     return (int)(DataOSimple.this.data(t)[this.iLong] >>> this.scroll & this.mask);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(T t) {
/* 107 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(T t) {
/* 112 */     return (int)this.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T t, int s) {
/* 117 */     if (s < min(t) || s > max(t))
/* 118 */       throw new RuntimeException("" + s + " " + s + " " + min(t)); 
/* 119 */     long c = this.mask;
/* 120 */     s = (int)(s & this.mask);
/* 121 */     DataOSimple.this.data(t)[this.iLong] = DataOSimple.this.data(t)[this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 122 */     c = s & 0xFFFFFFFFL;
/* 123 */     c <<= this.scroll;
/* 124 */     DataOSimple.this.data(t)[this.iLong] = DataOSimple.this.data(t)[this.iLong] | c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataOSimple$DataAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */