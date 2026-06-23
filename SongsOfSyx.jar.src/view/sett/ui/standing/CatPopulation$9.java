/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsPopulation;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStaples
/*     */ {
/*     */   null(int $anonymous0) {
/* 405 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 409 */     box.title(((STATS.POP()).WRONGFUL.info()).names);
/* 410 */     int i = 32 - stapleI - 1;
/* 411 */     box.add((SPRITE)box.text().add(-i).s().add(TIME.days().cycleName()));
/* 412 */     box.NL(8);
/* 413 */     int di = 0;
/* 414 */     for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/* 415 */       if (((CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(di)).defaultStanding() <= 0.0D) {
/* 416 */         di++;
/*     */         continue;
/*     */       } 
/* 419 */       box.add(cols[di]);
/* 420 */       box.textL((s.info()).name);
/* 421 */       box.tab(7);
/* 422 */       box.add((SPRITE)GFORMAT.iIncr(box.text(), s.statistics(cl).history(CatPopulation.this.race.get()).get(i)));
/* 423 */       box.NL();
/* 424 */       di++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 430 */     double am = 0.0D;
/* 431 */     int i = 32 - stapleI - 1;
/* 432 */     int di = 0;
/* 433 */     for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/* 434 */       if (((CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(di++)).defaultStanding() <= 0.0D)
/*     */         continue; 
/* 436 */       am += s.statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */     } 
/* 438 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2) {
/* 445 */     double am = 0.0D;
/* 446 */     int i = 32 - stapleI - 1;
/* 447 */     for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/* 448 */       am += s.statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */     }
/*     */     
/* 451 */     int h = y2 - y1;
/* 452 */     if (h <= 0)
/* 453 */       h = 1; 
/* 454 */     if (am == 0.0D) {
/*     */       return;
/*     */     }
/* 457 */     int ci = 0;
/* 458 */     for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/*     */       
/* 460 */       double d = s.statistics(cl).history(CatPopulation.this.race.get()).get(i);
/* 461 */       d /= am;
/* 462 */       int hh = (int)Math.ceil(h * d);
/*     */       
/* 464 */       if (hh > 0) {
/* 465 */         ColorImp c = ColorImp.TMP;
/* 466 */         c.set((COLOR)COLOR.UNIQUE.getC(ci));
/* 467 */         c.shadeSelf(hovered ? 0.75D : 0.55D);
/* 468 */         c.render(r, x1, x2, y2 - hh, y2);
/* 469 */         c.set((COLOR)COLOR.UNIQUE.getC(ci));
/* 470 */         c.shadeSelf(hovered ? 1.0D : 0.8D);
/* 471 */         c.render(r, x1 + 1, x2 - 1, y2 - hh + 1, y2 - 1);
/* 472 */         y2 -= hh;
/*     */       } 
/* 474 */       ci++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulation$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */