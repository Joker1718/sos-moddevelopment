/*    */ package view.sett.ui.noble;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.boosting.BoostSpec;
/*    */ import init.type.HCLASS_RACE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
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
/*    */   null(SPRITE $anonymous0) {
/* 65 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 71 */     GBox b = (GBox)text;
/*    */ 
/*    */     
/* 74 */     for (int si = 0; si < (GAME.NOBLE()).boosters.all().size(); si++) {
/* 75 */       BoostSpec s = (BoostSpec)(GAME.NOBLE()).boosters.all().get(si);
/* 76 */       double v = s.get((BOOSTABLE_O)HCLASS_RACE.clP());
/* 77 */       if (v > 0.0D) {
/* 78 */         (GAME.NOBLE()).boosters.hover(b, s, v, 0);
/* 79 */         b.tab(8);
/*    */         
/* 81 */         b.NL();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\UINobles$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */