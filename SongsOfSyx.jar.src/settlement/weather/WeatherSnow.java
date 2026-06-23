/*    */ package settlement.weather;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class WeatherSnow
/*    */   extends WeatherThing
/*    */ {
/* 14 */   private static CharSequence ¤¤name = "Snow";
/* 15 */   private static CharSequence ¤¤desc = "Amount of snow on the ground";
/* 16 */   private static double rainspeed = 1.0D / (TIME.secondsPerHour() * 4);
/* 17 */   private static double thawspeed = 1.0D / (4 * TIME.secondsPerHour());
/*    */   private double snowCount;
/*    */   
/*    */   static {
/* 21 */     D.ts(WeatherSnow.class);
/*    */   }
/*    */   
/*    */   WeatherSnow() {
/* 25 */     super(¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 31 */     if ((SETT.WEATHER()).temp.cold() > 0.0D) {
/* 32 */       this.snowCount -= ds * (SETT.WEATHER()).temp.cold();
/* 33 */       if (this.snowCount < 0.0D)
/* 34 */         this.snowCount = -4.0D; 
/*    */     } else {
/* 36 */       this.snowCount += ds * (SETT.WEATHER()).temp.heat();
/* 37 */       if (this.snowCount > 0.0D) {
/* 38 */         this.snowCount = 4.0D;
/*    */       }
/*    */     } 
/* 41 */     double d = getD();
/* 42 */     if (rainIsSnow()) {
/* 43 */       d += (SETT.WEATHER()).rain.getD() * rainspeed * ds;
/*    */     } else {
/* 45 */       d -= 2.0D * (SETT.WEATHER()).rain.getD() * rainspeed * ds;
/*    */     } 
/* 47 */     if ((SETT.WEATHER()).temp.heat() > 0.0D) {
/* 48 */       d -= thawspeed * (SETT.WEATHER()).temp.heat() * ds;
/*    */     }
/*    */     
/* 51 */     setD(CLAMP.d(d, 0.0D, 1.0D));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void init() {
/* 58 */     double snow = 0.0D;
/* 59 */     double p = TIME.years().bitPartOf();
/* 60 */     double tmp1 = (SETT.WEATHER()).temp.average(p - 0.2D);
/* 61 */     double tmp2 = (SETT.WEATHER()).temp.average(p);
/* 62 */     if (tmp1 < 0.5D && tmp2 < 0.5D) {
/* 63 */       snow = 1.0D;
/* 64 */     } else if (tmp1 < 0.5D) {
/* 65 */       snow = 1.0D - (tmp2 - 0.5D) * 16.0D;
/*    */     } 
/* 67 */     setD(snow);
/*    */   }
/*    */   
/*    */   public boolean rainIsSnow() {
/* 71 */     return (this.snowCount < 0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {
/* 76 */     super.save(file);
/* 77 */     file.d(this.snowCount);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 82 */     super.load(file);
/* 83 */     this.snowCount = file.d();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherSnow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */