/*     */ package settlement.stats.law;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY_COLLECTION;
/*     */ import util.statistics.HistoryObject;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatCrime
/*     */ {
/*  40 */   private static CharSequence ¤¤custody = "In Custody";
/*  41 */   private static CharSequence ¤¤crimes = "Crimes (today/yearly)";
/*  42 */   private static CharSequence ¤¤arrests = "Arrests (today/yearly)";
/*  43 */   private static CharSequence ¤¤current = "Decreed Punishment:";
/*  44 */   private static CharSequence ¤¤effect = "Administering a punishment for this crime has the following max potential effect:";
/*  45 */   private static CharSequence ¤¤currentGood = "The current punishment for this crime is is good will increase net {0}!";
/*  46 */   private static CharSequence ¤¤currentBad = "The current punishment for this crime too harsh, and the net {0} will decrease. Get more guards and other law boost in order to benefit from the current combination.";
/*     */   
/*     */   static {
/*  49 */     D.ts(StatCrime.class);
/*     */   }
/*     */   
/*  52 */   private final HistoryObject<HCLASS_RACE> occurence = new HistoryObject(32, (TIMECYCLE)TIME.days(), 
/*  53 */       false, HCLASS_RACE.MAP());
/*  54 */   private final HistoryObject<HCLASS_RACE> caught = new HistoryObject(32, (TIMECYCLE)TIME.days(), 
/*  55 */       false, HCLASS_RACE.MAP());
/*     */   
/*     */   int criminalsTot;
/*  58 */   final int[] criminals = Alloc.ii(RACES.all().size());
/*     */   
/*     */   public final CRIMES.CRIME crime;
/*  61 */   private final int[] autoPunishment = Alloc.ii(HCLASS_RACE.ALL().size());
/*     */   private final CrimesData data;
/*  63 */   private final double[] recentPunishments = new double[HCLASS_RACE.ALL().size() * CRIME_PUNISHMENTS.ALL().size()];
/*  64 */   private final double[] freedom = new double[HCLASS_RACE.ALL().size()];
/*  65 */   private final double[] loyalty = new double[HCLASS_RACE.ALL().size()];
/*     */   
/*     */   StatCrime(StatsInit init, CRIMES.CRIME type, CrimesData data) {
/*  68 */     this.crime = type;
/*  69 */     this.data = data;
/*  70 */     init.savers.put("LAW_CRIME_OCCURENCE_" + type.key, this.occurence);
/*  71 */     init.savers.put("LAW_CRIME_CAUGHT_" + type.key, this.caught);
/*  72 */     init.savers.put("LAW_CRIME_DATA_" + type.key, new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/*  76 */             HCLASS_RACE.MAP().saver().save(StatCrime.this.autoPunishment, file);
/*  77 */             StatCrime.this.occurence.save(file);
/*  78 */             StatCrime.this.caught.save(file);
/*  79 */             file.dsE(StatCrime.this.recentPunishments);
/*  80 */             file.dsE(StatCrime.this.freedom);
/*  81 */             file.dsE(StatCrime.this.loyalty);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/*  86 */             clear();
/*  87 */             HCLASS_RACE.MAP().loader().load(StatCrime.this.autoPunishment, file, 0);
/*  88 */             StatCrime.this.occurence.load(file);
/*  89 */             StatCrime.this.caught.load(file);
/*  90 */             file.dsE(StatCrime.this.recentPunishments);
/*  91 */             file.dsE(StatCrime.this.freedom);
/*  92 */             file.dsE(StatCrime.this.loyalty);
/*  93 */             if (VERSION.versionIsBefore(71, 23)) {
/*  94 */               StatCrime.this.setPunishments();
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void clear() {
/* 100 */             StatCrime.this.criminalsTot = 0;
/* 101 */             Arrays.fill(StatCrime.this.criminals, 0);
/* 102 */             StatCrime.this.occurence.clear();
/* 103 */             StatCrime.this.caught.clear();
/* 104 */             Arrays.fill(StatCrime.this.recentPunishments, 0.0D);
/* 105 */             Arrays.fill(StatCrime.this.freedom, 0.0D);
/* 106 */             Arrays.fill(StatCrime.this.loyalty, 0.0D);
/* 107 */             StatCrime.this.setPunishments();
/*     */           }
/*     */         });
/*     */     
/* 111 */     setPunishments();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setPunishments() {
/* 117 */     Arrays.fill(this.autoPunishment, 0);
/* 118 */     for (Race r : RACES.all()) {
/* 119 */       this.autoPunishment[(HCLASSES.OTHER().get(r)).index] = CRIME_PUNISHMENTS.STOCKS().index();
/*     */     }
/* 121 */     if (this.crime == CRIMES.PERSECUTED()) {
/* 122 */       for (Race r : RACES.all()) {
/* 123 */         this.autoPunishment[(HCLASSES.CITIZEN().get(r)).index] = CRIME_PUNISHMENTS.STOCKS().index();
/*     */       }
/*     */     }
/* 126 */     if (this.crime == CRIMES.S_PLEASURE()) {
/* 127 */       for (Race r : RACES.all()) {
/* 128 */         this.autoPunishment[(HCLASSES.SLAVE().get(r)).index] = CRIME_PUNISHMENTS.STOCKS().index();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double recentPunishment(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT p) {
/* 135 */     if (race == null) {
/* 136 */       double pop = 0.0D;
/* 137 */       double res = 0.0D;
/* 138 */       for (Race r : RACES.all()) {
/* 139 */         double pp = POP.pop(cl, r);
/* 140 */         pop += pp;
/* 141 */         res += recentPunishment(cl, r, p) * pp;
/*     */       } 
/* 143 */       if (pop == 0.0D)
/* 144 */         return 0.0D; 
/* 145 */       return res / pop;
/*     */     } 
/* 147 */     return this.recentPunishments[p.index() * CRIME_PUNISHMENTS.ALL().size() + HCLASS_RACE.clP(race, cl).index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void punish(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT punishment) {
/* 152 */     double dd = 1.0D / CRIME_PUNISHMENTS.get(cl).size();
/* 153 */     HCLASS_RACE cc = HCLASS_RACE.clP(race, cl);
/* 154 */     this.recentPunishments[punishment.index() * CRIME_PUNISHMENTS.ALL().size() + cc.index()] = this.recentPunishments[punishment.index() * CRIME_PUNISHMENTS.ALL().size() + cc.index()] + 1.0D;
/* 155 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.ALL()) {
/* 156 */       int i = p.index() * CRIME_PUNISHMENTS.ALL().size() + cc.index();
/* 157 */       this.recentPunishments[i] = this.recentPunishments[i] - dd;
/* 158 */       if (this.recentPunishments[i] < 0.0D) {
/* 159 */         this.recentPunishments[i] = 0.0D;
/*     */       }
/*     */     } 
/* 162 */     calc(cc);
/*     */   }
/*     */ 
/*     */   
/*     */   private void calc(HCLASS_RACE cc) {
/* 167 */     double tot = 0.0D;
/* 168 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cc.cl)) {
/* 169 */       int i = p.index() * CRIME_PUNISHMENTS.ALL().size() + cc.index();
/* 170 */       tot += this.recentPunishments[i];
/*     */     } 
/* 172 */     double freedom = 0.0D;
/* 173 */     double loyalty = 0.0D;
/*     */     
/* 175 */     if (tot > 0.0D) {
/* 176 */       for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cc.cl)) {
/* 177 */         int i = p.index() * CRIME_PUNISHMENTS.ALL().size() + cc.index();
/* 178 */         double v = this.recentPunishments[i] / tot;
/* 179 */         freedom += v * p.tyranny(cc.cl, cc.race);
/* 180 */         loyalty += v * p.law(cc.cl, cc.race);
/*     */       } 
/*     */     }
/*     */     
/* 184 */     this.freedom[cc.index] = freedom;
/* 185 */     this.loyalty[cc.index] = loyalty;
/*     */   }
/*     */   
/*     */   public double law(HCLASS cl, Race race) {
/* 189 */     return lawValue(cl, race) * this.crime.law(cl, race);
/*     */   }
/*     */   
/*     */   public double tyrrany(HCLASS cl, Race race) {
/* 193 */     return tyrranyValue(cl, race) * this.crime.tyrrany(cl, race);
/*     */   }
/*     */   
/*     */   public double lawValue(HCLASS cl, Race race) {
/* 197 */     if (race == null) {
/* 198 */       double pop = 0.0D;
/* 199 */       double res = 0.0D;
/* 200 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 201 */         Race r = (Race)RACES.all().get(ri);
/* 202 */         double p = (STATS.POP()).POP.data(cl).get(r);
/* 203 */         pop += p;
/* 204 */         res += p * lawValue(cl, r);
/*     */       } 
/* 206 */       if (pop == 0.0D) {
/* 207 */         return 0.0D;
/*     */       }
/* 209 */       return res / pop;
/*     */     } 
/* 211 */     return this.loyalty[HCLASS_RACE.clP(race, cl).index()];
/*     */   }
/*     */   
/*     */   public double tyrranyValue(HCLASS cl, Race race) {
/* 215 */     if (race == null) {
/* 216 */       double pop = 0.0D;
/* 217 */       double res = 0.0D;
/* 218 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 219 */         Race r = (Race)RACES.all().get(ri);
/* 220 */         double p = (STATS.POP()).POP.data(cl).get(r);
/* 221 */         pop += p;
/* 222 */         res += p * tyrranyValue(cl, r);
/*     */       } 
/* 224 */       if (pop == 0.0D) {
/* 225 */         return 0.0D;
/*     */       }
/* 227 */       return res / pop;
/*     */     } 
/* 229 */     return this.freedom[HCLASS_RACE.clP(race, cl).index()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatPunishment punishment(HCLASS cl, Race race) {
/* 238 */     if (race == null) {
/* 239 */       StatPunishment p = null;
/* 240 */       for (Race r : RACES.all()) {
/* 241 */         StatPunishment pp = punishment(cl, r);
/* 242 */         if (p == null) {
/* 243 */           p = pp; continue;
/* 244 */         }  if (p != pp)
/* 245 */           return null; 
/*     */       } 
/* 247 */       return p;
/*     */     } 
/*     */     
/* 250 */     return (StatPunishment)(STATS.LAW()).punishments.get(this.autoPunishment[(HCLASS_RACE.clP(race, cl)).index]);
/*     */   }
/*     */ 
/*     */   
/*     */   public CRIME_PUNISHMENTS.PUNISHMENT punishment(Induvidual i) {
/* 255 */     return (punishment(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).cl, i.race())).punish;
/*     */   }
/*     */ 
/*     */   
/*     */   public void punishmentSet(HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT p) {
/* 260 */     if (race == null) {
/* 261 */       for (Race r : RACES.all()) {
/* 262 */         punishmentSet(cl, r, p);
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 267 */     this.autoPunishment[(HCLASS_RACE.clP(race, cl)).index] = p.index();
/*     */   }
/*     */ 
/*     */   
/*     */   public void commit(HCLASS_RACE c, int amount) {
/* 272 */     this.occurence.inc(c, amount);
/* 273 */     this.data.crimesComitted.inc(c, amount);
/*     */     
/* 275 */     this.occurence.inc(HCLASS_RACE.clP(null, c.cl), amount);
/* 276 */     this.data.crimesComitted.inc(HCLASS_RACE.clP(null, c.cl), amount);
/*     */     
/* 278 */     this.occurence.inc(HCLASS_RACE.clP(), amount);
/* 279 */     this.data.crimesComitted.inc(HCLASS_RACE.clP(), amount);
/*     */   }
/*     */   
/*     */   public void commit(Induvidual i) {
/* 283 */     commit(i.popCL(), 1);
/*     */   }
/*     */   
/*     */   public final void catchh(Induvidual i) {
/* 287 */     catchh(i.race());
/*     */   }
/*     */   
/*     */   public void catchh(Race race) {
/* 291 */     this.caught.inc(HCLASS_RACE.clP(race, this.crime.cl), 1);
/* 292 */     this.caught.inc(HCLASS_RACE.clP(null, this.crime.cl), 1);
/* 293 */     if (this.crime.cl.player)
/* 294 */       this.caught.inc(HCLASS_RACE.clP(), 1); 
/*     */   }
/*     */   
/*     */   public HISTORY_COLLECTION<HCLASS_RACE> occurence() {
/* 298 */     return (HISTORY_COLLECTION<HCLASS_RACE>)this.occurence;
/*     */   }
/*     */   
/*     */   public HISTORY_COLLECTION<HCLASS_RACE> caught() {
/* 302 */     return (HISTORY_COLLECTION<HCLASS_RACE>)this.caught;
/*     */   }
/*     */   
/*     */   public int criminals(Race race) {
/* 306 */     if (race == null)
/* 307 */       return this.criminalsTot; 
/* 308 */     return this.criminals[race.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(HCLASS_RACE cl, double ds) {
/* 315 */     StatPunishment pp = punishment(cl.cl, cl.race);
/*     */     
/* 317 */     if (pp != null && pp.punish == CRIME_PUNISHMENTS.PARDON()) {
/* 318 */       double dd = ds / (TIME.secondsPerDay() * 16 * 4);
/*     */       
/* 320 */       for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.ALL()) {
/* 321 */         int ii = p.index() * CRIME_PUNISHMENTS.ALL().size() + cl.index();
/* 322 */         if (p == CRIME_PUNISHMENTS.PARDON()) {
/* 323 */           this.recentPunishments[ii] = this.recentPunishments[ii] + dd; continue;
/*     */         } 
/* 325 */         this.recentPunishments[ii] = this.recentPunishments[ii] - dd;
/* 326 */         if (this.recentPunishments[ii] < 0.0D) {
/* 327 */           this.recentPunishments[ii] = 0.0D;
/*     */         }
/*     */       } 
/* 330 */       calc(cl);
/*     */     } 
/*     */     
/* 333 */     boolean fix = false;
/* 334 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.ALL()) {
/* 335 */       if (this.recentPunishments[p.index() * CRIME_PUNISHMENTS.ALL().size() + cl.index()] > 1.0D) {
/* 336 */         fix = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 341 */     if (fix) {
/* 342 */       for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.ALL()) {
/* 343 */         this.recentPunishments[p.index() * CRIME_PUNISHMENTS.ALL().size() + cl.index()] = this.recentPunishments[p.index() * CRIME_PUNISHMENTS.ALL().size() + cl.index()] * 0.85D;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, HCLASS cl, Race race) {
/* 350 */     GBox b = (GBox)box;
/*     */     
/* 352 */     HCLASS_RACE r = HCLASS_RACE.clP(race, cl);
/* 353 */     b.title(this.crime.name);
/*     */ 
/*     */ 
/*     */     
/* 357 */     b.text(this.crime.desc);
/* 358 */     b.sep();
/*     */ 
/*     */     
/* 361 */     CRIMES.Response rr = this.crime.loyaltyInc(cl, race, (punishment(cl, race)).punish);
/*     */     
/* 363 */     GText t = b.text();
/*     */     
/* 365 */     if (rr.diff >= 0.0D) {
/* 366 */       t.normalify2();
/* 367 */       t.add(¤¤currentGood);
/*     */     } else {
/* 369 */       t.errorify();
/* 370 */       t.add(¤¤currentBad);
/*     */     } 
/*     */     
/* 373 */     t.insert(0, (STANDINGS.get(cl)).bloyalty.name);
/* 374 */     b.add((SPRITE)t);
/* 375 */     b.NL(4);
/*     */     
/* 377 */     b.add((SPRITE)(STANDINGS.get(cl)).happiness.bo.icon);
/* 378 */     b.textLL((STANDINGS.get(cl)).happiness.bo.name);
/* 379 */     b.tab(6);
/* 380 */     b.add((SPRITE)GFORMAT.percInc(b.text(), rr.newHap - rr.oldHappiness));
/* 381 */     b.NL();
/* 382 */     b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 383 */     b.textLL((BOOSTABLES.CIVICS()).LAW.name);
/* 384 */     b.tab(6);
/* 385 */     b.add((SPRITE)GFORMAT.percInc(b.text(), rr.newLaw - rr.oldLaw));
/* 386 */     b.NL();
/* 387 */     b.add((SPRITE)(STANDINGS.get(cl)).bloyalty.icon);
/* 388 */     b.textLL((STANDINGS.get(cl)).bloyalty.name);
/* 389 */     b.tab(6);
/* 390 */     b.add((SPRITE)GFORMAT.percInc(b.text(), rr.diff));
/*     */     
/* 392 */     b.sep();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 398 */     b.add((SPRITE)(UI.icons()).s.slave);
/* 399 */     b.textLL(¤¤custody);
/* 400 */     b.tab(7);
/* 401 */     b.add((SPRITE)GFORMAT.i(b.text(), criminals(race)));
/* 402 */     b.NL();
/*     */     
/* 404 */     b.add((SPRITE)(UI.icons()).s.slave);
/* 405 */     b.textLL(¤¤crimes);
/* 406 */     b.tab(7);
/* 407 */     b.add((SPRITE)GFORMAT.i(b.text(), occurence().get(r)));
/* 408 */     b.text((CharSequence)b.text().add('/'));
/* 409 */     b.add((SPRITE)GFORMAT.i(b.text(), occurence().history(r).getPeriodSum(-16, 0)));
/* 410 */     b.NL();
/*     */     
/* 412 */     b.add((SPRITE)(UI.icons()).s.sword);
/* 413 */     b.textLL(¤¤arrests);
/* 414 */     b.tab(7);
/* 415 */     b.add((SPRITE)GFORMAT.i(b.text(), caught().get(r)));
/* 416 */     b.text((CharSequence)b.text().add('/'));
/* 417 */     b.add((SPRITE)GFORMAT.i(b.text(), caught().history(r).getPeriodSum(-16, 0)));
/* 418 */     b.NL();
/*     */     
/* 420 */     b.sep();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 425 */     b.textLL(¤¤effect);
/* 426 */     b.NL();
/*     */ 
/*     */     
/* 429 */     b.add((SPRITE)(STANDINGS.get(cl)).bhappiness.icon);
/* 430 */     b.textLL(StatsLaw.¤¤tyranny);
/* 431 */     b.tab(7);
/* 432 */     b.add((SPRITE)GFORMAT.percInc(b.text(), -this.crime.tyrrany(cl, race), 1));
/* 433 */     b.NL();
/*     */     
/* 435 */     b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 436 */     b.textLL((BOOSTABLES.CIVICS()).LAW.name);
/* 437 */     b.tab(7);
/* 438 */     b.add((SPRITE)GFORMAT.percInc(b.text(), this.crime.law(cl, race), 1));
/* 439 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 443 */     StatPunishment pp = punishment(cl, race);
/*     */     
/* 445 */     b.add((pp == null) ? (SPRITE)(UI.icons()).m.questionmark : (SPRITE)pp.punish.icon);
/* 446 */     b.textLL(¤¤current);
/* 447 */     b.tab(7);
/* 448 */     if (pp != null) {
/* 449 */       b.textL((punishment(cl, race)).punish.action);
/* 450 */       b.NL();
/* 451 */       b.tab(1);
/* 452 */       b.add((SPRITE)(STANDINGS.get(cl)).bhappiness.icon);
/* 453 */       b.add((SPRITE)GFORMAT.f1(b.text(), pp.punish.tyranny(cl, race)));
/* 454 */       b.space();
/* 455 */       b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 456 */       b.add((SPRITE)GFORMAT.f1(b.text(), pp.punish.law(cl, race)));
/* 457 */       b.NL(4);
/*     */     } 
/* 459 */     b.NL();
/*     */     
/* 461 */     b.sep();
/* 462 */     b.tab(5);
/* 463 */     b.textLL(Dic.¤¤Rate);
/* 464 */     b.tab(7);
/* 465 */     b.add((SPRITE)(STANDINGS.get(cl)).bhappiness.icon);
/* 466 */     b.tab(9);
/* 467 */     b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 468 */     b.NL();
/*     */     
/* 470 */     double ptot = 0.0D;
/* 471 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cl)) {
/* 472 */       ptot += recentPunishment(cl, race, p);
/*     */     }
/*     */     
/* 475 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cl)) {
/* 476 */       b.add(p.icon.small);
/* 477 */       b.textL(p.name);
/* 478 */       b.tab(5);
/* 479 */       double d = (ptot <= 0.0D) ? 0.0D : (recentPunishment(cl, race, p) / ptot);
/*     */       
/* 481 */       b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 482 */       b.tab(7);
/* 483 */       b.add((SPRITE)GFORMAT.f0(b.text(), -p.tyranny(cl, race) * this.crime.tyrrany(cl, race)));
/* 484 */       b.tab(9);
/* 485 */       b.add((SPRITE)GFORMAT.f(b.text(), p.law(cl, race) * this.crime.law(cl, race)));
/* 486 */       b.NL(2);
/*     */     } 
/*     */     
/* 489 */     b.textLL(Dic.¤¤Total);
/* 490 */     b.tab(7);
/* 491 */     b.add((SPRITE)GFORMAT.f0(b.text(), -tyrranyValue(cl, race) * this.crime.tyrrany(cl, race)));
/* 492 */     b.tab(9);
/* 493 */     b.add((SPRITE)GFORMAT.f0(b.text(), lawValue(cl, race) * this.crime.law(cl, race)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 498 */     b.sep();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatCrime.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */