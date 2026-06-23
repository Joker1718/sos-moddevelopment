/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import game.audio.AUDIO;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends TerrainClearing
/*    */ {
/* 35 */   private final SoundRace sound = AUDIO.race("CLEAR");
/*    */ 
/*    */   
/*    */   public RESOURCE clear1(int tx, int ty) {
/* 39 */     TFlower.this.shared.NADA.placeFixed(tx, ty);
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean can() {
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int clearAll(int tx, int ty) {
/* 50 */     TFlower.this.shared.NADA.placeFixed(tx, ty);
/* 51 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundRace sound(int tx, int ty) {
/* 56 */     return this.sound;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEasilyCleared() {
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFlower$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */