/*    */ package view.interrupter;
/*    */ 
/*    */ import init.constant.C;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GTextR;
/*    */ import util.gui.panel.GPanel;
/*    */ import view.keyboard.KEYS;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IMouseText
/*    */   extends Interrupter
/*    */ {
/* 24 */   private final GTextR text = new GTextR((UI.FONT()).M, 200);
/* 25 */   private RENDEROBJ ren = (RENDEROBJ)this.text;
/* 26 */   private final GPanel box = new GPanel();
/*    */   private final InterManager manager;
/*    */   
/*    */   public IMouseText(InterManager manager) {
/* 30 */     this.manager = manager;
/* 31 */     this.box.inner().moveY1(128.0D);
/* 32 */     this.text.text().setMaxWidth(C.WIDTH() / 3);
/* 33 */     this.text.text().lablify();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {
/* 38 */     hide();
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean otherClick(MButt button) {
/* 43 */     hide();
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public void activate(CharSequence t) {
/* 48 */     this.text.text().set(t);
/* 49 */     this.ren = (RENDEROBJ)this.text;
/* 50 */     set();
/* 51 */     show(this.manager);
/*    */   }
/*    */ 
/*    */   
/*    */   public void activate(RENDEROBJ ren) {
/* 56 */     this.ren = ren;
/* 57 */     if (ren == null)
/*    */       return; 
/* 59 */     set();
/* 60 */     show(this.manager);
/*    */   }
/*    */ 
/*    */   
/*    */   private void set() {
/* 65 */     this.box.inner().set((BODY_HOLDER)this.ren);
/*    */     
/* 67 */     this.box.inner().moveX1Y1((VIEW.mouse().x() + 20), (VIEW.mouse().y() + 20));
/*    */     
/* 69 */     if (this.box.inner().x2() > C.WIDTH()) {
/* 70 */       this.box.inner().moveX2((VIEW.mouse().x() - 5));
/*    */     }
/*    */     
/* 73 */     if (this.box.inner().y2() > C.HEIGHT()) {
/* 74 */       this.box.inner().moveY2(C.HEIGHT());
/*    */     }
/*    */     
/* 77 */     this.ren.body().centerIn((BODY_HOLDER)this.box);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 83 */     return mCoo.isWithinRec((BODY_HOLDER)this.box);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean render(Renderer r, float ds) {
/* 88 */     this.box.render((SPRITE_RENDERER)r, ds);
/* 89 */     this.ren.render((SPRITE_RENDERER)r, ds);
/* 90 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean update(float ds) {
/* 95 */     if (KEYS.anyDown())
/* 96 */       hide(); 
/* 97 */     return true;
/*    */   }
/*    */   
/*    */   protected void hoverTimer(GBox text) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IMouseText.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */