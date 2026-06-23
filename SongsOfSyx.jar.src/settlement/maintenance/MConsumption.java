/*     */ package settlement.maintenance;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.AvailabilityListener;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.map.AbsGrid;
/*     */ 
/*     */ 
/*     */ final class MConsumption
/*     */ {
/*  14 */   private final AbsGrid grid = new AbsGrid(SETT.TWIDTH, SETT.THEIGHT, 32);
/*  15 */   private final QData[] datas = new QData[this.grid.all.size()];
/*  16 */   private final long[] ress = new long[RESOURCES.ALL().size()];
/*     */   
/*     */   private final MAINTENANCE m;
/*  19 */   private int upI = 0;
/*     */   
/*  21 */   private final int DD = 16384;
/*  22 */   private final double DDI = 6.103515625E-5D;
/*     */   
/*     */   MConsumption(MAINTENANCE m) {
/*  25 */     this.m = m;
/*  26 */     for (int i = 0; i < this.datas.length; i++) {
/*  27 */       this.datas[i] = new QData();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init() {
/*  43 */     for (int i = 0; i < this.grid.all.size(); i++) {
/*  44 */       update(i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void update() {
/*  50 */     if (this.upI >= this.grid.all.size()) {
/*  51 */       this.upI = 0;
/*     */     }
/*  53 */     if ((this.datas[this.upI]).changed) {
/*  54 */       update(this.upI);
/*     */     }
/*  56 */     this.upI++;
/*     */   }
/*     */ 
/*     */   
/*     */   void change(int tx, int ty) {
/*  61 */     int in = ((AbsGrid.GridTile)this.grid.map.get(tx, ty)).index;
/*  62 */     (this.datas[in]).changed = true;
/*     */   }
/*     */   
/*     */   private void update(int i) {
/*  66 */     QData d = this.datas[i];
/*  67 */     d.changed = false; int r;
/*  68 */     for (r = 0; r < RESOURCES.ALL().size(); r++) {
/*  69 */       this.ress[r] = (long)(this.ress[r] - Math.ceil(d.amounts[r] * 16384.0D));
/*  70 */       d.amounts[r] = 0.0D;
/*     */     } 
/*  72 */     for (COORDINATE c : this.grid.get(i)) {
/*  73 */       if (this.m.disabled.is(c))
/*     */         continue;  byte b; int j; MType[] arrayOfMType;
/*  75 */       for (j = (arrayOfMType = this.m.types).length, b = 0; b < j; ) { MType t = arrayOfMType[b];
/*  76 */         for (int k = 1; k < 5; k++) {
/*  77 */           double am = t.resRate(c.x(), c.y(), k);
/*  78 */           if (am > 0.0D)
/*     */           {
/*  80 */             d.amounts[t.res(c.x(), c.y(), k).index()] = d.amounts[t.res(c.x(), c.y(), k).index()] + am; } 
/*     */         } 
/*     */         b++; }
/*     */     
/*     */     } 
/*  85 */     for (r = 0; r < RESOURCES.ALL().size(); r++)
/*  86 */       this.ress[r] = (long)(this.ress[r] + Math.ceil(d.amounts[r] * 16384.0D)); 
/*     */   }
/*     */   
/*     */   private static class QData { private double[] amounts;
/*     */     private boolean changed;
/*     */     
/*     */     private QData() {
/*  93 */       this.amounts = new double[RESOURCES.ALL().size()];
/*  94 */       this.changed = false;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(RESOURCE res) {
/* 100 */     return this.ress[res.index()] * 6.103515625E-5D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\MConsumption.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */