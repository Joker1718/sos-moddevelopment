/*    */ package game.event.actions;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.color.RGB;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class _WEATHER
/*    */   extends EventActionConstructor
/*    */ {
/*    */   _WEATHER() {
/* 19 */     super("WEATHER");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 25 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction
/*    */   {
/* 31 */     private double temperature = Double.NaN;
/* 32 */     private double downpour = Double.NaN;
/* 33 */     private double wind = Double.NaN;
/* 34 */     private double lightning = Double.NaN;
/* 35 */     private double clouds = Double.NaN;
/*    */     
/* 37 */     private COLOR sky = null;
/*    */     double acc;
/*    */     
/* 40 */     Imp(String key, Json data, LISTE<EventAction> all) { super(key, all);
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
/* 59 */       this.acc = 0.0D; this.temperature = data.dTry("TEMPERATURE", -1.0D, 1.0D, Double.NaN); this.downpour = data.dTry("DOWNPOUR", 0.0D, 1.0D, Double.NaN); this.wind = data.dTry("WIND", 0.0D, 1.0D, Double.NaN); this.lightning = data.dTry("LIGHTNING", 0.0D, 1.0D, Double.NaN);
/*    */       this.clouds = data.dTry("CLOUDS", 0.0D, 1.0D, Double.NaN);
/*    */       if (data.has("SKY"))
/*    */         this.sky = (COLOR)new ColorImp(data, "SKY"); 
/* 63 */       data.checkUnused(); } public void update(Event e, EContext context, double ds, double second) { double dd = 1.0D;
/* 64 */       if (second < 10.0D) {
/* 65 */         dd = second / 10.0D;
/* 66 */       } else if ((GAME.EVENT().current()).duration.seconds - second < 10.0D) {
/* 67 */         dd = ((GAME.EVENT().current()).duration.seconds - second) / 10.0D;
/* 68 */       }  if (Double.isFinite(this.temperature))
/*    */       {
/* 70 */         (SETT.WEATHER()).temp.setD((this.temperature + 1.0D) * 0.5D);
/*    */       }
/* 72 */       if (Double.isFinite(this.downpour)) {
/* 73 */         (SETT.WEATHER()).rain.setD(this.downpour * dd);
/*    */       }
/* 75 */       if (Double.isFinite(this.wind)) {
/* 76 */         (SETT.WEATHER()).wind.setD(this.wind * dd);
/*    */       }
/* 78 */       if (Double.isFinite(this.lightning)) {
/* 79 */         (SETT.WEATHER()).thunder.setD(this.lightning * dd);
/*    */       }
/* 81 */       if (Double.isFinite(this.clouds)) {
/* 82 */         (SETT.WEATHER()).clouds.setD(this.clouds * dd);
/*    */       }
/* 84 */       if (this.sky != null)
/* 85 */         SETT.WEATHER().lightColor().interpolate((RGB)COLOR.WHITE200, (RGB)this.sky, dd);  }
/*    */ 
/*    */     
/*    */     void setContext(Event e, EContext data) {
/*    */       this.acc = 0.0D;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_WEATHER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */