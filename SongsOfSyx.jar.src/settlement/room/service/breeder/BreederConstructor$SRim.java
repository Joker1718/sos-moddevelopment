/*     */ package settlement.room.service.breeder;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SRim
/*     */   extends RoomSprite1x1
/*     */ {
/*     */   private final RoomSprite worm;
/*     */   private final int dirOff;
/*     */   private final Coo coo;
/*     */   
/*     */   public SRim(Json json, String key, RoomSprite worm, int dirOff) throws IOException {
/* 261 */     super(json, key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     this.coo = new Coo();
/*     */     this.worm = worm;
/*     */     this.dirOff = dirOff;
/*     */     sData(1);
/* 283 */   } public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) { COORDINATE c = (SETT.ROOMS()).fData.itemX1Y1(it.tx(), it.ty(), this.coo);
/* 284 */     if (c != null) {
/* 285 */       it.ranOffset(c.x() - it.tx(), c.y() - it.ty());
/*     */     }
/* 287 */     super.render(r, s, data, it, degrade, false); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 293 */     long ran = it.bigRan();
/*     */     
/* 295 */     DIR d = rot(data);
/* 296 */     d = d.next(this.dirOff);
/*     */     
/* 298 */     if (BreederConstructor.this.blue.station.worm(it.tx(), it.ty(), (int)ran)) {
/* 299 */       it.setOff(d.x() * 32 / 2, d.y() * 32 / 2);
/* 300 */       this.worm.render(r, s, (int)ran, it, degrade, false);
/*     */     } 
/* 302 */     ran >>= 32L;
/* 303 */     if (BreederConstructor.this.blue.station.worm(it.tx(), it.ty(), (int)ran)) {
/* 304 */       it.setOff(d.x() * 32, d.y() * 32);
/* 305 */       it.ranOffset(data, data);
/* 306 */       it.ranSwap();
/* 307 */       this.worm.render(r, s, (int)ran, it, degrade, false);
/*     */     } 
/* 309 */     return false;
/*     */   } protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) { rx -= d.x();
/*     */     ry -= d.y();
/*     */     d = d.next(this.dirOff);
/*     */     rx += d.x();
/*     */     ry += d.y();
/* 315 */     return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 2); } public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) { return this.worm.getData(tx, ty, rx, ry, item, itemRan); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 321 */     DIR d = rot(data);
/* 322 */     int s = 0;
/* 323 */     if ((this.dirOff & 0x1) != 0) {
/* 324 */       s |= d.next(2).mask();
/* 325 */       s |= d.next(4).mask();
/*     */     } else {
/*     */       
/* 328 */       s |= d.mask();
/* 329 */       s |= d.next(2).mask();
/* 330 */       s |= d.next(4).mask();
/*     */     } 
/* 332 */     (SPRITES.cons()).BIG.outline.render(r, s, x, y);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\BreederConstructor$SRim.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */