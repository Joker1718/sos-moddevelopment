/*    */ package view.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.Army;
/*    */ import settlement.room.military.artillery.ArtilleryInstance;
/*    */ import util.gui.table.GTableBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GTableBuilder
/*    */ {
/* 38 */   private int upI = -1;
/*    */ 
/*    */   
/*    */   public int nrOFEntries() {
/* 42 */     if (this.upI != GAME.updateI()) {
/* 43 */       this.upI = GAME.updateI();
/* 44 */       UIPanelArtillery.this.all.clearSoft();
/* 45 */       for (ArtilleryInstance bb : selection.all()) {
/* 46 */         if (bb.army() == army) {
/* 47 */           UIPanelArtillery.this.all.add(bb);
/*    */         }
/*    */       } 
/*    */     } 
/* 51 */     return UIPanelArtillery.this.all.size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIPanelArtillery$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */