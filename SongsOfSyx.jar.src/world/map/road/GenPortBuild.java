/*     */ package world.map.road;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ final class GenPortBuild
/*     */ {
/*     */   private final MAP_DOUBLE cost;
/*     */   
/*     */   GenPortBuild(ACTION util, MAP_DOUBLE cost, final MAP_BOOLEAN marked, final MAP_BOOLEAN bridge) {
/*  25 */     this.cost = cost;
/*  26 */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*     */       {
/*     */         protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*     */         {
/*  30 */           if (marked.is(it.tile())) {
/*  31 */             COLOR.BLUEISH.bind();
/*  32 */             (SPRITES.cons()).ICO.crosshair.render(r, it.x(), it.y());
/*  33 */             COLOR.unbind();
/*  34 */           } else if (bridge.is(it.tile())) {
/*  35 */             COLOR.ORANGE100.bind();
/*  36 */             (SPRITES.cons()).BIG.line.render(r, 0, it.x(), it.y());
/*  37 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  42 */     int i = 0;
/*     */     
/*  44 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  45 */       if (marked.is(c)) {
/*  46 */         i++;
/*  47 */         if (i % 10 == 0)
/*  48 */           util.exe(); 
/*  49 */         build(c, false); continue;
/*  50 */       }  if (bridge.is(c)) {
/*  51 */         WORLD.ROADS().set(c, true);
/*  52 */         if ((WORLD.ROADS()).canBridge.is(c))
/*  53 */           (WORLD.ROADS()).bridge.set(c, true); 
/*  54 */         build(c, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void build(COORDINATE start, boolean mini) {
/*  65 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  66 */     f.init(this);
/*  67 */     f.pushSloppy(start.x(), start.y(), 0.0D, null);
/*  68 */     Region home = (Region)(WORLD.REGIONS()).map.get(start);
/*     */     
/*  70 */     while (f.hasMore()) {
/*  71 */       PathTile t = f.pollSmallest();
/*  72 */       Region r = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/*  73 */       if (r != home)
/*     */         continue; 
/*  75 */       if (t.isSameAs(r.cx(), r.cy())) {
/*  76 */         if (mini) {
/*  77 */           if (!WORLD.ROADS().is((COORDINATE)t)) {
/*  78 */             WORLD.ROADS().set((COORDINATE)t, true);
/*  79 */             (WORLD.ROADS()).minified.set((COORDINATE)t, true);
/*     */           } 
/*  81 */           while (t != null) {
/*  82 */             if (!WORLD.ROADS().is((COORDINATE)t) && (WORLD.ROADS()).placable.is((COORDINATE)t)) {
/*  83 */               WORLD.ROADS().set((COORDINATE)t, true);
/*  84 */               (WORLD.ROADS()).minified.set((COORDINATE)t, true);
/*     */             } 
/*  86 */             t = t.getParent();
/*     */           } 
/*     */         } else {
/*  89 */           WORLD.ROADS().set(start, true);
/*  90 */           WTRAV.makeRoad(t);
/*  91 */           f.done();
/*     */         } 
/*  93 */         f.done();
/*     */         
/*     */         return;
/*     */       } 
/*  97 */       for (DIR d : DIR.ALL) {
/*     */         
/*  99 */         if (WTRAV.canLand(t.x(), t.y(), d, false)) {
/* 100 */           int dx = t.x() + d.x();
/* 101 */           int dy = t.y() + d.y();
/* 102 */           double v = this.cost.get(dx, dy) + WTRAV.cost(t.x(), t.y(), d);
/* 103 */           if (WTRAV.canLand(t.x(), t.y(), d, true))
/* 104 */             v *= 0.5D; 
/* 105 */           f.pushSmaller(dx, dy, t.getValue() + v * d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 111 */     f.done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPortBuild.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */