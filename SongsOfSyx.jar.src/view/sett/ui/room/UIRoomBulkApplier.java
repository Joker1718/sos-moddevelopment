/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ public abstract class UIRoomBulkApplier
/*    */ {
/*    */   protected final CharSequence name;
/*    */   
/*    */   public UIRoomBulkApplier(CharSequence name) {
/* 11 */     this.name = name;
/*    */   }
/*    */   
/*    */   protected abstract void apply(RoomInstance paramRoomInstance);
/*    */   
/*    */   protected void hover(GBox b) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoomBulkApplier.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */