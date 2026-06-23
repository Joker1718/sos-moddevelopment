/*     */ package settlement.room.food.farm;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends Tile.Cycle
/*     */ {
/*     */   null(Tile paramTile2, CharSequence $anonymous0) {
/* 239 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   boolean is() {
/* 243 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public double size() {
/* 248 */     double d = r();
/* 249 */     d *= Tile.this.bWorked.get() * Tile.this.time.daysWorkingI;
/*     */     
/* 251 */     d *= Tile.this.ins.tData.skill();
/* 252 */     d *= (Tile.this.ins.blueprintI()).constructor.fertility(Tile.this.coo.x(), Tile.this.coo.y());
/* 253 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */ 
/*     */     
/* 256 */     return d;
/*     */   }
/*     */   
/*     */   private double r() {
/* 260 */     double d = MATH.distance(Tile.this.time.dayPlant, Tile.this.time.day(), Tile.this.time.days);
/* 261 */     d /= Tile.this.time.daysPlanting;
/* 262 */     d *= 1.25D;
/* 263 */     double r = 0.25D * Tile.this.bRandom.get() * Tile.this.bRandomI;
/* 264 */     d -= r;
/* 265 */     return CLAMP.d(d, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double ripeness() {
/* 271 */     double d = r();
/* 272 */     if (d > 0.75D) {
/* 273 */       return CLAMP.d((d - 0.75D) * 8.0D, 0.0D, 1.0D);
/*     */     }
/* 275 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double fruit() {
/* 280 */     double d = r();
/* 281 */     if (d > 0.5D) {
/* 282 */       d = (d - 0.5D) * 4.0D;
/*     */     }
/* 284 */     d *= 0.2D + Tile.this.ins.tData.skill() * 0.5D;
/* 285 */     return CLAMP.d(d, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double ripenessFruit() {
/* 290 */     double d = r();
/* 291 */     if (d > 0.75D) {
/* 292 */       return CLAMP.d((d - 0.75D) * 4.0D, 0.0D, 1.0D);
/*     */     }
/* 294 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double growth() {
/* 299 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 304 */     Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 314 */     Tile.this.bWorked.inc((ROOMA)Tile.this.ins, 1);
/* 315 */     Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 0);
/* 316 */     Tile.this.ins.tData.increase(skill, Tile.this.coo.x(), Tile.this.coo.y());
/* 317 */     if (Tile.this.bHasExtraWork.get() > 0 && is()) {
/* 318 */       Tile.this.bHasExtraWork.inc((ROOMA)Tile.this.ins, -1);
/* 319 */       jobReserveCancel((RESOURCE)null);
/*     */     } 
/* 321 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile() {
/* 326 */     int i = Tile.this.bWorked.get();
/* 327 */     int n = i / 2;
/* 328 */     Tile.this.bWorked.set((ROOMA)Tile.this.ins, n);
/* 329 */     Tile.this.ins.tData.decrease(i - n);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Tile$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */