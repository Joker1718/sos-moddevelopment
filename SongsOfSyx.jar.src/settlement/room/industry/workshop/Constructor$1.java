/*    */ package settlement.room.industry.workshop;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import settlement.room.main.furnisher.FurnisherStat;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends FurnisherStat.FurnisherStatEmployees
/*    */ {
/*    */   null(Furnisher $anonymous0) {
/* 52 */     super($anonymous0);
/*    */   }
/*    */   public double get(AREA area, double acc) {
/* 55 */     int am = 0;
/* 56 */     for (COORDINATE c : area.body()) {
/* 57 */       if (area.is(c) && 
/* 58 */         (SETT.ROOMS()).fData.tileData.get(c) == 3)
/* 59 */         am++; 
/*    */     } 
/* 61 */     return am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */