/*    */ package game.faction.trade;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import init.trade.TRADE_TYPE;
/*    */ 
/*    */ public interface FBUYER
/*    */ {
/*    */   void addReserve(int paramInt1, TRADE_TYPE paramTRADE_TYPE, int paramInt2, Faction paramFaction);
/*    */   
/*    */   default void addReserveAndDeliver(int amount, TRADE_TYPE type) {
/* 11 */     addReserve(amount, type, 0, null);
/* 12 */     addDeliver(amount, type);
/*    */   }
/*    */   
/*    */   void addDeliver(int paramInt, TRADE_TYPE paramTRADE_TYPE);
/*    */   
/*    */   double buyPriority(int paramInt, double paramDouble);
/*    */   
/*    */   int addPrice(int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\FBUYER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */