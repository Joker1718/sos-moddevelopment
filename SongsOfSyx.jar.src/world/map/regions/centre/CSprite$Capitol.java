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
/*     */ class Capitol
/*     */ {
/* 129 */   private final int[][] mTownHouses = new int[][] {
/* 130 */       { 0, 1, 2, 2, 2, 2, 1
/* 131 */       }, { 1, 3, 4, 4, 4, 4, 3, 1
/* 132 */       }, { 2, 4, 6, 7, 7, 6, 4, 2
/* 133 */       }, { 2, 4, 7, 9, 9, 7, 4, 2
/* 134 */       }, { 2, 4, 7, 9, 9, 7, 4, 2
/* 135 */       }, { 2, 4, 6, 7, 7, 6, 4, 2
/* 136 */       }, { 1, 3, 4, 4, 4, 4, 3, 1
/* 137 */       }, { 0, 1, 2, 2, 2, 2, 1 }
/*     */     };
/*     */   
/* 140 */   private final int[][] mGarrison = new int[][] {
/* 141 */       new int[8], 
/* 142 */       new int[8], 
/* 143 */       new int[8], {
/* 144 */         0, 0, 0, 1, 2
/* 145 */       }, { 0, 0, 0, 3, 4
/* 146 */       }, new int[8], 
/* 147 */       new int[8], 
/* 148 */       new int[8]
/*     */     };
/*     */   
/* 151 */   private final int[][] mTownFarms = new int[][] {
/* 152 */       { 1, 1, 1, 1
/* 153 */       }, { 1, 1
/* 154 */       }, { 1, 1
/* 155 */       }, { 1, 1, 1, 1 }
/*     */     };
/*     */   
/* 158 */   private final int[][] mTerrain = new int[][] {
/* 159 */       { 0, 1, 1, 2
/* 160 */       }, { 3, 4, 4, 5
/* 161 */       }, { 3, 4, 4, 5
/* 162 */       }, { 6, 7, 7, 8 }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   void renderAboveA(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 168 */     CSprite.this.renderPop(con, dtx, dty, reg, ran, xx1 - 32, yy1 - 32, this.mTownHouses, this.mGarrison);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void renderAboveB(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 174 */     CSprite.this.renderOverlay(con, dtx, dty, reg, ran, xx1 - 32, yy1 - 32, this.mTownHouses);
/* 175 */     CSprite.this.renderGarrison(con, dtx, dty, reg, ran, xx1 - 32, yy1 - 32, this.mGarrison);
/*     */     
/* 177 */     int tx = dtx;
/* 178 */     int ty = dty;
/*     */     
/* 180 */     double p = CSprite.this.g.pop(reg);
/*     */     
/* 182 */     p = CLAMP.d((p - 0.4D) / 0.15D, 0.0D, 1.0D);
/*     */     
/* 184 */     if (tx == 1 && ty == 1) {
/*     */       
/* 186 */       double size = CSprite.this.g.fort(reg);
/* 187 */       if (size > 0.0D) {
/* 188 */         int dim = CLAMP.i(64 + (int)(p * 56.0D), 64, 120);
/* 189 */         int cx = xx1 + 32;
/* 190 */         int cy = yy1 + 32;
/* 191 */         ((RD.RACES()).visuals.cRace(reg).appearance()).world.walls.render(con, size, dim, cx, cy);
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
/* 220 */     CSprite.this.renderSiege(con, dtx, dty, reg, ran, xx1, yy1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void renderOnGround(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 226 */     x1 -= 32;
/* 227 */     y1 -= 32;
/*     */     
/* 229 */     CSprite.this.renderGround(con, dtx, dty, reg, ran, x1, y1, this.mTerrain, this.mTownFarms);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\CSprite$Capitol.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */