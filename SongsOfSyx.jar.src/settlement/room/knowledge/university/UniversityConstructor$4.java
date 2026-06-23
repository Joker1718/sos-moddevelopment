/*     */ package settlement.room.knowledge.university;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
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
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 106 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 111 */     super.render(r, s, data, it, degrade, isCandle);
/* 112 */     data = getData2(it);
/* 113 */     if (data != 0)
/* 114 */       sCarpet.renderBelow(r, s, getData2(it), it, degrade); 
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 121 */     int m = 0;
/* 122 */     if (!isC(rx, ry, item))
/* 123 */       return 0; 
/* 124 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 125 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 126 */       if (isC(rx + d.x(), ry + d.y(), item))
/* 127 */         m |= d.mask(); 
/*     */     } 
/* 129 */     return (byte)m;
/*     */   }
/*     */   
/*     */   private boolean isC(int rx, int ry, FurnisherItem item) {
/* 133 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 134 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 135 */       if (item.sprite(rx + d.x(), ry + d.y()) != this)
/* 136 */         return false; 
/*     */     } 
/* 138 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 143 */     return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledg\\university\UniversityConstructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */