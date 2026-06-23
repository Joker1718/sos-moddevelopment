/*     */ package world.overlay;
/*     */ 
/*     */ import init.constant.C;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import world.WORLD;
/*     */ 
/*     */ final class Edger
/*     */ {
/*     */   private final byte[][] edgeH;
/*     */   private final byte[][] edgeV;
/*     */   private final TILE_SHEET s;
/*     */   
/*     */   public Edger(int width, int height) {
/*  18 */     this.s = (WORLD.sprites()).edge;
/*  19 */     this.edgeH = new byte[2][width];
/*  20 */     this.edgeV = new byte[2][height - 2];
/*     */     
/*  22 */     this.edgeH[0][0] = 0;
/*  23 */     this.edgeH[0][width - 1] = 1;
/*  24 */     this.edgeH[1][0] = 2;
/*  25 */     this.edgeH[1][width - 1] = 3;
/*     */     
/*  27 */     for (int x = 1; x < width - 1; x++) {
/*  28 */       this.edgeH[0][x] = (byte)(20 + RND.rInt(8));
/*  29 */       this.edgeH[1][x] = (byte)(28 + RND.rInt(8));
/*     */     } 
/*  31 */     for (int y = 0; y < height - 2; y++) {
/*  32 */       this.edgeV[0][y] = (byte)(4 + RND.rInt(8));
/*  33 */       this.edgeV[1][y] = (byte)(12 + RND.rInt(8));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, RenderData rd, int zoomout) {
/*  39 */     int tx1 = rd.tx1();
/*  40 */     int tx2 = rd.tx2();
/*  41 */     int ty1 = rd.ty1();
/*  42 */     int ty2 = rd.ty2();
/*  43 */     int offX = rd.x1();
/*  44 */     int offY = rd.y1();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     int tileSize = 64;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     if (ty1 == 0) {
/*  56 */       int tmpX = offX;
/*  57 */       int tmpY = offY;
/*  58 */       for (int x = tx1; x <= tx2; x++) {
/*  59 */         this.s.render(r, this.edgeH[0][x], tmpX, tmpY);
/*  60 */         tmpX += tileSize;
/*     */       } 
/*     */     } 
/*  63 */     if (ty2 == (this.edgeV[0]).length + 1) {
/*  64 */       int tmpX = offX;
/*  65 */       int tmpY = (short)(offY + (ty2 - ty1) * tileSize);
/*  66 */       for (int x = tx1; x <= tx2; x++) {
/*  67 */         this.s.render(r, this.edgeH[1][x], tmpX, tmpY);
/*  68 */         tmpX += tileSize;
/*     */       } 
/*     */     } 
/*  71 */     if (tx1 == 0) {
/*  72 */       int tmpX = offX;
/*  73 */       int tmpY = offY;
/*  74 */       for (int y = ty1; y <= ty2; y++) {
/*  75 */         if (y > 0 && y <= (this.edgeV[0]).length) {
/*  76 */           this.s.render(r, this.edgeV[0][y - 1], tmpX, tmpY);
/*     */         }
/*  78 */         tmpY += tileSize;
/*     */       } 
/*     */     } 
/*  81 */     if (tx2 == (this.edgeH[0]).length - 1) {
/*  82 */       int tmpX = (short)(offX + (tx2 - tx1) * tileSize);
/*  83 */       int tmpY = offY;
/*  84 */       for (int y = ty1; y <= ty2; y++) {
/*  85 */         if (y > 0 && y <= (this.edgeV[0]).length) {
/*  86 */           this.s.render(r, this.edgeV[1][y - 1], tmpX, tmpY);
/*     */         }
/*  88 */         tmpY += tileSize;
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     renderOut(r, offX, offX + tileSize * (tx2 - tx1 + 1), offY, offY + tileSize * (ty2 - ty1 + 1), zoomout);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderOut(SPRITE_RENDERER r, int x1, int x2, int y1, int y2, int zoomout) {
/*  98 */     COLOR.BLACK.render(r, 0, x1, 0, C.HEIGHT() << zoomout);
/*  99 */     COLOR.BLACK.render(r, x2, C.WIDTH() << zoomout, 0, C.HEIGHT() << zoomout);
/* 100 */     COLOR.BLACK.render(r, x1, x2, 0, y1);
/* 101 */     COLOR.BLACK.render(r, x1, x2, y2, C.HEIGHT() << zoomout);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\Edger.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */