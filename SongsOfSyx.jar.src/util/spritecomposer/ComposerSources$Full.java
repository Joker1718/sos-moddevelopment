/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Full
/*     */   extends ComposerSources.Imp
/*     */ {
/* 376 */   private int tilesX = 8;
/*     */   
/*     */   private final int m;
/*     */   
/*     */   private int tileStart;
/*     */   
/*     */   private int tileEnd;
/*     */   
/*     */   private int tileCurrent;
/* 385 */   private int size = 0; private int offX; private int offY; private int width; private int tilesY; private final ComposerSources.Body body;
/*     */   
/*     */   private Full(int m) {
/* 388 */     this.m = m;
/* 389 */     this.body = new ComposerSources.Body(m, m);
/*     */   }
/*     */   
/*     */   private void setSize(int size) {
/* 393 */     this.size = size;
/* 394 */     this.body.init(0, 0, this.width, this.m * 2, 1, 1);
/*     */   }
/*     */   
/*     */   public Full init(int x, int y, int width, int height, int tilesX, int tilesY, ComposerDests.Tile dest) {
/* 398 */     setSize(dest.size());
/* 399 */     this.tilesX = tilesX;
/* 400 */     this.width = this.m * 2 + tilesX * this.size;
/* 401 */     this.body.init(x, y, this.width, tilesY * this.size + 2 * this.m, width, height);
/* 402 */     setVar(0);
/* 403 */     setSkip(0, tilesY * tilesX);
/* 404 */     this.tilesY = tilesY;
/* 405 */     setDest(dest);
/* 406 */     this.tileCurrent = 0;
/* 407 */     this.tileStart = 0;
/* 408 */     this.tileEnd = tilesX * tilesY;
/* 409 */     calc();
/* 410 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Full setSkip(int maxAmount, int skipfirst) {
/* 415 */     this.tileStart = skipfirst;
/* 416 */     this.tileEnd = this.tileStart + maxAmount;
/* 417 */     assert this.tileEnd <= this.tilesX * this.tilesY && this.tileEnd > this.tileStart;
/* 418 */     this.tileCurrent = this.tileStart;
/* 419 */     calc();
/* 420 */     return this;
/*     */   }
/*     */   
/*     */   public Full setNextSingle() {
/* 424 */     setSkip(1, this.tileStart + 1);
/* 425 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Full setVar(int var) {
/* 430 */     this.body.set(var);
/* 431 */     calc();
/* 432 */     return this;
/*     */   }
/*     */   
/*     */   private void calc() {
/* 436 */     this.offX = this.tileCurrent % this.tilesX;
/* 437 */     this.offY = this.tileCurrent / this.tilesX;
/* 438 */     this.offX *= this.size;
/* 439 */     this.offY *= this.size;
/* 440 */     this.offX += this.body.getStartX();
/* 441 */     this.offY += this.body.getStartY();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean next() {
/* 447 */     this.tileCurrent++;
/*     */     
/* 449 */     if (this.tileCurrent >= this.tileEnd) {
/* 450 */       this.tileCurrent = this.tileStart;
/* 451 */       calc();
/* 452 */       return true;
/*     */     } 
/* 454 */     calc();
/* 455 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 460 */     return this.body.body();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void setRot(int rot) {}
/*     */ 
/*     */ 
/*     */   
/*     */   int height() {
/* 470 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   int width() {
/* 475 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   int x1() {
/* 480 */     return this.offX;
/*     */   }
/*     */ 
/*     */   
/*     */   int y1() {
/* 485 */     return this.offY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerSources$Full.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */