/*    */ package settlement.misc;
/*    */ 
/*    */ import settlement.job.Job;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItemTile;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tile) {
/* 18 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 23 */     if ((SETT.PATH()).solidity.is(tx, ty))
/* 24 */       return true; 
/* 25 */     if ((SETT.JOBS()).getter.get(tx, ty) != null && ((Job)(SETT.JOBS()).getter.get(tx, ty)).becomesSolid())
/* 26 */       return true; 
/* 27 */     if ((SETT.ROOMS()).fData.tile.get(tx, ty) != null && ((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty)).isBlocker())
/* 28 */       return true; 
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\SettPlacability$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */