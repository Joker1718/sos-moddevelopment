/*     */ package settlement.entry;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EntryPoints
/*     */ {
/*  32 */   final int ww = Math.max(SETT.TWIDTH, SETT.THEIGHT);
/*  33 */   private final Bitmap1D ismap = new Bitmap1D(this.ww * 4, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final LIST<EntryPoint> all;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ArrayList<EntryPoint> active;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ArrayList<EntryPoint> reachable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dirty = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_BOOLEANE map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Coo ctmp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   EntryPoints() {
/* 150 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 154 */           for (EntryPoints.EntryPoint p : EntryPoints.this.all) {
/* 155 */             p.save(file);
/*     */           }
/*     */         }
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 160 */           clear();
/*     */           
/* 162 */           for (EntryPoints.EntryPoint p : EntryPoints.this.all)
/* 163 */             p.load(file); 
/* 164 */           for (EntryPoints.EntryPoint p : EntryPoints.this.all) {
/* 165 */             if (p.reachable)
/* 166 */               EntryPoints.this.reachable.add(p); 
/* 167 */             if (p.active) {
/* 168 */               EntryPoints.this.active.add(p);
/* 169 */               EntryPoints.this.ismap.set(EntryPoints.this.imapi(p.coo().x(), p.coo().y()), true);
/*     */             } 
/*     */           } 
/*     */           
/* 173 */           EntryPoints.this.dirty = true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 178 */           EntryPoints.this.dirty = true;
/* 179 */           EntryPoints.this.ismap.clear();
/* 180 */           for (EntryPoints.EntryPoint p : EntryPoints.this.all)
/* 181 */             p.clear(); 
/* 182 */           EntryPoints.this.active.clearSloppy();
/* 183 */           EntryPoints.this.reachable.clearSloppy();
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
/* 199 */     this.map = new MAP_BOOLEANE()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 205 */           int i = EntryPoints.this.imapi(tx, ty);
/* 206 */           if (i < 0)
/* 207 */             return false; 
/* 208 */           return EntryPoints.this.ismap.get(i);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 216 */           return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tile, boolean value) {
/* 221 */           return set(tile % SETT.TWIDTH, tile / SETT.TWIDTH, value);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 226 */           int i = EntryPoints.this.imapi(tx, ty);
/*     */           
/* 228 */           if (i < 0) {
/* 229 */             return this;
/*     */           }
/* 231 */           EntryPoints.this.dirty = true;
/* 232 */           if (!value) {
/* 233 */             for (EntryPoints.EntryPoint e : EntryPoints.this.all) {
/* 234 */               if (e.coo().isSameAs(tx, ty)) {
/* 235 */                 e.active = false;
/* 236 */                 EntryPoints.this.ismap.set(EntryPoints.this.imapi(tx, ty), false);
/* 237 */                 setActive();
/*     */                 break;
/*     */               } 
/*     */             } 
/* 241 */             return this;
/*     */           } 
/*     */           
/* 244 */           EntryPoints.EntryPoint ee = null;
/*     */           
/* 246 */           for (EntryPoints.EntryPoint e : EntryPoints.this.all) {
/* 247 */             if (e.body.holdsPoint(tx, ty)) {
/* 248 */               ee = e;
/*     */ 
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */           
/* 255 */           EntryPoints.this.ismap.set(EntryPoints.this.imapi(ee.coo().x(), ee.coo().y()), false);
/* 256 */           EntryPoints.this.ismap.set(i, true);
/* 257 */           ee.sCoo.set(tx, ty);
/* 258 */           ee.active = true;
/* 259 */           setActive();
/* 260 */           return this;
/*     */         }
/*     */         
/*     */         private void setActive() {
/* 264 */           EntryPoints.this.active.clearSloppy();
/* 265 */           for (EntryPoints.EntryPoint e : EntryPoints.this.all) {
/* 266 */             if (e.active) {
/* 267 */               EntryPoints.this.active.add(e);
/*     */             }
/*     */           } 
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
/* 302 */     this.ctmp = new Coo(); Rec ww = new Rec(3.0D); ArrayListGrower<EntryPoint> all = new ArrayListGrower(); int index = 0; for (COORDINATE c : ww) { if (c.x() == 0) { int x1 = 0; int x2 = 1; int y1 = c.y() * SETT.THEIGHT / 3; int y2 = (c.y() + 1) * SETT.THEIGHT / 3; EntryPoint p = new EntryPoint(index++, x1, x2, y1, y2, DIR.W, c.x(), c.y()); all.add(p); if (c.y() == 0) { p = new EntryPoint(index++, x1, x2, y1, y2, DIR.NW, c.x(), c.y()); all.add(p); y1 = 0; y2 = 1; x1 = c.x() * SETT.TWIDTH / 3; x2 = (c.x() + 1) * SETT.TWIDTH / 3; p = new EntryPoint(index++, x1, x2, y1, y2, DIR.NW, c.x(), c.y()); all.add(p); p = new EntryPoint(index++, x1, x2, y1, y2, DIR.N, c.x(), c.y()); all.add(p); }  if (c.y() == 2) { p = new EntryPoint(index++, x1, x2, y1, y2, DIR.SW, c.x(), c.y()); all.add(p); y1 = SETT.THEIGHT - 1; y2 = SETT.THEIGHT; x1 = c.x() * SETT.TWIDTH / 3; x2 = (c.x() + 1) * SETT.TWIDTH / 3; p = new EntryPoint(index++, x1, x2, y1, y2, DIR.SW, c.x(), c.y()); all.add(p); p = new EntryPoint(index++, x1, x2, y1, y2, DIR.S, c.x(), c.y()); all.add(p); }  continue; }  if (c.x() == 2) { int x1 = SETT.TWIDTH - 1; int x2 = SETT.TWIDTH; int y1 = c.y() * SETT.THEIGHT / 3; int y2 = (c.y() + 1) * SETT.THEIGHT / 3; EntryPoint p = new EntryPoint(index++, x1, x2, y1, y2, DIR.E, c.x(), c.y()); all.add(p); if (c.y() == 0) { p = new EntryPoint(index++, x1, x2, y1, y2, DIR.NE, c.x(), c.y()); all.add(p); y1 = 0; y2 = 1; x1 = c.x() * SETT.TWIDTH / 3; x2 = (c.x() + 1) * SETT.TWIDTH / 3; p = new EntryPoint(index++, x1, x2, y1, y2, DIR.NE, c.x(), c.y()); all.add(p); p = new EntryPoint(index++, x1, x2, y1, y2, DIR.N, c.x(), c.y()); all.add(p); }  if (c.y() == 2) { p = new EntryPoint(index++, x1, x2, y1, y2, DIR.SE, c.x(), c.y()); all.add(p); y1 = SETT.THEIGHT - 1; y2 = SETT.THEIGHT; x1 = c.x() * SETT.TWIDTH / 3; x2 = (c.x() + 1) * SETT.TWIDTH / 3; p = new EntryPoint(index++, x1, x2, y1, y2, DIR.SE, c.x(), c.y()); all.add(p); p = new EntryPoint(index++, x1, x2, y1, y2, DIR.S, c.x(), c.y()); all.add(p); }  continue; }  if (c.y() == 0) { int y1 = 0; int y2 = 1; int x1 = c.x() * SETT.TWIDTH / 3; int x2 = (c.x() + 1) * SETT.TWIDTH / 3; EntryPoint p = new EntryPoint(index++, x1, x2, y1, y2, DIR.N, c.x(), c.y()); all.add(p); continue; }  if (c.y() == 2) { int y1 = SETT.THEIGHT - 1; int y2 = SETT.THEIGHT; int x1 = c.x() * SETT.TWIDTH / 3; int x2 = (c.x() + 1) * SETT.TWIDTH / 3; EntryPoint p = new EntryPoint(index++, x1, x2, y1, y2, DIR.S, c.x(), c.y()); all.add(p); }  }  this.all = (LIST<EntryPoint>)all; this.active = new ArrayList(all.size()); this.reachable = new ArrayList(all.size());
/*     */   }
/*     */   private int imapi(int tx, int ty) { if (tx == 0) return ty;  if (tx == SETT.TWIDTH - 1) return this.ww + ty;  if (ty == 0) return this.ww * 2 + tx;  if (ty == SETT.THEIGHT - 1) return this.ww * 3 + tx;  return -1; }
/* 305 */   void generate(CapitolArea area) {} public LIST<EntryPoint> all() { return this.all; } public LIST<EntryPoint> active() { return (LIST<EntryPoint>)this.active; } public COORDINATE randomReachable() { return randomReachable(RND.rInt()); }
/*     */   public LIST<EntryPoint> reachable() { return (LIST<EntryPoint>)this.reachable; }
/*     */   public EntryPoint all(int wx, int wy) { return find(wx, wy, this.all); }
/*     */   public EntryPoint active(int wx, int wy) { return find(wx, wy, (LIST<EntryPoint>)this.active); }
/* 309 */   public EntryPoint reachable(int wx, int wy) { return find(wx, wy, (LIST<EntryPoint>)this.reachable); } public COORDINATE randomReachable(int rr) { if (this.reachable.size() <= 0)
/* 310 */       return null; 
/* 311 */     EntryPoint p = (EntryPoint)this.reachable.getC(rr);
/* 312 */     this.ctmp.set(p.coo());
/* 313 */     if (!RND.oneIn(3)) {
/* 314 */       DIR d = p.dirOut.next(-2 + RND.rInt(2) * 4);
/* 315 */       if ((SETT.PATH()).connectivity.is((COORDINATE)this.ctmp, d)) {
/* 316 */         this.ctmp.increment(d.x(), d.y());
/*     */       }
/*     */     } 
/* 319 */     if ((SETT.PATH()).connectivity.is((COORDINATE)this.ctmp))
/* 320 */       return (COORDINATE)this.ctmp; 
/* 321 */     return null; }
/*     */ 
/*     */ 
/*     */   
/*     */   private EntryPoint find(int wx, int wy, LIST<EntryPoint> all) {
/* 326 */     if (all.size() == 0) {
/* 327 */       return null;
/*     */     }
/* 329 */     EntryPoint best = (EntryPoint)all.get(0);
/* 330 */     double bestD = Double.MAX_VALUE;
/*     */     
/* 332 */     for (int ei = 1; ei < all.size(); ei++) {
/* 333 */       EntryPoint ee = (EntryPoint)all.get(ei);
/* 334 */       double dist = ee.distanceValue(wx, wy);
/* 335 */       if (dist < bestD) {
/* 336 */         bestD = dist;
/* 337 */         best = ee;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 342 */     return best;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasAny() {
/* 347 */     return (this.reachable.size() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   void update() {
/* 352 */     if (!this.dirty) {
/*     */       return;
/*     */     }
/*     */     
/* 356 */     this.reachable.clearSloppy();
/* 357 */     for (EntryPoint e : this.active) {
/*     */       
/* 359 */       e.reachable = (SETT.PATH()).connectivity.is(e.sCoo.x(), e.sCoo.y());
/* 360 */       if (e.reachable) {
/* 361 */         this.reachable.add(e);
/*     */       }
/*     */     } 
/* 364 */     this.dirty = false;
/*     */   }
/*     */   
/*     */   public void updateAvailability() {
/* 368 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, RenderData renData) {
/* 374 */     for (EntryPoint b : this.active) {
/* 375 */       if (renData.tBounds().holdsPoint(b.coo())) {
/* 376 */         if (b.reachable) {
/* 377 */           (GCOLOR.MAP()).BETTER.bind();
/* 378 */           (SPRITES.cons()).ICO.scratch.render((SPRITE_RENDERER)r, b.coo().x() * 64 - renData.offX1(), b.coo().y() * 64 - renData.offY1());
/* 379 */           (GCOLOR.MAP()).BEST.bind();
/*     */         } else {
/* 381 */           (GCOLOR.MAP()).BAD.bind();
/* 382 */           (SPRITES.cons()).ICO.scratch.render((SPRITE_RENDERER)r, b.coo().x() * 64 - renData.offX1(), b.coo().y() * 64 - renData.offY1());
/* 383 */           (GCOLOR.MAP()).SOSO.bind();
/*     */         } 
/* 385 */         if (this.map.is(b.coo())) {
/* 386 */           COLOR.BLUE100.render((SPRITE_RENDERER)r, b.coo().x() * 64 - renData.offX1(), b.coo().y() * 64 - renData.offY1());
/*     */         } else {
/* 388 */           COLOR.MEDIUM_BROWN.render((SPRITE_RENDERER)r, b.coo().x() * 64 - renData.offX1(), b.coo().y() * 64 - renData.offY1());
/*     */         } 
/*     */         
/* 391 */         for (DIR d : DIR.ORTHO) {
/* 392 */           int dx = b.coo().x() + d.x();
/* 393 */           int dy = b.coo().y() + d.y();
/* 394 */           if (SETT.IN_BOUNDS(dx, dy) && renData.tBounds().holdsPoint(dx, dy)) {
/* 395 */             (SPRITES.cons()).ICO.scratch.render((SPRITE_RENDERER)r, dx * 64 - renData.offX1(), dy * 64 - renData.offY1());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 400 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public static class EntryPoint
/*     */     implements INDEXED
/*     */   {
/*     */     public final int DIM;
/*     */     public final RECTANGLE body;
/* 409 */     private final Coo sCoo = new Coo();
/*     */     
/*     */     private final COORDINATE wCoo;
/*     */     public final DIR dirOut;
/*     */     private final int index;
/*     */     private boolean reachable = false;
/*     */     private boolean active = false;
/*     */     
/*     */     void save(FilePutter file) {
/* 418 */       this.sCoo.save(file);
/* 419 */       file.bool(this.active);
/* 420 */       file.bool(this.reachable);
/*     */     }
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 424 */       this.sCoo.load(file);
/* 425 */       this.active = file.bool();
/* 426 */       this.reachable = file.bool();
/*     */     }
/*     */     
/*     */     void clear() {
/* 430 */       this.sCoo.set(this.body.cX(), this.body.cY());
/* 431 */       this.active = false;
/* 432 */       this.reachable = false;
/*     */     }
/*     */     
/*     */     EntryPoint(int index, int x1, int x2, int y1, int y2, DIR dir, int wdx, int wdy) {
/* 436 */       this.body = (RECTANGLE)new Rec(x1, x2, y1, y2);
/* 437 */       this.DIM = Math.max(this.body.width(), this.body.height());
/* 438 */       this.dirOut = dir;
/* 439 */       this.sCoo.set(this.body.cX(), this.body.cY());
/* 440 */       this.wCoo = (COORDINATE)new Coo(wdx, wdy);
/* 441 */       this.index = index;
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 446 */       return this.index;
/*     */     }
/*     */     
/*     */     public boolean reachable() {
/* 450 */       return this.reachable;
/*     */     }
/*     */     
/*     */     public boolean active() {
/* 454 */       return this.active;
/*     */     }
/*     */     
/*     */     public COORDINATE coo() {
/* 458 */       return (COORDINATE)this.sCoo;
/*     */     }
/*     */     
/*     */     public COORDINATE wCooD() {
/* 462 */       return this.wCoo;
/*     */     }
/*     */     
/*     */     public int wx() {
/* 466 */       return this.wCoo.x() + SETT.WORLD_AREA().tiles().x1();
/*     */     }
/*     */     
/*     */     public int wy() {
/* 470 */       return this.wCoo.y() + SETT.WORLD_AREA().tiles().y1();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double distanceValue(int wx, int wy) {
/* 477 */       double ox = wx + 0.5D;
/* 478 */       double oy = wy + 0.5D;
/*     */       
/* 480 */       double x = (this.wCoo.x() + SETT.WORLD_AREA().tiles().x1()) + 0.5D;
/* 481 */       double y = (this.wCoo.y() + SETT.WORLD_AREA().tiles().y1()) + 0.5D;
/* 482 */       x += this.dirOut.x() * 0.5D;
/* 483 */       y += this.dirOut.y() * 0.5D;
/*     */       
/* 485 */       x -= ox;
/* 486 */       y -= oy;
/*     */       
/* 488 */       double dist = x * x + y * y;
/*     */       
/* 490 */       return dist;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\EntryPoints.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */