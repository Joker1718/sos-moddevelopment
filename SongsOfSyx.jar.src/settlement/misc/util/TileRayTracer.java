/*     */ package settlement.misc.util;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ public final class TileRayTracer
/*     */ {
/*     */   private final int radius;
/*     */   private final Ray[] rays;
/*     */   private final Ray[][][] raysOnTile;
/*     */   private final COORDINATE[] allTiles;
/*  15 */   private final Ray[] empty = new Ray[0];
/*     */   private final short[][] check;
/*  17 */   private short checkI = 0;
/*     */ 
/*     */   
/*     */   public TileRayTracer(int radius) {
/*  21 */     this.radius = radius;
/*  22 */     LinkedList<Ray> rays = new LinkedList();
/*     */     
/*  24 */     boolean[][] has = new boolean[radius * 2 + 1][radius * 2 + 1];
/*  25 */     this.raysOnTile = new Ray[radius * 2 + 1][radius * 2 + 1][0];
/*  26 */     for (int gy = -radius; gy <= radius; gy++) {
/*  27 */       rayTrace(-radius, gy, has, rays);
/*  28 */       rayTrace(radius, gy, has, rays);
/*     */     } 
/*     */     
/*  31 */     for (int gx = -radius; gx <= radius; gx++) {
/*  32 */       rayTrace(gx, -radius, has, rays);
/*  33 */       rayTrace(gx, radius, has, rays);
/*     */     } 
/*     */     
/*  36 */     this.rays = new Ray[rays.size()];
/*  37 */     int i = 0;
/*  38 */     while (!rays.isEmpty()) {
/*  39 */       this.rays[i] = new Ray((Ray)rays.removeFirst(), i);
/*  40 */       i++;
/*     */     } 
/*  42 */     int[][] grid = Alloc.i2(radius * 2 + 1, radius * 2 + 1);
/*  43 */     int all = 0; byte b; int j; Ray[] arrayOfRay1;
/*  44 */     for (j = (arrayOfRay1 = this.rays).length, b = 0; b < j; ) { Ray r = arrayOfRay1[b]; byte b1; int m; COORDINATE[] arrayOfCOORDINATE;
/*  45 */       for (m = (arrayOfCOORDINATE = r.coos).length, b1 = 0; b1 < m; ) { COORDINATE c = arrayOfCOORDINATE[b1];
/*     */         
/*  47 */         if (grid[c.y() + radius][c.x() + radius] == 0)
/*  48 */           all++; 
/*  49 */         grid[c.y() + radius][c.x() + radius] = grid[c.y() + radius][c.x() + radius] + 1;
/*     */         
/*     */         b1++; }
/*     */       
/*     */       b++; }
/*     */     
/*  55 */     this.allTiles = new COORDINATE[all];
/*  56 */     int tileI = 0;
/*  57 */     for (int y = 0; y < grid.length; y++) {
/*  58 */       for (int x = 0; x < (grid[y]).length; x++) {
/*  59 */         int c = grid[y][x];
/*  60 */         if (c > 0) {
/*  61 */           this.allTiles[tileI++] = (COORDINATE)new Coo((x - radius), (y - radius));
/*     */           
/*  63 */           this.raysOnTile[y][x] = new Ray[grid[y][x]];
/*  64 */           grid[y][x] = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     Ray[] arrayOfRay2;
/*  69 */     for (int k = (arrayOfRay2 = this.rays).length; j < k; ) { Ray r = arrayOfRay2[j]; byte b1; int m; COORDINATE[] arrayOfCOORDINATE;
/*  70 */       for (m = (arrayOfCOORDINATE = r.coos).length, b1 = 0; b1 < m; ) { COORDINATE c = arrayOfCOORDINATE[b1];
/*  71 */         this.raysOnTile[c.y() + radius][c.x() + radius][grid[c.y() + radius][c.x() + radius]] = r;
/*  72 */         grid[c.y() + radius][c.x() + radius] = grid[c.y() + radius][c.x() + radius] + 1; b1++; }
/*     */       
/*     */       j++; }
/*     */     
/*  76 */     this.check = new short[radius * 2 + 1][radius * 2 + 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkInit() {
/*  83 */     this.checkI = (short)(this.checkI + 1);
/*  84 */     if (this.checkI == 0) {
/*  85 */       for (int y = 0; y < this.check.length; y++) {
/*  86 */         for (int x = 0; x < (this.check[y]).length; x++) {
/*  87 */           this.check[y][x] = 0;
/*     */         }
/*     */       } 
/*  90 */       this.checkI = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean check(COORDINATE c) {
/*  95 */     if (this.check[c.y() + this.radius][c.x() + this.radius] != this.checkI) {
/*  96 */       this.check[c.y() + this.radius][c.x() + this.radius] = this.checkI;
/*  97 */       return true;
/*     */     } 
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public boolean checked(COORDINATE c) {
/* 103 */     return (this.check[c.y() + this.radius][c.x() + this.radius] == this.checkI);
/*     */   }
/*     */   
/*     */   public Ray[] rays(int dx, int dy) {
/* 107 */     dx += this.radius;
/* 108 */     dy += this.radius;
/* 109 */     if (dx < 0 || dy < 0 || dy >= this.raysOnTile.length || dx >= (this.raysOnTile[dy]).length)
/* 110 */       return this.empty; 
/* 111 */     return this.raysOnTile[dy][dx];
/*     */   }
/*     */   
/*     */   public Ray[] rays() {
/* 115 */     return this.rays;
/*     */   }
/*     */   
/*     */   public int radius() {
/* 119 */     return this.radius;
/*     */   }
/*     */   
/*     */   public COORDINATE[] tiles() {
/* 123 */     return this.allTiles;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void rayTrace(int fromx, int fromy, boolean[][] has, LinkedList<Ray> rays) {
/* 129 */     double divider, x = fromx;
/* 130 */     double y = fromy;
/*     */     
/* 132 */     if (Math.abs(x) > Math.abs(y)) {
/* 133 */       divider = Math.abs(x);
/* 134 */     } else if (Math.abs(x) < Math.abs(y)) {
/* 135 */       divider = Math.abs(y);
/*     */     } else {
/* 137 */       divider = Math.abs(x);
/*     */     } 
/*     */     
/* 140 */     double dx = -x / divider;
/* 141 */     double dy = -y / divider;
/*     */ 
/*     */ 
/*     */     
/* 145 */     for (int i = 0; i < divider; i++) {
/*     */ 
/*     */ 
/*     */       
/* 149 */       int tx = (int)x;
/* 150 */       int ty = (int)y;
/*     */       
/* 152 */       double r = Math.floor(Math.sqrt(x * x + y * y));
/*     */       
/* 154 */       if (r <= this.radius) {
/* 155 */         if (has[ty + this.radius][tx + this.radius]) {
/*     */           return;
/*     */         }
/* 158 */         has[ty + this.radius][tx + this.radius] = true;
/*     */         
/*     */         break;
/*     */       } 
/* 162 */       x += dx;
/* 163 */       y += dy;
/*     */     } 
/*     */     
/* 166 */     LinkedList<Coo> coos = new LinkedList();
/* 167 */     LinkedList<Coo> offs = new LinkedList();
/*     */ 
/*     */     
/*     */     while (true) {
/* 171 */       int tx = (int)x;
/* 172 */       int ty = (int)y;
/* 173 */       if (tx == 0 && ty == 0) {
/*     */         
/* 175 */         Ray ray = new Ray(coos.size());
/* 176 */         for (int j = ray.coos.length - 1; j >= 0; j--) {
/*     */           
/* 178 */           ray.coos[j] = (COORDINATE)coos.removeFirst();
/* 179 */           ray.tileOff[j] = (COORDINATE)offs.removeFirst();
/* 180 */           ray.radius[j] = Math.sqrt((ray.coos[j].x() * ray.coos[j].x() + ray.coos[j].y() * ray.coos[j].y()));
/* 181 */           ray.area[j] = (ray.tileOff[j].x() * ray.tileOff[j].y());
/* 182 */           ray.area[j] = ray.area[j] / 4096.0D;
/*     */         } 
/*     */         
/* 185 */         rays.add(ray);
/*     */         return;
/*     */       } 
/* 188 */       coos.add(new Coo(tx, ty));
/* 189 */       offs.add(new Coo(x - tx, y - ty));
/*     */       
/* 191 */       x += dx;
/* 192 */       y += dy;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Ray
/*     */   {
/*     */     private final COORDINATE[] coos;
/*     */     
/*     */     private final COORDINATE[] tileOff;
/*     */     private final double[] radius;
/*     */     private final double[] area;
/*     */     public final int index;
/*     */     
/*     */     Ray(Ray other, int index) {
/* 207 */       this.index = index;
/* 208 */       this.coos = other.coos;
/* 209 */       this.tileOff = other.tileOff;
/* 210 */       this.radius = other.radius;
/* 211 */       this.area = other.area;
/*     */     }
/*     */     
/*     */     Ray(int size) {
/* 215 */       this.coos = new COORDINATE[size];
/* 216 */       this.tileOff = new COORDINATE[size];
/* 217 */       this.radius = new double[size];
/* 218 */       this.area = new double[size];
/* 219 */       this.index = 0;
/*     */     }
/*     */     
/*     */     public COORDINATE first() {
/* 223 */       return this.coos[0];
/*     */     }
/*     */     
/*     */     public COORDINATE last() {
/* 227 */       return this.coos[this.coos.length - 1];
/*     */     }
/*     */     
/*     */     public int size() {
/* 231 */       return this.coos.length;
/*     */     }
/*     */     
/*     */     public COORDINATE get(int i) {
/* 235 */       return this.coos[i];
/*     */     }
/*     */     
/*     */     public COORDINATE[] coos() {
/* 239 */       return this.coos;
/*     */     }
/*     */     
/*     */     public double radius(int i) {
/* 243 */       return this.radius[i];
/*     */     }
/*     */     
/*     */     public double traverseArea(int i) {
/* 247 */       return 1.0D;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\mis\\util\TileRayTracer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */