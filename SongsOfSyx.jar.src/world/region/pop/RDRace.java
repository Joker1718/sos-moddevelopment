/*     */ package world.region.pop;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RBooster;
/*     */ import world.region.RD;
/*     */ import world.region.RData;
/*     */ 
/*     */ public class RDRace implements INDEXED {
/*  46 */   private static CharSequence ¤¤PopulationTarget = "Pop. Target";
/*  47 */   private static CharSequence ¤¤RulingSpecies = "¤Ruling Species";
/*     */ 
/*     */   
/*  50 */   private static CharSequence ¤¤Biome = "¤Species Biome";
/*     */   
/*  52 */   private static CharSequence ¤¤Armies = "¤Army presence";
/*  53 */   private static CharSequence ¤¤Representation = "¤Representation"; public final Race race;
/*     */   public final RDRacePopulation pop;
/*     */   
/*     */   static {
/*  57 */     D.ts(RDRace.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final RDRaceLoyalty loyalty;
/*     */   
/*     */   private int index;
/*     */   
/*     */   public final RDNames names;
/*     */ 
/*     */   
/*     */   RDRace(Race race, RD.RDInit init, int index) {
/*  70 */     this.race = race;
/*     */     
/*  72 */     this.index = index;
/*  73 */     double maxPop = 0.01D;
/*  74 */     double growth = 0.01D;
/*     */     
/*  76 */     this.names = new RDNames(race, init);
/*     */ 
/*     */ 
/*     */     
/*  80 */     maxPop = (race.population()).max;
/*  81 */     growth = (race.population()).growth;
/*     */ 
/*     */ 
/*     */     
/*  85 */     this.pop = new RDRacePopulation(init, race, maxPop, growth);
/*  86 */     this.loyalty = new RDRaceLoyalty(init, race);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double loyaltyTarget(Region reg) {
/*  92 */     return ((this.loyalty.get(reg) > 1) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  97 */     return this.index;
/*     */   }
/*     */   
/*     */   public static final class RDRaceLoyalty
/*     */     extends RData.RDataE
/*     */     implements RD.RDUpdatable
/*     */   {
/*     */     public final Boostable target;
/* 105 */     private static final double DTime = 8.0D / TIME.secondsPerDay();
/*     */     
/*     */     RDRaceLoyalty(RD.RDInit init, final Race race) {
/* 108 */       super("RACE_LOYALTY" + race.key, (INT_O.INT_OE)new DataO.DataByte(init.count, "RACE_LOYALTY" + race.key), init, String.valueOf(RDRaces.¤¤Loyalty) + ": " + String.valueOf(RDRaces.¤¤Loyalty));
/* 109 */       this.target = BOOSTING.push("LOYALTY_" + race.key, 0.0D, this.name, this.name, (SPRITE)(race.appearance()).iconBig, (BoostableCat.ALL()).WORLD_CIVICS);
/* 110 */       init.upers.add(this);
/* 111 */       (new RBooster(new BSourceInfo(((STATS.ENV()).OTHERS.info()).name, (SPRITE)(UI.icons()).s.citizen), 0.75D, 1.0D, true)
/*     */         {
/*     */           public double get(Region t) {
/* 114 */             double tot = (RD.RACES()).popTarget.getD(t);
/* 115 */             if (tot == 0.0D)
/* 116 */               return 0.0D; 
/* 117 */             double rr = 0.0D;
/* 118 */             for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 119 */               RDRace o = (RDRace)(RD.RACES()).all.get(ri);
/* 120 */               rr += o.pop.target(t) * race.pref().race(o.race);
/*     */             } 
/* 122 */             return CLAMP.d(rr / tot, 0.0D, 1.0D);
/*     */           }
/* 124 */         }).add(this.target);
/*     */       
/* 126 */       (new RBooster(new BSourceInfo(RDRaces.¤¤RegionCapacity, (SPRITE)(UI.icons()).s.human), 0.0D, -10.0D, false)
/*     */         {
/*     */           public double get(Region t)
/*     */           {
/* 130 */             double d = (RD.RACES()).popTarget.getD(t) / (1.0D + RD.RACES().maxPop(t) * (race.population()).max * 1.5D);
/* 131 */             d = (int)(d * 100.0D) / 100.0D;
/* 132 */             return d;
/*     */           }
/* 134 */         }).add(this.target);
/*     */       
/* 136 */       (new RBooster(new BSourceInfo(RDRace.¤¤Armies, (SPRITE)(UI.icons()).s.sword), 0.0D, 20.0D, false)
/*     */         {
/*     */           public double get(Region t) {
/* 139 */             double power = 0.0D;
/* 140 */             for (WArmy a : (WORLD.ENTITIES()).armies.fill(t)) {
/* 141 */               if (a.faction() == t.faction())
/* 142 */                 power += AD.power().get(a); 
/* 143 */             }  return power / ((RD.RACES()).pop.get(t) + 1);
/*     */           }
/* 145 */         }).add(this.target);
/*     */       
/* 147 */       (new RBooster(new BSourceInfo(String.valueOf(RDRace.¤¤Representation) + " (" + String.valueOf(RDRace.¤¤Representation), (SPRITE)(UI.icons()).s.human), 0.75D, 1.25D, true)
/*     */         {
/*     */           protected double get(Region reg)
/*     */           {
/* 151 */             int cit = POP.tot(HCLASSES.CITIZEN(), race);
/* 152 */             int slaves = POP.tot(HCLASSES.SLAVE(), race);
/* 153 */             int tot = POP.tot(null) + 1;
/* 154 */             if (cit == 0) {
/* 155 */               if (slaves > 0)
/* 156 */                 return 0.5D - CLAMP.d(250.0D * slaves / tot, 0.0D, 0.5D); 
/* 157 */               return 0.5D;
/*     */             } 
/* 159 */             return CLAMP.d(0.5D + 0.5D * RACES.playable().size() * cit / tot, 0.5D, 1.0D);
/*     */           }
/* 162 */         }).add(this.target);
/*     */       
/* 164 */       (new RBooster(new BSourceInfo(String.valueOf(RDRace.¤¤Representation) + ": " + String.valueOf(RDRace.¤¤Representation), (SPRITE)(UI.icons()).s.noble), 0.75D, 1.25D, true)
/*     */         {
/*     */           protected double get(Region reg)
/*     */           {
/* 168 */             int cit = POP.tot(HCLASSES.NOBLE(), race);
/* 169 */             int tot = POP.tot(HCLASSES.NOBLE(), null);
/* 170 */             if (cit == 0) {
/* 171 */               if (tot > RACES.playable().size())
/* 172 */                 return CLAMP.d(0.5D - (tot - RACES.playable().size()) / 4.0D, 0.0D, 0.5D); 
/* 173 */               return 0.5D;
/*     */             } 
/* 175 */             return CLAMP.d(0.5D + 0.5D * cit / tot, 0.5D, 1.0D);
/*     */           }
/* 178 */         }).add(this.target);
/*     */       
/* 180 */       BOOSTING.connecter(new ACTION()
/*     */           {
/*     */ 
/*     */             
/*     */             public void exe()
/*     */             {
/* 186 */               double to = ((STATS.BATTLE()).WAR.standing.definition(race)).mul;
/* 187 */               if (((STATS.BATTLE()).WAR.standing.definition(race)).inverted) {
/* 188 */                 to = -to;
/*     */               }
/* 190 */               (new RBooster(new BSourceInfo(((STATS.BATTLE()).WAR.info()).name, (SPRITE)(UI.icons()).s.sword), 0.0D, to, false)
/*     */                 {
/*     */                   protected double get(Region reg)
/*     */                   {
/* 194 */                     return CLAMP.d((STATS.BATTLE()).WAR.data(HCLASSES.CITIZEN()).getD(race, 0), 0.0D, 1.0D);
/*     */                   }
/* 196 */                 }).add(RDRace.RDRaceLoyalty.this.target);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(Region reg, double time) {
/* 206 */       double d = increase(reg) * DTime * time;
/* 207 */       moveTo(reg, Math.abs(d), (d < 0.0D) ? 0 : 255);
/*     */     }
/*     */     
/*     */     public double increase(Region reg) {
/* 211 */       return (int)(this.target.get((BOOSTABLE_O)reg) * 10.0D) / 10.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void init(Region reg) {
/* 216 */       double d = this.target.get((BOOSTABLE_O)reg);
/* 217 */       set(reg, (d < 0.0D) ? 0 : 255);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class RDRacePopulation
/*     */     extends RData.RDataE
/*     */     implements RD.RDUpdatable
/*     */   {
/*     */     public final double maxPopulation;
/*     */     public final double growthBase;
/*     */     public final Boostable dtarget;
/*     */     public final Boostable growth;
/* 229 */     private static final double DTime = 1.0D / TIME.secondsPerDay();
/*     */     public final BoosterImp biome;
/*     */     
/*     */     RDRacePopulation(RD.RDInit init, final Race race, double max, final double growthBase) {
/* 233 */       super("RACEPOP" + race.key, count(init, race), init, String.valueOf(Dic.¤¤Population) + ": " + String.valueOf(Dic.¤¤Population));
/* 234 */       init.upers.add(this);
/* 235 */       this.maxPopulation = max;
/* 236 */       this.growthBase = growthBase;
/* 237 */       this.dtarget = BOOSTING.push("POPULATION_TARGET_" + race.key, 1.0D, String.valueOf(RDRace.¤¤PopulationTarget) + ": " + String.valueOf(RDRace.¤¤PopulationTarget), race.info.names, (SPRITE)(race.appearance()).iconBig, (BoostableCat.ALL()).WORLD_CIVICS);
/* 238 */       this.growth = BOOSTING.push("POPULATION_GROWTH_" + race.key, 1.0D, String.valueOf(Dic.¤¤Growth) + ": " + String.valueOf(Dic.¤¤Growth), race.info.names, (SPRITE)(race.appearance()).iconBig, (BoostableCat.ALL()).WORLD_CIVICS);
/* 239 */       this.biome = (BoosterImp)new RBooster(new BSourceInfo(RDRace.¤¤Biome, (SPRITE)(UI.icons()).s.temperature), 0.1D, 2.0D, true)
/*     */         {
/*     */           public double get(Region reg)
/*     */           {
/* 243 */             double c = 0.0D;
/* 244 */             for (int i = 0; i < CLIMATES.ALL().size(); i++) {
/* 245 */               c += reg.info.climate((CLIMATE)CLIMATES.ALL().get(i)) * race.population().climate((CLIMATE)CLIMATES.ALL().get(i));
/*     */             }
/* 247 */             double t = 0.0D;
/* 248 */             for (int j = 0; j < TERRAINS.ALL().size(); j++)
/* 249 */               t += reg.info.terrain((TERRAIN)TERRAINS.ALL().get(j)) * race.population().terrain((TERRAIN)TERRAINS.ALL().get(j)); 
/* 250 */             return c * t;
/*     */           }
/*     */         };
/* 253 */       this.biome.add(this.dtarget);
/*     */ 
/*     */ 
/*     */       
/* 257 */       (new RBooster(new BSourceInfo(RDRace.¤¤RulingSpecies, (SPRITE)(UI.icons()).s.crown), 1.0D, 1.2D, true)
/*     */         {
/*     */           public double get(Region t) {
/* 260 */             if (t.faction() != null && t.faction().race() == race)
/* 261 */               return 1.0D; 
/* 262 */             return 0.0D;
/*     */           }
/* 264 */         }).add(this.dtarget);
/*     */       
/* 266 */       (new RBooster(new BSourceInfo(Dic.¤¤Base, (SPRITE)(UI.icons()).s.cancel), 0.0D, 1.0D, true)
/*     */         {
/*     */           public double get(Region t) {
/* 269 */             return growthBase;
/*     */           }
/* 271 */         }).add(this.growth);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 284 */       GVALUES.REGION.pushI("POPULATION_RACE_" + race.key, String.valueOf(Dic.¤¤Population) + ": " + String.valueOf(Dic.¤¤Population), (SPRITE)(race.appearance()).iconBig, (INT_O)this);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(Region reg, double time) {
/* 290 */       int t = target(reg);
/* 291 */       int pop = get(reg);
/*     */       
/* 293 */       if (t > pop && reg.faction() != null) {
/* 294 */         double pp = (pop + 10) * Math.max(0.0D, growth(reg)) * time * DTime;
/* 295 */         int inc = (int)pp;
/* 296 */         if (pp - inc > RND.rFloat())
/* 297 */           inc++; 
/* 298 */         pop += inc;
/* 299 */         if (pop > t)
/* 300 */           pop = t; 
/* 301 */         set(reg, pop);
/*     */       } else {
/* 303 */         double pp = (pop + 10) * time * DTime;
/* 304 */         int inc = (int)pp;
/* 305 */         if (pp - inc > RND.rFloat())
/* 306 */           inc++; 
/* 307 */         pop -= inc;
/* 308 */         if (pop < t)
/* 309 */           pop = t; 
/* 310 */         set(reg, pop);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void init(Region reg) {
/* 317 */       clearCaache();
/* 318 */       set(reg, target(reg));
/*     */     }
/*     */     
/*     */     public int target(Region reg) {
/* 322 */       double d = dtarget(reg);
/* 323 */       d *= RD.RACES().capacity(reg);
/* 324 */       d *= this.maxPopulation;
/* 325 */       d = CLAMP.d(d, 0.0D, 50000.0D);
/* 326 */       return (int)Math.round(d);
/*     */     }
/*     */     
/*     */     public double dtarget(Region reg) {
/* 330 */       double d = this.dtarget.get((BOOSTABLE_O)reg);
/* 331 */       double tot = totdTarget.getD(reg);
/* 332 */       if (tot > 0.0D)
/* 333 */         d /= tot; 
/* 334 */       return Math.round(d * 100.0D) / 100.0D;
/*     */     }
/*     */     
/*     */     public double growth(Region reg) {
/* 338 */       double n = get(reg);
/* 339 */       int t = target(reg);
/* 340 */       if (t == n)
/* 341 */         return 0.0D; 
/* 342 */       if (t < n) {
/* 343 */         double d = (t - n) / n;
/* 344 */         return d;
/*     */       } 
/* 346 */       return this.growth.get((BOOSTABLE_O)reg);
/*     */     }
/*     */ 
/*     */     
/*     */     public double base(Region reg) {
/* 351 */       return this.biome.get(reg);
/*     */     }
/*     */     
/* 354 */     private static int upI = -1;
/*     */     static void clearCaache() {
/* 356 */       upI = -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(Region t, int i) {
/* 361 */       super.set(t, i);
/*     */     }
/*     */     
/* 364 */     private static final DOUBLE_O<Region> totdTarget = new DOUBLE_O<Region>()
/*     */       {
/*     */         
/* 367 */         private Region upR = null;
/*     */         
/*     */         private double cache;
/*     */         
/*     */         public double getD(Region t) {
/* 372 */           if (RDRace.RDRacePopulation.upI != GAME.updateI() || this.upR != t) {
/* 373 */             RDRace.RDRacePopulation.upI = GAME.updateI();
/* 374 */             this.upR = t;
/* 375 */             this.cache = 0.0D;
/* 376 */             for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 377 */               this.cache += ((RDRace)(RD.RACES()).all.get(ri)).pop.dtarget.get((BOOSTABLE_O)t);
/*     */             }
/*     */           } 
/* 380 */           return this.cache;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     private static INT_O.INT_OE<Region> count(RD.RDInit init, Race race) {
/* 386 */       return (INT_O.INT_OE<Region>)new DataO<Region>.DataShortE(init.count, "RACEPOP" + race.key)
/*     */         {
/*     */           public void set(Region t, int s)
/*     */           {
/* 390 */             (RD.RACES()).pop.set(t, (RD.RACES()).population.get(t) - get(t));
/* 391 */             super.set(t, s);
/* 392 */             (RD.RACES()).pop.set(t, (RD.RACES()).population.get(t) + get(t));
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RDNames
/*     */   {
/*     */     public final RDRace.RDNameList intros;
/*     */     
/*     */     public final RDRace.RDNameList fNames;
/*     */     
/*     */     public final RDRace.RDNameList rIntro;
/*     */     
/*     */     public final RDRace.RDNameList rNames;
/*     */ 
/*     */     
/*     */     RDNames(Race r, RD.RDInit init) {
/* 411 */       this.intros = new RDRace.RDNameList(r.info.winfo.intros);
/* 412 */       this.fNames = new RDRace.RDNameList(r.info.winfo.fNames);
/* 413 */       this.rIntro = new RDRace.RDNameList(r.info.winfo.rIntro);
/* 414 */       this.rNames = new RDRace.RDNameList(r.info.winfo.rNames);
/*     */       
/* 416 */       init.savable.add(new SAVABLE()
/*     */           {
/*     */             public void save(FilePutter file)
/*     */             {
/* 420 */               file.i(RDRace.RDNames.this.intros.i);
/* 421 */               file.i(RDRace.RDNames.this.fNames.i);
/* 422 */               file.i(RDRace.RDNames.this.rIntro.i);
/* 423 */               file.i(RDRace.RDNames.this.rNames.i);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void load(FileGetter file) throws IOException {
/* 429 */               RDRace.RDNames.this.intros.i = file.i();
/* 430 */               RDRace.RDNames.this.fNames.i = file.i();
/* 431 */               RDRace.RDNames.this.rIntro.i = file.i();
/* 432 */               RDRace.RDNames.this.rNames.i = file.i();
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void clear() {}
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RDNameList
/*     */   {
/* 449 */     private int i = 0;
/*     */     private final ArrayList<String> all;
/*     */     
/*     */     private RDNameList(String[] nn) {
/* 453 */       this.all = new ArrayList((Object[])nn);
/* 454 */       this.i = RND.rInt(this.all.size());
/*     */     }
/*     */     
/*     */     public String next() {
/* 458 */       this.i %= this.all.size();
/* 459 */       String s = (String)this.all.get(this.i);
/* 460 */       if (FACTIONS.player() != null && Str.isSame(s, (CharSequence)(FACTIONS.player()).name)) {
/* 461 */         this.i++;
/* 462 */         this.i %= this.all.size();
/* 463 */         s = (String)this.all.get(this.i);
/*     */       } 
/* 465 */       this.i++;
/* 466 */       return s;
/*     */     }
/*     */     
/*     */     public String get(int index) {
/* 470 */       return (String)this.all.get(index);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */