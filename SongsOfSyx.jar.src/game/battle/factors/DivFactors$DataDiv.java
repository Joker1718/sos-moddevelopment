/*     */ package game.battle.factors;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.data.DOUBLE_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class DataDiv
/*     */   implements DOUBLE_O.DOUBLE_OE<Div>, SAVABLE
/*     */ {
/* 222 */   private final double[] data = new double[(Config.battle()).DIVISIONS_PER_BATTLE];
/* 223 */   private final long[] dataa = new long[2];
/*     */ 
/*     */   
/*     */   public final DOUBLE_O<Army> army;
/*     */ 
/*     */ 
/*     */   
/*     */   public double getD(Div t) {
/* 231 */     return this.data[t.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 236 */     file.ds(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 241 */     file.ds(this.data);
/* 242 */     Arrays.fill(this.dataa, 0L);
/* 243 */     for (int ai = 0; ai < 2; ai++) {
/* 244 */       for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 245 */         this.dataa[ai] = this.dataa[ai] + (int)(this.data[ai * (Config.battle()).DIVISIONS_PER_ARMY + di] * 100.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 252 */     Arrays.fill(this.data, 0.0D);
/* 253 */     Arrays.fill(this.dataa, 0L);
/*     */   }
/*     */   
/*     */   void clear(Army a) {
/* 257 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 258 */       this.data[a.index() * (Config.battle()).DIVISIONS_PER_ARMY + di] = 0.0D;
/*     */     }
/* 260 */     this.dataa[a.index()] = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public DOUBLE_O.DOUBLE_OE<Div> setD(Div t, double d) {
/* 265 */     this.dataa[t.army().index()] = this.dataa[t.army().index()] - (int)(this.data[t.index()] * 100.0D);
/* 266 */     this.data[t.index()] = d;
/* 267 */     this.dataa[t.army().index()] = this.dataa[t.army().index()] + (int)(this.data[t.index()] * 100.0D);
/* 268 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   DataDiv() {
/* 273 */     this.army = new DOUBLE_O<Army>()
/*     */       {
/*     */         public double getD(Army t)
/*     */         {
/* 277 */           return DivFactors.DataDiv.this.dataa[t.index()] / 100.0D;
/*     */         }
/*     */       };
/*     */     paramDivFactors.datas.add(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\DivFactors$DataDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */