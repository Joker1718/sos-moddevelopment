/*     */ package game.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.map.MAP_OBJECT_ISSER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements MAP_OBJECT_ISSER<Induvidual>
/*     */ {
/*     */   public boolean is(int tx, int ty, Induvidual value) {
/* 104 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 105 */       return false; 
/* 106 */     return is(tx + ty * SETT.TWIDTH, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is(int tile, Induvidual in) {
/* 112 */     Army value = in.army();
/* 113 */     Room r = (SETT.ROOMS()).map.get(tile);
/* 114 */     if (r != null) {
/* 115 */       if (in.hType() == HTYPES.RIOTER() && r.blueprint() instanceof settlement.room.spirit.grave.GraveData.GRAVE_DATA_HOLDER)
/* 116 */         return false; 
/* 117 */       if (r instanceof ArtilleryInstance) {
/* 118 */         return (((ArtilleryInstance)r).army() != value);
/*     */       }
/* 120 */       return (GAME.ARMIES().player() != value);
/*     */     } 
/*     */     
/* 123 */     if (value == GAME.ARMIES().player() && 
/* 124 */       SETT.TERRAIN().get(tile).clearing().isStructure()) {
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     if ((SETT.PATH()).availability.get(tile).isSolid(value) && SETT.TERRAIN().get(tile).clearing().canDestroy(tile % SETT.TWIDTH, tile / SETT.TWIDTH)) {
/* 129 */       return true;
/*     */     }
/* 131 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\TargetMap$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */