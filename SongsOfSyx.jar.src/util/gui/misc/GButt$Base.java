/*     */ package util.gui.misc;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public class Base
/*     */   extends GButt
/*     */ {
/*     */   protected final LIST<SPRITE> sprite;
/*  59 */   protected int labelXOff = 0;
/*  60 */   protected int labelYOff = 0;
/*     */   
/*     */   public Base(LIST<SPRITE> sprite, SPRITE label) {
/*  63 */     super(label);
/*     */     
/*  65 */     int w = ((SPRITE)sprite.get(0)).width();
/*  66 */     int h = ((SPRITE)sprite.get(0)).height();
/*     */     
/*  68 */     this.body.setWidth(((w > label.width()) ? w : label.width()));
/*  69 */     this.body.setHeight(((h > label.height()) ? h : label.height()));
/*  70 */     this.labelXOff = (w - label.width()) / 2;
/*  71 */     this.labelYOff = (h - label.height()) / 2;
/*  72 */     this.sprite = sprite;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  78 */     renAction();
/*  79 */     int x = this.body.x1();
/*  80 */     int y = this.body.y1();
/*     */     
/*  82 */     if (isSelected && isHovered) {
/*  83 */       ((SPRITE)this.sprite.get(3)).render(r, x, y);
/*  84 */       COLOR.WHITE200.bind();
/*     */     }
/*  86 */     else if (isSelected) {
/*  87 */       ((SPRITE)this.sprite.get(2)).render(r, x, y);
/*  88 */       COLOR.WHITE150.bind();
/*  89 */     } else if (isHovered) {
/*  90 */       ((SPRITE)this.sprite.get(1)).render(r, x, y);
/*  91 */       COLOR.WHITE150.bind();
/*  92 */     } else if (isActive) {
/*  93 */       ((SPRITE)this.sprite.get(0)).render(r, x, y);
/*  94 */       COLOR.WHITE100.bind();
/*     */     } else {
/*  96 */       ((SPRITE)this.sprite.get(0)).render(r, x, y);
/*  97 */       (GCOLOR.T()).INACTIVE.bind();
/*     */     } 
/*  99 */     this.label.render(r, x + this.labelXOff, y + this.labelYOff);
/* 100 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GButt$Base.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */