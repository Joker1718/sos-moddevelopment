/*     */ package snake2d.util.sprite;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SpriteSheet
/*     */ {
/*  10 */   protected int lastX1 = 0;
/*  11 */   protected int lastX2 = 0;
/*  12 */   protected int lastY1 = 0;
/*  13 */   protected int lastY2 = 0;
/*     */ 
/*     */   
/*     */   protected int scale;
/*     */ 
/*     */ 
/*     */   
/*     */   protected SpriteSheet(int scale) {
/*  21 */     this.scale = scale;
/*     */   }
/*     */   
/*     */   protected SpriteSheet() {
/*  25 */     this(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setScale(int scale) {
/*  31 */     this.scale = scale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SPRITE getSprite(int x1, int width, int y1, int height) {
/*  44 */     int tx1 = x1;
/*  45 */     int tx2 = tx1 + width;
/*  46 */     int ty1 = y1;
/*  47 */     int ty2 = ty1 + height;
/*     */     
/*  49 */     this.lastX1 = x1;
/*  50 */     this.lastX2 = x1 + width;
/*  51 */     this.lastY1 = y1;
/*  52 */     this.lastY2 = y1 + height;
/*  53 */     return new SPRITE.SpriteImp(tx1, tx2, ty1, ty2, width * this.scale, height * this.scale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SPRITE[] getVerticalSpriteArray(int x1, int width, int y1, int height, int size) {
/*  91 */     SPRITE[] res = new SPRITE[size];
/*     */     
/*  93 */     for (int i = 0; i < size; i++) {
/*  94 */       res[i] = getSprite(x1, width, y1 + height * i, height);
/*     */     }
/*     */     
/*  97 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SPRITE[] getHorizontalSpriteArray(int x1, int width, int y1, int height, int size) {
/* 131 */     SPRITE[] res = new SPRITE[size];
/*     */     
/* 133 */     for (int i = 0; i < size; i++) {
/* 134 */       res[i] = getSprite(x1 + width * i, width, y1, height);
/*     */     }
/*     */     
/* 137 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BigSprite getBigSprite(final int x1, int width, final int y1, int height) {
/* 153 */     this.lastX1 = x1;
/* 154 */     this.lastY1 = y1;
/* 155 */     this.lastX2 = x1 + width;
/* 156 */     this.lastY2 = y1 + height;
/* 157 */     return new BigSprite(this.scale, width, height)
/*     */       {
/*     */         protected int startX()
/*     */         {
/* 161 */           return x1;
/*     */         }
/*     */ 
/*     */         
/*     */         protected int startY() {
/* 166 */           return y1;
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\SpriteSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */