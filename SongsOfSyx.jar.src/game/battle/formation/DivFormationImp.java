/*     */ package game.battle.formation;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.Copyable;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ 
/*     */ public class DivFormationImp
/*     */   extends DivPositionImp
/*     */   implements DivFormation, Copyable<DivFormationImp> {
/*  23 */   private DIR faceDir = DIR.N;
/*  24 */   private final Rec bounds = new Rec();
/*  25 */   final Coo start = new Coo();
/*     */   
/*     */   private double dx;
/*     */   private double dy;
/*     */   private int width;
/*  30 */   private DIV_FORMATION ts = DIV_FORMATION.TIGHT;
/*  31 */   private int centreI = -1; private boolean hasExtraRoom = false;
/*     */   private boolean isNotCoherent = false;
/*     */   private final byte[] dirMasks;
/*     */   private final DivPosProjector proj;
/*     */   
/*     */   public DivFormationImp() {
/*  37 */     this((Config.battle()).MEN_PER_DIVISION);
/*     */   }
/*     */   
/*     */   private DivFormationImp(int maxMen) {
/*  41 */     super(maxMen);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 330 */     this.proj = new DivPosProjector(); this.dirMasks = Alloc.bb(maxMen);
/*     */   }
/*     */   public DIR dir() { return this.faceDir; }
/*     */   public void save(FilePutter file) { super.save(file); file.i(this.faceDir.id()); this.bounds.save(file); this.start.save(file); file.i(this.centreI); file.d(this.dx); file.d(this.dy); file.i(this.ts.ordinal()); file.bs(this.dirMasks); file.bool(this.hasExtraRoom); file.bool(this.isNotCoherent); file.i(this.width); }
/*     */   public void load(FileGetter file) throws IOException { super.load(file); this.faceDir = (DIR)DIR.ALL.get(file.i()); this.bounds.load(file); this.start.load(file); this.centreI = file.i(); this.dx = file.d(); this.dy = file.d(); this.ts = (DIV_FORMATION)DIV_FORMATION.all.get(file.i()); file.bs(this.dirMasks); this.hasExtraRoom = file.bool(); this.isNotCoherent = file.bool(); this.width = file.i(); } public void clear() { super.clear(); this.bounds.set((SETT.PWIDTH + 1), -1.0D, (SETT.PHEIGHT + 1), -1.0D); this.ts = DIV_FORMATION.TIGHT; this.hasExtraRoom = false; this.isNotCoherent = false; this.centreI = -1; } public void deployInit(DIR face, int x1, int y1, double dx, double dy, DIV_FORMATION ts, int width) { clear(); this.start.set(x1, y1); this.dx = dx; this.dy = dy; this.faceDir = face; this.ts = ts; this.width = width; } public void move(int dx, int dy) { this.start.increment(dx, dy); this.bounds.incr(dx, dy); for (int i = 0; i < deployed(); i++) { int x = px(i) + dx; int y = py(i) + dy; set(i, x, y); }  } public void deploy(int x, int y, DIV_SPEC spec) { int t = this.ts.sizeH(spec); this.bounds.unify(x - t, y - t); this.bounds.unify(x + t, y - t); this.bounds.unify(x - t, y + t); this.bounds.unify(x + t, y + t); set(deployed(), x, y); init(deployed() + 1); } public void deploy(int x, int y, int pi, DIV_SPEC spec) { int t = this.ts.sizeH(spec); this.bounds.unify(x - t, y - t); this.bounds.unify(x + t, y - t); this.bounds.unify(x - t, y + t); this.bounds.unify(x + t, y + t); set(pi, x, y); init(deployed() + 1); } public void deployFinish(PathUtilOnline.Filler f, DIV_SPEC spec) { this.isNotCoherent = false; if (deployed() == 0) return;  int xx = 0; int yy = 0; for (int i = 0; i < deployed(); i++) { COORDINATE p = pixel(i); xx += p.x(); yy += p.y(); }  xx /= deployed(); yy /= deployed(); int cx = xx; int cy = yy; double dist = Double.MAX_VALUE; int distI = -1; for (int j = 0; j < deployed(); j++) { COORDINATE p = pixel(j); int dx = p.x() - cx; int dy = p.y() - cy; double d = Math.sqrt((dx * dx + dy * dy)); if (d < dist) { dist = d; distI = j; }  }  if (distI == -1) throw new RuntimeException();  this.centreI = distI; setDirs(f, spec); } public void setHasExtraRoom() { this.hasExtraRoom = true; } public void copy(DivFormationImp o) { copyposition(o); this.faceDir = o.faceDir; this.bounds.set((RECTANGLE)o.bounds); this.start.set((COORDINATE)o.start); this.dx = o.dx; this.dy = o.dy; this.ts = o.ts; this.width = o.width; for (int i = 0; i < this.dirMasks.length; i++) this.dirMasks[i] = o.dirMasks[i];  this.hasExtraRoom = o.hasExtraRoom; this.isNotCoherent = o.isNotCoherent; this.centreI = o.centreI; } public RECTANGLE body() { return (RECTANGLE)this.bounds; } public DIV_FORMATION formation() { return this.ts; } public COORDINATE start() { return (COORDINATE)this.start; } public double dx() { return this.dx; } public double dy() { return this.dy; } public int width() { return this.width; } public int height(DIV_SPEC spec) { double dep = deployed(); if (dep == 0.0D) return 0;  double size = formation().size(spec); double menW = width() / size; return (int)Math.ceil(size * dep / menW); } public int dirMaskOrtho(int i) { return this.dirMasks[i] & 0xF; } public DIR dir(int i) { int di = this.dirMasks[i] >> 4 & 0xF; if (di < 2 || di - 2 >= DIR.ALL.size()) return null;  return (DIR)DIR.ALL.get(di - 2); } public void setDir(int i, DIR d) { int m = 2 + d.id(); this.dirMasks[i] = (byte)(this.dirMasks[i] & 0xF); this.dirMasks[i] = (byte)(this.dirMasks[i] | m << 4); } public boolean isEdge(int i) { int di = this.dirMasks[i] >> 4 & 0xF; return (di != 0); } public boolean hasExtraRoom() { return this.hasExtraRoom; } private void setDirs(PathUtilOnline.Filler f, DIV_SPEC spec) { int o = this.faceDir.id(); this.proj.init(this); f.init(this); int i; for (i = 0; i < deployed(); i++) { COORDINATE t = this.proj.projectTile(this, i, spec); f.fill(t); }  for (i = 0; i < deployed(); i++) { int mo = 0; int mn = 0; COORDINATE t = this.proj.projectTile(this, i, spec); for (int di = 0; di < DIR.ORTHO.size(); di++) { DIR d = (DIR)DIR.ORTHO.get(di); if (f.isser.is(t, d)) mo |= d.next(o).mask();  }  if (mo != 15) { mn = 1; double dx = 0.0D; double dy = 0.0D; double dd = 0.0D; for (int j = 0; j < DIR.ALL.size(); j++) { DIR d = (DIR)DIR.ALL.get(j); if (!f.isser.is(t, d)) { d = d.next(o); dx += d.x(); dy += d.y(); dd++; }  }  dx /= dd; dy /= dd; if ((dd > 0.0D && dx != 0.0D) || dy != 0.0D) mn += DIR.get(dx, dy).id() + 1;  }  mo |= mn << 4; this.dirMasks[i] = (byte)mo; }  f.done(); } private final class DivPosProjector
/*     */   {
/* 336 */     private final VectorImp vec = new VectorImp(); private double angle;
/* 337 */     private final Coo coo = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int init(DivFormationImp pos) {
/* 344 */       this.vec.set(pos.dx, pos.dy);
/* 345 */       this.angle = Math.atan2(this.vec.nX(), this.vec.nY()) - 1.5707963267948966D;
/* 346 */       return -((int)(this.angle / Math.PI / 2.0D));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public COORDINATE projectTile(DivFormationImp pos, int i, DIV_SPEC spec) {
/* 352 */       COORDINATE p = pos.pixel(i);
/* 353 */       double x = p.x();
/* 354 */       double y = p.y();
/*     */ 
/*     */ 
/*     */       
/* 358 */       double length = this.vec.set(pos.start().x(), pos.start().y(), x, y);
/* 359 */       double ang = Math.atan2(this.vec.nX(), this.vec.nY());
/* 360 */       if (pos.start.isSameAs(p)) {
/* 361 */         ang = this.angle;
/* 362 */         length = 0.0D;
/*     */       } 
/*     */       
/* 365 */       ang -= this.angle;
/*     */ 
/*     */       
/* 368 */       x = pos.ts.sizeH(spec) + Math.sin(ang) * length;
/* 369 */       y = pos.ts.sizeH(spec) + Math.cos(ang) * length;
/*     */       
/* 371 */       int ty = (int)(y / pos.ts.size(spec));
/* 372 */       int tx = (int)(x / pos.ts.size(spec));
/*     */       
/* 374 */       tx += SETT.TWIDTH / 2;
/* 375 */       ty += SETT.THEIGHT / 2;
/*     */       
/* 377 */       this.coo.set(tx, ty);
/* 378 */       return (COORDINATE)this.coo;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSameAs(DivFormationImp o) {
/* 386 */     return (this.start.isSameAs((COORDINATE)o.start) && this.dx == o.dx && this.dy == o.dy && deployed() == o.deployed() && this.width == o.width && this.ts == o.ts && centrePixel().isSameAs(o.centrePixel()));
/*     */   }
/*     */   
/*     */   public boolean isSameAs(DivFormationImp o, Div div) {
/* 390 */     if (!this.start.isSameAs((COORDINATE)o.start))
/* 391 */       return false; 
/* 392 */     if (this.dx != o.dx || this.dy != o.dy)
/* 393 */       return false; 
/* 394 */     if (this.ts != o.ts || !centrePixel().isSameAs(o.centrePixel()))
/* 395 */       return false; 
/* 396 */     if (deployed() != o.deployed())
/* 397 */       return false; 
/* 398 */     int w1 = this.width / this.ts.size(div);
/* 399 */     int w2 = o.width / this.ts.size(div);
/*     */     
/* 401 */     if (w1 != w2)
/* 402 */       return false; 
/* 403 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 408 */     return "" + this.start.x() + " " + this.start.x() + " | > " + this.start.y() + " " + this.dx + " | " + this.dy + " " + this.width + " | " + deployed() + " | " + String.valueOf(this.ts);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE centreTile() {
/* 415 */     if (deployed() == 0)
/* 416 */       return null; 
/* 417 */     return tile(this.centreI);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE centrePixel() {
/* 422 */     if (deployed() == 0)
/* 423 */       return null; 
/* 424 */     return pixel(this.centreI);
/*     */   }
/*     */   
/*     */   public int centreI() {
/* 428 */     return this.centreI;
/*     */   }
/*     */ 
/*     */   
/*     */   public void swap(int a, int b) {
/* 433 */     if (a == this.centreI) {
/* 434 */       this.centreI = b;
/* 435 */     } else if (b == this.centreI) {
/* 436 */       this.centreI = a;
/*     */     } 
/* 438 */     byte dm = this.dirMasks[a];
/* 439 */     int x = px(a);
/* 440 */     int y = py(a);
/* 441 */     set(a, px(b), py(b));
/* 442 */     set(b, x, y);
/* 443 */     this.dirMasks[a] = this.dirMasks[b];
/* 444 */     this.dirMasks[b] = dm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCoherent() {
/* 451 */     return !this.isNotCoherent;
/*     */   }
/*     */   
/*     */   public void coherentSetNot() {
/* 455 */     this.isNotCoherent = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivFormationImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */