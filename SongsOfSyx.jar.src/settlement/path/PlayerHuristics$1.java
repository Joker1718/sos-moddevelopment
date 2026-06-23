/*    */ package settlement.path;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_DOUBLE;
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
/*    */   implements MAP_DOUBLE
/*    */ {
/*    */   public double get(int tx, int ty) {
/* 27 */     return get(tx + ty * SETT.TWIDTH);
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(int tile) {
/* 32 */     return PlayerHuristics.I * (PlayerHuristics.this.counts[tile] & 0xFF);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\PlayerHuristics$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */