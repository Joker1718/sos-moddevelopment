/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EChoice;
/*    */ import game.event.engine.Event;
/*    */ import game.event.engine.EventCollection;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ abstract class EventActionConstructor
/*    */ {
/*    */   public final String key;
/*    */   
/*    */   EventActionConstructor(String key) {
/* 14 */     this.key = key;
/*    */   }
/*    */   
/*    */   public abstract EventAction action(Data paramData);
/*    */   
/*    */   static class Data {
/*    */     Json json;
/*    */     Event parent;
/*    */     EChoice choice;
/*    */     LISTE<EventAction> all;
/*    */     EventCollection engine;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\EventActionConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */