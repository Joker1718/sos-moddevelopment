/*    */ package snake2d.util.misc;
/*    */ 
/*    */ public class Usable<T>
/*    */ {
/*    */   private final T t;
/*    */   private Object user;
/*    */   
/*    */   public Usable(T t) {
/*  9 */     this.t = t;
/*    */   }
/*    */   
/*    */   public T use(Object user) {
/* 13 */     if (this.user != null)
/* 14 */       throw new RuntimeException("In use by: " + this.user); 
/* 15 */     this.user = user;
/* 16 */     return this.t;
/*    */   }
/*    */   
/*    */   public void done() {
/* 20 */     this.user = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\Usable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */