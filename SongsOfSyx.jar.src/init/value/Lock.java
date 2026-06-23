/*    */ package init.value;
/*    */ 
/*    */ public final class Lock<T>
/*    */ {
/*    */   public final Lockable<T> lockable;
/*    */   public final Locker<T> unlocker;
/*    */   
/*    */   public Lock(Lockable<T> lockable, Locker<T> unlocker) {
/*  9 */     this.lockable = lockable;
/* 10 */     this.unlocker = unlocker;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Lock.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */