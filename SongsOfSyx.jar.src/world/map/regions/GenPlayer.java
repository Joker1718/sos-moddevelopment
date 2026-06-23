/*     */ package world.map.regions;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ 
/*     */ class GenPlayer
/*     */ {
/*     */   public static boolean gen() {
/*  18 */     int pcx = -1;
/*  19 */     int pcy = -1;
/*     */     
/*  21 */     if ((WORLD.REGIONS()).player.is((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy())) {
/*  22 */       pcx = (WORLD.REGIONS()).player.cx();
/*  23 */       pcy = (WORLD.REGIONS()).player.cy();
/*  24 */     } else if ((WORLD.GEN()).playerX != -1) {
/*  25 */       pcx = (WORLD.GEN()).playerX;
/*  26 */       pcy = (WORLD.GEN()).playerY;
/*     */     } else {
/*  28 */       for (int i = 0; i < 1000; i++) {
/*  29 */         int x = RND.rInt(WORLD.TWIDTH());
/*  30 */         int y = RND.rInt(WORLD.THEIGHT());
/*     */         
/*  32 */         if (WorldCentrePlacablity.terrainC(x, y) == null) {
/*  33 */           pcx = x;
/*  34 */           pcy = y;
/*     */           break;
/*     */         } 
/*     */       } 
/*  38 */       if (pcx == -1) {
/*  39 */         for (COORDINATE c : WORLD.TBOUNDS()) {
/*  40 */           if (WorldCentrePlacablity.terrainC(c.x(), c.y()) == null) {
/*  41 */             pcx = c.x();
/*  42 */             pcy = c.y();
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  50 */     if (pcx == -1) {
/*  51 */       return false;
/*     */     }
/*  53 */     fixWays(pcx, pcy);
/*     */     
/*  55 */     Rec pp = new Rec(3.0D);
/*  56 */     pp.moveC((pcx + 1), (pcy + 1));
/*  57 */     boolean pharbour = false;
/*     */     
/*  59 */     for (COORDINATE c : pp) {
/*  60 */       (WORLD.REGIONS()).pmap.set(c, (WORLD.REGIONS()).player);
/*  61 */       pharbour |= (WORLD.WATER()).isBig.is(c);
/*     */     } 
/*     */     
/*  64 */     pharbour = false;
/*     */     
/*  66 */     if (pharbour) {
/*     */       
/*  68 */       GUTIL.flooder().init(GenPlayer.class);
/*  69 */       if (WTRAV.isGoodLandTile(pcx, pcy)) {
/*  70 */         GUTIL.flooder().pushSloppy(pcx, pcy, 0.0D);
/*     */       }
/*  72 */       if ((WORLD.WATER()).isBig.is(pcx, pcy)) {
/*  73 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  74 */           DIR d = (DIR)DIR.ORTHO.get(di);
/*  75 */           int dx = pcx + d.x();
/*  76 */           int dy = pcy + d.y();
/*  77 */           if (WTRAV.isGoodLandTile(dx, dy) && WTRAV.canLand(pcx, pcy, d, false)) {
/*  78 */             GUTIL.flooder().pushSloppy(dx, dy, 0.0D);
/*     */           }
/*     */         } 
/*     */       }
/*  82 */       Rec cc = new Rec(5.0D);
/*  83 */       cc.moveC(pp.cX(), pp.cY());
/*  84 */       while (GUTIL.flooder().hasMore()) {
/*  85 */         PathTile t = GUTIL.flooder().pollSmallest();
/*  86 */         if (!pp.holdsPoint((COORDINATE)t) && WTRAV.isHarbour(t.x(), t.y())) {
/*     */ 
/*     */           
/*  89 */           int px = t.x();
/*  90 */           int py = t.y();
/*  91 */           while (t != null) {
/*  92 */             (WORLD.REGIONS()).pmap.set((COORDINATE)t, (WORLD.REGIONS()).player);
/*  93 */             t = t.getParent();
/*     */           } 
/*  95 */           GUTIL.flooder().done();
/*  96 */           GUTIL.flooder().init(GenPlayer.class);
/*  97 */           GUTIL.flooder().pushSloppy(px, py, 0.0D);
/*  98 */           while (GUTIL.flooder().hasMore()) {
/*  99 */             t = GUTIL.flooder().pollSmallest();
/* 100 */             if (t.getValue() > 2.0F)
/*     */               continue; 
/* 102 */             (WORLD.REGIONS()).pmap.set((COORDINATE)t, (WORLD.REGIONS()).player);
/* 103 */             for (DIR d : DIR.ORTHO) {
/* 104 */               if ((WORLD.WATER()).isBig.is(t.x(), t.y(), d)) {
/* 105 */                 GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t);
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/* 113 */         for (DIR d : DIR.ORTHO) {
/* 114 */           if (cc.holdsPoint((COORDINATE)t, d) && WTRAV.canLand(t.x(), t.y(), d, false)) {
/* 115 */             GUTIL.flooder().pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t);
/*     */           }
/*     */         } 
/*     */       } 
/* 119 */       GUTIL.flooder().done();
/*     */     } 
/*     */     
/* 122 */     (WORLD.REGIONS()).player.info.centreSet(pcx, pcy);
/*     */     
/* 124 */     (WORLD.REGIONS()).player.info.name().clear().add((CharSequence)(FACTIONS.player()).name);
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   private static void fixWays(int px, int py) {
/* 129 */     WORLD.TERRAIN().secretFixWays();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenPlayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */