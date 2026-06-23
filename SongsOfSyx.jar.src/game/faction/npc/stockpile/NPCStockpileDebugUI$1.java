/*    */ package game.faction.npc.stockpile;
/*    */ 
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.trade.TR;
/*    */ import init.trade.TRADABLE;
/*    */ import util.gui.misc.GButt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 36 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 39 */     for (int i = 0; i < NPCStockpileDebugUI.this.tamounts.length; i++) {
/* 40 */       faction.stockpile.res((TRADABLE)TR.ALL().get(i)).inc(NPCStockpileDebugUI.this.tamounts[i]);
/* 41 */       NPCStockpileDebugUI.this.tamounts[i] = 0;
/*    */     } 
/*    */     
/* 44 */     faction.stockpile.update(faction, 0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\NPCStockpileDebugUI$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */