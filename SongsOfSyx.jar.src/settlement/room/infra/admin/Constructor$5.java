/*     */ package settlement.room.infra.admin;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.room.sprite.RoomSpriteImp;
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
/*     */   final RoomSprite idle;
/*     */   final RoomSprite active;
/*     */   final RoomSpriteImp ontop;
/*     */   
/*     */   null(RoomSprite $anonymous0, Json paramJson) throws IOException {
/* 132 */     super($anonymous0);
/*     */     
/* 134 */     this.idle = (RoomSprite)new RoomSprite1x1(paramJson, "WORK_UNUSED_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 137 */           return (item.get(rx, ry) != null && item.get(rx, ry).data() == 3);
/*     */         }
/*     */       };
/* 140 */     this.active = (RoomSprite)new RoomSprite1x1(paramJson, "WORK_USED_1X1");
/* 141 */     this.ontop = (RoomSpriteImp)new RoomSprite1x1(paramJson, "WORK_USED_TOP_1X1");
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 146 */     if (!blue.is(it.tile()))
/*     */       return; 
/* 148 */     SETT_JOB j = blue.job.get(it.tx(), it.ty());
/*     */     
/* 150 */     if (j.jobReservedIs(null)) {
/*     */ 
/*     */       
/* 153 */       this.ontop.animate((blue.job.used(it.tx(), it.ty()) ? true : false));
/* 154 */       this.active.render(r, s, getData2(it), it, degrade, false);
/* 155 */       this.ontop.render(r, s, getData2(it), it, degrade, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 161 */     return this.idle.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\Constructor$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */