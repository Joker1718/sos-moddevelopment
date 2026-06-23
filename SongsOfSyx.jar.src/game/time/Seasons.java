/*     */ package game.time;
/*     */ 
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ public final class Seasons
/*     */   extends TIMECYCLE {
/*     */   public final Season SPRING;
/*     */   public final Season SUMMER;
/*     */   public final Season AUTUMN;
/*     */   public final Season WINTER;
/*     */   public final LIST<Season> ALL;
/*  16 */   public final InterPolation currentDay = new InterPolation();
/*  17 */   public final InterPolation previousDay = new InterPolation();
/*  18 */   public final InterPolation nextDay = new InterPolation();
/*     */   
/*     */   public Seasons(double seconds, Json jData, Json jText) {
/*  21 */     super((int)seconds, 4, DicTime.¤¤Season, DicTime.¤¤Seasons);
/*  22 */     this.SPRING = new Season(0, 0.25D, "SPRING", jData, jText);
/*  23 */     this.SUMMER = new Season(1, 0.0D, "SUMMER", jData, jText);
/*  24 */     this.AUTUMN = new Season(2, 0.25D, "AUTUMN", jData, jText);
/*  25 */     this.WINTER = new Season(3, 1.0D, "WINTER", jData, jText);
/*  26 */     this.ALL = (LIST<Season>)new ArrayList((Object[])new Season[] { this.SPRING, this.SUMMER, this.AUTUMN, this.WINTER });
/*     */   }
/*     */ 
/*     */   
/*     */   public String bitName(int bit) {
/*  31 */     return ((Season)this.ALL.get(bit)).name;
/*     */   }
/*     */   
/*     */   public double winterValue() {
/*  35 */     double d = 1.0D - bitPartOf();
/*  36 */     double dd = 1.0D - d;
/*  37 */     d = (current()).winterValue * d + (next()).winterValue * dd;
/*  38 */     return d;
/*     */   }
/*     */   
/*     */   public Season current() {
/*  42 */     return (Season)this.ALL.get(bitCurrent());
/*     */   }
/*     */   
/*     */   public Season next() {
/*  46 */     return (Season)this.ALL.get((bitCurrent() + 1) % this.ALL.size());
/*     */   }
/*     */   
/*     */   public Season next(int i) {
/*  50 */     i += bitCurrent();
/*  51 */     i &= 0x3;
/*  52 */     return (Season)this.ALL.get(i);
/*     */   }
/*     */   
/*     */   public final class Season
/*     */   {
/*     */     public final String name;
/*     */     private final int index;
/*     */     final double dayNightRatio;
/*     */     public final double red;
/*     */     public final double green;
/*     */     public final double blue;
/*     */     public final double winterValue;
/*     */     
/*     */     Season(int index, double winterValue, String key, Json data, Json text) {
/*  66 */       this.name = text.text(key);
/*  67 */       data = data.json(key);
/*  68 */       this.dayNightRatio = data.d("NIGHTRATIO", 0.1D, 0.9D);
/*  69 */       this.red = data.d("RED", 0.0D, 10.0D);
/*  70 */       this.green = data.d("GREEN", 0.0D, 10.0D);
/*  71 */       this.blue = data.d("BLUE", 0.0D, 10.0D);
/*  72 */       this.index = index;
/*  73 */       this.winterValue = winterValue;
/*     */     }
/*     */     
/*     */     public int index() {
/*  77 */       return this.index;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Season getWithOffset(double seconds) {
/*  83 */     int s = (int)(secondOfBit() + seconds);
/*  84 */     if (s < 0) {
/*  85 */       s = (int)(s + cycleSeconds() * Math.ceil(-s / cycleSeconds()));
/*     */     }
/*  87 */     s = (int)(s / bitSeconds());
/*  88 */     s %= this.ALL.size();
/*  89 */     return (Season)this.ALL.get(s);
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double currentSecond) {
/*  94 */     super.update(currentSecond);
/*  95 */     this.currentDay.update(0);
/*  96 */     this.previousDay.update(-TIME.secondsPerDay());
/*  97 */     this.nextDay.update(TIME.secondsPerDay());
/*     */   }
/*     */   
/*     */   public class InterPolation
/*     */     implements RGB {
/*     */     private double red;
/*     */     private double green;
/*     */     private double blue;
/*     */     private double dayLength;
/*     */     private double winterValue;
/* 107 */     private int dayCurrent = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void update(int offSeconds) {
/* 114 */       double secSeasons = TIME.seasons().bitSeconds();
/* 115 */       int seasons = (TIME.seasons()).ALL.size();
/* 116 */       double s = TIME.years().bitSeconds() + TIME.currentSecond() + offSeconds;
/* 117 */       double d = TIME.secondsPerDay();
/*     */       
/* 119 */       double dPrev = s - d;
/* 120 */       double dNext = s + d;
/*     */       
/* 122 */       int prevI = (int)(dPrev / secSeasons);
/* 123 */       int nextI = (int)(dNext / secSeasons);
/* 124 */       int currentI = (int)(s / secSeasons);
/*     */       
/* 126 */       if (prevI != nextI) {
/* 127 */         if (prevI != currentI) {
/* 128 */           dPrev = currentI * secSeasons - dPrev;
/* 129 */           dNext = d + d - dPrev;
/* 130 */         } else if (nextI != currentI) {
/* 131 */           dNext -= nextI * secSeasons;
/* 132 */           dPrev = d + d - dNext;
/*     */         } 
/*     */       } else {
/* 135 */         dPrev = d;
/* 136 */         dNext = d;
/*     */       } 
/*     */       
/* 139 */       dPrev /= d * 2.0D;
/* 140 */       dNext /= d * 2.0D;
/*     */       
/* 142 */       prevI %= seasons;
/* 143 */       nextI %= seasons;
/* 144 */       currentI %= seasons;
/* 145 */       Seasons.Season prev = (Seasons.Season)(TIME.seasons()).ALL.get(prevI);
/* 146 */       Seasons.Season next = (Seasons.Season)(TIME.seasons()).ALL.get(nextI);
/*     */       
/* 148 */       this.red = dPrev * prev.red + dNext * next.red;
/* 149 */       this.green = dPrev * prev.green + dNext * next.green;
/* 150 */       this.blue = dPrev * prev.blue + dNext * next.blue;
/* 151 */       this.winterValue = dPrev * prev.winterValue + dNext * next.winterValue;
/*     */       
/* 153 */       if (this.dayCurrent != TIME.days().bitsSinceStart()) {
/* 154 */         this.dayLength = 1.0D - dPrev * prev.dayNightRatio + dNext * next.dayNightRatio;
/* 155 */         this.dayCurrent = TIME.days().bitsSinceStart();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public double dayLength() {
/* 161 */       return this.dayLength;
/*     */     }
/*     */     
/*     */     public double winterValue() {
/* 165 */       return this.winterValue;
/*     */     }
/*     */ 
/*     */     
/*     */     public double r() {
/* 170 */       return this.red;
/*     */     }
/*     */ 
/*     */     
/*     */     public double g() {
/* 175 */       return this.green;
/*     */     }
/*     */ 
/*     */     
/*     */     public double b() {
/* 180 */       return this.blue;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Seasons.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */