/*     */ package settlement.entity.animal;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.ResolverTile;
/*     */ import settlement.entity.animal.spawning.AnimalSpawnSpot;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.pasture.PastureInstance;
/*     */ import settlement.room.food.pasture.ROOM_PASTURE;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Animal
/*     */   extends ENTITY
/*     */ {
/*  44 */   private static CharSequence ¤¤Cub = "¤Cub";
/*  45 */   private static CharSequence ¤¤domestcated = "¤(Domesticated)";
/*     */   static {
/*  47 */     D.ts(Animal.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final byte def;
/*     */   private boolean markedForTheHunt = false;
/*     */   private boolean huntedReserved = false;
/*     */   float spriteTimer;
/*     */   final float ran;
/*  56 */   float damage = 0.0F;
/*  57 */   final ColorImp color = new ColorImp();
/*     */   private boolean domesticated;
/*  59 */   static final int lifeSpan = (int)(5.0D * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/*     */   
/*  61 */   private int birthDay = TIME.days().bitsSinceStart() - RND.rInt(lifeSpan);
/*  62 */   private byte upHour = (byte)RND.rInt(TIME.hours().bitsPerCycle());
/*  63 */   boolean cub = (TIME.days().bitsSinceStart() - this.birthDay < 14);
/*     */   
/*     */   boolean inWater = false;
/*     */   
/*     */   private byte spotI;
/*     */   
/*     */   private State state;
/*     */   
/*     */   float stateTimer;
/*  72 */   int stateI = -1;
/*  73 */   private byte killSwitch = 0;
/*  74 */   private float nTimer = 0.0F;
/*     */ 
/*     */   
/*     */   public Animal(int x, int y, AnimalSpecies spec, AnimalSpawnSpot spot) {
/*  78 */     this.def = (byte)spec.index();
/*     */     
/*  80 */     this.physics.initPosition(x, y, spec.hitBoxSize(), spec.hitBoxSize());
/*  81 */     this.physics.setMass(spec.mass() * RND.rFloat1(0.2D));
/*  82 */     this.physics.setRestitution(0.2F);
/*  83 */     this.physics.setHeight(spec.heightOverGround() + RND.rFloat0(spec.heightOverGround() / 4.0D));
/*  84 */     this.inWater = (SETT.ENTITIES()).submerged.is(this.physics.tileC().x(), this.physics.tileC().y());
/*  85 */     this.speed.accelerationInit(spec.acceleration());
/*  86 */     this.speed.magnitudeMaxInit(spec.acceleration());
/*  87 */     this.speed.turnRandom();
/*     */     
/*  89 */     this.spotI = (byte)((spot != null) ? spot.index() : -1);
/*     */     
/*  91 */     this.ran = RND.rFloat();
/*     */     
/*  93 */     int c = 60 + RND.rInt(60);
/*  94 */     this.color.set(c + RND.rInt0(8), c + RND.rInt0(8), c + RND.rInt0(8));
/*     */     
/*  96 */     this.speed.turnRandom();
/*  97 */     setState(State.STAND, RND.rFloat(1.0D));
/*     */     
/*  99 */     add(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Animal(FileGetter file) throws IOException {
/* 104 */     load(file);
/*     */     
/* 106 */     this.def = (byte)((AnimalSpecies)(SETT.ANIMALS()).map.loader().loadB(file, null)).index();
/* 107 */     this.markedForTheHunt = file.bool();
/* 108 */     this.huntedReserved = file.bool();
/* 109 */     this.spriteTimer = file.f();
/* 110 */     this.ran = file.f();
/* 111 */     this.damage = file.f();
/* 112 */     this.color.load(file);
/* 113 */     this.domesticated = file.bool();
/* 114 */     this.birthDay = file.i();
/* 115 */     this.upHour = file.b();
/* 116 */     this.inWater = file.bool();
/* 117 */     this.cub = file.bool();
/* 118 */     this.spotI = file.b();
/*     */     
/* 120 */     this.state = State.all[file.i()];
/* 121 */     this.stateTimer = file.f();
/* 122 */     this.stateI = file.i();
/* 123 */     this.killSwitch = file.b();
/* 124 */     this.nTimer = file.f();
/* 125 */     if (this.upHour < 0) {
/* 126 */       this.upHour = (byte)(this.upHour + TIME.hoursPerDay());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 132 */     super.save(file);
/* 133 */     (SETT.ANIMALS()).map.saver().save(species(), file);
/* 134 */     file.bool(this.markedForTheHunt);
/* 135 */     file.bool(this.huntedReserved);
/* 136 */     file.f(this.spriteTimer);
/* 137 */     file.f(this.ran);
/* 138 */     file.f(this.damage);
/* 139 */     this.color.save(file);
/* 140 */     file.bool(this.domesticated);
/* 141 */     file.i(this.birthDay);
/* 142 */     file.b(this.upHour);
/* 143 */     file.bool(this.inWater);
/* 144 */     file.bool(this.cub);
/* 145 */     file.b(this.spotI);
/*     */     
/* 147 */     file.i(this.state.ordinal());
/* 148 */     file.f(this.stateTimer);
/* 149 */     file.i(this.stateI);
/* 150 */     file.b(this.killSwitch);
/* 151 */     file.f(this.nTimer);
/*     */   }
/*     */ 
/*     */   
/*     */   void setState(State s, float duration) {
/* 156 */     s.activate(this, duration);
/* 157 */     this.state = s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(double ds) {
/* 163 */     int ox = this.physics.tileC().x();
/* 164 */     int oy = this.physics.tileC().y();
/* 165 */     this.physics.move(this, this.speed, ds);
/*     */     
/* 167 */     if (!domesticated()) {
/* 168 */       this.nTimer = (float)(this.nTimer - ds);
/*     */       
/* 170 */       if (this.nTimer < 0.0F) {
/* 171 */         this.nTimer = RND.rFloat(20.0D);
/* 172 */         ENTITY scared = null;
/* 173 */         for (ENTITY e : SETT.ENTITIES().getInProximity(this, 5)) {
/* 174 */           if (e instanceof Animal) {
/* 175 */             if (scared != null)
/* 176 */               ((Animal)e).scare(scared, false);  continue;
/* 177 */           }  if (!(e instanceof Humanoid) || HPoll.Handler.scaresAnimal((Humanoid)e)) {
/* 178 */             scare(e, false);
/* 179 */             scared = e;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     if (!this.state.update(this, ds))
/*     */     {
/*     */       
/* 188 */       if (!this.speed.isZero()) {
/* 189 */         setState(State.STAND, 1.0F);
/* 190 */       } else if (RND.rInt(4) == 0) {
/* 191 */         if (spot() != null && !domesticated())
/* 192 */         { if (!spot().active()) {
/* 193 */             this.killSwitch = (byte)(this.killSwitch + 1);
/* 194 */             if (this.killSwitch >= 20) {
/* 195 */               kill(false, false);
/* 196 */               return false;
/*     */             } 
/* 198 */             setState(State.WALK_RANDOM, 0.25F + RND.rFloat(1.0D));
/* 199 */           } else if (COORDINATE.tileDistance(this.physics.tileC(), (COORDINATE)spot()) > 8.0D) {
/* 200 */             this.killSwitch = (byte)(this.killSwitch + 1);
/* 201 */             if (this.killSwitch >= 48) {
/* 202 */               kill(false, false);
/* 203 */               return false;
/*     */             } 
/* 205 */             this.speed.turn2((BODY_HOLDER)this, (spot().x() * 64), (spot().y() * 64));
/* 206 */             setState(State.WALK_RANDOM, 1.0F + RND.rFloat(2.0D));
/*     */           } else {
/*     */             
/* 209 */             this.killSwitch = 0;
/* 210 */             if (RND.rInt(8) == 0) {
/* 211 */               setState(State.WALK_RANDOM, 4.0F + RND.rFloat(10.0D));
/*     */             } else {
/* 213 */               setState(State.WALK_RANDOM, 0.25F + RND.rFloat(1.0D));
/*     */             } 
/*     */           }  }
/*     */         else
/*     */         
/* 218 */         { setState(State.WALK_RANDOM, 0.25F + RND.rFloat(1.0D)); } 
/* 219 */       } else if (RND.rBoolean()) {
/* 220 */         this.speed.turnRandom();
/* 221 */         setState(State.STAND, 5.0F + RND.rFloat(5.0D));
/* 222 */         if (!this.domesticated || RND.oneIn(4))
/* 223 */           (species()).sound.rnd(body()); 
/*     */       } else {
/* 225 */         setState(State.GRACE, 8.0F + RND.rFloat() * 8.0F);
/*     */       } 
/*     */     }
/*     */     
/* 229 */     ResolverTile.collide(this);
/*     */     
/* 231 */     if (isRemoved()) {
/* 232 */       return false;
/*     */     }
/* 234 */     if (!this.physics.tileC().isSameAs(ox, oy)) {
/* 235 */       if (this.domesticated && (
/* 236 */         !((SETT.ROOMS()).map.get(this.physics.tileC()) instanceof PastureInstance) || ROOM_PASTURE.isGate(ox, oy) || ROOM_PASTURE.isGate(this.physics.tileC().x(), this.physics.tileC().y()))) {
/* 237 */         Room r = (SETT.ROOMS()).map.get(ox, oy);
/* 238 */         if (r == null || !(r instanceof PastureInstance)) {
/* 239 */           helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 240 */           return false;
/*     */         } 
/* 242 */         for (DIR d : DIR.ALLC) {
/* 243 */           int dx = ox + d.x();
/* 244 */           int dy = oy + d.y();
/* 245 */           if (r.isSame(ox, oy, dx, dy) && !ROOM_PASTURE.isGate(dx, dy) && !(SETT.PATH()).solidity.is(dx, dy)) {
/* 246 */             this.physics.body().moveC((dx * 64 + 32), (dy * 64 + 32));
/* 247 */             this.speed.magnitudeInit(0.0D);
/* 248 */             this.speed.magnitudeTargetSet(0.0D);
/* 249 */             this.speed.reverseX();
/* 250 */             this.speed.reverseY();
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 258 */       this.inWater = (SETT.ENTITIES()).submerged.is(this.physics.tileC().x(), this.physics.tileC().y());
/*     */     } 
/*     */     
/* 261 */     if (isRemoved()) {
/* 262 */       return false;
/*     */     }
/* 264 */     if (this.upHour == TIME.hours().bitCurrent()) {
/* 265 */       if (this.cub && TIME.days().bitsSinceStart() - this.birthDay >= 14) {
/* 266 */         this.cub = false;
/* 267 */         if (this.domesticated) {
/* 268 */           Room r = (SETT.ROOMS()).map.get(ssx(), ssy());
/* 269 */           if (r != null && r instanceof PastureInstance) {
/* 270 */             ((PastureInstance)r).reportAdult();
/*     */           } else {
/* 272 */             GAME.Notify("weird!");
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 277 */       if (!this.domesticated && TIME.days().bitCurrent() - this.birthDay > lifeSpan) {
/* 278 */         kill(false, false);
/* 279 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 283 */       if (this.upHour == 0) {
/* 284 */         this.upHour = (byte)(TIME.hours().bitsPerCycle() - 1);
/*     */       } else {
/* 286 */         this.upHour = (byte)(this.upHour - 1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 291 */     if (this.damage > 1.0F) {
/*     */       
/* 293 */       if (this.damage == 2.0F) {
/* 294 */         kill(true, false);
/*     */       } else {
/*     */         
/* 297 */         kill(false, false);
/*     */       } 
/* 299 */       return false;
/*     */     } 
/*     */     
/* 302 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, int offsetX, int offsetY) {
/* 308 */     this.state.sprite(this).render(this, false, r, s, ds, offsetX, offsetY);
/* 309 */     if (!VIEW.hideUI()) {
/* 310 */       if (huntReservable()) {
/* 311 */         (GCOLOR.MAP()).JOB_ACTIVE.bind();
/* 312 */         (SPRITES.cons()).ICO.crosshair.renderC((SPRITE_RENDERER)r, body().cX() + offsetX, body().cY() + offsetY);
/* 313 */       } else if (huntReserved()) {
/* 314 */         (GCOLOR.MAP()).JOB_RESERVED.bind();
/* 315 */         (SPRITES.cons()).ICO.crosshair.renderC((SPRITE_RENDERER)r, body().cX() + offsetX, body().cY() + offsetY);
/*     */       } 
/* 317 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnimalSpecies species() {
/* 324 */     return (AnimalSpecies)(SETT.ANIMALS()).species.get(this.def);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box) {
/* 330 */     box.title((species()).name);
/* 331 */     box.add((SPRITE)(species()).icon);
/* 332 */     box.NL();
/* 333 */     if (this.cub) {
/* 334 */       box.text(¤¤Cub);
/* 335 */       box.NL();
/* 336 */       box.text((species()).desc);
/*     */       
/*     */       return;
/*     */     } 
/* 340 */     box.text((species()).desc);
/*     */     
/* 342 */     box.NL();
/* 343 */     if (domesticated()) {
/* 344 */       box.text(¤¤domestcated);
/*     */       
/*     */       return;
/*     */     } 
/* 348 */     for (int i = 0; i < species().resources().size(); i++) {
/* 349 */       box.setResource((RESOURCE)species().resources().get(i), species().resAmount(i, this.physics.getMass()));
/*     */     }
/*     */     
/* 352 */     if ((S.get()).developer || (S.get()).debug) {
/* 353 */       box.NL();
/* 354 */       box.text(this.state.name());
/* 355 */       box.NL();
/* 356 */       box.add((SPRITE)box.text().add((spot() != null)));
/* 357 */       box.NL();
/* 358 */       box.add((SPRITE)box.text().add(this.killSwitch));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void click() {}
/*     */ 
/*     */   
/*     */   public void scare(ENTITY other, boolean flee) {
/* 368 */     this.state.scare(this, other, flee);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void collide(ECollision coll) {
/* 375 */     if (!this.state.wantsToCollide(this, coll.tileMomentum)) {
/* 376 */       this.state.collide(this, coll.other, coll.norX, coll.norY, 0.0D);
/*     */       return;
/*     */     } 
/* 379 */     this.state.collide(this, coll.other, coll.norX, coll.norY, coll.tileMomentum);
/*     */ 
/*     */ 
/*     */     
/* 383 */     double dam = 0.0D;
/*     */     
/* 385 */     for (int i = 0; i < (BOOSTABLES.BATTLE()).DAMAGES.size(); i++) {
/* 386 */       dam += 0.25D * coll.damage[i];
/*     */     }
/*     */ 
/*     */     
/* 390 */     if (dam > 7.0D * (species()).momTreshold) {
/* 391 */       this.damage += 2.0F;
/*     */     
/*     */     }
/* 394 */     else if (dam > 3.5D * (species()).momTreshold) {
/* 395 */       dam -= 1.5D * (species()).momTreshold;
/* 396 */       dam /= 0.5D * (species()).momTreshold;
/* 397 */       this.damage = (float)(this.damage + dam);
/*     */     } 
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
/*     */   public void collideUnconnected() {
/* 410 */     this.state.collideUnwalkable(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void meet(ENTITY other) {
/* 415 */     this.state.meet(this, other);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean collideTile(boolean broken, double norX, double norY, double momentum, int tx, int ty) {
/* 420 */     return this.state.collideTile(this, broken, norX, norY, momentum);
/*     */   }
/*     */   
/*     */   public ThingsCadavers.Cadaver slaugher() {
/* 424 */     if (isRemoved()) {
/* 425 */       throw new RuntimeException();
/*     */     }
/* 427 */     this.damage = (float)(this.damage + 0.25D);
/* 428 */     if (this.damage > 1.0F) {
/* 429 */       this.damage = 1.0F;
/*     */     }
/* 431 */     return kill(false, true);
/*     */   }
/*     */ 
/*     */   
/*     */   ThingsCadavers.Cadaver kill(boolean gore, boolean hunted) {
/* 436 */     if (isRemoved())
/* 437 */       throw new RuntimeException(); 
/* 438 */     helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 439 */     if (gore)
/* 440 */       (SETT.THINGS()).gore.explode(this, (species()).blood); 
/* 441 */     if ((SETT.TERRAIN()).WATER.DEEP.is(this.physics.tileC())) {
/* 442 */       return null;
/*     */     }
/* 444 */     if (hunted) {
/* 445 */       (SETT.ANIMALS()).spawn.reportKilled(species());
/* 446 */       return (SETT.THINGS()).cadavers.normal(body().cX(), body().cY(), this.physics.getMass(), this.damage, species(), this.speed.dir().id());
/*     */     } 
/*     */     
/* 449 */     if (gore) {
/* 450 */       return (SETT.THINGS()).cadavers.gore(body().cX(), body().cY(), species());
/*     */     }
/* 452 */     return (SETT.THINGS()).cadavers.normal(body().cX(), body().cY(), this.physics.getMass(), this.damage, species(), this.speed.dir().id());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 457 */     if (spot() != null)
/* 458 */       spot().deregisterAnimal(); 
/* 459 */     if (this.domesticated) {
/* 460 */       Room r = (SETT.ROOMS()).map.get(ssx(), ssy());
/* 461 */       if (r != null && r instanceof PastureInstance) {
/* 462 */         ((PastureInstance)r).removeAnimal(this.cub);
/*     */       } else {
/* 464 */         GAME.Notify("weird!");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean willCollideWith(ENTITY other) {
/* 471 */     if (domesticated())
/* 472 */       return false; 
/* 473 */     return this.state.willCollideWith(this, other);
/*     */   }
/*     */   
/*     */   public boolean domesticated() {
/* 477 */     return this.domesticated;
/*     */   }
/*     */   
/*     */   public boolean cub() {
/* 481 */     return this.cub;
/*     */   }
/*     */   
/*     */   public void domesticate() {
/* 485 */     (SETT.PATH()).finders.entity.report(this, -1);
/* 486 */     this.domesticated = true;
/* 487 */     this.birthDay = TIME.days().bitsSinceStart() - RND.rInt(2);
/* 488 */     this.cub = true;
/* 489 */     (SETT.PATH()).finders.entity.report(this, 1);
/*     */   }
/*     */   
/*     */   public AnimalSpawnSpot spot() {
/* 493 */     if (this.spotI < 0)
/* 494 */       return null; 
/* 495 */     return (AnimalSpawnSpot)(SETT.ANIMALS()).spawn.all().get(this.spotI);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setCollideDamage(ECollision coll, ECollision result) {
/* 501 */     if (!this.cub && !domesticated() && !(coll.other instanceof Animal) && 
/* 502 */       (SETT.ANIMALS()).spawn.isTimeForAKill(species())) {
/* 503 */       result.damage[0] = 1.0D;
/* 504 */       result.damagetileStrength = this.physics.getMass() * 64.0D * 32.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getDefenceSkill(double dirDot, double adx, double ady) {
/* 512 */     return (dirDot + 1.0D) * 0.2D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double height() {
/* 517 */     return this.physics.getHeight();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderSimple(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 522 */     render(r, shadows, ds, offsetX, offsetY);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBaby() {
/* 527 */     return this.cub;
/*     */   }
/*     */   
/*     */   public boolean huntReservable() {
/* 531 */     return (!this.domesticated && this.markedForTheHunt && !this.huntedReserved && !isRemoved());
/*     */   }
/*     */   
/*     */   public boolean huntReserved() {
/* 535 */     return (!this.domesticated && this.markedForTheHunt && this.huntedReserved && !isRemoved());
/*     */   }
/*     */   
/*     */   public void huntReserve() {
/* 539 */     if (huntReservable()) {
/* 540 */       (SETT.PATH()).finders.entity.report(this, -1);
/* 541 */       this.huntedReserved = true;
/* 542 */       (SETT.PATH()).finders.entity.report(this, 1);
/*     */       return;
/*     */     } 
/* 545 */     throw new RuntimeException("" + (this.cub ? 0 : 1) + " " + (this.cub ? 0 : 1) + " " + (this.domesticated ? 0 : 1) + " " + (this.huntedReserved ? 0 : 1));
/*     */   }
/*     */   
/*     */   public void huntReserveCancel() {
/* 549 */     if (huntReserved()) {
/* 550 */       (SETT.PATH()).finders.entity.report(this, -1);
/* 551 */       this.huntedReserved = false;
/* 552 */       (SETT.PATH()).finders.entity.report(this, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean huntMarkedIs() {
/* 557 */     return !(!huntReservable() && !huntReserved());
/*     */   }
/*     */   
/*     */   public boolean huntMarkedCan() {
/* 561 */     return (!huntMarkedIs() && !this.domesticated);
/*     */   }
/*     */   
/*     */   public void huntMark(boolean m) {
/* 565 */     (SETT.PATH()).finders.entity.report(this, -1);
/* 566 */     if (m) {
/* 567 */       if (huntMarkedIs())
/*     */         return; 
/* 569 */       if (huntMarkedCan()) {
/* 570 */         this.markedForTheHunt = true;
/*     */       }
/* 572 */     } else if (huntMarkedIs()) {
/* 573 */       this.markedForTheHunt = false;
/*     */     } 
/* 575 */     (SETT.PATH()).finders.entity.report(this, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Animal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */