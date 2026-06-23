/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
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
/*     */ class Row
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final GText work;
/*     */   private final STAT s;
/*     */   private final SPRITE icon;
/*     */   
/*     */   Row(STAT stat, GText text) {
/* 108 */     this.work = text;
/* 109 */     this.s = stat;
/* 110 */     this.body.setDim(480.0D, 32.0D);
/* 111 */     if ((stat.info()).icon != null) {
/* 112 */       this.icon = (stat.info()).icon.resized(24);
/*     */     } else {
/* 114 */       this.icon = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 121 */     if (isHovered) {
/* 122 */       COLOR.BLUEDARK.render(r, (RECTANGLE)body());
/*     */     }
/*     */     
/* 125 */     if (this.icon != null) {
/* 126 */       this.icon.renderCY(r, body().x1(), body().cY());
/*     */     }
/*     */     
/* 129 */     this.work.setFont((UI.FONT()).S);
/* 130 */     this.work.clear();
/* 131 */     this.work.add((this.s.info()).name);
/* 132 */     this.work.setMaxWidth(220);
/* 133 */     this.work.setMultipleLines(false);
/* 134 */     this.work.lablifySub();
/* 135 */     this.work.renderCY(r, body().x1() + 32, body().cY());
/*     */     
/* 137 */     this.work.setFont((UI.FONT()).S);
/* 138 */     this.work.clear();
/*     */     
/* 140 */     if (this.s == (STATS.POP()).age.AGE_DAYS) {
/* 141 */       GFORMAT.f(this.work, this.s.indu().get(UISubjectStats.this.a.a.indu()) / TIME.years().bitConversion((TIMECYCLE)TIME.days()), 2);
/* 142 */     } else if (this.s.indu().max(UISubjectStats.this.a.a.indu()) == 1 && this.s.info().isInt()) {
/* 143 */       GFORMAT.bool(this.work, (this.s.indu().get(UISubjectStats.this.a.a.indu()) == 1));
/* 144 */     } else if (this.s.info().isInt()) {
/*     */       
/* 146 */       GFORMAT.i(this.work, this.s.indu().get(UISubjectStats.this.a.a.indu()));
/*     */     } else {
/* 148 */       GFORMAT.perc(this.work, this.s.indu().getD(UISubjectStats.this.a.a.indu()));
/*     */     } 
/* 150 */     this.work.normalify();
/* 151 */     this.work.renderCY(r, body().x1() + 260, body().cY());
/*     */     
/* 153 */     double now = this.s.standing().get(UISubjectStats.this.a.a.indu());
/* 154 */     double max = this.s.standing().max(UISubjectStats.this.a.a.indu().clas(), UISubjectStats.this.a.a.race());
/* 155 */     int w = (int)(150.0D * this.s.standing().normalized(UISubjectStats.this.a.a.indu().clas(), UISubjectStats.this.a.a.race()));
/* 156 */     if (w > 0) {
/* 157 */       if (w < 20)
/* 158 */         w = 20; 
/* 159 */       GMeter.render(r, GMeter.C_REDGREEN, now / max, body().x1() + 330, body().x1() + 330 + w, body().y1() + 8, body().y2() - 8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 166 */     this.s.hover(text, UISubjectStats.this.a.a.indu());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 173 */     if (this.s.indu() != null)
/* 174 */       DebugInput.activate((DOUBLE_O.DOUBLE_OE<Induvidual>)this.s.indu(), UISubjectStats.this.a.a); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectStats$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */