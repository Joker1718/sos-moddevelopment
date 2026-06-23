/*     */ package world.region.pop;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
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
/*     */ public final class RDRaceLoyalty
/*     */   extends RData.RDataE
/*     */   implements RD.RDUpdatable
/*     */ {
/*     */   public final Boostable target;
/* 105 */   private static final double DTime = 8.0D / TIME.secondsPerDay();
/*     */   
/*     */   RDRaceLoyalty(RD.RDInit init, final Race race) {
/* 108 */     super("RACE_LOYALTY" + race.key, (INT_O.INT_OE)new DataO.DataByte(init.count, "RACE_LOYALTY" + race.key), init, String.valueOf(RDRaces.¤¤Loyalty) + ": " + String.valueOf(RDRaces.¤¤Loyalty));
/* 109 */     this.target = BOOSTING.push("LOYALTY_" + race.key, 0.0D, this.name, this.name, (SPRITE)(race.appearance()).iconBig, (BoostableCat.ALL()).WORLD_CIVICS);
/* 110 */     init.upers.add(this);
/* 111 */     (new RBooster(new BSourceInfo(((STATS.ENV()).OTHERS.info()).name, (SPRITE)(UI.icons()).s.citizen), 0.75D, 1.0D, true)
/*     */       {
/*     */         public double get(Region t) {
/* 114 */           double tot = (RD.RACES()).popTarget.getD(t);
/* 115 */           if (tot == 0.0D)
/* 116 */             return 0.0D; 
/* 117 */           double rr = 0.0D;
/* 118 */           for (int ri = 0; ri < (RD.RACES()).all.size(); ri++) {
/* 119 */             RDRace o = (RDRace)(RD.RACES()).all.get(ri);
/* 120 */             rr += o.pop.target(t) * race.pref().race(o.race);
/*     */           } 
/* 122 */           return CLAMP.d(rr / tot, 0.0D, 1.0D);
/*     */         }
/* 124 */       }).add(this.target);
/*     */     
/* 126 */     (new RBooster(new BSourceInfo(RDRaces.¤¤RegionCapacity, (SPRITE)(UI.icons()).s.human), 0.0D, -10.0D, false)
/*     */       {
/*     */         public double get(Region t)
/*     */         {
/* 130 */           double d = (RD.RACES()).popTarget.getD(t) / (1.0D + RD.RACES().maxPop(t) * (race.population()).max * 1.5D);
/* 131 */           d = (int)(d * 100.0D) / 100.0D;
/* 132 */           return d;
/*     */         }
/* 134 */       }).add(this.target);
/*     */     
/* 136 */     (new RBooster(new BSourceInfo(RDRace.¤¤Armies, (SPRITE)(UI.icons()).s.sword), 0.0D, 20.0D, false)
/*     */       {
/*     */         public double get(Region t) {
/* 139 */           double power = 0.0D;
/* 140 */           for (WArmy a : (WORLD.ENTITIES()).armies.fill(t)) {
/* 141 */             if (a.faction() == t.faction())
/* 142 */               power += AD.power().get(a); 
/* 143 */           }  return power / ((RD.RACES()).pop.get(t) + 1);
/*     */         }
/* 145 */       }).add(this.target);
/*     */     
/* 147 */     (new RBooster(new BSourceInfo(String.valueOf(RDRace.¤¤Representation) + " (" + String.valueOf(RDRace.¤¤Representation), (SPRITE)(UI.icons()).s.human), 0.75D, 1.25D, true)
/*     */       {
/*     */         protected double get(Region reg)
/*     */         {
/* 151 */           int cit = POP.tot(HCLASSES.CITIZEN(), race);
/* 152 */           int slaves = POP.tot(HCLASSES.SLAVE(), race);
/* 153 */           int tot = POP.tot(null) + 1;
/* 154 */           if (cit == 0) {
/* 155 */             if (slaves > 0)
/* 156 */               return 0.5D - CLAMP.d(250.0D * slaves / tot, 0.0D, 0.5D); 
/* 157 */             return 0.5D;
/*     */           } 
/* 159 */           return CLAMP.d(0.5D + 0.5D * RACES.playable().size() * cit / tot, 0.5D, 1.0D);
/*     */         }
/* 162 */       }).add(this.target);
/*     */     
/* 164 */     (new RBooster(new BSourceInfo(String.valueOf(RDRace.¤¤Representation) + ": " + String.valueOf(RDRace.¤¤Representation), (SPRITE)(UI.icons()).s.noble), 0.75D, 1.25D, true)
/*     */       {
/*     */         protected double get(Region reg)
/*     */         {
/* 168 */           int cit = POP.tot(HCLASSES.NOBLE(), race);
/* 169 */           int tot = POP.tot(HCLASSES.NOBLE(), null);
/* 170 */           if (cit == 0) {
/* 171 */             if (tot > RACES.playable().size())
/* 172 */               return CLAMP.d(0.5D - (tot - RACES.playable().size()) / 4.0D, 0.0D, 0.5D); 
/* 173 */             return 0.5D;
/*     */           } 
/* 175 */           return CLAMP.d(0.5D + 0.5D * cit / tot, 0.5D, 1.0D);
/*     */         }
/* 178 */       }).add(this.target);
/*     */     
/* 180 */     BOOSTING.connecter(new ACTION()
/*     */         {
/*     */ 
/*     */           
/*     */           public void exe()
/*     */           {
/* 186 */             double to = ((STATS.BATTLE()).WAR.standing.definition(race)).mul;
/* 187 */             if (((STATS.BATTLE()).WAR.standing.definition(race)).inverted) {
/* 188 */               to = -to;
/*     */             }
/* 190 */             (new RBooster(new BSourceInfo(((STATS.BATTLE()).WAR.info()).name, (SPRITE)(UI.icons()).s.sword), 0.0D, to, false)
/*     */               {
/*     */                 protected double get(Region reg)
/*     */                 {
/* 194 */                   return CLAMP.d((STATS.BATTLE()).WAR.data(HCLASSES.CITIZEN()).getD(race, 0), 0.0D, 1.0D);
/*     */                 }
/* 196 */               }).add(RDRace.RDRaceLoyalty.this.target);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Region reg, double time) {
/* 206 */     double d = increase(reg) * DTime * time;
/* 207 */     moveTo(reg, Math.abs(d), (d < 0.0D) ? 0 : 255);
/*     */   }
/*     */   
/*     */   public double increase(Region reg) {
/* 211 */     return (int)(this.target.get((BOOSTABLE_O)reg) * 10.0D) / 10.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(Region reg) {
/* 216 */     double d = this.target.get((BOOSTABLE_O)reg);
/* 217 */     set(reg, (d < 0.0D) ? 0 : 255);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDRace$RDRaceLoyalty.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */