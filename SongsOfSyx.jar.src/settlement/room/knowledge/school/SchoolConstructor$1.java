/*    */ package settlement.room.knowledge.school;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   final RoomSprite top;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 45 */     super($anonymous0, $anonymous1);
/*    */     
/* 47 */     this.top = (RoomSprite)new RoomSprite1x1(paramJson1, "BOOK_1X1")
/*    */       {
/*    */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*    */         {
/* 51 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 58 */     return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 63 */     if (blue.is(it.tile())) {
/* 64 */       DIR d = (DIR)DIR.ORTHO.get(getRot(data));
/* 65 */       FSERVICE f = blue.station.service(it.tx() + d.x(), it.ty() + d.y());
/* 66 */       if (f != null && (f.findableReservedCanBe() || f.findableReservedIs())) {
/* 67 */         this.top.render(r, s, getData2(it), it, degrade, false);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 74 */     return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\SchoolConstructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */