/*    */ package settlement.room.knowledge.university;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import snake2d.SPRITE_RENDERER;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 45 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 49 */     for (int i = 0; i < 3; i++) {
/* 50 */       if (item.sprite(rx + d.x() * i, ry + d.y() * i) != null && item.sprite(rx + d.x() * i, ry + d.y() * i).sData() == 2)
/* 51 */         return true; 
/*    */     } 
/* 53 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 59 */     type().renderOverlay(
/* 60 */         x, y, r, AVAILABILITY.AVOID_PASS, 
/* 61 */         0, data, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledg\\university\UniversityConstructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */