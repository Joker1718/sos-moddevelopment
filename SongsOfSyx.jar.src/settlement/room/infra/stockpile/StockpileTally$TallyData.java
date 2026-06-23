/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TallyData
/*     */ {
/* 155 */   private final int[] ams = Alloc.ii(RESOURCES.ALL().size() + 1);
/* 156 */   private final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */   public final CharSequence name;
/*     */   private final int index;
/*     */   
/*     */   TallyData(CharSequence name) {
/* 161 */     this.name = name;
/* 162 */     this.index = paramStockpileTally.datas.add(this);
/*     */   }
/*     */   
/*     */   public int total(int ri) {
/* 166 */     return this.ams[ri];
/*     */   }
/*     */   
/*     */   public int total(RESOURCE res) {
/* 170 */     if (res == null)
/* 171 */       return this.ams[RESOURCES.ALL().size()]; 
/* 172 */     return this.ams[res.index()];
/*     */   }
/*     */   
/*     */   public int get(int ri, StockpileInstance ins) {
/* 176 */     return ins.tdata[this.index][ri];
/*     */   }
/*     */   
/*     */   public int get(RESOURCE res, StockpileInstance ins) {
/* 180 */     if (res == null)
/* 181 */       return ins.tdata[this.index][RESOURCES.ALL().size()]; 
/* 182 */     return ins.tdata[this.index][res.index()];
/*     */   }
/*     */   
/*     */   void inc(StockpileInstance ins, int ri, int am) {
/* 186 */     set(ins, ri, get(ri, ins) + am);
/*     */   }
/*     */   
/*     */   void set(StockpileInstance ins, int ri, int am) {
/* 190 */     int old = ins.tdata[this.index][ri];
/* 191 */     ins.tdata[this.index][RESOURCES.ALL().size()] = ins.tdata[this.index][RESOURCES.ALL().size()] - old;
/* 192 */     ins.tdata[this.index][ri] = am;
/* 193 */     ins.tdata[this.index][RESOURCES.ALL().size()] = ins.tdata[this.index][RESOURCES.ALL().size()] + am;
/*     */     
/* 195 */     this.ams[ri] = this.ams[ri] + am - old;
/* 196 */     this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] + am - old;
/*     */     
/* 198 */     if (this.ams[ri] < 0)
/* 199 */       throw new RuntimeException(String.valueOf(RESOURCES.ALL().get(ri)) + " " + String.valueOf(RESOURCES.ALL().get(ri))); 
/* 200 */     if (this.ams[ri] > 0) {
/* 201 */       this.bits.or((RESOURCE)RESOURCES.ALL().get(ri));
/*     */     } else {
/* 203 */       this.bits.clear((RESOURCE)RESOURCES.ALL().get(ri));
/*     */     } 
/*     */   }
/*     */   void clear() {
/* 207 */     Arrays.fill(this.ams, 0);
/* 208 */     this.bits.clear();
/*     */   }
/*     */   
/*     */   public RBIT bits() {
/* 212 */     return (RBIT)this.bits;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\StockpileTally$TallyData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */