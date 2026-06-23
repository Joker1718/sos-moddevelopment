/*    */ package snake2d.util.misc;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ public final class Sort
/*    */ {
/*    */   private static final int INSERTION_SORT_THRESHOLD = 32;
/*    */   
/*    */   public static <T extends Comparable<? super T>> void sort(Comparable[] ts) {
/* 11 */     if (ts == null || ts.length <= 1)
/*    */       return; 
/* 13 */     sort(ts, 0, ts.length, null);
/*    */   }
/*    */   
/*    */   public static <T extends Comparable<? super T>> void sort(Comparable[] ts, int from, int to) {
/* 17 */     sort(ts, from, to, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T> void sort(Object[] ts, Comparator<? super T> comparator) {
/* 22 */     if (ts == null || ts.length <= 1)
/*    */       return; 
/* 24 */     sort(ts, 0, ts.length, (Comparator)comparator);
/*    */   }
/*    */   
/*    */   public static <T> void sort(Object[] ts, int from, int to, Comparator<? super T> comparator) {
/* 28 */     if (ts == null || from >= to || to - from <= 1)
/*    */       return; 
/* 30 */     if (from < 0 || to > ts.length) {
/* 31 */       throw new IndexOutOfBoundsException();
/*    */     }
/* 33 */     quicksort(ts, from, to - 1, (Comparator)comparator);
/*    */   }
/*    */   
/*    */   private static <T> void quicksort(Object[] a, int lo, int hi, Comparator<? super T> cmp) {
/* 37 */     while (hi - lo >= 32) {
/* 38 */       int pivotIndex = choosePivot(a, lo, hi, (Comparator)cmp);
/* 39 */       int p = partition(a, lo, hi, pivotIndex, (Comparator)cmp);
/*    */       
/* 41 */       if (p - lo < hi - p) {
/* 42 */         quicksort(a, lo, p - 1, (Comparator)cmp);
/* 43 */         lo = p + 1; continue;
/*    */       } 
/* 45 */       quicksort(a, p + 1, hi, (Comparator)cmp);
/* 46 */       hi = p - 1;
/*    */     } 
/*    */     
/* 49 */     insertionSort(a, lo, hi, (Comparator)cmp);
/*    */   }
/*    */   
/*    */   private static <T> int choosePivot(Object[] a, int lo, int hi, Comparator<? super T> cmp) {
/* 53 */     int mid = lo + (hi - lo) / 2;
/*    */     
/* 55 */     if (compare(a[lo], a[mid], (Comparator)cmp) > 0)
/* 56 */       swap(a, lo, mid); 
/* 57 */     if (compare(a[lo], a[hi], (Comparator)cmp) > 0)
/* 58 */       swap(a, lo, hi); 
/* 59 */     if (compare(a[mid], a[hi], (Comparator)cmp) > 0) {
/* 60 */       swap(a, mid, hi);
/*    */     }
/* 62 */     return mid;
/*    */   }
/*    */   
/*    */   private static <T> int partition(Object[] a, int lo, int hi, int pivotIndex, Comparator<? super T> cmp) {
/* 66 */     T pivot = (T)a[pivotIndex];
/* 67 */     swap(a, pivotIndex, hi);
/*    */     
/* 69 */     int i = lo;
/* 70 */     for (int j = lo; j < hi; j++) {
/* 71 */       if (compare(a[j], pivot, (Comparator)cmp) <= 0) {
/* 72 */         swap(a, i++, j);
/*    */       }
/*    */     } 
/* 75 */     swap(a, i, hi);
/* 76 */     return i;
/*    */   }
/*    */   
/*    */   private static <T> void insertionSort(Object[] a, int lo, int hi, Comparator<? super T> cmp) {
/* 80 */     for (int i = lo + 1; i <= hi; i++) {
/* 81 */       T key = (T)a[i];
/* 82 */       int j = i - 1;
/* 83 */       while (j >= lo && compare(a[j], key, (Comparator)cmp) > 0) {
/* 84 */         a[j + 1] = a[j];
/* 85 */         j--;
/*    */       } 
/* 87 */       a[j + 1] = key;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static <T> void swap(Object[] a, int i, int j) {
/* 92 */     T tmp = (T)a[i];
/* 93 */     a[i] = a[j];
/* 94 */     a[j] = tmp;
/*    */   }
/*    */ 
/*    */   
/*    */   private static <T> int compare(T a, T b, Comparator<? super T> cmp) {
/* 99 */     return (cmp != null) ? cmp.compare(a, b) : ((Comparable<T>)a).compareTo(b);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\Sort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */