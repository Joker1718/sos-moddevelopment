/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
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
/*    */ public class CInt
/*    */ {
/* 47 */   int di = -1;
/*    */ 
/*    */   
/*    */   CInt(String key) {
/* 51 */     paramEventAction.ints.add(this);
/*    */   }
/*    */   
/*    */   public int get(Event e, EContext t) {
/* 55 */     if (EventAction.levent != e.key) {
/* 56 */       t.actionContext = EventActionContext.makeData(e, t.actionContext);
/* 57 */       EventAction.levent = e.key;
/*    */     } 
/* 59 */     if (t.actionContext != null && this.di >= 0 && this.di < t.actionContext.length)
/* 60 */       return t.actionContext[this.di]; 
/* 61 */     return 0;
/*    */   }
/*    */   
/*    */   public void set(Event e, EContext t, int i) {
/* 65 */     if (EventAction.levent != e.key) {
/* 66 */       t.actionContext = EventActionContext.makeData(e, t.actionContext);
/* 67 */       EventAction.levent = e.key;
/*    */     } 
/* 69 */     if (t.actionContext != null && this.di >= 0 && this.di < t.actionContext.length)
/* 70 */       t.actionContext[this.di] = i; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\EventAction$CInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */