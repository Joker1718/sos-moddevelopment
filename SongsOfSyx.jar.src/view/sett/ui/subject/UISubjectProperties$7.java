/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.NEED;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsNeeds;
/*     */ import settlement.stats.service.StatService;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GText;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 502 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 508 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 509 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     
/* 511 */     int x1 = body().x1() + 8;
/*     */     
/* 513 */     if (n != null) {
/*     */       
/* 515 */       n.need.rate.icon.renderCY(r, x1, body().cY());
/*     */     } else {
/* 517 */       icon.renderCY(r, x1, body().cY());
/*     */     } 
/* 519 */     x1 += 20;
/*     */     
/* 521 */     work.setFont((UI.FONT()).S);
/* 522 */     work.clear();
/* 523 */     work.add((s.info()).name);
/* 524 */     work.setMultipleLines(false);
/* 525 */     work.setMaxWidth(200);
/* 526 */     work.lablify();
/* 527 */     work.renderCY(r, x1, body().cY());
/* 528 */     x1 += 230;
/*     */     
/* 530 */     int i = s.indu().get(UISubjectProperties.this.a.a.indu());
/* 531 */     double m = s.indu().max(UISubjectProperties.this.a.a.indu());
/* 532 */     double d = i / m;
/*     */     
/* 534 */     GMeter.GMeterCol c = GMeter.C_GREEN;
/* 535 */     if (n == null || i > n.breakpoint()) {
/* 536 */       c = GMeter.C_RED;
/*     */     }
/* 538 */     GMeter.render(r, c, 
/* 539 */         d, 
/* 540 */         x1, x1 + 75, body().y1() + 8, body().y2() - 8);
/*     */ 
/*     */ 
/*     */     
/* 544 */     if (n != null) {
/* 545 */       int x = (int)(x1 + 75.0D * n.breakpoint() / m);
/* 546 */       GCOLOR.UI().border().render(r, x, x + 1, body().y1() + 8, body().y2() - 8);
/*     */     } 
/*     */     
/* 549 */     x1 += 90;
/*     */     
/* 551 */     work.clear();
/*     */     
/* 553 */     if (n != null) {
/*     */       
/* 555 */       GFORMAT.percInc(work, n.need.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu()), 0);
/* 556 */       work.renderCY(r, x1, body().cY());
/* 557 */       x1 += 45;
/*     */       
/* 559 */       for (StatService s : STATS.SERVICE().perNeed((NEED)n.need)) {
/* 560 */         boolean ok = UISubjectProperties.this.access(s, (NEED)n.need);
/*     */         
/* 562 */         if (ok) {
/* 563 */           (GCOLOR.UI()).GOOD.hovered.bind();
/* 564 */           (UI.icons()).s.allRight.renderCY(r, x1, body().cY());
/*     */         } else {
/* 566 */           (GCOLOR.UI()).BAD.hovered.bind();
/* 567 */           (UI.icons()).s.cancel.renderCY(r, x1, body().cY());
/*     */         } 
/* 569 */         x1 += 12;
/*     */       } 
/* 571 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 582 */     text.title((s.info()).name);
/* 583 */     text.text((s.info()).desc);
/* 584 */     text.NL(4);
/* 585 */     GBox b = (GBox)text;
/* 586 */     b.textLL(UISubjectProperties.¤¤need);
/* 587 */     b.tab(6);
/* 588 */     if (n != null) {
/* 589 */       double d = s.indu().get(UISubjectProperties.this.a.a.indu()) / n.breakpoint();
/* 590 */       b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 591 */       b.NL();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 597 */     if (n != null) {
/*     */ 
/*     */ 
/*     */       
/* 601 */       b.textLL(UISubjectProperties.¤¤services);
/* 602 */       b.NL();
/*     */       
/* 604 */       for (StatService s : STATS.SERVICE().perNeed((NEED)n.need)) {
/* 605 */         b.add(s.icon(UISubjectProperties.this.a.a.indu()));
/* 606 */         b.textLL(s.name(UISubjectProperties.this.a.a.indu()));
/* 607 */         b.tab(6);
/* 608 */         if (UISubjectProperties.this.access(s, (NEED)n.need)) {
/* 609 */           b.add((SPRITE)(UI.icons()).s.allRight, (GCOLOR.UI()).GOOD.hovered);
/*     */         } else {
/* 611 */           b.add((SPRITE)(UI.icons()).s.cancel, (GCOLOR.UI()).BAD.hovered);
/*     */         } 
/* 613 */         b.NL();
/*     */       } 
/* 615 */       b.NL();
/* 616 */       b.sep();
/* 617 */       GText t = b.text();
/* 618 */       t.add(UISubjectProperties.¤¤percPerDay).insert(0, (int)(100.0D * n.need.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu())));
/* 619 */       n.need.rate.hover((GUI_BOX)b, (BOOSTABLE_O)UISubjectProperties.this.a.a.indu(), (CharSequence)t, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 625 */     DebugInput.activate((DOUBLE_O.DOUBLE_OE<Induvidual>)s.indu(), UISubjectProperties.this.a.a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectProperties$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */