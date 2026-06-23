/*     */ package util.gui.table;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ public abstract class GStaples
/*     */   extends HOVERABLE.HoverableAbs {
/*     */   private final int amount;
/*  16 */   private int hoveredI = -1;
/*  17 */   private final ColorImp color = new ColorImp();
/*     */   
/*     */   private boolean negative;
/*     */   
/*     */   private boolean border = true;
/*     */   
/*     */   public GStaples(int amount) {
/*  24 */     this(amount, false);
/*     */   }
/*     */   private boolean backGround = true; private boolean normalize = true; private boolean normalizePlus = false;
/*     */   public GStaples(int amount, boolean negative) {
/*  28 */     this.amount = amount;
/*  29 */     this.negative = negative;
/*     */   }
/*     */   
/*     */   public void border(boolean border) {
/*  33 */     this.border = border;
/*     */   }
/*     */   
/*     */   public void background(boolean border) {
/*  37 */     this.backGround = border;
/*     */   }
/*     */   
/*     */   public void normalize(boolean n) {
/*  41 */     this.normalize = n;
/*     */   }
/*     */   
/*     */   public void normalizePlus(boolean n) {
/*  45 */     this.normalizePlus = n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  52 */     int w = sw();
/*  53 */     if (w < 3)
/*     */       return; 
/*  55 */     if (body().height() < 3) {
/*     */       return;
/*     */     }
/*     */     
/*  59 */     int x1 = body().x1() + (body().width() - this.amount * sw()) / 2;
/*  60 */     int y1 = body().y1();
/*  61 */     int y2 = body().y2();
/*     */     
/*  63 */     if (this.border) {
/*  64 */       GCOLOR.UI().border().render(r, x1 - 1, x1 + this.amount * sw() + 1, y1 - 1, y2 + 1);
/*     */     }
/*     */     
/*  67 */     double max = 0.0D;
/*  68 */     double min = 0.0D;
/*  69 */     double mid = 0.0D;
/*  70 */     if (this.negative) {
/*  71 */       min = -1.0D;
/*     */     }
/*     */     
/*  74 */     if (this.normalizePlus) {
/*  75 */       min = Double.MAX_VALUE;
/*  76 */       max = -1.7976931348623157E308D;
/*  77 */       for (int i = 0; i < this.amount; i++) {
/*  78 */         double v = getValue(i);
/*  79 */         max = Math.max(max, v);
/*  80 */         min = Math.min(min, v);
/*     */       } 
/*     */       
/*  83 */       if (max == 0.0D)
/*  84 */         max = 1.0D; 
/*  85 */     } else if (this.normalize) {
/*  86 */       min = Double.MAX_VALUE;
/*  87 */       max = -1.7976931348623157E308D;
/*  88 */       for (int i = 0; i < this.amount; i++) {
/*  89 */         double v = getValue(i);
/*  90 */         max = Math.max(max, v);
/*  91 */         min = Math.min(min, v);
/*     */       } 
/*  93 */       min /= 2.0D;
/*  94 */       if (max == 0.0D)
/*  95 */         max = 1.0D; 
/*     */     } else {
/*  97 */       max = 1.0D;
/*  98 */       min = 0.0D;
/*     */     } 
/*     */     
/* 101 */     if (this.negative) {
/* 102 */       int cy = body().cY();
/*     */       
/* 104 */       for (int i = 0; i < this.amount; i++) {
/* 105 */         int x = x1 + i * w;
/* 106 */         double v = getValue(i);
/* 107 */         setColorBg(this.color, i, v);
/* 108 */         if (this.backGround && (!isHovered || !hovered(i))) {
/* 109 */           this.color.render(r, x, x + w, y1, y2);
/*     */         }
/*     */         
/* 112 */         v = (mid + v - min) / (max - min);
/* 113 */         v = CLAMP.d(v, -1.0D, 1.0D);
/* 114 */         int h = (int)Math.ceil(Math.abs(v) * (body().height() / 2));
/* 115 */         if (h > 0) {
/*     */           
/* 117 */           setColor(this.color, i, v);
/* 118 */           if (isHovered && hovered(i)) {
/* 119 */             this.color.shadeSelf(1.5D);
/*     */           } else {
/* 121 */             this.color.shadeSelf(0.5D);
/*     */           } 
/* 123 */           if (v < 0.0D) {
/* 124 */             int y22 = cy + h;
/* 125 */             this.color.render(r, x, x + w, cy, y22);
/* 126 */             setColor(this.color, i, v);
/* 127 */             this.color.render(r, x + 1, x + w - 1, cy, y22 - 1);
/*     */           } else {
/* 129 */             int y11 = cy - h;
/* 130 */             this.color.render(r, x, x + w, y11, cy);
/* 131 */             setColor(this.color, i, v);
/* 132 */             this.color.render(r, x + 1, x + w - 1, y11 + 1, cy);
/*     */           } 
/*     */         } 
/*     */       } 
/* 136 */       this.color.set(GCOLOR.UI().border()).shadeSelf(0.75D);
/* 137 */       this.color.render(r, body().x1(), body().x2(), cy, cy + 1);
/*     */     } else {
/*     */       
/* 140 */       for (int i = 0; i < this.amount; i++) {
/* 141 */         int x = x1 + i * w;
/* 142 */         double v = getValue(i);
/* 143 */         setColorBg(this.color, i, v);
/* 144 */         if (this.backGround && (!isHovered || !hovered(i))) {
/* 145 */           this.color.render(r, x, x + w, y1, y2);
/*     */         }
/* 147 */         v = (mid + v - min) / (max - min);
/*     */         
/* 149 */         v = CLAMP.d(v, 0.0D, 1.0D);
/* 150 */         int h = (int)Math.ceil(v * body().height());
/* 151 */         if (h > 0) {
/* 152 */           int y11 = y2 - h;
/* 153 */           setColor(this.color, i, v);
/* 154 */           if (isHovered && hovered(i)) {
/* 155 */             this.color.shadeSelf(1.5D).render(r, x, x + w, y11, y2);
/*     */           } else {
/* 157 */             this.color.shadeSelf(0.5D).render(r, x, x + w, y11, y2);
/* 158 */           }  setColor(this.color, i, v);
/* 159 */           this.color.render(r, x + 1, x + w - 1, y11 + 1, y2);
/* 160 */           renderExtra(r, (COLOR)this.color, i, (isHovered && hovered(i)), v, x, x + w, y11, y2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract double getValue(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void hover(GBox paramGBox, int paramInt);
/*     */ 
/*     */   
/*     */   public void setHovered(int i) {
/* 180 */     this.hoveredI = i;
/* 181 */     hoveredSet((this.hoveredI >= 0));
/*     */   }
/*     */   
/*     */   public int hoverI() {
/* 185 */     return this.hoveredI;
/*     */   }
/*     */   
/*     */   protected boolean hovered(int ii) {
/* 189 */     return (ii == this.hoveredI);
/*     */   }
/*     */   
/*     */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 193 */     c.set((GCOLOR.UI()).SOSO.normal);
/*     */   }
/*     */   
/*     */   protected void setColorBg(ColorImp c, int stapleI, double value) {
/* 197 */     c.set(GCOLOR.UI().bg());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 202 */     if (super.hover(mCoo)) {
/* 203 */       int x1 = body().x1() + (body().width() - this.amount * sw()) / 2;
/* 204 */       int x = mCoo.x() - x1;
/* 205 */       this.hoveredI = CLAMP.i(x / sw(), -1, this.amount - 1);
/* 206 */       return true;
/*     */     } 
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 213 */     if (this.hoveredI != -1) {
/* 214 */       hover((GBox)text, this.hoveredI);
/*     */     }
/* 216 */     super.hoverInfoGet(text);
/*     */   }
/*     */   
/*     */   private int sw() {
/* 220 */     return body().width() / this.amount;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GStaples.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */