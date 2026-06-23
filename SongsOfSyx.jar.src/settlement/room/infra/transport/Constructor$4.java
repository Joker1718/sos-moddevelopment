/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ class null
/*     */   extends RoomSprite.Imp
/*     */ {
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 116 */     RESOURCE res = null;
/* 117 */     int am = 0;
/*     */     
/* 119 */     TransportInstance ins = (TransportInstance)blue.get(it.tx(), it.ty());
/* 120 */     if (ins != null) {
/* 121 */       res = ins.data.resource();
/* 122 */       am = ins.data.stored();
/* 123 */       if (am > 0 || ins.data.cartVisible()) {
/* 124 */         int iii = (SETT.ROOMS()).fData.tileData.get(it.tile()) - 1;
/* 125 */         int dx = 0;
/* 126 */         int dy = 0;
/* 127 */         if ((iii & 0x1) == 1) {
/* 128 */           DIR dd = (DIR)DIR.ORTHO.get(data);
/* 129 */           dx = dd.x() * 32;
/* 130 */           dy = dd.y() * 32;
/*     */         } 
/* 132 */         (SETT.HALFENTS()).transports.sprite.renderBelow(r, s, data * 2, it.x() + dx + 32, it.y() + dy + 32, 0.0D, it.ran(), degrade, res, am / 400.0D);
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 142 */     TransportInstance ins = (TransportInstance)blue.get(it.tx(), it.ty());
/* 143 */     if (ins != null && ins.data.cartVisible()) {
/* 144 */       int iii = (SETT.ROOMS()).fData.tileData.get(it.tile()) - 1;
/* 145 */       int dx = 0;
/* 146 */       int dy = 0;
/* 147 */       if ((iii & 0x1) == 1) {
/* 148 */         DIR dd = (DIR)DIR.ORTHO.get(data);
/* 149 */         dx = dd.x() * 32;
/* 150 */         dy = dd.y() * 32;
/*     */       } 
/* 152 */       (SETT.HALFENTS()).transports.sprite.render(r, s, data * 2, it.x() + dx + 32, it.y() + dy + 32, degrade, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 159 */     return (byte)item.rotation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 165 */     ((SPRITE)(SPRITES.cons()).ICO.arrows.get(item.rotation)).render(r, x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\Constructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */