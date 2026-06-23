/*     */ package util.data;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ public interface INT extends DOUBLE {
/*     */   int get();
/*     */   
/*     */   int min();
/*     */   
/*     */   int max();
/*     */   
/*     */   default double getD() {
/*  17 */     if (get() < 0) {
/*  18 */       if (min() == 0)
/*  19 */         return 0.0D; 
/*  20 */       return get() / min();
/*  21 */     }  if (get() > 0) {
/*  22 */       if (max() == 0)
/*  23 */         return 0.0D; 
/*  24 */       return get() / max();
/*     */     } 
/*  26 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface INTE
/*     */     extends INT, DOUBLE.DOUBLE_MUTABLE
/*     */   {
/*     */     default void inc(int i) {
/*  34 */       set(CLAMP.i(get() + i, min(), max()));
/*     */     }
/*     */ 
/*     */     
/*     */     default INTE incD(double d) {
/*  39 */       int i = (int)(max() * d);
/*  40 */       if (i == 0)
/*  41 */         if (d < 0.0D) {
/*  42 */           i = -1;
/*     */         } else {
/*  44 */           i = 1;
/*  45 */         }   inc(i);
/*  46 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     default DOUBLE.DOUBLE_MUTABLE setD(double d) {
/*  51 */       set((int)Math.ceil(d * max()));
/*  52 */       return this;
/*     */     }
/*     */     
/*     */     void set(int param1Int); }
/*     */   
/*     */   public static class IntImp implements INTE, SAVABLE {
/*     */     public int i;
/*     */     public int min;
/*     */     public int max;
/*     */     
/*     */     public IntImp() {
/*  63 */       this(-2147483648, 2147483647);
/*     */     }
/*     */     
/*     */     public IntImp(int min, int max) {
/*  67 */       this.min = min;
/*  68 */       this.max = max;
/*  69 */       this.i = CLAMP.i(this.i, min, max);
/*     */     }
/*     */     
/*     */     public IntImp(int i, int min, int max) {
/*  73 */       this.min = min;
/*  74 */       this.max = max;
/*  75 */       i = CLAMP.i(i, min, max);
/*  76 */       this.i = i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int get() {
/*  82 */       return this.i;
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/*  87 */       return this.min;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max() {
/*  92 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/*  97 */       this.i = CLAMP.i(t, min(), max());
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 102 */       file.i(this.i);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 108 */       this.i = file.i();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 113 */       this.i = 0;
/*     */     }
/*     */     
/*     */     public boolean isMax() {
/* 117 */       return (get() >= this.max);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\INT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */