/*     */ package world.region.building;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT_O;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BBoost
/*     */   extends Booster
/*     */   implements BValue
/*     */ {
/*     */   final boolean global;
/*     */   final BoostSpec b;
/*     */   final RDBuilding bu;
/* 401 */   public double min = Double.MAX_VALUE;
/* 402 */   public double max = Double.MIN_VALUE;
/*     */   
/*     */   public final double[] froms;
/*     */   public final double[] tos;
/*     */   
/*     */   public BBoost(RDBuilding bu, boolean global, BoostSpec b) {
/* 408 */     super(new BSourceInfo(bu.info.name, global ? Dic.¤¤Realm : null, (SPRITE)((RDBuildingLevel)bu.levels.get(1)).icon), b.booster.isMul);
/* 409 */     this.global = global;
/* 410 */     this.froms = new double[bu.levels.size()];
/* 411 */     this.tos = new double[bu.levels.size()];
/* 412 */     if (b.booster.isMul) {
/* 413 */       Arrays.fill(this.froms, 1.0D);
/* 414 */       Arrays.fill(this.tos, 1.0D);
/*     */     } 
/* 416 */     this.bu = bu;
/* 417 */     this.b = b;
/*     */     
/* 419 */     for (int li = 1; li < bu.levels.size(); li++) {
/* 420 */       RDBuildingLevel l = (RDBuildingLevel)bu.levels.get(li);
/* 421 */       BoostSpecs coll = global ? l.global : l.local;
/* 422 */       for (BoostSpec bb : coll.all()) {
/* 423 */         if (b.isSameAs(bb)) {
/*     */           
/* 425 */           this.froms[li] = bb.booster.from();
/* 426 */           this.tos[li] = bb.booster.to();
/* 427 */           double mi = Math.min(this.tos[li], this.froms[li]);
/* 428 */           double ma = Math.max(this.tos[li], this.froms[li]);
/* 429 */           this.min = Math.min(this.min, mi);
/* 430 */           this.max = Math.max(this.max, ma);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 437 */     bu.boosters.push(this, b.boostable, global ? Dic.¤¤Realm : null);
/* 438 */     bu.bboosts.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(BOOSTABLE_O o) {
/* 445 */     return o.boostableValue(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Region t) {
/* 451 */     if (this.global && t.realm() != null) {
/* 452 */       int ll = this.bu.level.get(t);
/* 453 */       int l = RD.BUILDINGS().tmp().level(this.bu, t);
/* 454 */       if (ll != l) {
/* 455 */         return vGet(t.faction()) - this.tos[ll] - this.froms[ll] + this.tos[l] - this.froms[l];
/*     */       }
/* 457 */       return vGet(t.faction());
/*     */     } 
/*     */     
/* 460 */     return g(t);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Faction f) {
/* 465 */     if (f == null)
/* 466 */       return 0.0D; 
/* 467 */     if (!this.global)
/* 468 */       return 0.0D; 
/* 469 */     double res = 0.0D;
/* 470 */     for (int i = 1; i < this.froms.length; i++) {
/* 471 */       double am = ((INT_O.INT_OE)this.bu.levelAm.get(i - 1)).get(f);
/* 472 */       res += (this.tos[i] - this.froms[i]) * am;
/*     */     } 
/* 474 */     if (this.b.booster.isMul) {
/* 475 */       res++;
/*     */     }
/*     */ 
/*     */     
/* 479 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 484 */     return vGet(indu.faction());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 489 */     return vGet(div.faction());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE t) {
/* 494 */     return vGet(FACTIONS.player());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 499 */     return vGet((Faction)f);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 504 */     return vGet((Faction)f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/* 510 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double pget(BOOSTABLE_O o) {
/* 516 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private double g(Region t) {
/* 520 */     double ta = this.tos[RD.BUILDINGS().tmp().level(this.bu, t)];
/* 521 */     if (!this.b.booster.isMul && ta < 0.0D)
/* 522 */       return ta; 
/* 523 */     int i = RD.BUILDINGS().tmp().level(this.bu, t);
/* 524 */     double vv = this.tos[i];
/* 525 */     if (this.b.booster.isMul || vv > 0.0D) {
/* 526 */       return this.froms[i] + this.bu.efficiency.get((BOOSTABLE_O)t) * (this.tos[i] - this.froms[i]);
/*     */     }
/* 528 */     return vv;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double from() {
/* 534 */     return this.froms[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/* 539 */     return this.tos[this.tos.length - 1];
/*     */   }
/*     */   
/*     */   public boolean canAfford(Region reg, int current, int level) {
/* 543 */     if ((RD.BUILDINGS()).costs.get(this.b.boostable, this.b.booster) != null) {
/* 544 */       double am = this.tos[current] - this.tos[level];
/* 545 */       if (am <= 0.0D)
/* 546 */         return true; 
/* 547 */       return (am <= this.b.boostable.get((BOOSTABLE_O)reg));
/*     */     } 
/* 549 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuilding$BBoost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */