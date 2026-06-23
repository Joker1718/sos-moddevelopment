/*     */ package settlement.stats.law;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.arena.grand.ROOM_ARENA;
/*     */ import settlement.room.service.arena.pit.ROOM_FIGHTPIT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HISTORY_COLLECTION;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class StatsLaw
/*     */   extends StatCollection {
/*  43 */   private static CharSequence ¤¤name = "Law";
/*  44 */   private static CharSequence ¤¤descc = "Statistics regarding law";
/*  45 */   private static CharSequence ¤¤guardPower = "Guard Power";
/*  46 */   public static CharSequence ¤¤tyranny = "Tyranny";
/*  47 */   public static CharSequence ¤¤tyrannyD = "Tyranny is gained from punishing crimes harshly and is detrimental to happiness";
/*     */   
/*     */   public final LIST<StatCrime> crimes;
/*     */   
/*     */   public final LIST<StatPunishment> punishments;
/*     */   
/*     */   public final STAT guards;
/*     */   
/*     */   public final STAT executeArena;
/*     */   
/*     */   public final STAT EQUALITY;
/*     */   
/*     */   public final STAT EX_CON;
/*     */   
/*     */   public final STAT ESCAPED;
/*     */   final CrimesData cd;
/*     */   public final GETTER_TRANS.GETTER_TRANSE<Induvidual, CRIMES.CRIME> prisonerType;
/*     */   public double debug;
/*     */   public DOUBLE_O<HCLASS_RACE> tyranny;
/*     */   
/*     */   public StatsLaw(StatsInit init) {
/*  68 */     super(init, "LAW", ¤¤name, ¤¤descc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     D.ts(StatsLaw.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.debug = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 392 */     this.tyranny = new DOUBLE_O<HCLASS_RACE>() {
/*     */         protected double getDD(HCLASS cl, Race race) { double tot = 0.0D; double access = 0.0D; double rate = 0.0D; double rateTot = CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, null); for (ROOM_FIGHTPIT r : (SETT.ROOMS()).FIGHTPITS) { tot++; access += r.service().stats().access().data(cl).getD(race); for (Race race2 : RACES.all()) { if (r.punishEnabled().is(race2))
/* 394 */                 rate += CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, race2);  }  }  access /= tot; access *= CLAMP.d(4.0D * rate / rateTot, 0.0D, 1.0D); return access; } private final INFO info = new INFO(StatsLaw.¤¤tyranny, StatsLaw.¤¤tyrannyD); public void hover(GUI_BOX text, HCLASS cl, Race race) { GBox b = (GBox)text; b.textLL(Dic.¤¤Access); b.NL(); for (ROOM_FIGHTPIT r : (SETT.ROOMS()).FIGHTPITS) { b.add((SPRITE)r.icon); b.textLL(r.info.name); b.NL(); b.textLL(Dic.¤¤Access); b.tab(6); b.add((SPRITE)GFORMAT.perc(b.text(), r.service().stats().access().data(cl).getD(race))); b.NL(); double rateTot = CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, null); double rate = 0.0D; for (Race race2 : RACES.all()) { if (r.punishEnabled().is(race2)) { b.add((SPRITE)(race2.appearance()).icon); rate += CRIME_PUNISHMENTS.EXECUTE().stat().recent(null, race2); }  }  b.NL(); if (rateTot == 0.0D) { rate = 0.0D; } else { rate /= rateTot; }  b.textLL((CRIME_PUNISHMENTS.EXECUTE()).names); b.tab(6); GText t = b.text(); GFORMAT.perc(t, rate, 0); t.add('/'); GFORMAT.perc(t, 0.25D, 0); t.normalify(); b.add((SPRITE)t); b.NL(); }
/*     */            super.hover(text, cl, race); } }; (this.executeArena.info()).icon = (SPRITE)((ROOM_ARENA)(SETT.ROOMS()).GARENAS.get(0)).icon; this.guards = (STAT)new STATFakeData("GUARDS", init)
/*     */       {
/*     */         protected double getDD(HCLASS cl, Race race) { double pop = (STATS.POP()).POP.data().get(null); double g = (SETT.ROOMS()).GUARD.power.get() * 0.25D; if (pop <= 0.0D)
/* 398 */             return 0.0D;  g /= pop; g = Math.sqrt(g); g = CLAMP.d(g, 0.0D, 1.0D); return CLAMP.d(g + StatsLaw.this.debug, 0.0D, 1.0D); } public double getD(HCLASS_RACE hrace) { HCLASS cl = hrace.cl;
/* 399 */           Race race = hrace.race;
/* 400 */           return StatsLaw.this.tyrrany(cl, race); } public void hover(GUI_BOX text, HCLASS cl, Race type) { StatsLaw.this.hoverGuards(text, cl, type); super.hover(text, cl, type); }
/*     */       }; (this.guards.info()).icon = (SPRITE)(UI.icons()).s.sword; this.EQUALITY = (STAT)new STATFakeData("EQUALITY", init) { protected double getDD(HCLASS cl, Race r) { double t = 0.0D; for (Race rr : RACES.all()) { for (StatCrime c : crimes) t += (c.punishment(cl, rr)).punish.tyranny(cl, rr);  }  double d = 0.0D; for (StatCrime c : crimes)
/*     */             d += (c.punishment(cl, r)).punish.tyranny(cl, r);  if (d * 0.6D > t)
/*     */             return t / d;  return 1.0D; }
/*     */       }; final ArrayListGrower<StatCrime> crimes = new ArrayListGrower(); ArrayListGrower<StatPunishment> punishments = new ArrayListGrower(); this.cd = new CrimesData(init); for (CRIMES.CRIME c : CRIMES.ALL()) { if (c == CRIMES.PERSECUTED() || c == CRIMES.S_PLEASURE()) { crimes.add(new StatCrimePersecute(init, c, this.cd)); continue; }  crimes.add(new StatCrime(init, c, this.cd)); }  for (CRIME_PUNISHMENTS.PUNISHMENT c : CRIME_PUNISHMENTS.ALL())
/* 405 */       punishments.add(new StatPunishment(init, c));  this.crimes = (LIST<StatCrime>)crimes; this.punishments = (LIST<StatPunishment>)punishments; this.executeArena = (STAT)new STATFakeData("EXECUTE_ARENA", init) { public INFO info() { return this.info; } }
/*     */       ; (this.EQUALITY.info()).icon = (SPRITE)(UI.icons()).m.descrimination; this.EQUALITY.standing = new StatStanding(this.EQUALITY, 1.0D); this.ESCAPED = (STAT)new STATFakeData("ESCAPED", init) { protected double getDD(HCLASS cl, Race r) { return 250.0D * StatsLaw.this.escapees() / (STATS.POP()).POP.data().get(null); } }
/*     */       ; (this.ESCAPED.info()).icon = (SPRITE)(SETT.ROOMS()).STOCKADE.icon; init.count.getClass(); this.EX_CON = (STAT)new STATData("EX_CON", "EX_CON", init, (INT_O.INT_OE)new DataO.DataNibble(init.count, "EX_CON")); (this.EX_CON.info()).icon = (SPRITE)(UI.icons()).m.law; init.updatable.add(new StatsInit.StatUpdatableI() { public void update16(Humanoid h, int updateR, boolean day, int updateI) { if (day)
/*     */               StatsLaw.this.EX_CON.indu().inc(h.indu(), -1);  } }
/*     */       ); this.prisonerType = new GETTER_TRANS.GETTER_TRANSE<Induvidual, CRIMES.CRIME>(init) { final INT_O.INT_OE<Induvidual> data; public CRIMES.CRIME get(Induvidual f) { int i = this.data.get(f); if (i == 0)
/*     */             return null;  return (CRIMES.CRIME)CRIMES.ALL().get(i - 1); } public void set(Induvidual f, CRIMES.CRIME t) { if (f.hType() == HTYPES.PRISONER() && f.added() && get(f) != null) { (get(f).stat()).criminalsTot--; (get(f).stat()).criminals[f.race().index()] = (get(f).stat()).criminals[f.race().index()] - 1; StatsLaw.this.cd.count(f, -1); }
/*     */            this.data.set(f, t.index() + 1); if (f.hType() == HTYPES.PRISONER() && f.added()) { (get(f).stat()).criminalsTot++; (get(f).stat()).criminals[f.race().index()] = (get(f).stat()).criminals[f.race().index()] + 1; StatsLaw.this.cd.count(f, 1); }
/*     */            } };
/* 413 */   } public double tyrrany(HCLASS cl, Race race) { if (cl == null) {
/* 414 */       double tot = 0.0D;
/* 415 */       double v = 0.0D;
/* 416 */       for (int ci = 0; ci < HCLASSES.ALLP().size(); ci++) {
/* 417 */         HCLASS c = (HCLASS)HCLASSES.ALLP().get(ci);
/* 418 */         double pop = (STATS.POP()).POP.data(c).get(null);
/* 419 */         tot += pop;
/* 420 */         v += pop * tyrrany(c, null);
/*     */       } 
/* 422 */       if (tot == 0.0D)
/* 423 */         return 0.0D; 
/* 424 */       return v / tot;
/*     */     } 
/*     */ 
/*     */     
/* 428 */     if (race == null) {
/* 429 */       double tot = 0.0D;
/* 430 */       double v = 0.0D;
/* 431 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 432 */         Race r = (Race)RACES.all().get(ri);
/* 433 */         double pop = (STATS.POP()).POP.data(cl).get(r);
/* 434 */         tot += pop;
/* 435 */         v += pop * tyrrany(cl, r);
/*     */       } 
/* 437 */       if (tot == 0.0D)
/* 438 */         return 0.0D; 
/* 439 */       return v / tot;
/*     */     } 
/* 441 */     double am = 0.0D;
/* 442 */     for (int q = 0; q < CRIMES.all(cl).size(); q++) {
/* 443 */       int ci = ((CRIMES.CRIME)CRIMES.all(cl).get(q)).index();
/* 444 */       if (((StatCrime)this.crimes.get(ci)).crime != CRIMES.PERSECUTED())
/*     */       {
/* 446 */         am += ((StatCrime)this.crimes.get(ci)).tyrrany(cl, race); } 
/*     */     } 
/* 448 */     return am; }
/*     */ 
/*     */   
/*     */   public double lawMultiplier(HCLASS cl, Race race) {
/*     */     if (race == null) {
/*     */       double tot = 0.0D;
/*     */       double v = 0.0D;
/*     */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*     */         Race r = (Race)RACES.all().get(ri);
/*     */         double pop = (STATS.POP()).POP.data(cl).get(r);
/*     */         tot += pop;
/*     */         v += pop * lawMultiplier(cl, r);
/*     */       } 
/*     */       if (tot == 0.0D)
/*     */         return 0.0D; 
/*     */       return v / tot;
/*     */     } 
/*     */     double l = 0.0D;
/*     */     for (StatCrime c : this.crimes)
/*     */       l += c.law(cl, race); 
/*     */     return l;
/*     */   }
/*     */   
/*     */   public int criminals(HCLASS cl, Race race) {
/*     */     return this.cd.criminals(cl, race);
/*     */   }
/*     */   
/*     */   public void hoverGuards(GUI_BOX text, HCLASS cl, Race type) {
/*     */     GBox b = (GBox)text;
/*     */     b.add((SPRITE)(UI.icons()).s.shield);
/*     */     b.text(¤¤guardPower);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.f0(b.text(), (int)(SETT.ROOMS()).GUARD.power.get()));
/*     */     b.NL();
/*     */     b.text((HCLASSES.CITIZEN()).names);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.i(b.text(), (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(null)));
/*     */     b.NL();
/*     */     b.text((HCLASSES.SLAVE()).names);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.i(b.text(), (STATS.POP()).POP.data(HCLASSES.SLAVE()).get(null)));
/*     */     b.NL();
/*     */     b.text(Dic.¤¤Value);
/*     */     b.tab(6);
/*     */     GText tt = b.text();
/*     */     tt.add('s').add('q').add('r').add('t').add('(');
/*     */     tt.add(0.25D).add('*');
/*     */     tt.add((int)(SETT.ROOMS()).GUARD.power.get());
/*     */     tt.add('/');
/*     */     tt.add((STATS.POP()).POP.data().get(null));
/*     */     tt.add(')');
/*     */     tt.add('=');
/*     */     b.add((SPRITE)tt);
/*     */     b.add((SPRITE)GFORMAT.f(b.text(), this.guards.data().getD(null)));
/*     */     b.NL();
/*     */   }
/*     */   
/*     */   public double escapees() {
/*     */     return this.cd.escapedPrisoners;
/*     */   }
/*     */   
/*     */   public void escapeInc() {
/*     */     this.cd.escapedPrisoners++;
/*     */   }
/*     */   
/*     */   public double persecution(HCLASS cl, Race type) {
/*     */     StatCrimePersecute p = (StatCrimePersecute)CRIMES.PERSECUTED().stat();
/*     */     return p.value(cl, type);
/*     */   }
/*     */   
/*     */   public HISTORY_COLLECTION<HCLASS_RACE> crimeHistory() {
/*     */     return (HISTORY_COLLECTION<HCLASS_RACE>)this.cd.crimesComitted;
/*     */   }
/*     */   
/*     */   public Curfew getCurfew() {
/*     */     return this.cd.curfew;
/*     */   }
/*     */   
/*     */   public void punish(Induvidual i, CRIME_PUNISHMENTS.PUNISHMENT p) {
/*     */     CRIMES.CRIME c = (CRIMES.CRIME)this.prisonerType.get(i);
/*     */     HCLASS cl = c.cl;
/*     */     Race race = i.race();
/*     */     punish(c, cl, race, p);
/*     */   }
/*     */   
/*     */   public void punish(CRIMES.CRIME c, HCLASS cl, Race race, CRIME_PUNISHMENTS.PUNISHMENT p) {
/*     */     c.stat().punish(cl, race, p);
/*     */     p.stat().report(HCLASS_RACE.clP(race, cl));
/*     */   }
/*     */   
/*     */   public double lawHistory(HCLASS_RACE ra, int days) {
/*     */     return this.cd.history(ra, days);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatsLaw.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */