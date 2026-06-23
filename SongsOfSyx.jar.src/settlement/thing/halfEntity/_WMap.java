/*     */ package settlement.thing.halfEntity;
/*     */ 
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ class _WMap
/*     */ {
/*     */   private final _Quadrant[][] quadrants;
/*     */   private final int qMaxX;
/*     */   private final int qMaxY;
/*  12 */   private final int gridSize = 2048;
/*     */ 
/*     */   
/*     */   public _WMap(int mapSizeX, int mapSizeY) {
/*  16 */     this.qMaxX = mapSizeX / 2048;
/*  17 */     this.qMaxY = mapSizeY / 2048;
/*     */     
/*  19 */     this.quadrants = new _Quadrant[this.qMaxX][this.qMaxY];
/*     */     
/*  21 */     for (int y = 0; y < this.quadrants.length; y++) {
/*  22 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/*  23 */         this.quadrants[y][x] = new _Quadrant();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(HalfEntity e) {
/*  31 */     if (!isOut(e.gridX, e.gridY)) {
/*  32 */       throw new RuntimeException();
/*     */     }
/*  34 */     e.gridX = (short)(e.body().cX() / 2048);
/*  35 */     e.gridY = (short)(e.body().cY() / 2048);
/*     */ 
/*     */     
/*  38 */     if (isOut(e.gridX, e.gridY)) {
/*     */       return;
/*     */     }
/*  41 */     this.quadrants[e.gridY][e.gridX].add(e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(HalfEntity e) {
/*  47 */     if (isOut(e.gridX, e.gridY)) {
/*     */       return;
/*     */     }
/*  50 */     this.quadrants[e.gridY][e.gridX].remove(e);
/*  51 */     e.gridY = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void move(HalfEntity e) {
/*  58 */     short gridX = (short)(e.body().cX() / 2048);
/*  59 */     short gridY = (short)(e.body().cY() / 2048);
/*     */     
/*  61 */     if (e.gridX != gridX || e.gridY != gridY) {
/*  62 */       remove(e);
/*  63 */       add(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isOut(int qx1, int qy1) {
/*  70 */     return !(qx1 < this.qMaxX && qy1 < this.qMaxY && qx1 >= 0 && qy1 >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void fill(int x1, int x2, int y1, int y2, Tree<HalfEntity> result) {
/*  77 */     int min = 0;
/*     */     
/*  79 */     int qx1 = (x1 - min) / 2048;
/*  80 */     if (qx1 < 0)
/*  81 */       qx1 = 0; 
/*  82 */     int qy1 = (y1 - min) / 2048;
/*  83 */     if (qy1 < 0)
/*  84 */       qy1 = 0; 
/*  85 */     int qx2 = (x2 + min) / 2048;
/*  86 */     if (qx2 >= this.qMaxX)
/*  87 */       qx2 = this.qMaxX - 1; 
/*  88 */     int qy2 = (y2 + min) / 2048;
/*  89 */     if (qy2 >= this.qMaxY) {
/*  90 */       qy2 = this.qMaxY - 1;
/*     */     }
/*     */ 
/*     */     
/*  94 */     for (int y = qy1; y <= qy2; y++) {
/*  95 */       for (int x = qx1; x <= qx2; x++) {
/*  96 */         for (HalfEntity e : this.quadrants[y][x]) {
/*  97 */           if (e.body().touches(x1, x2, y1, y2)) {
/*  98 */             result.add(e);
/*  99 */             if (!result.hasRoom()) {
/*     */               return;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void fill(int x1, int x2, int y1, int y2, LISTE<HalfEntity> result) {
/* 110 */     int min = 192;
/*     */     
/* 112 */     int qx1 = (x1 - min) / 2048;
/* 113 */     if (qx1 < 0)
/* 114 */       qx1 = 0; 
/* 115 */     int qy1 = (y1 - min) / 2048;
/* 116 */     if (qy1 < 0)
/* 117 */       qy1 = 0; 
/* 118 */     int qx2 = (x2 + min) / 2048;
/* 119 */     if (qx2 >= this.qMaxX)
/* 120 */       qx2 = this.qMaxX - 1; 
/* 121 */     int qy2 = (y2 + min) / 2048;
/* 122 */     if (qy2 >= this.qMaxY) {
/* 123 */       qy2 = this.qMaxY - 1;
/*     */     }
/* 125 */     for (int y = qy1; y <= qy2; y++) {
/* 126 */       for (int x = qx1; x <= qx2; x++) {
/* 127 */         for (HalfEntity e : this.quadrants[y][x]) {
/* 128 */           if (e.body().touches(x1, x2, y1, y2)) {
/* 129 */             result.add(e);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void clear() {
/* 137 */     for (int y = 0; y < this.quadrants.length; y++) {
/* 138 */       for (int x = 0; x < (this.quadrants[0]).length; x++)
/* 139 */         this.quadrants[y][x].clear(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\_WMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */