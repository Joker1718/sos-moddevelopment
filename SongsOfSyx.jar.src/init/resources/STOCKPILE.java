/*    */ package init.resources;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.data.INT_O;
/*    */ 
/*    */ public interface STOCKPILE
/*    */   extends INT_O<RESOURCE>
/*    */ {
/*    */   int get(int paramInt);
/*    */   
/*    */   public static class StockpileImp
/*    */     implements STOCKPILE, SAVABLE, INT_O.INT_OE<RESOURCE> {
/* 18 */     private int[] amounts = Alloc.ii(RESOURCES.ALL().size());
/*    */ 
/*    */     
/*    */     public int get(RESOURCE res) {
/* 22 */       return this.amounts[res.bIndex()];
/*    */     }
/*    */ 
/*    */     
/*    */     public void set(RESOURCE res, int amount) {
/* 27 */       this.amounts[res.bIndex()] = amount;
/*    */     }
/*    */     
/*    */     public void add(RESOURCE res, int inc) {
/* 31 */       this.amounts[res.bIndex()] = this.amounts[res.bIndex()] + inc;
/*    */     }
/*    */ 
/*    */     
/*    */     public void save(FilePutter file) {
/* 36 */       file.isE(this.amounts);
/*    */     }
/*    */ 
/*    */     
/*    */     public void load(FileGetter file) throws IOException {
/* 41 */       file.isE(this.amounts);
/*    */     }
/*    */ 
/*    */     
/*    */     public void clear() {
/* 46 */       Arrays.fill(this.amounts, 0);
/*    */     }
/*    */ 
/*    */     
/*    */     public int get(int ri) {
/* 51 */       return this.amounts[ri];
/*    */     }
/*    */ 
/*    */     
/*    */     public int min(RESOURCE t) {
/* 56 */       return 0;
/*    */     }
/*    */ 
/*    */     
/*    */     public int max(RESOURCE t) {
/* 61 */       return Integer.MAX_VALUE;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\STOCKPILE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */