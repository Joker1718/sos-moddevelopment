/*    */ package settlement.path.finders;
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
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 43 */     file.i(SFinderFindable.all.size());
/* 44 */     for (SFinderFindable a : SFinderFindable.all) {
/* 45 */       a.map.save(file);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 52 */     int am = file.i();
/* 53 */     if (am != SFinderFindable.all.size()) {
/* 54 */       for (int i = 0; i < am; i++) {
/* 55 */         ((SFinderFindable)SFinderFindable.all.get(0)).map.load(file);
/*    */       }
/* 57 */       clear();
/*    */     } else {
/*    */       
/* 60 */       for (SFinderFindable a : SFinderFindable.all) {
/* 61 */         a.map.load(file);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 68 */     for (int i = 0; i < SFinderFindable.all.size(); i++)
/* 69 */       ((SFinderFindable)SFinderFindable.all.get(i)).map.clear(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFindersUpdater$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */