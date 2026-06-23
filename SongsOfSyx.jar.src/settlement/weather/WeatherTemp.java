/*     */ package settlement.weather;
/*     */ 
/*     */ import game.time.Seasons;
/*     */ import game.time.TIME;
/*     */ import init.type.CLIMATE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class WeatherTemp
/*     */   extends WeatherThing
/*     */ {
/*  18 */   private static final double speed = 1.0D / TIME.secondsPerDay();
/*     */   private double target;
/*  20 */   private int dayLast = -1;
/*     */   
/*  22 */   private static CharSequence ¤¤format = "¤~";
/*  23 */   private static CharSequence ¤¤name = "¤Temperature";
/*  24 */   private static CharSequence ¤¤desc = "¤Temperature is determined by climate, season and chance. Extreme temperature on either end causes your subjects to be exposed and can lead to death. Hearths warm subjects. Well usage, or skinny dipping in bodies of water cools subjects. Clothes help greatly with both warmth and cold.";
/*  25 */   public static double div = 0.06666666666666667D; private static final double min = 0.58D;
/*     */   
/*     */   static {
/*  28 */     D.ts(WeatherTemp.class);
/*     */   }
/*     */   private static final double max = 0.7D;
/*     */   
/*     */   WeatherTemp() {
/*  33 */     super(¤¤name, ¤¤desc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  40 */     if (this.dayLast != TIME.days().bitsSinceStart()) {
/*  41 */       this.dayLast = TIME.days().bitsSinceStart();
/*  42 */       this.target = average(TIME.years().bitPartOf()) + RND.rFloat() * div * RND.rSign();
/*     */     } 
/*     */     
/*  45 */     double t = this.target * (TIME.light().nightIs() ? (1.0D - div * TIME.light().partOfCircular()) : 1.0D);
/*  46 */     double temperature = adjustTowards(getD(), ds * speed, t);
/*  47 */     temperature = CLAMP.d(temperature, 0.0D, 1.0D);
/*  48 */     setD(temperature);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double average(double partOfYear) {
/*  56 */     return average(SETT.ENV().climate(), partOfYear);
/*     */   }
/*     */   
/*     */   public void setTarget(double target) {
/*  60 */     this.target = target;
/*  61 */     this.dayLast = TIME.days().bitsSinceStart();
/*     */   }
/*     */   
/*     */   private double average(CLIMATE c, double partOfYear) {
/*  65 */     if (partOfYear < 0.0D) {
/*  66 */       partOfYear += (1 - (int)partOfYear);
/*     */     }
/*  68 */     double p = partOfYear * (TIME.seasons()).ALL.size();
/*  69 */     int si = (int)p;
/*  70 */     p -= si;
/*     */     
/*  72 */     Seasons.Season s = (Seasons.Season)(TIME.seasons()).ALL.getC(si);
/*  73 */     double startWV = 0.0D;
/*  74 */     double endWV = 0.0D;
/*  75 */     if (p < 0.5D) {
/*  76 */       p += 0.5D;
/*  77 */       startWV = ((Seasons.Season)(TIME.seasons()).ALL.getC(si - 1)).winterValue;
/*  78 */       endWV = s.winterValue;
/*     */     } else {
/*     */       
/*  81 */       startWV = s.winterValue;
/*  82 */       endWV = ((Seasons.Season)(TIME.seasons()).ALL.getC(si + 1)).winterValue;
/*  83 */       p -= 0.5D;
/*     */     } 
/*     */ 
/*     */     
/*  87 */     double wv = startWV + p * (endWV - startWV);
/*  88 */     double t = c.tempCold * wv + c.tempWarm * (1.0D - wv);
/*  89 */     return t;
/*     */   }
/*     */   
/*     */   public double heat() {
/*  93 */     if (getD() > 0.5D)
/*  94 */       return 2.0D * (getD() - 0.5D); 
/*  95 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public double cold() {
/*  99 */     if (getD() < 0.5D) {
/* 100 */       return (0.5D - getD()) * 2.0D;
/*     */     }
/* 102 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public double target() {
/* 106 */     if (TIME.light().dayIs()) {
/* 107 */       return CLAMP.d(this.target + div * TIME.light().partOfCircular(), 0.0D, 1.0D);
/*     */     }
/* 109 */     return CLAMP.d(this.target - div * TIME.light().partOfCircular(), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public void format(Str srt) {
/* 113 */     if (getD() >= 0.5D) {
/* 114 */       srt.add('+');
/* 115 */       srt.add((int)(120.0D * (getD() - 0.5D)));
/*     */     } else {
/* 117 */       srt.add('-');
/* 118 */       srt.add((int)(100.0D * (0.5D - getD())));
/*     */     } 
/* 120 */     srt.add(¤¤format);
/*     */   }
/*     */   
/*     */   public int iTmp() {
/* 124 */     if (getD() >= 0.5D) {
/* 125 */       return (int)(120.0D * (getD() - 0.5D));
/*     */     }
/* 127 */     return (int)(100.0D * (getD() - 0.5D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 133 */     super.save(file);
/* 134 */     file.d(this.target);
/* 135 */     file.i(this.dayLast);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 140 */     super.load(file);
/* 141 */     this.target = file.d();
/* 142 */     this.dayLast = file.i();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init() {
/* 147 */     this.dayLast = -1;
/* 148 */     update(0.0D);
/*     */ 
/*     */     
/* 151 */     setD(target());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getEntityTemp() {
/* 160 */     double d = getD();
/* 161 */     if (d < 0.58D)
/* 162 */       return (d - 0.58D) / 0.58D; 
/* 163 */     if (d > 0.7D) {
/* 164 */       return (d - 0.7D) / 0.30000000000000004D;
/*     */     }
/* 166 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\WeatherTemp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */