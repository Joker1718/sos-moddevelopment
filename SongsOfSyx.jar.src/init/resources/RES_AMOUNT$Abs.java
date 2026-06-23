/*     */ package init.resources;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Abs
/*     */   implements RES_AMOUNT
/*     */ {
/*     */   private final byte cIndex;
/*     */   private final int amount;
/*     */   
/*     */   public Abs(RESOURCE c, int amount) {
/*  89 */     this.cIndex = c.bIndex();
/*  90 */     this.amount = amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/*  95 */     return (RESOURCE)RESOURCES.ALL().get(this.cIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public int amount() {
/* 100 */     return this.amount;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\RES_AMOUNT$Abs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */