/*    */ package snake2d.util.sets;
/*    */ 
/*    */ public interface ADDABLE<E> {
/*    */   int add(E paramE);
/*    */   
/*    */   default void add(Iterable<E> es) {
/*  7 */     for (E e : es)
/*  8 */       add(e);  } default void add(Object[] es) { byte b;
/*    */     int i;
/*    */     Object[] arrayOfObject;
/* 11 */     for (i = (arrayOfObject = es).length, b = 0; b < i; ) { E e = (E)arrayOfObject[b];
/* 12 */       add(e);
/*    */       b++; }
/*    */      }
/*    */    default E addReturn(E element) {
/* 16 */     add(element);
/* 17 */     return element;
/*    */   }
/*    */   
/*    */   int tryAdd(E paramE);
/*    */   
/*    */   boolean hasRoom();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ADDABLE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */