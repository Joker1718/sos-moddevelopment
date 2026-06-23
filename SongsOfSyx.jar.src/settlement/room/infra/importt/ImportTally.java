/*    */ package settlement.room.infra.importt;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.data.INT_O;
/*    */ import util.keymap.MAPPED;
/*    */ import util.keymap.RMapInt;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ImportTally
/*    */ {
/* 18 */   private final RMapInt<RESOURCE> pAmount = new RMapInt(RESOURCES.map());
/* 19 */   private final RMapInt<RESOURCE> pCapacity = new RMapInt(RESOURCES.map());
/* 20 */   public final INT_O<RESOURCE> amount = (INT_O<RESOURCE>)this.pAmount;
/* 21 */   public final INT_O<RESOURCE> capacity = (INT_O<RESOURCE>)this.pCapacity;
/*    */   
/*    */   public void debug(RESOURCE res) {
/* 24 */     LOG.ln(res.name);
/* 25 */     LOG.ln("am " + this.pAmount.get((MAPPED)res));
/* 26 */     LOG.ln("ca " + this.capacity.get(res));
/* 27 */     LOG.ln(Integer.valueOf(spaceForTribute(res)));
/* 28 */     LOG.ln();
/*    */   }
/*    */ 
/*    */   
/*    */   final SAVABLE saver;
/*    */   
/*    */   ImportTally() {
/* 35 */     this.saver = new SAVABLE()
/*    */       {
/*    */         public void save(FilePutter file) {}
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void load(FileGetter file) throws IOException {
/* 43 */           ImportTally.this.pAmount.clear();
/* 44 */           ImportTally.this.pCapacity.clear();
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public void clear() {
/* 50 */           ImportTally.this.pAmount.clear();
/* 51 */           ImportTally.this.pCapacity.clear();
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   void count(RESOURCE r, int amount, int capacity) {
/* 57 */     if (r != null) {
/* 58 */       this.pAmount.inc(r, amount);
/* 59 */       this.pCapacity.inc(r, capacity);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int spaceForTribute(RESOURCE res) {
/* 66 */     int am = this.capacity.get(res) - this.amount.get(res);
/* 67 */     if (am < 0) {
/* 68 */       return 0;
/*    */     }
/* 70 */     return am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\ImportTally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */