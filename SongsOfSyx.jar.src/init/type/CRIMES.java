/*     */ package init.type;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.Booster;
/*     */ import init.INIT;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CRIMES
/*     */ {
/*     */   private final CRIME WAR;
/*     */   private final CRIME THEFT;
/*     */   private final CRIME MURDER;
/*     */   private final CRIME VANDALISM;
/*     */   private final CRIME FLASHING;
/*     */   private final CRIME DISRESPECT;
/*     */   private final CRIME SPEECH;
/*     */   private final CRIME PLEASURE;
/*     */   private final CRIME S_THEFT;
/*     */   private final CRIME S_MURDER;
/*     */   private final CRIME S_DISRESPECT;
/*     */   private final CRIME S_PLEASURE;
/*     */   private final LIST<CRIME> ALL;
/*     */   private final LIST<CRIME> CITIZENS;
/*     */   private final LIST<CRIME> SLAVES;
/*     */   private static CRIMES self;
/*     */   
/*     */   CRIMES(INIT init) {
/*  45 */     self = this;
/*  46 */     LinkedList<CRIME> all = new LinkedList();
/*     */     
/*  48 */     Json json = (new Json((PATHS.CONFIG()).init.gets("LAW"))).json("CRIMES");
/*  49 */     Json desc = (new Json((PATHS.CONFIG()).text.gets("LAW"))).json("CRIMES");
/*     */     
/*  51 */     this.WAR = new CRIME(json, desc, (LISTE<CRIME>)all, "WAR", false, HCLASSES.OTHER());
/*     */     
/*  53 */     this.S_THEFT = new CRIME(json, desc, (LISTE<CRIME>)all, "S_THEFT", HCLASSES.SLAVE());
/*  54 */     this.S_MURDER = new CRIME(json, desc, (LISTE<CRIME>)all, "S_MURDER", HCLASSES.SLAVE());
/*  55 */     this.S_DISRESPECT = new CRIME(json, desc, (LISTE<CRIME>)all, "S_DISRESPECT", HCLASSES.SLAVE());
/*  56 */     this.S_PLEASURE = new CRIME(json, desc, (LISTE<CRIME>)all, "S_PLEASURE", false, HCLASSES.SLAVE());
/*     */     
/*  58 */     this.FLASHING = new CRIME(json, desc, (LISTE<CRIME>)all, "FLASHING", HCLASSES.CITIZEN());
/*  59 */     this.THEFT = new CRIME(json, desc, (LISTE<CRIME>)all, "THEFT", HCLASSES.CITIZEN());
/*  60 */     this.VANDALISM = new CRIME(json, desc, (LISTE<CRIME>)all, "VANDALISM", HCLASSES.CITIZEN());
/*  61 */     this.MURDER = new CRIME(json, desc, (LISTE<CRIME>)all, "MURDER", HCLASSES.CITIZEN());
/*  62 */     this.DISRESPECT = new CRIME(json, desc, (LISTE<CRIME>)all, "DISRESPECT", HCLASSES.CITIZEN());
/*  63 */     this.PLEASURE = new CRIME(json, desc, (LISTE<CRIME>)all, "PLEASURE", false, HCLASSES.CITIZEN());
/*  64 */     this.SPEECH = new CRIME(json, desc, (LISTE<CRIME>)all, "SPEECH", HCLASSES.CITIZEN());
/*     */ 
/*     */     
/*  67 */     this.PLEASURE.isCriminal = false;
/*  68 */     this.S_PLEASURE.isCriminal = false;
/*  69 */     this.ALL = (LIST<CRIME>)new ArrayList((Iterable)all);
/*     */     
/*  71 */     ArrayListGrower<CRIME> c = new ArrayListGrower();
/*  72 */     ArrayListGrower<CRIME> s = new ArrayListGrower();
/*     */ 
/*     */     
/*  75 */     for (CRIME cr : all) {
/*  76 */       if (cr.cl == HCLASSES.CITIZEN())
/*  77 */         c.add(cr); 
/*  78 */       if (cr.cl == HCLASSES.SLAVE()) {
/*  79 */         s.add(cr);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  85 */     this.CITIZENS = (LIST<CRIME>)c;
/*  86 */     this.SLAVES = (LIST<CRIME>)s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<CRIME> all(HCLASS cl) {
/*  92 */     if (cl == HCLASSES.CITIZEN())
/*  93 */       return self.CITIZENS; 
/*  94 */     return self.SLAVES;
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<CRIME> CITIZENS() {
/*  99 */     return self.CITIZENS;
/*     */   }
/*     */   
/*     */   public static LIST<CRIME> SLAVES() {
/* 103 */     return self.SLAVES;
/*     */   }
/*     */   
/*     */   public static CRIME PERSECUTED() {
/* 107 */     return self.PLEASURE;
/*     */   }
/*     */   
/*     */   public static CRIME DISRESPECT() {
/* 111 */     return self.DISRESPECT;
/*     */   }
/*     */   
/*     */   public static CRIME FLASHING() {
/* 115 */     return self.FLASHING;
/*     */   }
/*     */   
/*     */   public static CRIME VANDALISM() {
/* 119 */     return self.VANDALISM;
/*     */   }
/*     */   
/*     */   public static CRIME MURDER() {
/* 123 */     return self.MURDER;
/*     */   }
/*     */   
/*     */   public static CRIME THEFT() {
/* 127 */     return self.THEFT;
/*     */   }
/*     */   
/*     */   public static CRIME SPEECH() {
/* 131 */     return self.SPEECH;
/*     */   }
/*     */   
/*     */   public static CRIME S_PLEASURE() {
/* 135 */     return self.S_PLEASURE;
/*     */   }
/*     */   
/*     */   public static CRIME S_MURDER() {
/* 139 */     return self.S_MURDER;
/*     */   }
/*     */   
/*     */   public static CRIME S_DISRESPECT() {
/* 143 */     return self.S_DISRESPECT;
/*     */   }
/*     */   
/*     */   public static CRIME S_THEFT() {
/* 147 */     return self.S_THEFT;
/*     */   }
/*     */   
/*     */   public static CRIME WAR() {
/* 151 */     return self.WAR;
/*     */   }
/*     */   
/*     */   public static LIST<CRIME> ALL() {
/* 155 */     return self.ALL;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CRIME
/*     */     implements INDEXED
/*     */   {
/*     */     public CharSequence name;
/*     */     
/*     */     public CharSequence names;
/*     */     public CharSequence title;
/*     */     public CharSequence titles;
/*     */     public CharSequence desc;
/*     */     private final int index;
/*     */     
/*     */     CRIME(Json json, Json text, LISTE<CRIME> all, String key, HCLASS cl) {
/* 171 */       this(json, text, all, key, true, cl);
/*     */     }
/*     */     public final String key; public final double defFreedom; public final double defLaw; public final boolean isJudged; public final HCLASS cl; boolean isCriminal = true; public final StatStanding.StandingDef standingDef;
/*     */     CRIME(Json json, Json text, LISTE<CRIME> all, String key, boolean judged, HCLASS cl) {
/* 175 */       this.index = all.add(this);
/*     */       
/* 177 */       this.key = key;
/* 178 */       Json t = text.json(key);
/* 179 */       this.name = t.text("NAME");
/* 180 */       this.names = t.text("NAMES");
/* 181 */       this.title = t.text("TITLE");
/* 182 */       this.titles = t.text("TITLES");
/* 183 */       this.desc = t.text("DESC");
/*     */       
/* 185 */       json = json.json(key);
/* 186 */       this.standingDef = new StatStanding.StandingDef(json);
/* 187 */       this.defFreedom = json.d("FREEDOM", 0.0D, 1.0D);
/* 188 */       this.defLaw = json.d("LAW", 0.0D, 1.0D);
/* 189 */       this.isJudged = judged;
/* 190 */       this.cl = cl;
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 195 */       return this.index;
/*     */     }
/*     */     
/*     */     public double tyrrany(HCLASS cl, Race race) {
/* 199 */       if (race == null) {
/* 200 */         double pop = 0.0D;
/* 201 */         double v = 0.0D;
/* 202 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 203 */           int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 204 */           pop += p;
/* 205 */           v += p * ((Race)RACES.all().get(ri)).pref().crimeFreedom(this);
/*     */         } 
/* 207 */         if (pop == 0.0D)
/* 208 */           return this.defFreedom; 
/* 209 */         return v / pop;
/*     */       } 
/* 211 */       return race.pref().crimeFreedom(this);
/*     */     }
/*     */     
/*     */     public double law(HCLASS cl, Race race) {
/* 215 */       if (race == null) {
/* 216 */         double pop = 0.0D;
/* 217 */         double v = 0.0D;
/* 218 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 219 */           int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 220 */           pop += p;
/* 221 */           v += p * ((Race)RACES.all().get(ri)).pref().crimeLaw(this);
/*     */         } 
/* 223 */         if (pop == 0.0D)
/* 224 */           return this.defLaw; 
/* 225 */         return v / pop;
/*     */       } 
/* 227 */       return race.pref().crimeLaw(this);
/*     */     }
/*     */     
/*     */     public double tyrrany(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT pu) {
/* 231 */       if (race == null) {
/* 232 */         double pop = 0.0D;
/* 233 */         double v = 0.0D;
/* 234 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 235 */           int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 236 */           pop += p;
/* 237 */           v += p * ((Race)RACES.all().get(ri)).pref().crimeFreedom(this);
/*     */         } 
/* 239 */         if (pop == 0.0D)
/* 240 */           return this.defFreedom * pu.tyranny(cl, race); 
/* 241 */         return pu.tyranny(cl, race) * v / pop;
/*     */       } 
/* 243 */       return pu.tyranny(cl, race) * race.pref().crimeFreedom(this);
/*     */     }
/*     */     
/*     */     public double law(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT pu) {
/* 247 */       if (race == null) {
/* 248 */         double pop = 0.0D;
/* 249 */         double v = 0.0D;
/* 250 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 251 */           int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 252 */           pop += p;
/* 253 */           v += p * ((Race)RACES.all().get(ri)).pref().crimeLaw(this);
/*     */         } 
/* 255 */         if (pop == 0.0D)
/* 256 */           return pu.tyranny(cl, race) * this.defLaw; 
/* 257 */         return pu.tyranny(cl, race) * v / pop;
/*     */       } 
/* 259 */       return pu.tyranny(cl, race) * race.pref().crimeLaw(this);
/*     */     }
/*     */     
/*     */     public StatCrime stat() {
/* 263 */       return (StatCrime)(STATS.LAW()).crimes.get(this.index);
/*     */     }
/*     */     
/*     */     public boolean isCriminal() {
/* 267 */       return this.isCriminal;
/*     */     }
/*     */ 
/*     */     
/*     */     public CRIMES.Response loyaltyInc(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT pun) {
/* 272 */       return loyaltyIncCurrent(cl, race, tyrrany(cl, race, pun), law(cl, race, pun));
/*     */     }
/*     */     
/*     */     public CRIMES.Response loyaltyIncCurrent(HCLASS cl, Race race) {
/* 276 */       return loyaltyIncCurrent(cl, race, stat().tyrrany(cl, race), stat().law(cl, race));
/*     */     }
/*     */ 
/*     */     
/*     */     private CRIMES.Response loyaltyIncCurrent(HCLASS cl, Race race, double dtyrrany, double dlaw) {
/* 281 */       double hapCurrent = (STANDINGS.get(cl)).bhappiness.get(cl.get(race));
/*     */ 
/*     */       
/* 284 */       double hapWithout = hapCurrent / (1.0D - STATS.LAW().tyrrany(cl, race));
/* 285 */       double nextTyr = 0.0D; int ci;
/* 286 */       for (ci = 0; ci < CRIMES.all(cl).size(); ci++) {
/* 287 */         CRIME c = (CRIME)CRIMES.all(cl).get(ci);
/* 288 */         nextTyr += c.tyrrany(cl, race, (c.stat().punishment(cl, race)).punish);
/*     */       } 
/* 290 */       nextTyr -= tyrrany(cl, race, (stat().punishment(cl, race)).punish);
/* 291 */       CRIMES.response.oldHappiness = hapWithout * (1.0D - nextTyr);
/*     */       
/* 293 */       nextTyr += dtyrrany;
/* 294 */       CRIMES.response.newHap = hapWithout * (1.0D - nextTyr);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 299 */       double lawMul = 1.0D;
/* 300 */       double lawAdd = (BOOSTABLES.CIVICS()).LAW.baseValue;
/* 301 */       for (Booster bo : (BOOSTABLES.CIVICS()).LAW.all()) {
/* 302 */         if (bo.isMul) {
/* 303 */           lawMul *= bo.get(HCLASS_RACE.clP(race, cl)); continue;
/*     */         } 
/* 305 */         lawAdd += bo.get(HCLASS_RACE.clP(race, cl));
/*     */       } 
/*     */       
/* 308 */       for (ci = 0; ci < CRIMES.all(cl).size(); ci++) {
/* 309 */         CRIME c = (CRIME)CRIMES.all(cl).get(ci);
/* 310 */         lawAdd -= c.stat().law(cl, race);
/* 311 */         lawAdd += c.law(cl, race, (c.stat().punishment(cl, race)).punish);
/*     */       } 
/* 313 */       lawAdd -= law(cl, race, (stat().punishment(cl, race)).punish);
/* 314 */       CRIMES.response.oldLaw = lawMul * lawAdd;
/* 315 */       lawAdd += dlaw;
/*     */       
/* 317 */       CRIMES.response.newLaw = lawMul * lawAdd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 324 */       double mul = 1.0D;
/* 325 */       double add = (STANDINGS.get(cl)).bloyalty.baseValue;
/* 326 */       for (Booster bo : (STANDINGS.get(cl)).bloyalty.all()) {
/* 327 */         if (bo.isMul) {
/* 328 */           mul *= bo.get(HCLASS_RACE.clP(race, cl)); continue;
/*     */         } 
/* 330 */         add += bo.get(HCLASS_RACE.clP(race, cl));
/*     */       } 
/*     */       
/* 333 */       add -= hapCurrent;
/* 334 */       mul /= 1.0D + (BOOSTABLES.CIVICS()).LAW.get(HCLASS_RACE.clP(race, cl));
/* 335 */       CRIMES.response.oldloy = (add + CRIMES.response.oldHappiness) * mul * (1.0D + CRIMES.response.oldLaw);
/* 336 */       CRIMES.response.loy = (add + CRIMES.response.newHap) * mul * (1.0D + CRIMES.response.newLaw);
/*     */ 
/*     */ 
/*     */       
/* 340 */       CRIMES.response.diff = CRIMES.response.loy - CRIMES.response.oldloy;
/* 341 */       CRIMES.response.diff = Math.floor(CRIMES.response.diff * 1000.0D) / 1000.0D;
/* 342 */       return CRIMES.response;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 348 */   private static Response response = new Response();
/*     */   
/*     */   public static final class Response {
/*     */     public double oldHappiness;
/*     */     public double newHap;
/*     */     public double oldLaw;
/*     */     public double newLaw;
/*     */     public double oldloy;
/*     */     public double loy;
/*     */     public double diff;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CRIMES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */