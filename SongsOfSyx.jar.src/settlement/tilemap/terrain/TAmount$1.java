/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import snake2d.util.map.MAP_DOUBLEE;
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
/*    */   implements MAP_DOUBLEE
/*    */ {
/*    */   public double get(int tx, int ty) {
/* 75 */     return TAmount.this.get(tx, ty) * TAmount.this.maxI;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(int tile) {
/* 80 */     return TAmount.this.get(tile) * TAmount.this.maxI;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 85 */     TAmount.this.set(tx, ty, (int)(value * TAmount.this.max));
/* 86 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_DOUBLEE set(int tile, double value) {
/* 91 */     TAmount.this.set(tile, (int)(value * TAmount.this.max));
/* 92 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TAmount$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */