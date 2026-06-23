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
/*     */ class null
/*     */   extends GHeader.HeaderHorizontal
/*     */ {
/*     */   null(SPRITE $anonymous0, SPRITE $anonymous1) {
/* 184 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 187 */     GBox b = (GBox)text;
/*     */     
/* 189 */     b.title(res.name);
/* 190 */     b.add((SPRITE)text.text().add(ModuleIndustry.¤¤Production).s().add('(').add(Dic.¤¤Total).add(')'));
/* 191 */     b.NL(4);
/*     */     
/* 193 */     b.textLL(ModuleIndustry.¤¤ProducedDay);
/* 194 */     b.tab(7);
/* 195 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.get(0)));
/* 196 */     b.NL();
/*     */     
/* 198 */     b.textLL(ModuleIndustry.¤¤ProducedYesterDay);
/* 199 */     b.tab(7);
/* 200 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.get(1)));
/* 201 */     b.NL();
/*     */     
/* 203 */     int yearStart = (int)(-TIME.days().bitOfYear() * TIME.years().bitConversion((TIMECYCLE)TIME.years()));
/*     */     
/* 205 */     b.textLL(ModuleIndustry.¤¤ProducedNow);
/* 206 */     b.tab(7);
/* 207 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(yearStart, 0)));
/* 208 */     b.NL();
/*     */     
/* 210 */     b.textLL(ModuleIndustry.¤¤ProducedPrevious);
/* 211 */     b.tab(7);
/* 212 */     b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(-yearStart - (int)TIME.years().bitConversion((TIMECYCLE)TIME.days()), -yearStart)));
/* 213 */     b.NL();
/*     */     
/* 215 */     b.NL(8);
/* 216 */     b.textLL(DicTime.¤¤Days);
/* 217 */     (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.clear();
/* 218 */     (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.add((HISTORY)hi);
/* 219 */     text.NL();
/* 220 */     text.add((ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.sprite);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleIndustry$I$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */