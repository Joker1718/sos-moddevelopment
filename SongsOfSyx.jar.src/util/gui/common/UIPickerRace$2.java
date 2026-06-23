/*    */ package util.gui.common;
/*    */ 
/*    */ import init.race.Race;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.gui.misc.GBox;
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
/*    */   extends HOVERABLE.HoverableAbs
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 41 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 47 */     GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/* 48 */     GCOLOR.UI().bg().render(r, (RECTANGLE)this.body, -1);
/* 49 */     COLOR.WHITE35.bind();
/*    */     
/* 51 */     (((Race)UIPickerRace.this.all.getC(UIPickerRace.this.current - 1)).appearance()).icon.renderC(r, this.body.cX() - 18, this.body.cY());
/* 52 */     (((Race)UIPickerRace.this.all.getC(UIPickerRace.this.current + 1)).appearance()).icon.renderC(r, this.body.cX() + 18, this.body.cY());
/* 53 */     COLOR.unbind();
/* 54 */     (((Race)UIPickerRace.this.all.getC(UIPickerRace.this.current)).appearance()).iconBig.renderC(r, this.body.cX(), this.body.cY());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 62 */     UIPickerRace.this.hover((GBox)text, (Race)UIPickerRace.this.all.getC(UIPickerRace.this.current));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRace$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */