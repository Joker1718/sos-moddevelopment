/*    */ package util.gui.common;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ import util.gui.table.GTableBuilder;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GTableBuilder.GRowBuilder
/*    */ {
/*    */   public RENDEROBJ build(GETTER<Integer> ier) {
/* 45 */     UIPickerResAm.Button b = new UIPickerResAm.Button(UIPickerResAm.this, ier);
/* 46 */     UIPickerResAm.G gg = new UIPickerResAm.G(UIPickerResAm.this, ier);
/* 47 */     UIPickerResAm.this.addToRow(b, gg);
/* 48 */     return (RENDEROBJ)b;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerResAm$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */