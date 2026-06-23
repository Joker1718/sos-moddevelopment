/*    */ package snake2d.util.sets;
/*    */ 
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface LIST<E>
/*    */   extends Iterable<E>
/*    */ {
/*    */   E get(int paramInt);
/*    */   
/*    */   default E getC(int index) {
/* 22 */     if (size() == 0)
/* 23 */       return null; 
/* 24 */     int remainder = index % size();
/* 25 */     index = (remainder >> 31 & size()) + remainder;
/* 26 */     return get(index);
/*    */   }
/*    */   
/*    */   default E rnd() {
/* 30 */     return get(RND.rInt(size()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean contains(int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean contains(E paramE);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   int size();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean isEmpty();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default E last() {
/* 57 */     return get(size() - 1);
/*    */   }
/*    */   
/*    */   default <T extends E> LIST<E> join(LIST<T> other) {
/* 61 */     ArrayList<E> n = new ArrayList<>(size() + other.size()); int i;
/* 62 */     for (i = 0; i < size(); i++)
/* 63 */       n.add(get(i)); 
/* 64 */     for (i = 0; i < other.size(); i++)
/* 65 */       n.add((E)other.get(i)); 
/* 66 */     return n;
/*    */   }
/*    */   
/*    */   <T extends E> LIST<E> join(Object... others) {
/* 70 */     ArrayList<E> n = new ArrayList<>(size() + others.length); int i;
/* 71 */     for (i = 0; i < size(); i++)
/* 72 */       n.add(get(i)); 
/* 73 */     for (i = 0; i < others.length; i++)
/* 74 */       n.add((E)others[i]); 
/* 75 */     return n;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\LIST.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */