/*    */ package game.events.citizen;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
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
/* 56 */     int ri = RND.rInt(RACES.all().size());
/* 57 */     for (int i = 0; i < RACES.all().size(); i++) {
/* 58 */       Race r = (Race)RACES.all().getC(ri + i);
/* 59 */       if (EventCitizenStrike.this.event(0, r))
/*    */         return; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenStrike$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */