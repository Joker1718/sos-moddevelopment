/*     */ package init.race.appearence;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/*  84 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  89 */     int t = k;
/*     */     
/*  91 */     int w = (X2 - X1) / 5;
/*  92 */     int h = (Y2 - Y1) / 3;
/*     */     
/*  94 */     int ox = offX * (X2 - X1) / 48;
/*  95 */     int oy = offY * (Y2 - Y1) / 24;
/*     */     
/*  97 */     for (int y = 0; y < 3; y++) {
/*  98 */       for (int x = 0; x < 5; x++) {
/*  99 */         sheet.render(r, t, X1 + ox + x * w, X1 + ox + x * w + w, Y1 + oy + y * h, Y1 + oy + y * h + h);
/* 100 */         t++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RCrown$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */