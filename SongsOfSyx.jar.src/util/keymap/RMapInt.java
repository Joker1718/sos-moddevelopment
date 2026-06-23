/*     */ package util.keymap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ 
/*     */ public class RMapInt<T extends MAPPED>
/*     */   implements INT_O.INT_OE<T>, SAVABLE {
/*     */   private final RMAPS<T> map;
/*     */   private final int min;
/*     */   private final int max;
/*     */   private final int[] data;
/*     */   private int total;
/*     */   private final int clearTo;
/*     */   private INFO info;
/*     */   
/*     */   public RMapInt(RMAPS<T> map) {
/*  25 */     this(map, -2147483648, 2147483647);
/*     */   }
/*     */   
/*     */   public RMapInt(RMAPS<T> map, int min, int max) {
/*  29 */     this(map, min, max, 0);
/*     */   }
/*     */   
/*     */   public RMapInt(RMAPS<T> map, int min, int max, int clearTo) {
/*  33 */     this.map = map;
/*  34 */     this.min = min;
/*  35 */     this.max = max;
/*  36 */     this.data = Alloc.ii(map.all().size());
/*  37 */     this.clearTo = clearTo;
/*  38 */     Arrays.fill(this.data, clearTo);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  43 */     this.map.saver().save(this.data, file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  48 */     this.map.loader().load(this.data, file, 0); byte b; int i, arrayOfInt[];
/*  49 */     for (i = (arrayOfInt = this.data).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*  50 */       this.total += j;
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void clear() {
/*  55 */     Arrays.fill(this.data, this.clearTo);
/*  56 */     this.total = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(T t) {
/*  61 */     if (t == null)
/*  62 */       return this.total; 
/*  63 */     return this.data[t.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(T t) {
/*  68 */     return this.min;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(T t) {
/*  73 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RMapInt<T> setInfo(CharSequence name) {
/*  79 */     this.info = new INFO(name, name);
/*  80 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/*  85 */     return this.info;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(T t, int i) {
/*  91 */     this.total -= this.data[t.index()];
/*  92 */     this.data[t.index()] = i;
/*  93 */     this.total += this.data[t.index()];
/*     */   }
/*     */   
/*     */   public void setAll(int v) {
/*  97 */     Arrays.fill(this.data, v);
/*  98 */     this.total = v * this.data.length;
/*     */   }
/*     */   
/*     */   public static class RMapIntTwo<A extends MAPPED, B extends MAPPED>
/*     */     implements GETTER_TRANS<A, RMapInt<B>>, SAVABLE {
/*     */     private final ArrayList<RMapInt<B>> all;
/*     */     private final RMAPS<A> map;
/*     */     private final SAVABLE[] ss;
/*     */     
/*     */     public RMapIntTwo(RMAPS<A> map, RMAPS<B> map2) {
/* 108 */       this(map, map2, -2147483648, 2147483647);
/*     */     }
/*     */     
/*     */     public RMapIntTwo(RMAPS<A> map, RMAPS<B> map2, int min, int max) {
/* 112 */       this.map = map;
/* 113 */       this.all = new ArrayList(map.all().size());
/* 114 */       this.ss = new SAVABLE[map.all().size()];
/* 115 */       for (int i = 0; i < this.ss.length; i++) {
/* 116 */         RMapInt<B> b = new RMapInt<>(map2, min, max);
/* 117 */         this.ss[i] = b;
/* 118 */         this.all.add(b);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 124 */       this.map.saver().save(this.ss, file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 129 */       this.map.loader().load(this.ss, file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 134 */       for (RMapInt<B> b : this.all) {
/* 135 */         b.clear();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public RMapInt<B> get(A f) {
/* 141 */       return (RMapInt<B>)this.all.get(f.index());
/*     */     }
/*     */     
/*     */     public void setAll(int v) {
/* 145 */       for (RMapInt<B> b : this.all)
/* 146 */         b.setAll(v); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMapInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */