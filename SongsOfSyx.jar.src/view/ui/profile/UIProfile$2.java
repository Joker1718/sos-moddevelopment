/*    */ package view.ui.profile;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FactionProfileFlusher;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 62 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 66 */     activeSet(FactionProfileFlusher.canLoad(FACTIONS.player()));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 71 */     FactionProfileFlusher.load(FACTIONS.player());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIProfile$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */