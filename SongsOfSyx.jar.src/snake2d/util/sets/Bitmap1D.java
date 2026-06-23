/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ public class Bitmap1D
/*     */   implements SAVABLE
/*     */ {
/*     */   private final int[] bits;
/*     */   private final int max;
/*  14 */   static int[] masks = Alloc.ii(32);
/*  15 */   static int[] imasks = Alloc.ii(32);
/*     */   private final boolean outof;
/*     */   
/*     */   static {
/*  19 */     int m = 1;
/*  20 */     for (int i = 0; i < 32; i++) {
/*  21 */       masks[i] = m;
/*  22 */       imasks[i] = m ^ 0xFFFFFFFF;
/*  23 */       m <<= 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void save(FilePutter fp) {
/*  29 */     fp.isE(this.bits);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void load(FileGetter fp) throws IOException {
/*  34 */     fp.isE(this.bits);
/*     */   }
/*     */   
/*     */   public Bitmap1D(int size, boolean outof) {
/*  38 */     this.max = size;
/*  39 */     int l = size / 32;
/*  40 */     if (size % 32 != 0)
/*  41 */       l++; 
/*  42 */     this.bits = Alloc.ii(l);
/*  43 */     this.outof = outof;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean get(int bit) {
/*  48 */     if (bit < 0 || bit >= this.max) {
/*  49 */       return this.outof;
/*     */     }
/*  51 */     int m = bit & 0x1F;
/*  52 */     int i = bit >> 5;
/*     */     
/*  54 */     return ((this.bits[i] & masks[m]) == masks[m]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTrue(int bit) {
/*  60 */     if (bit < 0 || bit >= this.max) {
/*     */       return;
/*     */     }
/*  63 */     int m = bit & 0x1F;
/*  64 */     int i = bit >> 5;
/*  65 */     this.bits[i] = this.bits[i] | masks[m];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFalse(int bit) {
/*  71 */     if (bit < 0 || bit >= this.max) {
/*     */       return;
/*     */     }
/*  74 */     int m = bit & 0x1F;
/*  75 */     int i = bit >> 5;
/*  76 */     this.bits[i] = this.bits[i] & imasks[m];
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int bit, boolean bool) {
/*  81 */     if (bool) {
/*  82 */       setTrue(bit);
/*     */     } else {
/*  84 */       setFalse(bit);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void toggle(int bit) {
/*  89 */     set(bit, !get(bit));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  95 */     for (int i = 0; i < this.bits.length; i++)
/*  96 */       this.bits[i] = 0; 
/*     */   }
/*     */   
/*     */   public int size() {
/* 100 */     return this.max;
/*     */   }
/*     */   
/*     */   public void setAll(boolean b) {
/* 104 */     int k = b ? -1 : 0;
/* 105 */     for (int i = 0; i < this.bits.length; i++)
/* 106 */       this.bits[i] = k; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Bitmap1D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */