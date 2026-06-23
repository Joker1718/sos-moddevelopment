/*     */ package util.gui.slider;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ public class GSliderVer
/*     */   extends GuiSection {
/*     */   private final INT.INTE target;
/*     */   private final int size;
/*     */   
/*     */   private GSliderVer(SPRITE b1, SPRITE c, SPRITE cc, SPRITE b2, final INT.INTE target, int width) {
/*  24 */     this.target = target;
/*     */ 
/*     */     
/*  27 */     this.size = b1.width();
/*  28 */     this.c = c;
/*  29 */     this.cc = cc;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     GButt.Glow b = new GButt.Glow(b1)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  38 */           activeSet((target.get() > target.min()));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  43 */           if (target.get() > target.min()) {
/*  44 */             target.inc(-1);
/*     */           }
/*     */         }
/*     */       };
/*  48 */     b.body.setDim(b1.width());
/*  49 */     b.repetativeSet(true);
/*  50 */     add((RENDEROBJ)b);
/*     */     
/*  52 */     if (width < 3 * this.size) {
/*  53 */       width = 3 * this.size;
/*     */     }
/*  55 */     width -= 2 * this.size;
/*     */     
/*  57 */     addDownC(0, (RENDEROBJ)new Mid(width));
/*     */     
/*  59 */     b = new GButt.Glow(b2)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  63 */           activeSet((target.get() < target.max()));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  68 */           if (target.get() < target.max()) {
/*  69 */             target.inc(1);
/*     */           }
/*     */         }
/*     */       };
/*  73 */     b.body.setDim(b1.width());
/*  74 */     b.repetativeSet(true);
/*  75 */     addDownC(0, (RENDEROBJ)b);
/*     */   }
/*     */ 
/*     */   
/*     */   private final SPRITE c;
/*     */   private final SPRITE cc;
/*     */   
/*     */   public GSliderVer(INT.INTE target, int size) {
/*  83 */     this((UI.decor()).slider.makeSprite(4), (UI.decor()).slider.makeSprite(5), (UI.decor()).slider.makeSprite(6), (UI.decor()).slider.makeSprite(7), target, size);
/*     */   }
/*     */   
/*     */   public static int WIDTH() {
/*  87 */     return (UI.decor()).slider.size();
/*     */   }
/*     */   
/*     */   private class Mid
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private boolean dragging;
/*     */     
/*     */     Mid(int s) {
/*  95 */       this.body.setHeight(s);
/*  96 */       this.body.setWidth(GSliderVer.this.size);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 102 */       this.dragging &= MButt.LEFT.isDown();
/*     */       
/* 104 */       if (this.dragging) {
/* 105 */         double d = (CORE.getInput().getMouse().getCoo().y() - this.body.y1()) / this.body.height();
/* 106 */         int k = (int)CLAMP.d(Math.round(d * GSliderVer.this.target.max()), GSliderVer.this.target.min(), GSliderVer.this.target.max());
/* 107 */         GSliderVer.this.target.set(k);
/*     */       } 
/*     */       
/* 110 */       int j = isActive & ((GSliderVer.this.target.min() != GSliderVer.this.target.max()) ? 1 : 0);
/*     */       
/* 112 */       if (j == 0) {
/* 113 */         (GCOLOR.T()).INACTIVE.bind();
/* 114 */       } else if (isHovered || this.dragging) {
/* 115 */         COLOR.WHITE100.bind();
/*     */       } else {
/* 117 */         COLOR.WHITE65.bind();
/*     */       } 
/* 119 */       int mids = this.body.height() / GSliderVer.this.size;
/* 120 */       for (int i = 0; i < mids; i++) {
/* 121 */         GSliderVer.this.c.render(r, this.body.x1(), this.body.y1() + i * GSliderVer.this.size);
/*     */       }
/* 123 */       int left = this.body.height() % GSliderVer.this.size;
/* 124 */       if (left != 0) {
/* 125 */         int y1 = GSliderVer.this.size * mids - GSliderVer.this.size + left;
/* 126 */         GSliderVer.this.c.render(r, this.body.x1(), this.body.y1() + y1);
/*     */       } 
/* 128 */       if (GSliderVer.this.target.max() > 0) {
/* 129 */         int y1 = (body().height() - GSliderVer.this.size) * GSliderVer.this.target.get() / GSliderVer.this.target.max();
/* 130 */         GSliderVer.this.cc.render(r, this.body.x1(), this.body.y1() + y1);
/*     */       } 
/*     */ 
/*     */       
/* 134 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 139 */       activeSet(!(GSliderVer.this.target.get() <= GSliderVer.this.target.min() && GSliderVer.this.target.get() >= GSliderVer.this.target.max()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 145 */       this.dragging &= MButt.LEFT.isDown();
/*     */       
/* 147 */       if (this.dragging) {
/* 148 */         double d = (CORE.getInput().getMouse().getCoo().y() - this.body.y1()) / this.body.height();
/* 149 */         int k = (int)CLAMP.d(d * GSliderVer.this.target.max(), GSliderVer.this.target.min(), GSliderVer.this.target.max());
/* 150 */         GSliderVer.this.target.set(k);
/*     */       } 
/* 152 */       return super.hover(mCoo);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 158 */       this.dragging = true;
/* 159 */       super.clickA();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderVer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */