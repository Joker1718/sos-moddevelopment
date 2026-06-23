/*    */ package settlement.weather;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import settlement.main.SETT;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class WeatherIce
/*    */   extends WeatherThing {
/*  9 */   private static CharSequence ¤¤name = "Ice";
/* 10 */   private static CharSequence ¤¤desc = "Amount of ice on the water.";
/* 11 */   private static double thawspeed = 1.0D / (8 * TIME.secondsPerHour());
/*    */   
/*    */   static {
/* 14 */     D.ts(WeatherIce.class);
/*    */   }
/*    */   
/*    */   WeatherIce() {
/* 18 */     super(¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 24 */     double c = getD();
/* 25 */     double d = -((SETT.WEATHER()).temp.getD() - 0.5D) * 2.0D * thawspeed * ds;
/* 26 */     setD(c + d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 31 */     double snow = 0.0D;
/* 32 */     double p = TIME.years().bitPartOf();
/* 33 */     double tmp1 = (SETT.WEATHER()).temp.average(p - 0.2D);
/* 34 */     double tmp2 = (SETT.WEATHER()).temp.average(p);
/* 35 */     if (tmp1 < 0.5D && tmp2 < 0.5D) {
/* 36 */       snow = 1.0D;
/* 37 */     } else if (tmp1 < 0.5D) {
/* 38 */       snow = 1.0D - (tmp2 - 0.5D) * 16.0D;
/*    */     } 
/* 40 */     setD(snow);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBatheOutside() {
/* 45 */     return (getD() < 0.1D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherIce.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */