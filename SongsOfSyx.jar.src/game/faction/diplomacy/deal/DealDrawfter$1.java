/*    */ package game.faction.diplomacy.deal;
/*    */ 
/*    */ import init.trade.TRADABLE;
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
/*    */   extends DealDrawfter.Gift
/*    */ {
/*    */   public int max() {
/* 57 */     return gg.resources.max(res);
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 62 */     return gg.resources.get(res);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 67 */     gg.resources.set(res, t);
/*    */   }
/*    */ 
/*    */   
/*    */   public int value(int am) {
/* 72 */     return gg.valueResource(res, am);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canGift() {
/* 77 */     return (oo.resources.get(res) <= 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealDrawfter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */