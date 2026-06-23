/*    */ package settlement.misc;
/*    */ 
/*    */ import settlement.job.Job;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItemTile;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SettPlacability
/*    */ {
/* 14 */   public final MAP_BOOLEAN solidityWill = new MAP_BOOLEAN()
/*    */     {
/*    */       public boolean is(int tile)
/*    */       {
/* 18 */         throw new RuntimeException();
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean is(int tx, int ty) {
/* 23 */         if ((SETT.PATH()).solidity.is(tx, ty))
/* 24 */           return true; 
/* 25 */         if ((SETT.JOBS()).getter.get(tx, ty) != null && ((Job)(SETT.JOBS()).getter.get(tx, ty)).becomesSolid())
/* 26 */           return true; 
/* 27 */         if ((SETT.ROOMS()).fData.tile.get(tx, ty) != null && ((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty)).isBlocker())
/* 28 */           return true; 
/* 29 */         return false;
/*    */       }
/*    */     };
/*    */   
/* 33 */   public final MAP_BOOLEAN willBlock = new MAP_BOOLEAN()
/*    */     {
/*    */       public boolean is(int tile)
/*    */       {
/* 37 */         throw new RuntimeException();
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean is(int tx, int ty) {
/* 42 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 43 */           DIR d = (DIR)DIR.ORTHO.get(di);
/* 44 */           if (willBeBlocked(d, tx, ty))
/* 45 */             return true; 
/*    */         } 
/* 47 */         return false;
/*    */       }
/*    */       
/*    */       private boolean willBeBlocked(DIR from, int tx, int ty) {
/* 51 */         tx += from.x();
/* 52 */         ty += from.y();
/* 53 */         FurnisherItemTile t = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(tx, ty);
/* 54 */         if (t != null && t.mustBeReachable) {
/*    */           
/* 56 */           from = from.perpendicular();
/* 57 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*    */             
/* 59 */             DIR d = (DIR)DIR.ORTHO.get(di);
/* 60 */             if (d != from)
/*    */             {
/* 62 */               if (SETT.IN_BOUNDS(tx, ty, d))
/*    */               {
/* 64 */                 if (!SettPlacability.this.solidityWill.is(tx, ty, d))
/* 65 */                   return false;  }  } 
/*    */           } 
/* 67 */           return true;
/*    */         } 
/* 69 */         return false;
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public boolean willBeBlocked(int tx, int ty, int rx, int ry, MAP_OBJECT<?> dontCareAboutNonNull) {
/* 75 */     int dc = 0;
/* 76 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 77 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 78 */       if (dontCareAboutNonNull.is(rx, ry, d)) {
/* 79 */         dc++;
/*    */       
/*    */       }
/* 82 */       else if (!this.solidityWill.is(tx, ty, d)) {
/* 83 */         return false;
/*    */       } 
/* 85 */     }  return (dc != DIR.ORTHO.size());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\SettPlacability.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */