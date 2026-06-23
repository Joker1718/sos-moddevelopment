/*    */ package settlement.room.infra.importt;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {}
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 43 */     ImportTally.this.pAmount.clear();
/* 44 */     ImportTally.this.pCapacity.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 50 */     ImportTally.this.pAmount.clear();
/* 51 */     ImportTally.this.pCapacity.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\ImportTally$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */