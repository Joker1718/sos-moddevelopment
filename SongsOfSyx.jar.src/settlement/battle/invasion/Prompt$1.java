/*    */ package settlement.battle.invasion;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import util.gui.misc.GButt;
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
/* 56 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 60 */     InvasionSpec sp = SETT.INVADOR().spec(Prompt.this.ref);
/* 61 */     activeSet((sp != null && sp.canBeAttacked));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 66 */     InvasionSpec sp = SETT.INVADOR().spec(Prompt.this.ref);
/* 67 */     if (sp != null && sp.canBeAttacked)
/* 68 */       (VIEW.inters()).messages.hide(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\Prompt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */