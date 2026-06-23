/*     */ package world.map.pathing;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WPATHING
/*     */   extends WORLD.WorldResource
/*     */ {
/*  34 */   public final WDirMap map = new WDirMap();
/*  35 */   final Bitmap2D portArea = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*  36 */   Comps comps = new Comps(this.map);
/*     */   
/*  38 */   public final WRegFinder regFinder = new WRegFinder();
/*     */   
/*  40 */   private static LIST<DIR> dirs = (LIST<DIR>)new ArrayList((Iterable)DIR.ALL);
/*     */   
/*     */   public WPATHING() {
/*  43 */     super("pathing", "PATHING");
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
/*  63 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
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
/*     */         public void save(FilePutter file)
/*     */         {
/*  87 */           WPATHING.this.map.saver.save(file);
/*  88 */           WPATHING.this.portArea.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  93 */           WPATHING.this.map.saver.load(file);
/*  94 */           WPATHING.this.portArea.load(file);
/*  95 */           WPATHING.this.comps = Comps.generate(ACTION.NOP, WPATHING.this.map);
/*  96 */           validateInit(null);
/*  97 */           (WORLD.OVERLAY()).debug = null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 102 */           WPATHING.this.map.saver.clear();
/* 103 */           WPATHING.this.portArea.clear();
/* 104 */           WPATHING.this.comps = new Comps(WPATHING.this.map);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void validateInit(WORLD.WorldError error) {
/* 110 */           if (!WORLD.IN_BOUNDS((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy())) {
/* 111 */             if (error != null) {
/* 112 */               error.problem = "The world has no player region centre";
/* 113 */               error.coo.set(WORLD.TBOUNDS().cX(), WORLD.TBOUNDS().cY());
/*     */             } else {
/* 115 */               LOG.ln("bad stuff");
/*     */             } 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 122 */           boolean[] reached = new boolean[1023];
/*     */           
/* 124 */           GUTIL.flooder().init(this);
/* 125 */           GUTIL.flooder().pushSloppy((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy(), 0.0D);
/* 126 */           while (GUTIL.flooder().hasMore()) {
/* 127 */             PathTile t = GUTIL.flooder().pollSmallest();
/* 128 */             Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/* 129 */             if (reg != null && t.isSameAs(reg.cx(), reg.cy())) {
/* 130 */               reached[reg.index()] = true;
/*     */             }
/* 132 */             WPATHING.this.map.push(t, t.getValue());
/*     */           } 
/* 134 */           GUTIL.flooder().done();
/*     */ 
/*     */           
/* 137 */           for (int ri = 0; ri < 1023; ri++) {
/* 138 */             Region reg = WORLD.REGIONS().getByIndex(ri);
/* 139 */             if (reg.active() && 
/* 140 */               !reached[reg.index()]) {
/* 141 */               if (error != null) {
/* 142 */                 error.problem = "This region is not connected to other regions through roads " + reg.index();
/* 143 */                 error.coo.set(reg.cx(), reg.cy());
/*     */               } else {
/* 145 */                 LOG.ln("reg " + String.valueOf(reg));
/*     */               } 
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void generate(ACTION loadPrint) {
/* 157 */           clear();
/* 158 */           (new Gen()).generateAll((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy(), loadPrint);
/* 159 */           WPATHING.this.comps = Comps.generate(loadPrint, WPATHING.this.map);
/* 160 */           (WORLD.OVERLAY()).debug = null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 167 */           return (LIST<PLACABLE>)new ArrayList(0);
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
/* 334 */     this.regMap = new MAP_OBJECT<Region>()
/*     */       {
/*     */         public Region get(int tx, int ty)
/*     */         {
/* 338 */           if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 339 */             if (WPATHING.this.portArea.is(tx, ty))
/* 340 */               return (Region)(WORLD.REGIONS()).map.get(tx, ty); 
/* 341 */             return null;
/*     */           } 
/* 343 */           return (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public Region get(int tile) {
/* 348 */           if ((WORLD.WATER()).isBig.is(tile)) {
/* 349 */             if (WPATHING.this.portArea.is(tile))
/* 350 */               return (Region)(WORLD.REGIONS()).map.get(tile); 
/* 351 */             return null;
/*     */           } 
/* 353 */           return (Region)(WORLD.REGIONS()).map.get(tile);
/*     */         }
/*     */       };
/*     */     IDebugPanelWorld.add("path test", new ACTION() {
/*     */           public void exe() {}
/*     */         });
/*     */     IDebugPanelWorld.add("path overlay", new ACTION() {
/*     */           public void exe() {
/*     */             (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new Comps.DebugOverlay();
/*     */           }
/*     */         });
/*     */     IDebugPanelWorld.add((PLACABLE)new DebugPlacer());
/*     */   }
/*     */   
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   public MAP_OBJECT<Region> regMap;
/*     */   
/*     */   public WORLD.WorldResourceManager saver() {
/*     */     return this.saver;
/*     */   }
/*     */   
/*     */   public static int cost(int fromX, int fromY, DIR d) {
/*     */     if ((WORLD.WATER()).isBig.is(fromX, fromY))
/*     */       return 1; 
/*     */     int toX = fromX + d.x();
/*     */     int toY = fromY + d.y();
/*     */     if ((WORLD.WATER()).isBig.is(toX, toY))
/*     */       return 10; 
/*     */     if (WORLD.MOUNTAIN().coversTile(fromX, fromY))
/*     */       return 6; 
/*     */     if ((WORLD.FOREST()).amount.get(fromX, fromY) == 1.0D)
/*     */       return 4; 
/*     */     return 3;
/*     */   }
/*     */   
/*     */   public static double movementSpeed(int tx, int ty) {
/*     */     if ((WORLD.WATER()).isBig.is(tx, ty))
/*     */       return 1.0D; 
/*     */     if ((WORLD.MOUNTAIN()).heighter.get(tx, ty) >= 1)
/*     */       return 0.16D; 
/*     */     if ((WORLD.FOREST()).amount.get(tx, ty) == 1.0D)
/*     */       return 0.25D; 
/*     */     return 0.33D;
/*     */   }
/*     */   
/*     */   public PathTile path(int sx, int sy, int destX, int destY) {
/*     */     return this.comps.finder.find(sx, sy, destX, destY, WRegFinder.Treaty.DUMMY);
/*     */   }
/*     */   
/*     */   public PathTile path(COORDINATE start, int endX, int endY, WRegFinder.Treaty trav) {
/*     */     return this.comps.finder.find(start.x(), start.y(), endX, endY, trav);
/*     */   }
/*     */   
/*     */   public PathTile path(int startX, int startY, COORDINATE end, WRegFinder.Treaty trav) {
/*     */     return this.comps.finder.find(startX, startY, end.x(), end.y(), trav);
/*     */   }
/*     */   
/*     */   public PathTile path(COORDINATE start, COORDINATE end, WRegFinder.Treaty trav) {
/*     */     return this.comps.finder.find(start.x(), start.y(), end.x(), end.y(), trav);
/*     */   }
/*     */   
/*     */   public PathTile path(int sx, int sy, int destX, int destY, WRegFinder.Treaty treaty) {
/*     */     return this.comps.finder.find(sx, sy, destX, destY, treaty);
/*     */   }
/*     */   
/*     */   public double distance(Region from, Region to) {
/*     */     if (from == to)
/*     */       return 0.0D; 
/*     */     return this.comps.finder.dist(from.cx(), from.cy(), to.cx(), to.cy(), WRegFinder.Treaty.DUMMY);
/*     */   }
/*     */   
/*     */   public MAP_OBJECT<Comps.WComp> c() {
/*     */     return this.comps;
/*     */   }
/*     */   
/*     */   public COORDINATE rnd(Region home) {
/*     */     GUTIL.filler().init(this);
/*     */     GUTIL.filler().fill(home.cx(), home.cy());
/*     */     GUTIL.coos().set(0);
/*     */     while (GUTIL.filler().hasMore()) {
/*     */       COORDINATE c = GUTIL.filler().poll();
/*     */       if (!home.is(c))
/*     */         continue; 
/*     */       if (!(WORLD.REGIONS()).centre.is(c) && !(WORLD.WATER()).isBig.is(c)) {
/*     */         GUTIL.coos().get().set(c);
/*     */         GUTIL.coos().inc();
/*     */       } 
/*     */       for (DIR d : dirs) {
/*     */         if (this.map.can(c, d))
/*     */           GUTIL.filler().fill(c, d); 
/*     */       } 
/*     */     } 
/*     */     GUTIL.filler().done();
/*     */     if (GUTIL.coos().getI() == 0) {
/*     */       GUTIL.coos().get().set(home.cx(), home.cy());
/*     */       GUTIL.coos().inc();
/*     */     } 
/*     */     GUTIL.coos().set(RND.rInt(GUTIL.coos().getI()));
/*     */     return (COORDINATE)GUTIL.coos().get();
/*     */   }
/*     */   
/*     */   public COORDINATE rndDist(int cx, int cy, int dist) {
/*     */     GUTIL.flooder().init(this);
/*     */     GUTIL.flooder().pushSloppy(cx, cy, 0.0D);
/*     */     PathTile backup = null;
/*     */     while (GUTIL.flooder().hasMore()) {
/*     */       PathTile c = GUTIL.flooder().pollSmallest();
/*     */       if (c.getValue() >= dist) {
/*     */         GUTIL.flooder().done();
/*     */         return (COORDINATE)c;
/*     */       } 
/*     */       if (!(WORLD.REGIONS()).centre.is((COORDINATE)c))
/*     */         backup = c; 
/*     */       DIR d = (DIR)dirs.rnd();
/*     */       for (int i = 0; i < dirs.size(); i++) {
/*     */         if (this.map.can((COORDINATE)c, d) && !(WORLD.REGIONS()).cTile.is((COORDINATE)c, d))
/*     */           GUTIL.flooder().pushSmaller((COORDINATE)c, d, c.getValue() + d.tileDistance()); 
/*     */         d = d.next(1);
/*     */       } 
/*     */     } 
/*     */     GUTIL.filler().done();
/*     */     return (COORDINATE)backup;
/*     */   }
/*     */   
/*     */   public COORDINATE rndDistOwn(int cx, int cy, int dist) {
/*     */     GUTIL.flooder().init(this);
/*     */     GUTIL.flooder().pushSloppy(cx, cy, 0.0D);
/*     */     PathTile backup = null;
/*     */     Faction fa = ((Region)(WORLD.REGIONS()).map.get(cx, cy)).faction();
/*     */     while (GUTIL.flooder().hasMore()) {
/*     */       PathTile c = GUTIL.flooder().pollSmallest();
/*     */       Region rr = (Region)(WORLD.REGIONS()).map.get((COORDINATE)c);
/*     */       if (rr != null && rr.faction() != null && rr.faction() != fa)
/*     */         continue; 
/*     */       if (c.getValue() >= dist) {
/*     */         GUTIL.flooder().done();
/*     */         return (COORDINATE)c;
/*     */       } 
/*     */       if (!(WORLD.REGIONS()).cTile.is((COORDINATE)c))
/*     */         backup = c; 
/*     */       DIR d = (DIR)dirs.rnd();
/*     */       for (int i = 0; i < dirs.size(); i++) {
/*     */         if (this.map.can((COORDINATE)c, d) && !(WORLD.REGIONS()).cTile.is((COORDINATE)c, d))
/*     */           GUTIL.flooder().pushSmaller((COORDINATE)c, d, c.getValue() + d.tileDistance()); 
/*     */         d = d.next(1);
/*     */       } 
/*     */     } 
/*     */     GUTIL.filler().done();
/*     */     return (COORDINATE)backup;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WPATHING.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */