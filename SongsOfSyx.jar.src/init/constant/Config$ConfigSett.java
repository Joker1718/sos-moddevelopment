/*    */ package init.constant;
/*    */ 
/*    */ import snake2d.Errors;
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
/*    */ public final class ConfigSett
/*    */ {
/* 68 */   public final double HAPPINESS_EXPONENT = Config.j.d("HAPPINESS_EXPONENT");
/* 69 */   public final int TOURIST_PER_YEAR_MAX = Config.j.i("TOURIST_PER_YEAR_MAX");
/* 70 */   public final double TOURIST_CRETIDS = Config.j.d("TOURIST_CRETIDS");
/* 71 */   public final int DIMENSION = Config.j.i("DIMENSION", 256, 16000);
/*    */   
/* 73 */   public final double POP_RAIDER_WORTH = Config.j.i("POP_RAIDER_WORTH", 1, 10000);
/* 74 */   public final int secondsPerHour = Config.j.i("SECONDS_PER_HOUR");
/* 75 */   public final int hoursPerDay = Config.j.i("HOURS_PER_DAY");
/*    */ 
/*    */   
/*    */   ConfigSett() {
/* 79 */     if (this.DIMENSION % 64 != 0)
/* 80 */       throw new Errors.DataError("SETT DIMENSION MUST BE A MULTIPLE OF 64"); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\constant\Config$ConfigSett.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */