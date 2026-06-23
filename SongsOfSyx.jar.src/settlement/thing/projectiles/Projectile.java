/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public abstract class Projectile
/*     */   implements INDEXED {
/*  34 */   static final ArrayListResize<Projectile> ALL = new ArrayListResize(8, 32767);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   private static CharSequence ¤¤name = "¤Projectile";
/*  46 */   private static CharSequence ¤¤splashDamage = "¤Splash Damage (tiles)";
/*  47 */   private static CharSequence ¤¤Range = "¤Range (tiles)";
/*  48 */   private static CharSequence ¤¤Accuracy = "¤Accuracy";
/*  49 */   private static CharSequence ¤¤Reload = "¤Reload (seconds)";
/*  50 */   private static CharSequence ¤¤Arch = "¤Max angle (degrees)"; public final short index;
/*     */   
/*     */   static {
/*  53 */     D.ts(Projectile.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Projectile() {
/*  62 */     if (!ALL.hasRoom())
/*  63 */       throw new RuntimeException("Too many projectiles declared! max is 32767"); 
/*  64 */     this.index = (byte)ALL.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  69 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public final double range(int height, double ref) {
/*  74 */     return Trajectory.range(height, maxAngle(ref), velocity(ref));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double bluntDamage(double ref) {
/*  82 */     return mass(ref) * velocity(ref) * 0.015625D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderArrow(Renderer r, ShadowBatch s, double x, double y, int h, int ran, double dx, double dy, double dz, int zoomout) {
/* 106 */     if (zoomout < 2) {
/* 107 */       double l = Math.sqrt(dx * dx + dy * dy + dz * dz * 4.0D);
/* 108 */       dx /= l;
/* 109 */       dy /= l;
/* 110 */       dx *= 4.0D;
/* 111 */       dy *= 4.0D;
/* 112 */       for (int k = 0; k < 8; k++) {
/* 113 */         r.renderParticle((int)x, (int)y);
/* 114 */         x += dx;
/* 115 */         y += dy;
/*     */       } 
/*     */     } 
/* 118 */     s.setHeight(0);
/* 119 */     s.setDistance2Ground((h / 4));
/* 120 */     (SPRITES.icons()).s.dot.renderC((SPRITE_RENDERER)s, (int)x, (int)y);
/*     */   }
/*     */   
/* 123 */   private static final Rec pixels = new Rec();
/* 124 */   private static final VectorImp tVec = new VectorImp();
/* 125 */   private static final VectorImp sVec = new VectorImp();
/*     */   
/*     */   public void impact(double ref, double cx, double cy, double dx, double dy, double dz) {
/* 128 */     double areaAttack = areaAttack(ref);
/* 129 */     if (areaAttack <= 0.0D) {
/*     */       return;
/*     */     }
/* 132 */     if (dx == 0.0D && dy == 0.0D && dx == 0.0D) {
/*     */       return;
/*     */     }
/* 135 */     double mass = mass(ref);
/* 136 */     double speed = Math.sqrt(dx * dx + dy * dy + dz * dz);
/* 137 */     double mom = mass * speed;
/*     */     
/* 139 */     (SETT.THINGS()).gore.debris((int)cx, (int)cy, dx * 0.5D, dy * 0.5D);
/* 140 */     (SETT.GRASS()).current.increment((int)cx, (int)cy, -0.5D);
/*     */     
/* 142 */     sVec.set(dx, dy);
/* 143 */     dx = sVec.nX();
/* 144 */     dy = sVec.nY();
/*     */     
/* 146 */     pixels.setDim(areaAttack * 2.0D);
/* 147 */     pixels.moveC(cx, cy);
/*     */     
/* 149 */     for (ENTITY e : SETT.ENTITIES().fill((RECTANGLE)pixels)) {
/* 150 */       double l = tVec.set(cx, cy, e.body().cX(), e.body().cY());
/* 151 */       if (l > areaAttack)
/*     */         continue; 
/* 153 */       l = 1.0D - l / areaAttack;
/* 154 */       if (l < 0.0D) {
/*     */         continue;
/*     */       }
/* 157 */       tVec.set(tVec.nX() + sVec.nX() * (0.1D + RND.rFloat()) + RND.rFloat0(0.1D), tVec.nY() + sVec.nY() * (0.1D + RND.rFloat()) + RND.rFloat0(0.1D));
/*     */       
/* 159 */       (GAME.battle()).fight.projectileAttack(e, dx, dy, speed, this, ref);
/*     */     } 
/*     */ 
/*     */     
/* 163 */     for (int tdy = (int)-areaAttack; tdy <= areaAttack; tdy += 64) {
/* 164 */       for (int tdx = (int)-areaAttack; tdx <= areaAttack; tdx += 64) {
/* 165 */         int x = (int)(cx + tdx);
/* 166 */         int y = (int)(cy + tdy);
/* 167 */         double l = tVec.set(cx, cy, x, y);
/* 168 */         if (l <= areaAttack) {
/*     */           
/* 170 */           l = 1.0D - l / areaAttack;
/* 171 */           l *= mom * l;
/* 172 */           double str = (GAME.ARMIES()).map.strength.get(x >> 6, y >> 6);
/* 173 */           if (l * RND.rFloat() > str) {
/* 174 */             (GAME.ARMIES()).map.breakIt(x >> 6, y >> 6);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, CharSequence name, double ref, int height) {
/* 183 */     GBox b = (GBox)box;
/*     */     
/* 185 */     if (name != null) {
/* 186 */       b.add((SPRITE)b.text().lablify().add(¤¤name).add(':').s().add(name));
/* 187 */       b.NL();
/*     */     } 
/*     */     
/* 190 */     b.add((SPRITE)b.text().add(ref));
/* 191 */     b.NL();
/*     */     
/* 193 */     hov(b, ¤¤Range, range(height, ref) / 64.0D);
/* 194 */     hov(b, ¤¤Accuracy, GFORMAT.perc(b.text(), accuracy(ref)));
/* 195 */     hov(b, (BOOSTABLES.BATTLE()).DEXTERITY.name, skill(ref));
/* 196 */     hov(b, ¤¤Reload, reloadSeconds(ref));
/* 197 */     hov(b, ¤¤Arch, maxAngle(ref));
/* 198 */     hov(b, ¤¤splashDamage, areaAttack(ref));
/* 199 */     hov(b, (BOOSTABLES.BATTLE()).BLUNT_ATTACK.name, bluntDamage(ref));
/*     */     
/* 201 */     for (BOOSTABLES.BDamage pp : (BOOSTABLES.BATTLE()).DAMAGES) {
/* 202 */       hov(b, pp.attack.name, damage(pp.index(), ref));
/*     */     }
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, CharSequence name) {
/* 207 */     GBox b = (GBox)box;
/*     */     
/* 209 */     if (name != null) {
/* 210 */       b.add((SPRITE)b.text().lablify().add(¤¤name).add(':').s().add(name));
/* 211 */       b.tab(6);
/* 212 */       b.textL(Dic.¤¤From);
/* 213 */       b.tab(8);
/* 214 */       b.textL(Dic.¤¤To);
/*     */       
/* 216 */       b.NL();
/*     */     } 
/*     */     
/* 219 */     hov(b, ¤¤Range, range(0, 0.0D) / 64.0D, range(0, 1.0D) / 64.0D);
/* 220 */     hov(b, (BOOSTABLES.BATTLE()).DEXTERITY.name, skill(0.0D), skill(1.0D));
/* 221 */     hov(b, ¤¤Accuracy, accuracy(0.0D), 1.0D);
/* 222 */     hov(b, ¤¤Reload, reloadSeconds(0.0D), reloadSeconds(1.0D));
/* 223 */     hov(b, ¤¤Arch, maxAngle(0.0D), maxAngle(1.0D));
/* 224 */     hov(b, ¤¤splashDamage, areaAttack(0.0D), areaAttack(1.0D));
/* 225 */     hov(b, (BOOSTABLES.BATTLE()).BLUNT_ATTACK.name, bluntDamage(0.0D), bluntDamage(1.0D));
/*     */     
/* 227 */     for (BOOSTABLES.BDamage pp : (BOOSTABLES.BATTLE()).DAMAGES) {
/* 228 */       hov(b, pp.attack.name, damage(pp.index(), 0.0D), damage(pp.index(), 1.0D));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void hov(GBox b, CharSequence name, double v) {
/* 233 */     GText t = b.text();
/* 234 */     GFORMAT.f(t, v);
/* 235 */     if (v == 0.0D)
/* 236 */       t.color(COLOR.WHITE50); 
/* 237 */     hov(b, name, t);
/*     */   }
/*     */   
/*     */   private static void hov(GBox b, CharSequence name, GText vv) {
/* 241 */     b.textL(name);
/* 242 */     b.tab(6);
/* 243 */     b.add((SPRITE)vv);
/* 244 */     b.NL();
/*     */   }
/*     */   
/*     */   private static void hov(GBox b, CharSequence name, double from, double to) {
/* 248 */     b.textL(name);
/* 249 */     b.tab(6);
/* 250 */     GText t = b.text();
/* 251 */     GFORMAT.f(t, from);
/* 252 */     if (from == 0.0D)
/* 253 */       t.color(COLOR.WHITE50); 
/* 254 */     b.add((SPRITE)t);
/*     */     
/* 256 */     b.tab(8);
/* 257 */     t = b.text();
/* 258 */     GFORMAT.f(t, to);
/* 259 */     if (to == 0.0D)
/* 260 */       t.color(COLOR.WHITE50); 
/* 261 */     b.add((SPRITE)t);
/* 262 */     b.NL();
/*     */   } public abstract double velocity(double paramDouble);
/*     */   public abstract double maxAngle(double paramDouble);
/*     */   public abstract double reloadSeconds(double paramDouble);
/*     */   public abstract double accuracy(double paramDouble);
/*     */   public abstract double skill(double paramDouble);
/*     */   public abstract double mass(double paramDouble);
/*     */   public abstract double damage(int paramInt, double paramDouble);
/*     */   public abstract double areaAttack(double paramDouble);
/*     */   public abstract SoundRace soundRelease();
/*     */   public abstract SoundRace soundHit();
/*     */   public abstract ProjectileSprite sprite();
/* 274 */   public static final class ProjectileSpec { public double maxAngle; public double velocity; public double accuracy; public double[] damage = new double[(BOOSTABLES.BATTLE()).DAMAGES.size()]; public double dexterity; public double reloadSpeed; public double mass; public double areaAttack;
/*     */     
/*     */     public ProjectileSpec(Json json) {
/* 277 */       if (json.has("PROJECTILE"))
/* 278 */         json = json.json("PROJECTILE"); 
/* 279 */       this.mass = json.d("MASS", 0.01D, 100000.0D);
/* 280 */       this.velocity = json.d("TILE_SPEED", 0.5D, 250.0D) * 64.0D;
/*     */       
/* 282 */       this.reloadSpeed = json.d("RELOAD_SECONDS", 0.01D, 10000.0D);
/*     */       
/* 284 */       this.accuracy = json.d("ACCURACY", 0.01D, 1.0D);
/* 285 */       this.dexterity = json.d("DEXTERITY", 0.0D, 1.0E7D);
/* 286 */       (BOOSTABLES.BATTLE()).DAMAGE_COLL.readFill(this.damage, json, 0.0D, 100000.0D);
/* 287 */       this.areaAttack = json.dTry("TILE_RADIUS_DAMAGE", 0.0D, 10000.0D, 0.0D) * 64.0D;
/* 288 */       this.maxAngle = json.d("MAX_ARCH_ANGLE_DEGREES", 0.0D, 75.0D);
/*     */     } }
/*     */ 
/*     */   
/*     */   public static final class ProjectileImp
/*     */     extends Projectile
/*     */   {
/*     */     private final Projectile.ProjectileSpec from;
/*     */     private final Projectile.ProjectileSpec delta;
/*     */     private final ProjectileSprite sprite;
/*     */     public final SoundRace soundRelease;
/*     */     public final SoundRace soundHit;
/*     */     
/*     */     public ProjectileImp(Json data, String key) throws IOException {
/* 302 */       if (data.has("PROJECTILE")) {
/* 303 */         data = data.json("PROJECTILE");
/*     */       }
/* 305 */       this.sprite = ProjectileSprite.get(data);
/* 306 */       this.soundRelease = AUDIO.race("PROJECTILE_RELEASE_" + key);
/* 307 */       this.soundHit = AUDIO.race("PROJECTILE_HIT_" + key);
/* 308 */       this.from = new Projectile.ProjectileSpec(data.json("FROM"));
/* 309 */       this.delta = new Projectile.ProjectileSpec(data.json("TO"));
/*     */       
/* 311 */       this.delta.accuracy -= this.from.accuracy;
/* 312 */       this.delta.dexterity -= this.from.dexterity;
/* 313 */       this.delta.areaAttack -= this.from.areaAttack;
/* 314 */       this.delta.mass -= this.from.mass;
/* 315 */       this.delta.maxAngle -= this.from.maxAngle;
/* 316 */       this.delta.reloadSpeed -= this.from.reloadSpeed;
/* 317 */       this.delta.velocity -= this.from.velocity;
/*     */       
/* 319 */       for (BOOSTABLES.BDamage d : (BOOSTABLES.BATTLE()).DAMAGES) {
/* 320 */         this.delta.damage[d.index()] = this.delta.damage[d.index()] - this.from.damage[d.index()];
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public double mass(double ref) {
/* 326 */       return this.from.mass + this.delta.mass * ref;
/*     */     }
/*     */ 
/*     */     
/*     */     public double damage(int battleI, double ref) {
/* 331 */       return this.from.damage[battleI] + this.delta.damage[battleI] * ref;
/*     */     }
/*     */ 
/*     */     
/*     */     public double areaAttack(double ref) {
/* 336 */       return this.from.areaAttack + this.delta.areaAttack * ref;
/*     */     }
/*     */ 
/*     */     
/*     */     public double velocity(double ref) {
/* 341 */       return this.from.velocity + this.delta.velocity * ref;
/*     */     }
/*     */ 
/*     */     
/*     */     public double maxAngle(double ref) {
/* 346 */       ref = CLAMP.d(ref, 0.0D, 1.0D);
/* 347 */       return this.from.maxAngle + this.delta.maxAngle * ref;
/*     */     }
/*     */ 
/*     */     
/*     */     public double reloadSeconds(double ref) {
/* 352 */       ref = CLAMP.d(ref, 0.0D, 1.0D);
/* 353 */       return this.from.reloadSpeed + this.delta.reloadSpeed * ref;
/*     */     }
/*     */ 
/*     */     
/*     */     public double accuracy(double ref) {
/* 358 */       return CLAMP.d(this.from.accuracy + this.delta.accuracy * ref, 0.0D, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public double skill(double ref) {
/* 363 */       return this.from.dexterity + this.delta.dexterity * ref;
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace soundRelease() {
/* 368 */       return this.soundRelease;
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace soundHit() {
/* 373 */       return this.soundHit;
/*     */     }
/*     */ 
/*     */     
/*     */     public ProjectileSprite sprite() {
/* 378 */       return this.sprite;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Projectile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */