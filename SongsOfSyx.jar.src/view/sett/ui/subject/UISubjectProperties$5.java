/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import game.boosting.BHoverer;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import settlement.stats.service.StatService;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.colors.GCOLOR_UI;
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
/*     */ class null
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 262 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*     */     SPRITE sPRITE;
/* 266 */     GCOLOR.UI().border().render(r, (RECTANGLE)this.body, -1);
/* 267 */     GCOLOR.UI().bg(true, false, isHovered).render(r, (RECTANGLE)this.body, -2);
/* 268 */     double curr = TIME.years().bitConversion((TIMECYCLE)TIME.days()) * UISubjectProperties.this.ni() * n.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu());
/* 269 */     double m = TIME.years().bitConversion((TIMECYCLE)TIME.days()) * UISubjectProperties.this.ni() * n.rate.baseValue;
/*     */     
/* 271 */     if (m > 0.0D) {
/* 272 */       COLOR col = GCOLOR_UI.color((GCOLOR.UI()).NEUTRAL.inactive, true, false, isHovered);
/* 273 */       double d = curr / m - 0.5D;
/* 274 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 275 */       int w = (int)(d * (body().width() - 6));
/* 276 */       col.render(r, body().x1() + 3, body().x1() + 3 + w, body().y1() + 3, body().y2() - 3);
/*     */     } 
/*     */ 
/*     */     
/* 280 */     Icon icon = n.rate.icon;
/* 281 */     if (n == (NEEDS.TYPES()).SHRINE) {
/* 282 */       sPRITE = ((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(UISubjectProperties.this.a.a.indu())).religion.icon.small;
/* 283 */     } else if (n == (NEEDS.TYPES()).TEMPLE) {
/* 284 */       sPRITE = ((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(UISubjectProperties.this.a.a.indu())).religion.icon.small;
/*     */     } 
/* 286 */     sPRITE.renderCY(r, body().x1() + 3, body().cY());
/*     */     
/* 288 */     text.clear();
/* 289 */     GFORMAT.fRel(text, curr, m);
/* 290 */     text.renderCY(r, body().x1() + 23, body().cY());
/*     */     
/* 292 */     int x1 = body().x1() + 75;
/*     */     
/* 294 */     for (StatService s : STATS.SERVICE().perNeed(n)) {
/* 295 */       icon(r, s.access(UISubjectProperties.this.a.a), x1);
/* 296 */       x1 += 12;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 303 */     GBox b = (GBox)text;
/* 304 */     b.title(n.rate.name);
/* 305 */     b.text(UISubjectProperties.¤¤serviceDesc);
/* 306 */     text.NL(4);
/* 307 */     GFORMAT.f(b.text(), UISubjectProperties.this.ni() * n.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu()));
/* 308 */     b.NL(8);
/*     */ 
/*     */     
/* 311 */     b.textLL(UISubjectProperties.¤¤services);
/* 312 */     b.NL();
/*     */     
/* 314 */     for (StatService s : STATS.SERVICE().perNeed(n)) {
/* 315 */       hh(b, s.icon(UISubjectProperties.this.a.a.indu()), s.name, s.access(UISubjectProperties.this.a.a));
/*     */     }
/* 317 */     b.NL();
/* 318 */     b.sep();
/* 319 */     BHoverer.hover((GUI_BOX)b, n.rate.all(), UISubjectProperties.this.a.a.indu(), Dic.¤¤Rate, n.rate.baseValue, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private void icon(SPRITE_RENDERER r, boolean access, int x1) {
/* 324 */     if (access) {
/* 325 */       (GCOLOR.UI()).GOOD.hovered.bind();
/* 326 */       (UI.icons()).s.allRight.renderCY(r, x1, this.body.cY());
/*     */     } else {
/* 328 */       (GCOLOR.UI()).BAD.hovered.bind();
/* 329 */       (UI.icons()).s.cancel.renderCY(r, x1, this.body.cY());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void hh(GBox b, SPRITE icon, CharSequence name, boolean access) {
/* 334 */     b.add(icon);
/* 335 */     b.textLL(name);
/* 336 */     b.tab(7);
/* 337 */     if (access) {
/* 338 */       b.add((SPRITE)(UI.icons()).s.allRight, (GCOLOR.UI()).GOOD.hovered);
/*     */     } else {
/* 340 */       b.add((SPRITE)(UI.icons()).s.cancel, (GCOLOR.UI()).BAD.hovered);
/*     */     } 
/* 342 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectProperties$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */