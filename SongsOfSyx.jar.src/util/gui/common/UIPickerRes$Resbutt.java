/*    */ package util.gui.common;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
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
/*    */ class Resbutt
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   private final RESOURCE res;
/*    */   private int i;
/*    */   
/*    */   Resbutt(RESOURCE res, int i) {
/* 51 */     super((res == null) ? (SPRITE)(SPRITES.icons()).m.cancel : (SPRITE)res.icon());
/* 52 */     this.res = res;
/* 53 */     this.i = 0;
/* 54 */     pad(4, 4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 59 */     if (this.res == null) {
/* 60 */       text.text(Dic.¤¤cancel);
/*    */     } else {
/* 62 */       UIPickerRes.this.hoverResource(this.res, (GBox)text);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 67 */     UIPickerRes.this.select(this.res, this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 72 */     selectedSet((UIPickerRes.this.getResource() == this.res));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRes$Resbutt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */