/*     */ package settlement.room.health.asylum;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   RoomSprite sTableTop;
/*     */   
/*     */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 118 */     super($anonymous0, $anonymous1);
/*     */     
/* 120 */     this.sTableTop = (RoomSprite)new RoomSprite1x1(paramJson1, "TABLE_ONTOP_1X1")
/*     */       {
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 123 */           Constructor.null.access$0(Constructor.null.this).prenderAbove(r, s, it, degrade, true);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 128 */           return (item.get(rx, ry) == null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 134 */           (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 140 */     Constructor.this.prenderAbove(r, s, it, degrade, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 145 */     return this.sTableTop.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 151 */     super.render(r, s, data, it, degrade, isCandle);
/* 152 */     if (blue.is(it.tile()) && ((AsylumInstance)blue.get(it.tx(), it.ty())).isReserved(it.tx(), it.ty())) {
/* 153 */       this.sTableTop.render(r, s, (SETT.ROOMS()).fData.spriteData2.get(it.tile()), it, degrade, isCandle);
/*     */     }
/* 155 */     this.sTableTop.render(r, s, (SETT.ROOMS()).fData.spriteData2.get(it.tile()), it, degrade, isCandle);
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 162 */     (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\Constructor$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */