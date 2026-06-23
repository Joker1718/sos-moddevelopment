/*     */ package game.battle.formation;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.race.Race;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DivDeployer
/*     */ {
/*     */   private final DivFormationImp position;
/*  26 */   private int[] backers = Alloc.ii(251);
/*     */ 
/*     */   
/*     */   private final PathUtilOnline flooder;
/*     */   
/*     */   private final VectorImp vec;
/*     */ 
/*     */   
/*     */   public DivDeployer(PathUtilOnline f) {
/*  35 */     this.vec = new VectorImp();
/*     */     this.position = new DivFormationImp();
/*     */     this.flooder = f;
/*     */   } public DivFormationImp deploy(DIV_SPEC div, int men, DIV_FORMATION f, int x1, int y1, double dx, double dy, int width, Army a) {
/*  39 */     this.position.clear();
/*     */ 
/*     */     
/*  42 */     int tileSize = f.size(div);
/*     */     
/*  44 */     this.vec.set(dx, dy);
/*     */     
/*  46 */     double stepX = this.vec.nX() * tileSize;
/*  47 */     double stepY = this.vec.nY() * tileSize;
/*     */     
/*  49 */     DIR faceDir = this.vec.dir().next(-2);
/*     */     
/*  51 */     int steps = getSteps(width / tileSize, stepX, stepY, x1, y1, tileSize, a, div.race());
/*  52 */     if (steps == 0)
/*  53 */       return null; 
/*  54 */     if (steps > men)
/*  55 */       steps = men; 
/*  56 */     if (steps > 250) {
/*  57 */       steps = 250;
/*     */     }
/*  59 */     this.position.deployInit(faceDir, x1, y1, dx, dy, f, width);
/*     */     
/*  61 */     for (int i = 0; i < steps; i++) {
/*     */       
/*  63 */       int x = x1 + (int)(i * stepX);
/*  64 */       int y = y1 + (int)(i * stepY);
/*  65 */       this.position.deploy(x, y, div);
/*  66 */       men--;
/*     */     } 
/*     */     
/*  69 */     this.vec.rotate90();
/*     */     
/*  71 */     double backX = this.vec.nX() * tileSize;
/*  72 */     double backY = this.vec.nY() * tileSize;
/*     */     
/*  74 */     int backI = steps;
/*     */ 
/*     */     
/*  77 */     int backK = 1;
/*  78 */     this.backers[0] = steps / 2;
/*     */     int j;
/*  80 */     for (j = 1; j <= steps / 2; j++) {
/*  81 */       this.backers[backK++] = steps / 2 - j;
/*  82 */       this.backers[backK++] = steps / 2 + j;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     int depth = 1;
/*  89 */     while (men > 0 && backI > 0 && depth < 50) {
/*     */       
/*  91 */       for (j = 0; j < backI && men > 0; j++) {
/*  92 */         int p = this.backers[j];
/*  93 */         int x = x1 + (int)(p * stepX);
/*  94 */         int y = y1 + (int)(p * stepY);
/*  95 */         int fx = x + (int)(backX * (depth - 1));
/*  96 */         int fy = y + (int)(backY * (depth - 1));
/*  97 */         x = (int)(x + backX * depth);
/*  98 */         y = (int)(y + backY * depth);
/*  99 */         if (!DivPlacability.checkPixelStep(fx, fy, x, y, div.race(), a) || !isDeployable(x, y, a)) {
/* 100 */           for (int k = j + 1; k < backI; k++) {
/* 101 */             this.backers[k - 1] = this.backers[k];
/*     */           }
/* 103 */           backI--;
/* 104 */           j--;
/*     */         } else {
/*     */           
/* 107 */           this.position.deploy(x, y, div);
/* 108 */           men--;
/*     */         } 
/*     */       } 
/*     */       
/* 112 */       depth++;
/*     */     } 
/*     */     
/* 115 */     for (j = 0; j < backI; j++) {
/* 116 */       int p = this.backers[j];
/* 117 */       int x = x1 + (int)(p * stepX);
/* 118 */       int y = y1 + (int)(p * stepY);
/* 119 */       int fx = x + (int)(backX * (depth - 1));
/* 120 */       int fy = y + (int)(backY * (depth - 1));
/* 121 */       x = (int)(x + backX * depth);
/* 122 */       y = (int)(y + backY * depth);
/* 123 */       if (DivPlacability.checkPixelStep(fx, fy, x, y, div.race(), a) && isDeployable(x, y, a)) {
/*     */ 
/*     */         
/* 126 */         this.position.setHasExtraRoom();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     this.position.deployFinish(this.flooder.filler, div);
/* 133 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DivFormationImp deployArroundCentre(DIV_SPEC div, int men, DIV_FORMATION f, int x1, int y1, double dx, double dy, int width, Army a) {
/* 139 */     int bestX1 = -1;
/* 140 */     int bestY1 = -1;
/* 141 */     int best = 0;
/*     */ 
/*     */     
/* 144 */     DivFormationImp res = deployCentre(div, men, f, x1, y1, dx, dy, width / f.size(div), a);
/* 145 */     if (res != null && res.deployed() == men) {
/* 146 */       if (res.deployed() == men)
/* 147 */         return res; 
/* 148 */       if (res.deployed() > best) {
/* 149 */         best = res.deployed();
/* 150 */         bestX1 = x1;
/* 151 */         bestY1 = y1;
/*     */       } 
/*     */     } 
/*     */     
/* 155 */     for (int i = 1; i < 7; i++) {
/* 156 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 157 */         DIR d = (DIR)DIR.ALL.get(i);
/* 158 */         int x = (int)(x1 + d.xN() * 64.0D * i);
/* 159 */         int y = (int)(y1 + d.yN() * 64.0D * i);
/* 160 */         res = deployCentre(div, men, f, x, y, dx, dy, width / f.size(div), a);
/* 161 */         if (res != null) {
/*     */           
/* 163 */           if (res.deployed() == men)
/* 164 */             return res; 
/* 165 */           if (res.deployed() > best) {
/* 166 */             best = res.deployed();
/* 167 */             bestX1 = x1;
/* 168 */             bestY1 = y1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     if (best > 0)
/* 175 */       return deployCentre(div, men, f, bestX1, bestY1, dx, dy, width / f.size(div), a); 
/* 176 */     return null;
/*     */   }
/*     */   
/*     */   protected boolean isDeployable(int px, int py, Army a) {
/* 180 */     return true;
/*     */   }
/*     */   
/*     */   public DivFormationImp move(DIV_SPEC div, DivFormationImp f, int dx, int dy, Army a) {
/* 184 */     if (this.position == f)
/* 185 */       throw new RuntimeException(); 
/* 186 */     this.position.deployInit(f.dir(), f.start().x() + dx, f.start().y() + dy, f.dx(), f.dy(), f.formation(), f.width());
/* 187 */     for (int i = 0; i < f.deployed(); i++) {
/* 188 */       int x = f.pixel(i).x() + dx;
/* 189 */       int y = f.pixel(i).y() + dy;
/* 190 */       int tx = x >> 6;
/* 191 */       int ty = y >> 6;
/* 192 */       AVAILABILITY av = (SETT.PATH()).availability.get(tx, ty);
/* 193 */       if (av != null && (SETT.PATH()).availability.get(tx, ty).isSolid(a) && 
/* 194 */         !(GAME.ARMIES()).map.attackable.is(tx, ty, a)) {
/* 195 */         this.position.deploy(f.pixel(i).x(), f.pixel(i).y(), div);
/*     */       }
/*     */       else {
/*     */         
/* 199 */         this.position.deploy(x, y, div);
/*     */       } 
/* 201 */     }  this.position.deployFinish(this.flooder.filler, div);
/* 202 */     return this.position;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMove(DIV_SPEC div, DivFormationImp f, double dx, double dy, Army a) {
/* 207 */     for (int i = 0; i < f.deployed(); i++) {
/* 208 */       int x = (int)(f.pixel(i).x() + dx);
/* 209 */       int y = (int)(f.pixel(i).y() + dy);
/* 210 */       if (DivPlacability.pixelIsBlocked(x, y, div.race(), a))
/* 211 */         return false; 
/*     */     } 
/* 213 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public DivFormationImp deployCentre(DIV_SPEC div, int men, DIV_FORMATION form, int cx, int cy, double rightX, double rightY, int rowMen, Army a) {
/* 218 */     rowMen = CLAMP.i(rowMen, 1, men);
/*     */     
/* 220 */     double depth = men / rowMen;
/* 221 */     int stepsForward = (int)Math.ceil(depth / 2.0D);
/* 222 */     int ts = form.size(div);
/*     */     
/* 224 */     if (DivPlacability.pixelIsBlocked(cx, cy, div.race(), a)) {
/* 225 */       cx &= 0xFFFFFFC0;
/* 226 */       cy &= 0xFFFFFFC0;
/* 227 */       cx += 32;
/* 228 */       cy += 32;
/*     */     } 
/*     */     
/* 231 */     if (DivPlacability.pixelIsBlocked(cx, cy, div.race(), a)) {
/* 232 */       return null;
/*     */     }
/*     */     
/* 235 */     PathUtilOnline.Flooder f = this.flooder.getFlooder();
/* 236 */     f.init(this);
/* 237 */     this.position.clear();
/*     */ 
/*     */     
/* 240 */     this.vec.set(rightX, rightY);
/* 241 */     this.vec.rotate90();
/* 242 */     this.vec.rotate90();
/* 243 */     this.vec.rotate90();
/*     */ 
/*     */     
/* 246 */     int ccx = (int)(cx - rightX * rowMen * ts / 2.0D + rightX * ts / 2.0D + this.vec.nX() * (stepsForward - 1) * ts);
/* 247 */     int ccy = (int)(cy - rightY * rowMen * ts / 2.0D + rightY * ts / 2.0D + this.vec.nY() * (stepsForward - 1) * ts);
/* 248 */     this.position.deployInit(this.vec.dir(), ccx, ccy, rightX, rightY, form, rowMen * ts + ts / 2);
/*     */     
/*     */     int i;
/*     */     
/* 252 */     for (i = 0; i < stepsForward; i++) {
/* 253 */       int dx = (int)(cx + this.vec.nX() * ts * i);
/* 254 */       int dy = (int)(cy + this.vec.nY() * ts * i);
/* 255 */       int m = deployCentreRow(div, f, CLAMP.i(men, 0, rowMen), ts, dx, dy, rightX, rightY, this.position, a);
/* 256 */       if (m == 0)
/*     */         break; 
/* 258 */       men -= m;
/* 259 */       if (men <= 0) {
/*     */         break;
/*     */       }
/*     */     } 
/* 263 */     i = 1;
/* 264 */     while (men > 0) {
/* 265 */       int dx = (int)(cx + -this.vec.nX() * ts * i);
/* 266 */       int dy = (int)(cy + -this.vec.nY() * ts * i);
/* 267 */       int m = deployCentreRow(div, f, CLAMP.i(men, 0, rowMen), ts, dx, dy, rightX, rightY, this.position, a);
/* 268 */       if (m == 0)
/*     */         break; 
/* 270 */       men -= m;
/* 271 */       i++;
/*     */     } 
/*     */     
/* 274 */     deployCentreFinish(div, f, men, (int)(cx + this.vec.nX() * (stepsForward - 1)), (int)(cy + this.vec.nY() * (stepsForward - 1)), rightX, rightY, this.position, a);
/*     */     
/* 276 */     f.done();
/*     */     
/* 278 */     this.position.deployFinish(this.flooder.filler, div);
/* 279 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int deployCentreRow(DIV_SPEC div, PathUtilOnline.Flooder f, int men, int ts, int cx, int cy, double rx, double ry, DivFormationImp target, Army a) {
/* 287 */     if (DivPlacability.pixelIsBlocked(cx, cy, div.race(), a)) {
/* 288 */       cx &= 0xFFFFFFC0;
/* 289 */       cy &= 0xFFFFFFC0;
/* 290 */       cx += 32;
/* 291 */       cy += 32;
/*     */     } 
/*     */     
/* 294 */     if (DivPlacability.pixelIsBlocked(cx, cy, div.race(), a)) {
/* 295 */       return 0;
/*     */     }
/*     */     
/* 298 */     int left = men / 2;
/* 299 */     int right = men / 2;
/*     */     
/* 301 */     if (men % 2 == 0) {
/* 302 */       int dx = (int)(cx + rx * ts / 2.0D);
/* 303 */       int dy = (int)(cy + ry * ts / 2.0D);
/* 304 */       if (DivPlacability.pixelIsBlocked(dx, dy, div.race(), a)) {
/* 305 */         left--;
/*     */       } else {
/* 307 */         cx = dx;
/* 308 */         cy = dy;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     int amount = deployCentreRowPos(div, f, cx, cy, target);
/*     */     
/* 318 */     if (men == amount) {
/* 319 */       return amount;
/*     */     }
/* 321 */     boolean canRight = true;
/* 322 */     boolean canLeft = true;
/*     */     
/* 324 */     for (int i = 1; canRight || canLeft; i++) {
/*     */       
/* 326 */       if (canLeft && amount < men && i <= left) {
/* 327 */         int x = (int)(cx - i * rx * ts);
/* 328 */         int y = (int)(cy - i * ry * ts);
/* 329 */         if (DivPlacability.pixelIsBlocked(x, y, div.race(), a) || !isDeployable(x, y, a)) {
/* 330 */           canLeft = false;
/*     */         } else {
/* 332 */           amount += deployCentreRowPos(div, f, x, y, target);
/*     */         } 
/*     */       } else {
/* 335 */         canLeft = false;
/*     */       } 
/* 337 */       if (canRight && amount < men && i <= right) {
/* 338 */         int x = (int)(cx + i * rx * ts);
/* 339 */         int y = (int)(cy + i * ry * ts);
/* 340 */         if (DivPlacability.pixelIsBlocked(x, y, div.race(), a) || !isDeployable(x, y, a)) {
/* 341 */           canRight = false;
/*     */         } else {
/* 343 */           amount += deployCentreRowPos(div, f, x, y, target);
/*     */         } 
/*     */       } else {
/* 346 */         canRight = false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 354 */     return amount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int deployCentreRowPos(DIV_SPEC div, PathUtilOnline.Flooder f, int x, int y, DivFormationImp target) {
/* 360 */     target.deploy(x, y, div);
/* 361 */     int tx = x >> 6;
/* 362 */     int ty = y >> 6;
/* 363 */     f.pushSloppy(tx, ty, 0.0D);
/* 364 */     return 1;
/*     */   }
/*     */   
/*     */   private void deployCentreFinish(DIV_SPEC div, PathUtilOnline.Flooder f, int men, int ux, int uy, double rx, double ry, DivFormationImp target, Army a) {
/* 368 */     if (men == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 372 */     int x1 = ux;
/* 373 */     int y1 = uy;
/* 374 */     while (SETT.PIXEL_BOUNDS.holdsPoint(x1, y1)) {
/* 375 */       x1 = (int)(x1 - rx * 100.0D);
/* 376 */       y1 = (int)(y1 - ry * 100.0D);
/*     */     } 
/*     */     
/* 379 */     int x2 = ux;
/* 380 */     int y2 = uy;
/* 381 */     while (SETT.PIXEL_BOUNDS.holdsPoint(x2, y2)) {
/* 382 */       x2 = (int)(x2 + rx * 100.0D);
/* 383 */       y2 = (int)(y2 + ry * 100.0D);
/*     */     } 
/*     */     
/* 386 */     while (f.hasMore() && men > 0) {
/*     */       
/* 388 */       PathTile t = f.pollSmallest();
/*     */       
/* 390 */       if (t.getValue() > 0.0F) {
/* 391 */         target.deploy((t.x() << 6) + 32, (t.y() << 6) + 32, div);
/* 392 */         men--;
/*     */       } 
/*     */       
/* 395 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 396 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 397 */         int dx = t.x() + d.x();
/* 398 */         int dy = t.y() + d.y();
/* 399 */         if (SETT.IN_BOUNDS(dx, dy))
/*     */         {
/* 401 */           if (DivPlacability.tileIsOK(dx, dy, a)) {
/*     */             
/* 403 */             int x = (dx << 6) + 32;
/* 404 */             int y = (dy << 6) + 32;
/*     */             
/* 406 */             double D = ((x2 - x1) * (y - y1) - (x - x1) * (y2 - y1));
/* 407 */             if (D >= 0.0D) {
/* 408 */               f.pushSmaller(dx, dy, (t.getValue() + 1.0F));
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isValid(DIV_SPEC div, DivFormationImp destination, Army a) {
/* 417 */     if (destination.deployed() == 0)
/* 418 */       return false; 
/* 419 */     for (int i = 0; i < destination.deployed(); i++) {
/* 420 */       COORDINATE c = destination.pixel(i);
/* 421 */       if (DivPlacability.pixelIsBlocked(c.x(), c.y(), div.race(), a))
/* 422 */         return false; 
/*     */     } 
/* 424 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fixFormation(DIV_SPEC div, DivFormationImp old, DIV_FORMATION form, int men, Army a) {
/* 429 */     if (old.deployed() == 0)
/* 430 */       return false; 
/* 431 */     int sx = old.start().x();
/* 432 */     int sy = old.start().y();
/* 433 */     double dx = old.dx();
/* 434 */     double dy = old.dy();
/* 435 */     int steps = old.width() / old.formation().size(div);
/*     */     
/* 437 */     int bestI = -1;
/* 438 */     int bw = 0;
/* 439 */     double best = Double.MAX_VALUE;
/*     */     
/* 441 */     for (int i = 0; i < old.deployed(); i++) {
/* 442 */       int x = old.pixel(i).x();
/* 443 */       int y = old.pixel(i).y();
/* 444 */       int w = fixFormationWidth(x, y, steps, dx, dy, old.formation().size(div), a, div.race());
/* 445 */       if (w > 0) {
/* 446 */         double v = (steps - w + Math.abs(x - sx) + Math.abs(y - sy));
/* 447 */         if (v < best) {
/* 448 */           best = v;
/* 449 */           bw = w;
/* 450 */           bestI = i;
/* 451 */           if (v == 0.0D) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 459 */     if (bestI != -1) {
/*     */       
/* 461 */       int width = bw * old.formation().size(div);
/* 462 */       if (Math.abs(width - old.formation().size(div)) < old.formation().size(div)) {
/* 463 */         width = old.width();
/*     */       }
/* 465 */       DivFormationImp f = deploy(div, men, form, old.pixel(bestI).x(), old.pixel(bestI).y(), dx, dy, width, a);
/* 466 */       if (f == null) {
/* 467 */         LOG.ln("no!");
/*     */       } else {
/*     */         
/* 470 */         old.copy(f);
/*     */       } 
/* 472 */       return (f != null);
/*     */     } 
/*     */     
/* 475 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public DivFormationImp getFixedFormation(DIV_SPEC div, DivFormationImp old, DIV_FORMATION form, int men, Army a) {
/* 480 */     if (old.deployed() == 0)
/* 481 */       return null; 
/* 482 */     int sx = old.start().x();
/* 483 */     int sy = old.start().y();
/* 484 */     double dx = old.dx();
/* 485 */     double dy = old.dy();
/*     */ 
/*     */     
/* 488 */     int size = form.size(div);
/*     */     
/* 490 */     int bw = old.width();
/*     */     
/* 492 */     for (int i = 0; i < old.width(); i += size) {
/* 493 */       int x = (int)(sx + dx * i);
/* 494 */       int y = (int)(sy + dy * i);
/*     */       
/* 496 */       if (DivPlacability.pixelIsBlocked(x, y, div.race(), a)) {
/* 497 */         bw = i;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 502 */     if (bw < size || bw < old.width() / 2) {
/* 503 */       return deployArroundCentre(div, men, form, old.body().cX(), old.body().cY(), dx, dy, old.width(), a);
/*     */     }
/*     */ 
/*     */     
/* 507 */     DivFormationImp f = deploy(div, men, form, sx, sy, dx, dy, bw, a);
/* 508 */     return f;
/*     */   }
/*     */   
/*     */   private int fixFormationWidth(int px, int py, int steps, double dx, double dy, int tileSize, Army a, Race race) {
/* 512 */     for (int i = 0; i < steps; i++) {
/* 513 */       if (DivPlacability.pixelIsBlocked(px, py, race, a))
/* 514 */         return i; 
/* 515 */       px = (int)(px + dx * tileSize);
/* 516 */       py = (int)(py + dy * tileSize);
/*     */     } 
/* 518 */     return steps;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getSteps(int steps, double stepX, double stepY, int x1, int y1, int tileSize, Army a, Race race) {
/* 526 */     for (int i = 0; i < steps; i++) {
/*     */       
/* 528 */       int x = (int)(i * stepX);
/* 529 */       int y = (int)(i * stepY);
/* 530 */       x += x1;
/* 531 */       y += y1;
/*     */       
/* 533 */       if (DivPlacability.pixelIsBlocked(x, y, race, a) || !isDeployable(x, y, a)) {
/* 534 */         return i;
/*     */       }
/* 536 */       if (i != 0) {
/* 537 */         int tx1 = (int)(x1 + (i - 1) * stepX) >> 6;
/* 538 */         int ty1 = (int)(y1 + (i - 1) * stepY) >> 6;
/* 539 */         int tx2 = (int)(x1 + i * stepX) >> 6;
/* 540 */         int ty2 = (int)(y1 + i * stepY) >> 6;
/* 541 */         if ((tx1 != tx2 || ty1 != ty2) && 
/* 542 */           (SETT.PATH()).coster.player.getCost(tx1, ty1, tx2, ty2) < 0.0D) {
/* 543 */           return i;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 548 */     return steps;
/*     */   }
/*     */   
/*     */   static class DivDeployB
/*     */   {
/*     */     Div div;
/*     */     double dx;
/*     */     double dy;
/*     */     int x1;
/*     */     int y1;
/*     */     int width;
/*     */   }
/*     */   
/*     */   public boolean canDeploy(int x, int y, double nx, double ny, int width, int tz, Army a, Race race) {
/* 562 */     int steps = width / tz;
/* 563 */     return (steps == getSteps(steps, nx * tz, ny * tz, x, y, tz, a, race));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivDeployer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */