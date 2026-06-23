/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.gui.common.TITLEABLE;
/*     */ 
/*     */ public abstract class GStat implements TITLEABLE {
/*     */   protected final GText statText;
/*     */   private boolean bg = false;
/*     */   
/*     */   public GStat() {
/*  20 */     this(64);
/*     */   }
/*     */   
/*     */   public GStat(Font f) {
/*  24 */     this(new GText(f, 64));
/*     */   }
/*     */   
/*     */   public GStat(int size) {
/*  28 */     this(new GText((UI.FONT()).S, size));
/*     */   }
/*     */   
/*     */   public GStat increase() {
/*  32 */     this.statText.setFont((UI.FONT()).M);
/*  33 */     return this;
/*     */   }
/*     */   
/*     */   public GStat decrease() {
/*  37 */     this.statText.setFont((UI.FONT()).S);
/*  38 */     return this;
/*     */   }
/*     */   
/*     */   public GStat(GText text) {
/*  42 */     this.statText = text;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/*  47 */     return this.statText.width();
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/*  52 */     return this.statText.height();
/*     */   }
/*     */   
/*     */   public abstract void update(GText paramGText);
/*     */   
/*     */   public GStat bg() {
/*  58 */     this.bg = true;
/*  59 */     return this;
/*     */   }
/*     */   
/*     */   public void adjust() {
/*  63 */     this.statText.clear();
/*  64 */     update(this.statText);
/*  65 */     this.statText.adjustWidth();
/*     */   }
/*     */   
/*     */   public GStat setFont(Font f) {
/*  69 */     this.statText.setFont(f);
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  77 */     adjust();
/*  78 */     if (this.bg) {
/*  79 */       OPACITY.O50.bind();
/*  80 */       COLOR.BLACK.render(r, X1 - 1, X2 + 1, Y1 - 1, Y2 + 1);
/*  81 */       OPACITY.unbind();
/*     */     } 
/*  83 */     this.statText.render(r, X1, X1 + this.statText.width(), Y1, Y2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/*  89 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public final HOVERABLE r(DIR alignment) {
/*  93 */     HOV h = new HOV();
/*  94 */     h.setSprite((SPRITE)this);
/*  95 */     h.setAlign(alignment);
/*  96 */     return (HOVERABLE)h;
/*     */   }
/*     */   
/*     */   public final HOVERABLE r() {
/* 100 */     return r(DIR.NW);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class HOV
/*     */     extends HOVERABLE.Sprite
/*     */   {
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 170 */       ((GStat)this.sprite).adjust();
/* 171 */       super.render(r, ds, isHovered);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 176 */       ((GStat)this.sprite).hoverInfoGet((GBox)text);
/* 177 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GStat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */