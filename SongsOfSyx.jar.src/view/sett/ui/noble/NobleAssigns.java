/*    */ package view.sett.ui.noble;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.nobility.Noble;
/*    */ import game.nobility.NobleOffice;
/*    */ import init.constant.C;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.table.GRows;
/*    */ import util.gui.table.GScrollRows;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ class NobleAssigns
/*    */   extends GuiSection {
/*    */   Noble n;
/*    */   
/*    */   NobleAssigns() {
/* 20 */     GRows rows = new GRows(8);
/*    */     
/* 22 */     for (NobleOffice o : (GAME.NOBLE()).OFFICES) {
/*    */       
/* 24 */       if (!o.special) {
/* 25 */         rows.add((RENDEROBJ)new BB(o));
/*    */       }
/*    */     } 
/*    */     
/* 29 */     rows.nl();
/* 30 */     for (NobleOffice o : (GAME.NOBLE()).OFFICES) {
/*    */       
/* 32 */       if (o.special) {
/* 33 */         rows.add((RENDEROBJ)new BB(o));
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 38 */     GScrollRows rr = new GScrollRows((Iterable)rows.rows(), C.HEIGHT() - 300);
/*    */     
/* 40 */     add((RENDEROBJ)rr.view());
/*    */   }
/*    */ 
/*    */   
/*    */   private class BB
/*    */     extends GButt.ButtPanel
/*    */   {
/*    */     private final NobleOffice o;
/*    */     
/*    */     BB(NobleOffice o) {
/* 50 */       super(o.icon.huge);
/* 51 */       this.o = o;
/* 52 */       pad(4, 4);
/*    */     }
/*    */ 
/*    */     
/*    */     protected void renAction() {
/* 57 */       selectedSet((NobleAssigns.this.n.office() == this.o));
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     protected void clickA() {
/* 63 */       GAME.NOBLE().setOffice(NobleAssigns.this.n, this.o);
/* 64 */       (VIEW.inters()).popup.close();
/*    */     }
/*    */ 
/*    */     
/*    */     public void hoverInfoGet(GUI_BOX text) {
/* 69 */       this.o.hover(text);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\NobleAssigns.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */