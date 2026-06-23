/*     */ package settlement.path.components;
/*     */ 
/*     */ import init.resources.RESOURCE;
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
/*     */ final class Res
/*     */   extends FindableData
/*     */ {
/*     */   private final RESOURCE res;
/*     */   
/*     */   Res(RESOURCE res) {
/* 114 */     super(res.name);
/* 115 */     this.res = res;
/*     */   }
/*     */ 
/*     */   
/*     */   void add(SComponent c) {
/* 120 */     super.add(c);
/* 121 */     c.ress[FindableDataRes.this.index].or(this.res);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean remove(SComponent c) {
/* 126 */     boolean ret = super.remove(c);
/* 127 */     if (get(c) == 0) {
/* 128 */       c.ress[FindableDataRes.this.index].clear(this.res);
/*     */     }
/* 130 */     return ret;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\FindableDataRes$Res.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */