/*    */ package view.interrupter;
/*    */ import init.constant.C;
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.panel.GPanel;
/*    */ 
/*    */ public final class ITmpPanel extends Interrupter {
/* 15 */   private final GuiSection section = new GuiSection(); private boolean visable = false;
/* 16 */   private GPanel box = new GPanel();
/*    */   
/*    */   private int buttI;
/*    */ 
/*    */   
/*    */   public ITmpPanel(InterManager manager) {
/* 22 */     pin();
/*    */ 
/*    */     
/* 25 */     this.box.setButt();
/* 26 */     show(manager);
/*    */   }
/*    */   
/*    */   public void addTitle(CharSequence s) {
/* 30 */     this.box.setTitle(s);
/*    */   }
/*    */ 
/*    */   
/*    */   public void addButton(GButt.Panel button) {
/* 35 */     if (this.buttI++ > 10) {
/* 36 */       button.body.moveX1(this.section.body().x1()).moveY1(this.section.body().y2());
/* 37 */       this.section.add((RENDEROBJ)button);
/* 38 */       this.buttI = 0;
/*    */     } else {
/* 40 */       this.section.addRight(0, (RENDEROBJ)button);
/*    */     } 
/*    */ 
/*    */     
/* 44 */     this.visable = true;
/*    */     
/* 46 */     this.section.body().centerX(C.DIM());
/* 47 */     this.section.body().moveY1(120.0D);
/*    */   } public void addButtons(GButt.Panel... buttons) {
/*    */     byte b;
/*    */     int i;
/*    */     GButt.Panel[] arrayOfPanel;
/* 52 */     for (i = (arrayOfPanel = buttons).length, b = 0; b < i; ) { GButt.Panel bu = arrayOfPanel[b];
/* 53 */       addButton(bu);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 58 */     if (!this.visable)
/* 59 */       return false; 
/* 60 */     return this.section.hover(mCoo);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 65 */     if (MButt.LEFT == button) {
/* 66 */       this.section.click();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void hoverTimer(GBox text) {
/* 71 */     this.section.hoverInfoGet((GUI_BOX)text);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 78 */     if (this.visable) {
/* 79 */       this.box.inner().set((BODY_HOLDER)this.section);
/* 80 */       this.box.render((SPRITE_RENDERER)r, ds);
/* 81 */       this.section.render((SPRITE_RENDERER)r, ds);
/*    */     } 
/*    */     
/* 84 */     this.visable = false;
/* 85 */     this.buttI = 0;
/* 86 */     this.box.title().clear();
/* 87 */     this.section.clear();
/* 88 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\ITmpPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */