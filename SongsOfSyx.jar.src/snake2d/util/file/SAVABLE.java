/*    */ package snake2d.util.file;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public interface SAVABLE {
/*    */   void save(FilePutter paramFilePutter);
/*    */   
/*    */   void load(FileGetter paramFileGetter) throws IOException;
/*    */   
/*    */   void clear();
/*    */   
/*    */   public static abstract class SuperSavable implements SAVABLE {
/*    */     private final String key;
/*    */     
/*    */     SuperSavable(String key) {
/* 16 */       this.key = key;
/*    */     }
/*    */ 
/*    */     
/*    */     public void save(FilePutter f) {
/* 21 */       f.chars(this.key);
/* 22 */       int pos = f.getPosition();
/* 23 */       f.i(0);
/* 24 */       psave(f);
/* 25 */       int le = f.getPosition() - pos - 4;
/* 26 */       f.setAtPosition(pos, le);
/*    */     }
/*    */     
/*    */     public void load(FileGetter file) throws IOException {}
/*    */     
/*    */     public void clear() {}
/*    */     
/*    */     protected abstract void psave(FilePutter param1FilePutter);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\SAVABLE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */