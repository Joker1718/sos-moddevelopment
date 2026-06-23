/*    */ package settlement.room.sprite;
/*    */ 
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.SPRITE_RENDERER;
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
/*    */ public class Dummy
/*    */   implements RoomSprite
/*    */ {
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 63 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int sData() {
/* 68 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSprite$Dummy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */