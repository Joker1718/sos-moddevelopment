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
/*    */ class null
/*    */   extends TerrainClearing
/*    */ {
/* 28 */   private final SoundRace sound = AUDIO.race("CLEAR");
/*    */ 
/*    */   
/*    */   public RESOURCE clear1(int tx, int ty) {
/* 32 */     TDecor.this.shared.NADA.placeFixed(tx, ty);
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean can() {
/* 38 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int clearAll(int tx, int ty) {
/* 43 */     TDecor.this.shared.NADA.placeFixed(tx, ty);
/* 44 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public SoundRace sound(int tx, int ty) {
/* 49 */     return this.sound;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEasilyCleared() {
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TDecor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */