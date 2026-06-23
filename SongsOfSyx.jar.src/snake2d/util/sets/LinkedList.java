/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class LinkedList<E>
/*     */   implements LISTE<E>, Serializable {
/*     */   private static final long serialVersionUID = 1L;
/*   9 */   private Node<E> first = null;
/*  10 */   private Node<E> last = null;
/*  11 */   private int size = -1;
/*  12 */   private final Itr iter = new Itr(null);
/*     */   
/*     */   public LinkedList(E e) {
/*  15 */     add(e);
/*     */   }
/*     */   
/*     */   public LinkedList(Object[] e) {
/*  19 */     add((E[])e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends E> LinkedList(Iterable<T> other) {
/*  27 */     for (T e : other) {
/*  28 */       add((E)e);
/*     */     }
/*     */   }
/*     */   
/*     */   public Iterator<E> iterator() {
/*  33 */     this.iter.init();
/*  34 */     return this.iter;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int index) {
/*  40 */     if (index > this.size) {
/*  41 */       return null;
/*     */     }
/*  43 */     Node<E> n = this.first;
/*     */     
/*  45 */     while (index > 0 && n != null) {
/*  46 */       n = n.next;
/*  47 */       index--;
/*     */     } 
/*  49 */     return n.element;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRoom() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public LinkedList<E> clear() {
/*  59 */     this.first = null;
/*  60 */     this.size = -1;
/*  61 */     return this;
/*     */   }
/*     */   
/*     */   public E removeFirst() {
/*  65 */     E e = null;
/*  66 */     if (this.first != null) {
/*  67 */       e = this.first.element;
/*  68 */       this.first = this.first.next;
/*  69 */       if (this.first == null)
/*  70 */         this.last = null; 
/*  71 */       this.size--;
/*     */     } 
/*  73 */     return e;
/*     */   }
/*     */   
/*     */   public E getFirst() {
/*  77 */     if (this.first != null)
/*  78 */       return this.first.element; 
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/*  84 */     return (i > this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(E object) {
/*  89 */     for (E e : this) {
/*  90 */       if (e.equals(object))
/*  91 */         return true; 
/*     */     } 
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public void addFirst(E element) {
/*  97 */     if (this.first == null) {
/*  98 */       this.first = new Node<>(null);
/*  99 */       this.first.element = element;
/* 100 */       this.last = this.first;
/*     */     } else {
/* 102 */       Node<E> n = new Node<>(null);
/* 103 */       n.element = element;
/* 104 */       n.next = this.first;
/* 105 */       this.first = n;
/*     */     } 
/* 107 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(E element) {
/* 112 */     if (this.first == null) {
/* 113 */       this.first = new Node<>(null);
/* 114 */       this.first.element = element;
/* 115 */       this.last = this.first;
/*     */     }
/*     */     else {
/*     */       
/* 119 */       Node<E> current = new Node<>(null);
/* 120 */       current.element = element;
/* 121 */       this.last.next = current;
/* 122 */       this.last = current;
/*     */     } 
/*     */     
/* 125 */     this.size++;
/* 126 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tryAdd(E e) {
/* 131 */     return add(e);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(E element) {
/* 136 */     if (this.size < 0) {
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     if (this.first.element == element) {
/* 141 */       this.first = this.first.next;
/* 142 */       this.size--;
/* 143 */       if (this.first == null)
/* 144 */         this.last = null; 
/* 145 */       return true;
/*     */     } 
/*     */     
/* 148 */     Node<E> current = this.first;
/* 149 */     while (current.next != null) {
/* 150 */       if (current.next.element == element) {
/* 151 */         current.next = current.next.next;
/* 152 */         this.size--;
/* 153 */         if (current.next == null)
/* 154 */           this.last = current; 
/* 155 */         return true;
/*     */       } 
/* 157 */       current = current.next;
/*     */     } 
/*     */     
/* 160 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 168 */     return this.size + 1;
/*     */   }
/*     */   
/*     */   private class Itr
/*     */     implements Iterator<E>, Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private void init() {
/* 177 */       this.current = LinkedList.this.first;
/*     */     }
/*     */     private LinkedList.Node<E> current;
/*     */     private Itr() {}
/*     */     public boolean hasNext() {
/* 182 */       return (this.current != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public E next() {
/* 187 */       E e = this.current.element;
/* 188 */       this.current = this.current.next;
/* 189 */       return e;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Node<E>
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private E element;
/*     */     private Node<E> next;
/*     */     
/*     */     private Node() {}
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 205 */     return (this.size == -1);
/*     */   }
/*     */   
/*     */   public void shiftLeft() {
/* 209 */     if (this.first != null && this.first.next != null) {
/* 210 */       Node<E> n = this.first;
/* 211 */       this.first = n.next;
/* 212 */       this.last.next = n;
/* 213 */       n.next = null;
/* 214 */       this.last = n;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void shiftRight() {
/* 219 */     if (this.last != null && this.first.next != null) {
/* 220 */       Node<E> current = this.first;
/* 221 */       while (current.next != this.last) {
/* 222 */         current = current.next;
/*     */       }
/* 224 */       current.next = null;
/* 225 */       Node<E> n = this.last;
/* 226 */       this.last = current;
/* 227 */       n.next = this.first;
/* 228 */       this.first = n;
/*     */     } 
/*     */   }
/*     */   
/*     */   public LinkedList() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\LinkedList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */