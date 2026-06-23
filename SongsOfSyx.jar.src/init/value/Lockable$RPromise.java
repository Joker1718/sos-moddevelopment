/*     */ package init.value;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class RPromise
/*     */   implements ACTION
/*     */ {
/*     */   final String key;
/*     */   final double value;
/*     */   final String path;
/*     */   final COMPARATOR comp;
/*     */   
/*     */   RPromise(String key, double value, String path, COMPARATOR comp) {
/* 137 */     this.key = key;
/* 138 */     this.value = value;
/* 139 */     this.path = path;
/* 140 */     this.comp = comp;
/*     */   }
/*     */ 
/*     */   
/*     */   public void exe() {
/* 145 */     if (Lockable.this.values.get(this.key) == null) {
/* 146 */       if (!Lockable.hasSpewed) {
/* 147 */         GAME.Warn(this.path + this.path + "no " + System.lineSeparator() + " named : " + Lockable.this.values.key + " available: " + this.key + System.lineSeparator());
/*     */       } else {
/* 149 */         LOG.err(this.path + this.path + "no " + System.lineSeparator() + " named : " + Lockable.this.values.key);
/*     */       } 
/* 151 */       Lockable.hasSpewed = true;
/*     */       
/* 153 */       Value<T> v = new Value<>(this.key, (SPRITE)(SPRITES.icons()).s.cancel, "unknown", new DOUBLE_O<T>()
/*     */           {
/*     */             public double getD(T t) {
/* 156 */               return 0.0D;
/*     */             }
/* 158 */           },  false, true);
/*     */       
/* 160 */       Locker<T> un = new Locker.LockerValue<>(this.comp, v, 1.0D, Lockable.this.icon);
/* 161 */       Lock<T> lock = new Lock<>(Lockable.this, un);
/* 162 */       Lockable.this.res.add(lock);
/*     */     }
/*     */     else {
/*     */       
/* 166 */       Value<T> v = Lockable.this.values.get(this.key);
/*     */       
/* 168 */       Locker<T> un = new Locker.LockerValue<>(this.comp, v, this.value, Lockable.this.icon);
/* 169 */       Lock<T> lock = new Lock<>(Lockable.this, un);
/* 170 */       Lockable.this.res.add(lock);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\Lockable$RPromise.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */