/*     */ package settlement.room.service.breeder;
/*     */ 
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends RoomSprite.Imp
/*     */ {
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  68 */     long rr = it.bigRan();
/*     */     
/*  70 */     for (int i = 0; i < 4; i++) {
/*  71 */       int ran = (int)(rr & 0xFFL);
/*  72 */       rr >>= 16L;
/*     */       
/*  74 */       if (blue.station.worm(it.tx(), it.ty(), ran)) {
/*  75 */         bug.render(r, s, ran, it, degrade, false);
/*     */         
/*  77 */         DIR d = (DIR)DIR.ALL.getC(ran & 0x7);
/*  78 */         ran >>= 3;
/*  79 */         it.setOff(d.x() * 32 / 2, d.y() * 32 / 2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  84 */     int am = blue.station.resources(it.tx(), it.ty(), it.ran());
/*  85 */     if (am > 0) {
/*  86 */       ((IndustryResource)((Industry)blue.indus.get(0)).ins().get(0)).resource.renderLaying(r, it.x(), it.y(), it.ran(), am);
/*     */     }
/*     */     
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  94 */     return bug.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 100 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\BreederConstructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */