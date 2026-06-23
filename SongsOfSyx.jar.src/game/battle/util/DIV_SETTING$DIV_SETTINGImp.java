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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DIV_SETTINGImp
/*     */   implements SAVABLE, DIV_SETTING.DIV_SETTINGE, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  79 */   public double[] equip = new double[STATS.EQUIP().BATTLE_ALL().size()];
/*  80 */   public double[] training = new double[(STATS.BATTLE()).TRAINING_ALL.size()];
/*     */   
/*     */   public int men;
/*     */   
/*     */   public void save(FilePutter file) {
/*  85 */     file.ds(this.equip);
/*  86 */     file.ds(this.training);
/*  87 */     file.i(this.men);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  92 */     file.ds(this.equip);
/*  93 */     file.ds(this.training);
/*  94 */     this.men = file.i();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  99 */     Arrays.fill(this.equip, 0.0D);
/* 100 */     Arrays.fill(this.training, 0.0D);
/* 101 */     this.men = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 106 */     if (this.training == null || this.training.length != (STATS.BATTLE()).TRAINING_ALL.size())
/* 107 */       this.training = new double[(STATS.BATTLE()).TRAINING_ALL.size()]; 
/* 108 */     return this.training[tr.tIndex];
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 113 */     if (this.equip == null || this.equip.length != STATS.EQUIP().BATTLE_ALL().size())
/* 114 */       this.equip = new double[STATS.EQUIP().BATTLE_ALL().size()]; 
/* 115 */     return this.equip[e.indexMilitary()];
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 120 */     return this.men;
/*     */   }
/*     */ 
/*     */   
/*     */   public void trainingSet(StatsBattle.StatTraining tr, double d) {
/* 125 */     this.training[tr.index()] = d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void equipSet(EquipBattle e, double d) {
/* 131 */     this.equip[e.indexMilitary()] = d;
/*     */   }
/*     */ 
/*     */   
/*     */   public void menSet(int men) {
/* 136 */     this.men = men;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DIV_SETTING$DIV_SETTINGImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */