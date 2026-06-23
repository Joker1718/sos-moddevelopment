/*     */ package settlement.room.knowledge.school;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
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
/*     */ class null
/*     */   extends RoomSprite1x1
/*     */ {
/*     */   final RoomSprite top;
/*     */   
/*     */   null(RoomSprite $anonymous0, Json paramJson) throws IOException {
/* 107 */     super($anonymous0);
/*     */     
/* 109 */     this.top = (RoomSprite)new RoomSprite1x1(paramJson, "TABLE_TOP_1X1");
/*     */   }
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 113 */     if (item.width() > 1 && item.height() > 1) {
/* 114 */       return ((d == DIR.ORTHO.get(item.rotation) || d == ((DIR)DIR.ORTHO.get(item.rotation)).perpendicular()) && item.sprite(rx, ry) == this);
/*     */     }
/* 116 */     return (DIR.ORTHO.get(item.rotation) == d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 121 */     if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 122 */       this.top.render(r, s, getData2(it), it, degrade, false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 128 */     return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\SchoolConstructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */