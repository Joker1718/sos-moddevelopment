/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import snake2d.util.misc.Sort;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayListGrower<E>
/*     */   implements LISTE<E>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private Object[] es = new Object[0];
/*  17 */   private final Iter<E> iterator = new Iter<>(null);
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Comparator<E> c;
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Comparator<Object> co;
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int index) {
/*  30 */     if (index < this.es.length)
/*  31 */       return (E)this.es[index]; 
/*  32 */     throw new NoSuchElementException("no element at index: " + index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(E e) {
/*  42 */     return tryAdd(e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int tryAdd(E e) {
/*  48 */     Object[] nn = new Object[this.es.length + 1];
/*  49 */     for (int i = 0; i < this.es.length; i++) {
/*  50 */       nn[i] = this.es[i];
/*     */     }
/*  52 */     nn[this.es.length] = e;
/*  53 */     this.es = nn;
/*  54 */     return this.es.length - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasRoom() {
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/*  64 */     return (i < this.es.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(E object) {
/*  70 */     return (firstIndexOf(object) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  78 */     this.es = new Object[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  84 */     return this.es.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iter<E> iterator() {
/*  89 */     this.iterator.init();
/*  90 */     return this.iterator;
/*     */   }
/*     */   
/*     */   private class Iter<T>
/*     */     implements Iterator<E>, Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private void init() {
/*  99 */       this.current = 0;
/*     */     }
/*     */     private int current;
/*     */     private Iter() {}
/*     */     public boolean hasNext() {
/* 104 */       return (this.current < ArrayListGrower.this.es.length);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E next() {
/* 110 */       return (E)ArrayListGrower.this.es[this.current++];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 118 */     return (this.es.length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void swap(int indexA, int indexB) {
/* 123 */     if (indexA < 0 || indexB >= size() || indexB < 0 || indexB >= size())
/* 124 */       throw new RuntimeException(); 
/* 125 */     Object a = this.es[indexA];
/* 126 */     this.es[indexA] = this.es[indexB];
/* 127 */     this.es[indexB] = a;
/*     */   }
/*     */   
/*     */   public void shiftRight() {
/* 131 */     if (isEmpty())
/*     */       return; 
/* 133 */     E e = get(size() - 1);
/* 134 */     for (int i = size() - 1; i > 0; i--) {
/* 135 */       this.es[i] = this.es[i - 1];
/*     */     }
/* 137 */     this.es[0] = e;
/*     */   }
/*     */   
/*     */   public void replace(int index, E e2) {
/* 141 */     this.es[index] = e2;
/*     */   }
/*     */   
/*     */   public boolean remove(E remove) {
/* 145 */     int i = firstIndexOf(remove);
/* 146 */     if (i < 0)
/* 147 */       return false; 
/* 148 */     remove(i);
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   public int firstIndexOf(E e) {
/* 153 */     for (int i = 0; i < this.es.length; i++) {
/* 154 */       if (this.es[i] == e)
/* 155 */         return i; 
/*     */     } 
/* 157 */     return -1;
/*     */   }
/*     */   
/*     */   public void remove(int index) {
/* 161 */     if (index < 0 || index >= size())
/* 162 */       throw new RuntimeException(index); 
/* 163 */     Object[] nn = new Object[this.es.length - 1];
/*     */     
/* 165 */     int oi = 0;
/* 166 */     for (int i = 0; i < this.es.length; i++) {
/* 167 */       if (i != index) {
/*     */         
/* 169 */         nn[oi] = this.es[i];
/* 170 */         oi++;
/*     */       } 
/* 172 */     }  this.es = nn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sort(Comparator<E> c) {
/* 179 */     this.c = c;
/* 180 */     if (this.co == null) {
/* 181 */       this.co = new Comparator()
/*     */         {
/*     */           public int compare(Object o1, Object o2)
/*     */           {
/* 185 */             return ArrayListGrower.this.c.compare(o1, o2);
/*     */           }
/*     */         };
/*     */     }
/* 189 */     Sort.sort(this.es, this.co);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayListGrower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */