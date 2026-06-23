/*     */ package settlement.room.food.pasture;
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
/*     */ class null
/*     */   extends FurnisherItemTile
/*     */ {
/*     */   null(Furnisher $anonymous0, RoomSprite $anonymous1, AVAILABILITY $anonymous2, boolean $anonymous3) {
/*  85 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, MAP_BOOLEAN roomIs, FurnisherItem it, int rx, int ry) {
/*  89 */     if ((SETT.ROOMS()).placement.embryo.is(tx, ty) && 
/*  90 */       (SETT.ROOMS()).placement.placer.autoWalls.is()) {
/*  91 */       for (DIR d : DIR.ORTHO) {
/*  92 */         if (it.get(rx, ry, d) == null && UtilWallPlacability.wallCanBe.is(tx, ty, d) && (SETT.ROOMS()).placement.placer.placerDoor.isPlacable(tx + d.x(), ty + d.y(), null, null) == null) {
/*  93 */           return ConstructorOutdoor.¤¤Problem3;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 100 */     for (DIR d : DIR.ORTHO) {
/* 101 */       if (!roomIs.is(tx, ty, d)) {
/* 102 */         return null;
/*     */       }
/*     */     } 
/* 105 */     return ConstructorOutdoor.¤¤Problem;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ConstructorOutdoor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */