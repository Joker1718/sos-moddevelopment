/*    */ package game.events.general;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.Event;
/*    */ import snake2d.util.sets.Tree;
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
/*    */   extends Tree<Event>
/*    */ {
/*    */   null(int $anonymous0) {
/* 41 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(Event current, Event cmp) {
/* 45 */     return (GAME.EVENT().acc(current) > GAME.EVENT().acc(cmp));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\general\EventGeneral$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */