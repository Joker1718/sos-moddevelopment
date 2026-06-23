/*    */ package view.ui.economy;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.player.PCredits;
/*    */ import util.data.INT;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends MainDetails.SDetail
/*    */ {
/*    */   null(MainDetails paramMainDetails2, PCredits.CredHistory $anonymous0) {
/* 35 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   void up(GText text) {
/* 39 */     int i = ii.get();
/* 40 */     if (i < 0)
/* 41 */       i = GAME.player().credits().creditsH().historyRecords() - 1; 
/* 42 */     i = GAME.player().credits().creditsH().historyRecords() - i - 1;
/* 43 */     GFORMAT.iIncr(text, (h.IN.get(i) - h.OUT.get(i)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainDetails$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */