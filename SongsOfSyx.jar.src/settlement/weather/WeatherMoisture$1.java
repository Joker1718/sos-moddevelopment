/*    */ package settlement.weather;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.industry.module.RoomBoost;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.info.INFO;
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
/*    */ class null
/*    */   implements RoomBoost
/*    */ {
/*    */   public INFO info() {
/* 73 */     return WeatherMoisture.binfo;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(RoomInstance r) {
/* 78 */     return CLAMP.d((SETT.WEATHER()).moisture.growthValue(), 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherMoisture$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */