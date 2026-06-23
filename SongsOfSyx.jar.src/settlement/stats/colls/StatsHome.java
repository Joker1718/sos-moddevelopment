/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.race.home.RaceHomeClass;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class StatsHome extends StatCollection {
/*  48 */   private static CharSequence ¤¤desc = "¤This subject's place of residence.";
/*  49 */   private static CharSequence ¤¤name = "Housing";
/*  50 */   private static CharSequence ¤¤descc = "Housing related stats."; public final StatHome GETTER;
/*     */   
/*     */   static {
/*  53 */     D.ts(StatsHome.class);
/*     */   }
/*     */ 
/*     */   
/*  57 */   private final ArrayList<RMapInt.RMapIntTwo<HCLASS, Race>> targets = new ArrayList(RESOURCES.ALL().size());
/*     */   
/*     */   private final LIST<StatFurniture> currents;
/*     */   
/*     */   public final STAT materials;
/*     */   
/*  63 */   private final ArrayList<StatFurniture> tmp = new ArrayList(8);
/*     */ 
/*     */   
/*     */   public StatsHome(StatsInit init) {
/*  67 */     super(init, "HOME", ¤¤name, ¤¤descc);
/*  68 */     this.GETTER = new StatHome(init);
/*     */     
/*  70 */     for (int i = 0; i < RESOURCES.ALL().size(); i++) {
/*  71 */       this.targets.add(new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map()));
/*     */     }
/*     */     
/*  74 */     ArrayList<StatFurniture> cc = new ArrayList(8);
/*  75 */     while (cc.hasRoom()) {
/*  76 */       StatFurniture ss = new StatFurniture(cc.size(), init);
/*  77 */       cc.add(ss);
/*     */     } 
/*     */     
/*  80 */     this.currents = (LIST<StatFurniture>)cc;
/*     */     
/*  82 */     this.materials = (STAT)new STATFake("FURNITURE", init)
/*     */       {
/*     */         protected double getDD(HCLASS s, Race r, int daysBack)
/*     */         {
/*  86 */           double am = 0.0D;
/*  87 */           for (StatsHome.StatFurniture ss : StatsHome.this.currents)
/*  88 */             am += ss.current.data(s).get(r); 
/*  89 */           double div = pdivider(s, r, daysBack);
/*  90 */           if (div == 0.0D)
/*  91 */             return 0.0D; 
/*  92 */           return am / div;
/*     */         }
/*     */ 
/*     */         
/*     */         public double induGet(Induvidual t) {
/*  97 */           double am = 0.0D;
/*  98 */           for (StatsHome.StatFurniture ss : StatsHome.this.currents) {
/*  99 */             am += ss.current.indu().get(t);
/*     */           }
/* 101 */           double max = 0.0D;
/* 102 */           RaceHomeClass cc = t.race().home().clas(t.clas());
/* 103 */           for (RES_AMOUNT a : cc.resources())
/* 104 */             max += a.amount(); 
/* 105 */           if (max == 0.0D)
/* 106 */             return 1.0D; 
/* 107 */           return am / max;
/*     */         }
/*     */         
/*     */         public int dataDivider() {
/* 111 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int pdivider(HCLASS c, Race r, int daysback) {
/* 116 */           if (r == null) {
/* 117 */             int am = 0;
/* 118 */             for (Race rr : RACES.all()) {
/* 119 */               am += pdivider(c, rr, daysback);
/*     */             }
/* 121 */             return am;
/*     */           } 
/* 123 */           if (r == null || r.home() == null)
/* 124 */             throw new RuntimeException(String.valueOf(c) + " " + String.valueOf(c) + " " + String.valueOf(r)); 
/* 125 */           RaceHomeClass cc = r.home().clas(c);
/* 126 */           if (cc == null)
/* 127 */             return (STATS.POP()).POP.data(c).get(r); 
/* 128 */           return cc.amountTotal() * (STATS.POP()).POP.data(c).get(r);
/*     */         }
/*     */       };
/* 131 */     (this.materials.info()).icon = (SPRITE)(UI.icons()).m.furniture;
/*     */ 
/*     */     
/* 134 */     init.savers.put("HOME_F_TARGETS", new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 138 */             RESOURCES.map().saver().save((LIST)StatsHome.this.targets, file);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 143 */             RESOURCES.map().loader().load((LIST)StatsHome.this.targets, file);
/*     */           }
/*     */ 
/*     */           
/*     */           public void clear() {
/* 148 */             for (RMapInt.RMapIntTwo<HCLASS, Race> t : StatsHome.this.targets) {
/* 149 */               t.clear();
/*     */             }
/*     */           }
/*     */         });
/* 153 */     init.updatable.add(new StatsInit.StatUpdatableI()
/*     */         {
/*     */           
/*     */           public void update16(Humanoid h, int updateR, boolean day, int updateI)
/*     */           {
/* 158 */             double wearRateI = StatsHome.this.rate(h.indu()) / 16.0D;
/* 159 */             Induvidual i = h.indu();
/*     */             
/* 161 */             HOME home = StatsHome.this.GETTER.get(h.indu(), this);
/* 162 */             if (home != null) {
/* 163 */               wearRateI *= 1.0D + CLAMP.d((1.0D - home.isolation()) * 2.0D, 0.0D, 1.0D);
/*     */             }
/*     */             
/* 166 */             if (RND.rFloat() < wearRateI) {
/* 167 */               for (int ri = 0; ri < StatsHome.this.currents.size(); ri++) {
/* 168 */                 ((StatsHome.StatFurniture)StatsHome.this.currents.get(ri)).update(i);
/*     */               }
/*     */             }
/*     */           }
/*     */         });
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
/*     */   
/*     */   public LIST<StatFurniture> getTmp(Induvidual i) {
/* 187 */     return getTmp(i.clas(), i.race());
/*     */   }
/*     */   
/*     */   public StatFurniture furniture(int i) {
/* 191 */     return (StatFurniture)this.currents.get(i);
/*     */   }
/*     */   
/*     */   public LIST<StatFurniture> getTmp(HCLASS cl, Race ra) {
/* 195 */     LIST<RES_AMOUNT> li = ra.home().clas(cl).resources();
/* 196 */     this.tmp.clearSloppy();
/* 197 */     for (int i = 0; i < li.size(); i++) {
/* 198 */       this.tmp.add(this.currents.get(i));
/*     */     }
/* 200 */     return (LIST<StatFurniture>)this.tmp;
/*     */   }
/*     */   
/*     */   public double rate(Induvidual i) {
/* 204 */     return CLAMP.d(0.25D / (BOOSTABLES.CIVICS()).FURNITURE.get((BOOSTABLE_O)i), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public double rate(HCLASS cl, Race ra) {
/* 208 */     return CLAMP.d(0.25D / (BOOSTABLES.CIVICS()).FURNITURE.get((BOOSTABLE_O)HCLASS_RACE.clP(ra, cl)), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public int current(Humanoid h, int rI) {
/* 212 */     return ((StatFurniture)this.currents.get(rI)).current.indu().get(h.indu());
/*     */   }
/*     */   
/*     */   public int current(HCLASS c, Race type, int resI) {
/* 216 */     if (type == null) {
/* 217 */       RES_AMOUNT ra = (RES_AMOUNT)RACES.res().homeResMax(c).get(resI);
/* 218 */       if (ra == null)
/* 219 */         return 0; 
/* 220 */       int m = 0;
/* 221 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 222 */         int i = 0;
/* 223 */         for (RES_AMOUNT rr : ((Race)RACES.all().get(ri)).home().clas(c).resources()) {
/*     */ 
/*     */           
/* 226 */           if (rr.resource() == ra.resource()) {
/* 227 */             m += ((StatFurniture)this.currents.get(i)).current.data(c).get(RACES.all().get(ri));
/*     */           }
/* 229 */           i++;
/*     */         } 
/*     */       } 
/* 232 */       return m;
/*     */     } 
/* 234 */     return ((StatFurniture)this.currents.get(resI)).current.data(c).get(type);
/*     */   }
/*     */   
/*     */   public int needed(HCLASS c, Race type, int resI) {
/* 238 */     if (type == null) {
/* 239 */       RES_AMOUNT ra = (RES_AMOUNT)RACES.res().homeResMax(c).get(resI);
/* 240 */       int m = 0;
/* 241 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 242 */         type = (Race)RACES.all().get(ri);
/* 243 */         m += type.home().clas(c).amount(ra.resource()) * this.GETTER.stat().data(c).get(type);
/*     */       } 
/* 245 */       return m;
/*     */     } 
/* 247 */     return ((RES_AMOUNT)type.home().clas(c).resources().get(resI)).amount() * this.GETTER.stat().data(c).get(type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int max(HCLASS c, Race type, RESOURCE res) {
/* 253 */     return type.home().clas(c).amount(res);
/*     */   }
/*     */   
/*     */   public int target(Humanoid h, RESOURCE res) {
/* 257 */     return target(h.indu().clas(), h.indu().race(), res);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int target(HCLASS c, Race type, RESOURCE res) {
/* 286 */     if (type == null) {
/* 287 */       int m = 0;
/* 288 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 289 */         Race r = (Race)RACES.all().get(ri);
/* 290 */         m = Math.max(m, target(c, r, res));
/*     */       } 
/* 292 */       return m;
/*     */     } 
/* 294 */     return CLAMP.i(((RMapInt.RMapIntTwo)this.targets.get(res.index())).get((MAPPED)c).get((MAPPED)type), 0, max(c, type, res));
/*     */   }
/*     */   
/*     */   public void dump(Humanoid a) {
/* 298 */     HOME home = (STATS.HOME()).GETTER.get(a, this);
/* 299 */     Induvidual i = a.indu();
/* 300 */     for (StatFurniture e : STATS.HOME().getTmp(i)) {
/* 301 */       int toDump = -e.needed(a.indu());
/* 302 */       if (toDump > 0) {
/* 303 */         e.inc(i, -toDump);
/* 304 */         if (home != null) {
/* 305 */           (SETT.THINGS()).resources.create(home.serviceX(), home.serviceY(), e.resource(i), toDump); continue;
/*     */         } 
/* 307 */         (SETT.THINGS()).resources.create(a.physics.tileC(), e.resource(i), toDump);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void targetSet(int target, HCLASS c, Race type, RESOURCE res) {
/* 314 */     if (type == null) {
/* 315 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 316 */         Race r = (Race)RACES.all().get(ri);
/* 317 */         targetSet(target, c, r, res);
/*     */       } 
/*     */       return;
/*     */     } 
/* 321 */     target = CLAMP.i(target, 0, max(c, type, res));
/* 322 */     ((RMapInt.RMapIntTwo)this.targets.get(res.index())).get((MAPPED)c).set((MAPPED)type, target);
/*     */   }
/*     */   
/*     */   public final class StatFurniture
/*     */     implements WearableResource {
/*     */     private final int resI;
/*     */     public final STATData current;
/*     */     private final INT_O.INT_OE<Induvidual> counter;
/*     */     
/*     */     StatFurniture(int resI, StatsInit init) {
/* 332 */       this.resI = resI;
/* 333 */       this.current = new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "HOME_FURNITURE" + resI));
/* 334 */       this.counter = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "HOME_FCOUNTER" + resI);
/*     */     }
/*     */     
/*     */     void update(Induvidual i) {
/* 338 */       int am = this.current.indu().get(i) - (this.counter.get(i) >> 4);
/* 339 */       if (am > 0) {
/* 340 */         this.counter.inc(i, am);
/*     */       }
/*     */     }
/*     */     
/*     */     public RESOURCE resource(Induvidual i) {
/* 345 */       LIST<RES_AMOUNT> li = i.race().home().clas(i.clas()).resources();
/* 346 */       if (this.resI >= li.size())
/* 347 */         return null; 
/* 348 */       return ((RES_AMOUNT)li.get(this.resI)).resource();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void wearOut(Induvidual i) {
/* 354 */       int c = this.counter.get(i);
/* 355 */       int am = c >> 4;
/* 356 */       c &= 0xF;
/* 357 */       this.counter.set(i, c);
/* 358 */       if (am == 0) {
/*     */         return;
/*     */       }
/* 361 */       am = CLAMP.i(am, 0, this.current.indu().get(i));
/* 362 */       this.current.indu().inc(i, -am);
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(Induvidual i) {
/* 367 */       LIST<RES_AMOUNT> li = i.race().home().clas(i.clas()).resources();
/* 368 */       if (this.resI >= li.size())
/* 369 */         return 0; 
/* 370 */       return ((RES_AMOUNT)li.get(this.resI)).amount();
/*     */     }
/*     */ 
/*     */     
/*     */     public int target(Induvidual i) {
/* 375 */       if (!StatsHome.this.GETTER.has(i))
/* 376 */         return 0; 
/* 377 */       RESOURCE res = resource(i);
/* 378 */       if (res == null)
/* 379 */         return 0; 
/* 380 */       return StatsHome.this.target(i.clas(), i.race(), res);
/*     */     }
/*     */ 
/*     */     
/*     */     public double wearPerYear(Induvidual i) {
/* 385 */       return CLAMP.d(0.5D / (BOOSTABLES.CIVICS()).FURNITURE.get((BOOSTABLE_O)i), 0.0D, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(Induvidual i, int am) {
/* 390 */       int old = this.current.indu().get(i);
/* 391 */       if (am != old) {
/*     */         
/* 393 */         this.current.indu().set(i, CLAMP.i(am, 0, max(i)));
/* 394 */         if (i.player() && i.added()) {
/* 395 */           FACTIONS.player().res().inc(resource(i), FResources.RTYPE.FURNISH, old - this.current.indu().get(i));
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int needed(Induvidual i) {
/* 403 */       int am = target(i) - get(i) + (this.counter.get(i) >> 4);
/* 404 */       if (am < 0) {
/* 405 */         wearOut(i);
/* 406 */         am = target(i) - get(i);
/* 407 */         if (am < 0) {
/* 408 */           int c = this.counter.get(i) & 0xF;
/* 409 */           if (RND.rInt(16) < c)
/* 410 */             this.current.indu().inc(i, -1); 
/* 411 */           this.counter.set(i, 0);
/* 412 */           return target(i) - get(i);
/*     */         } 
/*     */       } 
/* 415 */       return am;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int get(Induvidual i) {
/* 421 */       return this.current.indu().get(i);
/*     */     }
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
/*     */   public static final class StatHome
/*     */     implements StatsInit.StatDisposable
/*     */   {
/*     */     private final INT_O.INT_OE<Induvidual> xx;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final INT_O.INT_OE<Induvidual> yy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final STATData stat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final STAT hasSearched;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final INFO info;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Coo coo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StatHome(StatsInit init) {
/* 488 */       this.coo = new Coo(); this.info = new INFO(Dic.¤¤Home, StatsHome.¤¤desc); init.count.getClass(); this.xx = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "HOME_XX"); init.count.getClass(); this.yy = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "HOME_YY"); INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>() {
/*     */           public int get(Induvidual t) { return (StatsHome.StatHome.this.xx.get(t) != 0) ? 1 : 0; } public int min(Induvidual t) { return 0; } public int max(Induvidual t) { return 1; } public void set(Induvidual t, int i) {}
/*     */         }; this.stat = new STATData("HOUSED", "HOME_HOUSE", init, b); (this.stat.info()).icon = (SETT.ROOMS()).HOME.icon.medium; init.disposable.add(this); init.count.getClass(); this.hasSearched = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "HOME_SEARCH"));
/* 491 */     } public boolean has(Humanoid h) { return (this.xx.get(h.indu()) != 0); } public COORDINATE hCoo(Humanoid f) { if (this.xx.get(f.indu()) == 0)
/* 492 */         return null; 
/* 493 */       this.coo.set((this.xx.get(f.indu()) - 1), (this.yy.get(f.indu()) - 1));
/* 494 */       return (COORDINATE)this.coo; }
/*     */     public boolean has(Induvidual h) { return (this.xx.get(h) != 0); }
/*     */     public HOME get(Induvidual f, Object user) { if (this.xx.get(f) == 0)
/*     */         return null;  int tx = this.xx.get(f) - 1; int ty = this.yy.get(f) - 1;
/* 498 */       return HOME.get(tx, ty); } public HOME get(Humanoid h, Object user) { return get(h.indu(), user); }
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose(Humanoid h) {
/* 503 */       STATS.HOME().dump(h);
/* 504 */       set(h, null);
/*     */     }
/*     */     
/*     */     public void set(Humanoid h, HOME home) {
/* 508 */       if (h.isRemoved() || SETT.ENTITIES().getByID(h.id()) != h)
/* 509 */         throw new RuntimeException("" + h.isRemoved() + " " + h.isRemoved()); 
/* 510 */       Induvidual f = h.indu();
/* 511 */       this.hasSearched.indu().set(f, 0);
/* 512 */       this.stat.removeH(f);
/*     */       
/* 514 */       HOME ho = get(h.indu(), this);
/* 515 */       if (ho != null) {
/* 516 */         ho.vacate(h);
/*     */       }
/*     */       
/* 519 */       if (home != null) {
/*     */         
/* 521 */         this.xx.set(f, home.serviceX() + 1);
/* 522 */         this.yy.set(f, home.serviceY() + 1);
/* 523 */         home.occupy(h);
/*     */       } else {
/*     */         
/* 526 */         this.xx.set(f, 0);
/* 527 */         this.yy.set(f, 0);
/*     */       } 
/*     */       
/* 530 */       this.stat.addH(f);
/*     */     }
/*     */ 
/*     */     
/*     */     public STAT stat() {
/* 535 */       return (STAT)this.stat;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsHome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */