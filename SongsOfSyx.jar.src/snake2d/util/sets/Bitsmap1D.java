/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Bitsmap1D
/*     */   implements SAVABLE, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final long[] bits;
/*     */   public final int outof;
/*     */   private final int max;
/*     */   private final int stride;
/*     */   private final long mask;
/*     */   
/*     */   public Bitsmap1D(int outof, int bits, int amount) {
/*  35 */     this.bits = new long[(int)Math.ceil((bits * amount) / 64.0D)];
/*  36 */     this.outof = outof;
/*  37 */     this.max = amount;
/*  38 */     this.stride = bits;
/*  39 */     this.mask = ((1 << bits) - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter fp) {
/*  44 */     fp.ls(this.bits);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter fp) throws IOException {
/*  49 */     fp.ls(this.bits);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int index) {
/*  59 */     if (index < 0 || index >= this.max) {
/*  60 */       return this.outof;
/*     */     }
/*  62 */     int i = index * this.stride;
/*     */     
/*  64 */     int l1 = i >> 6;
/*  65 */     int ls = 64 - this.stride - (i & 0x3F);
/*     */     
/*  67 */     if (ls >= 0) {
/*  68 */       return (int)(this.bits[l1] >> ls & this.mask);
/*     */     }
/*  70 */     long v = this.bits[l1] << -ls;
/*  71 */     ls += 64;
/*  72 */     v |= this.bits[l1 + 1] >>> ls;
/*     */     
/*  74 */     return (int)(v & this.mask);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  80 */     Arrays.fill(this.bits, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int index, int value) {
/*  90 */     long v = value;
/*  91 */     v &= this.mask;
/*  92 */     int i = index * this.stride;
/*     */     
/*  94 */     int l1 = i >> 6;
/*  95 */     int ls = 64 - this.stride - (i & 0x3F);
/*     */ 
/*     */ 
/*     */     
/*  99 */     if (ls >= 0) {
/* 100 */       this.bits[l1] = this.bits[l1] & (this.mask << ls ^ 0xFFFFFFFFFFFFFFFFL);
/* 101 */       this.bits[l1] = this.bits[l1] | v << ls;
/*     */     } else {
/*     */       
/* 104 */       this.bits[l1] = this.bits[l1] & (this.mask >> -ls ^ 0xFFFFFFFFFFFFFFFFL);
/* 105 */       this.bits[l1] = this.bits[l1] | v >> -ls;
/*     */       
/* 107 */       ls += 64;
/*     */       
/* 109 */       this.bits[l1 + 1] = this.bits[l1 + 1] & (this.mask << ls ^ 0xFFFFFFFFFFFFFFFFL);
/* 110 */       this.bits[l1 + 1] = this.bits[l1 + 1] | v << ls;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void inc(int index, int delta) {
/* 129 */     set(index, get(index) + delta);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAll(int value) {
/* 134 */     clear();
/* 135 */     for (int i = 0; i < this.max; i++) {
/* 136 */       set(i, value);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int maxIndex() {
/* 149 */     return this.max;
/*     */   }
/*     */   
/*     */   public int maxValue() {
/* 153 */     return (int)this.mask;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Bitsmap1D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */