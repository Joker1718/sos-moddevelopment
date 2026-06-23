/*     */ package game.battle.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface DIV_SETTING
/*     */ {
/*     */   double training(StatsBattle.StatTraining paramStatTraining);
/*     */   
/*     */   double equip(EquipBattle paramEquipBattle);
/*     */   
/*     */   int men();
/*     */   
/*     */   default int equipI(EquipBattle e) {
/*  29 */     return (int)CLAMP.d(Math.round(equip(e) * e.equipMax), 0.0D, e.equipMax);
/*     */   }
/*     */   
/*     */   public static interface DIV_SETTINGE
/*     */     extends DIV_SETTING
/*     */   {
/*     */     void trainingSet(StatsBattle.StatTraining param1StatTraining, double param1Double);
/*     */     
/*     */     default DIV_SETTINGE copySettings(DIV_SETTING other) {
/*     */       int i;
/*  39 */       for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/*  40 */         EquipBattle b = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/*  41 */         equipSet(b, other.equip(b));
/*     */       } 
/*  43 */       for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/*  44 */         StatsBattle.StatTraining b = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/*  45 */         trainingSet(b, other.training(b));
/*     */       } 
/*  47 */       menSet(other.men());
/*  48 */       return this;
/*     */     } void equipSet(EquipBattle param1EquipBattle, double param1Double);
/*     */     void menSet(int param1Int);
/*     */     default DIV_SETTINGE copySettings(DIV_SETTING other, int men, double e, double t) {
/*     */       int i;
/*  53 */       for (i = 0; i < STATS.EQUIP().BATTLE_ALL().size(); i++) {
/*  54 */         EquipBattle b = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(i);
/*  55 */         double d = (int)Math.round(other.equip(b) * e * b.max());
/*  56 */         d /= b.max();
/*  57 */         d = CLAMP.d(d, 0.0D, 1.0D);
/*  58 */         equipSet(b, d);
/*     */       } 
/*  60 */       for (i = 0; i < (STATS.BATTLE()).TRAINING_ALL.size(); i++) {
/*  61 */         StatsBattle.StatTraining b = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(i);
/*  62 */         double d = (int)(other.training(b) * t * b.stat.indu().max(null));
/*  63 */         d /= b.stat.indu().max(null);
/*  64 */         d = CLAMP.d(d, 0.0D, 1.0D);
/*  65 */         trainingSet(b, d);
/*     */       } 
/*  67 */       menSet(men);
/*  68 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class DIV_SETTINGImp implements SAVABLE, DIV_SETTINGE, Serializable {
/*     */     private static final long serialVersionUID = 1L;
/*     */     public double[] equip;
/*     */     public double[] training;
/*     */     public int men;
/*     */     
/*     */     public DIV_SETTINGImp() {
/*  79 */       this.equip = new double[STATS.EQUIP().BATTLE_ALL().size()];
/*  80 */       this.training = new double[(STATS.BATTLE()).TRAINING_ALL.size()];
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/*  85 */       file.ds(this.equip);
/*  86 */       file.ds(this.training);
/*  87 */       file.i(this.men);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/*  92 */       file.ds(this.equip);
/*  93 */       file.ds(this.training);
/*  94 */       this.men = file.i();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/*  99 */       Arrays.fill(this.equip, 0.0D);
/* 100 */       Arrays.fill(this.training, 0.0D);
/* 101 */       this.men = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public double training(StatsBattle.StatTraining tr) {
/* 106 */       if (this.training == null || this.training.length != (STATS.BATTLE()).TRAINING_ALL.size())
/* 107 */         this.training = new double[(STATS.BATTLE()).TRAINING_ALL.size()]; 
/* 108 */       return this.training[tr.tIndex];
/*     */     }
/*     */ 
/*     */     
/*     */     public double equip(EquipBattle e) {
/* 113 */       if (this.equip == null || this.equip.length != STATS.EQUIP().BATTLE_ALL().size())
/* 114 */         this.equip = new double[STATS.EQUIP().BATTLE_ALL().size()]; 
/* 115 */       return this.equip[e.indexMilitary()];
/*     */     }
/*     */ 
/*     */     
/*     */     public int men() {
/* 120 */       return this.men;
/*     */     }
/*     */ 
/*     */     
/*     */     public void trainingSet(StatsBattle.StatTraining tr, double d) {
/* 125 */       this.training[tr.index()] = d;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void equipSet(EquipBattle e, double d) {
/* 131 */       this.equip[e.indexMilitary()] = d;
/*     */     }
/*     */ 
/*     */     
/*     */     public void menSet(int men) {
/* 136 */       this.men = men;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DIV_SETTING.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */