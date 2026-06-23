/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.GuiSection;
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
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 82 */     UIRoomTable.tableSort.sort();
/* 83 */     super.render(r, ds);
/* 84 */     if (UIRoomTable.this.hovered != null) {
/* 85 */       SETT.OVERLAY().add(UIRoomTable.this.hovered.mX(), UIRoomTable.this.hovered.mY());
/* 86 */       VIEW.s().getWindow().centerAtTile(UIRoomTable.this.hovered.body().cX(), UIRoomTable.this.hovered.body().cY());
/* 87 */       UIRoomTable.this.wasHovering = true;
/* 88 */       UIRoomTable.this.hovered = null;
/*    */     } else {
/* 90 */       if (UIRoomTable.this.wasHovering)
/* 91 */         VIEW.s().getWindow().centerAt((COORDINATE)UIRoomTable.this.oldC); 
/* 92 */       UIRoomTable.this.wasHovering = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoomTable$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */