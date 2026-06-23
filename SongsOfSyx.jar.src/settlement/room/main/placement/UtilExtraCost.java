/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TileRayTracer;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ public final class UtilExtraCost
/*     */ {
/*  18 */   private double support = 0.0D;
/*  19 */   private double foundation = 0.0D;
/*  20 */   private int tick = -1;
/*     */   private final RoomPlacer placer;
/*  22 */   private static final TileRayTracer tracer = new TileRayTracer(4);
/*     */   
/*     */   UtilExtraCost(RoomPlacer placer) {
/*  25 */     this.placer = placer;
/*     */   }
/*     */ 
/*     */   
/*     */   public double support() {
/*  30 */     cache();
/*  31 */     return this.support;
/*     */   }
/*     */   
/*     */   public double foundation() {
/*  35 */     cache();
/*  36 */     return this.foundation;
/*     */   }
/*     */   
/*     */   public double total() {
/*  40 */     cache();
/*  41 */     return this.support + this.foundation;
/*     */   }
/*     */   
/*     */   private void cache() {
/*  45 */     if (GAME.updateI() == this.tick) {
/*     */       return;
/*     */     }
/*  48 */     this.tick = GAME.updateI();
/*     */     
/*  50 */     this.support = psupport((ROOMA)this.placer.instance, this.placer.blueprint());
/*  51 */     this.foundation = pfoundation((ROOMA)this.placer.instance, this.placer.blueprint());
/*     */   }
/*     */   
/*     */   public double get(int tx, int ty) {
/*  55 */     cache();
/*  56 */     return CLAMP.d((GUTIL.marker()).v1.get(tx, ty) - 1.0D, 0.0D, 4.0D) / 4.0D;
/*     */   }
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*  60 */     return ConstructionData.dExpensive.is(tx, ty, 1);
/*     */   }
/*     */   
/*     */   public static double psupport(ROOMA a, RoomBlueprintImp blueprint) {
/*  64 */     if (blueprint.constructor().mustBeIndoors() && blueprint.constructor().usesArea()) {
/*  65 */       return support(a) * 2.0D;
/*     */     }
/*  67 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public static double pfoundation(ROOMA a, RoomBlueprintImp blueprint) {
/*  71 */     if (a.area() == 0)
/*  72 */       return 0.0D; 
/*  73 */     if (blueprint.constructor().isHeavy()) {
/*  74 */       double d = 0.0D;
/*  75 */       for (COORDINATE c : a.body()) {
/*  76 */         if (a.is(c)) {
/*  77 */           d += (SETT.ENV()).foundation.get(c);
/*     */         }
/*     */       } 
/*  80 */       d /= a.area();
/*  81 */       return foundation(d);
/*     */     } 
/*     */     
/*  84 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public static double foundation(Room room, int rx, int ry) {
/*  88 */     int x1 = room.x1(rx, ry);
/*  89 */     int x2 = x1 + room.width(rx, ry);
/*  90 */     int y1 = room.y1(rx, ry);
/*  91 */     int y2 = y1 + room.height(rx, ry);
/*     */     
/*  93 */     double f = 0.0D;
/*  94 */     double a = 0.0D;
/*     */     
/*  96 */     for (int y = y1; y < y2; y++) {
/*  97 */       for (int x = x1; x < x2; x++) {
/*  98 */         if (room.isSame(rx, ry, x, y)) {
/*  99 */           f += (SETT.ENV()).foundation.get(x, y);
/* 100 */           a++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 105 */     if (a > 0.0D)
/* 106 */       f /= a; 
/* 107 */     return foundation(f);
/*     */   }
/*     */   
/*     */   public static double foundation(double aveFoundation) {
/* 111 */     double d = 0.1D - aveFoundation * 0.2D;
/* 112 */     d = (int)(100.0D * d) / 100.0D;
/* 113 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   private static double support(ROOMA a) {
/* 118 */     GUTIL.marker().init(UtilExtraCost.class);
/*     */     
/* 120 */     for (COORDINATE c : a.body()) {
/* 121 */       if (a.is(c)) {
/* 122 */         double v = support((AREA)a, c.x(), c.y());
/* 123 */         (GUTIL.marker()).v1.set(c, v);
/* 124 */         (GUTIL.marker()).v2.set(c, v);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     double total = 0.0D;
/* 130 */     double exp = 0.0D;
/* 131 */     double value = 0.0D;
/*     */     
/* 133 */     for (COORDINATE c : a.body()) {
/* 134 */       if (a.is(c)) {
/* 135 */         double v = (GUTIL.marker()).v1.get(c);
/* 136 */         total++;
/* 137 */         if (v >= 1.0D) {
/* 138 */           ConstructionData.dExpensive.set(a, c, 0); continue;
/*     */         } 
/* 140 */         ConstructionData.dExpensive.set(a, c, 1);
/* 141 */         exp++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 147 */     GUTIL.marker().done();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     if (total == 0.0D) {
/* 154 */       value = 0.0D;
/*     */     } else {
/* 156 */       value = exp / total;
/* 157 */     }  value *= 4.0D;
/* 158 */     value = CLAMP.d(value, 0.0D, 1.0D);
/* 159 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double support(AREA a, int tx, int ty) {
/* 165 */     double s = 0.0D;
/*     */     
/* 167 */     tracer.checkInit(); byte b; int i;
/*     */     TileRayTracer.Ray[] arrayOfRay;
/* 169 */     for (i = (arrayOfRay = tracer.rays()).length, b = 0; b < i; ) { TileRayTracer.Ray r = arrayOfRay[b];
/* 170 */       for (int j = 0; j < r.size(); j++) {
/* 171 */         int dx = tx + r.get(j).x();
/* 172 */         int dy = ty + r.get(j).y();
/* 173 */         if (!SETT.IN_BOUNDS(dx, dy))
/*     */           break; 
/* 175 */         if (!a.is(dx, dy)) {
/* 176 */           if (!(SETT.ROOMS()).map.is(dx, dy) && tracer.check(r.get(j)))
/* 177 */             s += CLAMP.d((3.5D - j) / 3.5D, 0.0D, 1.0D); 
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 183 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilExtraCost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */