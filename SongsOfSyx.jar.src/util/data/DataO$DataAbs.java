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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataAbs
/*     */   implements INT_O.INT_OE<T>
/*     */ {
/*     */   private final int iLong;
/*     */   private final int scroll;
/*     */   private final long mask;
/*     */   private final INFO info;
/*     */   public final String key;
/*     */   
/*     */   private DataAbs(String key, INFO info, DataO<T>.Count c) {
/* 131 */     c.count();
/* 132 */     this.key = key;
/* 133 */     this.scroll = c.scroll();
/* 134 */     this.mask = (1L << c.size) - 1L;
/* 135 */     this.iLong = c.longI;
/* 136 */     this.info = info;
/*     */     
/* 138 */     long cc = this.mask;
/* 139 */     cc <<= this.scroll;
/* 140 */     paramDataO.entries.push(key, c.size, new LONG_O.LONG_OE<T>()
/*     */         {
/*     */           public long get(T t)
/*     */           {
/* 144 */             return DataO.DataAbs.this.get(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(T t, long i) {
/* 149 */             DataO.DataAbs.this.set(t, (int)i);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 158 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(T t) {
/* 163 */     return (int)(DataO.this.data(t)[this.iLong] >>> this.scroll & this.mask);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(T t) {
/* 168 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(T t) {
/* 173 */     return (int)this.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T t, int s) {
/* 178 */     if (s < min(t) || s > max(t))
/* 179 */       throw new RuntimeException("" + s + " " + s + " " + min(t)); 
/* 180 */     long c = this.mask;
/* 181 */     s = (int)(s & this.mask);
/* 182 */     DataO.this.data(t)[this.iLong] = DataO.this.data(t)[this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 183 */     c = s & 0xFFFFFFFFL;
/* 184 */     c <<= this.scroll;
/* 185 */     DataO.this.data(t)[this.iLong] = DataO.this.data(t)[this.iLong] | c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataO$DataAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */