/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
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
/*  99 */     super($anonymous0);
/* 100 */     this.bg = (COLOR)new ColorImp(102, 87, 65);
/* 101 */     this.bg2 = (COLOR)this.bg.shade(0.6D);
/*     */   }
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 104 */     this.bg2.render(r, X1, X2, Y1, Y2);
/* 105 */     this.bg.render(r, X1 + 2, X2 - 2, Y1 + 2, Y2 - 2);
/* 106 */     rr(r, X1, X2, Y1, Y2);
/*     */   }
/*     */   
/*     */   private void rr(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 110 */     int c = 16 * (X2 - X1) / 32;
/*     */     
/* 112 */     sheet.render(r, DIR.SE.mask(), X1, X1 + c, Y1, Y1 + c);
/* 113 */     sheet.render(r, DIR.SW.mask(), X1 + c, X1 + c * 2, Y1, Y1 + c);
/* 114 */     sheet.render(r, DIR.NE.mask(), X1, X1 + c, Y1 + c, Y1 + c * 2);
/* 115 */     sheet.render(r, DIR.NW.mask(), X1 + c, X1 + c * 2, Y1 + c, Y1 + c * 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */