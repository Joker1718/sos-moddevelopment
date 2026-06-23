/*     */ package settlement.environment;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BoostSpecs;
/*     */ import init.paths.PATH;
/*     */ import init.race.bio.Opinion;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SettEnv
/*     */   extends SettEnvMap.Updatable
/*     */   implements MAP_DOUBLE, MAPPED
/*     */ {
/*     */   private final int index;
/* 354 */   private int extraI = -1;
/*     */   public final String key;
/*     */   public final double declineSpeed;
/*     */   public final BoostSpecs bonuses;
/*     */   public final StatStanding.StandingDef standing;
/*     */   final Bitsmap1D map;
/*     */   final int max;
/*     */   public final double maxI;
/*     */   private final EUpdater uper;
/*     */   public final SPRITE icon;
/*     */   public final Opinion op;
/*     */   public final INFO info;
/*     */   
/*     */   SettEnv(LISTE<SettEnvMap.Updatable> uall, LISTE<SettEnv> all, String key, PATH pj, PATH tj, int bits, EUpdater uper) throws IOException {
/* 368 */     super(uall);
/* 369 */     this.info = new INFO(new Json(tj.gets(key)));
/* 370 */     this.key = key;
/* 371 */     this.index = all.add(this);
/* 372 */     Json j = new Json(pj.gets(key));
/* 373 */     this.icon = (SPRITE)SPRITES.icons().get(j);
/* 374 */     this.declineSpeed = j.d("DECLINE_VALUE", 0.0D, 1.0D);
/* 375 */     this.bonuses = new BoostSpecs(this.info.name, (SPRITE)(UI.icons()).s.eye, false);
/* 376 */     this.bonuses.read(j, null);
/* 377 */     this.standing = new StatStanding.StandingDef(j);
/* 378 */     this.map = new Bitsmap1D(0, bits, SETT.TAREA);
/* 379 */     this.max = (1 << bits) - 1;
/* 380 */     this.maxI = 1.0D / this.max;
/* 381 */     this.uper = uper;
/* 382 */     this.op = new Opinion();
/* 383 */     this.op.read(new Json(tj.gets(key)));
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(int tile) {
/* 388 */     double v = this.map.get(tile) * this.maxI;
/*     */     
/* 390 */     if ((SETT.FLOOR()).getter.get(tile) != null && !(SETT.ROOMS()).map.is(tile))
/* 391 */       v += ((Floors.Floor)(SETT.FLOOR()).getter.get(tile)).envValue(this, tile); 
/* 392 */     return CLAMP.d(v, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public double getCost(int toX, int toY) {
/* 396 */     return (SETT.LIGHTS().los().get(toX, toY).blocksEnv(toX, toY) ? 16 : true);
/*     */   }
/*     */   
/*     */   double getRadius(int tx, int ty) {
/* 400 */     if ((SETT.ROOMS()).construction.isser.is(tx, ty) || (SETT.ROOMS()).placement.embryo.is(tx, ty))
/* 401 */       return 0.0D; 
/* 402 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 403 */     if (r != null && r.constructor() != null && r.constructor().envValue(this, SettEnvMap.SettEnvValue.init(), tx, ty)) {
/* 404 */       return SettEnvMap.SettEnvValue.self.radius;
/*     */     }
/* 406 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getBaseValue(int tx, int ty) {
/* 411 */     if ((SETT.ROOMS()).construction.isser.is(tx, ty) || (SETT.ROOMS()).placement.embryo.is(tx, ty)) {
/* 412 */       return 0.0D;
/*     */     }
/* 414 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*     */     
/* 416 */     if (r != null && !(SETT.ROOMS()).construction.isser.is(tx, ty) && r.constructor() != null && 
/* 417 */       r.constructor().envValue(this, SettEnvMap.SettEnvValue.init(), tx, ty)) {
/* 418 */       return SettEnvMap.SettEnvValue.self.value;
/*     */     }
/* 420 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public int dirs(int tx, int ty) {
/* 424 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 425 */     if (r != null && r.constructor() != null && r.constructor().envValue(this, SettEnvMap.SettEnvValue.init(), tx, ty)) {
/* 426 */       return SettEnvMap.SettEnvValue.self.approvedDirs;
/*     */     }
/* 428 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(int tx, int ty) {
/* 433 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 434 */       return 0.0D; 
/* 435 */     return get(tx + ty * SETT.TWIDTH);
/*     */   }
/*     */   
/*     */   public void addExtraView(double value, double radius, int tx, int ty, int approvedDirs) {
/* 439 */     GUTIL.flooder().init(this);
/* 440 */     (SETT.ENV()).map.updater.addExtraView(GUTIL.flooder(), this, value, radius, tx, ty, approvedDirs);
/* 441 */     GUTIL.flooder().done();
/*     */     
/* 443 */     this.extraI = GAME.updateI();
/*     */   }
/*     */   
/*     */   public double getView(int tx, int ty) {
/* 447 */     double g = get(tx, ty);
/* 448 */     if (this.extraI == GAME.updateI()) {
/* 449 */       g = this.uper.getExtraValue(this, g, tx, ty);
/* 450 */       g = CLAMP.d(g, 0.0D, 1.0D);
/*     */     } 
/*     */     
/* 453 */     return g;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 458 */     return this.index;
/*     */   }
/*     */   
/*     */   public STAT stat() {
/* 462 */     return (STAT)(STATS.ACCESS()).ACCESS.all().get(this.index);
/*     */   }
/*     */   
/*     */   public int max() {
/* 466 */     return this.max;
/*     */   }
/*     */   
/*     */   public double radius() {
/* 470 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/* 475 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(RECTANGLE bounds, RECTANGLE area) {
/* 480 */     this.uper.update(this, bounds, area);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean has(int tx, int ty) {
/* 486 */     return (this.map.get(tx + ty * SETT.TWIDTH) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 491 */     this.map.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMap$SettEnv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */