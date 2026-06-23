/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsPopulation;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 283 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 288 */     box.title(Dic.¤¤Population);
/* 289 */     int i = 32 - stapleI - 1;
/* 290 */     box.add((SPRITE)box.text().add(-i).s().add(TIME.days().cycleName()));
/* 291 */     box.NL(8);
/*     */     
/* 293 */     box.textLL(Dic.¤¤Population);
/* 294 */     box.tab(7);
/* 295 */     box.add((SPRITE)GFORMAT.iBig(box.text(), (int)getValue(stapleI)));
/* 296 */     box.NL(8);
/*     */     
/*     */     int ci;
/*     */     
/* 300 */     for (ci = 0; ci < CAUSE_ARRIVES.ALL().size(); ci++) {
/* 301 */       CAUSE_ARRIVE a = (CAUSE_ARRIVE)CAUSE_ARRIVES.ALL().get(ci);
/* 302 */       int am = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.enters().get(a.index())).statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */       
/* 304 */       if (am > 0) {
/* 305 */         box.textL(a.name);
/* 306 */         box.tab(7);
/* 307 */         box.add((SPRITE)GFORMAT.iIncr(box.text(), am));
/* 308 */         box.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 312 */     box.NL(4);
/*     */     
/* 314 */     for (ci = 0; ci < CAUSE_LEAVES.ALL().size(); ci++) {
/* 315 */       CAUSE_LEAVE a = (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(ci);
/* 316 */       int am = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(a.index())).statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */       
/* 318 */       if (am > 0) {
/* 319 */         box.textL(a.names);
/* 320 */         if (a.defaultStanding() > 0.0D)
/* 321 */           box.tab(6).add((SPRITE)(UI.icons()).s.angry, (GCOLOR.UI()).BAD.hovered); 
/* 322 */         box.tab(7);
/* 323 */         box.add((SPRITE)GFORMAT.iIncr(box.text(), -am));
/* 324 */         box.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 328 */     box.NL(4);
/* 329 */     box.textLL(Dic.¤¤Total);
/* 330 */     box.tab(7);
/* 331 */     box.add((SPRITE)GFORMAT.iIncr(box.text(), (int)(getValue(stapleI) - getValue(stapleI - 1))));
/* 332 */     box.NL(4);
/*     */     
/* 334 */     if (cl == HCLASSES.CITIZEN()) {
/* 335 */       box.sep();
/* 336 */       box.textLL(Dic.¤¤Type);
/* 337 */       box.NL();
/* 338 */       for (STAT t : (STATS.POP()).TYPE.all()) {
/* 339 */         box.textL((t.info()).name);
/* 340 */         box.tab(7);
/* 341 */         box.add((SPRITE)GFORMAT.i(box.text(), t.data(cl).get(CatPopulation.this.race.get(), i)));
/* 342 */         box.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 352 */     int i = 32 - stapleI - 1;
/* 353 */     if (i >= 32)
/* 354 */       i = 31; 
/* 355 */     if (i < 0)
/* 356 */       i = 0; 
/* 357 */     int am = (STATS.POP()).POP.data(cl).get(CatPopulation.this.race.get(), i);
/*     */     
/* 359 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 364 */     int i = 32 - stapleI - 1;
/* 365 */     for (int ci = 0; ci < CAUSE_LEAVES.ALL().size(); ci++) {
/* 366 */       CAUSE_LEAVE a = (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(ci);
/* 367 */       if (!a.natural) {
/* 368 */         int am = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(a.index())).statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */         
/* 370 */         if (am > 0) {
/* 371 */           c.set((GCOLOR.UI()).BAD.normal);
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 379 */     super.setColor(c, stapleI, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulation$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */