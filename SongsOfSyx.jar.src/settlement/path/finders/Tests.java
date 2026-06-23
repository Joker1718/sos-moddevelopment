/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GButt;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Tests
/*     */ {
/*     */   private final SFINDERS finders;
/*     */   
/*     */   Tests(SFINDERS finders) {
/*  45 */     this.finders = finders;
/*  46 */     IDebugPanelSett.add("Path Compare astar", new PlacerCompare());
/*     */     
/*  48 */     (new ON_TOP_RENDERABLE()
/*     */       {
/*     */         Bitmap1D map;
/*     */ 
/*     */         
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/*  54 */           if (!TestPath.tester.isSuccessful()) {
/*     */             return;
/*     */           }
/*  57 */           if (this.map == null) {
/*     */             return;
/*     */           }
/*  60 */           if (TestPath.tester.hasNext()) {
/*  61 */             this.map = new Bitmap1D(SETT.TAREA, false);
/*     */             
/*  63 */             this.map.set(TestPath.tester.x() + TestPath.tester.y() * SETT.TWIDTH, true);
/*  64 */             while (TestPath.tester.setNext()) {
/*  65 */               this.map.set(TestPath.tester.x() + TestPath.tester.y() * SETT.TWIDTH, true);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/*  70 */           RenderData.RenderIterator it = data.onScreenTiles();
/*  71 */           while (it.has()) {
/*  72 */             if (this.map.get(it.tile())) {
/*  73 */               (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*     */             }
/*  75 */             it.next();
/*     */           } 
/*     */         }
/*  78 */       }).add();
/*     */     
/*  80 */     IDebugPanelSett.add("Path Per Test", new ACTION() {
/*  81 */           final SPath p = new SPath();
/*     */ 
/*     */           
/*     */           public void exe() {
/*  85 */             int am = 1000;
/*  86 */             int[] sx = Alloc.ii(1000);
/*  87 */             int[] sy = Alloc.ii(1000);
/*     */             
/*  89 */             for (int i = 0; i < 1000; i++) {
/*  90 */               sx[i] = RND.rInt(SETT.TWIDTH);
/*  91 */               sy[i] = RND.rInt(SETT.THEIGHT);
/*     */             } 
/*     */ 
/*     */             
/*  95 */             int[] dx = Alloc.ii(1000);
/*  96 */             int[] dy = Alloc.ii(1000);
/*  97 */             for (int k = 0; k < 1000; k++) {
/*  98 */               dx[k] = RND.rInt(SETT.TWIDTH);
/*  99 */               dy[k] = RND.rInt(SETT.THEIGHT);
/*     */             } 
/* 101 */             long l2 = System.currentTimeMillis();
/* 102 */             int i1 = 0;
/* 103 */             l2 = System.currentTimeMillis();
/* 104 */             i1 = 0;
/* 105 */             for (int i3 = 0; i3 < 1000; i3++) {
/* 106 */               if (find(sx[i3], sy[i3], dx[i3], dy[i3], false))
/* 107 */                 i1++; 
/*     */             } 
/* 109 */             double d3 = i1;
/* 110 */             d3 /= (System.currentTimeMillis() - l2);
/* 111 */             d3 *= 1000.0D;
/* 112 */             LOG.ln("long paths: " + d3 + "p/s, paths: " + i1);
/*     */ 
/*     */ 
/*     */             
/* 116 */             dx = Alloc.ii(1000);
/* 117 */             dy = Alloc.ii(1000);
/* 118 */             for (int j = 0; j < 1000; j++) {
/* 119 */               dx[j] = CLAMP.i(sx[j] + RND.rInt0(100), 0, SETT.TWIDTH);
/* 120 */               dy[j] = CLAMP.i(sy[j] + RND.rInt0(100), 0, SETT.TWIDTH);
/*     */             } 
/* 122 */             long l1 = System.currentTimeMillis();
/* 123 */             i1 = 0;
/* 124 */             l1 = System.currentTimeMillis();
/* 125 */             i1 = 0;
/* 126 */             for (int i2 = 0; i2 < 1000; i2++) {
/* 127 */               if (find(sx[i2], sy[i2], dx[i2], dy[i2], false))
/* 128 */                 i1++; 
/*     */             } 
/* 130 */             double d2 = i1;
/* 131 */             d2 /= (System.currentTimeMillis() - l1);
/* 132 */             d2 *= 1000.0D;
/* 133 */             LOG.ln("short paths: " + d2 + "p/s, paths: " + i1);
/*     */ 
/*     */ 
/*     */             
/* 137 */             long now = System.currentTimeMillis();
/* 138 */             int a = 0;
/*     */             
/* 140 */             now = System.currentTimeMillis();
/* 141 */             a = 0;
/* 142 */             for (int n = 0; n < 1000; n++) {
/* 143 */               if (findR(sx[n], sy[n], false))
/* 144 */                 a++; 
/*     */             } 
/* 146 */             double d1 = a;
/* 147 */             d1 /= (System.currentTimeMillis() - now);
/* 148 */             d1 *= 1000.0D;
/* 149 */             LOG.ln("res closest: " + d1 + "p/s, paths: " + a);
/*     */ 
/*     */ 
/*     */             
/* 153 */             now = System.currentTimeMillis();
/* 154 */             a = 0;
/*     */             
/* 156 */             now = System.currentTimeMillis();
/* 157 */             a = 0;
/* 158 */             for (int m = 0; m < 1000; m++) {
/* 159 */               if (findJ(sx[m], sy[m]))
/* 160 */                 a++; 
/*     */             } 
/* 162 */             double d = a;
/* 163 */             d /= (System.currentTimeMillis() - now);
/* 164 */             d *= 1000.0D;
/* 165 */             LOG.ln("job: " + d + "p/s, paths: " + a);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           private boolean find(int startX, int startY, int destX, int destY, boolean full) {
/* 174 */             if (!this.p.request(startX, startY, destX, destY, full)) {
/* 175 */               return false;
/*     */             }
/*     */             
/* 178 */             return forward();
/*     */           }
/*     */           private boolean forward() {
/*     */             do {
/*     */             
/* 183 */             } while (!this.p.isDest() && this.p.isSuccessful() && this.p.setNext());
/*     */ 
/*     */             
/* 186 */             return this.p.isSuccessful();
/*     */           }
/*     */           
/*     */           private boolean findR(int startX, int startY, boolean full) {
/* 190 */             RESOURCE res = (SETT.PATH()).finders.resource.scattered.reserve(startX, startY, RBIT.ALL, this.p, 250);
/* 191 */             if (res == null) {
/* 192 */               return false;
/*     */             }
/*     */             
/* 195 */             (SETT.PATH()).finders.resource.unreserve(res, this.p.destX(), this.p.destY(), 1);
/*     */             
/* 197 */             return forward();
/*     */           }
/*     */ 
/*     */           
/*     */           private boolean findJ(int startX, int startY) {
/* 202 */             if ((SETT.PATH()).finders.job.find(startX, startY, this.p, true) != null) {
/* 203 */               return forward();
/*     */             }
/* 205 */             return false;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 210 */     IDebugPanelSett.add((PLACABLE)new FF());
/*     */   }
/*     */ 
/*     */   
/*     */   private class FF
/*     */     extends PlacableSimpleTile
/*     */   {
/* 217 */     private Coo start = new Coo(-1.0D, -1.0D); ON_TOP_RENDERABLE rr;
/*     */     
/*     */     public FF() {
/* 220 */       super("Path Place");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 234 */       this.rr = new ON_TOP_RENDERABLE()
/*     */         {
/*     */           
/*     */           public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */           {
/* 239 */             remove();
/*     */             
/* 241 */             if (Tests.FF.this.start.x() == -1 || (SETT.PATH()).solidity.is((COORDINATE)Tests.FF.this.start)) {
/*     */               return;
/*     */             }
/* 244 */             int dx = VIEW.s().getWindow().tile().x();
/* 245 */             int dy = VIEW.s().getWindow().tile().y();
/*     */             
/* 247 */             if ((SETT.PATH()).solidity.is(dx, dy)) {
/*     */               return;
/*     */             }
/* 250 */             PathTile t = (SETT.PATH()).finders.finder().cDebug(Tests.FF.this.start.x(), Tests.FF.this.start.y(), dx, dy, true);
/* 251 */             int dd = (int)(VIEW.renderSecond() * 8.0D) % 1024;
/*     */             
/* 253 */             while (t != null) {
/*     */               
/* 255 */               int sx = t.x();
/* 256 */               int sy = t.y();
/* 257 */               while (t != null) {
/* 258 */                 ((dd == 0) ? COLOR.WHITE100 : COLOR.ORANGE100).bind();
/* 259 */                 int rx = data.transformGX(t.x() * 64);
/* 260 */                 int ry = data.transformGY(t.y() * 64);
/* 261 */                 (SPRITES.cons()).ICO.tile.render((SPRITE_RENDERER)r, rx, ry);
/*     */ 
/*     */                 
/* 264 */                 t = t.getParent();
/* 265 */                 dd--;
/*     */               } 
/*     */               
/* 268 */               if (Math.abs(sx - dx) <= 1 && Math.abs(sy - dy) <= 1) {
/*     */                 break;
/*     */               }
/* 271 */               t = (SETT.PATH()).finders.finder().find(sx, sy, dx, dy, true);
/*     */             } 
/*     */           }
/*     */         };
/*     */     }
/*     */     public CharSequence isPlacable(int tx, int ty) {
/*     */       return (SETT.PATH()).solidity.is(tx, ty) ? Dic.empty : null;
/*     */     }
/*     */     
/*     */     public void renderOverlay(GameWindow window) {
/* 281 */       this.rr.add();
/*     */     }
/*     */     
/*     */     public void place(int tx, int ty) {
/*     */       this.start.set(tx, ty);
/*     */     } }
/*     */   
/* 288 */   private class PlacerCompare implements ACTION { private Bitmap1D map = null;
/* 289 */     private Bitmap1D map2 = null; int sx;
/*     */     int sy;
/* 291 */     private final SPath path = new SPath();
/* 292 */     private final PathGame.PathFancy path2 = new PathGame.PathFancy(256);
/*     */     
/* 294 */     ON_TOP_RENDERABLE ren = new ON_TOP_RENDERABLE()
/*     */       {
/*     */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */         {
/* 298 */           if (Tests.PlacerCompare.this.map == null) {
/* 299 */             remove();
/*     */             return;
/*     */           } 
/* 302 */           RenderData.RenderIterator it = data.onScreenTiles();
/* 303 */           while (it.has()) {
/* 304 */             if (Tests.PlacerCompare.this.map.get(it.tile())) {
/* 305 */               (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*     */             }
/* 307 */             it.next();
/*     */           } 
/*     */           
/* 310 */           if (Tests.PlacerCompare.this.map2 == null)
/*     */             return; 
/* 312 */           it = data.onScreenTiles();
/* 313 */           while (it.has()) {
/* 314 */             COLOR.RED100.bind();
/* 315 */             if (Tests.PlacerCompare.this.map2.get(it.tile())) {
/* 316 */               (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x() + 4, it.y() + 4);
/*     */             }
/* 318 */             it.next();
/*     */           } 
/* 320 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */     
/* 324 */     PlacableSimpleTile p1 = new PlacableSimpleTile("set start")
/*     */       {
/*     */         public void place(int tx, int ty)
/*     */         {
/* 328 */           Tests.PlacerCompare.this.sx = tx;
/* 329 */           Tests.PlacerCompare.this.sy = ty;
/* 330 */           (VIEW.s()).tools.place((PLACABLE)Tests.PlacerCompare.this.p2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/* 336 */           if ((SETT.PATH()).solidity.is(tx, ty))
/* 337 */             return E; 
/* 338 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 342 */     PlacableSimpleTile p2 = new PlacableSimpleTile("set dest")
/*     */       {
/*     */         boolean full = false;
/*     */         
/* 346 */         final ArrayList<CLICKABLE> pp = new ArrayList(
/* 347 */             new GButt.Panel("F")
/*     */             {
/*     */               protected void clickA() {
/* 350 */                 Tests.PlacerCompare.null.this.full = !Tests.PlacerCompare.null.this.full;
/*     */               }
/*     */               
/*     */               protected void renAction() {
/* 354 */                 selectedSet(Tests.PlacerCompare.null.this.full);
/*     */               }
/*     */             });
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty)
/*     */         {
/* 361 */           if (Tests.PlacerCompare.this.path.request(Tests.PlacerCompare.this.sx, Tests.PlacerCompare.this.sy, tx, ty, this.full)) {
/* 362 */             Tests.PlacerCompare.this.map = new Bitmap1D(SETT.TAREA, false);
/* 363 */             Tests.PlacerCompare.this.map.set(Tests.PlacerCompare.this.path.x() + Tests.PlacerCompare.this.path.y() * SETT.TWIDTH, true);
/* 364 */             while (Tests.PlacerCompare.this.path.isSuccessful() && Tests.PlacerCompare.this.path.setNext()) {
/* 365 */               Tests.PlacerCompare.this.map.set(Tests.PlacerCompare.this.path.x() + Tests.PlacerCompare.this.path.y() * SETT.TWIDTH, true);
/*     */             }
/* 367 */             Tests.PlacerCompare.this.ren.add();
/*     */           } 
/*     */ 
/*     */           
/* 371 */           if (GUTIL.astar().getShortest(Tests.PlacerCompare.this.path2, (SETT.PATH()).coster.player, Tests.PlacerCompare.this.sx, Tests.PlacerCompare.this.sy, tx, ty)) {
/* 372 */             Tests.PlacerCompare.this.map2 = new Bitmap1D(SETT.TAREA, false);
/* 373 */             Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true); label19: while (true) {
/*     */               while (true) {
/* 375 */                 if (!Tests.PlacerCompare.this.path2.setNext())
/*     */                 
/*     */                 { 
/* 378 */                   if (Tests.PlacerCompare.this.path2.isCompleate() || !GUTIL.astar().getShortest(Tests.PlacerCompare.this.path2, (SETT.PATH()).coster.player, Tests.PlacerCompare.this.path2.x(), Tests.PlacerCompare.this.path2.y(), tx, ty))
/*     */                     break;  continue; }  Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true);
/* 380 */               }  Tests.PlacerCompare.this.ren.add();
/*     */               break label19;
/*     */             } 
/*     */           } else {
/*     */             return;
/*     */           } 
/*     */           Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true);
/* 387 */           continue; } public CharSequence isPlacable(int tx, int ty) { return null; }
/*     */ 
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 392 */           return (LIST<CLICKABLE>)this.pp;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void exe() {
/* 400 */       this.path.clear();
/* 401 */       (VIEW.s()).tools.place((PLACABLE)this.p1);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\Tests.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */