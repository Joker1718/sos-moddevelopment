/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.Minable;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GeneratorMinerals
/*     */ {
/*  32 */   private final HeightMap height2 = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 16, 4);
/*  33 */   private final HeightMap height3 = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 16, 4);
/*     */   
/*  35 */   private final Polymap map = new Polymap(SETT.TWIDTH, SETT.THEIGHT);
/*  36 */   private final Poly[] pps = new Poly[this.map.polys()];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final MAP_BOOLEAN placable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generate2(GeneratorUtil util, final Minable m, double size, double quality) {
/* 103 */     Arrays.sort(this.pps, new Comparator<Poly>()
/*     */         {
/*     */           public int compare(GeneratorMinerals.Poly o1, GeneratorMinerals.Poly o2)
/*     */           {
/* 107 */             if (o1 == null)
/* 108 */               return (o2 == null) ? 0 : -1; 
/* 109 */             if (o2 == null)
/* 110 */               return 1; 
/* 111 */             double v = o2.occ[m.index] - o1.occ[m.index];
/* 112 */             if (v > 0.0D)
/* 113 */               return 1; 
/* 114 */             if (v < 0.0D)
/* 115 */               return -1; 
/* 116 */             return 0;
/*     */           }
/*     */         });
/* 119 */     double s = size; byte b; int i; Poly[] arrayOfPoly;
/* 120 */     for (i = (arrayOfPoly = this.pps).length, b = 0; b < i; ) { Poly p = arrayOfPoly[b];
/* 121 */       if (p != null && p.valid()) {
/*     */         
/* 123 */         double rich = RND.rFloat1(0.1D);
/* 124 */         double ai = size;
/* 125 */         ai /= rich;
/* 126 */         if (size > 50.0D) {
/* 127 */           ai = size * (0.5D + RND.rFloat() * 0.5D);
/*     */         }
/* 129 */         ai = CLAMP.d(ai, 0.0D, s);
/*     */         
/* 131 */         s -= mineralize(util, p.x, p.y, m, ai, quality);
/* 132 */         if (s <= 0.0D) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   private void log(Object o) {}
/*     */   
/*     */   GeneratorMinerals(CapitolArea area, GeneratorUtil util) {
/* 143 */     this.placable = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tile)
/*     */         {
/* 147 */           return (!(SETT.MINERALS()).getter.is(tile) && !(SETT.TERRAIN()).WATER.DEEP.is(tile));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tx, int ty) {
/* 152 */           return (SETT.IN_BOUNDS(tx, ty) && is(tx + ty * SETT.TWIDTH)); } }; log(Integer.valueOf(this.pps.length)); int valid = 0; for (COORDINATE c : SETT.TILE_BOUNDS) { (SETT.MINERALS()).getter.set(c, null); int id = this.map.getter.get(c); if (this.pps[id] == null) { this.pps[id] = new Poly(); valid++; }  if (this.placable.is(c)) { (this.pps[id]).x = c.x(); (this.pps[id]).y = c.y(); }  if (SETT.TILE_BOUNDS.isOnEdge(c.x(), c.y()) && (this.pps[id]).valid) { (this.pps[id]).valid = false; valid--; }
/*     */        for (Minable m : RESOURCES.minables().all())
/*     */         (this.pps[id]).occ[m.index] = (this.pps[id]).occ[m.index] + m.terrain((TERRAIN)TERRAINS.sett.get(c));  }
/*     */      if (area.isBattle)
/*     */       return;  Region reg = FACTIONS.player().capitolRegion(); log(Integer.valueOf(valid)); for (Minable m : RESOURCES.minables().all()) { double am = 0.0D; for (TERRAIN t : TERRAINS.ALL())
/*     */         am += m.terrain(t) * reg.info.terrain(t);  am = (int)(38.0D + 2000.0D * am * m.occurence); log(m.key() + " " + m.key()); generate2(util, m, am, 1.0D); generate2(util, m, 1000.0D, 0.0D); }
/*     */      for (Minable m : RESOURCES.minables().all())
/* 159 */       log(String.valueOf(m.resource.name) + " " + String.valueOf(m.resource.name));  blurEdges(); } private int mineralize(GeneratorUtil util, int x, int y, Minable t, double size, double quality) { if (!this.placable.is(x, y)) {
/* 160 */       return 0;
/*     */     }
/* 162 */     log("making " + String.valueOf(t.resource.name) + "  " + size + " " + quality + " (" + x + ":" + y + ")");
/*     */     
/* 164 */     GUTIL.flooder().init(this);
/*     */     
/* 166 */     GUTIL.flooder().pushSloppy(x, y, 0.0D);
/* 167 */     GUTIL.flooder().setValue2(x, y, 0.0D);
/* 168 */     double nor = this.height3.get(x, y);
/* 169 */     double oldSize = size;
/* 170 */     double vv = 0.0D;
/*     */     
/* 172 */     while (GUTIL.flooder().hasMore()) {
/* 173 */       PathTile c = GUTIL.flooder().pollSmallest();
/* 174 */       if (this.pps[this.map.get(c.x(), c.y())] == null)
/*     */         continue; 
/* 176 */       (this.pps[this.map.get(c.x(), c.y())]).valid = false;
/* 177 */       if (!this.placable.is((COORDINATE)c)) {
/*     */         continue;
/*     */       }
/* 180 */       vv = Math.max(vv, c.getValue());
/* 181 */       double dh = 0.5D + this.height2.get((COORDINATE)c) * 0.75D;
/* 182 */       size--;
/* 183 */       if (size < 0.0D)
/*     */         break; 
/* 185 */       double dist = c.getValue2();
/*     */       
/* 187 */       (SETT.MINERALS()).getter.set((COORDINATE)c, t);
/* 188 */       (SETT.MINERALS()).amountD.set((COORDINATE)c, dh);
/* 189 */       (SETT.MINERALS()).value.set((COORDINATE)c, quality);
/*     */       
/* 191 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 192 */         DIR dir = (DIR)DIR.ALL.get(di);
/* 193 */         if (SETT.IN_BOUNDS((COORDINATE)c, dir) && 
/* 194 */           this.pps[this.map.get(c.x() + dir.x(), c.y() + dir.y())] != null && (this.pps[this.map.get(c.x(), c.y())] == this.pps[this.map.get(c.x() + dir.x(), c.y() + dir.y())] || this.pps[this.map.get(c.x() + dir.x(), c.y() + dir.y())].valid())) {
/* 195 */           double v = this.height3.get((COORDINATE)c, dir);
/* 196 */           v = Math.abs(v - nor);
/* 197 */           double ddsist = dist + dir.tileDistance();
/* 198 */           v += ddsist / 64.0D;
/* 199 */           if (GUTIL.flooder().pushSmaller((COORDINATE)c, dir, v) != null) {
/* 200 */             GUTIL.flooder().setValue2((COORDINATE)c, dir, ddsist);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     GUTIL.flooder().done();
/*     */ 
/*     */     
/* 217 */     return (int)(oldSize - size); }
/*     */ 
/*     */   
/*     */   private void blurEdges() {
/* 221 */     double e = 4.0D;
/* 222 */     GUTIL.flooder().init(this);
/* 223 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 224 */       if ((SETT.MINERALS()).amountInt.get(c) == 0) {
/* 225 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*     */       }
/*     */     } 
/* 228 */     while (GUTIL.flooder().hasMore()) {
/* 229 */       PathTile c = GUTIL.flooder().pollSmallest();
/* 230 */       if (c.getValue() > e) {
/*     */         break;
/*     */       }
/* 233 */       if ((SETT.MINERALS()).amountInt.get((COORDINATE)c) > 0) {
/* 234 */         double am = c.getValue() / e;
/* 235 */         (SETT.MINERALS()).amountD.set((COORDINATE)c, (SETT.MINERALS()).amountD.get((COORDINATE)c) * am);
/*     */       } 
/* 237 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 238 */         DIR dir = (DIR)DIR.ALL.get(di);
/* 239 */         if (SETT.IN_BOUNDS((COORDINATE)c, dir)) {
/* 240 */           double v = c.getValue() + dir.tileDistance();
/* 241 */           GUTIL.flooder().pushSmaller((COORDINATE)c, dir, v);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 248 */     GUTIL.flooder().done();
/*     */   }
/*     */   private class Poly { int x; int y; double[] occ;
/*     */     boolean valid;
/*     */     
/*     */     private Poly() {
/* 254 */       this.x = -1;
/* 255 */       this.y = -1;
/* 256 */       this.occ = new double[RESOURCES.minables().all().size()];
/* 257 */       this.valid = true;
/*     */     }
/*     */     
/*     */     private boolean valid() {
/* 261 */       return (this.valid && this.x != -1);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorMinerals.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */