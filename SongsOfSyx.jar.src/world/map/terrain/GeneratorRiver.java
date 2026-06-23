/*     */ package world.map.terrain;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorRiver
/*     */ {
/*     */   private static int dX;
/*     */   private static int dY;
/*  21 */   private static int trials = 0;
/*     */   private static int maxLength;
/*     */   private static boolean fromOcean = false;
/*     */   
/*     */   GeneratorRiver() {
/*  26 */     largeRivers();
/*  27 */     smallRivers();
/*     */   }
/*     */ 
/*     */   
/*     */   private void smallRivers() {
/*  32 */     LinkedList<Coo> coo = new LinkedList<>();
/*     */     
/*  34 */     for (int y = 0; y < WORLD.THEIGHT(); y++) {
/*  35 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/*     */         
/*  37 */         if (smallStart(x, y) != null) {
/*  38 */           coo.add(new Coo(x, y));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  43 */     Collections.shuffle(coo);
/*     */     
/*  45 */     double am = (200 * WORLD.TAREA()) / 50176.0D;
/*     */     
/*  47 */     while (am-- > 0.0D && !coo.isEmpty()) {
/*  48 */       Coo c = coo.removeFirst();
/*     */       
/*  50 */       if (smallRiver(c.x(), c.y()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DIR smallStart(int tx, int ty) {
/*  58 */     if (!WORLD.WATER().is(tx, ty)) {
/*  59 */       return null;
/*     */     }
/*  61 */     int ri = RND.rInt(DIR.ORTHO.size());
/*     */     
/*  63 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  64 */       DIR d = (DIR)DIR.ORTHO.getC(ri + i);
/*     */       
/*  66 */       if (WORLD.IN_BOUNDS(tx, ty, d))
/*     */       {
/*  68 */         if (!WORLD.MOUNTAIN().is(tx + d.x(), ty + d.y()) && WORLD.WATER().get(tx, ty, d) == (WORLD.WATER()).NOTHING)
/*  69 */           return d;  } 
/*     */     } 
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean smallRiver(int sx, int sy) {
/*  76 */     DIR d = smallStart(sx, sy);
/*  77 */     if (d == null) {
/*  78 */       return false;
/*     */     }
/*  80 */     sx += d.x();
/*  81 */     sy += d.y();
/*     */ 
/*     */     
/*  84 */     if (!WORLD.IN_BOUNDS(sx, sy))
/*  85 */       return false; 
/*  86 */     if (WORLD.MOUNTAIN().is(sx, sy))
/*  87 */       return false; 
/*  88 */     if (WORLD.WATER().get(sx, sy) != (WORLD.WATER()).NOTHING) {
/*  89 */       return false;
/*     */     }
/*  91 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  92 */       DIR d2 = (DIR)DIR.ORTHO.get(di);
/*  93 */       if ((WORLD.WATER()).RIVER_SMALL.is(sx, sy, d2)) {
/*  94 */         return false;
/*     */       }
/*     */     } 
/*  97 */     int straights = 2;
/*     */     
/*  99 */     return smallRiver(sx, sy, d, straights, 24);
/*     */   }
/*     */   
/*     */   private boolean smallRiver(int tx, int ty, DIR dir, int straights, int length) {
/* 103 */     if (length-- < 0)
/* 104 */       return false; 
/* 105 */     if (!WORLD.IN_BOUNDS(tx, ty))
/* 106 */       return smallSuccess(tx, ty); 
/* 107 */     if (WORLD.MOUNTAIN().is(tx, ty)) {
/* 108 */       return false;
/*     */     }
/* 110 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 111 */       DIR d2 = (DIR)DIR.ORTHO.get(di);
/* 112 */       if (d2.perpendicular() != dir)
/*     */       {
/* 114 */         if (WORLD.WATER().get(tx, ty, d2) != (WORLD.WATER()).NOTHING) {
/* 115 */           return smallSuccess(tx, ty);
/*     */         }
/*     */       }
/*     */     } 
/* 119 */     straights--;
/* 120 */     if (straights <= 0) {
/* 121 */       dir = dir.next(2 * RND.rInt0(1));
/* 122 */       straights = 3;
/*     */     } 
/*     */     
/* 125 */     if (smallRiver(tx + dir.x(), ty + dir.y(), dir, straights, length)) {
/* 126 */       return smallSuccess(tx, ty);
/*     */     }
/* 128 */     return false;
/*     */   }
/*     */   
/*     */   private boolean smallSuccess(int tx, int ty) {
/* 132 */     (WORLD.WATER()).RIVER_SMALL.placeRaw(tx, ty);
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static int largeRivers() {
/* 139 */     double am = (10 * WORLD.TAREA()) / 50176.0D;
/*     */ 
/*     */ 
/*     */     
/* 143 */     LinkedList<Coo> coo = new LinkedList<>();
/*     */     
/* 145 */     for (int y = 0; y < WORLD.THEIGHT(); y++) {
/* 146 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/* 147 */         if (isDeltable(x, y)) {
/* 148 */           coo.add(new Coo(x, y));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     Collections.shuffle(coo);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     while (!coo.isEmpty() && am > 0.0D) {
/*     */       
/* 160 */       Coo v = coo.removeFirst();
/*     */       
/* 162 */       int j = v.y();
/* 163 */       int x = v.x();
/*     */       
/* 165 */       if ((WORLD.WATER()).RIVER.is(x, j)) {
/*     */         continue;
/*     */       }
/* 168 */       maxLength = 16 + RND.rInt(WORLD.TWIDTH() - 1);
/*     */       
/* 170 */       if ((WORLD.WATER()).has.is(x, j - 1)) {
/* 171 */         dX = 0;
/* 172 */         dY = 1;
/* 173 */       } else if ((WORLD.WATER()).has.is(x, j + 1)) {
/* 174 */         dX = 0;
/* 175 */         dY = -1;
/* 176 */       } else if ((WORLD.WATER()).has.is(x - 1, j)) {
/* 177 */         dX = 1;
/* 178 */         dY = 0;
/* 179 */       } else if ((WORLD.WATER()).has.is(x + 1, j)) {
/* 180 */         dX = -1;
/* 181 */         dY = 0;
/*     */       } else {
/*     */         continue;
/*     */       } 
/*     */       
/* 186 */       fromOcean = (WORLD.WATER().bordersCount(x, j, (WORLD.WATER()).OCEAN.normal) == 1);
/*     */       
/* 188 */       trials = 0;
/*     */       
/* 190 */       if (start(j, x, 0, false, false, 0)) {
/* 191 */         placeDelta(x, j);
/* 192 */         am--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 197 */     for (int i = 0; i < 75; i++) {
/* 198 */       int x = RND.rInt(WORLD.TWIDTH());
/* 199 */       int j = RND.rInt(WORLD.THEIGHT());
/* 200 */       dX = -1 + RND.rInt(3);
/* 201 */       dY = (dX == 0) ? (-1 + RND.rInt(3)) : 0;
/* 202 */       trials = 0;
/* 203 */       maxLength = 16 + RND.rInt(WORLD.TWIDTH() - 1);
/* 204 */       branch(j, x, 0, false, false, 0);
/*     */     } 
/*     */     
/* 207 */     return 0;
/*     */   }
/*     */   
/*     */   private static void placeDelta(int x, int y) {
/* 211 */     if ((WORLD.WATER()).LAKE.delta.isPlacable(x, y, null, null) == null) {
/* 212 */       (WORLD.WATER()).LAKE.delta.placeRaw(x, y);
/*     */     } else {
/* 214 */       (WORLD.WATER()).OCEAN.delta.placeRaw(x, y);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean isDeltable(int x, int y) {
/* 219 */     if ((WORLD.WATER()).LAKE.delta.isPlacable(x, y, null, null) == null || (WORLD.WATER()).OCEAN.delta.isPlacable(x, y, null, null) == null) {
/* 220 */       return true;
/*     */     }
/* 222 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean start(int y, int x, int straight, boolean left, boolean right, int length) {
/* 227 */     trials++;
/*     */     
/* 229 */     if (length > maxLength) {
/* 230 */       return true;
/*     */     }
/* 232 */     if ((WORLD.WATER()).has.is(x, y)) {
/* 233 */       return false;
/*     */     }
/* 235 */     if (trials > 1000) {
/* 236 */       return false;
/*     */     }
/* 238 */     if (length > 0 && isDeltable(x, y)) {
/* 239 */       if (length < 3)
/* 240 */         return false; 
/* 241 */       if (fromOcean && (WORLD.WATER()).OCEAN.normal.is(x, y))
/* 242 */         return false; 
/* 243 */       if (straight <= 1)
/* 244 */         return false; 
/* 245 */       if (WORLD.WATER().borders(x, y, (WORLD.WATER()).RIVER))
/* 246 */         return false; 
/* 247 */       if (dY == 1 && (WORLD.WATER()).has.is(x, y + 1)) {
/* 248 */         placeDelta(x, y);
/* 249 */         return true;
/* 250 */       }  if (dY == -1 && (WORLD.WATER()).has.is(x, y - 1)) {
/* 251 */         placeDelta(x, y);
/* 252 */         return true;
/* 253 */       }  if (dX == 1 && (WORLD.WATER()).has.is(x + 1, y)) {
/* 254 */         placeDelta(x, y);
/* 255 */         return true;
/* 256 */       }  if (dX == -1 && (WORLD.WATER()).has.is(x - 1, y)) {
/* 257 */         placeDelta(x, y);
/* 258 */         return true;
/*     */       } 
/* 260 */       return false;
/*     */     } 
/*     */     
/* 263 */     if (fromOcean && length > 2 && WORLD.WATER().borders(x, y, (WORLD.WATER()).OCEAN.normal)) {
/* 264 */       return false;
/*     */     }
/* 266 */     if (x == WORLD.TWIDTH() - 1 || y == WORLD.THEIGHT() - 1 || x == 0 || y == 0) {
/* 267 */       if (length < 3) {
/* 268 */         return false;
/*     */       }
/* 270 */       (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 271 */       return true;
/*     */     } 
/*     */     
/* 274 */     if (WORLD.MOUNTAIN().is(x, y) && length > 3 && RND.rInt(8) == 0) {
/* 275 */       return true;
/*     */     }
/* 277 */     if (WORLD.WATER().borders(x, y, (WORLD.WATER()).RIVER)) {
/* 278 */       if (length > 4) {
/* 279 */         (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 280 */         return true;
/*     */       } 
/* 282 */       return false;
/*     */     } 
/*     */     
/* 285 */     if (straight == 2) {
/* 286 */       straight = 0;
/* 287 */       left = true;
/* 288 */       right = true;
/*     */     } 
/*     */     
/* 291 */     if (dX == 0) {
/* 292 */       if (RND.rInt(4) == 1 && right) {
/* 293 */         if (start(y, x + 1, 0, false, true, length + 1)) {
/* 294 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 295 */           return true;
/*     */         } 
/* 297 */       } else if (RND.rInt(4) == 1 && left) {
/* 298 */         if (start(y, x - 1, 0, true, false, length + 1)) {
/* 299 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 300 */           return true;
/*     */         } 
/*     */       } else {
/* 303 */         if (start(y + dY, x, straight + 1, left, right, length + 1)) {
/* 304 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 305 */           return true;
/*     */         } 
/* 307 */         if (RND.rBoolean()) {
/* 308 */           if (right && start(y, x + 1, 0, false, true, length + 1)) {
/* 309 */             (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 310 */             return true;
/*     */           }
/*     */         
/* 313 */         } else if (left && start(y, x - 1, 0, true, false, length + 1)) {
/* 314 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 315 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 323 */     if (dY == 0) {
/* 324 */       if (RND.rInt(4) == 1 && right) {
/* 325 */         if (start(y + 1, x, 0, false, true, length + 1)) {
/* 326 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 327 */           return true;
/*     */         } 
/* 329 */       } else if (RND.rInt(4) == 1 && left) {
/* 330 */         if (start(y - 1, x, 0, true, false, length + 1)) {
/* 331 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 332 */           return true;
/*     */         } 
/*     */       } else {
/* 335 */         if (start(y, x + dX, straight + 1, left, right, length + 1)) {
/* 336 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 337 */           return true;
/*     */         } 
/* 339 */         if (RND.rBoolean()) {
/* 340 */           if (right && start(y + 1, x, 0, false, true, length + 1)) {
/* 341 */             (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 342 */             return true;
/*     */           }
/*     */         
/* 345 */         } else if (left && start(y - 1, x, 0, true, false, length + 1)) {
/* 346 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 347 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 355 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean branch(int y, int x, int straight, boolean left, boolean right, int length) {
/* 361 */     trials++;
/*     */     
/* 363 */     if ((WORLD.WATER()).RIVER.is(x, y)) {
/* 364 */       return true;
/*     */     }
/* 366 */     if ((WORLD.WATER()).has.is(x, y)) {
/* 367 */       return false;
/*     */     }
/* 369 */     if (trials > 1000) {
/* 370 */       return false;
/*     */     }
/* 372 */     if (x == WORLD.TWIDTH() - 1 || y == WORLD.THEIGHT() - 1 || x == 0 || y == 0) {
/* 373 */       if (length < 3) {
/* 374 */         return false;
/*     */       }
/* 376 */       (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 377 */       return true;
/*     */     } 
/*     */     
/* 380 */     if (WORLD.MOUNTAIN().is(x, y) && length > 3 && RND.rInt(8) == 0) {
/* 381 */       return true;
/*     */     }
/* 383 */     if (WORLD.WATER().borders(x, y, (WORLD.WATER()).RIVER)) {
/* 384 */       if (length > 4) {
/* 385 */         (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 386 */         return true;
/*     */       } 
/* 388 */       return false;
/*     */     } 
/*     */     
/* 391 */     if (straight == 2) {
/* 392 */       straight = 0;
/* 393 */       left = true;
/* 394 */       right = true;
/*     */     } 
/*     */     
/* 397 */     if (dX == 0) {
/* 398 */       if (RND.rInt(4) == 1 && right) {
/* 399 */         if (start(y, x + 1, 0, false, true, length + 1)) {
/* 400 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 401 */           return true;
/*     */         } 
/* 403 */       } else if (RND.rInt(4) == 1 && left) {
/* 404 */         if (start(y, x - 1, 0, true, false, length + 1)) {
/* 405 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 406 */           return true;
/*     */         } 
/*     */       } else {
/* 409 */         if (start(y + dY, x, straight + 1, left, right, length + 1)) {
/* 410 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 411 */           return true;
/*     */         } 
/* 413 */         if (RND.rBoolean()) {
/* 414 */           if (right && start(y, x + 1, 0, false, true, length + 1)) {
/* 415 */             (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 416 */             return true;
/*     */           }
/*     */         
/* 419 */         } else if (left && start(y, x - 1, 0, true, false, length + 1)) {
/* 420 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 421 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 429 */     if (dY == 0) {
/* 430 */       if (RND.rInt(4) == 1 && right) {
/* 431 */         if (start(y + 1, x, 0, false, true, length + 1)) {
/* 432 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 433 */           return true;
/*     */         } 
/* 435 */       } else if (RND.rInt(4) == 1 && left) {
/* 436 */         if (start(y - 1, x, 0, true, false, length + 1)) {
/* 437 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 438 */           return true;
/*     */         } 
/*     */       } else {
/* 441 */         if (start(y, x + dX, straight + 1, left, right, length + 1)) {
/* 442 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 443 */           return true;
/*     */         } 
/* 445 */         if (RND.rBoolean()) {
/* 446 */           if (right && start(y + 1, x, 0, false, true, length + 1)) {
/* 447 */             (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 448 */             return true;
/*     */           }
/*     */         
/* 451 */         } else if (left && start(y - 1, x, 0, true, false, length + 1)) {
/* 452 */           (WORLD.WATER()).RIVER.placeRaw(x, y);
/* 453 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 461 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\GeneratorRiver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */