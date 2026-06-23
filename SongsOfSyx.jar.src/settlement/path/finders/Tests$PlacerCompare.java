/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GButt;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
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
/*     */ class PlacerCompare
/*     */   implements ACTION
/*     */ {
/* 288 */   private Bitmap1D map = null;
/* 289 */   private Bitmap1D map2 = null; int sx;
/*     */   int sy;
/* 291 */   private final SPath path = new SPath();
/* 292 */   private final PathGame.PathFancy path2 = new PathGame.PathFancy(256);
/*     */   
/* 294 */   ON_TOP_RENDERABLE ren = new ON_TOP_RENDERABLE()
/*     */     {
/*     */       public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*     */       {
/* 298 */         if (Tests.PlacerCompare.this.map == null) {
/* 299 */           remove();
/*     */           return;
/*     */         } 
/* 302 */         RenderData.RenderIterator it = data.onScreenTiles();
/* 303 */         while (it.has()) {
/* 304 */           if (Tests.PlacerCompare.this.map.get(it.tile())) {
/* 305 */             (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*     */           }
/* 307 */           it.next();
/*     */         } 
/*     */         
/* 310 */         if (Tests.PlacerCompare.this.map2 == null)
/*     */           return; 
/* 312 */         it = data.onScreenTiles();
/* 313 */         while (it.has()) {
/* 314 */           COLOR.RED100.bind();
/* 315 */           if (Tests.PlacerCompare.this.map2.get(it.tile())) {
/* 316 */             (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x() + 4, it.y() + 4);
/*     */           }
/* 318 */           it.next();
/*     */         } 
/* 320 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */   
/* 324 */   PlacableSimpleTile p1 = new PlacableSimpleTile("set start")
/*     */     {
/*     */       public void place(int tx, int ty)
/*     */       {
/* 328 */         Tests.PlacerCompare.this.sx = tx;
/* 329 */         Tests.PlacerCompare.this.sy = ty;
/* 330 */         (VIEW.s()).tools.place((PLACABLE)Tests.PlacerCompare.this.p2);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int tx, int ty) {
/* 336 */         if ((SETT.PATH()).solidity.is(tx, ty))
/* 337 */           return E; 
/* 338 */         return null;
/*     */       }
/*     */     };
/*     */   
/* 342 */   PlacableSimpleTile p2 = new PlacableSimpleTile("set dest")
/*     */     {
/*     */       boolean full = false;
/*     */       
/* 346 */       final ArrayList<CLICKABLE> pp = new ArrayList(
/* 347 */           new GButt.Panel("F")
/*     */           {
/*     */             protected void clickA() {
/* 350 */               Tests.PlacerCompare.null.this.full = !Tests.PlacerCompare.null.this.full;
/*     */             }
/*     */             
/*     */             protected void renAction() {
/* 354 */               selectedSet(Tests.PlacerCompare.null.this.full);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/*     */       public void place(int tx, int ty) {
/* 361 */         if (Tests.PlacerCompare.this.path.request(Tests.PlacerCompare.this.sx, Tests.PlacerCompare.this.sy, tx, ty, this.full)) {
/* 362 */           Tests.PlacerCompare.this.map = new Bitmap1D(SETT.TAREA, false);
/* 363 */           Tests.PlacerCompare.this.map.set(Tests.PlacerCompare.this.path.x() + Tests.PlacerCompare.this.path.y() * SETT.TWIDTH, true);
/* 364 */           while (Tests.PlacerCompare.this.path.isSuccessful() && Tests.PlacerCompare.this.path.setNext()) {
/* 365 */             Tests.PlacerCompare.this.map.set(Tests.PlacerCompare.this.path.x() + Tests.PlacerCompare.this.path.y() * SETT.TWIDTH, true);
/*     */           }
/* 367 */           Tests.PlacerCompare.this.ren.add();
/*     */         } 
/*     */ 
/*     */         
/* 371 */         if (GUTIL.astar().getShortest(Tests.PlacerCompare.this.path2, (SETT.PATH()).coster.player, Tests.PlacerCompare.this.sx, Tests.PlacerCompare.this.sy, tx, ty)) {
/* 372 */           Tests.PlacerCompare.this.map2 = new Bitmap1D(SETT.TAREA, false);
/* 373 */           Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true); label19: while (true) {
/*     */             while (true) {
/* 375 */               if (!Tests.PlacerCompare.this.path2.setNext())
/*     */               
/*     */               { 
/* 378 */                 if (Tests.PlacerCompare.this.path2.isCompleate() || !GUTIL.astar().getShortest(Tests.PlacerCompare.this.path2, (SETT.PATH()).coster.player, Tests.PlacerCompare.this.path2.x(), Tests.PlacerCompare.this.path2.y(), tx, ty))
/*     */                   break;  continue; }  Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true);
/* 380 */             }  Tests.PlacerCompare.this.ren.add();
/*     */             break label19;
/*     */           } 
/*     */         } else {
/*     */           return;
/*     */         } 
/*     */         Tests.PlacerCompare.this.map2.set(Tests.PlacerCompare.this.path2.x() + Tests.PlacerCompare.this.path2.y() * SETT.TWIDTH, true);
/* 387 */         continue; } public CharSequence isPlacable(int tx, int ty) { return null; }
/*     */ 
/*     */ 
/*     */       
/*     */       public LIST<CLICKABLE> getAdditionalButt() {
/* 392 */         return (LIST<CLICKABLE>)this.pp;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe() {
/* 400 */     this.path.clear();
/* 401 */     (VIEW.s()).tools.place((PLACABLE)this.p1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\Tests$PlacerCompare.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */