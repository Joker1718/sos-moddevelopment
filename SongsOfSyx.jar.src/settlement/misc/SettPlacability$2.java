/*    */ package settlement.misc;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItemTile;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
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
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tile) {
/* 37 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 42 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 43 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 44 */       if (willBeBlocked(d, tx, ty))
/* 45 */         return true; 
/*    */     } 
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   private boolean willBeBlocked(DIR from, int tx, int ty) {
/* 51 */     tx += from.x();
/* 52 */     ty += from.y();
/* 53 */     FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 54 */     if (t != null && t.mustBeReachable) {
/*    */       
/* 56 */       from = from.perpendicular();
/* 57 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*    */         
/* 59 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 60 */         if (d != from)
/*    */         {
/* 62 */           if (SETT.IN_BOUNDS(tx, ty, d))
/*    */           {
/* 64 */             if (!SettPlacability.this.solidityWill.is(tx, ty, d))
/* 65 */               return false;  }  } 
/*    */       } 
/* 67 */       return true;
/*    */     } 
/* 69 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\SettPlacability$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */