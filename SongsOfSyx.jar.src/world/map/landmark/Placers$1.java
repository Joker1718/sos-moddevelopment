/*    */ package world.map.landmark;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.INT;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.slider.GSliderInt;
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
/*    */   extends GSliderInt
/*    */ {
/*    */   null(INT.INTE $anonymous0, int $anonymous1, boolean $anonymous2, boolean $anonymous3) {
/* 42 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 46 */     super.hoverInfoGet(text);
/* 47 */     GBox b = (GBox)text;
/* 48 */     b.add((SPRITE)b.text().add(':').add((CharSequence)(Placers.this.get()).name));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\Placers$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */