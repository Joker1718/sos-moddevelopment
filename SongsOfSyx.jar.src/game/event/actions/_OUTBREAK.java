/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import init.type.DISEASE;
/*    */ import init.type.DISEASES;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ final class _OUTBREAK
/*    */   extends EventActionConstructor
/*    */ {
/*    */   _OUTBREAK() {
/* 15 */     super("OUTBREAK");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 21 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction {
/*    */     private final double amount;
/*    */     public final DISEASE disease;
/* 28 */     private EventAction.CInt am = new EventAction.CInt(this, "AFFLICTED");
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 31 */       super(key, all);
/* 32 */       this.amount = data.d("AMOUNT", 0.0D, 1.0D);
/* 33 */       this.disease = (DISEASE)DISEASES.map().readTry(data);
/* 34 */       data.checkUnused();
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void exe(Event event, EContext data) {
/* 40 */       if (this.disease != null) {
/* 41 */         int am = STATS.DISEASE().incubating().data().get(null) + STATS.DISEASE().sick().data().get(null);
/* 42 */         STATS.DISEASE().outbreak(this.amount, this.disease);
/* 43 */         am = STATS.DISEASE().incubating().data().get(null) + STATS.DISEASE().sick().data().get(null) - am;
/* 44 */         this.am.set(event, data, am);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_OUTBREAK.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */