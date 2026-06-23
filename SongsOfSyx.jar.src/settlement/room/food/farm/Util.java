/*    */ package settlement.room.food.farm;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import game.time.TIMECYCLE;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ 
/*    */ 
/*    */ 
/*    */ class Util
/*    */ {
/*    */   public static double prospect(FarmInstance ins) {
/* 13 */     double base = base(ins) * ((IndustryResource)ins.industry().outs().get(0)).rate;
/*    */     
/* 15 */     double skill = ins.tData.skill();
/* 16 */     double work = ins.tData.work();
/* 17 */     return base * skill * work * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static double base(FarmInstance ins) {
/* 23 */     double area = ins.area() / ROOM_FARM.WORKERPERTILE;
/* 24 */     return area;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static int prevHarvest(FarmInstance ins) {
/* 30 */     ROOM_FARM b = ins.blueprintI();
/* 31 */     Time t = b.time;
/* 32 */     if (t.dayI() < t.dayDeath) {
/* 33 */       return ((IndustryResource)((Industry)b.industries().get(0)).outs().get(0)).yearPrev.get(ins);
/*    */     }
/* 35 */     return ((IndustryResource)((Industry)b.industries().get(0)).outs().get(0)).year.get(ins);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Util.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */