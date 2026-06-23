/*    */ package game.event.engine;
/*    */ 
/*    */ import game.event.actions.EventAction;
/*    */ import game.event.actions.EventActions;
/*    */ import game.time.TIME;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ public class EDuration
/*    */ {
/*    */   public final double seconds;
/*    */   public final LIST<EventAction> on_expire;
/*    */   
/*    */   EDuration(Json data, EventActions actions, Event parent) {
/* 16 */     if (data.has("DURATION")) {
/* 17 */       data = data.json("DURATION");
/* 18 */       this.seconds = data.dTry("DAYS", 0.0D, 1000000.0D, 1.0D) * TIME.secondsPerDay();
/* 19 */       this.on_expire = EActions.actions(parent, actions, data);
/* 20 */       data.checkUnused();
/*    */     } else {
/* 22 */       this.seconds = 0.0D;
/* 23 */       this.on_expire = EActions.actions();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EDuration.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */