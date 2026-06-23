/*    */ package snake2d.util.sets;
/*    */ 
/*    */ public interface TRANSFORMER<F, T>
/*    */ {
/*    */   T transform(F paramF);
/*    */   
/*    */   ArrayList<T> toArrayList(Object... fs) {
/*  8 */     ArrayList<T> res = new ArrayList<>(fs.length); byte b; int i; Object[] arrayOfObject;
/*  9 */     for (i = (arrayOfObject = fs).length, b = 0; b < i; ) { F f = (F)arrayOfObject[b];
/* 10 */       res.add(transform(f)); b++; }
/* 11 */      return res;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\TRANSFORMER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */