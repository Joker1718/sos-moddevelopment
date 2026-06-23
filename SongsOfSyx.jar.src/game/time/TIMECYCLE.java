/*     */ package game.time;
/*     */ 
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.Numbers;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ public abstract class TIMECYCLE
/*     */ {
/*     */   private final int bits;
/*     */   private final double secondsPerbit;
/*     */   private final double secondsPerCycle;
/*     */   private double partOfBit;
/*     */   private double partIfBitCircular;
/*     */   private final CharSequence postFix;
/*     */   private final CharSequence names;
/*     */   private int bitsSinceStart;
/*     */   private int bitsOfCycle;
/*     */   private double bitsOfDay;
/*     */   private double bitsOfSeason;
/*     */   private double bitsOfYear;
/*     */   private double secondOfBit;
/*     */   
/*     */   TIMECYCLE(int seconds, int amount, CharSequence postFix, CharSequence names) {
/*  25 */     this.secondsPerbit = seconds;
/*  26 */     this.bits = amount;
/*     */     
/*  28 */     this.secondsPerCycle = this.secondsPerbit * amount;
/*  29 */     this.postFix = postFix;
/*  30 */     this.names = names;
/*     */   }
/*     */   
/*     */   void update(double currentSecond) {
/*  34 */     this.bitsSinceStart = (int)(currentSecond / this.secondsPerbit);
/*  35 */     this.secondOfBit = currentSecond % this.secondsPerbit;
/*  36 */     this.bitsOfCycle = this.bitsSinceStart % this.bits;
/*     */     
/*  38 */     this.partOfBit = currentSecond % this.secondsPerbit / this.secondsPerbit;
/*  39 */     if (this.partOfBit <= 0.5D) {
/*  40 */       this.partIfBitCircular = this.partOfBit * 2.0D;
/*     */     } else {
/*  42 */       this.partIfBitCircular = 1.0D - (this.partOfBit - 0.5D) * 2.0D;
/*     */     } 
/*  44 */     this.bitsOfDay = currentSecond % TIME.days().bitSeconds() / this.secondsPerbit;
/*  45 */     this.bitsOfSeason = currentSecond % TIME.seasons().bitSeconds() / this.secondsPerbit;
/*  46 */     this.bitsOfYear = currentSecond % TIME.years().bitSeconds() / this.secondsPerbit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double bitPartOf() {
/*  54 */     return this.partOfBit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double bitPartOfC() {
/*  62 */     return this.partIfBitCircular;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double bitSeconds() {
/*  70 */     return this.secondsPerbit;
/*     */   }
/*     */   
/*     */   public double secondOfBit() {
/*  74 */     return this.secondOfBit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bitsPerCycle() {
/*  82 */     return this.bits;
/*     */   }
/*     */   
/*     */   public double bitConversion(TIMECYCLE toBits) {
/*  86 */     return this.secondsPerbit / toBits.secondsPerbit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bitsSinceStart() {
/*  94 */     return this.bitsSinceStart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bitCurrent() {
/* 102 */     return this.bitsOfCycle;
/*     */   }
/*     */   
/*     */   public String bitNameCurrent() {
/* 106 */     return bitName(this.bitsOfCycle);
/*     */   }
/*     */   
/*     */   public double bitOfDay() {
/* 110 */     return this.bitsOfDay;
/*     */   }
/*     */   
/*     */   public double bitOfSeason() {
/* 114 */     return this.bitsOfSeason;
/*     */   }
/*     */   
/*     */   public double bitOfYear() {
/* 118 */     return this.bitsOfYear;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract String bitName(int paramInt);
/*     */   
/*     */   public CharSequence cycleName() {
/* 125 */     return this.postFix;
/*     */   }
/*     */   
/*     */   public CharSequence cycleNames() {
/* 129 */     return this.names;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double cycleSeconds() {
/* 139 */     return this.secondsPerCycle;
/*     */   }
/*     */   
/*     */   public static final class Hours
/*     */     extends TIMECYCLE {
/*     */     private final String[] names;
/*     */     
/*     */     Hours(int seconds, int amount) {
/* 147 */       super(seconds, amount, "hour", "hours");
/* 148 */       this.names = new String[amount];
/* 149 */       for (int i = 0; i < amount; i++) {
/* 150 */         this.names[i] = Numbers.getSuffix(i + 1);
/*     */       }
/*     */     }
/*     */     
/*     */     public String bitName(int bit) {
/* 155 */       return this.names[bit];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Days
/*     */     extends TIMECYCLE
/*     */   {
/*     */     private final String[] names;
/* 163 */     public final double dayShiftStart = 0.25D;
/* 164 */     public final double dayShiftEnd = 0.75D;
/*     */     private boolean dayShift;
/*     */     private double partOfShift;
/*     */     
/*     */     Days(int seconds, int amount) {
/* 169 */       super(seconds, amount, DicTime.¤¤Day, DicTime.¤¤Days);
/* 170 */       this.names = new String[amount];
/* 171 */       for (int i = 0; i < amount; i++) {
/* 172 */         this.names[i] = Numbers.getSuffix(i + 1);
/*     */       }
/*     */     }
/*     */     
/*     */     protected void update(double currentSecond) {
/* 177 */       super.update(currentSecond);
/* 178 */       this.dayShift = (bitPartOf() >= 0.25D && bitPartOf() < 0.75D);
/* 179 */       if (this.dayShift) {
/* 180 */         this.partOfShift = (bitPartOf() - 0.25D) * 2.0D;
/* 181 */       } else if (bitPartOf() < 0.25D) {
/* 182 */         this.partOfShift = 0.5D + bitPartOf() * 2.0D;
/*     */       } else {
/* 184 */         this.partOfShift = (bitPartOf() - 0.75D) * 2.0D;
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean dayShift() {
/* 189 */       return this.dayShift;
/*     */     }
/*     */     
/*     */     public boolean isNightShift() {
/* 193 */       return !this.dayShift;
/*     */     }
/*     */     
/*     */     public double shiftPartOf() {
/* 197 */       return this.partOfShift;
/*     */     }
/*     */ 
/*     */     
/*     */     public String bitName(int bit) {
/* 202 */       return this.names[bit];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Years
/*     */     extends TIMECYCLE
/*     */   {
/*     */     private final String[] names;
/*     */     
/*     */     Years(int seconds, int amount) {
/* 212 */       super(seconds, amount, DicTime.¤¤Year, DicTime.¤¤Years);
/* 213 */       this.names = new String[amount];
/* 214 */       for (int i = 0; i < amount; i++) {
/* 215 */         this.names[i] = Numbers.getSuffix(i + 1);
/*     */       }
/*     */     }
/*     */     
/*     */     public String bitName(int bit) {
/* 220 */       return this.names[bit];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Ages
/*     */     extends TIMECYCLE
/*     */   {
/*     */     private final String[] names;
/*     */     
/*     */     public Ages(int seconds, Json jData, Json jText) {
/* 230 */       super(seconds, jData.i("AGES"), DicTime.¤¤Age, DicTime.¤¤Ages);
/* 231 */       this.names = jText.texts("AGES", jData.i("AGES", 1, 1000), 1000);
/*     */     }
/*     */ 
/*     */     
/*     */     public String bitName(int bit) {
/* 236 */       return this.names[bit];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\TIMECYCLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */