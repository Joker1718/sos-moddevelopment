/*     */ package world.map.road;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.util.Arrays;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ 
/*     */ final class GenPortMini
/*     */ {
/*  29 */   private final Bitmap2D debug = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*     */   private final ACTION util;
/*  31 */   private final ArrayList<Reg> regs = new ArrayList(1023);
/*  32 */   private final ArrayListGrower<Port> ports = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final MAP_BOOLEANE marked;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_OBJECT<Reg> map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MAP_OBJECT<Port> port;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setLand() {
/*  83 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  84 */     f.init(this);
/*     */     
/*  86 */     for (Region r : WORLD.REGIONS().all()) {
/*     */       
/*  88 */       if (r.info.area() > 0) {
/*  89 */         f.pushSloppy(r.cx(), r.cy(), 0.0D, null);
/*  90 */         f.setValue2(r.cx(), r.cy(), r.index());
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     while (f.hasMore()) {
/*     */       
/*  96 */       PathTile t = f.pollSmallest();
/*  97 */       if (t.getParent() != null) {
/*  98 */         t.setValue2(t.getParent().getValue2());
/*     */       }
/* 100 */       Region rr = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/*     */ 
/*     */       
/* 103 */       for (DIR d : DIR.ALL) {
/* 104 */         if (WTRAV.can(t.x(), t.y(), d, true)) {
/* 105 */           Region other = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t, d);
/* 106 */           if (other != rr) {
/*     */             continue;
/*     */           }
/* 109 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */     } 
/* 113 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 114 */       if (this.marked.is(c)) {
/* 115 */         Port p = new Port(c, (Reg)this.map.get(c), 0.0D, this.ports.size());
/* 116 */         ((Reg)this.map.get(c)).ports.add(p);
/* 117 */         this.ports.add(p);
/*     */       } 
/*     */       
/* 120 */       if (f.hasBeenPushed(c.x(), c.y())) {
/*     */ 
/*     */ 
/*     */         
/* 124 */         if (!WTRAV.LAND.isPossible(c.x(), c.y(), true)) {
/*     */           continue;
/*     */         }
/* 127 */         int from = (int)f.getValue2(c.x(), c.y());
/* 128 */         for (DIR d : DIR.ALL) {
/* 129 */           if (f.hasBeenPushed(c.x(), c.y(), d) && WTRAV.canLand(c.x(), c.y(), d, true)) {
/* 130 */             int regTo = (int)f.getValue2(c.x(), c.y(), d);
/* 131 */             if (from != regTo) {
/* 132 */               double dd = (f.getValue(c) + f.getValue(c.x() + d.x(), c.y() + d.y()));
/* 133 */               connect(f.get(c.x(), c.y()));
/* 134 */               ((Reg)this.regs.get(from)).land.add(new Reg.Connect((Reg)this.regs.get(regTo), dd));
/* 135 */               ((Reg)this.regs.get(regTo)).land.add(new Reg.Connect((Reg)this.regs.get(from), dd));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 143 */     f.done();
/*     */ 
/*     */     
/* 146 */     for (Reg home : this.regs) {
/* 147 */       if (home.land.size() == 0)
/*     */         continue; 
/* 149 */       if (home.reg.index() % 10 == 0) {
/* 150 */         this.util.exe();
/*     */       }
/* 152 */       f.init(this);
/* 153 */       f.pushSloppy(home.reg.cx(), home.reg.cy(), 0.0D, null);
/*     */       
/* 155 */       while (f.hasMore()) {
/* 156 */         PathTile t = f.pollSmallest();
/* 157 */         Reg o = (Reg)this.map.get((COORDINATE)t);
/* 158 */         o.dists[home.reg.index()] = t.getValue();
/* 159 */         home.dists[o.reg.index()] = t.getValue();
/* 160 */         for (Reg.Connect l : o.land) {
/* 161 */           f.pushSmaller(l.to.reg.cx(), l.to.reg.cy(), t.getValue() + l.cost, t);
/*     */         }
/*     */       } 
/* 164 */       f.done();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void connect(PathTile t) {
/* 169 */     while (t != null) {
/* 170 */       this.debug.set((COORDINATE)t, true);
/* 171 */       t = t.getParent();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setPortDists() {
/* 177 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 178 */     f.init(this);
/* 179 */     for (Port p : this.ports) {
/* 180 */       f.pushSloppy(p.x(), p.y(), 0.0D, null);
/* 181 */       f.setValue2((COORDINATE)p, p.index);
/*     */     } 
/*     */     
/* 184 */     while (f.hasMore()) {
/*     */       
/* 186 */       PathTile t = f.pollSmallest();
/* 187 */       if (t.getParent() != null) {
/* 188 */         t.setValue2(t.getParent().getValue2());
/*     */       }
/*     */       
/* 191 */       for (DIR d : DIR.ALL) {
/* 192 */         if ((WORLD.WATER()).isBig.is((COORDINATE)t, d) && WTRAV.can(t.x(), t.y(), d, false)) {
/*     */           
/* 194 */           double v = ((WORLD.WATER()).coversTile.is((COORDINATE)t, d) ? true : 3);
/* 195 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 200 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 201 */       if (f.hasBeenPushed(c.x(), c.y())) {
/*     */         
/* 203 */         Port portFrom = (Port)this.ports.get((int)f.getValue2(c.x(), c.y()));
/* 204 */         double dist = f.getValue(c) + portFrom.cost;
/*     */         
/* 206 */         for (DIR d : DIR.ALL) {
/* 207 */           if (f.hasBeenPushed(c.x(), c.y(), d) && WTRAV.can(c.x(), c.y(), d, false)) {
/* 208 */             Port portTo = (Port)this.ports.get((int)f.getValue2(c.x(), c.y(), d));
/* 209 */             if (portFrom != portTo) {
/* 210 */               double dd = dist + f.getValue(c.x() + d.x(), c.y() + d.y());
/*     */               
/* 212 */               if (dd < portFrom.dists[portTo.index]) {
/* 213 */                 portFrom.dists[portTo.index] = dd;
/* 214 */                 portTo.dists[portFrom.index] = dd;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 222 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 223 */       if (f.hasBeenPushed(c.x(), c.y())) {
/*     */         
/* 225 */         Port portFrom = (Port)this.ports.get((int)f.getValue2(c.x(), c.y()));
/* 226 */         double dist = f.getValue(c) + portFrom.cost;
/*     */         
/* 228 */         for (DIR d : DIR.ALL) {
/* 229 */           if (f.hasBeenPushed(c.x(), c.y(), d) && WTRAV.can(c.x(), c.y(), d, false)) {
/* 230 */             Port portTo = (Port)this.ports.get((int)f.getValue2(c.x(), c.y(), d));
/* 231 */             if (portFrom != portTo) {
/* 232 */               double dd = dist + f.getValue(c.x() + d.x(), c.y() + d.y());
/*     */               
/* 234 */               if (dd <= portFrom.dists[portTo.index]) {
/* 235 */                 connect(f.get(c.x(), c.y()));
/* 236 */                 connect(f.get(c.x() + d.x(), c.y() + d.y()));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 244 */     f.done();
/*     */     
/* 246 */     for (Port home : new ArrayList((Iterable)this.ports)) {
/* 247 */       for (Port other : this.ports) {
/* 248 */         if (home == other || home.dists[other.index] == Double.MAX_VALUE)
/*     */           continue; 
/* 250 */         home.cons.add(new Port.Connect(other, home.dists[other.index]));
/*     */       } 
/*     */     } 
/*     */     
/* 254 */     for (Port home : this.ports) {
/* 255 */       if (home.cons.size() == 0)
/*     */         continue; 
/* 257 */       if (home.index % 10 == 0) {
/* 258 */         this.util.exe();
/*     */       }
/* 260 */       f.init(this);
/* 261 */       f.pushSloppy(home.x(), home.y(), 0.0D, null);
/*     */       
/* 263 */       while (f.hasMore()) {
/* 264 */         PathTile t = f.pollSmallest();
/* 265 */         Port o = (Port)this.port.get((COORDINATE)t);
/* 266 */         o.dists[home.index] = t.getValue();
/* 267 */         home.dists[o.index] = t.getValue();
/* 268 */         for (Port.Connect l : o.cons) {
/* 269 */           f.pushSmaller(l.to.x(), l.to.y(), t.getValue() + l.cost, t);
/*     */         }
/*     */       } 
/* 272 */       f.done();
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
/*     */   private boolean isConnected(Port p) {
/* 284 */     for (Port o : this.ports) {
/*     */       
/* 286 */       double w = p.dists[o.index];
/* 287 */       double l = p.reg.dists[o.reg.reg.index()];
/*     */       
/* 289 */       if (w == Double.MAX_VALUE) {
/*     */         continue;
/*     */       }
/* 292 */       if (l == Double.MAX_VALUE) {
/* 293 */         return true;
/*     */       }
/* 295 */       w += o.cost;
/* 296 */       w += p.cost;
/*     */       
/* 298 */       if (w + 32.0D < l) {
/* 299 */         return true;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 304 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static class Reg
/*     */   {
/*     */     public final Region reg;
/*     */     
/* 312 */     public ArrayListGrower<Connect> land = new ArrayListGrower();
/* 313 */     public ArrayListGrower<GenPortMini.Port> ports = new ArrayListGrower();
/* 314 */     public final double[] dists = new double[1023];
/*     */     
/*     */     private Reg(Region reg) {
/* 317 */       this.reg = reg;
/* 318 */       Arrays.fill(this.dists, Double.MAX_VALUE);
/*     */     }
/*     */     
/*     */     static class Connect
/*     */     {
/*     */       final GenPortMini.Reg to;
/*     */       final double cost;
/*     */       
/*     */       Connect(GenPortMini.Reg to, double cost) {
/* 327 */         this.to = to;
/* 328 */         this.cost = cost; } } } static class Connect { final GenPortMini.Reg to; final double cost; Connect(GenPortMini.Reg to, double cost) { this.to = to; this.cost = cost; }
/*     */      }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GenPortMini(ACTION util, final MAP_BOOLEANE marked) {
/* 337 */     this.map = new MAP_OBJECT<Reg>()
/*     */       {
/*     */         public GenPortMini.Reg get(int tx, int ty)
/*     */         {
/* 341 */           if (WORLD.IN_BOUNDS(tx, ty))
/* 342 */             return get(tx + ty * WORLD.TWIDTH()); 
/* 343 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public GenPortMini.Reg get(int tile) {
/* 348 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tile);
/* 349 */           if (reg != null) {
/* 350 */             return (GenPortMini.Reg)GenPortMini.this.regs.get(reg.index());
/*     */           }
/* 352 */           return null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 389 */     this.port = new MAP_OBJECT<Port>()
/*     */       {
/*     */         public GenPortMini.Port get(int tx, int ty)
/*     */         {
/* 393 */           if (WORLD.IN_BOUNDS(tx, ty))
/* 394 */             return get(tx + ty * WORLD.TWIDTH()); 
/* 395 */           return null; } protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) { if (marked.is(it.tile())) {
/*     */             COLOR.BLUEISH.bind(); (SPRITES.cons()).ICO.crosshair.render(r, it.x(), it.y()); COLOR.unbind();
/*     */           } else if (GenPortMini.this.debug.is(it.tile())) {
/*     */             COLOR.ORANGE100.bind(); (SPRITES.cons()).BIG.line.render(r, 0, it.x(), it.y()); COLOR.unbind();
/*     */           }  }
/* 400 */       }; this.util = util; this.marked = marked; (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false) { public GenPortMini.Port get(int tile) { GenPortMini.Reg reg = (GenPortMini.Reg)GenPortMini.this.map.get(tile);
/* 401 */           if (reg != null)
/* 402 */             for (int i = 0; i < reg.ports.size(); i++) {
/* 403 */               if (((GenPortMini.Port)reg.ports.get(i)).x() + ((GenPortMini.Port)reg.ports.get(i)).y() * WORLD.TWIDTH() == tile) {
/* 404 */                 return (GenPortMini.Port)reg.ports.get(i);
/*     */               }
/*     */             }  
/* 407 */           return null; } }; for (Region r : WORLD.REGIONS().all())
/*     */       this.regs.add(new Reg(r));  setLand(); for (Port p : this.ports) { p.dists = new double[this.ports.size()]; Arrays.fill(p.dists, Double.MAX_VALUE); }
/*     */      util.exe(); setPortDists(); util.exe(); for (Port p : new ArrayList((Iterable)this.ports)) {
/*     */       if (!isConnected(p))
/*     */         marked.set((COORDINATE)p, false); 
/* 412 */     }  } public Reg get(Region reg) { return (Reg)this.regs.get(reg.index()); }
/*     */ 
/*     */   
/*     */   private static class Port extends Coo {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private final int index;
/*     */     private final GenPortMini.Reg reg;
/*     */     private final double cost;
/*     */     private double[] dists;
/*     */     private ArrayListGrower<Connect> cons = new ArrayListGrower();
/*     */     
/*     */     private Port(COORDINATE c, GenPortMini.Reg reg, double cost, int index) {
/*     */       set(c);
/*     */       this.reg = reg;
/*     */       this.cost = cost;
/*     */       this.index = index;
/*     */     }
/*     */     
/*     */     static class Connect {
/*     */       final GenPortMini.Port to;
/*     */       final double cost;
/*     */       
/*     */       Connect(GenPortMini.Port to, double cost) {
/*     */         this.to = to;
/*     */         this.cost = cost;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static class Connect {
/*     */     final GenPortMini.Port to;
/*     */     final double cost;
/*     */     
/*     */     Connect(GenPortMini.Port to, double cost) {
/*     */       this.to = to;
/*     */       this.cost = cost;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPortMini.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */