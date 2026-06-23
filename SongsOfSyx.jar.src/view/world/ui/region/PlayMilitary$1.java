/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 30 */     GFORMAT.iIncr(text, (int)(RD.MILITARY()).conscriptTarget.get((BOOSTABLE_O)g.get()));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 35 */     b.title((RD.MILITARY()).conscriptTarget.name);
/* 36 */     b.text((RD.MILITARY()).conscriptTarget.desc);
/* 37 */     b.sep();
/*    */     
/* 39 */     (RD.MILITARY()).conscriptTarget.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), null, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayMilitary$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */