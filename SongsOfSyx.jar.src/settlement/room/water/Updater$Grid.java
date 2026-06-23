/*     */ package settlement.room.water;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.Queue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Grid
/*     */   implements SAVABLE
/*     */ {
/* 286 */   final int w = (int)Math.ceil(SETT.TWIDTH / 16.0D);
/* 287 */   final int h = (int)Math.ceil(SETT.THEIGHT / 16.0D);
/* 288 */   private final Queue<GridTile> active = new Queue(this.w * this.h);
/* 289 */   private final GridTile[][] grid = new GridTile[this.w][this.h];
/* 290 */   private final Bitmap2D mark = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */   
/*     */   Grid() {
/* 293 */     for (int y = 0; y < this.h; y++) {
/* 294 */       for (int x = 0; x < this.w; x++)
/* 295 */         this.grid[y][x] = new GridTile(x, y); 
/*     */     } 
/*     */   }
/*     */   public void save(FilePutter file) {
/*     */     byte b;
/*     */     int i;
/*     */     GridTile[][] arrayOfGridTile;
/* 302 */     for (i = (arrayOfGridTile = this.grid).length, b = 0; b < i; ) { GridTile[] tt = arrayOfGridTile[b]; byte b1; int j; GridTile[] arrayOfGridTile1;
/* 303 */       for (j = (arrayOfGridTile1 = tt).length, b1 = 0; b1 < j; ) { GridTile t = arrayOfGridTile1[b1];
/* 304 */         file.bool(t.marked); b1++; }
/*     */        b++; }
/* 306 */      this.mark.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 311 */     this.active.clear(); byte b; int i; GridTile[][] arrayOfGridTile;
/* 312 */     for (i = (arrayOfGridTile = this.grid).length, b = 0; b < i; ) { GridTile[] tt = arrayOfGridTile[b]; byte b1; int j; GridTile[] arrayOfGridTile1;
/* 313 */       for (j = (arrayOfGridTile1 = tt).length, b1 = 0; b1 < j; ) { GridTile t = arrayOfGridTile1[b1];
/* 314 */         t.marked = file.bool();
/* 315 */         if (t.marked) {
/* 316 */           t.marked = false;
/* 317 */           mark(t.body.cX(), t.body.cY());
/*     */         }  b1++; }
/*     */        b++; }
/*     */     
/* 321 */     this.mark.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 326 */     this.mark.clear();
/* 327 */     this.active.clear(); byte b; int i; GridTile[][] arrayOfGridTile;
/* 328 */     for (i = (arrayOfGridTile = this.grid).length, b = 0; b < i; ) { GridTile[] tt = arrayOfGridTile[b]; byte b1; int j; GridTile[] arrayOfGridTile1;
/* 329 */       for (j = (arrayOfGridTile1 = tt).length, b1 = 0; b1 < j; ) { GridTile t = arrayOfGridTile1[b1];
/* 330 */         t.marked = false;
/*     */         b1++; }
/*     */       
/*     */       b++; }
/*     */   
/*     */   } public RECTANGLE pollNext() {
/* 336 */     if (this.active.size() == 0)
/* 337 */       return null; 
/* 338 */     GridTile t = (GridTile)this.active.poll();
/* 339 */     t.marked = false;
/* 340 */     return t.body;
/*     */   }
/*     */   
/*     */   public void mark(int tx, int ty) {
/* 344 */     this.mark.set(tx, ty, true);
/* 345 */     tx /= 16;
/* 346 */     ty /= 16;
/* 347 */     GridTile t = this.grid[ty][tx];
/* 348 */     if (!t.marked) {
/* 349 */       t.marked = true;
/* 350 */       this.active.push(t);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static class GridTile
/*     */   {
/*     */     public static final int size = 16;
/*     */     private final RECTANGLE body;
/*     */     private boolean marked = false;
/*     */     
/*     */     GridTile(int gx, int gy) {
/* 362 */       int x2 = Math.min(gx * 16 + 16, SETT.TWIDTH);
/* 363 */       int y2 = Math.min(gy * 16 + 16, SETT.THEIGHT);
/*     */       
/* 365 */       this.body = (RECTANGLE)new Rec((gx * 16), x2, (gy * 16), y2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Updater$Grid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */