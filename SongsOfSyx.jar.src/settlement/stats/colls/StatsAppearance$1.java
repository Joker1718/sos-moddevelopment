/*    */ package settlement.stats.colls;
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
/*    */   public void save(FilePutter file) {
/* 60 */     StatsAppearance.this.nameFirst.save(file);
/* 61 */     StatsAppearance.this.nameLast.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 66 */     StatsAppearance.this.nameFirst.load(file);
/* 67 */     StatsAppearance.this.nameLast.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 72 */     StatsAppearance.this.nameFirst.clear();
/* 73 */     StatsAppearance.this.nameLast.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAppearance$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */