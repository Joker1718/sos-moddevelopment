/*     */ package settlement.job;
/*     */ 
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.STOCKPILE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import view.subview.GameWindow;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Convert
/*     */   extends PlacableMulti
/*     */ {
/*     */   boolean count;
/*     */   int res;
/*     */   int allocated;
/*     */   
/*     */   public Convert() {
/* 360 */     super(JobBuildStructure.¤¤Convert, JobBuildStructure.¤¤ConvertD, (SPRITE)new SPRITE.Twin(paramJobBuildStructure.terrain.wall.getIcon(), (SPRITE)(SPRITES.icons()).m.arrow_right));
/*     */ 
/*     */ 
/*     */     
/* 364 */     this.count = true;
/* 365 */     this.res = 0;
/* 366 */     this.allocated = 0;
/*     */   }
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {
/* 370 */     this.count = true;
/* 371 */     this.res = 0;
/* 372 */     this.allocated = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void finishChecking(AREA placedArea) {
/* 377 */     this.count = false;
/* 378 */     super.finishChecking(placedArea);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 384 */     Terrain.TerrainTile te = SETT.TERRAIN().get(tx, ty);
/* 385 */     if (te == null || !(te instanceof TBuilding.BuildingComponent))
/* 386 */       return JobBuildStructure.¤¤SameProblem; 
/* 387 */     if (JobBuildStructure.this.terrain.isser.is(tx, ty)) {
/* 388 */       return JobBuildStructure.¤¤SameProblem;
/*     */     }
/* 390 */     if (this.count) {
/* 391 */       if (te instanceof TBuilding.Wall && (((TBuilding.Wall)te).building()).wall == te && JobBuildStructure.this.wall.res() != null) {
/* 392 */         this.res += JobBuildStructure.this.wall.resAmount();
/* 393 */       } else if ((te instanceof TBuilding.Ceiling || te instanceof TBuilding.Ceiling.Opening) && JobBuildStructure.this.ceiling.res() != null) {
/* 394 */         this.res += JobBuildStructure.this.ceiling.resAmount();
/*     */       } 
/* 396 */       if (this.res >= ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())) {
/* 397 */         return JobBuildStructure.¤¤ConvertR;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 402 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void finishPlacing(AREA placedArea) {
/* 407 */     if (this.res > 1) {
/* 408 */       STOCKPILE.StockpileImp stock = new STOCKPILE.StockpileImp();
/* 409 */       stock.set(JobBuildStructure.this.wall.res(), this.res - 1);
/* 410 */       this.res = 0;
/* 411 */       this.allocated = 0;
/* 412 */       RESOURCE.remove(stock, FResources.RTYPE.CONSTRUCTION);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 419 */     if (JobBuildStructure.this.terrain.isser.is(tx, ty))
/*     */       return; 
/* 421 */     Terrain.TerrainTile te = SETT.TERRAIN().get(tx, ty);
/* 422 */     if (te instanceof TBuilding.Wall && (((TBuilding.Wall)te).building()).wall == te && this.allocated + JobBuildStructure.this.wall.resAmount() < ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())) {
/* 423 */       JobBuildStructure.this.terrain.wall.placeFixed(tx, ty);
/* 424 */       this.allocated += JobBuildStructure.this.wall.resAmount();
/*     */     }
/* 426 */     else if ((te instanceof TBuilding.Ceiling || te instanceof TBuilding.Ceiling.Opening) && this.allocated + JobBuildStructure.this.ceiling.resAmount() < ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())) {
/* 427 */       JobBuildStructure.this.terrain.roof.placeFixed(tx, ty);
/* 428 */       this.allocated += JobBuildStructure.this.ceiling.resAmount();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 434 */     return (PLACABLE)(SETT.JOBS()).tool_clear;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int oktiles, AREA a) {
/* 441 */     if (JobBuildStructure.this.wall.res() != null) {
/* 442 */       b.add((SPRITE)JobBuildStructure.this.wall.res().icon());
/* 443 */       b.add((SPRITE)GFORMAT.iofk(b.text(), this.res, ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(JobBuildStructure.this.wall.res())));
/*     */     } 
/* 445 */     super.placeInfo(b, oktiles, a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildStructure$Convert.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */