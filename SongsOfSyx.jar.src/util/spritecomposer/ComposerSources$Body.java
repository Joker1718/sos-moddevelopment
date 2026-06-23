/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Body
/*     */   implements BODY_HOLDER
/*     */ {
/* 149 */   private final Rec body = new Rec();
/* 150 */   private final Rec allBody = new Rec();
/*     */   private final int marginLeft;
/*     */   private final int marginTop;
/*     */   
/*     */   Body(int marginLeft, int marginTop) {
/* 155 */     this.marginLeft = marginLeft;
/* 156 */     this.marginTop = marginTop;
/*     */   }
/*     */   private int bodiesX; private int bodiesY;
/*     */   void init(int x, int y, int width, int height, int nrWidth, int nrHeight) {
/* 160 */     this.body.set(x, (x + width), y, (y + height));
/* 161 */     this.bodiesX = nrWidth;
/* 162 */     this.bodiesY = nrHeight;
/* 163 */     this.allBody.set(x, (x + this.body.width() * nrWidth), y, (y + this.body.height() * nrHeight));
/* 164 */     assert nrWidth > 0 && nrHeight > 0 && this.marginLeft >= 0 && this.marginTop >= 0 && x >= 0 && y >= 0 && width > 0 && 
/* 165 */       height > 0;
/*     */   }
/*     */   
/*     */   void set(int nr) {
/* 169 */     int x = nr % this.bodiesX;
/* 170 */     int y = nr / this.bodiesX;
/* 171 */     if (y >= this.bodiesY)
/* 172 */       throw new RuntimeException("cant set var higher"); 
/* 173 */     this.body.moveX1Y1((this.allBody.x1() + x * this.body.width()), (this.allBody.y1() + y * this.body.height()));
/*     */   }
/*     */   
/*     */   int getStartX() {
/* 177 */     return this.body.x1() + this.marginLeft;
/*     */   }
/*     */   
/*     */   int getStartY() {
/* 181 */     return this.body.y1() + this.marginTop;
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 186 */     return (RECTANGLE)this.allBody;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerSources$Body.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */