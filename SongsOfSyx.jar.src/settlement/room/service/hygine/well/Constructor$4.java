/*     */ package settlement.room.service.hygine.well;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
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
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   null(Json $anonymous0, String $anonymous1) throws IOException {
/*  96 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 103 */     if (blue.is(it.tile())) {
/* 104 */       sStencil.render(r, s, data, it, degrade, false);
/* 105 */       (SETT.TERRAIN()).WATER.renderOverlayed(it);
/*     */     } 
/* 107 */     it.countWater();
/* 108 */     it.countWater();
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 114 */     super.render(r, s, data, it, degrade, false);
/* 115 */     int up = (blue.is(it.tile()) && ((WellInstance)blue.getter.get(it.tile())).upgrade() > 0) ? 1 : 0;
/* 116 */     RoomSprite roo = eSprite((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile()), data, up);
/* 117 */     if (roo != null) {
/* 118 */       roo.render(r, s, getData2(it), it, degrade, false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 124 */     RoomSprite roo = eSprite(item, getData(tx, ty, rx, ry, item, itemRan), 0);
/* 125 */     if (roo != null)
/* 126 */       return roo.getData(tx, ty, rx, ry, item, itemRan); 
/* 127 */     return 0;
/*     */   }
/*     */   
/*     */   private RoomSprite eSprite(FurnisherItem item, int data, int up) {
/* 131 */     if (item.width() == 4) {
/* 132 */       if ((data & DIR.S.mask()) == 0) {
/* 133 */         return sRoof;
/*     */       }
/* 135 */     } else if (item.width() == 5) {
/* 136 */       if (up > 0) {
/* 137 */         if ((data & 0xF) == 15) {
/* 138 */           return sFountain;
/*     */         }
/* 140 */       } else if ((data & DIR.S.mask()) != 0 && (data & DIR.N.mask()) != 0) {
/* 141 */         if ((data & 0xF) == 15)
/* 142 */           return sRoofMid; 
/* 143 */         return sRoof;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\well\Constructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */