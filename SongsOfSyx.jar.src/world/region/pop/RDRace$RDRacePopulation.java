/*     */ package world.region.pop;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import init.value.GVALUES;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RBooster;
/*     */ import world.region.RD;
/*     */ import world.region.RData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RDRacePopulation
/*     */   extends RData.RDataE
/*     */   implements RD.RDUpdatable
/*     */ {
/*     */   public final double maxPopulation;
/*     */   public final double growthBase;
/*     */   public final Boostable dtarget;
/*     */   public final Boostable growth;
/* 229 */   private static final double DTime = 1.0D / TIME.secondsPerDay();
/*     */   public final BoosterImp biome;
/*     */   
/*     */   RDRacePopulation(RD.RDInit init, final Race race, double max, final double growthBase) {
/* 233 */     super("RACEPOP" + race.key, count(init, race), init, String.valueOf(Dic.¤¤Population) + ": " + String.valueOf(Dic.¤¤Population));
/* 234 */     init.upers.add(this);
/* 235 */     this.maxPopulation = max;
/* 236 */     this.growthBase = growthBase;
/* 237 */     this.dtarget = BOOSTING.push("POPULATION_TARGET_" + race.key, 1.0D, String.valueOf(RDRace.¤¤PopulationTarget) + ": " + String.valueOf(RDRace.¤¤PopulationTarget), race.info.names, (SPRITE)(race.appearance()).iconBig, (BoostableCat.ALL()).WORLD_CIVICS);
/* 238 */     this.growth = BOOSTING.push("POPULATION_GROWTH_" + race.key, 1.0D, String.valueOf(Dic.¤¤Growth) + ": " + String.valueOf(Dic.¤¤Growth), race.info.names, (SPRITE)(race.appearance()).iconBig, (BoostableCat.ALL()).WORLD_CIVICS);
/* 239 */     this.biome = (BoosterImp)new RBooster(new BSourceInfo(RDRace.¤¤Biome, (SPRITE)(UI.icons()).s.temperature), 0.1D, 2.0D, true)
/*     */       {
/*     */         public double get(Region reg)
/*     */         {
/* 243 */           double c = 0.0D;
/* 244 */           for (int i = 0; i < CLIMATES.ALL().size(); i++) {
/* 245 */             c += reg.info.climate((CLIMATE)CLIMATES.ALL().get(i)) * race.population().climate((CLIMATE)CLIMATES.ALL().get(i));
/*     */           }
/* 247 */           double t = 0.0D;
/* 248 */           for (int j = 0; j < TERRAINS.ALL().size(); j++)
/* 249 */             t += reg.info.terrain((TERRAIN)TERRAINS.ALL().get(j)) * race.population().terrain((TERRAIN)TERRAINS.ALL().get(j)); 
/* 250 */           return c * t;
/*     */         }
/*     */       };
/* 253 */     this.biome.add(this.dtarget);
/*     */ 
/*     */ 
/*     */     
/* 257 */     (new RBooster(new BSourceInfo(RDRace.¤¤RulingSpecies, (SPRITE)(UI.icons()).s.crown), 1.0D, 1.2D, true)
/*     */       {
/*     */         public double get(Region t) {
/* 260 */           if (t.faction() != null && t.faction().race() == race)
/* 261 */             return 1.0D; 
/* 262 */           return 0.0D;
/*     */         }
/* 264 */       }).add(this.dtarget);
/*     */     
/* 266 */     (new RBooster(new BSourceInfo(Dic.¤¤Base, (SPRITE)(UI.icons()).s.cancel), 0.0D, 1.0D, true)
/*     */       {
/*     */         public double get(Region t) {
/* 269 */           return growthBase;
/*     */         }
/* 271 */       }).add(this.growth);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     GVALUES.REGION.pushI("POPULATION_RACE_" + race.key, String.valueOf(Dic.¤¤Population) + ": " + String.valueOf(Dic.¤¤Population), (SPRITE)(race.appearance()).iconBig, (INT_O)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Region reg, double time) {
/* 290 */     int t = target(reg);
/* 291 */     int pop = get(reg);
/*     */     
/* 293 */     if (t > pop && reg.faction() != null) {
/* 294 */       double pp = (pop + 10) * Math.max(0.0D, growth(reg)) * time * DTime;
/* 295 */       int inc = (int)pp;
/* 296 */       if (pp - inc > RND.rFloat())
/* 297 */         inc++; 
/* 298 */       pop += inc;
/* 299 */       if (pop > t)
/* 300 */         pop = t; 
/* 301 */       set(reg, pop);
/*     */     } else {
/* 303 */       double pp = (pop + 10) * time * DTime;
/* 304 */       int inc = (int)pp;
/* 305 */       if (pp - inc > RND.rFloat())
/* 306 */         inc++; 
/* 307 */       pop -= inc;
/* 308 */       if (pop < t)
/* 309 */         pop = t; 
/* 310 */       set(reg, pop);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Region reg) {
/* 317 */     clearCaache();
/* 318 */     set(reg, target(reg));
/*     */   }
/*     */   
/*     */   public int target(Region reg) {
/* 322 */     double d = dtarget(reg);
/* 323 */     d *= RD.RACES().capacity(reg);
/* 324 */     d *= this.maxPopulation;
/* 325 */     d = CLAMP.d(d, 0.0D, 50000.0D);
/* 326 */     return (int)Math.round(d);
/*     */   }
/*     */   
/*     */   public double dtarget(Region reg) {
/* 330 */     double d = this.dtarget.get((BOOSTABLE_O)reg);
/* 331 */     double tot = totdTarget.getD(reg);
/* 332 */     if (tot > 0.0D)
/* 333 */       d /= tot; 
/* 334 */     return Math.round(d * 100.0D) / 100.0D;
/*     */   }
/*     */   
/*     */   public double growth(Region reg) {
/* 338 */     double n = get(reg);
/* 339 */     int t = target(reg);
/* 340 */     if (t == n)
/* 341 */       return 0.0D; 
/* 342 */     if (t < n) {
/* 343 */       double d = (t - n) / n;
/* 344 */       return d;
/*     */     } 
/* 346 */     return this.growth.get((BOOSTABLE_O)reg);
/*     */   }
/*     */ 
/*     */   
/*     */   public double base(Region reg) {
/* 351 */     return this.biome.get(reg);
/*     */   }
/*     */   
/* 354 */   private static int upI = -1;
/*     */   static void clearCaache() {
/* 356 */     upI = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Region t, int i) {
/* 361 */     super.set(t, i);
/*     */   }
/*     */   
/* 364 */   private static final DOUBLE_O<Region> totdTarget = new DOUBLE_O<Region>()
/*     */     {
/*     */       
/* 367 */       private Region upR = null;
/*     */       
/*     */       private double cache;
/*     */       
/*     */       public double getD(Region t) {
/* 372 */         if (RDRace.RDRacePopulation.upI != GAME.updateI() || this.upR != t) {
/* 373 */           RDRace.RDRacePopulation.upI = GAME.updateI();
/* 374 */           this.upR = t;
/* 375 */           this.cache = 0.0D;
/* 376 */           for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 377 */             this.cache += ((RDRace)(RD.RACES()).all.get(ri)).pop.dtarget.get((BOOSTABLE_O)t);
/*     */           }
/*     */         } 
/* 380 */         return this.cache;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private static INT_O.INT_OE<Region> count(RD.RDInit init, Race race) {
/* 386 */     return (INT_O.INT_OE<Region>)new DataO<Region>.DataShortE(init.count, "RACEPOP" + race.key)
/*     */       {
/*     */         public void set(Region t, int s)
/*     */         {
/* 390 */           (RD.RACES()).pop.set(t, (RD.RACES()).population.get(t) - get(t));
/* 391 */           super.set(t, s);
/* 392 */           (RD.RACES()).pop.set(t, (RD.RACES()).population.get(t) + get(t));
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDRace$RDRacePopulation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */