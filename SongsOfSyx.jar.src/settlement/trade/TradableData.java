/*    */ package settlement.trade;
/*    */ 
/*    */ import init.trade.TRADE_TYPE;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.data.INT_O;
/*    */ 
/*    */ public class TradableData
/*    */   implements INT_O.INT_OE<TRADE_TYPE>, SAVABLE
/*    */ {
/* 15 */   private int[] data = Alloc.ii(TRADE_TYPE.all.size());
/* 16 */   private int total = 0;
/*    */   
/*    */   public int get(TRADE_TYPE t) {
/* 19 */     if (t == null)
/* 20 */       return this.total; 
/* 21 */     return this.data[t.index];
/*    */   }
/*    */   
/*    */   public int min(TRADE_TYPE t) {
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */   public int max(TRADE_TYPE t) {
/* 29 */     return Integer.MAX_VALUE;
/*    */   }
/*    */   
/*    */   public void set(TRADE_TYPE t, int i) {
/* 33 */     this.total -= this.data[t.index];
/* 34 */     this.data[t.index] = i;
/* 35 */     this.total += this.data[t.index];
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 40 */     file.isE(this.data);
/*    */   }
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 44 */     file.isE(this.data);
/* 45 */     this.total = 0; byte b; int i, arrayOfInt[];
/* 46 */     for (i = (arrayOfInt = this.data).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 47 */       this.total += j;
/*    */       b++; }
/*    */   
/*    */   } public void clear() {
/* 51 */     Arrays.fill(this.data, 0);
/* 52 */     this.total = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\TradableData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */