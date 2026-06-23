/*    */ package settlement.room.service.food.canteen;
/*    */ 
/*    */ import init.resources.ResG;
/*    */ import init.settings.S;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.info.GFORMAT;
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
/*    */ class null
/*    */   extends GButt.BSection
/*    */ {
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 41 */     GBox b = (GBox)text;
/* 42 */     b.title(e.resource.name);
/* 43 */     b.textLL(Gui.this.¤¤Food).add((SPRITE)GFORMAT.i(b.text(), ((CanteenInstance)g.get()).amount(e)));
/* 44 */     if ((S.get()).developer) {
/* 45 */       b.NL();
/* 46 */       b.textL(Dic.¤¤Access);
/* 47 */       b.add((SPRITE)GFORMAT.i(b.text(), ((CanteenInstance)g.get()).amountReserved(e)));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 53 */     selectedSet(((CanteenInstance)g.get()).uses(e));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 58 */     ((CanteenInstance)g.get()).usesToggle(e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */