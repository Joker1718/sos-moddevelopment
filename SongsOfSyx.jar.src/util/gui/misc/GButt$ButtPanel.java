/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ButtPanel
/*     */   extends GButt
/*     */ {
/* 442 */   private final int M = 4;
/* 443 */   private COLOR color = COLOR.WHITE35;
/*     */   private SPRITE icon;
/* 445 */   private DIR align = DIR.C;
/*     */   
/*     */   public ButtPanel(CharSequence label) {
/* 448 */     this((UI.FONT()).H2.getText(label));
/*     */   }
/*     */ 
/*     */   
/*     */   public ButtPanel(CharSequence label, int width) {
/* 453 */     this((UI.FONT()).H2.getText(label));
/* 454 */     this.body.setWidth(width);
/*     */   }
/*     */ 
/*     */   
/*     */   public ButtPanel(SPRITE label) {
/* 459 */     super(label);
/* 460 */     if (label == null) {
/* 461 */       this.body.setDim(16.0D);
/*     */     } else {
/* 463 */       this.body.setDim((this.label.width() + 16), (this.label.height() + 8));
/*     */     } 
/*     */   }
/*     */   public ButtPanel setDim(int width, int height) {
/* 467 */     this.body.setDim(width, height);
/* 468 */     return this;
/*     */   }
/*     */   
/*     */   public ButtPanel setDim(int width) {
/* 472 */     this.body.setWidth(width);
/* 473 */     return this;
/*     */   }
/*     */   
/*     */   public ButtPanel pad(int x, int y) {
/* 477 */     this.body.incrW((x * 2));
/* 478 */     this.body.incrH((y * 2));
/* 479 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 485 */     renAction();
/* 486 */     COLOR border = GCOLOR.UI().border();
/* 487 */     border.render(r, (RECTANGLE)body());
/* 488 */     GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -1);
/*     */     
/* 490 */     if (isSelected) {
/* 491 */       COLOR.WHITE85.render(r, (RECTANGLE)this.body, -2);
/* 492 */     } else if (isHovered) {
/* 493 */       COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/*     */     } 
/* 495 */     GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -4);
/*     */     
/* 497 */     if (!isActive) {
/* 498 */       OPACITY.O0.bind();
/* 499 */     } else if (isHovered) {
/* 500 */       OPACITY.O100.bind();
/*     */     } else {
/* 502 */       OPACITY.O35.bind();
/*     */     } 
/*     */     
/* 505 */     this.color.render(r, (RECTANGLE)body(), -4);
/* 506 */     OPACITY.unbind();
/*     */ 
/*     */ 
/*     */     
/* 510 */     if (this.icon != null) {
/* 511 */       if (this.label == null) {
/* 512 */         this.icon.renderC(r, (RECTANGLE)this.body);
/*     */       } else {
/* 514 */         this.icon.renderC(r, body().x1() + this.icon.width() / 2 + 4, body().cY());
/*     */       } 
/*     */     }
/*     */     
/* 518 */     if (this.label instanceof Text) {
/* 519 */       (GCOLOR.T()).H1.bind();
/*     */       
/* 521 */       int ww = this.body.width();
/* 522 */       if (this.icon != null)
/* 523 */         ww -= 24 + this.icon.width(); 
/* 524 */       ((Text)this.label).setMultipleLines(false);
/* 525 */       ((Text)this.label).setMaxWidth(ww);
/*     */     }
/*     */     else {
/*     */       
/* 529 */       COLOR.WHITE100.bind();
/*     */     } 
/*     */     
/* 532 */     if (this.label != null) {
/* 533 */       if (this.icon != null) {
/* 534 */         this.label.renderC(r, body().x1() + this.icon.width() + 12 + this.label.width() / 2, body().cY());
/*     */       } else {
/* 536 */         int dx = this.align.x() * (body().width() - this.label.width() - 8) / 2;
/* 537 */         int dy = this.align.y() * (body().height() - this.label.height() - 8) / 2;
/* 538 */         this.label.renderC(r, this.body.cX() + dx, body().cY() + dy);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 543 */     COLOR.unbind();
/*     */     
/* 545 */     if (!isActive) {
/* 546 */       OPACITY.O50.bind();
/* 547 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, -2);
/* 548 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderBG(SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered, RECTANGLE body) {
/* 558 */     GCOLOR.UI().bg().render(r, body, -1);
/*     */     
/* 560 */     if (isSelected) {
/* 561 */       COLOR.WHITE85.render(r, body, -2);
/* 562 */     } else if (isHovered) {
/* 563 */       COLOR.WHITE50.render(r, body, -2);
/*     */     } else {
/* 565 */       COLOR.BLACK.render(r, body, -2);
/*     */     } 
/* 567 */     GCOLOR.UI().bg().render(r, body, -4);
/*     */     
/* 569 */     if (!isActive) {
/* 570 */       OPACITY.O0.bind();
/* 571 */     } else if (isHovered) {
/* 572 */       OPACITY.O100.bind();
/*     */     } else {
/* 574 */       OPACITY.O35.bind();
/*     */     } 
/*     */     
/* 577 */     COLOR.WHITE35.render(r, body, -5);
/* 578 */     OPACITY.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderBGMini(SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered, RECTANGLE body) {
/* 583 */     if (isSelected) {
/* 584 */       COLOR.WHITE85.render(r, body, 0);
/* 585 */     } else if (isHovered) {
/* 586 */       COLOR.WHITE50.render(r, body, 0);
/*     */     } else {
/* 588 */       COLOR.BLACK.render(r, body, 0);
/*     */     } 
/* 590 */     GCOLOR.UI().bg().render(r, body, -1);
/*     */     
/* 592 */     if (!isActive) {
/* 593 */       OPACITY.O0.bind();
/* 594 */     } else if (isHovered) {
/* 595 */       OPACITY.O100.bind();
/*     */     } else {
/* 597 */       OPACITY.O35.bind();
/*     */     } 
/*     */     
/* 600 */     COLOR.WHITE35.render(r, body, -2);
/* 601 */     OPACITY.unbind();
/*     */   }
/*     */   
/*     */   public static void renderFrame(SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered, RECTANGLE body) {
/* 605 */     COLOR border = GCOLOR.UI().border();
/* 606 */     COLOR.BLACK.renderFrame(r, body.x1() + 1, body.x2(), body.y1() + 1, body.y2(), 0, 1);
/* 607 */     border.renderFrame(r, body.x1(), body.x2() - 1, body.y1(), body.y2() - 1, 0, 1);
/*     */   }
/*     */   
/*     */   public static void renderFrame(SPRITE_RENDERER r, RECTANGLE body) {
/* 611 */     COLOR border = GCOLOR.UI().border();
/*     */     
/* 613 */     border.renderFrame(r, body.x1(), body.x2(), body.y1(), body.y2(), 0, 1);
/*     */   }
/*     */   
/*     */   public ButtPanel align(DIR d) {
/* 617 */     this.align = d;
/* 618 */     return this;
/*     */   }
/*     */   
/*     */   public ButtPanel bg(COLOR c) {
/* 622 */     this.color = c;
/* 623 */     return this;
/*     */   }
/*     */   
/*     */   public ButtPanel bgClear() {
/* 627 */     this.color = COLOR.WHITE35;
/* 628 */     return this;
/*     */   }
/*     */   
/*     */   public ButtPanel icon(SPRITE icon) {
/* 632 */     this.icon = icon;
/*     */     
/* 634 */     if (this.label == null) {
/* 635 */       if (body().width() < icon.width() + 8)
/* 636 */         body().setWidth((icon.width() + 8)); 
/* 637 */       if (body().height() < icon.height() + 8)
/* 638 */         this.body.setHeight((icon.height() + 8)); 
/*     */     } else {
/* 640 */       int w = icon.width() + 16 + this.label.width();
/* 641 */       if (body().width() < w)
/* 642 */         body().setWidth(w); 
/* 643 */       if (body().height() < icon.height() + 8) {
/* 644 */         this.body.setHeight((icon.height() + 8));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 649 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec body() {
/* 654 */     return this.body;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GButt$ButtPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */