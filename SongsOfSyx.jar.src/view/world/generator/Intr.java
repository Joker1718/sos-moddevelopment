/*    */ package view.world.generator;
/*    */ import init.constant.C;
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.panel.GPanel;
/*    */ import view.interrupter.Interrupter;
/*    */ 
/*    */ final class Intr extends Interrupter {
/*    */   Intr(WorldViewGenerator v) {
/* 17 */     pin();
/* 18 */     v.uiManager.add(this);
/*    */   }
/*    */   private GuiSection s;
/*    */   public void add(GuiSection s, CharSequence title) {
/* 22 */     add(s, title, true);
/*    */   }
/*    */   
/*    */   public void add(GuiSection s, CharSequence title, boolean panel) {
/* 26 */     this.s = s;
/* 27 */     if (s != null && panel) {
/*    */       
/* 29 */       s.body().moveCY((C.HEIGHT() / 2));
/* 30 */       s.body().moveCX((C.WIDTH() / 2));
/*    */       
/* 32 */       GPanel pan = new GPanel();
/* 33 */       pan.setBig();
/* 34 */       pan.inner().setDim(s.body().width(), s.body().height());
/* 35 */       pan.body.centerIn((BODY_HOLDER)s);
/* 36 */       pan.setTitle(title);
/* 37 */       s.add((RENDEROBJ)pan);
/* 38 */       s.moveLastToBack();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 46 */     if (this.s != null) {
/* 47 */       return this.s.hover(mCoo);
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 54 */     if (button == MButt.LEFT && this.s != null) {
/* 55 */       this.s.click();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void hoverTimer(GBox text) {
/* 60 */     if (this.s != null) {
/* 61 */       this.s.hoverInfoGet((GUI_BOX)text);
/*    */     }
/*    */   }
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 66 */     if (this.s != null)
/* 67 */       this.s.render((SPRITE_RENDERER)r, ds); 
/* 68 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 74 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canSave() {
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\Intr.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */