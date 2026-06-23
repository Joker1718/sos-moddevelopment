/*    */ package settlement.room.water;
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
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 39 */     file.d(Updater.this.timer);
/* 40 */     Updater.this.grid1.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 45 */     Updater.this.timer = file.d();
/* 46 */     Updater.this.grid1.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 51 */     Updater.this.timer = 0.0D;
/* 52 */     Updater.this.grid1.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Updater$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */