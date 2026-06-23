/*     */ package settlement.room.main;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
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
/*     */ 
/*     */ class null
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 100 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 106 */     blue.icon.render(r, X1, X2, Y1, Y2);
/* 107 */     int size = 16 * (X2 - X1) / 32;
/*     */     
/* 109 */     (UI.icons()).s.chevron(DIR.N);
/*     */     
/* 111 */     COLOR.BLACK.bind();
/* 112 */     OPACITY.O66.bind();
/* 113 */     int sh = size / 8; int j;
/* 114 */     for (j = 0; j < upAm; j++)
/* 115 */       (UI.icons()).s.chevron(DIR.N).render(r, X1 + sh, X1 + size + sh, Y1 + sh + j * size / 2, Y1 + sh + j * size / 2 + size); 
/* 116 */     OPACITY.unbind();
/* 117 */     COLOR.unbind();
/*     */ 
/*     */     
/* 120 */     RoomUpgrades.ORANGE100.bind();
/* 121 */     for (j = 0; j < upAm; j++)
/* 122 */       (UI.icons()).s.chevron(DIR.N).render(r, X1, X1 + size, Y1 + j * size / 2, Y1 + j * size / 2 + size); 
/* 123 */     COLOR.unbind();
/* 124 */     COLOR.unbind();
/* 125 */     size = 24 * (X2 - X1) / 64;
/*     */     
/* 127 */     for (int ri = 0; ri < blue.constructor().resources(); ri++) {
/* 128 */       if (RoomUpgrades.this.masks[upAm][ri] > 0.0D && RoomUpgrades.this.masks[upAm - 1][ri] == 0.0D) {
/* 129 */         blue.constructor().resource(ri).icon().render(r, X2 - size, X2, Y2 - size, Y2);
/* 130 */         Y2 = (int)(Y2 - size * 0.75D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomUpgrades$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */