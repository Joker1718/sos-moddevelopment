/*     */ package settlement.room.law.stockade;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.placement.UtilWallPlacability;
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
/* 124 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) {
/* 128 */     if ((SETT.ROOMS()).placement.embryo.is(tx, ty) && 
/* 129 */       (SETT.ROOMS()).placement.placer.autoWalls.is()) {
/* 130 */       for (DIR d : DIR.ORTHO) {
/* 131 */         if (it.get(rx, ry, d) == null && UtilWallPlacability.wallCanBe.is(tx, ty, d) && (SETT.ROOMS()).placement.placer.placerDoor.isPlacable(tx + d.x(), ty + d.y(), null, null) == null) {
/* 132 */           return Constructor.¤¤Problem3;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 139 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 140 */       DIR dd = (DIR)DIR.ORTHO.get(di);
/* 141 */       if (!roomIs.is(tx, ty, dd) && !(SETT.PATH()).solidity.is(tx, ty, dd) && 
/* 142 */         roomIs.is(tx, ty, dd.next(2)) && !roomIs.is(tx, ty, dd.next(1)) && 
/* 143 */         roomIs.is(tx, ty, dd.next(-2)) && !roomIs.is(tx, ty, dd.next(-1))) {
/* 144 */         return null;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 150 */     return Constructor.¤¤Problem;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\Constructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */