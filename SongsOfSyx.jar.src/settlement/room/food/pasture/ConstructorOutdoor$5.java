/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends FurnisherItemTile
/*     */ {
/*     */   null(Furnisher $anonymous0, RoomSprite $anonymous1, AVAILABILITY $anonymous2, boolean $anonymous3) {
/* 115 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) {
/* 120 */     for (DIR d : DIR.ORTHO) {
/* 121 */       if (it.get(rx, ry, d) != null) {
/*     */         continue;
/*     */       }
/* 124 */       if (!p(tx + d.x(), ty + d.y(), roomIs)) {
/* 125 */         return ConstructorOutdoor.¤¤Problem2;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 131 */     return super.isPlacable(tx, ty, roomIs, it, rx, ry);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean p(int tx, int ty, MAP_BOOLEAN roomIs) {
/* 136 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 137 */       if (!roomIs.is(tx, ty, (DIR)DIR.ORTHO.get(i)))
/* 138 */         return false; 
/*     */     } 
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ConstructorOutdoor$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */