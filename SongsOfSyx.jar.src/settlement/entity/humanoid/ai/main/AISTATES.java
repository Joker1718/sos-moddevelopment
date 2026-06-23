/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ import settlement.thing.DRAGGABLE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AISTATES
/*     */ {
/*     */   public static final double WALK_SPEED = 0.6D;
/*  22 */   public final STOP_DIV STAND_SWORD = new STOP_DIV("STANDS", HSprites.SWORD_STAND);
/*  23 */   public final STOP STAND = new STOP("STAND", HSprites.STAND);
/*  24 */   public final STOP STAND_BABY = new STOP("STAND_BABY", HSprites.STAND_BABY);
/*  25 */   public final MOVE_TOWARDS MOVE_TO = new MOVE_TOWARDS("MOVETO");
/*  26 */   public final PUSH_TOWARDS PUSH_TO = new PUSH_TOWARDS("PUSHTO", HSprites.SWORD_STAND);
/*  27 */   public final WALK WALK = new WALK("WALK", 0.6D);
/*  28 */   public final WALK RUN = new WALK("RUN", 1.0D);
/*  29 */   public final STOP STOP = new STOP("STOP", HSprites.STAND);
/*     */   
/*  31 */   public final WALK_DEST WALK2 = new WALK_DEST("WALK2", 0.6D);
/*  32 */   public final WALK_DEST RUN2 = new WALK_DEST("DEST_RUN", 0.9D);
/*  33 */   public final WALK_DEST DRAG = new WALK_DEST("DRAG", true);
/*  34 */   public final WALK_DEST WALK2_SWORD = new WALK_DEST("WALK2_SWORD", 0.4D, HSprites.SWORD_STAND);
/*  35 */   public final Animation WORK = new Animation("WORK", "working", HSprites.TOOL_HIT);
/*  36 */   public final SLEEP SLEEP = new SLEEP();
/*  37 */   public final Animations anima = new Animations();
/*  38 */   public final AnimationArrays animaArr = new AnimationArrays();
/*  39 */   public final STOP layStop = new STOP("LAYSTOP", HSprites.LAY);
/*  40 */   public final Animation LAY = new Animation("LAY", "laying", HSprites.LAY);
/*  41 */   public final FLY FLY = new FLY("FLY");
/*     */   
/*  43 */   public final WALK jog = new WALK("SPRINT", 0.7D);
/*  44 */   public final WALK jogCrazy = new WALK("SPRINT_CRAZY", 0.7D, HSprites.WAVE);
/*     */   
/*  46 */   public final Sword SWORD = new Sword();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class SLEEP
/*     */   {
/*     */     public AISTATE activate(Humanoid a, AIManager d, float time) {
/*  55 */       d.stateTimer = time;
/*  56 */       a.speed.magnitudeInit(0.0D);
/*  57 */       a.speed.magnitudeTargetSet(0.0D);
/*  58 */       if (!a.speed.dir().isOrtho())
/*  59 */         a.speed.setDirCurrent(a.speed.dir().next(1)); 
/*  60 */       return this.state;
/*     */     }
/*     */     
/*  63 */     private final AISTATE state = new AISTATE("SLEEP", "sleeping")
/*     */       {
/*     */         public HSprite sprite(Humanoid a)
/*     */         {
/*  67 */           return HSprites.SLEEP;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/*  72 */           d.stateTimer = (float)(d.stateTimer - ds);
/*  73 */           if (d.stateTimer <= 0.0F) {
/*  74 */             return false;
/*     */           }
/*  76 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static class WALK
/*     */   {
/*     */     private final double target;
/*     */     
/*     */     private final AISTATE state;
/*     */     
/*     */     public WALK(String key, double target) {
/*  89 */       this(key, target, HSprites.MOVE);
/*     */     }
/*     */     
/*     */     public WALK(String key, double target, final HSprite sprite) {
/*  93 */       this.target = target;
/*  94 */       this.state = new AISTATE(key, "walking")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/*  98 */             return sprite;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 103 */             a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/*     */             
/* 105 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 106 */             return (d.stateTimer > 0.0F);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d, double time) {
/* 114 */       d.stateTimer = (float)time;
/* 115 */       a.speed.magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 116 */       return this.state;
/*     */     }
/*     */     
/*     */     AISTATE activate(Humanoid a, AIManager d, float time, float x, float y) {
/* 120 */       a.speed.turn2(x, y).magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 121 */       return activate(a, d, time);
/*     */     }
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d, float time, ENTITY other) {
/* 125 */       a.speed.turn2(a.body(), other.body()).magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 126 */       return activate(a, d, time);
/*     */     }
/*     */     
/*     */     public AISTATE activateFRom(Humanoid a, AIManager d, float time, ENTITY other) {
/* 130 */       a.speed.turn2(other.body(), a.body()).magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 131 */       return activate(a, d, time);
/*     */     }
/*     */     
/*     */     AISTATE activate(Humanoid a, AIManager d, float time, double deg) {
/* 135 */       a.speed.turnWithAngel(deg);
/* 136 */       a.speed.magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 137 */       return activate(a, d, time);
/*     */     }
/*     */     
/*     */     AISTATE activateRND(Humanoid a, AIManager d, float time) {
/* 141 */       a.speed.turnRandom();
/* 142 */       a.speed.magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 143 */       return activate(a, d, time);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class STOP
/*     */   {
/*     */     public final AISTATE state;
/*     */ 
/*     */ 
/*     */     
/*     */     public STOP(String key, final HSprite s) {
/* 156 */       this.state = new AISTATE(key, "stopping")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/* 160 */             return (a.speed.magnitude() >= a.speed.magintudeMax()) ? HSprites.LAY : s;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 166 */             if (a.speed.isZero()) {
/* 167 */               d.stateTimer = (float)(d.stateTimer - ds);
/* 168 */               return (d.stateTimer > 0.0F);
/*     */             } 
/* 170 */             a.speed.brake(ds);
/* 171 */             return true;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d) {
/* 178 */       d.stateTimer = 0.1F;
/* 179 */       a.speed.magnitudeTargetSet(0.0D);
/*     */       
/* 181 */       return this.state;
/*     */     }
/*     */     
/*     */     public AISTATE instant(Humanoid a, AIManager d) {
/* 185 */       a.speed.magnitudeInit(0.0D);
/* 186 */       a.speed.magnitudeTargetSet(0.0D);
/*     */       
/* 188 */       d.stateTimer = 0.1F;
/* 189 */       return this.state;
/*     */     }
/*     */     
/*     */     public AISTATE aDirRND(Humanoid a, AIManager d, float time) {
/* 193 */       a.speed.turnRandom();
/* 194 */       d.stateTimer = time;
/* 195 */       a.speed.magnitudeTargetSet(0.0D);
/*     */       
/* 197 */       return this.state;
/*     */     }
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d, double time) {
/* 201 */       d.stateTimer = (float)time;
/* 202 */       a.speed.magnitudeTargetSet(0.0D);
/*     */       
/* 204 */       return this.state;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class STOP_DIV
/*     */   {
/*     */     private final AISTATE state;
/*     */     
/* 214 */     private final double max = 65536.0D;
/*     */     
/*     */     public STOP_DIV(String key, final HSprite s) {
/* 217 */       this.state = new AISTATE(key, "stopping div")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/* 221 */             return (a.speed.magnitude() >= a.speed.magintudeMax()) ? HSprites.LAY : s;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 227 */             if (a.speed.isZero()) {
/* 228 */               d.stateTimer = (float)(d.stateTimer - ds);
/* 229 */               return (d.stateTimer > 0.0F);
/*     */             } 
/*     */             
/* 232 */             if (!AISTATES.STOP_DIV.this.goingTowardsDiv(a, d))
/* 233 */               a.speed.brake(ds); 
/* 234 */             return true;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean goingTowardsDiv(Humanoid a, AIManager d) {
/* 241 */       Div div = a.division();
/* 242 */       if (div != null)
/*     */       {
/* 244 */         if (div.reporter.posHas(a)) {
/* 245 */           COORDINATE dest = div.reporter.getPixel(a);
/* 246 */           double dx = (dest.x() - a.body().cX());
/* 247 */           double dy = (dest.y() - a.body().cY());
/*     */ 
/*     */ 
/*     */           
/* 251 */           if (dx * dx + dy * dy < 65536.0D && 
/* 252 */             dx * a.speed.nX() >= 0.0D && dy * a.speed.nY() >= 0.0D) {
/* 253 */             return true;
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 258 */       return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d, double time) {
/* 285 */       d.stateTimer = (float)time;
/* 286 */       a.speed.magnitudeTargetSet(0.0D);
/*     */       
/* 288 */       return this.state;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class FLY
/*     */   {
/*     */     private final AISTATE state;
/*     */ 
/*     */     
/*     */     private FLY(String key) {
/* 300 */       this.state = new AISTATE(key, "flying")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/* 304 */             return HSprites.LAY;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 309 */             a.physics.setHeightOverGround(a.physics.getZ() + ds * d.stateTimer * 64.0D);
/* 310 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 311 */             if (a.physics.getZ() < 0.0D) {
/* 312 */               a.physics.setHeightOverGround(0.0D);
/* 313 */               return false;
/*     */             } 
/* 315 */             return true;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d, float seconds) {
/* 322 */       d.stateTimer = seconds / 2.0F;
/* 323 */       return this.state;
/*     */     }
/*     */     
/*     */     public AISTATE add(Humanoid a, AIManager d, float seconds) {
/* 327 */       d.stateTimer += seconds / 2.0F;
/* 328 */       return this.state;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class MOVE_TOWARDS
/*     */   {
/*     */     private final AISTATE state;
/*     */     
/*     */     private MOVE_TOWARDS(String key) {
/* 338 */       this(key, HSprites.MOVE);
/*     */     }
/*     */     
/*     */     public MOVE_TOWARDS(String key, final HSprite sprite) {
/* 342 */       this.state = new AISTATE(key, "walking")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/* 346 */             return sprite;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 351 */             a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 352 */             float dx = d.X - a.body().cX();
/* 353 */             float dy = d.Y - a.body().cY();
/*     */             
/* 355 */             if (dx * a.speed.nX() < 0.0D || dy * a.speed.nY() < 0.0D) {
/* 356 */               a.physics.body().moveC(d.X, d.Y);
/* 357 */               return false;
/* 358 */             }  if (dx == 0.0F && dy == 0.0F) {
/* 359 */               return false;
/*     */             }
/* 361 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 362 */             if (d.stateTimer <= 0.0F) {
/* 363 */               return false;
/*     */             }
/* 365 */             return true;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE move(Humanoid a, AIManager d, int destX, int destY, double time, double speed) {
/* 372 */       d.X = destX;
/* 373 */       d.Y = destY;
/* 374 */       if (d.X != a.physics.body().cX() || d.Y != a.physics.body().cY()) {
/* 375 */         a.speed.turn2((BODY_HOLDER)a, d.X, d.Y).magnitudeTargetSetPrecise(speed);
/*     */       } else {
/*     */         
/* 378 */         a.speed.magnitudeTargetSet(0.0D);
/* 379 */         a.speed.magnitudeInit(0.0D);
/*     */       } 
/* 381 */       d.stateTimer = (float)time;
/* 382 */       return this.state;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class PUSH_TOWARDS
/*     */   {
/*     */     private final AISTATE state;
/*     */     
/*     */     public PUSH_TOWARDS(String key, final HSprite sprite) {
/* 392 */       this.state = new AISTATE(key, "pushing")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/* 396 */             return sprite;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 402 */             double dx = (d.X - a.body().cX());
/* 403 */             double dy = (d.Y - a.body().cY());
/* 404 */             if (ds == 0.0D) {
/* 405 */               return true;
/*     */             }
/* 407 */             if (dx == 0.0D && dy == 0.0D) {
/* 408 */               return false;
/*     */             }
/* 410 */             double nx = a.speed.x();
/* 411 */             double ny = a.speed.y();
/* 412 */             double mag = a.speed.magnitude();
/* 413 */             if (mag > 0.0D && (dx * nx < 0.0D || dy * ny < 0.0D)) {
/* 414 */               double m = mag - ds * (256.0D + a.speed.magnitude() * 0.1D);
/* 415 */               if (m < 0.0D) {
/* 416 */                 m = 0.0D;
/* 417 */                 a.speed.turn2(dx, dy);
/*     */               } 
/* 419 */               a.speed.magnitudeInit(m);
/* 420 */               a.speed.setDirCurrent(DIR.get(dx, dy));
/* 421 */               a.speed.setPrevDir();
/*     */             } else {
/* 423 */               if (same(dx, nx) != same(dy, ny)) {
/* 424 */                 a.speed.setPrevDir();
/* 425 */                 a.speed.turn2(dx, dy);
/*     */               } 
/*     */               
/* 428 */               a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/*     */               
/* 430 */               double ddx = (a.body().cX() - d.X);
/* 431 */               double ddy = (a.body().cY() - d.Y);
/*     */               
/* 433 */               if (ddx * (ddx + Math.ceil(a.speed.x() * ds)) < 0.0D || ddy * (ddy + Math.ceil(a.speed.y() * ds)) < 0.0D) {
/* 434 */                 a.physics.body().moveC(d.X, d.Y);
/* 435 */                 return false;
/*     */               } 
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 442 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 443 */             return (d.stateTimer > 0.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           private double same(double dx, double sx) {
/* 448 */             if (dx == sx)
/* 449 */               return 1.0D; 
/* 450 */             if (dx == 0.0D) {
/* 451 */               return ((sx == 0.0D) ? true : false);
/*     */             }
/* 453 */             return dx / sx;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public AISTATE move(Humanoid a, AIManager d, int destX, int destY, double time, double speed) {
/* 460 */       d.X = destX;
/* 461 */       d.Y = destY;
/* 462 */       a.speed.magnitudeTargetSet(speed);
/* 463 */       d.stateTimer = (float)time;
/* 464 */       return this.state;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class WALK_DEST
/*     */   {
/*     */     private final AISTATE state;
/*     */     private final double speed;
/*     */     
/*     */     public WALK_DEST(String key, double speed, final HSprite sprite) {
/* 475 */       this.speed = speed;
/*     */       
/* 477 */       this.state = new AISTATE(key, "walking")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/* 481 */             return sprite;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 486 */             a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 487 */             float dx = d.X - a.body().cX();
/* 488 */             float dy = d.Y - a.body().cY();
/*     */             
/* 490 */             if (dx * a.speed.nX() < 0.0D || dy * a.speed.nY() < 0.0D) {
/* 491 */               a.physics.body().moveC(d.X, d.Y);
/* 492 */               return false;
/* 493 */             }  if (dx == 0.0F && dy == 0.0F) {
/* 494 */               return false;
/*     */             }
/* 496 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 497 */             if (d.stateTimer <= 0.0F) {
/* 498 */               LOG.ln("" + ds + " " + ds + " " + String.valueOf(a.tc()) + " " + a.body().cX() + " " + d.X + " " + a.speed.nX() + " " + a.speed.magnitude() + " " + a.speed.magintudeMax());
/* 499 */               d.debug(a, "strange");
/*     */ 
/*     */               
/* 502 */               d.stateTimer = 10.0F;
/* 503 */               a.physics.body().moveC(d.X, d.Y);
/* 504 */               return false;
/*     */             } 
/* 506 */             return true;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     private WALK_DEST(String key, double speed) {
/* 513 */       this(key, speed, HSprites.MOVE);
/*     */     }
/*     */     
/*     */     private WALK_DEST(String key, boolean shittycoding) {
/* 517 */       this.speed = 0.3D;
/* 518 */       this.state = new AISTATE(key, "dragging")
/*     */         {
/*     */           public HSprite sprite(Humanoid a)
/*     */           {
/* 522 */             return HSprites.DRAG;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean update(Humanoid a, AIManager d, double ds) {
/* 527 */             a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/* 528 */             float dx = d.X - a.body().cX();
/* 529 */             float dy = d.Y - a.body().cY();
/*     */             
/* 531 */             if (dx * a.speed.nX() < 0.0D || dy * a.speed.nY() < 0.0D) {
/* 532 */               a.physics.body().moveC(d.X, d.Y);
/* 533 */               return false;
/* 534 */             }  if (dx == 0.0F && dy == 0.0F) {
/* 535 */               return false;
/*     */             }
/* 537 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 538 */             if (d.stateTimer <= 0.0F) {
/* 539 */               GAME.Notify("" + a.speed.magnitude() + " " + a.speed.magnitude() + " " + String.valueOf(a.physics.tileC()) + " " + String.valueOf(d.path) + " " + a.speed.nX());
/*     */               
/* 541 */               d.stateTimer = 48.0F;
/*     */             } 
/* 543 */             DRAGGABLE c = ((DRAGGABLE.DRAGGABLE_HOLDER)DRAGGABLE.DRAGGABLE_HOLDER.all().get(d.subPathByte)).draggable(d.planObject);
/* 544 */             if (c != null) {
/* 545 */               if (c.canBeDragged())
/* 546 */                 c.drag(a.speed.dir(), a.physics.body().cX(), a.physics.body().cY(), a.physics.body().width() << 1); 
/*     */             } else {
/* 548 */               d.debug(a, "draggable has mysteriously dissapeared!");
/*     */             } 
/*     */ 
/*     */             
/* 552 */             return true;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean cTileNeeds(Humanoid a, AIManager d) {
/* 559 */       int x2 = (a.physics.tileC().x() << 6) + 32;
/* 560 */       int y2 = (a.physics.tileC().y() << 6) + 32;
/*     */       
/* 562 */       if (x2 != a.physics.body().cX() || y2 != a.physics.body().cY()) {
/* 563 */         return true;
/*     */       }
/*     */       
/* 566 */       return false;
/*     */     }
/*     */     
/*     */     public AISTATE cTile(Humanoid a, AIManager d) {
/* 570 */       int x2 = (a.physics.tileC().x() << 6) + 32;
/* 571 */       int y2 = (a.physics.tileC().y() << 6) + 32;
/* 572 */       return free(a, d, x2, y2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AISTATE path(Humanoid a, AIManager d) {
/* 597 */       int x2 = d.path.getSettCX();
/* 598 */       int y2 = d.path.getSettCY();
/*     */       
/* 600 */       if (x2 == a.physics.body().cX() && y2 == a.physics.body().cY()) {
/* 601 */         return free(a, d, a.physics.body().cX(), a.physics.body().cY());
/*     */       }
/* 603 */       if (a.physics.tileC().isSameAs((COORDINATE)d.path) && a.physics.isWithinTile()) {
/* 604 */         return free(a, d, a.physics.body().cX(), a.physics.body().cY());
/*     */       }
/*     */       
/* 607 */       a.speed.turn2((BODY_HOLDER)a, x2, y2);
/* 608 */       double dy = Math.max(
/* 609 */           a.body().y2() + 2 - (d.path.y() + 1) * 64, 
/* 610 */           d.path.y() * 64 - a.body().y1() - 2) / 
/* 611 */         Math.abs(a.speed.nY());
/* 612 */       double dx = Math.max(
/* 613 */           a.body().x2() + 2 - (d.path.x() + 1) * 64, 
/* 614 */           d.path.x() * 64 - a.body().x1() - 2) / 
/* 615 */         Math.abs(a.speed.nX());
/*     */       
/* 617 */       if (dx > dy) {
/* 618 */         x2 = (int)(a.physics.body().cX() + a.speed.nX() * dx);
/* 619 */         y2 = (int)(a.physics.body().cY() + a.speed.nY() * dx);
/*     */       } else {
/* 621 */         x2 = (int)(a.physics.body().cX() + a.speed.nX() * dy);
/* 622 */         y2 = (int)(a.physics.body().cY() + a.speed.nY() * dy);
/*     */       } 
/* 624 */       d.X = x2;
/* 625 */       d.Y = y2;
/* 626 */       a.speed.turn2((BODY_HOLDER)a, x2, y2);
/* 627 */       a.speed.magnitudeTargetSet(this.speed + RND.rFloat(0.05D));
/* 628 */       d.stateTimer = 48.0F;
/* 629 */       return this.state;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AISTATE edge(Humanoid a, AIManager d, DIR dir) {
/* 637 */       int dd = (64 - a.body().width() - 1) / 2;
/*     */       
/* 639 */       int x2 = a.physics.tileC().x() * 64 + 32 + dir.x() * dd;
/* 640 */       int y2 = a.physics.tileC().y() * 64 + 32 + dir.y() * dd;
/*     */       
/* 642 */       if (x2 == a.physics.body().cX() && y2 == a.physics.body().cY()) {
/* 643 */         return free(a, d, a.physics.body().cX(), a.physics.body().cY());
/*     */       }
/* 645 */       if (!a.physics.isWithinTile()) {
/* 646 */         return cTile(a, d);
/*     */       }
/*     */       
/* 649 */       free(a, d, x2, y2);
/* 650 */       a.speed.magnitudeTargetSet(0.2D);
/* 651 */       d.stateTimer = 48.0F;
/* 652 */       return this.state;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AISTATE moveToEdge(Humanoid a, AIManager d, DIR dir) {
/* 660 */       int x2 = a.tc().x() * 64 + 32;
/* 661 */       int y2 = a.tc().y() * 64 + 32;
/* 662 */       int dd = (64 - a.body().width() - 2) / 2;
/* 663 */       x2 += dir.x() * dd;
/* 664 */       y2 += dir.y() * dd;
/*     */       
/* 666 */       return free(a, d, x2, y2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AISTATE dirTile(Humanoid a, AIManager d, DIR dir) {
/* 673 */       int x2 = (a.physics.tileC().x() << 6) + 32;
/* 674 */       int y2 = (a.physics.tileC().y() << 6) + 32;
/* 675 */       x2 += dir.x() * 64;
/* 676 */       y2 += dir.y() * 64;
/* 677 */       return free(a, d, x2, y2);
/*     */     }
/*     */     
/*     */     public AISTATE free(Humanoid a, AIManager d, int x2, int y2) {
/* 681 */       d.X = x2;
/* 682 */       d.Y = y2;
/* 683 */       if (x2 != a.physics.body().cX() || y2 != a.physics.body().cY()) {
/* 684 */         a.speed.turn2((BODY_HOLDER)a, x2, y2).magnitudeTargetSet(this.speed + RND.rFloat(0.05D));
/*     */       }
/*     */       else {
/*     */         
/* 688 */         a.speed.magnitudeTargetSet(0.0D);
/* 689 */         a.speed.magnitudeInit(0.0D);
/*     */       } 
/* 691 */       d.stateTimer = 48.0F;
/* 692 */       return this.state;
/*     */     }
/*     */     
/*     */     public AISTATE tile(Humanoid a, AIManager d, int tx, int ty) {
/* 696 */       int x2 = (tx << 6) + 32;
/* 697 */       int y2 = (ty << 6) + 32;
/* 698 */       d.X = x2;
/* 699 */       d.Y = y2;
/* 700 */       if (x2 != a.physics.body().cX() || y2 != a.physics.body().cY()) {
/* 701 */         a.speed.turn2((BODY_HOLDER)a, x2, y2).magnitudeTargetSet(this.speed + RND.rFloat(0.05D));
/*     */       } else {
/*     */         
/* 704 */         a.speed.magnitudeTargetSet(0.0D);
/* 705 */         a.speed.magnitudeInit(0.0D);
/*     */       } 
/* 707 */       d.stateTimer = 48.0F;
/* 708 */       return this.state;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final class Animations
/*     */   {
/* 719 */     public final AISTATES.Animation work = new AISTATES.Animation("A1", "Working", HSprites.TOOL_HIT);
/* 720 */     public final AISTATES.Animation box = new AISTATES.Animation("A2", "box", HSprites.GRAB);
/* 721 */     public final AISTATES.Animation wave = new AISTATES.Animation("A3", "waiving", HSprites.WAVE);
/* 722 */     public final AISTATES.Animation throww = new AISTATES.Animation("A4", "throw", HSprites.THROW);
/* 723 */     public final AISTATES.Animation stand = new AISTATES.Animation("A5", "waiving", HSprites.STAND);
/* 724 */     public final AISTATES.Animation grab = new AISTATES.Animation("A6", "grabbing", HSprites.BOX);
/* 725 */     public final AISTATES.Animation fist = new AISTATES.Animation("A7", "shaking fist", HSprites.FIST);
/* 726 */     public final AISTATES.Animation fistRight = new AISTATES.Animation("A8", "shaking fist", HSprites.ARM_RIGHT);
/* 727 */     public final AISTATES.Animation fistLeft = new AISTATES.Animation("A9", "shaking fist", HSprites.ARM_LEFT);
/* 728 */     public final AISTATES.Animation dance = new AISTATES.Animation("A10", "shaking fist", HSprites.DANCE);
/* 729 */     public final AISTATES.Animation danceE = new AISTATES.Animation("A11", "shaking fist", HSprites.DANCE_EXTRA);
/* 730 */     public final AISTATES.Animation sword = new AISTATES.Animation("A12", "bracing", HSprites.SWORD_STAND);
/* 731 */     public final AISTATES.Animation stab = new AISTATES.Animation("A13", "stab", HSprites.SWORD_STAB);
/* 732 */     public final AISTATES.Animation sword_out = new AISTATES.Animation("A14", "bracing", HSprites.SWORD_OUT);
/* 733 */     public final AISTATES.Animation sword_in = new AISTATES.Animation("A15", "bracing", HSprites.SWORD_IN);
/* 734 */     public final AISTATES.Animation lay = new AISTATES.Animation("A16", "laying", HSprites.LAY);
/* 735 */     public final AISTATES.Animation carry = new AISTATES.Animation("A17", "carry", HSprites.CARRY);
/* 736 */     public final AISTATES.Animation armsOut = new AISTATES.Animation("A18", "carry", HSprites.ARMS_OUT);
/* 737 */     public final AISTATES.Animation layoff = new AISTATES.Animation("A19", "laying", HSprites.LAYOFF);
/* 738 */     public final AISTATES.Animation archer0 = new AISTATES.Animation("A20", "archer", HSprites.ARCHER2);
/* 739 */     public final AISTATES.Animation archer1 = new AISTATES.Animation("A21", "archer", HSprites.ARCHER3);
/* 740 */     public final AISTATES.Animation archer2 = new AISTATES.Animation("A22", "archer", HSprites.ARCHER4);
/* 741 */     public final AISTATES.Animation strangle = new AISTATES.Animation("A23", "strangle", HSprites.STRANGLED);
/* 742 */     public final AISTATES.Animation toolSlam = new AISTATES.Animation("W_TOOL", "working", HSprites.TOOL_HIT);
/* 743 */     public final AISTATES.Animation toolBack = new AISTATES.Animation("W_TOOL_BACK", "working", HSprites.TOOL_BACK);
/*     */   }
/*     */ 
/*     */   
/*     */   public final class AnimationArrays
/*     */   {
/*     */     private final AISTATES.Animation[] speak;
/*     */     
/*     */     private final AISTATES.Animation[] dance;
/*     */     private final AISTATES.Animation[] lecture;
/*     */     
/*     */     private AnimationArrays() {
/* 755 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 761 */         .speak = new AISTATES.Animation[] { this$0.anima.carry, this$0.anima.fist, this$0.anima.grab, this$0.anima.fistRight, this$0.anima.fistRight, this$0.anima.fistRight };
/*     */       
/* 763 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 774 */         .dance = new AISTATES.Animation[] { this$0.anima.carry, this$0.anima.fist, this$0.anima.grab, this$0.anima.fistRight, this$0.anima.fistLeft, this$0.anima.dance, this$0.anima.dance, this$0.anima.dance, this$0.anima.danceE, this$0.anima.danceE, this$0.anima.danceE };
/*     */       
/* 776 */       this
/*     */ 
/*     */ 
/*     */         
/* 780 */         .lecture = new AISTATES.Animation[] { this$0.anima.box, this$0.anima.fist, this$0.anima.grab, this$0.anima.wave };
/*     */     }
/*     */     
/*     */     public AISTATES.Animation speak() {
/* 784 */       return get(this.speak);
/*     */     }
/*     */     
/*     */     public AISTATES.Animation dance() {
/* 788 */       return get(this.dance);
/*     */     }
/*     */     
/*     */     public AISTATES.Animation lecture() {
/* 792 */       return get(this.lecture);
/*     */     }
/*     */     
/*     */     public AISTATES.Animation get(AISTATES.Animation[] as) {
/* 796 */       return as[RND.rInt(as.length)];
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class Animation
/*     */   {
/*     */     final AISTATE state;
/*     */     public final double time;
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d, double time) {
/* 806 */       a.spriteTimer = 0.0F;
/* 807 */       d.stateTimer = (float)time;
/* 808 */       return this.state;
/*     */     }
/*     */     
/*     */     public AISTATE resume(Humanoid a, AIManager d, double time) {
/* 812 */       d.stateTimer = (float)time;
/* 813 */       return this.state;
/*     */     }
/*     */     
/*     */     public AISTATE activate(Humanoid a, AIManager d) {
/* 817 */       a.spriteTimer = 0.0F;
/* 818 */       d.stateTimer = (float)(this.state.sprite(a)).time;
/* 819 */       return this.state;
/*     */     }
/*     */ 
/*     */     
/*     */     public Animation(String key, String name, final HSprite sprite) {
/* 824 */       this.state = new AISTATE(key, name)
/*     */         {
/*     */           public boolean update(Humanoid a, AIManager d, double ds)
/*     */           {
/* 828 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 829 */             return (d.stateTimer >= 0.0F);
/*     */           }
/*     */ 
/*     */           
/*     */           public HSprite sprite(Humanoid a) {
/* 834 */             return sprite;
/*     */           }
/*     */         };
/*     */       
/* 838 */       this.time = sprite.time;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Sword
/*     */   {
/* 849 */     public final AISTATES.STOP STOP_SWORD = new AISTATES.STOP("SF_STAND", HSprites.SWORD_STAND);
/* 850 */     public final AISTATES.WALK RUN = new AISTATES.WALK("SF_RUN", 0.9D, HSprites.SWORD_STAND);
/* 851 */     public final AISTATES.WALK WALK = new AISTATES.WALK("SF_WALK", 0.2D, HSprites.SWORD_STAND);
/* 852 */     public final AISTATE strike = new AISTATE.Custom("SF_STRIKE", "striking", HSprites.SWORD_OUT)
/*     */       {
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 855 */           a.speed.magnitudeAdjust(ds, 1.5D, 1.0D);
/* 856 */           d.stateTimer = (float)(d.stateTimer - ds);
/* 857 */           return (d.stateTimer > 0.0F);
/*     */         }
/*     */       };
/* 860 */     public final AISTATE strikeIn = new AISTATE.Custom("SF_STRIKE2", "striking", HSprites.SWORD_IN)
/*     */       {
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 863 */           a.speed.magnitudeAdjust(ds, 1.5D, 1.0D);
/* 864 */           d.stateTimer = (float)(d.stateTimer - ds);
/* 865 */           return (d.stateTimer > 0.0F);
/*     */         }
/*     */       };
/* 868 */     public final AISTATE backup = new AISTATE.Custom("SF_BACKUP", "backing up", HSprites.SWORD_STAND)
/*     */       {
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 871 */           a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/*     */           
/* 873 */           d.stateTimer = (float)(d.stateTimer - ds);
/* 874 */           return (d.stateTimer > 0.0F);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */