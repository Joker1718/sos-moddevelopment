/*     */ package world.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.util.Arrays;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.text.D;
/*     */ import view.ui.message.MessageText;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.army.WArmy;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Util
/*     */ {
/*     */   public static boolean allies(Faction a, Faction b) {
/*  48 */     if (a == b)
/*  49 */       return true; 
/*  50 */     if (a == null || b == null)
/*  51 */       return false; 
/*  52 */     return (DIP.get(a, b)).ally;
/*     */   }
/*     */   
/*     */   public static boolean enemies(Faction a, Faction b) {
/*  56 */     return DIP.WAR().is(a, b);
/*     */   }
/*     */   
/*  59 */   private final Pair res = new Pair();
/*     */ 
/*     */   
/*     */   public Pair fill(Faction a, Faction b, int cx, int cy) {
/*  63 */     this.res.a.clearSloppy();
/*  64 */     this.res.b.clearSloppy();
/*     */     
/*  66 */     GUTIL.flooder().init(Util.class);
/*  67 */     GUTIL.flooder().pushSloppy(cx, cy, 0.0D);
/*     */     
/*  69 */     while (GUTIL.flooder().hasMore()) {
/*  70 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/*  72 */       if (t.getValue() > WArmy.reinforceTiles) {
/*     */         break;
/*     */       }
/*  75 */       for (WArmy ar : (WORLD.ENTITIES()).armies.fillTile(t.x(), t.y())) {
/*  76 */         if (valid(ar) == null)
/*     */           continue; 
/*  78 */         if (ar.ctx() != t.x() || ar.cty() != t.y()) {
/*     */           continue;
/*     */         }
/*  81 */         if (allies(a, ar.faction()) && enemies(b, ar.faction())) {
/*  82 */           this.res.a.add(ar); continue;
/*  83 */         }  if (allies(b, ar.faction()) && enemies(a, ar.faction())) {
/*  84 */           this.res.b.add(ar);
/*     */         }
/*     */       } 
/*  87 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/*  88 */         DIR d = (DIR)DIR.ALL.get(di);
/*  89 */         if ((WORLD.PATH()).map.can((COORDINATE)t, d))
/*  90 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance()); 
/*     */       } 
/*     */     } 
/*  93 */     GUTIL.flooder().done();
/*  94 */     return this.res;
/*     */   }
/*     */   
/*  97 */   private Rec fillBounds = new Rec(6.0D);
/*     */   
/*     */   public WArmy getBesieger(Region reg) {
/* 100 */     if (!reg.active())
/* 101 */       return null; 
/* 102 */     if (!reg.besieged())
/* 103 */       return null; 
/* 104 */     this.fillBounds.moveC(reg.cx(), reg.cy());
/* 105 */     for (WArmy a : (WORLD.ENTITIES()).armies.fillTiles((RECTANGLE)this.fillBounds)) {
/* 106 */       if (valid(a) != null && a.faction() == FACTIONS.player() && a.besieging(reg)) {
/* 107 */         return a;
/*     */       }
/*     */     } 
/* 110 */     for (WArmy a : (WORLD.ENTITIES()).armies.fillTiles((RECTANGLE)this.fillBounds)) {
/* 111 */       if (valid(a) != null && a.besieging(reg)) {
/* 112 */         return a;
/*     */       }
/*     */     } 
/* 115 */     return null;
/*     */   }
/*     */   
/*     */   public static WArmy valid(WArmy a) {
/* 119 */     if (a == null)
/* 120 */       return null; 
/* 121 */     if (AD.men(null).get(a) <= 0)
/* 122 */       return null; 
/* 123 */     return a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static COORDINATE retTile(WArmy a) {
/* 128 */     if (a.faction() == null) {
/* 129 */       return null;
/*     */     }
/* 131 */     GUTIL.flooder().init(Util.class);
/* 132 */     GUTIL.flooder().pushSloppy(a.ctx(), a.cty(), 0.0D);
/*     */     
/* 134 */     double ap = AD.power().get(a);
/* 135 */     double pow = enemyPower(a.faction(), a.ctx(), a.cty());
/*     */     
/* 137 */     while (GUTIL.flooder().hasMore()) {
/* 138 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 139 */       if (t.getValue() > 8.0F) {
/*     */         break;
/*     */       }
/* 142 */       double p = enemyPower(a.faction(), t.x(), t.y());
/*     */       
/* 144 */       if (p > pow) {
/*     */         continue;
/*     */       }
/* 147 */       if (p < ap && (a.ctx() != t.x() || a.cty() != t.y())) {
/* 148 */         GUTIL.flooder().done();
/* 149 */         return (COORDINATE)t;
/*     */       } 
/*     */ 
/*     */       
/* 153 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 154 */         DIR d = (DIR)DIR.ALL.get(di);
/* 155 */         if ((WORLD.PATH()).map.can((COORDINATE)t, d))
/* 156 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance()); 
/*     */       } 
/*     */     } 
/* 159 */     GUTIL.flooder().done();
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double enemyPower(Faction f, int tx, int ty) {
/* 165 */     double pow = 0.0D;
/* 166 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 167 */     if (reg != null && enemies(f, reg.faction())) {
/* 168 */       pow += (RD.MILITARY()).power.getD(reg);
/*     */     }
/*     */     
/* 171 */     if ((WORLD.PATH()).map.is.is(tx, ty))
/*     */     {
/* 173 */       for (int di = 0; di < DIR.ALLC.size(); di++) {
/* 174 */         DIR d = (DIR)DIR.ALLC.get(di);
/* 175 */         if (d == DIR.C || (WORLD.PATH()).map.can(tx, ty, d)) {
/*     */           
/* 177 */           int dx = tx + d.x();
/* 178 */           int dy = ty + d.y();
/*     */           
/* 180 */           for (WArmy a : (WORLD.ENTITIES()).armies.fillTile(dx, dy)) {
/* 181 */             if (a.ctx() == dx && a.cty() == dy && 
/* 182 */               enemies(f, a.faction())) {
/* 183 */               pow += AD.power().get(a);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 191 */     return pow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class Pair
/*     */   {
/* 198 */     public final ArrayList<WArmy> a = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/* 199 */     public final ArrayList<WArmy> b = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   }
/*     */   
/* 202 */   private static CharSequence ¤¤lost = "Settlement lost!";
/* 203 */   private static CharSequence ¤¤lostC = "Region of {0} has fallen to our enemies.";
/*     */   
/* 205 */   private static CharSequence ¤¤factionMove = "Capital Relocated";
/* 206 */   private static CharSequence ¤¤factionMoveD = "The faction of {0} has moved its capital. Its people still resist.";
/*     */   
/*     */   static {
/* 209 */     D.ts(Util.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void conquer(Side side, double devistation, double death, Region reg, Faction newFaction) {
/* 215 */     Faction fAttacker = ((Side.SideUnit)side.us.get(0)).faction();
/* 216 */     Faction fDefender = reg.faction();
/*     */     
/* 218 */     if (fDefender == FACTIONS.player()) {
/* 219 */       Str.TMP.clear().add(¤¤lostC).insert(0, (CharSequence)reg.info.name());
/* 220 */       (new MessageText(¤¤lost)).paragraph((CharSequence)Str.TMP).send();
/* 221 */     } else if (fDefender != null && fDefender.capitolRegion() == reg) {
/* 222 */       Region newCapitol = reg;
/* 223 */       int ri = Rnd.i(reg.faction().realm().all().size());
/* 224 */       for (int i = 0; i < reg.faction().realm().all().size(); i++) {
/* 225 */         Region r = (Region)reg.faction().realm().all().get((i + ri) % reg.faction().realm().all().size());
/* 226 */         if (r != newCapitol) {
/* 227 */           newCapitol = r;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 232 */       double pow = ((Side.SideUnit)side.us.get(0)).power();
/* 233 */       if (fAttacker != null) {
/* 234 */         pow = (AD.power().get(fAttacker) / 2);
/*     */       }
/*     */       
/* 237 */       if (newCapitol == reg || (AD.power().get(fDefender) < pow && Rnd.oneIn(reg.faction().realm().all().size()))) {
/* 238 */         FACTIONS.remove((FactionNPC)fDefender, true);
/*     */       } else {
/*     */         
/* 241 */         Str.TMP.clear().add(¤¤factionMoveD).insert(0, Faction.name(fDefender));
/* 242 */         WORLD.LOG().log(null, fDefender, (UI.icons()).s.arrow_right, (CharSequence)Str.TMP, newCapitol.cx(), newCapitol.cy());
/* 243 */         (new MessageText(¤¤factionMove)).paragraph((CharSequence)Str.TMP).send();
/*     */         
/* 245 */         newCapitol.setCapitol();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 251 */     double dev = (RD.DEVASTATION()).current.getD(reg);
/* 252 */     dev += devistation;
/* 253 */     dev = CLAMP.d(dev, 0.0D, 1.0D);
/* 254 */     (RD.DEVASTATION()).current.setD(reg, dev);
/*     */ 
/*     */     
/* 257 */     if (newFaction == FACTIONS.player() && RD.OWNER().prevOwner(reg) != FACTIONS.player()) {
/* 258 */       for (RDBuilding bu : (RD.BUILDINGS()).all) {
/*     */ 
/*     */         
/* 261 */         if (bu.level.get(reg) > 0) {
/* 262 */           bu.level.set(reg, 0);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 268 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/*     */ 
/*     */       
/* 271 */       if (bu.level.get(reg) > 0) {
/* 272 */         double ll = bu.level.get(reg) * devistation;
/* 273 */         int l = (int)ll;
/* 274 */         ll -= l;
/* 275 */         if (ll > Rnd.f())
/* 276 */           l++; 
/* 277 */         bu.level.set(reg, l);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 282 */     for (RDRace r : (RD.RACES()).all) {
/* 283 */       int tot = r.pop.get(reg);
/* 284 */       int nn = (int)(1.0D + tot * (1.0D - death));
/* 285 */       nn = CLAMP.i(nn, 1, tot);
/* 286 */       r.pop.set(reg, nn);
/*     */     } 
/*     */     
/* 289 */     BattleListener.notify(side, reg);
/* 290 */     reg.fationSet(newFaction, true);
/*     */   }
/*     */ 
/*     */   
/* 294 */   private static double[] needs = null;
/*     */ 
/*     */   
/*     */   public static void ship(Side toSide, Side fromSide, int[] slaves, int[] loot) {
/* 298 */     if (needs == null) {
/* 299 */       needs = new double[(AD.supplies()).all.size()];
/*     */     }
/*     */     
/* 302 */     Shipment s = null;
/*     */     
/* 304 */     Faction to = ((Side.SideUnit)toSide.us.get(0)).faction();
/*     */     
/* 306 */     if (to != null && to.capitolRegion() != null) {
/* 307 */       for (Race r : RACES.all()) {
/* 308 */         if (slaves[r.index] > 0) {
/* 309 */           if (s == null) {
/* 310 */             s = (WORLD.ENTITIES()).caravans.create(((Side.SideUnit)fromSide.us.get(0)).x(), ((Side.SideUnit)fromSide.us.get(0)).y(), to.capitolRegion(), TRADE_TYPE.spoils);
/*     */           }
/* 312 */           if (s != null) {
/* 313 */             s.loadAndReserve((TRADABLE)TR.get(r), slaves[r.index]);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 319 */     Arrays.fill(needs, 0.0D);
/*     */     
/* 321 */     for (Side.SideUnit u : toSide.us) {
/* 322 */       if (u.a() != null && AD.men(null).get(u.a()) > 0) {
/* 323 */         WArmy a = u.a();
/* 324 */         for (ADSupply su : (AD.supplies()).all) {
/* 325 */           needs[su.index()] = needs[su.index()] + su.needed(a);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 331 */     for (Side.SideUnit u : toSide.us) {
/* 332 */       if (u.a() != null && AD.men(null).get(u.a()) > 0) {
/* 333 */         WArmy a = u.a();
/* 334 */         for (ADSupply su : (AD.supplies()).all) {
/* 335 */           double n = su.needed(a);
/* 336 */           if (n == 0.0D)
/*     */             continue; 
/* 338 */           int am = (int)Math.ceil(n * loot[su.res.index()] / needs[su.index()]);
/* 339 */           am = CLAMP.i(am, 0, loot[su.res.index()]);
/* 340 */           am = CLAMP.i(am, 0, (int)n);
/* 341 */           su.current().inc(a, am);
/* 342 */           loot[su.res.index()] = loot[su.res.index()] - am;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 348 */     if (to == null || to.capitolRegion() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 352 */     for (RESOURCE res : RESOURCES.ALL()) {
/*     */       
/* 354 */       if (loot[res.index()] > 0) {
/* 355 */         if (s == null) {
/* 356 */           s = (WORLD.ENTITIES()).caravans.create(((Side.SideUnit)fromSide.us.get(0)).x(), ((Side.SideUnit)fromSide.us.get(0)).y(), to.capitolRegion(), TRADE_TYPE.spoils);
/*     */         }
/* 358 */         if (s != null)
/* 359 */           s.loadAndReserve((TRADABLE)TR.get(res), loot[res.index()]); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Util.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */