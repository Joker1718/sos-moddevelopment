/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ public abstract class EventAction
/*    */ {
/* 13 */   public final ArrayListGrower<CInt> ints = new ArrayListGrower();
/*    */   public final String key;
/*    */   public boolean hideUI = false;
/*    */   
/*    */   EventAction(String key, LISTE<EventAction> all) {
/* 18 */     this.key = key;
/* 19 */     all.add(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void exe(Event e, EContext data) {}
/*    */ 
/*    */   
/*    */   void setContext(Event e, EContext data) {}
/*    */ 
/*    */   
/*    */   public void hover(GBox b, Event e, EContext context) {}
/*    */   
/*    */   public CharSequence problem(Event e, EContext context) {
/* 32 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addToMessageBody(LISTE<RENDEROBJ> rows, Event e, EContext context, RECTANGLE messBody) {}
/*    */ 
/*    */   
/*    */   public void update(Event e, EContext context, double ds, double second) {}
/*    */ 
/*    */   
/* 43 */   private static String levent = null;
/*    */   
/*    */   public class CInt
/*    */   {
/* 47 */     int di = -1;
/*    */ 
/*    */     
/*    */     CInt(String key) {
/* 51 */       EventAction.this.ints.add(this);
/*    */     }
/*    */     
/*    */     public int get(Event e, EContext t) {
/* 55 */       if (EventAction.levent != e.key) {
/* 56 */         t.actionContext = EventActionContext.makeData(e, t.actionContext);
/* 57 */         EventAction.levent = e.key;
/*    */       } 
/* 59 */       if (t.actionContext != null && this.di >= 0 && this.di < t.actionContext.length)
/* 60 */         return t.actionContext[this.di]; 
/* 61 */       return 0;
/*    */     }
/*    */     
/*    */     public void set(Event e, EContext t, int i) {
/* 65 */       if (EventAction.levent != e.key) {
/* 66 */         t.actionContext = EventActionContext.makeData(e, t.actionContext);
/* 67 */         EventAction.levent = e.key;
/*    */       } 
/* 69 */       if (t.actionContext != null && this.di >= 0 && this.di < t.actionContext.length)
/* 70 */         t.actionContext[this.di] = i; 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\EventAction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */