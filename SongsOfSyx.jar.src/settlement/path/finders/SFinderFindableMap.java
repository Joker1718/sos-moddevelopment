/*    */ package settlement.path.finders;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.Bitmap2D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SFinderFindableMap
/*    */ {
/*    */   public static final int quad = 16;
/* 17 */   static final int W = SETT.TWIDTH / 16;
/* 18 */   static final int H = SETT.THEIGHT / 16;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 25 */   final Bitmap2D day = new Bitmap2D(W, H, false);
/* 26 */   final Bitmap2D tries = new Bitmap2D(W, H, false);
/* 27 */   final Bitmap2D fail = new Bitmap2D(W, H, false);
/*    */ 
/*    */   
/*    */   public void report(COORDINATE c, boolean success) {
/* 31 */     report(c.x(), c.y(), success);
/*    */   }
/*    */   
/*    */   public void report(int tx, int ty, boolean success) {
/* 35 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/*    */       return;
/*    */     }
/* 38 */     tx >>= 4;
/* 39 */     ty >>= 4;
/*    */     
/* 41 */     this.tries.set(tx, ty, true);
/* 42 */     this.day.set(tx, ty, ((TIME.days().bitsSinceStart() & 0x1) == 1));
/* 43 */     if (!success) {
/* 44 */       this.fail.set(tx, ty, true);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean has(int tx, int ty) {
/* 49 */     tx >>= 4;
/* 50 */     ty >>= 4;
/* 51 */     return this.tries.is(tx, ty);
/*    */   }
/*    */   
/*    */   public boolean fail(int tx, int ty) {
/* 55 */     tx >>= 4;
/* 56 */     ty >>= 4;
/* 57 */     return this.fail.is(tx, ty);
/*    */   }
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 61 */     tx >>= 4;
/* 62 */     ty >>= 4;
/* 63 */     return !this.fail.is(tx, ty);
/*    */   }
/*    */   
/*    */   void update(int i, boolean d) {
/* 67 */     if (this.tries.is(i) && this.day.is(i) == d) {
/* 68 */       this.tries.set(i, false);
/* 69 */       this.fail.set(i, false);
/*    */     } 
/*    */   }
/*    */   
/*    */   void save(FilePutter file) {
/* 74 */     this.day.save(file);
/* 75 */     this.fail.save(file);
/* 76 */     this.tries.save(file);
/*    */   }
/*    */ 
/*    */   
/*    */   void load(FileGetter file) throws IOException {
/* 81 */     this.day.load(file);
/* 82 */     this.fail.load(file);
/* 83 */     this.tries.load(file);
/*    */   }
/*    */   
/*    */   void clear() {
/* 87 */     this.day.clear();
/* 88 */     this.fail.clear();
/* 89 */     this.tries.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderFindableMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */