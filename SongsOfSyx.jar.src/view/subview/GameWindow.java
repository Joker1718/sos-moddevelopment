/*     */ package view.subview;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import snake2d.MButt;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_SETTER;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameWindow
/*     */ {
/*     */   private final RECTANGLE gameMax;
/*  24 */   private final Rec max = new Rec();
/*     */   private final Rec viewWindowDefault;
/*     */   private final Rec viewWindow;
/*     */   private final Pixels pixels;
/*  28 */   private final Pixels2 pixels2 = new Pixels2();
/*  29 */   private int maxZoomOut = 2;
/*     */   private boolean dragging = false;
/*  31 */   private int dragX = -1;
/*  32 */   private int dragY = -1;
/*  33 */   private int dragCX = -1;
/*  34 */   private int dragCY = -1;
/*     */   
/*     */   private boolean hovered;
/*  37 */   private final SubMouse pixel = new SubMouse(this)
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       private boolean hasMoved = true;
/*  41 */       private Coo relative = new Coo();
/*     */ 
/*     */       
/*     */       protected void update() {
/*  45 */         this.relative.set((VIEW.mouse().x() << GameWindow.this.zoomout), (VIEW.mouse().y() << GameWindow.this.zoomout));
/*  46 */         int x = VIEW.mouse().x() - GameWindow.this.viewWindow.x1();
/*  47 */         int y = VIEW.mouse().y() - GameWindow.this.viewWindow.y1();
/*     */         
/*  49 */         x = GameWindow.this.pixels.x1() + (x << GameWindow.this.zoomout);
/*  50 */         y = GameWindow.this.pixels.y1() + (y << GameWindow.this.zoomout);
/*     */         
/*  52 */         if (y >= GameWindow.this.max.height()) {
/*  53 */           y = GameWindow.this.max.height() - 1;
/*     */         }
/*  55 */         if (x >= GameWindow.this.max.width())
/*  56 */           x = GameWindow.this.max.width() - 1; 
/*  57 */         if (x < 0)
/*  58 */           x = 0; 
/*  59 */         if (y < 0)
/*  60 */           y = 0; 
/*  61 */         this.hasMoved = set(x, y);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean hasMoved() {
/*  67 */         return this.hasMoved;
/*     */       }
/*     */ 
/*     */       
/*     */       public COORDINATE rel() {
/*  72 */         return (COORDINATE)this.relative;
/*     */       }
/*     */     };
/*  75 */   private final SubMouse tile = new SubMouse(this)
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */       private boolean hasMoved = true;
/*  79 */       private Coo relative = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected void update() {
/*  86 */         int x = GameWindow.this.pixel.x() >> 6;
/*  87 */         int y = GameWindow.this.pixel.y() >> 6;
/*  88 */         this.hasMoved = set(x, y);
/*     */         
/*  90 */         int relX = (GameWindow.this.pixel.x() & 0xFFFFFFC0) - GameWindow.this.pixels.x1() + (GameWindow.this.viewWindow.x1() << GameWindow.this.zoomout);
/*  91 */         int relY = (GameWindow.this.pixel.y() & 0xFFFFFFC0) - GameWindow.this.pixels.y1() + (GameWindow.this.viewWindow.y1() << GameWindow.this.zoomout);
/*     */         
/*  93 */         this.relative.set(relX, relY);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean hasMoved() {
/* 100 */         return this.hasMoved;
/*     */       }
/*     */ 
/*     */       
/*     */       public COORDINATE rel() {
/* 105 */         return (COORDINATE)this.relative;
/*     */       }
/*     */     };
/*     */   
/*     */   private final Rec tiles;
/*     */   private static final double maxSpeed = 2048.0D;
/*     */   private static final double accD = 3072.0D;
/* 112 */   private Coo speed = new Coo();
/* 113 */   private Coo acc = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int zoomout;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean hasZoomedOutMore;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_SETTER centerer;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_SETTER centererTile;
/*     */ 
/*     */ 
/*     */   
/*     */   public SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rec viewWindow() {
/* 143 */     return this.viewWindow;
/*     */   }
/*     */   
/*     */   public GameWindow(RECTANGLE abs, RECTANGLE gameMax, int outMargin) {
/* 147 */     this(0, abs, gameMax, outMargin);
/*     */   }
/*     */   
/*     */   public GameWindow setzoomoutMax(int max) {
/* 151 */     this.maxZoomOut = max;
/* 152 */     setZoomout(this.zoomout);
/* 153 */     return this;
/*     */   }
/*     */   
/*     */   public int zoomoutmax() {
/* 157 */     return this.maxZoomOut;
/*     */   }
/*     */   
/*     */   public void crop(RECTANGLE rec) {
/* 161 */     int moveX = rec.x1() - this.viewWindow.x1();
/* 162 */     int moveY = rec.y1() - this.viewWindow.y1();
/* 163 */     this.pixels.incr((moveX << this.zoomout), (moveY << this.zoomout));
/* 164 */     this.viewWindow.setWidth(rec.width());
/* 165 */     this.viewWindow.setHeight(rec.height());
/* 166 */     this.viewWindow.moveX1Y1(rec.x1(), rec.y1());
/* 167 */     update(0.0F);
/*     */   }
/*     */   
/*     */   public void uncrop() {
/* 171 */     crop((RECTANGLE)this.viewWindowDefault);
/*     */   }
/*     */   
/*     */   public boolean hasZoomedOutMoreandConsumeThatMotherFZoom() {
/* 175 */     boolean ret = this.hasZoomedOutMore;
/* 176 */     this.hasZoomedOutMore = false;
/* 177 */     return ret;
/*     */   }
/*     */   
/*     */   public GameWindow setZoomout(int pow2) {
/* 181 */     int old = this.zoomout;
/* 182 */     this.zoomout = pow2;
/* 183 */     if (this.zoomout > this.maxZoomOut) {
/* 184 */       this.hasZoomedOutMore = true;
/* 185 */       this.zoomout = this.maxZoomOut;
/*     */     } 
/* 187 */     if (this.zoomout < 0) {
/* 188 */       this.zoomout = 0;
/*     */     }
/* 190 */     int dx = this.viewWindow.width() - 2 << this.zoomout;
/* 191 */     int dy = this.viewWindow.height() - 2 << this.zoomout;
/*     */     
/* 193 */     this.max.set(-dx, (this.gameMax.width() + dx), -dy, (this.gameMax.height() + dy));
/*     */ 
/*     */ 
/*     */     
/* 197 */     int cx = this.pixels.cX();
/* 198 */     int cy = this.pixels.cY();
/* 199 */     this.pixels.update();
/* 200 */     this.pixels.moveC(cx, cy);
/* 201 */     if (old != this.zoomout) {
/* 202 */       double s = (this.zoomout + 1) / (old + 1);
/* 203 */       this.speed.scale(s, s);
/*     */     } 
/*     */     
/* 206 */     update(0.0F);
/* 207 */     return this;
/*     */   }
/*     */   
/*     */   public GameWindow zoomInc() {
/* 211 */     return setZoomout(this.zoomout + 1);
/*     */   }
/*     */   
/*     */   public GameWindow zoomInc(int delta) {
/* 215 */     return setZoomout(this.zoomout + delta);
/*     */   }
/*     */   
/*     */   public int zoomout() {
/* 219 */     return this.zoomout;
/*     */   }
/*     */   
/*     */   public void setFromOther(GameWindow c) {
/* 223 */     int px = c.pixel().x();
/* 224 */     int py = c.pixel().y();
/* 225 */     this.pixel.update();
/*     */ 
/*     */     
/* 228 */     int dx = px - this.pixel.x();
/* 229 */     int dy = py - this.pixel.y();
/*     */     
/* 231 */     this.pixels.incr(dx, dy);
/* 232 */     update(0.0F);
/*     */   }
/*     */   
/*     */   public void hover() {
/* 236 */     this.hovered = true;
/* 237 */     if (!(KEYS.MAIN()).MOD.isPressed()) {
/* 238 */       double s = MButt.peekWheel();
/* 239 */       if (s != 0.0D) {
/* 240 */         int z = zoomout();
/* 241 */         int d = (s < 0.0D) ? 1 : -1;
/* 242 */         zoomByMouse(this.zoomout + d);
/*     */         
/* 244 */         if (z != zoomout())
/* 245 */           MButt.clearWheelSpin(); 
/*     */       } 
/*     */     } 
/* 248 */     if (!this.dragging && MButt.WHEEL.consumeClick()) {
/* 249 */       this.dragX = VIEW.mouse().x();
/* 250 */       this.dragY = VIEW.mouse().y();
/* 251 */       this.dragCX = this.pixels.cX();
/* 252 */       this.dragCY = this.pixels.cY();
/* 253 */       this.dragging = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void zoomByMouse(int z) {
/* 258 */     int zold = zoomout();
/* 259 */     int px = pixel().x();
/* 260 */     int py = pixel().y();
/* 261 */     int dx = px - this.pixels.x1() >> zoomout();
/* 262 */     int dy = py - this.pixels.y1() >> zoomout();
/*     */     
/* 264 */     setZoomout(z);
/*     */     
/* 266 */     if (zold != zoomout()) {
/* 267 */       this.pixels.moveX1Y1((px - (dx << zoomout())), (py - (dy << zoomout())));
/* 268 */       update(0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean consumeHover() {
/* 274 */     boolean h = this.hovered;
/* 275 */     this.hovered = false;
/* 276 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(float ds) {
/* 286 */     if ((VIEW.UI()).manager.open()) {
/*     */       return;
/*     */     }
/* 289 */     if ((KEYS.MAIN()).ZOOM_IN.consumeClick()) {
/* 290 */       setZoomout(this.zoomout - 1);
/*     */     }
/* 292 */     if ((KEYS.MAIN()).ZOOM_OUT.consumeClick()) {
/* 293 */       setZoomout(this.zoomout + 1);
/*     */     }
/*     */     
/* 296 */     double maxy = 1.0D;
/*     */     
/* 298 */     double accD = 3072.0D * (1 << this.zoomout);
/* 299 */     double maxSpeed = 2048.0D * (1 << this.zoomout);
/*     */ 
/*     */ 
/*     */     
/* 303 */     this.acc.ySet(0.0D);
/* 304 */     if ((KEYS.MAIN()).SCROLL_UP.isPressed()) {
/* 305 */       if (this.speed.y() > 0)
/* 306 */         this.speed.ySet(0.0D); 
/* 307 */       this.acc.ySet(-accD);
/* 308 */     } else if ((KEYS.MAIN()).SCROLL_DOWN.isPressed()) {
/* 309 */       if (this.speed.y() < 0)
/* 310 */         this.speed.ySet(0.0D); 
/* 311 */       this.acc.ySet(accD);
/*     */     } 
/* 313 */     this.acc.xSet(0.0D);
/* 314 */     if ((KEYS.MAIN()).SCROLL_LEFT.isPressed()) {
/* 315 */       this.acc.xSet(-accD);
/* 316 */       if (this.speed.x() > 0)
/* 317 */         this.speed.xSet(0.0D); 
/* 318 */     } else if ((KEYS.MAIN()).SCROLL_RIGHT.isPressed()) {
/* 319 */       this.acc.xSet(accD);
/* 320 */       if (this.speed.x() < 0) {
/* 321 */         this.speed.xSet(0.0D);
/*     */       }
/*     */     }
/* 324 */     else if ((S.get()).scroll.get() == 1) {
/* 325 */       if (VIEW.mouse().x() < 4) {
/* 326 */         this.acc.xSet(-accD);
/* 327 */       } else if (VIEW.mouse().x() > C.DIM().x2() - 5) {
/* 328 */         this.acc.xSet(accD);
/*     */       } 
/* 330 */       if (VIEW.mouse().y() < 4) {
/* 331 */         this.acc.ySet(-accD);
/* 332 */       } else if (VIEW.mouse().y() > C.DIM().y2() - 5) {
/* 333 */         this.acc.ySet(accD);
/*     */       } 
/*     */     } 
/* 336 */     double maxx = 1.0D;
/*     */     
/* 338 */     this.dragging &= MButt.WHEEL.isDown();
/* 339 */     if (this.dragging) {
/*     */       
/* 341 */       int dx = VIEW.mouse().x() - this.dragX;
/* 342 */       int dy = VIEW.mouse().y() - this.dragY;
/*     */ 
/*     */ 
/*     */       
/* 346 */       pinc((this.dragCX - (dx << this.zoomout) - this.pixels.cX()), (this.dragCY - (dy << this.zoomout) - this.pixels.cY()));
/*     */       
/* 348 */       bondify();
/*     */       
/* 350 */       this.pixels.update();
/* 351 */       this.pixels2.update();
/* 352 */       this.pixel.update();
/* 353 */       this.tile.update();
/*     */       
/* 355 */       if (this.pixels.hasMoved()) {
/* 356 */         int tX1 = this.pixels.x1() / 64;
/* 357 */         int tX2 = this.pixels.x2() / 64;
/* 358 */         int tY1 = this.pixels.y1() / 64;
/* 359 */         int tY2 = this.pixels.y2() / 64;
/*     */         
/* 361 */         this.tiles.set(tX1, tX2, tY1, tY2);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 367 */     if (this.acc.x() == 0)
/* 368 */       this.speed.decrease(ds * accD * 4.0D, 0.0D); 
/* 369 */     if (this.acc.y() == 0) {
/* 370 */       this.speed.decrease(0.0D, ds * accD * 4.0D);
/*     */     }
/* 372 */     this.speed.increment((COORDINATE)this.acc, ds);
/* 373 */     if (this.speed.x() > maxSpeed * maxx) {
/* 374 */       this.speed.decrease(Math.max(accD * 2.0D * ds, ((Math.abs(this.speed.x()) * 8) * ds)), 0.0D);
/* 375 */       if (this.speed.x() < maxSpeed * maxx)
/* 376 */         this.speed.xSet(maxSpeed * maxx); 
/* 377 */     } else if (this.speed.x() < -maxSpeed * maxx) {
/* 378 */       this.speed.decrease(Math.max(accD * 2.0D * ds, ((Math.abs(this.speed.x()) * 8) * ds)), 0.0D);
/* 379 */       if (this.speed.x() > -maxSpeed * maxx)
/* 380 */         this.speed.xSet(-maxSpeed * maxx); 
/*     */     } 
/* 382 */     if (this.speed.y() > maxSpeed * maxy) {
/* 383 */       this.speed.decrease(0.0D, Math.max(accD * 2.0D * ds, ((Math.abs(this.speed.y()) * 8) * ds)));
/* 384 */       if (this.speed.y() < maxSpeed * maxy) {
/* 385 */         this.speed.ySet(maxSpeed * maxy);
/*     */       }
/* 387 */     } else if (this.speed.y() < -maxSpeed * maxy) {
/* 388 */       this.speed.decrease(0.0D, Math.max(accD * 2.0D * ds, ((Math.abs(this.speed.y()) * 8) * ds)));
/* 389 */       if (this.speed.y() > -maxSpeed * maxy) {
/* 390 */         this.speed.ySet(-maxSpeed * maxy);
/*     */       }
/*     */     } 
/* 393 */     pinc((this.speed.x() * ds), (this.speed.y() * ds));
/*     */ 
/*     */     
/* 396 */     double d = (1 + this.zoomout);
/*     */     
/* 398 */     if ((KEYS.MAIN()).MUP.isPressed()) {
/* 399 */       pinc(0.0D, -d);
/* 400 */     } else if ((KEYS.MAIN()).MDOWN.isPressed()) {
/* 401 */       pinc(0.0D, d);
/*     */     } 
/* 403 */     if ((KEYS.MAIN()).MLEFT.isPressed()) {
/* 404 */       pinc(-d, 0.0D);
/* 405 */     } else if ((KEYS.MAIN()).MRIGHT.isPressed()) {
/* 406 */       pinc(d, 0.0D);
/*     */     } 
/*     */ 
/*     */     
/* 410 */     bondify();
/*     */     
/* 412 */     this.pixels.update();
/* 413 */     this.pixels2.update();
/* 414 */     this.pixel.update();
/* 415 */     this.tile.update();
/*     */     
/* 417 */     if (this.pixels.hasMoved()) {
/* 418 */       int tX1 = this.pixels.x1() / 64;
/* 419 */       int tX2 = this.pixels.x2() / 64;
/* 420 */       int tY1 = this.pixels.y1() / 64;
/* 421 */       int tY2 = this.pixels.y2() / 64;
/*     */       
/* 423 */       this.tiles.set(tX1, tX2, tY1, tY2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pinc(double dx, double dy) {
/* 431 */     if (dx < 0.0D) {
/* 432 */       if (this.pixels.x1() > this.gameMax.x1()) {
/* 433 */         this.pixels.incrX(dx);
/* 434 */         if (this.pixels.x1() < this.gameMax.x1()) {
/* 435 */           this.pixels.moveX1(this.gameMax.x1());
/* 436 */           this.speed.xSet(0.0D);
/*     */         } 
/* 438 */       } else if (this.pixels.x2() > this.gameMax.x2()) {
/* 439 */         this.pixels.incrX(dx);
/* 440 */         if (this.pixels.x2() < this.gameMax.x2()) {
/* 441 */           this.pixels.moveX2(this.gameMax.x2());
/* 442 */           this.speed.xSet(0.0D);
/*     */         }
/*     */       
/*     */       } 
/* 446 */     } else if (this.pixels.x2() < this.gameMax.x2()) {
/* 447 */       this.pixels.incrX(dx);
/* 448 */       if (this.pixels.x2() > this.gameMax.x2()) {
/* 449 */         this.pixels.moveX2(this.gameMax.x2());
/* 450 */         this.speed.xSet(0.0D);
/*     */       } 
/* 452 */     } else if (this.pixels.x1() < 0) {
/* 453 */       this.pixels.incrX(dx);
/* 454 */       if (this.pixels.x1() > 0) {
/* 455 */         this.pixels.moveX1(0.0D);
/* 456 */         this.speed.xSet(0.0D);
/*     */       } 
/*     */     } 
/*     */     
/* 460 */     if (dy < 0.0D) {
/* 461 */       if (this.pixels.y1() > this.gameMax.y1()) {
/* 462 */         this.pixels.incrY(dy);
/* 463 */         if (this.pixels.y1() < this.gameMax.y1()) {
/* 464 */           this.pixels.moveY1(this.gameMax.y1());
/* 465 */           this.speed.ySet(0.0D);
/*     */         } 
/* 467 */       } else if (this.pixels.y2() > this.gameMax.y2()) {
/* 468 */         this.pixels.incrY(dy);
/* 469 */         if (this.pixels.y2() < this.gameMax.y2()) {
/* 470 */           this.pixels.moveY2(this.gameMax.y2());
/* 471 */           this.speed.ySet(0.0D);
/*     */         }
/*     */       
/*     */       } 
/* 475 */     } else if (this.pixels.y2() < this.gameMax.y2()) {
/* 476 */       this.pixels.incrY(dy);
/* 477 */       if (this.pixels.y2() > this.gameMax.y2()) {
/* 478 */         this.pixels.moveY2(this.gameMax.y2());
/* 479 */         this.speed.ySet(0.0D);
/*     */       } 
/* 481 */     } else if (this.pixels.y1() < 0) {
/* 482 */       this.pixels.incrY(dy);
/* 483 */       if (this.pixels.y1() > 0) {
/* 484 */         this.pixels.moveY1(0.0D);
/* 485 */         this.speed.ySet(0.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void bondify() {
/* 492 */     if (this.pixels.x1() < this.max.x1() || this.pixels.width() > this.max.width()) {
/* 493 */       this.speed.xSet(0.0D);
/* 494 */       this.pixels.moveX1(this.max.x1());
/* 495 */     } else if (this.pixels.x2() > this.max.x2()) {
/* 496 */       this.pixels.moveX2(this.max.x2());
/* 497 */       this.speed.xSet(0.0D);
/*     */     } 
/* 499 */     if (this.pixels.y1() < this.max.y1() || this.pixels.height() > this.max.height()) {
/* 500 */       this.speed.ySet(0.0D);
/* 501 */       this.pixels.moveY1(this.max.y1());
/* 502 */     } else if (this.pixels.y2() > this.max.y2()) {
/*     */       
/* 504 */       this.pixels.moveY2(this.max.y2());
/* 505 */       this.speed.ySet(0.0D);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stop() {
/* 510 */     this.speed.set(0.0D, 0.0D);
/* 511 */     this.acc.set(0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public void centerAt(int x1, int y1) {
/* 515 */     stop();
/* 516 */     this.pixels.moveC(x1, y1);
/* 517 */     update(0.0F);
/*     */   }
/*     */   
/*     */   public void inc(int x1, int y1) {
/* 521 */     stop();
/* 522 */     this.pixels.incr(x1, y1);
/* 523 */     update(0.0F);
/*     */   }
/*     */   
/*     */   public void centerAt(COORDINATE coo) {
/* 527 */     centerAt(coo.x(), coo.y());
/*     */   }
/*     */   
/*     */   public void centerAtTile(int tileX, int tileY) {
/* 531 */     centerAt(tileX * 64 + 32, 
/* 532 */         tileY * 64 + 32);
/*     */   }
/*     */   
/* 535 */   public GameWindow(int zoomout, RECTANGLE view, RECTANGLE gameMax, int outMargin) { this.centerer = new MAP_SETTER()
/*     */       {
/*     */         public MAP_SETTER set(int tx, int ty)
/*     */         {
/* 539 */           GameWindow.this.stop();
/* 540 */           GameWindow.this.pixels.moveC(tx, ty);
/* 541 */           GameWindow.this.update(0.0F);
/* 542 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_SETTER set(int tile) {
/* 547 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */     
/* 551 */     this.centererTile = new MAP_SETTER()
/*     */       {
/*     */         public MAP_SETTER set(int tx, int ty)
/*     */         {
/* 555 */           GameWindow.this.stop();
/* 556 */           GameWindow.this.pixels.moveC((tx * 64 + 32), (ty * 64 + 32));
/* 557 */           GameWindow.this.update(0.0F);
/* 558 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_SETTER set(int tile) {
/* 563 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 734 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 738 */           file.i(GameWindow.this.pixels().cX());
/* 739 */           file.i(GameWindow.this.pixels().cY());
/* 740 */           file.i(GameWindow.this.zoomout);
/*     */         }
/*     */         
/*     */         public void load(FileGetter file) throws IOException
/*     */         {
/* 745 */           GameWindow.this.centerAt(file.i(), file.i());
/* 746 */           GameWindow.this.setZoomout(file.i());
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {}
/*     */       };
/*     */     this.zoomout = zoomout;
/*     */     this.viewWindow = new Rec(view);
/*     */     this.viewWindowDefault = new Rec(view);
/*     */     this.pixels = new Pixels(gameMax);
/*     */     Rec m = new Rec(gameMax);
/*     */     m.incrW((outMargin * 2));
/*     */     m.incrH((outMargin * 2));
/*     */     m.incrX(-outMargin);
/*     */     m.incrY(-outMargin);
/*     */     this.gameMax = (RECTANGLE)new Rec((RECTANGLE)m);
/*     */     this.max.set((RECTANGLE)m);
/*     */     this.tiles = new Rec();
/*     */     update(0.0F); }
/*     */ 
/*     */   
/*     */   public void copy(GameWindow window) {
/* 768 */     setZoomout(window.zoomout());
/* 769 */     int x1 = window.pixels().x1() - (window.viewWindow.x1() << window.zoomout);
/* 770 */     int y1 = window.pixels().y1() - (window.viewWindow.y1() << window.zoomout);
/*     */     
/* 772 */     x1 += viewWindow().x1() << zoomout();
/* 773 */     y1 += viewWindow().y1() << zoomout();
/*     */     
/* 775 */     centerAt(x1 + this.pixels.width() / 2, y1 + this.pixels.height() / 2);
/*     */   }
/*     */   
/*     */   public SUB_MOUSE pixel() {
/*     */     return this.pixel;
/*     */   }
/*     */   
/*     */   public SUB_MOUSE tile() {
/*     */     return this.tile;
/*     */   }
/*     */   
/*     */   public RECTANGLE view() {
/*     */     return (RECTANGLE)this.viewWindow;
/*     */   }
/*     */   
/*     */   public PIXELWINDOW pixels() {
/*     */     return this.pixels2;
/*     */   }
/*     */   
/*     */   public RECTANGLE tiles() {
/*     */     return (RECTANGLE)this.tiles;
/*     */   }
/*     */   
/*     */   public static interface PIXELWINDOW extends RECTANGLE {
/*     */     COORDINATE relative();
/*     */     
/*     */     default int relX() {
/*     */       return relative().x();
/*     */     }
/*     */     
/*     */     default int relY() {
/*     */       return relative().y();
/*     */     }
/*     */     
/*     */     int screenX(int param1Int);
/*     */     
/*     */     int screenY(int param1Int);
/*     */     
/*     */     boolean hasMoved();
/*     */   }
/*     */   
/*     */   public class Pixels extends Rec implements PIXELWINDOW {
/*     */     private static final long serialVersionUID = -7484519024737753592L;
/*     */     private final Coo move = new Coo();
/*     */     private final Rec old = new Rec();
/*     */     private final Coo relative = new Coo();
/*     */     private boolean hasMoved = true;
/*     */     private int w;
/*     */     private int h;
/*     */     
/*     */     public Rec moveX1(double X1) {
/*     */       this.move.xSet(X1);
/*     */       super.moveX1(X1);
/*     */       this.relative.set(x1(), y1());
/*     */       this.relative.increment(GameWindow.this.viewWindow.x1(), GameWindow.this.viewWindow.y1());
/*     */       return this;
/*     */     }
/*     */     
/*     */     public Rec moveY1(double Y1) {
/*     */       this.move.ySet(Y1);
/*     */       super.moveY1(Y1);
/*     */       this.relative.set(x1(), y1());
/*     */       this.relative.increment(GameWindow.this.viewWindow.x1(), GameWindow.this.viewWindow.y1());
/*     */       return this;
/*     */     }
/*     */     
/*     */     public COORDINATE relative() {
/*     */       return (COORDINATE)this.relative;
/*     */     }
/*     */     
/*     */     public boolean hasMoved() {
/*     */       return this.hasMoved;
/*     */     }
/*     */     
/*     */     void update() {
/*     */       this.w = GameWindow.this.viewWindow.width() << GameWindow.this.zoomout;
/*     */       this.h = GameWindow.this.viewWindow.height() << GameWindow.this.zoomout;
/*     */       setDim(this.w, this.h);
/*     */       this.hasMoved = !this.old.isSameAs(this);
/*     */       this.old.set(this);
/*     */     }
/*     */     
/*     */     public int screenX(int x) {
/*     */       return x - relX();
/*     */     }
/*     */     
/*     */     public int screenY(int y) {
/*     */       return y - relY();
/*     */     }
/*     */     
/*     */     private Pixels(RECTANGLE max) {}
/*     */   }
/*     */   
/*     */   private class Pixels2 extends Rec implements PIXELWINDOW {
/*     */     private static final long serialVersionUID = -6275702531051471901L;
/*     */     private final Coo relative = new Coo();
/*     */     
/*     */     public COORDINATE relative() {
/*     */       return (COORDINATE)this.relative;
/*     */     }
/*     */     
/*     */     public boolean hasMoved() {
/*     */       return GameWindow.this.pixels.hasMoved;
/*     */     }
/*     */     
/*     */     void update() {
/*     */       set(GameWindow.this.pixels);
/*     */       if (GameWindow.this.zoomout != 0) {
/*     */         moveX1((x1() >> GameWindow.this.zoomout << GameWindow.this.zoomout));
/*     */         moveY1((y1() >> GameWindow.this.zoomout << GameWindow.this.zoomout));
/*     */       } 
/*     */       this.relative.set(x1(), y1());
/*     */       this.relative.increment(-(GameWindow.this.viewWindow.x1() << GameWindow.this.zoomout), -(GameWindow.this.viewWindow.y1() << GameWindow.this.zoomout));
/*     */     }
/*     */     
/*     */     public int screenX(int x) {
/*     */       return x - relX();
/*     */     }
/*     */     
/*     */     public int screenY(int y) {
/*     */       return y - relY();
/*     */     }
/*     */   }
/*     */   
/*     */   private abstract class SubMouse extends Coo implements SUB_MOUSE {
/*     */     private static final long serialVersionUID = 4936922844334905532L;
/*     */     
/*     */     protected abstract void update();
/*     */   }
/*     */   
/*     */   public static interface SUB_MOUSE extends COORDINATE {
/*     */     boolean hasMoved();
/*     */     
/*     */     COORDINATE rel();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\subview\GameWindow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */