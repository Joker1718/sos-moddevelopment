/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCompNLevel;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitsmap1D;
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
/*     */ final class SFinderUpdater
/*     */ {
/* 250 */   private final Bitmap1D tryShort = new Bitmap1D(32767, false);
/* 251 */   private final Bitmap1D distanceFailed = new Bitmap1D(32767, false);
/* 252 */   private final Bitsmap1D distance = new Bitsmap1D(0, 2, 32767);
/* 253 */   private final Bitsmap1D distanceTimeout = new Bitsmap1D(0, 2, 32767);
/*     */   
/* 255 */   private final double speed = 0.03125D;
/* 256 */   double ci = 0.0D;
/* 257 */   int roundabout = 0;
/*     */   
/* 259 */   private final int[] dists = new int[] {
/* 260 */       150, 
/* 261 */       400, 
/* 262 */       1000, Integer
/* 263 */       .MAX_VALUE
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 271 */     int old = (int)this.ci;
/* 272 */     this.ci += ds * ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax() * 0.03125D;
/* 273 */     int now = (int)this.ci;
/* 274 */     int delt = old - now;
/*     */     
/* 276 */     if (this.ci >= ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax()) {
/* 277 */       this.roundabout++;
/* 278 */       this.ci -= ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax();
/*     */     } 
/*     */     
/* 281 */     for (int k = 0; k <= delt; k++) {
/* 282 */       int i = k + old;
/* 283 */       i %= ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax();
/* 284 */       this.tryShort.set(i, false);
/*     */       
/* 286 */       if (this.distanceFailed.get(i)) {
/*     */         
/* 288 */         this.distanceFailed.set(i, false);
/* 289 */         this.distance.inc(i, 1);
/* 290 */         this.distanceTimeout.set(i, this.roundabout - 1 & 0x3);
/* 291 */       } else if ((this.roundabout & 0x3) == this.distanceTimeout.get(i)) {
/* 292 */         this.distance.set(i, 0);
/* 293 */         this.distanceTimeout.set(i, 0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean tryShort(int tx, int ty) {
/* 300 */     SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 301 */     if (c == null)
/* 302 */       return false; 
/* 303 */     if (this.tryShort.get(c.index()))
/* 304 */       return false; 
/* 305 */     return true;
/*     */   }
/*     */   
/*     */   public void failShort(int tx, int ty) {
/* 309 */     SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 310 */     if (c == null)
/*     */       return; 
/* 312 */     this.tryShort.set(c.index(), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean tryDistance(int tx, int ty) {
/* 317 */     if (STATS.WORK().workforce() - (STATS.WORK()).EMPLOYED.stat().data().get(null) < 80) {
/* 318 */       return true;
/*     */     }
/* 320 */     SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 321 */     if (c == null)
/* 322 */       return false; 
/* 323 */     return !(this.distanceFailed.get(c.index()) && this.distance.get(c.index()) == this.distance.maxValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int distance(int tx, int ty) {
/* 329 */     if (STATS.WORK().workforce() - (STATS.WORK()).EMPLOYED.stat().data().get(null) < 80) {
/* 330 */       return Integer.MAX_VALUE;
/*     */     }
/* 332 */     SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 333 */     return this.dists[this.distance.get(c.index())];
/*     */   }
/*     */   
/*     */   public void distanceFail(int tx, int ty) {
/* 337 */     SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 338 */     this.distanceFailed.set(c.index(), true);
/* 339 */     failShort(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderJob$SFinderUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */