/*    */ package game.time;
/*    */ 
/*    */ import init.settings.S;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LightShadows
/*    */ {
/*    */   private double dir;
/*    */   private double sx;
/*    */   private double sy;
/*    */   private double sLength;
/*    */   private double tilt;
/*    */   boolean isNight;
/*    */   boolean rising;
/*    */   
/*    */   void update(Light light) {
/* 25 */     double ttilt = 1.0D;
/* 26 */     if ((S.get()).lightCycle.get() == 0) {
/* 27 */       this.dir = 180.0D;
/* 28 */       this.tilt = 25.0D;
/*    */     } else {
/* 30 */       this.dir = 450.0D - light.time.getD() * 360.0D;
/* 31 */       this.dir %= 360.0D;
/*    */       
/* 33 */       double dayL = (TIME.seasons()).currentDay.dayLength();
/* 34 */       double nightL = 1.0D - dayL;
/*    */       
/* 36 */       double nightA = nightL / 2.0D;
/* 37 */       double mid = nightA + dayL / 2.0D;
/* 38 */       double nightB = nightA + dayL;
/* 39 */       if (light.time.getD() < nightA) {
/* 40 */         ttilt = 1.0D - light.time.getD() / nightA;
/* 41 */         this.isNight = true;
/* 42 */         this.rising = false;
/* 43 */       } else if (light.time.getD() < mid) {
/* 44 */         ttilt = (light.time.getD() - nightA) / (mid - nightA);
/* 45 */         this.isNight = false;
/* 46 */         this.rising = true;
/* 47 */       } else if (light.time.getD() < nightB) {
/* 48 */         ttilt = 1.0D - (light.time.getD() - mid) / (nightB - mid);
/* 49 */         this.isNight = false;
/* 50 */         this.rising = false;
/*    */       } else {
/* 52 */         ttilt = (light.time.getD() - nightB) / (1.0D - nightB);
/* 53 */         this.isNight = true;
/* 54 */         this.rising = true;
/*    */       } 
/*    */       
/* 57 */       ttilt = Math.pow(ttilt, 1.0D);
/* 58 */       this.tilt = 5.0D + 35.0D * ttilt;
/*    */     } 
/*    */ 
/*    */     
/* 62 */     this.sLength = 3.5D - 3.0D * Math.pow(CLAMP.d(this.tilt / 50.0D, 0.0D, 1.0D), 1.0D);
/* 63 */     double ra = Math.toRadians(this.dir);
/* 64 */     this.sLength = (1.0D + (S.get()).shadows.getD()) * this.sLength;
/*    */     
/* 66 */     this.sx = -this.sLength * Math.cos(ra);
/* 67 */     this.sy = -this.sLength * Math.sin(ra);
/*    */   }
/*    */   
/*    */   double dir() {
/* 71 */     return this.dir;
/*    */   }
/*    */   
/*    */   double dirNight() {
/* 75 */     return (100.0D + this.dir) % 360.0D;
/*    */   }
/*    */   
/*    */   public double sx() {
/* 79 */     return this.sx;
/*    */   }
/*    */   
/*    */   public double sy() {
/* 83 */     return this.sy;
/*    */   }
/*    */   
/*    */   public double tilt() {
/* 87 */     return this.tilt;
/*    */   }
/*    */   
/*    */   public double dtilt() {
/* 91 */     return (this.tilt - 5.0D) / 35.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\LightShadows.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */