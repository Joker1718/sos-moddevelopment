/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.type.BUILDING_PREFS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.water.pool.ROOM_POOL;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements StatsInit.StatUpdatableI
/*     */ {
/*     */   public void update16(Humanoid h, int updateI, boolean day, int ui) {
/* 226 */     Induvidual i = h.indu();
/*     */ 
/*     */     
/* 229 */     double res = h.race().pref().structure(BUILDING_PREFS.get(h.tc().x(), h.tc().y()));
/* 230 */     for (DIR dIR : DIR.ORTHO) {
/* 231 */       res += h.race().pref().structure(BUILDING_PREFS.get(h.tc().x() + dIR.x(), h.tc().y() + dIR.y()));
/*     */     }
/* 233 */     res /= 5.0D;
/*     */     
/* 235 */     int d = (int)Math.ceil(15.0D * res);
/* 236 */     int n = StatsEnv.this.BUILDING_PREF.indu().get(h.indu());
/*     */     
/* 238 */     if (d > n * 2) {
/* 239 */       StatsEnv.this.BUILDING_PREF.indu().inc(i, 2);
/* 240 */     } else if (d > n) {
/* 241 */       StatsEnv.this.BUILDING_PREF.indu().inc(i, 1);
/* 242 */     } else if (d < n && (updateI & 0x7) == 0) {
/* 243 */       StatsEnv.this.BUILDING_PREF.indu().inc(i, -1);
/*     */     } 
/*     */ 
/*     */     
/* 247 */     Room r = (Room)(SETT.ROOMS()).map.get(h.physics.tileC());
/*     */     
/* 249 */     if (r == null) {
/* 250 */       int current = StatsEnv.this.ROAD_PREF.indu().get(i);
/* 251 */       int tar = 0;
/*     */       
/* 253 */       double deg = 1.0D - (SETT.FLOOR()).degrade.get(h.tc().x(), h.tc().y());
/*     */       
/* 255 */       Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(h.physics.tileC());
/* 256 */       if (f != null && f.isRoad) {
/* 257 */         StatsEnv.this.PATHOGENS.indu().inc(i, -1);
/* 258 */         tar = (int)Math.ceil(deg * 255.0D * f.pref(h.race()));
/* 259 */         StatsEnv.this.ACCESS_ROAD.indu().set(i, (deg > 0.5D) ? 1 : 0);
/*     */       } else {
/* 261 */         StatsEnv.this.ACCESS_ROAD.indu().set(i, 0);
/*     */       } 
/*     */       
/* 264 */       if (tar > current) {
/* 265 */         current += 128;
/* 266 */         current = CLAMP.i(current, 0, tar);
/* 267 */       } else if (tar < current) {
/* 268 */         current -= 48;
/* 269 */         current = CLAMP.i(current, tar, 255);
/*     */       } 
/* 271 */       StatsEnv.this.ROAD_PREF.indu().set(i, current);
/*     */     } else {
/*     */       
/* 274 */       if (r.blueprint() instanceof ROOM_POOL) {
/* 275 */         ROOM_POOL p = (ROOM_POOL)r.blueprint();
/* 276 */         double d1 = h.race().pref().pool(p);
/* 277 */         StatsEnv.this.POOL_PREF.indu().setD(i, d1);
/*     */       } 
/*     */       
/* 280 */       if ((SETT.ROOMS()).fData.item.get(h.tc()) == null && (SETT.FLOOR()).getter.get(h.physics.tileC()) == null)
/* 281 */         StatsEnv.this.PATHOGENS.indu().setD(i, (SETT.GROUND()).MOISTURE_BASE.get(h.tc())); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEnv$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */