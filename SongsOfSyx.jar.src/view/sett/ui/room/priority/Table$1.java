/*    */ package view.sett.ui.room.priority;
/*    */ 
/*    */ import settlement.room.main.employment.RoomEmployment;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 33 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 37 */     for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/* 38 */       if (fRoom.active(e))
/* 39 */         ((RoomEmployment)e.o).priority.inc(-1); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Table$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */