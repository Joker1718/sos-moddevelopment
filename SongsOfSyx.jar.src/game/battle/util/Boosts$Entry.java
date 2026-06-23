/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Entry
/*     */   implements INDEXED
/*     */ {
/*  41 */   private int checkI = GAME.updateI() - 1201; private final Boostable bo; final Boosts.TmpBoost badd; final Boosts.TmpBoost bmul;
/*     */   Entry(Boostable bo) {
/*  43 */     this.badd = new Boosts.TmpBoost(paramBoosts);
/*  44 */     this.bmul = new Boosts.TmpBoost(paramBoosts);
/*     */     
/*  46 */     this.add = 0.0D;
/*  47 */     this.sub = 0.0D;
/*  48 */     this.mul = 0.0D;
/*     */ 
/*     */     
/*  51 */     this.bo = bo;
/*     */   }
/*     */   private double add; private double sub; private double mul;
/*     */   
/*     */   double get(DIV_SPEC div) {
/*  56 */     if (Math.abs(this.checkI - GAME.updateI()) > 1200) {
/*  57 */       this.checkI = GAME.updateI();
/*  58 */       this.badd.set(this.bo, false);
/*  59 */       this.bmul.set(this.bo, true);
/*     */     } 
/*     */     
/*  62 */     this.add = this.bo.baseValue;
/*  63 */     this.sub = 0.0D;
/*  64 */     this.mul = 1.0D;
/*     */     
/*  66 */     for (BoostSpec ss : div.race().all(this.bo)) {
/*  67 */       if (ss.booster.isMul) {
/*  68 */         this.mul *= ss.booster.getValue(1.0D); continue;
/*     */       } 
/*  70 */       add(ss.booster.getValue(1.0D));
/*     */     } 
/*     */     
/*  73 */     if (div.faction() != null) {
/*  74 */       for (Booster ss : this.bo.fGlobal) {
/*  75 */         if (ss.isMul) {
/*  76 */           this.mul *= ss.get(div.faction()); continue;
/*     */         } 
/*  78 */         add(ss.get(div.faction()));
/*     */       } 
/*     */     }
/*     */     
/*  82 */     add(div.experience(), this.badd.experience, this.bmul.experience);
/*     */     int i;
/*  84 */     for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/*  85 */       StatsBattle.StatTraining tr = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/*  86 */       double v = tr.bValue(div.training((StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i)));
/*  87 */       add(v, this.badd.training[i], this.bmul.training[i]);
/*     */     } 
/*     */     
/*  90 */     for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/*  91 */       EquipBattle e = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/*  92 */       double v = e.bValue(div.equip(e));
/*  93 */       add(v, this.badd.equip[i], this.bmul.equip[i]);
/*     */     } 
/*     */ 
/*     */     
/*  97 */     return CLAMP.d(this.mul * this.add + this.sub, 0.0D, Double.MAX_VALUE);
/*     */   }
/*     */ 
/*     */   
/*     */   double max() {
/* 102 */     double add = this.bo.baseValue;
/* 103 */     double mul = 1.0D;
/*     */     
/* 105 */     double a = 0.0D;
/* 106 */     double m = 0.0D;
/*     */ 
/*     */     
/* 109 */     for (int ri = 0; ri < RACES.playable().size(); ri++) {
/* 110 */       Race r = (Race)RACES.playable().get(ri);
/* 111 */       a = Math.max(a, this.badd.race[r.index]);
/* 112 */       m = Math.max(m, this.bmul.race[r.index]);
/*     */     } 
/* 114 */     add += a;
/* 115 */     mul *= m;
/*     */     
/* 117 */     a = 0.0D;
/* 118 */     m = 0.0D;
/*     */     int i;
/* 120 */     for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 121 */       a = Math.max(a, this.badd.training[i]);
/* 122 */       m = Math.max(a, this.bmul.training[i]);
/*     */     } 
/*     */     
/* 125 */     add += a;
/* 126 */     mul *= m;
/*     */     
/* 128 */     a = 0.0D;
/* 129 */     m = 0.0D;
/*     */     
/* 131 */     for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 132 */       a = Math.max(a, this.badd.equip[i]);
/* 133 */       m = Math.max(a, this.bmul.equip[i]);
/*     */     } 
/*     */     
/* 136 */     add += a;
/* 137 */     mul *= m;
/*     */     
/* 139 */     return add * mul;
/*     */   }
/*     */ 
/*     */   
/*     */   void add(double v, double a, double m) {
/* 144 */     a *= v;
/* 145 */     m = 1.0D + (m - 1.0D) * v;
/* 146 */     add(a);
/* 147 */     this.mul *= m;
/*     */   }
/*     */ 
/*     */   
/*     */   void add(double a) {
/* 152 */     if (a < 0.0D) {
/* 153 */       this.sub += a;
/*     */     } else {
/* 155 */       this.add += a;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int index() {
/* 160 */     return this.bo.index();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\Boosts$Entry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */