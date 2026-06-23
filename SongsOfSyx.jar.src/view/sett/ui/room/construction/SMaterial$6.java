/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import init.structure.Structure;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
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
/*     */   extends GButt.Panel
/*     */ {
/*     */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 109 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 112 */     GBox b = (GBox)text;
/* 113 */     b.title(t.name);
/* 114 */     SMaterial.this.buttonIndoor.hoverInfoGet(text);
/* 115 */     b.NL();
/* 116 */     b.text(t.desc);
/* 117 */     b.setResource(t.resource, t.resAmount);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 122 */     s.placement.placer.structure.set(t.terrain());
/* 123 */     (VIEW.inters()).popup.close();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 128 */     selectedSet((s.placement.placer.structure.get() == t.terrain()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SMaterial$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */