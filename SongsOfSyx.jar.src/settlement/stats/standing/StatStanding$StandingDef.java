/*     */ package settlement.stats.standing;
/*     */ 
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StandingDef
/*     */ {
/*     */   public static final String key = "STANDING";
/*     */   private static KeyMap<Integer> oks;
/* 230 */   private static StandingDef NONE = new StandingDef(null);
/*     */   
/*     */   public final boolean inverted;
/*     */   public final double mul;
/*     */   private final double expo;
/*     */   public final MATH.QuickPOW exp;
/* 236 */   public double prio = 1.0D;
/*     */   
/*     */   public final boolean child;
/* 239 */   private final StandingData[] data = new StandingData[HCLASSES.ALL().size()];
/*     */   
/*     */   public StandingDef(Json json, StandingDef def) {
/* 242 */     check(json);
/* 243 */     this.inverted = json.bool("INVERTED", def.inverted);
/* 244 */     this.mul = json.dTry("MULTIPLIER", 0.0D, 10000.0D, def.mul);
/* 245 */     this.expo = json.dTry("EXPONENT", 0.01D, 10.0D, def.expo);
/* 246 */     this.prio = (int)json.dTry("PRIO", 0.0D, 100000.0D, def.prio);
/* 247 */     this.child = json.bool("CHILD", def.child);
/* 248 */     boolean dismiss = json.bool("DISMISS", (def.data[0]).dismiss);
/* 249 */     for (HCLASS c : HCLASSES.ALL()) {
/* 250 */       this.data[c.index()] = json.has(c.key) ? new StandingData(json, c) : def.data[c.index()];
/* 251 */       (this.data[c.index()]).dismiss = dismiss;
/*     */     } 
/*     */     
/* 254 */     if (this.expo == 1.0D) {
/* 255 */       this.exp = null;
/*     */     } else {
/* 257 */       this.exp = new MATH.QuickPOW(this.expo, 64);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void check(Json json) {
/* 262 */     if (oks == null) {
/* 263 */       oks = new KeyMap();
/* 264 */       oks.put("INVERTED", Integer.valueOf(1));
/* 265 */       oks.put("MULTIPLIER", Integer.valueOf(1));
/* 266 */       oks.put("EXPONENT", Integer.valueOf(1));
/* 267 */       oks.put("PRIO", Integer.valueOf(1));
/* 268 */       oks.put("DISMISS", Integer.valueOf(1));
/* 269 */       oks.put("CHILD", Integer.valueOf(1));
/* 270 */       for (HCLASS c : HCLASSES.ALL()) {
/* 271 */         oks.put(c.key, Integer.valueOf(1));
/*     */       }
/*     */     } 
/* 274 */     for (String k : json.keys()) {
/* 275 */       if (!oks.containsKey(k)) {
/* 276 */         String a = "";
/* 277 */         for (String s : oks.keysSorted())
/* 278 */           a = a + a + ", "; 
/* 279 */         json.error(k + " is not a valid STANDING field. Valid: " + k, k);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private double getMulled(double v) {
/* 286 */     double dd = CLAMP.d(v * this.mul, 0.0D, 1.0D);
/* 287 */     if (this.exp != null)
/* 288 */       return this.exp.pow(dd); 
/* 289 */     return dd;
/*     */   }
/*     */   
/*     */   public StandingDef(Json json) {
/* 293 */     boolean dismiss = false;
/* 294 */     if (json == null) {
/* 295 */       this.inverted = false;
/* 296 */       this.mul = 0.0D;
/* 297 */       this.expo = 1.0D;
/* 298 */       this.prio = 1.0D;
/* 299 */       this.child = false;
/*     */     } else {
/*     */       
/* 302 */       if (json.has("STANDING")) {
/* 303 */         json = json.json("STANDING");
/*     */       }
/* 305 */       this.mul = json.has("MULTIPLIER") ? json.d("MULTIPLIER", 0.0D, 100000.0D) : 1.0D;
/* 306 */       this.expo = json.dTry("EXPONENT", 0.01D, 10.0D, 1.0D);
/* 307 */       this.prio = (int)json.dTry("PRIO", 0.0D, 100000.0D, 1.0D);
/* 308 */       this.inverted = (json.has("INVERTED") && json.bool("INVERTED"));
/* 309 */       this.child = json.bool("CHILD", false);
/* 310 */       dismiss = (json.has("DISMISS") && json.bool("DISMISS"));
/*     */     } 
/* 312 */     if (json != null) {
/* 313 */       for (HCLASS c : HCLASSES.ALL()) {
/* 314 */         this.data[c.index()] = new StandingData(json, c);
/* 315 */         (this.data[c.index()]).dismiss = dismiss;
/*     */       } 
/*     */     } else {
/* 318 */       for (HCLASS c : HCLASSES.ALL()) {
/* 319 */         this.data[c.index()] = new StandingData(0.0D);
/* 320 */         (this.data[c.index()]).dismiss = dismiss;
/*     */       } 
/*     */     } 
/*     */     
/* 324 */     if (this.expo == 1.0D) {
/* 325 */       this.exp = null;
/*     */     } else {
/* 327 */       this.exp = new MATH.QuickPOW(this.expo, 64);
/*     */     } 
/*     */   }
/*     */   
/*     */   public class StandingData
/*     */   {
/*     */     public final double max;
/*     */     public final double from;
/*     */     
/*     */     StandingData(Json json, HCLASS clas) {
/* 337 */       this((json == null || !json.has(clas.key)) ? 0.0D : json.d(clas.key, 0.0D, 1000000.0D));
/*     */     }
/*     */     public final double to; public boolean dismiss;
/*     */     StandingData(double max) {
/* 341 */       this.max = max;
/* 342 */       if (StatStanding.StandingDef.this.inverted) {
/* 343 */         this.from = this.max;
/* 344 */         this.to = 0.0D;
/*     */       } else {
/* 346 */         this.from = 0.0D;
/* 347 */         this.to = this.max;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public StandingData get(HCLASS c) {
/* 354 */     return this.data[c.index()];
/*     */   }
/*     */   
/*     */   public StandingDef NONE() {
/* 358 */     if (NONE == null)
/* 359 */       NONE = new StandingDef(null); 
/* 360 */     return NONE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\StatStanding$StandingDef.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */