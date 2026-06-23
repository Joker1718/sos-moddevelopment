/*     */ package tools.perf;
/*     */ 
/*     */ import util.data.INT_O;
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
/*     */   public DataAbs(INFO info, Test.DataOSimple<T>.Count c) {
/* 231 */     c.count();
/* 232 */     this.scroll = c.scroll();
/* 233 */     this.mask = (1L << c.size) - 1L;
/* 234 */     this.iLong = c.longI;
/* 235 */     this.info = info;
/*     */ 
/*     */     
/* 238 */     long cc = this.mask;
/* 239 */     cc <<= this.scroll;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 245 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(T t) {
/* 250 */     return (int)(Test.DataOSimple.this.data(t)[this.iLong] >>> this.scroll & this.mask);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(T t) {
/* 255 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(T t) {
/* 260 */     return (int)this.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T t, int s) {
/* 265 */     if (s < min(t) || s > max(t))
/* 266 */       throw new RuntimeException("" + s + " " + s + " " + min(t)); 
/* 267 */     long c = this.mask;
/* 268 */     s = (int)(s & this.mask);
/* 269 */     Test.DataOSimple.this.data(t)[this.iLong] = Test.DataOSimple.this.data(t)[this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 270 */     c = s & 0xFFFFFFFFL;
/* 271 */     c <<= this.scroll;
/* 272 */     Test.DataOSimple.this.data(t)[this.iLong] = Test.DataOSimple.this.data(t)[this.iLong] | c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\perf\Test$DataOSimple$DataAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */