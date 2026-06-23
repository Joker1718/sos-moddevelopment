/*     */ package settlement.entry;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntryPoint
/*     */   implements INDEXED
/*     */ {
/*     */   public final int DIM;
/*     */   public final RECTANGLE body;
/* 409 */   private final Coo sCoo = new Coo();
/*     */   
/*     */   private final COORDINATE wCoo;
/*     */   public final DIR dirOut;
/*     */   private final int index;
/*     */   private boolean reachable = false;
/*     */   private boolean active = false;
/*     */   
/*     */   void save(FilePutter file) {
/* 418 */     this.sCoo.save(file);
/* 419 */     file.bool(this.active);
/* 420 */     file.bool(this.reachable);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 424 */     this.sCoo.load(file);
/* 425 */     this.active = file.bool();
/* 426 */     this.reachable = file.bool();
/*     */   }
/*     */   
/*     */   void clear() {
/* 430 */     this.sCoo.set(this.body.cX(), this.body.cY());
/* 431 */     this.active = false;
/* 432 */     this.reachable = false;
/*     */   }
/*     */   
/*     */   EntryPoint(int index, int x1, int x2, int y1, int y2, DIR dir, int wdx, int wdy) {
/* 436 */     this.body = (RECTANGLE)new Rec(x1, x2, y1, y2);
/* 437 */     this.DIM = Math.max(this.body.width(), this.body.height());
/* 438 */     this.dirOut = dir;
/* 439 */     this.sCoo.set(this.body.cX(), this.body.cY());
/* 440 */     this.wCoo = (COORDINATE)new Coo(wdx, wdy);
/* 441 */     this.index = index;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 446 */     return this.index;
/*     */   }
/*     */   
/*     */   public boolean reachable() {
/* 450 */     return this.reachable;
/*     */   }
/*     */   
/*     */   public boolean active() {
/* 454 */     return this.active;
/*     */   }
/*     */   
/*     */   public COORDINATE coo() {
/* 458 */     return (COORDINATE)this.sCoo;
/*     */   }
/*     */   
/*     */   public COORDINATE wCooD() {
/* 462 */     return this.wCoo;
/*     */   }
/*     */   
/*     */   public int wx() {
/* 466 */     return this.wCoo.x() + SETT.WORLD_AREA().tiles().x1();
/*     */   }
/*     */   
/*     */   public int wy() {
/* 470 */     return this.wCoo.y() + SETT.WORLD_AREA().tiles().y1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double distanceValue(int wx, int wy) {
/* 477 */     double ox = wx + 0.5D;
/* 478 */     double oy = wy + 0.5D;
/*     */     
/* 480 */     double x = (this.wCoo.x() + SETT.WORLD_AREA().tiles().x1()) + 0.5D;
/* 481 */     double y = (this.wCoo.y() + SETT.WORLD_AREA().tiles().y1()) + 0.5D;
/* 482 */     x += this.dirOut.x() * 0.5D;
/* 483 */     y += this.dirOut.y() * 0.5D;
/*     */     
/* 485 */     x -= ox;
/* 486 */     y -= oy;
/*     */     
/* 488 */     double dist = x * x + y * y;
/*     */     
/* 490 */     return dist;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\EntryPoints$EntryPoint.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */