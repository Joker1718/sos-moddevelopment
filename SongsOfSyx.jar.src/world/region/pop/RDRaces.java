/*     */ package world.region.pop;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.map.regions.RegionInfo;
/*     */ import world.region.RBooster;
/*     */ import world.region.RD;
/*     */ import world.region.RData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RDRaces
/*     */ {
/*  40 */   public static CharSequence ¤¤Loyalty = "¤Loyalty";
/*  41 */   public static CharSequence ¤¤LoyaltyD = "¤Current Loyalty. Loyalty determines the chance of rebellion. Loyalty changes slowly based on the target. Increase loyalty by allocating admin points into loyalty boosting areas. Loyalty will also increase the longer a region has belonged to you. Loyalty is species specific.";
/*  42 */   static CharSequence ¤¤RegionCapacity = "¤Region Capacity";
/*  43 */   private static CharSequence ¤¤RegionCapacityD = "¤Region Population capacity.";
/*     */   public RDRaces(RD.RDInit init) {
/*  45 */     D.ts(RDRaces.class);
/*     */ 
/*     */     
/*  48 */     this.map = new RDRace[RACES.all().size()];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     this.mCapacity = (Config.world()).POPULATION_CAPACITY_MAX;
/*     */ 
/*     */     
/*  66 */     this.popTarget = new DOUBLE_O.DoubleOCached<Region>()
/*     */       {
/*     */         public double getValue(Region t)
/*     */         {
/*  70 */           double cache = 0.0D;
/*  71 */           for (int ri = 0; ri < RDRaces.this.all.size(); ri++) {
/*  72 */             cache += ((RDRace)RDRaces.this.all.get(ri)).pop.target(t);
/*     */           }
/*  74 */           return cache;
/*     */         }
/*     */       };
/*     */     
/*  78 */     this.loyaltyAll = new DOUBLE_O<Region>()
/*     */       {
/*  80 */         final INFO info = new INFO(RDRaces.¤¤Loyalty, RDRaces.¤¤LoyaltyD);
/*     */ 
/*     */         
/*     */         public double getD(Region t) {
/*  84 */           double d = 0.0D;
/*  85 */           for (RDRace r : RDRaces.this.all) {
/*  86 */             d += r.pop.get(t) * r.loyalty.getD(t);
/*     */           }
/*  88 */           if (RDRaces.this.population.get(t) > 0)
/*  89 */             d /= RDRaces.this.population.get(t); 
/*  90 */           return d;
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/*  95 */           return this.info;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 101 */     this.capacityCurrent = new INT_O<Region>()
/*     */       {
/*     */ 
/*     */         
/*     */         public int get(Region t)
/*     */         {
/* 107 */           double cc = 0.0D;
/* 108 */           for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 109 */             RDRace r = (RDRace)(RD.RACES()).all.get(ri);
/* 110 */             cc += r.pop.get(t) / r.pop.maxPopulation;
/*     */           } 
/* 112 */           return (int)cc;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Region t) {
/* 117 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Region t) {
/* 122 */           return Integer.MAX_VALUE;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 129 */     this.capacity = BOOSTING.push("POPULATION_CAPACITY", 1.0D, ¤¤RegionCapacity, ¤¤RegionCapacityD, (SPRITE)(UI.icons()).s.human, (BoostableCat.ALL()).WORLD, 0.0D);
/* 130 */     GVALUES.REGION.pushI("POPULATION_CAPACITY_USED", ¤¤RegionCapacity, (SPRITE)(UI.icons()).s.human, this.capacityCurrent);
/*     */ 
/*     */     
/* 133 */     (new RBooster(new BSourceInfo(Dic.¤¤Area, (SPRITE)(UI.icons()).s.expand), 0.0D, 32768.0D, true)
/*     */       {
/*     */         public double get(Region t)
/*     */         {
/* 137 */           double a = t.info.area();
/* 138 */           a = CLAMP.d(a, 50.0D, 2.147483647E9D);
/* 139 */           return a / 32768.0D;
/*     */         }
/* 143 */       }).add(this.capacity);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     (new RBooster(new BSourceInfo(Ground.¤¤moisture, (SPRITE)(UI.icons()).s.sprout), 0.2D, 1.0D, true)
/*     */       {
/*     */         public double get(Region t)
/*     */         {
/* 159 */           return t.info.moisture();
/*     */         }
/* 164 */       }).add(this.capacity);
/*     */     
/* 166 */     init.count.getClass(); this.pop = new RData.RDataE("POPULATION", (INT_O.INT_OE)new DataO.DataInt(init.count, "POPULATION"), init, Dic.¤¤Population);
/* 167 */     this.population = (RData)this.pop;
/*     */ 
/*     */     
/* 170 */     GVALUES.REGION.pushI("POPULATION", Dic.¤¤Population, (SPRITE)(UI.icons()).s.human, (INT_O)this.pop);
/* 171 */     GVALUES.REGION.pushI("POPULATION_TARGET", String.valueOf(Dic.¤¤Population) + ": " + String.valueOf(Dic.¤¤Population), (SPRITE)(UI.icons()).s.human, new INT_O<Region>()
/*     */         {
/*     */           public int get(Region t)
/*     */           {
/* 175 */             return (int)RDRaces.this.popTarget.getD(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Region t) {
/* 180 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Region t) {
/* 185 */             return Integer.MAX_VALUE;
/*     */           }
/*     */         });
/*     */     
/* 189 */     GVALUES.FACTION.pushI("POPULATION_KINGDOM", String.valueOf(Dic.¤¤Population) + ": " + String.valueOf(Dic.¤¤Population), (SPRITE)(UI.icons()).s.human, new INT_O<Faction>()
/*     */         {
/*     */           public int get(Faction t)
/*     */           {
/* 193 */             if (t == null)
/* 194 */               return 0; 
/* 195 */             return RDRaces.this.pop.faction().get(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Faction t) {
/* 200 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Faction t) {
/* 205 */             return Integer.MAX_VALUE;
/*     */           }
/*     */         });
/*     */     
/* 209 */     GVALUES.REGION.pushI("POPULATION_KINGDOM", String.valueOf(Dic.¤¤Population) + ": " + String.valueOf(Dic.¤¤Population), (SPRITE)(UI.icons()).s.human, new INT_O<Region>()
/*     */         {
/*     */           public int get(Region t)
/*     */           {
/* 213 */             if (t.faction() == null)
/* 214 */               return 0; 
/* 215 */             return RDRaces.this.pop.faction().get(t.faction());
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Region t) {
/* 220 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Region t) {
/* 225 */             return Integer.MAX_VALUE;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 230 */     ArrayList<RDRace> all = new ArrayList(RACES.playable().size());
/*     */     
/* 232 */     for (Race r : RACES.playable()) {
/* 233 */       RDRace rr = new RDRace(r, init, all.size());
/* 234 */       this.map[r.index()] = rr;
/* 235 */       all.add(this.map[r.index()]);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 240 */     this.all = (LIST<RDRace>)all;
/* 241 */     this.visuals = new Visuals(init);
/*     */     
/* 243 */     this.edicts = new RDEdicts((LIST<RDRace>)all, init);
/*     */   }
/*     */ 
/*     */   
/*     */   private final RDRace[] map;
/*     */   
/*     */   public final LIST<RDRace> all;
/*     */   
/*     */   public final Boostable capacity;
/*     */   
/*     */   public final RDEdicts edicts;
/*     */   
/*     */   final RData.RDataE pop;
/*     */   
/*     */   public final RData population;
/*     */   public final Visuals visuals;
/*     */   private final double mCapacity;
/*     */   public final DOUBLE_O.DoubleOCached<Region> popTarget;
/*     */   public final DOUBLE_O<Region> loyaltyAll;
/*     */   public INT_O<Region> capacityCurrent;
/*     */   
/*     */   public void init() {}
/*     */   
/*     */   public RDRace get(Race race) {
/* 267 */     return this.map[race.index];
/*     */   }
/*     */   
/*     */   public double maxPopReg() {
/* 271 */     return this.mCapacity * (RegionInfo.vArea()).ave;
/*     */   }
/*     */   
/*     */   public double maxPop(Region reg) {
/* 275 */     if (reg != null && reg.capitol())
/* 276 */       return 40000.0D; 
/* 277 */     return this.mCapacity * (RegionInfo.vArea()).ave;
/*     */   }
/*     */   
/*     */   public double popSizeD(Region reg) {
/* 281 */     if (reg.capitol()) {
/* 282 */       return this.population.get(reg) / 40000.0D;
/*     */     }
/*     */     
/* 285 */     return this.population.get(reg) / this.mCapacity * reg.info.area();
/*     */   }
/*     */   
/*     */   public double popSize(Region reg) {
/* 289 */     return CLAMP.d(this.population.get(reg) / maxPop(reg), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public double popSizeTarget(Region reg) {
/* 293 */     return CLAMP.d(this.popTarget.getD(reg) / maxPop(reg), 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double capacity(Region reg) {
/* 298 */     if (reg.faction() == FACTIONS.player()) {
/* 299 */       return this.capacity.get((BOOSTABLE_O)reg);
/*     */     }
/* 301 */     double fa = this.mCapacity * reg.info.area() * (0.2D + reg.info.moisture() * 0.8D) * (0.5D + RD.RAN().getD(reg, 0));
/*     */     
/* 303 */     if (reg.faction() instanceof FactionNPC) {
/*     */ 
/*     */       
/* 306 */       double min = fa * 0.1D;
/* 307 */       double max = fa;
/*     */       
/* 309 */       FactionNPC f = (FactionNPC)reg.faction();
/*     */ 
/*     */       
/* 312 */       double empireSize = f.realm().ferArea() / 10.0D * (RegionInfo.vArea()).ave * (RegionInfo.vFer()).ave;
/* 313 */       empireSize = CLAMP.d(empireSize, 0.0D, 1.0D);
/*     */       
/* 315 */       double competence = f.court().king().size();
/* 316 */       if (reg.capitol()) {
/* 317 */         return min + (40000.0D - min) * competence * empireSize;
/*     */       }
/*     */       
/* 320 */       return min + (max - min) * competence * Math.pow(empireSize, 0.5D);
/*     */     } 
/* 322 */     return fa * 0.1D;
/*     */   }
/*     */ 
/*     */   
/*     */   public final class Visuals
/*     */   {
/*     */     private final INT_O.INT_OE<Region> cRace;
/*     */     
/*     */     private final INT_O.INT_OE<Region> cacheI;
/*     */     
/* 332 */     private final ArrayList<INT_O.INT_OE<Region>> vVill = new ArrayList(16);
/*     */     
/*     */     private Visuals(RD.RDInit init) {
/* 335 */       if (RDRaces.this.all.size() > 255)
/* 336 */         throw new RuntimeException("too many races"); 
/* 337 */       init.count.getClass(); this.cRace = (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "VISUALS_RACE");
/* 338 */       init.count.getClass(); this.cacheI = (INT_O.INT_OE<Region>)new DataO.DataNibble(init.count, "VISUALS_RACEI");
/* 339 */       while (this.vVill.hasRoom())
/* 340 */         this.vVill.add(new DataO.DataByte(init.count, "VISUALS_RACE?" + this.vVill.size())); 
/*     */     }
/*     */     
/*     */     public Race cRace(Region reg) {
/* 344 */       cache(reg);
/* 345 */       return ((RDRace)RDRaces.this.all.get(this.cRace.get(reg))).race;
/*     */     }
/*     */     
/*     */     public Race vRace(Region reg, int ran) {
/* 349 */       cache(reg);
/* 350 */       ran &= 0xF;
/* 351 */       return ((RDRace)RDRaces.this.all.get(((INT_O.INT_OE)this.vVill.get(ran)).get(reg))).race;
/*     */     }
/*     */     
/*     */     private void cache(Region reg) {
/* 355 */       int ri = 15 - (VIEW.RI() >> 6 & 0xF);
/* 356 */       if (this.cacheI.get(reg) == ri)
/*     */         return; 
/* 358 */       this.cacheI.set(reg, ri);
/* 359 */       RDRace biggest = null;
/* 360 */       int bb = -1;
/* 361 */       int vi = 0;
/* 362 */       for (int rri = 0; rri < RDRaces.this.all.size(); rri++) {
/* 363 */         RDRace r = (RDRace)RDRaces.this.all.get(rri);
/* 364 */         if (r.pop.get(reg) > bb) {
/* 365 */           biggest = r;
/* 366 */           bb = r.pop.get(reg);
/*     */         } 
/* 368 */         if (RDRaces.this.population.get(reg) > 0) {
/* 369 */           int vam = 16 * r.pop.get(reg) / RDRaces.this.population.get(reg);
/* 370 */           for (int i = 0; i < vam && vi < 16; i++) {
/* 371 */             ((INT_O.INT_OE)this.vVill.get(vi++)).set(reg, r.index());
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 376 */       this.cRace.set(reg, biggest.index());
/*     */       
/* 378 */       for (; vi < 16; vi++)
/* 379 */         ((INT_O.INT_OE)this.vVill.get(vi)).set(reg, biggest.index()); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDRaces.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */