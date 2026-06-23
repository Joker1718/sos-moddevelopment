/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ public class ArrayCooShort
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final short[] coos;
/*     */   private final int size;
/*  16 */   private final Coord coo = new Coord(null);
/*     */   private int i;
/*     */   
/*     */   public ArrayCooShort(int size) {
/*  20 */     this.size = size;
/*  21 */     this.coos = new short[size * 2];
/*     */   }
/*     */   
/*     */   public final void save(FilePutter fp) {
/*  25 */     fp.ss(this.coos);
/*  26 */     fp.i(this.i);
/*     */   }
/*     */   
/*     */   public final void load(FileGetter fp) throws IOException {
/*  30 */     fp.ss(this.coos);
/*  31 */     this.i = fp.i();
/*  32 */     set(this.i);
/*     */   }
/*     */   
/*     */   public COORDINATEE get() {
/*  36 */     return (COORDINATEE)this.coo;
/*     */   }
/*     */   
/*     */   public int getI() {
/*  40 */     return this.i;
/*     */   }
/*     */   
/*     */   public COORDINATEE set(int i) {
/*  44 */     if (i < 0 || i >= this.size)
/*  45 */       throw new RuntimeException(String.valueOf(i) + " " + this.size); 
/*  46 */     this.i = i;
/*  47 */     return (COORDINATEE)this.coo;
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/*  51 */     return (this.i < this.size - 1);
/*     */   }
/*     */   
/*     */   public COORDINATEE next() {
/*  55 */     return set(this.i + 1);
/*     */   }
/*     */   
/*     */   public int size() {
/*  59 */     return this.size;
/*     */   }
/*     */   
/*     */   public void copy(ArrayCooShort other) {
/*  63 */     if (this.size != other.size) {
/*  64 */       throw new RuntimeException();
/*     */     }
/*  66 */     for (int i = 0; i < this.coos.length; i++) {
/*  67 */       this.coos[i] = other.coos[i];
/*     */     }
/*  69 */     set(0);
/*     */   }
/*     */   
/*     */   public int x(int i) {
/*  73 */     return this.coos[i];
/*     */   }
/*     */   
/*     */   public int y(int i) {
/*  77 */     return this.coos[i + this.size];
/*     */   }
/*     */   
/*     */   private class Coord
/*     */     extends COORDINATEE.Abs implements Serializable {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private Coord() {}
/*     */     
/*     */     public int x() {
/*  87 */       return ArrayCooShort.this.coos[ArrayCooShort.this.i];
/*     */     }
/*     */ 
/*     */     
/*     */     public int y() {
/*  92 */       return ArrayCooShort.this.coos[ArrayCooShort.this.i + ArrayCooShort.this.size];
/*     */     }
/*     */ 
/*     */     
/*     */     public void xSet(double x) {
/*  97 */       ArrayCooShort.this.coos[ArrayCooShort.this.i] = (short)(int)x;
/*     */     }
/*     */ 
/*     */     
/*     */     public void ySet(double y) {
/* 102 */       ArrayCooShort.this.coos[ArrayCooShort.this.i + ArrayCooShort.this.size] = (short)(int)y;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 107 */       return "COORD " + x() + " " + y();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void swap(int i1, int i2) {
/* 113 */     short x = this.coos[i2];
/* 114 */     short y = this.coos[i2 + this.size];
/*     */     
/* 116 */     this.coos[i2] = this.coos[i1];
/* 117 */     this.coos[i2 + this.size] = this.coos[i1 + this.size];
/*     */     
/* 119 */     this.coos[i1] = x;
/* 120 */     this.coos[i1 + this.size] = y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shuffle(int max) {
/* 125 */     for (int i = 0; i < max; i++) {
/* 126 */       swap(RND.rInt(max), RND.rInt(max));
/*     */     }
/*     */   }
/*     */   
/*     */   public void shuffle(int from, int to) {
/* 131 */     int d = to - from;
/* 132 */     for (int i = from; i < to; i++) {
/* 133 */       swap(from + RND.rInt(d), from + RND.rInt(d));
/*     */     }
/*     */   }
/*     */   
/*     */   public void inc() {
/* 138 */     this.i++;
/* 139 */     this.i %= this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dec() {
/* 144 */     this.i--;
/* 145 */     if (this.i <= 0)
/* 146 */       this.i = 0; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayCooShort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */