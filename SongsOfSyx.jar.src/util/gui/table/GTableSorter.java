/*     */ package util.gui.table;
/*     */ 
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GTableSorter<T>
/*     */ {
/*     */   private final Object[] pop;
/*     */   private final Tree<T> tree;
/*     */   private int popI;
/*     */   private int sortI;
/*     */   protected GTSort<T> sort;
/*     */   protected GTFilter<T> filter;
/*     */   
/*     */   public GTableSorter(int max) {
/*  20 */     this.pop = new Object[max];
/*  21 */     this.tree = new Tree<T>(max)
/*     */       {
/*     */         protected boolean isGreaterThan(T current, T cmp)
/*     */         {
/*  25 */           if (GTableSorter.this.sort == null)
/*     */           {
/*  27 */             return true;
/*     */           }
/*  29 */           int c = GTableSorter.this.sort.cmp(current, cmp);
/*  30 */           return (c <= 0);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void sort() {
/*  36 */     this.sortI--;
/*  37 */     if (this.sortI > 0)
/*     */       return; 
/*  39 */     this.sortI = 64;
/*  40 */     this.popI = 0;
/*  41 */     this.tree.clear();
/*  42 */     for (int i = 0; i < this.pop.length; i++) {
/*  43 */       T t = getUnsorted(i);
/*  44 */       if (t != null && (
/*  45 */         this.filter == null || this.filter.passes(t))) {
/*  46 */         this.tree.add(t);
/*     */       }
/*     */     } 
/*  49 */     while (this.tree.hasMore()) {
/*  50 */       this.pop[this.popI++] = this.tree.pollGreatest();
/*     */     }
/*     */   }
/*     */   
/*     */   public void sortForced() {
/*  55 */     this.sortI = 0;
/*  56 */     sort();
/*     */   }
/*     */   
/*     */   protected abstract T getUnsorted(int paramInt);
/*     */   
/*     */   public int size() {
/*  62 */     return this.popI;
/*     */   }
/*     */ 
/*     */   
/*     */   public T get(int index) {
/*  67 */     if (index >= 0 && index < this.popI) {
/*  68 */       return (T)this.pop[index];
/*     */     }
/*  70 */     return null;
/*     */   }
/*     */   
/*     */   public T get(GETTER<Integer> getter) {
/*  74 */     return get(((Integer)getter.get()).intValue());
/*     */   }
/*     */   
/*     */   public int getIndex(T t) {
/*  78 */     for (int i = 0; i < this.popI; i++) {
/*  79 */       if (t == this.pop[i])
/*  80 */         return i; 
/*  81 */     }  return 0;
/*     */   }
/*     */   
/*     */   public void setFilter(GTFilter<T> filter) {
/*  85 */     this.filter = filter;
/*  86 */     this.sortI = 0;
/*  87 */     sort();
/*     */   }
/*     */   
/*     */   public void setSort(GTSort<T> sort) {
/*  91 */     this.sort = sort;
/*  92 */     this.sortI = 0;
/*  93 */     sort();
/*     */   }
/*     */   
/*     */   public GTSort<T> currentSort() {
/*  97 */     return this.sort;
/*     */   }
/*     */   
/*     */   public GTFilter<T> currentFilter() {
/* 101 */     return this.filter;
/*     */   }
/*     */   
/*     */   public static abstract class GTFilter<T>
/*     */   {
/*     */     public final CharSequence name;
/*     */     
/*     */     public GTFilter(CharSequence name) {
/* 109 */       this.name = name;
/*     */     }
/*     */     
/*     */     public abstract boolean passes(T param1T);
/*     */   }
/*     */   
/*     */   public static abstract class GTSort<T> {
/*     */     public final CharSequence name;
/*     */     
/*     */     public GTSort(CharSequence name) {
/* 119 */       this.name = name;
/*     */     }
/*     */     
/*     */     public abstract int cmp(T param1T1, T param1T2);
/*     */     
/*     */     public abstract void format(T param1T, GText param1GText);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GTableSorter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */