/*    */ package settlement.room.law.stocks;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends UIRoomModule
/*    */ {
/*    */   public void hover(GBox box, Room i, int rx, int ry) {
/* 67 */     AREA a = (AREA)(SETT.ROOMS()).map.rooma.get(rx, ry);
/* 68 */     int am = 0;
/* 69 */     int aa = 0;
/* 70 */     for (COORDINATE c : a.body()) {
/* 71 */       if (a.is(c) && ROOM_STOCKS.this.tile.get(c.x(), c.y()) != null) {
/* 72 */         am++;
/* 73 */         if (ROOM_STOCKS.this.tile.get(c.x(), c.y()).state() == Tile.STATE.available) {
/* 74 */           aa++;
/*    */         }
/*    */       } 
/*    */     } 
/* 78 */     box.textLL(Dic.¤¤Available);
/* 79 */     box.add((SPRITE)GFORMAT.iofk(box.text(), aa, am));
/*    */     
/* 81 */     super.hover(box, i, rx, ry);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\ROOM_STOCKS$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */