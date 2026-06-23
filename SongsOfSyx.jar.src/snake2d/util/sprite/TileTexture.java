/*     */ package snake2d.util.sprite;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ public class TileTexture implements DIMENSION {
/*     */   private final int sx;
/*     */   private final int sy;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private final int size;
/*  12 */   private final TextureCoords tex = new TextureCoords();
/*     */   
/*     */   public TileTexture(int tileSize, int tilesX, int tilesY, int px, int py) {
/*  15 */     this.sx = px;
/*  16 */     this.sy = py;
/*  17 */     this.width = tilesX;
/*  18 */     this.height = tilesY;
/*  19 */     this.size = tileSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/*  24 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/*  29 */     return this.height;
/*     */   }
/*     */   
/*     */   public TextureCoords get(int tx, int ty, double offX, double offY) {
/*  33 */     int px = (tx & this.width - 1) * this.size;
/*  34 */     px = (int)(px + this.size * offX);
/*  35 */     int py = (ty & this.height - 1) * this.size;
/*  36 */     py = (int)(py + this.size * offY);
/*  37 */     return this.tex.get(this.sx + px, this.sy + py, this.size, this.size);
/*     */   }
/*     */   
/*     */   public TextureCoords get(double tx, double ty) {
/*  41 */     int x = (int)tx;
/*  42 */     int y = (int)ty;
/*     */     
/*  44 */     x = MATH.mod(x, this.width * this.size);
/*  45 */     y = MATH.mod(y, this.height * this.size);
/*  46 */     return this.tex.get(this.sx + x, this.sy + y, this.size, this.size);
/*     */   }
/*     */   
/*     */   public TileTextureScroller scroller(double speedx, double speedy) {
/*  50 */     return new TileTextureScroller(this, speedx, speedy);
/*     */   }
/*     */   
/*     */   public static class TileTextureScroller
/*     */   {
/*  55 */     private final TextureCoords tex = new TextureCoords();
/*     */     
/*     */     private final TileTexture scroller;
/*     */     
/*     */     private double speedx;
/*     */     private double speedy;
/*     */     
/*     */     public TileTextureScroller(TileTexture scroller, double speedx, double speedy) {
/*  63 */       this.scroller = scroller;
/*  64 */       this.speedx = speedx;
/*  65 */       this.speedy = speedy;
/*  66 */       this.mx = scroller.width * scroller.size;
/*  67 */       this.my = scroller.width * scroller.size;
/*  68 */       this.dx = (RND.rFloat() * scroller.width * scroller.size);
/*  69 */       this.dy = (RND.rFloat() * scroller.height * scroller.size);
/*     */     }
/*     */     public double dx; public double dy; private final int mx; private final int my;
/*     */     public void update(double ds) {
/*  73 */       update(ds * this.speedx, ds * this.speedy);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update(double x, double y) {
/*  78 */       this.dx += x;
/*  79 */       this.dy += y;
/*     */       
/*  81 */       this.dx = MATH.mod(this.dx, this.mx);
/*  82 */       this.dy = MATH.mod(this.dy, this.my);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureCoords get(int tileX, int tileY) {
/*  87 */       int px = (int)x1(tileX);
/*  88 */       int py = (int)y1(tileY);
/*  89 */       return this.tex.get(px, py, this.scroller.size, this.scroller.size);
/*     */     }
/*     */ 
/*     */     
/*     */     public float x1(int tileX) {
/*  94 */       double x = (tileX * this.scroller.size) + this.dx;
/*  95 */       x %= this.mx;
/*  96 */       return this.scroller.sx + (float)x;
/*     */     }
/*     */ 
/*     */     
/*     */     public float y1(int tileY) {
/* 101 */       double y = (tileY * this.scroller.size) + this.dy;
/* 102 */       y %= this.my;
/* 103 */       return this.scroller.sy + (float)y;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\TileTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */