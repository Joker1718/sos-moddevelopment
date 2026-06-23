/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GButt;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends PlacableSimpleTile
/*     */ {
/*     */   boolean full;
/*     */   final ArrayList<CLICKABLE> pp;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 342 */     super($anonymous0);
/*     */     
/* 344 */     this.full = false;
/*     */     
/* 346 */     this.pp = new ArrayList(
/* 347 */         new GButt.Panel("F")
/*     */         {
/*     */           protected void clickA() {
/* 350 */             Tests.PlacerCompare.null.this.full = !Tests.PlacerCompare.null.this.full;
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 354 */             selectedSet(Tests.PlacerCompare.null.this.full);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 361 */     if (Tests.PlacerCompare.this.path.request(Tests.PlacerCompare.this.sx, Tests.PlacerCompare.this.sy, tx, ty, this.full)) {
/* 362 */       Tests.PlacerCompare.this.map = new Bitmap1D(SETT.TAREA, false);
/* 363 */       Tests.PlacerCompare.this.map.set(Tests.PlacerCompare.this.path.x() + Tests.PlacerCompare.this.path.y() * SETT.TWIDTH, true);
/* 364 */       while (Tests.PlacerCompare.this.path.isSuccessful() && Tests.PlacerCompare.this.path.setNext()) {
/* 365 */         Tests.PlacerCompare.this.map.set(Tests.PlacerCompare.this.path.x() + Tests.PlacerCompare.this.path.y() * SETT.TWIDTH, true);
/*     */       }
/* 367 */       Tests.PlacerCompare.this.ren.add();
/*     */     } 
/*     */ 
/*     */     
/* 371 */     if (GUTIL.astar().getShortest(Tests.PlacerCompare.this.path2, (SETT.PATH()).coster.player, Tests.PlacerCompare.this.sx, Tests.PlacerCompare.this.sy, tx, ty)) {
/* 372 */       Tests.PlacerCompare.this.map2 = new Bitmap1D(SETT.TAREA, false);
/* 373 */       Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true); label19: while (true) {
/*     */         while (true) {
/* 375 */           if (!Tests.PlacerCompare.this.path2.setNext())
/*     */           
/*     */           { 
/* 378 */             if (Tests.PlacerCompare.this.path2.isCompleate() || !GUTIL.astar().getShortest(Tests.PlacerCompare.this.path2, (SETT.PATH()).coster.player, Tests.PlacerCompare.this.path2.x(), Tests.PlacerCompare.this.path2.y(), tx, ty))
/*     */               break;  continue; }  Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true);
/* 380 */         }  Tests.PlacerCompare.this.ren.add();
/*     */         break label19;
/*     */       } 
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */     Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true);
/* 387 */     continue; } public CharSequence isPlacable(int tx, int ty) { return null; }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 392 */     return (LIST<CLICKABLE>)this.pp;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\Tests$PlacerCompare$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */