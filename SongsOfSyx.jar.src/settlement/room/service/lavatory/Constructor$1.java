/*    */ package settlement.room.service.lavatory;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import settlement.room.sprite.RoomSpriteCombo;
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
/*    */ class null
/*    */   extends RoomSpriteCombo
/*    */ {
/*    */   private RoomSprite rim;
/*    */   private RoomSprite lid;
/*    */   private RoomSprite shit;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 46 */     super($anonymous0, $anonymous1);
/*    */     
/* 48 */     this.rim = (RoomSprite)new RoomSprite1x1(paramJson1, "SHITHOLE_1X1")
/*    */       {
/*    */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 51 */           return (item.sprite(rx, ry) == null && (d.orthoID() == item.rotation || d.perpendicular().orthoID() == item.rotation));
/*    */         }
/*    */       };
/* 54 */     this.lid = (RoomSprite)new RoomSprite1x1(paramJson1, "SHIT_LID_1X1");
/* 55 */     this.shit = (RoomSprite)new RoomSprite1x1(paramJson1, "SHIT_1X1");
/*    */   }
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 59 */     return this.rim.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 65 */     super.render(r, s, data, it, degrade, isCandle);
/* 66 */     if (blue.is(it.tile()) && Lavatory.isOpen((SETT.ROOMS()).data.get(it.tile()))) {
/* 67 */       this.shit.render(r, s, getData2(it), it, degrade, isCandle);
/* 68 */       this.rim.render(r, s, getData2(it), it, degrade, isCandle);
/*    */     } else {
/* 70 */       this.lid.render(r, s, getData2(it), it, degrade, isCandle);
/*    */     } 
/*    */     
/* 73 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\lavatory\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */