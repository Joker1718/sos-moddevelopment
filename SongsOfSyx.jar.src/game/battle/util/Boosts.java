/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.MapIndexed;
/*     */ 
/*     */ 
/*     */ final class Boosts
/*     */ {
/*  20 */   private final MapIndexed<Entry> map = new MapIndexed();
/*     */   
/*     */   public double get(DIV_SPEC div, Boostable bo) {
/*  23 */     if (!this.map.contains(bo.index())) {
/*  24 */       this.map.add(new Entry(bo));
/*     */     }
/*  26 */     Entry e = (Entry)this.map.get(bo.index());
/*  27 */     return e.get(div);
/*     */   }
/*     */ 
/*     */   
/*     */   public double max(Boostable bo) {
/*  32 */     if (!this.map.contains(bo.index()))
/*  33 */       this.map.add(new Entry(bo)); 
/*  34 */     return ((Entry)this.map.get(bo.index())).max();
/*     */   }
/*     */ 
/*     */   
/*     */   private class Entry
/*     */     implements INDEXED
/*     */   {
/*  41 */     private int checkI = GAME.updateI() - 1201;
/*     */     private final Boostable bo;
/*  43 */     final Boosts.TmpBoost badd = new Boosts.TmpBoost();
/*  44 */     final Boosts.TmpBoost bmul = new Boosts.TmpBoost();
/*     */     
/*  46 */     private double add = 0.0D;
/*  47 */     private double sub = 0.0D;
/*  48 */     private double mul = 0.0D;
/*     */     
/*     */     Entry(Boostable bo) {
/*  51 */       this.bo = bo;
/*     */     }
/*     */ 
/*     */     
/*     */     double get(DIV_SPEC div) {
/*  56 */       if (Math.abs(this.checkI - GAME.updateI()) > 1200) {
/*  57 */         this.checkI = GAME.updateI();
/*  58 */         this.badd.set(this.bo, false);
/*  59 */         this.bmul.set(this.bo, true);
/*     */       } 
/*     */       
/*  62 */       this.add = this.bo.baseValue;
/*  63 */       this.sub = 0.0D;
/*  64 */       this.mul = 1.0D;
/*     */       
/*  66 */       for (BoostSpec ss : div.race().all(this.bo)) {
/*  67 */         if (ss.booster.isMul) {
/*  68 */           this.mul *= ss.booster.getValue(1.0D); continue;
/*     */         } 
/*  70 */         add(ss.booster.getValue(1.0D));
/*     */       } 
/*     */       
/*  73 */       if (div.faction() != null) {
/*  74 */         for (Booster ss : this.bo.fGlobal) {
/*  75 */           if (ss.isMul) {
/*  76 */             this.mul *= ss.get(div.faction()); continue;
/*     */           } 
/*  78 */           add(ss.get(div.faction()));
/*     */         } 
/*     */       }
/*     */       
/*  82 */       add(div.experience(), this.badd.experience, this.bmul.experience);
/*     */       int i;
/*  84 */       for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/*  85 */         StatsBattle.StatTraining tr = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/*  86 */         double v = tr.bValue(div.training((StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i)));
/*  87 */         add(v, this.badd.training[i], this.bmul.training[i]);
/*     */       } 
/*     */       
/*  90 */       for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/*  91 */         EquipBattle e = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/*  92 */         double v = e.bValue(div.equip(e));
/*  93 */         add(v, this.badd.equip[i], this.bmul.equip[i]);
/*     */       } 
/*     */ 
/*     */       
/*  97 */       return CLAMP.d(this.mul * this.add + this.sub, 0.0D, Double.MAX_VALUE);
/*     */     }
/*     */ 
/*     */     
/*     */     double max() {
/* 102 */       double add = this.bo.baseValue;
/* 103 */       double mul = 1.0D;
/*     */       
/* 105 */       double a = 0.0D;
/* 106 */       double m = 0.0D;
/*     */ 
/*     */       
/* 109 */       for (int ri = 0; ri < RACES.playable().size(); ri++) {
/* 110 */         Race r = (Race)RACES.playable().get(ri);
/* 111 */         a = Math.max(a, this.badd.race[r.index]);
/* 112 */         m = Math.max(m, this.bmul.race[r.index]);
/*     */       } 
/* 114 */       add += a;
/* 115 */       mul *= m;
/*     */       
/* 117 */       a = 0.0D;
/* 118 */       m = 0.0D;
/*     */       int i;
/* 120 */       for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 121 */         a = Math.max(a, this.badd.training[i]);
/* 122 */         m = Math.max(a, this.bmul.training[i]);
/*     */       } 
/*     */       
/* 125 */       add += a;
/* 126 */       mul *= m;
/*     */       
/* 128 */       a = 0.0D;
/* 129 */       m = 0.0D;
/*     */       
/* 131 */       for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 132 */         a = Math.max(a, this.badd.equip[i]);
/* 133 */         m = Math.max(a, this.bmul.equip[i]);
/*     */       } 
/*     */       
/* 136 */       add += a;
/* 137 */       mul *= m;
/*     */       
/* 139 */       return add * mul;
/*     */     }
/*     */ 
/*     */     
/*     */     void add(double v, double a, double m) {
/* 144 */       a *= v;
/* 145 */       m = 1.0D + (m - 1.0D) * v;
/* 146 */       add(a);
/* 147 */       this.mul *= m;
/*     */     }
/*     */ 
/*     */     
/*     */     void add(double a) {
/* 152 */       if (a < 0.0D) {
/* 153 */         this.sub += a;
/*     */       } else {
/* 155 */         this.add += a;
/*     */       } 
/*     */     }
/*     */     
/*     */     public int index() {
/* 160 */       return this.bo.index();
/*     */     }
/*     */   }
/*     */   
/*     */   private final class TmpBoost {
/*     */     private double[] training;
/*     */     private double[] equip;
/*     */     
/*     */     private TmpBoost() {
/* 169 */       this.training = new double[(STATS.BATTLE()).TRAINING_ALL.size()];
/* 170 */       this.equip = new double[STATS.EQUIP().all().size()];
/* 171 */       this.race = new double[RACES.all().size()];
/*     */     }
/*     */     private double[] race;
/*     */     
/*     */     void set(Boostable bo, boolean isMul) {
/* 176 */       this.experience = get((STATS.BATTLE()).COMBAT_EXPERIENCE.boosters, bo, isMul);
/* 177 */       for (int ri = 0; ri < RACES.all().size(); ri++)
/* 178 */         this.race[ri] = get(((Race)RACES.all().get(ri)).boosts, bo, isMul);  int i;
/* 179 */       for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/* 180 */         StatsBattle.StatTraining t = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/* 181 */         this.training[i] = get(t.stat.boosters, bo, isMul);
/*     */       } 
/* 183 */       for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/* 184 */         EquipBattle t = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/* 185 */         this.equip[i] = get((t.stat()).boosters, bo, isMul);
/*     */       } 
/*     */     }
/*     */     private double experience;
/*     */     private double get(BoostSpecs bos, Boostable bo, boolean isMul) {
/* 190 */       if (isMul) {
/* 191 */         double d = 1.0D;
/* 192 */         for (int i = 0; i < bos.all().size(); i++) {
/* 193 */           BoostSpec s = (BoostSpec)bos.all().get(i);
/* 194 */           if (s.booster.isMul == isMul && s.boostable == bo) {
/* 195 */             d *= s.booster.to();
/*     */           }
/*     */         } 
/*     */         
/* 199 */         return d;
/*     */       } 
/* 201 */       double res = 0.0D;
/* 202 */       for (int si = 0; si < bos.all().size(); si++) {
/* 203 */         BoostSpec s = (BoostSpec)bos.all().get(si);
/* 204 */         if (s.booster.isMul == isMul && s.boostable == bo) {
/* 205 */           res += s.booster.to();
/*     */         }
/*     */       } 
/*     */       
/* 209 */       return res;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\Boosts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */