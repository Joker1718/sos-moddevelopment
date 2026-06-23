/*     */ package settlement.environment;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TileRayTracer;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class All
/*     */   extends SettEnvMap.Updatable
/*     */ {
/* 105 */   private final Bitmap2D has = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */   
/*     */   All(LISTE<SettEnvMap.Updatable> all) {
/* 108 */     super(all);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(RECTANGLE bounds, RECTANGLE area) {
/* 114 */     for (COORDINATE c : area) {
/* 115 */       if (SETT.IN_BOUNDS(c)) {
/* 116 */         this.has.set(c, false);
/* 117 */         for (ROOM_MONUMENT m : (SETT.ROOMS()).MONUMENTS.all) {
/* 118 */           m.mapData.set(c, 0);
/* 119 */           m.mapUpgrade.set(c, m.mapUpgrade.max());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 125 */     for (COORDINATE c : bounds) {
/* 126 */       trace2(c, area);
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
/*     */   private void trace2(COORDINATE source, RECTANGLE area) {
/* 138 */     Room ro = (Room)(SETT.ROOMS()).map.get(source);
/*     */     
/* 140 */     if (ro == null) {
/*     */       return;
/*     */     }
/* 143 */     if (!(ro.blueprint() instanceof ROOM_MONUMENT)) {
/*     */       return;
/*     */     }
/* 146 */     if (!isCentre(ro, source.x(), source.y(), source.x(), source.y())) {
/*     */       return;
/*     */     }
/*     */     
/* 150 */     ROOM_MONUMENT m = (ROOM_MONUMENT)ro.blueprint();
/*     */     
/* 152 */     int ra = (int)m.radius((FurnisherItem)(SETT.ROOMS()).fData.item.get(source.x(), source.y()));
/* 153 */     if (ra == 0)
/*     */       return; 
/* 155 */     if (!area.holdsPoint(source)) {
/* 156 */       if (Math.abs(area.cX() - source.x()) - ra > 8)
/*     */         return; 
/* 158 */       if (Math.abs(area.cY() - source.y()) - ra > 8) {
/*     */         return;
/*     */       }
/*     */     } 
/* 162 */     int up = ro.upgrade(source.x(), source.y());
/*     */     
/* 164 */     EUpdater.traces.checkInit();
/*     */     
/* 166 */     for (TileRayTracer.Ray r : EUpdater.rays(source.x(), source.y(), area)) {
/* 167 */       for (int i = 0; i < r.size() && 
/* 168 */         r.radius(i) < ra; i++) {
/*     */         
/* 170 */         COORDINATE d = r.get(i);
/*     */         
/* 172 */         int dx = d.x() + source.x();
/* 173 */         int dy = d.y() + source.y();
/* 174 */         if (area.holdsPoint(dx, dy) && EUpdater.traces.check(d)) {
/*     */           
/* 176 */           if (m.mapUpgrade.get(dx, dy) > up) {
/* 177 */             m.mapUpgrade.set(dx, dy, up);
/*     */           }
/* 179 */           if (m.mapData.get(dx, dy) < m.maxEnv())
/* 180 */             m.mapData.increment(dx, dy, 1); 
/* 181 */           this.has.set(dx, dy, true);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 188 */         if (SettEnvMonument.isBlocked(dx, dy)) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isCentre(Room ro, int dx, int dy, int sourceX, int sourceY) {
/* 197 */     int w = ro.width(dx, dy);
/* 198 */     int h = ro.height(dx, dy);
/* 199 */     int x1 = ro.x1(dx, dy);
/* 200 */     int y1 = ro.y1(dx, dy);
/* 201 */     int cx = x1 + w / 2;
/* 202 */     int cy = y1 + h / 2;
/*     */     
/* 204 */     if ((w & 0x1) == 0 && sourceX > cx)
/* 205 */       cx--; 
/* 206 */     if ((h & 0x1) == 0 && sourceY > cy)
/* 207 */       cy--; 
/* 208 */     return (dx == cx && dy == cy);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getBaseValue(int tx, int ty) {
/* 213 */     return (((SETT.ROOMS()).map.blueprintImp.get(tx, ty) instanceof ROOM_MONUMENT) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean has(int tx, int ty) {
/* 218 */     return this.has.is(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 223 */     for (ROOM_MONUMENT m : (SETT.ROOMS()).MONUMENTS.all) {
/* 224 */       m.mapData.clear();
/* 225 */       m.mapUpgrade.clear();
/*     */     } 
/* 227 */     this.has.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMonument$All.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */