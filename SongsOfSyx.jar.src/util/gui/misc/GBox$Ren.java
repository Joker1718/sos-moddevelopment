/*     */ package util.gui.misc;
/*     */ 
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Ren
/*     */ {
/*     */   private int x;
/*     */   private int y;
/*     */   private SPRITE renderable;
/*     */   private RENDEROBJ ren;
/*  89 */   private final ColorImp col = new ColorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int height() {
/*  96 */     if (this.renderable != null)
/*  97 */       return this.renderable.height(); 
/*  98 */     return this.ren.body().height();
/*     */   }
/*     */   
/*     */   private void init(SPRITE o, int fixed) {
/* 102 */     this.renderable = o;
/* 103 */     this.x = GBox.this.dx;
/* 104 */     this.y = GBox.this.dy;
/* 105 */     GBox.this.dx += fixed;
/* 106 */     if (o.height() > GBox.this.dHeight)
/* 107 */       GBox.this.dHeight = o.height(); 
/* 108 */     if (this.x + o.width() > GBox.this.width) {
/* 109 */       GBox.this.width = this.x + o.width();
/*     */     }
/* 111 */     this.col.set(COLOR.WHITE100);
/* 112 */     GBox.this.rensFreeI++;
/* 113 */     GBox.this.rens.add(this);
/* 114 */     this.ren = null;
/*     */   }
/*     */   
/*     */   private void init(RENDEROBJ o, int fixed) {
/* 118 */     this.renderable = null;
/* 119 */     this.ren = o;
/* 120 */     this.x = GBox.this.dx;
/* 121 */     this.y = GBox.this.dy;
/* 122 */     GBox.this.dx += fixed;
/* 123 */     if (o.body().height() > GBox.this.dHeight)
/* 124 */       GBox.this.dHeight = o.body().height(); 
/* 125 */     if (this.x + o.body().width() > GBox.this.width) {
/* 126 */       GBox.this.width = this.x + o.body().width();
/*     */     }
/* 128 */     GBox.this.rensFreeI++;
/* 129 */     GBox.this.rens.add(this);
/* 130 */     this.col.set(COLOR.WHITE100);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GBox$Ren.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */