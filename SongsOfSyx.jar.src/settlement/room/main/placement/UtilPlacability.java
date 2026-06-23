/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.text.D;
/*     */ 
/*     */ final class UtilPlacability {
/*  19 */   private final Str sError = new Str(100);
/*     */   private final RoomPlacer p;
/*  21 */   private static CharSequence ¤¤TooSmall = "¤The area designated is too small.";
/*  22 */   private static CharSequence ¤¤NotEnoughItems = "¤This room plan has insufficient: {0} items. Place more items inside the shape to continue.";
/*  23 */   private static CharSequence ¤¤NotEnough = "¤This room will have insufficient {0}. Either the shape needs to be expanded, or more items need to placed.";
/*  24 */   private static CharSequence ¤¤Disconnected = "¤Area must be connected!";
/*  25 */   private static CharSequence ¤¤BlockingSelf = "¤Items are cutting off room. Make sure the room can be reached from the outside.";
/*     */ 
/*     */   
/*  28 */   private static CharSequence ¤¤NotInside = "Must be placed inside the designated area. You must expand the area before you can place items.";
/*  29 */   private static CharSequence ¤¤NotBlockOther = "Must not block other item.";
/*  30 */   private static CharSequence ¤¤WillBeBlock = "Must not be blocked by other items.";
/*  31 */   private static CharSequence ¤¤WillBlockRoom = "Area is not connected, or an item is cutting off part of the room.";
/*  32 */   private static CharSequence ¤¤ItemsREached = "Max amount of this item is reached.";
/*  33 */   private static CharSequence ¤¤ItemMustREac = "Item must be reachable.";
/*     */   
/*     */   static {
/*  36 */     D.ts(UtilPlacability.class);
/*     */   }
/*     */ 
/*     */   
/*     */   UtilPlacability(RoomPlacer p) {
/*  41 */     D.t(this);
/*  42 */     this.p = p;
/*     */   }
/*     */   
/*     */   public FurnisherItemGroup createProblemGroup() {
/*  46 */     for (FurnisherItemGroup g : this.p.blueprint().constructor().groups()) {
/*  47 */       if (this.p.resources.groups(g) < g.min) {
/*  48 */         return g;
/*     */       }
/*     */     } 
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public CharSequence createProblem(AREA instance) {
/*  55 */     this.sError.clear();
/*     */     
/*  57 */     if (instance.area() < 1) {
/*  58 */       return (CharSequence)this.sError.add(¤¤TooSmall);
/*     */     }
/*     */ 
/*     */     
/*  62 */     if (this.p.blueprint().constructor().constructionProblem(instance) != null) {
/*  63 */       return this.p.blueprint().constructor().constructionProblem(instance);
/*     */     }
/*     */     
/*  66 */     for (FurnisherItemGroup g : this.p.blueprint().constructor().groups()) {
/*  67 */       if (this.p.resources.groups(g) < g.min) {
/*  68 */         return (CharSequence)this.sError.add(¤¤NotEnoughItems).insert(0, g.name());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  73 */     for (int si = 0; si < this.p.blueprint().constructor().stats().size(); si++) {
/*     */       
/*  75 */       FurnisherStat s = (FurnisherStat)this.p.blueprint().constructor().stats().get(si);
/*  76 */       if (this.p.itemStats(s.index()) < s.min) {
/*  77 */         return (CharSequence)this.sError.add(¤¤NotEnough).insert(0, s.name());
/*     */       }
/*     */     } 
/*     */     
/*  81 */     if (!checkAccess(instance)) {
/*  82 */       return ¤¤BlockingSelf;
/*     */     }
/*     */     
/*  85 */     if (isDisconnected(instance)) {
/*  86 */       return ¤¤Disconnected;
/*     */     }
/*     */     
/*  89 */     GUTIL.filler().init(this);
/*  90 */     fillFirst(instance);
/*  91 */     int a = instance.area();
/*  92 */     while (GUTIL.filler().hasMore()) {
/*  93 */       COORDINATE c = GUTIL.filler().poll();
/*     */ 
/*     */       
/*  96 */       a--;
/*  97 */       for (DIR d : DIR.ORTHO) {
/*  98 */         if (instance.is(c, d)) {
/*     */           
/* 100 */           if ((SETT.ROOMS()).fData.blocking.is(c)) {
/*     */             
/* 102 */             if ((SETT.ROOMS()).fData.blocking.is(c, d))
/* 103 */               GUTIL.filler().fill(c, d); 
/*     */             continue;
/*     */           } 
/* 106 */           GUTIL.filler().fill(c, d);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 113 */     GUTIL.filler().done();
/* 114 */     if (a > 0) {
/* 115 */       return ¤¤Disconnected;
/*     */     }
/*     */     
/* 118 */     if (this.p.autoWalls.is())
/* 119 */       return this.p.door.createProblem(); 
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isDisconnected(AREA instance) {
/* 126 */     if (instance.area() == 0)
/* 127 */       return false; 
/* 128 */     GUTIL.filler().init(this);
/* 129 */     fillFirst(instance);
/* 130 */     int a = instance.area();
/* 131 */     while (GUTIL.filler().hasMore()) {
/* 132 */       COORDINATE c = GUTIL.filler().poll();
/* 133 */       a--;
/* 134 */       for (DIR d : DIR.ORTHO) {
/* 135 */         if (instance.is(c, d)) {
/*     */           
/* 137 */           if ((SETT.ROOMS()).fData.blocking.is(c)) {
/*     */             
/* 139 */             if ((SETT.ROOMS()).fData.blocking.is(c, d))
/* 140 */               GUTIL.filler().fill(c, d); 
/*     */             continue;
/*     */           } 
/* 143 */           GUTIL.filler().fill(c, d);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 150 */     GUTIL.filler().done();
/* 151 */     if (a > 0) {
/* 152 */       return true;
/*     */     }
/* 154 */     return false;
/*     */   }
/*     */   
/*     */   private boolean checkAccess(AREA instance) {
/* 158 */     boolean allBlocked = true;
/* 159 */     for (COORDINATE c : instance.body()) {
/* 160 */       if (instance.is(c)) {
/* 161 */         boolean blocked = !(((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(c)).player >= 0.0D && !(SETT.PATH()).solidity.is(c));
/* 162 */         allBlocked &= blocked;
/* 163 */         if (!blocked) {
/* 164 */           for (DIR d : DIR.ORTHO) {
/* 165 */             if (!instance.is(c, d) && 
/* 166 */               ((AVAILABILITY)(SETT.ROOMS()).fData.availability.get(c, d)).player > 0.0D && !(SETT.PATH()).solidity.is(c, d)) {
/* 167 */               return true;
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     return allBlocked;
/*     */   }
/*     */   
/*     */   private void fillFirst(AREA instance) {
/* 178 */     for (COORDINATE c : instance.body()) {
/* 179 */       if (instance.is(c) && 
/* 180 */         !(SETT.ROOMS()).fData.blocking.is(c)) {
/* 181 */         GUTIL.filler().fill(c);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 186 */     for (COORDINATE c : instance.body()) {
/* 187 */       if (instance.is(c)) {
/* 188 */         GUTIL.filler().fill(c);
/*     */         return;
/*     */       } 
/*     */     } 
/* 192 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence itemPlacable(int tx, int ty, int rx, int ry, FurnisherItem item, AREA a) {
/* 199 */     FurnisherItemTile t = item.get(rx, ry);
/*     */     
/* 201 */     if (t == null) {
/* 202 */       return null;
/*     */     }
/* 204 */     if (!a.is(tx, ty)) {
/* 205 */       return ¤¤NotInside;
/*     */     }
/* 207 */     if ((SETT.ROOMS()).fData.tile.is(tx, ty)) {
/* 208 */       return ¤¤WillBeBlock;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     CharSequence s = t.isPlacable(tx, ty, (MAP_BOOLEAN)a, item, rx, ry);
/* 215 */     if (s != null) {
/* 216 */       return s;
/*     */     }
/*     */     
/* 219 */     if (t.mustBeReachable) {
/* 220 */       int b = 0;
/* 221 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 222 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 223 */         if (item.get(rx, ry, d) != null && ((FurnisherItemTile)item.get(rx, ry, d)).isBlocker()) {
/* 224 */           b++;
/* 225 */         } else if (!a.is(tx, ty, d) || (SETT.ROOMS()).fData.blocking.is(tx, ty, d)) {
/* 226 */           b++;
/*     */         } 
/*     */       } 
/* 229 */       if (b == 4) {
/* 230 */         return ¤¤ItemMustREac;
/*     */       }
/*     */     } 
/*     */     
/* 234 */     if (t.isBlocker()) {
/* 235 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 236 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 237 */         if (otherItemWillBeBlocked(tx, ty, item, rx, ry, d, a)) {
/* 238 */           return String.valueOf(¤¤NotBlockOther) + " 1";
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 244 */     return null;
/*     */   }
/*     */   
/*     */   private boolean otherItemWillBeBlocked(int tx, int ty, FurnisherItem item, int rx, int ry, DIR dir, AREA a) {
/* 248 */     tx += dir.x();
/* 249 */     ty += dir.y();
/* 250 */     rx += dir.x();
/* 251 */     ry += dir.y();
/*     */     
/* 253 */     if (a.is(tx, ty) && (SETT.ROOMS()).fData.mustReach.is(tx, ty)) {
/* 254 */       int b = 0;
/* 255 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 256 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 257 */         FurnisherItemTile t = (FurnisherItemTile)item.get(rx, ry, d);
/* 258 */         if (t != null && t.isBlocker()) {
/* 259 */           b++;
/* 260 */         } else if (!a.is(tx, ty, d) || (SETT.ROOMS()).fData.blocking.is(tx, ty, d)) {
/* 261 */           b++;
/*     */         } 
/* 263 */       }  return (b == 4);
/*     */     } 
/* 265 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence itemProblem(int x1, int y1, FurnisherItemGroup group, FurnisherItem item, AREA a) {
/* 274 */     if (this.p.resources.groups(group) >= group.max) {
/* 275 */       return ¤¤ItemsREached;
/*     */     }
/*     */     int y;
/* 278 */     for (y = 0; y < item.height(); y++) {
/* 279 */       for (int x = 0; x < item.width(); x++) {
/* 280 */         int tx = x + x1;
/* 281 */         int ty = y + y1;
/* 282 */         CharSequence s = itemPlacable(tx, ty, x, y, item, a);
/* 283 */         if (s != null) {
/* 284 */           return s;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 289 */     GUTIL.filler().init(this);
/*     */     
/* 291 */     for (y = 0; y < item.height(); y++) {
/* 292 */       for (int x = 0; x < item.width(); x++) {
/* 293 */         FurnisherItemTile t = item.get(x, y);
/* 294 */         if (t != null && t.isBlocker()) {
/* 295 */           int tx = x + x1;
/* 296 */           int ty = y + y1;
/* 297 */           (GUTIL.filler()).closer.set(tx, ty);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 302 */     for (y = -1; y <= item.height(); y++) {
/* 303 */       for (int x = -1; x <= item.width(); x++) {
/* 304 */         if (x == -1 || x == item.width() || y == -1 || y == item.height())
/*     */         {
/* 306 */           if (x != -1 || y != -1)
/*     */           {
/* 308 */             if (x != -1 || y != item.height())
/*     */             {
/* 310 */               if (x != item.width() || y != -1)
/*     */               {
/* 312 */                 if (x != item.width() || y != item.height()) {
/*     */ 
/*     */                   
/* 315 */                   int tx = x + x1;
/* 316 */                   int ty = y + y1;
/* 317 */                   if (checkIfOtherTileBlocked(tx, ty, a) || checkIfOtherItemBlocked(tx, ty, a)) {
/* 318 */                     GUTIL.filler().done();
/* 319 */                     return String.valueOf(¤¤NotBlockOther) + " 2 " + String.valueOf(¤¤NotBlockOther) + " " + checkIfOtherTileBlocked(tx, ty, a);
/*     */                   } 
/*     */                 }  }  }  } 
/*     */         }
/*     */       } 
/*     */     } 
/* 325 */     boolean first = false;
/* 326 */     int area = 0;
/* 327 */     for (COORDINATE c : a.body()) {
/* 328 */       if (!a.is(c))
/*     */         continue; 
/* 330 */       if (!(GUTIL.filler()).isser.is(c.x(), c.y()) && !isBlockerTile(c.x(), c.y(), a)) {
/* 331 */         area++;
/* 332 */         if (!first) {
/* 333 */           (GUTIL.filler()).filler.set(c);
/* 334 */           first = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 339 */     while (GUTIL.filler().hasMore()) {
/* 340 */       COORDINATE c = GUTIL.filler().poll();
/* 341 */       area--;
/* 342 */       for (DIR d : DIR.ORTHO) {
/* 343 */         int dx = c.x() + d.x();
/* 344 */         int dy = c.y() + d.y();
/* 345 */         if (a.is(dx, dy) && !isBlockerTile(dx, dy, a)) {
/* 346 */           GUTIL.filler().fill(dx, dy);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 351 */     GUTIL.filler().done();
/*     */     
/* 353 */     if (area != 0) {
/* 354 */       return ¤¤WillBlockRoom;
/*     */     }
/*     */     
/* 357 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean checkIfOtherTileBlocked(int tx, int ty, AREA a) {
/* 363 */     if (!a.is(tx, ty))
/* 364 */       return false; 
/* 365 */     FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 366 */     if (t == null || !t.mustBeReachable) {
/* 367 */       return false;
/*     */     }
/* 369 */     COORDINATE c = (SETT.ROOMS()).fData.itemMaster(tx, ty, Coo.TMP);
/* 370 */     int mx = c.x();
/* 371 */     int my = c.y();
/*     */     
/* 373 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 374 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 375 */       int dx = tx + d.x();
/* 376 */       int dy = ty + d.y();
/* 377 */       if (a.is(dx, dy))
/*     */       {
/* 379 */         if (!(GUTIL.filler()).isser.is(dx, dy)) {
/*     */           
/* 381 */           t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(dx, dy);
/* 382 */           if (t == null)
/* 383 */             return false; 
/* 384 */           if (!t.isBlocker()) {
/*     */             
/* 386 */             c = (SETT.ROOMS()).fData.itemMaster(dx, dy, Coo.TMP);
/* 387 */             if (c.x() != mx || c.y() != my)
/*     */             {
/*     */               
/* 390 */               if (t.isNotBlocker())
/* 391 */                 return false;  } 
/*     */           } 
/*     */         }  } 
/* 394 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkIfOtherItemBlocked(int tx, int ty, AREA a) {
/* 399 */     if (!a.is(tx, ty))
/* 400 */       return false; 
/* 401 */     FurnisherItem item = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 402 */     if (item == null) {
/* 403 */       return false;
/*     */     }
/* 405 */     COORDINATE c = (SETT.ROOMS()).fData.itemMaster(tx, ty, Coo.TMP);
/*     */     
/* 407 */     tx = c.x() - item.firstX();
/* 408 */     ty = c.y() - item.firstY();
/*     */     
/* 410 */     for (int y = 0; y < item.height(); y++) {
/* 411 */       for (int x = 0; x < item.width(); x++) {
/* 412 */         if (x == 0 || x == item.width() - 1 || y == 0 || y == item.height() - 1) {
/* 413 */           int dx = x + tx;
/* 414 */           int dy = y + ty;
/* 415 */           if (!isBlockedTile(dx, dy, a)) {
/* 416 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 421 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isBlockerTile(int tx, int ty, AREA a) {
/* 426 */     if (!a.is(tx, ty))
/* 427 */       return true; 
/* 428 */     if ((GUTIL.filler()).isser.is(tx, ty))
/* 429 */       return true; 
/* 430 */     FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 431 */     return (t != null && t.isBlocker());
/*     */   }
/*     */   
/*     */   private boolean isBlockedTile(int tx, int ty, AREA a) {
/* 435 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 436 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 437 */       int dx = tx + d.x();
/* 438 */       int dy = ty + d.y();
/* 439 */       if (!isBlockerTile(dx, dy, a))
/* 440 */         return false; 
/*     */     } 
/* 442 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilPlacability.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */