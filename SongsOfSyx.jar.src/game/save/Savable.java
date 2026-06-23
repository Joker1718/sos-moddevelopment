/*    */ package game.save;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ 
/*    */ public abstract class Savable
/*    */ {
/*    */   public final String key;
/*    */   
/*    */   public Savable(String key) {
/* 13 */     this.key = key;
/*    */   }
/*    */   
/*    */   protected abstract void save(FilePutter paramFilePutter);
/*    */   
/*    */   protected void loadFail() {
/* 19 */     throw new RuntimeException("Failed to load critical resource: " + this.key);
/*    */   }
/*    */   
/*    */   protected abstract void load(FileGetter paramFileGetter) throws IOException;
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\save\Savable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */