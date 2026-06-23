/*    */ package view.ui.message;
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
/* 69 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void save(FilePutter f) {
/* 73 */     f.mark(this);
/* 74 */     f.i(Messages.this.all.size());
/* 75 */     for (Message m : Messages.this.all) {
/* 76 */       f.object(m);
/*    */     }
/*    */   }
/*    */   
/*    */   public void load(FileGetter f) throws IOException {
/* 81 */     f.check(this);
/* 82 */     Messages.this.unread = 0;
/*    */     
/* 84 */     int am = f.i();
/*    */     
/* 86 */     for (int i = 0; i < am; i++) {
/* 87 */       Message m = (Message)f.object(true);
/* 88 */       if (m != null) {
/* 89 */         Messages.this.all.add(m);
/* 90 */         if (!m.isRead)
/* 91 */           Messages.this.unread++; 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\Messages$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */