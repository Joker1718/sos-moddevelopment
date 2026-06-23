/*    */ package view.main;
/*    */ 
/*    */ import game.save.Savable;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import view.keyboard.KEYS;
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
/*    */   extends Savable
/*    */ {
/*    */   null(String $anonymous0) {
/* 78 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void save(FilePutter file) {
/* 82 */     if (VIEW.this.current instanceof VIEW.ViewSub) {
/* 83 */       file.i(((VIEW.ViewSub)VIEW.this.current).index);
/*    */     } else {
/* 85 */       file.i(-1);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 91 */     int si = file.i();
/* 92 */     VIEW.ViewSub v = null;
/* 93 */     if (si >= 0) {
/* 94 */       v = (VIEW.ViewSub)VIEW.ViewSub.all.get(si);
/*    */     }
/* 96 */     KEYS.get().readSettings();
/* 97 */     VIEW.this.setFirstView(v);
/* 98 */     VIEW.this.current.activate();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\main\VIEW$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */