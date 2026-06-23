/*    */ package game.faction.npc.stockpile;
/*    */ 
/*    */ import game.faction.npc.FactionNPC;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 59 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 62 */     faction.stockpile.saver().clear();
/* 63 */     faction.stockpile.update(faction, 0.0D);
/* 64 */     for (int i = 0; i < NPCStockpileDebugUI.this.tamounts.length; i++)
/* 65 */       NPCStockpileDebugUI.this.tamounts[i] = 0; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\NPCStockpileDebugUI$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */