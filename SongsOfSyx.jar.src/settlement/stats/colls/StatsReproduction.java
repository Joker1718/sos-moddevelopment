/*     */ package settlement.stats.colls;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.updating.IUpdater;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class StatsReproduction {
/*  47 */   private static CharSequence ¤¤limit = "Births Allowed";
/*  48 */   private static CharSequence ¤¤fertile = "Fertile Population";
/*  49 */   private static CharSequence ¤¤children = "Children";
/*  50 */   private static CharSequence ¤¤noProp = "This subject type does dot reproduce naturally.";
/*  51 */   private static CharSequence ¤¤estimated = "Estimated births/year";
/*  52 */   private static CharSequence ¤¤days = "A {0} infant is dependant on its parent for {1} days. After that, the child takes {2} days to become a productive adult, but this period can be prolonged by schooling."; public final STAT fertile; public final STAT forced; public final STAT limited;
/*     */   
/*     */   static {
/*  55 */     D.ts(StatsReproduction.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private final int CHECKS_PER_YEAR = 4;
/*     */ 
/*     */ 
/*     */   
/*  67 */   public final RMapInt<HCLASS_RACE> limit = new RMapInt(HCLASS_RACE.MAP(), 0, 40000, 40000);
/*  68 */   public final Bitmap1D forcedSetting = new Bitmap1D(HCLASS_RACE.ALL().size(), false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final IUpdater updater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void set(Induvidual ii) {
/* 174 */     int from = (int)Math.ceil(1.5D * (ii.race()).physics.adultDay);
/* 175 */     int to = (int)(((STATS.POP()).age.lifespan(ii) - from) * (BOOSTABLES.PHYSICS()).REPRODUCTION_AGE.get((BOOSTABLE_O)ii));
/* 176 */     to += from;
/* 177 */     int a = (STATS.POP()).age.AGE_DAYS.indu().get(ii);
/* 178 */     this.fertile.indu().set(ii, (a >= from && a < to) ? 1 : 0);
/*     */   }
/*     */   
/*     */   StatsReproduction(StatsInit init)
/*     */   {
/* 183 */     this.updater = new IUpdater(60000, TIME.secondsPerDay() * TIME.years().bitConversion((TIMECYCLE)TIME.days()) / 4.0D)
/*     */       {
/*     */         
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/* 188 */           if (VIEW.b().isActive()) {
/*     */             return;
/*     */           }
/* 191 */           ENTITY e = SETT.ENTITIES().getByIndex(i);
/* 192 */           if (e != null && e instanceof Humanoid)
/* 193 */           { Humanoid a = (Humanoid)e;
/* 194 */             if (StatsReproduction.this.fertile.indu().get(a.indu()) != 1)
/*     */               return; 
/* 196 */             if (StatsReproduction.this.newInfantsAllowed(a.indu().clas(), a.race()) <= 0)
/*     */               return; 
/* 198 */             double rate = (BOOSTABLES.PHYSICS()).REPRODUCTION_SPEED.get((BOOSTABLE_O)a.indu()) / 4.0D;
/* 199 */             if (a.indu().hType() == HTYPES.SLAVE())
/* 200 */             { rate *= (StatsReproduction.this.fertile.data(HCLASSES.SLAVE()).get(a.race()) + 1.0D) / (StatsReproduction.this.fertile.type().get(HTYPE_RACE.get(a.indu())) + 1.0D);
/* 201 */               inpregnate(a, rate, HTYPES.PARENT_SLAVE()); }
/* 202 */             else if (a.indu().hType() == HTYPES.SUBJECT())
/* 203 */             { rate *= (StatsReproduction.this.fertile.data(HCLASSES.CITIZEN()).get(a.race()) + 1.0D) / (StatsReproduction.this.fertile.type().get(HTYPE_RACE.get(a.indu())) + 1.0D);
/* 204 */               inpregnate(a, rate, HTYPES.PARENT()); }  } 
/*     */         } protected double getDD(HCLASS cl, Race r) { if (StatsReproduction.this.forcedSetting.get((HCLASS_RACE.clP(r, cl)).index)) return 0.0D;  return 1.0D; }
/*     */       }; this.forced.standing = new StatStanding(this.forced, 1.0D); (this.forced.info()).icon = (SPRITE)(UI.icons()).s.reproduction; StatBooster bo = new StatBooster() {
/*     */         public double vGet(HCLASS_RACE t) { return (StatsReproduction.this.forcedSetting.get(t.index) ? true : false); } public double vGet(Div div) { return (StatsReproduction.this.forcedSetting.get((HCLASS_RACE.clP(div.race(), HCLASSES.CITIZEN())).index) ? true : false); } public double vGet(Induvidual indu) { return (StatsReproduction.this.forcedSetting.get((HCLASS_RACE.clP(indu.race(), indu.clas())).index) ? true : false); }
/*     */       }; this.forced.boosters.pushPromise((BOOSTABLES.PHYSICS()).REPRODUCTION_SPEED, (BValue)bo, 3.0D, true); bo = new StatBooster() {
/*     */         public double vGet(HCLASS_RACE t) { return get(); } public double vGet(Div div) { return get(); }
/*     */       }; init.count.getClass(); this.fertile = (STAT)new STATData("REPO_FERTILE", init, (DataO.DataAbs)new DataO.DataBit(init.count, "REPO_FERTILE_BIT")); this.fertile.info().setInt(); (this.fertile.info()).icon = (SPRITE)(UI.icons()).s.reproduction; this.forced = (STAT)new STATFakeData("REPO_BIRTH_NATURAL", init) {
/*     */         public double vGet(Induvidual indu) { return get(); } private double get() { double pop = (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(null); if (pop >= 2000.0D)
/*     */             return 1.0D;  return 0.2D + 0.8D * pop / 2000.0D; }
/*     */       }; (new BoosterValue((BValue)bo, new BSourceInfo(Dic.¤¤Population, (SPRITE)(UI.icons()).s.human), 1.0D, true)).add((BOOSTABLES.PHYSICS()).REPRODUCTION_SPEED); this.limited = (STAT)new STATFakeData("REPO_BIRTH_ALLOWED", init) {
/*     */         protected double getDD(HCLASS cl, Race r) { if (StatsReproduction.this.newInfantsAllowed(cl, r) > 0)
/* 215 */             return 1.0D;  return 0.0D; } private void inpregnate(Humanoid a, double chance, HTYPE parent) { if (chance < RND.rFloat()) {
/*     */             return;
/*     */           }
/* 218 */           a.HTypeSet(parent, null, null); }
/*     */       }; this.limited.standing = new StatStanding(this.limited, 1.0D); (this.limited.info()).icon = (SPRITE)(UI.icons()).s.reproduction.twin((SPRITE)(UI.icons()).s.cancel);
/*     */     init.addable.add(new StatsInit.Addable() { public void removePrivate(Induvidual i) {} public void addPrivate(Induvidual i) { StatsReproduction.this.set(i); } }
/*     */       );
/*     */     init.savers.put("KNOCKUPPER", this.updater);
/*     */     init.savers.put("KNOCKUPPER_limit", this.limit);
/*     */     init.savers.put("KNOCKUPPER_setting", this.forcedSetting);
/* 225 */     init.upers.add(new StatsInit.StatUpdatable() { public void update(double ds) { StatsReproduction.this.updater.update(ds); } }); } public HTYPE parent(HCLASS cl) { if (cl == HCLASSES.CITIZEN())
/* 226 */       return HTYPES.PARENT(); 
/* 227 */     if (cl == HCLASSES.SLAVE())
/* 228 */       return HTYPES.PARENT_SLAVE(); 
/* 229 */     return null; }
/*     */ 
/*     */   
/*     */   public HTYPE child(HCLASS cl) {
/* 233 */     if (cl == HCLASSES.CITIZEN())
/* 234 */       return HTYPES.CHILD(); 
/* 235 */     if (cl == HCLASSES.SLAVE())
/* 236 */       return HTYPES.CHILD_SLAVE(); 
/* 237 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int kidsIncoming(HCLASS cl, Race r) {
/* 242 */     HTYPE pp = parent(cl);
/* 243 */     if (pp == null)
/* 244 */       return 0; 
/* 245 */     if (r == null) {
/* 246 */       int am = 0;
/* 247 */       for (int ri = 0; ri < RACES.all().size(); ri++)
/* 248 */         am += kidsIncoming(cl, (Race)RACES.all().get(ri)); 
/* 249 */       return am;
/*     */     } 
/*     */     
/* 252 */     return (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, pp)) + (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, pp.child()));
/*     */   }
/*     */ 
/*     */   
/*     */   public double kidsPerYear(HCLASS cl, Race r) {
/* 257 */     if (parent(cl) == null) {
/* 258 */       return 0.0D;
/*     */     }
/* 260 */     if (r == null) {
/* 261 */       int am = 0;
/* 262 */       for (int ri = 0; ri < RACES.all().size(); ri++)
/* 263 */         am = (int)(am + kidsPerYear(cl, (Race)RACES.all().get(ri))); 
/* 264 */       return am;
/*     */     } 
/* 266 */     return this.fertile.data(cl).get(r) * (BOOSTABLES.PHYSICS()).REPRODUCTION_SPEED.get((BOOSTABLE_O)HCLASS_RACE.clP(r, cl));
/*     */   }
/*     */   
/*     */   public boolean propagates(HCLASS cl, Race r) {
/* 270 */     if (parent(cl) == null)
/* 271 */       return false; 
/* 272 */     if (r == null)
/* 273 */       return false; 
/* 274 */     return (r.physics.babyDays > 0);
/*     */   }
/*     */   
/*     */   public int newInfantsAllowed(HCLASS cl, Race r) {
/* 278 */     if (!propagates(cl, r))
/* 279 */       return 0; 
/* 280 */     int am = POP.next(cl, r);
/* 281 */     return this.limit.get((MAPPED)HCLASS_RACE.clP(r, cl)) - am;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, HCLASS cl, Race r) {
/* 289 */     GBox b = (GBox)box;
/*     */     
/* 291 */     HTYPE pp = parent(cl);
/*     */     
/* 293 */     b.textLL(pp.names);
/* 294 */     b.tab(6);
/* 295 */     b.add((SPRITE)GFORMAT.i(b.text(), ((pp == null) ? 0L : (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, pp)))));
/* 296 */     b.NL();
/* 297 */     b.textLL(¤¤children);
/* 298 */     b.tab(6);
/* 299 */     b.add((SPRITE)GFORMAT.i(b.text(), ((pp == null) ? 0L : (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, pp.child())))));
/* 300 */     b.NL();
/* 301 */     b.textL(Dic.¤¤Total);
/* 302 */     b.tab(6);
/* 303 */     b.add((SPRITE)GFORMAT.i(b.text(), kidsIncoming(cl, r)));
/* 304 */     b.NL();
/*     */     
/* 306 */     if (!propagates(cl, r)) {
/* 307 */       b.sep();
/* 308 */       b.warn(¤¤noProp);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 313 */     b.NL(4);
/* 314 */     GText t = b.text();
/* 315 */     t.add(¤¤days);
/* 316 */     t.insert(0, r.info.namePosessive);
/* 317 */     t.insert(1, r.physics.babyDays);
/* 318 */     t.insert(2, r.physics.childDays);
/* 319 */     b.add((SPRITE)t);
/* 320 */     b.sep();
/*     */ 
/*     */ 
/*     */     
/* 324 */     (BOOSTABLES.PHYSICS()).REPRODUCTION_SPEED.hover(box, (BOOSTABLE_O)HCLASS_RACE.clP(r, cl), false);
/* 325 */     (BOOSTABLES.PHYSICS()).REPRODUCTION_AGE.hover(box, (BOOSTABLE_O)HCLASS_RACE.clP(r, cl), false);
/*     */     
/* 327 */     b.textLL(((STATS.POP()).POP.info()).name);
/* 328 */     b.tab(6);
/* 329 */     b.add((SPRITE)GFORMAT.i(b.text(), (STATS.POP()).POP.data(cl).get(r)));
/* 330 */     b.NL();
/* 331 */     b.textLL(¤¤fertile);
/* 332 */     b.tab(6);
/* 333 */     b.add((SPRITE)GFORMAT.i(b.text(), this.fertile.data(cl).get(r)));
/* 334 */     b.NL();
/* 335 */     b.textLL(¤¤estimated);
/* 336 */     b.tab(6);
/* 337 */     b.add((SPRITE)GFORMAT.f(b.text(), kidsPerYear(cl, r), 2));
/* 338 */     b.NL();
/* 339 */     b.sep();
/*     */     
/* 341 */     b.textLL(¤¤limit);
/* 342 */     b.NL();
/* 343 */     b.textLL(Dic.¤¤limit);
/* 344 */     b.tab(6);
/* 345 */     b.add((SPRITE)GFORMAT.i(b.text(), this.limit.get((MAPPED)HCLASS_RACE.clP(r, cl))));
/* 346 */     b.NL();
/*     */     
/* 348 */     b.textLL(Dic.¤¤Population);
/* 349 */     b.tab(6);
/* 350 */     b.add((SPRITE)GFORMAT.i(b.text(), -POP.tot(cl, r)));
/* 351 */     b.NL();
/*     */     
/* 353 */     b.textLL(Dic.¤¤Inbound);
/* 354 */     b.tab(6);
/* 355 */     b.add((SPRITE)GFORMAT.i(b.text(), -(POP.next(cl, r) - POP.tot(cl, r))));
/* 356 */     b.NL();
/*     */     
/* 358 */     b.textLL(Dic.¤¤Total);
/* 359 */     b.tab(6);
/* 360 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), newInfantsAllowed(cl, r)));
/* 361 */     b.NL();
/*     */     
/* 363 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 369 */     double tar = 0.1D;
/*     */ 
/*     */     
/* 372 */     for (int i = 0; i < 10; i++) {
/*     */       
/* 374 */       double[] vv = new double[1000];
/* 375 */       boolean[] repo = new boolean[vv.length];
/* 376 */       double ave = 0.0D;
/*     */       
/* 378 */       double fertiles = 0.0D;
/* 379 */       for (int ii = 0; ii < vv.length; ii++) {
/* 380 */         vv[ii] = RND.rFloat() * 2.0D * tar;
/* 381 */         repo[ii] = RND.rBoolean();
/* 382 */         ave += vv[ii];
/* 383 */         if (repo[ii])
/* 384 */           fertiles++; 
/*     */       } 
/* 386 */       ave /= vv.length;
/*     */ 
/*     */       
/* 389 */       double stored = 0.0D;
/* 390 */       double count = 0.0D;
/* 391 */       LOG.ln(Double.valueOf(ave));
/* 392 */       double babies = 0.0D;
/* 393 */       for (int y = 0; y < 10; y++) {
/*     */         
/* 395 */         for (int j = 0; j < vv.length; j++) {
/* 396 */           double r = vv[j];
/* 397 */           if (!repo[j]) {
/* 398 */             stored += r - ave;
/* 399 */             count++;
/* 400 */             if (count > 1000.0D) {
/* 401 */               stored /= 2.0D;
/* 402 */               count /= 2.0D;
/*     */             }
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 408 */             double dd = 1000.0D / fertiles;
/*     */             
/* 410 */             double extra = 1.5D * stored / (fertiles + 1.0D);
/* 411 */             if (extra > stored)
/* 412 */               extra = stored; 
/* 413 */             stored -= extra;
/* 414 */             extra = r * extra;
/* 415 */             r *= dd;
/*     */ 
/*     */             
/* 418 */             if (r >= 1.0D) {
/*     */               
/* 420 */               stored += r - 1.0D;
/* 421 */               babies++;
/* 422 */             } else if (RND.rFloat() <= r) {
/* 423 */               babies++;
/*     */             } 
/*     */           } 
/*     */         } 
/* 427 */       }  LOG.ln(" -> " + babies / 10.0D * vv.length + " " + babies / 10.0D * vv.length / ave + " " + stored);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReproduction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */