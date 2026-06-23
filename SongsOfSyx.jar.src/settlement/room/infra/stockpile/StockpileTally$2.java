/*    */ package settlement.room.infra.stockpile;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import util.keymap.MAPPED;
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
/*    */   extends StockpileTally.TallyData
/*    */ {
/*    */   null(StockpileTally paramStockpileTally2, CharSequence $anonymous0) {
/* 46 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   void set(StockpileInstance ins, int ri, int am) {
/* 50 */     super.set(ins, ri, am);
/* 51 */     StockpileTally.this.amountDay.set((MAPPED)RESOURCES.ALL().get(ri), total(ri));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\StockpileTally$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */