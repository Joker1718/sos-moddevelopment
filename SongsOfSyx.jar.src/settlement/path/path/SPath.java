/*     */ package settlement.path.path;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFINDER;
/*     */ import settlement.path.finders.SPathFinder;
/*     */ import settlement.path.thread.FinderThread;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ 
/*     */ 
/*     */ public class SPath
/*     */   extends PathGame.PathFancy
/*     */ {
/*     */   protected short destX;
/*     */   protected short destY;
/*     */   protected boolean successful = false;
/*     */   protected boolean arrived = false;
/*     */   private boolean full = false;
/*     */   public static final int size = 256;
/*     */   private int sx;
/*     */   private int sy;
/*     */   
/*     */   public SPath() {
/*  39 */     super(256);
/*     */ 
/*     */ 
/*     */     
/*  43 */     this.thread = new FinderThread.ThreadPath();
/*     */   }
/*     */   private static Text t = (UI.FONT()).M.getText(5).adjustWidth();
/*     */   
/*     */   public void save(FilePutter file) {
/*  48 */     file.i(this.destX).i(this.destY).i(this.sx).i(this.sy);
/*  49 */     file.bool(this.successful).bool(this.arrived).bool(this.full);
/*  50 */     super.save(file);
/*     */   }
/*     */   public final FinderThread.ThreadPath thread;
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  55 */     this.destX = (short)file.i();
/*  56 */     this.destY = (short)file.i();
/*  57 */     this.sx = file.i();
/*  58 */     this.sy = file.i();
/*  59 */     this.successful = file.bool();
/*  60 */     this.arrived = file.bool();
/*  61 */     this.full = file.bool();
/*     */ 
/*     */ 
/*     */     
/*  65 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int offsetX, int offsetY) {
/*  70 */     if (!this.successful)
/*     */       return; 
/*  72 */     if (length() == 0) {
/*     */       return;
/*     */     }
/*  75 */     COLOR.YELLOW100.bind();
/*     */     
/*  77 */     int i = 0;
/*  78 */     t.clear();
/*     */     
/*  80 */     SPRITE s = (SPRITES.cons()).ICO.crosshair;
/*     */     
/*  82 */     int tileI = getCurrentI();
/*     */     
/*  84 */     int x = x() * 64 + offsetX;
/*  85 */     int y = y() * 64 + offsetY;
/*  86 */     int d = 0;
/*  87 */     s.render(r, x + d, y + d);
/*  88 */     t.clear().add(i++);
/*  89 */     t.render(r, x, y);
/*     */     
/*  91 */     while (super.setNext()) {
/*  92 */       t.clear().add(i++);
/*  93 */       x = x() * 64 + offsetX;
/*  94 */       y = y() * 64 + offsetY;
/*  95 */       s.render(r, x + d, y + d);
/*  96 */       t.render(r, x, y);
/*     */     } 
/*     */     
/*  99 */     COLOR.unbind();
/*     */     
/* 101 */     setCurrentI(tileI);
/*     */   }
/*     */   
/*     */   public boolean request(int startX, int startY, SFINDER f, int maxDistance) {
/* 105 */     this.full = false;
/* 106 */     this.sx = startX;
/* 107 */     this.sy = startY;
/* 108 */     this.destX = -1;
/* 109 */     this.destY = -1;
/* 110 */     this.successful = false;
/*     */     
/* 112 */     if (setNear(startX, startY, f, this.full)) {
/* 113 */       this.successful = true;
/* 114 */       return true;
/*     */     } 
/*     */     
/* 117 */     SPathFinder.SPathUtilResult r = (SETT.PATH()).finders.finder().find(startX, startY, f, maxDistance);
/* 118 */     if (r != null) {
/* 119 */       this.successful = true;
/* 120 */       this.destX = (short)r.destX;
/* 121 */       this.destY = (short)r.destY;
/* 122 */       PathTile t = r.t;
/* 123 */       sett(t);
/*     */     } 
/*     */ 
/*     */     
/* 127 */     return this.successful;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean request(Humanoid start, int dx, int dy) {
/* 132 */     return request(start.tc().x(), start.tc().y(), dx, dy, false);
/*     */   }
/*     */   
/*     */   public boolean request(COORDINATE start, COORDINATE to) {
/* 136 */     return request(start.x(), start.y(), to.x(), to.y(), false);
/*     */   }
/*     */   
/*     */   public boolean request(COORDINATE start, int dx, int dy) {
/* 140 */     return request(start.x(), start.y(), dx, dy, false);
/*     */   }
/*     */   
/*     */   public boolean request(int sx, int sy, COORDINATE to) {
/* 144 */     return request(sx, sy, to.x(), to.y(), false);
/*     */   }
/*     */   
/*     */   public boolean requestFull(COORDINATE start, COORDINATE to) {
/* 148 */     return request(start.x(), start.y(), to.x(), to.y(), true);
/*     */   }
/*     */   
/*     */   public boolean requestFull(COORDINATE start, int dx, int dy) {
/* 152 */     return request(start.x(), start.y(), dx, dy, true);
/*     */   }
/*     */   
/*     */   public boolean requestFull(int sx, int sy, int dx, int dy) {
/* 156 */     return request(sx, sy, dx, dy, true);
/*     */   }
/*     */   
/*     */   public boolean request(int startX, int startY, int destX, int destY, boolean full) {
/* 160 */     this.full = full;
/* 161 */     this.sx = startX;
/* 162 */     this.sy = startY;
/* 163 */     this.destX = (short)destX;
/* 164 */     this.destY = (short)destY;
/* 165 */     this.successful = false;
/*     */     
/* 167 */     if (!SETT.TILE_BOUNDS.holdsPoint(this.sx, this.sy)) {
/* 168 */       clear();
/* 169 */       return false;
/*     */     } 
/*     */     
/* 172 */     if (full && !SETT.IN_BOUNDS(destX, destY)) {
/* 173 */       if (!SETT.IN_BOUNDS(destX, destY)) {
/* 174 */         clear();
/* 175 */         return false;
/*     */       }
/*     */     
/* 178 */     } else if (!SETT.TILE_BOUNDS.touches(destX, destY)) {
/* 179 */       clear();
/* 180 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 184 */     this.successful = false;
/*     */     
/* 186 */     if (!SETT.TILE_BOUNDS.holdsPoint(startX, startY)) {
/* 187 */       return false;
/*     */     }
/*     */     
/* 190 */     if (full && ((SETT.PATH()).availability.get(destX, destY)).player < 0.0D) {
/* 191 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 195 */     if (setNear(startX, startY, destX, destY, full)) {
/* 196 */       this.successful = true;
/* 197 */       return true;
/*     */     } 
/*     */     
/* 200 */     PathTile t = (SETT.PATH()).finders.finder().find(startX, startY, destX, destY, full);
/*     */     
/* 202 */     if (t != null) {
/* 203 */       sett(t);
/*     */       
/* 205 */       this.successful = true;
/*     */     } 
/*     */     
/* 208 */     return this.successful;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean resumeThreaded(int startX, int startY) {
/* 218 */     this.successful = false;
/*     */     
/* 220 */     if (!SETT.TILE_BOUNDS.holdsPoint(startX, startY)) {
/* 221 */       return false;
/*     */     }
/*     */     
/* 224 */     if (this.full && ((SETT.PATH()).availability.get(this.destX, this.destY)).player < 0.0D) {
/* 225 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 229 */     if (setNear(startX, startY, this.destX, this.destY, this.full)) {
/* 230 */       this.successful = true;
/* 231 */       return true;
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
/* 243 */     if (this.thread.isProcessed(startX, startY, this.destX, this.destY)) {
/* 244 */       if (this.thread.isSuccess()) {
/* 245 */         this.arrived = this.thread.path.isCompleate();
/* 246 */         this.thread.path.copyTo(this);
/* 247 */         this.thread.path.setCurrentI(0);
/* 248 */         while (this.thread.path.hasNext()) {
/* 249 */           (SETT.PATH()).huristics.set(this.thread.path.x(), this.thread.path.y());
/* 250 */           this.thread.path.setNext();
/*     */         } 
/*     */         
/* 253 */         setCurrentI(0);
/* 254 */         this.successful = true;
/* 255 */         if (this.full && (this.thread.destX != this.destX || this.thread.destY != this.destY)) {
/* 256 */           (SETT.PATH()).thread.prep(this, this.thread.destX, this.thread.destY, this.destX, this.destY, this.full);
/* 257 */         } else if (Math.abs(this.thread.destX - this.destX) + Math.abs(this.thread.destY - this.destY) > 1) {
/* 258 */           (SETT.PATH()).thread.prep(this, this.thread.destX, this.thread.destY, this.destX, this.destY, this.full);
/*     */         } 
/*     */       } 
/*     */       
/* 262 */       return this.successful;
/*     */     } 
/*     */     
/* 265 */     PathTile t = (SETT.PATH()).finders.finder().find(startX, startY, this.destX, this.destY, this.full);
/*     */ 
/*     */     
/* 268 */     if (t != null) {
/* 269 */       sett(t);
/*     */       
/* 271 */       this.successful = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     return this.successful;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setNear(int startX, int startY, SFINDER f, boolean full) {
/* 283 */     if (f.isTile(startX, startY, 0)) {
/* 284 */       this.destX = (short)startX;
/* 285 */       this.destY = (short)startY;
/* 286 */       return setNear(startX, startY, startX, startY, full);
/*     */     } 
/*     */     
/* 289 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 290 */       int destX = startX + ((DIR)DIR.ORTHO.get(i)).x();
/* 291 */       int destY = startY + ((DIR)DIR.ORTHO.get(i)).y();
/* 292 */       if (f.isTile(destX, destY, 0) && 
/* 293 */         setNear(startX, startY, destX, destY, full)) {
/* 294 */         this.destX = (short)destX;
/* 295 */         this.destY = (short)destY;
/*     */       } 
/*     */     } 
/*     */     
/* 299 */     return false;
/*     */   }
/*     */   
/*     */   private boolean setNear(int startX, int startY, int destX, int destY, boolean full) {
/* 303 */     if (startX == destX && startY == destY) {
/* 304 */       if (full) {
/* 305 */         setOne(startX, startY);
/* 306 */         return true;
/*     */       } 
/*     */       
/* 309 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 310 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 311 */         if (SETT.IN_BOUNDS(destX, destY, d) && ((AVAILABILITY)(SETT.PATH()).availability.get(destX, destY, d)).player > 0.0D) {
/* 312 */           setTwo(startX, startY, startX + d.x(), startY + d.y());
/* 313 */           return true;
/*     */         } 
/*     */       } 
/* 316 */       return false;
/*     */     } 
/*     */     
/* 319 */     if (Math.abs(startX - destX) + Math.abs(startY - destY) == 1) {
/* 320 */       if (full) {
/* 321 */         setTwo(startX, startY, destX, destY);
/* 322 */         return true;
/*     */       } 
/* 324 */       setOne(startX, startY);
/* 325 */       return true;
/*     */     } 
/* 327 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean resume(COORDINATE start, RECTANGLE body) {
/* 332 */     if (!this.successful) {
/* 333 */       return false;
/*     */     }
/* 335 */     if (start.isSameAs((COORDINATE)this)) {
/* 336 */       return !(SETT.PATH()).solidity.is((COORDINATE)this);
/*     */     }
/* 338 */     if ((SETT.PATH()).solidity.is((COORDINATE)this)) {
/* 339 */       return request(start.x(), start.y(), this.destX, this.destY, this.full);
/*     */     }
/*     */     
/* 342 */     int x = x();
/* 343 */     int y = y();
/* 344 */     if (setPrev() && start.isSameAs((COORDINATE)this) && 
/* 345 */       (SETT.PATH()).coster.player.getCost(start.x(), start.y(), x, y) >= 0.0D) {
/* 346 */       return true;
/*     */     }
/*     */     
/* 349 */     return request(start.x(), start.y(), this.destX, this.destY, this.full);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNext() {
/* 356 */     if (!this.successful) {
/* 357 */       throw new RuntimeException();
/*     */     }
/* 359 */     if (isDest()) {
/* 360 */       return false;
/*     */     }
/* 362 */     if (!hasNext()) {
/* 363 */       resumeThreaded(x(), y());
/* 364 */       super.setNext();
/*     */     } else {
/* 366 */       super.setNext();
/*     */     } 
/*     */     
/* 369 */     return this.successful;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSettCX() {
/* 377 */     return (x() << 6) + 32;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSettCY() {
/* 385 */     return (y() << 6) + 32;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDest() {
/* 392 */     if (!this.successful)
/* 393 */       return false; 
/* 394 */     if (hasNext())
/* 395 */       return false; 
/* 396 */     if (this.full) {
/* 397 */       return (x() == this.destX && y() == this.destY);
/*     */     }
/* 399 */     return (Math.abs(x() - this.destX) + Math.abs(y() - this.destY) == 1);
/*     */   }
/*     */   
/*     */   public boolean isSuccessful() {
/* 403 */     return this.successful;
/*     */   }
/*     */   
/*     */   public short destX() {
/* 407 */     return this.destX;
/*     */   }
/*     */   
/*     */   public short destY() {
/* 411 */     return this.destY;
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/* 415 */     return this.full;
/*     */   }
/*     */   
/*     */   public String toDebugString() {
/* 419 */     return "((" + this.sx + "," + this.sy + ") --> (" + this.destX + "," + this.destY + ") succ:" + isSuccessful() + ", dest:" + isDest() + "\n " + 
/* 420 */       x() + " " + y() + " " + length() + " " + getCurrentI();
/*     */   }
/*     */   
/*     */   public static double LAST_DISTANCE() {
/* 424 */     return ((SETT.PATH()).finders.finder()).lastDistance;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 429 */     this.successful = false;
/* 430 */     this.full = false;
/* 431 */     super.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   private void sett(PathTile t) {
/* 436 */     set(t);
/*     */     
/* 438 */     if ((this.full && !t.isSameAs(this.destX, this.destY)) || (!this.full && Math.abs(t.x() - this.destX) + Math.abs(t.y() - this.destY) > 1))
/*     */     {
/* 440 */       (SETT.PATH()).thread.prep(this, t.x(), t.y(), this.destX, this.destY, this.full);
/*     */     }
/*     */     
/* 443 */     while (t != null) {
/* 444 */       (SETT.PATH()).huristics.set(t.x(), t.y());
/* 445 */       t = t.getParent();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDirect(int sx, int sy, int destX, int destY, PathTile t, boolean full) {
/* 452 */     this.successful = true;
/* 453 */     this.destX = (short)destX;
/* 454 */     this.destY = (short)destY;
/* 455 */     this.sx = sx;
/* 456 */     this.sy = sy;
/* 457 */     this.full = full;
/* 458 */     sett(t);
/* 459 */     this.arrived = isCompleate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void copy(PathGame.PathFancy other, int destX, int destY, boolean full) {
/* 465 */     other.setCurrentI(0);
/* 466 */     other.copyTo(this);
/* 467 */     this.successful = true;
/*     */     
/* 469 */     this.full = full;
/* 470 */     this.sx = other.x();
/* 471 */     this.sy = other.y();
/* 472 */     while (other.hasNext()) {
/* 473 */       (SETT.PATH()).huristics.set(other.x(), other.y());
/* 474 */       other.setNext();
/*     */     } 
/*     */     
/* 477 */     this.destX = (short)destX;
/* 478 */     this.destY = (short)destY;
/* 479 */     this.arrived = other.isCompleate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLength(int ll) {
/* 485 */     super.setLength(ll);
/* 486 */     int iold = getCurrentI();
/* 487 */     while (super.setNext()) {
/* 488 */       this.destX = (short)x();
/* 489 */       this.destY = (short)y();
/*     */     } 
/* 491 */     setCurrentI(iold);
/*     */   }
/*     */ 
/*     */   
/*     */   public void debug() {
/* 496 */     int iold = getCurrentI();
/* 497 */     setCurrentI(0);
/* 498 */     LOG.ln();
/* 499 */     LOG.ln("l:" + length());
/* 500 */     for (int i = 0; i < length(); i++) {
/* 501 */       setCurrentI(i);
/* 502 */       LOG.ln("\t(" + x() + " " + y() + ")");
/*     */     } 
/* 504 */     setCurrentI(iold);
/* 505 */     LOG.ln("" + this.destX + " " + this.destX);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\path\SPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */