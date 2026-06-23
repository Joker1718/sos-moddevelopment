/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Json;
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
/*     */ public final class ProjectileImp
/*     */   extends Projectile
/*     */ {
/*     */   private final Projectile.ProjectileSpec from;
/*     */   private final Projectile.ProjectileSpec delta;
/*     */   private final ProjectileSprite sprite;
/*     */   public final SoundRace soundRelease;
/*     */   public final SoundRace soundHit;
/*     */   
/*     */   public ProjectileImp(Json data, String key) throws IOException {
/* 302 */     if (data.has("PROJECTILE")) {
/* 303 */       data = data.json("PROJECTILE");
/*     */     }
/* 305 */     this.sprite = ProjectileSprite.get(data);
/* 306 */     this.soundRelease = AUDIO.race("PROJECTILE_RELEASE_" + key);
/* 307 */     this.soundHit = AUDIO.race("PROJECTILE_HIT_" + key);
/* 308 */     this.from = new Projectile.ProjectileSpec(data.json("FROM"));
/* 309 */     this.delta = new Projectile.ProjectileSpec(data.json("TO"));
/*     */     
/* 311 */     this.delta.accuracy -= this.from.accuracy;
/* 312 */     this.delta.dexterity -= this.from.dexterity;
/* 313 */     this.delta.areaAttack -= this.from.areaAttack;
/* 314 */     this.delta.mass -= this.from.mass;
/* 315 */     this.delta.maxAngle -= this.from.maxAngle;
/* 316 */     this.delta.reloadSpeed -= this.from.reloadSpeed;
/* 317 */     this.delta.velocity -= this.from.velocity;
/*     */     
/* 319 */     for (BOOSTABLES.BDamage d : (BOOSTABLES.BATTLE()).DAMAGES) {
/* 320 */       this.delta.damage[d.index()] = this.delta.damage[d.index()] - this.from.damage[d.index()];
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double mass(double ref) {
/* 326 */     return this.from.mass + this.delta.mass * ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public double damage(int battleI, double ref) {
/* 331 */     return this.from.damage[battleI] + this.delta.damage[battleI] * ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public double areaAttack(double ref) {
/* 336 */     return this.from.areaAttack + this.delta.areaAttack * ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public double velocity(double ref) {
/* 341 */     return this.from.velocity + this.delta.velocity * ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public double maxAngle(double ref) {
/* 346 */     ref = CLAMP.d(ref, 0.0D, 1.0D);
/* 347 */     return this.from.maxAngle + this.delta.maxAngle * ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public double reloadSeconds(double ref) {
/* 352 */     ref = CLAMP.d(ref, 0.0D, 1.0D);
/* 353 */     return this.from.reloadSpeed + this.delta.reloadSpeed * ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public double accuracy(double ref) {
/* 358 */     return CLAMP.d(this.from.accuracy + this.delta.accuracy * ref, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double skill(double ref) {
/* 363 */     return this.from.dexterity + this.delta.dexterity * ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace soundRelease() {
/* 368 */     return this.soundRelease;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace soundHit() {
/* 373 */     return this.soundHit;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProjectileSprite sprite() {
/* 378 */     return this.sprite;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Projectile$ProjectileImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */