/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class _EARTHQUAKE
/*    */   extends EventActionConstructor
/*    */ {
/*    */   _EARTHQUAKE() {
/* 16 */     super("EARTHQUAKE");
/*    */   }
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 21 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp extends EventAction {
/*    */     double acc;
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 28 */       super(key, all);
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
/* 41 */       this.vtime = 0.0D;
/*    */       data.checkUnused();
/*    */     } double vtime;
/*    */     public void update(Event event, EContext e, double ds, double second) {
/* 45 */       if (VIEW.s().isActive() && VIEW.renderSecond() > this.vtime) {
/* 46 */         this.vtime = VIEW.renderSecond() + RND.rFloat() * 0.2D;
/* 47 */         if (ds > 0.0D)
/* 48 */           (VIEW.s().getWindow()).centerer.set(VIEW.s().getWindow().pixels().cX() + RND.rInt0(20), VIEW.s().getWindow().pixels().cY() + RND.rInt0(20)); 
/*    */       } 
/*    */     }
/*    */     
/*    */     public void setContext(Event event, EContext data) {
/*    */       this.acc = 0.0D;
/*    */       this.vtime = 0.0D;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_EARTHQUAKE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */