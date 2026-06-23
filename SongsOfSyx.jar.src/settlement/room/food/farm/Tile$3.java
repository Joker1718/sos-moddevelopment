/*     */ package settlement.room.food.farm;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 335 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   boolean is() {
/* 339 */     return (size() > 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double size() {
/* 344 */     if (Tile.this.bHarvested.get() == 0) {
/* 345 */       double d = Tile.this.bWorked.get() * Tile.this.time.daysWorkingI;
/* 346 */       d *= Tile.this.ins.tData.skill();
/* 347 */       d *= (Tile.this.ins.blueprintI()).constructor.fertility(Tile.this.coo.x(), Tile.this.coo.y());
/* 348 */       d = CLAMP.d(d, 0.0D, 1.0D);
/*     */       
/* 350 */       return d;
/*     */     } 
/*     */     
/* 353 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double ripeness() {
/* 358 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double fruit() {
/* 363 */     return 0.2D + Tile.this.ins.tData.skill() * 0.5D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double ripenessFruit() {
/* 368 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double growth() {
/* 373 */     double d = MATH.distance(Tile.this.time.day(), Tile.this.time.dayDeath, Tile.this.time.days);
/* 374 */     d *= 1.25D;
/* 375 */     double r = 0.25D * Tile.this.bRandom.get() * Tile.this.bRandomI;
/* 376 */     d -= r;
/* 377 */     return CLAMP.d(d, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 382 */     if (Tile.this.bHarvested.get() == 0 && MATH.distance(Tile.this.time.day(), Tile.this.time.dayDeath, Tile.this.time.days) <= 1.0D) {
/* 383 */       Tile.this.bSize.set((ROOMA)Tile.this.ins, (int)Math.ceil(size() * Tile.this.bSize.max()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 389 */     Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 1);
/* 390 */     IndustryResource rr = (IndustryResource)((Industry)Tile.this.b.industries().get(0)).outs().get(0);
/* 391 */     double d = rr.rate;
/*     */     
/* 393 */     d *= Tile.this.bWorked.get() * Tile.this.time.daysWorkingI;
/* 394 */     d *= Tile.this.ins.tData.skill();
/* 395 */     d *= Tile.this.time.days;
/* 396 */     d *= ROOM_FARM.WORKERPERTILEI;
/* 397 */     d *= (Tile.this.ins.blueprintI()).yearMul;
/* 398 */     int am = rr.inc((ROOM_IDATA_INSTANCE)Tile.this.ins, d);
/* 399 */     if (am > 0) {
/* 400 */       (SETT.THINGS()).resources.create((COORDINATE)Tile.this.coo, Tile.this.b.crop.resource, am);
/*     */     }
/* 402 */     Tile.this.CDead.jobPerform(skill, r, rAm);
/*     */ 
/*     */     
/* 405 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void destroyTile() {
/* 410 */     Tile.this.bHarvested.set((ROOMA)Tile.this.ins, 1);
/* 411 */     Tile.this.bSize.set((ROOMA)Tile.this.ins, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Tile$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */