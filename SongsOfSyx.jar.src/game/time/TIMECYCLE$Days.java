/*     */ package game.time;
/*     */ 
/*     */ import snake2d.util.misc.Numbers;
/*     */ import util.text.DicTime;
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
/*     */ public final class Days
/*     */   extends TIMECYCLE
/*     */ {
/*     */   private final String[] names;
/* 163 */   public final double dayShiftStart = 0.25D;
/* 164 */   public final double dayShiftEnd = 0.75D;
/*     */   private boolean dayShift;
/*     */   private double partOfShift;
/*     */   
/*     */   Days(int seconds, int amount) {
/* 169 */     super(seconds, amount, DicTime.¤¤Day, DicTime.¤¤Days);
/* 170 */     this.names = new String[amount];
/* 171 */     for (int i = 0; i < amount; i++) {
/* 172 */       this.names[i] = Numbers.getSuffix(i + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void update(double currentSecond) {
/* 177 */     super.update(currentSecond);
/* 178 */     this.dayShift = (bitPartOf() >= 0.25D && bitPartOf() < 0.75D);
/* 179 */     if (this.dayShift) {
/* 180 */       this.partOfShift = (bitPartOf() - 0.25D) * 2.0D;
/* 181 */     } else if (bitPartOf() < 0.25D) {
/* 182 */       this.partOfShift = 0.5D + bitPartOf() * 2.0D;
/*     */     } else {
/* 184 */       this.partOfShift = (bitPartOf() - 0.75D) * 2.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean dayShift() {
/* 189 */     return this.dayShift;
/*     */   }
/*     */   
/*     */   public boolean isNightShift() {
/* 193 */     return !this.dayShift;
/*     */   }
/*     */   
/*     */   public double shiftPartOf() {
/* 197 */     return this.partOfShift;
/*     */   }
/*     */ 
/*     */   
/*     */   public String bitName(int bit) {
/* 202 */     return this.names[bit];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\TIMECYCLE$Days.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */