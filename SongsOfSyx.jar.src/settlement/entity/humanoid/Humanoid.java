/*     */ package settlement.entity.humanoid;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.nobility.Noble;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.settings.S;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.ResolverTile;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.HAI;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.DRAGGABLE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Humanoid
/*     */   extends ENTITY
/*     */   implements DRAGGABLE
/*     */ {
/*  56 */   public static final int WORK_TICKS = 16 * TIME.workHours() / TIME.hoursPerDay();
/*  57 */   public static final double WORK_PER_DAY = WORK_TICKS / 16.0D;
/*  58 */   public static final double WORK_PER_DAYI = 1.0D / WORK_PER_DAY;
/*     */   
/*     */   final AIManager ai;
/*     */   private final Induvidual induvidual;
/*  62 */   public byte spriteoff = (byte)RND.rInt(255);
/*  63 */   public float spriteTimer = 0.0F;
/*  64 */   public float relTimer = 0.0F;
/*     */ 
/*     */   
/*  67 */   private float updateTimer = (float)(RND.rFloat() * HumanoidResource.updateDelta);
/*  68 */   private byte dayOfYear = (byte)TIME.days().bitCurrent();
/*     */   
/*  70 */   private byte updateI = (byte)RND.rInt(255);
/*  71 */   private byte dayRan = (byte)RND.rInt(256);
/*     */   public float moveBonus;
/*     */   public boolean inWater;
/*  74 */   private short nobleI = -1;
/*  75 */   private byte leaveCause = -1;
/*     */   private byte mark;
/*  77 */   public static int TARGET_MAX = 10;
/*     */ 
/*     */   
/*     */   public Humanoid(int x, int y, Race spec, HTYPE type, CAUSE_ARRIVE cause) {
/*  81 */     this.induvidual = new Induvidual(type, spec);
/*     */     
/*  83 */     this.physics.initPosition(x, y, spec.physics.hitBoxsize(), spec.physics.hitBoxsize());
/*     */     
/*  85 */     this.physics.setRestitution(0.2F);
/*  86 */     this.physics.setHeight(spec.physics.height() + RND.rFloat0(spec.physics.height() / 4.0D));
/*     */     
/*  88 */     this.physics.setMass((BOOSTABLES.PHYSICS()).MASS.get((BOOSTABLE_O)this.induvidual));
/*  89 */     this.speed.accelerationInit((BOOSTABLES.PHYSICS()).ACCELERATION.get((BOOSTABLE_O)this.induvidual) * 64.0D);
/*  90 */     this.speed.magnitudeMaxInit((BOOSTABLES.PHYSICS()).SPEED.get((BOOSTABLE_O)this.induvidual) * 64.0D);
/*  91 */     this.speed.turnRandom();
/*     */     
/*  93 */     this.ai = new AIManager(this);
/*     */     
/*  95 */     initTile(-1, -1);
/*     */     
/*  97 */     add(false);
/*     */     
/*  99 */     if (isRemoved()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 104 */     this.induvidual.add(this, cause);
/* 105 */     this.ai.add(this, cause);
/*     */ 
/*     */     
/* 108 */     if (this.induvidual.player()) {
/* 109 */       (GAME.count()).SUBJECTS.inc(1);
/*     */     }
/* 111 */     if (cause == CAUSE_ARRIVES.IMMIGRATED()) {
/* 112 */       (STATS.POP()).TYPE.IMMIGRANT.set(this.induvidual);
/*     */     }
/*     */     
/* 115 */     STATS.REL().setHumanoid(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid(FileGetter file) throws IOException {
/* 120 */     load(file);
/* 121 */     this.ai = new AIManager(this, file);
/* 122 */     this.induvidual = new Induvidual(file);
/* 123 */     this.spriteoff = file.b();
/* 124 */     this.spriteTimer = file.f();
/* 125 */     this.relTimer = file.f();
/* 126 */     this.updateTimer = file.f();
/* 127 */     this.dayOfYear = file.b();
/* 128 */     this.updateI = file.b();
/* 129 */     this.dayRan = file.b();
/* 130 */     this.moveBonus = file.f();
/* 131 */     this.inWater = file.bool();
/* 132 */     this.nobleI = file.s();
/* 133 */     this.leaveCause = file.b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 138 */     super.save(file);
/* 139 */     this.ai.save(file);
/* 140 */     this.induvidual.save(file);
/* 141 */     file.b(this.spriteoff);
/* 142 */     file.f(this.spriteTimer);
/* 143 */     file.f(this.relTimer);
/* 144 */     file.f(this.updateTimer);
/* 145 */     file.b(this.dayOfYear);
/* 146 */     file.b(this.updateI);
/* 147 */     file.b(this.dayRan);
/* 148 */     file.f(this.moveBonus);
/* 149 */     file.bool(this.inWater);
/* 150 */     file.s(this.nobleI);
/* 151 */     file.b(this.leaveCause);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, int offsetX, int offsetY) {
/* 157 */     int x = body().x1() + offsetX - (race().appearance()).off;
/* 158 */     int y = body().y1() + offsetY - (race().appearance()).off;
/*     */     
/* 160 */     x += -4 + (this.spriteoff & 0x7);
/* 161 */     y += -4 + (this.spriteoff >> 3 & 0x7);
/* 162 */     HSprite sprite = this.ai.sprite(this);
/* 163 */     sprite.render(this, this.ai, r, s, ds, x, y);
/*     */     
/* 165 */     if (division() != null && division().settings().mustering() && (id() & 0x1F) == 0) {
/* 166 */       (SETT.BATTLE()).bannerR.regBannerman(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderSimple(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 174 */     int x = body().x1() + offsetX - (race().appearance()).off;
/* 175 */     int y = body().y1() + offsetY - (race().appearance()).off;
/*     */     
/* 177 */     x += -4 + (this.spriteoff & 0x7);
/* 178 */     y += -4 + (this.spriteoff >> 3 & 0x7);
/* 179 */     HSprite sprite = this.ai.sprite(this);
/* 180 */     sprite.renderSimple(this, this.ai, r, shadows, ds, x, y);
/* 181 */     if (division() != null && division().settings().mustering() && (id() & 0x1F) == 0) {
/* 182 */       (SETT.BATTLE()).bannerR.regBannerman(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Race race() {
/* 190 */     return this.induvidual.race();
/*     */   }
/*     */   
/*     */   private void initTile(int ox, int oy) {
/* 194 */     this.inWater = (SETT.ENTITIES()).submerged.is(this.physics.tileC().x(), this.physics.tileC().y());
/* 195 */     initSpeed();
/*     */   }
/*     */   
/*     */   private void initSpeed() {
/* 199 */     this.moveBonus = (float)((this.ai.resourceA() > 0) ? 0.6D : 1.0D);
/*     */     
/* 201 */     AVAILABILITY a = (AVAILABILITY)(SETT.PATH()).availability.get(this.physics.tileC());
/* 202 */     if (a != null) {
/* 203 */       this.moveBonus = (float)(this.moveBonus * a.movementSpeed * (1.0D - 0.5D * (STATS.NEEDS()).INJURIES.COUNT.indu().getD(indu())));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(double ds) {
/* 209 */     int cx = body().cX() >> 4;
/* 210 */     int cy = body().cY() >> 4;
/*     */     
/* 212 */     int ox = this.physics.tileC().x();
/* 213 */     int oy = this.physics.tileC().y();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     this.physics.move(this, this.speed, ds * this.moveBonus);
/*     */     
/* 223 */     this.ai.update(this, ds);
/*     */     
/* 225 */     ResolverTile.collide(this);
/*     */     
/* 227 */     if (isRemoved()) {
/* 228 */       return false;
/*     */     }
/* 230 */     if (!this.physics.tileC().isSameAs(ox, oy)) {
/* 231 */       initTile(ox, oy);
/* 232 */       if (RND.oneIn(18) && !(SETT.ROOMS()).map.is(this.physics.tileC())) {
/* 233 */         int x = this.physics.tileC().x() + RND.rInt0(9) / 8;
/* 234 */         int y = this.physics.tileC().y() + RND.rInt0(9) / 8;
/* 235 */         if (SETT.IN_BOUNDS(x, y) && !(SETT.ROOMS()).map.is(x, y) && (SETT.FLOOR()).getter.get(x, y) == null) {
/* 236 */           (SETT.TILE_MAP()).growth.tear(x, y);
/*     */ 
/*     */           
/* 239 */           (SETT.GRASS()).currentI.increment(x, y, -1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 245 */     if (AIManager.dead != null) {
/* 246 */       kill(false, AIManager.dead);
/* 247 */       AIManager.dead = null;
/* 248 */       return false;
/*     */     } 
/*     */     
/* 251 */     int uS = (int)this.updateTimer;
/* 252 */     this.updateTimer = (float)(this.updateTimer - ds);
/* 253 */     int uSN = (int)this.updateTimer;
/*     */     
/* 255 */     if (uS != uSN) {
/* 256 */       if (!this.inWater && (uS & 0x1) == 0 && 
/* 257 */         (STATS.NEEDS()).INJURIES.COUNT.indu().get(this.induvidual) > RND.rInt((STATS.NEEDS()).INJURIES.COUNT.indu().max(this.induvidual))) {
/* 258 */         (SETT.THINGS()).gore.bleed(this, (race().appearance()).colors.blood);
/*     */       }
/*     */       
/* 261 */       if ((uS & 0x7) == 0) {
/* 262 */         HEvent.Handler.exhaust(this);
/* 263 */       } else if ((uS & 0x7) == 1) {
/* 264 */         HEvent.Handler.checkMorale(this);
/*     */       } 
/* 266 */       Div d = division();
/* 267 */       if (d != null && d.settings().mustering()) {
/* 268 */         BattleTrajectories.register(this, d);
/*     */       }
/* 270 */       this.physics.setMass((BOOSTABLES.PHYSICS()).MASS.get((BOOSTABLE_O)this.induvidual));
/* 271 */       this.speed.accelerationInit(Math.max(0.2D, (BOOSTABLES.PHYSICS()).ACCELERATION.get((BOOSTABLE_O)this.induvidual)) * 64.0D);
/* 272 */       this.speed.magnitudeMaxInit(Math.max(0.2D, (BOOSTABLES.PHYSICS()).SPEED.get((BOOSTABLE_O)this.induvidual)) * 64.0D);
/*     */     } 
/*     */     
/* 275 */     if (this.updateTimer <= 0.0F) {
/* 276 */       boolean day = false;
/*     */       
/* 278 */       if (this.dayOfYear != TIME.days().bitCurrent()) {
/*     */         
/* 280 */         int now = (int)(TIME.days().bitPartOf() * 16.0D);
/* 281 */         int db = getDayBreakTick();
/* 282 */         if (now >= db) {
/* 283 */           day = true;
/* 284 */           this.dayOfYear = (byte)TIME.days().bitCurrent();
/*     */         } 
/*     */       } 
/*     */       
/* 288 */       this.updateTimer = (float)(this.updateTimer + HumanoidResource.updateDelta);
/*     */       
/* 290 */       this.updateI = (byte)(this.updateI + 1);
/* 291 */       if (day)
/* 292 */         this.dayRan = (byte)RND.rInt(256); 
/* 293 */       this.ai.update(this, this.updateI, day);
/* 294 */       if (isRemoved())
/* 295 */         return true; 
/* 296 */       this.induvidual.update(this, this.updateI & 0xFF, day);
/* 297 */       this.mark = (byte)(this.mark - 1);
/* 298 */       this.mark = (byte)CLAMP.i(this.mark, 0, 100);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 304 */     if (AIManager.dead != null) {
/* 305 */       kill(AIManager.deadGore, AIManager.dead);
/* 306 */       AIManager.dead = null;
/* 307 */     } else if (body().cX() >> 4 != cx || body().cY() >> 4 != cy) {
/* 308 */       Div d = division();
/* 309 */       if (d != null)
/* 310 */         d.reporter.reportPosition(divSpot(), body().cX(), body().cY()); 
/*     */     } 
/* 312 */     return true;
/*     */   }
/*     */   
/*     */   public double partOfDay() {
/* 316 */     int now = (int)(TIME.days().bitPartOf() * 16.0D);
/* 317 */     int db = getDayBreakTick();
/* 318 */     if (now == db)
/* 319 */       return 1.0D; 
/* 320 */     if (now < db) {
/* 321 */       return 1.0D - 0.0625D * (db - now);
/*     */     }
/* 323 */     return 1.0D - 0.0625D * (16 - now - db);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox text) {
/* 329 */     (VIEW.s()).ui.subjects.hoverInfo(this, text);
/*     */     
/* 331 */     if ((S.get()).developer) {
/* 332 */       text.NL();
/* 333 */       text.add((SPRITE)GFORMAT.f(text.text(), this.ai.stateTimer));
/* 334 */       text.NL();
/* 335 */       text.text(String.valueOf(tc()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void click() {
/* 344 */     (VIEW.s()).ui.subjects.showSingle(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeClicked() {
/* 349 */     return (VIEW.s()).ui.subjects.canShow(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean inflictDamage(double d, CAUSE_LEAVE cause) {
/* 357 */     this.leaveCause = (byte)cause.index();
/*     */     
/* 359 */     if (d <= 0.0D) {
/* 360 */       return false;
/*     */     }
/* 362 */     if (d > 0.1D) {
/* 363 */       (SETT.THINGS()).gore.bleed(this, (race().appearance()).colors.blood);
/*     */     }
/*     */     
/* 366 */     if (d > 0.2D) {
/* 367 */       (SETT.THINGS()).gore.cloud(this, (race().appearance()).colors.blood);
/*     */     }
/*     */     
/* 370 */     if (d * RND.rFloat() > 1.0D) {
/* 371 */       (SETT.HUMANOIDS()).sound.rnd(this);
/* 372 */       (SETT.THINGS()).gore.explode(this, (race().appearance()).colors.blood);
/* 373 */       (STATS.NEEDS()).INJURIES.COUNT.indu().setD(this.induvidual, 1.0D);
/* 374 */       if (division() != null) {
/* 375 */         (GAME.ARMIES()).factors.reportCasulty(division());
/*     */       }
/*     */       
/* 378 */       kill(true, (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.leaveCause));
/* 379 */       return false;
/*     */     } 
/*     */     
/* 382 */     int m = (STATS.NEEDS()).INJURIES.COUNT.indu().max(this.induvidual);
/* 383 */     d *= m;
/* 384 */     int ii = (int)d;
/*     */     
/* 386 */     if (RND.rFloat() < d - ii) {
/* 387 */       ii++;
/*     */     }
/* 389 */     int am = (STATS.NEEDS()).INJURIES.COUNT.indu().get(this.induvidual) + ii;
/*     */     
/* 391 */     if (am >= m) {
/* 392 */       (STATS.NEEDS()).INJURIES.COUNT.indu().inc(this.induvidual, (int)(d * RND.rFloat()));
/* 393 */       if (division() != null) {
/* 394 */         (GAME.ARMIES()).factors.reportCasulty(division());
/*     */       }
/* 396 */       kill(true, (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.leaveCause));
/* 397 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 401 */     (STATS.NEEDS()).INJURIES.COUNT.indu().set(this.induvidual, am);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 407 */     return true;
/*     */   }
/*     */   
/*     */   public void kill(boolean gore, CAUSE_LEAVE cause) {
/* 411 */     if (isRemoved()) {
/*     */       return;
/*     */     }
/* 414 */     if (indu().hType() == HTYPES.PRISONER()) {
/* 415 */       if (cause.leavesCorpse && AIModule_Prisoner.punishment(this, (HAI)this.ai) == CRIME_PUNISHMENTS.STOCKS())
/* 416 */         STATS.LAW().punish(indu(), CRIME_PUNISHMENTS.EXECUTE()); 
/* 417 */       if (cause == CAUSE_LEAVES.EXECUTED()) {
/* 418 */         (GAME.count()).EXECUTIONS.inc(1);
/* 419 */         STATS.LAW().punish(indu(), CRIME_PUNISHMENTS.EXECUTE());
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 431 */     (STATS.POP()).COUNT.reg(indu(), cause);
/*     */     
/* 433 */     if (cause.leavesCorpse) {
/* 434 */       if (this.speed.isZero()) {
/* 435 */         (SETT.THINGS()).corpses.create(
/* 436 */             this, 
/* 437 */             !gore, cause);
/*     */       } else {
/*     */         
/* 440 */         (SETT.HALFENTS()).corpses.make(this, gore, cause);
/*     */       } 
/* 442 */       if (!VIEW.b().isActive() && (
/* 443 */         indu().player() || RND.oneIn(5))) {
/* 444 */         STATS.EQUIP().drop(this);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 449 */     helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 450 */     STATS.REL().setDeath(this.induvidual, cause);
/*     */   }
/*     */ 
/*     */   
/*     */   public void collide(ECollision coll) {
/* 455 */     HEvent.Handler.collide(this, this.ai, coll);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void meet(ENTITY other) {
/* 460 */     HEvent.Handler.meet(this, this.ai, other);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean collidesWithOthers(ENTITY e) {
/* 465 */     return HPoll.Handler.collides(this, this.ai, e);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean willCollideWith(ENTITY other) {
/* 470 */     return HPoll.Handler.willCollideWith(this, this.ai, other);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean collideTile(boolean broken, double norX, double norY, double force, int tx, int ty) {
/* 476 */     return HEvent.Handler.collideTile(this, this.ai, norX, norY, force, broken, tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void collideUnconnected() {
/* 482 */     HEvent.Handler.collisionUnreachable(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setCollideDamage(ECollision coll, ECollision result) {
/* 487 */     HPoll.Handler.collideDamage(this, this.ai, coll, result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 495 */     this.ai.cancel(this);
/* 496 */     this.induvidual.cancel(this);
/* 497 */     if (noble() != null) {
/* 498 */       GAME.NOBLE().vacateOnlyCallFromHumanoid(this, this.nobleI);
/*     */     }
/* 500 */     STATS.REL().setDeath(this.induvidual, CAUSE_LEAVES.OTHER());
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
/*     */   public double getDefenceSkill(double dirDot, double adx, double ady) {
/* 515 */     double d = HPoll.Handler.defenseSkill(this, dirDot, adx, ady);
/* 516 */     return d;
/*     */   }
/*     */   
/*     */   public Induvidual indu() {
/* 520 */     return this.induvidual;
/*     */   }
/*     */   
/*     */   public HAI ai() {
/* 524 */     return (HAI)this.ai;
/*     */   }
/*     */   
/*     */   public CAUSE_LEAVE lastLeaveCause() {
/* 528 */     if (this.leaveCause == -1)
/* 529 */       return null; 
/* 530 */     return (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.leaveCause);
/*     */   }
/*     */   
/*     */   private int getDayBreakTick() {
/* 534 */     int db = (this.spriteoff & 0x3) - 1;
/*     */     
/* 536 */     RoomInstance w = (RoomInstance)(STATS.WORK()).EMPLOYED.get(this.induvidual);
/* 537 */     if (w != null) {
/* 538 */       db += (int)(w.blueprintI().employment().getShiftStart() * 15.0D);
/* 539 */       if ((STATS.RAN().get(this.induvidual, 0) & 0x1) == 1 && w.blueprintI().employment().worksNights()) {
/* 540 */         db += 8;
/* 541 */         db &= 0xF;
/*     */       } 
/*     */     } else {
/* 544 */       db = (int)(db + 4.875D);
/*     */     } 
/* 546 */     return db & 0xF;
/*     */   }
/*     */   
/*     */   public int getNewDayHour() {
/* 550 */     return 24 * getDayBreakTick() / 16;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDivision(Div div) {
/* 556 */     (STATS.BATTLE()).DIV.set(this, div);
/* 557 */     if (div != null) {
/* 558 */       (division()).reporter.reportPosition(divSpot(), body().cX(), body().cY());
/*     */     }
/*     */   }
/*     */   
/*     */   public void teleportAndInitInDiv() {
/* 563 */     if (division() == null)
/*     */       return; 
/* 565 */     if (!division().settings().mustering())
/*     */       return; 
/* 567 */     COORDINATE de = (division()).reporter.getPixel(this);
/* 568 */     if (de == null)
/*     */       return; 
/* 570 */     this.physics.body().moveC(de);
/* 571 */     this.ai.muster(this);
/* 572 */     SETT.ENTITIES().move(this);
/* 573 */     if (division() == null)
/*     */       return; 
/* 575 */     this.speed.setDirCurrent(division().dir());
/* 576 */     (division()).reporter.reportPosition(divSpot(), body().cX(), body().cY());
/*     */   }
/*     */ 
/*     */   
/*     */   public Div division() {
/* 581 */     return (Div)(STATS.BATTLE()).DIV.get(this);
/*     */   }
/*     */   
/*     */   public static abstract class HumanoidResource
/*     */   {
/*     */     public static final int updatesPerDay = 16;
/*     */     public static final double updatesPerDayI = 0.0625D;
/* 588 */     public static final double updateDelta = (TIME.secondsPerHour() * TIME.hoursPerDay() / 16);
/*     */     public static final int byteDelta = 16;
/*     */     public static CAUSE_LEAVE dead;
/*     */     public static boolean deadGore;
/*     */     
/*     */     protected abstract void update(Humanoid param1Humanoid, int param1Int, boolean param1Boolean);
/*     */     
/*     */     protected abstract void update(Humanoid param1Humanoid, double param1Double);
/*     */     
/*     */     protected abstract void cancel(Humanoid param1Humanoid);
/*     */     
/*     */     protected abstract void add(Humanoid param1Humanoid, CAUSE_ARRIVE param1CAUSE_ARRIVE);
/*     */     
/*     */     protected abstract void save(FilePutter param1FilePutter); }
/*     */   
/*     */   protected double height() {
/* 604 */     return this.physics.getHeight() * (this.ai.sprite(this)).height;
/*     */   }
/*     */   
/*     */   public short divSpot() {
/* 608 */     return (short)STATS.BATTLE().position(indu());
/*     */   }
/*     */ 
/*     */   
/*     */   public int dayRan() {
/* 613 */     return this.dayRan;
/*     */   }
/*     */   
/*     */   public Noble noble() {
/* 617 */     if (this.nobleI == -1) {
/* 618 */       return null;
/*     */     }
/* 620 */     return (Noble)GAME.NOBLE().ALL().get(this.nobleI);
/*     */   }
/*     */   
/*     */   public void nobleSet() {
/* 624 */     if (noble() != null)
/* 625 */       throw new RuntimeException(); 
/* 626 */     HTypeSet(HTYPES.NOBILITY(), CAUSE_LEAVES.OTHER(), (CAUSE_ARRIVE)null);
/* 627 */     this.nobleI = GAME.NOBLE().assignOnlyCallFromHumanoid(this);
/*     */   }
/*     */   
/*     */   public void HTypeSet(HTYPE t, CAUSE_LEAVE leave, CAUSE_ARRIVE arr) {
/* 631 */     boolean added = !isRemoved();
/* 632 */     if (added) {
/* 633 */       SETT.ENTITIES().moveIntoTheTheUnknown(this);
/* 634 */       if (noble() != null) {
/* 635 */         GAME.NOBLE().vacateOnlyCallFromHumanoid(this, this.nobleI);
/*     */       }
/*     */     } 
/*     */     
/* 639 */     this.ai.changeType(this, t, leave, arr);
/* 640 */     double m = (BOOSTABLES.PHYSICS()).MASS.get((BOOSTABLE_O)this.induvidual) * RND.rFloat1(0.1D);
/* 641 */     this.physics.setMass((t == HTYPES.CHILD()) ? (m / 2.0D) : m);
/* 642 */     this.speed.accelerationInit(Math.max(0.2D, (BOOSTABLES.PHYSICS()).ACCELERATION.get((BOOSTABLE_O)this.induvidual)) * 64.0D);
/* 643 */     this.speed.magnitudeMaxInit(Math.max(0.2D, (BOOSTABLES.PHYSICS()).SPEED.get((BOOSTABLE_O)this.induvidual)) * 64.0D);
/* 644 */     if (added)
/* 645 */       SETT.ENTITIES().returnFromTheTheUnknown(this); 
/*     */   }
/*     */   
/*     */   public void interrupt() {
/* 649 */     this.ai.overwrite(this, (AI.plans()).NOP);
/*     */   }
/*     */   
/*     */   public void knockOut() {
/* 653 */     this.ai.overwrite(this, (AI.plans()).KNOCKED_OUT);
/*     */   }
/*     */   
/*     */   public CharSequence title() {
/* 657 */     if (noble() != null) {
/* 658 */       return noble().title();
/*     */     }
/* 660 */     if (indu().hType().isWorks()) {
/* 661 */       if ((STATS.WORK()).EMPLOYED.get(indu()) == null)
/* 662 */         return Dic.¤¤Oddjobber; 
/* 663 */       return (((RoomInstance)(STATS.WORK()).EMPLOYED.get(indu())).blueprintI().employment()).title;
/* 664 */     }  if (indu().hType() == HTYPES.PRISONER()) {
/* 665 */       return ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(indu())).title;
/*     */     }
/*     */ 
/*     */     
/* 669 */     return (indu().hType()).name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void target(int amount) {
/* 674 */     this.mark = (byte)(this.mark + amount);
/*     */   }
/*     */   
/*     */   public int targets() {
/* 678 */     return this.mark;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drag(DIR d, int cx, int cy, int fromDist) {
/* 684 */     this.speed.setDirCurrent(d);
/* 685 */     this.physics.body().moveC(cx - fromDist * d.xN(), cy - fromDist * d.yN());
/* 686 */     if (this.physics.body().cX() < 0)
/* 687 */       this.physics.body().moveCX(0.0D); 
/* 688 */     if (this.physics.body().cX() >= SETT.PIXEL_BOUNDS.x2())
/* 689 */       this.physics.body().moveCX((SETT.PIXEL_BOUNDS.x2() - 1)); 
/* 690 */     if (this.physics.body().cY() < 0)
/* 691 */       this.physics.body().moveCY(0.0D); 
/* 692 */     if (this.physics.body().cY() >= SETT.PIXEL_BOUNDS.y2()) {
/* 693 */       this.physics.body().moveCY((SETT.PIXEL_BOUNDS.y2() - 1));
/*     */     }
/* 695 */     if (COORDINATE.tileDistance(cx, cy, body().cX(), body().cY()) > 192.0D) {
/* 696 */       LOG.ln("" + cx + " " + cx + " " + cy);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drag(DIR d, int cx, int cy) {
/* 702 */     drag(d, cx, cy, body().width());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeDragged() {
/* 707 */     return (this.ai.plan() == (AI.plans()).KNOCKED_OUT);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\Humanoid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */