/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GButt
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*  31 */   private static String ¤¤on = "turn off";
/*  32 */   private static String ¤¤off = "turn on";
/*  33 */   private static String ¤¤select = "select";
/*     */   static {
/*  35 */     D.ts(GButt.class);
/*     */   }
/*     */   
/*     */   protected SPRITE label;
/*     */   
/*     */   protected GButt(SPRITE r) {
/*  41 */     this.label = r;
/*     */   }
/*     */ 
/*     */   
/*     */   public GButt replaceLabel(SPRITE label, DIR d) {
/*  46 */     this.label = label;
/*  47 */     return this;
/*     */   }
/*     */   
/*     */   public GButt hoverSet(INFO info) {
/*  51 */     hoverTitleSet(info.name);
/*  52 */     hoverInfoSet(info.desc);
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public static class Base
/*     */     extends GButt {
/*     */     protected final LIST<SPRITE> sprite;
/*  59 */     protected int labelXOff = 0;
/*  60 */     protected int labelYOff = 0;
/*     */     
/*     */     public Base(LIST<SPRITE> sprite, SPRITE label) {
/*  63 */       super(label);
/*     */       
/*  65 */       int w = ((SPRITE)sprite.get(0)).width();
/*  66 */       int h = ((SPRITE)sprite.get(0)).height();
/*     */       
/*  68 */       this.body.setWidth(((w > label.width()) ? w : label.width()));
/*  69 */       this.body.setHeight(((h > label.height()) ? h : label.height()));
/*  70 */       this.labelXOff = (w - label.width()) / 2;
/*  71 */       this.labelYOff = (h - label.height()) / 2;
/*  72 */       this.sprite = sprite;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  78 */       renAction();
/*  79 */       int x = this.body.x1();
/*  80 */       int y = this.body.y1();
/*     */       
/*  82 */       if (isSelected && isHovered) {
/*  83 */         ((SPRITE)this.sprite.get(3)).render(r, x, y);
/*  84 */         COLOR.WHITE200.bind();
/*     */       }
/*  86 */       else if (isSelected) {
/*  87 */         ((SPRITE)this.sprite.get(2)).render(r, x, y);
/*  88 */         COLOR.WHITE150.bind();
/*  89 */       } else if (isHovered) {
/*  90 */         ((SPRITE)this.sprite.get(1)).render(r, x, y);
/*  91 */         COLOR.WHITE150.bind();
/*  92 */       } else if (isActive) {
/*  93 */         ((SPRITE)this.sprite.get(0)).render(r, x, y);
/*  94 */         COLOR.WHITE100.bind();
/*     */       } else {
/*  96 */         ((SPRITE)this.sprite.get(0)).render(r, x, y);
/*  97 */         (GCOLOR.T()).INACTIVE.bind();
/*     */       } 
/*  99 */       this.label.render(r, x + this.labelXOff, y + this.labelYOff);
/* 100 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Panel
/*     */     extends GButt
/*     */   {
/*     */     public Panel(CharSequence label) {
/* 111 */       this((UI.FONT()).M.getText(label));
/*     */     }
/*     */     
/*     */     public Panel(SPRITE label) {
/* 115 */       super(label);
/* 116 */       this.body.setDim((label.width() + 6), (label.height() + 6));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Panel(SPRITE label, CharSequence hovInfo) {
/* 122 */       this(label);
/*     */       
/* 124 */       hoverInfoSet(hovInfo);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 130 */       renAction();
/*     */       
/* 132 */       if (isSelected || isHovered) {
/*     */         
/* 134 */         if (isSelected) {
/* 135 */           OPACITY.O25To50.bind();
/* 136 */           COLOR.WHITE100.render(r, (RECTANGLE)this.body);
/* 137 */         } else if (isHovered) {
/* 138 */           OPACITY.O25.bind();
/* 139 */           COLOR.WHITE100.render(r, (RECTANGLE)this.body);
/*     */         } 
/* 141 */         OPACITY.unbind();
/*     */       } 
/*     */       
/* 144 */       if (!isActive) {
/* 145 */         (GCOLOR.T()).INACTIVE.bind();
/* 146 */       } else if (isSelected && isHovered) {
/* 147 */         (GCOLOR.T()).HOVER_SELECTED.bind();
/* 148 */       } else if (isSelected) {
/* 149 */         (GCOLOR.T()).SELECTED.bind();
/* 150 */       } else if (isHovered) {
/* 151 */         (GCOLOR.T()).HOVERED.bind();
/*     */       } else {
/* 153 */         COLOR.WHITE100.bind();
/* 154 */       }  this.label.renderC(r, (RECTANGLE)body());
/* 155 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Glow
/*     */     extends GButt
/*     */   {
/*     */     protected final SPRITE bg;
/*     */ 
/*     */     
/* 168 */     private COLOR normal = COLOR.WHITE100;
/*     */     
/*     */     public Glow(SPRITE label) {
/* 171 */       this(label, (SPRITE)null);
/* 172 */       this.body.setHeight((this.body.height() + 6));
/* 173 */       this.body.incrW(4.0D);
/*     */     }
/*     */     
/*     */     public Glow(CharSequence text) {
/* 177 */       this((SPRITE)new Text((UI.FONT()).S, text));
/* 178 */       this.body.setHeight((this.body.height() + 6));
/*     */     }
/*     */     
/*     */     public Glow(SPRITE label, SPRITE bg) {
/* 182 */       super(label);
/* 183 */       this.body.setWidth(label.width());
/* 184 */       this.body.setHeight(label.height());
/* 185 */       if (bg != null) {
/* 186 */         if (bg.width() > this.body.width())
/* 187 */           this.body.setWidth(bg.width()); 
/* 188 */         if (bg.height() > this.body.height())
/* 189 */           this.body.setHeight(bg.height()); 
/*     */       } 
/* 191 */       this.bg = bg;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 197 */       renAction();
/* 198 */       int x = this.body.x1();
/* 199 */       int y = this.body.y1();
/* 200 */       if (this.bg != null) {
/* 201 */         this.bg.render(r, x, y);
/* 202 */         x += (this.body.width() - this.label.width()) / 2;
/*     */       } 
/*     */       
/* 205 */       if (!isActive) {
/* 206 */         (GCOLOR.T()).INACTIVE.bind();
/* 207 */       } else if (isSelected && isHovered) {
/* 208 */         (GCOLOR.T()).HOVER_SELECTED.bind();
/* 209 */       } else if (isSelected) {
/* 210 */         (GCOLOR.T()).SELECTED.bind();
/* 211 */       } else if (isHovered) {
/* 212 */         (GCOLOR.T()).HOVERED.bind();
/*     */       } else {
/* 214 */         this.normal.bind();
/* 215 */       }  y += (this.body.height() - this.label.height()) / 2;
/* 216 */       this.label.render(r, x, y);
/* 217 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public void color(COLOR color) {
/* 222 */       this.normal = color;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class BText
/*     */     extends Glow {
/*     */     private final Text text;
/*     */     private DIR d;
/*     */     
/*     */     public BText(Font f, int max, DIR d) {
/* 232 */       super((SPRITE)new Text(f, max), (SPRITE)null);
/* 233 */       this.text = (Text)this.label;
/* 234 */       this.d = d;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 240 */       renAction();
/*     */       
/* 242 */       update(this.text);
/* 243 */       this.text.adjustWidth();
/* 244 */       this.d.reposition(this.body, this.text.width(), this.text.height());
/*     */       
/* 246 */       super.render(r, ds, isActive, isSelected, isHovered);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract void update(Text param1Text);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Checkbox
/*     */     extends ButtPanel
/*     */   {
/*     */     public Checkbox() {
/* 258 */       this(16);
/* 259 */       icon(iconn());
/*     */     }
/*     */     
/*     */     public Checkbox(int dim) {
/* 263 */       super((SPRITE)null);
/* 264 */       icon(iconn());
/*     */     }
/*     */     
/*     */     public Checkbox(CharSequence label) {
/* 268 */       super((UI.FONT()).H2.getText(label));
/* 269 */       icon(iconn());
/*     */     }
/*     */     
/*     */     public Checkbox(SPRITE label) {
/* 273 */       super(label);
/* 274 */       icon(iconn());
/*     */     }
/*     */     
/*     */     private SPRITE iconn() {
/* 278 */       return (SPRITE)new SPRITE.Imp(16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 282 */             if (GButt.Checkbox.this.selectedIs()) {
/* 283 */               (GCOLOR.UI()).GOOD.hovered.bind();
/* 284 */               (UI.icons()).s.allRight.render(r, X1, X2, Y1, Y2);
/*     */             } else {
/* 286 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 287 */               (UI.icons()).s.cancel.render(r, X1, X2, Y1, Y2);
/*     */             } 
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 297 */       if (this.hoverTitle != null)
/* 298 */         text.title(this.hoverTitle); 
/* 299 */       if (this.hoverInfo != null) {
/* 300 */         text.text(this.hoverInfo);
/*     */       } else {
/* 302 */         text.text(selectedIs() ? GButt.¤¤on : GButt.¤¤off);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CheckboxSelect
/*     */     extends ButtPanel
/*     */   {
/*     */     public CheckboxSelect() {
/* 312 */       this(16);
/* 313 */       icon(iconn());
/*     */     }
/*     */     
/*     */     public CheckboxSelect(int dim) {
/* 317 */       super((SPRITE)null);
/* 318 */       icon(iconn());
/*     */     }
/*     */     
/*     */     public CheckboxSelect(CharSequence label) {
/* 322 */       super((UI.FONT()).H2.getText(label));
/* 323 */       icon(iconn());
/*     */     }
/*     */     
/*     */     public CheckboxSelect(SPRITE label) {
/* 327 */       super(label);
/* 328 */       icon(iconn());
/*     */     }
/*     */     
/*     */     private SPRITE iconn() {
/* 332 */       return (SPRITE)new SPRITE.Imp(16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 336 */             if (GButt.CheckboxSelect.this.selectedIs()) {
/* 337 */               (GCOLOR.UI()).GOOD.hovered.bind();
/* 338 */               (UI.icons()).s.dot.render(r, X1, X2, Y1, Y2);
/*     */             } 
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 347 */       if (this.hoverTitle != null)
/* 348 */         text.title(this.hoverTitle); 
/* 349 */       if (this.hoverInfo != null) {
/* 350 */         text.text(this.hoverInfo);
/*     */       } else {
/* 352 */         text.text(GButt.¤¤select);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BStat2
/*     */     extends GButt
/*     */   {
/*     */     private final GStat stat;
/* 362 */     private COLOR color = COLOR.WHITE25;
/*     */     
/*     */     public BStat2(SPRITE icon, GStat stat) {
/* 365 */       super(icon);
/* 366 */       this.stat = stat;
/* 367 */       this.body.setWidth((icon.width() + stat.height() * 4));
/* 368 */       this.body.setHeight((icon.height() + 8));
/*     */     }
/*     */     
/*     */     public BStat2(CharSequence title, GStat stat) {
/* 372 */       super((SPRITE)(new GText((UI.FONT()).S, title)).lablify());
/* 373 */       this.stat = stat;
/* 374 */       this.body.setWidth((this.label.width() + 8 + stat.height() * 4));
/* 375 */       this.body.setHeight((this.label.height() + stat.height() + 8));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 381 */       renAction();
/* 382 */       GCOLOR.UI().border().render(r, (RECTANGLE)body());
/* 383 */       GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -3);
/*     */       
/* 385 */       if (isSelected) {
/* 386 */         COLOR.WHITE85.render(r, (RECTANGLE)this.body, -2);
/* 387 */       } else if (isHovered) {
/* 388 */         COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/*     */       } 
/* 390 */       if (isHovered) {
/* 391 */         OPACITY.O100.bind();
/* 392 */       } else if (isActive) {
/* 393 */         OPACITY.O50.bind();
/*     */       } else {
/* 395 */         OPACITY.O012.bind();
/*     */       } 
/*     */       
/* 398 */       if (isHovered || isSelected) {
/* 399 */         OPACITY.O100.bind();
/* 400 */       } else if (isActive) {
/* 401 */         OPACITY.O50.bind();
/*     */       } else {
/* 403 */         OPACITY.O012.bind();
/*     */       } 
/* 405 */       this.color.render(r, (RECTANGLE)body(), -4);
/* 406 */       OPACITY.unbind();
/* 407 */       this.stat.adjust();
/* 408 */       this.label.renderCY(r, body().x1() + 4, this.body.cY());
/* 409 */       if (this.label instanceof GText) {
/*     */         
/* 411 */         this.stat.renderCY(r, body().x1() + 4 + this.label.width() + 2, body().cY());
/*     */       } else {
/* 413 */         this.stat.renderCY(r, body().x1() + 4 + this.label.width() + 2, body().cY());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 421 */       this.stat.hoverInfoGet((GBox)text);
/* 422 */       super.hoverInfoGet(text);
/*     */     }
/*     */     
/*     */     public BStat2 bg(COLOR c) {
/* 426 */       this.color = c;
/* 427 */       return this;
/*     */     }
/*     */     
/*     */     public void bgClear() {
/* 431 */       this.color = COLOR.WHITE25;
/*     */     }
/*     */     
/*     */     public BStat2 setWidth(int width) {
/* 435 */       this.body.setWidth(width);
/* 436 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ButtPanel
/*     */     extends GButt {
/* 442 */     private final int M = 4;
/* 443 */     private COLOR color = COLOR.WHITE35;
/*     */     private SPRITE icon;
/* 445 */     private DIR align = DIR.C;
/*     */     
/*     */     public ButtPanel(CharSequence label) {
/* 448 */       this((UI.FONT()).H2.getText(label));
/*     */     }
/*     */ 
/*     */     
/*     */     public ButtPanel(CharSequence label, int width) {
/* 453 */       this((UI.FONT()).H2.getText(label));
/* 454 */       this.body.setWidth(width);
/*     */     }
/*     */ 
/*     */     
/*     */     public ButtPanel(SPRITE label) {
/* 459 */       super(label);
/* 460 */       if (label == null) {
/* 461 */         this.body.setDim(16.0D);
/*     */       } else {
/* 463 */         this.body.setDim((this.label.width() + 16), (this.label.height() + 8));
/*     */       } 
/*     */     }
/*     */     public ButtPanel setDim(int width, int height) {
/* 467 */       this.body.setDim(width, height);
/* 468 */       return this;
/*     */     }
/*     */     
/*     */     public ButtPanel setDim(int width) {
/* 472 */       this.body.setWidth(width);
/* 473 */       return this;
/*     */     }
/*     */     
/*     */     public ButtPanel pad(int x, int y) {
/* 477 */       this.body.incrW((x * 2));
/* 478 */       this.body.incrH((y * 2));
/* 479 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 485 */       renAction();
/* 486 */       COLOR border = GCOLOR.UI().border();
/* 487 */       border.render(r, (RECTANGLE)body());
/* 488 */       GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -1);
/*     */       
/* 490 */       if (isSelected) {
/* 491 */         COLOR.WHITE85.render(r, (RECTANGLE)this.body, -2);
/* 492 */       } else if (isHovered) {
/* 493 */         COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/*     */       } 
/* 495 */       GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -4);
/*     */       
/* 497 */       if (!isActive) {
/* 498 */         OPACITY.O0.bind();
/* 499 */       } else if (isHovered) {
/* 500 */         OPACITY.O100.bind();
/*     */       } else {
/* 502 */         OPACITY.O35.bind();
/*     */       } 
/*     */       
/* 505 */       this.color.render(r, (RECTANGLE)body(), -4);
/* 506 */       OPACITY.unbind();
/*     */ 
/*     */ 
/*     */       
/* 510 */       if (this.icon != null) {
/* 511 */         if (this.label == null) {
/* 512 */           this.icon.renderC(r, (RECTANGLE)this.body);
/*     */         } else {
/* 514 */           this.icon.renderC(r, body().x1() + this.icon.width() / 2 + 4, body().cY());
/*     */         } 
/*     */       }
/*     */       
/* 518 */       if (this.label instanceof Text) {
/* 519 */         (GCOLOR.T()).H1.bind();
/*     */         
/* 521 */         int ww = this.body.width();
/* 522 */         if (this.icon != null)
/* 523 */           ww -= 24 + this.icon.width(); 
/* 524 */         ((Text)this.label).setMultipleLines(false);
/* 525 */         ((Text)this.label).setMaxWidth(ww);
/*     */       }
/*     */       else {
/*     */         
/* 529 */         COLOR.WHITE100.bind();
/*     */       } 
/*     */       
/* 532 */       if (this.label != null) {
/* 533 */         if (this.icon != null) {
/* 534 */           this.label.renderC(r, body().x1() + this.icon.width() + 12 + this.label.width() / 2, body().cY());
/*     */         } else {
/* 536 */           int dx = this.align.x() * (body().width() - this.label.width() - 8) / 2;
/* 537 */           int dy = this.align.y() * (body().height() - this.label.height() - 8) / 2;
/* 538 */           this.label.renderC(r, this.body.cX() + dx, body().cY() + dy);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 543 */       COLOR.unbind();
/*     */       
/* 545 */       if (!isActive) {
/* 546 */         OPACITY.O50.bind();
/* 547 */         COLOR.BLACK.render(r, (RECTANGLE)this.body, -2);
/* 548 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static void renderBG(SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered, RECTANGLE body) {
/* 558 */       GCOLOR.UI().bg().render(r, body, -1);
/*     */       
/* 560 */       if (isSelected) {
/* 561 */         COLOR.WHITE85.render(r, body, -2);
/* 562 */       } else if (isHovered) {
/* 563 */         COLOR.WHITE50.render(r, body, -2);
/*     */       } else {
/* 565 */         COLOR.BLACK.render(r, body, -2);
/*     */       } 
/* 567 */       GCOLOR.UI().bg().render(r, body, -4);
/*     */       
/* 569 */       if (!isActive) {
/* 570 */         OPACITY.O0.bind();
/* 571 */       } else if (isHovered) {
/* 572 */         OPACITY.O100.bind();
/*     */       } else {
/* 574 */         OPACITY.O35.bind();
/*     */       } 
/*     */       
/* 577 */       COLOR.WHITE35.render(r, body, -5);
/* 578 */       OPACITY.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public static void renderBGMini(SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered, RECTANGLE body) {
/* 583 */       if (isSelected) {
/* 584 */         COLOR.WHITE85.render(r, body, 0);
/* 585 */       } else if (isHovered) {
/* 586 */         COLOR.WHITE50.render(r, body, 0);
/*     */       } else {
/* 588 */         COLOR.BLACK.render(r, body, 0);
/*     */       } 
/* 590 */       GCOLOR.UI().bg().render(r, body, -1);
/*     */       
/* 592 */       if (!isActive) {
/* 593 */         OPACITY.O0.bind();
/* 594 */       } else if (isHovered) {
/* 595 */         OPACITY.O100.bind();
/*     */       } else {
/* 597 */         OPACITY.O35.bind();
/*     */       } 
/*     */       
/* 600 */       COLOR.WHITE35.render(r, body, -2);
/* 601 */       OPACITY.unbind();
/*     */     }
/*     */     
/*     */     public static void renderFrame(SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered, RECTANGLE body) {
/* 605 */       COLOR border = GCOLOR.UI().border();
/* 606 */       COLOR.BLACK.renderFrame(r, body.x1() + 1, body.x2(), body.y1() + 1, body.y2(), 0, 1);
/* 607 */       border.renderFrame(r, body.x1(), body.x2() - 1, body.y1(), body.y2() - 1, 0, 1);
/*     */     }
/*     */     
/*     */     public static void renderFrame(SPRITE_RENDERER r, RECTANGLE body) {
/* 611 */       COLOR border = GCOLOR.UI().border();
/*     */       
/* 613 */       border.renderFrame(r, body.x1(), body.x2(), body.y1(), body.y2(), 0, 1);
/*     */     }
/*     */     
/*     */     public ButtPanel align(DIR d) {
/* 617 */       this.align = d;
/* 618 */       return this;
/*     */     }
/*     */     
/*     */     public ButtPanel bg(COLOR c) {
/* 622 */       this.color = c;
/* 623 */       return this;
/*     */     }
/*     */     
/*     */     public ButtPanel bgClear() {
/* 627 */       this.color = COLOR.WHITE35;
/* 628 */       return this;
/*     */     }
/*     */     
/*     */     public ButtPanel icon(SPRITE icon) {
/* 632 */       this.icon = icon;
/*     */       
/* 634 */       if (this.label == null) {
/* 635 */         if (body().width() < icon.width() + 8)
/* 636 */           body().setWidth((icon.width() + 8)); 
/* 637 */         if (body().height() < icon.height() + 8)
/* 638 */           this.body.setHeight((icon.height() + 8)); 
/*     */       } else {
/* 640 */         int w = icon.width() + 16 + this.label.width();
/* 641 */         if (body().width() < w)
/* 642 */           body().setWidth(w); 
/* 643 */         if (body().height() < icon.height() + 8) {
/* 644 */           this.body.setHeight((icon.height() + 8));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 649 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Rec body() {
/* 654 */       return this.body;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BSection
/*     */     extends GuiSection {
/*     */     private boolean selectedIs;
/*     */     private boolean link = false;
/*     */     public static final int M = 2;
/* 663 */     private CharSequence hov = null;
/*     */ 
/*     */     
/*     */     public BSection(int width, int height) {
/* 667 */       body().setWidth(width).setHeight(height);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BSection setAsLink() {
/* 675 */       this.link = true;
/* 676 */       return this;
/*     */     }
/*     */     
/*     */     public void pad() {
/* 680 */       pad(4);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 686 */       renAction();
/* 687 */       if (visableIs()) {
/*     */         
/* 689 */         renderBG(r, (RECTANGLE)body(), activeIs(), hoveredIs(), selectedIs());
/*     */         
/* 691 */         boolean hov = hoveredIs();
/* 692 */         super.render(r, ds);
/*     */         
/* 694 */         if (!activeIs()) {
/* 695 */           OPACITY.O25.bind();
/* 696 */           COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 697 */           OPACITY.unbind();
/* 698 */         } else if (hov && this.link) {
/* 699 */           (SPRITES.icons()).m.arrow_right.render(r, body().x2() - 24 - 6, body().y1());
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static void renderBG(SPRITE_RENDERER r, RECTANGLE body, boolean isActive, boolean isHovered, boolean isSelected) {
/* 710 */       GButt.ButtPanel.renderFrame(r, body);
/* 711 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, body);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void renAction() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public GuiSection selectedSet(boolean yes) {
/* 722 */       this.selectedIs = yes;
/* 723 */       return super.selectedSet(yes);
/*     */     }
/*     */     
/*     */     public void selectOnlythis(boolean yes) {
/* 727 */       this.selectedIs = yes;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean selectedIs() {
/* 732 */       return this.selectedIs;
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiSection hoverInfoSet(CharSequence s) {
/* 737 */       this.hov = s;
/* 738 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 743 */       if (this.hov != null)
/* 744 */         text.text(this.hov); 
/* 745 */       super.hoverInfoGet(text);
/*     */     }
/*     */     
/*     */     public BSection() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */