/*    */ package game.events.citizen;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.rnd.RND;
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
/* 44 */     int ri = RND.rInt(RACES.all().size());
/* 45 */     for (int i = 0; i < RACES.all().size(); i++) {
/* 46 */       Race r = (Race)RACES.all().getC(ri + i);
/* 47 */       int am = (int)Math.ceil(((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) * RND.rFloat()));
/* 48 */       if (am > 0) {
/* 49 */         EventCitizenEmmigrate.this.event(am, r);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenEmmigrate$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */