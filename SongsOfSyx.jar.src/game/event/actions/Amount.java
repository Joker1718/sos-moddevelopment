/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ class Amount
/*    */ {
/*    */   public final EventAction.CInt amount;
/* 12 */   public double rel = 0.0D;
/* 13 */   public double perPerson = 0.0D;
/* 14 */   public double abs = 0.0D;
/*    */   
/*    */   Amount(EventAction.CInt amount) {
/* 17 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   void read(Json json, int min) {
/* 21 */     this.rel = json.dTry("RELATIVE", min, 1000.0D, 0.0D);
/* 22 */     this.perPerson = json.dTry("PER_PERSON", min, 1000.0D, 0.0D);
/* 23 */     this.abs = json.dTry("AMOUNT", min, 2.147483647E9D, 0.0D);
/* 24 */     json.checkUnused();
/*    */   }
/*    */   
/*    */   void set(Event event, EContext c, int available) {
/* 28 */     int am = (int)(this.rel * available);
/* 29 */     am = (int)(am + this.perPerson * (STATS.POP()).POP.data().get(null));
/* 30 */     am = (int)(am + this.abs);
/* 31 */     this.amount.set(event, c, am);
/*    */   }
/*    */ 
/*    */   
/*    */   void inc(Event event, EContext c, int available) {
/* 36 */     int am = (int)(this.rel * available);
/* 37 */     am = (int)(am + this.perPerson * (STATS.POP()).POP.data().get(null));
/* 38 */     am = (int)(am + this.abs);
/* 39 */     this.amount.set(event, c, this.amount.get(event, c) + am);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\Amount.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */