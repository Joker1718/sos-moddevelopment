/*     */ package settlement.stats.standing;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ public final class StatStanding
/*     */ {
/*     */   private final StandingDef def;
/*     */   private final STAT stat;
/*     */   public final double defaultInput;
/*     */   
/*     */   public StatStanding(STAT stat, double defaultInput) {
/*  22 */     this.stat = stat;
/*  23 */     this.def = StandingDef.NONE;
/*  24 */     this.defaultInput = defaultInput;
/*     */   }
/*     */   
/*     */   public StatStanding(STAT stat, double defaultInput, StandingDef def) {
/*  28 */     this.stat = stat;
/*  29 */     this.def = def;
/*  30 */     this.defaultInput = defaultInput;
/*     */   }
/*     */   
/*     */   public StandingDef base() {
/*  34 */     return this.def;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDismiss(HCLASS c, Race r) {
/*  39 */     return getDismiss(c, r, 0);
/*     */   }
/*     */   
/*     */   public double getDismiss(HCLASS c, Race r, int daysback) {
/*  43 */     if (r != null)
/*  44 */       return (definition(r).get(c)).dismiss ? (definition(r).get(c)).max : 0.0D; 
/*  45 */     double m = 0.0D;
/*  46 */     double p = (STATS.POP()).POP.data(c).get(null, daysback);
/*  47 */     if (p == 0.0D) {
/*  48 */       for (int i = 0; i < RACES.all().size(); i++) {
/*  49 */         Race ra = (Race)RACES.all().get(i);
/*  50 */         m += (definition(ra).get(c)).dismiss ? (definition(ra).get(c)).max : 0.0D;
/*     */       } 
/*  52 */       return m / RACES.all().size();
/*     */     } 
/*     */     
/*  55 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  56 */       Race ra = (Race)RACES.all().get(ri);
/*  57 */       m += ((definition(ra).get(c)).dismiss ? (definition(ra).get(c)).max : 0.0D) * (STATS.POP()).POP.data(c).get(ra, daysback);
/*     */     } 
/*  59 */     return m / p;
/*     */   }
/*     */ 
/*     */   
/*     */   public double max(HCLASS c, Race r) {
/*  64 */     return max(c, r, 0);
/*     */   }
/*     */   
/*     */   public double max(HCLASS c, Race r, int daysback) {
/*  68 */     if (r != null)
/*  69 */       return (definition(r).get(c)).max; 
/*  70 */     double m = 0.0D;
/*  71 */     double p = (STATS.POP()).POP.data(c).get(null, daysback);
/*  72 */     if (p == 0.0D) {
/*  73 */       for (int i = 0; i < RACES.all().size(); i++) {
/*  74 */         Race ra = (Race)RACES.all().get(i);
/*  75 */         m += (definition(ra).get(c)).max;
/*     */       } 
/*  77 */       return m / RACES.all().size();
/*     */     } 
/*  79 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  80 */       Race ra = (Race)RACES.all().get(ri);
/*  81 */       m += (definition(ra).get(c)).max * (STATS.POP()).POP.data(c).get(ra, daysback);
/*     */     } 
/*  83 */     return m / p;
/*     */   }
/*     */ 
/*     */   
/*     */   public double normalized(HCLASS c, Race r) {
/*  88 */     if (r != null)
/*  89 */       return r.stats().defNormalized(c, this); 
/*  90 */     double m = 0.0D;
/*  91 */     double p = (STATS.POP()).POP.data(c).get(null);
/*  92 */     if (p == 0.0D)
/*  93 */       return 0.0D; 
/*  94 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  95 */       Race ra = (Race)RACES.all().get(ri);
/*  96 */       m += ra.stats().defNormalized(c, this) * (STATS.POP()).POP.data(c).get(ra);
/*     */     } 
/*  98 */     return m / p;
/*     */   }
/*     */ 
/*     */   
/*     */   public double def(HCLASS c, Race r) {
/* 103 */     if (r != null)
/* 104 */       return get(c, r, this.defaultInput); 
/* 105 */     double m = 0.0D;
/* 106 */     double p = (STATS.POP()).POP.data(c).get(null);
/* 107 */     if (p == 0.0D)
/* 108 */       return 0.0D; 
/* 109 */     for (Race ra : RACES.all()) {
/* 110 */       m += get(c, ra, this.defaultInput) * (STATS.POP()).POP.data(c).get(ra);
/*     */     }
/* 112 */     return m / p;
/*     */   }
/*     */   
/*     */   public double get(HCLASS c, Race r) {
/* 116 */     return get(c, r, this.stat.data(c).getD(r));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHistoric(HCLASS c, Race race, int daysBack) {
/* 122 */     if (race == null) {
/* 123 */       double m = 0.0D;
/* 124 */       double p = (STATS.POP()).POP.data(c).get(null, daysBack);
/* 125 */       if (p == 0.0D) {
/* 126 */         for (int i = 0; i < RACES.all().size(); i++) {
/* 127 */           Race ra = (Race)RACES.all().get(i);
/* 128 */           m += getHistoric(c, ra, daysBack);
/*     */         } 
/* 130 */         return m / RACES.all().size();
/*     */       } 
/*     */       
/* 133 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 134 */         Race ra = (Race)RACES.all().get(ri);
/* 135 */         m += getHistoric(c, ra, daysBack) * (STATS.POP()).POP.data(c).get(ra, daysBack);
/*     */       } 
/* 137 */       return m / p;
/*     */     } 
/* 139 */     StandingDef def = definition(race);
/* 140 */     double d = stat().data(c).getD(race, daysBack);
/* 141 */     d = def.getMulled(d);
/* 142 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 143 */     if (def.inverted)
/* 144 */       d = 1.0D - d; 
/* 145 */     return d * (def.get(c)).max;
/*     */   }
/*     */   
/*     */   public double getPrev(HCLASS c, Race race, int days) {
/* 149 */     if (race == null) {
/* 150 */       double m = 0.0D;
/* 151 */       double p = (STATS.POP()).POP.data(c).getPeriod(null, days, 0);
/* 152 */       if (p == 0.0D) {
/* 153 */         for (int i = 0; i < RACES.all().size(); i++) {
/* 154 */           Race ra = (Race)RACES.all().get(i);
/* 155 */           m += getPrev(c, ra, days);
/*     */         } 
/* 157 */         return m / RACES.all().size();
/*     */       } 
/*     */       
/* 160 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 161 */         Race ra = (Race)RACES.all().get(ri);
/* 162 */         m += getPrev(c, ra, days) * (STATS.POP()).POP.data(c).getPeriod(ra, days, 0);
/*     */       } 
/* 164 */       return m / p;
/*     */     } 
/* 166 */     StandingDef def = definition(race);
/* 167 */     double d = stat().data(c).getPeriodD(race, days, 0);
/* 168 */     d = def.getMulled(d);
/* 169 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 170 */     if (def.inverted)
/* 171 */       d = 1.0D - d; 
/* 172 */     return d * (def.get(c)).max;
/*     */   }
/*     */   
/*     */   public double get(Induvidual i) {
/* 176 */     return get((i.hType()).CLASS, i.race(), this.stat.indu().getD(i));
/*     */   }
/*     */   
/*     */   public double get(HCLASS c, Race race, double input) {
/* 180 */     if (race == null) {
/* 181 */       double m = 0.0D;
/* 182 */       double p = (STATS.POP()).POP.data(c).get(null);
/* 183 */       if (p == 0.0D) {
/* 184 */         for (int i = 0; i < RACES.all().size(); i++) {
/* 185 */           Race ra = (Race)RACES.all().get(i);
/* 186 */           m += get(c, ra, input);
/*     */         } 
/* 188 */         return m / RACES.all().size();
/*     */       } 
/* 190 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 191 */         Race ra = (Race)RACES.all().get(ri);
/* 192 */         m += get(c, ra, input) * (STATS.POP()).POP.data(c).get(ra);
/*     */       } 
/* 194 */       return m / p;
/*     */     } 
/* 196 */     StandingDef def = definition(race);
/* 197 */     double d = input;
/* 198 */     d = def.getMulled(d);
/* 199 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 200 */     if (def.inverted)
/* 201 */       d = 1.0D - d; 
/* 202 */     return d * (def.get(c)).max;
/*     */   }
/*     */   
/*     */   public StandingDef definition(Race race) {
/* 206 */     return race.stats().def(this);
/*     */   }
/*     */   
/*     */   public double definitionD(Race race) {
/* 210 */     double m = 0.0D;
/* 211 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 212 */       m = Math.max(m, (definition((Race)RACES.all().get(ri))).mul);
/*     */     }
/* 214 */     if (m == 0.0D)
/* 215 */       return 0.0D; 
/* 216 */     return (definition(race)).mul / m;
/*     */   }
/*     */ 
/*     */   
/*     */   public STAT stat() {
/* 221 */     return this.stat;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class StandingDef
/*     */   {
/*     */     public static final String key = "STANDING";
/*     */     
/*     */     private static KeyMap<Integer> oks;
/* 230 */     private static StandingDef NONE = new StandingDef(null);
/*     */     
/*     */     public final boolean inverted;
/*     */     public final double mul;
/*     */     private final double expo;
/*     */     public final MATH.QuickPOW exp;
/* 236 */     public double prio = 1.0D;
/*     */     
/*     */     public final boolean child;
/* 239 */     private final StandingData[] data = new StandingData[HCLASSES.ALL().size()];
/*     */     
/*     */     public StandingDef(Json json, StandingDef def) {
/* 242 */       check(json);
/* 243 */       this.inverted = json.bool("INVERTED", def.inverted);
/* 244 */       this.mul = json.dTry("MULTIPLIER", 0.0D, 10000.0D, def.mul);
/* 245 */       this.expo = json.dTry("EXPONENT", 0.01D, 10.0D, def.expo);
/* 246 */       this.prio = (int)json.dTry("PRIO", 0.0D, 100000.0D, def.prio);
/* 247 */       this.child = json.bool("CHILD", def.child);
/* 248 */       boolean dismiss = json.bool("DISMISS", (def.data[0]).dismiss);
/* 249 */       for (HCLASS c : HCLASSES.ALL()) {
/* 250 */         this.data[c.index()] = json.has(c.key) ? new StandingData(json, c) : def.data[c.index()];
/* 251 */         (this.data[c.index()]).dismiss = dismiss;
/*     */       } 
/*     */       
/* 254 */       if (this.expo == 1.0D) {
/* 255 */         this.exp = null;
/*     */       } else {
/* 257 */         this.exp = new MATH.QuickPOW(this.expo, 64);
/*     */       } 
/*     */     }
/*     */     
/*     */     private static void check(Json json) {
/* 262 */       if (oks == null) {
/* 263 */         oks = new KeyMap();
/* 264 */         oks.put("INVERTED", Integer.valueOf(1));
/* 265 */         oks.put("MULTIPLIER", Integer.valueOf(1));
/* 266 */         oks.put("EXPONENT", Integer.valueOf(1));
/* 267 */         oks.put("PRIO", Integer.valueOf(1));
/* 268 */         oks.put("DISMISS", Integer.valueOf(1));
/* 269 */         oks.put("CHILD", Integer.valueOf(1));
/* 270 */         for (HCLASS c : HCLASSES.ALL()) {
/* 271 */           oks.put(c.key, Integer.valueOf(1));
/*     */         }
/*     */       } 
/* 274 */       for (String k : json.keys()) {
/* 275 */         if (!oks.containsKey(k)) {
/* 276 */           String a = "";
/* 277 */           for (String s : oks.keysSorted())
/* 278 */             a = a + a + ", "; 
/* 279 */           json.error(k + " is not a valid STANDING field. Valid: " + k, k);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private double getMulled(double v) {
/* 286 */       double dd = CLAMP.d(v * this.mul, 0.0D, 1.0D);
/* 287 */       if (this.exp != null)
/* 288 */         return this.exp.pow(dd); 
/* 289 */       return dd;
/*     */     }
/*     */     
/*     */     public StandingDef(Json json) {
/* 293 */       boolean dismiss = false;
/* 294 */       if (json == null) {
/* 295 */         this.inverted = false;
/* 296 */         this.mul = 0.0D;
/* 297 */         this.expo = 1.0D;
/* 298 */         this.prio = 1.0D;
/* 299 */         this.child = false;
/*     */       } else {
/*     */         
/* 302 */         if (json.has("STANDING")) {
/* 303 */           json = json.json("STANDING");
/*     */         }
/* 305 */         this.mul = json.has("MULTIPLIER") ? json.d("MULTIPLIER", 0.0D, 100000.0D) : 1.0D;
/* 306 */         this.expo = json.dTry("EXPONENT", 0.01D, 10.0D, 1.0D);
/* 307 */         this.prio = (int)json.dTry("PRIO", 0.0D, 100000.0D, 1.0D);
/* 308 */         this.inverted = (json.has("INVERTED") && json.bool("INVERTED"));
/* 309 */         this.child = json.bool("CHILD", false);
/* 310 */         dismiss = (json.has("DISMISS") && json.bool("DISMISS"));
/*     */       } 
/* 312 */       if (json != null) {
/* 313 */         for (HCLASS c : HCLASSES.ALL()) {
/* 314 */           this.data[c.index()] = new StandingData(json, c);
/* 315 */           (this.data[c.index()]).dismiss = dismiss;
/*     */         } 
/*     */       } else {
/* 318 */         for (HCLASS c : HCLASSES.ALL()) {
/* 319 */           this.data[c.index()] = new StandingData(0.0D);
/* 320 */           (this.data[c.index()]).dismiss = dismiss;
/*     */         } 
/*     */       } 
/*     */       
/* 324 */       if (this.expo == 1.0D) {
/* 325 */         this.exp = null;
/*     */       } else {
/* 327 */         this.exp = new MATH.QuickPOW(this.expo, 64);
/*     */       } 
/*     */     }
/*     */     
/*     */     public class StandingData
/*     */     {
/*     */       public final double max;
/*     */       public final double from;
/*     */       
/*     */       StandingData(Json json, HCLASS clas) {
/* 337 */         this((json == null || !json.has(clas.key)) ? 0.0D : json.d(clas.key, 0.0D, 1000000.0D));
/*     */       }
/*     */       public final double to; public boolean dismiss;
/*     */       StandingData(double max) {
/* 341 */         this.max = max;
/* 342 */         if (StatStanding.StandingDef.this.inverted) {
/* 343 */           this.from = this.max;
/* 344 */           this.to = 0.0D;
/*     */         } else {
/* 346 */           this.from = 0.0D;
/* 347 */           this.to = this.max;
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public StandingData get(HCLASS c) {
/* 354 */       return this.data[c.index()];
/*     */     }
/*     */     
/*     */     public StandingDef NONE() {
/* 358 */       if (NONE == null)
/* 359 */         NONE = new StandingDef(null); 
/* 360 */       return NONE;
/*     */     }
/*     */   }
/*     */   
/*     */   public class StandingData {
/*     */     public final double max;
/*     */     public final double from;
/*     */     public final double to;
/*     */     public boolean dismiss;
/*     */     
/*     */     StandingData(Json json, HCLASS clas) {
/*     */       this((json == null || !json.has(clas.key)) ? 0.0D : json.d(clas.key, 0.0D, 1000000.0D));
/*     */     }
/*     */     
/*     */     StandingData(double max) {
/*     */       this.max = max;
/*     */       if (((StatStanding.StandingDef)StatStanding.this).inverted) {
/*     */         this.from = this.max;
/*     */         this.to = 0.0D;
/*     */       } else {
/*     */         this.from = 0.0D;
/*     */         this.to = this.max;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\StatStanding.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */