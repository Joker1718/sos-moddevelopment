/*    */ package game.battle.thread.status;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.battle.formation.DivPositionImp;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.DIMENSION;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ import snake2d.util.sets.Bitmap2D;
/*    */ 
/*    */ public final class DivArmyMap {
/*    */   public static final int radius = 7;
/* 12 */   private Bitmap2D[] maps = new Bitmap2D[] { new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false), new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false) };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DivArmyMap(DivStatus[] statuses) {}
/*    */ 
/*    */ 
/*    */   
/*    */   void add(Div div, DivPositionImp next) {
/* 22 */     for (int i = 0; i < next.deployed(); i++) {
/* 23 */       int x = next.tile(i).x();
/* 24 */       int y = next.tile(i).y();
/* 25 */       Bitmap2D m = this.maps[div.army().index()];
/* 26 */       add(x, y, m);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void add(int tx, int ty, Bitmap2D map) {
/* 32 */     for (int y = -6; y < 7; y++) {
/* 33 */       for (int x = -6; x < 7; x++) {
/*    */         
/* 35 */         int dx = tx + x;
/* 36 */         int dy = ty + y;
/* 37 */         if (SETT.IN_BOUNDS(dx, dy))
/* 38 */           map.set(dx, dy, true); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   void clear() {
/*    */     byte b;
/*    */     int i;
/*    */     Bitmap2D[] arrayOfBitmap2D;
/* 47 */     for (i = (arrayOfBitmap2D = this.maps).length, b = 0; b < i; ) { Bitmap2D m = arrayOfBitmap2D[b];
/* 48 */       m.clear();
/*    */       b++; }
/*    */   
/*    */   } public MAP_BOOLEAN enemy(Div div) {
/* 52 */     return (MAP_BOOLEAN)this.maps[div.army().index() + 1 & 0x1];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\DivArmyMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */