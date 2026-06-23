/*     */ package world.map.road;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import javax.sound.sampled.Port;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GenPort
/*     */ {
/*     */   private final IntChecker wCheck;
/*  32 */   public final LinkedList<Port> allports = new LinkedList();
/*     */   
/*     */   public final Bitsmap2D wmap;
/*     */   
/*     */   private final MAP_DOUBLE u;
/*  37 */   public Bitmap2D port = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  38 */   public Bitmap2D oldPort = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*     */ 
/*     */ 
/*     */   
/*     */   public GenPort(ACTION u, MAP_DOUBLE infra) {
/*  43 */     this.u = infra;
/*     */     
/*  45 */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*     */       {
/*     */         protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*     */         {
/*  49 */           if (GenPort.this.port.is(it.tile())) {
/*  50 */             if (GenPort.this.oldPort.is(it.tile())) {
/*  51 */               COLOR.REDISH.bind();
/*     */             } else {
/*  53 */               COLOR.ORANGE100.bind();
/*  54 */             }  (SPRITES.cons()).ICO.crosshair.render(r, it.x(), it.y());
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  61 */     int wi = 0;
/*     */     
/*  63 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  64 */       GUTIL.flooder().setValue2(c, 0.0D);
/*     */     }
/*     */     
/*  67 */     wi = 1;
/*     */     
/*  69 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  70 */       if ((WORLD.WATER()).isBig.is(c) && GUTIL.flooder().getValue2(c.x(), c.y()) == 0.0F && 
/*  71 */         assignWater(wi, c.x(), c.y())) {
/*  72 */         wi++;
/*     */       }
/*     */     } 
/*  75 */     wi--;
/*     */     
/*  77 */     int kk = (wi == 0) ? 32 : (32 - Integer.numberOfTrailingZeros(wi));
/*     */     
/*  79 */     this.wmap = new Bitsmap2D(0, kk, (DIMENSION)WORLD.TBOUNDS());
/*     */     
/*  81 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  82 */       this.wmap.set(c, (int)CLAMP.d((GUTIL.flooder().getValue2(c.x(), c.y()) - 1.0F), 0.0D, wi));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  87 */     u.exe();
/*  88 */     this.wCheck = new IntChecker(wi + 1);
/*     */     
/*  90 */     int a = 0;
/*     */     
/*  92 */     for (Region r : WORLD.REGIONS().all()) {
/*  93 */       if (r.info.area() == 0)
/*     */         continue; 
/*  95 */       if (a++ > 10) {
/*  96 */         a = 0;
/*  97 */         u.exe();
/*     */       } 
/*  99 */       createPorts(r);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean assignWater(int i, int x, int y) {
/* 110 */     GUTIL.flooder().init(this);
/* 111 */     GUTIL.flooder().pushSloppy(x, y, 0.0D);
/*     */     
/* 113 */     while (GUTIL.flooder().hasMore()) {
/* 114 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 115 */       t.setValue2(i);
/* 116 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 117 */         DIR d = (DIR)DIR.ALL.get(di);
/* 118 */         int dx = t.x() + d.x();
/* 119 */         int dy = t.y() + d.y();
/* 120 */         if ((WORLD.WATER()).isBig.is(dx, dy) && WTRAV.can(t.x(), t.y(), d, false)) {
/* 121 */           GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + d.tileDistance(), t);
/*     */         }
/*     */       } 
/*     */     } 
/* 125 */     GUTIL.flooder().done();
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createPorts(Region home) {
/* 136 */     this.wCheck.init();
/* 137 */     int am = 0;
/*     */     
/* 139 */     for (COORDINATE c : home.info.bounds()) {
/* 140 */       if (home.is(c) && WTRAV.HARBOUR.isPossible(c.x(), c.y(), false) && !this.wCheck.isSetAndSet(this.wmap.get(c))) {
/* 141 */         am++;
/*     */       }
/*     */     } 
/*     */     
/* 145 */     this.wCheck.init();
/*     */     
/* 147 */     for (COORDINATE c : home.info.bounds()) {
/* 148 */       if (home.is(c) && (WORLD.WATER()).isBig.is(c) && WORLD.ROADS().is(c)) {
/* 149 */         if (!this.wCheck.isSetAndSet(this.wmap.get(c))) {
/* 150 */           this.port.set(c, true);
/* 151 */           am--;
/*     */         } 
/* 153 */         this.oldPort.set(c, true);
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     while (createPort(home) && am > 0) {
/* 158 */       am--;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean createPort(Region home) {
/* 166 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 167 */     f.init(this);
/*     */     
/* 169 */     PathTile hh = f.close(home.info.cx(), home.info.cy(), 0.0D, null);
/*     */     
/* 171 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 172 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 173 */       int dx = home.info.cx() + d.x();
/* 174 */       int dy = home.info.cy() + d.y();
/* 175 */       if (WTRAV.isGoodLandTile(dx, dy) && WTRAV.canLand(home.info.cx(), home.info.cy(), d, false)) {
/* 176 */         f.pushSloppy(dx, dy, 0.0D, hh);
/* 177 */         f.setValue2(dx, dy, 0.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     PathTile backup = null;
/*     */     
/* 186 */     while (f.hasMore()) {
/* 187 */       PathTile t = f.pollSmallest();
/* 188 */       Region current = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/* 189 */       if (current == null || current != home) {
/*     */         continue;
/*     */       }
/* 192 */       if ((WORLD.WATER()).isBig.is((COORDINATE)t) && !this.wCheck.isSet(this.wmap.get((COORDINATE)t))) {
/* 193 */         if (WTRAV.isHarbour(t.x(), t.y()) && !(WORLD.REGIONS()).cTile.is((COORDINATE)t)) {
/* 194 */           this.wCheck.isSetAndSet(this.wmap.get((COORDINATE)t));
/* 195 */           f.done();
/* 196 */           this.port.set((COORDINATE)t, true);
/* 197 */           return true;
/*     */         } 
/* 199 */         backup = t;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 205 */       for (DIR d : DIR.ALL) {
/*     */         
/* 207 */         if (WTRAV.can(t.x(), t.y(), d, false)) {
/* 208 */           int dx = t.x() + d.x();
/* 209 */           int dy = t.y() + d.y();
/* 210 */           double v = this.u.get(dx, dy) + WTRAV.cost(t.x(), t.y(), d);
/* 211 */           if ((WORLD.WATER()).isBig.is((COORDINATE)t))
/* 212 */             v += 100.0D; 
/* 213 */           f.pushSmaller(dx, dy, t.getValue() + v * d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 218 */     f.done();
/* 219 */     if (backup != null) {
/* 220 */       this.wCheck.isSetAndSet(this.wmap.get((COORDINATE)backup));
/* 221 */       this.port.set((COORDINATE)backup, true);
/* 222 */       return true;
/*     */     } 
/* 224 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPort.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */