/*    */ package init.trade;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.data.INT_O;
/*    */ 
/*    */ public class TR_STOCKPILE
/*    */   implements INT_O.INT_OE<TRADABLE>, SAVABLE
/*    */ {
/* 14 */   private int[] amounts = Alloc.ii(TR.ALL().size());
/*    */ 
/*    */   
/*    */   public int get(TRADABLE res) {
/* 18 */     return this.amounts[res.index()];
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(TRADABLE res, int amount) {
/* 23 */     this.amounts[res.index()] = amount;
/*    */   }
/*    */   
/*    */   public void add(TRADABLE res, int inc) {
/* 27 */     this.amounts[res.index()] = this.amounts[res.index()] + inc;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 32 */     TR.MAP().saver().save(this.amounts, file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 37 */     TR.MAP().loader().load(this.amounts, file, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 42 */     Arrays.fill(this.amounts, 0);
/*    */   }
/*    */   
/*    */   public int get(int ri) {
/* 46 */     return this.amounts[ri];
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(TRADABLE t) {
/* 51 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(TRADABLE t) {
/* 56 */     return Integer.MAX_VALUE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\trade\TR_STOCKPILE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */