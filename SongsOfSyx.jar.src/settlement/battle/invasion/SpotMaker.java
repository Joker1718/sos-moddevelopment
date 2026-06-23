/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import settlement.entry.EntryPoints;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.projectiles.Projectile;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SpotMaker
/*     */ {
/*     */   public static InvasionSpot get(int men, int wx, int wy) {
/*  31 */     EntryPoints.EntryPoint p = getEntry(wx, wy);
/*  32 */     InvasionSpot sp = make(men, p);
/*     */     
/*  34 */     return sp;
/*     */   }
/*     */   
/*     */   private static EntryPoints.EntryPoint getEntry(int wx, int wy) {
/*  38 */     EntryPoints.EntryPoint start = (SETT.ENTRY()).points.active(wx, wy);
/*  39 */     if (start == null) {
/*  40 */       return (SETT.ENTRY()).points.all(wx, wy);
/*     */     }
/*  42 */     wx = start.wx() + start.dirOut.x();
/*  43 */     wy = start.wy() + start.dirOut.y();
/*     */     
/*  45 */     LinkedList<COORDINATE> all = new LinkedList();
/*     */     
/*  47 */     RECTANGLE inner = SETT.WORLD_AREA().tiles();
/*  48 */     Rec outer = new Rec((inner.width() + 2), (inner.height() + 2));
/*  49 */     outer.moveX1Y1(inner).incrX(-1.0D).incrY(-1.0D);
/*  50 */     GUTIL.flooder().init(SpotMaker.class);
/*  51 */     GUTIL.flooder().pushSloppy(wx, wy, 0.0D);
/*     */     
/*  53 */     while (GUTIL.flooder().hasMore()) {
/*  54 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  55 */       all.add(t);
/*     */       
/*  57 */       for (DIR d : DIR.ORTHO) {
/*  58 */         int dx = t.x() + d.x();
/*  59 */         int dy = t.y() + d.y();
/*  60 */         if (!WORLD.IN_BOUNDS(dx, dy))
/*     */           continue; 
/*  62 */         if (!outer.isOnEdge(dx, dy))
/*     */           continue; 
/*  64 */         if (WTRAV.canLand(t.x(), t.y(), d, false)) {
/*  65 */           GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  71 */     GUTIL.flooder().done();
/*     */     
/*  73 */     COORDINATE cc = (COORDINATE)all.rnd();
/*     */     
/*  75 */     EntryPoints.EntryPoint best = null;
/*  76 */     double bestV = Double.MAX_VALUE;
/*  77 */     for (EntryPoints.EntryPoint p : (SETT.ENTRY()).points.all()) {
/*  78 */       if (!WTRAV.isGoodLandTile(p.wx(), p.wy()))
/*     */         continue; 
/*  80 */       double v = p.distanceValue(cc.x(), cc.y()) + RND.rFloat();
/*  81 */       if (v < bestV) {
/*  82 */         bestV = v;
/*  83 */         best = p;
/*     */       } 
/*     */     } 
/*  86 */     return best;
/*     */   }
/*     */ 
/*     */   
/*     */   private static InvasionSpot make(int men, EntryPoints.EntryPoint p) {
/*  91 */     GUTIL.coos().set(0);
/*  92 */     for (COORDINATE cOORDINATE : p.body) {
/*  93 */       if ((SETT.PATH()).connectivity.is(cOORDINATE)) {
/*  94 */         GUTIL.coos().get().set(cOORDINATE);
/*  95 */         GUTIL.coos().inc();
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     if (GUTIL.coos().getI() < 8) {
/* 100 */       GUTIL.coos().set(0);
/* 101 */       for (COORDINATE cOORDINATE : p.body) {
/* 102 */         if (((Terrain.TerrainTile)SETT.TERRAIN().get(cOORDINATE)).clearing().isStructure()) {
/* 103 */           GUTIL.coos().get().set(cOORDINATE);
/* 104 */           GUTIL.coos().inc();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 110 */     if (GUTIL.coos().getI() < 8) {
/* 111 */       GUTIL.coos().set(0);
/* 112 */       for (COORDINATE cOORDINATE : p.body) {
/* 113 */         GUTIL.coos().get().set(cOORDINATE);
/* 114 */         GUTIL.coos().inc();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 120 */     Rec c = new Rec(1.0D);
/*     */     
/* 122 */     GUTIL.coos().set(RND.rInt(GUTIL.coos().getI()));
/*     */ 
/*     */     
/* 125 */     int sx = GUTIL.coos().get().x();
/* 126 */     int sy = GUTIL.coos().get().y();
/*     */ 
/*     */     
/* 129 */     c.moveX1Y1(sx, sy);
/* 130 */     DIR d = dir(p.body).next(2);
/*     */     
/* 132 */     int w = Math.max(men / 10, 8);
/* 133 */     int i = 1;
/*     */     
/* 135 */     while (w > 0) {
/*     */ 
/*     */ 
/*     */       
/* 139 */       int x = sx + i * d.x();
/* 140 */       int y = sy + i * d.y();
/*     */ 
/*     */       
/* 143 */       if (p.body.holdsPoint(x, y)) {
/* 144 */         w--;
/* 145 */         c.unify(x, y);
/*     */       } 
/* 147 */       int x2 = sx - i * d.x();
/* 148 */       int y2 = sy - i * d.y();
/* 149 */       if (p.body.holdsPoint(x2, y2)) {
/* 150 */         w--;
/* 151 */         c.unify(x2, y2);
/*     */       } 
/*     */       
/* 154 */       i++;
/* 155 */       if (!SETT.IN_BOUNDS(x, y) && !SETT.IN_BOUNDS(x2, y2)) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 160 */     if (c.width() * c.height() < 8) {
/* 161 */       LOG.ln(String.valueOf(p.body) + " " + String.valueOf(p.body));
/* 162 */       LOG.ln("" + sx + " " + sx + " " + sy);
/* 163 */       LOG.ln(String.valueOf(c) + " " + String.valueOf(c));
/* 164 */       w = 8;
/* 165 */       i = 1;
/* 166 */       while (w > 0) {
/*     */         
/* 168 */         int x = sx + i * d.x();
/* 169 */         int y = sy + i * d.y();
/*     */ 
/*     */         
/* 172 */         if (p.body.holdsPoint(x, y)) {
/* 173 */           w--;
/* 174 */           c.unify(x, y);
/*     */         } 
/* 176 */         int x2 = sx - i * d.x();
/* 177 */         int y2 = sy - i * d.y();
/* 178 */         if (p.body.holdsPoint(x2, y2)) {
/* 179 */           w--;
/* 180 */           c.unify(x2, y2);
/*     */         } 
/*     */         
/* 183 */         LOG.ln("" + x + " " + x + " | " + y + " " + x2);
/* 184 */         i++;
/* 185 */         if (!SETT.IN_BOUNDS(x, y) && !SETT.IN_BOUNDS(x2, y2)) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 191 */     return new InvasionSpot(c);
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
/*     */   private static DIR dir(RECTANGLE body) {
/* 203 */     if (body.width() == 1)
/* 204 */       return (body.x1() == 0) ? DIR.W : DIR.E; 
/* 205 */     if (body.height() == 1)
/* 206 */       return (body.y1() == 0) ? DIR.N : DIR.S; 
/* 207 */     throw new RuntimeException(String.valueOf(body));
/*     */   }
/*     */   
/*     */   static class InvasionSpot
/*     */   {
/* 212 */     private static Coo bomb = new Coo();
/*     */     public final Rec body;
/*     */     private final ArrayCooShort coos;
/*     */     public final int size;
/*     */     public final DIR dir;
/*     */     private int lastBombarded;
/* 218 */     private static Trajectory traj = new Trajectory();
/*     */     private boolean any = false;
/*     */     
/*     */     public InvasionSpot(FileGetter f) throws IOException {
/* 222 */       this.body = new Rec();
/* 223 */       this.body.load(f);
/* 224 */       this.size = Math.max(this.body.width(), this.body.height());
/* 225 */       this.coos = new ArrayCooShort(this.size);
/* 226 */       this.coos.load(f);
/* 227 */       DIR.ALL.get(f.i());
/* 228 */       this.dir = SpotMaker.dir((RECTANGLE)this.body).perpendicular();
/* 229 */       this.lastBombarded = f.i();
/* 230 */       this.any = f.bool();
/*     */     }
/*     */     
/*     */     public InvasionSpot(Rec rec) {
/* 234 */       this.body = rec;
/* 235 */       this.size = Math.max(rec.width(), rec.height());
/* 236 */       this.coos = new ArrayCooShort(this.size);
/* 237 */       int i = 0;
/* 238 */       for (COORDINATE c : rec) {
/*     */         
/* 240 */         this.coos.set(i).set(c);
/* 241 */         i++;
/*     */       } 
/* 243 */       this.coos.shuffle(i - 1);
/* 244 */       this.coos.set(0);
/* 245 */       this.dir = SpotMaker.dir((RECTANGLE)this.body).perpendicular();
/* 246 */       this.lastBombarded = 0;
/*     */     }
/*     */     
/*     */     public void save(FilePutter p) {
/* 250 */       this.body.save(p);
/* 251 */       this.coos.save(p);
/* 252 */       p.i(this.dir.id());
/* 253 */       p.i(this.lastBombarded);
/* 254 */       p.bool(this.any);
/*     */     }
/*     */ 
/*     */     
/*     */     private COORDINATE getNextBombardStart() {
/* 259 */       int dist = 12;
/*     */       
/* 261 */       while (this.lastBombarded < dist) {
/*     */         
/* 263 */         if (this.coos.getI() >= this.coos.size() - 1) {
/* 264 */           this.coos.set(0);
/* 265 */           if (!this.any)
/* 266 */             this.lastBombarded++; 
/* 267 */           this.any = false;
/*     */         } 
/*     */         
/* 270 */         int sx = this.coos.get().x();
/* 271 */         int sy = this.coos.get().y();
/*     */         
/* 273 */         int x = sx + this.dir.x() * this.lastBombarded;
/* 274 */         int y = sy + this.dir.y() * this.lastBombarded;
/* 275 */         this.coos.inc();
/* 276 */         if ((SETT.PATH()).availability.get(x, y).isSolid(GAME.ARMIES().enemy())) {
/* 277 */           this.any = true;
/* 278 */           bomb.set(sx, sy);
/*     */           
/* 280 */           return (COORDINATE)bomb;
/*     */         } 
/*     */       } 
/* 283 */       return null;
/*     */     }
/*     */     
/*     */     public boolean launchProj() {
/* 287 */       COORDINATE coo = getNextBombardStart();
/* 288 */       if (coo == null)
/* 289 */         return false; 
/* 290 */       int sx = coo.x() * 64 + 32;
/* 291 */       int sy = coo.y() * 64 + 32;
/* 292 */       int x = sx + this.lastBombarded * this.dir.x() * 64;
/* 293 */       int y = sy + this.lastBombarded * this.dir.y() * 64;
/* 294 */       Projectile proj = (SETT.INVADOR()).proj;
/*     */       
/* 296 */       if (this.lastBombarded == 0 || !traj.calcLow(16, sx, sy, x, y, proj.maxAngle(1.0D), proj.velocity(1.0D))) {
/* 297 */         (GAME.ARMIES()).map.breakIt(x / 64, y / 64);
/*     */       } else {
/* 299 */         SETT.PROJS().launch(sx, sy, 16, traj, proj, 0.0D, 1.0D, null);
/*     */       } 
/* 301 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\SpotMaker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */