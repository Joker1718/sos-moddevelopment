/*    */ package settlement.room.main.copy;
/*    */ 
/*    */ import init.structure.Structure;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.Panel
/*    */ {
/*    */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 76 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 79 */     GBox b = (GBox)text;
/* 80 */     b.title(t.name);
/* 81 */     b.text(t.desc);
/* 82 */     b.NL();
/* 83 */     b.setResource(t.resource, t.resAmount);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 88 */     Copier.this.structure = t.terrain();
/* 89 */     (VIEW.inters()).popup.close();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 94 */     selectedSet((Copier.this.structure == t.terrain()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\Copier$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */