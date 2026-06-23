/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.WRenContext;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Urban
/*     */ {
/* 237 */   private final int[][] mTownHouses = new int[][] {
/* 238 */       { 0, 1, 2, 2, 1, -1, -1
/* 239 */       }, { 1, 2, 4, 4, 2, 1, -1, -1
/* 240 */       }, { 2, 4, 9, 9, 4, 2, -1, -1
/* 241 */       }, { 2, 4, 9, 9, 4, 2, -1, -1
/* 242 */       }, { 1, 2, 4, 4, 2, 1, -1, -1
/* 243 */       }, { 0, 1, 2, 2, 1, -1, -1
/* 244 */       }, { -1, -1, -1, -1, -1, -1, -1, -1
/* 245 */       }, { -1, -1, -1, -1, -1, -1, -1, -1 }
/*     */     };
/*     */   
/* 248 */   private final int[][] mGarrison = new int[][] {
/* 249 */       new int[8], 
/* 250 */       new int[8], {
/* 251 */         0, 0, 1, 2
/* 252 */       }, { 0, 0, 3, 4
/* 253 */       }, new int[8], 
/* 254 */       new int[8], 
/* 255 */       new int[8], 
/* 256 */       new int[8]
/*     */     };
/*     */   
/* 259 */   private final int[][] mTownFarms = new int[][] {
/* 260 */       { 1, 1, 1, -1
/* 261 */       }, { 1, 1, -1
/* 262 */       }, { 1, 1, 1, -1
/* 263 */       }, { -1, -1, -1, -1 }
/*     */     };
/*     */   
/* 266 */   private final int[][] mTerrain = new int[][] {
/* 267 */       { 0, 1, 2, -1
/* 268 */       }, { 3, 4, 5, -1
/* 269 */       }, { 6, 7, 8, -1
/* 270 */       }, { -1, -1, -1, -1 }
/*     */     };
/*     */ 
/*     */   
/*     */   void renderAboveA(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 275 */     CSprite.this.renderPop(con, dtx, dty, reg, ran, xx1, yy1, this.mTownHouses, this.mGarrison);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void renderAboveB(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 281 */     CSprite.this.renderOverlay(con, dtx, dty, reg, ran, xx1, yy1, this.mTownHouses);
/* 282 */     CSprite.this.renderGarrison(con, dtx, dty, reg, ran, xx1, yy1, this.mGarrison);
/*     */     
/* 284 */     int tx = dtx;
/* 285 */     int ty = dty;
/*     */     
/* 287 */     double p = CSprite.this.g.pop(reg);
/* 288 */     p = CLAMP.d((p - 0.4D) / 0.15D, 0.0D, 1.0D);
/*     */     
/* 290 */     if (tx == 1 && ty == 1) {
/*     */       
/* 292 */       double size = CSprite.this.g.fort(reg);
/* 293 */       if (size > 0.0D) {
/* 294 */         int dim = CLAMP.i(64 + (int)(p * 36.0D), 64, 100);
/* 295 */         int cx = xx1 + 32;
/* 296 */         int cy = yy1 + 32;
/* 297 */         ((RD.RACES()).visuals.cRace(reg).appearance()).world.walls_village.render(con, size, dim, cx, cy);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 330 */     CSprite.this.renderSiege(con, dtx, dty, reg, ran, xx1, yy1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void renderOnGround(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 336 */     CSprite.this.renderGround(con, dtx, dty, reg, ran, x1, y1, this.mTerrain, this.mTownFarms);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\CSprite$Urban.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */