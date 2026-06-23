/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 101 */     GFORMAT.f0(text, (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 106 */     b.title((BOOSTABLES.CIVICS()).LAW.name);
/* 107 */     b.text((BOOSTABLES.CIVICS()).LAW.desc);
/* 108 */     b.sep();
/* 109 */     (BOOSTABLES.CIVICS()).LAW.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl), null, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\UILawCrimeList$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */