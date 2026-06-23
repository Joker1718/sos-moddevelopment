/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import snake2d.Errors;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventActionContext
/*    */ {
/*    */   public static int[] makeData(Event a, int[] old) {
/* 18 */     int ii = make(a, 0);
/*    */     
/* 20 */     if (old == null || old.length < ii) {
/* 21 */       old = Alloc.ii(ii + 16);
/*    */     }
/* 23 */     return old;
/*    */   }
/*    */ 
/*    */   
/*    */   private static int make(Event event, int ii) {
/* 28 */     if (ii < 0) {
/* 29 */       throw new Errors.DataError("Something is wrong with event " + event.key + ". Either the event chain is too long, or the event has a cyclic behaviour.");
/*    */     }
/*    */     int ai;
/* 32 */     for (ai = 0; ai < event.actions().size(); ai++) {
/* 33 */       EventAction a = (EventAction)event.actions().get(ai);
/* 34 */       for (EventAction.CInt i : a.ints) {
/* 35 */         i.di = ii++;
/*    */       }
/*    */     } 
/*    */     
/* 39 */     for (ai = 0; ai < event.actions().size(); ai++) {
/* 40 */       EventAction a = (EventAction)event.actions().get(ai);
/* 41 */       if (a instanceof _EVENT.Imp) {
/* 42 */         ii = make(((_EVENT.Imp)a).other, ii);
/*    */       }
/*    */     } 
/*    */     
/* 46 */     return ii;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setData(Event event, EContext con) {
/* 53 */     for (int ai = 0; ai < event.actions().size(); ai++) {
/* 54 */       EventAction a = (EventAction)event.actions().get(ai);
/* 55 */       a.setContext(event, con);
/*    */     } 
/*    */   }
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
/*    */   static void check(LIST<Event> events) {
/* 71 */     for (Event o : events) {
/* 72 */       for (int ai = 0; ai < o.actions().size(); ai++) {
/* 73 */         EventAction a = (EventAction)o.actions().get(ai);
/* 74 */         if (a instanceof _EVENT.Imp && ((_EVENT.Imp)a).other == o)
/* 75 */           throw new Errors.DataError("Event: " + o.key + " Has a cyclic nature and this is bad!"); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\EventActionContext.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */