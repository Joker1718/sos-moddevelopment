/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(int $anonymous0) {
/*  96 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 100 */     int d = (Y2 - Y1) / 2;
/* 101 */     WorldMountain.this.sheet.render(r, 0 + DIR.SE.mask(), X1, X1 + d, Y1, Y1 + d);
/* 102 */     WorldMountain.this.sheet.render(r, 0 + DIR.SW.mask(), X1 + d, X1 + d * 2, Y1, Y1 + d);
/* 103 */     WorldMountain.this.sheet.render(r, 0 + DIR.NE.mask(), X1, X1 + d, Y1 + d, Y1 + d * 2);
/* 104 */     WorldMountain.this.sheet.render(r, 0 + DIR.NW.mask(), X1 + d, X1 + d * 2, Y1 + d, Y1 + d * 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldMountain$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */