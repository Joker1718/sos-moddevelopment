/*    */ package settlement.room.food.fish;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ 
/*    */ class BoatMaker
/*    */ {
/*    */   public static void make(FishInstance ins) {
/* 12 */     for (COORDINATE c : ins.body()) {
/* 13 */       if (!ins.is(c) || 
/* 14 */         (SETT.ROOMS()).fData.tile.get(c) != null) {
/*    */         continue;
/*    */       }
/*    */       
/* 18 */       if ((SETT.TERRAIN()).WATER.SHALLOW.is(c) && (SETT.TERRAIN()).WATER.deepSeaFishSpot.is(c)) {
/* 19 */         make(ins, c);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void make(FishInstance ins, COORDINATE start) {
/* 27 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 28 */       if (make(ins, start, (DIR)DIR.ALL.get(di))) {
/*    */         return;
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean make(FishInstance ins, COORDINATE start, DIR dir) {
/* 37 */     int fx = start.x();
/* 38 */     int fy = start.y();
/* 39 */     for (int i = 0; i <= 55; i++) {
/* 40 */       int tx = fx + dir.x();
/* 41 */       int ty = fy + dir.y();
/* 42 */       if (ins.is(fx, fy) && (SETT.TERRAIN()).WATER.SHALLOW.is(fx, fy) && !(SETT.TERRAIN()).WATER.open.is(fx, fy)) {
/*    */         
/* 44 */         boolean border = true;
/* 45 */         for (DIR d : DIR.ALL) {
/* 46 */           if (!ins.is(fx, fy, d) || Job.isWork.is((SETT.ROOMS()).data.get(fx, fy, d))) {
/* 47 */             border = false;
/*    */             break;
/*    */           } 
/*    */         } 
/* 51 */         if (border) {
/* 52 */           int data = Job.isWork.set(0);
/* 53 */           data = Job.isShip.set(data);
/* 54 */           data = Job.shipDir.set(data, dir.perpendicular().id());
/* 55 */           (SETT.ROOMS()).data.set((ROOMA)ins, fx, fy, data);
/* 56 */           return true;
/*    */         } 
/* 58 */         return false;
/*    */       } 
/* 60 */       if (!ins.body().holdsPoint(tx, ty))
/* 61 */         return false; 
/* 62 */       if (!(SETT.TERRAIN()).WATER.is.is(tx, ty))
/* 63 */         return false; 
/* 64 */       if (!dir.isOrtho() && (
/* 65 */         !(SETT.TERRAIN()).WATER.is.is(fx, ty) || (SETT.TERRAIN()).WATER.is.is(tx, fy))) {
/* 66 */         return false;
/*    */       }
/* 68 */       fx = tx;
/* 69 */       fy = ty;
/*    */     } 
/*    */ 
/*    */     
/* 73 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\BoatMaker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */