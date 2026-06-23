/*     */ package world.region.updating;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.religion.Religion;
/*     */ import init.trade.TRADABLE;
/*     */ import java.util.Random;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Tree;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDOutputs;
/*     */ import world.region.RDReligions;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.pop.RDEdicts;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Builder
/*     */ {
/*  30 */   private final Resources res = new Resources();
/*  31 */   private final BRace race = new BRace();
/*  32 */   private final BReligion religion = new BReligion();
/*  33 */   private final BMil military = new BMil();
/*     */   
/*     */   private final BOther civic;
/*  36 */   private final RebelBuilder rebBuilder = new RebelBuilder();
/*     */   
/*     */   Builder() {
/*  39 */     LinkedList<RDBuilding> all = new LinkedList();
/*  40 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/*  41 */       all.add(bu);
/*     */     }
/*     */     
/*  44 */     for (RBuilding<?> b : this.res.all) {
/*  45 */       all.remove(b.bu);
/*     */     }
/*  47 */     for (RBuilding<?> b : this.race.all) {
/*  48 */       all.remove(b.bu);
/*     */     }
/*  50 */     for (RBuilding<?> b : this.religion.all) {
/*  51 */       all.remove(b.bu);
/*     */     }
/*  53 */     for (RBuilding<?> b : this.military.all) {
/*  54 */       all.remove(b.bu);
/*     */     }
/*  56 */     this.civic = new BOther((LIST<RDBuilding>)all);
/*     */   }
/*     */   
/*     */   public void build(Region reg) {
/*  60 */     RealmBuilder builder = this.rebBuilder;
/*  61 */     if (reg.faction() instanceof FactionNPC) {
/*  62 */       builder = (((FactionNPC)reg.faction()).court().king()).builder;
/*     */     }
/*  64 */     build(reg, builder);
/*     */   }
/*     */   
/*     */   public void build(Region reg, RealmBuilder builder) {
/*  68 */     if (builder == null) {
/*  69 */       builder = this.rebBuilder;
/*     */     }
/*  71 */     if (RD.OWNER().prevOwner(reg) == FACTIONS.player()) {
/*  72 */       for (RDBuilding bu : (RD.BUILDINGS()).all) {
/*  73 */         if (bu.level.get(reg) > 0) {
/*  74 */           bu.level.set(reg, 0);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*  80 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/*  81 */       bu.level.set(reg, 0);
/*     */     }
/*     */     
/*  84 */     for (RDRace rr : (RD.RACES()).all) {
/*  85 */       for (RDEdicts.RDRaceEdict e : (RD.RACES()).edicts.all) {
/*  86 */         e.toggled(rr).set(reg, 0);
/*     */       }
/*     */     } 
/*  89 */     this.res.build(reg, builder);
/*  90 */     this.race.build(reg, builder);
/*  91 */     this.religion.build(reg, builder);
/*  92 */     this.military.build(reg, builder);
/*  93 */     this.civic.build(reg, builder);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class BOther
/*     */   {
/*     */     private final Builder.Sort<Integer> tree;
/* 100 */     private double[] prios = new double[256];
/*     */ 
/*     */     
/*     */     BOther(LIST<RDBuilding> all) {
/* 104 */       Random ran = new Random(12345678910L);
/* 105 */       for (int i = 0; i < this.prios.length; i++) {
/* 106 */         this.prios[i] = ran.nextDouble();
/*     */       }
/*     */       
/* 109 */       LinkedList<Builder.RBuilding<Integer>> aa = new LinkedList();
/* 110 */       for (RDBuilding b : all) {
/* 111 */         if (!b.AIBuild)
/*     */           continue; 
/* 113 */         aa.add(new Builder.RBuilding<Integer>(b)
/*     */             {
/*     */               public double value(RealmBuilder current, Region rcurrent)
/*     */               {
/* 117 */                 int i = this.bu.index() + RD.RAN().get(rcurrent, 0, 16);
/* 118 */                 i &= 0xFF;
/* 119 */                 return Builder.BOther.this.prios[i];
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               double value(Integer t, RealmBuilder builder, Region reg) {
/* 125 */                 return 0.0D;
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/* 131 */       this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<Integer>>)aa);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void build(Region reg, RealmBuilder builder) {
/* 137 */       this.tree.build(reg, builder, Builder.points(builder, reg, 1.0D));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class BMil
/*     */   {
/*     */     private final Builder.Sort<Integer> tree;
/* 145 */     private double[] prios = new double[256];
/* 146 */     private LinkedList<Builder.RBuilding<Integer>> all = new LinkedList();
/*     */ 
/*     */     
/*     */     BMil() {
/* 150 */       Random ran = new Random(12345678910L);
/* 151 */       for (int i = 0; i < this.prios.length; i++) {
/* 152 */         this.prios[i] = ran.nextDouble();
/*     */       }
/*     */ 
/*     */       
/* 156 */       for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 157 */         double v = Math.max(b.boosters().max((RD.MILITARY()).bgarrison), b.boosters().max((RD.MILITARY()).bFortification));
/* 158 */         if (!b.AIBuild || v <= 0.0D) {
/*     */           continue;
/*     */         }
/* 161 */         this.all.add(new Builder.RBuilding<Integer>(b)
/*     */             {
/*     */               public double value(RealmBuilder current, Region rcurrent)
/*     */               {
/* 165 */                 int i = this.bu.index() + RD.RAN().get(rcurrent, 0, 16);
/* 166 */                 i &= 0xFF;
/* 167 */                 return Builder.BMil.this.prios[i] * current.military(rcurrent);
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               double value(Integer t, RealmBuilder builder, Region reg) {
/* 173 */                 return 0.0D;
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/* 179 */       this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<Integer>>)this.all);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void build(Region reg, RealmBuilder builder) {
/* 185 */       this.tree.build(reg, builder, Builder.points(builder, reg, 1.0D));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static int points(RealmBuilder builder, Region reg, double am) {
/* 191 */     int p = (int)(builder.size() * (RD.RACES()).population.get(reg) / 100.0D);
/* 192 */     return p;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class BReligion
/*     */   {
/* 198 */     private LinkedList<Builder.RBuilding<Religion>> all = new LinkedList();
/*     */     
/*     */     private final Builder.Sort<Religion> tree;
/*     */     
/*     */     BReligion() {
/* 203 */       KeyMap<Religion> boosts = new KeyMap();
/* 204 */       for (RDReligions.RDReligion rr : RD.RELIGION().all()) {
/* 205 */         boosts.put(rr.boost.key, rr.religion);
/*     */       }
/*     */       
/* 208 */       for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 209 */         Builder.RBuilding<Religion> br = new Builder.RBuilding<Religion>(bu)
/*     */           {
/*     */             double value(Religion t, RealmBuilder builder, Region reg) {
/* 212 */               return builder.priority(t, reg);
/*     */             }
/*     */           };
/*     */         
/* 216 */         for (BoostSpec s : bu.boosters().all()) {
/*     */           
/* 218 */           if (boosts.containsKey(s.boostable.key)) {
/* 219 */             br.bos.add(new Builder.RSpec<>(s, (Religion)boosts.get(s.boostable.key)));
/*     */           }
/*     */         } 
/* 222 */         if (bu.AIBuild && br.bos.size() > 0) {
/* 223 */           this.all.add(br);
/*     */         }
/*     */       } 
/* 226 */       this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<Religion>>)this.all);
/*     */     }
/*     */     
/*     */     void build(Region reg, RealmBuilder builder) {
/* 230 */       this.tree.build(reg, builder, Builder.points(builder, reg, 1.0D));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class BRace
/*     */   {
/* 239 */     private LinkedList<Builder.RBuilding<RDRace>> all = new LinkedList();
/*     */     
/*     */     private final Builder.Sort<RDRace> tree;
/*     */     
/*     */     BRace() {
/* 244 */       KeyMap<RDRace> map = new KeyMap();
/*     */       
/* 246 */       for (RDRace r : (RD.RACES()).all) {
/* 247 */         map.put(r.pop.dtarget.key, r);
/*     */       }
/*     */       
/* 250 */       for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 251 */         Builder.RBuilding<RDRace> br = new Builder.RBuilding<RDRace>(bu)
/*     */           {
/*     */             double value(RDRace t, RealmBuilder builder, Region reg) {
/* 254 */               return builder.policy(t.race, reg);
/*     */             }
/*     */           };
/* 257 */         for (BoostSpec s : bu.boosters().all()) {
/* 258 */           if (map.containsKey(s.boostable.key)) {
/* 259 */             br.bos.add(new Builder.RSpec<>(s, (RDRace)map.get(s.boostable.key)));
/*     */           }
/*     */         } 
/* 262 */         if (bu.AIBuild && br.bos.size() > 0) {
/* 263 */           this.all.add(br);
/*     */         }
/*     */       } 
/* 266 */       this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<RDRace>>)this.all);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void build(Region reg, RealmBuilder builder) {
/* 274 */       this.tree.build(reg, builder, Builder.points(builder, reg, 0.75D));
/*     */       
/* 276 */       for (RDRace r : (RD.RACES()).all) {
/* 277 */         double v = builder.policy(r.race, reg);
/* 278 */         for (RDEdicts.RDRaceEdict ee : (RD.RACES()).edicts.all) {
/* 279 */           ee.toggled(r).set(reg, 0);
/*     */         }
/*     */         
/* 282 */         if (v < 0.0D) {
/* 283 */           v = -v;
/* 284 */           int i = (int)Math.round(v * (RD.RACES()).edicts.all.size()) - 1;
/* 285 */           i = CLAMP.i(i, 0, (RD.RACES()).edicts.all.size() - 1);
/* 286 */           if (i >= 0) {
/* 287 */             ((RDEdicts.RDRaceEdict)(RD.RACES()).edicts.all.get(i)).toggled(r).set(reg, 1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Resources
/*     */   {
/* 300 */     private LinkedList<Builder.RBuilding<RDOutputs.RDResource>> all = new LinkedList();
/*     */     
/*     */     private final Builder.Sort<RDOutputs.RDResource> tree;
/*     */     
/*     */     Resources() {
/* 305 */       KeyMap<RDOutputs.RDResource> map = new KeyMap();
/*     */       
/* 307 */       for (RDOutputs.RDResource r : (RD.OUTPUT()).RES) {
/* 308 */         map.put(r.boost.key, r);
/*     */       }
/*     */       
/* 311 */       for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 312 */         Builder.RBuilding<RDOutputs.RDResource> br = new Builder.RBuilding<RDOutputs.RDResource>(bu)
/*     */           {
/*     */             double value(RDOutputs.RDResource t, RealmBuilder builder, Region reg) {
/* 315 */               return builder.priority(t.res, reg) * this.bu.baseEfficiency(reg);
/*     */             }
/*     */           };
/* 318 */         for (BoostSpec s : bu.boosters().all()) {
/*     */           
/* 320 */           if (map.containsKey(s.boostable.key)) {
/* 321 */             br.bos.add(new Builder.RSpec<>(s, (RDOutputs.RDResource)map.get(s.boostable.key)));
/*     */           }
/*     */         } 
/* 324 */         if (bu.AIBuild && br.bos.size() > 0)
/* 325 */           this.all.add(br); 
/*     */       } 
/* 327 */       this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<RDOutputs.RDResource>>)this.all);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void build(Region reg, RealmBuilder builder) {
/* 333 */       this.tree.build(reg, builder, Builder.points(builder, reg, 1.0D));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class RBuilding<T>
/*     */   {
/*     */     public final RDBuilding bu;
/* 341 */     public final ArrayListGrower<Builder.RSpec<T>> bos = new ArrayListGrower();
/*     */     
/*     */     public RBuilding(RDBuilding bu) {
/* 344 */       this.bu = bu;
/*     */     }
/*     */     
/*     */     public double value(RealmBuilder current, Region rcurrent) {
/* 348 */       double v1 = 0.0D;
/* 349 */       for (Builder.RSpec<T> b : this.bos) {
/* 350 */         v1 += b.bo.booster.to() * value(b.t, current, rcurrent);
/*     */       }
/* 352 */       return v1;
/*     */     }
/*     */     
/*     */     abstract double value(T param1T, RealmBuilder param1RealmBuilder, Region param1Region);
/*     */   }
/*     */   
/*     */   private static class RSpec<T> {
/*     */     public final BoostSpec bo;
/*     */     public final T t;
/*     */     
/*     */     public RSpec(BoostSpec bo, T t) {
/* 363 */       this.bo = bo;
/* 364 */       this.t = t;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Sort<T>
/*     */     extends Tree<RBuilding<T>>
/*     */   {
/*     */     private final LIST<Builder.RBuilding<T>> all;
/*     */     protected RealmBuilder current;
/*     */     protected Region rcurrent;
/*     */     
/*     */     public Sort(LIST<Builder.RBuilding<T>> all) {
/* 376 */       super(all.size());
/* 377 */       this.all = all;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     double init(Region reg, RealmBuilder builder) {
/* 384 */       this.current = builder;
/* 385 */       this.rcurrent = reg;
/* 386 */       clear();
/* 387 */       double vv = 0.0D;
/* 388 */       for (Builder.RBuilding<T> b : this.all) {
/* 389 */         double v = b.value(builder, reg);
/* 390 */         if (v > 0.0D) {
/* 391 */           vv += v;
/* 392 */           add(b);
/*     */         } 
/*     */       } 
/*     */       
/* 396 */       return vv;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isGreaterThan(Builder.RBuilding<T> curr, Builder.RBuilding<T> cmp) {
/* 401 */       return (curr.value(this.current, this.rcurrent) > cmp.value(this.current, this.rcurrent));
/*     */     }
/*     */ 
/*     */     
/*     */     void build(Region reg, RealmBuilder builder, int points) {
/* 406 */       double mid = init(reg, builder);
/*     */       
/* 408 */       while (hasMore() && points > 0) {
/* 409 */         Builder.RBuilding<?> b = (Builder.RBuilding)pollGreatest();
/* 410 */         if (b.bu.level.get(reg) != 0)
/*     */           continue; 
/* 412 */         double v = b.value(builder, reg);
/*     */         
/* 414 */         int l = (int)Math.ceil((b.bu.levels.size() - 1) * v / mid);
/* 415 */         l = CLAMP.i(l, 0, b.bu.levels.size() - 1);
/* 416 */         l = CLAMP.i(l, 0, points);
/* 417 */         b.bu.level.set(reg, l);
/*     */         
/* 419 */         points -= l;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class RebelBuilder
/*     */     implements RealmBuilder
/*     */   {
/* 430 */     private Region cacheReg = null;
/* 431 */     private double[] races = new double[RACES.all().size()];
/* 432 */     private double[] religions = new double[RACES.all().size()];
/*     */     private double mil;
/*     */     
/*     */     private void init(Region reg) {
/* 436 */       if (this.cacheReg == reg)
/*     */         return; 
/* 438 */       this.cacheReg = reg;
/* 439 */       this.mil = RD.RAN().get(reg, 20, 8) / 1024.0D;
/*     */       
/* 441 */       double max = -1.7976931348623157E308D;
/* 442 */       RDRace mrace = null;
/* 443 */       int ri = (RD.OWNER()).ownerI.get(reg);
/* 444 */       for (RDRace rr : (RD.RACES()).all) {
/* 445 */         double d = rr.pop.base(reg) * (0.25D + RD.RAN().get(reg, ri + rr.race.index() * 3, 3) / 7.0D);
/* 446 */         double dr = RD.RAN().get(reg, ri + rr.race.index() * 5, 4);
/* 447 */         dr /= 7.0D;
/* 448 */         this.races[rr.race.index()] = -1.0D + dr;
/* 449 */         if (d > max) {
/* 450 */           mrace = rr;
/* 451 */           max = d;
/*     */         } 
/*     */       } 
/*     */       
/* 455 */       double rasism = (STATS.ENV()).OTHERS.standing().definitionD(mrace.race);
/*     */       
/* 457 */       for (RDRace rr : (RD.RACES()).all) {
/* 458 */         if (rr == mrace) {
/* 459 */           this.races[rr.race.index()] = 1.0D + 2.0D * rasism;
/*     */           continue;
/*     */         } 
/* 462 */         this.races[rr.race.index()] = this.races[rr.race.index()] + mrace.race.pref().race(rr.race);
/* 463 */         this.races[rr.race.index()] = this.races[rr.race.index()] * rasism;
/*     */       } 
/*     */       
/* 466 */       RDReligions.RDReligion tr = (RDReligions.RDReligion)RD.RELIGION().all().get(0);
/* 467 */       max = 0.0D;
/* 468 */       for (RDReligions.RDReligion rr : RD.RELIGION().all()) {
/* 469 */         this.religions[rr.religion.index()] = 0.0D;
/* 470 */         if (rr.current.get(reg) > max) {
/* 471 */           max = rr.current.get(reg);
/* 472 */           tr = rr;
/*     */         } 
/*     */       } 
/* 475 */       this.religions[tr.religion.index()] = 1.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double policy(Race race, Region reg) {
/* 482 */       init(reg);
/* 483 */       return this.races[race.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public double priority(TRADABLE res, Region reg) {
/* 488 */       return 1.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double priority(Religion religion, Region reg) {
/* 493 */       init(reg);
/* 494 */       return this.religions[religion.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public double military(Region reg) {
/* 499 */       return this.mil;
/*     */     }
/*     */ 
/*     */     
/*     */     public double size() {
/* 504 */       return 0.25D;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\Builder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */