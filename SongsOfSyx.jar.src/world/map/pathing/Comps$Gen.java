/*     */ package world.map.pathing;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Gen
/*     */ {
/*     */   private final Comps.WComp[] comps;
/*     */   private final WDirMap m;
/*  82 */   private Bitmap2D mark = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*     */   private boolean log = false;
/*  84 */   private static double dist = 8.0D;
/*     */   
/*     */   Gen(ACTION aa, WDirMap m) {
/*  87 */     this.m = m;
/*  88 */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*     */       {
/*     */         
/*     */         protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*     */         {
/*  93 */           if ((WORLD.PATH()).map.is.is(it.tile())) {
/*  94 */             COLOR.WHITE100.bind();
/*  95 */             for (int di = 0; di < DIR.ALL.size(); di++) {
/*  96 */               DIR d = (DIR)DIR.ALL.get(di);
/*  97 */               if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/*  98 */                 ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */             } 
/* 100 */             COLOR.unbind();
/*     */           } 
/* 102 */           if (Comps.Gen.this.mark.is(it.tx(), it.ty())) {
/* 103 */             COLOR.RED100.bind();
/* 104 */             (SPRITES.cons()).ICO.clear.render(r, it.x(), it.y());
/* 105 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 111 */     LinkedList<Comps.WComp> comps = new LinkedList();
/* 112 */     int id = 0;
/*     */ 
/*     */ 
/*     */     
/* 116 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 117 */       if (isComp(c)) {
/* 118 */         this.mark.set(c, true);
/* 119 */         comps.add(new Comps.WComp(c.x(), c.y(), id));
/* 120 */         id++;
/*     */       } 
/*     */     } 
/*     */     
/* 124 */     createAdditional(comps, aa);
/*     */ 
/*     */     
/* 127 */     this.comps = new Comps.WComp[comps.size()];
/* 128 */     id = 0;
/* 129 */     for (Comps.WComp c : comps) {
/* 130 */       this.comps[id++] = c;
/*     */     }
/*     */     
/* 133 */     if (this.log) {
/* 134 */       LOG.ln("Components " + comps.size());
/*     */     }
/* 136 */     int ii = 0;
/* 137 */     final Bitmap1D check = new Bitmap1D(this.comps.length, false);
/*     */     
/* 139 */     final Bitmap2D tmp = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/* 140 */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*     */       {
/*     */         
/*     */         protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*     */         {
/* 145 */           if ((WORLD.PATH()).map.is.is(it.tile())) {
/*     */             
/* 147 */             if (tmp.is(it.tile())) {
/* 148 */               COLOR.ORANGE100.bind();
/*     */             } else {
/* 150 */               COLOR.WHITE100.bind();
/* 151 */             }  for (int di = 0; di < DIR.ALL.size(); di++) {
/* 152 */               DIR d = (DIR)DIR.ALL.get(di);
/* 153 */               if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/* 154 */                 ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */             } 
/* 156 */             COLOR.unbind();
/*     */           } 
/*     */ 
/*     */           
/* 160 */           if (Comps.Gen.this.mark.is(it.tx(), it.ty())) {
/* 161 */             (check.get((int)GUTIL.flooder().getValue2(it.tx(), it.ty())) ? COLOR.GREEN100 : COLOR.RED100).bind();
/* 162 */             (SPRITES.cons()).ICO.clear.render(r, it.x(), it.y());
/* 163 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 168 */     for (COORDINATE c : WORLD.TBOUNDS())
/* 169 */       GUTIL.flooder().setValue2(c, -1.0D);  byte b;
/*     */     int i;
/*     */     Comps.WComp[] arrayOfWComp;
/* 172 */     for (i = (arrayOfWComp = this.comps).length, b = 0; b < i; ) { Comps.WComp c = arrayOfWComp[b];
/* 173 */       GUTIL.flooder().setValue2(c.tx, c.ty, c.id);
/*     */       b++; }
/*     */     
/* 176 */     for (i = (arrayOfWComp = this.comps).length, b = 0; b < i; ) { Comps.WComp c = arrayOfWComp[b];
/* 177 */       if (!check.get((int)GUTIL.flooder().getValue2(c.tx, c.ty))) {
/* 178 */         init(c, check, tmp);
/* 179 */         if (ii++ % 5 == 0)
/* 180 */           aa.exe(); 
/*     */       } 
/*     */       b++; }
/*     */     
/* 184 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 185 */       if (m.is.is(c) && !tmp.is(c)) {
/* 186 */         m.remove(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isComp(COORDINATE c) {
/* 193 */     if ((WORLD.REGIONS()).cTile.is(c))
/* 194 */       return true; 
/* 195 */     if (!this.m.is.is(c)) {
/* 196 */       return false;
/*     */     }
/* 198 */     if ((WORLD.WATER()).isBig.is(c)) {
/* 199 */       boolean water = false;
/* 200 */       boolean land = false;
/*     */       
/* 202 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 203 */         DIR d = (DIR)DIR.ALL.get(di);
/* 204 */         if (this.m.can(c, d)) {
/* 205 */           if ((WORLD.WATER()).isBig.is(c, d)) {
/* 206 */             water = true;
/*     */           } else {
/*     */             
/* 209 */             land = true;
/*     */           } 
/*     */         }
/*     */       } 
/* 213 */       if (water && land) {
/* 214 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 218 */     Region h = (Region)(WORLD.PATH()).regMap.get(c);
/* 219 */     if (h != null) {
/* 220 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 221 */         DIR d = (DIR)DIR.ALL.get(di);
/* 222 */         if (this.m.can(c, d) && (WORLD.PATH()).regMap.get(c, d) != h) {
/* 223 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 228 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createAdditional(LinkedList<Comps.WComp> comps, ACTION aa) {
/* 233 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 234 */       GUTIL.flooder().setValue2(c, 0.0D);
/*     */     }
/*     */ 
/*     */     
/* 238 */     for (int i = 0; i < 20; i++) {
/* 239 */       aa.exe();
/* 240 */       createAdditionalP(comps);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean createAdditionalP(LinkedList<Comps.WComp> comps) {
/* 245 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 246 */     f.init(this);
/*     */     
/* 248 */     int id = 0;
/* 249 */     int pp = 0;
/* 250 */     for (Comps.WComp c : comps) {
/* 251 */       if (f.getValue2(c.tx, c.ty) == 0.0F) {
/* 252 */         f.pushSloppy(c.tx, c.ty, 0.0D);
/* 253 */         pp++;
/*     */       } 
/* 255 */       id++;
/*     */     } 
/*     */     
/* 258 */     if (pp == 0) {
/* 259 */       f.done();
/* 260 */       return false;
/*     */     } 
/*     */     
/* 263 */     while (f.hasMore()) {
/* 264 */       PathTile t = f.pollSmallest();
/* 265 */       if (t.getValue2() != 0.0F) {
/*     */         continue;
/*     */       }
/* 268 */       if (t.getValue() > dist) {
/* 269 */         int c = 0;
/* 270 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 271 */           DIR d = (DIR)DIR.ALL.get(di);
/* 272 */           if (this.m.can((COORDINATE)t, d)) {
/* 273 */             c++;
/*     */           }
/*     */         } 
/* 276 */         if (c == 2) {
/* 277 */           comps.add(new Comps.WComp(t.x(), t.y(), id++));
/* 278 */           this.mark.set((COORDINATE)t, true);
/* 279 */           t = t.getParent();
/* 280 */           while (t != null) {
/* 281 */             f.setValue2((COORDINATE)t, 1.0D);
/* 282 */             t = t.getParent();
/*     */           } 
/*     */           continue;
/*     */         } 
/*     */       } 
/* 287 */       this.m.pushSimple(t);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 292 */     f.done();
/* 293 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void init(Comps.WComp start, Bitmap1D check, Bitmap2D tmp) {
/* 298 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 299 */     f.init(this);
/* 300 */     f.pushSloppy(start.tx, start.ty, 0.0D);
/*     */     
/* 302 */     int home = (int)f.getValue2(start.tx, start.ty);
/*     */     
/* 304 */     while (f.hasMore()) {
/*     */       
/* 306 */       PathTile t = f.pollSmallest();
/* 307 */       int id = (int)t.getValue2();
/* 308 */       if (id >= 0 && id != home) {
/* 309 */         if (!check.get(id)) {
/* 310 */           this.comps[home].push(id, t.getValue());
/* 311 */           this.comps[id].push(home, t.getValue());
/* 312 */           while (t != null) {
/* 313 */             tmp.set((COORDINATE)t, true);
/* 314 */             t = t.getParent();
/*     */           } 
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/* 320 */       this.m.push(t, t.getValue());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 325 */     check.set(home, true);
/* 326 */     f.done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\Comps$Gen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */