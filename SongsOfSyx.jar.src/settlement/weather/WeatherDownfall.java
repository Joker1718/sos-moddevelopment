/*    */ package settlement.weather;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class WeatherDownfall
/*    */   extends WeatherThing
/*    */ {
/*  9 */   private static CharSequence ¤¤name = "Downfall";
/* 10 */   private static CharSequence ¤¤desc = "The amount of downfall.";
/* 11 */   private static double speed = 0.5D / TIME.secondsPerHour();
/* 12 */   private double target = 0.0D;
/*    */   
/*    */   static {
/* 15 */     D.ts(WeatherDownfall.class);
/*    */   }
/*    */   
/*    */   WeatherDownfall() {
/* 19 */     super(¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 24 */     setD(adjustTowards(getD(), ds * speed, this.target));
/* 25 */     this.target = 0.0D;
/*    */   }
/*    */   
/*    */   public void setTarget(double target) {
/* 29 */     this.target = target;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 34 */     setD(0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherDownfall.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */