/*    */ package util.keymap;
/*    */ 
/*    */ import game.save.Savable;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
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
/*    */   extends Savable
/*    */ {
/*    */   null(String $anonymous0) {
/* 22 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void save(FilePutter file) {
/* 26 */     RMAPS.this.saver = new RMAPS.Saver(RMAPS.this, file);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 32 */     RMAPS.this.loader = new RMAPS.Loader(RMAPS.this, file);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMAPS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */