/*     */ package util.gui.slider;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  92 */     this.body.setWidth(s);
/*  93 */     this.body.setHeight(paramGSliderHor.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  99 */     this.dragging &= MButt.LEFT.isDown();
/*     */     
/* 101 */     if (this.dragging) {
/* 102 */       double sx = (this.body.x1() + GSliderHor.this.cc.width() / 2);
/* 103 */       double ex = (this.body.x2() - GSliderHor.this.cc.width() / 2);
/* 104 */       double w = ex - sx;
/* 105 */       double d = (VIEW.mouse().x() - sx) / w;
/* 106 */       int k = (int)CLAMP.d(Math.round(d * GSliderHor.this.target.max()), GSliderHor.this.target().min(), GSliderHor.this.target().max());
/* 107 */       GSliderHor.this.target().set(k);
/*     */     } 
/*     */     
/* 110 */     int j = isActive & ((GSliderHor.this.target().min() != GSliderHor.this.target().max()) ? 1 : 0);
/*     */     
/* 112 */     if (j == 0) {
/* 113 */       (GCOLOR.T()).INACTIVE.bind();
/* 114 */     } else if (isHovered || this.dragging) {
/* 115 */       COLOR.WHITE100.bind();
/*     */     } else {
/* 117 */       COLOR.WHITE85.bind();
/*     */     } 
/* 119 */     int mids = this.body.width() / GSliderHor.this.size;
/* 120 */     for (int i = 0; i < mids; i++) {
/* 121 */       GSliderHor.this.c.render(r, this.body.x1() + i * GSliderHor.this.size, this.body.y1());
/*     */     }
/* 123 */     int left = this.body.width() % GSliderHor.this.size;
/* 124 */     if (left != 0) {
/* 125 */       int x1 = GSliderHor.this.size * mids - GSliderHor.this.size + left;
/* 126 */       GSliderHor.this.c.render(r, this.body.x1() + x1, this.body.y1());
/*     */     } 
/*     */     
/* 129 */     if (GSliderHor.this.target().max() != 0) {
/* 130 */       double d = GSliderHor.this.target().get() / GSliderHor.this.target().max();
/* 131 */       int x1 = (int)((body().width() - GSliderHor.this.size) * d);
/*     */       
/* 133 */       GSliderHor.this.cc.render(r, this.body.x1() + x1, this.body.y1());
/*     */     } 
/*     */     
/* 136 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 143 */     return super.hover(mCoo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 149 */     activeSet(!(GSliderHor.this.target.get() <= GSliderHor.this.target.min() && GSliderHor.this.target.get() >= GSliderHor.this.target.max()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 154 */     this.dragging = true;
/* 155 */     super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderHor$Mid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */