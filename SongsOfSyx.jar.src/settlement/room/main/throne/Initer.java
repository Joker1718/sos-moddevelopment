/*    */ package settlement.room.main.throne;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import util.GUTIL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Initer
/*    */ {
/*    */   Initer(THRONE t) {}
/*    */   
/*    */   public boolean placebleWhole(int x1, int y1, int rot) {
/* 18 */     int x2 = x1 + Sprite.width(rot);
/* 19 */     int y2 = y1 + Sprite.height(rot);
/*    */     
/* 21 */     for (int y = y1; y < y2; y++) {
/* 22 */       for (int x = x1; x < x2; x++) {
/* 23 */         if (!placableTile(x, y))
/* 24 */           return false; 
/*    */       } 
/*    */     } 
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public boolean placableTile(int tx, int ty) {
/* 31 */     if ((SETT.JOBS()).getter.is(tx, ty))
/* 32 */       return false; 
/* 33 */     if ((SETT.ROOMS()).map.is(tx, ty))
/* 34 */       return false; 
/* 35 */     if ((SETT.TERRAIN()).TREES.isTree(tx, ty))
/* 36 */       return true; 
/* 37 */     if (!(SETT.TERRAIN()).NADA.is(tx, ty) && !SETT.TERRAIN().get(tx, ty).roofIs() && !SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared())
/* 38 */       return false; 
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public void markArround(int tx, int ty) {
/* 43 */     int i = 0;
/* 44 */     while (GUTIL.circle().radius(i) < 100) {
/* 45 */       int x = tx + GUTIL.circle().get(i).x();
/* 46 */       int y = ty + GUTIL.circle().get(i).y();
/*    */       
/* 48 */       if (placebleWhole(x, y, 0)) {
/* 49 */         (SETT.ROOMS()).THRONE.setInstance(tx, ty);
/*    */         return;
/*    */       } 
/* 52 */       i++;
/*    */     } 
/*    */     
/* 55 */     (SETT.ROOMS()).THRONE.setInstance(tx, ty);
/*    */   }
/*    */   
/*    */   public void place(int x1, int y1, int rot) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\throne\Initer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */