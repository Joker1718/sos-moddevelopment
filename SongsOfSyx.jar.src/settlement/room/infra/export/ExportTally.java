/*    */ package settlement.room.infra.export;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import util.data.INT_O;
/*    */ import util.keymap.RMapInt;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ExportTally
/*    */ {
/* 17 */   private final RMapInt<RESOURCE> pAmount = new RMapInt(RESOURCES.map());
/* 18 */   private final RMapInt<RESOURCE> pCapacity = new RMapInt(RESOURCES.map());
/* 19 */   public final INT_O<RESOURCE> amount = (INT_O<RESOURCE>)this.pAmount;
/* 20 */   public final INT_O<RESOURCE> capacity = (INT_O<RESOURCE>)this.pCapacity;
/*    */   
/*    */   final SAVABLE saver;
/*    */ 
/*    */   
/*    */   ExportTally() {
/* 26 */     this.saver = new SAVABLE()
/*    */       {
/*    */         public void save(FilePutter file)
/*    */         {
/* 30 */           ExportTally.this.pAmount.save(file);
/* 31 */           ExportTally.this.pCapacity.save(file);
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void load(FileGetter file) throws IOException {
/* 38 */           ExportTally.this.pAmount.load(file);
/* 39 */           ExportTally.this.pCapacity.load(file);
/* 40 */           ExportTally.this.pAmount.clear();
/* 41 */           for (ExportInstance i : (SETT.ROOMS()).EXPORT.all()) {
/* 42 */             if (i.resource() != null) {
/* 43 */               ExportTally.this.pAmount.inc(i.resource(), i.amount);
/*    */             }
/*    */           } 
/*    */         }
/*    */ 
/*    */         
/*    */         public void clear() {
/* 50 */           ExportTally.this.pAmount.clear();
/* 51 */           ExportTally.this.pCapacity.clear();
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   void inc(RESOURCE r, int amount, int capacity) {
/* 57 */     this.pAmount.inc(r, amount);
/* 58 */     this.pCapacity.inc(r, capacity);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\ExportTally.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */