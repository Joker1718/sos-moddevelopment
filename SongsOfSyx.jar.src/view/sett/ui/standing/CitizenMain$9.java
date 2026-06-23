/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.Race;
/*     */ import init.settings.S;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.standing.StandingCitizen;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
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
/*     */ class null
/*     */   extends GuiSection
/*     */ {
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 270 */     super.hoverInfoGet(text);
/* 271 */     if (!text.emptyIs()) {
/*     */       return;
/*     */     }
/* 274 */     GBox b = (GBox)text;
/* 275 */     b.title((h.happiness.info()).name);
/* 276 */     b.text((h.happiness.info()).desc);
/* 277 */     b.NL(8);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 282 */     b.textL((h.fullfillment.info()).name);
/* 283 */     b.tab(7);
/* 284 */     b.add((SPRITE)GFORMAT.perc(b.text(), h.fullfillment.getD((Race)race.get()), 4));
/*     */     
/* 286 */     double c = 0.0D;
/* 287 */     double m = 0.0D;
/* 288 */     for (STAT s : STATS.all()) {
/* 289 */       c += s.standing().get(cl, (Race)race.get());
/* 290 */       m += s.standing().max(cl, (Race)race.get()) - s.standing().getDismiss(cl, (Race)race.get());
/*     */     } 
/* 292 */     GText gText1 = b.text();
/* 293 */     gText1.add('(');
/* 294 */     GFORMAT.dofk(gText1, c, m);
/* 295 */     gText1.add(')');
/* 296 */     b.tab(9);
/* 297 */     b.add((SPRITE)gText1);
/* 298 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 302 */     b.textL((h.expectation.info()).name);
/* 303 */     b.tab(7);
/* 304 */     b.add((SPRITE)GFORMAT.perc(b.text(), h.expectation.getD((Race)race.get()), 4));
/* 305 */     b.NL();
/*     */ 
/*     */     
/* 308 */     GText t = b.text();
/* 309 */     t.add('=').s();
/* 310 */     b.tab(7);
/* 311 */     b.add((SPRITE)GFORMAT.perc(t, h.fullfillment.getD((Race)race.get()) / h.expectation.getD((Race)race.get())));
/* 312 */     b.NL();
/*     */     
/* 314 */     double bo = (STANDINGS.get(cl)).bhappiness.get((BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl));
/*     */     
/* 316 */     if (bo != 1.0D || (S.get()).developer) {
/* 317 */       b.sep();
/* 318 */       (STANDINGS.get(cl)).bhappiness.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), Dic.¤¤Boosts, true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CitizenMain$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */