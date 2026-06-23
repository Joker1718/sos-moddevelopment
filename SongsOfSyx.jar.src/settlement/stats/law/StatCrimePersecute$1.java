/*    */ package settlement.stats.law;
/*    */ 
/*    */ import init.type.HCLASS_RACE;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
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
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 39 */     HCLASS_RACE.MAP().saver().save(StatCrimePersecute.this.active, file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 44 */     HCLASS_RACE.MAP().loader().load(StatCrimePersecute.this.active, file, 0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 49 */     Arrays.fill(StatCrimePersecute.this.active, 0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatCrimePersecute$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */