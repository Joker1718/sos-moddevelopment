/*    */ package util.gui.table;
/*    */ 
/*    */ import snake2d.util.gui.clickable.Scrollable;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.DOUBLE;
/*    */ import util.data.INT;
/*    */ import util.gui.slider.GSliderVer;
/*    */ 
/*    */ 
/*    */ public abstract class GScrollable
/*    */   extends Scrollable
/*    */   implements INT.INTE
/*    */ {
/*    */   public GScrollable(Scrollable.ScrollRow... rows) {
/* 15 */     super(null, rows);
/* 16 */     GSliderVer slider = new GSliderVer(this, getView().body().height());
/* 17 */     slider.body().moveX1((getView().body().x2() + 4));
/* 18 */     slider.body().moveY1(getView().body().y1());
/* 19 */     getView().add((RENDEROBJ)slider);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GScrollable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */