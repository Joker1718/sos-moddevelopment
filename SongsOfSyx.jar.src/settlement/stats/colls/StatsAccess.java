/*     */ package settlement.stats.colls;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.environment.SettEnvShape;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class StatsAccess extends StatCollection {
/*  45 */   private static CharSequence ¤¤name = "Other";
/*  46 */   private static CharSequence ¤¤desc = "Access to different environments.";
/*     */   
/*  48 */   private static CharSequence ¤¤nameA = "Surroundings";
/*  49 */   private static CharSequence ¤¤descA = "Access to different environments.";
/*     */   
/*     */   public final StatsMonuments MONUMENTS;
/*     */   
/*     */   public final StatsA ACCESS;
/*  54 */   private static CharSequence ¤¤monumentName = "Decorations";
/*  55 */   private static CharSequence ¤¤MonumentsD = "The value is based on access, upgrade and general decoration degrade in your city. The access can be higher than 100%, in which case it will compensate in places where there is no access.";
/*  56 */   private static CharSequence ¤¤MonumentsDeg = "Degrade";
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  61 */     D.ts(StatsAccess.class);
/*     */   }
/*     */   
/*     */   public StatsAccess(StatsInit init) {
/*  65 */     super(init, "OTHER", ¤¤name, ¤¤desc);
/*  66 */     this.ACCESS = new StatsA(init);
/*  67 */     init.coll = this;
/*     */     
/*  69 */     this.MONUMENTS = new StatsMonuments(init);
/*     */     
/*  71 */     init.updatable.add(new Updater());
/*     */   }
/*     */   
/*     */   private final class Updater implements StatsInit.StatUpdatableI {
/*     */     private final ArrayList<SettEnvMap.SettEnv> alle;
/*     */     
/*     */     private Updater() {
/*  78 */       this.alle = new ArrayList((Iterable)(SETT.ENV()).map.all());
/*     */       
/*  80 */       this.alle.remove((SETT.ENV()).map.NOISE);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void update16(Humanoid h, int updateI, boolean day, int ui) {
/*  86 */       Induvidual i = h.indu();
/*     */       
/*  88 */       if (!HPoll.Handler.works(h) || (STATS.WORK()).EMPLOYED.get(h) == null || 
/*  89 */         !((RoomInstance)(STATS.WORK()).EMPLOYED.get(h)).constructor().envValue((SETT.ENV()).map.NOISE)) {
/*  90 */         SettEnvMap.SettEnv e = (SETT.ENV()).map.NOISE;
/*  91 */         accessCheck2(h, ((STAT)StatsAccess.this.ACCESS.all().get(e.index())).indu(), e.get(h.physics.tileC()) * 16.0D, e.declineSpeed);
/*     */       } 
/*     */       
/*  94 */       RoomBlueprint room = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(h.physics.tileC());
/*  95 */       if (room == null || room.registersEnvironment()) {
/*  96 */         boolean deg = false;
/*  97 */         for (StatsAccess.StatMonument m : StatsAccess.this.MONUMENTS.ALL) {
/*  98 */           int a = m.m.mapData.get(h.physics.tileC());
/*  99 */           int c = m.amount.indu().get(i);
/* 100 */           if (a > 0) {
/* 101 */             m.access.indu().set(i, 1);
/* 102 */             deg |= (SETT.ENV()).map.MONUMENT.DEGRADE.is(h.tc());
/* 103 */             int up = m.m.mapUpgrade.get(h.physics.tileC());
/* 104 */             m.upgrade.indu().set(h.indu(), up);
/*     */           } 
/*     */           
/* 107 */           if (a > c) {
/* 108 */             m.amount.indu().inc(h.indu(), 1); continue;
/* 109 */           }  if (a < c) {
/* 110 */             if (m.amount.indu().get(i) == 0) {
/* 111 */               m.access.indu().set(i, 0);
/* 112 */               m.upgrade.indu().set(h.indu(), 0); continue;
/*     */             } 
/* 114 */             m.amount.indu().inc(h.indu(), -1);
/*     */           } 
/*     */         } 
/* 117 */         StatsAccess.this.MONUMENTS.degrade.indu().set(i, deg ? 1 : 0);
/*     */ 
/*     */         
/* 120 */         for (SettEnvMap.SettEnv e : this.alle) {
/* 121 */           accessCheck(h, ((STAT)StatsAccess.this.ACCESS.all().get(e.index())).indu(), e.get(h.physics.tileC()) * 16.0D, e.declineSpeed);
/*     */         }
/*     */ 
/*     */         
/* 125 */         for (StatsAccess.Env ee : StatsAccess.this.ACCESS.envs) {
/* 126 */           if (ee.t.is(h.physics.tileC())) {
/* 127 */             ee.stat.indu().inc(h.indu(), 1);
/* 128 */             for (StatsAccess.Env e : StatsAccess.this.ACCESS.envs) {
/* 129 */               if (e == ee)
/*     */                 continue; 
/* 131 */               e.stat.indu().inc(h.indu(), -1);
/*     */             } 
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private void accessCheck(Humanoid h, INT_O.INT_OE<Induvidual> data, double value, double deg) {
/* 140 */       Induvidual i = h.indu();
/* 141 */       int v = (int)Math.ceil(value);
/* 142 */       if (v > data.get(i) * 2)
/* 143 */         data.inc(i, 2); 
/* 144 */       if (v > data.get(i)) {
/* 145 */         data.inc(i, 1);
/* 146 */       } else if (v < data.get(i) && RND.oneIn(8.0D * 1.0D / deg)) {
/* 147 */         data.inc(i, -1);
/*     */       } 
/*     */     }
/*     */     
/*     */     private void accessCheck2(Humanoid h, INT_O.INT_OE<Induvidual> data, double value, double deg) {
/* 152 */       Induvidual i = h.indu();
/* 153 */       int v = (int)Math.ceil(value);
/* 154 */       if (v > data.get(i))
/* 155 */         data.inc(i, 1); 
/* 156 */       if (v < data.get(i)) {
/* 157 */         data.inc(i, -1);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StatsA
/*     */     extends StatCollection
/*     */   {
/*     */     private final STAT WATER;
/*     */     
/* 169 */     private final ArrayListGrower<StatsAccess.Env> envs = new ArrayListGrower();
/*     */     
/*     */     private StatsA(StatsInit init) {
/* 172 */       super(init, "ACCESS", StatsAccess.¤¤nameA, StatsAccess.¤¤descA);
/* 173 */       for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/*     */         
/* 175 */         StatInfo info = new StatInfo(e.info.name, e.info.names, e.info.desc);
/* 176 */         info.setOpinion(e.op);
/* 177 */         info.icon = e.icon;
/* 178 */         String dkey = this.key + "_" + this.key;
/* 179 */         init.count.getClass(); final STATData d = new STATData(e.key, init, (DataO.DataAbs)new DataO.DataNibble(init.count, dkey), info);
/* 180 */         init.onArrivalStats.add(d);
/* 181 */         d.standing = new StatStanding((STAT)d, 0.0D, e.standing);
/*     */         
/* 183 */         ACTION ac = new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 187 */               for (BoostSpec sp : e.bonuses.all()) {
/*     */                 
/* 189 */                 StatBooster vv = StatBooster.make((STAT)d);
/* 190 */                 BoosterValue boosterValue = new BoosterValue((BValue)vv, sp.booster.info, sp.booster.to(), sp.booster.isMul);
/* 191 */                 d.boosters.push((Booster)boosterValue, sp.boostable);
/*     */               } 
/*     */             }
/*     */           };
/*     */         
/* 196 */         BOOSTING.connecter(ac);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 201 */       for (SettEnvShape.Type t : (SETT.ENV()).map.SHAPE.all) {
/* 202 */         this.envs.add(new StatsAccess.Env(init, t));
/*     */       }
/*     */       
/* 205 */       this.WATER = (STAT)new STATFake(this.key + "_WATER", init, null)
/*     */         {
/*     */           protected double getDD(HCLASS s, Race r, int daysBack)
/*     */           {
/* 209 */             double d = (SETT.ENV()).map.WATER_SALT.stat().data(s).getD(r) + (SETT.ENV()).map.WATER_SWEET.stat().data(s).getD(r);
/* 210 */             d = CLAMP.d(d, 0.0D, 1.0D);
/* 211 */             return d;
/*     */           }
/*     */ 
/*     */           
/*     */           public double induGet(Induvidual t) {
/* 216 */             double a = (SETT.ENV()).map.WATER_SALT.stat().indu().getD(t) + (SETT.ENV()).map.WATER_SWEET.stat().indu().getD(t);
/* 217 */             return CLAMP.d(a, 0.0D, 1.0D);
/*     */           }
/*     */         };
/*     */       
/* 221 */       (this.WATER.info()).icon = (SPRITE)(UI.icons()).m.water;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class StatsMonuments
/*     */     extends StatCollection
/*     */   {
/*     */     private final STAT degrade;
/* 230 */     private final ArrayList<StatsAccess.StatMonument> ALL = new ArrayList((SETT.ROOMS()).MONUMENTS.all.size());
/*     */     
/*     */     private StatsMonuments(StatsInit init) {
/* 233 */       super(init, "MONUMENTS", StatsAccess.¤¤monumentName, StatsAccess.¤¤MonumentsD);
/* 234 */       init.count.getClass(); this.degrade = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataCrumb(init.count, "MON_DEGRADE"), null);
/* 235 */       ROOM_MONUMENT[] rr = new ROOM_MONUMENT[(SETT.ROOMS()).MONUMENTS.all.size()];
/*     */       
/* 237 */       for (ROOM_MONUMENT m : (SETT.ROOMS()).MONUMENTS.all)
/* 238 */         rr[m.monumentIndex] = m;  byte b; int i;
/*     */       ROOM_MONUMENT[] arrayOfROOM_MONUMENT1;
/* 240 */       for (i = (arrayOfROOM_MONUMENT1 = rr).length, b = 0; b < i; ) { ROOM_MONUMENT m = arrayOfROOM_MONUMENT1[b];
/* 241 */         this.ALL.add(new StatsAccess.StatMonument(m, init, this.degrade));
/*     */         b++; }
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<StatsAccess.StatMonument> ALL() {
/* 248 */       return (LIST<StatsAccess.StatMonument>)this.ALL;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class StatMonument
/*     */     extends STATFake
/*     */   {
/*     */     public ROOM_MONUMENT m;
/*     */     public final STAT upgrade;
/*     */     public final STAT amount;
/*     */     public final STAT access;
/*     */     private final STAT degrade;
/*     */     
/*     */     StatMonument(final ROOM_MONUMENT m, StatsInit init, STAT degrade) {
/* 263 */       super(m.key, init, new StatInfo(m.info.name, m.info.names, StatsAccess.¤¤MonumentsD));
/* 264 */       this.access = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "ACCESS_" + m.key));
/* 265 */       this.amount = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "AMOUNT_" + m.key));
/* 266 */       this.upgrade = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataCrumb(init.count, m.key + "dupgrade"), null);
/* 267 */       this.degrade = degrade;
/* 268 */       this.m = m;
/* 269 */       this.info.icon = (SPRITE)m.icon;
/* 270 */       this.info.setOpinion(m.opinion);
/* 271 */       this.standing = new StatStanding((STAT)this, 0.0D, m.defaultStanding);
/* 272 */       info().setMatters(true, false);
/* 273 */       BOOSTING.connecter(new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 277 */               for (BoostSpec t : m.boosts.all()) {
/*     */                 
/* 279 */                 StatBooster statBooster = StatBooster.make((STAT)StatsAccess.StatMonument.this);
/* 280 */                 BSourceInfo in = new BSourceInfo(StatsAccess.StatMonument.this.info.names, m.icon.small);
/* 281 */                 BoosterValue boosterValue = new BoosterValue((BValue)statBooster, in, t.booster.from(), t.booster.to(), t.booster.isMul);
/*     */                 
/* 283 */                 StatsAccess.StatMonument.this.boosters.push((Booster)boosterValue, t.boostable);
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected double getDD(HCLASS s, Race r, int daysBack) {
/* 314 */       double acc = this.access.data(s).get(r, daysBack);
/* 315 */       if (acc == 0.0D) {
/* 316 */         return 0.0D;
/*     */       }
/*     */       
/* 319 */       double d = this.amount.data(s).get(r, daysBack) / acc * this.m.maxEnv();
/* 320 */       d = CLAMP.d(d, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */       
/* 324 */       d *= 1.0D - this.degrade.data(s).get(r, daysBack) / acc;
/*     */       
/* 326 */       if (this.m.upgrades().max() > 0) {
/* 327 */         d *= (this.upgrade.data(s).get(r) + acc) / acc * (1 + this.m.upgrades().max());
/*     */       }
/*     */       
/* 330 */       return d * this.access.data(s).getD(r, daysBack);
/*     */     }
/*     */ 
/*     */     
/*     */     public double induGet(Induvidual t) {
/* 335 */       double a = this.amount.indu().get(t) / this.m.maxEnv();
/* 336 */       a = CLAMP.d(a, 0.0D, 1.0D);
/* 337 */       a *= (1 - this.degrade.indu().get(t));
/* 338 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public int dataDivider() {
/* 343 */       return 128;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 348 */       GBox b = (GBox)text;
/* 349 */       b.text(this.m.info.desc);
/* 350 */       b.sep();
/* 351 */       double acc = this.access.data(cl).get(type);
/*     */       
/* 353 */       b.textL(Dic.¤¤Access);
/* 354 */       b.tab(6);
/* 355 */       double d = 0.0D;
/* 356 */       if (acc > 0.0D)
/* 357 */         d = this.amount.data(cl).get(type) / acc * this.m.maxEnv(); 
/* 358 */       b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 359 */       b.NL();
/*     */       
/* 361 */       b.textL(StatsAccess.¤¤MonumentsDeg);
/* 362 */       b.tab(6);
/* 363 */       d = 0.0D;
/* 364 */       if (acc > 0.0D)
/* 365 */         d = this.degrade.data(cl).get(type) / acc; 
/* 366 */       b.add((SPRITE)GFORMAT.percInv(b.text(), d));
/* 367 */       b.NL();
/*     */       
/* 369 */       if (this.m.upgrades().max() > 0) {
/* 370 */         b.textL(Dic.¤¤Upgrade);
/* 371 */         b.tab(6);
/* 372 */         b.add((SPRITE)GFORMAT.perc(b.text(), (this.upgrade.data(cl).get(type) + acc) / acc * (1 + this.m.upgrades().max())));
/* 373 */         b.NL(4);
/*     */       } 
/*     */       
/* 376 */       super.hover(text, cl, type);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GUI_BOX text, Induvidual indu) {
/* 382 */       GBox b = (GBox)text;
/* 383 */       b.text(this.m.info.desc);
/* 384 */       b.sep();
/*     */       
/* 386 */       b.textL(Dic.¤¤Access);
/* 387 */       b.tab(7);
/* 388 */       double d = this.amount.indu().get(indu) / this.m.maxEnv();
/* 389 */       b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 390 */       b.NL();
/*     */       
/* 392 */       b.textL(StatsAccess.¤¤MonumentsDeg);
/* 393 */       b.tab(7);
/* 394 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.degrade.indu().getD(indu)));
/* 395 */       b.NL();
/*     */       
/* 397 */       if (this.m.upgrades().max() > 0) {
/* 398 */         b.textL(Dic.¤¤Upgrade);
/* 399 */         b.tab(6);
/* 400 */         b.add((SPRITE)GFORMAT.perc(b.text(), this.upgrade.indu().get(indu) / this.m.upgrades().max()));
/* 401 */         b.NL(4);
/*     */       } 
/*     */       
/* 404 */       super.hover(text, indu);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Env
/*     */   {
/*     */     private final SettEnvShape.Type t;
/*     */ 
/*     */     
/*     */     public final STAT stat;
/*     */ 
/*     */     
/*     */     Env(StatsInit init, SettEnvShape.Type t) {
/* 419 */       this.t = t;
/* 420 */       String key = "SHAPE_" + t.key;
/*     */       
/* 422 */       STATData d = new STATData(key, init, (DataO.DataAbs)new DataO.DataCrumb(init.count, "D_" + key), null);
/* 423 */       (d.info()).icon = t.icon;
/* 424 */       init.onArrivalStats.add(d);
/*     */       
/* 426 */       this.stat = (STAT)d;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAccess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */