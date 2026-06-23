/*     */ package init.race;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ public final class RaceBoosts
/*     */ {
/*     */   private double[][] priorities;
/*     */   private double[][] skillRelative;
/*     */   private double[][] skill;
/*  37 */   public final BoostSpecs boosters = new BoostSpecs(RACES.name(), (SPRITE)(UI.icons()).s.citizen, true);
/*  38 */   private final KeyMap<BV> bvmap = new KeyMap();
/*     */ 
/*     */ 
/*     */   
/*     */   RaceBoosts() {
/*  43 */     ACTION a = new ACTION()
/*     */       {
/*     */         
/*     */         public void exe()
/*     */         {
/*  48 */           for (Race c : RACES.all()) {
/*     */             
/*  50 */             for (BoostSpec s : c.boosts.all()) {
/*  51 */               String k = s.boostable.key + s.boostable.key;
/*  52 */               if (!RaceBoosts.this.bvmap.containsKey(k)) {
/*  53 */                 RaceBoosts.this.bvmap.put(k, new RaceBoosts.BV(RaceBoosts.this.boosters, s.boostable, s.booster.isMul));
/*     */               }
/*  55 */               ((RaceBoosts.BV)RaceBoosts.this.bvmap.get(k)).set(c, s.booster.to());
/*     */             } 
/*     */           } 
/*     */           
/*  59 */           RaceBoosts.this.setPrio();
/*     */         }
/*     */       };
/*     */     
/*  63 */     BOOSTING.connecter(a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BoostSpec pushIfDoesntExist(Race c, double v, Boostable bo, boolean isMul) {
/*  69 */     String k = bo.key + bo.key;
/*  70 */     double none = (isMul ? true : false);
/*  71 */     if (this.bvmap.containsKey(k) && ((BV)this.bvmap.get(k)).dd[c.index()] == none) {
/*  72 */       return null;
/*     */     }
/*  74 */     boolean ret = false;
/*  75 */     if (!this.bvmap.containsKey(k)) {
/*  76 */       ret = true;
/*  77 */       this.bvmap.put(k, new BV(this.boosters, bo, isMul));
/*     */     } 
/*     */ 
/*     */     
/*  81 */     BV bv = (BV)this.bvmap.get(k);
/*  82 */     bv.set(c, v);
/*  83 */     setPrio();
/*     */     
/*  85 */     return ret ? bv.spec : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void setPrio() {
/*  91 */     HashMap<String, RoomEmploymentSimple> map = new HashMap<>();
/*     */     
/*  93 */     for (RoomEmploymentSimple p : (SETT.ROOMS()).employment.ALLS()) {
/*  94 */       if (p.blueprint().bonus() != null) {
/*  95 */         map.put((p.blueprint().bonus()).key, p);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 101 */     double max = 0.0D;
/* 102 */     double min = 10000.0D;
/*     */     
/* 104 */     this.priorities = new double[RACES.all().size()][(SETT.ROOMS()).employment.ALLS().size()];
/* 105 */     for (Race r : RACES.all()) {
/*     */       
/* 107 */       for (BoostSpec s : r.boosts.all()) {
/* 108 */         RoomEmploymentSimple e = map.get(s.boostable.key);
/* 109 */         if (e == null)
/*     */           continue; 
/* 111 */         double v = s.booster.isMul ? ((s.booster.to() - 1.0D) * 5.0D) : s.booster.to();
/* 112 */         max = Math.max(v, max);
/* 113 */         min = Math.min(min, v);
/*     */       } 
/*     */     } 
/*     */     
/* 117 */     for (Race r : RACES.all()) {
/* 118 */       double[] vv = this.priorities[r.index()];
/* 119 */       Arrays.fill(vv, 0.5D);
/* 120 */       if (min > max) {
/*     */         continue;
/*     */       }
/* 123 */       for (RoomEmploymentSimple p : (SETT.ROOMS()).employment.ALLS()) {
/* 124 */         if (p.blueprint().bonus() != null) {
/* 125 */           double v = r.bvalue(p.blueprint().bonus());
/* 126 */           v -= min;
/* 127 */           v /= max - min;
/* 128 */           vv[p.eindex()] = v;
/*     */         } 
/*     */       } 
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
/* 142 */     this.skillRelative = new double[RACES.all().size()][(SETT.ROOMS()).employment.ALLS().size()];
/* 143 */     this.skill = new double[RACES.all().size()][(SETT.ROOMS()).employment.ALLS().size()];
/*     */     
/* 145 */     for (RoomEmploymentSimple e : (SETT.ROOMS()).employment.ALLS()) {
/*     */       
/* 147 */       if (e.blueprint().bonus() != null) {
/* 148 */         Boostable bo = e.blueprint().bonus();
/*     */         
/* 150 */         for (Race r : RACES.all()) {
/* 151 */           double[] vv = this.skillRelative[r.index()];
/* 152 */           double v = r.bvalue(bo);
/* 153 */           if (v > 1.0D) {
/* 154 */             v = 0.5D + v * 2.0D;
/*     */           } else {
/* 156 */             v = Math.pow(v, 2.0D) * 0.5D;
/* 157 */           }  v = CLAMP.d(v, 0.0D, 2.0D);
/*     */           
/* 159 */           vv[e.eindex()] = v;
/* 160 */           this.skill[r.index()][e.eindex()] = r.bvalue(bo);
/*     */         } 
/*     */         continue;
/*     */       } 
/* 164 */       for (Race r : RACES.all()) {
/* 165 */         double[] vv = this.skillRelative[r.index()];
/* 166 */         vv[e.eindex()] = 0.5D;
/* 167 */         this.skill[r.index()][e.eindex()] = 1.0D;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug() {
/* 177 */     LOG.ln("RACEBOOST");
/*     */     
/* 179 */     for (Race r : RACES.all()) {
/* 180 */       LOG.ln(r.key + " " + r.key);
/*     */     }
/* 182 */     for (BoostSpec b : this.boosters.all()) {
/* 183 */       String s = b.boostable.key + " " + b.boostable.key + " " + b.booster.from();
/*     */       
/* 185 */       LOG.ln(s);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getNorSkill(Race race, RoomEmploymentSimple e) {
/* 192 */     return this.skillRelative[race.index()][e.eindex()];
/*     */   }
/*     */   
/*     */   public double skill(Race race, RoomEmploymentSimple e) {
/* 196 */     return this.skill[race.index()][e.eindex()];
/*     */   }
/*     */   
/*     */   private static class BV
/*     */     extends Booster
/*     */   {
/*     */     private double from;
/*     */     private double to;
/* 204 */     private final double[] dd = new double[RACES.all().size()];
/*     */     private final boolean isMul;
/*     */     public final BoostSpec spec;
/*     */     private final BValue value;
/*     */     
/*     */     BV(BoostSpecs bos, Boostable target, final boolean isMul) {
/* 210 */       super(new BSourceInfo(RACES.name(), (SPRITE)(UI.icons()).s.citizen), isMul);
/* 211 */       this.isMul = isMul;
/* 212 */       if (isMul)
/* 213 */         Arrays.fill(this.dd, 1.0D); 
/* 214 */       set();
/*     */       
/* 216 */       this.spec = bos.push(this, target);
/*     */       
/* 218 */       this.value = new BValue()
/*     */         {
/*     */ 
/*     */           
/*     */           public double vGet(FactionNPC f)
/*     */           {
/* 224 */             if (f == null || f.capitolRegion() == null)
/* 225 */               return 0.0D; 
/* 226 */             return vGet(f.capitolRegion());
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Player f) {
/* 231 */             return isMul ? 1.0D : 1.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(HCLASS_RACE popTime) {
/* 236 */             if (popTime.race == null) {
/* 237 */               double acc = 0.0D;
/* 238 */               double tot = 0.0D;
/* 239 */               for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 240 */                 Race r = (Race)RACES.all().get(ri);
/* 241 */                 double pop = (STATS.POP()).POP.data(popTime.cl).get(r);
/*     */                 
/* 243 */                 acc += RaceBoosts.BV.this.dd[r.index()] * pop;
/* 244 */                 tot += pop;
/*     */               } 
/* 246 */               if (tot == 0.0D)
/* 247 */                 return 0.0D; 
/* 248 */               return acc / tot;
/*     */             } 
/*     */             
/* 251 */             return RaceBoosts.BV.this.dd[popTime.race.index()];
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public double vGet(Div div) {
/* 257 */             return RaceBoosts.BV.this.dd[div.info.race().index()];
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Induvidual indu) {
/* 262 */             return RaceBoosts.BV.this.dd[indu.race().index()];
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Region reg) {
/* 267 */             double acc = 0.0D;
/* 268 */             double tot = 0.0D;
/* 269 */             for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 270 */               RDRace r = (RDRace)(RD.RACES()).all.get(ri);
/* 271 */               double pop = r.pop.get(reg);
/* 272 */               acc += RaceBoosts.BV.this.dd[r.race.index()] * pop;
/* 273 */               tot += pop;
/*     */             } 
/* 275 */             if (tot == 0.0D)
/* 276 */               return 0.0D; 
/* 277 */             return acc / tot;
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     void set(Race c, double value) {
/* 283 */       this.dd[c.index()] = value;
/* 284 */       set();
/*     */     }
/*     */     
/*     */     private void set() {
/* 288 */       if (this.isMul) {
/* 289 */         this.from = 1.0D;
/* 290 */         this.to = 1.0D;
/*     */       } else {
/* 292 */         this.from = 0.0D;
/* 293 */         this.to = 0.0D;
/*     */       }  byte b; int i;
/*     */       double[] arrayOfDouble;
/* 296 */       for (i = (arrayOfDouble = this.dd).length, b = 0; b < i; ) { double v = arrayOfDouble[b];
/* 297 */         this.from = Math.min(v, this.from);
/* 298 */         this.to = Math.max(v, this.to);
/*     */         b++; }
/*     */     
/*     */     }
/*     */     
/*     */     public double getValue(double input) {
/* 304 */       return input;
/*     */     }
/*     */ 
/*     */     
/*     */     public double from() {
/* 309 */       return this.from;
/*     */     }
/*     */ 
/*     */     
/*     */     public double to() {
/* 314 */       return this.to;
/*     */     }
/*     */ 
/*     */     
/*     */     protected double pget(BOOSTABLE_O o) {
/* 319 */       return o.boostableValue(this.value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceBoosts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */