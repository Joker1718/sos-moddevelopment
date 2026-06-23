/*     */ package settlement.room.military.supply;
/*     */ 
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
/*     */ public class TallyData
/*     */ {
/*     */   private final int insStride;
/*  87 */   private final int[] ams = Alloc.ii(RESOURCES.ALL().size() + 1);
/*     */   public final CharSequence name;
/*     */   private final int index;
/*     */   
/*     */   TallyData(CharSequence name) {
/*  92 */     this.name = name;
/*  93 */     this.index = paramSupplyTally.datas.add(this);
/*  94 */     this.insStride = this.index * (RESOURCES.ALL().size() + 1);
/*     */   }
/*     */   
/*     */   public int total(RESOURCE a) {
/*  98 */     if (a == null)
/*  99 */       return this.ams[RESOURCES.ALL().size()]; 
/* 100 */     return this.ams[a.index()];
/*     */   }
/*     */   
/*     */   public int get(SupplyInstance ins, RESOURCE a) {
/* 104 */     if (a == null)
/* 105 */       return ins.tdata[this.insStride + RESOURCES.ALL().size()]; 
/* 106 */     return ins.tdata[this.insStride + a.index()];
/*     */   }
/*     */   
/*     */   private void inc(SupplyInstance ins, RESOURCE a, int am) {
/* 110 */     set(ins, a, get(ins, a) + am);
/*     */   }
/*     */   
/*     */   private void set(SupplyInstance ins, RESOURCE a, int am) {
/* 114 */     int old = ins.tdata[this.insStride + a.index()];
/* 115 */     this.ams[a.index()] = this.ams[a.index()] - old;
/* 116 */     this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] - old;
/* 117 */     ins.tdata[this.insStride + a.index()] = (short)am;
/* 118 */     ins.tdata[this.insStride + RESOURCES.ALL().size()] = (short)am;
/* 119 */     this.ams[a.index()] = this.ams[a.index()] + am;
/* 120 */     this.ams[RESOURCES.ALL().size()] = this.ams[RESOURCES.ALL().size()] - am;
/*     */     
/* 122 */     if (this.ams[a.index()] < 0)
/* 123 */       throw new RuntimeException(String.valueOf(a) + " " + String.valueOf(a)); 
/*     */   }
/*     */   
/*     */   private void clear() {
/* 127 */     Arrays.fill(this.ams, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\SupplyTally$TallyData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */