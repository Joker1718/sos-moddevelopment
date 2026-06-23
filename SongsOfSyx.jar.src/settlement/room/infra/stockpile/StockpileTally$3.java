/*    */ package settlement.room.infra.stockpile;
/*    */ 
/*    */ import init.resources.RESOURCE;
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
/*    */ class null
/*    */   implements DOUBLE_O<RESOURCE>
/*    */ {
/*    */   public double getD(RESOURCE t) {
/* 62 */     int sp = StockpileTally.this.space.total(t);
/* 63 */     if (sp == 0)
/* 64 */       return 1.0D; 
/* 65 */     double used = StockpileTally.this.amount.total(t);
/* 66 */     return used / sp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\StockpileTally$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */