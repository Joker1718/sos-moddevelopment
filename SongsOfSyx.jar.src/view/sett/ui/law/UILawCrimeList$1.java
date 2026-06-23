/*    */ package view.sett.ui.law;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASS_RACE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 84 */     GFORMAT.f(text, (BOOSTABLES.BEHAVIOUR()).LAWFULNESS.get((BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl)), 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 89 */     b.title((BOOSTABLES.BEHAVIOUR()).LAWFULNESS.name);
/* 90 */     b.text((BOOSTABLES.BEHAVIOUR()).LAWFULNESS.desc);
/* 91 */     b.sep();
/* 92 */     (BOOSTABLES.BEHAVIOUR()).LAWFULNESS.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl), null, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\UILawCrimeList$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */