/*    */ package game.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.military.artillery.ArtilleryInstance;
/*    */ import snake2d.util.map.MAP_OBJECT;
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
/*    */   implements MAP_OBJECT<Army>
/*    */ {
/*    */   public Army get(int tile) {
/* 47 */     Room r = (SETT.ROOMS()).map.get(tile);
/* 48 */     if (r != null) {
/* 49 */       if (r instanceof ArtilleryInstance) {
/* 50 */         return ((ArtilleryInstance)r).army();
/*    */       }
/* 52 */       return GAME.ARMIES().player();
/*    */     } 
/*    */     
/* 55 */     return (((SETT.PATH()).availability.get(tile)).player < 0.0D) ? GAME.ARMIES().player() : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Army get(int tx, int ty) {
/* 60 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 61 */       return null; 
/* 62 */     return get(tx + ty * SETT.TWIDTH);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\TargetMap$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */