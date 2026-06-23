/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Source
/*     */   extends ComposerSources.Source
/*     */ {
/* 225 */   private final Rec body = new Rec();
/*     */   
/*     */   private int dim;
/*     */   
/*     */   private final int height;
/*     */   
/*     */   private int width;
/*     */   
/*     */   Source(SnakeImage im) {
/* 234 */     this.im = im;
/* 235 */     this.dim = im.width / 128 - 2;
/* 236 */     this.height = this.dim;
/*     */   }
/*     */   private int pixelX1; private int pixelY1; private final SnakeImage im; private int hh;
/*     */   
/*     */   public RECTANGLE body() {
/* 241 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   int height() {
/* 246 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   int width() {
/* 251 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   int x1() {
/* 256 */     return this.pixelX1;
/*     */   }
/*     */ 
/*     */   
/*     */   int y1() {
/* 261 */     return this.pixelY1;
/*     */   }
/*     */ 
/*     */   
/*     */   Source set(int cI) {
/* 266 */     this.pixelX1 = cI % 64 * (this.dim + 2) + 1;
/* 267 */     this.pixelY1 = cI / 64 * (this.dim + 2) + 1;
/* 268 */     this.width = this.dim;
/*     */     
/*     */     int x;
/*     */     
/* 272 */     label28: for (x = this.dim - 1; x >= 0; x--) {
/* 273 */       for (int i = 0; i < this.dim; i++) {
/* 274 */         if (this.im.rgb.get(this.pixelX1 + x, this.pixelY1 + i) != 0) {
/* 275 */           this.width = x + 1;
/*     */           
/*     */           break label28;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*     */     int y;
/*     */     
/* 284 */     label29: for (y = this.dim - 1; y > 0; y--) {
/* 285 */       for (int i = 0; i < this.dim; i++) {
/* 286 */         if (this.im.rgb.get(this.pixelX1 + i, this.pixelY1 + y) != 0) {
/* 287 */           this.hh = y;
/*     */ 
/*     */           
/*     */           break label29;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 296 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerFonter$Source.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */