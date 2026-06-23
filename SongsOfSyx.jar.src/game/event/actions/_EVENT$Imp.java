/*    */ package game.event.actions;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import game.event.engine.EventCollection;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Imp
/*    */   extends EventAction
/*    */ {
/*    */   public final Event other;
/*    */   private boolean keepInfo;
/*    */   private boolean clearContent;
/*    */   private boolean message;
/*    */   private boolean duration;
/*    */   
/*    */   Imp(String key, Event parent, Json data, LISTE<EventAction> all, EventCollection engine) {
/* 35 */     super(key, all);
/* 36 */     this.other = engine.read(parent, data.value("EVENT"), data, "EVENT");
/* 37 */     this.keepInfo = data.bool("KEEP_INFO", false);
/* 38 */     this.clearContent = data.bool("CLEAR_CONTEXT", false);
/* 39 */     this.message = data.bool("MESSAGE", true);
/* 40 */     this.duration = data.bool("KEEP_TIME", false);
/* 41 */     data.checkUnused();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exe(Event event, EContext data) {
/* 47 */     if (this.other != null)
/* 48 */       GAME.EVENT().set(this.other, this.keepInfo, this.duration, this.clearContent, this.message); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_EVENT$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */