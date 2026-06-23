/*     */ package util.data;
/*     */ 
/*     */ import snake2d.util.bit.Bits;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class INTWRAP<T>
/*     */   implements INT_O.INT_OE<T>
/*     */ {
/*     */   private final Bits bits;
/*     */   private final INT_O.INT_OE<T> data;
/*     */   
/*     */   public INTWRAP(int mask, INT_O.INT_OE<T> data) {
/* 152 */     this.bits = new Bits(mask);
/* 153 */     this.data = data;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(T t) {
/* 158 */     return this.bits.get(this.data.get(t));
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(T t) {
/* 163 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(T t) {
/* 168 */     return this.bits.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T t, int i) {
/* 173 */     int d = this.data.get(t);
/* 174 */     d = this.bits.set(d, i);
/* 175 */     this.data.set(t, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\INT_O$INTWRAP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */