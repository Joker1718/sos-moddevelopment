/*     */ package settlement.path.components;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SCOMPONENTS
/*     */ {
/*  22 */   public final FindableDatas data = new FindableDatas();
/*  23 */   public final SComp0Level zero = new SComp0Level();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LIST<SCompNLevel> levels;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SCompNLevel last;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final LIST<SComponentLevel> all;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final SCompFinder pather;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean debug = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_OBJECT<SComponent> superComp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  77 */     for (SComponentLevel l : this.all)
/*  78 */       l.init(); 
/*     */   }
/*     */   
/*     */   public void init() {
/*  82 */     for (SComponentLevel l : this.all)
/*  83 */       l.init(); 
/*  84 */     update();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/*  91 */     if (this.debug) {
/*  92 */       int k; for (k = 0; k < 10; k++) {
/*  93 */         int x = RND.rInt(SETT.TWIDTH);
/*  94 */         int y = RND.rInt(SETT.THEIGHT);
/*  95 */         DIR d = (DIR)DIR.ALL.rnd();
/*  96 */         Terrain.TerrainTile t = RND.rBoolean() ? (SETT.TERRAIN()).NADA : (Terrain.TerrainTile)((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(0)).wall;
/*     */         
/*  98 */         for (int i = 0; i < 8; i++) {
/*  99 */           int tx = x + d.x() * i;
/* 100 */           int ty = y + d.y() * i;
/* 101 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 102 */             t.placeFixed(tx, ty);
/*     */           }
/*     */         } 
/*     */       } 
/* 106 */       for (k = 0; k < 10; k++) {
/* 107 */         int x = RND.rInt(SETT.TWIDTH);
/* 108 */         int y = RND.rInt(SETT.THEIGHT);
/* 109 */         DIR d = (DIR)DIR.ALL.rnd();
/*     */         
/* 111 */         for (int i = 0; i < 8; i++) {
/* 112 */           int tx = x + d.x() * i;
/* 113 */           int ty = y + d.y() * i;
/* 114 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 115 */             updateService(tx, ty);
/*     */           }
/*     */         } 
/*     */       } 
/* 119 */       for (SComponentLevel l : this.all) {
/* 120 */         l.update();
/*     */       }
/* 122 */       for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 123 */         SComponent co = (SComponent)this.zero.get(c);
/* 124 */         while (co != null) {
/* 125 */           SComponentEdge e = co.edgefirst();
/* 126 */           while (e != null) {
/*     */             
/* 128 */             if (e.to() != e.to().level().get(e.to().centreX(), e.to().centreY())) {
/* 129 */               LOG.ln("eye!");
/*     */             }
/* 131 */             e = e.next();
/*     */           } 
/* 133 */           co = co.superComp();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 140 */     for (SComponentLevel l : this.all) {
/* 141 */       l.update();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAvailability(int tx, int ty) {
/* 166 */     this.zero.update(tx, ty);
/*     */   }
/*     */   
/*     */   public void updateService(int tx, int ty) {
/* 170 */     this.zero.changeSerives(tx, ty);
/*     */   }
/*     */   public SCOMPONENTS() {
/* 173 */     this.superComp = new MAP_OBJECT<SComponent>()
/*     */       {
/*     */         public SComponent get(int tile)
/*     */         {
/* 177 */           SComponent s = SCOMPONENTS.this.zero.get(tile);
/* 178 */           while (s != null && s.superComp() != null)
/* 179 */             s = s.superComp(); 
/* 180 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         public SComponent get(int tx, int ty) {
/* 185 */           if (SETT.IN_BOUNDS(tx, ty))
/* 186 */             return get(tx + ty * SETT.TWIDTH); 
/* 187 */           return null;
/*     */         }
/*     */       };
/*     */     int increase = 8;
/*     */     int ls = 0;
/*     */     int ss = 64;
/*     */     while (ss <= SETT.TWIDTH) {
/*     */       ss *= 8;
/*     */       ls++;
/*     */     } 
/*     */     ls++;
/*     */     ArrayList<SComponentLevel> all = new ArrayList(ls + 1);
/*     */     all.add(this.zero);
/*     */     ArrayList<SCompNLevel> levels = new ArrayList(ls);
/*     */     ss = 64;
/*     */     ls = 1;
/*     */     while (levels.hasRoom()) {
/*     */       SCompNLevel l = new SCompNLevel((SComponentLevel)all.get(all.size() - 1), ls, ss);
/*     */       levels.add(l);
/*     */       all.add(l);
/*     */       ss *= 8;
/*     */       if (ss > SETT.TWIDTH)
/*     */         ss = SETT.TWIDTH; 
/*     */       ls++;
/*     */     } 
/*     */     this.levels = (LIST<SCompNLevel>)levels;
/*     */     this.last = (SCompNLevel)levels.get(levels.size() - 1);
/*     */     this.all = (LIST<SComponentLevel>)all;
/*     */     this.pather = new SCompFinder(this, GUTIL.pathTools());
/*     */     IDebugPanelSett.add("comp debug", new ACTION() {
/*     */           public void exe() {
/*     */             SCOMPONENTS.this.debug = !SCOMPONENTS.this.debug;
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCOMPONENTS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */