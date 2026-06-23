/*     */ package view.sett.ui.room.priority;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Chunk
/*     */   extends GuiSection
/*     */ {
/*     */   public final int prio;
/*     */   
/*     */   public Chunk(int prio) {
/* 259 */     this.prio = prio;
/* 260 */     body().setDim(Row.EW, Row.HH);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 266 */     if (hoveredIs() && Row.this.dragging != null) {
/* 267 */       Row.this.draggingTo = this;
/*     */     }
/* 269 */     int x1 = body().x1();
/* 270 */     int y1 = body().y1();
/*     */     
/* 272 */     clear();
/* 273 */     body().setDim(Row.EW, Row.HH);
/* 274 */     body().moveX1Y1(x1, y1);
/* 275 */     arrange();
/*     */ 
/*     */     
/* 278 */     GButt.ButtPanel.renderBG(r, true, false, (Row.this.draggingTo == this), (RECTANGLE)body());
/* 279 */     if (this.prio == 0) {
/* 280 */       OPACITY.O50.bind();
/* 281 */       COLOR.RED100.render(r, (RECTANGLE)body(), -4);
/* 282 */       OPACITY.unbind();
/*     */     } 
/* 284 */     GCOLOR.UI().border().render(r, body().x1(), body().x1() + 1, body().y1() + 6, body().y2() - 6);
/*     */     
/* 286 */     Row.Card hov = null;
/* 287 */     for (Row.Card c : Row.this.cards) {
/* 288 */       if (is(c) && c.hoveredIs())
/* 289 */         hov = c; 
/*     */     } 
/* 291 */     super.render(r, ds);
/*     */     
/* 293 */     if (hov != null) {
/* 294 */       hov.render(r, ds, true, false, true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void arrange() {
/* 301 */     int am = 0;
/* 302 */     for (Row.Card c : Row.this.cards) {
/* 303 */       if (is(c)) {
/* 304 */         am++;
/*     */       }
/*     */     } 
/* 307 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 310 */     double ww = (Row.EW - 2 * Row.MM - ((Row.Card)Row.this.cards.get(0)).body.width());
/*     */ 
/*     */     
/* 313 */     double dx = ww;
/* 314 */     am = (int)Math.ceil(am / 2.0D);
/* 315 */     if (am > 0)
/* 316 */       dx /= am; 
/* 317 */     if (dx > ((Row.Card)Row.this.cards.get(0)).body.width())
/* 318 */       dx = ((Row.Card)Row.this.cards.get(0)).body.width(); 
/* 319 */     double x1 = (body().x1() + Row.MM);
/* 320 */     int y1 = body().y1() + (body().height() - ((Row.Card)Row.this.cards.get(0)).body.height() * 2) / 2;
/*     */ 
/*     */     
/* 323 */     for (Row.Card c : Row.this.cards) {
/* 324 */       if (is(c)) {
/* 325 */         add((RENDEROBJ)c, (int)x1, y1);
/* 326 */         x1 += dx;
/* 327 */         if (x1 > (body().x2() - ((Row.Card)Row.this.cards.get(0)).body.width() - Row.MM)) {
/* 328 */           y1 += ((Row.Card)Row.this.cards.get(0)).body.height();
/* 329 */           x1 = (body().x1() + Row.MM);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean is(Row.Card c) {
/* 338 */     if (!Row.this.groupFilter.active(c.g))
/* 339 */       return false; 
/* 340 */     int p = CLAMP.i(Row.this.emp.priorities.get(c.e), 0, Row.this.emp.priorities.max(c.e));
/* 341 */     return (p == this.prio);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 346 */     super.hoverInfoGet(text);
/* 347 */     GBox b = (GBox)text;
/* 348 */     if (text.emptyIs()) {
/* 349 */       b.textLL(Row.¤¤priority);
/* 350 */       b.add((SPRITE)b.text().add(this.prio));
/* 351 */       if (this.prio == Row.this.emp.priorities.max(null)) {
/* 352 */         b.text(Row.¤¤highest);
/* 353 */       } else if (this.prio == 1) {
/* 354 */         b.text(Row.¤¤lowest);
/* 355 */       } else if (this.prio == 0) {
/* 356 */         b.title(Row.¤¤ban);
/* 357 */         b.NL();
/* 358 */         b.text(Row.¤¤banD);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Row$Chunk.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */