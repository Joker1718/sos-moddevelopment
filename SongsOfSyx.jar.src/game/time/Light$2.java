/*    */ package game.time;
/*    */ 
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.data.DOUBLE;
/*    */ import util.data.INT;
/*    */ import util.gui.slider.GSliderInt;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 40 */     INT.IntImp in = new INT.IntImp(0, 300);
/* 41 */     Light.this.time = (DOUBLE)in;
/* 42 */     GuiSection s = new GuiSection();
/* 43 */     s.add((RENDEROBJ)new GSliderInt((INT.INTE)in, 300, true));
/* 44 */     (VIEW.inters()).popup.show((RENDEROBJ)s, (CLICKABLE)s, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Light$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */