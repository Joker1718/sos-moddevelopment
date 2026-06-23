/*     */ package settlement.room.service.lavatory;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   private RoomSprite water;
/*     */   private RoomSprite basin;
/*     */   
/*     */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 120 */     super($anonymous0, $anonymous1);
/*     */     
/* 122 */     this.water = (RoomSprite)new RoomSprite1x1(paramJson1, "BASIN_WATER_1X1");
/* 123 */     this.basin = (RoomSprite)new RoomSprite1x1(paramJson1, "BASIN_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 126 */           return (item.sprite(rx, ry) == null && (d.orthoID() == item.rotation || d.perpendicular().orthoID() == item.rotation));
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 132 */     return this.basin.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 138 */     super.render(r, s, data, it, degrade, isCandle);
/* 139 */     this.water.render(r, s, getData2(it), it, degrade, isCandle);
/* 140 */     this.basin.render(r, s, getData2(it), it, degrade, isCandle);
/* 141 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\lavatory\Constructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */