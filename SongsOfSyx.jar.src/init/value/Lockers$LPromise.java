/*     */ package init.value;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class LPromise<T>
/*     */   implements ACTION
/*     */ {
/*     */   String key;
/*     */   String path;
/*     */   Locker<T> locker;
/*     */   GValueCat<T> vv;
/*     */   
/*     */   public void exe() {
/* 131 */     Lockable<T> lockable = this.vv.LOCK.get(this.key);
/* 132 */     if (lockable == null) {
/* 133 */       if (!this.vv.LOCK.hasSpewed) {
/* 134 */         GAME.Warn(this.path + this.path + "no UNLOCKABLE " + System.lineSeparator() + " named : " + this.vv.key + " available: " + this.key + System.lineSeparator());
/*     */       } else {
/* 136 */         LOG.ln(this.path + this.path + "no UNLOCKABLE " + System.lineSeparator() + " named : " + this.vv.key);
/*     */       } 
/* 138 */       this.vv.LOCK.hasSpewed = true;
/*     */       return;
/*     */     } 
/* 141 */     Lock<T> lock = new Lock<>(lockable, this.locker);
/* 142 */     lockable.res.add(lock);
/* 143 */     Lockers.this.locks.add(lock);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Lockers$LPromise.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */