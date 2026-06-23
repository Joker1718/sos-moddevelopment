/*    */ package game.event.engine;
/*    */ 
/*    */ import snake2d.util.file.Json;
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
/*    */ final class ESelectionMark
/*    */ {
/*    */   public boolean mark = false;
/* 84 */   public String clear = null;
/* 85 */   public String filter = null;
/*    */   
/*    */   void read(Json json) {
/* 88 */     if (json.has("MARK")) {
/* 89 */       json = json.json("MARK");
/* 90 */       this.mark = json.bool("MARK_WITH_EVENT_KEY", false);
/* 91 */       this.clear = json.value("CLEAR_EVENT_KEY", null);
/* 92 */       this.filter = json.value("ALLOW_ONLY_MARK", null);
/* 93 */       json.checkUnused();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\ESelection$ESelectionMark.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */