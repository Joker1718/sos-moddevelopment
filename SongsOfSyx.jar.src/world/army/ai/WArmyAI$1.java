/*    */ package world.army.ai;
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
/* 43 */     WArmyAI.this.war.save(file);
/* 44 */     WArmyAI.this.rebel.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 49 */     WArmyAI.this.war.load(file);
/* 50 */     WArmyAI.this.rebel.load(file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 55 */     WArmyAI.this.war.clear();
/* 56 */     WArmyAI.this.rebel.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\WArmyAI$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */