/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.Sort;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayList<E>
/*     */   implements LISTE<E>, SAVABLE, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Object[] es;
/*  29 */   private final Iter<E> iterator = new Iter<>();
/*     */   private final int size;
/*  31 */   private int last = 0;
/*     */   
/*     */   private transient Comparator<E> c;
/*     */   
/*     */   private transient Comparator<Object> co;
/*     */   
/*     */   public ArrayList(int size) {
/*  38 */     this.size = size;
/*  39 */     this.es = new Object[size];
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList(E first) {
/*  44 */     this.size = 1;
/*  45 */     this.es = new Object[1];
/*  46 */     this.last = this.size;
/*  47 */     this.es[0] = first;
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends E> ArrayList(Iterable<T> other) {
/*  52 */     int i = 0;
/*  53 */     for (T e : other)
/*  54 */       i++; 
/*  55 */     this.es = new Object[i];
/*  56 */     i = 0;
/*  57 */     for (T e : other) {
/*  58 */       this.es[i] = e;
/*  59 */       i++;
/*     */     } 
/*  61 */     this.size = i;
/*  62 */     this.last = this.size;
/*     */   }
/*     */   
/*     */   @SafeVarargs
/*     */   public <T extends E> ArrayList(Object... es) {
/*  67 */     this.es = es;
/*  68 */     this.size = es.length;
/*  69 */     this.last = this.size;
/*     */   }
/*     */   
/*     */   public int indexOf(E t) {
/*  73 */     for (int i = 0; i < this.last; i++) {
/*  74 */       if (this.es[i] == t)
/*  75 */         return i; 
/*     */     } 
/*  77 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int index) {
/*  83 */     if (index < this.last)
/*  84 */       return (E)this.es[index]; 
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public E last() {
/*  90 */     if (size() > 0)
/*  91 */       return (E)this.es[this.last - 1]; 
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(E e) {
/* 102 */     if (!hasRoom())
/* 103 */       throw new RuntimeException("I'm full! " + this.last + " " + this.size); 
/* 104 */     this.es[this.last] = e;
/* 105 */     this.last++;
/* 106 */     return this.last - 1;
/*     */   }
/*     */   
/*     */   public void addNull() {
/* 110 */     if (!hasRoom())
/* 111 */       throw new RuntimeException("I'm full!"); 
/* 112 */     this.es[this.last] = null;
/* 113 */     this.last++;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tryAdd(E e) {
/* 118 */     if (!hasRoom())
/* 119 */       return -1; 
/* 120 */     this.es[this.last] = e;
/* 121 */     this.last++;
/* 122 */     return this.last - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E remove(int i) {
/* 132 */     if (i >= this.last) {
/* 133 */       return null;
/*     */     }
/* 135 */     if (i == this.last - 1) {
/*     */       
/* 137 */       E e1 = (E)this.es[this.last - 1];
/* 138 */       this.es[this.last - 1] = null;
/* 139 */       this.last--;
/* 140 */       return e1;
/*     */     } 
/*     */ 
/*     */     
/* 144 */     E e = (E)this.es[i];
/* 145 */     this.es[i] = this.es[this.last - 1];
/* 146 */     this.es[this.last - 1] = null;
/* 147 */     this.last--;
/* 148 */     if (this.iterator.current == i + 1)
/* 149 */       this.iterator.current = this.iterator.current - 1; 
/* 150 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public E removeOrdered(int i) {
/* 155 */     if (i >= this.last) {
/* 156 */       return null;
/*     */     }
/* 158 */     if (i == this.last - 1) {
/*     */       
/* 160 */       E e1 = (E)this.es[this.last - 1];
/* 161 */       this.es[this.last - 1] = null;
/* 162 */       this.last--;
/* 163 */       return e1;
/*     */     } 
/*     */ 
/*     */     
/* 167 */     E e = (E)this.es[i];
/*     */     
/* 169 */     for (int k = i; k < this.last - 1; k++) {
/* 170 */       this.es[k] = this.es[k + 1];
/*     */     }
/*     */     
/* 173 */     this.es[this.last - 1] = null;
/* 174 */     this.last--;
/* 175 */     if (this.iterator.current >= i)
/* 176 */       this.iterator.current = this.iterator.current - 1; 
/* 177 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E remove(E object) {
/* 186 */     for (int i = 0; i < this.last; i++) {
/* 187 */       if (this.es[i] == object)
/* 188 */         return remove(i); 
/*     */     } 
/* 190 */     return null;
/*     */   }
/*     */   
/*     */   public int removeOrdered(E object) {
/* 194 */     for (int i = 0; i < this.last; i++) {
/* 195 */       if (this.es[i] == object) {
/* 196 */         removeOrdered(i);
/* 197 */         return i;
/*     */       } 
/*     */     } 
/* 200 */     return -1;
/*     */   }
/*     */   
/*     */   public int remainingSlots() {
/* 204 */     return this.size - this.last;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasRoom() {
/* 209 */     return (remainingSlots() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/* 214 */     return (i < this.size && this.es[i] != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(E object) {
/* 220 */     for (int i = 0; i < this.last; i++) {
/* 221 */       if (this.es[i] == object)
/* 222 */         return true; 
/*     */     } 
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 233 */     if (this.last > this.es.length)
/* 234 */       this.last = this.es.length; 
/* 235 */     for (int i = 0; i < this.last; i++) {
/* 236 */       this.es[i] = null;
/*     */     }
/* 238 */     this.last = 0;
/*     */   }
/*     */   
/*     */   public void clearSloppy() {
/* 242 */     this.last = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 247 */     return this.last;
/*     */   }
/*     */   
/*     */   public int max() {
/* 251 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iter<E> iterator() {
/* 256 */     this.iterator.init();
/* 257 */     return this.iterator;
/*     */   }
/*     */   
/*     */   public void iteratorRemoveCurrent() {
/* 261 */     remove(this.iterator.current - 1);
/*     */   }
/*     */   
/*     */   public class Iter<T>
/*     */     implements Iterator<E>, Serializable {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private int current;
/*     */     
/*     */     private void init() {
/* 270 */       this.current = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 275 */       return (this.current < ArrayList.this.last);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E next() {
/* 281 */       return (E)ArrayList.this.es[this.current++];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 288 */     return (this.last == 0);
/*     */   }
/*     */   
/*     */   public E removeLast() {
/* 292 */     return remove(size() - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sort(Comparator<E> c) {
/* 299 */     if (this.last <= 1)
/*     */       return; 
/* 301 */     this.c = c;
/* 302 */     if (this.co == null) {
/* 303 */       this.co = new Comparator()
/*     */         {
/*     */           public int compare(Object o1, Object o2)
/*     */           {
/* 307 */             return ArrayList.this.c.compare(o1, o2);
/*     */           }
/*     */         };
/*     */     }
/* 311 */     Sort.sort(this.es, 0, this.last, this.co);
/*     */   }
/*     */   
/*     */   public void shiftLeft() {
/* 315 */     for (int i = 1; i < this.last; i++) {
/* 316 */       this.es[i - 1] = this.es[i];
/*     */     }
/* 318 */     this.es[this.last - 1] = null;
/* 319 */     this.last--;
/*     */   }
/*     */   
/*     */   public void shiftLeft(int index) {
/* 323 */     for (int i = index + 1; i < this.last; i++) {
/* 324 */       this.es[i - 1] = this.es[i];
/*     */     }
/* 326 */     this.es[this.last - 1] = null;
/* 327 */     this.last--;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 332 */     file.i(size());
/* 333 */     for (E e : this) {
/* 334 */       file.object(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 339 */     this.last = file.i();
/* 340 */     for (int i = 0; i < this.last; i++) {
/* 341 */       this.es[i] = file.object(false);
/*     */     }
/*     */   }
/*     */   
/*     */   public void replace(int index, E object) {
/* 346 */     this.es[index] = object;
/* 347 */     if (index >= this.last)
/* 348 */       this.last = index + 1; 
/*     */   }
/*     */   
/*     */   public ArrayList<E> reverse() {
/* 352 */     int s = size() / 2;
/* 353 */     for (int i = 0; i < s; i++) {
/* 354 */       Object o = this.es[i];
/* 355 */       this.es[i] = this.es[size() - 1 - i];
/* 356 */       this.es[size() - 1 - i] = o;
/*     */     } 
/* 358 */     return this;
/*     */   }
/*     */   
/*     */   public void insert(int i, E object) {
/* 362 */     if (!hasRoom())
/* 363 */       throw new RuntimeException(); 
/* 364 */     if (i < 0 || i > this.last)
/* 365 */       throw new RuntimeException(); 
/* 366 */     for (int k = this.last; k > i; k--)
/* 367 */       this.es[k] = this.es[k - 1]; 
/* 368 */     this.es[i] = object;
/* 369 */     this.last++;
/*     */   }
/*     */   
/*     */   public void swap(int position, int position2) {
/* 373 */     Object e = this.es[position];
/* 374 */     this.es[position] = this.es[position2];
/* 375 */     this.es[position2] = e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shuffle() {
/* 380 */     if (size() <= 1) {
/*     */       return;
/*     */     }
/* 383 */     for (int i = 0; i < size(); i++) {
/* 384 */       swap(i, RND.rInt(size()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void shuffle(int start) {
/* 391 */     if (size() - start <= 1) {
/*     */       return;
/*     */     }
/* 394 */     for (int i = start; i < size(); i++)
/* 395 */       swap(i, start + RND.rInt(size() - start)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */