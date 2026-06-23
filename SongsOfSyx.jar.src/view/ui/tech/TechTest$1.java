/*    */ package view.ui.tech;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
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
/*    */ class null
/*    */   extends GButt.Checkbox
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 43 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 46 */     p.show = !p.show;
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 50 */     selectedSet(p.show);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 55 */     GBox b = (GBox)text;
/* 56 */     double bo = 0.0D;
/* 57 */     double cost = 0.0D;
/* 58 */     for (TechTest.Line l : p.lines) {
/* 59 */       b.text(l.name);
/* 60 */       b.add((SPRITE)GFORMAT.f0(b.text(), l.bo));
/* 61 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)l.cost));
/* 62 */       bo += l.bo;
/* 63 */       cost += l.cost;
/* 64 */       text.NL();
/*    */     } 
/*    */     
/* 67 */     b.add((SPRITE)GFORMAT.f0(b.text(), bo));
/* 68 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)cost));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\TechTest$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */