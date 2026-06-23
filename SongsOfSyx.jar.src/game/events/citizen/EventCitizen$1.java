/*    */ package game.events.citizen;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 75 */     double total = 0.0D;
/* 76 */     for (Race r : RACES.all()) {
/* 77 */       int a = EventCitizen.this.getAmount(r);
/* 78 */       total += a;
/* 79 */       EventCitizen.this.amounts[r.index()] = a;
/*    */     } 
/*    */ 
/*    */     
/* 83 */     double c = total / (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(null);
/*    */     
/* 85 */     if (c == 0.0D) {
/* 86 */       LOG.ln("nay!");
/*    */     } else {
/* 88 */       Race r = EventCitizen.this.getRace(total);
/* 89 */       EventCitizen.this.emmi.event(EventCitizen.this.amounts[r.index], r);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizen$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */