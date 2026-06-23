/*     */ package world.map.pathing;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.MapIndexed;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.map.road.WTRAV;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ 
/*     */ final class GenPort
/*     */ {
/*  36 */   private final ArrayListResize<Port> ports = new ArrayListResize(1023, 10230);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Bitsmap2D wRegs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_BOOLEAN mPort;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setPortAreas(ACTION util) {
/* 138 */     (WORLD.PATH()).portArea.clear();
/* 139 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 140 */     f.init(this);
/* 141 */     for (Port p : this.ports) {
/* 142 */       Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)p.coo);
/* 143 */       if (reg != null) {
/* 144 */         f.pushSloppy(p.coo.x(), p.coo.y(), 0.0D, null);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     while (f.hasMore()) {
/* 152 */       PathTile t = f.pollSmallest();
/* 153 */       if (t.getParent() != null)
/* 154 */         t.setValue2(t.getParent().getValue2()); 
/* 155 */       Region r = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/* 156 */       if (r == null || r != ((Port)this.ports.get((int)t.getValue2())).region())
/*     */         continue; 
/* 158 */       (WORLD.PATH()).portArea.set((COORDINATE)t, true);
/* 159 */       for (DIR d : DIR.ALL) {
/* 160 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t, d) && WTRAV.can(t.x(), t.y(), d, false)) {
/* 161 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance(), t);
/*     */         }
/*     */       } 
/*     */     } 
/* 165 */     f.done();
/*     */     
/* 167 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 168 */       Region reg = (Region)(WORLD.REGIONS()).map.get(c);
/* 169 */       if (reg != null && (WORLD.WATER()).isBig.is(c) && (WORLD.ROADS()).bridge.is(c)) {
/* 170 */         (WORLD.PATH()).portArea.set(c, true);
/*     */       }
/*     */     } 
/*     */     
/* 174 */     for (Region reg : WORLD.REGIONS().all()) {
/* 175 */       if ((WORLD.WATER()).isBig.is(reg.cx(), reg.cy())) {
/* 176 */         f.pushSloppy(reg.cx(), reg.cy(), 0.0D, null);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void connectNeighs(ACTION util) {
/* 182 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     
/* 184 */     Bitmap2D coast = coast();
/*     */     
/* 186 */     f.init(this);
/*     */     
/* 188 */     for (Port p : this.ports) {
/* 189 */       f.pushSloppy(p.coo.x(), p.coo.y(), 0.0D, null);
/*     */     }
/* 191 */     while (f.hasMore()) {
/*     */       
/* 193 */       PathTile t = f.pollSmallest();
/* 194 */       if (t.getParent() != null) {
/* 195 */         t.setValue2(t.getParent().getValue2());
/*     */       }
/* 197 */       Port pFrom = (Port)this.ports.get((int)t.getValue2());
/* 198 */       int from = this.wRegs.get((COORDINATE)pFrom.coo);
/*     */ 
/*     */ 
/*     */       
/* 202 */       for (DIR d : DIR.ALL) {
/* 203 */         if (coast.is((COORDINATE)t, d) && WTRAV.can(t.x(), t.y(), d, false) && from == this.wRegs.get(t.x(), t.y(), d)) {
/* 204 */           double v = ((WORLD.WATER()).coversTile.is((COORDINATE)t, d) ? true : 3);
/* 205 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */     } 
/* 209 */     f.done();
/* 210 */     util.exe();
/*     */     
/* 212 */     MapIndexed<Connection> cons = new MapIndexed();
/* 213 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 214 */       if (f.hasBeenPushed(c.x(), c.y())) {
/*     */         
/* 216 */         int portFrom = (int)f.getValue2(c.x(), c.y());
/* 217 */         double dist = f.getValue(c);
/*     */         
/* 219 */         for (DIR d : DIR.ALL) {
/* 220 */           if (f.hasBeenPushed(c.x(), c.y(), d) && WTRAV.can(c.x(), c.y(), d, false)) {
/* 221 */             int portTo = (int)f.getValue2(c.x(), c.y(), d);
/* 222 */             if (portFrom != portTo) {
/* 223 */               double dd = (d.isOrtho() ? false : 100) + dist + f.getValue(c.x() + d.x(), c.y() + d.y());
/* 224 */               int ii = ii(portFrom, portTo);
/* 225 */               Connection con = (Connection)cons.getTry(ii);
/* 226 */               if (con == null) {
/* 227 */                 con = new Connection(ii);
/* 228 */                 cons.add(con);
/*     */               } 
/* 230 */               if (dd < con.cost) {
/* 231 */                 con.cost = dd;
/* 232 */                 con.a = f.get(c.x(), c.y());
/* 233 */                 con.b = f.get(c.x() + d.x(), c.y() + d.y());
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 241 */     for (Connection c : cons.toList()) {
/* 242 */       Gen.connect(c.a);
/* 243 */       Gen.connect(c.b);
/* 244 */       DIR d = DIR.get((COORDINATE)c.a, (COORDINATE)c.b);
/* 245 */       (WORLD.PATH()).map.add((COORDINATE)c.a, d);
/* 246 */       (WORLD.PATH()).map.add((COORDINATE)c.b, d.perpendicular());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private LIST<PortGroup> makeGroups() {
/* 252 */     ArrayList<PortGroup> groups = new ArrayList(this.ports.size());
/* 253 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 254 */     int gi = 0;
/* 255 */     for (Port p : this.ports) {
/* 256 */       if (p.group != null) {
/*     */         continue;
/*     */       }
/* 259 */       int wi = this.wRegs.get((COORDINATE)p.coo);
/*     */       
/* 261 */       PortGroup g = new PortGroup(gi++);
/* 262 */       groups.add(g);
/* 263 */       f.init(this);
/* 264 */       f.pushSloppy((COORDINATE)p.coo, 0.0D);
/* 265 */       while (f.hasMore()) {
/* 266 */         PathTile t = f.pollSmallest();
/* 267 */         if (this.wRegs.get((COORDINATE)t) != wi) {
/*     */           continue;
/*     */         }
/* 270 */         if (this.mPort.is((COORDINATE)t)) {
/* 271 */           Port po = (Port)this.ports.get((int)t.getValue2());
/* 272 */           g.all.add(po);
/* 273 */           po.group = g;
/*     */         } 
/* 275 */         for (DIR d : DIR.ALL) {
/* 276 */           if ((WORLD.PATH()).map.can((COORDINATE)t, d) && (WORLD.WATER()).isBig.is((COORDINATE)t, d)) {
/* 277 */             f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */           }
/*     */         } 
/*     */       } 
/* 281 */       f.done();
/*     */     } 
/*     */     
/* 284 */     groups.shuffle();
/* 285 */     return (LIST<PortGroup>)groups;
/*     */   }
/*     */   
/*     */   private Bitmap2D coast() {
/* 289 */     Bitmap2D coast = new Bitmap2D(WORLD.TWIDTH(), WORLD.THEIGHT(), false);
/*     */     
/* 291 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     
/* 293 */     f.init(this);
/* 294 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 295 */       if ((WORLD.WATER()).isBig.is(c) && !(WORLD.WATER()).coversTile.is(c)) {
/* 296 */         f.pushSloppy(c.x(), c.y(), 0.0D, null);
/*     */       }
/*     */     } 
/*     */     
/* 300 */     while (f.hasMore()) {
/* 301 */       PathTile t = f.pollSmallest();
/* 302 */       coast.set((COORDINATE)t, true);
/* 303 */       if (t.getValue() > 3.0F) {
/*     */         continue;
/*     */       }
/* 306 */       for (DIR d : DIR.ALL) {
/* 307 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t, d)) {
/* 308 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/* 312 */     f.done();
/* 313 */     return coast;
/*     */   }
/*     */   
/*     */   private Bitmap2D network(LIST<Port> ports) {
/* 317 */     Bitmap2D network = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/* 318 */     Polymap polly = new Polymap(WORLD.TBOUNDS(), 12, 1.0D);
/*     */     
/* 320 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 321 */       if ((WORLD.WATER()).isBig.is(c) && polly.isEdge(c.x(), c.y())) {
/* 322 */         network.set(c, true);
/*     */       }
/*     */     } 
/* 325 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     
/* 327 */     f.init(this);
/* 328 */     for (Port p : ports) {
/* 329 */       f.pushSloppy((COORDINATE)p.coo, 0.0D);
/*     */     }
/*     */     
/* 332 */     Bitmap1D check = new Bitmap1D(ports.size(), false);
/*     */     
/* 334 */     while (f.hasMore()) {
/* 335 */       PathTile t = f.pollSmallest();
/* 336 */       if (t.getParent() != null)
/* 337 */         t.setValue2(t.getParent().getValue2()); 
/* 338 */       if (check.get((int)t.getValue2())) {
/*     */         continue;
/*     */       }
/* 341 */       if (network.is((COORDINATE)t)) {
/* 342 */         check.set((int)t.getValue2(), true);
/* 343 */         while (t != null) {
/* 344 */           network.set((COORDINATE)t, true);
/* 345 */           t = t.getParent();
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/* 350 */       for (DIR d : DIR.ALL) {
/* 351 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t, d)) {
/* 352 */           double v = 1.0D;
/* 353 */           if (!(WORLD.PATH()).map.can((COORDINATE)t, d))
/* 354 */             v = 4.0D; 
/* 355 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 360 */     f.done();
/* 361 */     return network;
/*     */   }
/*     */   
/* 364 */   GenPort(ACTION util) { this.mPort = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 368 */           if (!(WORLD.WATER()).isBig.is(tx, ty)) {
/* 369 */             return false;
/*     */           }
/*     */           
/* 372 */           if ((WORLD.ROADS()).harbour.is(tx, ty) && !(WORLD.ROADS()).bridge.is(tx, ty))
/* 373 */             return true; 
/* 374 */           if ((WORLD.REGIONS()).cTile.get(tx, ty) != null) {
/* 375 */             return true;
/*     */           }
/* 377 */           return false; } protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) { if ((WORLD.PATH()).portArea.is(it.tile())) { ((COLOR)COLOR.UNIQUE.getC(GenPort.this.wRegs.get(it.tile()))).bind(); (SPRITES.cons()).BIG.outline.render(r, 0, it.x(), it.y()); COLOR.unbind(); }
/*     */            if ((WORLD.PATH()).map.is.is(it.tile())) { COLOR.ORANGE100.bind(); for (int di = 0; di < DIR.ALL.size(); di++) {
/*     */               DIR d = (DIR)DIR.ALL.get(di); if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/*     */                 ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */             }  COLOR.unbind(); }
/*     */            }
/* 383 */       }; this.wRegs = new GenPortRegs(util); (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false) { public boolean is(int tile) { return false; } }; PathUtilOnline.Flooder f = GUTIL.flooder(); for (COORDINATE c : WORLD.TBOUNDS()) { if (this.mPort.is(c)) { f.setValue2(c, this.ports.size()); this.ports.add(new Port(this.ports.size(), c)); }  }  setPortAreas(util); util.exe(); connectNeighs(util); util.exe(); LIST<PortGroup> groups = makeGroups(); Bitmap2D network = network((LIST<Port>)this.ports); Bitmap1D check = new Bitmap1D(this.ports.size(), false); for (PortGroup g : groups) { int whome = this.wRegs.get((COORDINATE)((Port)g.all.get(0)).coo); check.clear(); f.init(this); for (Port p : g.all)
/*     */         f.pushSloppy((COORDINATE)p.coo, 0.0D);  while (f.hasMore()) { PathTile t = f.pollSmallest(); int wnow = this.wRegs.get((COORDINATE)t); if (this.mPort.is((COORDINATE)t) && wnow != whome) { Port po = (Port)this.ports.get((int)t.getValue2()); if (!check.get(po.group.index)) { check.set(wnow, true); Gen.connect(t); }  }  for (DIR d : DIR.ALL) { if (network.is((COORDINATE)t, d) || (WORLD.PATH()).map.can((COORDINATE)t, d)) { double v = 1.0D; if (!(WORLD.PATH()).map.can((COORDINATE)t, d))
/*     */               v = 8.0D;  f.pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance(), t); }
/*     */            }
/*     */          }
/*     */        f.done(); util.exe(); }
/* 389 */      util.exe(); } private static class Port { public final Coo coo = new Coo();
/*     */     
/*     */     public GenPort.PortGroup group;
/*     */     
/*     */     Port(int index, COORDINATE c) {
/* 394 */       this.coo.set(c);
/*     */     }
/*     */ 
/*     */     
/*     */     public Region region() {
/* 399 */       return (Region)(WORLD.REGIONS()).map.get((COORDINATE)this.coo);
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class PortGroup
/*     */   {
/* 406 */     public final ArrayListGrower<GenPort.Port> all = new ArrayListGrower();
/*     */     public final int index;
/*     */     
/*     */     PortGroup(int index) {
/* 410 */       this.index = index;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Connection
/*     */     implements INDEXED
/*     */   {
/* 417 */     private double cost = Double.MAX_VALUE;
/*     */     private PathTile a;
/*     */     private PathTile b;
/*     */     private final int index;
/*     */     
/*     */     Connection(int ii) {
/* 423 */       this.index = ii;
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 428 */       return this.index;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int ii(int a, int b) {
/* 436 */     if (a > b) {
/* 437 */       int c = a;
/* 438 */       a = b;
/* 439 */       b = c;
/*     */     } 
/* 441 */     return a * this.ports.size() + b;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\GenPort.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */