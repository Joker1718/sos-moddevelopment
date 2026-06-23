/*     */ package util.text;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ public class DicTime
/*     */ {
/*   9 */   public static CharSequence ¤¤Day = "¤Day";
/*  10 */   public static CharSequence ¤¤Days = "¤Days";
/*  11 */   public static CharSequence ¤¤Season = "¤Season";
/*  12 */   public static CharSequence ¤¤Seasons = "¤Seasons";
/*  13 */   public static CharSequence ¤¤Year = "¤Year";
/*  14 */   public static CharSequence ¤¤Years = "¤Years";
/*  15 */   public static CharSequence ¤¤Age = "¤Age";
/*  16 */   public static CharSequence ¤¤Ages = "¤Ages";
/*  17 */   public static CharSequence ¤¤Hour = "¤Hours";
/*  18 */   public static CharSequence ¤¤Hours = "¤Hours";
/*  19 */   public static CharSequence ¤¤Minute = "¤Minute";
/*  20 */   public static CharSequence ¤¤Minutes = "¤Minutes";
/*  21 */   public static CharSequence ¤¤Second = "¤Second";
/*  22 */   public static CharSequence ¤¤Seconds = "¤Seconds";
/*  23 */   public static CharSequence ¤¤Today = "¤Today";
/*  24 */   private static CharSequence ¤¤now = "¤now";
/*     */   
/*  26 */   private static CharSequence ¤¤1OfSomething = "¤1 {0}";
/*  27 */   private static CharSequence ¤¤MoreOfSomething = "¤{0} {1}";
/*     */   
/*  29 */   private static CharSequence ¤¤dateFormat = "¤Day {0} of {1}, Year {2} of the {3}";
/*  30 */   private static CharSequence ¤¤dateFormatShort = "¤{0}/{1} - {2} {3}";
/*     */   
/*  32 */   private static CharSequence ¤¤2SomethingAgo = "{0}, {1} ago";
/*  33 */   private static CharSequence ¤¤1SomethingAgo = "{0} ago";
/*     */   
/*  35 */   private static CharSequence ¤¤yearsDays = "{0} years, {1} days";
/*     */   
/*  37 */   private static final Str f = new Str(32);
/*  38 */   private static final Str f2 = new Str(32);
/*     */   
/*     */   static {
/*  41 */     D.ts(DicTime.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Str setDate(Str text, int second) {
/*  46 */     int age = second % (int)TIME.age().cycleSeconds() / (int)TIME.age().bitSeconds();
/*  47 */     int year = second % (int)TIME.years().cycleSeconds() / (int)TIME.years().bitSeconds();
/*  48 */     int season = second % (int)TIME.seasons().cycleSeconds() / (int)TIME.seasons().bitSeconds();
/*  49 */     int day = second % (int)TIME.days().cycleSeconds() / (int)TIME.days().bitSeconds();
/*  50 */     text.clear().add(¤¤dateFormat);
/*  51 */     text.insert(0, day + 1);
/*  52 */     text.insert(1, TIME.seasons().bitName(season));
/*  53 */     text.insert(2, year + 1);
/*  54 */     text.insert(3, TIME.age().bitName(age));
/*  55 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Str setDateShort(Str text, int second) {
/*  60 */     int age = second % (int)TIME.age().cycleSeconds() / (int)TIME.age().bitSeconds();
/*  61 */     int year = second % (int)TIME.years().cycleSeconds() / (int)TIME.years().bitSeconds();
/*  62 */     int season = second % (int)TIME.seasons().cycleSeconds() / (int)TIME.seasons().bitSeconds();
/*  63 */     int day = second % (int)TIME.days().cycleSeconds() / (int)TIME.days().bitSeconds();
/*  64 */     text.clear().add(¤¤dateFormatShort);
/*  65 */     text.insert(0, day + 1);
/*  66 */     text.insert(1, TIME.seasons().bitName(season));
/*  67 */     text.insert(2, year + 1);
/*  68 */     CharSequence aa = TIME.age().bitName(age);
/*  69 */     f.clear();
/*  70 */     f.add(Character.toUpperCase(aa.charAt(0)));
/*  71 */     f.add('.');
/*  72 */     for (int i = 1; i < aa.length(); i++) {
/*  73 */       if (aa.charAt(i - 1) == ' ') {
/*  74 */         f.add(Character.toUpperCase(aa.charAt(i))).add('.');
/*     */       }
/*     */     } 
/*  77 */     text.insert(3, (CharSequence)f);
/*  78 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setTime(Str text, double second) {
/*  86 */     double s = second % TIME.secondsPerDay();
/*  87 */     int h = (int)(s / TIME.secondsPerHour());
/*  88 */     s %= TIME.secondsPerHour();
/*     */     
/*  90 */     s = (int)(60.0D * s / TIME.secondsPerHour());
/*  91 */     if (h < 10)
/*  92 */       text.add('0'); 
/*  93 */     text.add(h);
/*  94 */     text.add(':');
/*  95 */     if (s < 10.0D)
/*  96 */       text.add('0'); 
/*  97 */     text.add((int)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Str setAgo(Str text, double seconds) {
/* 104 */     return setYearDay(text, seconds, ¤¤2SomethingAgo);
/*     */   }
/*     */   
/*     */   public static Str setSpanDays(Str text, double from, double to) {
/* 108 */     text.clear();
/* 109 */     int day = (int)(from / (int)TIME.days().bitSeconds());
/* 110 */     text.add(day).s().add('-').s();
/* 111 */     day = (int)(to / (int)TIME.days().bitSeconds());
/* 112 */     text.add(day).s();
/* 113 */     text.add(¤¤1SomethingAgo);
/* 114 */     text.insert(0, ¤¤Days);
/* 115 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Str setYearDay(Str text, double seconds, CharSequence F) {
/* 120 */     int secondAgo = (int)seconds;
/* 121 */     int year = secondAgo / (int)TIME.years().bitSeconds();
/* 122 */     secondAgo = (int)(secondAgo - year * TIME.years().bitSeconds());
/* 123 */     int day = secondAgo / (int)TIME.days().bitSeconds();
/*     */     
/* 125 */     if (year == 0 && day == 0) {
/* 126 */       text.clear().add(¤¤now);
/* 127 */       return text;
/*     */     } 
/*     */     
/* 130 */     text.clear().add(F);
/* 131 */     text.insert(0, (CharSequence)setDays(f.clear(), day));
/* 132 */     text.insert(1, (CharSequence)setYears(f.clear(), year));
/* 133 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setYearDay(Str text, double seconds) {
/* 137 */     int secondAgo = (int)seconds;
/* 138 */     int year = secondAgo / (int)TIME.years().bitSeconds();
/* 139 */     secondAgo = (int)(secondAgo - year * TIME.years().bitSeconds());
/* 140 */     int day = secondAgo / (int)TIME.days().bitSeconds();
/* 141 */     text.clear().add(¤¤yearsDays);
/* 142 */     text.insert(0, year);
/* 143 */     text.insert(1, day);
/* 144 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setYears(Str text, double years) {
/* 148 */     format(text, years, ¤¤Year, ¤¤Years);
/* 149 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setYearsAgo(Str text, double years) {
/* 153 */     f.clear();
/* 154 */     setYears(f, years);
/* 155 */     text.clear().add(¤¤1SomethingAgo);
/* 156 */     text.insert(0, (CharSequence)f);
/* 157 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setDaysAgo(Str text, double days) {
/* 161 */     f.clear();
/* 162 */     setDays(f, days);
/* 163 */     text.clear().add(¤¤1SomethingAgo);
/* 164 */     text.insert(0, (CharSequence)f);
/* 165 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setDays(Str text, double days) {
/* 169 */     format(text, days, ¤¤Day, ¤¤Days);
/* 170 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setHours(Str text, double hours) {
/* 174 */     format(text, hours, ¤¤Hour, ¤¤Hours);
/* 175 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setMinutes(Str text, double minutes) {
/* 179 */     format(text, minutes, ¤¤Minute, ¤¤Minutes);
/* 180 */     return text;
/*     */   }
/*     */   
/*     */   public static Str setSeconds(Str text, double minutes) {
/* 184 */     format(text, minutes, ¤¤Second, ¤¤Seconds);
/* 185 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void format(Str text, double days, CharSequence singular, CharSequence plural) {
/* 191 */     f2.clear();
/* 192 */     if (days == 1.0D) {
/* 193 */       text.add(¤¤1OfSomething).insert(0, singular);
/* 194 */     } else if (days == (int)days) {
/* 195 */       text.add(¤¤MoreOfSomething).insert(0, (int)days).insert(1, plural);
/*     */     } else {
/* 197 */       text.add(¤¤MoreOfSomething).insert(0, days, 1).insert(1, plural);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\DicTime.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */