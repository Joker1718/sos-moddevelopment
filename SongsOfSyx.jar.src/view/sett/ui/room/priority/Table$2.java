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
/*    */ 
/*    */ 
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
/* 44 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 48 */     for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/* 49 */       if (fRoom.active(e))
/* 50 */         ((RoomEmployment)e.o).priority.inc(1); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Table$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */