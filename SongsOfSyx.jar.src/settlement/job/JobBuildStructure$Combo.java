/*     */ package settlement.job;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Combo
/*     */   extends PlacableMulti
/*     */ {
/*     */   public Combo() {
/* 290 */     super((CharSequence)(new Str(JobBuildStructure.¤¤Structure)).insert(0, paramJobBuildStructure.building.name), JobBuildStructure.¤¤StructureD, paramJobBuildStructure.terrain.iconCombo);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 295 */     if (isWall(tx, ty, a))
/* 296 */       return JobBuildStructure.this.wall.placer().isPlacable(tx, ty, a, t); 
/* 297 */     return JobBuildStructure.this.ceiling.placer().isPlacable(tx, ty, a, t);
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 302 */     if (isWall(tx, ty, a)) {
/* 303 */       JobBuildStructure.this.wall.placer().place(tx, ty, a, t);
/*     */     } else {
/* 305 */       JobBuildStructure.this.ceiling.placer().place(tx, ty, a, t);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA a, PLACER_TYPE t, boolean isPlacable, boolean areaIsPlacable) {
/* 311 */     if (isWall(tx, ty, a)) {
/* 312 */       JobBuildStructure.this.wall.renderAbove(r, x, y, mask, tx, ty);
/*     */     } else {
/* 314 */       JobBuildStructure.this.ceiling.renderAbove(r, x, y, mask, tx, ty);
/*     */     } 
/*     */   }
/*     */   private boolean isWall(int tx, int ty, AREA a) {
/* 318 */     for (DIR d : DIR.ALL) {
/* 319 */       if (!a.is(tx, ty, d)) {
/* 320 */         int y1 = a.body().y1();
/* 321 */         int y2 = a.body().y2();
/* 322 */         int x1 = a.body().x1();
/* 323 */         int x2 = a.body().x2();
/* 324 */         if ((a.body().height() & 0x1) == 1) {
/* 325 */           y1 = a.body().cY();
/* 326 */           y2 = a.body().cY();
/*     */         } else {
/* 328 */           y1 = a.body().cY() - 1;
/* 329 */           y2 = a.body().cY();
/*     */         } 
/*     */         
/* 332 */         if ((a.body().width() & 0x1) == 1) {
/* 333 */           x1 = a.body().cX();
/* 334 */           x2 = a.body().cX();
/*     */         } else {
/* 336 */           x1 = a.body().cX() - 1;
/* 337 */           x2 = a.body().cX();
/*     */         } 
/*     */         
/* 340 */         return ((tx < x1 || tx > x2) && (ty < y1 || ty > y2));
/*     */       } 
/*     */     } 
/* 343 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBePlacedAs(PLACER_TYPE t) {
/* 348 */     return (t != PLACER_TYPE.LINE);
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 353 */     return JobBuildStructure.this.wall.placer().getUndo();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildStructure$Combo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */