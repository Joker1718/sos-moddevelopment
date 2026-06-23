/*     */ package world.map.regions;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.constant.Config;
/*     */ import init.sprite.SPRITES;
/*     */ import java.util.Comparator;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ import world.map.road.WTRAV;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ 
/*     */ final class GenAssign
/*     */ {
/*  30 */   private final Polymap pmap = new Polymap(WORLD.TWIDTH(), WORLD.THEIGHT(), 8, 1.0D);
/*     */ 
/*     */   
/*     */   public GenAssign(ACTION lprinter) {
/*  34 */     if (!GenPlayer.gen()) {
/*     */       return;
/*     */     }
/*  37 */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*     */       {
/*     */         protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*     */         {
/*  41 */           ((COLOR)COLOR.UNIQUE.getC(GenAssign.this.pmap.get(it.tx(), it.ty()))).bind();
/*  42 */           (SPRITES.cons()).BIG.outline.render(r, 0, it.x(), it.y());
/*  43 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  48 */     ArrayList<Tile> tiles = new ArrayList(WORLD.TAREA());
/*     */     
/*  50 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       
/*  52 */       if (canBeCentre(c)) {
/*  53 */         tiles.add(new Tile(c));
/*     */       }
/*     */     } 
/*     */     
/*  57 */     tiles.sort(new Comparator<Tile>()
/*     */         {
/*     */           public int compare(GenAssign.Tile o1, GenAssign.Tile o2)
/*     */           {
/*  61 */             return (o1.value > o2.value) ? 1 : -1;
/*     */           }
/*     */         });
/*     */     
/*  65 */     int ri = 1;
/*  66 */     for (Tile t : tiles) {
/*  67 */       if (ri > 1023)
/*     */         return; 
/*  69 */       if (canBeCentre((COORDINATE)t)) {
/*  70 */         assign((COORDINATE)t, WORLD.REGIONS().getByIndex(ri));
/*  71 */         ri++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  76 */     lprinter.exe();
/*  77 */     expand();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void expand() {
/*  83 */     this.pmap.checkInit();
/*  84 */     GUTIL.flooder().init(this);
/*  85 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       
/*  87 */       Region reg = (Region)(WORLD.REGIONS()).map.get(c);
/*     */       
/*  89 */       if (reg != null && reg != (WORLD.REGIONS()).player) {
/*  90 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*  91 */         GUTIL.flooder().setValue2(c, reg.index());
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     while (GUTIL.flooder().hasMore()) {
/*  96 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  97 */       Region dadda = WORLD.REGIONS().getByIndex(Math.round(t.getValue2()));
/*  98 */       (WORLD.REGIONS()).pmap.set((COORDINATE)t, dadda);
/*  99 */       for (DIR d : DIR.ORTHO) {
/* 100 */         if (isExpandable(t.x(), t.y(), d, dadda) && 
/* 101 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance() * expandValue(t.x(), t.y(), d)) != null) {
/* 102 */           GUTIL.flooder().setValue2(t.x(), t.y(), d, dadda.index());
/*     */         }
/*     */       } 
/*     */     } 
/* 106 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */   
/*     */   void assign(COORDINATE centre, Region reg) {
/* 111 */     GUTIL.flooder().init(this);
/* 112 */     this.pmap.checkInit();
/*     */ 
/*     */     
/* 115 */     for (int y = -1; y <= 3; y++) {
/* 116 */       for (int x = -1; x <= 3; x++) {
/* 117 */         int dx = centre.x() + x;
/* 118 */         int dy = centre.y() + y;
/* 119 */         GUTIL.flooder().pushSloppy(dx, dy, 0.0D);
/* 120 */         (WORLD.REGIONS()).pmap.set(dx, dy, reg);
/*     */       } 
/*     */     } 
/*     */     
/* 124 */     int area = 0;
/*     */     
/* 126 */     double size = 25.0D + (Config.world()).REGION_SIZE;
/* 127 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 129 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 130 */       if ((WORLD.REGIONS()).pmap.get((COORDINATE)t) != null && (WORLD.REGIONS()).pmap.get((COORDINATE)t) != reg) {
/*     */         continue;
/*     */       }
/* 133 */       this.pmap.checker.set((COORDINATE)t, true);
/*     */ 
/*     */       
/* 136 */       area++;
/* 137 */       (WORLD.REGIONS()).pmap.set((COORDINATE)t, reg);
/* 138 */       size -= tileValue(t.x(), t.y());
/* 139 */       if (size < 0.0D) {
/* 140 */         GUTIL.flooder().done();
/*     */         
/*     */         return;
/*     */       } 
/* 144 */       if (t.getValue() > Math.sqrt(area) * 2.0D) {
/*     */         continue;
/*     */       }
/* 147 */       for (DIR d : DIR.ORTHO) {
/* 148 */         if (WTRAV.canLand(t.x(), t.y(), d, false)) {
/* 149 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance() * expandValue(t.x(), t.y(), d));
/*     */         }
/*     */       } 
/*     */     } 
/* 153 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */   
/*     */   private double expandValue(int fromX, int fromY, DIR dir) {
/* 158 */     if (terrain(fromX, fromY) != terrain(fromX + dir.x(), fromY + dir.y()))
/* 159 */       return 5.0D; 
/* 160 */     if (!this.pmap.checker.is(fromX + dir.x(), fromY + dir.y()))
/* 161 */       return 20.0D; 
/* 162 */     return 1.0D;
/*     */   }
/*     */   
/*     */   public static int terrain(int tx, int ty) {
/* 166 */     if (WORLD.MOUNTAIN().getHeight(tx, ty) > 0) {
/* 167 */       return 1;
/*     */     }
/* 169 */     if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 170 */       return 2;
/*     */     }
/* 172 */     if ((WORLD.FOREST()).amount.get(tx, ty) == 1.0D)
/* 173 */       return 3; 
/* 174 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isExpandable(int fromX, int fromY, DIR dir, Region reg) {
/* 181 */     int tx = fromX + dir.x();
/* 182 */     int ty = fromY + dir.y();
/* 183 */     if (!WORLD.IN_BOUNDS(tx, ty)) {
/* 184 */       return false;
/*     */     }
/* 186 */     if ((WORLD.REGIONS()).pmap.get(tx, ty) != null && (WORLD.REGIONS()).pmap.get(tx, ty, dir) != reg) {
/* 187 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 191 */     if (WORLD.MOUNTAIN().coversTile(fromX, fromY) && WORLD.MOUNTAIN().coversTile(tx, ty)) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (WORLD.MOUNTAIN().coversTile(tx, ty)) {
/* 195 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 196 */         DIR d = (DIR)DIR.ALL.get(di);
/* 197 */         if (!WORLD.MOUNTAIN().coversTile(tx + d.x(), ty + d.y()))
/* 198 */           return true; 
/*     */       } 
/* 200 */       return false;
/*     */     } 
/* 202 */     if ((WORLD.WATER()).has.is(tx, ty)) {
/* 203 */       if (!(WORLD.WATER()).coversTile.is(tx, ty))
/* 204 */         return true; 
/* 205 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 206 */         DIR d = (DIR)DIR.ALL.get(di);
/* 207 */         if (WORLD.IN_BOUNDS(tx, ty, d) && !(WORLD.WATER()).coversTile.is(tx + d.x(), ty + d.y()))
/* 208 */           return true; 
/*     */       } 
/* 210 */       return false;
/*     */     } 
/* 212 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canBeCentre(COORDINATE c) {
/* 216 */     if (WorldCentrePlacablity.terrain(c.x(), c.y()) == null) {
/* 217 */       for (int y = -2; y < 5; y++) {
/* 218 */         for (int x = -2; x < 5; x++) {
/* 219 */           int dx = c.x() + x;
/* 220 */           int dy = c.y() + y;
/* 221 */           if (!WORLD.IN_BOUNDS(dx, dy))
/* 222 */             return false; 
/* 223 */           if ((WORLD.REGIONS()).map.get(dx, dy) != null) {
/* 224 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 230 */       return true;
/*     */     } 
/* 232 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Tile
/*     */     extends Coo
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public final double value;
/*     */ 
/*     */     
/*     */     Tile(COORDINATE c) {
/* 245 */       set(c);
/* 246 */       this.value = value(c.x(), c.y());
/*     */     }
/*     */ 
/*     */     
/*     */     private double value(int tx, int ty) {
/* 251 */       double v = WORLD.MOISTURE().get(tx, ty);
/* 252 */       for (DIR d : DIR.ALLC) {
/* 253 */         if ((WORLD.WATER()).has.is(tx, ty, d)) {
/* 254 */           v += WORLD.MOISTURE().get(tx, ty);
/*     */         }
/* 256 */         if ((WORLD.MOUNTAIN()).haser.is(tx, ty, d))
/* 257 */           v += WORLD.MOISTURE().get(tx, ty); 
/*     */       } 
/* 259 */       v *= RND.rFloat1(0.25D);
/* 260 */       return v + RND.rFloat();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static double tileValue(int tx, int ty) {
/* 266 */     double v = CLAMP.d(WORLD.MOISTURE().get(tx, ty), 0.05D, 1.0D);
/* 267 */     if ((WORLD.WATER()).has.is(tx, ty)) {
/* 268 */       v = 0.75D + 0.25D * v;
/*     */     }
/* 270 */     if ((WORLD.MOUNTAIN()).haser.is(tx, ty))
/* 271 */       v = 0.5D + v * 0.5D; 
/* 272 */     if ((WORLD.FOREST()).is.is(tx, ty))
/* 273 */       v = 0.2D + v * 0.8D; 
/* 274 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 279 */     while (FACTIONS.NPCs().size() > 0) {
/* 280 */       FACTIONS.remove((FactionNPC)FACTIONS.NPCs().get(0), false);
/*     */     }
/* 282 */     WORLD.REGIONS().saver().clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenAssign.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */