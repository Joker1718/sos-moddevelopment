/*    */ package settlement.room.food.farm;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import game.time.TIMECYCLE;
/*    */ import snake2d.util.MATH;
/*    */ 
/*    */ final class Time {
/*    */   public final int days;
/*    */   public final int daysPlanting;
/*    */   public final int dayPlant;
/*    */   public final int dayEvent;
/*    */   public final int dayHarvest;
/*    */   public final int dayOffWork;
/*    */   public final int dayDeath;
/*    */   public final int daysWorking;
/*    */   public final double daysWorkingI;
/*    */   
/*    */   Time(ROOM_FARM b) {
/* 19 */     this.days = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*    */ 
/*    */     
/* 22 */     this.daysPlanting = (int)Math.ceil(this.days * 3.0D / 8.0D);
/* 23 */     this.dayHarvest = (int)Math.round(b.crop.seasonalOffset * this.days);
/* 24 */     this.dayOffWork = MATH.mod(this.dayHarvest + 1, this.days);
/*    */     
/* 26 */     this.dayDeath = MATH.mod(this.dayHarvest + 2, this.days);
/*    */     
/* 28 */     this.dayPlant = MATH.mod(this.dayHarvest - this.daysPlanting, this.days);
/* 29 */     this.dayEvent = this.dayPlant + 1;
/* 30 */     this.daysWorking = this.days - 2;
/* 31 */     this.daysWorkingI = 1.0D / this.daysWorking;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double day() {
/* 38 */     return TIME.years().bitPartOf() * this.days;
/*    */   }
/*    */   
/*    */   public int dayI() {
/* 42 */     return (int)day();
/*    */   }
/*    */   
/*    */   public boolean isHarvest() {
/* 46 */     return !(dayI() != this.dayHarvest && dayI() != MATH.mod(this.dayHarvest + 1, this.days));
/*    */   }
/*    */   
/*    */   public double daysToHarvest() {
/* 50 */     if (isHarvest())
/* 51 */       return 0.0D; 
/* 52 */     return MATH.distance(day(), this.dayHarvest, this.days);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Time.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */