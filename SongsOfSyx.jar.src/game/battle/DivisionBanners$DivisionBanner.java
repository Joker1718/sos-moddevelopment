/*     */ package game.battle;
/*     */ 
/*     */ import init.sprite.BitmapSprite;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DivisionBanner
/*     */   implements SPRITE
/*     */ {
/*     */   public final BitmapSprite sprite;
/*  75 */   public final ColorImp col = new ColorImp();
/*  76 */   public final ColorImp bg = new ColorImp(20, 20, 20);
/*  77 */   private final int m = 2;
/*     */   
/*     */   public DivisionBanner(BitmapSprite sprite) {
/*  80 */     this.sprite = sprite;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/*  85 */     return 28;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/*  90 */     return 28;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 103 */     int s = (X2 - X1) / width();
/* 104 */     if (s < 1) {
/* 105 */       s = 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     renderSymbol(r, X1 + 2, Y1 + 2, s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderSymbol(SPRITE_RENDERER r, int X1, int Y1, int scale) {
/* 122 */     for (int y = -1; y <= 26; y++) {
/* 123 */       for (int x = -1; x <= 26; x++) {
/* 124 */         int dx = (x - 1) / 2;
/* 125 */         int dy = (y - 1) / 2;
/*     */         
/* 127 */         if (this.sprite.is(dx, dy)) {
/* 128 */           ColorImp colorImp = this.col;
/* 129 */           for (DIR d : DIR.ALL) {
/* 130 */             int ddx = (x - 1 + d.x()) / 2;
/* 131 */             int ddy = (y - 1 + d.y()) / 2;
/* 132 */             if (!this.sprite.is(ddx, ddy)) {
/* 133 */               colorImp = ColorImp.TMP.set((COLOR)colorImp).shadeSelf(0.6D);
/*     */               break;
/*     */             } 
/*     */           } 
/* 137 */           colorImp.render(r, X1 + x * scale, X1 + x * scale + scale, Y1 + y * scale, Y1 + y * scale + scale);
/*     */         } else {
/* 139 */           for (DIR d : DIR.ALL) {
/* 140 */             int ddx = (x - 1 + d.x()) / 2;
/* 141 */             int ddy = (y - 1 + d.y()) / 2;
/* 142 */             if (this.sprite.is(ddx, ddy)) {
/* 143 */               this.bg.render(r, X1 + x * scale, X1 + x * scale + scale, Y1 + y * scale, Y1 + y * scale + scale);
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\DivisionBanners$DivisionBanner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */