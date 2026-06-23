/*     */ package snake2d.util.sprite;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
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
/*     */ public abstract class BigSprite
/*     */ {
/*     */   private final float px;
/*     */   protected final int gameWidth;
/*     */   protected final int gameHeight;
/*     */   private final int scale;
/*     */   private final TextureCoords stencil;
/*     */   
/*     */   protected BigSprite(int scale, int width, int height) {
/*  46 */     this.stencil = new TextureCoords();
/*     */     this.px = 1.0F / scale;
/*     */     this.gameWidth = width * scale;
/*     */     this.gameHeight = height * scale;
/*     */     this.scale = scale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, int width, int height, int scale, double dpx1, double dpy1) {
/*  59 */     int pw = width / scale;
/*  60 */     int ph = height / scale;
/*     */ 
/*     */     
/*  63 */     if (dpx1 < 0.0D) {
/*  64 */       dpx1 = 0.0D;
/*     */     }
/*  66 */     if (dpy1 < 0.0D) {
/*  67 */       dpy1 = 0.0D;
/*     */     }
/*  69 */     if (dpx1 >= this.gameWidth) {
/*     */       return;
/*     */     }
/*  72 */     if (dpy1 >= this.gameHeight) {
/*     */       return;
/*     */     }
/*  75 */     int px1 = (int)dpx1;
/*  76 */     int py1 = (int)dpy1;
/*     */     
/*  78 */     int dx = (int)((dpx1 - px1) * scale);
/*  79 */     int dy = (int)((dpy1 - py1) * scale);
/*     */     
/*  81 */     if (px1 + pw > this.gameWidth) {
/*     */       
/*  83 */       pw = this.gameWidth - px1;
/*     */     }
/*  85 */     else if (dx != 0) {
/*  86 */       pw++;
/*     */     } 
/*     */ 
/*     */     
/*  90 */     if (py1 + ph > this.gameHeight) {
/*     */       
/*  92 */       ph = this.gameHeight - py1;
/*  93 */     } else if (dy != 0) {
/*  94 */       ph++;
/*     */     } 
/*     */     
/*  97 */     this.stencil.get(px1 + startX(), py1 + startY(), pw, ph);
/*     */     
/*  99 */     width = pw * scale;
/* 100 */     height = ph * scale;
/*     */ 
/*     */     
/* 103 */     x1 -= dx;
/* 104 */     y1 -= dy;
/*     */     
/* 106 */     r.renderSprite(x1, x1 + width, y1, y1 + height, 
/* 107 */         this.stencil); } public void render(SPRITE_RENDERER r, int x1, int y1, RECTANGLE quad) {
/*     */     short tx1 = (short)(int)(startX() + quad.x1() * this.px);
/*     */     short ty1 = (short)(int)(startY() + quad.y1() * this.px);
/*     */     int dx = quad.x1() % this.scale;
/*     */     int dy = quad.y1() % this.scale;
/*     */     x1 -= dx;
/*     */     y1 -= dy;
/*     */     r.renderSprite(x1, x1 + quad.width() + this.scale, y1, y1 + quad.height() + this.scale, TextureCoords.Normal.get(tx1, ty1, (int)(this.px * quad.width() + 1.0F), (int)(this.px * quad.height() + 1.0F)));
/*     */   } protected abstract int startX(); protected abstract int startY(); public int getGameWidth() {
/* 116 */     return this.gameWidth;
/*     */   }
/*     */   
/*     */   public int getGameHeight() {
/* 120 */     return this.gameHeight;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\BigSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */