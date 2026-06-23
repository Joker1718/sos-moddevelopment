/*    */ package view.sett.ui.army;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
/*    */ import world.army.AD;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 62 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 66 */     activeSet((UIArmyCitySendOut.this.li.size() > 0 && Actions.sendProblem((LIST<Div>)UIArmyCitySendOut.this.li) == null));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 72 */     for (UIArmyCitySendOut.Card c : UIArmyCitySendOut.this.current) {
/* 73 */       if (UIArmyCitySendOut.this.army.divs().canAdd() && c.selectedIs() && (c.div()).info.men() > 0 && AD.cityDivs().attachedArmy(c.div()) == null) {
/* 74 */         AD.cityDivs().attach(UIArmyCitySendOut.this.army, c.div());
/*    */       }
/*    */     } 
/*    */     
/* 78 */     (VIEW.inters()).popup.close();
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 83 */     Actions.hoverSendOutProblem((LIST<Div>)UIArmyCitySendOut.this.li, text);
/* 84 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\UIArmyCitySendOut$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */