/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorCave
/*     */ {
/*  22 */   private final PathGame.PathFancy p = new PathGame.PathFancy(5000);
/*     */   
/*     */   private final int caveSize;
/*     */   private final double tunnels;
/*     */   
/*     */   GeneratorCave(CapitolArea area, GeneratorUtil util, LinkedList<COORDINATE> caves) {
/*  28 */     int amount = (int)(util.json.d("CAVE_AMOUNT", 0.0D, 1.0D) * 300.0D);
/*  29 */     this.caveSize = (int)(util.json.d("CAVE_SIZE", 0.0D, 1.0D) * 30.0D);
/*  30 */     this.tunnels = util.json.d("CAVE_TUNNELS", 0.0D, 1.0D);
/*     */     
/*  32 */     for (int i = 0; i < amount; i++) {
/*  33 */       int x = RND.rInt(SETT.TWIDTH);
/*  34 */       int j = RND.rInt(SETT.THEIGHT);
/*  35 */       if (cave(area, util, x, j)) {
/*  36 */         caves.add(new Coo(x, j));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  42 */     GUTIL.flooder().init(this);
/*  43 */     for (int y = 0; y < SETT.TWIDTH; y++) {
/*  44 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/*  45 */         if ((SETT.TERRAIN()).CAVE.is(x, y)) {
/*  46 */           GUTIL.flooder().pushSloppy(x, y, 0.0D);
/*     */         }
/*     */       } 
/*     */     } 
/*  50 */     while (GUTIL.flooder().hasMore()) {
/*  51 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  52 */       (SETT.TERRAIN()).CAVE.placeRaw(t.x(), t.y());
/*     */       
/*  54 */       for (DIR d : DIR.ORTHO) {
/*  55 */         if (!SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */           continue; 
/*  57 */         if ((SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)t, d)) {
/*  58 */           if (RND.oneIn(3)) {
/*  59 */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, 1.0D); continue;
/*     */           } 
/*  61 */           GUTIL.flooder().close((COORDINATE)t, d, 0.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  67 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cave(CapitolArea area, GeneratorUtil util, int x, int y) {
/*  73 */     GUTIL.flooder().init(this);
/*  74 */     LinkedList<Coo> coos = new LinkedList();
/*     */     
/*  76 */     util.polly.checkInit();
/*  77 */     util.polly.checker.set(x, y, true);
/*     */     
/*  79 */     GUTIL.flooder().pushSloppy(x, y, 0.0D);
/*     */     
/*  81 */     for (int i = RND.rInt(this.caveSize); i > 0; i--) {
/*  82 */       int x2 = x + RND.rInt0(10 + this.caveSize);
/*  83 */       int y2 = y + RND.rInt0(10 + this.caveSize);
/*  84 */       if (SETT.IN_BOUNDS(x2, y2) && 
/*  85 */         !util.polly.checker.is(x2, y2)) {
/*  86 */         util.polly.checker.set(x2, y2, true);
/*  87 */         GUTIL.flooder().pushSloppy(x2, y2, 0.0D);
/*  88 */         coos.add(new Coo(x2, y2));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  94 */     while (GUTIL.flooder().hasMore()) {
/*  95 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  96 */       if (!(SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)t)) {
/*  97 */         GUTIL.flooder().done();
/*  98 */         return false;
/*     */       } 
/*     */       
/* 101 */       for (DIR d : DIR.ORTHO) {
/* 102 */         if (!SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */           continue; 
/* 104 */         if (!util.polly.checker.is((COORDINATE)t, d)) {
/* 105 */           if (t.getValue() < 5.0F)
/* 106 */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());  continue;
/*     */         } 
/* 108 */         GUTIL.flooder().pushSmaller((COORDINATE)t, d, 0.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 113 */     GUTIL.flooder().done();
/* 114 */     GUTIL.flooder().init(this);
/* 115 */     for (Coo c : coos) {
/* 116 */       GUTIL.flooder().pushSloppy((COORDINATE)c, 0.0D);
/*     */     }
/*     */     
/* 119 */     while (GUTIL.flooder().hasMore()) {
/* 120 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 121 */       if ((SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)t)) {
/* 122 */         (SETT.TERRAIN()).CAVE.placeRaw(t.x(), t.y());
/*     */       }
/*     */       
/* 125 */       for (DIR d : DIR.ORTHO) {
/* 126 */         if (!SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */           continue; 
/* 128 */         if (util.polly.checker.is((COORDINATE)t, d))
/* 129 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, 0.0D); 
/*     */       } 
/*     */     } 
/* 132 */     GUTIL.flooder().done();
/*     */ 
/*     */ 
/*     */     
/* 136 */     int a = RND.rInt((int)(1.0D + coos.size() * this.tunnels * 10.0D));
/*     */     
/* 138 */     for (int j = 0; j < a; j++) {
/* 139 */       Coo c = (Coo)coos.removeFirst();
/* 140 */       tunnel(area, util, c.x(), c.y());
/* 141 */       coos.add(c);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void tunnel(CapitolArea area, final GeneratorUtil util, final int startX, final int startY) {
/* 152 */     PathGame.COST cm = new PathGame.COST()
/*     */       {
/*     */         
/*     */         public double getCost(int fromX, int fromY, int toX, int toY)
/*     */         {
/* 157 */           if (!SETT.IN_BOUNDS(toX, toY)) {
/* 158 */             return -1.0D;
/*     */           }
/* 160 */           if (!util.polly.isEdge(toX, toY)) {
/* 161 */             return 5.0D;
/*     */           }
/*     */           
/* 164 */           if ((SETT.TERRAIN()).MOUNTAIN.is(toX, toY)) {
/* 165 */             return 1.0D;
/*     */           }
/* 167 */           if ((SETT.TERRAIN()).CAVE.is(toX, toY)) {
/* 168 */             return 2.0D;
/*     */           }
/* 170 */           return 0.0D;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 175 */     PathGame.DEST dm = new PathGame.DEST()
/*     */       {
/*     */         protected boolean isDest(int x, int y) {
/* 178 */           if ((SETT.TERRAIN()).CAVE.is(x, y)) {
/* 179 */             int d = Math.abs(x - startX);
/* 180 */             d += Math.abs(y - startY);
/* 181 */             return (d > 60);
/*     */           } 
/* 183 */           return !(SETT.TERRAIN()).MOUNTAIN.is(x, y);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected float getOptDistance(int x, int y) {
/* 189 */           return 0.0F;
/*     */         }
/*     */       };
/*     */     
/* 193 */     if (!GUTIL.astar().getNearest(this.p, cm, dm, startX, startY)) {
/*     */       return;
/*     */     }
/*     */     
/* 197 */     GUTIL.flooder().init(this);
/*     */     
/* 199 */     int max = 60 + RND.rInt(60);
/*     */     
/*     */     do {
/* 202 */       int x = this.p.x();
/* 203 */       int y = this.p.y();
/* 204 */       GUTIL.flooder().pushSmaller(x, y, 0.0D);
/* 205 */     } while (this.p.setNext() && max-- >= 0);
/*     */     
/* 207 */     while (GUTIL.flooder().hasMore()) {
/* 208 */       PathTile t = GUTIL.flooder().pollGreatest();
/* 209 */       if ((SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)t))
/* 210 */         (SETT.TERRAIN()).CAVE.placeRaw(t.x(), t.y()); 
/* 211 */       if ((SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)t, DIR.E)) {
/* 212 */         (SETT.TERRAIN()).CAVE.placeRaw(t.x() + 1, t.y());
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 218 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorCave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */