/*     */ package settlement.thing;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.ShortStack;
/*     */ import util.statistics.HistoryInt;
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
/*     */ public abstract class ThingFactory<T extends THINGS.Thing>
/*     */   implements INDEXED
/*     */ {
/*     */   private final int index;
/* 218 */   private short firstAdded = -1;
/* 219 */   private short lastAdded = -1;
/*     */   private ShortStack free;
/* 221 */   public final HistoryInt addedHistory = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_OBJECT<T> tGet;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/* 232 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 238 */     this.firstAdded = -1;
/* 239 */     this.lastAdded = -1;
/* 240 */     this.addedHistory.clear();
/* 241 */     this.free.clear();
/* 242 */     for (int i = this.free.capacity() - 1; i >= 0; i--)
/* 243 */       this.free.push((short)i);  byte b; int j; T[] arrayOfT;
/* 244 */     for (j = (arrayOfT = all()).length, b = 0; b < j; ) { T t = arrayOfT[b];
/* 245 */       t.clear();
/*     */       b++; }
/*     */   
/*     */   }
/*     */   protected void save(FilePutter file) {
/* 250 */     file.mark(this);
/*     */ 
/*     */     
/* 253 */     int am = 0;
/* 254 */     short f = this.firstAdded;
/* 255 */     while (f != -1) {
/* 256 */       f = ((THINGS.Thing)all()[f]).addedNext;
/* 257 */       am++;
/*     */     } 
/*     */     
/* 260 */     file.i(am);
/* 261 */     f = this.firstAdded;
/* 262 */     while (f != -1) {
/* 263 */       file.s(f);
/* 264 */       all()[f].save(file);
/* 265 */       all()[f].saveP(file);
/* 266 */       f = ((THINGS.Thing)all()[f]).addedNext;
/*     */     } 
/* 268 */     this.addedHistory.save(file);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 272 */     file.check(this);
/* 273 */     this.free.clear();
/*     */     
/* 275 */     this.firstAdded = -1;
/* 276 */     this.lastAdded = -1;
/* 277 */     int am = file.i();
/* 278 */     for (int i = 0; i < am; i++) {
/* 279 */       T t = all()[file.s()];
/* 280 */       t.load(file);
/* 281 */       this.free.push(t.index());
/* 282 */       t.loadP(file);
/*     */     } 
/* 284 */     if ((all()).length != this.free.capacity())
/* 285 */       throw new RuntimeException();  byte b; int j;
/*     */     T[] arrayOfT;
/* 287 */     for (j = (arrayOfT = all()).length, b = 0; b < j; ) { T t = arrayOfT[b];
/* 288 */       if (t == null || t.isRemoved()) {
/* 289 */         this.free.push(t.index());
/*     */       }
/*     */       b++; }
/*     */     
/* 293 */     this.addedHistory.load(file);
/* 294 */     this.addedHistory.set(added());
/*     */   }
/*     */   ThingFactory(LISTE<ThingFactory<?>> all, int size) {
/* 297 */     this.tGet = new MAP_OBJECT<T>()
/*     */       {
/*     */         public T get(int tile)
/*     */         {
/* 301 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public T get(int tx, int ty) {
/* 307 */           if (!SETT.IN_BOUNDS(tx, ty))
/* 308 */             return null; 
/* 309 */           THINGS.Thing t = (SETT.THINGS()).grid[ty][tx];
/* 310 */           if (t == null) {
/* 311 */             return null;
/*     */           }
/* 313 */           while (t != null) {
/* 314 */             if (t.factory() == THINGS.ThingFactory.this)
/* 315 */               return (T)t; 
/* 316 */             t = t.next;
/*     */           } 
/* 318 */           return null;
/*     */         }
/*     */       };
/*     */     this.index = all.add(this);
/*     */     this.free = new ShortStack(size);
/*     */     for (int i = size - 1; i >= 0; i--)
/*     */       this.free.push((short)i); 
/*     */   }
/*     */   void update(double ds) {}
/*     */   private final void remove(THINGS.Thing res) {
/* 328 */     short next = res.addedNext;
/* 329 */     short prev = res.addedPrev;
/*     */     
/* 331 */     if (next != -1) {
/* 332 */       ((THINGS.Thing)all()[next]).addedPrev = prev;
/*     */     }
/*     */     
/* 335 */     if (prev != -1) {
/* 336 */       ((THINGS.Thing)all()[prev]).addedNext = next;
/*     */     }
/*     */     
/* 339 */     if (res.index() == this.firstAdded) {
/* 340 */       this.firstAdded = next;
/*     */     }
/*     */     
/* 343 */     if (res.index() == this.lastAdded) {
/* 344 */       this.lastAdded = prev;
/*     */     }
/*     */ 
/*     */     
/* 348 */     res.addedPrev = -1;
/* 349 */     res.addedNext = -1;
/* 350 */     this.free.push(res.index());
/* 351 */     this.addedHistory.set(added());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final void add(THINGS.Thing res) {
/* 357 */     if (res.addedNext != -1)
/* 358 */       throw new RuntimeException(); 
/* 359 */     if (res.addedPrev != -1) {
/* 360 */       throw new RuntimeException();
/*     */     }
/* 362 */     int i = this.free.pop();
/* 363 */     this.addedHistory.set(added());
/* 364 */     if (i != res.index()) {
/* 365 */       throw new RuntimeException("" + i + " " + i);
/*     */     }
/* 367 */     if (this.firstAdded == -1) {
/* 368 */       this.firstAdded = res.index();
/* 369 */       this.lastAdded = res.index();
/*     */       
/*     */       return;
/*     */     } 
/* 373 */     ((THINGS.Thing)all()[this.lastAdded]).addedNext = res.index();
/* 374 */     res.addedPrev = this.lastAdded;
/* 375 */     this.lastAdded = res.index();
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
/*     */   T nextInLine() {
/* 397 */     if (this.free.isEmpty()) {
/* 398 */       all()[this.firstAdded].remove();
/*     */     }
/* 400 */     short i = this.free.pop();
/* 401 */     this.free.push(i);
/* 402 */     T res = all()[i];
/*     */     
/* 404 */     if (!res.isRemoved()) {
/* 405 */       throw new RuntimeException("" + this.free.size() + " " + this.free.size());
/*     */     }
/* 407 */     return res;
/*     */   }
/*     */   
/*     */   public int added() {
/* 411 */     return (all()).length - this.free.size();
/*     */   }
/*     */   
/*     */   public int remainingToAdd() {
/* 415 */     return this.free.size();
/*     */   }
/*     */   
/*     */   final T first() {
/* 419 */     if (this.firstAdded >= 0)
/* 420 */       return all()[this.firstAdded]; 
/* 421 */     return null;
/*     */   }
/*     */   
/*     */   final T next(T t) {
/* 425 */     if (((THINGS.Thing)t).addedNext != -1)
/* 426 */       return all()[((THINGS.Thing)t).addedNext]; 
/* 427 */     return null;
/*     */   }
/*     */   
/*     */   protected abstract T[] all();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\THINGS$ThingFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */