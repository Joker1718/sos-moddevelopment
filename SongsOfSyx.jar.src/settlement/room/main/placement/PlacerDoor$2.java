/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ class null
/*     */   extends PlacableMulti
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/*  76 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  80 */     if (PlacerDoor.this.placeWithoutHistory(tx, ty)) {
/*  81 */       PlacerDoor.this.history.placeDoor(tx, ty, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  87 */     if (!PlacerDoor.this.isEdge.is(tx, ty))
/*  88 */       return E; 
/*  89 */     if (!UtilWallPlacability.wallCanBe.is(tx, ty))
/*  90 */       return E; 
/*  91 */     if (PlacerDoor.this.isOpening.is(tx, ty))
/*  92 */       return E; 
/*  93 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/*  99 */     PlacerDoor.this.cDoor.render(r, mask, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 104 */     return (PLACABLE)PlacerDoor.this.undo;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 109 */     return (SPRITE)(SPRITES.icons()).m.wall_opening;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\PlacerDoor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */