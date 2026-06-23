/*     */ package game.time;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TIME
/*     */   extends GAME.GameResource
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int secondsPerHour;
/*     */   private final int hoursPerDay;
/*     */   private final int secondsPerDay;
/*     */   private final double secondsPerDayI;
/*     */   private final int workHours;
/*     */   private final double workValue;
/*  37 */   private final double workSecondsWalkNext = 3.0D;
/*     */   
/*     */   private final double workSeconds;
/*  40 */   private final int SERVICE_PER_DAY = 4;
/*     */   
/*     */   private double currentSecond;
/*     */   
/*     */   private double playedGame;
/*     */   
/*  46 */   private double offsetSecond = 0.0D;
/*     */   
/*     */   private final TIMECYCLE.Hours hours;
/*     */   
/*     */   private final TIMECYCLE.Days days;
/*     */   private final Seasons seasons;
/*     */   private final TIMECYCLE.Years years;
/*     */   private final TIMECYCLE.Ages ages;
/*     */   private final Light light;
/*     */   private static TIME t;
/*     */   
/*     */   public TIME() {
/*  58 */     super("TIME", true);
/*  59 */     t = this;
/*     */     
/*  61 */     Json jData = new Json((PATHS.CONFIG()).init.gets("Time"));
/*  62 */     Json jText = new Json(PATHS.TEXT_MISC().gets("Time"));
/*     */     
/*  64 */     this.secondsPerHour = (Config.sett()).secondsPerHour;
/*  65 */     this.hoursPerDay = (Config.sett()).hoursPerDay;
/*     */     
/*  67 */     this.secondsPerDay = this.secondsPerHour * this.hoursPerDay;
/*  68 */     this.secondsPerDayI = 1.0D / this.secondsPerDay;
/*  69 */     this.workHours = this.hoursPerDay * 8 / 16;
/*  70 */     this.workValue = this.hoursPerDay / this.workHours;
/*  71 */     this.workSeconds = (this.workHours * this.secondsPerHour);
/*     */     
/*  73 */     this.hours = new TIMECYCLE.Hours(secondsPerHour(), hoursPerDay());
/*     */ 
/*     */     
/*  76 */     this.days = new TIMECYCLE.Days((int)this.hours.cycleSeconds(), jData.i("DAYS_PER_SEASON", 2, 8));
/*     */     
/*  78 */     this.seasons = new Seasons(this.days.cycleSeconds(), jData, jText);
/*     */ 
/*     */     
/*  81 */     this.years = new TIMECYCLE.Years((int)this.seasons.cycleSeconds(), jData.i("YEARS_PER_AGE"));
/*     */     
/*  83 */     this.ages = new TIMECYCLE.Ages((int)this.years.cycleSeconds(), jData, jText);
/*     */ 
/*     */     
/*  86 */     this.currentSecond += this.days.bitSeconds() * 0.5D;
/*  87 */     this.light = new Light();
/*  88 */     update(0.0D, Profiler.DUMMY);
/*     */     
/*  90 */     GVALUES.FACTION.push("TIME_YEAR_PART", "time of year", (SPRITE)(UI.icons()).s.clock, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/*  94 */             return TIME.years().bitPartOf();
/*     */           }
/*     */         });
/*  97 */     GVALUES.FACTION.push("TIME_YEARS_SINCE_START", "time of year", (SPRITE)(UI.icons()).s.clock, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/* 101 */             return TIME.years().bitsSinceStart();
/*     */           }
/* 103 */         },  false);
/*     */   }
/*     */   
/*     */   public static void set(double currentSecond) {
/* 107 */     t.currentSecond = currentSecond;
/* 108 */     t.update(0.0D, Profiler.DUMMY);
/*     */   }
/*     */   
/*     */   public static double currentSecond() {
/* 112 */     return t.currentSecond;
/*     */   }
/*     */   
/*     */   public static TIMECYCLE.Hours hours() {
/* 116 */     return t.hours;
/*     */   }
/*     */   
/*     */   public static TIMECYCLE.Days days() {
/* 120 */     return t.days;
/*     */   }
/*     */   
/*     */   public static Seasons.Season season() {
/* 124 */     return t.seasons.current();
/*     */   }
/*     */   
/*     */   public static Seasons seasons() {
/* 128 */     return t.seasons;
/*     */   }
/*     */   
/*     */   public static TIMECYCLE.Years years() {
/* 132 */     return t.years;
/*     */   }
/*     */   
/*     */   public static TIMECYCLE.Ages age() {
/* 136 */     return t.ages;
/*     */   }
/*     */   
/*     */   public static Light light() {
/* 140 */     return t.light;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static double getIncrementedTime(double time) {
/* 146 */     double currentSecond = t.currentSecond;
/* 147 */     currentSecond += time;
/* 148 */     if (currentSecond >= t.ages.cycleSeconds()) {
/* 149 */       currentSecond -= t.ages.cycleSeconds();
/* 150 */     } else if (currentSecond < 0.0D) {
/* 151 */       currentSecond += t.ages.cycleSeconds();
/* 152 */     }  return currentSecond;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getFertility() {
/* 157 */     return 1.0D;
/*     */   }
/*     */   
/*     */   public static int getWorkPerDay(double workSeconds) {
/* 161 */     double walkSpeed = 1.5D;
/* 162 */     double toFrom = 150.0D / walkSpeed;
/* 163 */     double workNet = workSeconds() - toFrom;
/*     */     
/* 165 */     return (int)Math.ceil(workNet / (workSeconds + 3.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 171 */     file.d(this.currentSecond);
/* 172 */     file.d(this.offsetSecond);
/* 173 */     file.d(this.playedGame);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 178 */     this.currentSecond = file.d();
/* 179 */     this.offsetSecond = file.d();
/* 180 */     this.playedGame = file.d();
/* 181 */     update(0.0D, Profiler.DUMMY);
/*     */   }
/*     */   
/*     */   public static double playedGame() {
/* 185 */     return t.playedGame;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 190 */     this.currentSecond += ds;
/* 191 */     this.playedGame += ds;
/* 192 */     double current = this.currentSecond + this.offsetSecond;
/*     */     
/* 194 */     while (this.currentSecond >= this.ages.cycleSeconds())
/* 195 */       this.currentSecond -= this.ages.cycleSeconds(); 
/* 196 */     while (current >= this.ages.cycleSeconds())
/* 197 */       current -= this.ages.cycleSeconds(); 
/* 198 */     this.hours.update(current);
/* 199 */     this.days.update(current);
/* 200 */     this.seasons.update(current);
/* 201 */     this.years.update(current);
/* 202 */     this.ages.update(current);
/*     */     
/* 204 */     this.light.update(ds);
/*     */   }
/*     */   
/*     */   public static int servicePerDay() {
/* 208 */     t.getClass(); return 4;
/*     */   }
/*     */   
/*     */   public static double workSeconds() {
/* 212 */     return t.workSeconds;
/*     */   }
/*     */   
/*     */   public static double workSecondsWalkNext() {
/* 216 */     t.getClass(); return 3.0D;
/*     */   }
/*     */   
/*     */   public static double workValue() {
/* 220 */     return t.workValue;
/*     */   }
/*     */   
/*     */   public static int workHours() {
/* 224 */     return t.workHours;
/*     */   }
/*     */   
/*     */   public static double secondsPerDayI() {
/* 228 */     return t.secondsPerDayI;
/*     */   }
/*     */   
/*     */   public static int secondsPerDay() {
/* 232 */     return t.secondsPerDay;
/*     */   }
/*     */   
/*     */   public static int hoursPerDay() {
/* 236 */     return t.hoursPerDay;
/*     */   }
/*     */   
/*     */   public static int secondsPerHour() {
/* 240 */     return t.secondsPerHour;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\TIME.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */