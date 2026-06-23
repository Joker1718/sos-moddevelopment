/*     */ package settlement.environment;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.QueueInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Chunks
/*     */ {
/* 498 */   private final int mask = -16;
/* 499 */   private final int width = SETT.TWIDTH / 16;
/* 500 */   private final int size = this.width * SETT.THEIGHT / 16;
/*     */   
/* 502 */   private final Bitmap1D changed = new Bitmap1D(this.size, false);
/* 503 */   private final int[] upMasks = Alloc.ii(this.size);
/* 504 */   private final QueueInteger updatables = new QueueInteger(this.size + 1);
/* 505 */   private Coo coo = new Coo();
/*     */   
/*     */   private final Rec rr;
/*     */   
/*     */   private int pt;
/*     */ 
/*     */   
/*     */   public void change(int tx, int ty, int mask) {
/* 513 */     if (!SETT.IN_BOUNDS(tx, ty))
/*     */       return; 
/* 515 */     int x1 = tx - 16;
/* 516 */     int x2 = tx + 16;
/* 517 */     int y1 = ty - 16;
/* 518 */     int y2 = ty + 16;
/*     */     
/* 520 */     for (int y = y1; y <= y2; y += 16) {
/* 521 */       for (int x = x1; x <= x2; x += 16) {
/* 522 */         if (SETT.IN_BOUNDS(x, y)) {
/* 523 */           changeP(x, y, mask);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void changeP(int tx, int ty, int mask) {
/* 531 */     int c = getChunk(tx, ty);
/* 532 */     this.upMasks[c] = this.upMasks[c] | mask;
/* 533 */     if (!this.changed.get(c)) {
/* 534 */       this.changed.set(c, true);
/* 535 */       this.updatables.push(c);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int getChunk(int tx, int ty) {
/* 541 */     tx &= 0xFFFFFFF0;
/* 542 */     ty &= 0xFFFFFFF0;
/* 543 */     int c = tx / 16 + this.width * ty / 16;
/* 544 */     return c;
/*     */   }
/*     */   Chunks() {
/* 547 */     this.rr = new Rec(5.0D, 5.0D);
/*     */   }
/*     */   
/*     */   public void change(int tx, int ty) {
/* 551 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/*     */       return;
/*     */     }
/* 554 */     int m = 0;
/*     */     
/* 556 */     this.rr.moveC(tx, ty);
/*     */     
/* 558 */     for (SettEnvMap.Updatable e : SettEnvMap.this.ups) {
/* 559 */       if ((m & e.bit) != 0) {
/*     */         continue;
/*     */       }
/* 562 */       for (COORDINATE c : this.rr) {
/* 563 */         if (SETT.IN_BOUNDS(c) && (e.has(c.x(), c.y()) || e.getBaseValue(c.x(), c.y()) > 0.0D)) {
/* 564 */           m |= e.bit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 582 */     if (m != 0)
/* 583 */       change(tx, ty, m); 
/*     */   }
/*     */   
/*     */   void clear() {
/* 587 */     this.changed.clear();
/* 588 */     this.updatables.clear();
/* 589 */     Arrays.fill(this.upMasks, 0);
/*     */   }
/*     */   
/*     */   public boolean has() {
/* 593 */     return this.updatables.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE next() {
/* 599 */     int x = this.pt % this.width;
/* 600 */     int y = this.pt / this.width;
/* 601 */     this.coo.set((16 * x), (16 * y));
/* 602 */     this.changed.set(this.pt, false);
/* 603 */     this.upMasks[this.pt] = 0;
/* 604 */     return (COORDINATE)this.coo;
/*     */   }
/*     */   
/*     */   public int nextMask() {
/* 608 */     this.pt = this.updatables.poll();
/* 609 */     return this.upMasks[this.pt];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\SettEnvMap$Chunks.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */