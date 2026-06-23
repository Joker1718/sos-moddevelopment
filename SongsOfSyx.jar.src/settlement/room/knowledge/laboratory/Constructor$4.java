/*     */ package settlement.room.knowledge.laboratory;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
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
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   final RoomSprite1x1 ontop;
/*     */   
/*     */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/*  79 */     super($anonymous0, $anonymous1);
/*     */     
/*  81 */     this.ontop = new RoomSprite1x1(paramJson1, "WORK_TABLE_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/*  85 */           return (item.sprite(rx + d.perpendicular().x() * 2, ry + d.perpendicular().y() * 2) == (Constructor.null.access$0(Constructor.null.this)).schair);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  91 */     if (blue.job.used(it.tx(), it.ty())) {
/*  92 */       int i = 0;
/*  93 */       for (DIR d : DIR.ORTHO) {
/*  94 */         if ((SETT.ROOMS()).fData.sprite.is(it.tx(), it.ty(), d, Constructor.this.schair)) {
/*  95 */           tablet.render(r, s, i, it, degrade, false);
/*     */           break;
/*     */         } 
/*  98 */         i++;
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     this.ontop.render(r, s, getData2(it), it, degrade, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 107 */     return this.ontop.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\laboratory\Constructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */