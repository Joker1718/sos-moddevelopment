/*    */ package settlement.room.service.breeder;
/*    */ 
/*    */ import util.gui.misc.GButt;
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
/* 72 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 76 */     ((ROOM_BREEDER)Gui.access$2(Gui.this)).prosecute = !((ROOM_BREEDER)Gui.access$2(Gui.this)).prosecute;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 81 */     selectedSet(((ROOM_BREEDER)Gui.access$2(Gui.this)).prosecute);
/* 82 */     super.renAction();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\Gui$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */