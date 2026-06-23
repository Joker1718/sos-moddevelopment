/*     */ package settlement.thing;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RBIT;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectStreamException;
/*     */ import settlement.entity.ESpeed;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.ShortStack;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.statistics.HistoryInt;
/*     */ import view.sett.SETT_HOVERABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class THINGS
/*     */   extends SETT.SettResource
/*     */ {
/*  37 */   private final ArrayList<ThingFactory<?>> all = new ArrayList(16);
/*  38 */   private final Thing[][] grid = new Thing[SETT.THEIGHT][SETT.TWIDTH];
/*  39 */   private final ArrayList<Thing> tmp = new ArrayList(16000);
/*     */   
/*     */   private static final int MAX_OUT_TILES = 2;
/*  42 */   public final Sprites sprites = new Sprites();
/*  43 */   public final ThingsGore gore = new ThingsGore((LISTE<ThingFactory<?>>)this.all, 1.0F, this.sprites);
/*  44 */   public final ThingsResources resources = new ThingsResources((LISTE<ThingFactory<?>>)this.all);
/*  45 */   public final ThingsCorpses corpses = new ThingsCorpses((LISTE<ThingFactory<?>>)this.all);
/*  46 */   public final ThingsCadavers cadavers = new ThingsCadavers((LISTE<ThingFactory<?>>)this.all);
/*  47 */   public final ThingsRubbish rubbish = new ThingsRubbish((LISTE<ThingFactory<?>>)this.all);
/*     */   
/*     */   public THINGS() throws IOException {
/*  50 */     super("THINGS", true);
/*  51 */     ThingPlacer.init();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/*  56 */     if (ds > 0.0D) {
/*  57 */       for (ThingFactory<?> t : this.all) {
/*  58 */         t.update(ds);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void clear() {
/*  64 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  65 */       this.grid[c.y()][c.x()] = null;
/*     */     }
/*  67 */     for (ThingFactory<?> t : this.all) {
/*  68 */       t.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*  73 */     for (ThingFactory<?> t : this.all) {
/*  74 */       t.save(saveFile);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*  79 */     for (ThingFactory<?> t : this.all) {
/*  80 */       t.load(saveFile);
/*     */     }
/*  82 */     super.load(saveFile);
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
/*     */   private void addTile(int tx, int ty) {
/* 105 */     if (!this.tmp.hasRoom())
/*     */       return; 
/* 107 */     if (!SETT.IN_BOUNDS(tx, ty))
/*     */       return; 
/* 109 */     Thing t = this.grid[ty][tx];
/* 110 */     if (t == null) {
/*     */       return;
/*     */     }
/* 113 */     while (t != null && this.tmp.hasRoom()) {
/* 114 */       this.tmp.add(t);
/* 115 */       t = t.next;
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
/*     */   public LISTE<Thing> get(int tx, int ty) {
/* 128 */     this.tmp.clear();
/* 129 */     addTile(tx, ty);
/* 130 */     return (LISTE<Thing>)this.tmp;
/*     */   }
/*     */   
/*     */   public SETT_HOVERABLE getArroundCoo(int x, int y) {
/* 134 */     int tx1 = (x >> 6) - 1;
/* 135 */     int tx2 = (x >> 6) + 1;
/* 136 */     int ty1 = (y >> 6) - 1;
/* 137 */     int ty2 = (y >> 6) + 1;
/* 138 */     double maxDistance = 100000.0D;
/* 139 */     SETT_HOVERABLE h = null;
/* 140 */     for (Thing t : get(tx1, tx2, ty1, ty2)) {
/* 141 */       if (!(t instanceof SETT_HOVERABLE))
/*     */         continue; 
/* 143 */       if (!t.body().holdsPoint(x, y))
/*     */         continue; 
/* 145 */       double d = COORDINATE.properDistance(x, y, t.body().cX(), t.body().cY());
/* 146 */       if (d < maxDistance) {
/* 147 */         maxDistance = d;
/* 148 */         h = (SETT_HOVERABLE)t;
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   public Thing getFirst(int tx, int ty) {
/* 157 */     if (SETT.IN_BOUNDS(tx, ty))
/* 158 */       return this.grid[ty][tx]; 
/* 159 */     return null;
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
/*     */   public LISTE<Thing> get(int tx1, int tx2, int ty1, int ty2) {
/* 171 */     this.tmp.clear();
/* 172 */     for (int y = ty1; y < ty2; y++) {
/* 173 */       for (int x = tx1; x < tx2; x++) {
/* 174 */         addTile(x, y);
/*     */       }
/*     */     } 
/* 177 */     return (LISTE<Thing>)this.tmp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LISTE<Thing> get(RECTANGLE tiles) {
/* 186 */     return get(tiles.x1(), tiles.x2(), tiles.y1(), tiles.y2());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, float ds, RECTANGLE renWin, int offX, int offY) {
/* 192 */     int tx1 = (renWin.x1() >> 6) - 2;
/* 193 */     int tx2 = (renWin.x2() >> 6) + 2;
/* 194 */     int ty1 = (renWin.y1() >> 6) - 2;
/* 195 */     int ty2 = (renWin.y2() >> 6) + 2;
/* 196 */     this.tmp.clear();
/* 197 */     get(tx1, tx2, ty1, ty2);
/*     */     
/* 199 */     int offXs = offX - renWin.x1();
/* 200 */     int offYs = offY - renWin.y1();
/*     */     
/* 202 */     for (int i = 0; i < this.tmp.size(); i++) {
/* 203 */       ((Thing)this.tmp.get(i)).render(r, shadowBatch, ds, offXs, offYs);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderZoomed(Renderer r, RECTANGLE renWin, int offX, int offY) {
/* 210 */     this.resources.renderZoomed(r, renWin, offX, offY);
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class ThingFactory<T extends Thing>
/*     */     implements INDEXED
/*     */   {
/*     */     private final int index;
/* 218 */     private short firstAdded = -1;
/* 219 */     private short lastAdded = -1;
/*     */     private ShortStack free;
/* 221 */     public final HistoryInt addedHistory = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final MAP_OBJECT<T> tGet;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int index() {
/* 232 */       return this.index;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clear() {
/* 238 */       this.firstAdded = -1;
/* 239 */       this.lastAdded = -1;
/* 240 */       this.addedHistory.clear();
/* 241 */       this.free.clear();
/* 242 */       for (int i = this.free.capacity() - 1; i >= 0; i--)
/* 243 */         this.free.push((short)i);  byte b; int j; T[] arrayOfT;
/* 244 */       for (j = (arrayOfT = all()).length, b = 0; b < j; ) { T t = arrayOfT[b];
/* 245 */         t.clear();
/*     */         b++; }
/*     */     
/*     */     }
/*     */     protected void save(FilePutter file) {
/* 250 */       file.mark(this);
/*     */ 
/*     */       
/* 253 */       int am = 0;
/* 254 */       short f = this.firstAdded;
/* 255 */       while (f != -1) {
/* 256 */         f = ((THINGS.Thing)all()[f]).addedNext;
/* 257 */         am++;
/*     */       } 
/*     */       
/* 260 */       file.i(am);
/* 261 */       f = this.firstAdded;
/* 262 */       while (f != -1) {
/* 263 */         file.s(f);
/* 264 */         all()[f].save(file);
/* 265 */         all()[f].saveP(file);
/* 266 */         f = ((THINGS.Thing)all()[f]).addedNext;
/*     */       } 
/* 268 */       this.addedHistory.save(file);
/*     */     }
/*     */     
/*     */     protected void load(FileGetter file) throws IOException {
/* 272 */       file.check(this);
/* 273 */       this.free.clear();
/*     */       
/* 275 */       this.firstAdded = -1;
/* 276 */       this.lastAdded = -1;
/* 277 */       int am = file.i();
/* 278 */       for (int i = 0; i < am; i++) {
/* 279 */         T t = all()[file.s()];
/* 280 */         t.load(file);
/* 281 */         this.free.push(t.index());
/* 282 */         t.loadP(file);
/*     */       } 
/* 284 */       if ((all()).length != this.free.capacity())
/* 285 */         throw new RuntimeException();  byte b; int j;
/*     */       T[] arrayOfT;
/* 287 */       for (j = (arrayOfT = all()).length, b = 0; b < j; ) { T t = arrayOfT[b];
/* 288 */         if (t == null || t.isRemoved()) {
/* 289 */           this.free.push(t.index());
/*     */         }
/*     */         b++; }
/*     */       
/* 293 */       this.addedHistory.load(file);
/* 294 */       this.addedHistory.set(added());
/*     */     }
/*     */     ThingFactory(LISTE<ThingFactory<?>> all, int size) {
/* 297 */       this.tGet = new MAP_OBJECT<T>()
/*     */         {
/*     */           public T get(int tile)
/*     */           {
/* 301 */             throw new RuntimeException();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public T get(int tx, int ty) {
/* 307 */             if (!SETT.IN_BOUNDS(tx, ty))
/* 308 */               return null; 
/* 309 */             THINGS.Thing t = (SETT.THINGS()).grid[ty][tx];
/* 310 */             if (t == null) {
/* 311 */               return null;
/*     */             }
/* 313 */             while (t != null) {
/* 314 */               if (t.factory() == THINGS.ThingFactory.this)
/* 315 */                 return (T)t; 
/* 316 */               t = t.next;
/*     */             } 
/* 318 */             return null;
/*     */           }
/*     */         };
/*     */       this.index = all.add(this);
/*     */       this.free = new ShortStack(size);
/*     */       for (int i = size - 1; i >= 0; i--)
/*     */         this.free.push((short)i); 
/*     */     }
/*     */     void update(double ds) {}
/*     */     private final void remove(THINGS.Thing res) {
/* 328 */       short next = res.addedNext;
/* 329 */       short prev = res.addedPrev;
/*     */       
/* 331 */       if (next != -1) {
/* 332 */         ((THINGS.Thing)all()[next]).addedPrev = prev;
/*     */       }
/*     */       
/* 335 */       if (prev != -1) {
/* 336 */         ((THINGS.Thing)all()[prev]).addedNext = next;
/*     */       }
/*     */       
/* 339 */       if (res.index() == this.firstAdded) {
/* 340 */         this.firstAdded = next;
/*     */       }
/*     */       
/* 343 */       if (res.index() == this.lastAdded) {
/* 344 */         this.lastAdded = prev;
/*     */       }
/*     */ 
/*     */       
/* 348 */       res.addedPrev = -1;
/* 349 */       res.addedNext = -1;
/* 350 */       this.free.push(res.index());
/* 351 */       this.addedHistory.set(added());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private final void add(THINGS.Thing res) {
/* 357 */       if (res.addedNext != -1)
/* 358 */         throw new RuntimeException(); 
/* 359 */       if (res.addedPrev != -1) {
/* 360 */         throw new RuntimeException();
/*     */       }
/* 362 */       int i = this.free.pop();
/* 363 */       this.addedHistory.set(added());
/* 364 */       if (i != res.index()) {
/* 365 */         throw new RuntimeException("" + i + " " + i);
/*     */       }
/* 367 */       if (this.firstAdded == -1) {
/* 368 */         this.firstAdded = res.index();
/* 369 */         this.lastAdded = res.index();
/*     */         
/*     */         return;
/*     */       } 
/* 373 */       ((THINGS.Thing)all()[this.lastAdded]).addedNext = res.index();
/* 374 */       res.addedPrev = this.lastAdded;
/* 375 */       this.lastAdded = res.index();
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
/*     */     T nextInLine() {
/* 397 */       if (this.free.isEmpty()) {
/* 398 */         all()[this.firstAdded].remove();
/*     */       }
/* 400 */       short i = this.free.pop();
/* 401 */       this.free.push(i);
/* 402 */       T res = all()[i];
/*     */       
/* 404 */       if (!res.isRemoved()) {
/* 405 */         throw new RuntimeException("" + this.free.size() + " " + this.free.size());
/*     */       }
/* 407 */       return res;
/*     */     }
/*     */     
/*     */     public int added() {
/* 411 */       return (all()).length - this.free.size();
/*     */     }
/*     */     
/*     */     public int remainingToAdd() {
/* 415 */       return this.free.size();
/*     */     }
/*     */     
/*     */     final T first() {
/* 419 */       if (this.firstAdded >= 0)
/* 420 */         return all()[this.firstAdded]; 
/* 421 */       return null;
/*     */     }
/*     */     
/*     */     final T next(T t) {
/* 425 */       if (((THINGS.Thing)t).addedNext != -1)
/* 426 */         return all()[((THINGS.Thing)t).addedNext]; 
/* 427 */       return null;
/*     */     }
/*     */     
/*     */     protected abstract T[] all();
/*     */   }
/*     */   
/*     */   public static abstract class Thing
/*     */     implements BODY_HOLDER {
/* 435 */     private short ix = -1;
/* 436 */     private short iy = -1;
/* 437 */     short addedNext = -1;
/* 438 */     short addedPrev = -1;
/*     */     private final short index;
/*     */     private Thing next;
/*     */     private Thing prev;
/* 442 */     protected final RBIT.RBITImp resourcemask = new RBIT.RBITImp();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract void render(Renderer param1Renderer, ShadowBatch param1ShadowBatch, float param1Float, int param1Int1, int param1Int2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Thing(int index) {
/* 453 */       this.index = (short)index;
/*     */     }
/*     */     
/*     */     public final boolean isRemoved() {
/* 457 */       return (this.ix == -1);
/*     */     }
/*     */     
/*     */     public final void remove() {
/* 461 */       if (this.ix == -1)
/* 462 */         throw new RuntimeException(); 
/* 463 */       THINGS m = SETT.THINGS();
/* 464 */       this.resourcemask.clear();
/* 465 */       if (this.next != null) {
/* 466 */         this.next.prev = this.prev;
/*     */       }
/* 468 */       if (this.prev != null) {
/* 469 */         this.prev.next = this.next;
/*     */       }
/*     */       
/* 472 */       if (m.grid[this.iy][this.ix] == this) {
/* 473 */         m.grid[this.iy][this.ix] = this.next;
/*     */       }
/*     */       
/* 476 */       this.next = null;
/* 477 */       this.prev = null;
/* 478 */       this.ix = -1;
/* 479 */       factory().remove(this);
/* 480 */       removeAction();
/*     */     }
/*     */     
/*     */     Object readResolve() throws ObjectStreamException {
/* 484 */       if (!isRemoved())
/* 485 */         addColdAsHell(); 
/* 486 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void addAction() {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected void removeAction() {}
/*     */ 
/*     */     
/*     */     final void addColdAsHell() {
/* 499 */       THINGS m = SETT.THINGS();
/* 500 */       this.next = null;
/* 501 */       if (m.grid[this.iy][this.ix] == null) {
/* 502 */         m.grid[this.iy][this.ix] = this;
/*     */         
/*     */         return;
/*     */       } 
/* 506 */       this.resourcemask.or((RBIT)(m.grid[this.iy][this.ix]).resourcemask);
/*     */       
/* 508 */       if (m.grid[this.iy][this.ix].z() >= z()) {
/* 509 */         (m.grid[this.iy][this.ix]).prev = this;
/* 510 */         this.next = m.grid[this.iy][this.ix];
/* 511 */         m.grid[this.iy][this.ix] = this;
/*     */         
/*     */         return;
/*     */       } 
/* 515 */       Thing parent = m.grid[this.iy][this.ix];
/* 516 */       while (parent.next != null && parent.next.z() < z()) {
/* 517 */         parent = parent.next;
/*     */       }
/* 519 */       if (parent.next != null) {
/* 520 */         parent.next.prev = this;
/* 521 */         this.next = parent.next;
/*     */       } 
/*     */       
/* 524 */       parent.next = this;
/* 525 */       this.prev = parent;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final void add() {
/* 533 */       if (this.ix != -1)
/* 534 */         throw new RuntimeException(); 
/* 535 */       this.ix = (short)ctx();
/* 536 */       this.iy = (short)cty();
/* 537 */       if (!SETT.TILE_BOUNDS.holdsPoint(this.ix, this.iy)) {
/* 538 */         this.ix = -1;
/*     */         
/*     */         return;
/*     */       } 
/* 542 */       addColdAsHell();
/* 543 */       if (factory() != null)
/* 544 */         factory().add(this); 
/* 545 */       addAction();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void move(ESpeed speed, double ds, float restituion, RECTANGLEE body, boolean tileCollide) {
/* 551 */       body.incrX(speed.x() * ds);
/* 552 */       body.incrY(speed.y() * ds);
/*     */       
/* 554 */       if (this.ix != ctx() || this.iy != cty()) {
/* 555 */         if (!isRemoved())
/* 556 */           remove(); 
/* 557 */         add();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void move() {
/* 563 */       if (this.ix != ctx() || this.iy != cty()) {
/* 564 */         remove();
/* 565 */         add();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int ctx() {
/* 571 */       return body().cX() >> 6;
/*     */     }
/*     */     
/*     */     public int cty() {
/* 575 */       return body().cY() >> 6;
/*     */     }
/*     */     
/*     */     protected abstract int z();
/*     */     
/*     */     final void saveP(FilePutter f) {
/* 581 */       f.bool(!isRemoved());
/* 582 */       this.resourcemask.save(f);
/*     */     }
/*     */     
/*     */     final void loadP(FileGetter f) throws IOException {
/* 586 */       clear();
/*     */       
/* 588 */       if (f.bool()) {
/* 589 */         this.resourcemask.load(f);
/* 590 */         this.ix = (short)ctx();
/* 591 */         this.iy = (short)cty();
/* 592 */         addColdAsHell();
/* 593 */         factory().add(this);
/*     */       } 
/*     */     }
/*     */     
/*     */     final void clear() {
/* 598 */       this.addedNext = -1;
/* 599 */       this.addedPrev = -1;
/* 600 */       this.next = null;
/* 601 */       this.prev = null;
/* 602 */       this.ix = -1;
/* 603 */       this.iy = -1;
/*     */     }
/*     */     
/*     */     protected abstract void save(FilePutter param1FilePutter);
/*     */     
/*     */     protected abstract void load(FileGetter param1FileGetter) throws IOException;
/*     */     
/*     */     public short index() {
/* 611 */       return this.index;
/*     */     }
/*     */     
/*     */     public abstract THINGS.ThingFactory<?> factory();
/*     */     
/*     */     public Thing tileNext() {
/* 617 */       return this.next;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\THINGS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */