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
/*    */ public class EChoice
/*    */ {
/*    */   public final CharSequence name;
/* 14 */   public final Lockable<Faction> request = GVALUES.FACTION.LOCK.push();
/*    */   
/*    */   public final int index;
/*    */   public final LIST<EventAction> actions;
/*    */   
/*    */   EChoice(Event e, int index, EventActions act, Json data, CharSequence name) {
/* 20 */     this.name = name;
/* 21 */     this.request.push("REQUIRES", data);
/* 22 */     this.index = index;
/* 23 */     this.actions = EActions.actions(e, this, act, data);
/* 24 */     data.checkUnused();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EChoice.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */