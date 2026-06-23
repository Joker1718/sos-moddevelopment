/*    */ package world.region;
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
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 34 */     Realm.this.regions.save(file);
/* 35 */     file.s(Realm.this.capitolI);
/* 36 */     file.d(Realm.this.ferArea);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 41 */     Realm.this.regions.load(file);
/* 42 */     Realm.this.capitolI = file.s();
/* 43 */     Realm.this.ferArea = file.d();
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 48 */     Realm.this.regions.clear();
/* 49 */     Realm.this.capitolI = -1;
/* 50 */     Realm.this.ferArea = 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Realm$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */