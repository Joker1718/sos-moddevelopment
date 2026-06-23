/*    */ package game.faction.royalty;
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
/* 65 */     file.i(NPCCourt.this.all.size());
/* 66 */     for (Royalty r : NPCCourt.this.all) {
/* 67 */       r.save(file);
/*    */     }
/* 69 */     NPCCourt.this.king.save(file);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 77 */     int k = file.i();
/* 78 */     NPCCourt.this.all.clear();
/* 79 */     for (int i = 0; i < k; i++) {
/* 80 */       NPCCourt.this.all.add(new Royalty(NPCCourt.this, file));
/*    */     }
/* 82 */     NPCCourt.this.king.load(NPCCourt.this, file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 87 */     NPCCourt.this.all.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\NPCCourt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */