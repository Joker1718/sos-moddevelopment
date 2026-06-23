/*    */ package game.event.engine;
/*    */ 
/*    */ import game.event.actions.EventAction;
/*    */ import game.event.actions.EventActions;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ final class EActions {
/*    */   static LIST<EventAction> actions() {
/* 12 */     return (LIST<EventAction>)new ArrayList(0);
/*    */   }
/*    */ 
/*    */   
/*    */   static LIST<EventAction> actions(Event e, EventActions act, Json data) {
/* 17 */     return get(e, null, act, data, true);
/*    */   }
/*    */ 
/*    */   
/*    */   static LIST<EventAction> actions(Event e, EChoice c, EventActions act, Json data) {
/* 22 */     return get(e, c, act, data, true);
/*    */   }
/*    */ 
/*    */   
/*    */   static LIST<EventAction> actions(String key, Event e, EventActions act, Json data) {
/* 27 */     return actions(key, e, null, act, data, true);
/*    */   }
/*    */   
/*    */   static LIST<EventAction> actions(String key, Event e, EChoice choice, EventActions act, Json data, boolean allowOther) {
/* 31 */     if (!data.has(key)) {
/* 32 */       return (LIST<EventAction>)new ArrayList(0);
/*    */     }
/* 34 */     data = data.json(key);
/* 35 */     return get(e, choice, act, data, allowOther);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static LIST<EventAction> get(Event e, EChoice choice, EventActions act, Json data, boolean allow) {
/* 41 */     if (data.has("ACTIONS")) {
/* 42 */       return act.get(data.jsons("ACTIONS"), e, choice, (LISTE)e.allActions, allow);
/*    */     }
/* 44 */     return (LIST<EventAction>)new ArrayList(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EActions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */