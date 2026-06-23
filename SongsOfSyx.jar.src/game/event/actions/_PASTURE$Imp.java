/*    */ package game.event.actions;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.food.pasture.PastureInstance;
/*    */ import settlement.room.food.pasture.ROOM_PASTURE;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
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
/*    */ public final class Imp
/*    */   extends EventAction
/*    */ {
/*    */   private final ROOM_PASTURE room;
/*    */   private final double amount;
/*    */   
/*    */   Imp(String key, Json data, LISTE<EventAction> all) {
/* 32 */     super(key, all);
/* 33 */     RoomBlueprint b = (RoomBlueprint)(SETT.ROOMS()).collection.getWarn(data.value("ROOM"), data);
/*    */     
/* 35 */     if (b != null && b instanceof ROOM_PASTURE) {
/* 36 */       this.room = (ROOM_PASTURE)b;
/*    */     } else {
/* 38 */       this.room = null;
/* 39 */       GAME.Warn(data.errorGet("no pasture named: " + data.value("ROOM"), "ROOM"));
/*    */     } 
/* 41 */     this.amount = data.d("ANIMALS_KILLED", 0.0D, 1.0D);
/* 42 */     data.checkUnused();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exe(Event event, EContext data) {
/* 48 */     if (this.room == null) {
/*    */       return;
/*    */     }
/* 51 */     ROOM_PASTURE p = this.room;
/*    */     
/* 53 */     if (p.instancesSize() == 0) {
/*    */       return;
/*    */     }
/* 56 */     double death = this.amount;
/*    */     
/* 58 */     double am = 0.0D;
/* 59 */     int tot = 0;
/*    */     
/* 61 */     for (int i = 0; i < p.instancesSize(); i++) {
/* 62 */       PastureInstance ins = (PastureInstance)p.getInstance(i);
/* 63 */       data.coo.set(ins.body().cX(), ins.body().cY());
/* 64 */       tot += ins.animalsCurrent();
/* 65 */       int d = (int)Math.ceil(Math.ceil(ins.animalsCurrent() * death));
/* 66 */       ins.kill(d);
/* 67 */       am += d;
/*    */     } 
/*    */ 
/*    */     
/* 71 */     double per = am / tot;
/* 72 */     data.actionAmount = per;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_PASTURE$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */