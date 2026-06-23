/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import snake2d.util.misc.Sort;
/*     */ 
/*     */ public class ArrayListResize<E>
/*     */   implements LISTE<E>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Object[] es;
/*  14 */   private final Iter<E> iterator = new Iter<>(null);
/*  15 */   private final IterReverse<E> iteratorReverse = new IterReverse<>(null);
/*     */   private final int maxSize;
/*     */   private final int minSize;
/*  18 */   private int last = 0;
/*     */   
/*     */   private transient Comparator<E> c;
/*     */   
/*     */   private transient Comparator<Object> co;
/*     */   
/*     */   public ArrayListResize(int minSize, int maxSize) {
/*  25 */     this.maxSize = maxSize;
/*  26 */     this.minSize = minSize;
/*  27 */     this.es = new Object[minSize];
/*     */   }
/*     */   
/*     */   public ArrayListResize(int minSize) {
/*  31 */     this.maxSize = Integer.MAX_VALUE;
/*  32 */     this.minSize = minSize;
/*  33 */     this.es = new Object[minSize];
/*     */   }
/*     */ 
/*     */   
/*     */   private void increase() {
/*  38 */     if (this.last == this.es.length - 1 && this.es.length != this.maxSize) {
/*  39 */       int size = this.es.length * 2;
/*  40 */       if (size > this.maxSize)
/*  41 */         size = this.maxSize; 
/*  42 */       Object[] esNew = new Object[size];
/*  43 */       for (int i = 0; i < this.last; i++) {
/*  44 */         esNew[i] = this.es[i];
/*     */       }
/*  46 */       this.es = esNew;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void decrease() {
/*  51 */     if (this.es.length != this.minSize && this.last < this.es.length / 2) {
/*  52 */       int size = this.es.length / 2;
/*  53 */       if (size < this.minSize)
/*  54 */         size = this.minSize; 
/*  55 */       Object[] esNew = new Object[size];
/*  56 */       for (int i = 0; i < this.last; i++) {
/*  57 */         esNew[i] = this.es[i];
/*     */       }
/*  59 */       this.es = esNew;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int index) {
/*  66 */     if (index < this.last)
/*  67 */       return (E)this.es[index]; 
/*  68 */     throw new NoSuchElementException("no element at index: " + index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(E e) {
/*  78 */     int i = tryAdd(e);
/*  79 */     if (i == -1)
/*  80 */       throw new RuntimeException(hasRoom()); 
/*  81 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tryAdd(E e) {
/*  86 */     increase();
/*  87 */     if (!hasRoom())
/*  88 */       return -1; 
/*  89 */     this.es[this.last] = e;
/*  90 */     this.last++;
/*  91 */     return this.last - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E remove(int i) {
/* 101 */     if (i >= this.last) {
/* 102 */       return null;
/*     */     }
/*     */     
/* 105 */     E e = (E)this.es[i];
/*     */     
/* 107 */     if (i == this.last - 1) {
/* 108 */       this.es[this.last - 1] = null;
/* 109 */       this.last--;
/* 110 */       decrease();
/* 111 */       return e;
/*     */     } 
/*     */     
/* 114 */     this.es[i] = this.es[this.last - 1];
/* 115 */     this.es[this.last - 1] = null;
/* 116 */     this.last--;
/* 117 */     if (this.iterator.current == i + 1)
/* 118 */       this.iterator.current = this.iterator.current - 1; 
/* 119 */     decrease();
/* 120 */     return e;
/*     */   }
/*     */   
/*     */   public int removeOrdered(E object) {
/* 124 */     for (int i = 0; i < this.last; i++) {
/* 125 */       if (this.es[i] == object) {
/* 126 */         removeOrdered(i);
/* 127 */         return i;
/*     */       } 
/*     */     } 
/* 130 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public E removeOrdered(int i) {
/* 135 */     if (i >= this.last) {
/* 136 */       return null;
/*     */     }
/* 138 */     if (i == this.last - 1) {
/*     */       
/* 140 */       E e1 = (E)this.es[this.last - 1];
/* 141 */       this.es[this.last - 1] = null;
/* 142 */       this.last--;
/* 143 */       return e1;
/*     */     } 
/*     */ 
/*     */     
/* 147 */     E e = (E)this.es[i];
/*     */     
/* 149 */     for (int k = i; k < this.last - 1; k++) {
/* 150 */       this.es[k] = this.es[k + 1];
/*     */     }
/*     */     
/* 153 */     this.es[this.last - 1] = null;
/* 154 */     this.last--;
/* 155 */     if (this.iterator.current >= i)
/* 156 */       this.iterator.current = this.iterator.current - 1; 
/* 157 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(E object) {
/* 166 */     for (int i = 0; i < this.last; i++) {
/* 167 */       if (this.es[i] == object)
/* 168 */         return (remove(i) != null); 
/*     */     } 
/* 170 */     return false;
/*     */   }
/*     */   
/*     */   public int remainingSlots() {
/* 174 */     return this.maxSize - this.last;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasRoom() {
/* 179 */     return (remainingSlots() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/* 184 */     return (i < this.last);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(E object) {
/* 190 */     for (int i = 0; i < this.last; i++) {
/* 191 */       if (this.es[i] == object)
/* 192 */         return true; 
/*     */     } 
/* 194 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 202 */     if (this.es.length != this.minSize)
/* 203 */       this.es = new Object[this.minSize]; 
/* 204 */     this.last = 0;
/*     */   }
/*     */   
/*     */   public void clearSoft() {
/* 208 */     this.last = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 213 */     return this.last;
/*     */   }
/*     */   
/*     */   public int max() {
/* 217 */     return this.maxSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iter<E> iterator() {
/* 222 */     this.iterator.init();
/* 223 */     return this.iterator;
/*     */   }
/*     */   
/*     */   public Iterator<E> iteratorReverse() {
/* 227 */     this.iteratorReverse.init();
/* 228 */     return this.iteratorReverse;
/*     */   }
/*     */   
/*     */   public void iteratorRemoveCurrent() {
/* 232 */     remove(this.iterator.current - 1);
/*     */   }
/*     */   
/*     */   private class Iter<T>
/*     */     implements Iterator<E>, Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private void init() {
/* 241 */       this.current = 0;
/*     */     }
/*     */     private int current;
/*     */     private Iter() {}
/*     */     public boolean hasNext() {
/* 246 */       return (this.current < ArrayListResize.this.last);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E next() {
/* 252 */       return (E)ArrayListResize.this.es[this.current++];
/*     */     }
/*     */   }
/*     */   
/*     */   private class IterReverse<T>
/*     */     implements Iterator<E>, Serializable {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private int current;
/*     */     
/*     */     private IterReverse() {}
/*     */     
/*     */     private void init() {
/* 264 */       this.current = ArrayListResize.this.last - 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 269 */       return (this.current >= 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E next() {
/* 275 */       return (E)ArrayListResize.this.es[this.current--];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 282 */     return (this.last == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void trim() {
/* 287 */     Object[] no = new Object[this.last];
/* 288 */     for (int i = 0; i < this.last; i++)
/* 289 */       no[i] = this.es[i]; 
/* 290 */     this.es = no;
/*     */   }
/*     */   
/*     */   public E getLast() {
/* 294 */     return get(this.last - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sort(Comparator<E> c) {
/* 301 */     if (this.last <= 1)
/*     */       return; 
/* 303 */     if (this.co == null) {
/* 304 */       this.co = new Comparator()
/*     */         {
/*     */           public int compare(Object o1, Object o2)
/*     */           {
/* 308 */             return ArrayListResize.this.c.compare(o1, o2);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/* 313 */     this.c = c;
/* 314 */     Sort.sort(this.es, 0, this.last - 1, this.co);
/*     */   }
/*     */   
/*     */   public void swap(int indexA, int indexB) {
/* 318 */     if (indexA < 0 || indexB >= size() || indexB < 0 || indexB >= size())
/* 319 */       throw new RuntimeException(); 
/* 320 */     Object a = this.es[indexA];
/* 321 */     this.es[indexA] = this.es[indexB];
/* 322 */     this.es[indexB] = a;
/*     */   }
/*     */   
/*     */   public void shiftRight() {
/* 326 */     if (isEmpty())
/*     */       return; 
/* 328 */     E e = get(size() - 1);
/* 329 */     for (int i = size() - 1; i > 0; i--) {
/* 330 */       this.es[i] = this.es[i - 1];
/*     */     }
/* 332 */     this.es[0] = e;
/*     */   }
/*     */   
/*     */   public void replace(int index, E e2) {
/* 336 */     this.es[index] = e2;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayListResize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */