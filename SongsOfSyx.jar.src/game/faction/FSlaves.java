/*    */ package game.faction;
/*    */ 
/*    */ import init.race.Race;
/*    */ 
/*    */ public abstract class FSlaves extends FactionResource {
/*    */   public abstract int available(Race paramRace);
/*    */   
/*    */   public abstract void trade(Race paramRace, int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract int price(Race paramRace, int paramInt);
/*    */   
/*    */   public static int B22ASE_PRICE(Race race) {
/* 13 */     int days = 20;
/* 14 */     days *= FACTIONS.PRICE().edibleLow();
/* 15 */     return days;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FSlaves.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */