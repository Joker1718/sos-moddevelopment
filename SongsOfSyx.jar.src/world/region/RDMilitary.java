/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.army.WDIV;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RDMilitary
/*     */ {
/*  33 */   private static CharSequence ¤¤garrisonD = "Troops that are stationed in a region which will defend it against attacks.";
/*  34 */   private static CharSequence ¤¤conscriptD = "Conscripts are candidates that can be trained into soldiers."; public final RData.RDataE garrison; public final DOUBLE_O.DOUBLE_OE<Region> fort; public final Boostable bgarrison; public final Boostable conscriptTarget; public final Boostable bFortification;
/*     */   
/*     */   static {
/*  37 */     D.ts(RDMilitary.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   private final RDMilitaryGar gar = new RDMilitaryGar();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final DOUBLE_O<Region> power;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double besigeMul(Region t) {
/* 142 */     return CLAMP.d((WORLD.BATTLES().besigedTime(t) - TIME.secondsPerDay()) / TIME.secondsPerDay() * 16.0D, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public int defensePower(Region reg) {
/* 146 */     return (int)Math.ceil((1.0D + this.fort.getD(reg)) * this.power.getD(reg));
/*     */   }
/*     */   
/*     */   public int garrisonTarget(Region reg) {
/* 150 */     if (reg == null)
/* 151 */       return 0; 
/* 152 */     if (reg.faction() == FACTIONS.player()) {
/* 153 */       return (int)this.bgarrison.get((BOOSTABLE_O)reg);
/*     */     }
/* 155 */     double dz = (RD.RACES()).population.get(reg) / 40000.0D;
/* 156 */     dz *= 1.0D + 0.25D * (-8 + RD.RAN().get(reg, 9, 4)) / 8.0D;
/* 157 */     dz = CLAMP.d(dz, 0.0D, 1.0D);
/*     */     
/* 159 */     dz *= CLAMP.d(POP.tot(null) / 8000.0D, 0.1D, 1.0D);
/*     */ 
/*     */     
/* 162 */     if (reg.faction() instanceof FactionNPC) {
/* 163 */       FactionNPC f = (FactionNPC)reg.faction();
/* 164 */       dz *= 1.0D + 0.5D * f.court().king().garrison();
/*     */     } 
/* 166 */     dz = CLAMP.d(dz, 0.0D, 1.0D);
/* 167 */     dz = 100.0D + dz * (this.garrison.max(reg) - 100);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     return (int)dz;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int conscripts(Race r, Faction f) {
/* 180 */     if (f == FACTIONS.player()) {
/* 181 */       if (RD.RACES().get(r) == null) {
/* 182 */         return 0;
/*     */       }
/*     */ 
/*     */       
/* 186 */       int am = 0;
/* 187 */       for (int i = 0; i < f.realm().regions(); i++) {
/* 188 */         Region rr = f.realm().region(i);
/* 189 */         if (!rr.capitol() && (RD.RACES()).population.get(rr) > 0) {
/* 190 */           am = (int)(am + this.conscriptTarget.get((BOOSTABLE_O)rr) * (RD.RACES().get(r)).pop.get(rr) / (RD.RACES()).population.get(rr));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 195 */       return am;
/*     */     } 
/*     */     
/* 198 */     if (RD.RACES().get(r) == null) {
/* 199 */       double d1 = f.realm().all().size() / 8.0D;
/* 200 */       d1 = CLAMP.d(d1, 0.0D, 1.0D);
/* 201 */       return (int)(WORLD.camps().current(f, r) * d1);
/*     */     } 
/*     */     
/* 204 */     FactionNPC ff = (FactionNPC)f;
/* 205 */     double dist = 1.0D + CLAMP.d(RD.DIST().distance((Faction)ff) / 512.0D, 0.0D, 2.0D);
/*     */     
/* 207 */     double p = 1.0D + f.realm().all().size() * 0.025D;
/* 208 */     double d = POP.tot(null) / 20000.0D;
/* 209 */     d = CLAMP.d(d, 0.1D, 1.0D);
/* 210 */     d *= dist * (RD.RACES().get(r)).pop.faction().get(f) * 0.25D / p;
/* 211 */     if (r == (ff.court().king().roy()).induvidual.race())
/* 212 */       return (int)(10.0D + d); 
/* 213 */     return (int)d;
/*     */   }
/*     */   
/*     */   RDMilitary(RD.RDInit init) {
/* 217 */     this.power = new DOUBLE_O<Region>() {
/* 218 */         private final INFO info = new INFO(Dic.¤¤Garrison, 
/* 219 */             Dic.¤¤GarrisonD);
/*     */         
/*     */         public double getD(Region t)
/*     */         {
/* 223 */           int p = 0;
/* 224 */           for (WDIV d : RDMilitary.this.divisions(t))
/* 225 */             p += d.provess(); 
/* 226 */           return p; } public int get(Region t) { if (FACTIONS.player().capitolRegion() == t) { int pow = 0; for (WDIV d : RDMilitary.this.gar.player()) pow += d.men();  return pow; }  return super.get(t); } public void set(Region t, int s) { RDMilitary.this.gar.init(); super.set(t, s); }
/*     */       }; this.garrison = new RData.RDataE("GARRISON", (INT_O.INT_OE<Region>)dataShort, init, Dic.¤¤garrison); init.count.getClass(); this.fort = (DOUBLE_O.DOUBLE_OE<Region>)new DataO.DataDouble(init.count, "REG_FORT"); init.upers.add(new RD.RDUpdatable() {
/*     */           private final double dt = 2.0D / TIME.secondsPerDay();
/*     */         }; this.bgarrison = BOOSTING.push("GARRISON", 0.0D, Dic.¤¤garrison, ¤¤garrisonD, (SPRITE)(UI.icons()).s.shield, (BoostableCat.ALL()).WORLD); this.bFortification = BOOSTING.push("FORTIFICATION", 8.0D, Dic.¤¤Fort, Dic.¤¤FortD, (SPRITE)(UI.icons()).s.degrade, (BoostableCat.ALL()).WORLD); init.count.getClass(); DataO<Region>.DataShort dataShort = new DataO<Region>.DataShort(init.count, "GARRISON", null, (Config.battle()).REGION_MAX_DIVS * (Config.battle()).MEN_PER_DIVISION) {
/*     */           public void update(Region reg, double time) { int t = RDMilitary.this.garrisonTarget(reg); if (WORLD.BATTLES().besigedTime(reg) > 0.0D) { int i = (int)(RDMilitary.this.garrisonTarget(reg) * (1.0D - RDMilitary.this.besigeMul(reg))); i = (int)Math.min(RDMilitary.this.garrison.get(reg) * (1.0D - RDMilitary.this.besigeMul(reg)), i); i = CLAMP.i(i, 0, t); if (i < RDMilitary.this.garrison.get(reg))
/* 231 */                 RDMilitary.this.garrison.set(reg, i);  return; }  int d = RDMilitary.this.garrisonTarget(reg); RDMilitary.this.garrison.moveTo(reg, time * this.dt * 50.0D, d); double f = RDMilitary.this.bFortification.get((BOOSTABLE_O)reg) - RDMilitary.this.fort.getD(reg); double nn = RDMilitary.this.fort.getD(reg) + time * this.dt * f; if (f < 0.0D) { nn += 3.0D * time * this.dt * f; nn = Math.max(nn, 0.0D); } else { nn = Math.min(nn, RDMilitary.this.bFortification.get((BOOSTABLE_O)reg)); }  RDMilitary.this.fort.setD(reg, nn); } public void init(Region reg) { RDMilitary.this.garrison.set(reg, RDMilitary.this.garrisonTarget(reg)); RDMilitary.this.fort.setD(reg, RDMilitary.this.bFortification.get((BOOSTABLE_O)reg)); } public INFO info() { return this.info; }
/*     */         });
/*     */     this.conscriptTarget = BOOSTING.push("CONSCRIPTABLE_TARGET", 0.0D, Dic.¤¤Conscripts, ¤¤conscriptD, (SPRITE)(UI.icons()).s.sword, (BoostableCat.ALL()).WORLD);
/*     */     (new RBooster(new BSourceInfo(Dic.¤¤Population, (SPRITE)(UI.icons()).s.human), 0.0D, 20000.0D, false) { public double get(Region t) { return (RD.RACES()).population.get(t) * 0.05D / 20000.0D; } }
/*     */       ).add(this.conscriptTarget);
/* 236 */   } public double garrison(Region reg) { return this.garrison.getD(reg); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void extractSpoils(Region r, int[] equipAmounts) {
/* 242 */     if (FACTIONS.player().capitolRegion() == r) {
/* 243 */       this.gar.extractLostEquipment(equipAmounts);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<WDIV> divisions(Region r) {
/* 250 */     return this.gar.divisions(r, this.garrison.get(r), garrisonTarget(r));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDMilitary.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */