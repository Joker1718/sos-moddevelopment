/*     */ package world.region;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.DivisionBanners;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.race.Race;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.text.Dic;
/*     */ import world.army.WDIV;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class WDiv
/*     */   implements WDIV
/*     */ {
/*     */   Race race;
/*     */   int men;
/*     */   int menTarget;
/*     */   int index;
/*     */   Faction f;
/*     */   Region r;
/*     */   
/*     */   public int men() {
/* 175 */     return this.men;
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 180 */     return this.race;
/*     */   }
/*     */ 
/*     */   
/*     */   public int menTarget() {
/* 185 */     return this.menTarget;
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 190 */     return 0.1D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resolve(Induvidual[] hs) {
/* 195 */     menSet(hs.length);
/*     */   }
/*     */   
/*     */   public void resolve(int surviviors, double experiencePerMan) {
/* 199 */     menSet(surviviors);
/*     */   }
/*     */   
/*     */   void menSet(int amount) {
/* 203 */     (RD.MILITARY()).garrison.inc(this.r, -this.men);
/* 204 */     (RD.MILITARY()).garrison.inc(this.r, amount);
/* 205 */     this.men = amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int daysUntilMenArrives() {
/* 210 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 215 */     return Dic.¤¤Garrison;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needSupplies() {
/* 221 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 226 */     if (this.f != null && this.f.capitolRegion() == this.r && this.f instanceof FactionNPC) {
/* 227 */       double d = 0.15D * (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)(((FactionNPC)this.f).court().king().roy()).induvidual);
/* 228 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 229 */       return d;
/*     */     } 
/* 231 */     return 0.15D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DivisionBanners.DivisionBanner banner() {
/* 237 */     return (GAME.ARMIES()).banners.get(this.index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bannerSet(int bi) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 247 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public DivGeneration generate() {
/* 252 */     return new DivGeneration((DIV_SPEC)this, this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 257 */     return e.garrisonAmount() / e.equipMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 262 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WArmy army() {
/* 268 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR color() {
/* 273 */     return RDMilitaryGar.colr;
/*     */   }
/*     */   
/* 276 */   public final DIV_SETTING target = new DIV_SETTING()
/*     */     {
/*     */       public double training(StatsBattle.StatTraining tr)
/*     */       {
/* 280 */         return RDMilitaryGar.WDiv.this.training(tr);
/*     */       }
/*     */ 
/*     */       
/*     */       public double equip(EquipBattle e) {
/* 285 */         return RDMilitaryGar.WDiv.this.equip(e);
/*     */       }
/*     */ 
/*     */       
/*     */       public int men() {
/* 290 */         return RDMilitaryGar.WDiv.this.menTarget;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public DIV_SETTING target() {
/* 297 */     return this.target;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDMilitaryGar$WDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */