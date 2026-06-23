/*    */ package view.interrupter;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.gui.misc.GBox;
/*    */ import view.keyboard.KEYS;
/*    */ 
/*    */ public class InterGuisection extends Interrupter {
/*    */   private GuiSection section;
/*    */   
/*    */   public InterGuisection(InterManager m) {
/* 18 */     this.m = m;
/*    */   }
/*    */   private ACTION closeAction; private final InterManager m;
/*    */   
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 23 */     return !(!this.section.hover(mCoo) && !mCoo.isWithinRec((RECTANGLE)this.section.body()));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 28 */     if (button == MButt.LEFT) {
/* 29 */       this.section.click();
/* 30 */     } else if (button == MButt.RIGHT && back()) {
/* 31 */       deactivate();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected boolean back() {
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean otherClick(MButt button) {
/* 41 */     if (button == MButt.RIGHT) {
/* 42 */       deactivate();
/* 43 */       return true;
/*    */     } 
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public GuiSection section() {
/* 49 */     return this.section;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hoverTimer(GBox text) {
/* 54 */     this.section.hoverInfoGet((GUI_BOX)text);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 59 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 60 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 65 */     if ((KEYS.MAIN()).ESCAPE.consumeClick())
/* 66 */       hide(); 
/* 67 */     return true;
/*    */   }
/*    */   
/*    */   public void activate(GuiSection section) {
/* 71 */     this.section = section;
/* 72 */     show(this.m);
/*    */   }
/*    */   
/*    */   public void close() {
/* 76 */     hide();
/*    */   }
/*    */   
/*    */   public void setCloseAction(ACTION action) {
/* 80 */     this.closeAction = action;
/*    */   }
/*    */   
/*    */   public void deactivate() {
/* 84 */     hide();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void deactivateAction() {
/* 89 */     if (this.closeAction != null)
/* 90 */       this.closeAction.exe(); 
/* 91 */     this.closeAction = null;
/* 92 */     super.deactivateAction();
/*    */   }
/*    */   
/*    */   public GuiSection current() {
/* 96 */     if (isActivated())
/* 97 */       return this.section; 
/* 98 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\InterGuisection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */