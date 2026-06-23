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
/*    */ class null
/*    */   extends UIGoodsTraders
/*    */ {
/*    */   null(int $anonymous0) {
/* 61 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected int price(FactionNPC f) {
/* 65 */     return f.res((TRADABLE)UIGoodsExport.this.res.get()).priceBuyP();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int sortValue(FactionNPC f) {
/* 70 */     return -f.res((TRADABLE)UIGoodsExport.this.res.get()).priceBuyP();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsExport$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */