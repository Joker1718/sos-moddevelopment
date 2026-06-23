/*     */ package snake2d.util.sprite;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpriteCollection
/*     */   implements SPRITE
/*     */ {
/*     */   private ArrayListResize<SpriteWCoo> sprites;
/*  14 */   private int width = 0;
/*  15 */   private int height = 0;
/*     */   
/*     */   public SpriteCollection(SPRITE s) {
/*  18 */     this.sprites = new ArrayListResize(2, 500);
/*  19 */     add(s, 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(SPRITE s, int x, int y) {
/*  25 */     if (y < 0) {
/*  26 */       for (SpriteWCoo sc : this.sprites) {
/*  27 */         sc.dY = sc.dY - y;
/*     */       }
/*  29 */       y = 0;
/*     */     } 
/*     */     
/*  32 */     if (y + s.height() > this.height) {
/*  33 */       this.height = y + s.height();
/*     */     }
/*     */     
/*  36 */     if (x < 0) {
/*  37 */       for (SpriteWCoo sc : this.sprites) {
/*  38 */         sc.dX = sc.dX - x;
/*     */       }
/*  40 */       x = 0;
/*     */     } 
/*     */     
/*  43 */     if (x + s.width() > this.width) {
/*  44 */       this.width = x + s.width();
/*     */     }
/*     */     
/*  47 */     this.sprites.add(new SpriteWCoo(s, x, y, null));
/*     */   }
/*     */   
/*     */   public SpriteCollection addRight(SPRITE s) {
/*  51 */     add(
/*  52 */         s, 
/*  53 */         ((SpriteWCoo)this.sprites.getLast()).dX + ((SpriteWCoo)this.sprites.getLast()).s.width(), 
/*  54 */         ((SpriteWCoo)this.sprites.getLast()).dY);
/*  55 */     return this;
/*     */   }
/*     */   
/*     */   public void addRightC(int m, SPRITE s) {
/*  59 */     add(
/*  60 */         s, 
/*  61 */         ((SpriteWCoo)this.sprites.getLast()).dX + ((SpriteWCoo)this.sprites.getLast()).s.width() + m, 
/*  62 */         ((SpriteWCoo)this.sprites.getLast()).dY + (((SpriteWCoo)this.sprites.getLast()).s.height() - s.height()) / 2);
/*     */   }
/*     */   
/*     */   public void addRightCAbs(int abs, SPRITE s) {
/*  66 */     add(
/*  67 */         s, 
/*  68 */         abs, 
/*  69 */         ((SpriteWCoo)this.sprites.getLast()).dY + (((SpriteWCoo)this.sprites.getLast()).s.height() - s.height()) / 2);
/*     */   }
/*     */   
/*     */   public void addDown(SPRITE s) {
/*  73 */     add(
/*  74 */         s, 
/*  75 */         ((SpriteWCoo)this.sprites.getLast()).dX, 
/*  76 */         ((SpriteWCoo)this.sprites.getLast()).dY + ((SpriteWCoo)this.sprites.getLast()).s.height());
/*     */   }
/*     */   
/*     */   public void addLeft(SPRITE s) {
/*  80 */     add(
/*  81 */         s, 
/*  82 */         ((SpriteWCoo)this.sprites.getLast()).dX - s.width(), 
/*  83 */         ((SpriteWCoo)this.sprites.getLast()).dY);
/*     */   }
/*     */   
/*     */   public void addUp(SPRITE s) {
/*  87 */     add(
/*  88 */         s, 
/*  89 */         ((SpriteWCoo)this.sprites.getLast()).dX, 
/*  90 */         ((SpriteWCoo)this.sprites.getLast()).dY - s.height());
/*     */   }
/*     */ 
/*     */   
/*     */   public void addOnTopCentered(SPRITE s) {
/*  95 */     int x1 = ((SpriteWCoo)this.sprites.getLast()).dX + (((SpriteWCoo)this.sprites.getLast()).s.width() - s.width()) / 2;
/*  96 */     int y1 = ((SpriteWCoo)this.sprites.getLast()).dY + (((SpriteWCoo)this.sprites.getLast()).s.height() - s.height()) / 2;
/*  97 */     add(s, x1, y1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLastX1() {
/* 102 */     return ((SpriteWCoo)this.sprites.getLast()).dX;
/*     */   }
/*     */   
/*     */   public int getLastX2() {
/* 106 */     return ((SpriteWCoo)this.sprites.getLast()).dX + ((SpriteWCoo)this.sprites.getLast()).s.width();
/*     */   }
/*     */   
/*     */   public int getLastY1() {
/* 110 */     return ((SpriteWCoo)this.sprites.getLast()).dY;
/*     */   }
/*     */   
/*     */   public int getLastY2() {
/* 114 */     return ((SpriteWCoo)this.sprites.getLast()).dY + ((SpriteWCoo)this.sprites.getLast()).s.height();
/*     */   }
/*     */   
/*     */   private class SpriteWCoo
/*     */   {
/*     */     private final SPRITE s;
/*     */     private int dY;
/*     */     private int dX;
/*     */     
/*     */     private SpriteWCoo(SPRITE s, int x, int y) {
/* 124 */       this.s = s;
/* 125 */       this.dY = y;
/* 126 */       this.dX = x;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 133 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 138 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 143 */     float xScale = ((X2 - X1) / this.width);
/* 144 */     float yScale = ((Y2 - Y1) / this.height);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     for (SpriteWCoo s : this.sprites) {
/* 151 */       int x1 = (int)(X1 + s.dX * xScale);
/* 152 */       int y1 = (int)(Y1 + s.dY * yScale);
/* 153 */       int x2 = (int)((X1 + s.dX + s.s.width()) * xScale);
/* 154 */       int y2 = (int)((Y1 + s.dY + s.s.height()) * yScale);
/* 155 */       s.s.render(r, x1, x2, y1, y2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int Y1) {
/* 163 */     for (SpriteWCoo s : this.sprites) {
/* 164 */       s.s.render(r, X1 + s.dX, X1 + s.dX + s.s.width(), Y1 + s.dY, Y1 + s.dY + s.s.height());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords other, int X1, int X2, int Y1, int Y2) {
/* 171 */     for (SpriteWCoo s : this.sprites)
/* 172 */       s.s.renderTextured(other, X1 + s.dX, X1 + s.dX + s.s.width(), Y1 + s.dY, Y1 + s.dY + s.s.height()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\SpriteCollection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */