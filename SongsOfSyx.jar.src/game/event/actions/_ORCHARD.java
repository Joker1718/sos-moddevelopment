/*    */ package game.event.actions;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.food.orchard.ROOM_ORCHARD;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ final class _ORCHARD
/*    */   extends EventActionConstructor
/*    */ {
/*    */   _ORCHARD() {
/* 19 */     super("ORCHARD");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 25 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction
/*    */   {
/*    */     private final ROOM_ORCHARD room;
/*    */     private final double amount;
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 35 */       super(key, all);
/* 36 */       RoomBlueprint b = (RoomBlueprint)(SETT.ROOMS()).collection.getWarn(data.value("ROOM"), data);
/*    */       
/* 38 */       if (b != null && b instanceof ROOM_ORCHARD) {
/* 39 */         this.room = (ROOM_ORCHARD)b;
/*    */       } else {
/* 41 */         this.room = null;
/* 42 */         GAME.Warn(data.errorGet("no orchard room named: " + data.value("ROOM"), "ROOM"));
/*    */       } 
/* 44 */       this.amount = data.d("AREA_AFFECTED", 0.0D, 1.0D);
/* 45 */       data.checkUnused();
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void exe(Event event, EContext data) {
/* 51 */       int area = (int)(this.amount * this.room.totalArea());
/* 52 */       double aa = 0.0D;
/* 53 */       int r = RND.rInt() & Integer.MAX_VALUE;
/* 54 */       boolean first = true;
/*    */ 
/*    */       
/* 57 */       for (int i = 0; i < this.room.instancesSize(); i++) {
/* 58 */         RoomInstance ro = this.room.getInstance((i + r) % this.room.instancesSize());
/* 59 */         if (first || ro.area() <= area) {
/* 60 */           this.room.event(ro.mX(), ro.mY(), 1.0D);
/* 61 */           data.coo.set(ro.body().cX(), ro.body().cY());
/* 62 */           area -= ro.area();
/* 63 */           first = false;
/* 64 */           aa += ro.area();
/*    */         } 
/*    */       } 
/*    */       
/* 68 */       double per = aa / this.room.totalArea();
/* 69 */       data.actionAmount = per;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_ORCHARD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */