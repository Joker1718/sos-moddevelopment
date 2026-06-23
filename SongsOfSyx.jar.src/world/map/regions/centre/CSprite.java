/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.data.INT;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import view.main.VIEW;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.WRenContext;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ public final class CSprite {
/*  25 */   private final Urban urban = new Urban();
/*  26 */   private final Capitol capitol = new Capitol();
/*  27 */   private GETTER g = new GETTER()
/*     */     {
/*     */       public double pop(Region reg)
/*     */       {
/*  31 */         return RD.RACES().popSize(reg);
/*     */       }
/*     */ 
/*     */       
/*     */       public double fort(Region reg) {
/*  36 */         return (RD.BUILDINGS()).levelWall.get(reg);
/*     */       }
/*     */ 
/*     */       
/*     */       public double garrison(Region reg) {
/*  41 */         return RD.MILITARY().garrison(reg);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   CSprite() {
/*  47 */     final GuiSection ss = new GuiSection();
/*  48 */     final INT.IntImp pop = new INT.IntImp(0, 100);
/*  49 */     final INT.IntImp fort = new INT.IntImp(0, 100);
/*  50 */     final INT.IntImp bu = new INT.IntImp(0, 100);
/*     */     
/*  52 */     ss.addDown(4, (RENDEROBJ)new GSliderInt((INT.INTE)intImp1, 200, false));
/*  53 */     ss.addDown(4, (RENDEROBJ)new GSliderInt((INT.INTE)intImp2, 200, false));
/*  54 */     ss.addDown(4, (RENDEROBJ)new GSliderInt((INT.INTE)intImp3, 200, false));
/*     */     
/*  56 */     ss.add((RENDEROBJ)new GPanel((RECTANGLE)ss.body()));
/*  57 */     ss.moveLastToBack();
/*     */     
/*  59 */     ss.body().moveX1Y1(50.0D, 50.0D);
/*     */ 
/*     */     
/*  62 */     final GETTER g = new GETTER()
/*     */       {
/*     */         public double pop(Region reg)
/*     */         {
/*  66 */           return pop.getD();
/*     */         }
/*     */ 
/*     */         
/*     */         public double fort(Region reg) {
/*  71 */           return fort.getD();
/*     */         }
/*     */ 
/*     */         
/*     */         public double garrison(Region reg) {
/*  76 */           return bu.getD();
/*     */         }
/*     */       };
/*     */     
/*  80 */     IDebugPanelWorld.add("Region Visuals", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  84 */             CSprite.this.g = g;
/*  85 */             (VIEW.inters()).section.activate(ss);
/*     */           }
/*     */         });
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
/*     */   public void renderOnGround(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 100 */     if (reg.capitol()) {
/* 101 */       this.capitol.renderOnGround(con, dtx, dty, reg, ran, x1, y1);
/*     */     } else {
/* 103 */       this.urban.renderOnGround(con, dtx, dty, reg, ran, x1, y1);
/*     */     } 
/*     */   }
/*     */   public void renderAboveA(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 107 */     if (reg.capitol()) {
/* 108 */       this.capitol.renderAboveA(con, dtx, dty, reg, ran, x1, y1);
/*     */     } else {
/* 110 */       this.urban.renderAboveA(con, dtx, dty, reg, ran, x1, y1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderAboveB(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 115 */     if (reg.capitol()) {
/* 116 */       this.capitol.renderAboveB(con, dtx, dty, reg, ran, x1, y1);
/*     */     } else {
/* 118 */       this.urban.renderAboveB(con, dtx, dty, reg, ran, x1, y1);
/*     */     } 
/*     */   }
/*     */   public void renderAboveTerrain(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {}
/*     */   
/*     */   private class Capitol { private final int[][] mTownHouses;
/*     */     private final int[][] mGarrison;
/*     */     private final int[][] mTownFarms;
/*     */     private final int[][] mTerrain;
/*     */     
/*     */     private Capitol() {
/* 129 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 137 */         .mTownHouses = new int[][] { { 0, 1, 2, 2, 2, 2, 1 }, { 1, 3, 4, 4, 4, 4, 3, 1 }, { 2, 4, 6, 7, 7, 6, 4, 2 }, { 2, 4, 7, 9, 9, 7, 4, 2 }, { 2, 4, 7, 9, 9, 7, 4, 2 }, { 2, 4, 6, 7, 7, 6, 4, 2 }, { 1, 3, 4, 4, 4, 4, 3, 1 }, { 0, 1, 2, 2, 2, 2, 1 } };
/*     */ 
/*     */       
/* 140 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 148 */         .mGarrison = new int[][] { new int[8], new int[8], new int[8], { 0, 0, 0, 1, 2 }, { 0, 0, 0, 3, 4 }, new int[8], new int[8], new int[8] };
/*     */ 
/*     */       
/* 151 */       this
/*     */ 
/*     */ 
/*     */         
/* 155 */         .mTownFarms = new int[][] { { 1, 1, 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 1, 1, 1 } };
/*     */ 
/*     */       
/* 158 */       this
/*     */ 
/*     */ 
/*     */         
/* 162 */         .mTerrain = new int[][] { { 0, 1, 1, 2 }, { 3, 4, 4, 5 }, { 3, 4, 4, 5 }, { 6, 7, 7, 8 } };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void renderAboveA(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 168 */       CSprite.this.renderPop(con, dtx, dty, reg, ran, xx1 - 32, yy1 - 32, this.mTownHouses, this.mGarrison);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void renderAboveB(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 174 */       CSprite.this.renderOverlay(con, dtx, dty, reg, ran, xx1 - 32, yy1 - 32, this.mTownHouses);
/* 175 */       CSprite.this.renderGarrison(con, dtx, dty, reg, ran, xx1 - 32, yy1 - 32, this.mGarrison);
/*     */       
/* 177 */       int tx = dtx;
/* 178 */       int ty = dty;
/*     */       
/* 180 */       double p = CSprite.this.g.pop(reg);
/*     */       
/* 182 */       p = CLAMP.d((p - 0.4D) / 0.15D, 0.0D, 1.0D);
/*     */       
/* 184 */       if (tx == 1 && ty == 1) {
/*     */         
/* 186 */         double size = CSprite.this.g.fort(reg);
/* 187 */         if (size > 0.0D) {
/* 188 */           int dim = CLAMP.i(64 + (int)(p * 56.0D), 64, 120);
/* 189 */           int cx = xx1 + 32;
/* 190 */           int cy = yy1 + 32;
/* 191 */           ((RD.RACES()).visuals.cRace(reg).appearance()).world.walls.render(con, size, dim, cx, cy);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       CSprite.this.renderSiege(con, dtx, dty, reg, ran, xx1, yy1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void renderOnGround(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 226 */       x1 -= 32;
/* 227 */       y1 -= 32;
/*     */       
/* 229 */       CSprite.this.renderGround(con, dtx, dty, reg, ran, x1, y1, this.mTerrain, this.mTownFarms);
/*     */     } }
/*     */   
/*     */   private static interface GETTER { double pop(Region param1Region);
/*     */     double fort(Region param1Region);
/*     */     
/*     */     double garrison(Region param1Region); }
/*     */   
/* 237 */   private class Urban { private final int[][] mTownHouses = new int[][] {
/* 238 */         { 0, 1, 2, 2, 1, -1, -1
/* 239 */         }, { 1, 2, 4, 4, 2, 1, -1, -1
/* 240 */         }, { 2, 4, 9, 9, 4, 2, -1, -1
/* 241 */         }, { 2, 4, 9, 9, 4, 2, -1, -1
/* 242 */         }, { 1, 2, 4, 4, 2, 1, -1, -1
/* 243 */         }, { 0, 1, 2, 2, 1, -1, -1
/* 244 */         }, { -1, -1, -1, -1, -1, -1, -1, -1
/* 245 */         }, { -1, -1, -1, -1, -1, -1, -1, -1 }
/*     */       };
/*     */     
/* 248 */     private final int[][] mGarrison = new int[][] {
/* 249 */         new int[8], 
/* 250 */         new int[8], {
/* 251 */           0, 0, 1, 2
/* 252 */         }, { 0, 0, 3, 4
/* 253 */         }, new int[8], 
/* 254 */         new int[8], 
/* 255 */         new int[8], 
/* 256 */         new int[8]
/*     */       };
/*     */     
/* 259 */     private final int[][] mTownFarms = new int[][] {
/* 260 */         { 1, 1, 1, -1
/* 261 */         }, { 1, 1, -1
/* 262 */         }, { 1, 1, 1, -1
/* 263 */         }, { -1, -1, -1, -1 }
/*     */       };
/*     */     
/* 266 */     private final int[][] mTerrain = new int[][] {
/* 267 */         { 0, 1, 2, -1
/* 268 */         }, { 3, 4, 5, -1
/* 269 */         }, { 6, 7, 8, -1
/* 270 */         }, { -1, -1, -1, -1 }
/*     */       };
/*     */ 
/*     */     
/*     */     void renderAboveA(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 275 */       CSprite.this.renderPop(con, dtx, dty, reg, ran, xx1, yy1, this.mTownHouses, this.mGarrison);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void renderAboveB(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1) {
/* 281 */       CSprite.this.renderOverlay(con, dtx, dty, reg, ran, xx1, yy1, this.mTownHouses);
/* 282 */       CSprite.this.renderGarrison(con, dtx, dty, reg, ran, xx1, yy1, this.mGarrison);
/*     */       
/* 284 */       int tx = dtx;
/* 285 */       int ty = dty;
/*     */       
/* 287 */       double p = CSprite.this.g.pop(reg);
/* 288 */       p = CLAMP.d((p - 0.4D) / 0.15D, 0.0D, 1.0D);
/*     */       
/* 290 */       if (tx == 1 && ty == 1) {
/*     */         
/* 292 */         double size = CSprite.this.g.fort(reg);
/* 293 */         if (size > 0.0D) {
/* 294 */           int dim = CLAMP.i(64 + (int)(p * 36.0D), 64, 100);
/* 295 */           int cx = xx1 + 32;
/* 296 */           int cy = yy1 + 32;
/* 297 */           ((RD.RACES()).visuals.cRace(reg).appearance()).world.walls_village.render(con, size, dim, cx, cy);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 330 */       CSprite.this.renderSiege(con, dtx, dty, reg, ran, xx1, yy1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void renderOnGround(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 336 */       CSprite.this.renderGround(con, dtx, dty, reg, ran, x1, y1, this.mTerrain, this.mTownFarms);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void renderGround(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1, int[][] mTerrain, int[][] mTownFarms) {
/* 348 */     WorldRaceSheet.Terrain os = ((RD.RACES()).visuals.cRace(reg).appearance()).world.terrain;
/* 349 */     WorldRaceSheet.Farm farm = ((RD.RACES()).visuals.cRace(reg).appearance()).world.farm;
/* 350 */     if (mTerrain[dty][dtx] >= 0) {
/* 351 */       os.render(con, mTerrain[dty][dtx], ran, x1, y1);
/*     */     }
/* 353 */     int t = mTownFarms[dtx][dty];
/* 354 */     if (t >= 0) {
/* 355 */       t = (int)(mTownFarms[dtx][dty] + 2.0D * RD.RACES().popSize(reg) - (ran & 0x11));
/* 356 */       if (t > 0) {
/* 357 */         OPACITY.O50.bind();
/* 358 */         farm.render(con, ran, x1, y1);
/* 359 */         OPACITY.unbind();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderGarrison(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1, int[][] mGarrison) {
/* 369 */     double v = this.g.garrison(reg);
/* 370 */     if (v <= 0.0D) {
/*     */       return;
/*     */     }
/* 373 */     con.s.setHard();
/* 374 */     con.s.setHeight(6).setDistance2Ground(0.0D);
/*     */ 
/*     */ 
/*     */     
/* 378 */     for (int y = 0; y < 2; y++) {
/* 379 */       for (int x = 0; x < 2; ) {
/* 380 */         int ix = x + dtx * 2;
/* 381 */         int iy = y + dty * 2;
/* 382 */         if (!isGarrison(reg, ix, iy, ran, mGarrison)) {
/*     */           x++; continue;
/*     */         } 
/* 385 */         int x1 = xx1 + x * 32;
/* 386 */         int y1 = yy1 + y * 32;
/* 387 */         TILE_SHEET sh = (WORLD.BUILDINGS()).sprites.garrison;
/* 388 */         int t = (int)Math.round(v * 7.0D);
/* 389 */         int rot = ran >> 9 & 0x3;
/* 390 */         sh.render(con.r, t + rot * 8, x1, y1);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isGarrison(Region reg, int dx, int dy, int ran, int[][] mGarrison) {
/* 398 */     return (this.g.garrison(reg) > 0.0D && mGarrison[dy][dx] - 1 == (reg.index() & 0x3));
/*     */   }
/*     */   
/*     */   private void renderPop(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1, int[][] mTownHouses, int[][] mGarrison) {
/* 402 */     int tx = dtx;
/* 403 */     int ty = dty;
/* 404 */     double p = this.g.pop(reg);
/*     */     
/* 406 */     con.s.setSoft();
/* 407 */     con.s.setHeight(4);
/* 408 */     int ttt = ran;
/*     */     
/* 410 */     WorldRaceSheet.Town sh = ((RD.RACES()).visuals.cRace(reg).appearance()).world.town;
/* 411 */     for (int y = 0; y < 2; y++) {
/* 412 */       for (int x = 0; x < 2; x++) {
/* 413 */         int ix = x + tx * 2;
/* 414 */         int iy = y + ty * 2;
/* 415 */         if (!isGarrison(reg, ix, iy, ttt, mGarrison))
/*     */         {
/* 417 */           if (mTownHouses[iy][ix] >= 0) {
/*     */             
/* 419 */             int t = mTownHouses[iy][ix] - 9;
/* 420 */             t += (int)(p * 11.0D) + (ran & 0x3);
/* 421 */             ran >>= 2;
/* 422 */             if (t >= 0) {
/*     */               
/* 424 */               t = (int)Math.round(3.0D * t / 10.0D);
/*     */               
/* 426 */               if (t > 3)
/* 427 */                 t = 3; 
/* 428 */               int x1 = xx1 + x * 32;
/* 429 */               int y1 = yy1 + y * 32;
/* 430 */               sh.render(con.r, con.s, t, ran, x1, y1);
/* 431 */               ran >>= 4;
/* 432 */               if (TIME.light().nightIs() && TIME.light().partOfCircular() * 4.0D > (ran & 0x7)) {
/* 433 */                 int lx = reg.cx() - dtx;
/* 434 */                 int ly = reg.cy() - dty;
/* 435 */                 if (!(WORLD.WATER()).coversTile.is(lx, ly) && !WORLD.MOUNTAIN().coversTile(lx, ly)) {
/* 436 */                   x1 += 16 + (GAME.intervals().get05() + ran & 0x3);
/* 437 */                   y1 += 16 + (GAME.intervals().get05() + (ran >> 4) & 0x3);
/* 438 */                   CORE.renderer().renderUniLight(x1, y1, 2, 64);
/*     */                 } 
/*     */               } 
/*     */               
/* 442 */               ran >>= 3;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 449 */     if ((RD.HEALTH()).outbreak.get(reg) == 1) {
/* 450 */       ran = ttt;
/* 451 */       for (int i = 0; i < 2; i++) {
/* 452 */         for (int x = 0; x < 2; x++) {
/* 453 */           int ix = x + tx * 2;
/* 454 */           int iy = i + ty * 2;
/* 455 */           if (mTownHouses[iy][ix] > 0) {
/*     */ 
/*     */             
/* 458 */             int x1 = xx1 + x * 32;
/* 459 */             int y1 = yy1 + i * 32;
/* 460 */             Sparks.render(x1, y1, mTownHouses[iy][ix], ran);
/* 461 */             ran >>= 3;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderOverlay(WRenContext con, int dtx, int dty, Region reg, int ran, int xx1, int yy1, int[][] mTownHouses) {
/* 472 */     int tx = dtx;
/* 473 */     int ty = dty;
/* 474 */     double p = this.g.pop(reg);
/*     */     
/* 476 */     con.s.setSoft();
/* 477 */     con.s.setHeight(4);
/*     */     
/* 479 */     ran >>= 1;
/*     */     
/* 481 */     WorldRaceSheet.Overlay os = ((RD.RACES()).visuals.cRace(reg).appearance()).world.overlay;
/*     */     
/* 483 */     for (int y = 0; y < 2; y++) {
/* 484 */       for (int x = 0; x < 2; x++) {
/* 485 */         if (mTownHouses[y + ty * 2][x + tx * 2] >= 0) {
/*     */           
/* 487 */           int t = (int)(mTownHouses[y + ty * 2][x + tx * 2] * p - (ran & 0x7));
/* 488 */           if (t > 0) {
/* 489 */             int x1 = xx1 + x * 32;
/* 490 */             int y1 = yy1 + y * 32;
/* 491 */             os.render(con, ran, x1, y1);
/*     */           } 
/*     */           
/* 494 */           ran >>= 7;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderSiege(WRenContext con, int dtx, int dty, Region reg, int ran, int x1, int y1) {
/* 503 */     if (!reg.besieged())
/*     */       return; 
/* 505 */     int tx = dtx;
/* 506 */     int ty = dty;
/*     */ 
/*     */     
/* 509 */     if (tx >= 1 && ty >= 1) {
/*     */       
/* 511 */       tx--;
/* 512 */       ty--;
/*     */       
/* 514 */       int dx = tx - 1;
/* 515 */       int dy = ty - 1;
/*     */       
/* 517 */       int d = 32;
/*     */       
/* 519 */       int x = -64 + d * dx;
/* 520 */       int y = -64 + d * dy;
/*     */ 
/*     */       
/* 523 */       int t = tx + ty * 3;
/* 524 */       (WORLD.BUILDINGS()).sprites.siege.render(con.r, t, x1 + x, y1 + y);
/* 525 */       con.s.setHard();
/* 526 */       con.s.setHeight(4).setDistance2Ground(0.0D);
/* 527 */       (WORLD.BUILDINGS()).sprites.siege.render((SPRITE_RENDERER)con.s, t, x1 + x, y1 + y);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\CSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */