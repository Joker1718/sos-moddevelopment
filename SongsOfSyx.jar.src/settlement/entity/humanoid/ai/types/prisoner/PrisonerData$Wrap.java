/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.HAI;
/*     */ import snake2d.util.bit.Bits;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Wrap
/*     */   implements INT_O.INT_OE<HAI>
/*     */ {
/*     */   private final Bits bits;
/*     */   private final INT_O.INT_OE<AIManager> data;
/*     */   
/*     */   Wrap(Bits bits, INT_O.INT_OE<AIManager> data) {
/* 104 */     this.bits = bits;
/* 105 */     this.data = data;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(HAI t) {
/* 110 */     return this.bits.get(this.data.get(t));
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(HAI t) {
/* 115 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(HAI t) {
/* 120 */     return this.bits.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(HAI t, int i) {
/* 125 */     int d = this.data.get(t);
/* 126 */     d = this.bits.set(d, i);
/* 127 */     this.data.set(t, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\PrisonerData$Wrap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */