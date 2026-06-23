/*    */ package util.gui.misc;
/*    */ import init.constant.C;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.panel.GPanel;
/*    */ 
/*    */ public final class GButtablePanel extends CLICKABLE.ClickableAbs {
/* 14 */   private final GuiSection s = new GuiSection();
/*    */   private boolean visable = false;
/* 16 */   private GPanel box = new GPanel(); private int buttI;
/*    */   
/*    */   public GButtablePanel() {
/* 19 */     this.box.setButt();
/*    */   }
/*    */   
/*    */   public void addTitle(CharSequence s) {
/* 23 */     this.box.setTitle(s);
/* 24 */     this.body.set((RECTANGLE)this.box.body());
/*    */   }
/*    */   
/*    */   public void addButton(CLICKABLE button, int margin) {
/* 28 */     if (this.buttI++ >= 10) {
/* 29 */       button.body().moveX1(this.s.body().x1()).moveY1(this.s.body().y2());
/* 30 */       this.s.add((RENDEROBJ)button);
/* 31 */       this.buttI = 0;
/*    */     } else {
/* 33 */       this.s.addRight(margin, (RENDEROBJ)button);
/*    */     } 
/* 35 */     this.visable = true;
/*    */     
/* 37 */     this.s.body().centerX(C.DIM());
/* 38 */     this.s.body().moveY1(120.0D);
/* 39 */     this.box.inner().set((BODY_HOLDER)this.s);
/* 40 */     this.body.set((RECTANGLE)this.box.body());
/*    */   }
/*    */   
/*    */   public void nl() {
/* 44 */     this.buttI = 100;
/*    */   }
/*    */   
/*    */   public void addButton(CLICKABLE button) {
/* 48 */     addButton(button, 0);
/*    */   } public void addButtons(CLICKABLE... buttons) {
/*    */     byte b;
/*    */     int i;
/*    */     CLICKABLE[] arrayOfCLICKABLE;
/* 53 */     for (i = (arrayOfCLICKABLE = buttons).length, b = 0; b < i; ) { CLICKABLE bu = arrayOfCLICKABLE[b];
/* 54 */       addButton(bu);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   public void clear() {
/* 59 */     this.s.clear();
/* 60 */     this.visable = false;
/* 61 */     this.buttI = 0;
/* 62 */     this.box.title().clear();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 67 */     if (this.visable) {
/* 68 */       this.box.render(r, ds);
/* 69 */       this.s.render(r, ds);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 75 */     this.s.click();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hover(COORDINATE mCoo) {
/* 80 */     this.s.hover(mCoo);
/* 81 */     return super.hover(mCoo);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 86 */     this.s.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GButtablePanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */