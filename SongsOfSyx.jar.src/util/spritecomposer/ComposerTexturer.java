/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ComposerTexturer
/*     */   implements BODY_HOLDER
/*     */ {
/*  12 */   private final S source = new S();
/*     */   
/*     */   private final ComposerUtil c;
/*  15 */   public Rec body = new Rec(); private int destX; private int destY;
/*     */   
/*     */   ComposerTexturer(ComposerUtil c) {
/*  18 */     this.destX = 0;
/*  19 */     this.destY = 0;
/*  20 */     this.c = c;
/*     */   }
/*     */ 
/*     */   
/*     */   public SpriteData paste(int sourceX1, int sourceY1, int tilesX, int tilesY) {
/*  25 */     this.body.setWidth((tilesX * 16 + 12)).setHeight((tilesY * 16 + 12));
/*  26 */     this.body.moveX1Y1(sourceX1, sourceY1);
/*     */     
/*  28 */     int sx = sourceX1 + 6;
/*  29 */     int sy = sourceY1 + 6;
/*     */ 
/*     */     
/*  32 */     copy(sx, sy, 0, tilesX, 0, tilesY);
/*  33 */     past(1, tilesX + 1, 1, tilesY + 1);
/*     */ 
/*     */     
/*  36 */     copy(sx, sy, 0, tilesX, tilesY - 1, tilesY);
/*  37 */     past(1, tilesX + 1, 0, 1);
/*     */ 
/*     */     
/*  40 */     copy(sx, sy, 0, tilesX, 0, 1);
/*  41 */     past(1, tilesX + 1, tilesY + 1, tilesY + 2);
/*     */ 
/*     */     
/*  44 */     copy(sx, sy, tilesX - 1, tilesX, 0, tilesY);
/*  45 */     past(0, 1, 1, tilesY + 1);
/*     */ 
/*     */     
/*  48 */     copy(sx, sy, tilesX - 1, tilesX, tilesY - 1, tilesY);
/*  49 */     past(0, 1, 0, 1);
/*     */ 
/*     */ 
/*     */     
/*  53 */     copy(sx, sy, 0, 1, 0, tilesY);
/*  54 */     past(tilesX + 1, tilesX + 2, 1, tilesY + 1);
/*     */ 
/*     */     
/*  57 */     copy(sx, sy, 0, 1, tilesY - 1, tilesY);
/*  58 */     past(tilesX + 1, tilesX + 2, 0, 1);
/*     */ 
/*     */     
/*  61 */     copy(sx, sy, 0, 1, 0, 1);
/*  62 */     past(tilesX + 1, tilesX + 2, tilesY + 1, tilesY + 2);
/*     */ 
/*     */ 
/*     */     
/*  66 */     copy(sx, sy, tilesX - 1, tilesX, 0, 1);
/*  67 */     past(0, 1, tilesY + 1, tilesY + 2);
/*     */     
/*  69 */     SpriteData s = SpriteData.save(this.destX, this.destY, this.destX + 16 * (tilesX + 2), this.destY + 16 * (tilesY + 2), 24);
/*  70 */     this.destX += (tilesX + 2) * 16;
/*  71 */     if (this.destX + (tilesX + 2) * 16 >= Resources.dests.chunk.destWidth()) {
/*  72 */       this.destX = 0;
/*  73 */       this.destY += 160;
/*     */     } 
/*  75 */     return s;
/*     */   }
/*     */   
/*     */   private void copy(int sx, int sy, int tx1, int tx2, int ty1, int ty2) {
/*  79 */     this.source.x1 = sx + tx1 * 16;
/*  80 */     this.source.y1 = sy + ty1 * 16;
/*  81 */     this.source.width = (tx2 - tx1) * 16;
/*  82 */     this.source.height = (ty2 - ty1) * 16;
/*  83 */     this.c.copy(this.source);
/*     */   }
/*     */   
/*     */   private void past(int tx1, int tx2, int ty1, int ty2) {
/*  87 */     ComposerDests.DestChunk d = Resources.dests.chunk;
/*  88 */     d.rec.moveX1Y1((this.destX + tx1 * 16), (this.destY + ty1 * 16));
/*  89 */     d.rec.setDim(((tx2 - tx1) * 16), ((ty2 - ty1) * 16));
/*  90 */     this.c.paste(d);
/*     */   }
/*     */   
/*     */   private final class S extends ComposerSources.Source { private int x1;
/*     */     private int y1;
/*     */     private int width;
/*     */     private int height;
/*     */     
/*     */     public RECTANGLE body() {
/*  99 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 104 */       return this.y1;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 109 */       return this.x1;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 114 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     int height() {
/* 119 */       return this.height;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 125 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerTexturer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */