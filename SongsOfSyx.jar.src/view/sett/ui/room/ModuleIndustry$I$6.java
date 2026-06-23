/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GHeader.HeaderHorizontal
/*     */ {
/*     */   null(SPRITE $anonymous0, SPRITE $anonymous1) {
/* 298 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 302 */     GBox b = (GBox)text;
/*     */     
/* 304 */     b.title(res.name);
/* 305 */     b.add((SPRITE)text.text().add(ModuleIndustry.¤¤Consumption).s().add('(').add(Dic.¤¤Total).add(')'));
/* 306 */     b.NL(4);
/*     */     
/* 308 */     b.textLL(ModuleIndustry.¤¤ConsumedDay);
/* 309 */     b.tab(7);
/* 310 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.get(0)));
/* 311 */     b.NL();
/*     */     
/* 313 */     b.textLL(ModuleIndustry.¤¤ConsumedYEsterday);
/* 314 */     b.tab(7);
/* 315 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.get(1)));
/* 316 */     b.NL();
/*     */     
/* 318 */     int yearStart = (int)(-TIME.days().bitOfYear() * TIME.years().bitConversion((TIMECYCLE)TIME.years()));
/*     */     
/* 320 */     b.textLL(ModuleIndustry.¤¤ConsumedNow);
/* 321 */     b.tab(7);
/* 322 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(-yearStart, 0)));
/* 323 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 327 */     b.textLL(ModuleIndustry.¤¤ConsumedPrevious);
/* 328 */     b.tab(7);
/* 329 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(-((int)TIME.years().bitConversion((TIMECYCLE)TIME.days())) - yearStart, -yearStart)));
/* 330 */     b.NL();
/*     */     
/* 332 */     b.NL(8);
/* 333 */     b.textLL(DicTime.¤¤Days);
/* 334 */     (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.clear();
/* 335 */     (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.add((HISTORY)hi);
/* 336 */     text.NL();
/* 337 */     text.add((ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.sprite);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleIndustry$I$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */