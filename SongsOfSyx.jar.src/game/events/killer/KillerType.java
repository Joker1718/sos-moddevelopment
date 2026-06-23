/*    */ package game.events.killer;
/*    */ 
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ class KillerType
/*    */ {
/*    */   public final CharSequence name;
/*    */   public final CharSequence method;
/*    */   public final CharSequence[] messages;
/*    */   
/*    */   KillerType(Json json) {
/* 12 */     this.name = json.text("NAME");
/* 13 */     this.method = json.text("METHOD");
/* 14 */     this.messages = (CharSequence[])json.texts("MESSAGES", 2, 100);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\KillerType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */