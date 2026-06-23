/*    */ package game.events.disaster;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import settlement.main.SETT;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 34 */     EventTemperature.this.event(0.2D, (SETT.WEATHER()).temp.average(TIME.years().bitPartOf()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\disaster\EventTemperature$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */