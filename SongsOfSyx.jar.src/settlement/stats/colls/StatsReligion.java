/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.race.Race;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.spirit.shrine.ROOM_SHRINE;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.service.StatService;
/*     */ import settlement.stats.stat.SETT_STATISTICS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.STATFakeRace;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.race.PERMISSION;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsReligion
/*     */   extends StatCollection
/*     */ {
/*  70 */   private static CharSequence ¤¤religion = "Religion";
/*  71 */   private static CharSequence ¤¤religionD = "Affiliated religion.";
/*     */   
/*  73 */   private static CharSequence ¤¤followers = "Followers";
/*  74 */   private static CharSequence ¤¤followersD = "The amount of followers for this religion.";
/*     */   
/*  76 */   private static CharSequence ¤¤access = "Access";
/*  77 */   private static CharSequence ¤¤accessD = "The Access of:";
/*     */   
/*  79 */   private static CharSequence ¤¤value = "Quality";
/*  80 */   private static CharSequence ¤¤valueD = "The quality of:";
/*     */ 
/*     */   
/*  83 */   private static CharSequence ¤¤Temple = "Temple";
/*  84 */   private static CharSequence ¤¤Shrine = "Shrine";
/*     */ 
/*     */   
/*  87 */   private static CharSequence ¤¤name = "Religion";
/*  88 */   private static CharSequence ¤¤desc = "Stats related to religion and afterlife."; private final ArrayList<StatReligion> religions; public final LIST<StatReligion> ALL; public final GETTER_TRANS.GETTER_TRANSE<Induvidual, StatReligion> getter; public final ReligionTot TEMPLE; public final ReligionTot SHRINE; public final STAT OPPOSITION; private double opCache; private int updateI;
/*     */   
/*     */   static {
/*  91 */     D.ts(StatsReligion.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StatsReligion(StatsInit init) {
/* 105 */     super(init, "RELIGION", ¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     this.opCache = 0.0D;
/* 310 */     this.updateI = -1; this.religions = new ArrayList(RELIGIONS.ALL().size()); this.TEMPLE = new ReligionTot(init, "TEMPLE", ¤¤Temple, (SPRITE)(UI.icons()).s.temple, (NEEDS.TYPES()).TEMPLE); this.SHRINE = new ReligionTot(init, "SHRINE", ¤¤Shrine, (SPRITE)(UI.icons()).s.shrine, (NEEDS.TYPES()).SHRINE); for (Religion t : RELIGIONS.ALL()) { this.religions.add(new StatReligion(t, init)); IDebugPanelSett.add("Convert to: " + t.key, new ACTION(t) { final Religion kk; public void exe() { (new EntityIterator.Humans() { protected boolean processAndShouldBreakH(Humanoid h, int ie) { (StatsReligion.null.access$0(StatsReligion.null.this)).getter.set(h.indu(), (StatsReligion.null.access$0(StatsReligion.null.this)).religions.get(StatsReligion.null.this.kk.index())); return false; } }
/*     */                 ).iterate(); } }
/*     */         ); }  this.ALL = (LIST<StatReligion>)this.religions; this.getter = new Getter(init); this.OPPOSITION = (STAT)new STATFakeRace("RELIGION_OPPOSITION", init) { protected double getDD(Race r) { return StatsReligion.this.opposition(); } public void hover(GUI_BOX text, HCLASS cl, Race type) { GBox b = (GBox)text; StatHoverer.hover(text, (STAT)this); b.sep(); for (int x = 0; x < StatsReligion.this.ALL.size(); x++) { b.tab(1 + x * 2); b.add(((StatsReligion.StatReligion)StatsReligion.this.ALL.get(x)).religion.icon.small); }  b.NL(4); for (int y = 0; y < StatsReligion.this.ALL.size(); y++) { StatsReligion.StatReligion r = (StatsReligion.StatReligion)StatsReligion.this.ALL.get(y); b.add(r.religion.icon.small); for (int i = 0; i < StatsReligion.this.ALL.size(); i++) { b.tab(1 + i * 2); if (r.opposition((StatsReligion.StatReligion)StatsReligion.this.ALL.get(i)) > 0.0D) { b.add((SPRITE)GFORMAT.f(b.text(), r.opposition((StatsReligion.StatReligion)StatsReligion.this.ALL.get(i))).errorify()); } else { b.add((SPRITE)GFORMAT.f(b.text(), r.opposition((StatsReligion.StatReligion)StatsReligion.this.ALL.get(i))).normalify()); }  }  b.NL(2); }  b.sep(); StatHoverer.hover(text, (STAT)this, cl, type); } }; this.OPPOSITION.info().setMatters(true, false); init.updatable.add(new StatsInit.StatUpdatableI() { public void update16(Humanoid h, int updateR, boolean day, int updateI) { if (day && RND.oneIn(8)) { double tot = 0.0D; for (StatsReligion.StatReligion r : StatsReligion.this.ALL) tot += r.religion.conversionCity.get((BOOSTABLE_O)h.indu());  if (tot <= 0.0D) return;  tot *= RND.rFloat(); for (StatsReligion.StatReligion r : StatsReligion.this.ALL) { tot -= r.religion.conversionCity.get((BOOSTABLE_O)h.indu()); if (tot <= 0.0D) { StatsReligion.this.getter.set(h.indu(), r); return; }  }  }  } }); BOOSTING.connecter(new ACTION() { public void exe() { KeyMap<StatsReligion.BB> map = new KeyMap(); for (int ri = 0; ri < RELIGIONS.ALL().size(); ri++) { Religion r = (Religion)RELIGIONS.ALL().get(ri); for (int bi = 0; bi < r.boosts.all().size(); bi++) { BoostSpec s = (BoostSpec)r.boosts.all().get(bi); String k = s.identifier(); if ((s.boostable.cat.typeMask & 0x4) != 0 && !map.containsKey(k)) { StatsReligion.BB b = new StatsReligion.BB(s.boostable, s.booster.isMul); StatsReligion.this.TEMPLE.TOTAL.boosters.push(b, s.boostable); map.put(k, b); }  }  }  } }); for (Religion r : RELIGIONS.ALL()) conBoost(r);  init.onArrivalActions.add(new ACTION.ACTION_O<Induvidual>() { public void exe(Induvidual t) { set(t, StatsReligion.this.TEMPLE); set(t, StatsReligion.this.SHRINE); } private void set(Induvidual t, StatsReligion.ReligionTot tt) { StatsReligion.StatReligion r = (StatsReligion.StatReligion)StatsReligion.this.getter.get(t); double d = tt.access(r.religion).data(t.clas()).getD(t.race()); d *= tt.ACCESS.indu().max(t); int v = (int)d; if (d - v > RND.rFloat()) v++;  int a = v; if (a > tt.ACCESS.indu().max(t)) a = tt.ACCESS.indu().max(t);  double q = tt.quality(r.religion).data(t.clas()).getD(t.race()); tt.ACCESS.indu().set(t, a); tt.QUALITY.indu().setD(t, (a > 0) ? q : 0.0D); } });
/* 313 */   } private double opposition() { if (this.updateI == GAME.updateI()) {
/* 314 */       return this.opCache;
/*     */     }
/* 316 */     double pop = (STATS.POP()).POP.data().get(null);
/* 317 */     if (pop == 0.0D)
/* 318 */       return 1.0D; 
/* 319 */     double v = 0.0D;
/* 320 */     for (int ri = 0; ri < this.religions.size(); ri++) {
/* 321 */       double vv = 0.0D;
/* 322 */       StatReligion r = (StatReligion)this.religions.get(ri);
/* 323 */       for (int ri2 = 0; ri2 < this.religions.size(); ri2++) {
/* 324 */         StatReligion r2 = (StatReligion)this.religions.get(ri2);
/* 325 */         double am = r2.followers.data().get(null) / pop;
/* 326 */         am *= r.opposition(r2);
/* 327 */         vv += am;
/*     */       } 
/* 329 */       v += vv * r.followers.data().get(null);
/*     */     } 
/* 331 */     v /= pop;
/* 332 */     this.opCache = CLAMP.d(v, 0.0D, 1.0D);
/* 333 */     this.updateI = GAME.updateI();
/* 334 */     return this.opCache; }
/*     */ 
/*     */   
/*     */   private final class Getter
/*     */     implements GETTER_TRANS.GETTER_TRANSE<Induvidual, StatReligion>, StatsInit.Addable
/*     */   {
/*     */     private final INT_O.INT_OE<Induvidual> ii;
/* 341 */     private final INFO info = new INFO(StatsReligion.¤¤religion, StatsReligion.¤¤religionD);
/*     */     
/*     */     Getter(StatsInit init) {
/* 344 */       init.count.getClass(); this.ii = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "REL_ID");
/* 345 */       init.addable.add(this);
/* 346 */       init.onConstruct.add(new StatsInit.StatInitable()
/*     */           {
/*     */             
/*     */             public void init(Induvidual h)
/*     */             {
/* 351 */               double d = 0.0D;
/* 352 */               for (StatsReligion.StatReligion re : (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL) {
/* 353 */                 d += re.religion.conversionCity.get((BOOSTABLE_O)h);
/*     */               }
/* 355 */               d *= RND.rFloat();
/* 356 */               for (StatsReligion.StatReligion re : (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL) {
/* 357 */                 d -= re.religion.conversionCity.get((BOOSTABLE_O)h);
/* 358 */                 if (d <= 0.0D) {
/* 359 */                   (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).getter.set(h, re);
/*     */                   return;
/*     */                 } 
/*     */               } 
/* 363 */               (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).getter.set(h, (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL.get((StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL.size() - 1));
/*     */             }
/*     */           });
/*     */       
/* 367 */       init.copier.add(new INT_O.INT_OE<Induvidual>()
/*     */           {
/*     */             public int get(Induvidual t)
/*     */             {
/* 371 */               return StatsReligion.Getter.this.ii.get(t);
/*     */             }
/*     */ 
/*     */             
/*     */             public int min(Induvidual t) {
/* 376 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Induvidual t) {
/* 381 */               return 127;
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(Induvidual t, int i) {
/* 386 */               StatsReligion.Getter.this.set(t, (StatsReligion.StatReligion)(StatsReligion.Getter.access$2(StatsReligion.Getter.this)).religions.get(i));
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public StatsReligion.StatReligion get(Induvidual f) {
/* 394 */       return (StatsReligion.StatReligion)StatsReligion.this.religions.get(this.ii.get(f));
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(Induvidual f, StatsReligion.StatReligion t) {
/* 399 */       if (this.ii.get(f) == t.index())
/*     */         return; 
/* 401 */       StatsReligion.this.TEMPLE.clearAccess(f);
/* 402 */       StatsReligion.this.SHRINE.clearAccess(f);
/* 403 */       removeH(f);
/* 404 */       this.ii.set(f, t.index());
/* 405 */       addH(f);
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 410 */       return this.info;
/*     */     }
/*     */ 
/*     */     
/*     */     public void addPrivate(Induvidual i) {
/* 415 */       StatsReligion.StatReligion r = get(i);
/* 416 */       r.followers.inc(i, 1);
/* 417 */       StatsReligion.this.TEMPLE.access(r.religion).inc(i, StatsReligion.this.TEMPLE.ACCESS.indu().get(i));
/* 418 */       StatsReligion.this.TEMPLE.quality(r.religion).inc(i, StatsReligion.this.TEMPLE.QUALITY.indu().get(i));
/* 419 */       StatsReligion.this.SHRINE.access(r.religion).inc(i, StatsReligion.this.SHRINE.ACCESS.indu().get(i));
/* 420 */       StatsReligion.this.SHRINE.quality(r.religion).inc(i, StatsReligion.this.SHRINE.QUALITY.indu().get(i));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void removePrivate(Induvidual i) {
/* 426 */       StatsReligion.StatReligion r = get(i);
/* 427 */       r.followers.inc(i, -1);
/* 428 */       StatsReligion.this.TEMPLE.access(r.religion).inc(i, -StatsReligion.this.TEMPLE.ACCESS.indu().get(i));
/* 429 */       StatsReligion.this.TEMPLE.quality(r.religion).inc(i, -StatsReligion.this.TEMPLE.QUALITY.indu().get(i));
/* 430 */       StatsReligion.this.SHRINE.access(r.religion).inc(i, -StatsReligion.this.SHRINE.ACCESS.indu().get(i));
/* 431 */       StatsReligion.this.SHRINE.quality(r.religion).inc(i, -StatsReligion.this.SHRINE.QUALITY.indu().get(i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final class StatReligion
/*     */     implements INDEXED
/*     */   {
/*     */     public final Religion religion;
/*     */     
/*     */     public final INFO info;
/*     */     
/*     */     public final SETT_STATISTICS.SettStatistics followers;
/* 444 */     public final PERMISSION.Permission permissionTemple = new PERMISSION.Permission();
/* 445 */     public final PERMISSION.Permission permissionShrine = new PERMISSION.Permission();
/*     */     
/*     */     StatReligion(Religion religion, StatsInit init) {
/* 448 */       this.religion = religion;
/*     */ 
/*     */ 
/*     */       
/* 452 */       this.info = religion.info;
/* 453 */       this.permissionTemple.setDef(true);
/* 454 */       this.permissionShrine.setDef(true);
/* 455 */       String k = "REL_" + String.valueOf(religion) + "_";
/* 456 */       this.followers = new SETT_STATISTICS.SettStatistics(k + "F", init, StatsReligion.¤¤followers, StatsReligion.¤¤followersD);
/*     */       
/* 458 */       for (HCLASS s : HCLASSES.ALL()) {
/* 459 */         this.permissionTemple.set(s, null, true);
/* 460 */         this.permissionShrine.set(s, null, true);
/*     */       } 
/* 462 */       init.savers.put(k + "PERM", this.permissionTemple);
/* 463 */       init.savers.put(k + "PERMS", this.permissionShrine);
/*     */     }
/*     */ 
/*     */     
/*     */     public double opposition(StatReligion other) {
/* 468 */       return this.religion.opposition(other.religion);
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 473 */       return this.religion.index();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class BB
/*     */     extends Booster
/*     */     implements BValue
/*     */   {
/* 482 */     private final Booster[] vv = new Booster[RELIGIONS.ALL().size()];
/*     */     private final double min;
/*     */     private final double max;
/*     */     private final double aa;
/*     */     
/*     */     public BB(Boostable bb, boolean isMul) {
/* 488 */       super(new BSourceInfo(Dic.¤¤Religion, (SPRITE)(UI.icons()).s.star), isMul);
/*     */       
/* 490 */       double min = Double.MAX_VALUE;
/* 491 */       double max = Double.MIN_VALUE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 496 */       this.aa = (isMul ? true : false);
/*     */       
/* 498 */       for (Religion r : RELIGIONS.ALL()) {
/* 499 */         for (BoostSpec s : r.boosts.all()) {
/*     */           
/* 501 */           if (s.boostable == bb && s.booster.isMul == isMul && (s.boostable.cat.typeMask & 0x4) != 0) {
/* 502 */             this.vv[r.index()] = s.booster;
/*     */             
/* 504 */             min = Math.min(min, s.booster.from());
/* 505 */             max = Math.max(max, s.booster.to());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 510 */       this.min = min;
/* 511 */       this.max = max;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 518 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 523 */       return vv(((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(indu)).religion, (STATS.RELIGION()).TEMPLE.TOTAL.indu().getD(indu));
/*     */     }
/*     */     
/*     */     private double vv(Religion rel, double v) {
/* 527 */       if (this.vv[rel.index()] == null)
/* 528 */         return this.aa; 
/* 529 */       return this.vv[rel.index()].getValue(v);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 534 */       double dd = 0.0D;
/* 535 */       for (int ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 536 */         StatsReligion.StatReligion rl = (StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(ri);
/* 537 */         double v = StatsReligion.this.TEMPLE.access(rl.religion).div().getD(div) * StatsReligion.this.TEMPLE.quality(rl.religion).div().getD(div);
/* 538 */         dd += vv(rl.religion, v) * rl.followers.div().getD(div);
/*     */       } 
/*     */       
/* 541 */       return dd;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE popTime) {
/* 546 */       double dd = 0.0D;
/* 547 */       for (int ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 548 */         StatsReligion.StatReligion rl = (StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(ri);
/* 549 */         double v = StatsReligion.this.TEMPLE.access(rl.religion).data(popTime.cl).getD(popTime.race, 0) * StatsReligion.this.TEMPLE.quality(rl.religion).data(popTime.cl).getD(popTime.race, 0);
/* 550 */         dd += vv(rl.religion, v) * rl.followers.data(popTime.cl).getD(popTime.race, 0);
/*     */       } 
/* 552 */       return dd;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 557 */       return vGet(HCLASS_RACE.clP());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 562 */       if (f.court().king() == null || f.court().king().roy() == null)
/* 563 */         return 0.0D; 
/* 564 */       return vv(((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get((f.court().king().roy()).induvidual)).religion, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getValue(double input) {
/* 569 */       return CLAMP.d(input, this.min, this.max);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double pget(BOOSTABLE_O o) {
/* 574 */       return o.boostableValue(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public double from() {
/* 579 */       return this.min;
/*     */     }
/*     */ 
/*     */     
/*     */     public double to() {
/* 584 */       return this.max;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ReligionTot
/*     */     extends StatService
/*     */   {
/*     */     public final STAT TOTAL;
/*     */     
/*     */     public final STAT ACCESS;
/*     */     
/*     */     public final STAT QUALITY;
/*     */     
/* 598 */     private final SETT_STATISTICS.SettStatistics[] accesses = new SETT_STATISTICS.SettStatistics[RELIGIONS.ALL().size()];
/* 599 */     private final SETT_STATISTICS.SettStatistics[] qualities = new SETT_STATISTICS.SettStatistics[RELIGIONS.ALL().size()];
/*     */     
/*     */     ReligionTot(StatsInit init, String key, CharSequence name, SPRITE icon, NEED need) {
/* 602 */       super(name, name, icon, need);
/*     */       
/* 604 */       this.TOTAL = (STAT)new STATFake(key, init)
/*     */         {
/*     */           protected double getDD(HCLASS s, Race r, int daysBack)
/*     */           {
/* 608 */             double a = StatsReligion.ReligionTot.this.ACCESS.data(s).getD(r, daysBack);
/* 609 */             double q = StatsReligion.ReligionTot.this.QUALITY.data(s).getD(r, daysBack);
/* 610 */             return a * (0.2D + 0.8D * q);
/*     */           }
/*     */ 
/*     */           
/*     */           protected double induGet(Induvidual t) {
/* 615 */             return StatsReligion.ReligionTot.this.ACCESS.indu().get(t) * StatsReligion.ReligionTot.this.QUALITY.indu().getD(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 620 */             StatHoverer.hover(text, (STAT)this);
/* 621 */             GBox b = (GBox)text;
/* 622 */             b.sep();
/*     */             
/* 624 */             b.textL((StatsReligion.ReligionTot.this.ACCESS.info()).name);
/* 625 */             b.tab(6);
/* 626 */             b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.ACCESS.data(cl).getD(type)));
/* 627 */             b.NL();
/* 628 */             b.textL((StatsReligion.ReligionTot.this.QUALITY.info()).name);
/* 629 */             b.tab(6);
/* 630 */             b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.QUALITY.data(cl).getD(type)));
/* 631 */             b.sep();
/*     */             
/* 633 */             StatHoverer.hover(text, (STAT)this, cl, type);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, Induvidual indu) {
/* 638 */             StatHoverer.hover(text, (STAT)this);
/* 639 */             GBox b = (GBox)text;
/* 640 */             b.sep();
/*     */             
/* 642 */             b.textL((StatsReligion.ReligionTot.this.ACCESS.info()).name);
/* 643 */             b.tab(6);
/* 644 */             b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.ACCESS.indu().getD(indu)));
/* 645 */             b.NL();
/* 646 */             b.textL((StatsReligion.ReligionTot.this.QUALITY.info()).name);
/* 647 */             b.tab(6);
/* 648 */             b.add((SPRITE)GFORMAT.perc(b.text(), StatsReligion.ReligionTot.this.QUALITY.indu().getD(indu)));
/* 649 */             b.sep();
/*     */             
/* 651 */             StatHoverer.hover(text, (STAT)this, indu);
/*     */           }
/*     */         };
/*     */       
/* 655 */       (this.TOTAL.info()).icon = icon;
/*     */       
/* 657 */       this.ACCESS = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO<Induvidual>.DataBit(init.count, key + "ACCESS")
/*     */           {
/*     */             public void set(Induvidual t, int s)
/*     */             {
/* 661 */               StatsReligion.StatReligion r = (StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(t);
/* 662 */               StatsReligion.ReligionTot.this.accesses[r.index()].inc(t, -get(t));
/* 663 */               super.set(t, s);
/* 664 */               StatsReligion.ReligionTot.this.accesses[r.index()].inc(t, get(t));
/* 665 */               if (get(t) == 0) {
/* 666 */                 StatsReligion.ReligionTot.this.QUALITY.indu().set(t, 0);
/*     */ 
/*     */               
/*     */               }
/*     */             }
/* 671 */           }new StatInfo(StatsReligion.¤¤access, StatsReligion.¤¤access, String.valueOf(StatsReligion.¤¤accessD) + " " + String.valueOf(StatsReligion.¤¤accessD)));
/*     */       
/* 673 */       this.QUALITY = (STAT)new STATData(null, key + "_QUALITY", init, (INT_O.INT_OE)new DataO<Induvidual>.DataNibble1(init.count, key + "_QUALITY")
/*     */           {
/*     */             public void set(Induvidual t, int s) {
/* 676 */               if (StatsReligion.ReligionTot.this.ACCESS.indu().get(t) == 0)
/* 677 */                 s = 0; 
/* 678 */               StatsReligion.StatReligion r = (StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(t);
/* 679 */               StatsReligion.ReligionTot.this.qualities[r.index()].inc(t, -get(t));
/* 680 */               super.set(t, s);
/* 681 */               StatsReligion.ReligionTot.this.qualities[r.index()].inc(t, get(t));
/*     */             }
/* 687 */           }new StatInfo(StatsReligion.¤¤value, StatsReligion.¤¤value, String.valueOf(StatsReligion.¤¤valueD) + " " + String.valueOf(StatsReligion.¤¤valueD)))
/*     */         {
/*     */           public int pdivider(HCLASS c, Race r, int daysback)
/*     */           {
/* 691 */             return StatsReligion.ReligionTot.this.ACCESS.data(c).get(r, daysback);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 697 */       for (Religion t : RELIGIONS.ALL()) {
/* 698 */         this.accesses[t.index()] = new SETT_STATISTICS.SettStatistics(key + "_" + key + "_A", init, StatsReligion.¤¤access, String.valueOf(StatsReligion.¤¤accessD) + " " + String.valueOf(StatsReligion.¤¤accessD))
/*     */           {
/*     */             protected int popDivider(HCLASS c, Race r, int daysback) {
/* 701 */               return ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(t.index())).followers.data(c).get(r, daysback);
/*     */             }
/*     */           };
/* 704 */         this.qualities[t.index()] = new SETT_STATISTICS.SettStatistics(key + "_" + key + "_Q", init, StatsReligion.¤¤value, String.valueOf(StatsReligion.¤¤valueD) + " " + String.valueOf(StatsReligion.¤¤valueD))
/*     */           {
/*     */             protected int popDivider(HCLASS c, Race r, int daysback) {
/* 707 */               return StatsReligion.ReligionTot.this.accesses[t.index()].data(c).get(r, daysback);
/*     */             }
/*     */ 
/*     */             
/*     */             public int dataDivider() {
/* 712 */               return StatsReligion.ReligionTot.this.QUALITY.indu().max(null);
/*     */             }
/*     */           };
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public SETT_STATISTICS.SettStatistics access(Religion r) {
/* 721 */       return this.accesses[r.index()];
/*     */     }
/*     */     
/*     */     public SETT_STATISTICS.SettStatistics quality(Religion r) {
/* 725 */       return this.qualities[r.index()];
/*     */     }
/*     */     
/*     */     public void clearAccess(Humanoid h) {
/* 729 */       this.ACCESS.indu().set(h.indu(), 0);
/* 730 */       this.QUALITY.indu().set(h.indu(), 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clearAccess(Induvidual h) {
/* 735 */       this.ACCESS.indu().set(h, 0);
/* 736 */       this.QUALITY.indu().set(h, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setAccess(Humanoid h) {
/* 741 */       Room r = (Room)(SETT.ROOMS()).map.get(h.tc());
/* 742 */       if (r != null && r instanceof ROOM_SERVICER) {
/* 743 */         ROOM_SERVICER t = (ROOM_SERVICER)r;
/* 744 */         this.ACCESS.indu().set(h.indu(), 1);
/* 745 */         this.QUALITY.indu().setD(h.indu(), t.quality());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean access(Humanoid h) {
/* 751 */       return (this.ACCESS.indu().get(h.indu()) > 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public STAT total() {
/* 756 */       return this.TOTAL;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name(Induvidual i) {
/* 761 */       StatsReligion.StatReligion r = (StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(i);
/* 762 */       if (this.need == (NEEDS.TYPES()).TEMPLE) {
/* 763 */         if (((LIST)(SETT.ROOMS()).TEMPLES.perRel.get(r.index())).size() > 0) {
/* 764 */           return ((ROOM_TEMPLE)((LIST)(SETT.ROOMS()).TEMPLES.perRel.get(r.index())).get(0)).info.name;
/*     */         }
/*     */       }
/* 767 */       else if (((LIST)(SETT.ROOMS()).TEMPLES.perRelShrine.get(r.index())).size() > 0) {
/* 768 */         return ((ROOM_SHRINE)((LIST)(SETT.ROOMS()).TEMPLES.perRelShrine.get(r.index())).get(0)).info.name;
/*     */       } 
/*     */       
/* 771 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE icon(Induvidual i) {
/* 776 */       return (SPRITE)((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(i)).religion.icon;
/*     */     }
/*     */ 
/*     */     
/*     */     public void cheatSetTotal(Induvidual i, double tot) {
/* 781 */       this.ACCESS.indu().set(i, (tot > 0.0D) ? 1 : 0);
/* 782 */       this.QUALITY.indu().setD(i, tot);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void conBoost(Religion rel) {
/* 793 */     for (ROOM_TEMPLE r : (SETT.ROOMS()).TEMPLES.perRel.get(rel.index())) {
/*     */       
/* 795 */       BSourceInfo in = new BSourceInfo(r.info.name, (SPRITE)r.icon);
/* 796 */       (new BoosterImp(in, 4.0D, false)
/*     */         {
/*     */           
/*     */           public double vGet(Induvidual indu)
/*     */           {
/* 801 */             if (r.service().total() > 0)
/* 802 */               return 1.0D; 
/* 803 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(HCLASS_RACE popT) {
/* 808 */             if (r.service().total() > 0)
/* 809 */               return 1.0D; 
/* 810 */             return 0.0D;
/*     */           }
/* 812 */         }).add(rel.conversionCity);
/*     */     } 
/*     */ 
/*     */     
/* 816 */     for (ROOM_SHRINE r : (SETT.ROOMS()).TEMPLES.perRelShrine.get(rel.index())) {
/*     */       
/* 818 */       BSourceInfo in = new BSourceInfo(r.info.name, (SPRITE)r.icon);
/* 819 */       (new BoosterImp(in, 4.0D, false)
/*     */         {
/*     */           public double vGet(Induvidual indu) {
/* 822 */             if (r.service().total() > 0)
/* 823 */               return 1.0D; 
/* 824 */             return 0.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(HCLASS_RACE popT) {
/* 829 */             if (r.service().total() > 0)
/* 830 */               return 1.0D; 
/* 831 */             return 0.0D;
/*     */           }
/* 833 */         }).add(rel.conversionCity);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReligion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */