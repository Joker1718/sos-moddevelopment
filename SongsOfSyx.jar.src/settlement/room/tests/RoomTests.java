/*    */ package settlement.room.tests;
/*    */ import settlement.room.main.ROOMS;
/*    */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import view.interrupter.IDebugPanel;
/*    */ import view.main.VIEW;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ 
/*    */ public final class RoomTests {
/*    */   public RoomTests(ROOMS r) {
/* 13 */     for (ROOM_ARTILLERY a : r.ARTILLERY) {
/* 14 */       IDebugPanelSett.add((PLACABLE)new ArtilleryTest(a.eplacer));
/*    */     }
/*    */     
/* 17 */     IDebugPanel.add("production & trade panel", new ACTION()
/*    */         {
/*    */           public void exe()
/*    */           {
/* 21 */             (VIEW.inters()).popup.show((RENDEROBJ)new UITradeDebug(), null);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\RoomTests.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */