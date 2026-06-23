/*    */ package game.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.military.artillery.ArtilleryInstance;
/*    */ import snake2d.util.map.MAP_OBJECT_ISSER;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements MAP_OBJECT_ISSER<Army>
/*    */ {
/*    */   public boolean is(int tx, int ty, Army value) {
/* 70 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 71 */       return false; 
/* 72 */     return is(tx + ty * SETT.TWIDTH, value);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean is(int tile, Army value) {
/* 79 */     Room r = (SETT.ROOMS()).map.get(tile);
/* 80 */     if (r != null) {
/* 81 */       if (r instanceof ArtilleryInstance) {
/* 82 */         return (((ArtilleryInstance)r).army() != value);
/*    */       }
/* 84 */       return (GAME.ARMIES().player() != value);
/*    */     } 
/*    */     
/* 87 */     if (value == GAME.ARMIES().player() && 
/* 88 */       SETT.TERRAIN().get(tile).clearing().isStructure()) {
/* 89 */       return false;
/*    */     }
/*    */     
/* 92 */     if ((SETT.PATH()).availability.get(tile).isSolid(value) && SETT.TERRAIN().get(tile).clearing().canDestroy(tile % SETT.TWIDTH, tile / SETT.TWIDTH)) {
/* 93 */       return true;
/*    */     }
/* 95 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\TargetMap$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */