/*     */ package settlement.thing.pointlight;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PointRayTracer
/*     */ {
/*     */   private final Bitmap1D lit;
/*     */   private final Bitsmap1D corners;
/*     */   private final int tileDiameter;
/*     */   
/*     */   public PointRayTracer(int tileDiameter) {
/*  18 */     this.tileDiameter = tileDiameter;
/*  19 */     this.lit = new Bitmap1D(tileDiameter * tileDiameter, false);
/*  20 */     this.corners = new Bitsmap1D(0, 4, tileDiameter * tileDiameter);
/*     */   }
/*     */   
/*     */   boolean litIs(int tx, int ty) {
/*  24 */     return (this.corners.get(tx + ty * this.tileDiameter) != 0);
/*     */   }
/*     */   
/*     */   private boolean lit(int tx, int ty) {
/*  28 */     return this.lit.get(tx + ty * this.tileDiameter);
/*     */   }
/*     */   
/*     */   private boolean lit(int tx, int ty, DIR d) {
/*  32 */     return lit(tx + d.x(), ty + d.y());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(int x, int y) {
/*  38 */     int ctx = x >> 6;
/*  39 */     int cty = y >> 6;
/*     */     
/*  41 */     if (!shouldBeLit(ctx, cty)) {
/*     */       return;
/*     */     }
/*     */     
/*  45 */     this.lit.clear();
/*  46 */     this.lit.set(this.tileDiameter / 2 + this.tileDiameter * this.tileDiameter / 2, true);
/*  47 */     int tx1 = ctx - this.tileDiameter / 2;
/*  48 */     int ty1 = cty - this.tileDiameter / 2;
/*     */ 
/*     */     
/*  51 */     for (int gy = 0; gy <= this.tileDiameter; gy++) {
/*  52 */       rayTrace(-tx1, -ty1, ctx, cty, tx1, ty1 + gy);
/*  53 */       rayTrace(-tx1, -ty1, ctx, cty, tx1 + this.tileDiameter - 1, ty1 + gy);
/*     */     } 
/*     */     
/*  56 */     for (int gx = 1; gx <= this.tileDiameter - 1; gx++) {
/*  57 */       rayTrace(-tx1, -ty1, ctx, cty, tx1 + gx, ty1);
/*  58 */       rayTrace(-tx1, -ty1, ctx, cty, tx1 + gx, ty1 + this.tileDiameter - 1);
/*     */     } 
/*     */     
/*  61 */     this.corners.clear();
/*     */     
/*  63 */     for (int ty = 1; ty <= this.tileDiameter - 1; ty++) {
/*  64 */       for (int tx = 1; tx <= this.tileDiameter - 1; tx++) {
/*  65 */         int t = tx + ty * this.tileDiameter;
/*  66 */         if (this.lit.get(t)) {
/*  67 */           this.corners.set(t, 15);
/*     */         } else {
/*  69 */           for (DIR d : DIR.NORTHO) {
/*  70 */             if (!cornercheck(tx, ty, d, tx1, ty1, d) && 
/*  71 */               !cornercheck(tx, ty, d.next(1), tx1, ty1, d)) {
/*  72 */               cornercheck(tx, ty, d.next(-1), tx1, ty1, d);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean cornercheck(int tx, int ty, DIR d, int tx1, int ty1, DIR dir) {
/*  82 */     if (lit(tx, ty, d)) {
/*  83 */       int fx = tx1 + tx;
/*  84 */       int fy = ty1 + ty;
/*  85 */       int tox = tx1 + tx + d.x();
/*  86 */       int toy = ty1 + ty + d.y();
/*     */       
/*  88 */       LOS from = SETT.LIGHTS().los().get(fx, fy);
/*  89 */       LOS to = SETT.LIGHTS().los().get(tox, toy);
/*  90 */       if (from.passesToOtherFromThis(fx, fy, tox, toy) && to.passesFromOtherToThis(fx, fy, tox, toy)) {
/*  91 */         int t = tx + ty * this.tileDiameter;
/*  92 */         int c = this.corners.get(t);
/*  93 */         c |= dir.mask();
/*  94 */         this.corners.set(t, c);
/*  95 */         return true;
/*     */       } 
/*     */     } 
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void rayTrace(int mx, int my, int fromx, int fromy, int tox, int toy) {
/*     */     double divider;
/* 104 */     if (Math.abs(tox - fromx) > Math.abs(toy - fromy)) {
/* 105 */       divider = Math.abs(tox - fromx);
/* 106 */     } else if (Math.abs(tox - fromx) < Math.abs(toy - fromy)) {
/* 107 */       divider = Math.abs(toy - fromy);
/*     */     } else {
/* 109 */       divider = Math.abs(tox - fromx);
/*     */     } 
/*     */     
/* 112 */     double dx = (tox - fromx) / divider;
/* 113 */     double dy = (toy - fromy) / divider;
/*     */     
/* 115 */     double x = fromx + 0.5D;
/* 116 */     double y = fromy + 0.5D;
/*     */     
/* 118 */     for (int i = 0; i < divider; i++) {
/*     */       
/* 120 */       int otx = (int)x;
/* 121 */       int oty = (int)y;
/* 122 */       this.lit.set(otx + mx + (oty + my) * this.tileDiameter, true);
/* 123 */       LOS lFrom = SETT.LIGHTS().los().get(otx, oty);
/* 124 */       x += dx;
/* 125 */       y += dy;
/* 126 */       int tx = (int)x;
/* 127 */       int ty = (int)y;
/*     */       
/* 129 */       LOS lTo = SETT.LIGHTS().los().get(tx, ty);
/*     */       
/* 131 */       if (!lFrom.passesToOtherFromThis(otx, oty, tx, ty) || !lTo.passesFromOtherToThis(otx, oty, tx, ty)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   byte getSide(int tx, int ty, DIR d) {
/* 139 */     return ((this.corners.get(tx + ty * this.tileDiameter) & d.mask()) != 0) ? Byte.MAX_VALUE : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean shouldBeLit(int x, int y) {
/* 144 */     return SETT.IN_BOUNDS(x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\PointRayTracer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */