/*     */ package settlement.thing.halfEntity.dingy;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.thing.halfEntity.Factory;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class Dingy extends HalfEntity {
/*  32 */   private static VectorImp vec = new VectorImp();
/*     */   
/*     */   private static final double SPEED = 2.0D;
/*  35 */   private int hi = -1;
/*  36 */   private byte up = 0;
/*     */   
/*     */   private byte pointI;
/*     */   private byte pointM;
/*     */   private byte rCatch;
/*     */   private double mov;
/*  42 */   private final WayPoint[] points = new WayPoint[4];
/*     */ 
/*     */   
/*  45 */   private static final int[] bumpOff = Alloc.ii(128);
/*     */   
/*     */   static {
/*  48 */     for (int i = 0; i < bumpOff.length; i += 2) {
/*  49 */       bumpOff[i] = (int)(RND.rSign() * RND.rFloat() * 2.0D);
/*  50 */       bumpOff[i + 1] = (int)(RND.rSign() * RND.rFloat() * 2.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Dingy() {
/*  56 */     super(128, 128);
/*  57 */     for (int i = 0; i < this.points.length; i++) {
/*  58 */       this.points[i] = new WayPoint();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/*  63 */     file.i(this.hi);
/*  64 */     file.b(this.pointI);
/*  65 */     file.b(this.pointM);
/*  66 */     RESOURCES.map().saver().save((MAPPED)catc(), file);
/*  67 */     file.b(this.rCatch);
/*  68 */     file.d(this.mov);
/*  69 */     file.b(this.up); byte b; int i; WayPoint[] arrayOfWayPoint;
/*  70 */     for (i = (arrayOfWayPoint = this.points).length, b = 0; b < i; ) { WayPoint p = arrayOfWayPoint[b];
/*  71 */       p.save(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   protected HalfEntity load(FileGetter file) throws IOException {
/*  76 */     this.hi = file.i();
/*  77 */     this.pointI = file.b();
/*  78 */     this.pointM = file.b();
/*  79 */     this.rCatch = ((RESOURCE)RESOURCES.map().loader().loadB(file, null)).bIndex();
/*  80 */     file.b();
/*  81 */     this.mov = file.d();
/*  82 */     this.up = file.b(); byte b; int i; WayPoint[] arrayOfWayPoint;
/*  83 */     for (i = (arrayOfWayPoint = this.points).length, b = 0; b < i; ) { WayPoint p = arrayOfWayPoint[b];
/*  84 */       p.load(file); b++; }
/*  85 */      return this;
/*     */   }
/*     */   
/*     */   public Humanoid host() {
/*  89 */     ENTITY e = SETT.ENTITIES().getByID(this.hi);
/*  90 */     if (e != null && e instanceof Humanoid)
/*  91 */       return (Humanoid)e; 
/*  92 */     return null;
/*     */   }
/*     */   
/*     */   private RESOURCE catc() {
/*  96 */     return (RESOURCE)RESOURCES.ALL().get(this.rCatch);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean init(Humanoid h, int tx, int ty, RESOURCE cat, int upgrade, DIR dir) {
/* 102 */     this.hi = h.id();
/* 103 */     this.mov = 0.0D;
/* 104 */     RoomInstance ins = (RoomInstance)(SETT.ROOMS()).map.instance.get(tx, ty);
/* 105 */     if (!setWaypoint(tx + 0.5D, ty + 0.5D, 0, ins, dir.id()))
/* 106 */       return false; 
/* 107 */     this.pointI = 0;
/* 108 */     this.pointM = 1;
/* 109 */     this.up = (byte)(upgrade & 0x1);
/* 110 */     body().moveC(((this.points[0]).tx * 64.0F), ((this.points[0]).ty * 64.0F));
/*     */     
/* 112 */     for (int i = 1; i < this.points.length; ) {
/* 113 */       WayPoint prev = this.points[i - 1];
/* 114 */       double dx = (prev.tx + prev.dx * prev.distance);
/* 115 */       double dy = (prev.ty + prev.dy * prev.distance);
/* 116 */       if (setWaypoint(dx, dy, i, ins, prev.di)) {
/* 117 */         this.pointM = (byte)(this.pointM + 1);
/*     */         i++;
/*     */       } 
/*     */       break;
/*     */     } 
/* 122 */     this.rCatch = cat.bIndex();
/* 123 */     add();
/* 124 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean setWaypoint(double tx, double ty, int pi, RoomInstance ins, int ri) {
/* 129 */     WayPoint p = this.points[pi];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     p.tx = (float)tx;
/* 135 */     p.ty = (float)ty;
/*     */     
/* 137 */     int mLength = 16 + RND.rInt(32);
/*     */     
/* 139 */     ri += RND.rInt0(1);
/*     */     
/* 141 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 142 */       DIR d = (DIR)DIR.ALL.getC(ri + di);
/*     */       
/* 144 */       if (passable(tx, ty, tx + d.xN(), ty + d.yN(), ins)) {
/* 145 */         vec.set(d.xN(), d.yN());
/* 146 */         p.dx = (float)vec.nX();
/* 147 */         p.dy = (float)vec.nY();
/* 148 */         p.di = (byte)d.id();
/* 149 */         p.distance = 0.0F;
/* 150 */         for (int i = 0; i < mLength; i++) {
/* 151 */           double nx = tx + p.dx;
/* 152 */           double ny = ty + p.dy;
/* 153 */           if (passable(tx, ty, nx, ny, ins)) {
/* 154 */             p.distance++;
/* 155 */             tx += p.dx;
/* 156 */             ty += p.dy;
/* 157 */           } else if (i > 5) {
/* 158 */             return true;
/*     */           } 
/*     */         } 
/*     */         
/* 162 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 167 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean passable(double fromX, double fromY, double toX, double toY, RoomInstance ins) {
/* 173 */     int tx = (int)toX;
/* 174 */     int ty = (int)toY;
/* 175 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 176 */       return false; 
/* 177 */     if (ins != null && ins.is(tx, ty)) {
/* 178 */       if (!(SETT.TERRAIN()).WATER.is.is(tx, ty))
/* 179 */         return false; 
/* 180 */     } else if (!(SETT.TERRAIN()).WATER.DEEP.is(tx, ty) && !(SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty)) {
/* 181 */       return false;
/* 182 */     }  int x = (int)fromX;
/* 183 */     int y = (int)fromY;
/* 184 */     return ((SETT.TERRAIN()).WATER.is.is(x, ty) && (SETT.TERRAIN()).WATER.is.is(tx, y));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 190 */     Humanoid a = host();
/* 191 */     if (a == null) {
/* 192 */       remove();
/*     */       
/*     */       return;
/*     */     } 
/* 196 */     this.mov += ds * 2.0D;
/*     */ 
/*     */ 
/*     */     
/* 200 */     int pi = this.pointI;
/*     */     
/* 202 */     if (pi == this.pointM) {
/* 203 */       if (this.mov > 20.0D) {
/* 204 */         this.pointI = (byte)(this.pointI + 1);
/* 205 */         this.mov = 0.0D;
/*     */       } 
/* 207 */     } else if (this.pointI > this.pointM) {
/* 208 */       pi = this.pointM - this.pointI - this.pointM;
/*     */       
/* 210 */       if (pi < 0) {
/* 211 */         remove();
/*     */         
/*     */         return;
/*     */       } 
/* 215 */       WayPoint p = this.points[pi];
/*     */       
/* 217 */       if (this.mov >= p.distance) {
/* 218 */         this.mov = 0.0D;
/* 219 */         int cx = (int)(p.tx * 64.0F);
/* 220 */         int cy = (int)(p.ty * 64.0F);
/* 221 */         this.pointI = (byte)(this.pointI + 1);
/* 222 */         body().moveC(cx, cy);
/*     */       } else {
/* 224 */         int cx = (int)((p.tx + (p.distance - this.mov) * p.dx) * 64.0D);
/* 225 */         int cy = (int)((p.ty + (p.distance - this.mov) * p.dy) * 64.0D);
/* 226 */         body().moveC(cx, cy);
/*     */       } 
/*     */     } else {
/*     */       
/* 230 */       WayPoint p = this.points[this.pointI];
/* 231 */       if (this.mov >= p.distance) {
/* 232 */         this.mov = 0.0D;
/* 233 */         int cx = (int)((p.tx + p.distance * p.dx) * 64.0F);
/* 234 */         int cy = (int)((p.ty + p.distance * p.dy) * 64.0F);
/* 235 */         this.pointI = (byte)(this.pointI + 1);
/* 236 */         body().moveC(cx, cy);
/*     */       } else {
/* 238 */         int cx = (int)((p.tx + this.mov * p.dx) * 64.0D);
/* 239 */         int cy = (int)((p.ty + this.mov * p.dy) * 64.0D);
/* 240 */         body().moveC(cx, cy);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, ShadowBatch s, float ds, int x1, int y1) {
/* 252 */     DIR dir = DIR.N;
/* 253 */     int pi = this.pointI;
/* 254 */     RESOURCE res = null;
/* 255 */     int frame = (int)(TIME.currentSecond() * 4.0D) & 0x1;
/* 256 */     if (pi == this.pointM) {
/* 257 */       dir = (DIR)DIR.ALL.get((this.points[pi - 1]).di);
/* 258 */       frame = 0;
/* 259 */     } else if (this.pointI > this.pointM) {
/* 260 */       pi = this.pointM - this.pointI - this.pointM;
/* 261 */       if (pi < 0)
/*     */         return; 
/* 263 */       dir = ((DIR)DIR.ALL.get((this.points[pi]).di)).perpendicular();
/* 264 */       res = (RESOURCE)RESOURCES.ALL().get(this.rCatch & 0xFF);
/*     */     } else {
/* 266 */       dir = (DIR)DIR.ALL.get((this.points[pi]).di);
/*     */     } 
/*     */ 
/*     */     
/* 270 */     int ran = GUTIL.ran2().get(GUTIL.ran2().get(index()));
/* 271 */     double sp = 10.0D / (1 + (ran & 0xF));
/* 272 */     ran >>= 4;
/* 273 */     int f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/* 274 */     ran >>= 4;
/* 275 */     int df = MATH.distanceC(8, f, 16);
/* 276 */     x1 += df;
/*     */     
/* 278 */     sp = 10.0D / (1 + (ran & 0xF));
/* 279 */     ran >>= 4;
/* 280 */     f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/* 281 */     ran >>= 4;
/* 282 */     df = MATH.distanceC(8, f, 16);
/* 283 */     y1 += df;
/*     */ 
/*     */ 
/*     */     
/* 287 */     (constructor()).sprite.render((SPRITE_RENDERER)r, s, dir.id(), x1, y1, frame, this.up);
/*     */     
/* 289 */     Humanoid host = host();
/*     */     
/* 291 */     if (res != null) {
/* 292 */       int x = x1 + body().width() / 2;
/* 293 */       int y = y1 + body().height() / 2;
/*     */       
/* 295 */       x = (int)(x + dir.xN() * 2.0D * 4.0D);
/* 296 */       y = (int)(y + dir.yN() * 2.0D * 4.0D);
/*     */       
/* 298 */       res.renderOneC((SPRITE_RENDERER)r, x, y, 0);
/*     */     } 
/*     */     
/* 301 */     if (host != null) {
/* 302 */       DIR d = dir.perpendicular();
/*     */       
/* 304 */       HSprite hSprite = HSprites.STAND;
/* 305 */       double ani = 0.0D;
/* 306 */       if (this.pointI == this.pointM) {
/* 307 */         d = d.next(2);
/* 308 */         hSprite = HSprites.GRAB;
/* 309 */         ani = TIME.currentSecond() * 3.0D;
/*     */       } else {
/* 311 */         hSprite = (frame == 0) ? HSprites.STAND : HSprites.CARRY;
/*     */       } 
/*     */       
/* 314 */       int x = x1 + body().width() / 2 - 48;
/* 315 */       int y = y1 + body().height() / 2 - 48;
/*     */       
/* 317 */       x = (int)(x + d.xN() * 2.0D * 4.0D);
/* 318 */       y = (int)(y + d.yN() * 2.0D * 4.0D);
/*     */       
/* 320 */       hSprite.render(host.indu(), ani, 0.0D, false, d, null, 0, r, s, ds, x, y);
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
/*     */   protected void removeAction() {
/* 332 */     if (host() != null) {
/* 333 */       double time = 0.0D;
/* 334 */       for (int i = 0; i < this.pointM; i++) {
/* 335 */         time += (this.points[i]).distance;
/*     */       }
/* 337 */       time /= 2.0D;
/* 338 */       time *= 2.0D;
/* 339 */       time += 20.0D;
/* 340 */       HEvent.Handler.fishingTripOver(host(), time);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected DingyFactory constructor() {
/* 347 */     return (SETT.HALFENTS()).dingy;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box) {}
/*     */ 
/*     */   
/*     */   private static final class WayPoint
/*     */     implements SAVABLE
/*     */   {
/*     */     byte di;
/*     */     
/*     */     float tx;
/*     */     
/*     */     float ty;
/*     */     
/*     */     float dx;
/*     */     float dy;
/*     */     float distance;
/*     */     
/*     */     public void save(FilePutter file) {
/* 368 */       file.b(this.di);
/* 369 */       file.f(this.tx);
/* 370 */       file.f(this.ty);
/* 371 */       file.f(this.dx);
/* 372 */       file.f(this.dy);
/* 373 */       file.f(this.distance);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 378 */       this.di = file.b();
/* 379 */       this.tx = file.f();
/* 380 */       this.ty = file.f();
/* 381 */       this.dx = file.f();
/* 382 */       this.dy = file.f();
/* 383 */       this.distance = file.f();
/*     */     }
/*     */     
/*     */     public void clear() {}
/*     */   }
/*     */   
/*     */   protected void render(Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\dingy\Dingy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */