/*     */ package world.region;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public class RDReligions {
/*  30 */   private final ArrayListGrower<RDReligion> all = new ArrayListGrower();
/*     */   public final INT_O.INT_OE<Region> opposition;
/*  32 */   private static CharSequence ¤¤Opposition = "Religious differences";
/*     */   
/*     */   static {
/*  35 */     D.ts(RDReligions.class);
/*     */   }
/*     */ 
/*     */   
/*     */   RDReligions(RD.RDInit init) {
/*  40 */     init.count.getClass(); this.opposition = (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "REL_OPPOSITION");
/*     */     
/*  42 */     for (Religion r : RELIGIONS.ALL()) {
/*  43 */       this.all.add(new RDReligion(init, r));
/*     */     }
/*     */     
/*  46 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */ 
/*     */           
/*     */           public void exe()
/*     */           {
/*  52 */             RBooster lo = new RBooster(new BSourceInfo(RDReligions.¤¤Opposition, (SPRITE)(UI.icons()).s.heat), 1.0D, 0.75D, true)
/*     */               {
/*     */                 public double get(Region t)
/*     */                 {
/*  56 */                   return (RDReligions.null.access$0(RDReligions.null.this)).opposition.getD(t);
/*     */                 }
/*     */               };
/*     */             
/*  60 */             for (RDRace race : (RD.RACES()).all) {
/*  61 */               lo.add(race.loyalty.target);
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  67 */     init.upers.add(new RD.RDUpdatable()
/*     */         {
/*  69 */           final double dt = 1.0D / (TIME.secondsPerDay() * 16);
/*     */ 
/*     */ 
/*     */           
/*     */           public void update(Region reg, double time) {
/*  74 */             double min = RDReligions.this.min(reg);
/*  75 */             double tot = RDReligions.this.tot(reg) - min;
/*     */             
/*  77 */             for (RDReligions.RDReligion r : RDReligions.this.all) {
/*  78 */               double target = Math.round(255.0D * (r.boost.get((BOOSTABLE_O)reg) - min) / tot);
/*  79 */               double now = target + this.dt * (target - r.current.get(reg));
/*  80 */               now = CLAMP.d(now, Math.min(target, r.current.get(reg)), Math.max(target, r.current.get(reg)));
/*  81 */               r.current.set(reg, (int)now);
/*     */             } 
/*     */             
/*  84 */             setop(reg);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void init(Region reg) {
/*  90 */             double min = RDReligions.this.min(reg);
/*  91 */             double tot = RDReligions.this.tot(reg) - min;
/*  92 */             for (RDReligions.RDReligion r : RDReligions.this.all) {
/*  93 */               double target = Math.round(255.0D * (r.boost.get((BOOSTABLE_O)reg) - min) / tot);
/*  94 */               r.current.set(reg, (int)target);
/*     */             } 
/*  96 */             setop(reg);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           private void setop(Region reg) {
/* 102 */             double op = 0.0D;
/*     */             
/* 104 */             for (int ri = 0; ri < RDReligions.this.all.size(); ri++) {
/* 105 */               double vv = 0.0D;
/* 106 */               RDReligions.RDReligion r = (RDReligions.RDReligion)RDReligions.this.all.get(ri);
/* 107 */               for (int ri2 = 0; ri2 < RDReligions.this.all.size(); ri2++) {
/* 108 */                 RDReligions.RDReligion r2 = (RDReligions.RDReligion)RDReligions.this.all.get(ri2);
/* 109 */                 double am = r2.current.getD(reg);
/* 110 */                 am *= r.religion.opposition(r2.religion);
/* 111 */                 vv += am;
/*     */               } 
/* 113 */               op += vv * r.current.getD(reg);
/*     */             } 
/*     */             
/* 116 */             op = CLAMP.d(op, 0.0D, 1.0D);
/* 117 */             RDReligions.this.opposition.setD(reg, op);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private double min(Region reg) {
/* 124 */     double mi = 0.0D;
/* 125 */     for (RDReligion r : this.all) {
/* 126 */       mi = Math.min(mi, r.boost.get((BOOSTABLE_O)reg));
/*     */     }
/* 128 */     return mi;
/*     */   }
/*     */   
/*     */   private double tot(Region reg) {
/* 132 */     double tot = 0.0D;
/* 133 */     for (RDReligion r : this.all) {
/* 134 */       tot += Math.max(r.boost.get((BOOSTABLE_O)reg), 0.0D);
/*     */     }
/* 136 */     return tot;
/*     */   }
/*     */   
/*     */   public LIST<RDReligion> all() {
/* 140 */     return (LIST<RDReligion>)this.all;
/*     */   }
/*     */   
/*     */   public RDReligion get(Religion t) {
/* 144 */     return (RDReligion)this.all.get(t.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public class RDReligion
/*     */   {
/*     */     public final Boostable boost;
/*     */     public final BoostSpecs boosts;
/*     */     public final Religion religion;
/*     */     public final INT_O.INT_OE<Region> current;
/*     */     
/*     */     private RDReligion(RD.RDInit init, final Religion reg) {
/* 156 */       this.boosts = new BoostSpecs(reg.info.name, (SPRITE)reg.icon, true);
/* 157 */       this.religion = reg;
/* 158 */       this.current = (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "REL" + reg.key);
/* 159 */       this.boost = BOOSTING.push("CONVERSION_" + reg.key, reg.inclination, reg.info.name, reg.info.desc, (SPRITE)reg.icon, (BoostableCat.ALL()).WORLD_CIVICS);
/* 160 */       BOOSTING.connecter(new ACTION()
/*     */           {
/*     */ 
/*     */             
/*     */             public void exe()
/*     */             {
/* 166 */               for (BoostSpec s : reg.boosts.all()) {
/*     */ 
/*     */ 
/*     */                 
/* 170 */                 if ((s.boostable.cat.typeMask & 0x2) != 0) {
/* 171 */                   BoosterValue b = new BoosterValue((BValue)new RDReligions.RDReligion.value(s.boostable), s.booster.info, s.booster.to(), s.booster.isMul);
/* 172 */                   RDReligions.RDReligion.this.boosts.push((Booster)b, s.boostable);
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double target(Region reg) {
/* 182 */       double tot = 0.0D;
/* 183 */       for (RDReligion r : RDReligions.this.all) {
/* 184 */         tot += r.boost.get((BOOSTABLE_O)reg);
/*     */       }
/* 186 */       return this.boost.get((BOOSTABLE_O)reg) / tot;
/*     */     }
/*     */     
/*     */     public class value
/*     */       extends BValue.BValueFaction {
/*     */       value(Boostable bo) {
/* 192 */         super(bo);
/*     */       }
/*     */ 
/*     */       
/*     */       public double vGet(Region reg) {
/* 197 */         return RDReligions.RDReligion.this.current.getD(reg);
/*     */       }
/*     */ 
/*     */       
/*     */       public double vGet(Player f) {
/* 202 */         double d = 0.0D;
/* 203 */         for (int i = 0; i < f.realm().regions(); i++) {
/* 204 */           Region reg = f.realm().region(i);
/* 205 */           d += RDReligions.RDReligion.this.current.getD(reg) * (RD.RACES()).population.get(reg);
/*     */         } 
/* 207 */         d /= (RD.RACES()).population.faction().get(f);
/* 208 */         return d;
/*     */       }
/*     */ 
/*     */       
/*     */       public double vGet(FactionNPC f) {
/* 213 */         return 0.0D;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDReligions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */