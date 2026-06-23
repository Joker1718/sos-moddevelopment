/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ public class ArrayInt
/*     */   implements SAVABLE
/*     */ {
/*     */   private final int[] data;
/*     */   
/*     */   public ArrayInt(int size) {
/*  15 */     this.data = Alloc.ii(size);
/*     */   }
/*     */   
/*     */   public ArrayInt(LIST<?> li) {
/*  19 */     this.data = Alloc.ii(li.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  24 */     file.isE(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  29 */     file.isE(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  34 */     setAll(0);
/*     */   }
/*     */   
/*     */   public int get(int i) {
/*  38 */     return this.data[i];
/*     */   }
/*     */   
/*     */   public int get(INDEXED i) {
/*  42 */     return get(i.index());
/*     */   }
/*     */   
/*     */   public ArrayInt setAll(int v) {
/*  46 */     for (int i = 0; i < this.data.length; i++)
/*  47 */       this.data[i] = v; 
/*  48 */     return this;
/*     */   }
/*     */   
/*     */   public ArrayInt set(int i, int v) {
/*  52 */     this.data[i] = v;
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public ArrayInt set(INDEXED i, int v) {
/*  57 */     return set(i.index(), v);
/*     */   }
/*     */   
/*     */   public ArrayInt inc(int i, int d) {
/*  61 */     this.data[i] = this.data[i] + d;
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public ArrayInt inc(INDEXED i, int d) {
/*  66 */     return inc(i.index(), d);
/*     */   }
/*     */   
/*     */   public static class ArrayInt2D
/*     */     implements SAVABLE {
/*     */     private final ArrayInt[] ints;
/*     */     
/*     */     public ArrayInt2D(int h, int w) {
/*  74 */       this.ints = new ArrayInt[h];
/*  75 */       for (int i = 0; i < h; i++)
/*  76 */         this.ints[i] = new ArrayInt(w); 
/*     */     }
/*     */     
/*     */     public void save(FilePutter file) { byte b;
/*     */       int i;
/*     */       ArrayInt[] arrayOfArrayInt;
/*  82 */       for (i = (arrayOfArrayInt = this.ints).length, b = 0; b < i; ) { ArrayInt arrayInt = arrayOfArrayInt[b];
/*  83 */         arrayInt.save(file);
/*     */         b++; }
/*     */        } public void load(FileGetter file) throws IOException { byte b;
/*     */       int i;
/*     */       ArrayInt[] arrayOfArrayInt;
/*  88 */       for (i = (arrayOfArrayInt = this.ints).length, b = 0; b < i; ) { ArrayInt arrayInt = arrayOfArrayInt[b];
/*  89 */         arrayInt.load(file);
/*     */         b++; }
/*     */        } public void clear() { byte b;
/*     */       int i;
/*     */       ArrayInt[] arrayOfArrayInt;
/*  94 */       for (i = (arrayOfArrayInt = this.ints).length, b = 0; b < i; ) { ArrayInt arrayInt = arrayOfArrayInt[b];
/*  95 */         arrayInt.clear(); b++; }
/*     */        } public ArrayInt2D setAll(int v) { byte b;
/*     */       int i;
/*     */       ArrayInt[] arrayOfArrayInt;
/*  99 */       for (i = (arrayOfArrayInt = this.ints).length, b = 0; b < i; ) { ArrayInt arrayInt = arrayOfArrayInt[b];
/* 100 */         arrayInt.setAll(v); b++; }
/* 101 */        return this; }
/*     */ 
/*     */     
/*     */     public ArrayInt get(int i) {
/* 105 */       return this.ints[i];
/*     */     }
/*     */     
/*     */     public ArrayInt get(INDEXED i) {
/* 109 */       return this.ints[i.index()];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayInt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */