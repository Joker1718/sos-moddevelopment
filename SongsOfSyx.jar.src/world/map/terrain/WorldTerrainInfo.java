/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ public final class WorldTerrainInfo
/*     */ {
/*  14 */   private final DOUBLE.DoubleImp[] terrain = new DOUBLE.DoubleImp[TERRAINS.ALL().size()];
/*  15 */   private final DOUBLE.DoubleImp fertility = new DOUBLE.DoubleImp();
/*  16 */   private final DOUBLE.DoubleImp[] climates = new DOUBLE.DoubleImp[CLIMATES.ALL().size()];
/*     */   public int tx;
/*     */   
/*     */   public WorldTerrainInfo() {
/*     */     int i;
/*  21 */     for (i = 0; i < this.terrain.length; i++) {
/*  22 */       this.terrain[i] = new DOUBLE.DoubleImp();
/*     */     }
/*  24 */     for (i = 0; i < this.climates.length; i++)
/*  25 */       this.climates[i] = new DOUBLE.DoubleImp(); 
/*     */   }
/*     */   public int ty;
/*     */   public void clear() {
/*     */     int i;
/*  30 */     for (i = 0; i < this.terrain.length; i++) {
/*  31 */       this.terrain[i].setD(0.0D);
/*     */     }
/*  33 */     for (i = 0; i < this.climates.length; i++) {
/*  34 */       this.climates[i].setD(0.0D);
/*     */     }
/*  36 */     this.fertility.setD(0.0D);
/*     */   }
/*     */   
/*     */   public void initCity(int x1, int y1) {
/*  40 */     clear();
/*  41 */     for (int y = 0; y < 3; y++) {
/*  42 */       for (int x = 0; x < 3; x++) {
/*  43 */         int tx = x + x1;
/*  44 */         int ty = y + y1;
/*  45 */         add(tx, ty);
/*     */       } 
/*     */     } 
/*  48 */     this.tx = x1 + 1;
/*  49 */     this.ty = y1 + 1;
/*  50 */     double d = 9.0D;
/*  51 */     divide(d);
/*     */   }
/*     */   
/*     */   public void add(int tx, int ty) {
/*  55 */     this.fertility.incD(WORLD.MOISTURE().get(tx, ty));
/*  56 */     double f = 0.0D;
/*  57 */     f += WORLD.FOREST().add(this, tx, ty);
/*  58 */     f += WORLD.MOUNTAIN().add(this, tx, ty);
/*  59 */     f += WORLD.WATER().add(this, tx, ty);
/*     */     
/*  61 */     add(TERRAINS.NONE(), CLAMP.d(1.0D - f, 0.0D, 1.0D));
/*     */     
/*  63 */     this.climates[((CLIMATE)(WORLD.CLIMATE()).getter.get(tx, ty)).index()].incD(1.0D);
/*     */   }
/*     */   
/*     */   public void add(TERRAIN t, double v) {
/*  67 */     this.terrain[t.index()].incD(v);
/*     */   }
/*     */   
/*     */   public DOUBLE.DoubleImp get(TERRAIN t) {
/*  71 */     return this.terrain[t.index()];
/*     */   }
/*     */   
/*     */   public DOUBLE.DoubleImp get(CLIMATE c) {
/*  75 */     return this.climates[c.index()];
/*     */   }
/*     */   
/*     */   public DOUBLE.DoubleImp fertility() {
/*  79 */     return this.fertility;
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
/*     */   
/*     */   public void divide(double d) {
/*     */     int i;
/*  96 */     for (i = 0; i < this.terrain.length; i++)
/*  97 */       this.terrain[i].setD(this.terrain[i].getD() / d); 
/*  98 */     for (i = 0; i < this.climates.length; i++)
/*  99 */       this.climates[i].setD(this.climates[i].getD() / d); 
/* 100 */     this.fertility.setD(this.fertility.getD() / d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldTerrainInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */