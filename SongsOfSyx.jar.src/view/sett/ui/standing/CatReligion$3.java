/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
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
/*     */ class null
/*     */   extends GuiSection
/*     */ {
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 225 */     if (!isHoveringAHoverElement()) {
/*     */       
/* 227 */       GBox b = (GBox)text;
/* 228 */       b.title(ss.info.name);
/* 229 */       b.text(ss.info.desc);
/* 230 */       b.NL(8);
/*     */       
/* 232 */       b.textL((ss.followers.info()).name);
/* 233 */       b.tab(8);
/* 234 */       b.add((SPRITE)GFORMAT.i(b.text(), ss.followers.data(cl).get(race.get())));
/* 235 */       b.NL();
/*     */       
/* 237 */       b.textLL((STATS.RELIGION()).TEMPLE.name);
/* 238 */       b.tab(6);
/* 239 */       b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).TEMPLE.access(ss.religion).data(cl).getD(race.get())));
/* 240 */       b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).TEMPLE.quality(ss.religion).data(cl).getD(race.get())));
/* 241 */       b.NL();
/*     */       
/* 243 */       b.textLL((STATS.RELIGION()).SHRINE.name);
/* 244 */       b.tab(6);
/* 245 */       b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).SHRINE.access(ss.religion).data(cl).getD(race.get())));
/* 246 */       b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).SHRINE.quality(ss.religion).data(cl).getD(race.get())));
/* 247 */       b.NL();
/*     */       
/* 249 */       b.textLL(CatReligion.¤¤Conversion);
/* 250 */       b.tab(6);
/* 251 */       b.add((SPRITE)GFORMAT.f0(b.text(), ss.religion.conversionCity.get((BOOSTABLE_O)cl.get((Race)race.get()))));
/*     */       
/* 253 */       b.NL(8);
/*     */ 
/*     */       
/* 256 */       ss.religion.boosts.hover(text, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), 4);
/*     */     } 
/*     */ 
/*     */     
/* 260 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 265 */     GCOLOR.UI().border().render(r, (RECTANGLE)body());
/* 266 */     GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -1);
/* 267 */     super.render(r, ds);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatReligion$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */