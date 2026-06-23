/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ class PointMapQuadrant
/*    */   implements SAVABLE
/*    */ {
/* 11 */   private long[] added = new long[16];
/* 12 */   private byte last = 0;
/*    */ 
/*    */   
/*    */   void add(long d) {
/* 16 */     if (this.last >= Byte.MAX_VALUE) {
/*    */       return;
/*    */     }
/* 19 */     if (this.last == this.added.length) {
/* 20 */       long[] n = new long[this.added.length + 16];
/* 21 */       for (int i = 0; i < this.added.length; i++)
/* 22 */         n[i] = this.added[i]; 
/* 23 */       this.added = n;
/*    */     } 
/*    */     
/* 26 */     this.added[this.last] = d;
/* 27 */     this.last = (byte)(this.last + 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void remove(int tx, int ty) {
/* 33 */     for (int i = 0; i < this.last; i++) {
/* 34 */       Light q = Light.init(this.added[i]);
/* 35 */       if (q.tx() == tx && q.ty() == ty) {
/* 36 */         if (i < this.last)
/* 37 */           this.added[i] = this.added[this.last - 1]; 
/* 38 */         this.last = (byte)(this.last - 1);
/* 39 */         i--;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   boolean is(int tx, int ty) {
/* 47 */     for (int i = 0; i < this.last; i++) {
/* 48 */       Light q = Light.init(this.added[i]);
/* 49 */       if (q.tx() == tx && q.ty() == ty) {
/* 50 */         return true;
/*    */       }
/*    */     } 
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 59 */     this.last = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 64 */     file.i(this.last);
/* 65 */     for (int i = 0; i < this.last; i++) {
/* 66 */       file.l(this.added[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 72 */     this.last = 0;
/* 73 */     int k = file.i();
/* 74 */     for (int i = 0; i < k; i++)
/* 75 */       add(file.l()); 
/*    */   }
/*    */   
/*    */   public int last() {
/* 79 */     return this.last;
/*    */   }
/*    */   
/*    */   public long get(int i) {
/* 83 */     return this.added[i];
/*    */   }
/*    */   
/*    */   public void set(int i, long d) {
/* 87 */     this.added[i] = d;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\PointMapQuadrant.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */