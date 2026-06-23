/*    */ package game.faction.player.emmi;
/*    */ 
/*    */ import game.faction.royalty.Royalty;
/*    */ import game.faction.royalty.opinion.ROPINION;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends EmiTypeRoy
/*    */ {
/*    */   null(SPRITE $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2) {
/* 76 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hover(Royalty t, GUI_BOX text) {
/* 82 */     super.hover(t, text);
/* 83 */     GBox b = (GBox)text;
/* 84 */     b.textLL(Emissaries.¤¤assasinateDex);
/* 85 */     b.add((SPRITE)GFORMAT.f(b.text(), ROPINION.EMMI().assasinationsPerYear(t, 1.0D)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\Emissaries$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */