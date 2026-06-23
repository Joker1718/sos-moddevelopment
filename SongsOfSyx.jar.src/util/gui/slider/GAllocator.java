/*     */ package util.gui.slider;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ public class GAllocator
/*     */   extends CLICKABLE.ClickableAbs {
/*  19 */   public static CharSequence ¤¤click = "(Hold {0} and click for full allocation.)";
/*     */   
/*     */   static {
/*  22 */     D.ts(GAllocator.class);
/*     */   }
/*     */   private final SPRITE minus;
/*     */   private final SPRITE plus;
/*     */   private final COLOR color;
/*     */   private final INT.INTE target;
/*  28 */   private byte hoverI = 0;
/*     */   private final int width;
/*     */   private SPRITE icon;
/*     */   
/*     */   public GAllocator(SPRITE minus, SPRITE plus, COLOR color, INT.INTE target, int width, int height) {
/*  33 */     this.minus = minus;
/*  34 */     this.plus = plus;
/*  35 */     this.color = color;
/*  36 */     this.target = target;
/*  37 */     this.width = width;
/*  38 */     this.body.setDim((width * target.max() + minus.width() + plus.width() + 4), height);
/*     */   }
/*     */   
/*     */   public GAllocator(COLOR color, INT.INTE target, int width, int height) {
/*  42 */     this((SPRITE)(SPRITES.icons()).s.minifier, (SPRITE)(SPRITES.icons()).s.magnifier, color, target, width, height);
/*     */   }
/*     */   
/*     */   public GAllocator(COLOR color, INT.INTE target, int width, int height, int mmax) {
/*  46 */     this((SPRITE)(SPRITES.icons()).s.minifier, (SPRITE)(SPRITES.icons()).s.magnifier, color, target, width, height);
/*  47 */     this.body.setDim((width * mmax + this.minus.width() + this.plus.width() + 4), height);
/*     */   }
/*     */   
/*     */   public GAllocator setIcon(SPRITE icon) {
/*  51 */     this.icon = icon;
/*  52 */     this.body.setDim((icon.width() + 8 + this.width * this.target.max() + this.minus.width() + this.plus.width() + 4), body().height());
/*  53 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/*  58 */     if (super.hover(mCoo)) {
/*  59 */       int ix = 0;
/*  60 */       if (this.icon != null) {
/*  61 */         ix = this.icon.width() + 4;
/*     */       }
/*  63 */       if (mCoo.x() <= body().x1() + ix + this.minus.width() && mCoo.x() > body().x1() + ix) {
/*  64 */         this.hoverI = -1;
/*  65 */       } else if (mCoo.x() >= body().x2() - this.plus.width()) {
/*  66 */         this.hoverI = 1;
/*     */       } else {
/*  68 */         this.hoverI = 0;
/*  69 */       }  return true;
/*     */     } 
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/*  76 */     if (!activeIs())
/*  77 */       return super.click(); 
/*  78 */     if (this.hoverI == 1 && this.target.get() < this.target.max()) {
/*  79 */       if ((KEYS.MAIN()).MOD.isPressed())
/*  80 */       { this.target.set(this.target.max()); }
/*     */       else
/*  82 */       { this.target.inc(1); } 
/*  83 */     } else if (this.hoverI == -1 && this.target.get() > this.target.min()) {
/*  84 */       if ((KEYS.MAIN()).MOD.isPressed()) {
/*  85 */         this.target.set(0);
/*     */       } else {
/*  87 */         this.target.inc(-1);
/*     */       } 
/*  89 */     }  return super.click();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  95 */     int ix = 0;
/*  96 */     if (this.icon != null) {
/*  97 */       this.icon.renderCY(r, body().x1(), body().cY());
/*  98 */       ix = this.icon.width() + 8;
/*     */     } 
/*     */     
/* 101 */     if (!activeIs() || this.target.get() <= this.target.min()) {
/* 102 */       (GCOLOR.T()).INACTIVE.bind();
/* 103 */     } else if (this.hoverI == -1) {
/* 104 */       (GCOLOR.T()).HOVERED.bind();
/*     */     } 
/*     */ 
/*     */     
/* 108 */     this.minus.renderCY(r, body().x1() + ix, body().cY());
/*     */     
/* 110 */     ColorImp.TMP.set(this.color).shadeSelf(0.5D);
/*     */     
/* 112 */     for (int i = 0; i < this.target.max(); i++) {
/* 113 */       int x1 = body().x1() + this.minus.width() + 2 + i * this.width + ix;
/* 114 */       ColorImp.TMP.render(r, x1, x1 + this.width - 2, body().y1(), body().y2());
/* 115 */       if (i < this.target.get()) {
/* 116 */         this.color.render(r, x1 + 1, x1 + this.width - 2, body().y1(), body().y2() - 1);
/*     */       }
/*     */     } 
/* 119 */     if (!activeIs() || this.target.get() >= this.target.max()) {
/* 120 */       (GCOLOR.T()).INACTIVE.bind();
/* 121 */     } else if (this.hoverI == 1) {
/* 122 */       (GCOLOR.T()).HOVERED.bind();
/*     */     } else {
/* 124 */       COLOR.unbind();
/*     */     } 
/* 126 */     this.plus.renderCY(r, body().x2() - this.plus.width(), body().cY());
/*     */     
/* 128 */     COLOR.unbind();
/*     */     
/* 130 */     this.hoverI = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 137 */     hov(text);
/* 138 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hov(GUI_BOX text) {
/* 143 */     Text t = text.text();
/* 144 */     t.add(¤¤click);
/* 145 */     t.insert(0, (KEYS.MAIN()).MOD.repr());
/* 146 */     text.add((SPRITE)t);
/* 147 */     text.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GAllocator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */