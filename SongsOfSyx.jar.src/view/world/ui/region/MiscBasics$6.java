/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 152 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 157 */     COLOR.WHITE25.render(r, X1, X2, Y1, Y2);
/* 158 */     int x = X1; int i;
/* 159 */     for (i = 0; i < AM / 2; i++) {
/* 160 */       ColorImp.TMP.interpolate((CLIMATES.COLD()).color, (CLIMATES.TEMP()).color, i / 5.0D);
/* 161 */       ColorImp.TMP.render(r, x, x + DIM, Y1 + 2, Y2 - 2);
/* 162 */       x += DIM;
/*     */     } 
/* 164 */     for (i = 0; i < AM / 2; i++) {
/* 165 */       ColorImp.TMP.interpolate((CLIMATES.TEMP()).color, (CLIMATES.HOT()).color, i / 5.0D);
/* 166 */       ColorImp.TMP.render(r, x, x + DIM, Y1 + 2, Y2 - 2);
/* 167 */       x += DIM;
/*     */     } 
/*     */ 
/*     */     
/* 171 */     double d = 0.0D;
/* 172 */     for (CLIMATE c : CLIMATES.ALL()) {
/* 173 */       d += ((Region)g.get()).info.climate(c) * c.index();
/*     */     }
/* 175 */     d /= (CLIMATES.ALL().size() - 1);
/* 176 */     x = (int)(X1 + d * (X2 - X1));
/* 177 */     x -= 12;
/* 178 */     COLOR.BLACK.bind();
/* 179 */     (SPRITES.icons()).m.crossair.render(r, x + 2, Y1 + 2);
/* 180 */     COLOR.unbind();
/* 181 */     (SPRITES.icons()).m.crossair.render(r, x, Y1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscBasics$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */