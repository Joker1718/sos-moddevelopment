/*    */ package game.events;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SuperSaver;
/*    */ import snake2d.util.sets.LIST;
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
/*    */   extends SuperSaver<EVENTS.EventResource>
/*    */ {
/*    */   null(Class<?> $anonymous0, LIST<EVENTS.EventResource> $anonymous1) {
/* 40 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void save(EVENTS.EventResource t, FilePutter f) {
/* 44 */     t.save(f);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(EVENTS.EventResource t, FileGetter f) throws IOException {
/* 49 */     t.load(f);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String key(EVENTS.EventResource t) {
/* 54 */     return t.key;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clear(EVENTS.EventResource t) {
/* 59 */     t.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\EVENTS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */