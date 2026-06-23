/*    */ package settlement.weather;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class WeatherClouds
/*    */   extends WeatherThing
/*    */ {
/* 10 */   private static CharSequence ¤¤name = "Clouds";
/* 11 */   private static CharSequence ¤¤desc = "The amount of clouds.";
/* 12 */   private static double speed = 1.0D / 1.5D * TIME.secondsPerHour();
/*    */   private double target;
/*    */   
/*    */   static {
/* 16 */     D.ts(WeatherClouds.class);
/*    */   }
/*    */   
/*    */   WeatherClouds() {
/* 20 */     super(¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 25 */     setD(adjustTowards(getD(), ds * speed, this.target));
/* 26 */     this.target = 0.0D;
/*    */   }
/*    */   
/*    */   public void setTarget(double target) {
/* 30 */     this.target = CLAMP.d(target, 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 35 */     setD(0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherClouds.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */