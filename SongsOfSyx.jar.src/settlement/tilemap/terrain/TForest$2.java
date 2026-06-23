/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private COLOR bg;
/*     */   private COLOR bg2;
/*     */   private final int[] dx;
/*     */   private final int[] dy;
/*     */   
/*     */   null(int $anonymous0) {
/*  79 */     super($anonymous0);
/*     */     
/*  81 */     this.bg = (COLOR)new ColorImp(102, 87, 65);
/*  82 */     this.bg2 = (COLOR)this.bg.shade(0.6D);
/*  83 */     this.dx = new int[] { 0, 16, 16 };
/*  84 */     this.dy = new int[] { 0, 0, 16, 16 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  92 */     this.bg2.render(r, X1, X2, Y1, Y2);
/*  93 */     this.bg.render(r, X1 + 2, X2 - 2, Y1 + 2, Y2 - 2);
/*     */     
/*  95 */     for (int i = 0; i < 4; i++) {
/*  96 */       int x = X1 + this.dx[i];
/*  97 */       int y = Y1 + this.dy[i];
/*  98 */       int x2 = x + 16;
/*  99 */       int y2 = y + 16;
/*     */       
/* 101 */       ((COLOR)(SETT.TERRAIN()).colors.tree.fertile.get(0)).bind();
/*     */       
/* 103 */       TForest.this.sprites.smedium.render(r, i, x, x2, y, y2);
/*     */     } 
/* 105 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */