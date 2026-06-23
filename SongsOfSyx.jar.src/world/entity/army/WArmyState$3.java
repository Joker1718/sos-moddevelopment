/*     */ package world.entity.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends WArmyState
/*     */ {
/*     */   WArmyState update(WArmy a, double ds) {
/* 123 */     Region reg = a.region();
/* 124 */     if (reg == null) {
/* 125 */       a.stateFloat = 0.0F;
/* 126 */       return WArmyState.fortifying;
/*     */     } 
/*     */     
/* 129 */     a.stateFloat = (float)(a.stateFloat + ds);
/*     */     
/* 131 */     if (a.stateFloat < 120.0F) {
/* 132 */       return this;
/*     */     }
/* 134 */     a.stateFloat -= 120.0F;
/*     */     
/* 136 */     double rd = RD.RACES().popSize(reg);
/* 137 */     double ad = AD.men(null).get(a) / (Config.battle()).MEN_PER_ARMY;
/* 138 */     double dd = ad / rd;
/*     */     
/* 140 */     double d = 180.0D * dd / (TIME.secondsPerDay() * 4);
/*     */     
/* 142 */     double inc = (RD.DEVASTATION()).current.max(reg) * d;
/* 143 */     int iinc = (int)inc;
/* 144 */     if (inc - iinc > RND.rFloat()) {
/* 145 */       iinc++;
/*     */     }
/* 147 */     int now = (RD.DEVASTATION()).current.get(reg);
/* 148 */     if (now + iinc >= (RD.DEVASTATION()).current.max(reg)) {
/* 149 */       iinc = (RD.DEVASTATION()).current.max(reg) - now;
/*     */     }
/*     */     
/* 152 */     if (iinc > 0) {
/*     */ 
/*     */       
/* 155 */       Shipment s = null;
/* 156 */       Faction to = a.faction();
/*     */       
/* 158 */       if (to != null) {
/* 159 */         for (RESOURCE res : RESOURCES.ALL()) {
/*     */           
/* 161 */           int am = (int)Math.ceil(RD.OUTPUT().get((TRADABLE)TR.get(res)).loot(reg) * d * 10.0D);
/*     */           
/* 163 */           if (am > 0 && to != null) {
/* 164 */             if (s == null) {
/* 165 */               s = (WORLD.ENTITIES()).caravans.create(a.ctx(), a.cty(), to.capitolRegion(), TRADE_TYPE.spoils);
/*     */             }
/* 167 */             if (s != null) {
/* 168 */               s.loadAndReserve((TRADABLE)TR.get(res), am);
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 174 */         for (RDRace ra : (RD.RACES()).all) {
/* 175 */           int pop = (int)Math.ceil(ra.pop.get(reg) * d * 0.5D);
/* 176 */           if (pop > 0) {
/*     */             
/* 178 */             ra.pop.inc(reg, -pop);
/* 179 */             if (s == null) {
/* 180 */               s = (WORLD.ENTITIES()).caravans.create(a.ctx(), a.cty(), to.capitolRegion(), TRADE_TYPE.spoils);
/*     */             }
/* 182 */             if (s != null) {
/* 183 */               s.loadAndReserve((TRADABLE)TR.get(ra.race), (int)Math.ceil(pop / 2.0D));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 192 */       if (a.faction() == FACTIONS.player() && reg.faction() instanceof FactionNPC) {
/* 193 */         FactionNPC ff = (FactionNPC)reg.faction();
/* 194 */         ROPINION.STANCE().raid(ff, 1.0D);
/*     */       } 
/*     */       
/* 197 */       (RD.DEVASTATION()).current.inc(reg, iinc);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 202 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText info(WArmy a, GText box) {
/* 207 */     box.warnify();
/* 208 */     box.set(Dic.¤¤Raiding);
/* 209 */     return box;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name(WArmy a) {
/* 214 */     return Dic.¤¤Raiding;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyState$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */