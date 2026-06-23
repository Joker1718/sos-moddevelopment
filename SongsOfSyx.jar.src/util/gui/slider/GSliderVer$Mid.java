/*     */ package util.gui.slider;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Mid
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private boolean dragging;
/*     */   
/*     */   Mid(int s) {
/*  95 */     this.body.setHeight(s);
/*  96 */     this.body.setWidth(paramGSliderVer.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 102 */     this.dragging &= MButt.LEFT.isDown();
/*     */     
/* 104 */     if (this.dragging) {
/* 105 */       double d = (CORE.getInput().getMouse().getCoo().y() - this.body.y1()) / this.body.height();
/* 106 */       int k = (int)CLAMP.d(Math.round(d * GSliderVer.this.target.max()), GSliderVer.this.target.min(), GSliderVer.this.target.max());
/* 107 */       GSliderVer.this.target.set(k);
/*     */     } 
/*     */     
/* 110 */     int j = isActive & ((GSliderVer.this.target.min() != GSliderVer.this.target.max()) ? 1 : 0);
/*     */     
/* 112 */     if (j == 0) {
/* 113 */       (GCOLOR.T()).INACTIVE.bind();
/* 114 */     } else if (isHovered || this.dragging) {
/* 115 */       COLOR.WHITE100.bind();
/*     */     } else {
/* 117 */       COLOR.WHITE65.bind();
/*     */     } 
/* 119 */     int mids = this.body.height() / GSliderVer.this.size;
/* 120 */     for (int i = 0; i < mids; i++) {
/* 121 */       GSliderVer.this.c.render(r, this.body.x1(), this.body.y1() + i * GSliderVer.this.size);
/*     */     }
/* 123 */     int left = this.body.height() % GSliderVer.this.size;
/* 124 */     if (left != 0) {
/* 125 */       int y1 = GSliderVer.this.size * mids - GSliderVer.this.size + left;
/* 126 */       GSliderVer.this.c.render(r, this.body.x1(), this.body.y1() + y1);
/*     */     } 
/* 128 */     if (GSliderVer.this.target.max() > 0) {
/* 129 */       int y1 = (body().height() - GSliderVer.this.size) * GSliderVer.this.target.get() / GSliderVer.this.target.max();
/* 130 */       GSliderVer.this.cc.render(r, this.body.x1(), this.body.y1() + y1);
/*     */     } 
/*     */ 
/*     */     
/* 134 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 139 */     activeSet(!(GSliderVer.this.target.get() <= GSliderVer.this.target.min() && GSliderVer.this.target.get() >= GSliderVer.this.target.max()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 145 */     this.dragging &= MButt.LEFT.isDown();
/*     */     
/* 147 */     if (this.dragging) {
/* 148 */       double d = (CORE.getInput().getMouse().getCoo().y() - this.body.y1()) / this.body.height();
/* 149 */       int k = (int)CLAMP.d(d * GSliderVer.this.target.max(), GSliderVer.this.target.min(), GSliderVer.this.target.max());
/* 150 */       GSliderVer.this.target.set(k);
/*     */     } 
/* 152 */     return super.hover(mCoo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 158 */     this.dragging = true;
/* 159 */     super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderVer$Mid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */