/*    */ package game.tourism;
/*    */ 
/*    */ import init.race.Race;
/*    */ import java.util.Comparator;
/*    */ import settlement.room.main.RoomBlueprintImp;
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
/*    */   implements Comparator<RoomBlueprintImp>
/*    */ {
/*    */   public int compare(RoomBlueprintImp o1, RoomBlueprintImp o2) {
/* 58 */     double v = race.pref().getWork(o1.employment()) - race.pref().getWork(o2.employment());
/* 59 */     if (v < 0.0D)
/* 60 */       return 1; 
/* 61 */     if (v > 0.0D)
/* 62 */       return -1; 
/* 63 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\TourismRace$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */