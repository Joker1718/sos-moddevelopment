/*    */ package view.ui.goods;
/*    */ 
/*    */ import game.faction.npc.FactionNPC;
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
/*    */   extends UIGoodsTraders
/*    */ {
/*    */   null(int $anonymous0) {
/* 79 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected int price(FactionNPC f) {
/* 83 */     return f.res((TRADABLE)UIGoodsImport.this.res.get()).priceSellP();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int sortValue(FactionNPC f) {
/* 88 */     return f.res((TRADABLE)UIGoodsImport.this.res.get()).priceSellP();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsImport$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */