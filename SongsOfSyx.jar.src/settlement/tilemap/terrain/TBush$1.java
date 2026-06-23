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
/* 42 */   private final SoundRace sound = AUDIO.race("CLEAR_BUSH");
/*    */ 
/*    */   
/*    */   public RESOURCE clear1(int tx, int ty) {
/* 46 */     TBush.this.shared.NADA.placeFixed(tx, ty);
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean can() {
/* 52 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int clearAll(int tx, int ty) {
/* 57 */     TBush.this.shared.NADA.placeFixed(tx, ty);
/* 58 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundRace sound(int tx, int ty) {
/* 63 */     return this.sound;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEasilyCleared() {
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBush$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */