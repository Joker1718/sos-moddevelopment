/*    */ package settlement.room.infra.station;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.file.Json;
/*    */ import util.GUTIL;
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
/* 52 */     super($anonymous0, $anonymous1);
/*    */     
/* 54 */     this.top = (RoomSprite)new RoomSprite1x1(paramJson1, "WORK_TOP_1X1");
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 58 */     StationInstance ins = (StationInstance)blue.get(it.tx(), it.ty());
/* 59 */     if (ins != null && 
/* 60 */       ins.prepD() + (GUTIL.ran2().get(it.tile()) & 0xFF) * 0.00392156862745098D >= 1.0D) {
/*    */       return;
/*    */     }
/* 63 */     this.top.render(r, s, getData2(it), it, degrade, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 68 */     return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */