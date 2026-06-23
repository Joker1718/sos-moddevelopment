/*     */ package settlement.tilemap.terrain;
/*     */ 
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
/*     */   
/*     */   null(int $anonymous0) {
/*  83 */     super($anonymous0);
/*     */     
/*  85 */     this.bg = (COLOR)new ColorImp(102, 87, 65);
/*  86 */     this.bg2 = (COLOR)this.bg.shade(0.6D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  91 */     this.bg2.render(r, X1, X2, Y1, Y2);
/*  92 */     this.bg.render(r, X1 + 2, X2 - 2, Y1 + 2, Y2 - 2);
/*     */     
/*  94 */     int x = X1 + 4;
/*  95 */     int y = Y1 + 4;
/*  96 */     int dd = 8;
/*  97 */     int w = 16;
/*     */ 
/*     */ 
/*     */     
/* 101 */     TRock.this.sheet.render(r, 19, x, x + w, y, y + w);
/*     */     
/* 103 */     int tile = 32;
/* 104 */     TRock.this.sheet.render(r, tile, x + dd, x + dd + w, y, y + w);
/*     */     
/* 106 */     tile = 33;
/* 107 */     TRock.this.sheet.render(r, tile, x, x + w, y + dd, y + dd + w);
/*     */     
/* 109 */     tile = 34;
/* 110 */     TRock.this.sheet.render(r, tile, x + dd, x + dd + w, y + dd, y + dd + w);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TRock$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */