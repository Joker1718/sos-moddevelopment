/*     */ package world.entity;
/*     */ 
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sets.ADDABLE;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Tree;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ class _WEntityMap
/*     */ {
/*     */   private final _QuadrantArray[][] quadrants;
/*  15 */   private final WEntity[] region = new WEntity[1023];
/*     */   private final int qMaxX;
/*     */   private final int qMaxY;
/*  18 */   private final int gridSize = 1024;
/*     */ 
/*     */   
/*     */   public _WEntityMap(int mapSizeX, int mapSizeY) {
/*  22 */     this.qMaxX = mapSizeX / 1024;
/*  23 */     this.qMaxY = mapSizeY / 1024;
/*     */     
/*  25 */     this.quadrants = new _QuadrantArray[this.qMaxX][this.qMaxY];
/*     */     
/*  27 */     for (int y = 0; y < this.quadrants.length; y++) {
/*  28 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/*  29 */         this.quadrants[y][x] = new _QuadrantArray();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(WEntity e) {
/*  37 */     if (!isOut(e.gridX, e.gridY)) {
/*  38 */       throw new RuntimeException();
/*     */     }
/*  40 */     e.gridX = (short)(e.body().x1() / 1024);
/*  41 */     e.gridY = (short)(e.body().y1() / 1024);
/*     */ 
/*     */     
/*  44 */     if (isOut(e.gridX, e.gridY)) {
/*     */       return;
/*     */     }
/*  47 */     this.quadrants[e.gridY][e.gridX].add(e);
/*     */     
/*  49 */     e.regionI = -1;
/*  50 */     Region reg = (Region)(WORLD.REGIONS()).map.get(e.ctx(), e.cty());
/*  51 */     if (reg != null) {
/*  52 */       e.regionI = (short)reg.index();
/*  53 */       WEntity rn = this.region[reg.index()];
/*  54 */       this.region[reg.index()] = e;
/*  55 */       e.regionNext = rn;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(WEntity e) {
/*  61 */     if (isOut(e.gridX, e.gridY)) {
/*     */       return;
/*     */     }
/*  64 */     this.quadrants[e.gridY][e.gridX].remove(e);
/*  65 */     e.gridY = -1;
/*  66 */     if (e.regionI != -1) {
/*     */       
/*  68 */       WEntity current = this.region[e.regionI];
/*  69 */       this.region[e.regionI] = null;
/*  70 */       while (current != null) {
/*  71 */         if (current != e) {
/*  72 */           WEntity rn = this.region[e.regionI];
/*  73 */           this.region[e.regionI] = current;
/*  74 */           WEntity next = current.regionNext;
/*  75 */           current.regionNext = rn;
/*  76 */           current = next; continue;
/*     */         } 
/*  78 */         current = current.regionNext;
/*     */       } 
/*  80 */       e.regionNext = null;
/*  81 */       e.regionI = -1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public WEntity regFirst(Region reg) {
/*  86 */     return this.region[reg.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void move(WEntity e) {
/*  91 */     short gridX = (short)(e.body().x1() / 1024);
/*  92 */     short gridY = (short)(e.body().y1() / 1024);
/*  93 */     Region reg = (Region)(WORLD.REGIONS()).map.get(e.ctx(), e.cty());
/*  94 */     int ri = (reg == null) ? -1 : reg.index();
/*     */     
/*  96 */     if (e.gridX != gridX || e.gridY != gridY || ri != e.regionI) {
/*  97 */       remove(e);
/*  98 */       add(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isOut(int qx1, int qy1) {
/* 105 */     return !(qx1 < this.qMaxX && qy1 < this.qMaxY && qx1 >= 0 && qy1 >= 0);
/*     */   }
/*     */   
/*     */   void fill(RECTANGLE area, LISTE<WEntity> result) {
/* 109 */     fill(area.x1(), area.x2(), area.y1(), area.y2(), (ADDABLE<WEntity>)result);
/*     */   }
/*     */ 
/*     */   
/*     */   void fill(RECTANGLE area, Tree<WEntity> result) {
/* 114 */     fill(area.x1(), area.x2(), area.y1(), area.y2(), (ADDABLE<WEntity>)result);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void fill(int x1, int x2, int y1, int y2, ADDABLE<WEntity> result) {
/* 120 */     int min = 192;
/*     */     
/* 122 */     int qx1 = (x1 - min) / 1024;
/* 123 */     if (qx1 < 0)
/* 124 */       qx1 = 0; 
/* 125 */     int qy1 = (y1 - min) / 1024;
/* 126 */     if (qy1 < 0)
/* 127 */       qy1 = 0; 
/* 128 */     int qx2 = (x2 + min) / 1024;
/* 129 */     if (qx2 >= this.qMaxX)
/* 130 */       qx2 = this.qMaxX - 1; 
/* 131 */     int qy2 = (y2 + min) / 1024;
/* 132 */     if (qy2 >= this.qMaxY) {
/* 133 */       qy2 = this.qMaxY - 1;
/*     */     }
/* 135 */     for (int y = qy1; y <= qy2; y++) {
/* 136 */       for (int x = qx1; x <= qx2; x++) {
/* 137 */         for (WEntity e : this.quadrants[y][x]) {
/* 138 */           if (e.body().touches(x1, x2, y1, y2)) {
/* 139 */             if (!result.hasRoom())
/*     */               return; 
/* 141 */             result.add(e);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void fill(int x, int y, ADDABLE<WEntity> result) {
/* 150 */     fill(x, x, y, y, result);
/*     */   }
/*     */   
/*     */   void clear() {
/* 154 */     for (int y = 0; y < this.quadrants.length; y++) {
/* 155 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/* 156 */         this.quadrants[y][x].clear();
/*     */       }
/*     */     } 
/* 159 */     for (int i = 0; i < this.region.length; i++)
/* 160 */       this.region[i] = null; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\_WEntityMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */