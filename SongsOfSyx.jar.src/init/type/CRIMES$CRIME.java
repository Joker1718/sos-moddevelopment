/*     */ package init.type;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.Booster;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CRIME
/*     */   implements INDEXED
/*     */ {
/*     */   public CharSequence name;
/*     */   public CharSequence names;
/*     */   public CharSequence title;
/*     */   public CharSequence titles;
/*     */   public CharSequence desc;
/*     */   private final int index;
/*     */   public final String key;
/*     */   public final double defFreedom;
/*     */   public final double defLaw;
/*     */   public final boolean isJudged;
/*     */   public final HCLASS cl;
/*     */   boolean isCriminal = true;
/*     */   public final StatStanding.StandingDef standingDef;
/*     */   
/*     */   CRIME(Json json, Json text, LISTE<CRIME> all, String key, HCLASS cl) {
/* 171 */     this(json, text, all, key, true, cl);
/*     */   }
/*     */   
/*     */   CRIME(Json json, Json text, LISTE<CRIME> all, String key, boolean judged, HCLASS cl) {
/* 175 */     this.index = all.add(this);
/*     */     
/* 177 */     this.key = key;
/* 178 */     Json t = text.json(key);
/* 179 */     this.name = t.text("NAME");
/* 180 */     this.names = t.text("NAMES");
/* 181 */     this.title = t.text("TITLE");
/* 182 */     this.titles = t.text("TITLES");
/* 183 */     this.desc = t.text("DESC");
/*     */     
/* 185 */     json = json.json(key);
/* 186 */     this.standingDef = new StatStanding.StandingDef(json);
/* 187 */     this.defFreedom = json.d("FREEDOM", 0.0D, 1.0D);
/* 188 */     this.defLaw = json.d("LAW", 0.0D, 1.0D);
/* 189 */     this.isJudged = judged;
/* 190 */     this.cl = cl;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 195 */     return this.index;
/*     */   }
/*     */   
/*     */   public double tyrrany(HCLASS cl, Race race) {
/* 199 */     if (race == null) {
/* 200 */       double pop = 0.0D;
/* 201 */       double v = 0.0D;
/* 202 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 203 */         int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 204 */         pop += p;
/* 205 */         v += p * ((Race)RACES.all().get(ri)).pref().crimeFreedom(this);
/*     */       } 
/* 207 */       if (pop == 0.0D)
/* 208 */         return this.defFreedom; 
/* 209 */       return v / pop;
/*     */     } 
/* 211 */     return race.pref().crimeFreedom(this);
/*     */   }
/*     */   
/*     */   public double law(HCLASS cl, Race race) {
/* 215 */     if (race == null) {
/* 216 */       double pop = 0.0D;
/* 217 */       double v = 0.0D;
/* 218 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 219 */         int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 220 */         pop += p;
/* 221 */         v += p * ((Race)RACES.all().get(ri)).pref().crimeLaw(this);
/*     */       } 
/* 223 */       if (pop == 0.0D)
/* 224 */         return this.defLaw; 
/* 225 */       return v / pop;
/*     */     } 
/* 227 */     return race.pref().crimeLaw(this);
/*     */   }
/*     */   
/*     */   public double tyrrany(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT pu) {
/* 231 */     if (race == null) {
/* 232 */       double pop = 0.0D;
/* 233 */       double v = 0.0D;
/* 234 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 235 */         int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 236 */         pop += p;
/* 237 */         v += p * ((Race)RACES.all().get(ri)).pref().crimeFreedom(this);
/*     */       } 
/* 239 */       if (pop == 0.0D)
/* 240 */         return this.defFreedom * pu.tyranny(cl, race); 
/* 241 */       return pu.tyranny(cl, race) * v / pop;
/*     */     } 
/* 243 */     return pu.tyranny(cl, race) * race.pref().crimeFreedom(this);
/*     */   }
/*     */   
/*     */   public double law(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT pu) {
/* 247 */     if (race == null) {
/* 248 */       double pop = 0.0D;
/* 249 */       double v = 0.0D;
/* 250 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 251 */         int p = (STATS.POP()).POP.data(cl).get(RACES.all().get(ri));
/* 252 */         pop += p;
/* 253 */         v += p * ((Race)RACES.all().get(ri)).pref().crimeLaw(this);
/*     */       } 
/* 255 */       if (pop == 0.0D)
/* 256 */         return pu.tyranny(cl, race) * this.defLaw; 
/* 257 */       return pu.tyranny(cl, race) * v / pop;
/*     */     } 
/* 259 */     return pu.tyranny(cl, race) * race.pref().crimeLaw(this);
/*     */   }
/*     */   
/*     */   public StatCrime stat() {
/* 263 */     return (StatCrime)(STATS.LAW()).crimes.get(this.index);
/*     */   }
/*     */   
/*     */   public boolean isCriminal() {
/* 267 */     return this.isCriminal;
/*     */   }
/*     */ 
/*     */   
/*     */   public CRIMES.Response loyaltyInc(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT pun) {
/* 272 */     return loyaltyIncCurrent(cl, race, tyrrany(cl, race, pun), law(cl, race, pun));
/*     */   }
/*     */   
/*     */   public CRIMES.Response loyaltyIncCurrent(HCLASS cl, Race race) {
/* 276 */     return loyaltyIncCurrent(cl, race, stat().tyrrany(cl, race), stat().law(cl, race));
/*     */   }
/*     */ 
/*     */   
/*     */   private CRIMES.Response loyaltyIncCurrent(HCLASS cl, Race race, double dtyrrany, double dlaw) {
/* 281 */     double hapCurrent = (STANDINGS.get(cl)).bhappiness.get(cl.get(race));
/*     */ 
/*     */     
/* 284 */     double hapWithout = hapCurrent / (1.0D - STATS.LAW().tyrrany(cl, race));
/* 285 */     double nextTyr = 0.0D; int ci;
/* 286 */     for (ci = 0; ci < CRIMES.all(cl).size(); ci++) {
/* 287 */       CRIME c = (CRIME)CRIMES.all(cl).get(ci);
/* 288 */       nextTyr += c.tyrrany(cl, race, (c.stat().punishment(cl, race)).punish);
/*     */     } 
/* 290 */     nextTyr -= tyrrany(cl, race, (stat().punishment(cl, race)).punish);
/* 291 */     CRIMES.response.oldHappiness = hapWithout * (1.0D - nextTyr);
/*     */     
/* 293 */     nextTyr += dtyrrany;
/* 294 */     CRIMES.response.newHap = hapWithout * (1.0D - nextTyr);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 299 */     double lawMul = 1.0D;
/* 300 */     double lawAdd = (BOOSTABLES.CIVICS()).LAW.baseValue;
/* 301 */     for (Booster bo : (BOOSTABLES.CIVICS()).LAW.all()) {
/* 302 */       if (bo.isMul) {
/* 303 */         lawMul *= bo.get(HCLASS_RACE.clP(race, cl)); continue;
/*     */       } 
/* 305 */       lawAdd += bo.get(HCLASS_RACE.clP(race, cl));
/*     */     } 
/*     */     
/* 308 */     for (ci = 0; ci < CRIMES.all(cl).size(); ci++) {
/* 309 */       CRIME c = (CRIME)CRIMES.all(cl).get(ci);
/* 310 */       lawAdd -= c.stat().law(cl, race);
/* 311 */       lawAdd += c.law(cl, race, (c.stat().punishment(cl, race)).punish);
/*     */     } 
/* 313 */     lawAdd -= law(cl, race, (stat().punishment(cl, race)).punish);
/* 314 */     CRIMES.response.oldLaw = lawMul * lawAdd;
/* 315 */     lawAdd += dlaw;
/*     */     
/* 317 */     CRIMES.response.newLaw = lawMul * lawAdd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 324 */     double mul = 1.0D;
/* 325 */     double add = (STANDINGS.get(cl)).bloyalty.baseValue;
/* 326 */     for (Booster bo : (STANDINGS.get(cl)).bloyalty.all()) {
/* 327 */       if (bo.isMul) {
/* 328 */         mul *= bo.get(HCLASS_RACE.clP(race, cl)); continue;
/*     */       } 
/* 330 */       add += bo.get(HCLASS_RACE.clP(race, cl));
/*     */     } 
/*     */     
/* 333 */     add -= hapCurrent;
/* 334 */     mul /= 1.0D + (BOOSTABLES.CIVICS()).LAW.get(HCLASS_RACE.clP(race, cl));
/* 335 */     CRIMES.response.oldloy = (add + CRIMES.response.oldHappiness) * mul * (1.0D + CRIMES.response.oldLaw);
/* 336 */     CRIMES.response.loy = (add + CRIMES.response.newHap) * mul * (1.0D + CRIMES.response.newLaw);
/*     */ 
/*     */ 
/*     */     
/* 340 */     CRIMES.response.diff = CRIMES.response.loy - CRIMES.response.oldloy;
/* 341 */     CRIMES.response.diff = Math.floor(CRIMES.response.diff * 1000.0D) / 1000.0D;
/* 342 */     return CRIMES.response;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CRIMES$CRIME.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */