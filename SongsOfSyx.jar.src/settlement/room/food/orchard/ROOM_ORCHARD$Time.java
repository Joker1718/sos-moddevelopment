/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Time
/*     */ {
/*     */   public final int DAYS_TILL_GROWTH;
/*     */   public final int ripeDay;
/*     */   public final int deadDay;
/* 180 */   public final int days = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */   
/*     */   Time(RoomInitData data) {
/* 183 */     this.DAYS_TILL_GROWTH = data.data().i("DAYS_TILL_GROWTH", 8, 1024);
/* 184 */     this.ripeDay = (int)(this.days * data.data().d("RIPE_AT_PART_OF_YEAR", 0.0D, 1.0D));
/* 185 */     this.deadDay = MATH.mod(this.ripeDay + 3, this.days);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRipe() {
/* 191 */     return isRipe(dayI());
/*     */   }
/*     */   
/*     */   public boolean isRipe(double day) {
/* 195 */     return MATH.isWithin(day, this.ripeDay, this.deadDay);
/*     */   }
/*     */   
/*     */   public boolean isDeadDay() {
/* 199 */     return (dayI() == this.deadDay);
/*     */   }
/*     */   
/*     */   public double fruit() {
/* 203 */     return fruit(day());
/*     */   }
/*     */ 
/*     */   
/*     */   private double fruit(double day) {
/* 208 */     double rd = (this.ripeDay + this.days - 2);
/* 209 */     double dd = (this.deadDay + this.days - 1);
/* 210 */     if (this.deadDay < this.ripeDay) {
/* 211 */       dd += TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */     }
/*     */     
/* 214 */     double di = day + this.days;
/*     */     
/* 216 */     if (di > rd) {
/* 217 */       if (di < dd)
/* 218 */         return CLAMP.d(0.5D * (di - rd), 0.0D, 1.0D); 
/* 219 */       if (di > dd)
/* 220 */         return CLAMP.d(1.0D - di - dd, 0.0D, 1.0D); 
/* 221 */       return 1.0D;
/*     */     } 
/* 223 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public double day() {
/* 227 */     return TIME.years().bitPartOf() * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */   }
/*     */   
/*     */   public int dayI() {
/* 231 */     return (int)day();
/*     */   }
/*     */   
/*     */   public int daysTillHarvest() {
/* 235 */     return MATH.distance(dayI(), this.ripeDay, this.days);
/*     */   }
/*     */   
/*     */   public int daysTillHarvest(int nextTreeDays) {
/* 239 */     int day = TIME.days().bitCurrent();
/* 240 */     day += nextTreeDays;
/* 241 */     int dy = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 242 */     int dday = day % dy;
/* 243 */     return day + MATH.distance(dday, this.ripeDay, this.days);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\ROOM_ORCHARD$Time.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */