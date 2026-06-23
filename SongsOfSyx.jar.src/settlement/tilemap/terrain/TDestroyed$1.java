/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import game.audio.SoundRace;
/*    */ import init.resources.RESOURCE;
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
/*    */   extends TerrainClearing
/*    */ {
/*    */   public RESOURCE clear1(int tx, int ty) {
/* 33 */     TDestroyed.this.shared.NADA.placeFixed(tx, ty);
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean can() {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int clearAll(int tx, int ty) {
/* 44 */     TDestroyed.this.shared.NADA.placeFixed(tx, ty);
/* 45 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundRace sound(int tx, int ty) {
/* 50 */     return TDestroyed.this.get(tx, ty).clearing().sound(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEasilyCleared() {
/* 55 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void destroy(int tx, int ty) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canDestroy(int tx, int ty) {
/* 66 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public double strength() {
/* 71 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TDestroyed$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */