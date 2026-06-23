/*    */ package settlement.weather;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class WeatherGrowth
/*    */   extends WeatherThing
/*    */ {
/* 13 */   private static CharSequence ¤¤name = "Growth";
/* 14 */   private static CharSequence ¤¤desc = "The growth of plants.";
/* 15 */   private static double speed = 1.0D / (2 * TIME.secondsPerDay());
/*    */   private boolean isAutumn;
/*    */   
/*    */   static {
/* 19 */     D.ts(WeatherGrowth.class);
/*    */   }
/*    */   
/*    */   WeatherGrowth() {
/* 23 */     super(¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void update(double ds) {
/* 33 */     double g = getD();
/* 34 */     this.isAutumn = (TIME.years().bitPartOf() > 0.5D);
/* 35 */     if (!this.isAutumn) {
/* 36 */       if ((SETT.WEATHER()).temp.heat() > 0.0D) {
/* 37 */         g += ds * speed * 2.0D;
/*    */       }
/* 39 */     } else if ((SETT.WEATHER()).temp.heat() < 0.25D) {
/* 40 */       g -= ds * speed;
/*    */     } 
/*    */     
/* 43 */     setD(g);
/*    */     
/* 45 */     super.update(ds);
/*    */   }
/*    */   
/*    */   public boolean isAutumn() {
/* 49 */     return this.isAutumn;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void init() {
/* 54 */     update(0.0D);
/* 55 */     double d = 0.0D;
/* 56 */     double p = TIME.years().bitPartOf();
/* 57 */     double tmp1 = (SETT.WEATHER()).temp.average(p - 0.2D);
/* 58 */     double tmp2 = (SETT.WEATHER()).temp.average(p);
/* 59 */     if (tmp1 > 0.5D && tmp2 > 0.5D) {
/* 60 */       d = 1.0D;
/* 61 */     } else if (tmp1 > 0.5D) {
/* 62 */       d = 0.5D;
/*    */     } else {
/* 64 */       d = 0.0D;
/* 65 */     }  setD(d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {
/* 70 */     super.save(file);
/* 71 */     file.bool(this.isAutumn);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 76 */     super.load(file);
/* 77 */     this.isAutumn = file.bool();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherGrowth.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */