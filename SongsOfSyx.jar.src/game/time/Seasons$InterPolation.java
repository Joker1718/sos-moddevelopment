/*     */ package game.time;
/*     */ 
/*     */ import snake2d.util.color.RGB;
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
/*     */ public class InterPolation
/*     */   implements RGB
/*     */ {
/*     */   private double red;
/*     */   private double green;
/*     */   private double blue;
/*     */   private double dayLength;
/*     */   private double winterValue;
/* 107 */   private int dayCurrent = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void update(int offSeconds) {
/* 114 */     double secSeasons = TIME.seasons().bitSeconds();
/* 115 */     int seasons = (TIME.seasons()).ALL.size();
/* 116 */     double s = TIME.years().bitSeconds() + TIME.currentSecond() + offSeconds;
/* 117 */     double d = TIME.secondsPerDay();
/*     */     
/* 119 */     double dPrev = s - d;
/* 120 */     double dNext = s + d;
/*     */     
/* 122 */     int prevI = (int)(dPrev / secSeasons);
/* 123 */     int nextI = (int)(dNext / secSeasons);
/* 124 */     int currentI = (int)(s / secSeasons);
/*     */     
/* 126 */     if (prevI != nextI) {
/* 127 */       if (prevI != currentI) {
/* 128 */         dPrev = currentI * secSeasons - dPrev;
/* 129 */         dNext = d + d - dPrev;
/* 130 */       } else if (nextI != currentI) {
/* 131 */         dNext -= nextI * secSeasons;
/* 132 */         dPrev = d + d - dNext;
/*     */       } 
/*     */     } else {
/* 135 */       dPrev = d;
/* 136 */       dNext = d;
/*     */     } 
/*     */     
/* 139 */     dPrev /= d * 2.0D;
/* 140 */     dNext /= d * 2.0D;
/*     */     
/* 142 */     prevI %= seasons;
/* 143 */     nextI %= seasons;
/* 144 */     currentI %= seasons;
/* 145 */     Seasons.Season prev = (Seasons.Season)(TIME.seasons()).ALL.get(prevI);
/* 146 */     Seasons.Season next = (Seasons.Season)(TIME.seasons()).ALL.get(nextI);
/*     */     
/* 148 */     this.red = dPrev * prev.red + dNext * next.red;
/* 149 */     this.green = dPrev * prev.green + dNext * next.green;
/* 150 */     this.blue = dPrev * prev.blue + dNext * next.blue;
/* 151 */     this.winterValue = dPrev * prev.winterValue + dNext * next.winterValue;
/*     */     
/* 153 */     if (this.dayCurrent != TIME.days().bitsSinceStart()) {
/* 154 */       this.dayLength = 1.0D - dPrev * prev.dayNightRatio + dNext * next.dayNightRatio;
/* 155 */       this.dayCurrent = TIME.days().bitsSinceStart();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double dayLength() {
/* 161 */     return this.dayLength;
/*     */   }
/*     */   
/*     */   public double winterValue() {
/* 165 */     return this.winterValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public double r() {
/* 170 */     return this.red;
/*     */   }
/*     */ 
/*     */   
/*     */   public double g() {
/* 175 */     return this.green;
/*     */   }
/*     */ 
/*     */   
/*     */   public double b() {
/* 180 */     return this.blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Seasons$InterPolation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */