/*    */ package game.battle.thread.status;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.battle.formation.DivPositionImp;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_DOUBLE;
/*    */ import snake2d.util.sets.Bitsmap1D;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DivsSpaceMap
/*    */ {
/*    */   public static final int radius = 4;
/*    */   private static final double radiusI = 0.25D;
/* 15 */   private Bitsmap1D map = new Bitsmap1D(0, 3, SETT.TAREA);
/*    */ 
/*    */   
/*    */   public MAP_DOUBLE cost;
/*    */ 
/*    */ 
/*    */   
/*    */   void add(Div div, DivPositionImp next) {
/* 23 */     for (int i = 0; i < next.deployed(); i++) {
/* 24 */       int x = next.tile(i).x();
/* 25 */       int y = next.tile(i).y();
/* 26 */       add(x, y, i);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private void add(int tx, int ty, int currentI) {
/* 32 */     for (int y = -3; y < 4; y++) {
/* 33 */       for (int x = -3; x < 4; x++) {
/*    */         
/* 35 */         int dx = tx + x;
/* 36 */         int dy = ty + y;
/* 37 */         if (SETT.IN_BOUNDS(dx, dy)) {
/* 38 */           int dist = 4 - Math.abs(x) + Math.abs(y);
/* 39 */           if (dist > 0) {
/* 40 */             int t = dx + dy * SETT.TWIDTH;
/* 41 */             if (this.map.get(t) < dist) {
/* 42 */               this.map.set(t, dist);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   void clear() {
/* 52 */     this.map.clear();
/*    */   }
/*    */   public DivsSpaceMap(DivStatus[] statuses) {
/* 55 */     this.cost = new MAP_DOUBLE()
/*    */       {
/*    */         public double get(int tx, int ty)
/*    */         {
/* 59 */           return get(tx + ty * SETT.TWIDTH);
/*    */         }
/*    */ 
/*    */         
/*    */         public double get(int tile) {
/* 64 */           return (32 * DivsSpaceMap.this.map.get(tile)) * 0.25D;
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\DivsSpaceMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */