/*    */ package game.event.engine;
/*    */ 
/*    */ import game.event.actions.EventAction;
/*    */ import game.event.actions.EventActions;
/*    */ import game.faction.Faction;
/*    */ import init.value.GVALUES;
/*    */ import init.value.Lockable;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ class ECondition
/*    */ {
/*    */   public final LIST<EventAction> on_fulfill;
/* 14 */   public final Lockable<Faction> request = GVALUES.FACTION.LOCK.push();
/*    */ 
/*    */   
/*    */   ECondition(String key, Json data, EventActions actions, Event parent) {
/* 18 */     if (key != null)
/* 19 */       data = data.json(key); 
/* 20 */     this.request.push("REQUIRES", data);
/* 21 */     this.on_fulfill = EActions.actions(parent, actions, data);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\ECondition.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */