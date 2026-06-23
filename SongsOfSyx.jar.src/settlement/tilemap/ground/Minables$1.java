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
/*    */ class null
/*    */   extends Bitsmap1D
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1, int $anonymous2) {
/* 41 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void set(int index, int value) {
/* 49 */     int am = Minables.this.amount.get(index);
/* 50 */     Minables.this.amounts[get(index)] = Minables.this.amounts[get(index)] - am;
/* 51 */     super.set(index, value);
/* 52 */     Minables.this.amounts[get(index)] = Minables.this.amounts[get(index)] + am;
/* 53 */     Minables.this.amounts[get(index)] = Math.max(0L, Minables.this.amounts[get(index)]);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\ground\Minables$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */