/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import settlement.main.CapitolArea;
/*    */ import settlement.main.SETT;
/*    */ import settlement.main.SettlementGrid;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.rnd.HeightMap;
/*    */ import world.WORLD;
/*    */ 
/*    */ class GeneratorFertilityInit
/*    */ {
/* 14 */   private final double aI = 1.0D / SettlementGrid.QUAD_AREA;
/*    */ 
/*    */ 
/*    */   
/*    */   GeneratorFertilityInit(CapitolArea area, GeneratorUtil util) {
/* 19 */     HeightMap ferMap = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 32, 2);
/*    */     
/* 21 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*    */       
/* 23 */       double base = getBase(area, c);
/* 24 */       double f = ferMap.get(c);
/* 25 */       double h = 1.0D - util.height.get(c);
/* 26 */       double res = get(base, f, h);
/* 27 */       util.fer.set(c, res);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private double getBase(CapitolArea area, COORDINATE c) {
/* 37 */     double v = 0.0D;
/* 38 */     int wx = area.tiles().x1() + c.x() / SettlementGrid.QUAD_SIZE;
/* 39 */     int wy = area.tiles().y1() + c.y() / SettlementGrid.QUAD_SIZE;
/*    */     
/* 41 */     int dx = c.x() % SettlementGrid.QUAD_SIZE - SettlementGrid.QUAD_HALF;
/* 42 */     int dy = c.y() % SettlementGrid.QUAD_SIZE - SettlementGrid.QUAD_HALF;
/*    */     
/* 44 */     double ax = (Math.abs(dx) * (SettlementGrid.QUAD_SIZE - Math.abs(dy)));
/* 45 */     double ay = (Math.abs(dy) * (SettlementGrid.QUAD_SIZE - Math.abs(dx)));
/* 46 */     double axy = (Math.abs(dx) * Math.abs(dy));
/* 47 */     double a = SettlementGrid.QUAD_AREA - ax - ay - axy;
/*    */     
/* 49 */     v += (WORLD.GROUND()).moisture.get(wx, wy) * a;
/*    */     
/* 51 */     for (DIR d : DIR.ALL) {
/*    */       
/* 53 */       if (d.x() * dx < 0)
/*    */         continue; 
/* 55 */       if (d.y() * dy < 0) {
/*    */         continue;
/*    */       }
/* 58 */       if (d.x() != 0 && d.y() != 0) {
/* 59 */         v += WORLD.MOISTURE().get(wx + d.x(), wy + d.y()) * axy; continue;
/* 60 */       }  if (d.x() != 0) {
/* 61 */         v += WORLD.MOISTURE().get(wx + d.x(), wy) * ax; continue;
/* 62 */       }  if (d.y() != 0) {
/* 63 */         v += WORLD.MOISTURE().get(wx, wy + d.y()) * ay;
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 69 */     return v * this.aI;
/*    */   }
/*    */ 
/*    */   
/*    */   static double get(double base, double fe, double hi) {
/* 74 */     base = CLAMP.d(base, 0.0D, 1.0D) * 0.7D;
/*    */     
/* 76 */     double f = hi;
/* 77 */     f = Math.pow(f, 1.0D + 8.0D * (1.0D - base));
/*    */ 
/*    */     
/* 80 */     f = CLAMP.d(base + f, 0.0D, 1.0D);
/* 81 */     f -= 0.2D * fe;
/*    */     
/* 83 */     return CLAMP.d(f, 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorFertilityInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */