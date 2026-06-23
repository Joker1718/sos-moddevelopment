/*    */ package game.events.citizen;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.file.Alloc;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 55 */     int[] races = Alloc.ii(RACES.all().size());
/* 56 */     for (int i = 0; i < races.length; i++) {
/* 57 */       races[i] = (int)Math.ceil(((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(RACES.all().get(i)) * RND.rExpo()));
/*    */     }
/* 59 */     EventCitizenRiot.this.riot(races);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenRiot$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */