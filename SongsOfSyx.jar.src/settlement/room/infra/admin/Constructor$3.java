/*     */ package settlement.room.infra.admin;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
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
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   final RoomSprite1x1 idle;
/*     */   
/*     */   null(RoomSprite $anonymous0, Json paramJson) throws IOException {
/*  76 */     super($anonymous0);
/*     */     
/*  78 */     this.idle = new RoomSprite1x1(paramJson, "ADMIN_ONTOP_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  81 */           return (d.orthoID() == item.rotation);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  88 */     data = getData2(it);
/*  89 */     Room ro = (SETT.ROOMS()).map.get(it.tile());
/*  90 */     if (ro instanceof AdminInstance && !(SETT.ROOMS()).fData.candle.is(it.tile())) {
/*  91 */       long ran = GUTIL.ran2().get(it.tx(), it.ty()) << 32L | GUTIL.ran2().get(it.tx() + 1, it.ty());
/*  92 */       int am = blue.data.usedD >> 4 & 0xF;
/*  93 */       am -= it.ran() & 0x3;
/*  94 */       DIR d = this.idle.rot(getData2(it));
/*  95 */       for (int i = 0; i < am; i++) {
/*  96 */         int dd = (int)((ran & 0x7L) * 7L);
/*  97 */         DIR dd2 = d.next(2);
/*  98 */         int d2 = (int)(ran >> 3L & 0x1L);
/*  99 */         d2 *= 4;
/* 100 */         ran >>= 4L;
/*     */         
/* 102 */         it.setOff(-d.x() * dd + dd2.x() * d2, -d.y() * dd + dd2.y() * d2);
/* 103 */         this.idle.render(r, s, data, it, degrade, false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 112 */     return this.idle.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\Constructor$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */