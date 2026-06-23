/*     */ package world.region.building;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BUtil;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lock;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RDBuilding
/*     */   implements MAPPED
/*     */ {
/*  48 */   public final ArrayListGrower<Booster> baseFactors = new ArrayListGrower();
/*     */   private final BoostSpecs boosters;
/*  50 */   private final ArrayListGrower<BBoost> bboosts = new ArrayListGrower();
/*     */   
/*     */   public final Boostable efficiency;
/*     */   public final INT_O.INT_OE<Region> level;
/*     */   public final LIST<RDBuildingLevel> levels;
/*     */   public final INFO info;
/*     */   private final int index;
/*     */   public final RDBuildingCat cat;
/*     */   final String kk;
/*     */   public final boolean AIBuild;
/*     */   public final boolean notify;
/*     */   final String order;
/*     */   private final ArrayList<INT_O.INT_OE<Faction>> levelAm;
/*  63 */   private static CharSequence ¤¤NotEnough = "Not enough";
/*  64 */   private static CharSequence ¤¤Requirement = "Requirements not met";
/*     */   static {
/*  66 */     D.ts(RDBuilding.class);
/*     */   }
/*     */   
/*     */   RDBuilding(LISTE<RDBuilding> all, RD.RDInit init, RDBuildingCat cat, String key, INFO info, LIST<RDBuildingLevel> levels, boolean AIBuilds, boolean notify, String order) {
/*  70 */     this.info = info;
/*  71 */     this.cat = cat;
/*  72 */     this.AIBuild = AIBuilds;
/*  73 */     this.notify = notify;
/*  74 */     this.order = order;
/*  75 */     cat.all.add(this);
/*  76 */     this.index = all.add(this);
/*  77 */     this.kk = cat.key + "_" + cat.key;
/*  78 */     key = "BUILDING_" + this.kk;
/*  79 */     this.efficiency = BOOSTING.push(key, 1.0D, info.name, info.desc, (SPRITE)((RDBuildingLevel)levels.get(0)).icon, (BoostableCat.ALL()).WORLD);
/*     */ 
/*     */ 
/*     */     
/*  83 */     this.boosters = new BoostSpecs(info.name, (SPRITE)((RDBuildingLevel)levels.get(0)).icon, true);
/*  84 */     RDBuildingLevel flevel = new RDBuildingLevel(Dic.¤¤Clear, (UI.icons()).m.cancel, GVALUES.REGION.LOCK.push());
/*  85 */     ArrayList<RDBuildingLevel> ll = new ArrayList(levels.size() + 1);
/*  86 */     ll.add(flevel);
/*  87 */     ll.add((Iterable)levels);
/*  88 */     this.levels = (LIST<RDBuildingLevel>)ll;
/*  89 */     this.level = (INT_O.INT_OE<Region>)new DataO<Region>.DataNibble(init.count, "BUILDING_LEVEL" + cat.key + " " + key, ll.size() - 1)
/*     */       {
/*     */         public void set(Region t, int s) {
/*  92 */           if (get(t) != 0 && t.faction() != null)
/*  93 */             ((INT_O.INT_OE)RDBuilding.this.levelAm.get(get(t) - 1)).inc(t.faction(), -1); 
/*  94 */           if (s != get(t) && t.faction() == FACTIONS.player())
/*  95 */             (RD.BUILDINGS()).costs.setDirty(); 
/*  96 */           super.set(t, s);
/*  97 */           if (get(t) != 0 && t.faction() != null) {
/*  98 */             ((INT_O.INT_OE)RDBuilding.this.levelAm.get(get(t) - 1)).inc(t.faction(), 1);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     int i = 0;
/* 122 */     for (RDBuildingLevel lll : this.levels) {
/* 123 */       lll.index = i++;
/*     */     }
/*     */     
/* 126 */     this.levelAm = new ArrayList(levels.size());
/* 127 */     while (this.levelAm.hasRoom()) {
/* 128 */       DataO.DataShort dataShort = new DataO.DataShort(init.rCount, "BUILDING_LEVEL" + cat.key + " " + key + this.levelAm.size());
/* 129 */       this.levelAm.add(dataShort);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 134 */     values(key);
/*     */   }
/*     */ 
/*     */   
/*     */   private void values(String kk) {
/* 139 */     for (int l = 1; l < this.levels.size(); l++) {
/* 140 */       final int k = l - 1;
/* 141 */       GVALUES.FACTION.pushI(kk + "_LEVEL_" + kk, ((RDBuildingLevel)this.levels.get(k + 1)).name, (SPRITE)((RDBuildingLevel)this.levels.get(k)).icon, (INT_O)this.levelAm.get(k));
/* 142 */       GVALUES.REGION.pushI(kk + "_KINGDOM_LEVEL_" + kk, ((RDBuildingLevel)this.levels.get(k + 1)).name, (SPRITE)((RDBuildingLevel)this.levels.get(k)).icon, new INT_O<Region>()
/*     */           {
/*     */             public int get(Region t)
/*     */             {
/* 146 */               if (t.faction() == null)
/* 147 */                 return 0; 
/* 148 */               return ((INT_O.INT_OE)RDBuilding.this.levelAm.get(k)).get(t.faction());
/*     */             }
/*     */ 
/*     */             
/*     */             public int min(Region t) {
/* 153 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Region t) {
/* 158 */               return Integer.MAX_VALUE;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     GVALUES.REGION.pushI(kk + "_LEVEL", String.valueOf(Dic.¤¤Level) + ": " + String.valueOf(Dic.¤¤Level), (SPRITE)((RDBuildingLevel)this.levels.get(1)).icon, (INT_O)this.level);
/*     */     
/* 168 */     GVALUES.REGION.push(kk, String.valueOf(Dic.¤¤Buildings) + ": " + String.valueOf(Dic.¤¤Buildings), (SPRITE)((RDBuildingLevel)this.levels.get(1)).icon, new BOOLEANO<Region>()
/*     */         {
/*     */           public boolean is(Region t)
/*     */           {
/* 172 */             return (RDBuilding.this.level.get(t) > 0);
/*     */           }
/*     */         });
/*     */     
/* 176 */     GVALUES.REGION.pushI(kk + "_KINGDOM", String.valueOf(Dic.¤¤Buildings) + " (" + String.valueOf(Dic.¤¤Buildings) + "): " + String.valueOf(Dic.¤¤Realm), (SPRITE)((RDBuildingLevel)this.levels.get(1)).icon, new INT_O<Region>()
/*     */         {
/*     */           public int get(Region t)
/*     */           {
/* 180 */             if (t.faction() == null)
/* 181 */               return (RDBuilding.this.level.get(t) > 0) ? 1 : 0; 
/* 182 */             int am = 0;
/* 183 */             for (INT_O.INT_OE<Faction> l : RDBuilding.this.levelAm)
/* 184 */               am += l.get(t.faction()); 
/* 185 */             return am;
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Region t) {
/* 190 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Region t) {
/* 195 */             return Integer.MAX_VALUE;
/*     */           }
/*     */         });
/*     */     
/* 199 */     GVALUES.FACTION.pushI(kk + "_AMOUNT", String.valueOf(Dic.¤¤Buildings) + " (" + String.valueOf(Dic.¤¤Buildings) + "): " + String.valueOf(Dic.¤¤Realm), (SPRITE)((RDBuildingLevel)this.levels.get(1)).icon, new INT_O<Faction>()
/*     */         {
/*     */           public int get(Faction t)
/*     */           {
/* 203 */             int am = 0;
/* 204 */             for (INT_O.INT_OE<Faction> l : RDBuilding.this.levelAm)
/* 205 */               am += l.get(t); 
/* 206 */             return am;
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Faction t) {
/* 211 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Faction t) {
/* 216 */             return Integer.MAX_VALUE;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 221 */     GVALUES.REGION.push(kk + "_PROSPECT", Dic.¤¤Prospect, (SPRITE)(UI.icons()).s.question, new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region r) {
/* 224 */             double add = BUtil.value((LIST)RDBuilding.this.baseFactors, r);
/* 225 */             return add;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 233 */     return (SPRITE)((RDBuildingLevel)this.levels.get(1)).icon;
/*     */   }
/*     */   
/*     */   public INT_O<Faction> nr(int level) {
/* 237 */     return (INT_O<Faction>)this.levelAm.get(level);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void connect(RD.RDInit init) {
/* 243 */     KeyMap<BBoost> map = new KeyMap();
/*     */     
/* 245 */     boolean[] costs = new boolean[(RD.BUILDINGS()).costs.ALL.size()];
/*     */     
/* 247 */     for (RDBuildingLevel l : this.levels) {
/*     */       int bi;
/* 249 */       for (bi = 0; bi < l.local.all().size(); bi++) {
/* 250 */         BoostSpec lb = (BoostSpec)l.local.all().get(bi);
/* 251 */         String k = lb.identifier();
/* 252 */         if (!map.containsKey(k)) {
/* 253 */           BBoost b = new BBoost(this, false, lb);
/* 254 */           map.put(k, b);
/*     */         } 
/* 256 */         final RDBuildPoints.RDBuildPoint c = (RD.BUILDINGS()).costs.get(lb.boostable, lb.booster);
/*     */         
/* 258 */         if (c != null && !costs[c.index]) {
/*     */           
/* 260 */           (new Creator.Bo(new BSourceInfo(c.info.name, (SPRITE)c.bo.icon), 0.0D, 1.0D, true)
/*     */             {
/*     */               double get(Region reg)
/*     */               {
/* 264 */                 return c.eff(reg);
/*     */               }
/* 268 */             }).add(this.efficiency);
/* 269 */           costs[c.index] = true;
/*     */         } 
/*     */       } 
/*     */       
/* 273 */       for (bi = 0; bi < l.global.all().size(); bi++) {
/* 274 */         BoostSpec lb = (BoostSpec)l.global.all().get(bi);
/*     */         
/* 276 */         String k = lb.identifier() + "G";
/* 277 */         if (!map.containsKey(k)) {
/*     */           
/* 279 */           BBoost b = new BBoost(this, true, lb);
/* 280 */           map.put(k, b);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 285 */     for (RDBuildingLevel l : this.levels) {
/*     */       
/* 287 */       for (BoostSpec s : l.global.all()) {
/* 288 */         l.local.push(s.booster, s.boostable, Dic.¤¤Realm);
/*     */       }
/* 290 */       l.global = null;
/*     */     } 
/*     */     
/* 293 */     KeyMap<String> lmap = new KeyMap();
/*     */     
/* 295 */     for (RDBuildingLevel lev : this.levels) {
/*     */       
/* 297 */       for (Lock<Region> lock : (Iterable<Lock<Region>>)lev.reqs.all()) {
/* 298 */         String k = String.valueOf(lock.unlocker.name);
/* 299 */         if (!lmap.containsKey(k)) {
/* 300 */           lmap.put(k, k);
/*     */           
/* 302 */           final ArrayListGrower<Lock<Region>> locks = new ArrayListGrower();
/*     */           
/* 304 */           for (int li = 0; li < this.levels.size(); li++) {
/* 305 */             RDBuildingLevel le = (RDBuildingLevel)this.levels.get(li);
/* 306 */             Lock<Region> fl = null;
/* 307 */             for (int ri = 0; ri < le.reqs.all().size(); ri++) {
/* 308 */               Lock<Region> re = (Lock<Region>)le.reqs.all().get(ri);
/* 309 */               if (String.valueOf(re.unlocker.name).equals(k)) {
/* 310 */                 fl = re;
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 315 */             if (fl == null && li > 0) {
/* 316 */               locks.add(locks.get(li - 1));
/*     */             } else {
/* 318 */               locks.add(fl);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 323 */           (new BoosterImp(new BSourceInfo("!" + String.valueOf(lock.unlocker.name), (SPRITE)(UI.icons()).s.boom), 0.0D, 1.0D, true)
/*     */             {
/*     */               public double vGet(Region t)
/*     */               {
/* 327 */                 if (t.faction() == FACTIONS.player()) {
/* 328 */                   for (int l = RD.BUILDINGS().tmp().level(RDBuilding.this, t); l >= 0; l--);
/*     */ 
/*     */ 
/*     */                   
/* 332 */                   Lock<Region> re = (Lock<Region>)locks.get(RD.BUILDINGS().tmp().level(RDBuilding.this, t));
/* 333 */                   if (re == null) {
/* 334 */                     return 1.0D;
/*     */                   }
/* 336 */                   return (re.unlocker.inUnlocked(t) ? true : false);
/*     */                 } 
/*     */ 
/*     */                 
/* 340 */                 return 1.0D;
/*     */               }
/* 343 */             }).add(this.efficiency);
/*     */         } 
/*     */       } 
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
/*     */   public CharSequence canAfford(Region reg, int lc, int level) {
/* 357 */     if (level <= lc)
/* 358 */       return null; 
/* 359 */     if (level >= this.levels.size()) {
/* 360 */       return Dic.¤¤Unavailable;
/*     */     }
/* 362 */     if (reg.faction() != null) {
/* 363 */       int cr = ((RDBuildingLevel)this.levels.get(level)).cost - ((RDBuildingLevel)this.levels.get(RD.BUILDINGS().tmp().level(this, reg))).cost;
/* 364 */       if (cr > reg.faction().credits().credits()) {
/* 365 */         return (CharSequence)Str.TMP.clear().add(¤¤NotEnough).add(':').s().add(Dic.¤¤Currs);
/*     */       }
/*     */     } 
/*     */     
/* 369 */     if (!((RDBuildingLevel)this.levels.get(level)).reqs.passes(reg)) {
/* 370 */       return ¤¤Requirement;
/*     */     }
/* 372 */     for (BBoost b : this.bboosts) {
/* 373 */       if (!b.canAfford(reg, lc, level))
/* 374 */         return (CharSequence)Str.TMP.clear().add(¤¤NotEnough).add(':').s().add(b.b.boostable.name); 
/* 375 */     }  return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<RDBuildingLevel> levels() {
/* 380 */     return this.levels;
/*     */   }
/*     */   
/*     */   public BoostSpecs boosters() {
/* 384 */     return this.boosters;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 389 */     return this.index;
/*     */   }
/*     */   
/*     */   public double baseEfficiency(Region reg) {
/* 393 */     return BUtil.value((LIST)this.baseFactors, reg);
/*     */   }
/*     */   
/*     */   private static class BBoost
/*     */     extends Booster implements BValue {
/*     */     final boolean global;
/*     */     final BoostSpec b;
/*     */     final RDBuilding bu;
/* 401 */     public double min = Double.MAX_VALUE;
/* 402 */     public double max = Double.MIN_VALUE;
/*     */     
/*     */     public final double[] froms;
/*     */     public final double[] tos;
/*     */     
/*     */     public BBoost(RDBuilding bu, boolean global, BoostSpec b) {
/* 408 */       super(new BSourceInfo(bu.info.name, global ? Dic.¤¤Realm : null, (SPRITE)((RDBuildingLevel)bu.levels.get(1)).icon), b.booster.isMul);
/* 409 */       this.global = global;
/* 410 */       this.froms = new double[bu.levels.size()];
/* 411 */       this.tos = new double[bu.levels.size()];
/* 412 */       if (b.booster.isMul) {
/* 413 */         Arrays.fill(this.froms, 1.0D);
/* 414 */         Arrays.fill(this.tos, 1.0D);
/*     */       } 
/* 416 */       this.bu = bu;
/* 417 */       this.b = b;
/*     */       
/* 419 */       for (int li = 1; li < bu.levels.size(); li++) {
/* 420 */         RDBuildingLevel l = (RDBuildingLevel)bu.levels.get(li);
/* 421 */         BoostSpecs coll = global ? l.global : l.local;
/* 422 */         for (BoostSpec bb : coll.all()) {
/* 423 */           if (b.isSameAs(bb)) {
/*     */             
/* 425 */             this.froms[li] = bb.booster.from();
/* 426 */             this.tos[li] = bb.booster.to();
/* 427 */             double mi = Math.min(this.tos[li], this.froms[li]);
/* 428 */             double ma = Math.max(this.tos[li], this.froms[li]);
/* 429 */             this.min = Math.min(this.min, mi);
/* 430 */             this.max = Math.max(this.max, ma);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 437 */       bu.boosters.push(this, b.boostable, global ? Dic.¤¤Realm : null);
/* 438 */       bu.bboosts.add(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(BOOSTABLE_O o) {
/* 445 */       return o.boostableValue(this);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double vGet(Region t) {
/* 451 */       if (this.global && t.realm() != null) {
/* 452 */         int ll = this.bu.level.get(t);
/* 453 */         int l = RD.BUILDINGS().tmp().level(this.bu, t);
/* 454 */         if (ll != l) {
/* 455 */           return vGet(t.faction()) - this.tos[ll] - this.froms[ll] + this.tos[l] - this.froms[l];
/*     */         }
/* 457 */         return vGet(t.faction());
/*     */       } 
/*     */       
/* 460 */       return g(t);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Faction f) {
/* 465 */       if (f == null)
/* 466 */         return 0.0D; 
/* 467 */       if (!this.global)
/* 468 */         return 0.0D; 
/* 469 */       double res = 0.0D;
/* 470 */       for (int i = 1; i < this.froms.length; i++) {
/* 471 */         double am = ((INT_O.INT_OE)this.bu.levelAm.get(i - 1)).get(f);
/* 472 */         res += (this.tos[i] - this.froms[i]) * am;
/*     */       } 
/* 474 */       if (this.b.booster.isMul) {
/* 475 */         res++;
/*     */       }
/*     */ 
/*     */       
/* 479 */       return res;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 484 */       return vGet(indu.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 489 */       return vGet(div.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE t) {
/* 494 */       return vGet(FACTIONS.player());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 499 */       return vGet((Faction)f);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 504 */       return vGet((Faction)f);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double getValue(double input) {
/* 510 */       return 0.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected double pget(BOOSTABLE_O o) {
/* 516 */       return 0.0D;
/*     */     }
/*     */     
/*     */     private double g(Region t) {
/* 520 */       double ta = this.tos[RD.BUILDINGS().tmp().level(this.bu, t)];
/* 521 */       if (!this.b.booster.isMul && ta < 0.0D)
/* 522 */         return ta; 
/* 523 */       int i = RD.BUILDINGS().tmp().level(this.bu, t);
/* 524 */       double vv = this.tos[i];
/* 525 */       if (this.b.booster.isMul || vv > 0.0D) {
/* 526 */         return this.froms[i] + this.bu.efficiency.get((BOOSTABLE_O)t) * (this.tos[i] - this.froms[i]);
/*     */       }
/* 528 */       return vv;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double from() {
/* 534 */       return this.froms[0];
/*     */     }
/*     */ 
/*     */     
/*     */     public double to() {
/* 539 */       return this.tos[this.tos.length - 1];
/*     */     }
/*     */     
/*     */     public boolean canAfford(Region reg, int current, int level) {
/* 543 */       if ((RD.BUILDINGS()).costs.get(this.b.boostable, this.b.booster) != null) {
/* 544 */         double am = this.tos[current] - this.tos[level];
/* 545 */         if (am <= 0.0D)
/* 546 */           return true; 
/* 547 */         return (am <= this.b.boostable.get((BOOSTABLE_O)reg));
/*     */       } 
/* 549 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String key() {
/* 560 */     return this.kk;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuilding.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */