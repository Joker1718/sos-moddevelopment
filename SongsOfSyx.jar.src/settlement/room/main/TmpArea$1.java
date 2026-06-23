/*    */ package settlement.room.main;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomBlueprint
/*    */ {
/*    */   null(String $anonymous0) {
/* 32 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void update(double ds) {
/* 36 */     if (TmpArea.this.lastUser != null) {
/* 37 */       TmpArea.this.error();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public SFinderFindable service(int tx, int ty) {
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public COLOR miniC(int tx, int ty) {
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 59 */     clear();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clear() {
/* 64 */     TmpArea.this.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public COLOR miniCPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/* 69 */     return (COLOR)origional;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\TmpArea$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */