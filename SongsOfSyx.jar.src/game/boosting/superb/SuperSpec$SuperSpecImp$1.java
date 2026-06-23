/*    */ package game.boosting.superb;
/*    */ 
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.data.DOUBLE_O;
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
/*    */   implements DOUBLE_O.DOUBLE_OE<SuperBoostableObj>
/*    */ {
/*    */   public double getD(SuperBoostableObj t) {
/* 78 */     return t.boostingData().values()[SuperSpec.SuperSpecImp.this.index];
/*    */   }
/*    */ 
/*    */   
/*    */   public DOUBLE_O.DOUBLE_OE<SuperBoostableObj> setD(SuperBoostableObj t, double d) {
/* 83 */     t.boostingData().values()[SuperSpec.SuperSpecImp.this.index] = CLAMP.d(d, 0.0D, 1.0D);
/* 84 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec$SuperSpecImp$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */