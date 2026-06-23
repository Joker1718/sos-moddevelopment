/*    */ package settlement.room.service.stage;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSpriteBoxN;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends RoomSpriteBoxN
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 39 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 43 */     return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() >= 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\stage\StageConstructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */