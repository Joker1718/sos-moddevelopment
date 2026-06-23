/*     */ package view.tool;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PlacableSingleTool
/*     */   extends ToolPlacer.placeFunc
/*     */ {
/*     */   private PlacableSingle placable;
/*     */   
/*     */   void updateHovered(float ds, GameWindow window, boolean pressed) {}
/*     */   
/*     */   void render(SPRITE_RENDERER r, float ds, GameWindow window) {
/*  30 */     int tx = window.tile().x();
/*  31 */     int ty = window.tile().y();
/*     */     
/*  33 */     this.placable.init(tx, ty);
/*     */     
/*  35 */     CharSequence problem = this.placable.isPlacable(tx, ty);
/*     */     
/*  37 */     if (problem == null) {
/*  38 */       int t = 0;
/*  39 */       GUTIL.filler().init(this);
/*  40 */       GUTIL.filler().fill(tx, ty);
/*  41 */       while (GUTIL.filler().hasMore()) {
/*  42 */         COORDINATE c = GUTIL.filler().poll();
/*  43 */         t++;
/*  44 */         int mask = 0;
/*  45 */         for (DIR d : DIR.ORTHO) {
/*  46 */           int dx = c.x() + d.x();
/*  47 */           int dy = c.y() + d.y();
/*  48 */           if (!SETT.IN_BOUNDS(dx, dy))
/*     */             continue; 
/*  50 */           if (dx == tx && dy == ty) {
/*  51 */             mask |= d.mask(); continue;
/*  52 */           }  if (GUTIL.filler().isFilled(dx, dy) || (this.placable.isPlacable(dx, dy) == null && this.placable.expandsTo(c.x(), c.y(), dx, dy))) {
/*  53 */             mask |= d.mask();
/*  54 */             GUTIL.filler().fill(dx, dy);
/*     */           } 
/*     */         } 
/*  57 */         render(r, mask, c.x(), c.y(), true, window);
/*     */       } 
/*  59 */       GUTIL.filler().done();
/*  60 */       this.placable.placeInfo(VIEW.hoverBox(), t);
/*     */     } else {
/*  62 */       render(r, 0, tx, ty, false, window);
/*  63 */       VIEW.hoverBox().error(problem);
/*     */     } 
/*  65 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private void render(SPRITE_RENDERER r, int mask, int tx, int ty, boolean placable, GameWindow window) {
/*  69 */     if (placable) {
/*  70 */       (GCOLOR.MAP()).OK.bind();
/*     */     } else {
/*  72 */       (GCOLOR.MAP()).BAD.bind();
/*  73 */     }  int x = (tx - window.tile().x()) * 64 + window.tile().rel().x();
/*  74 */     int y = (ty - window.tile().y()) * 64 + window.tile().rel().y();
/*  75 */     this.placable.renderPlaceHolder(r, mask, x, y, tx, ty, placable);
/*     */   }
/*     */ 
/*     */   
/*     */   void click(GameWindow window) {
/*  80 */     int tx = window.tile().x();
/*  81 */     int ty = window.tile().y();
/*     */     
/*  83 */     CharSequence problem = this.placable.isPlacable(tx, ty);
/*  84 */     if (problem != null) {
/*     */       return;
/*     */     }
/*  87 */     this.placable.placeFirst(tx, ty);
/*     */ 
/*     */     
/*  90 */     GUTIL.filler().init(this);
/*  91 */     GUTIL.filler().fill(tx, ty);
/*  92 */     while (GUTIL.filler().hasMore()) {
/*  93 */       COORDINATE c = GUTIL.filler().poll();
/*  94 */       this.placable.placeExpanded(c.x(), c.y());
/*  95 */       for (DIR d : DIR.ORTHO) {
/*  96 */         int dx = c.x() + d.x();
/*  97 */         int dy = c.y() + d.y();
/*  98 */         if (!SETT.IN_BOUNDS(dx, dy))
/*     */           continue; 
/* 100 */         if (dx == tx && dy == ty)
/*     */           continue; 
/* 102 */         if (this.placable.isPlacable(dx, dy) == null && this.placable.expandsTo(c.x(), c.y(), dx, dy)) {
/* 103 */           GUTIL.filler().fill(dx, dy);
/*     */         }
/*     */       } 
/*     */     } 
/* 107 */     GUTIL.filler().done();
/*     */   }
/*     */ 
/*     */   
/*     */   void activate(PLACABLE placer, GameWindow window) {
/* 112 */     this.placable = (PlacableSingle)placer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void clickRelease(GameWindow window) {}
/*     */ 
/*     */ 
/*     */   
/*     */   LIST<CLICKABLE> gui() {
/* 122 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableSingleTool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */