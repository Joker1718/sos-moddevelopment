/*    */ package settlement.tilemap.ground;
/*    */ 
/*    */ import snake2d.util.sets.Bitsmap1D;
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
/*    */ class null
/*    */   extends Bitsmap1D
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1, int $anonymous2) {
/* 56 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void set(int index, int value) {
/* 64 */     Minables.this.amounts[Minables.this.types.get(index)] = Minables.this.amounts[Minables.this.types.get(index)] - get(index);
/* 65 */     super.set(index, value);
/* 66 */     Minables.this.amounts[Minables.this.types.get(index)] = Minables.this.amounts[Minables.this.types.get(index)] + get(index);
/* 67 */     Minables.this.amounts[Minables.this.types.get(index)] = Math.max(0L, Minables.this.amounts[Minables.this.types.get(index)]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Minables$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */