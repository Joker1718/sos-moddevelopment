/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ public class GText extends Text {
/*  14 */   private ColorImp color = new ColorImp((GCOLOR.T()).NORMAL);
/*     */   
/*     */   public GText(Font f, CharSequence text) {
/*  17 */     super(f, text);
/*     */   }
/*     */   
/*     */   public GText(Font f, int length) {
/*  21 */     super(f, length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  26 */     this.color.bind();
/*  27 */     super.render(r, X1, X1 + this.maxWidth, Y1, Y2);
/*  28 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   public COLOR color() {
/*  32 */     return (COLOR)this.color;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText clear() {
/*  37 */     super.clear();
/*  38 */     return this;
/*     */   }
/*     */   
/*     */   public GText color(COLOR c) {
/*  42 */     this.color.set(c);
/*  43 */     return this;
/*     */   }
/*     */   
/*     */   public GText lablify() {
/*  47 */     this.color.set((GCOLOR.T()).H1);
/*  48 */     return this;
/*     */   }
/*     */   
/*     */   public GText lablifySub() {
/*  52 */     this.color.set((GCOLOR.T()).H2);
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public GText normalify() {
/*  57 */     this.color.set((GCOLOR.T()).NORMAL);
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public GText normalify2() {
/*  62 */     this.color.set((GCOLOR.T()).NORMAL2);
/*  63 */     return this;
/*     */   }
/*     */   
/*     */   public GText selectify() {
/*  67 */     this.color.set((GCOLOR.T()).HOVER_SELECTED);
/*  68 */     return this;
/*     */   }
/*     */   
/*     */   public GText hoverify() {
/*  72 */     this.color.set((GCOLOR.T()).HOVERED);
/*  73 */     return this;
/*     */   }
/*     */   
/*     */   public GText clickify() {
/*  77 */     this.color.set((GCOLOR.T()).CLICKABLE);
/*  78 */     return this;
/*     */   }
/*     */   
/*     */   public GText errorify() {
/*  82 */     this.color.set((GCOLOR.T()).ERROR);
/*  83 */     return this;
/*     */   }
/*     */   
/*     */   public GText warnify() {
/*  87 */     this.color.set((GCOLOR.T()).WARNING);
/*  88 */     return this;
/*     */   }
/*     */   
/*     */   public GText decrease() {
/*  92 */     setFont((UI.FONT()).S);
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public GText increase() {
/*  97 */     setFont((UI.FONT()).M);
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GText setMaxWidth(int max) {
/* 105 */     super.setMaxWidth(max);
/* 106 */     return this;
/*     */   }
/*     */   
/*     */   public final GTextR r(DIR alignment) {
/* 110 */     return new GTextR(this, alignment);
/*     */   }
/*     */ 
/*     */   
/*     */   public GText toCamel() {
/* 115 */     super.toCamel();
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText toLower() {
/* 121 */     super.toLower();
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public GText toUpper() {
/* 127 */     super.toUpper();
/* 128 */     adjustWidth();
/* 129 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GText.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */